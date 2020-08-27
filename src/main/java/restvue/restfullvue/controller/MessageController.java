package restvue.restfullvue.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restvue.restfullvue.domain.Message;
import restvue.restfullvue.domain.Views;
import restvue.restfullvue.repo.MessageRepo;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> getList() {
        return messageRepo.findAll();
    }

    @GetMapping("/{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreationTime(LocalDateTime.now());
        return messageRepo.save(message);
    }

    @PutMapping("/{id}")
    public Message update(
            @PathVariable("id") Message messageFromDB,
            @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDB, "id");

        return messageRepo.save(messageFromDB);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Message message) {
        messageRepo.delete(message);
    }
}

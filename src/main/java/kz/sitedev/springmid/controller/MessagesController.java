package kz.sitedev.springmid.controller;

import io.swagger.annotations.Api;
import kz.sitedev.springmid.entity.Message;
import kz.sitedev.springmid.repository.MessageRepository;
import kz.sitedev.springmid.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/messages")
@Api
public class MessagesController {
    @Autowired
    MessageService messageService;

    @GetMapping("{id}")
    public List<Message> getByJobCvId(@PathVariable Long id){
        return messageService.getByRespId(id);
    }

    @PostMapping("")
    public Message create(@Valid @RequestBody Message message){
        message.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return messageService.create(message);
    }
}

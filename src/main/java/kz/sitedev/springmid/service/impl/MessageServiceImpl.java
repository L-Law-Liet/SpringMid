package kz.sitedev.springmid.service.impl;
import kz.sitedev.springmid.entity.Message;
import kz.sitedev.springmid.repository.MessageRepository;
import kz.sitedev.springmid.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> all() {
        return messageRepository.findAll();
    }

    public List<Message> getByRespId(Long id){
        return messageRepository.getByJobCvId(id);
    }

    public Message create(Message message){
        return messageRepository.saveAndFlush(message);
    }
}

package com.bob.service;





import com.bob.domain.Message;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class MessageService {

    @PersistenceContext
    EntityManager entityManager;



    private static final Logger logger = Logger.getLogger(MessageService.class.getName());


    public List<Message> findAllMessages() {
        Query query = entityManager.createQuery("select m from MESSAGE m", Message.class);
        List<Message> messages = query.getResultList();
        return messages;
    }

    public List<Message> saveMessages(List<Message> messages) {
        entityManager.merge(messages);
        return messages;
    }
}

package com.bob.repo;



import com.bob.domain.Message;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

//@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class MessageRepo {


    @PersistenceContext
    EntityManager entityManager;

    public List<Message> findAllMessages() {
        String jpql = "select m from Message m";
        return entityManager
                .createQuery(jpql, Message.class)
                .getResultList();
    }
}

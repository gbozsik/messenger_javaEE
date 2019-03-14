package com.bob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@Entity
@Table(name = "MESSAGE")
public class Message extends BaseModel {


    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "CREATED")
    private Date created;

    @Column(name = "AUTHOR")
    private String author;

    public Message(String message, String author) {
        super();
        this.message = message;
        this.created = new Date();
        this.author = author;
    }


}

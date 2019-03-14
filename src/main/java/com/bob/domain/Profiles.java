package com.bob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@Entity
@Table(name = "PROFILE")
public class Profiles extends BaseModel {

    private String profilename;
    private String firstName;
    private String lastName;
    private Date created;



    public Profiles(Long id, String profilename, String firstName, String lastName) {
        super(id);
        this.profilename = profilename;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = new Date();
    }
}

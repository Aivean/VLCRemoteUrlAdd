package com.aivean.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by squirrel on 2/17/14.
 */
@Entity
@Table(name = "seasons")
public class Season {

    @Id
    private Long show_id;

    @Column
    private Integer number;

    @Column(name = "brb_link")
    private String brbLink;


    public Long getShow_id() {
        return show_id;
    }

    public void setShow_id(Long show_id) {
        this.show_id = show_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBrbLink() {
        return brbLink;
    }

    public void setBrbLink(String brbLink) {
        this.brbLink = brbLink;
    }
}

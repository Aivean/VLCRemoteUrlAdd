package com.aivean.db.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by squirrel on 2/17/14.
 */
@Entity
@Table(name = "seasons")
public class Season {

    @Id
    @Column(name = "season_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @Column
    private Integer number;

    @Column(name = "brb_link")
    private String brbLink;

    @OneToMany
    @JoinColumn
    private List<Episode> episodes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Show getShow_id() {
        return show;
    }

    public void setShow_id(Show show_id) {
        this.show = show_id;
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

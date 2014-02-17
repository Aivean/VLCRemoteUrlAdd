package com.aivean.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by squirrel on 2/17/14.
 */
@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    private Long id;

    @Column(name = "show_id")
    private Long showId;

    @Column(name = "season_number")
    private Integer seasonNumber;

    @Column
    private String title;

    @Column(name = "brb_link")
    private String brbLink;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrbLink() {
        return brbLink;
    }

    public void setBrbLink(String brbLink) {
        this.brbLink = brbLink;
    }
}

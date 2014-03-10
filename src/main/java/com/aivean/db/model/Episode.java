package com.aivean.db.model;

import javax.persistence.*;

/**
 * Created by squirrel on 2/17/14.
 */
@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "episode_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

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

    public Show getShowId() {
        return show;
    }

    public void setShowId(Show showId) {
        this.show = showId;
    }

    public Season getSeasonNumber() {
        return season;
    }

    public void setSeasonNumber(Season seasonNumber) {
        this.season = seasonNumber;
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

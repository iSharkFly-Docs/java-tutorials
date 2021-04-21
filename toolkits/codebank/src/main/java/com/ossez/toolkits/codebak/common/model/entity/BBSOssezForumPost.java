package com.ossez.toolkits.codebak.common.model.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(catalog = "ossez_bbs", name = "bbsossez_forum_post")
public class BBSOssezForumPost implements Serializable {
    private static final long serialVersionUID = 5530454436970805656L;

    private static Logger logger = LoggerFactory.getLogger(BBSOssezForumPost.class);


    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String message;

    @Column(name = "tid")
    private Long tid;

    @Column(name = "dateline")
    private Long dateline;



    /**
     * Constructor
     */
    public BBSOssezForumPost() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getDateline() {
        return dateline;
    }

    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }
}
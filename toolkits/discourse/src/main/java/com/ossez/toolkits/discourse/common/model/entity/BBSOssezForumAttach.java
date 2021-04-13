package com.ossez.toolkits.discourse.common.model.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(catalog = "ossez_bbs", name = "bbsossez_forum_attach")
public class BBSOssezForumAttach implements Serializable {
    private static final long serialVersionUID = 5530454436970805656L;

    private static Logger logger = LoggerFactory.getLogger(BBSOssezForumAttach.class);


    @Id
    @Column(name = "aid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;

    @Column(name = "attachment")
    private String attachment;



    /**
     * Constructor
     */
    public BBSOssezForumAttach() {

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


    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
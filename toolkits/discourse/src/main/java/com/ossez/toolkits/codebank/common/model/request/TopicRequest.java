package com.ossez.toolkits.codebank.common.model.request;

import java.io.Serializable;


/**
 * SearchRequest Object, UI can send search String and related pagination
 *
 * @author YuCheng Hu
 */
public class TopicRequest implements Serializable {
    private static final long serialVersionUID = 6474765081240948885L;


    private String title;
    private Integer topic_id;
    private String raw;
    private Integer category;
    private String target_recipients;
    private String archetype;
    private String created_at;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getTarget_recipients() {
        return target_recipients;
    }

    public void setTarget_recipients(String target_recipients) {
        this.target_recipients = target_recipients;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}

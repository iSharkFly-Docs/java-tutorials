package com.ossez.toolkits.codebank.common.model.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TopicRequest that = (TopicRequest) o;

        return new EqualsBuilder().append(title, that.title).append(topic_id, that.topic_id).append(raw, that.raw).append(category, that.category).append(target_recipients, that.target_recipients).append(archetype, that.archetype).append(created_at, that.created_at).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(title).append(topic_id).append(raw).append(category).append(target_recipients).append(archetype).append(created_at).toHashCode();
    }
}

package com.ossez.toolkits.codebak.common.model.response;

import java.io.Serializable;
import java.util.Date;

/**
 * SearchResponse from Remote Source
 *
 * @author YuCheng Hu
 */
public class SearchResponse implements Serializable {
    private static final long serialVersionUID = -2014480627591149391L;


    private String uuid;
    private Date currentDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}

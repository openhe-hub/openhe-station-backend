package com.openhe.backend.bean.note;

import lombok.Data;

import java.util.Date;

@Data
public class Note {
    private Integer id;
    private String name;
    private String tags;
    private Date date;
    private String path;
    private Integer groupId;
}

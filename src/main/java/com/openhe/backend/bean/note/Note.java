package com.openhe.backend.bean.note;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class Note {
    private Integer id;
    private String name;
    private String tags;
    private Date date;
    private String path;
    private Integer groupId;
    private MultipartFile file;
}

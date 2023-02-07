package com.openhe.backend.bean.note;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class Passage {
    private String name;
    private String tags;
    private Date date;
    private String path;
    private String parentPath;
    private MultipartFile file;
}

package com.openhe.backend.bean.note;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class Note {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String tags;
    private Date date;
    private String path;
    private Integer groupId;
}

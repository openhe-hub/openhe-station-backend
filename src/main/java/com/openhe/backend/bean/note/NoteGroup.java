package com.openhe.backend.bean.note;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteGroup {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String path;
    private ArrayList<Note> notes;
}

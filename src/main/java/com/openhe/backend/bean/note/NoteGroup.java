package com.openhe.backend.bean.note;

import lombok.Data;

@Data
public class NoteGroup {
    private Integer id;
    private String name;
    private String path;
    private Note[] notes;
}

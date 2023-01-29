package com.openhe.backend.bean.note;

import lombok.Data;

import java.util.ArrayList;

@Data
public class NoteGroup {
    private Integer id;
    private String name;
    private String path;
    private ArrayList<Note> notes;
}

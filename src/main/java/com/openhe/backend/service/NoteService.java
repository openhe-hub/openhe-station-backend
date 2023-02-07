package com.openhe.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.openhe.backend.bean.note.Note;
import com.openhe.backend.bean.note.NoteGroup;
import com.openhe.backend.bean.note.Passage;

public interface NoteService extends IService<Note> {
    boolean newNote(Passage passage);
}

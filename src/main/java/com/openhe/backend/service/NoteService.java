package com.openhe.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.openhe.backend.bean.note.Note;
import com.openhe.backend.bean.note.NoteGroup;

public interface NoteService extends IService<Note> {
    NoteGroup[] loadStructure();
    String loadPassage(int groupId,int passageId);
}

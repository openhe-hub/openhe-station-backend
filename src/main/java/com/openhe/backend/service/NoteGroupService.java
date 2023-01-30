package com.openhe.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openhe.backend.bean.note.Note;
import com.openhe.backend.bean.note.NoteGroup;

import java.util.List;

public interface NoteGroupService extends IService<NoteGroup> {
    List<NoteGroup> loadStructure();

    String loadPassage(int groupIdx, int passageIdx);

    Note getNoteInfo(int groupIdx, int passageIdx);
}

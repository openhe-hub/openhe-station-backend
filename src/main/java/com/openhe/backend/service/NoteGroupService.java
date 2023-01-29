package com.openhe.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openhe.backend.bean.note.NoteGroup;

public interface NoteGroupService extends IService<NoteGroup> {
    NoteGroup[] loadStructure();
    String loadPassage(int groupId,int passageId);
}

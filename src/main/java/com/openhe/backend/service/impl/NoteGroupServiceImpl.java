package com.openhe.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openhe.backend.bean.note.NoteGroup;
import com.openhe.backend.mapper.NoteGroupMapper;
import com.openhe.backend.service.NoteGroupService;
import org.springframework.stereotype.Service;

@Service
public class NoteGroupServiceImpl extends ServiceImpl<NoteGroupMapper, NoteGroup>
        implements NoteGroupService {

    @Override
    public NoteGroup[] loadStructure() {
        return new NoteGroup[0];
    }

    @Override
    public String loadPassage(int groupId, int passageId) {
        return null;
    }
}

package com.openhe.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openhe.backend.bean.note.Note;
import com.openhe.backend.bean.note.NoteGroup;
import com.openhe.backend.bean.note.Passage;
import com.openhe.backend.mapper.NoteMapper;
import com.openhe.backend.service.NoteGroupService;
import com.openhe.backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note>
        implements NoteService {
    @Autowired
    NoteGroupService noteGroupService;
    @Autowired
    NoteMapper noteMapper;

    @Override
    public boolean newNote(Passage passage) {
        System.out.println(passage.toString());
        if (!StringUtils.hasLength(passage.getName())) {
            return false;
        }
        // insert into database
        Note note=new Note();
        note.setName(passage.getName());
        note.setTags(passage.getTags());
        note.setDate(passage.getDate());
        note.setPath("/"+passage.getPath());
        note.setGroupId(noteGroupService.getGroupId(passage.getParentPath()));
        System.out.println(note.toString());
        int ret = noteMapper.insert(note);
        System.out.println(ret);
        // save local .md file
        try {
            String path = ResourceUtils.getURL("classpath:").getPath()
                    + "note" + passage.getParentPath()
                    +  note.getPath() + ".md";
            System.out.println(path);
            System.out.println(passage.getFile().getSize());
            passage.getFile().transferTo(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


}

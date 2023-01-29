package com.openhe.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openhe.backend.bean.note.NoteGroup;
import com.openhe.backend.mapper.NoteGroupMapper;
import com.openhe.backend.mapper.NoteMapper;
import com.openhe.backend.service.NoteGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Service
@Slf4j
public class NoteGroupServiceImpl extends ServiceImpl<NoteGroupMapper, NoteGroup>
        implements NoteGroupService {
    @Autowired
    NoteGroupMapper noteGroupMapper;

    List<NoteGroup> noteGroups;

    @Override
    public List<NoteGroup> loadStructure() {
        noteGroups = noteGroupMapper.selectAll();
        return noteGroups;
    }

    @Override
    public String loadPassage(int groupIdx, int passageIdx) {
        NoteGroup group = noteGroups.get(groupIdx);
        String path = "note";
        StringBuilder content = new StringBuilder();
        // concat path
        path += group.getPath();
        path += group.getNotes().get(passageIdx).getPath();
        path += ".md";
        log.info("reading note content from: " + path);
        // read *.md note
        ClassPathResource classPathResource = new ClassPathResource(path);
        try {
            InputStream inputStream = classPathResource.getInputStream();
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(buf)) != -1) {
                content.append(new String(buf, 0, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info(content.toString());
        return content.toString();
    }
}

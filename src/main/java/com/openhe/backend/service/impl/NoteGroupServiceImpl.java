package com.openhe.backend.service.impl;

import ch.qos.logback.core.util.FileUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openhe.backend.bean.note.Folder;
import com.openhe.backend.bean.note.Note;
import com.openhe.backend.bean.note.NoteGroup;
import com.openhe.backend.mapper.NoteGroupMapper;
import com.openhe.backend.mapper.NoteMapper;
import com.openhe.backend.service.NoteGroupService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@Slf4j
public class NoteGroupServiceImpl extends ServiceImpl<NoteGroupMapper, NoteGroup>
        implements NoteGroupService {
    @Autowired
    NoteGroupMapper noteGroupMapper;

    List<NoteGroup> noteGroups;

    private boolean isLoaded = false;

    @Override
    public List<NoteGroup> loadStructure() {
        noteGroups = noteGroupMapper.selectAll();
        isLoaded = true;
        return noteGroups;
    }

    @Override
    public String loadPassage(int groupIdx, int passageIdx) {
        if (!isLoaded) {
            loadStructure();
        }
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

        return content.toString();
    }

    @Override
    public Note getNoteInfo(int groupIdx, int passageIdx) {
        if (!isLoaded) {
            loadStructure();
        }
        return noteGroups.get(groupIdx).getNotes().get(passageIdx);
    }

    @Override
    public boolean newFolder(Folder folder) {
        if (!StringUtils.hasLength(folder.getName())) {
            return false;
        }
        // insert into database
        NoteGroup noteGroup = new NoteGroup();
        noteGroup.setName(folder.getName());
        noteGroup.setPath("/" + folder.getName());
        int ret = noteGroupMapper.insert(noteGroup);
        System.out.println(ret);
        // make new local folder
        try {
            String path = ResourceUtils.getURL("classpath:").getPath()
                    + "note" + noteGroup.getPath();
            System.out.println(path);
            FileUtils.forceMkdir(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public int getGroupId(String groupPath) {
        if (!isLoaded) loadStructure();
        for (NoteGroup noteGroup : noteGroups) {
            if (noteGroup.getPath().equals(groupPath)) {
                return noteGroup.getId();
            }
        }
        return -1;
    }

    @Override
    public String getGroupPath(String groupPath) {
        if (!isLoaded) loadStructure();
        for (NoteGroup noteGroup : noteGroups) {
            if (noteGroup.getPath().equals(groupPath)) {
                return noteGroup.getPath();
            }
        }
        return "";
    }
}

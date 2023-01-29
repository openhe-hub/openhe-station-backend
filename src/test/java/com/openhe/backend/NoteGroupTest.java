package com.openhe.backend;

import com.openhe.backend.mapper.NoteGroupMapper;
import com.openhe.backend.service.NoteGroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoteGroupTest {
    @Autowired
    NoteGroupMapper noteGroupMapper;

    @Autowired
    NoteGroupService noteGroupService;

    @Test
    public void testSelectAll() {
        noteGroupMapper.selectAll()
                .forEach(System.out::println);
    }

    @Test
    public void testLoadPassage() {
        noteGroupService.loadStructure();
        String content = noteGroupService.loadPassage(0, 0);
    }
}

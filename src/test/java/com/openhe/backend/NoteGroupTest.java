package com.openhe.backend;

import com.openhe.backend.mapper.NoteGroupMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoteGroupTest {
    @Autowired
    NoteGroupMapper noteGroupMapper;

    @Test
    public void testSelectAll() {
        noteGroupMapper.selectAll()
                .forEach(System.out::println);
    }
}

package com.openhe.backend.controller;

import com.openhe.backend.bean.note.NoteGroup;
import com.openhe.backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/structure")
    public NoteGroup[] getStructure() {
        return noteService.loadStructure();
    }

    @PostMapping("/passage")
    public String postPassage(@RequestBody Integer groupId,
                              @RequestBody Integer passageId) {
        return noteService.loadPassage(groupId, passageId);
    }
}

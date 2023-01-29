package com.openhe.backend.controller;

import com.openhe.backend.bean.note.NoteGroup;
import com.openhe.backend.bean.note.NoteQuery;
import com.openhe.backend.service.NoteGroupService;
import com.openhe.backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteGroupService noteGroupService;

    @GetMapping("/structure")
    public List<NoteGroup> getStructure() {
        return noteGroupService.loadStructure();
    }

    @PostMapping("/passage")
    public String postPassage(@RequestBody NoteQuery noteQuery) {
        return noteGroupService.loadPassage(noteQuery.getGroupIdx(),
                noteQuery.getPassageIdx());
    }
}

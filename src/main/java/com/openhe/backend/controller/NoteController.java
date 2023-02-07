package com.openhe.backend.controller;

import com.openhe.backend.bean.note.*;
import com.openhe.backend.bean.status.CreateStatus;
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
    @Autowired
    private NoteService noteService;

    @GetMapping("/structure")
    public List<NoteGroup> getStructure() {
        return noteGroupService.loadStructure();
    }

    @PostMapping("/passage")
    public String postPassage(@RequestBody NoteQuery noteQuery) {
        return noteGroupService.loadPassage(noteQuery.getGroupIdx(),
                noteQuery.getPassageIdx());
    }

    @GetMapping("/folder")
    public List<String> getFolders(){
        return noteGroupService.getFolders();
    }

    @PostMapping("/info")
    public Note getNoteInfo(@RequestBody NoteQuery noteQuery) {
        return noteGroupService.getNoteInfo(noteQuery.getGroupIdx(),
                noteQuery.getPassageIdx());
    }

    @PostMapping("/new_note")
    public CreateStatus createNewNote(Passage passage) {
        return new CreateStatus("note", noteService.newNote(passage));
    }

    @PostMapping("/new_folder")
    public CreateStatus createNewFolder(@RequestBody Folder folder) {
        return new CreateStatus("folder", noteGroupService.newFolder(folder));
    }
}

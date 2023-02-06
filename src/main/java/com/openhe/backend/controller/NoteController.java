package com.openhe.backend.controller;

import com.openhe.backend.bean.note.Folder;
import com.openhe.backend.bean.note.Note;
import com.openhe.backend.bean.note.NoteGroup;
import com.openhe.backend.bean.note.NoteQuery;
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

    @PostMapping("/info")
    public Note getNoteInfo(@RequestBody NoteQuery noteQuery) {
        return noteGroupService.getNoteInfo(noteQuery.getGroupIdx(),
                noteQuery.getPassageIdx());
    }

    @PostMapping("/new_note")
    public CreateStatus createNewNote(Note note) {
        System.out.println(note.toString());
        System.out.println(note.getFile().getSize());
        return new CreateStatus("note", noteService.isNewNoteValid(note));
    }

    @PostMapping("/new_folder")
    public CreateStatus createNewFolder(@RequestBody Folder folder) {
        System.out.println(folder.toString());
        return new CreateStatus("folder", noteGroupService.isNewFolderValid(folder));
    }
}

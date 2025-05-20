package com.Dtest.backend.controller;

import com.Dtest.backend.dto.NoteDTO;
import com.Dtest.backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNote(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDTO> updateNote(@PathVariable Long id, @RequestBody NoteDTO dto) {
        try {
            NoteDTO updated = noteService.updateNote(id, dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<NoteDTO> createNote(@RequestBody NoteDTO dto) {
        NoteDTO created = noteService.createNote(dto);
        return ResponseEntity.ok(created);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
}

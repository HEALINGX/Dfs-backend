package com.Dtest.backend.service;

import com.Dtest.backend.dto.NoteDTO;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.model.Note;
import com.Dtest.backend.repository.DoctorDetailsDescRepo;
import com.Dtest.backend.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepo noteRepository;

    @Autowired
    private DoctorDetailsDescRepo doctorDetailsDescRepo;

    // แปลง Entity → DTO
    private NoteDTO entityToDto(Note entity) {
        NoteDTO dto = new NoteDTO();
        dto.setUserId(entity.getUserId());
        dto.setNoteSubject(entity.getNoteSubject());
        dto.setNoteContent(entity.getNoteContent());
        dto.setHbnCode(entity.getHbnCode());
        dto.setActive(entity.isActive());
        dto.setUpdateDate(entity.getUpdateDate());
        dto.setUpdateTime(entity.getUpdateTime());

        if (entity.getDoctorDetailsDesc() != null) {
            dto.setDoctorCode(entity.getDoctorDetailsDesc().getDoctorCode());
        }

        return dto;
    }

    // แปลง DTO → Entity
    private void updateEntityFromDto(Note entity, NoteDTO dto) {
        entity.setUserId(dto.getUserId());
        entity.setNoteSubject(dto.getNoteSubject());
        entity.setNoteContent(dto.getNoteContent());
        entity.setHbnCode(dto.getHbnCode());
        entity.setActive(dto.isActive());
        entity.setUpdateDate(dto.getUpdateDate());
        entity.setUpdateTime(dto.getUpdateTime());

        if (dto.getDoctorCode() != null) {
            DoctorDetailsDesc doctorDetailsDesc = new DoctorDetailsDesc();
            doctorDetailsDesc.setDoctorCode(dto.getDoctorCode());
            entity.setDoctorDetailsDesc(doctorDetailsDesc);
        }
    }

    public Optional<NoteDTO> getNoteById(Long id) {
        return noteRepository.findById(id).map(this::entityToDto);
    }

    public NoteDTO createNote(NoteDTO dto) {
        Note note = new Note();
        updateEntityFromDto(note, dto);

        DoctorDetailsDesc doctorDetailsDesc = doctorDetailsDescRepo.findById(dto.getDoctorCode())
                .orElseThrow(() -> new RuntimeException("DoctorDetailsDesc not found"));
        note.setDoctorDetailsDesc(doctorDetailsDesc);

        Note saved = noteRepository.save(note);
        return entityToDto(saved);
    }

    public NoteDTO updateNote(Long id, NoteDTO dto) {
        Note existing = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        updateEntityFromDto(existing, dto);

        DoctorDetailsDesc doctorDetailsDesc = doctorDetailsDescRepo.findById(dto.getDoctorCode())
                .orElseThrow(() -> new RuntimeException("DoctorDetailsDesc not found"));
        existing.setDoctorDetailsDesc(doctorDetailsDesc);

        Note saved = noteRepository.save(existing);
        return entityToDto(saved);
    }

    public void deleteNoteById(Long id) {

        noteRepository.deleteById(id);
    }
}

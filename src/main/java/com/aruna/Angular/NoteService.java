package com.aruna.Angular;

import java.util.List;
import com.aruna.Angular.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noteService")
public class NoteService implements NoteServiceInterface {

	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<Note> getAll() {
		return noteRepository.findAll();
	}

	@Override
	public Note save(Note nt) {
		return noteRepository.save(nt);

	}

	@Override
	public void delete(Long id) {
		noteRepository.delete(id);
	}

	@Override
	public Note find(Long id) {
		return noteRepository.findOne(id);
	}
@Override
	public Note update(Note nt,Long id) {
		nt.setId(id);
	return noteRepository.saveAndFlush(nt);
	}
}
	
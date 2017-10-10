package com.aruna.Angular;

import com.aruna.Angular.*;
import java.util.*;

public interface NoteServiceInterface {

	public List<Note> getAll();

	public Note save(Note nt);

	public Note find(Long id);

	public void delete(Long id);

   public Note update(Note nt,Long id);

}

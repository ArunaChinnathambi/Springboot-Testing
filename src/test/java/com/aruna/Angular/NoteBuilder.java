package com.aruna.Angular;
import com.aruna.Angular.*;

public class NoteBuilder {
  private Note note = new Note();
  
  public NoteBuilder id(Long id) {
	 note.setId(id);
    return this;
  }
  
  public NoteBuilder date(String date) {
	note.setDate(date);
    return this;
  }

   public NoteBuilder notes(String notes) {
	note.setNotes(notes);
    return this;
  }   
  
   public Note build() {
    return note;
  }
}
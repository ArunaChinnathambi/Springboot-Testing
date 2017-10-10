package com.aruna.Angular;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import com.aruna.Angular.*;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class NoteServiceUnitTest
{
@InjectMocks
private NoteService noteService;

@Mock
private NoteRepository noteRepository;

Note note = new Note();

@Test
public void getTest() 
{
    List<Note> note = new ArrayList<Note>();
note.add(new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build());
note.add(new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build());


when(noteRepository.findAll()).thenReturn(note);
List<Note> result = noteService.getAll();
assertEquals(2, result.size());
}

@Test
public void findTest()
{
    Note note1=new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build();
when(noteRepository.findOne(1L)).thenReturn(note1);
Note result = noteService.find(1L);
assertEquals(1L, 1L);
}

@Test
public void saveTest()
{
    Note note1=new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build();
when(noteRepository.save(note)).thenReturn(note1);
Note result = noteService.save(note);
assertEquals(1L,1L);
}

@Test
public void deleteTest()
{
Note note1=new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build();
noteService.delete(1L);
verify(noteRepository, times(1)).delete(1L);
}
@Test
public void updateTest()
{
    Note note1=new NoteBuilder().id(1L).date("13.09.2017").notes("Hai").build();
    when(noteRepository.saveAndFlush(note1)).thenReturn(note1);
Note result = noteService.update(note1,1L);
assertEquals(1L,1L);


}

}
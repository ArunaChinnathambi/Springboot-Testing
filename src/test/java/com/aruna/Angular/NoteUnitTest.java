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

public class NoteUnitTest
{
@InjectMocks
private NoteController notecontroller;

@Mock
private NoteService noteService;

Note note = new Note();

@Test
public void getTest() 
{
    List<Note> note = new ArrayList<Note>();
note.add(new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build());
note.add(new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build());


when(noteService.getAll()).thenReturn(note);
List<Note> result = notecontroller.getAll();
assertEquals(2, result.size());
}

@Test
public void findTest()
{
    Note note1=new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build();
when(noteService.find(1L)).thenReturn(note1);
Note result = notecontroller.find(1L);
assertEquals(1L, 1L);
}

@Test
public void saveTest()
{
    Note note1=new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build();
when(noteService.save(note)).thenReturn(note1);
Note result = notecontroller.save(note);
assertEquals(1L,1L);
}

@Test
public void deleteTest()
{
Note note1=new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build();
notecontroller.delete(1L);
verify(noteService, times(1)).delete(1L);
}
@Test
public void updateTest()
{
    Note note1=new NoteBuilder().id(1L).date("13.09.2017").notes("Hai").build();
    when(noteService.update(note1,1L)).thenReturn(note1);
Note result = notecontroller.update(note1,1L);
assertEquals(1L,1L);


}

@Test
public void sizeTest()
{
    Note e1=new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build();
    Note e2=new NoteBuilder().id(1L).date("13.09.2017").notes("Welcome").build();
List<Note> notelist=new ArrayList<Note>();
notelist.add(e1);
notelist.add(e2);
    when(noteService.getAll()).thenReturn(notelist);
    List<Note> result = notecontroller.getAll();
    assertEquals(2, result.size());

for (Iterator<Note> i = result.iterator(); i.hasNext();) {
     Note e3 = i.next();
        System.out.println(" Id"+e3.getId());
        System.out.println(" Date" +" "+e3. getDate());
        System.out.println(" Notes"+ " "+e3.getNotes());
       }
    }
}
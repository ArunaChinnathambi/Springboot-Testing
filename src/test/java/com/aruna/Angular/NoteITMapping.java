package com.aruna.Angular;

import com.aruna.Angular.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(value = NoteController.class, secure = false)
public class NoteITMapping {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    @Test
    public void getByID() throws Exception {

        Note crntnote = new Note();
        crntnote.setId(1L);
        crntnote.setDate("13.09.2017");
        crntnote.setNotes("Welcome");

        given(noteService.find(1L)).willReturn(crntnote);
        mockMvc.perform(get("/Note/get/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
               .andExpect(content().json("{'date': '13.09.2017','notes': 'Welcome','id': 1}"));
    }

@Test
    public void getAll() throws Exception {

        Note crntnote = new Note();
        crntnote.setId(1L);
        crntnote.setDate("13.09.2017");
        crntnote.setNotes("Welcome");

        List<Note> alist1 = new ArrayList<Note>();
        alist1.add(crntnote);
        given(noteService.getAll()).willReturn(alist1);
        mockMvc.perform(get("/Note/get").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().json("[{'date': '13.09.2017','notes': 'Welcome','id': 1}]"));

    }

    @Test
    public void save() throws Exception {

        Note crntnote = new Note();
        crntnote.setId(1L);
        crntnote.setDate("13.09.2017");
        crntnote.setNotes("Welcome");

        when(noteService.find(crntnote.getId())).thenReturn(crntnote);
        mockMvc.perform(post("/Note/save").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(crntnote))).andExpect(status().isOk());

        }

        @Test
    public void updateByID() throws Exception {

        Note crntnote = new Note();
        crntnote.setId(1L);
        crntnote.setDate("13.09.2017");
        crntnote.setNotes("Welcome");

        when(noteService.find(crntnote.getId())).thenReturn(crntnote);

        mockMvc.perform(put("/Note/update/1", crntnote.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(crntnote))).andExpect(status().isOk());

    }

@Test
    public void deleteByID() throws Exception {

        Note crntnote = new Note();
        crntnote.setId(1L);
        crntnote.setDate("13.09.2017");
        crntnote.setNotes("Welcome");

        when(noteService.find(crntnote.getId())).thenReturn(crntnote);

        mockMvc.perform(delete("/Note/delete/1", crntnote.getId())).andExpect(status().isOk());

        verify(noteService, times(1)).delete(crntnote.getId());
        verifyNoMoreInteractions(noteService);
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
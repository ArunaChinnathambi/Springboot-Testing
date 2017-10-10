package com.aruna.Angular;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import static com.jayway.restassured.RestAssured.when;
import org.springframework.test.context.junit4.SpringRunner;


import com.jayway.restassured.RestAssured;

import com.jayway.restassured.http.ContentType;
import java.util.*;
import com.aruna.Angular.Note;

import com.aruna.Angular.NoteRepository;

@RunWith(SpringRunner.class)

@SpringBootTest(classes=AngularApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
locations = "classpath:application.properties")

public class NoteITRandomPort {

       
private static final String NAME_FIELD = "eFullDte";
private static final String  NOTESS_RESOURCE = "Note/get";
private static final String NOTE_RESOURCE = "Note/get/{id}";
private static final String fulldate="13.09.2017";
   
private static final Long NOTE_ID = 1L;
private static final Note FIRST_NOTE = new NoteBuilder().id(NOTE_ID).date("13.09.2017").notes("Welcome").build();
private static final Note SECOND_NOTE = new NoteBuilder().id(2L).date("13.09.2017").notes("Welcome").build();
private static final Note THIRD_NOTE = new NoteBuilder().id(3L).date("13.09.2017").notes("Welcome").build();

@Autowired
    private NoteRepository noteRepository;


 @Value("${local.server.port}")
    private int serverPort;
    private Note firstNote;
    private Note secondNote;

 @Before
    public void setUp() {
        noteRepository.deleteAll();
        firstNote = noteRepository.saveAndFlush(FIRST_NOTE);
        secondNote = noteRepository.saveAndFlush(SECOND_NOTE);
        RestAssured.port = serverPort;
    }

@Test
    //SAVE
    public void addItemShouldReturnSavedItem() {
        given().body(THIRD_NOTE).contentType(ContentType.JSON).when().post(NOTESS_RESOURCE).then()
                .statusCode(HttpStatus.SC_OK).body(NAME_FIELD, is(fulldate));
        System.out.println("**************addItemShouldReturnSavedItem completed !!!******************");
    }

    @Test
    //GET ALL EVENTS
    public void getItemsShouldReturnBothItems() {
        when().get(NOTESS_RESOURCE).then().statusCode(HttpStatus.SC_OK).body(NAME_FIELD,
                hasItems(fulldate, fulldate));
    }

    @Test
    //DELETE
    public void deleteItemShouldReturnNoContent() {
        when().delete(NOTE_RESOURCE, secondNote.getId()).then().statusCode(HttpStatus.SC_OK);
    }
}

package com.aruna.Angular;

import com.aruna.Angular.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("noteRepository")
public interface NoteRepository extends JpaRepository< Note ,Long > {

}

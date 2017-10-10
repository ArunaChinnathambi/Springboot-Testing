package com.aruna.Angular;

import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    public Long id;
  
    public String date;
  
    public String notes;
   
   
public void setId(Long id)
{
    this.id=id;
}

public Long getId()
{
    return id;
}

public void setDate(String date)
{
    this.date=date;
}

public String getDate()
{
    return date;
}

public void setNotes(String notes)
{
    this.notes=notes;
}

public String getNotes()
{
    return notes;
}

}
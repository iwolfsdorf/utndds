package ar.org.utn.ddstp0.ws.dto;

import java.util.ArrayList;

public class Assignment {

  private String title;
  private String description;
  private ArrayList<Grade> grades;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ArrayList<Grade> getGrades() {
    return grades;
  }

  public void setGrades(ArrayList<Grade> grades) {
    this.grades = grades;
  }
}

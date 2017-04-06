package ar.org.utn.ddstp0.ws.dto;

import java.util.List;

import org.uqbar.commons.utils.Observable;
@Observable
public class Assignment {

  private int id;
  private String title;
  private String description;
  private List<Grade> grades;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

  public List<Grade> getGrades() {
    return grades;
  }

  public void setGrades(List<Grade> grades) {
    this.grades = grades;
  }
}

package ar.org.utn.ddstp0.ws.dto;

import org.uqbar.commons.utils.Observable;

import java.util.List;

@Observable
public class Materias {

  private List<Assignment> assignments;

  public List<Assignment> getAssignments() {
    return assignments;
  }

  public void setAssignments(List<Assignment> assignments) {
    this.assignments = assignments;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < this.assignments.size(); i++) {
      if (i != 0)
        stringBuilder.append("\nMaterias:");

      stringBuilder.append("Titulo : " + this.assignments.get(i).getTitle() + '\n');
      stringBuilder.append("Descripcion : " + this.assignments.get(i).getDescription() + '\n');
      for (int j = 0; j < this.assignments.get(i).getGrades().size(); j++) {
        stringBuilder
            .append("Nota : " + this.assignments.get(i).getGrades().get(j).getValue() + '\n');
        stringBuilder.append("Fecha creacion : "
            + this.assignments.get(i).getGrades().get(j).getCreated_at() + '\n');
        stringBuilder.append("Fecha Actualizacion : "
            + this.assignments.get(i).getGrades().get(j).getUpdated_at() + '\n');
      }
    }

    return stringBuilder.toString();
  }

}

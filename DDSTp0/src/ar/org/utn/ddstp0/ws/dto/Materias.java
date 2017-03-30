package ar.org.utn.ddstp0.ws.dto;

public class Materias {

  private Assignment[] assignments;

  public Assignment[] getAssignments() {
    return assignments;
  }

  public void setAssignments(Assignment[] assignments) {
    this.assignments = assignments;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < this.assignments.length; i++) {
      if (i != 0)
        stringBuilder.append("\nMaterias:");

      stringBuilder.append("Titulo : " + this.assignments[i].getTitle() + '\n');
      stringBuilder.append("Descripcion : " + this.assignments[i].getDescription() + '\n');
      for (int j = 0; j < this.assignments[i].getGrades().length; j++) {
        stringBuilder.append("Nota : " + this.assignments[i].getGrades()[j].getValue() + '\n');
        stringBuilder.append(
            "Fecha creacion : " + this.assignments[i].getGrades()[j].getCreated_at() + '\n');
        stringBuilder.append(
            "Fecha Actualizacion : " + this.assignments[i].getGrades()[j].getUpdated_at() + '\n');
      }
    }

    return stringBuilder.toString();
  }

}

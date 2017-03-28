package ar.org.utn.ddstp0.ws.service.impl;

import java.util.ArrayList;

import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Materia;
import ar.org.utn.ddstp0.ws.service.AlumnoRestWSClient;

public class AlumnoRestWSClientImpl implements AlumnoRestWSClient {

  @Override
  public void actualizarDatos(Alumno alumno) {
    // TODO: Se hace llamado al WS (PUT http://notitas.herokuapp.com/student)

  }

  @Override
  public Alumno consultaDatos(String token) {
    // TODO: Se hace llamado al WS (GET http://notitas.herokuapp.com/student)
    return null;
  }

  @Override
  public ArrayList<Materia> consultaMaterias(String token) {
    // TODO: Se hace llamado al WS (GET http://notitas.herokuapp.com/student/assignments)
    return null;
  }



}

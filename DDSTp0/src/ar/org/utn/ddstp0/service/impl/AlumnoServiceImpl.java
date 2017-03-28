package ar.org.utn.ddstp0.service.impl;

import java.util.ArrayList;

import ar.org.utn.ddstp0.service.AlumnoService;
import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Assignment;

public class AlumnoServiceImpl implements AlumnoService {

  @Override
  public void actualizarDatos(Alumno alumno) {
    // TODO: Se llama a AlumnoRestWSClientImpl.actualizarDatos(alumno)

  }


  @Override
  public Alumno consultaDatos(String token) {
    // TODO: Se llama a AlumnoRestWSClientImpl.consultaDatos(token) y se devuelve este valor
    return null;
  }

  @Override
  public ArrayList<Assignment> consultaMaterias(String token) {
    // TODO: Se llama a AlumnoRestWSClientImpl.consultaMaterias(token) y se devuelve este valor
    return null;
  }

}

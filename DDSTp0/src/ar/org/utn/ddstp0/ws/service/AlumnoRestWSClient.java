package ar.org.utn.ddstp0.ws.service;

import java.util.ArrayList;

import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Assignment;

public interface AlumnoRestWSClient {

  public void actualizarDatos(Alumno alumno);

  public Alumno consultaDatos(String token);

  public ArrayList<Assignment> consultaMaterias(String token);

}

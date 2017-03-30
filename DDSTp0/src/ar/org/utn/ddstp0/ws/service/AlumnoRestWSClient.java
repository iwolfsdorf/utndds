package ar.org.utn.ddstp0.ws.service;

import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Materias;

public interface AlumnoRestWSClient {

  public int actualizarDatos(String token, Alumno alumno);

  public Alumno consultaDatos(String token);

  public Materias consultaMaterias(String token);

}

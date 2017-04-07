package ar.org.utn.ddstp0.service;

import java.util.List;

import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Assignment;

public interface AlumnoService {

  public String actualizarDatos();

  public Alumno consultaDatos();

  public List<Assignment> consultaMaterias();

}

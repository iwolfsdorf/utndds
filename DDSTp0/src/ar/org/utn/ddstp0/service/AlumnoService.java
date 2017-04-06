package ar.org.utn.ddstp0.service;

import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Materias;

public interface AlumnoService {

  public String actualizarDatos();

  public Alumno consultaDatos();

  public Materias consultaMaterias();

}

package ar.org.utn.ddstp0.service;

import java.util.ArrayList;

import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Materia;

public interface AlumnoService {

  public void actualizarDatos(Alumno alumno);

  public Alumno consultaDatos(String token);

  public ArrayList<Materia> consultaMaterias(String token);

}

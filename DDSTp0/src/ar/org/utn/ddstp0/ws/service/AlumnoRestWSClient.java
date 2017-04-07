package ar.org.utn.ddstp0.ws.service;

import ar.org.utn.ddstp0.exception.ServiceException;
import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Materias;

public interface AlumnoRestWSClient {

  public int actualizarDatos(String token, Alumno alumno) throws ServiceException;

  public Alumno consultaDatos(String token) throws ServiceException;

  public Materias consultaMaterias(String token) throws ServiceException;

}

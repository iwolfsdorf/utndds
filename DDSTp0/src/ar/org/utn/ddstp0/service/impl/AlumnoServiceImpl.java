package ar.org.utn.ddstp0.service.impl;

import org.apache.commons.lang.StringUtils;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

import java.util.List;

import ar.org.utn.ddstp0.exception.ServiceException;
import ar.org.utn.ddstp0.service.AlumnoService;
import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Assignment;
import ar.org.utn.ddstp0.ws.service.impl.AlumnoRestWSClientImpl;

@Observable
public class AlumnoServiceImpl implements AlumnoService {

  private String token;
  private Alumno resultadoAlumno;
  private String github_user;
  private String resultadoActualizacion;
  private List<Assignment> resultadosMaterias;
  private String error;

  public String actualizarDatos() {
    error = "";

    if (StringUtils.isEmpty(this.github_user)) {
      error = "Debe agregar un usuario de GitHub";
      return null;
    }

    Alumno alumno;
    try {
      alumno = getWSService().consultaDatos(this.token);
      alumno.setGithub_user(this.github_user);
      int estado = getWSService().actualizarDatos(this.token, alumno);
      if (estado == 201)
        resultadoActualizacion = "Actualizacion correcta.";
      else
        error = "Hubo un problema al actualizar.";
    } catch (ServiceException e) {
      error = e.getMessage();
    }

    return resultadoActualizacion;
  }

  public Alumno consultaDatos() {
    error = "";
    // Se llama a AlumnoRestWSClientImpl.consultaDatos(token)
    try {
      resultadoAlumno = getWSService().consultaDatos(this.token);
      return resultadoAlumno;
    } catch (ServiceException e) {
      error = e.getMessage();
      return null;
    }
  }

  public List<Assignment> consultaMaterias() {
    error = "";
    try {
      resultadosMaterias = getWSService().consultaMaterias(this.token).getAssignments();
      return resultadosMaterias;
    } catch (ServiceException e) {
      error = e.getMessage();
      return null;
    }

  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Alumno getResultadoAlumno() {
    return resultadoAlumno;
  }

  public void setResultadoAlumno(Alumno resultadoAlumno) {
    this.resultadoAlumno = resultadoAlumno;
  }

  public List<Assignment> getResultadosMaterias() {
    return resultadosMaterias;
  }

  public void setResultadosMaterias(List<Assignment> resultadosMaterias) {
    this.resultadosMaterias = resultadosMaterias;
  }

  public String getGithub_user() {
    return github_user;
  }

  public void setGithub_user(String github_user) {
    this.github_user = github_user;
  }

  public String getResultadoActualizacion() {
    return resultadoActualizacion;
  }

  public void setResultadoActualizacion(String resultadoActualizacion) {
    this.resultadoActualizacion = resultadoActualizacion;
  }

  public AlumnoRestWSClientImpl getWSService() {
    return ApplicationContext.getInstance().getSingleton(AlumnoRestWSClientImpl.class);
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}

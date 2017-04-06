package ar.org.utn.ddstp0.service.impl;

import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;
import ar.org.utn.ddstp0.service.AlumnoService;
import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Materias;
import ar.org.utn.ddstp0.ws.service.impl.AlumnoRestWSClientImpl;

@Observable
public class AlumnoServiceImpl implements AlumnoService {

  private String token;
  private Alumno resultadoAlumno;
  private Materias resultadoMaterias;
  private String github_user;
  private String resultadoActualizacion;

  public String actualizarDatos() {
    Alumno alumno = getWSService().consultaDatos(this.token);
    alumno.setGithub_user(this.github_user);
    int estado = getWSService().actualizarDatos(this.token, alumno);

    if (estado == 201)
      resultadoActualizacion = "Actualizacion correcta.";
    else
      resultadoActualizacion = "Hubo un problema al actualizar.";

    return resultadoActualizacion;
  }

  public Alumno consultaDatos() {
    // Se llama a AlumnoRestWSClientImpl.consultaDatos(token)
    resultadoAlumno = getWSService().consultaDatos(this.token);
    return resultadoAlumno;
  }

  public Materias consultaMaterias() {
    resultadoMaterias = getWSService().consultaMaterias(this.token);
    return resultadoMaterias;
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

  public Materias getResultadoMaterias() {
    return resultadoMaterias;
  }

  public void setResultadoMaterias(Materias resultadoMaterias) {
    this.resultadoMaterias = resultadoMaterias;
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
}

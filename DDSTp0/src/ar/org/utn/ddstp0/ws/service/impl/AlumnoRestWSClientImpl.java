package ar.org.utn.ddstp0.ws.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ar.org.utn.ddstp0.exception.ServiceException;
import ar.org.utn.ddstp0.utils.RestWSClientConstants;
import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Materias;
import ar.org.utn.ddstp0.ws.service.AlumnoRestWSClient;

public class AlumnoRestWSClientImpl implements AlumnoRestWSClient {

  RestTemplate restTemplate;;

  private RestTemplate getRestTemplate() {
    if (restTemplate == null) {
      restTemplate = new RestTemplate();
    }
    return restTemplate;
  }

  @Override
  public int actualizarDatos(String token, Alumno alumno) throws ServiceException {
    // Se hace llamado al WS (PUT http://notitas.herokuapp.com/student)

    if (StringUtils.isEmpty(token)) {
      throw new ServiceException("Token vacio.");
    }

    try {
      HttpHeaders headers = new HttpHeaders();
      headers.add("Authorization", RestWSClientConstants.AUTHORIZATION_KEY + token);
      headers.setContentType(MediaType.APPLICATION_JSON);
      HttpEntity<Alumno> request = new HttpEntity<Alumno>(alumno, headers);
      ResponseEntity<Alumno> response = getRestTemplate().exchange(
          RestWSClientConstants.API_HEROKUAPP + RestWSClientConstants.RESOURCE_ALUMNO,
          HttpMethod.PUT, request, Alumno.class);
      return response.getStatusCode().value();
    } catch (Exception ex) {
      throw new ServiceException("Se produjo un error inesperado", ex);
    }
  }

  @Override
  public Alumno consultaDatos(String token) throws ServiceException {
    // Se hace llamado al WS (GET http://notitas.herokuapp.com/student)
    if (StringUtils.isEmpty(token)) {
      throw new ServiceException("Token vacio.");
    }
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.add("Authorization", RestWSClientConstants.AUTHORIZATION_KEY + token);
      HttpEntity<String> request = new HttpEntity<String>(headers);
      ResponseEntity<Alumno> response = getRestTemplate().exchange(
          RestWSClientConstants.API_HEROKUAPP + RestWSClientConstants.RESOURCE_ALUMNO,
          HttpMethod.GET, request, Alumno.class);
      return response.getBody();

    } catch (Exception ex) {
      throw new ServiceException("Se produjo un error inesperado", ex);
    }
  }

  @Override
  public Materias consultaMaterias(String token) throws ServiceException {
    // Se hace llamado al WS (GET http://notitas.herokuapp.com/student/assignments)
    if (StringUtils.isEmpty(token)) {
      throw new ServiceException("Token vacio.");
    }
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.add("Authorization", RestWSClientConstants.AUTHORIZATION_KEY + token);
      HttpEntity<Materias> request = new HttpEntity<Materias>(headers);
      ResponseEntity<Materias> response = getRestTemplate().exchange(
          RestWSClientConstants.API_HEROKUAPP + RestWSClientConstants.RESOURCE_MATERIAS,
          HttpMethod.GET, request, Materias.class);

      return response.getBody();

    } catch (Exception ex) {
      throw new ServiceException("Se produjo un error inesperado", ex);
    }
  }

}

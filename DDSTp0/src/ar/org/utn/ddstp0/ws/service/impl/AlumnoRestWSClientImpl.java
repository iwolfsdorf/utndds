package ar.org.utn.ddstp0.ws.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
  public int actualizarDatos(String token, Alumno alumno) {
    // Se hace llamado al WS (PUT http://notitas.herokuapp.com/student)

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", RestWSClientConstants.AUTHORIZATION_KEY + token);
    headers.setContentType(MediaType.APPLICATION_JSON);

    // MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
    // map.add("code", String.valueOf(alumno.getCode()));
    // map.add("first_name", alumno.getFirst_name());
    // map.add("last_name", alumno.getLast_name());
    // map.add("github_user", alumno.getGithub_user());

    HttpEntity<Alumno> request = new HttpEntity<Alumno>(alumno, headers);

    ResponseEntity<Alumno> response = getRestTemplate().exchange(
        RestWSClientConstants.API_HEROKUAPP + RestWSClientConstants.RESOURCE_ALUMNO, HttpMethod.PUT,
        request, Alumno.class);
    return response.getStatusCode().value();
  }

  @Override
  public Alumno consultaDatos(String token) {
    // Se hace llamado al WS (GET http://notitas.herokuapp.com/student)
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", RestWSClientConstants.AUTHORIZATION_KEY + token);
    HttpEntity<String> request = new HttpEntity<String>(headers);
    ResponseEntity<Alumno> response = getRestTemplate().exchange(
        RestWSClientConstants.API_HEROKUAPP + RestWSClientConstants.RESOURCE_ALUMNO, HttpMethod.GET,
        request, Alumno.class);

    return response.getBody();
  }

  @Override
  public Materias consultaMaterias(String token) {
    // Se hace llamado al WS (GET http://notitas.herokuapp.com/student/assignments)
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", RestWSClientConstants.AUTHORIZATION_KEY + token);
    HttpEntity<String> request = new HttpEntity<String>(headers);
    ResponseEntity<Materias> response = getRestTemplate().exchange(
        RestWSClientConstants.API_HEROKUAPP + RestWSClientConstants.RESOURCE_MATERIAS,
        HttpMethod.GET, request, Materias.class);

    return response.getBody();
  }

}

package ar.org.utn.ddstp0.ws.dto;

import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

@Transactional
@Observable
public class Alumno {

  private int code;
  private String first_name;
  private String last_name;
  private String github_user;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getGithub_user() {
    return github_user;
  }

  public void setGithub_user(String github_user) {
    this.github_user = github_user;
  }

  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();

    if (this.code != 0) {
      stringBuilder.append("Code : " + this.code + '\n');
      stringBuilder.append("First_name : " + this.first_name + '\n');
      stringBuilder.append("Last_name : " + this.last_name + '\n');
      stringBuilder.append("Github_user : " + this.github_user + '\n');
    }
    return stringBuilder.toString();
  }
}

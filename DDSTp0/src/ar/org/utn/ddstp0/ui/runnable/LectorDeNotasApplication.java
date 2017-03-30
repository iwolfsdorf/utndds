package ar.org.utn.ddstp0.ui.runnable;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;

import ar.org.utn.ddstp0.ui.InformacionPersonalWindow;
import ar.org.utn.ddstp0.ws.service.impl.AlumnoRestWSClientImpl;

public class LectorDeNotasApplication extends Application {

  public static void main(String[] args) {
    new LectorDeNotasApplication().start();
  }

  @Override
  protected Window<?> createMainWindow() {
    System.setProperty("http.proxyHost", "proxy.hq.colegio-escribanos.org.ar");
    System.setProperty("http.proxyPort", "8080");
    System.setProperty("https.proxyHost", "proxy.hq.colegio-escribanos.org.ar");
    System.setProperty("https.proxyPort", "8080");

    ApplicationContext.getInstance().configureSingleton(AlumnoRestWSClientImpl.class,
        new AlumnoRestWSClientImpl());
    return new InformacionPersonalWindow(this);
  }
}

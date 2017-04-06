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
    ApplicationContext.getInstance().configureSingleton(AlumnoRestWSClientImpl.class,
        new AlumnoRestWSClientImpl());
    return new InformacionPersonalWindow(this);
  }
}

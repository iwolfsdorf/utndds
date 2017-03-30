package ar.org.utn.ddstp0.ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import java.awt.Color;

import ar.org.utn.ddstp0.service.impl.AlumnoServiceImpl;
import ar.org.utn.ddstp0.ws.dto.Alumno;

@SuppressWarnings("serial")
public class InformacionPersonalWindow extends SimpleWindow<AlumnoServiceImpl> {

  public InformacionPersonalWindow(WindowOwner parent) {
    super(parent, new AlumnoServiceImpl());
    this.getModelObject().setResultadoAlumno(new Alumno());
  }

  @Override
  protected void addActions(Panel actionsPanel) {
    new Button(actionsPanel).setCaption("Datos Personales").onClick(getModelObject()::consultaDatos)
        .setAsDefault().disableOnError();
    
    new Button(actionsPanel).setCaption("Datos Materias").onClick(getModelObject()::consultaMaterias)
    .setAsDefault().disableOnError();
    
    new Button(actionsPanel).setCaption("Actualizar Datos").onClick(getModelObject()::actualizarDatos)
    .setAsDefault().disableOnError();
  }

  @Override
  protected void createFormPanel(Panel mainPanel) {
    Panel searchFormPanel = new Panel(mainPanel);
    searchFormPanel.setLayout(new ColumnLayout(2));

    new Label(searchFormPanel).setText("Token").setForeground(Color.BLUE);
    new TextBox(searchFormPanel).setWidth(150).bindValueToProperty("token");
    
    new Label(searchFormPanel).setText("Nuevo usario GitHub").setForeground(Color.BLUE);
    new TextBox(searchFormPanel).setWidth(150).bindValueToProperty("github_user");
  }

  @Override
  protected void createMainTemplate(Panel mainPanel) {
    this.setTitle("Buscador de Alumno");
    this.setTaskDescription("Ingrese un token y si quiere un usuario de GitHub para actualizar.");

    super.createMainTemplate(mainPanel);
    
    Label actualizacion = new Label(mainPanel);
    actualizacion.setForeground(Color.BLUE).bindValueToProperty("resultadoActualizacion");

    Label alumno = new Label(mainPanel);
    alumno.setForeground(Color.BLUE).bindValueToProperty("resultadoAlumno");
    
    Label materias = new Label(mainPanel);
    materias.setForeground(Color.BLUE).bindValueToProperty("resultadoMaterias");
  }

}

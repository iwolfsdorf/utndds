package ar.org.utn.ddstp0.ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import java.awt.Color;

import ar.org.utn.ddstp0.service.impl.AlumnoServiceImpl;
import ar.org.utn.ddstp0.ws.dto.Alumno;
import ar.org.utn.ddstp0.ws.dto.Assignment;

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

    new Button(actionsPanel).setCaption("Datos Materias")
        .onClick(getModelObject()::consultaMaterias).setAsDefault().disableOnError();

    new Button(actionsPanel).setCaption("Actualizar Datos")
        .onClick(getModelObject()::actualizarDatos).setAsDefault().disableOnError();
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

    Label error = new Label(mainPanel);
    error.setForeground(Color.RED).bindValueToProperty("error");

    super.createMainTemplate(mainPanel);

    Label actualizacion = new Label(mainPanel);
    actualizacion.setForeground(Color.BLUE).bindValueToProperty("resultadoActualizacion");

    Label alumno = new Label(mainPanel);
    alumno.setForeground(Color.BLACK).bindValueToProperty("resultadoAlumno");

    this.createResultsGridMaterias(mainPanel);
  }


  protected void createResultsGridMaterias(Panel mainPanel) {
    Table<Assignment> table = new Table<Assignment>(mainPanel, Assignment.class);
    table.setNumberVisibleRows(4);
    table.setWidth(450);

    table.bindItemsToProperty("resultadosMaterias");

    this.describeResultsGridAlumno(table);
  }

  protected void describeResultsGridAlumno(Table<Assignment> table) {
    new Column<Assignment>(table) //
        .setTitle("Legajo").setFixedSize(100).bindContentsToProperty("id");

    new Column<Assignment>(table) //
        .setTitle("Nombre").setFixedSize(150).bindContentsToProperty("title");

    new Column<Assignment>(table) //
        .setTitle("Apellido").setFixedSize(150).bindContentsToProperty("description");

    new Column<Assignment>(table).setTitle("Notas").setFixedSize(200)
        .bindContentsToProperty("grades");

  }

}

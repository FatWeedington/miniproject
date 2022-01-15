package btx.prog.one.miniproject.hospital.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GraphicalUserInterface extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox vbox = new VBox();
        vbox.getChildren().add(createMenueBar());
        vbox.getChildren().add(createToolBar());
        vbox.getChildren().add(createTableView());
        var scene = new Scene(vbox, 1400,800);
        stage.setScene(scene);
        stage.show();
    }

    private MenuBar createMenueBar(){
        MenuBar menuBar= new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem aboutMenuItem = new MenuItem("About...");
        fileMenu.getItems().add(aboutMenuItem);
        menuBar.getMenus().add(fileMenu);

        Menu patientMenu = new Menu("Patient");
        MenuItem newPatientMenuItem = new MenuItem("New Patient...");
        patientMenu.getItems().add(newPatientMenuItem);
        menuBar.getMenus().add(patientMenu);
        return menuBar;
    }

    private ToolBar createToolBar(){
        ToolBar toolBar = new ToolBar();
        Button newPatientButton = new Button("New Patient...");
        Button setButton = new Button("Set A ...");

        toolBar.getItems().add(newPatientButton);
        toolBar.getItems().add(setButton);

        return toolBar;
    }

    private TableView createTableView(){
        TableView tableView = new TableView();

        return tableView;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}

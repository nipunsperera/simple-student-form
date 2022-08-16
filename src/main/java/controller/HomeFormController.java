package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HomeFormController {
    public JFXButton btnSaveStudent;
    public JFXButton btnViewStudent;

    public void btnSaveStudentOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/RegistrationFrom.fxml");
        Parent container = FXMLLoader.load(resource);
        Scene scene = new Scene(container);
        Stage stage = (Stage)(btnSaveStudent.getScene().getWindow());
        stage.setScene(scene);
        stage.setTitle("View Student Details");
        stage.show();
        stage.centerOnScreen();

    }

    public void btnViewStudentOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/StudentsForm.fxml");
        Parent container = FXMLLoader.load(resource);
        Scene scene = new Scene(container);
        Stage stage = (Stage)(btnSaveStudent.getScene().getWindow());
        stage.setScene(scene);
        stage.setTitle("View Student Details");
        stage.show();
        stage.centerOnScreen();


    }
}

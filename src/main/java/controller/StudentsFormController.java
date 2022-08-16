package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import util.Student;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class StudentsFormController {
    public TableView<Student> tableStudent;
    public JFXButton btnBack;

    public void initialize() throws IOException, ClassNotFoundException {
        File file = new File("/home/nipunperera/Desktop/results/database.txt");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Student> readObject = (ArrayList<Student>) ois.readObject();
        System.out.println(readObject);
        for(Student eachStudent : readObject){
            tableStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
            tableStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("id"));
            tableStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact"));

            String name = eachStudent.getName();
            String id = eachStudent.getId();
            String contact = eachStudent.getContact();
            Student student = new Student(name, id, contact);
            tableStudent.getItems().add(student);
        }

        ois.close();
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/HomeForm.fxml");
        Parent container = FXMLLoader.load(resource);
        Scene scene = new Scene(container);
        Stage stage = (Stage)(btnBack.getScene().getWindow());
        stage.setScene(scene);
        stage.setTitle("View Student Details");
        stage.show();
        stage.centerOnScreen();
    }
}

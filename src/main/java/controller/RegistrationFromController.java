package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.Student;

import javax.tools.FileObject;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class RegistrationFromController {
    public JFXTextField txtID;
    public JFXTextField txtName;
    public JFXTextField txtContactNumber;
    public JFXButton btnSaveStudent;
    public JFXButton btnBack;
    private File file;
    private ArrayList<Student> readObject;

    public void initialize() throws IOException, ClassNotFoundException {


        file = new File("/home/nipunperera/Desktop/results/database.txt");
        if(!file.exists()){
            file.getParentFile().mkdirs();
            file.createNewFile();
            readObject = new ArrayList<>();
        }else{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            readObject = (ArrayList<Student>) ois.readObject();
            System.out.println(readObject);

            ois.close();
        }
    }

    public void btnSaveStudentOnAction(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Student student = new Student(txtName.getText(), txtID.getText(), txtContactNumber.getText());
        readObject.add(student);
        oos.writeObject(readObject);
        System.out.println(readObject);

        oos.close();

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/HomeForm.fxml");
        Parent container = FXMLLoader.load(resource);
        Scene scene = new Scene(container);
        Stage stage = (Stage)(txtID.getScene().getWindow());
        stage.setScene(scene);
        stage.setTitle("View Student Details");
        stage.show();
        stage.centerOnScreen();
    }

    public void getId() throws IOException {

    }
}

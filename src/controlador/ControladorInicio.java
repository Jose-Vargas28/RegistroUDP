package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorInicio {

    @FXML private TextField txtCedula;

    @FXML
    private void buscarUsuario() throws Exception {
        Stage stage = (Stage) txtCedula.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/cliente.fxml"));

        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    private void registrarUsuario() throws Exception {
        Stage stage = (Stage) txtCedula.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/registro.fxml"));

        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}

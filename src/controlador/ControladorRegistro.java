package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import red.ClienteUDP;

public class ControladorRegistro {

    @FXML private TextField txtCedula;
    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private CheckBox chkPreferencial;
    @FXML private Label lblEstado;

    private ClienteUDP cliente = new ClienteUDP();

    @FXML
    private void crearUsuario() {
        try {
            String mensaje = "REGISTRAR;" +
                    txtCedula.getText() + ";" +
                    txtCorreo.getText() + ";" +
                    "0999999999;" +  // teléfono quemado (cliente no valida)
                    txtNombre.getText() + ";" +
                    chkPreferencial.isSelected();

            String respuesta = cliente.enviar(mensaje);
            lblEstado.setText(respuesta);

        } catch (Exception e) {
            lblEstado.setText("Error de comunicación");
        }
    }
}

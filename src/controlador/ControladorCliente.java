package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import red.ClienteUDP;

public class ControladorCliente {

    @FXML private Label lblCedula;
    @FXML private Label lblNombre;
    @FXML private Label lblCorreo;
    @FXML private Label lblPreferencial;
    @FXML private Label lblSaldo;

    private ClienteUDP cliente = new ClienteUDP();

    @FXML
    private void recargar() {
        lblSaldo.setText("Saldo: 5.00 USD");
    }

    @FXML
    private void pagar() {
        lblSaldo.setText("Saldo: 4.70 USD");
    }
}

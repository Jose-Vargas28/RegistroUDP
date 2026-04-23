package modelo;

public class Usuario {

    private String cedula;
    private String correo;
    private String telefono;
    private String nombre;
    private boolean preferencial;
    private Tarjeta tarjeta;

    public Usuario(String cedula, String correo, String telefono,
                   String nombre, boolean preferencial) {
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.preferencial = preferencial;
        this.tarjeta = new Tarjeta();
    }

    public String getCedula() {
        return cedula;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public String obtenerInformacion() {
        return cedula + ";" +
                nombre + ";" +
                correo + ";" +
                telefono + ";" +
                preferencial + ";" +
                tarjeta.getSaldo();
    }
}

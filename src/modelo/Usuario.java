package modelo;

public class Usuario {

    private final String cedula;
    private final String nombre;
    private final String correo;
    private final boolean preferencial;

    public Usuario(String cedula, String nombre, String correo, boolean preferencial) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.preferencial = preferencial;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean isPreferencial() {
        return preferencial;
    }
}

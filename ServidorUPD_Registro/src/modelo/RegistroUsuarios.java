package modelo;

import java.util.ArrayList;

public class RegistroUsuarios {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public String registrarUsuario(Usuario usuario) {

        if (buscarUsuario(usuario.getCedula()) != null) {
            return "ERROR: Usuario ya registrado";
        }

        usuarios.add(usuario);
        return "OK: Usuario registrado correctamente";
    }

    public Usuario buscarUsuario(String cedula) {
        for (Usuario u : usuarios) {
            if (u.getCedula().equals(cedula)) {
                return u;
            }
        }
        return null;
    }
}
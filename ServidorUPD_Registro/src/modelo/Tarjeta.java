package modelo;

public class Tarjeta {

    private double saldo;

    public Tarjeta() {
        this.saldo = 0.0;
    }

    public void cargarSaldo(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public boolean pagarPasaje(boolean preferencial) {
        double costo = preferencial ? 0.15 : 0.30;

        if (saldo >= costo) {
            saldo -= costo;
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }
}
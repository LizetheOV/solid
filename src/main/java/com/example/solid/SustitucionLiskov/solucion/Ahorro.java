package com.example.solid.SustitucionLiskov.solucion;

public class Ahorro extends Cuenta implements Debitar, Acreditar{
    @Override
    public void debitar(Double monto) {

    }

    @Override
    public void acreditar(Double monto) {

    }
}

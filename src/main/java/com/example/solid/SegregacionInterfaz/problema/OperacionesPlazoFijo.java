package com.example.solid.SegregacionInterfaz.problema;


public class OperacionesPlazoFijo implements OperacionesBancarias {

    @Override
    public void depositar(String numeroCuenta, Double monto) {
       //codigo para depositar
    }

    @Override
    public void retirar(String numeroCuenta, Double monto) {
        throw new UnsupportedOperationException("Not Allowed");
    }
}

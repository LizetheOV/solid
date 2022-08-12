package com.example.solid.SegregacionInterfaz.problema;

import org.springframework.stereotype.Service;

@Service
public class OperacionesCuentaAhorro implements OperacionesBancarias {

    @Override
    public void depositar(String numeroCuenta, Double monto) {
        //codigo para depositar
    }

    @Override
    public void retirar(String numeroCuenta, Double monto) {
        //codigo para retirar
    }
}

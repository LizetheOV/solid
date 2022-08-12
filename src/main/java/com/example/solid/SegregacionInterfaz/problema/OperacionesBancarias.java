package com.example.solid.SegregacionInterfaz.problema;

public interface OperacionesBancarias {
    void depositar(String numeroCuenta, Double monto);
    void retirar(String numeroCuenta, Double monto);

}

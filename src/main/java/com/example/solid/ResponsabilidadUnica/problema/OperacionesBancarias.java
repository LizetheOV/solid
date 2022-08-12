package com.example.solid.ResponsabilidadUnica.problema;

import javax.naming.OperationNotSupportedException;

public interface OperacionesBancarias {
    void depositar(String numeroCuenta, Double monto);
    void retirar(String numeroCuenta, Double monto) throws OperationNotSupportedException;

}

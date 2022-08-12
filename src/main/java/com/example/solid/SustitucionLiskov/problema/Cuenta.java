package com.example.solid.SustitucionLiskov.problema;

import lombok.Getter;
import lombok.Setter;

import javax.naming.OperationNotSupportedException;

@Getter
@Setter
public abstract class Cuenta {
    private String numeroCuenta;
    private Double saldo;

    public abstract void debitar(Double monto) throws OperationNotSupportedException;
    public abstract void acreditar(Double monto);


}

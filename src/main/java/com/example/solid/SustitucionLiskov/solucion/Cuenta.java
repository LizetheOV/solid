package com.example.solid.SustitucionLiskov.solucion;

import lombok.Getter;
import lombok.Setter;

import javax.naming.OperationNotSupportedException;

@Getter
@Setter
public class Cuenta {
    private String numeroCuenta;
    private Double saldo;
}

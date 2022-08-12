package com.example.solid.SustitucionLiskov.problema;


import javax.naming.OperationNotSupportedException;

public class PlazoFijo extends Cuenta {
    private static Double fixedAmount = 1000.0;

    @Override
    public void debitar(Double monto) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("No permitido");
    }

    @Override
    public void acreditar(Double monto) {
        if (monto == fixedAmount) {
            setSaldo(getSaldo() + fixedAmount);
        } else {
            throw new IllegalArgumentException();
        }
    }
}

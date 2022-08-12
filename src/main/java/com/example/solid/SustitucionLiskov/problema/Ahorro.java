package com.example.solid.SustitucionLiskov.problema;

import javax.naming.OperationNotSupportedException;

public class Ahorro extends Cuenta {

    @Override
    public void debitar(Double monto) throws OperationNotSupportedException {
        Double saldoActual = getSaldo();
        if (saldoActual >= monto) {
            Double saldoActualizado = saldoActual - monto;
            setSaldo(saldoActualizado);
        } else {
            throw new OperationNotSupportedException("Saldo insufiente");
        }
    }

    @Override
    public void acreditar(Double monto) {
        Double saldoActualizado = getSaldo() + monto;
        setSaldo(saldoActualizado);
    }
}

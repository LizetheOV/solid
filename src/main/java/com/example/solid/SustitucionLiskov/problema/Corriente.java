package com.example.solid.SustitucionLiskov.problema;

public class Corriente extends Cuenta {

    @Override
    public void debitar(Double monto) {
        Double saldoActualizado = getSaldo() - monto;
        setSaldo(saldoActualizado);
    }

    @Override
    public void acreditar(Double monto) {
        Double saldoActualizado = getSaldo() + monto;
        setSaldo(saldoActualizado);
    }
}

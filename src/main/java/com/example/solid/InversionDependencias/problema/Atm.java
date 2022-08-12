package com.example.solid.InversionDependencias.problema;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Atm {
    DatabaseAccess databaseAccess;

    public Atm(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public void depositar(String numeroCuenta, Double monto) {
        try {
            Double saldoActual = databaseAccess.obtenerSaldo(numeroCuenta);
            databaseAccess.actualizarSaldo(numeroCuenta, saldoActual + monto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void retirar(String numeroCuenta, Double monto) {
        Double saldoActual = databaseAccess.obtenerSaldo(numeroCuenta);
        if (saldoActual >= monto) {
            databaseAccess.actualizarSaldo(numeroCuenta, saldoActual - monto);
        }
    }
}

package com.example.solid.InversionDependencias.problema;

import org.springframework.stereotype.Component;

@Component
public class DatabaseAccess {

    public Double obtenerSaldo(String numeroCuenta) {
        String consultaSaldo = "SELECT balance FROM SAVINGS_BANK WHERE number=" + numeroCuenta;
        Double saldo = (Double) ejecutarConsulta(consultaSaldo);
        return saldo;
    }

    public void actualizarSaldo(String numeroCuenta, Double nuevoSaldo) {
        String actualizarSaldo = "UPDATE SAVINGS_BANK set balance=" + nuevoSaldo + " WHERE number=" + numeroCuenta;
        ejecutarConsulta(actualizarSaldo);
    }

    private Object ejecutarConsulta(String consulta) {
        //codigo para ejecutar la consulta
        return consulta;
    }

}

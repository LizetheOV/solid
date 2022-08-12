package com.example.solid.ResponsabilidadUnica.problema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;

@Service
public class Atm implements OperacionesBancarias {

    @Autowired
    DatabaseAccess databaseAccess;

    @Autowired
    Notificacion notificacion;

    @Override
    public void depositar(String numeroCuenta, Double monto) {
        try {
            Double saldoActual = obtenerSaldo(numeroCuenta);
            actualizarSaldo(numeroCuenta, saldoActual + monto);
            enviarNotificacion(numeroCuenta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enviarNotificacion(String numeroCuenta) {
        String email = obtenerEmailCliente(numeroCuenta);
        notificacion.enviarNotificacion(email, Canal.EMAIL, "Notificacion de Deposito");
    };

    @Override
    public void retirar(String numeroCuenta, Double monto) throws OperationNotSupportedException {
        Double saldoActual = obtenerSaldo(numeroCuenta);

        if (saldoActual >= monto) {
            actualizarSaldo(numeroCuenta, saldoActual - monto);
        } else {
            throw new OperationNotSupportedException("Fondos insuficientes");
        }
    }

    private String obtenerEmailCliente(String numeroCuenta) {
        String findEmail = "SELECT CLIENT.email " +
                "FROM CLIENT INNER JOIN SAVINGS_BANK " +
                "WHERE DEBIT_ACCOUNT.number=" + numeroCuenta;
        return (String) databaseAccess.executeFind(findEmail);
    }

    private Double obtenerSaldo(String numeroCuenta) {
        String consulta = "SELECT balance FROM SAVINGS_BANK WHERE number=" + numeroCuenta;
        return (Double) databaseAccess.executeFind(consulta);
    }

    private void actualizarSaldo(String numeroCuenta, Double monto) {
        String consulta = "UPDATE DEBIT_ACCOUNT set balance=" + monto + " WHERE number=" + numeroCuenta;
        databaseAccess.executeSentence(consulta);
    }
}

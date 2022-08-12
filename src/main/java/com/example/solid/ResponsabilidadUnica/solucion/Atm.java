package com.example.solid.ResponsabilidadUnica.solucion;

import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;

@Service
public class Atm implements OperacionesBancarias {

    AtmRepository atmRepository;

    Notificacion notificacion;

    public Atm(AtmRepository atmRepository, Notificacion notificacion) {
        this.atmRepository = atmRepository;
        this.notificacion = notificacion;
    }

    @Override
    public void depositar(String numeroCuenta, Double monto) {
        try {
            Double saldoActual = atmRepository.obtenerSaldo(numeroCuenta);
            atmRepository.actualizarSaldo(numeroCuenta, saldoActual + monto);
            String email = atmRepository.obtenerEmailCliente(numeroCuenta);
            notificacion.enviarNotificacion(email, Canal.EMAIL, "Notificacion de Deposito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void retirar(String numeroCuenta, Double monto) throws OperationNotSupportedException {
        Double saldoActual = atmRepository.obtenerSaldo(numeroCuenta);

        if (saldoActual >= monto) {
            atmRepository.actualizarSaldo(numeroCuenta, saldoActual - monto);
        } else {
            throw new OperationNotSupportedException("Fondos insuficientes");
        }
    }
}

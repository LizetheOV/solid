package com.example.solid.InversionDependencias.solucion;


import com.example.solid.InversionDependencias.problema.DatabaseAccess;
import com.example.solid.ResponsabilidadUnica.solucion.AtmRepository;
import org.springframework.stereotype.Service;

@Service
public class Atm {
    AtmRepository atmRepository;

    public Atm(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    public void depositar(String numeroCuenta, Double monto) {
        try {
            Double saldoActual = atmRepository.obtenerSaldo(numeroCuenta);
            atmRepository.actualizarSaldo(numeroCuenta, saldoActual + monto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void retirar(String numeroCuenta, Double monto) {
        Double saldoActual = atmRepository.obtenerSaldo(numeroCuenta);
        if (saldoActual >= monto) {
            atmRepository.actualizarSaldo(numeroCuenta, saldoActual - monto);
        }
    }
}

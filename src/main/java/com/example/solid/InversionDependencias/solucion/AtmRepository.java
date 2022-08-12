package com.example.solid.InversionDependencias.solucion;

import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepository {
    Double obtenerSaldo(String numeroCuenta);
    void actualizarSaldo(String numeroCuenta, Double monto);
}

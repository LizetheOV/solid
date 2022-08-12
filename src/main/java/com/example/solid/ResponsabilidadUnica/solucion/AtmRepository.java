package com.example.solid.ResponsabilidadUnica.solucion;

import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepository {
    Double obtenerSaldo(String numeroCuenta);
    void actualizarSaldo(String numeroCuenta, Double monto);
    String obtenerEmailCliente(String numeroCuenta);
}

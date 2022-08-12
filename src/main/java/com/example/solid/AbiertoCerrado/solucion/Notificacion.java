package com.example.solid.AbiertoCerrado.solucion;

import org.springframework.stereotype.Service;

@Service
public class Notificacion {

    public void enviarNotificacion(String destino, String mensaje, Notificador notificador) {
        notificador.enviarNotificacion(destino, mensaje);
    }
}

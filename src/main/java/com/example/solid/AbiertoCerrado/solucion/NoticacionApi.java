package com.example.solid.AbiertoCerrado.solucion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/notificacion")
public class NoticacionApi {

    @Autowired
    Notificacion notificacion;

    @GetMapping(value = "/email")
    public void enviarEmail(@RequestParam String destino, @RequestParam String mensaje) {
        notificacion.enviarNotificacion(destino, mensaje, new Email());
    }

    @GetMapping(value = "/sms")
    public void enviarSms(@RequestParam String destino, @RequestParam String mensaje) {
        notificacion.enviarNotificacion(destino, mensaje, new Sms());
    }
}

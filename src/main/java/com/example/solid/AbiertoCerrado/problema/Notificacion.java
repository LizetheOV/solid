package com.example.solid.AbiertoCerrado.problema;

import org.springframework.stereotype.Service;

@Service
public class Notificacion {

    public void enviarNotificacion(String destino, Canal canal, String mensaje) {
        if (canal.equals(Canal.EMAIL)) {
            enviarEmail(destino, mensaje);
        } else {
            enviarSMS(destino, mensaje);
        }
    }

    private void enviarEmail(String email, String mensaje) {
        //code to send email
    }

    private void enviarSMS(String numero, String mensaje) {
        //code to send SMS
    }

    private void enviarW(String numero, String mensaje) {
        //code to send SMS
    }
}

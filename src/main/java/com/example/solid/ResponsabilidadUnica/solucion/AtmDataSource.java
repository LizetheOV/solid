package com.example.solid.ResponsabilidadUnica.solucion;

public class AtmDataSource  implements AtmRepository {
    @Override
    public Double obtenerSaldo(String numeroCuenta) {
        String consulta = "SELECT balance FROM SAVINGS_BANK WHERE number=" + numeroCuenta;
        return (Double) executeFind(consulta);
    }

    @Override
    public void actualizarSaldo(String numeroCuenta, Double monto) {
        String consulta = "UPDATE DEBIT_ACCOUNT set balance=" + monto + " WHERE number=" + numeroCuenta;
        executeSentence(consulta);
    }

    @Override
    public String obtenerEmailCliente(String numeroCuenta) {
        String findEmail = "SELECT CLIENT.email " +
                "FROM CLIENT INNER JOIN SAVINGS_BANK " +
                "WHERE DEBIT_ACCOUNT.number=" + numeroCuenta;
        return (String) executeFind(findEmail);
    }

    public Object executeFind(String sentence) {
        return sentence;
    }

    public void executeSentence(String sentence) {

    }
}

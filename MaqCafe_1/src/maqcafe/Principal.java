package maqcafe;

public class Principal {
    public static void main(String[] args) {
        
        // Liga a máquina
        MaquinaCafe maquina = new MaquinaCafe();
        
        // Simula um cliente chegando e usando
        maquina.iniciarAtendimento();
        
    }
}
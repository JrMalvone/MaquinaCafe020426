
package com.mycompany.maquinadecafe;

public interface IPagamentos {
    public abstract boolean pagarcartao();
    public abstract boolean pagarpix();
    public abstract void saldoindisponivel();
    
}

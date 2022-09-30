// CRIANDO NOSSO MODELO.
package model;

import helper.Utils;

public class Producer {

    private static int contador = 1;
    private int codigo;
    private String nome;
    private Double  preco;

    public Producer(String nome, Double preco) {
        this.codigo = Producer.contador;
        this.nome = nome;
        this.preco = preco;
        Producer.contador += 1;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String toString(){
        return "Codigo " + this.getCodigo() +
                "\nNome : " + this.getNome() +
                "\nPreço " + Utils.doubleParaString(this.getPreco());
    }
}

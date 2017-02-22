package com.decisionsupport.ahpmethod.AhpStatic;

/**
 * Created by gabrielrosa on 21/02/17.
 */

public class Alternative implements Comparable<Alternative> {

    private String nome;
    private float valor;

    public Alternative (String nome, float valor) {

        this.nome = nome;
        this.valor = valor;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Alternative outra) {
        if(this.getValor() > outra.getValor()){
            return -1;
        }
        if(this.getValor() < outra.getValor()){
            return 1;
        }
        return 0;
    }

}

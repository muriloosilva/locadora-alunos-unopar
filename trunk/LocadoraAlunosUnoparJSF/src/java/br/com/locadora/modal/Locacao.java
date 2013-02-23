/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.modal;

/**
 *
 * @author murilo
 */
public class Locacao {
    
    private int codLocacao;
    private int codVeiculo;
    private String data;
    private String cliente;
    private double valor;

    public int getCodLocacao() {
        return codLocacao;
    }

    public void setCodLocacao(int codLocacao) {
        this.codLocacao = codLocacao;
    }

    public int getCodVeiculo() {
        return codVeiculo;
    }

    public void setCodVeiculo(int codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}

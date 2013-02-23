/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controller;

import br.com.locadora.banco.LocacaoDAO;
import br.com.locadora.modal.Locacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author paulo.terra
 */
@RequestScoped
@ManagedBean(name = "pedido")
public class ValidaLocacaoCRUD {

    private Locacao locacao;

    public ValidaLocacaoCRUD() {
        locacao = new Locacao();
    }

    public String locarOk() {

        String ret = "erro";
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        if (locacaoDAO.addLocacao(locacao) == true) {
            ret = "sucesso";
        } else {
            ret = "erro";
        }
        return ret;
    }

    public Locacao getLocacao() {
        return locacao;
    }
    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }
}

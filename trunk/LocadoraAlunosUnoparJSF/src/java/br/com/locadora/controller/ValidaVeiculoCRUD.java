/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controller;

import br.com.locadora.banco.VeiculoDAO;
import br.com.locadora.modal.Veiculo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author paulo.terra
 */
@RequestScoped
@ManagedBean(name = "veiculo")
public class ValidaVeiculoCRUD {

    private Veiculo veiculo;

    public ValidaVeiculoCRUD() {
        veiculo = new Veiculo();
    }

    public String inserirOk() {

        String ret = "erro";
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        if (veiculoDAO.addVeiculo(veiculo) == true) {
            ret = "sucesso";
        } else {
            ret = "erro";
        }
        return ret;
    }

    public String buscarOk() {
        
        String ret = "erro";
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        Veiculo veiculo1 = new Veiculo();
        veiculo1 = veiculoDAO.getVeiculo(veiculo.getPlaca());
        if (veiculo1.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
            veiculo = veiculo1;//bean tela = bean banco
            ret = "sucesso";
        } else {
            ret = "erro";
        }
        return ret;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}

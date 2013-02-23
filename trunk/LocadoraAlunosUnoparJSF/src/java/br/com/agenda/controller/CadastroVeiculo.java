/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.controller;

import br.com.agenda.banco.VeiculoDAO;
import br.com.agenda.modal.Veiculo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author murilo
 */
@WebServlet(name = "CadastroVeiculo", urlPatterns = {"/CadastroVeiculo"})
public class CadastroVeiculo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         Veiculo veiculo = new Veiculo();
        veiculo.setAno(Integer.parseInt(request.getParameter("ano")));
        veiculo.setMarca(request.getParameter("marca"));
        veiculo.setModelo(request.getParameter("modelo"));
        veiculo.setPlaca(request.getParameter("placa"));
        veiculo.setTipo(request.getParameter("tipo"));
        veiculo.setValor(Double.parseDouble(request.getParameter("valor")));
        
        VeiculoDAO veiculoDao = new VeiculoDAO();
        boolean result = veiculoDao.addVeiculo(veiculo);
        
        RequestDispatcher view;
        if(result)
            view = request.getRequestDispatcher("/faces/cadastroOk.xhtml");
        else
            view = request.getRequestDispatcher("/faces/cadastroErro.xhtml");
        
	view.forward(request, response);
       
    }

}

package br.com.agenda.banco;

import br.com.agenda.modal.Locacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LocacaoDAO {
	public boolean addLocacao(Locacao locacao){
            
            boolean ret = false;
		
		String sql = "INSERT INTO locacao(codlocacao,codveiculo,data,cliente,valor) VALUES" +
				" (?,?,?,?,?)";
		try {
			// prepared statement para insers�o
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1,locacao.getCodLocacao());
			stmt.setInt(2,locacao.getCodVeiculo());
                        stmt.setString(3,locacao.getData());
                        stmt.setString(4,locacao.getCliente());
                        stmt.setDouble(5,locacao.getValor());
			// executa
			stmt.execute();
			stmt.close();
			con.close();
                        ret = true;
		} catch (SQLException e) {
                        ret = false;        
		}
                return ret;
	}
		
}

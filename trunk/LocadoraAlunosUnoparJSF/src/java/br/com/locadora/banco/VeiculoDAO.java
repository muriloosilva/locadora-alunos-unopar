package br.com.locadora.banco;

import br.com.locadora.modal.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VeiculoDAO {
	public boolean addVeiculo(Veiculo veiculo){
            
            boolean ret = false;
		
		String sql = "INSERT INTO veiculo(placa,ano,modelo,marca,tipo,valor) VALUES" +
				" (?,?,?,?,?,?)";
		try {
			// prepared statement para insers�o
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,veiculo.getPlaca());
			stmt.setInt(2,veiculo.getAno());
                        stmt.setString(3,veiculo.getModelo());
                        stmt.setString(4,veiculo.getMarca());
                        stmt.setString(5,veiculo.getTipo());
			stmt.setDouble(6,veiculo.getValor());
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
	
	public List<Veiculo> getVeiculos(){
		
		PreparedStatement stmt;
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from veiculo");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				Veiculo veiculo = new Veiculo();
                                veiculo.setIdVeiculo(rs.getInt("idveiculo"));
                                veiculo.setPlaca(rs.getString("placa"));
                                veiculo.setAno(rs.getInt("ano"));
                                veiculo.setModelo(rs.getString("modelo"));
                                veiculo.setMarca(rs.getString("marca"));
                                veiculo.setTipo(rs.getString("tipo"));
                                veiculo.setValor(rs.getDouble("valor"));
				veiculos.add(veiculo);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return veiculos;
		
	}
	
    public Veiculo getVeiculo(String placa){
		
		PreparedStatement stmt;
		Veiculo veiculo = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from veiculo where placa like '%"+placa+"%'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				veiculo = new Veiculo();
                                veiculo.setIdVeiculo(rs.getInt("idveiculo"));
                                veiculo.setPlaca(rs.getString("placa"));
                                veiculo.setAno(rs.getInt("ano"));
                                veiculo.setModelo(rs.getString("modelo"));
                                veiculo.setMarca(rs.getString("marca"));
                                veiculo.setTipo(rs.getString("tipo"));
                                veiculo.setValor(rs.getDouble("valor"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return veiculo;
		
	}
	
	
	
}

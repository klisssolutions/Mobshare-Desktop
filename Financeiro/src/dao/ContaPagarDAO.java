package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ContaPagar;

public class ContaPagarDAO {
	
	private Connection con;
	private PreparedStatement stm;
	private ResultSet rs;
	public ArrayList<ContaPagar> listaContaPagar;

	
	public ContaPagarDAO() {
		con = new Conexao().getConexao();
		
	}
	
	public Boolean pagarConta(int idConta){
		Boolean result = true;
		
		String sql = "update conta_pagar set paga = 1 where idConta_Pagar = "+idConta;
		try {
			stm = con.prepareStatement(sql);
			stm.execute();
			
			
			result = true;
		} catch (SQLException e) {
		
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<ContaPagar> listarContaPagar(){
		
		
		listaContaPagar = new ArrayList<ContaPagar>();
		String sql = "select * from v_conta_pagar";
		try {
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				ContaPagar contaPagar = new ContaPagar();
				contaPagar.setIdConta_Pagar(rs.getInt("idConta_Pagar"));
				contaPagar.setValor(rs.getFloat("valor"));
				contaPagar.setNomeBanco(rs.getString("nomeBanco"));
				contaPagar.setVencimento(rs.getDate("vencimento"));
				contaPagar.setIdBanco(rs.getInt("idBanco"));
				
				//System.out.print(contaReceber.getNomeBanco());
				
				
				listaContaPagar.add(contaPagar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return listaContaPagar;
		
	}
	
	
public ArrayList<ContaPagar> listarSaida(){
		
		
		listaContaPagar = new ArrayList<ContaPagar>();
		String sql = "select * from v_saida";
		try {
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				ContaPagar contaPagar = new ContaPagar();
				contaPagar.setIdConta_Pagar(rs.getInt("idConta_Pagar"));
				contaPagar.setValor(rs.getFloat("valor"));
				contaPagar.setNomeBanco(rs.getString("nomeBanco"));
				contaPagar.setVencimento(rs.getDate("vencimento"));
				contaPagar.setIdBanco(rs.getInt("idBanco"));
				
				//System.out.print(contaReceber.getNomeBanco());
				
				
				listaContaPagar.add(contaPagar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return listaContaPagar;
		
	}

}

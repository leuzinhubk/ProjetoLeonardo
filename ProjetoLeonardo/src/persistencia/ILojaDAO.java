package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Loja;

public class ILojaDAO implements LojaDAO{

	private String inserir_loja = "insert into Loja(nome_loja, produto_loja, valor_loja) values(?,?,?)";
	private String remover_loja = "delete from Loja where id_loja = ?";
	private String atualizar_loja = 
			"update Loja set nome_loja = ?, produto_loja = ?, valor_loja = ? where id_loja = ?";
	private String buscar_todos_lojas = "select * from Loja";
	
	private Conexao conexao;
	
	public ILojaDAO()
	{
		conexao = new Conexao();
	}
	
	@Override
	public void gravar(Loja loja) {
		try
		{
			PreparedStatement stmt = conexao.getConexao().prepareStatement(inserir_loja);
			stmt.setString(1, loja.getNome());
			stmt.setString(2, loja.getProduto());
			stmt.setInt(3, loja.getValor());
			stmt.execute();
			stmt.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(Loja loja) {
		try
		{
			PreparedStatement stmt = conexao.getConexao().prepareStatement(remover_loja);
			stmt.setInt(1, loja.getId());
			stmt.execute();
			stmt.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Loja loja) {
		try
		{
			PreparedStatement stmt = conexao.getConexao().prepareStatement(atualizar_loja);
			stmt.setString(1, loja.getNome());
			stmt.setString(2, loja.getProduto());
			stmt.setInt(3, loja.getValor());
			stmt.setInt(4, loja.getId());
			stmt.execute();
			stmt.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Loja> fidAll() {
		List<Loja> lojas = new ArrayList<Loja>();
		try
		{
			PreparedStatement stmt = conexao.getConexao().prepareStatement(buscar_todos_lojas);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				Loja loja = new Loja();
				loja.setId(rs.getInt("id_loja"));
				loja.setProduto(rs.getString("produto_loja"));
				loja.setValor(rs.getInt("valor_loja"));
				loja.setNome(rs.getString("nome_loja"));
				lojas.add(loja);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return lojas;
	}

}

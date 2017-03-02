package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class IProdutoDAO implements ProdutoDAO{

	private String gravar_produto = 
			"insert into Produto(nome_produto) values (?)";
	private String buscar_todos_produtos =
			"select * from Produto order by nome_produto asc";
	private String atualizar_produto = 
			"update Produto set nome_produto = ? where id_produto = ?";
	private Conexao conexao;

	
	public  IProdutoDAO() {
		conexao = new Conexao();
	}
	
	@Override
	public void gravar(Produto produto) {
		try{
			PreparedStatement stmt = conexao.getConexao().prepareStatement(gravar_produto);
			stmt.setString(1, produto.getNome());
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void atualizar(Produto produto)
	{
		try{
			PreparedStatement stmt = conexao.getConexao().prepareStatement(atualizar_produto);
			stmt.setString(1, produto.getNome());
			stmt.setInt(2, produto.getId());
			stmt.execute();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Produto> findAll() {
		List<Produto> produtos = new ArrayList<Produto>();
		try{
			PreparedStatement stmt = conexao.getConexao().prepareStatement(buscar_todos_produtos);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Produto produto = new Produto();
				produto.setId(rs.getInt("id_produto"));
				produto.setNome(rs.getString("nome_produto"));
				
				produtos.add(produto);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return produtos;
	}

}

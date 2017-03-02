package persistencia;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Produto;

@Named
@SessionScoped
public class PersistenciaProduto implements Serializable{

	private static final long serialVersionUID = -1311403687871501692L;
	private ProdutoDAO produtoDAO;
	
	public PersistenciaProduto()
	{
		produtoDAO = new IProdutoDAO();
	}
	
	public void gravar(Produto produto)
	{
		produtoDAO.gravar(produto);
	}
	
	public List<Produto> findAll()
	{
		return produtoDAO.findAll();
	}
	
	public void atualizar(Produto produto)
	{
		produtoDAO.atualizar(produto);
	}
}

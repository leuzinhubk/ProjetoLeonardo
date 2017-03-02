package persistencia;

import java.util.List;

import model.Produto;

public interface ProdutoDAO {

	public void gravar(Produto produto);
	public void atualizar(Produto produto);
	public List<Produto> findAll();
}

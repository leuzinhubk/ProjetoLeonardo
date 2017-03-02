package persistencia;

import java.util.List;

import model.Loja;

public interface LojaDAO {

	public void gravar(Loja loja);
	public void remover(Loja loja);
	public void atualizar(Loja loja);
	public List<Loja> fidAll();
	
}

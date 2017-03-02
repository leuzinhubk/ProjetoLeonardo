package persistencia;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Loja;


@Named
@SessionScoped
public class PersistenciaLoja implements Serializable{

	private static final long serialVersionUID = -5870167184224703799L;
	private LojaDAO lojaDAO;
	
	public PersistenciaLoja()
	{
		lojaDAO = new ILojaDAO();
	}
	
	public void gravar(Loja loja)
	{
		lojaDAO.gravar(loja);
	}
	
	public void remover(Loja loja)
	{
		lojaDAO.remover(loja);
	}
	
	public void atualizar(Loja loja)
	{
		lojaDAO.atualizar(loja);
	}
	
	public List<Loja> findAll()
	{
		return lojaDAO.fidAll();
	}
}

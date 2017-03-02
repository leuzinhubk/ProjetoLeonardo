package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Loja;

@Named
@SessionScoped
public class LojaBean implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7567714482005272569L;
	private Loja loja;
	private boolean update;
	
	public LojaBean()
	{
		loja = new Loja();
		update = false;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}
	
	
	
}

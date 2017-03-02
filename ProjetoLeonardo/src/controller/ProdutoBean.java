package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Produto;

@Named
@SessionScoped
public class ProdutoBean implements Serializable{


	private static final long serialVersionUID = -7695368589915983088L;
	private Produto produto;
	private boolean update;
	
	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public ProdutoBean()
	{
		produto = new Produto();
		update = false;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}

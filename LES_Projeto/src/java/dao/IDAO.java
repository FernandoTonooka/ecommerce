package dao;

import java.util.List;

import domain.EntidadeDominio;

public interface IDAO {
	
	public void salvar(EntidadeDominio entidade);
	public void alterar(EntidadeDominio entidade);
	public void excluir(EntidadeDominio entidade);
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
}

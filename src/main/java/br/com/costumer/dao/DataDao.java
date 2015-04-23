package br.com.costumer.dao;

import java.util.List;

import br.com.costumer.model.Endereco;

public interface DataDao {

	public boolean addEntity(Endereco endereco) throws Exception;
	public Endereco getEntityById(long id) throws Exception;
	public Endereco getEntityByCEP(String cep) throws Exception;
	public List<Endereco> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	
}

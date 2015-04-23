package br.com.costumer.services;

import java.util.List;

import br.com.costumer.model.Endereco;

public interface DataServices {
	public boolean addEntity(Endereco endereco) throws Exception;
	public Endereco getEntityById(long id) throws Exception;
	public List<Endereco> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public Endereco getCEP(String cep) throws Exception;
}

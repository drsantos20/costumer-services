package br.com.costumer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.costumer.dao.DataDao;
import br.com.costumer.model.Endereco;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addEntity(Endereco endereco) throws Exception {
		return dataDao.addEntity(endereco);
	}

	@Override
	public Endereco getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Endereco> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

	@Override
	public Endereco getCEP(String cep) throws Exception {
		return dataDao.getEntityByCEP(cep);
	}

	@Override
	public boolean updateEntity(Endereco endereco) throws Exception {
		return dataDao.updateEntity(endereco);
	}

}

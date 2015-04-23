package br.com.costumer.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.costumer.model.Endereco;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Endereco endereco) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(endereco);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Endereco getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Endereco endereco = (Endereco) session.load(Endereco.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return endereco;
	}
	
	@Override
	public Endereco getEntityByCEP(String cep) throws Exception {
		Endereco endereco = null;
		session = sessionFactory.openSession();

		Query query = session.createQuery("from Endereco where cep = :cep ");
		query.setParameter("cep", cep);
		List<?> list = query.list();
		if(!list.isEmpty()){
			endereco = (Endereco) list.get(0);
		} else {
			int subs = cep.length();;
			for (int i = 0; i < cep.length(); i++) {
				cep = changeCharInPosition(subs-1, '0', cep);
				System.out.println(cep);
				subs=subs-1;
				
				query.setParameter("cep", cep);
				list = query.list();
				if(!list.isEmpty()){
					endereco = (Endereco) list.get(0);
					break;
				}
			}
		}
		
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return endereco;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Endereco> enderecoList = session.createCriteria(Endereco.class)
				.list();
		tx.commit();
		session.close();
		return enderecoList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Endereco.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
	
	public String changeCharInPosition(int position, char ch, String str){
	    char[] charArray = str.toCharArray();
	    charArray[position] = ch;
	    return new String(charArray);
	}

}

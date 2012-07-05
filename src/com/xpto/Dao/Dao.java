package com.xpto.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


public class Dao<T> {

	private final EntityManagerFactory entityManager = new JpaUtil().getFactory();
	private final EntityManager manager = entityManager.createEntityManager();
	private Class<T> classe;
	
	public Dao(Class<T> classe){
		
		super();
		this.classe=classe;
		
	}
	
	public void adicionar(T entity){
		manager.persist(entity);
	}
	
	public T atualiza(T entity){
		
		return manager.merge(entity);
		
	}
	
	public void remover( T entity){
		manager.remove(entity);
	}
	
	public List<T> buscarTodos(){
		Query query = manager.createQuery("Select e from"+ classe.getName()+" e");
		return query.getResultList();
	}
	
	public T buscarPorId(Long id){
		
		return manager.find(classe, id);
	}
}

package com.epam.jpa.task02.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.epam.jpa.task02.model.Client;

public class ClientDAO {
	public EntityManager em = Persistence.createEntityManagerFactory("dbconnect").createEntityManager();
	 
    public Client create(Client client){
        em.getTransaction().begin();
        Client clientFromDB = em.merge(client);
        em.getTransaction().commit();
        return clientFromDB;
    }
 
    public void delete(String id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }
 
    public Client get(String id){
        return em.find(Client.class, id);
    }
 
    public void update(Client client){
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
    }
 
    public List<Client> getAll(){
        TypedQuery<Client> namedQuery = em.createNamedQuery("client.getAll", Client.class);
        return namedQuery.getResultList();
    }
}

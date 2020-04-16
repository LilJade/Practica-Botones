package com.lilJade.DAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lilJade.model.*;

public class ProductoDao {
	
	Inventario inv = new Inventario();
	
	public List<Inventario> productoLista (){
		List<Inventario> listaInv = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("HIBERNATE_START_JPA");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			listaInv = em.createQuery("from Inventario").getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return listaInv;
	}
	
	public void agregarDatos(Inventario inv){
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("HIBERNATE_START_JPA");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(inv);
		em.flush();
		em.getTransaction().commit();
	}
	
	public void actualizarDatos(Inventario inv) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("HIBERNATE_START_JPA");
		em = emf.createEntityManager();
		
		inv.getId();
		inv.getNombreProducto();
		inv.getPrecioProducto();
		inv.getCantidadProducto();
		inv.getTotalProducto();
		
		em.getTransaction().begin();
		em.merge(inv);
		em.flush();
		em.getTransaction().commit();
	}
	
	public void eliminarDatos(Inventario inv){
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("HIBERNATE_START_JPA");
		em = emf.createEntityManager();
		
		inv = em.getReference(Inventario.class, inv.getId());
		em.getTransaction().begin();
		em.remove(inv);
		em.flush();
		em.getTransaction().commit();
	}

}

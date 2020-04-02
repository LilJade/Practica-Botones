package com.lilJade.controladorDeDatos;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lilJade.model.Inventario;

/**
 * Servlet implementation class servletControler
 */
public class servletControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String id = request.getParameter("Id");
		String nombrePr = request.getParameter("nProducto");
		String precioPr = request.getParameter("pProducto");
		String cantidadPr = request.getParameter("cProducto");
		String totalPr = request.getParameter("tProducto");
		
		Inventario inv = new Inventario();
		inv.setId(Integer.parseInt(id));
		//inv.setNombreProducto(nombrePr);
		//inv.setPrecioProducto(Double.parseDouble(precioPr));
		//inv.setCantidadProducto(Integer.parseInt(cantidadPr));
		//inv.setTotalProducto(Double.parseDouble(totalPr));
		
		EntityManager em;
		EntityManagerFactory emf;
		
		emf = Persistence.createEntityManagerFactory("HIBERNATE_START_JPA");
		em = emf.createEntityManager();
		em.getTransaction().begin();

		//Agregar
		//em.persist(inv);
		
		//Editar
		//em.merge(inv);
		
		//Eliminar
		inv = em.getReference(Inventario.class, inv.getId());
		em.remove(inv);
		em.flush();
		em.getTransaction().commit();
		
		response.sendRedirect("index.jsp");
	}

}

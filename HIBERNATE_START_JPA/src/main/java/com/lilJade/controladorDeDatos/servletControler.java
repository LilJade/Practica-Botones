package com.lilJade.controladorDeDatos;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lilJade.DAO.ProductoDao;
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
		Inventario inv = new Inventario();
		ProductoDao prdD = new ProductoDao();

		String id = null;
		String nombrePr = null;
		String precioPr = null;
		String cantidadPr = null;
		String totalPr = null;
		try {
			id = request.getParameter("Id");
			nombrePr = request.getParameter("nProducto");
			precioPr = request.getParameter("pProducto");
			cantidadPr = request.getParameter("cProducto");
			totalPr = request.getParameter("tProducto");
			
			inv.setId(Integer.parseInt(id));
			inv.setNombreProducto(nombrePr);
			inv.setPrecioProducto(Double.parseDouble(precioPr));
			inv.setCantidadProducto(Integer.parseInt(cantidadPr));
			inv.setTotalProducto(Double.parseDouble(totalPr));
		} catch (Exception e) {
		}
		
		String acttion = request.getParameter("btn");
		
		if(acttion.equals("GUARDAR")){
			inv.setId(Integer.parseInt(id));
			inv.setNombreProducto(nombrePr);
			inv.setPrecioProducto(Double.parseDouble(precioPr));
			inv.setCantidadProducto(Integer.parseInt(cantidadPr));
			inv.setTotalProducto(Double.parseDouble(totalPr));
			
			prdD.agregarDatos(inv);
		} else if(acttion.equals("ACTUALIZAR")) {
			inv.setId(Integer.parseInt(id));
			inv.setNombreProducto(nombrePr);
			inv.setPrecioProducto(Double.parseDouble(precioPr));
			inv.setCantidadProducto(Integer.parseInt(cantidadPr));
			inv.setTotalProducto(Double.parseDouble(totalPr));
			
			prdD.actualizarDatos(inv);
		} else if(acttion.equals("ELIMINAR")){
			inv.setId(Integer.parseInt(id));
			prdD.eliminarDatos(inv);
		}
		
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoDao invDao = new ProductoDao();
		Gson json = new Gson();
		
		try {
			response.getWriter().append(json.toJson(invDao.productoLista()));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

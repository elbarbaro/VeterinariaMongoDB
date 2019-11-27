package com.barbaro.mongodbperro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barbaro.mongodbperro.db.DatabaseManager;
import com.barbaro.mongodbperro.model.Perro;


@WebServlet("/perro/actualizar")
public class ActualizarPerroController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String txtId = null;
		Perro perro = null;
		DatabaseManager dbManager = null;
		RequestDispatcher dispatcher = null;

		txtId = req.getParameter("id");
		dbManager = new DatabaseManager();
		perro = dbManager.getPerro(txtId);
		if(perro != null) {
			req.setAttribute("action", getServletContext().getContextPath() + "/perro/actualizar");
			req.setAttribute("message", "Actualizar");
			req.setAttribute("perro", perro);
			dispatcher = req.getRequestDispatcher("/formPerro.jsp");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("error", "No se encontro");
			dispatcher = req.getRequestDispatcher("/error.jsp"); // TODO IMPLEMENTAR
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String nombre = req.getParameter("nombre");
		Integer edad = Integer.parseInt(req.getParameter("edad"));
		Float peso = Float.parseFloat(req.getParameter("peso"));
		String color = req.getParameter("color");
		String raza = req.getParameter("raza");
		Boolean estaVivo = req.getParameter("estaVivo").equals("1")?true:false;
		//  TODO Recuperar el radio de estaVivo
		
		Perro perro = new Perro();
		perro.setNombre(nombre);
		perro.setColor(color);
		perro.setEdad(edad);
		perro.setRaza(raza);
		perro.setPeso(peso);
		perro.setEstaVivo(estaVivo); // TODO CAMBIAR
		
		DatabaseManager dbManager = new DatabaseManager();
		dbManager.updatePerro(id, perro);
		
		req.setAttribute("success", true);
		req.setAttribute("message", "Perro actualizado");
		req.getRequestDispatcher(getServletContext().getContextPath()).forward(req, resp);
	}
}

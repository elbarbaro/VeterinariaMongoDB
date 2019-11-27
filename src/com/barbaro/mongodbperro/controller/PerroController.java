package com.barbaro.mongodbperro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barbaro.mongodbperro.db.DatabaseManager;
import com.barbaro.mongodbperro.model.Perro;


@WebServlet("/perro")
public class PerroController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("action", "perro");
		req.setAttribute("message", "Agregar");
		req.getRequestDispatcher("formPerro.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Integer edad = Integer.parseInt(req.getParameter("edad"));
		Float peso = Float.parseFloat(req.getParameter("peso"));
		String color = req.getParameter("color");
		String raza = req.getParameter("raza");
		
		Perro perro = new Perro();
		perro.setNombre(nombre);
		perro.setColor(color);
		perro.setEdad(edad);
		perro.setRaza(raza);
		perro.setPeso(peso);
		perro.setEstaVivo(true);
		
		DatabaseManager dbManager = new DatabaseManager();
		dbManager.addPerro(perro);
		
		req.setAttribute("success", true);
		req.setAttribute("message", "Perro agregado");
		req.getRequestDispatcher(getServletContext().getContextPath())
			.forward(req, resp);
	}
}

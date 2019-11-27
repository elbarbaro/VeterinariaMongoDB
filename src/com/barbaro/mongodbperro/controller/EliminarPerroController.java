package com.barbaro.mongodbperro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barbaro.mongodbperro.db.DatabaseManager;


@WebServlet("/perro/eliminar")
public class EliminarPerroController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String txtId = null;
		DatabaseManager dbManager = null;
		RequestDispatcher dispatcher = null;
		
		txtId = req.getParameter("txtId");
		dbManager = new DatabaseManager();
		dbManager.deletePerro(txtId);
		
		req.setAttribute("success", true);
		req.setAttribute("message", "Perro eliminado");
		dispatcher = req.getRequestDispatcher(getServletContext().getContextPath());
		dispatcher.forward(req, resp);
		
		// TODO IMPLEMENTAR EL FLUJO DE ERROR
	}
}

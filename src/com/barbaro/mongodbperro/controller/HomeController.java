package com.barbaro.mongodbperro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barbaro.mongodbperro.db.DatabaseManager;
import com.barbaro.mongodbperro.model.Perro;


@WebServlet("/")
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Perro> listPerros = null;
		DatabaseManager dbManager = null;
		RequestDispatcher dispatcher = null;
		
		dbManager = new DatabaseManager();
		listPerros = dbManager.getPerros();
		req.setAttribute("listPerros", listPerros);
		dispatcher = req.getRequestDispatcher("home.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Redirigir a cargar la vista con datos en sesion
		doGet(req, resp);
	}
}

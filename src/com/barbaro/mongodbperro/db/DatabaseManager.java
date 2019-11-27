package com.barbaro.mongodbperro.db;

import com.barbaro.mongodbperro.model.Perro;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class DatabaseManager {
	
	public void addPerro(Perro perro) {
		
		MongoClient client = MongoClients.create();
		MongoDatabase myDb = client.getDatabase("veterinaria");
		MongoCollection<Document> perrosCollection
										= myDb.getCollection("perros");
		
		// Preparando los datos en un modelo
		Document perroDoc = new Document("nombre", perro.getNombre())
				.append("edad", perro.getEdad())
				.append("color", perro.getColor())
				.append("raza", perro.getRaza())
				.append("peso", perro.getPeso())
				.append("estaVivo", perro.isEstaVivo());
		
		// Aqui se hace la inserción del documento
		perrosCollection.insertOne(perroDoc);
		
		client.close();
	}
	
	public List<Perro> getPerros(){
		
		MongoClient client = MongoClients.create();
		MongoDatabase myDb = client.getDatabase("veterinaria");
		MongoCollection<Document> perrosCollection
										= myDb.getCollection("perros");
		
		List<Perro> listPerros = new ArrayList<>();
		MongoCursor<Document> iterator = perrosCollection.find().iterator();
		while(iterator.hasNext()) {
			Document doc = iterator.next();
			Perro perro = new Perro();
			perro.setNombre(doc.getString("nombre"));
			perro.setEdad(doc.getInteger("edad"));
			perro.setColor(doc.getString("color"));
			perro.setPeso(doc.getDouble("peso").floatValue());
			perro.setEstaVivo(doc.getBoolean("estaVivo"));
			perro.setRaza(doc.getString("raza"));
			listPerros.add(perro);
		}
		
		client.close();
		return listPerros;
	}
}

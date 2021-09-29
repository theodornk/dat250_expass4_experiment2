package no.hvl.dat110.rest.counters;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.put;
import static spark.Spark.delete;
import static spark.Spark.post;

import com.google.gson.Gson;

import java.util.*;


public class App {

	public static void main(String[] args) {

		HashMap<Integer, Todo> todosMap = new HashMap<Integer, Todo>();

		if (args.length > 0) {
			port(Integer.parseInt(args[0]));
		} else {
			port(8080);
		}


		after((req, res) -> {
  		  res.type("application/json");
  		});

		get("/todo/:id", (req, res) -> {
			Gson gson = new Gson();
			return todosMap.get(Integer.parseInt(req.params("id"))).toJson();
		});

		get("/todo", (req,res) -> {
			Gson gson = new Gson();
			return gson.toJson(todosMap);
		});

		put("/todo/:id", (req,res) -> {
			Gson gson = new Gson();
			todosMap.put(Integer.parseInt(req.params("id")), gson.fromJson(req.body(), Todo.class));
			return todosMap.get(Integer.parseInt(req.params("id"))).toJson();
		});

		post("/todo", (req,res) -> {
			Gson gson = new Gson();
			todosMap.put(todosMap.size(), gson.fromJson(req.body(), Todo.class));
			return "K";
		});

		delete("/todo/:id", (req, res) -> {
			Gson gson = new Gson();
			todosMap.remove(Integer.parseInt(req.params("id")));
			return gson.toJson(todosMap);
		});


    }
    
}

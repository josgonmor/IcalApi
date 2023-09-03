package net.josgonmor.ws;

import java.util.ArrayList;


import com.google.gson.Gson;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("/json")
public class ApiManager {

	private static boolean initEvents = false;
	private static boolean initTodos = false;
	private static boolean initCal = false;
	// Return all Events instances
	@Path("/all-events")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendAllEvents() {
		if(initCal==false) {
			IcalManager.loadCalendar();
			initCal=true;
		}
		if(initEvents==false) {
			IcalManager.loadEvents();
			initEvents=true;
		}
		Gson gson = new Gson();
		ArrayList<Eventos> events = IcalManager.returnEventos();
		String jsonString = gson.toJson(events);
		return Response.status(Response.Status.OK).entity(jsonString).build();
	}
	
	// Return all Todos instances
	@Path("/all-todos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendAllTodos() {
		if(initCal==false) {
			IcalManager.loadCalendar();
			initCal=true;
		}
		if(initTodos==false) {
			IcalManager.loadTodos();
			initTodos=true;
		}
		Gson gson = new Gson();
		ArrayList<Todos> todos = IcalManager.returnTodos();
		String jsonString = gson.toJson(todos);
		return Response.status(Response.Status.OK).entity(jsonString).build();
	}
		
		
	
	
	
	
	
}

package com.studentData.curd.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentData.curd.model.crudmodel;
import com.studentData.curd.service.crudservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class crudresource {
	
	crudservice service = new crudservice();
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel addSTUDENT(crudmodel STUDENT) {
		 return service.insertSTUDENT(STUDENT);
		
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel>  getSTUDENT() throws SQLException {
		 return service.getSTUDENT();
		
	}
	
	@Path("/retrieveById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel>  getSTUDENT(@PathParam("id") int id) throws SQLException {
		return service.getSTUDENTById(id);
		
	}
	

	
	@Path("/updateUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel updateSTUDENT(crudmodel STUDENT) {
		 return service.updatetSTUDENT(STUDENT);
		
	}
	
	@Path("/deleteUserById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteSTUDENT(@PathParam("id") int id) {
		return service.deletetSTUDENT(id);
		
	}

	
	
}

package sonvh.webservice.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sonvh.webservice.entity.Group;
import sonvh.webservice.entity.Groups;

@Path("/ws")
public class Service {

	Groups listGroup = new Groups();

	// http://localhost:8740/RESTfulExample/rest/ws/get (with GET method)
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Group getGroup() {

		Group group = new Group();
		group.setId(1);
		group.setName("Metallica");

		return group;

	}

	// http://localhost:8740/RESTfulExample/rest/ws/getList (with POST method)
	@POST
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Group> getListGroups() {

		return listGroup.getGroups();
	}

	@POST
	@Path("/getGroupByID/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Group getGroupByID(@DefaultValue("2") @PathParam("id") int id) {

		return listGroup.findUser_byID(id);
	}

	@POST
	@Path("/updateGroup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateGroup(Group group) {

		boolean result = listGroup.updateGroup(group);
		return Response.ok().entity(String.valueOf(result)).build();
	}

	@POST
	@Path("/addGroup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createGroup(Group group) {

		boolean result = listGroup.addGroup(group);
		return Response.ok().entity(String.valueOf(result)).build();
	}

}
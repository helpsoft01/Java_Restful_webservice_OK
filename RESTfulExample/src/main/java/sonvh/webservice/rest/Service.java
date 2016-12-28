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

import sonvh.webservice.entity.Product;
import sonvh.webservice.entity.Products;
import sonvh.webservice.entity.ResultMessage;

@Path("/ws")
public class Service {

	static Products listGroup;

	public Service() {
		// TODO Auto-generated constructor stub
		if (listGroup == null)
			listGroup = new Products();
	}

	// http://localhost:8740/RESTfulExample/rest/ws/get (with GET method)
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getGroup() {

		Product group = new Product();
		group.setId(1);
		group.setName("Metallica");

		return group;

	}

	// http://localhost:8740/RESTfulExample/rest/ws/getList (with POST method)
	@POST
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getListGroups() {

		return listGroup.getGroups();
	}

	// http://localhost:8740/RESTfulExample/rest/ws/getGroupByID/2
	@POST
	@Path("/getGroupByID/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Product getGroup_ByID(@DefaultValue("2") @PathParam("id") int id) {

		return listGroup.findUser_byID(id);
	}
	@POST
	@Path("/getGroupByName/{name}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getGroup_ByName(@DefaultValue("") @PathParam("name") String name) {

		return listGroup.findUser_byName(name);
	}

	@POST
	@Path("/updateGroup_plain")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateGroup(Product group) {

		boolean result = listGroup.updateGroup(group);
		return Response.ok().entity(String.valueOf(result)).build();
	}

	@POST
	@Path("/updateGroup_Json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultMessage updateGroup_resultJson(Product group) {

		boolean flag = listGroup.updateGroup(group);
		ResultMessage result = new ResultMessage();
		result.setFlag(flag);
		return result;
	}

	@POST
	@Path("/addGroup_plain")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createGroup_resultBoolean(Product group) {

		boolean result = listGroup.addGroup(group);
		return Response.ok().entity(String.valueOf(result)).build();
	}

	@POST
	@Path("/addGroup_Json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultMessage createGroup_resultJson(Product group) {

		boolean flag = listGroup.addGroup(group);
		ResultMessage result = new ResultMessage();
		result.setFlag(flag);

		return result;
	}
}
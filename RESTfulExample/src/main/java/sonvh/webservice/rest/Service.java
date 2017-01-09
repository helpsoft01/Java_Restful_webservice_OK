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

	static Products listProducts;

	public Service() {
		// TODO Auto-generated constructor stub
		if (listProducts == null)
			listProducts = new Products();
	}

	// http://localhost:8740/RESTfulExample/rest/ws/get (with GET method)
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct() {

		Product prod = new Product();
		prod.setId(1);
		prod.setName("Metallica");

		return prod;

	}

	// http://localhost:8740/RESTfulExample/rest/ws/getList (with POST method)
	@POST
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getListProducts() {

		return listProducts.getList();
	}

	// http://localhost:8740/RESTfulExample/rest/ws/getGroupByID/2
	@POST
	@Path("/get_ByID/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Product get_ByID(@DefaultValue("2") @PathParam("id") int id) {

		return listProducts.find_byID(id);
	}
	@POST
	@Path("/get_ByName/{name}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> get_ByName(@DefaultValue("") @PathParam("name") String name) {

		return listProducts.find_byName(name);
	}

	@POST
	@Path("/update_plain")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response update_resultPlain(Product prod) {

		boolean result = listProducts.update(prod);
		return Response.ok().entity(String.valueOf(result)).build();
	}

	@POST
	@Path("/update_Json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultMessage update_resultJson(Product prod) {

		boolean flag = listProducts.update(prod);
		ResultMessage result = new ResultMessage();
		result.setFlag(flag);
		return result;
	}

	@POST
	@Path("/add_plain")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response create_resultBoolean(Product prod) {

		boolean result = listProducts.add(prod);
		return Response.ok().entity(String.valueOf(result)).build();
	}

	@POST
	@Path("/add_Json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultMessage create_resultJson(Product prod) {

		boolean flag = listProducts.add(prod);
		ResultMessage result = new ResultMessage();
		result.setFlag(flag);

		return result;
	}
}
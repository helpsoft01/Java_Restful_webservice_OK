package sonvh.webservice.entity;

import java.util.Date;

public class Product {

	int id;
	String name;
	Date createDate;
	double price;
	boolean active;

	public Product() {
		// TODO Auto-generated constructor stub
		createDate=new Date();
		active=true;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}

}

package erp.module.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_City {

	@Column(name = "city_id")
	private int city_id;
	
	@Column(name = "state_id")
	private int state_id;
	
	@Column(name = "city_name")
	private String city_name;
	
	@Column(name = "zipcode")
	private String zipcode;

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}

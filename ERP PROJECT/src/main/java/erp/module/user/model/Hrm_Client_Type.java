package erp.module.user.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Hrm_Client_Type {

	@Column(name = "client_type_id")
	private String client_type_id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "create_time")
	private Date create_time;
	
	@Column(name = "update_time")
	private Date update_time;

	public String getClient_type_id() {
		return client_type_id;
	}

	public void setClient_type_id(String client_type_id) {
		this.client_type_id = client_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
}

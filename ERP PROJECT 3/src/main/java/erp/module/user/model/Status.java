package erp.module.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Status {

	@Column(name = "status_id")
	private String status_id;
	
	@Column(name = "description")
	private String description;

	public String getStatus_id() {
		return status_id;
	}

	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

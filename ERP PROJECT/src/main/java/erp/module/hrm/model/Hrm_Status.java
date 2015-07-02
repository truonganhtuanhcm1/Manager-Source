package erp.module.hrm.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_Status {
	
	@Column(name = "status_id")
	private int status_id;
	
	@Column(name = "status_name")
	private String status_name;
	
	@Column(name = "is_other")
	private boolean is_other;
	
	@Column(name = "create_time")
	private Timestamp create_time;
	
	@Column(name = "create_user")
	private String create_user;
	
	@Column(name = "update_time")
	private Timestamp update_time;
	
	@Column(name = "update_user")
	private String update_user;
	
	@Column(name = "is_deleted")
	private boolean is_deleted;

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	public boolean isIs_other() {
		return is_other;
	}

	public void setIs_other(boolean is_other) {
		this.is_other = is_other;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	
}

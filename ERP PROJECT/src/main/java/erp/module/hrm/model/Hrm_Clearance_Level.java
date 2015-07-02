package erp.module.hrm.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_Clearance_Level {

	@Column(name = "clearance_lv_id")
	private int clearance_lv_id;
	
	@Column(name = "clearance_lv_name")
	private String clearance_lv_name;
	
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

	public int getClearance_lv_id() {
		return clearance_lv_id;
	}

	public void setClearance_lv_id(int clearance_lv_id) {
		this.clearance_lv_id = clearance_lv_id;
	}

	public String getClearance_lv_name() {
		return clearance_lv_name;
	}

	public void setClearance_lv_name(String clearance_lv_name) {
		this.clearance_lv_name = clearance_lv_name;
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

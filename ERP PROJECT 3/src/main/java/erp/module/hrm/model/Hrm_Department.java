package erp.module.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_Department {
	
	@Column(name = "department_id")
	private int department_id;
	
	@Column(name = "department_name")
	private String department_name;
	
	@Column(name = "is_deleted")
	private boolean is_deleted;

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
}

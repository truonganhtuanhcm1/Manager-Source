package erp.module.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_Work_Time {
	
	@Column(name = "work_time_id")
	private int work_time_id;
	
	@Column(name = "work_time_name")
	private String work_time_name;
	
	@Column(name = "is_deleted")
	private boolean is_deleted;

	public int getWork_time_id() {
		return work_time_id;
	}

	public void setWork_time_id(int work_time_id) {
		this.work_time_id = work_time_id;
	}

	public String getWork_time_name() {
		return work_time_name;
	}

	public void setWork_time_name(String work_time_name) {
		this.work_time_name = work_time_name;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	
}

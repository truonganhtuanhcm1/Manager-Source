package erp.module.hrm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_RecruitmentType {
	
	@Column(name = "recruitment_type_id")
	private int recruitment_type_id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "create_time")
	private Date create_time;
	
	public int getRecruitment_type_id() {
		return recruitment_type_id;
	}

	public void setRecruitment_type_id(int recruitment_type_id) {
		this.recruitment_type_id = recruitment_type_id;
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

	@Column(name = "update_time")
	private Date update_time;
	


}

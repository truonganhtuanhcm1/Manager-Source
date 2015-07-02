package erp.module.user.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Permission {
	
	@Column(name = "permission_id")
	private String  permission_id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "create_time")
	private Date  create_time;
	
	@Column(name = "update_time")
	private Date  update_time;
	
	@Column(name = "applied")
	private String  applied;

	public String getApplied() {
		return applied;
	}

	public void setApplied(String applied) {
		this.applied = applied;
	}

	public String getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(String permission_id) {
		this.permission_id = permission_id;
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

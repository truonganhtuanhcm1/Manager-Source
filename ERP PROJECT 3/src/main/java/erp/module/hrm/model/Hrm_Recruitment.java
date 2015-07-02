package erp.module.hrm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_Recruitment {

	@Column(name = "recruitment_id")
	private int recruitment_id;
	
	@Column(name = "client_id_position")
	private int client_id_position;
	
	@Column(name = "client_id_position_name")
	private String client_id_position_name;
	
	@Column(name = "recruitment_type_id")
	private int recruitment_type_id;
	
	@Column(name = "recruitment_type_name")
	private String recruitment_type_name;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "job_description")
	private String job_description;
	
	@Column(name = "job_recruitment")
	private String job_recruitment;
	
	@Column(name = "enable")
	private boolean enable;
	
	@Column(name = "expired_date")
	private Date expired_date;
	
	@Column(name = "create_time")
	private Date create_time;
	
	@Column(name = "update_time")
	private Date update_time;
	
	@Column(name = "create_user")
	private String create_user;
	
	public int getRecruitment_id() {
		return recruitment_id;
	}

	public void setRecruitment_id(int recruitment_id) {
		this.recruitment_id = recruitment_id;
	}

	public int getClient_id_position() {
		return client_id_position;
	}

	public void setClient_id_position(int client_id_position) {
		this.client_id_position = client_id_position;
	}

	public String getClient_id_position_name() {
		return client_id_position_name;
	}

	public void setClient_id_position_name(String client_id_position_name) {
		this.client_id_position_name = client_id_position_name;
	}

	public int getRecruitment_type_id() {
		return recruitment_type_id;
	}

	public void setRecruitment_type_id(int recruitment_type_id) {
		this.recruitment_type_id = recruitment_type_id;
	}

	public String getRecruitment_type_name() {
		return recruitment_type_name;
	}

	public void setRecruitment_type_name(String recruitment_type_name) {
		this.recruitment_type_name = recruitment_type_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public String getJob_recruitment() {
		return job_recruitment;
	}

	public void setJob_recruitment(String job_recruitment) {
		this.job_recruitment = job_recruitment;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Date getExpired_date() {
		return expired_date;
	}

	public void setExpired_date(Date expired_date) {
		this.expired_date = expired_date;
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

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	@Column(name = "update_user")
	private String update_user;
}

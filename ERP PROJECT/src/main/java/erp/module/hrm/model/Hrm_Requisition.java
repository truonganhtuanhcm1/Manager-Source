package erp.module.hrm.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_Requisition {
	
	@Column(name = "requisition_id")
	private int requisition_id;
	
	@Column(name = "requisition_id_input")
	private String requisition_id_input;
	
	@Column(name = "contract_id")
	private int contract_id;
	
	@Column(name = "contract_name")
	private String contract_name;
	
	@Column(name = "contract_number")
	private String contract_number;
	
	@Column(name = "requester")
	private String requester;
	
	@Column(name = "position_id")
	private int position_id;
	
	@Column(name = "position_title")
	private String position_title;
		
	@Column(name = "required_date")
	private Timestamp required_date;
	
	@Column(name = "status_id")
	private int status_id;

	@Column(name = "salary_range")
	private String salary_range;

	@Column(name = "clearance_lv_id")
	private int clearance_lv_id;
	
	@Column(name = "certificate_req")
	private String certificate_req;
	
	@Column(name = "education_id")
	private int education_id;
	
	@Column(name = "education_other")
	private String education_other;
	
	@Column(name = "street")
	private String street;
		
	@Column(name = "city_name")
	private String city_name;
	
	@Column(name = "state_id")
	private int state_id;
	
	@Column(name = "country_id")
	private int country_id;
	
	@Column(name = "attachment")
	private String attachment;
	
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

	public String getRequisition_id_input() {
		return requisition_id_input;
	}

	public void setRequisition_id_input(String requisition_id_input) {
		this.requisition_id_input = requisition_id_input;
	}

	public int getRequisition_id() {
		return requisition_id;
	}

	public void setRequisition_id(int requisition_id) {
		this.requisition_id = requisition_id;
	}

	public int getContract_id() {
		return contract_id;
	}

	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	public Timestamp getRequired_date() {
		return required_date;
	}

	public void setRequired_date(Timestamp required_date) {
		this.required_date = required_date;
	}

	public int getClearance_lv_id() {
		return clearance_lv_id;
	}

	public void setClearance_lv_id(int clearance_lv_id) {
		this.clearance_lv_id = clearance_lv_id;
	}

	public String getCertificate_req() {
		return certificate_req;
	}

	public void setCertificate_req(String certificate_req) {
		this.certificate_req = certificate_req;
	}

	public int getEducation_id() {
		return education_id;
	}

	public void setEducation_id(int education_id) {
		this.education_id = education_id;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
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

	public String getPosition_title() {
		return position_title;
	}

	public void setPosition_title(String position_title) {
		this.position_title = position_title;
	}

	public String getSalary_range() {
		return salary_range;
	}

	public void setSalary_range(String salary_range) {
		this.salary_range = salary_range;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}

	public String getContract_number() {
		return contract_number;
	}

	public void setContract_number(String contract_number) {
		this.contract_number = contract_number;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getEducation_other() {
		return education_other;
	}

	public void setEducation_other(String education_other) {
		this.education_other = education_other;
	}

}

package erp.module.hrm.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_Candidate_Tracker {

	@Column(name = "candidate_tracker_id")
	private int candidate_tracker_id;
	
	@Column(name = "candidate_tracker_id_input")
	private String candidate_tracker_id_input;
	
	@Column(name = "contract_id")
	private int contract_id;
	
	@Column(name = "requisition_id")
	private int requisition_id;
	
	@Column(name = "requisition_id_input")
	private String requisition_id_input;
	
	@Column(name = "state_id")
	private int state_id;
	
	@Column(name = "country_id")
	private int country_id;
	
	@Column(name = "status_id")
	private int status_id;
	
	@Column(name = "status_name")
	private String status_name;
	
	@Column(name = "clearance_lv_id")
	private int clearance_lv_id;
	
	@Column(name = "education_id")
	private int education_id;
	
	@Column(name = "education_other")
	private String education_other;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "mid_name")
	private String mid_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "status_other")
	private String status_other;
	
	@Column(name = "job_location")
	private String job_location;
	
	@Column(name = "refered_location")
	private String refered_location;
	
	@Column(name = "salary_range")
	private String salary_range;
	
	@Column(name = "experience")
	private String experience;
	
	@Column(name = "email_type")
	private int email_type;
	
	@Column(name = "email_first")
	private String email_first;
	
	@Column(name = "email_second")
	private String email_second;
	
	@Column(name = "email_third")
	private String email_third;
	
	@Column(name = "phone_first")
	private String phone_first;
	
	@Column(name = "phone_second")
	private String phone_second;
	
	@Column(name = "phone_third")
	private String phone_third;
	
	@Column(name = "email_date_type")
	private int email_date_type;
	
	@Column(name = "email_date")
	private Timestamp email_date;
	
	@Column(name = "call_date_type")
	private int call_date_type;
	
	@Column(name = "call_date")
	private Timestamp call_date;
	
	@Column(name = "phone_screen_date")
	private Timestamp phone_screen_date;
	
	@Column(name = "candidate_comment")
	private String candidate_comment;
	
	@Column(name = "dvs_comment")
	private String dvs_comment;
	
	@Column(name = "position_id")
	private int position_id;
	
	@Column(name = "position_title")
	private String position_title;
	
	@Column(name = "alt_position")
	private String alt_position;
	
	@Column(name = "best_time_contact")
	private String best_time_contact;
	
	@Column(name = "certification")
	private String certification;
	
	@Column(name = "q_qualification")
	private String q_qualification; 
	
	@Column(name = "q_background")
	private String q_background;
	
	@Column(name = "q_technical_skill")
	private String q_technical_skill;
	
	@Column(name = "q_expected_salary")
	private String q_expected_salary;
	
	@Column(name = "q_communication")
	private String q_communication;
	
	@Column(name = "q_initiative")
	private String q_initiative;
	
	@Column(name = "available_start_date")
	private Timestamp available_start_date;
	
	@Column(name = "question1")
	private String question1;
	
	@Column(name = "question2")
	private String question2;
	
	@Column(name = "question3")
	private String question3;
	
	@Column(name = "question4")
	private String question4;
	
	@Column(name = "question5")
	private String question5;
	
		@Column(name = "description1")
	private String description1;
	
	@Column(name = "description2")
	private String description2;
	
	@Column(name = "description3")
	private String description3;
	
	@Column(name = "description4")
	private String description4;
	
	@Column(name = "description5")
	private String description5;
	
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
	
	@Column(name = "delete_time")
	private Timestamp delete_time;
	
	@Column(name = "delete_user")
	private String delete_user;
	
	@Column(name = "is_deleted")
	private boolean is_deleted;

	public int getCandidate_tracker_id() {
		return candidate_tracker_id;
	}

	public void setCandidate_tracker_id(int candidate_tracker_id) {
		this.candidate_tracker_id = candidate_tracker_id;
	}

	public int getRequisition_id() {
		return requisition_id;
	}

	public void setRequisition_id(int requisition_id) {
		this.requisition_id = requisition_id;
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

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getClearance_lv_id() {
		return clearance_lv_id;
	}

	public void setClearance_lv_id(int clearance_lv_id) {
		this.clearance_lv_id = clearance_lv_id;
	}

	public int getEducation_id() {
		return education_id;
	}

	public void setEducation_id(int education_id) {
		this.education_id = education_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMid_name() {
		return mid_name;
	}

	public void setMid_name(String mid_name) {
		this.mid_name = mid_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus_other() {
		return status_other;
	}

	public void setStatus_other(String status_other) {
		this.status_other = status_other;
	}

	public String getJob_location() {
		return job_location;
	}

	public void setJob_location(String job_location) {
		this.job_location = job_location;
	}

	public String getRefered_location() {
		return refered_location;
	}

	public void setRefered_location(String refered_location) {
		this.refered_location = refered_location;
	}

	public String getSalary_range() {
		return salary_range;
	}

	public void setSalary_range(String salary_range) {
		this.salary_range = salary_range;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getEmail_type() {
		return email_type;
	}

	public void setEmail_type(int email_type) {
		this.email_type = email_type;
	}

	public int getEmail_date_type() {
		return email_date_type;
	}

	public void setEmail_date_type(int email_date_type) {
		this.email_date_type = email_date_type;
	}

	public Timestamp getEmail_date() {
		return email_date;
	}

	public void setEmail_date(Timestamp email_date) {
		this.email_date = email_date;
	}

	public int getCall_date_type() {
		return call_date_type;
	}

	public void setCall_date_type(int call_date_type) {
		this.call_date_type = call_date_type;
	}

	public Timestamp getCall_date() {
		return call_date;
	}

	public void setCall_date(Timestamp call_date) {
		this.call_date = call_date;
	}

	public Timestamp getPhone_screen_date() {
		return phone_screen_date;
	}

	public void setPhone_screen_date(Timestamp phone_screen_date) {
		this.phone_screen_date = phone_screen_date;
	}

	public String getCandidate_comment() {
		return candidate_comment;
	}

	public void setCandidate_comment(String candidate_comment) {
		this.candidate_comment = candidate_comment;
	}

	public String getDvs_comment() {
		return dvs_comment;
	}

	public void setDvs_comment(String dvs_comment) {
		this.dvs_comment = dvs_comment;
	}

	public String getAlt_position() {
		return alt_position;
	}

	public void setAlt_position(String alt_position) {
		this.alt_position = alt_position;
	}

	public String getBest_time_contact() {
		return best_time_contact;
	}

	public void setBest_time_contact(String best_time_contact) {
		this.best_time_contact = best_time_contact;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getQ_qualification() {
		return q_qualification;
	}

	public void setQ_qualification(String q_qualification) {
		this.q_qualification = q_qualification;
	}

	public String getQ_background() {
		return q_background;
	}

	public void setQ_background(String q_background) {
		this.q_background = q_background;
	}

	public String getQ_technical_skill() {
		return q_technical_skill;
	}

	public void setQ_technical_skill(String q_technical_skill) {
		this.q_technical_skill = q_technical_skill;
	}

	public String getQ_expected_salary() {
		return q_expected_salary;
	}

	public void setQ_expected_salary(String q_expected_salary) {
		this.q_expected_salary = q_expected_salary;
	}

	public String getQ_communication() {
		return q_communication;
	}

	public void setQ_communication(String q_communication) {
		this.q_communication = q_communication;
	}

	public String getQ_initiative() {
		return q_initiative;
	}

	public void setQ_initiative(String q_initiative) {
		this.q_initiative = q_initiative;
	}

	public Timestamp getAvailable_start_date() {
		return available_start_date;
	}

	public void setAvailable_start_date(Timestamp available_start_date) {
		this.available_start_date = available_start_date;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
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

	public Timestamp getDelete_time() {
		return delete_time;
	}

	public void setDelete_time(Timestamp delete_time) {
		this.delete_time = delete_time;
	}

	public String getDelete_user() {
		return delete_user;
	}

	public void setDelete_user(String delete_user) {
		this.delete_user = delete_user;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public String getRequisition_id_input() {
		return requisition_id_input;
	}

	public void setRequisition_id_input(String requisition_id_input) {
		this.requisition_id_input = requisition_id_input;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	public String getDescription1() {
		return description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public String getDescription3() {
		return description3;
	}

	public void setDescription3(String description3) {
		this.description3 = description3;
	}

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	public String getPosition_title() {
		return position_title;
	}

	public void setPosition_title(String position_title) {
		this.position_title = position_title;
	}
	
	public String getQuestion4() {
		return question4;
	}

	public void setQuestion4(String question4) {
		this.question4 = question4;
	}

	public String getQuestion5() {
		return question5;
	}

	public void setQuestion5(String question5) {
		this.question5 = question5;
	}

	public String getDescription4() {
		return description4;
	}

	public void setDescription4(String description4) {
		this.description4 = description4;
	}

	public String getDescription5() {
		return description5;
	}

	public void setDescription5(String description5) {
		this.description5 = description5;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getEmail_first() {
		return email_first;
	}

	public void setEmail_first(String email_first) {
		this.email_first = email_first;
	}

	public String getEmail_second() {
		return email_second;
	}

	public void setEmail_second(String email_second) {
		this.email_second = email_second;
	}

	public String getEmail_third() {
		return email_third;
	}

	public void setEmail_third(String email_third) {
		this.email_third = email_third;
	}

	public String getPhone_first() {
		return phone_first;
	}

	public void setPhone_first(String phone_first) {
		this.phone_first = phone_first;
	}

	public String getPhone_second() {
		return phone_second;
	}

	public void setPhone_second(String phone_second) {
		this.phone_second = phone_second;
	}

	public String getPhone_third() {
		return phone_third;
	}

	public void setPhone_third(String phone_third) {
		this.phone_third = phone_third;
	}

	public String getCandidate_tracker_id_input() {
		return candidate_tracker_id_input;
	}

	public void setCandidate_tracker_id_input(String candidate_tracker_id_input) {
		this.candidate_tracker_id_input = candidate_tracker_id_input;
	}

	public int getContract_id() {
		return contract_id;
	}

	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}

	public String getEducation_other() {
		return education_other;
	}

	public void setEducation_other(String education_other) {
		this.education_other = education_other;
	}

	


}

package erp.module.hrm.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_Employee {

	@Column(name = "emp_id")
	private int emp_id;
	
	@Column(name = "emp_id_input")
	private String emp_id_input;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "mid_name")
	private String mid_name;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state_id")
	private int state_id;
	
	@Column(name = "state_name")
	private String state_name;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	@Column(name = "country_id")
	private int country_id;
	
	@Column(name = "country_name")
	private String country_name;
	
	@Column(name = "position_type")
	private String position_type;
	
	@Column(name = "hired_date")
	private Timestamp hired_date;
	
	@Column(name = "salary")
	private String salary;
	
	@Column(name = "work_time_id")
	private int work_time_id;
	
	@Column(name = "work_time_name")
	private String work_time_name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "home_number")
	private String home_number;
	
	@Column(name = "clearance_lv_id")
	private int clearance_lv_id;
	
	@Column(name = "clearance_lv_name")
	private String clearance_lv_name;
	
	@Column(name = "contract_id")
	private int contract_id;
	
	@Column(name = "contract_id_input")
	private String contract_id_input;
	
	@Column(name = "department_id")
	private int department_id;
	
	@Column(name = "department_name")
	private String department_name;
	
	@Column(name = "program")
	private String program;
	
	@Column(name = "program_manager")
	private String program_manager;
	
	@Column(name = "poc_phone")
	private String poc_phone;
	
	@Column(name = "evaluation_date")
	private Timestamp evaluation_date;
	
	@Column(name = "tax_info")
	private String tax_info;
	
	@Column(name = "court_order")
	private String court_order;
	
	@Column(name = "county")
	private String county;
	
	@Column(name = "court_address")
	private String court_address;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "termination_date")
	private Timestamp termination_date;
	
	@Column(name = "rehire")
	private boolean rehire;
	
	@Column(name = "not_hire")
	private boolean not_hire;
	
	@Column(name = "termination_reason_id")
	private int termination_reason_id;
	
	@Column(name = "termination_reason_content")
	private String termination_reason_content;
	
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
}

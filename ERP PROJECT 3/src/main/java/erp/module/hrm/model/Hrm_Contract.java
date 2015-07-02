package erp.module.hrm.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_Contract {
	
	@Column(name = "contract_id")
	private int contract_id;
	
	@Column(name = "contract_id_input")
	private String contract_id_input;
	
	@Column(name = "contract_number")
	private String 	contract_number;
	
	@Column(name = "contract_name")
	private String 	contract_name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "modification")
	private String modification;

	@Column(name = "value")
	private String value;
	
	@Column(name = "start_date")
	private Timestamp start_date;
	
	@Column(name = "end_date")
	private Timestamp end_date	;

	@Column(name = "create_time")
	private Timestamp create_time;
	
	@Column(name = "create_user")
	private String create_user	;
	
	@Column(name = "update_time")
	private Timestamp update_time	;
	
	@Column(name = "update_user")
	private String update_user;
	
	@Column(name = "delete_time")
	private Timestamp delete_time;
	
	@Column(name = "delete_user")
	private String delete_user	;
	
	@Column(name = "is_deleted")
	private boolean is_deleted;

	public int getContract_id() {
		return contract_id;
	}

	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}

	public String getContract_id_input() {
		return contract_id_input;
	}

	public void setContract_id_input(String contract_id_input) {
		this.contract_id_input = contract_id_input;
	}

	public String getContract_number() {
		return contract_number;
	}

	public void setContract_number(String contract_number) {
		this.contract_number = contract_number;
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

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModification() {
		return modification;
	}

	public void setModification(String modification) {
		this.modification = modification;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	public Timestamp getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
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
	
}

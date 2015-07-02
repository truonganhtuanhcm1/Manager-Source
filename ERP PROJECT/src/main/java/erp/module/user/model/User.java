package erp.module.user.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import erp.core.ConvertCore;
import erp.core.log.ILog;

@Entity
public class User {

	@Column(name = "user_name")
	private String user_name;

	@Column(name = "password")
	private String password;

	@Column(name = "password_hint")
	private String password_hint;

	@Column(name = "client_id")
	private String client_id;

	@Column(name = "status_id")
	private int status_id;

	@Column(name = "create_time")
	private Date create_time;

	@Column(name = "update_time")
	private Date update_time;

	@Column(name = "update_time")
	private String create_user;

	@Column(name = "update_time")
	private String update_user;

	@Column(name = "delete_time")
	private Date delete_time;

	@Column(name = "delete_user")
	private String delete_user;

	@Column(name = "is_deleted")
	private boolean is_deleted;

	@Column(name = "forgot_key")
	private String forgot_key;

	@Column(name = "email")
	private String email;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "birth_date")
	private Date birth_date;

	@Column(name = "birth_date_string")
	private String birth_date_string;

	public String getBirth_date_string() {
		return birth_date_string;
	}

	public void setBirth_date_string(String birth_date_string) {
		this.birth_date_string = birth_date_string;
	}

	@Column(name = "contact_id")
	private String contact_id;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address")
	private String address;

	@Column(name = "group_id")
	private int group_id;

	@Column(name = "group_name")
	private String group_name;

	@Column(name = "client_type_id")
	private String client_type_id;

	@Column(name = "status_name")
	private String status_name;

	private List<Permission> lstPermission;

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	public String getClient_type_id() {
		return client_type_id;
	}

	public void setClient_type_id(String client_type_id) {
		this.client_type_id = client_type_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		birth_date_string = ConvertCore.DateToString(birth_date, "MM/dd/yyyy");
		this.birth_date = birth_date;
	}

	public String getContact_id() {
		return contact_id;
	}

	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
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

	public Date getDelete_time() {
		return delete_time;
	}

	public void setDelete_time(Date delete_time) {
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

	public String getForgot_key() {
		return forgot_key;
	}

	public void setForgot_key(String forgot_key) {
		this.forgot_key = forgot_key;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword_hint() {
		return password_hint;
	}

	public void setPassword_hint(String password_hint) {
		this.password_hint = password_hint;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
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

	public List<Permission> getLstPermission() {

		return lstPermission;
	}

	public void setLstPermission(List<Permission> lstPermission) {

		this.lstPermission = lstPermission;
		ILog.Debug("Added " + lstPermission.size() + " permissions!", this);
	}

	public boolean has_permission(String _strPermission) {

		ILog.Debug("Check permission " + _strPermission, this);
		if (lstPermission == null)
			return false;
		for (Permission permission : lstPermission) {
			if (_strPermission.equals(permission.getPermission_id())) {

				ILog.Debug("Check permission " + _strPermission + " with "
						+ permission.getApplied(), this);

				if (permission.getApplied().equals(_strPermission)) {
					ILog.Debug("Have permission " + _strPermission, this);
				}

				return permission.getApplied().equals(_strPermission);
			}
		}
		return false;
	}

}

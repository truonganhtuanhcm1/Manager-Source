package erp.module.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Hrm_Termination_Reason {

	@Column(name = "termination_reason_id")
	private int termination_reason_id;
	
	@Column(name = "termination_reason_content")
	private String termination_reason_content;
	
	@Column(name = "is_deleted")
	private boolean is_deleted;

	public int getTermination_reason_id() {
		return termination_reason_id;
	}

	public void setTermination_reason_id(int termination_reason_id) {
		this.termination_reason_id = termination_reason_id;
	}

	public String getTermination_reason_content() {
		return termination_reason_content;
	}

	public void setTermination_reason_content(String termination_reason_content) {
		this.termination_reason_content = termination_reason_content;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	
}

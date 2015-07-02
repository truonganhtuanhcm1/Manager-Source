package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_CandidateTrackerDAO;
import erp.module.hrm.model.Hrm_Candidate_Tracker;

public class Hrm_CandidateTrackerService extends BUS {
	
	public List<Hrm_Candidate_Tracker> search(String keyword,
			int statusId,
			String position,
			String requisitionIdInput) {

		List<Hrm_Candidate_Tracker> lstResult = null;
		try {
			lstResult = new Hrm_CandidateTrackerDAO(this.m_objData).search(keyword, 
					statusId, position, requisitionIdInput);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
	
	public Hrm_Candidate_Tracker getByCandidateTrackerId(int candidateTrackerId) {

		Hrm_Candidate_Tracker candTrk = null;
		try {
			candTrk = new Hrm_CandidateTrackerDAO(this.m_objData)
					.getByCandidateTrackerId(candidateTrackerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return candTrk;
	}
	
	public boolean addCandidateTracker(
			String candidateTrackerIdInput,
			int contractId,
			int requisitionId,
			int stateId,
			int countryId,
			int statusId,
			int clearanceLvId,
			int positionId,
			int educationId,
			String educationOther,
			String firstName,
			String midName,
			String lastName,
			String city,
			String statusOther,
			String jobLocation,
			String referedLocation,
			String salaryRange,
			String experience,
			String emailFirst,
			String emailSecond,
			String emailThird,
			String phoneFirst,
			String phoneSecond,
			String phoneThird,
			int emailDateType,
			Date emailDate,
			int callDateType,
			Date callDate,
			Date phoneScreenDate,
			String candidateComment,
			String dvsComment,
			String altPosition,
			String bestTimeContact,
			String certification,
			String qQualification,
			String qBackground,
			String qTechnicalSkill,
			String qExpectedSalary,
			String qCommunication,
			String qInitiative,
			Date availableStartDate,
			String question1,
			String question2,
			String question3,
			String description1,
			String description2,
			String description3,
			String createUser, 
			String question4, 
			String question5, 
			String description4, 
			String description5,
			String attachmentName) throws SQLException {

		this.BeginTran();

		Hrm_CandidateTrackerDAO dao = new Hrm_CandidateTrackerDAO(this.m_objData);
		boolean isOk = true;
		boolean isCreated = false;
		try {
			isOk = dao.insert(candidateTrackerIdInput, contractId, requisitionId, stateId, countryId, statusId, clearanceLvId, positionId, 
					educationId, educationOther, firstName, midName, lastName, city, statusOther, jobLocation, referedLocation, 
					salaryRange, experience, emailFirst, emailSecond, emailThird, phoneFirst, phoneSecond, phoneThird,
					emailDateType, emailDate, 
					callDateType, callDate, phoneScreenDate, candidateComment, dvsComment, 
					altPosition, bestTimeContact, certification, qQualification, qBackground, qTechnicalSkill, 
					qExpectedSalary, qCommunication, qInitiative, availableStartDate, question1, question2, 
					question3, description1, description2, description3, createUser, question4, question5, 
					description4, description5, attachmentName);
					
		} catch (SQLException e) {
			isOk = false;
			ILog.Error("HRM_CandidateTrackerDAO -> Insert()", this, e);
			e.printStackTrace();
		}

		try {
			if (isOk) {
				this.CommitTran();
				isCreated = true;
			} else {
				this.RollbackTran();
				isCreated = false;
			}
		} catch (Exception e) {
			isCreated = false;
			ILog.Error("HRM_CandidateTrackerService -> Add() : " + e.getMessage(), this, e);
		}

		return isCreated;
	}
	
	public boolean updateCandidateTracker(int candidateTrackerId,
			String candidateTrackerIdInput,
			int contractId,
			int requisitionId,
			int stateId,
			int countryId,
			int statusId,
			int clearanceLvId,
			int positionId,
			int educationId,
			String educationOther,
			String firstName,
			String midName,
			String lastName,
			String city,
			String statusOther,
			String jobLocation,
			String referedLocation,
			String salaryRange,
			String experience,
			String emailFirst,
			String emailSecond,
			String emailThird,
			String phoneFirst,
			String phoneSecond,
			String phoneThird,
			int emailDateType,
			Date emailDate,
			int callDateType,
			Date callDate,
			Date phoneScreenDate,
			String candidateComment,
			String dvsComment,
			String altPosition,
			String bestTimeContact,
			String certification,
			String qQualification,
			String qBackground,
			String qTechnicalSkill,
			String qExpectedSalary,
			String qCommunication,
			String qInitiative,
			Date availableStartDate,
			String question1,
			String question2,
			String question3,
			String question4,
			String question5,
			String description1,
			String description2,
			String description3,
			String description4,
			String description5,
			String attachment,
			String updateUser) throws SQLException {

		this.BeginTran();

		Hrm_CandidateTrackerDAO dao = new Hrm_CandidateTrackerDAO(this.m_objData);
		boolean isOk = true;
		boolean isUpdated = false;
		try {
			isOk = dao.update(candidateTrackerId, candidateTrackerIdInput, contractId, requisitionId, stateId, countryId, statusId, clearanceLvId, positionId, 
					educationId, educationOther, firstName, midName, lastName, city, statusOther, jobLocation, referedLocation, 
					salaryRange, experience, emailFirst, emailSecond, emailThird, phoneFirst, phoneSecond, phoneThird, 
					emailDateType, emailDate, 
					callDateType, callDate, phoneScreenDate, candidateComment, dvsComment, 
					altPosition, bestTimeContact, certification, qQualification, qBackground, qTechnicalSkill, 
					qExpectedSalary, qCommunication, qInitiative, availableStartDate, question1, question2, 
					question3, question4, question5, description1, description2, description3, description4,
					description5, attachment, updateUser);
					
		} catch (SQLException e) {
			isOk = false;
			ILog.Error("HRM_CandidateTrackerDAO -> Update()", this, e);
			e.printStackTrace();
		}

		try {
			if (isOk) {
				this.CommitTran();
				isUpdated = true;
			} else {
				this.RollbackTran();
				isUpdated = false;
			}
		} catch (Exception e) {
			isUpdated = false;
			ILog.Error("HRM_CandidateTrackerService -> Update() : " + e.getMessage(), this, e);
		}

		return isUpdated;
	}
	
	public boolean delete(int candidateTrackerId, String userName) throws SQLException {
		// TODO Auto-generated method stub
		this.BeginTran();
		
		Hrm_CandidateTrackerDAO dao = new Hrm_CandidateTrackerDAO(m_objData);
		boolean isOk = dao.delete(candidateTrackerId, userName);

		if (isOk) {
			this.CommitTran();
		} else {
			this.RollbackTran();
		}
		
		return isOk;
		
	}
	
}

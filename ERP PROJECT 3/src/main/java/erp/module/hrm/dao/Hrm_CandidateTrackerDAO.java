package erp.module.hrm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import erp.core.ConvertCore;
import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.core.log.ILog;
import erp.module.hrm.model.Hrm_Candidate_Tracker;
import erp.module.user.model.User;

public class Hrm_CandidateTrackerDAO extends DAO {

	public Hrm_CandidateTrackerDAO(IData objData) {
		super(objData);
		// TODO Auto-generated constructor stub
	}
	
	public List<Hrm_Candidate_Tracker> search(String keyword,
			int statusId,
			String position, 
			String requisitionIdInput)
			throws SQLException {

		try {

			this.TryConnect();
			this.m_objData.SetStoreName("hrm_candidate_tracker_search(?,?,?,?)");
			this.m_objData.Parameters.setString(1, keyword);
			this.m_objData.Parameters.setInt(2, statusId);
			this.m_objData.Parameters.setString(3, position);
			this.m_objData.Parameters.setString(4, requisitionIdInput);
			
			ResultSetMapper util = new ResultSetMapper<User>();
			ResultSet rsResult = this.m_objData.ExecToResultSet();
			
			List<Hrm_Candidate_Tracker> lstResult = util.mapRersultSetToObject(
					rsResult, Hrm_Candidate_Tracker.class);

			if (lstResult == null)
				return null;

			if (lstResult.size() > 0)
				return lstResult;
			return null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}

		return null;
	}
	
	public boolean insert(
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
			String attachmentName
			) throws SQLException {
		// public boolean Insert(Hrm_Requisition hrmRequisition) throws
		// SQLException {
		boolean isOk = true;
		try {

			this.TryConnect();

			this.m_objData
					.SetStoreName("hrm_candidate_tracker_insert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
							+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			this.m_objData.Parameters.setString(1, candidateTrackerIdInput);
			this.m_objData.Parameters.setInt(2, contractId);
			this.m_objData.Parameters.setInt(3, requisitionId);
			this.m_objData.Parameters.setInt(4, stateId);
			this.m_objData.Parameters.setInt(5, countryId);
			this.m_objData.Parameters.setInt(6, statusId);
			this.m_objData.Parameters.setInt(7, clearanceLvId);
			this.m_objData.Parameters.setInt(8, positionId);
			this.m_objData.Parameters.setInt(9, educationId);
			this.m_objData.Parameters.setString(10, educationOther);
			this.m_objData.Parameters.setString(11, firstName);
			this.m_objData.Parameters.setString(12, midName);
			this.m_objData.Parameters.setString(13, lastName);
			this.m_objData.Parameters.setString(14, city);
			this.m_objData.Parameters.setString(15, statusOther);
			this.m_objData.Parameters.setString(16, jobLocation);
			this.m_objData.Parameters.setString(17, referedLocation);
			this.m_objData.Parameters.setString(18, salaryRange);
			this.m_objData.Parameters.setString(19, experience);
			this.m_objData.Parameters.setString(20, emailFirst);
			this.m_objData.Parameters.setString(21, emailSecond);
			this.m_objData.Parameters.setString(22, emailThird);
			this.m_objData.Parameters.setString(23, phoneFirst);
			this.m_objData.Parameters.setString(24, phoneSecond);
			this.m_objData.Parameters.setString(25, phoneThird);
			this.m_objData.Parameters.setInt(26, emailDateType);
			this.m_objData.Parameters.setTimestamp(27, ConvertCore.ConvertToSqlTimestamp(emailDate));
			this.m_objData.Parameters.setInt(28, callDateType);
			this.m_objData.Parameters.setTimestamp(29, ConvertCore.ConvertToSqlTimestamp(callDate));
			this.m_objData.Parameters.setTimestamp(30, ConvertCore.ConvertToSqlTimestamp(phoneScreenDate));
			this.m_objData.Parameters.setString(31, candidateComment);
			this.m_objData.Parameters.setString(32, dvsComment);
			this.m_objData.Parameters.setString(33, altPosition);
			this.m_objData.Parameters.setString(34, bestTimeContact);
			this.m_objData.Parameters.setString(35, certification);
			this.m_objData.Parameters.setString(36, qQualification);
			this.m_objData.Parameters.setString(37, qBackground);
			this.m_objData.Parameters.setString(38, qTechnicalSkill);
			this.m_objData.Parameters.setString(39, qExpectedSalary);
			this.m_objData.Parameters.setString(40, qCommunication);
			this.m_objData.Parameters.setString(41, qInitiative);
			this.m_objData.Parameters.setTimestamp(42, ConvertCore.ConvertToSqlTimestamp(availableStartDate));
			this.m_objData.Parameters.setString(43, question1);
			this.m_objData.Parameters.setString(44, question2);
			this.m_objData.Parameters.setString(45, question3);
			this.m_objData.Parameters.setString(46, description1);
			this.m_objData.Parameters.setString(47, description2);
			this.m_objData.Parameters.setString(48, description3);
			this.m_objData.Parameters.setString(49, createUser);
			this.m_objData.Parameters.setString(50, question4);
			this.m_objData.Parameters.setString(51, question5);
			this.m_objData.Parameters.setString(52, description4);
			this.m_objData.Parameters.setString(53, description5);
			this.m_objData.Parameters.setString(54, attachmentName);

			this.m_objData.ExecNoneQuery();
			isOk = true;

		} catch (Exception e) {
			isOk = false;
			ILog.Error("Requisition DAO - Insert: ", this, e);
			e.printStackTrace();
		} finally {
			this.TryDisconnect();
		}

		return isOk;
	}
	
	public boolean update(int candidateTrackerId,
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
			String updateUser
			) throws SQLException {
		boolean isOk = true;
		try {

			this.TryConnect();

			this.m_objData
					.SetStoreName("hrm_candidate_tracker_update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
							+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			this.m_objData.Parameters.setInt(1, candidateTrackerId);
			this.m_objData.Parameters.setString(2, candidateTrackerIdInput);
			this.m_objData.Parameters.setInt(3, contractId);
			this.m_objData.Parameters.setInt(4, requisitionId);
			this.m_objData.Parameters.setInt(5, stateId);
			this.m_objData.Parameters.setInt(6, countryId);
			this.m_objData.Parameters.setInt(7, statusId);
			this.m_objData.Parameters.setInt(8, clearanceLvId);
			this.m_objData.Parameters.setInt(9, positionId);
			this.m_objData.Parameters.setInt(10, educationId);
			this.m_objData.Parameters.setString(11, educationOther);
			this.m_objData.Parameters.setString(12, firstName);
			this.m_objData.Parameters.setString(13, midName);
			this.m_objData.Parameters.setString(14, lastName);
			this.m_objData.Parameters.setString(15, city);
			this.m_objData.Parameters.setString(16, statusOther);
			this.m_objData.Parameters.setString(17, jobLocation);
			this.m_objData.Parameters.setString(18, referedLocation);
			this.m_objData.Parameters.setString(19, salaryRange);
			this.m_objData.Parameters.setString(20, experience);
			this.m_objData.Parameters.setString(21, emailFirst);
			this.m_objData.Parameters.setString(22, emailSecond);
			this.m_objData.Parameters.setString(23, emailThird);
			this.m_objData.Parameters.setString(24, phoneFirst);
			this.m_objData.Parameters.setString(25, phoneSecond);
			this.m_objData.Parameters.setString(26, phoneThird);
			this.m_objData.Parameters.setInt(27, emailDateType);
			this.m_objData.Parameters.setTimestamp(28, emailDate != null ? ConvertCore.ConvertToSqlTimestamp(emailDate) : null);
			this.m_objData.Parameters.setInt(29, callDateType);
			this.m_objData.Parameters.setTimestamp(30, callDate != null ? ConvertCore.ConvertToSqlTimestamp(callDate) : null);
			this.m_objData.Parameters.setTimestamp(31, phoneScreenDate != null ? ConvertCore.ConvertToSqlTimestamp(phoneScreenDate) : null);
			this.m_objData.Parameters.setString(32, candidateComment);
			this.m_objData.Parameters.setString(33, dvsComment);
			this.m_objData.Parameters.setString(34, altPosition);
			this.m_objData.Parameters.setString(35, bestTimeContact);
			this.m_objData.Parameters.setString(36, certification);
			this.m_objData.Parameters.setString(37, qQualification);
			this.m_objData.Parameters.setString(38, qBackground);
			this.m_objData.Parameters.setString(39, qTechnicalSkill);
			this.m_objData.Parameters.setString(40, qExpectedSalary);
			this.m_objData.Parameters.setString(41, qCommunication);
			this.m_objData.Parameters.setString(42, qInitiative);
			this.m_objData.Parameters.setTimestamp(43, availableStartDate != null ? ConvertCore.ConvertToSqlTimestamp(availableStartDate) : null);
			this.m_objData.Parameters.setString(44, question1);
			this.m_objData.Parameters.setString(45, question2);
			this.m_objData.Parameters.setString(46, question3);
			this.m_objData.Parameters.setString(47, question4);
			this.m_objData.Parameters.setString(48, question5);
			this.m_objData.Parameters.setString(49, description1);
			this.m_objData.Parameters.setString(50, description2);
			this.m_objData.Parameters.setString(51, description3);
			this.m_objData.Parameters.setString(52, description4);
			this.m_objData.Parameters.setString(53, description5);
			this.m_objData.Parameters.setString(54, attachment);
			this.m_objData.Parameters.setString(55, updateUser);
			this.m_objData.ExecNoneQuery();
			isOk = true;

		} catch (Exception e) {
			isOk = false;
			ILog.Error("Candidate DAO - Update: ", this, e);
			e.printStackTrace();
		} finally {
			this.TryDisconnect();
		}

		return isOk;
	}
	
	public Hrm_Candidate_Tracker getByCandidateTrackerId(int candidateTrackerId) throws SQLException {

		try {

			this.TryConnect();
			this.m_objData.SetStoreName("hrm_candidate_tracker_getById(?)");
			this.m_objData.Parameters.setInt(1, candidateTrackerId);

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet rsResult = this.m_objData.ExecToResultSet();

			List<Hrm_Candidate_Tracker> lstResult = util.mapRersultSetToObject(rsResult, Hrm_Candidate_Tracker.class);
			
			if(lstResult==null)
				return null;

			if (lstResult.size() > 0){
				return lstResult.get(0);
			}
				
			return null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}

		return null;
	}
	
	public boolean delete(int candTrkId, String userName)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("hrm_candidate_tracker_delete(?,?)");

			this.m_objData.Parameters.setInt(1, candTrkId);
			this.m_objData.Parameters.setString(2, userName);

			this.m_objData.ExecNoneQuery();

			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.TryDisconnect();
		}

		return false;
	}

}

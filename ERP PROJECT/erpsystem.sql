-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2015 at 04:19 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `erpsystem`
--
CREATE DATABASE IF NOT EXISTS `erpsystem` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `erpsystem`;

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `hrm_candidate_tracker_delete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_candidate_tracker_delete`(IN `p_candidate_tracker_id` INT, IN `p_delete_user` VARCHAR(255))
    NO SQL
UPDATE hrm_candidate_tracker
SET
	delete_time = CURRENT_TIMESTAMP,
	delete_user = p_delete_user,
	is_deleted = 1
WHERE
	candidate_tracker_id = p_candidate_tracker_id$$

DROP PROCEDURE IF EXISTS `hrm_candidate_tracker_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_candidate_tracker_getAll`(IN `p_keyword` VARCHAR(255), IN `p_status_id` INT, IN `p_position` VARCHAR(255), IN `p_requisition_id_input` VARCHAR(255))
    NO SQL
SELECT ct.*,
		r.requisition_id_input,
		s.status_name,
		p.position_title

FROM hrm_candidate_tracker AS ct 
LEFT JOIN hrm_requisition AS r ON r.requisition_id = ct.requisition_id
LEFT JOIN hrm_status AS s ON s.status_id = ct.status_id
LEFT JOIN hrm_position AS p ON p.position_id = ct.position_id

WHERE ct.is_deleted = 0$$

DROP PROCEDURE IF EXISTS `hrm_candidate_tracker_getById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_candidate_tracker_getById`(IN `p_candidate_tracker_id` INT)
    NO SQL
SELECT ct.*

FROM hrm_candidate_tracker AS ct



WHERE 
	ct.is_deleted = 0 AND
	ct.candidate_tracker_id = p_candidate_tracker_id$$

DROP PROCEDURE IF EXISTS `hrm_candidate_tracker_insert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_candidate_tracker_insert`(
	IN `p_candidate_tracker_id_input` VARCHAR(30), 
	IN `p_contract_id` INT, 
	IN `p_requisition_id` INT, 
	IN `p_state_id` INT, 
	IN `p_country_id` INT, 
	IN `p_status_id` INT, 
	IN `p_clearance_lv_id` INT, 
	IN `p_position_id` INT, 
	IN `p_education_id` INT,
	IN `p_education_other` VARCHAR(255),
	IN `p_first_name` VARCHAR(100), 
	IN `p_mid_name` VARCHAR(100), 
	IN `p_last_name` VARCHAR(100), 
	IN `p_city` VARCHAR(50), 
	IN `p_status_other` VARCHAR(50), 
	IN `p_job_location` VARCHAR(255), 
	IN `p_refered_location` VARCHAR(255), 
	IN `p_salary_range` VARCHAR(50), 
	IN `p_experience` VARCHAR(255),  
	IN `p_email_first` VARCHAR(100), 
	IN `p_email_second` VARCHAR(100), 
	IN `p_email_third` VARCHAR(100), 
	IN `p_phone_first` VARCHAR(30), 
	IN `p_phone_second` VARCHAR(30), 
	IN `p_phone_third` VARCHAR(30), 
	IN `p_email_date_type` INT, 
	IN `p_email_date` TIMESTAMP, 
	IN `p_call_date_type` INT, 
	IN `p_call_date` TIMESTAMP, 
	IN `p_phone_screen_date` TIMESTAMP, 
	IN `p_candidate_comment` VARCHAR(1000), 
	IN `p_dvs_comment` VARCHAR(1000), 
	IN `p_alt_position` VARCHAR(255), 
	IN `p_best_time_contact` VARCHAR(50), 
	IN `p_certification` VARCHAR(100), 
	IN `p_q_qualification` VARCHAR(1000), 
	IN `p_q_background` VARCHAR(1000), 
	IN `p_q_technical_skill` VARCHAR(1000), 
	IN `p_q_expected_salary` VARCHAR(50), 
	IN `p_q_communication` VARCHAR(1000), 
	IN `p_q_initiative` VARCHAR(1000), 
	IN `p_available_start_date` TIMESTAMP, 
	IN `p_question1` VARCHAR(1000), 
	IN `p_question2` VARCHAR(1000), 
	IN `p_question3` VARCHAR(1000), 
	IN `p_description1` VARCHAR(1000), 
	IN `p_description2` VARCHAR(1000), 
	IN `p_description3` VARCHAR(1000), 
	IN `p_create_user` VARCHAR(255), 
	IN `p_question4` VARCHAR(1000), 
	IN `p_question5` VARCHAR(1000), 
	IN `p_description4` VARCHAR(1000), 
	IN `p_description5` VARCHAR(1000), 
	IN `p_attachment` VARCHAR(1000))
    NO SQL
INSERT INTO hrm_candidate_tracker(
	candidate_tracker_id_input,
	contract_id,
	requisition_id,
    state_id, 
    country_id, 
    status_id, 
    clearance_lv_id, 
	position_id,
    education_id, 
	education_other,
    first_name, 
	mid_name,
	last_name,
	city,
	status_other,
	job_location,
	refered_location,
	salary_range,
	experience,
	email_first,
	email_second,
	email_third,
	phone_first,
	phone_second,
	phone_third,
	email_date_type,
	email_date,
	call_date_type,
	call_date,
	phone_screen_date,
	candidate_comment,
	dvs_comment,
	alt_position,
	best_time_contact,
	certification,
	q_qualification,
	q_background,
	q_technical_skill,
	q_expected_salary,
	q_communication,
	q_initiative,
	available_start_date,
	question1,
	question2,
	question3,
    question4,
    question5,
	description1,
	description2,
	description3,
    description4,
    description5,
    attachment,
    create_time,
    create_user,
    update_time,
    update_user,
    is_deleted
) 
VALUES(
	p_candidate_tracker_id_input,
	p_contract_id,
	p_requisition_id,
    p_state_id, 
    p_country_id, 
    p_status_id, 
    p_clearance_lv_id,
	p_position_id,	
    p_education_id, 
	p_education_other,
    p_first_name, 
	p_mid_name,
	p_last_name,
	p_city,
	p_status_other,
	p_job_location,
	p_refered_location,
	p_salary_range,
	p_experience,
	p_email_first,
	p_email_second,
	p_email_third,
	p_phone_first,
	p_phone_second,
	p_phone_third,
	p_email_date_type,
	p_email_date,
	p_call_date_type,
	p_call_date,
	p_phone_screen_date,
	p_candidate_comment,
	p_dvs_comment,
	p_alt_position,
	p_best_time_contact,
	p_certification,
	p_q_qualification,
	p_q_background,
	p_q_technical_skill,
	p_q_expected_salary,
	p_q_communication,
	p_q_initiative,
	p_available_start_date,
	p_question1,
	p_question2,
	p_question3,
    p_question4,
    p_question5,
	p_description1,
	p_description2,
	p_description3,
    p_description4,
    p_description5,
    p_attachment,
    CURRENT_TIMESTAMP,
    p_create_user,
    CURRENT_TIMESTAMP,
    p_create_user,
    0
)$$

DROP PROCEDURE IF EXISTS `hrm_candidate_tracker_search`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_candidate_tracker_search`(
	IN `p_keyword` VARCHAR(255), 
	IN `p_status_id` INT, 
	IN `p_position` VARCHAR(255), 
	IN `p_requisition_id_input` VARCHAR(255))
    NO SQL
SELECT ct.*,
		r.requisition_id_input,
		p.position_title,
		s.status_name
FROM hrm_candidate_tracker AS ct 
LEFT JOIN hrm_position AS p ON p.position_id = ct.position_id
LEFT JOIN hrm_requisition AS r ON r.requisition_id = ct.requisition_id
LEFT JOIN hrm_state AS st ON st.state_id = ct.state_id
LEFT JOIN hrm_country AS c ON c.country_id = ct.country_id
LEFT JOIN hrm_clearance_level AS cl ON cl.clearance_lv_id = ct.clearance_lv_id
LEFT JOIN hrm_education AS e ON e.education_id = ct.education_id
LEFT JOIN hrm_status AS s ON s.status_id = ct.status_id

WHERE 
	ct.is_deleted = 0 AND

	(p_keyword = '' OR (
		st.state_name LIKE CONCAT('%', p_keyword, '%') OR
		c.country_name LIKE CONCAT('%', p_keyword, '%') OR
		cl.clearance_lv_name LIKE CONCAT('%', p_keyword, '%') OR
		e.education_name LIKE CONCAT('%', p_keyword, '%') OR
		ct.education_other LIKE CONCAT('%', p_keyword, '%') OR
		ct.first_name LIKE CONCAT('%', p_keyword, '%') OR
		ct.mid_name LIKE CONCAT('%', p_keyword, '%') OR
		ct.last_name LIKE CONCAT('%', p_keyword, '%') OR
		CONCAT(TRIM(ct.first_name), ' ' , TRIM(ct.mid_name), ' ', TRIM(ct.last_name)) LIKE CONCAT('%', p_keyword, '%') OR
		ct.city LIKE CONCAT('%', p_keyword, '%') OR
		ct.status_other LIKE CONCAT('%', p_keyword, '%') OR
		ct.job_location LIKE CONCAT('%', p_keyword, '%') OR
		ct.refered_location LIKE CONCAT('%', p_keyword, '%') OR
		ct.salary_range LIKE CONCAT('%', p_keyword, '%') OR
		ct.experience LIKE CONCAT('%', p_keyword, '%') OR
		ct.email_first LIKE CONCAT('%', p_keyword, '%') OR
		ct.email_second LIKE CONCAT('%', p_keyword, '%') OR
		ct.email_third LIKE CONCAT('%', p_keyword, '%') OR
		ct.phone_first LIKE CONCAT('%', p_keyword, '%') OR
		ct.phone_second LIKE CONCAT('%', p_keyword, '%') OR

		ct.phone_third LIKE CONCAT('%', p_keyword, '%') OR
		ct.candidate_comment LIKE CONCAT('%', p_keyword, '%') OR
		ct.dvs_comment LIKE CONCAT('%', p_keyword, '%') OR
		ct.alt_position LIKE CONCAT('%', p_keyword, '%') OR
		ct.best_time_contact LIKE CONCAT('%', p_keyword, '%') OR
		ct.certification LIKE CONCAT('%', p_keyword, '%') OR
		ct.q_qualification LIKE CONCAT('%', p_keyword, '%') OR
		ct.q_background LIKE CONCAT('%', p_keyword, '%') OR
		ct.q_technical_skill LIKE CONCAT('%', p_keyword, '%') OR
		ct.q_expected_salary LIKE CONCAT('%', p_keyword, '%') OR
		ct.q_communication LIKE CONCAT('%', p_keyword, '%') OR
		ct.q_initiative LIKE CONCAT('%', p_keyword, '%') OR
		ct.question1 LIKE CONCAT('%', p_keyword, '%') OR
		ct.question2 LIKE CONCAT('%', p_keyword, '%') OR
		ct.question3 LIKE CONCAT('%', p_keyword, '%') OR
		ct.question4 LIKE CONCAT('%', p_keyword, '%') OR
		ct.question5 LIKE CONCAT('%', p_keyword, '%') OR
		ct.description1 LIKE CONCAT('%', p_keyword, '%') OR

		ct.description2 LIKE CONCAT('%', p_keyword, '%') OR
		ct.description3 LIKE CONCAT('%', p_keyword, '%') OR
		ct.description4 LIKE CONCAT('%', p_keyword, '%') OR
		ct.description5 LIKE CONCAT('%', p_keyword, '%')
	)) AND 
	(p_status_id = -1 OR ct.status_id = p_status_id) AND 
	(p_requisition_id_input = '' OR r.requisition_id_input LIKE CONCAT('%', p_requisition_id_input, '%')) AND
	(p_position = '' OR p.position_title LIKE CONCAT('%', p_position, '%'))$$

DROP PROCEDURE IF EXISTS `hrm_candidate_tracker_update`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_candidate_tracker_update`(
    IN `p_candidate_tracker_id` INT, 
	IN `p_candidate_tracker_id_input` VARCHAR(20), 
	IN `p_contract_id` INT, 
    IN `p_requisition_id` INT, 
    IN `p_state_id` INT, 
    IN `p_country_id` INT, 
    IN `p_status_id` INT, 
    IN `p_clearance_lv_id` INT, 
    IN `p_position_id` INT, 
    IN `p_education_id` INT, 
	IN `p_education_other` VARCHAR(255), 
    IN `p_first_name` VARCHAR(100), 
    IN `p_mid_name` VARCHAR(100), 
    IN `p_last_name` VARCHAR(100), 
    IN `p_city` VARCHAR(50), 
    IN `p_status_other` VARCHAR(50), 
	IN `p_job_location` VARCHAR(255), 
	IN `p_refered_location` VARCHAR(255), 
	IN `p_salary_range` VARCHAR(50), 
	IN `p_experience` VARCHAR(255), 
	IN `p_email_first` VARCHAR(100), 
	IN `p_email_second` VARCHAR(100), 
	IN `p_email_third` VARCHAR(100), 
	IN `p_phone_first` VARCHAR(30), 
	IN `p_phone_second` VARCHAR(30), 
	IN `p_phone_third` VARCHAR(30), 
	IN `p_email_date_type` INT, 
	IN `p_email_date` TIMESTAMP, 
	IN `p_call_date_type` INT, 
	IN `p_call_date` TIMESTAMP, 
	IN `p_phone_screen_date` TIMESTAMP, 
	IN `p_candidate_comment` VARCHAR(1000), 
	IN `p_dvs_comment` VARCHAR(1000), 
	IN `p_alt_position` VARCHAR(255), 
	IN `p_best_time_contact` VARCHAR(50), 
	IN `p_certification` VARCHAR(100), 
	IN `p_q_qualification` VARCHAR(1000), 
	IN `p_q_background` VARCHAR(1000), 
	IN `p_q_technical_skill` VARCHAR(1000), 
	IN `p_q_expected_salary` VARCHAR(50), 
	IN `p_q_communication` VARCHAR(1000), 
    IN `p_q_initiative` VARCHAR(1000), 
    IN `p_available_start_date` TIMESTAMP, 
	IN `p_question1` VARCHAR(1000), 
	IN `p_question2` VARCHAR(1000), 
	IN `p_question3` VARCHAR(1000), 
	IN `p_question4` VARCHAR(1000), 
	IN `p_question5` VARCHAR(1000), 
	IN `p_description1` VARCHAR(1000), 
	IN `p_description2` VARCHAR(1000), 
	IN `p_description3` VARCHAR(1000), 
	IN `p_description4` VARCHAR(1000), 
	IN `p_description5` VARCHAR(1000), 
	IN `p_attachment` VARCHAR(1000),
	IN `p_update_user` VARCHAR(255) )
    NO SQL
UPDATE hrm_candidate_tracker

	SET
		candidate_tracker_id_input = p_candidate_tracker_id_input,
		contract_id = p_contract_id,
		requisition_id = p_requisition_id,
		state_id = p_state_id,
		country_id = p_country_id, 
		status_id = p_status_id, 
		clearance_lv_id = p_clearance_lv_id, 
		position_id = p_position_id,
		education_id = p_education_id, 
		education_other = p_education_other,
		first_name = p_first_name, 
		mid_name = p_mid_name,
		last_name = p_last_name,
		city = p_city,
		status_other = p_status_other,
		job_location = p_job_location,
		refered_location = p_refered_location,
		salary_range = p_salary_range,
		experience = p_experience,
		email_first = p_email_first,
		email_second = p_email_second,
		email_third = p_email_third,
		phone_first = p_phone_first,
		phone_second = p_phone_second,
		phone_third = p_phone_third,
		email_date_type = p_email_date_type,
		email_date = p_email_date,
		call_date_type = p_call_date_type,
		call_date = p_call_date,
		phone_screen_date = p_phone_screen_date,
		candidate_comment = p_candidate_comment,
		dvs_comment = p_dvs_comment,
		alt_position = p_alt_position,

		best_time_contact = p_best_time_contact,
		certification = p_certification,
		q_qualification = p_q_qualification,
		q_background = p_q_background,
		q_technical_skill = p_q_technical_skill,
		q_expected_salary = p_q_expected_salary,
		q_communication = p_q_communication,
		q_initiative = p_q_initiative,
		available_start_date = p_available_start_date,
		question1 = p_question1,
		question2 = p_question2,
		question3 = p_question3,
		question4 = p_question4,
		question5 = p_question5,
		description1 = p_description1,
		description2 = p_description2,
		description3 = p_description3,
		description4 = p_description4,
		description5 = p_description5,
		attachment = p_attachment,
		update_user = p_update_user,
		update_time = CURRENT_TIMESTAMP     		
	
	WHERE candidate_tracker_id = p_candidate_tracker_id$$

DROP PROCEDURE IF EXISTS `hrm_city_by_cityId`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_city_by_cityId`(IN `p_city_id` INT)
    NO SQL
SELECT *
FROM hrm_city
WHERE city_id = p_city_id$$

DROP PROCEDURE IF EXISTS `hrm_city_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_city_getAll`()
    NO SQL
SELECT *
FROM hrm_city
GROUP BY city_id$$

DROP PROCEDURE IF EXISTS `hrm_city_get_by_stateId`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_city_get_by_stateId`(IN `p_state_id` INT)
    NO SQL
SELECT *
FROM hrm_city
WHERE state_id = p_state_id
GROUP BY city_id$$

DROP PROCEDURE IF EXISTS `hrm_clearance_level_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_clearance_level_getAll`()
    NO SQL
SELECT *
FROM hrm_clearance_level
WHERE is_deleted = 0$$

DROP PROCEDURE IF EXISTS `hrm_client_group_getList`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_client_group_getList`()
    NO SQL
select * from hrm_client_group$$

DROP PROCEDURE IF EXISTS `hrm_client_InsertClientInfo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_client_InsertClientInfo`(IN `_client_type_id` VARCHAR(255), IN `_group_id` VARCHAR(255), IN `_create_user` VARCHAR(255))
    NO SQL
begin
set @id:= (select client_id +1 from hrm_client order by create_time desc, client_id desc limit 0,1);

INSERT INTO `hrm_client`(`client_id`, `client_type_id`, `group_id`, `create_time`, `update_time`) VALUES (@id,_client_type_id,_group_id,current_timestamp,current_timestamp);

select @id;
end$$

DROP PROCEDURE IF EXISTS `hrm_client_type_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_client_type_getAll`()
    NO SQL
SELECT * FROM hrm_client_type	 WHERE is_deleted = 0$$

DROP PROCEDURE IF EXISTS `hrm_client_UpdateClientInfo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_client_UpdateClientInfo`(IN `_client_id` VARCHAR(255), IN `_client_type_id` VARCHAR(255), IN `_group_id` VARCHAR(255), IN `_udpate_user` VARCHAR(255))
    NO SQL
update hrm_client
set group_id= _group_id,
	client_type_id= _client_type_id,
    update_time = CURRENT_TIMESTAMP
where client_id = _client_id$$

DROP PROCEDURE IF EXISTS `hrm_contact_InsertContactInfo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_contact_InsertContactInfo`(IN `_client_id` VARCHAR(255), IN `_email` VARCHAR(255), IN `_phone` VARCHAR(255), IN `_address` VARCHAR(1000), IN `_create_user` VARCHAR(255))
    NO SQL
begin

set @id:= (select contact_id +1 from hrm_contact order by create_time desc, contact_id desc limit 0,1);


INSERT INTO `hrm_contact`(`contact_id`, `email`, `phone`, `address`, `create_time`, `update_time`) VALUES (@id,_email,_phone,_address,current_timestamp,current_timestamp);

INSERT INTO `hrm_client_contact`(`client_id`, `contact_id`, `create_time`, `update_time`) VALUES (_client_id,@id,current_timestamp,current_timestamp);

end$$

DROP PROCEDURE IF EXISTS `hrm_contact_UpdateContactInfo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_contact_UpdateContactInfo`(IN `_contact_id` VARCHAR(255), IN `_email` VARCHAR(255), IN `_phone` VARCHAR(255), IN `_address` VARCHAR(555), IN `_udpate_user` VARCHAR(255))
    NO SQL
update hrm_contact
set email= _email,
	phone= _phone,
	address= _address,
    update_time = CURRENT_TIMESTAMP

where contact_id = _contact_id$$

DROP PROCEDURE IF EXISTS `hrm_contract_delete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_contract_delete`(IN `p_contract_id` INT, IN `p_delete_user` VARCHAR(255))
    NO SQL
UPDATE hrm_contract

SET 
	delete_user = p_delete_user,
    delete_time = CURRENT_TIMESTAMP,
	is_deleted = 1

WHERE 
	contract_id = p_contract_id$$

DROP PROCEDURE IF EXISTS `hrm_contract_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_contract_getAll`()
    NO SQL
SELECT *
FROM hrm_contract
WHERE is_deleted = 0$$

DROP PROCEDURE IF EXISTS `hrm_contract_getById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_contract_getById`(IN `p_contract_id` INT)
    NO SQL
SELECT *
FROM hrm_contract
WHERE contract_id = p_contract_id AND
	is_deleted = 0$$

DROP PROCEDURE IF EXISTS `hrm_contract_insert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_contract_insert`(
	IN `p_contract_id_input` VARCHAR(20) CHARSET utf8,
	IN `p_contract_number` VARCHAR(12) CHARSET utf8, 
	IN `p_contract_name` VARCHAR(25) CHARSET utf8, 
	IN `p_description` VARCHAR(500) CHARSET utf8, 
	IN `p_modification` VARCHAR(255) CHARSET utf8, 
	IN `p_value` VARCHAR(255) CHARSET utf8, 
	IN `p_start_date` TIMESTAMP, 
	IN `p_end_date` TIMESTAMP, 
	IN `p_create_user` VARCHAR(255) CHARSET utf8)
    NO SQL
INSERT INTO hrm_contract(
    contract_id_input,
	contract_number,
    contract_name,
    description,
    modification,
    `value`,
    start_date,
    end_date,
    create_time,
    create_user,
    update_time,

    update_user,
    delete_time,
    delete_user,
    is_deleted
    )
VALUES(
	p_contract_id_input,
    p_contract_number,
    p_contract_name,
    p_description,
    p_modification,
    p_value,
    p_start_date,
    p_end_date,
    CURRENT_TIMESTAMP,
    p_create_user,
    CURRENT_TIMESTAMP,
    p_create_user,
    NULL,
    NULL,
    0
    )$$

DROP PROCEDURE IF EXISTS `hrm_contract_search`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_contract_search`(
	IN `p_contract_id_input` VARCHAR(12), 
	IN `p_contract_number` VARCHAR(12), 
	IN `p_contract_name` VARCHAR(25), 
	IN `p_modification` VARCHAR(255), 
	IN `p_value` VARCHAR(255), 
	IN `p_start_date` TIMESTAMP, 
	IN `p_end_date` TIMESTAMP)
    NO SQL
SELECT *
FROM hrm_contract
WHERE 
	is_deleted = 0 AND
	(p_contract_id_input = '' OR contract_id_input LIKE CONCAT('%', p_contract_id_input, '%')) AND 
	(p_contract_number = '' OR contract_number LIKE CONCAT('%', p_contract_number, '%')) AND 
	(p_contract_name = '' OR contract_name LIKE CONCAT('%', p_contract_name, '%')) AND
	(p_modification = '' OR modification LIKE CONCAT('%', p_modification, '%')) AND
	(p_value = '' OR `value` LIKE CONCAT('%', p_value, '%')) AND
	( (p_start_date IS NULL AND p_end_date IS NULL ) OR ( start_date >= p_start_date AND end_date <= p_end_date ))$$

DROP PROCEDURE IF EXISTS `hrm_contract_update`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_contract_update`(
	IN `p_contract_id_input` VARCHAR(20),	 
	IN `p_contract_number` VARCHAR(12), 
	IN `p_contract_name` VARCHAR(25), 
	IN `p_description` VARCHAR(500), 
	IN `p_modification` VARCHAR(255), 
	IN `p_value` VARCHAR(255), 
	IN `p_start_date` TIMESTAMP, 
	IN `p_end_date` TIMESTAMP, 
	IN `p_update_user` VARCHAR(255), 
	IN `p_contract_id` INT)
    NO SQL
UPDATE hrm_contract

SET 
	contract_id_input = p_contract_id_input,
	contract_number = p_contract_number,
	contract_name = p_contract_name,
    description = p_description,
    modification = p_modification,
    `value` = p_value,
    start_date = p_start_date,
    end_date = p_end_date,
    update_user = p_update_user,
    update_time = CURRENT_TIMESTAMP    

WHERE contract_id = p_contract_id$$

DROP PROCEDURE IF EXISTS `hrm_country_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_country_getAll`()
    NO SQL
SELECT *
FROM hrm_country
WHERE is_deleted = 0$$

DROP PROCEDURE IF EXISTS `hrm_department_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_department_getAll`()
    NO SQL
SELECT *
FROM hrm_department
WHERE is_deleted = 0$$

DROP PROCEDURE IF EXISTS `hrm_education_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_education_getAll`()
    NO SQL
SELECT *
FROM hrm_education
WHERE is_deleted = 0$$

DROP PROCEDURE IF EXISTS `hrm_employee_insert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_employee_insert`(
	IN `p_emp_id_input` VARCHAR(50), 
	IN `p_first_name` VARCHAR(50), 
	IN `p_last_name` VARCHAR(50), 
	IN `p_mid_name` VARCHAR(50), 
	IN `p_street` VARCHAR(255), 
	IN `p_city` VARCHAR(255), 
	IN `p_state_id` INT, 
	IN `p_zipcode` VARCHAR(10), 
	IN `p_country_id` INT, 
	IN `p_position_type` VARCHAR(255), 
	IN `p_hired_date` TIMESTAMP, 
	IN `p_salary` VARCHAR(100), 
	IN `p_work_time_id` INT, 
	IN `p_email` VARCHAR(100), 
	IN `p_mobile` VARCHAR(50), 
	IN `p_home_number` VARCHAR(255), 
	IN `p_clearance_lv_id` INT, 

	IN `p_contract_id` INT, 
	IN `p_department_id` INT, 
	IN `p_program` VARCHAR(255), 
	IN `p_program_manager` VARCHAR(255), 
	IN `p_poc_phone` VARCHAR(50), 
	IN `p_evaluation_date` TIMESTAMP, 
	IN `p_tax_info` VARCHAR(255), 
	IN `p_court_order` VARCHAR(255), 
	IN `p_county` VARCHAR(255), 
	IN `p_court_address` VARCHAR(255), 
	IN `p_amount` INT, 
	IN `p_termination_date` TIMESTAMP, 
	IN `p_rehire` BOOLEAN, 
	IN `p_not_hire` BOOLEAN, 
	IN `p_termination_reason_id` INT,
	IN `p_create_user` VARCHAR(255)
	)
    NO SQL
INSERT INTO hrm_employee(
	emp_id_input,
	first_name,
	last_name,
	mid_name, 
	street, 
	city, 
	state_id, 
	zipcode, 
	country_id, 
	position_type, 
	hired_date, 
	salary, 

	work_time_id, 
	email, 
	mobile, 
	home_number, 
	clearance_lv_id, 
	contract_id, 
	department_id, 
	program, 
	program_manager, 
	poc_phone, 
	evaluation_dateP, 
	tax_info, 
	court_order, 
	county, 
	court_address, 
	amount, 
	termination_date, 
	rehire, 
	not_hire, 
	termination_reason_id,
    create_time,
    create_user,
    update_time,
    update_user,
    is_deleted
) 
VALUES(
	p_emp_id_input,
	p_first_name,
	p_last_name,
	p_mid_name, 
	p_street, 
	p_city, 
	p_state_id, 
	p_zipcode, 
	p_country_id, 
	p_position_type, 
	p_hired_date, 
	p_salary, 
	p_work_time_id, 
	p_email, 
	p_mobile, 
	p_home_number, 
	p_clearance_lv_id, 
	p_contract_id, 
	p_department_id, 
	p_program, 
	p_program_manager, 
	p_poc_phone, 
	p_evaluation_dateP, 
	p_tax_info, 
	p_court_order, 
	p_county, 
	p_court_address, 
	p_amount, 
	p_termination_date, 
	p_rehire, 
	p_not_hire, 
	p_termination_reason_id,
    CURRENT_TIMESTAMP,
    p_create_user,
    CURRENT_TIMESTAMP,
    p_create_user,
    0
)$$

DROP PROCEDURE IF EXISTS `hrm_employee_update`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_employee_update`(
	IN `p_emp_id` INT, 
	IN `p_emp_id_input` VARCHAR(50), 
	IN `p_first_name` VARCHAR(50), 
	IN `p_last_name` VARCHAR(50), 
	IN `p_mid_name` VARCHAR(50), 
	IN `p_street` VARCHAR(255), 
	IN `p_city` VARCHAR(255), 
	IN `p_state_id` INT, 
	IN `p_zipcode` VARCHAR(10), 
	IN `p_country_id` INT, 
	IN `p_position_type` VARCHAR(255), 
	IN `p_hired_date` TIMESTAMP, 
	IN `p_salary` VARCHAR(100), 
	IN `p_work_time_id` INT, 
	IN `p_email` VARCHAR(100), 
	IN `p_mobile` VARCHAR(50), 
	IN `p_home_number` VARCHAR(255), 
	IN `p_clearance_lv_id` INT, 
	IN `p_contract_id` INT, 
	IN `p_department_id` INT, 
	IN `p_program` VARCHAR(255), 
	IN `p_program_manager` VARCHAR(255), 
	IN `p_poc_phone` VARCHAR(50), 
	IN `p_evaluation_date` TIMESTAMP, 
	IN `p_tax_info` VARCHAR(255), 
	IN `p_court_order` VARCHAR(255), 
	IN `p_county` VARCHAR(255), 
	IN `p_court_address` VARCHAR(255), 
	IN `p_amount` INT, 
	IN `p_termination_date` TIMESTAMP, 
	IN `p_rehire` BOOLEAN, 
	IN `p_not_hire` BOOLEAN, 
	IN `p_termination_reason_id` INT,
	IN `p_update_user` VARCHAR(255)
	)
    NO SQL
UPDATE hrm_employee
SET 
	emp_id_input = p_emp_id_input,
	first_name = p_first_name,
	last_name = p_last_name,
	mid_name = p_mid_name, 

	street = p_street, 
	city = p_city, 
	state_id = p_state_id, 
	zipcode = p_zipcode, 
	country_id = p_country_id, 
	position_type = p_position_type, 
	hired_date = p_hired_date, 
	salary = p_salary, 
	work_time_id = p_work_time_id, 
	email = p_email, 
	mobile = p_mobile, 
	home_number = p_home_number, 
	clearance_lv_id = p_clearance_lv_id, 
	contract_id = p_contract_id, 
	department_id = p_department_id, 
	program = p_program, 
	program_manager = p_program_manager, 
	poc_phone = p_poc_phone, 
	evaluation_date = p_evaluation_date, 
	tax_info = p_tax_info, 
	court_order = p_court_order, 
	county = p_county, 
	court_address = p_court_address, 
	amount = p_amount, 
	termination_date = p_termination_date, 
	rehire = p_rehire, 
	not_hire = p_not_hire, 
	termination_reason_id = p_termination_reason_id,
    update_time = CURRENT_TIMESTAMP,
    update_user = p_update_user
WHERE 
	emp_id = p_emp_id$$

DROP PROCEDURE IF EXISTS `hrm_person_InsertPersonInfo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_person_InsertPersonInfo`(IN `_client_id` VARCHAR(255), IN `_first_name` VARCHAR(255), IN `_last_name` VARCHAR(255), IN `_birth_date` DATE, IN `_create_user` VARCHAR(255))
    NO SQL
INSERT INTO `hrm_person`(`client_id`, `first_name`, `last_name`, `birth_date`, `create_time`, `update_time`) VALUES (_client_id,_first_name,_last_name,_birth_date,current_timestamp,current_timestamp)$$

DROP PROCEDURE IF EXISTS `hrm_person_UpdatePersonInfo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_person_UpdatePersonInfo`(IN `_client_id` VARCHAR(255), IN `_first_name` VARCHAR(255), IN `_last_name` VARCHAR(255), IN `_birth_date` DATE, IN `_udpate_user` VARCHAR(255))
    NO SQL
update hrm_person
set first_name= _first_name,
	last_name= _last_name,
    birth_date= _birth_date,
    update_time = CURRENT_TIMESTAMP
where client_id = _client_id$$

DROP PROCEDURE IF EXISTS `hrm_position_getall`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_position_getall`()
    NO SQL
SELECT *
FROM hrm_position
WHERE is_deleted = 0$$

DROP PROCEDURE IF EXISTS `hrm_recruitment_delete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_recruitment_delete`(IN `_id` INT, IN `_user_name` VARCHAR(255))
    NO SQL
UPDATE hrm_recruitment
SET  
	delete_time = CURRENT_TIMESTAMP,
    delete_user = _user_name,
    is_deleted = 1
WHERE
	recruitment_id = _id$$

DROP PROCEDURE IF EXISTS `hrm_recruitment_getById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_recruitment_getById`(IN `_id` INT)
    NO SQL
SELECT re.*,
	rt.description as recruitment_type_name,

    gr.description as client_id_position_name

FROM hrm_recruitment re,
	hrm_recruitment_type rt,
    hrm_client cl,
    sys_group gr
    
WHERE re.is_deleted = 0 
	and rt.recruitment_type_id = re.recruitment_type_id
    and cl.client_id = re.client_id_position
    and cl.group_id = gr.group_id
    and re.recruitment_id = _id$$

DROP PROCEDURE IF EXISTS `hrm_recruitment_insert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_recruitment_insert`(IN `_client_id_position` INT, IN `_title` VARCHAR(1000), IN `_expired_date` TIMESTAMP, IN `_enable` BOOLEAN, IN `_job_description` VARCHAR(10000), IN `_job_recruitment` VARCHAR(10000), IN `_create_user` VARCHAR(255), IN `_recruitment_type_id` INT)
    NO SQL
INSERT INTO `hrm_recruitment`
(
`client_id_position`, 
`recruitment_type_id`, `title`,
 `job_description`, `job_recruitment`, 
`enable`, `expired_date`, 
`create_time`, `update_time`, 
`create_user`, `update_user`, 
`delete_user`, `delete_time`, 
`is_deleted`
) 
VALUES 
(
_client_id_position,
_recruitment_type_id,_title,
_job_description,_job_recruitment,
_enable,_expired_date,
CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,
_create_user,_create_user,
NULL,NULL,
0

)$$

DROP PROCEDURE IF EXISTS `hrm_recruitment_search`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_recruitment_search`(IN `_posistion_id` INT, IN `_type_id` INT, IN `_status_id` INT, IN `_from_date` DATE, IN `_to_date` DATE)
    NO SQL
SELECT re.*,
	rt.description as recruitment_type_name,
    gr.group_name as client_id_position_name

FROM hrm_recruitment re,
	hrm_recruitment_type rt,
    hrm_client_group gr
    
WHERE re.is_deleted = 0 
	and rt.recruitment_type_id = re.recruitment_type_id
    and gr.client_id = re.client_id_position
    and (_posistion_id=-1 or gr.client_id = _posistion_id)
    and (_type_id=-1 or re.recruitment_type_id=_type_id)
    and (_status_id=-1 or re.enable = _status_id)
    and (_from_date is null or re.expired_date >= _from_date)
    and (_to_date is null or re.expired_date <= _to_date)$$

DROP PROCEDURE IF EXISTS `hrm_recruitment_type_getList`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_recruitment_type_getList`()
    NO SQL
select * from hrm_recruitment_type$$

DROP PROCEDURE IF EXISTS `hrm_recruitment_update`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_recruitment_update`(IN `_id` INT, IN `_client_id_position` INT, IN `_title` VARCHAR(1000), IN `_expired_date` TIMESTAMP, IN `_enable` BOOLEAN, IN `_job_description` VARCHAR(10000), IN `_job_recruitment` VARCHAR(10000), IN `_create_user` VARCHAR(255), IN `_recruitment_type_id` INT)
UPDATE `hrm_recruitment`

SET
`client_id_position`=_client_id_position, 
`recruitment_type_id`=_recruitment_type_id, `title`=_title,
 `job_description`=_job_description, `job_recruitment`=_job_recruitment, 
`enable`=_enable, `expired_date`=_expired_date, 
`update_time`=CURRENT_TIMESTAMP,`update_user`=_create_user
WHERE
recruitment_id =  _id$$

DROP PROCEDURE IF EXISTS `hrm_recruitment_updateStatus`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_recruitment_updateStatus`(IN `_id` INT, IN `_status` BOOLEAN, IN `_user_name` VARCHAR(255))
    NO SQL
UPDATE hrm_recruitment
SET enable = _status, 
	update_time = CURRENT_TIMESTAMP,
    update_user = _user_name
WHERE
recruitment_id = _id$$

DROP PROCEDURE IF EXISTS `hrm_requisition_delete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_requisition_delete`(IN `p_requisition_id` INT)
    NO SQL
UPDATE hrm_requisition

SET  
    is_deleted = 1
    
WHERE
	requisition_id = p_requisition_id$$

DROP PROCEDURE IF EXISTS `hrm_requisition_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_requisition_getAll`(
	IN `p_contract_id` INT, 
	IN `p_requisition_id` INT, 
	IN `p_location` VARCHAR(255), 
	IN `p_requester` VARCHAR(255), 
	IN `p_position_id` INT, 
	IN `p_status_id` INT, 
	IN `p_dtRequiredDate` DATE)
    NO SQL
SELECT r.*, 
	c.contract_name, c.contract_number,
    p.position_title
FROM hrm_requisition r
LEFT JOIN hrm_contract c ON r.contract_id = c.contract_id 
LEFT JOIN hrm_position p ON r.position_id = p.position_id
LEFT JOIN hrm_state s ON r.state_id = s.state_id
WHERE r.is_deleted = 0
    AND  (p_requisition_id = -1  OR requisition_id = p_requisition_id)
    AND  (p_contract_id = -1  OR p_contract_id = r.contract_id  )
    AND  (p_location = ''  OR r.city_name like  CONCAT('%',p_location,'%'))
    AND  (p_location = ''  OR s.state_name like  CONCAT('%',p_location,'%'))
    AND  (p_requester = ''  OR requester like CONCAT('%',p_requester,'%'))
    AND  (p_position_id = -1  OR p_position_id = r.position_id)
    AND  (p_status_id = -1  OR p_status_id = r.status_id  )
    AND  (p_dtRequiredDate is null OR p_dtRequiredDate = r.required_date)

	
ORDER BY r.requisition_id_input ASC$$

DROP PROCEDURE IF EXISTS `hrm_requisition_getById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_requisition_getById`(IN `p_requisition_id` INT)
    NO SQL
SELECT r.*, 
	c.contract_number, c.contract_name,
    p.position_title
FROM hrm_requisition r
LEFT JOIN hrm_contract c ON r.contract_id = c.contract_id
LEFT JOIN hrm_position p ON r.position_id = p.position_id
WHERE 
	r.is_deleted = 0 AND
	r.requisition_id = p_requisition_id$$

DROP PROCEDURE IF EXISTS `hrm_requisition_insert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_requisition_insert`(
	IN `p_requisition_id_input` VARCHAR(200), 
	IN `p_contract_id` INT, 
	IN `p_requester` VARCHAR(20), 
	IN `p_position_id` INT, 
	IN `p_required_date` TIMESTAMP, 
	IN `p_status_id` INT, 

	IN `p_salary_range` VARCHAR(200), 
	IN `p_clearance_lv_id` INT, 
	IN `p_certificate_req` VARCHAR(100), 
	IN `p_education_id` INT,
	IN `p_education_other` VARCHAR(255),
	IN `p_city_name` VARCHAR(255), 
	IN `p_state_id` INT, 
	IN `p_country_id` INT, 
	IN `p_attachment` VARCHAR(255), 
	IN `p_create_user` VARCHAR(255), 
	IN `p_update_user` VARCHAR(255))
    NO SQL
INSERT INTO `hrm_requisition`(
	`requisition_id_input`, 
	`contract_id`,
    `requester`, 
    `position_id`, 
    `required_date`, 
    `status_id`, 
    `salary_range`, 
    `clearance_lv_id`, 
    `certificate_req`, 
    `education_id`, 
	`education_other`,
    `city_name`,
    `state_id`,
    `country_id`,
    `attachment`,
    `create_time`,
    `create_user`,
    `update_time`,
    `update_user`,
    `is_deleted`
) 
VALUES(

    p_requisition_id_input,
    p_contract_id,
    p_requester,
    p_position_id,
    p_required_date,
    p_status_id,
    p_salary_range,
    p_clearance_lv_id,
    p_certificate_req,
    p_education_id,
	p_education_other,
    p_city_name,
    p_state_id,
    p_country_id,
    p_attachment,
    CURRENT_TIMESTAMP,
    p_create_user,
    CURRENT_TIMESTAMP,
    p_update_user,

    0
)$$

DROP PROCEDURE IF EXISTS `hrm_requisition_update`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_requisition_update`(
	IN `p_requisition_id` INT, 
	IN `p_requisition_id_input` VARCHAR(200), 
	IN `p_contract_id` INT, 
	IN `p_requester` VARCHAR(20), 
	IN `p_position_id` INT, 
	IN `p_required_date` TIMESTAMP, 
	IN `p_status_id` INT, 
	IN `p_salary_range` VARCHAR(100), 
	IN `p_clearance_lv_id` INT, 
	IN `p_certificate_req` VARCHAR(100), 
	IN `p_education_id` INT, 
	IN `p_education_other` VARCHAR(255),
	IN `p_city_name` VARCHAR(255), 
	IN `p_state_id` INT, 
	IN `p_country_id` INT, 
	IN `p_attachment` VARCHAR(255), 
	IN `p_update_user` VARCHAR(255))
    NO SQL
UPDATE hrm_requisition

SET
	requisition_id_input = p_requisition_id_input,
    contract_id = p_contract_id,
    requester = p_requester,
    position_id = p_position_id,
    required_date = p_required_date,
    status_id = p_status_id,
    salary_range = p_salary_range,
    clearance_lv_id = p_clearance_lv_id,
    certificate_req = p_certificate_req,
    education_id = p_education_id,
	education_other = p_education_other,
    city_name = p_city_name,
    state_id = p_state_id,
    country_id = p_country_id,
    attachment = p_attachment,
    update_time = CURRENT_TIMESTAMP,
    update_user = p_update_user
    

WHERE
	requisition_id = p_requisition_id$$

DROP PROCEDURE IF EXISTS `hrm_state_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_state_getAll`()
    NO SQL
SELECT *
FROM hrm_state
WHERE is_deleted = 0
ORDER BY no_state, state_name$$

DROP PROCEDURE IF EXISTS `hrm_status_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_status_getAll`()
    NO SQL
SELECT *
FROM hrm_status
WHERE is_deleted = 0
ORDER BY is_other ASC, status_id ASC$$

DROP PROCEDURE IF EXISTS `hrm_termination_reason_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_termination_reason_getAll`()
    NO SQL
SELECT *
FROM hrm_termination_reason
WHERE is_deleted = 0$$

DROP PROCEDURE IF EXISTS `hrm_work_time_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hrm_work_time_getAll`()
    NO SQL
SELECT *
FROM hrm_work_time
WHERE is_deleted = 0$$

DROP PROCEDURE IF EXISTS `sys_group_delete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_group_delete`(IN `id` INT, IN `_username` VARCHAR(255))
    NO SQL
UPDATE sys_group
SET is_deleted = 1,
	delete_user = _username,
    delete_time = CURRENT_TIMESTAMP
WHERE group_id = id$$

DROP PROCEDURE IF EXISTS `sys_group_genid`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_group_genid`()
    NO SQL
select group_id + 1 from sys_group order by create_time desc$$

DROP PROCEDURE IF EXISTS `sys_group_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_group_getAll`(IN `_strSearch` VARCHAR(500))
    NO SQL
SELECT * FROM sys_group 
WHERE is_deleted = 0
	AND (_strSearch='' 
         OR group_name like CONCAT('%',_strSearch,'%')
         OR description like CONCAT('%',_strSearch,'%')
         )
 order by create_time desc$$

DROP PROCEDURE IF EXISTS `sys_group_insert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_group_insert`(IN `_group_name` VARCHAR(255), IN `_description` VARCHAR(1000), IN `_username` VARCHAR(255), IN `_group_id` INT)
    NO SQL
INSERT INTO sys_group
(
    group_id,
    group_name,
    description,
    update_time,

    update_user,
    create_time,
    create_user,
    is_deleted
)
VALUES(
    _group_id,
    _group_name,
    _description,
    CURRENT_TIMESTAMP,
    _username,
    CURRENT_TIMESTAMP,

    _username,
    0
    )$$

DROP PROCEDURE IF EXISTS `sys_group_update`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_group_update`(IN `_group_id` INT, IN `_group_name` VARCHAR(255), IN `_description` VARCHAR(1000), IN `_username` VARCHAR(255))
    NO SQL
UPDATE sys_group
SET group_name= _group_name,
	description= _description,
    update_time = CURRENT_TIMESTAMP,
    update_user = _username
WHERE group_id= _group_id$$

DROP PROCEDURE IF EXISTS `sys_permission_getByGroupID`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_permission_getByGroupID`(IN `_keyword` VARCHAR(255), IN `_group_id` VARCHAR(255))
    NO SQL
SELECT pp.*, ifnull(pg.permission_id,0) as applied
FROM sys_permission  pp

LEFT JOIN sys_permission_group pg ON pp.permission_id = pg.permission_id
AND pg.group_id = _group_id 
WHERE (_keyword = '' 
     OR pp.permission_id like concat('%', _keyword ,'%')
     OR pp.description like concat('%', _keyword ,'%'))
ORDER BY pp.permission_id$$

DROP PROCEDURE IF EXISTS `sys_permission_group_add`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_permission_group_add`(IN `_group_id` VARCHAR(255), IN `_permission_id` VARCHAR(255))
    NO SQL
INSERT INTO sys_permission_group(group_id,permission_id,create_time,update_time)
VALUES(_group_id
	, _permission_id
       , current_timestamp
       ,current_timestamp)$$

DROP PROCEDURE IF EXISTS `sys_permission_group_remove`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_permission_group_remove`(IN `_group_id` VARCHAR(255), IN `_permission_id` VARCHAR(255))
    NO SQL
DELETE FROM sys_permission_group 
WHERE group_id = _group_id
	AND permission_id = _permission_id$$

DROP PROCEDURE IF EXISTS `sys_status_getAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_status_getAll`()
    NO SQL
select * from sys_status$$

DROP PROCEDURE IF EXISTS `sys_user_delete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_user_delete`(IN `_user_name` VARCHAR(255), IN `_delete_user` VARCHAR(255))
    NO SQL
update sys_user 
set is_deleted = 1,
	delete_time = current_timestamp,
    delete_user = _delete_user
where user_name= _user_name$$

DROP PROCEDURE IF EXISTS `sys_user_getByEmail`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_user_getByEmail`(IN `_email` VARCHAR(255))
    NO SQL
select * from sys_user where email=_email$$

DROP PROCEDURE IF EXISTS `sys_user_getByUsername`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_user_getByUsername`(IN `username` VARCHAR(200))
    NO SQL
SELECT u.*,
    ps.first_name, ps.last_name, ps.birth_date,
    ct.contact_id, ct.phone, ct.address, cl.client_type_id,
	g.group_id,g.group_name
FROM SYS_USER u
	LEFT JOIN hrm_client cl ON cl.client_id = u.client_id
    LEFT JOIN sys_group g ON g.group_id = cl.group_id
    LEFT JOIN hrm_client_contact clt ON clt.client_id = cl.client_id
    LEFT JOIN hrm_contact ct ON ct.contact_id = clt.contact_id
    LEFT JOIN hrm_person ps ON ps.client_id = cl.client_id
WHERE u.IS_DELETED=0
	AND u.USER_NAME=username$$

DROP PROCEDURE IF EXISTS `sys_user_InsertUserInfo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_user_InsertUserInfo`(IN `_client_id` VARCHAR(255), IN `_user_name` VARCHAR(255), IN `_password` VARCHAR(255), IN `_email` VARCHAR(255), IN `_status_id` VARCHAR(255), IN `_create_user` VARCHAR(255))
    NO SQL
INSERT INTO `sys_user`(`user_name`, `password`, `password_hint`, `email`, `client_id`, `status_id`, `create_time`, `update_time`, `create_user`, `update_user`, `delete_time`, `delete_user`, `is_deleted`, `forgot_key`) VALUES (_user_name,_password,'',_email,_client_id,_status_id,current_timestamp,current_timestamp,_create_user,_create_user,null,null,0,null)$$

DROP PROCEDURE IF EXISTS `sys_user_search`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_user_search`(IN `_keyword` VARCHAR(550), IN `_group_id` INT, IN `_client_type_id` VARCHAR(255), IN `_status_id` VARCHAR(255))
    NO SQL
SELECT u.user_name, u.email, u.client_id, u.status_id,
	u.update_time, u.update_user,
    ps.first_name, ps.last_name, ps.birth_date,
    ct.contact_id, ct.phone, ct.address,
	g.group_id,g.group_name,st.description as  status_name
FROM SYS_USER u
	LEFT JOIN hrm_client cl ON cl.client_id = u.client_id
    LEFT JOIN sys_group g ON g.group_id = cl.group_id
    LEFT JOIN hrm_client_contact clt ON clt.client_id = cl.client_id

    LEFT JOIN hrm_contact ct ON ct.contact_id = clt.contact_id
    LEFT JOIN hrm_person ps ON ps.client_id = cl.client_id
    LEFT JOIN sys_status st ON st.status_id = u.status_id 
WHERE u.IS_DELETED=0
	AND (_keyword='' 
		OR u.USER_NAME=_keyword
        OR u.EMAIL = _keyword
        OR ps.first_name =_keyword
        OR ps.last_name =_keyword
        OR ct.phone = _keyword
        )
    AND (_group_id = 0
         OR cl.group_id = _group_id)
    AND (_client_type_id = ''
         OR cl.client_type_id = _client_type_id)
    AND (_status_id=''
         OR u.status_id = _status_id)$$

DROP PROCEDURE IF EXISTS `sys_user_update`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_user_update`(IN _user_name VARCHAR(255), IN _password VARCHAR(255), IN _password_hint VARCHAR(255), IN _client_id INT, IN _status_id INT, IN _update_user VARCHAR(255), IN _forgot_key VARCHAR(255))
UPDATE `sys_user` SET 
	`password`=_password,
	`password_hint`=_password_hint,
	`client_id`=_client_id,
	`status_id`=_status_id,
	`update_time`= CURRENT_TIMESTAMP,
	`update_user`=_update_user,
	`forgot_key`=_forgot_key
WHERE `user_name`=_user_name$$

DROP PROCEDURE IF EXISTS `sys_user_updateFull`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_user_updateFull`(IN `_user_name` VARCHAR(255), IN `_email` VARCHAR(255), IN `_group_id` VARCHAR(255), IN `_client_type_id` VARCHAR(255), IN `_first_name` VARCHAR(255), IN `_last_name` VARCHAR(255), IN `_dBirthDate` DATE, IN `_phone` VARCHAR(255), IN `_address` VARCHAR(4000), IN `_udpate_user` VARCHAR(255), IN `_client_id` VARCHAR(255))
    NO SQL
begin
Update sys_user 
set email = _email,
	update_time = CURRENT_TIMESTAMP,
    update_user = _udpate_user
where user_name = _user_name;

update hrm_client
set group_id= _group_id,
	client_type_id= _client_type_id,
    update_time = CURRENT_TIMESTAMP
where client_id = _client_id;

update hrm_person
set first_name= _first_name,
	last_name= _last_name,
    birth_date= _dBirthDate,
    update_time = CURRENT_TIMESTAMP
where client_id = _client_id;

update hrm_contact
set phone= _phone,
	address= _address,
    update_time = CURRENT_TIMESTAMP
where contact_id 
in (select contact_id 
    from hrm_client_contact 
    where client_id = _client_id);

end$$

DROP PROCEDURE IF EXISTS `sys_user_UpdateUserInfo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sys_user_UpdateUserInfo`(IN `_user_name` VARCHAR(255), IN `_email` VARCHAR(255), IN `_status_id` VARCHAR(255), IN `_udpate_user` VARCHAR(255))
    NO SQL
Update sys_user 
set email = _email,
	status_id = _status_id,
	update_time = CURRENT_TIMESTAMP,
    update_user = _udpate_user
where user_name = _user_name$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `client_relationship`
--

DROP TABLE IF EXISTS `client_relationship`;
CREATE TABLE IF NOT EXISTS `client_relationship` (
  `client_id_from` varchar(20) NOT NULL,
  `client_id_to` varchar(20) NOT NULL,
  `role_type_from` varchar(20) NOT NULL,
  `role_type_to` varchar(20) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `general_id`
--

DROP TABLE IF EXISTS `general_id`;
CREATE TABLE IF NOT EXISTS `general_id` (
  `general_id` varchar(255) NOT NULL,
  `value` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `hrm_candidate_tracker`
--

DROP TABLE IF EXISTS `hrm_candidate_tracker`;
CREATE TABLE IF NOT EXISTS `hrm_candidate_tracker` (
  `candidate_tracker_id` int(11) NOT NULL,
  `candidate_tracker_id_input` varchar(20) DEFAULT NULL,
  `contract_id` int(11) DEFAULT NULL,
  `requisition_id` int(11) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `clearance_lv_id` int(11) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  `education_id` int(11) DEFAULT NULL,
  `education_other` varchar(255) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `mid_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `status_other` varchar(50) DEFAULT NULL,
  `job_location` varchar(255) DEFAULT NULL,
  `refered_location` varchar(255) DEFAULT NULL,
  `salary_range` varchar(50) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `email_type` int(11) DEFAULT NULL,
  `email_first` varchar(100) DEFAULT NULL,
  `email_second` varchar(100) DEFAULT NULL,
  `email_third` varchar(100) DEFAULT NULL,
  `phone_first` varchar(30) DEFAULT NULL,
  `phone_second` varchar(30) DEFAULT NULL,
  `phone_third` varchar(30) DEFAULT NULL,
  `email_date_type` int(11) DEFAULT NULL,
  `email_date` timestamp NULL DEFAULT NULL,
  `call_date_type` int(11) DEFAULT NULL,
  `call_date` timestamp NULL DEFAULT NULL,
  `phone_screen_date` timestamp NULL DEFAULT NULL,
  `candidate_comment` varchar(1000) DEFAULT NULL,
  `dvs_comment` varchar(1000) DEFAULT NULL,
  `alt_position` varchar(255) DEFAULT NULL,
  `best_time_contact` varchar(50) DEFAULT NULL,
  `certification` varchar(100) DEFAULT NULL,
  `q_qualification` varchar(1000) DEFAULT NULL,
  `q_background` varchar(1000) DEFAULT NULL,
  `q_technical_skill` varchar(1000) DEFAULT NULL,
  `q_expected_salary` varchar(50) DEFAULT NULL,
  `q_communication` varchar(1000) DEFAULT NULL,
  `q_initiative` varchar(1000) DEFAULT NULL,
  `available_start_date` timestamp NULL DEFAULT NULL,
  `question1` varchar(1000) NOT NULL,
  `question2` varchar(1000) NOT NULL,
  `question3` varchar(1000) NOT NULL,
  `question4` varchar(1000) NOT NULL,
  `question5` varchar(1000) NOT NULL,
  `description1` varchar(1000) NOT NULL,
  `description2` varchar(1000) NOT NULL,
  `description3` varchar(1000) NOT NULL,
  `description4` varchar(1000) NOT NULL,
  `description5` varchar(1000) NOT NULL,
  `attachment` varchar(1000) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(255) DEFAULT NULL,
  `delete_time` timestamp NULL DEFAULT NULL,
  `delete_user` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_candidate_tracker`
--

INSERT INTO `hrm_candidate_tracker` (`candidate_tracker_id`, `candidate_tracker_id_input`, `contract_id`, `requisition_id`, `state_id`, `country_id`, `status_id`, `clearance_lv_id`, `position_id`, `education_id`, `education_other`, `first_name`, `mid_name`, `last_name`, `city`, `status_other`, `job_location`, `refered_location`, `salary_range`, `experience`, `email_type`, `email_first`, `email_second`, `email_third`, `phone_first`, `phone_second`, `phone_third`, `email_date_type`, `email_date`, `call_date_type`, `call_date`, `phone_screen_date`, `candidate_comment`, `dvs_comment`, `alt_position`, `best_time_contact`, `certification`, `q_qualification`, `q_background`, `q_technical_skill`, `q_expected_salary`, `q_communication`, `q_initiative`, `available_start_date`, `question1`, `question2`, `question3`, `question4`, `question5`, `description1`, `description2`, `description3`, `description4`, `description5`, `attachment`, `create_time`, `create_user`, `update_time`, `update_user`, `delete_time`, `delete_user`, `is_deleted`) VALUES
(1, 'CT01', NULL, 51, 1, 1, 4, 4, 3, 3, '', 'Vo', 'Minh', 'Vo', 'HCM', 'Others', 'Job location', '', '5000-10000', '1 year"', 1, 'vominhvo@yahoo.com', '', '', '01285388963', '', '', 1, '2015-05-19 17:00:00', 1, '2015-05-19 17:00:00', NULL, 'a', 'b', 'Alternative position', '11h00', 'BPMN', '', '', '', '', '', '', '2015-05-20 17:00:00', 'Question 1', 'Question 2', 'Question 3', 'Description1', 'Q5', 'Description3', 'admin', 'Description 1', 'admin', 'Description 2', '', '2015-05-19 15:33:02', 'admin', '2015-06-16 16:42:14', 'admin', '2015-05-20 04:51:00', 'admin', 0),
(2, 'CT022', 2, 44, 64, 1, 2, 1, 1, 8, '', 'Nguyen', 'Thanh', 'Hung', 'Ha Noi', '', 'asdasd', '', 'asdasd', 'experience', 1, 'asdasd', 'vovo@yahoo.com', '', 'asdas', '', '', 1, '2015-05-21 17:00:00', 1, '2015-05-29 17:00:00', NULL, 'asd', 'asdasd', 'asdasd', 'asda', 'asdasd', '', '', '', '', '', '', NULL, 'Question 1', 'Question 2', 'Question 3', 'Question 4', 'Question 5', 'Description 1', 'Description 2', 'Description 3', 'Description 4', 'Description 5', '45175ket qua tuyen sinh 1.xlsx', '2015-05-20 04:32:51', 'admin', '2015-06-19 12:52:35', 'admin', NULL, NULL, 0),
(3, 'CT03', NULL, 38, 1, 1, 1, 5, 4, 3, '', 'Vy', 'Minh', 'Vy', 'HCM', 'Others', 'Job location', '', '5000-10000', '2 year', 1, 'vominhvo@yahoo.com', '', '', '01285388963', '', '', 1, '2015-05-21 17:00:00', 1, '2015-05-22 17:00:00', NULL, 'A', 'B', 'Alternative position', '13h00', 'BPMN', '', '', '', '', '', '', NULL, 'Question 1', 'Question 2', 'Question 3', 'Question 4', 'Question 5', 'Description 1', 'Description 2', 'Description 3', 'Description 4', 'Description 5', '68096DOANH THU HANG DIEN MAY - 16-04-2015.xlsx', '2015-05-22 02:27:36', 'admin', '2015-06-17 14:41:21', 'admin', NULL, NULL, 0),
(4, 'CT04', NULL, 51, 64, 1, 1, 9, 2, 4, '', 'Dung', '', 'Phan', 'Ha Noi', 'Others', 'Job location', '', '5000-10000', 'Experiences', 1, 'dungphanit@gmail.com', 'dung@yahoo.com', '', '088888888', '222222', '', 1, '2015-05-21 17:00:00', 1, '2015-05-21 17:00:00', NULL, 'Candidate comment', 'DVS comment', 'Alternative position', 'Best time contact', 'Certification', '', '', '', '', '', '', NULL, 'Question 1', 'Question 2', 'Question 3', 'Question 4', 'Question 5', 'Description 1', 'Description 2', 'Description 3', 'Description 4', 'Description 5', '108065LO HANG.xlsx', '2015-05-22 04:59:21', 'admin', '2015-06-17 14:41:03', 'admin', NULL, NULL, 0),
(5, 'CT05', NULL, 43, 1, 1, 4, 5, 3, 2, '', 'Vo', '', 'Vo', 'Ha Noi', 'Others', 'Job location', '', '5000-10000', '2 year', 1, 'vominhvo@yahoo.com', '', '', '01285388963', '', '', 1, '2015-05-29 17:00:00', 1, '2015-05-29 17:00:00', NULL, 'A', 'B', 'Alternative position', 'Best time contact', 'BPMN', '', '', '', '', '', '', NULL, 'Question 1', 'Question 2', 'Question 3', 'Question 4', 'Question 5', 'Description 1', 'Description 2', 'Description 3', 'Description 4', 'Description 5', '56557Phieu danh gia thuc tap.docx', '2015-05-22 07:00:38', 'admin', '2015-05-22 09:32:21', 'admin', NULL, NULL, 0),
(6, 'CT06', NULL, 51, 64, 1, 4, 4, 2, 4, '', 'Vo', 'Vo', 'Minh ', 'HCM', 'Others', 'Job location', '', '56789', '1 year', 2, 'vominhvo@yahoo.com', '', '', '01285388963', '', '', 1, '2015-05-25 17:00:00', 1, '2015-05-26 17:00:00', NULL, 'A', 'B', 'Alternative position', '11h00', 'BPMN', '', '', '', '', '', '', NULL, 'Question 1', 'Question 2', 'Question 3', 'Question 4', 'Question 5', 'Description 1', 'Description 2', 'Description 3', 'Description 4', 'Description 5', '16097The Past Tense.docx', '2015-05-25 06:52:47', 'admin', '2015-05-25 06:52:47', 'admin', NULL, NULL, 0),
(7, 'CT07', NULL, 38, 2, 1, 4, 3, 2, 3, '', 'Linh', 'Chi', 'Tran', 'HCM', 'Others', 'job location', '', '$25.000-$30.000', 'Experience', NULL, 'dungphanit@gmail.com', 'dung@yahoo.com', '', '0999999331', '', '07647832', 1, '2015-06-23 17:00:00', 1, '2015-06-18 17:00:00', NULL, 'candidate comment', 'dvs comment', 'alt position', 'best', 'certification', '', '', '', '', '', '', NULL, 'Question 1', 'Question 2', 'Question 3', 'Question 4', 'Question 5', 'Description 1', 'Description 2', 'Description 3', 'Description 4', 'Description 5', '30842PFCLopezRuizAnnex3.pdf', '2015-06-17 13:39:04', 'admin', '2015-06-17 13:43:34', 'admin', NULL, NULL, 0),
(8, 'E032', 1, 61, 1, 1, 1, 1, 1, 9, 'ddd', 'Linh', 'Chi', 'Tran', 'HCM', 'Others', 'job location', '', '$25.000-$30.000', 'exp', NULL, 'dungphanit@gmail.com', '', '', '0999999331', '', '', 1, '2015-06-17 17:00:00', 1, '2015-06-17 17:00:00', NULL, 'candidate comment', 'dvs comment', 'alt position', 'best', 'certification', '', '', '', '', '', '', NULL, 'Question 1', 'Question 2', 'Question 3', 'Question 4', 'Question 5', 'Description 1', 'Description 2', 'Description 3', 'Description 4', 'Description 5', '36586PFCLopezRuizAnnex3.pdf', '2015-06-18 02:02:11', 'admin', '2015-06-19 09:29:21', 'admin', NULL, NULL, 0),
(9, 'CT10', 10, 38, 64, 1, 3, 3, 3, 6, '', 'Vu', 'Tuan', 'Anh', 'HCM', 'Others', 'job location', '', '$25.000-$30.000', 'Exp', NULL, 'dungphanit@gmail.com', 'dung@yahoo.com', '', '0999999331', '88888', '', 1, '2015-06-17 17:00:00', 1, '2015-06-17 17:00:00', NULL, 'candidate comment', 'dvs comment', 'alt position', 'best', 'certification', '', '', '', '', '', '', NULL, 'Question 1', 'Question 2', 'Question 3', 'Question 4', 'Question 5', 'Description 1', 'Description 2', 'Description 3', 'Description 4', 'Description 5', '17999PFCLopezRuizAnnex3.pdf', '2015-06-18 02:28:54', 'admin', '2015-06-18 02:28:54', 'admin', NULL, NULL, 0),
(10, 'CT11', 3, 61, 2, 1, 2, 3, 3, 1, '', 'Vo', 'Vo', '11', 'HCM', '', 'job location', '', '$25.000-$30.000', 'exp', NULL, 'abc@yahoo.com', 'vovo@yahoo.com', 'xyz@gmail.com', '0999999331', '0923222222', '', 1, '2015-06-17 17:00:00', 1, '2015-06-18 17:00:00', NULL, 'candidate comment', 'dvs comment', 'alt position', 'best', 'certification', '', '', '', '', '', '', NULL, 'Question 1', 'Question 2', 'Question 3', 'Question 4', 'Question 5', 'Description 1', 'Description 2', 'Description 3', 'Description 4', 'Description 5', '10846PFCLopezRuizAnnex3.pdf', '2015-06-18 08:00:15', 'admin', '2015-06-18 08:00:31', 'admin', NULL, NULL, 0),
(11, 'E02', 5, 38, 1, 1, 5, 11, 4, 4, '', 'Vo', 'Minh', 'Vo', 'No 4', 'aa', 'job location', '', '$25.000-$30.000', 'sss', NULL, 'sss', 'sss', '', 'sss', '', '', 1, '2015-06-18 17:00:00', 1, '2015-06-18 17:00:00', NULL, 'candidate comment', 'dvs comment', 'alt position', 'best', 'certification', '', '', '', '', '', '', NULL, 'Question 1', 'Question 2', 'Question 3', 'Question 4', 'Question 5', 'Description 1', 'Description 2', 'Description 3', 'Description 4', 'Description 5', '86858PFCLopezRuizAnnex3.pdf', '2015-06-19 12:55:31', 'admin', '2015-06-19 12:56:03', 'admin', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_city`
--

DROP TABLE IF EXISTS `hrm_city`;
CREATE TABLE IF NOT EXISTS `hrm_city` (
  `city_id` int(11) NOT NULL,
  `zipcode` char(5) NOT NULL,
  `city_name` varchar(255) NOT NULL,
  `state_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_city`
--

INSERT INTO `hrm_city` (`city_id`, `zipcode`, `city_name`, `state_id`) VALUES
(1, '99501', 'Anchorage', 1),
(1, '99502', 'Anchorage', 1),
(1, '99503', 'Anchorage', 1),
(1, '99504', 'Anchorage', 1),
(1, '99507', 'Anchorage', 1),
(1, '99508', 'Anchorage', 1),
(1, '99513', 'Anchorage', 1),
(1, '99515', 'Anchorage', 1),
(1, '99516', 'Anchorage', 1),
(1, '99517', 'Anchorage', 1),
(1, '99518', 'Anchorage', 1),
(1, '99529', 'Anchorage', 1),
(1, '99530', 'Anchorage', 1),
(1, '99599', 'Anchorage', 1),
(2, '99505', 'Jber', 1),
(2, '99506', 'Jber', 1),
(3, '99540', 'Indian', 1),
(4, '99556', 'Anchor Point', 1),
(5, '99567', 'Chugiak', 1),
(6, '99568', 'Clam Gulch', 1),
(7, '99572', 'Cooper Landing', 1),
(8, '99573', 'Copper Center', 1),
(9, '99577', 'Eagle River', 1),
(10, '99586', 'Gakona', 1),
(11, '99588', 'Glennallen', 1),
(12, '99603', 'Homer', 1),
(13, '99605', 'Hope', 1),
(14, '99610', 'Kasilof', 1),
(15, '99611', 'Kenai', 1),
(16, '99615', 'Kodiak', 1),
(17, '99623', 'Wasilla', 1),
(17, '99654', 'Wasilla', 1),
(18, '99631', 'Moose Pass', 1),
(19, '99639', 'Ninilchik', 1),
(20, '99645', 'Palmer', 1),
(21, '99664', 'Seward', 1),
(22, '99669', 'Soldotna', 1),
(23, '99672', 'Sterling', 1),
(24, '99676', 'Talkeetna', 1),
(25, '99686', 'Valdez', 1),
(26, '99688', 'Willow', 1),
(27, '99701', 'Fairbanks', 1),
(27, '99709', 'Fairbanks', 1),
(27, '99712', 'Fairbanks', 1),
(27, '99775', 'Fairbanks', 1),
(27, '99790', 'Fairbanks', 1),
(28, '99702', 'Eielson Afb', 1),
(29, '99703', 'Fort Wainwright', 1),
(30, '99704', 'Clear', 1),
(31, '99705', 'North Pole', 1),
(32, '99714', 'Salcha', 1),
(33, '99731', 'Fort Greely', 1),
(34, '99737', 'Delta Junction', 1),
(35, '99743', 'Healy', 1),
(36, '99760', 'Nenana', 1),
(37, '99779', 'Tok', 1),
(37, '99780', 'Tok', 1),
(38, '99801', 'Juneau', 1),
(38, '99811', 'Juneau', 1),
(39, '99824', 'Douglas', 1),
(40, '99827', 'Haines', 1),
(41, '99835', 'Sitka', 1),
(42, '99901', 'Ketchikan', 1),
(43, '35004', 'Moody', 2),
(44, '35005', 'Adamsville', 2),
(45, '35006', 'Adger', 2),
(46, '35007', 'Alabaster', 2),
(47, '35010', 'Alexander City', 2),
(48, '35014', 'Alpine', 2),
(49, '35016', 'Arab', 2),
(50, '35019', 'Baileyton', 2),
(51, '35020', 'Bessemer', 2),
(51, '35022', 'Bessemer', 2),
(51, '35023', 'Bessemer', 2),
(52, '35031', 'Blountsville', 2),
(53, '35033', 'Bremen', 2),
(54, '35034', 'Brent', 2),
(55, '35035', 'Brierfield', 2),
(56, '35040', 'Calera', 2),
(57, '35042', 'Centreville', 2),
(58, '35043', 'Chelsea', 2),
(59, '35044', 'Childersburg', 2),
(60, '35045', 'Clanton', 2),
(60, '35046', 'Clanton', 2),
(61, '35049', 'Cleveland', 2),
(62, '35051', 'Columbiana', 2),
(63, '35053', 'Crane Hill', 2),
(64, '35054', 'Cropwell', 2),
(65, '35055', 'Cullman', 2),
(65, '35057', 'Cullman', 2),
(65, '35058', 'Cullman', 2),
(66, '35061', 'Dolomite', 2),
(67, '35062', 'Dora', 2),
(68, '35063', 'Empire', 2),
(69, '35064', 'Fairfield', 2),
(70, '35068', 'Fultondale', 2),
(71, '35071', 'Gardendale', 2),
(72, '35072', 'Goodwater', 2),
(73, '35073', 'Graysville', 2),
(74, '35077', 'Hanceville', 2),
(75, '35078', 'Harpersville', 2),
(76, '35079', 'Hayden', 2),
(77, '35080', 'Helena', 2),
(78, '35083', 'Holly Pond', 2),
(79, '35085', 'Jemison', 2),
(80, '35087', 'Joppa', 2),
(81, '35089', 'Kellyton', 2),
(82, '35091', 'Kimberly', 2),
(83, '35094', 'Leeds', 2),
(84, '35096', 'Lincoln', 2),
(85, '35097', 'Locust Fork', 2),
(86, '35098', 'Logan', 2),
(87, '35111', 'Mc Calla', 2),
(88, '35114', 'Maylene', 2),
(89, '35115', 'Montevallo', 2),
(90, '35116', 'Morris', 2),
(91, '35117', 'Mount Olive', 2),
(92, '35118', 'Mulga', 2),
(93, '35120', 'Odenville', 2),
(94, '35121', 'Oneonta', 2),
(95, '35124', 'Pelham', 2),
(96, '35125', 'Pell City', 2),
(96, '35128', 'Pell City', 2),
(97, '35126', 'Pinson', 2),
(98, '35127', 'Pleasant Grove', 2),
(99, '35130', 'Quinton', 0),
(100, '35131', 'Ragland', 2),
(101, '35133', 'Remlap', 2),
(102, '35135', 'Riverside', 2),
(103, '35136', 'Rockford', 2),
(104, '35143', 'Shelby', 2),
(105, '35147', 'Sterrett', 2),
(106, '35148', 'Sumiton', 2),
(107, '35150', 'Sylacauga', 2),
(107, '35151', 'Sylacauga', 2),
(108, '35160', 'Talladega', 2),
(109, '35171', 'Thorsby', 2),
(110, '35172', 'Trafford', 2),
(111, '35173', 'Trussville', 2),
(112, '35175', 'Union Grove', 2),
(113, '35176', 'Vandiver', 2),
(114, '35178', 'Vincent', 2),
(115, '35179', 'Vinemont', 2),
(116, '35180', 'Warrior', 2),
(117, '35183', 'Weogufka', 2),
(118, '35184', 'West Blocton', 2),
(119, '35186', 'Wilsonville', 2),
(120, '35188', 'Woodstock', 2),
(121, '35203', 'Birmingham', 2),
(121, '35204', 'Birmingham', 2),
(121, '35205', 'Birmingham', 2),
(121, '35206', 'Birmingham', 2),
(121, '35207', 'Birmingham', 2),
(121, '35208', 'Birmingham', 2),
(121, '35209', 'Birmingham', 2),
(121, '35210', 'Birmingham', 2),
(121, '35211', 'Birmingham', 2),
(121, '35212', 'Birmingham', 2),
(121, '35213', 'Birmingham', 2),
(121, '35214', 'Birmingham', 2),
(121, '35215', 'Birmingham', 2),
(121, '35216', 'Birmingham', 2),
(121, '35217', 'Birmingham', 2),
(121, '35218', 'Birmingham', 2),
(121, '35221', 'Birmingham', 2),
(121, '35222', 'Birmingham', 2),
(121, '35223', 'Birmingham', 2),
(121, '35224', 'Birmingham', 2),
(121, '35226', 'Birmingham', 2),
(121, '35228', 'Birmingham', 2),
(121, '35233', 'Birmingham', 2),
(121, '35234', 'Birmingham', 2),
(121, '35235', 'Birmingham', 2),
(121, '35242', 'Birmingham', 2),
(121, '35243', 'Birmingham', 2),
(121, '35244', 'Birmingham', 2),
(122, '35401', 'Tuscaloosa', 2),
(122, '35404', 'Tuscaloosa', 2),
(122, '35405', 'Tuscaloosa', 2),
(122, '35406', 'Tuscaloosa', 2),
(123, '35441', 'Akron', 2),
(124, '35442', 'Aliceville', 2),
(125, '35443', 'Boligee', 2),
(126, '35444', 'Brookwood', 2),
(127, '35446', 'Buhl', 2),
(128, '35447', 'Carrollton', 2),
(129, '35452', 'Coker', 2),
(130, '35453', 'Cottondale', 2),
(131, '35456', 'Duncanville', 2),
(132, '35457', 'Echola', 2),
(133, '35458', 'Elrod', 2),
(134, '35459', 'Emelle', 2),
(135, '35460', 'Epes', 2),
(136, '35461', 'Ethelsville', 2),
(137, '35462', 'Eutaw', 2),
(138, '35463', 'Fosters', 2),
(139, '35464', 'Gainesville', 2),
(140, '35466', 'Gordo', 2),
(141, '35469', 'Knoxville', 2),
(142, '35470', 'Livingston', 2),
(143, '35473', 'Northport', 2),
(143, '35475', 'Northport', 2),
(143, '35476', 'Northport', 2),
(144, '35474', 'Moundville', 2),
(145, '35480', 'Ralph', 2),
(146, '35481', 'Reform', 2),
(147, '35490', 'Vance', 2),
(148, '35501', 'Jasper', 2),
(148, '35503', 'Jasper', 2),
(148, '35504', 'Jasper', 2),
(149, '35540', 'Addison', 2),
(150, '35541', 'Arley', 2),
(151, '35542', 'Bankston', 2),
(152, '35543', 'Bear Creek', 2),
(153, '35544', 'Beaverton', 2),
(154, '35546', 'Berry', 2),
(155, '35548', 'Brilliant', 2),
(156, '35549', 'Carbon Hill', 2),
(157, '35550', 'Cordova', 2),
(158, '35552', 'Detroit', 2),
(159, '35553', 'Double Springs', 2),
(160, '35554', 'Eldridge', 2),
(161, '35555', 'Fayette', 2),
(162, '35563', 'Guin', 2),
(163, '35564', 'Hackleburg', 2),
(164, '35565', 'Haleyville', 2),
(165, '35570', 'Hamilton', 2),
(166, '35571', 'Hodges', 2),
(167, '35572', 'Houston', 2),
(168, '35574', 'Kennedy', 2),
(169, '35575', 'Lynn', 2),
(170, '35576', 'Millport', 2),
(171, '35578', 'Nauvoo', 2),
(172, '35579', 'Oakman', 2),
(173, '35580', 'Parrish', 2),
(174, '35581', 'Phil Campbell', 2),
(175, '35582', 'Red Bay', 2),
(176, '35585', 'Spruce Pine', 2),
(177, '35586', 'Sulligent', 2),
(178, '35587', 'Townley', 2),
(179, '35592', 'Vernon', 2),
(180, '35593', 'Vina', 2),
(181, '35594', 'Winfield', 2),
(182, '35601', 'Decatur', 2),
(182, '35603', 'Decatur', 2),
(183, '35610', 'Anderson', 2),
(184, '35611', 'Athens', 2),
(184, '35613', 'Athens', 2),
(184, '35614', 'Athens', 2),
(185, '35616', 'Cherokee', 2),
(186, '35618', 'Courtland', 2),
(187, '35619', 'Danville', 2),
(188, '35620', 'Elkmont', 2),
(189, '35621', 'Eva', 2),
(190, '35622', 'Falkville', 2),
(191, '35630', 'Florence', 2),
(191, '35633', 'Florence', 2),
(191, '35634', 'Florence', 2),
(192, '35640', 'Hartselle', 2),
(193, '35643', 'Hillsboro', 2),
(194, '35645', 'Killen', 2),
(195, '35646', 'Leighton', 2),
(196, '35647', 'Lester', 2),
(197, '35648', 'Lexington', 2),
(198, '35650', 'Moulton', 2),
(199, '35651', 'Mount Hope', 2),
(200, '35652', 'Rogersville', 2),
(201, '35653', 'Russellville', 2),
(201, '35654', 'Russellville', 2),
(202, '35660', 'Sheffield', 2),
(203, '35661', 'Muscle Shoals', 2),
(204, '35670', 'Somerville', 2),
(205, '35671', 'Tanner', 2),
(206, '35672', 'Town Creek', 2),
(207, '35673', 'Trinity', 2),
(208, '35674', 'Tuscumbia', 2),
(209, '35677', 'Waterloo', 2),
(210, '35739', 'Ardmore', 2),
(211, '35740', 'Bridgeport', 2),
(212, '35741', 'Brownsboro', 2),
(213, '35744', 'Dutton', 2),
(214, '35745', 'Estillfork', 2),
(215, '35746', 'Fackler', 2),
(216, '35747', 'Grant', 2),
(217, '35748', 'Gurley', 2),
(218, '35749', 'Harvest', 2),
(219, '35750', 'Hazel Green', 2),
(220, '35751', 'Hollytree', 2),
(221, '35752', 'Hollywood', 2),
(222, '35754', 'Laceys Spring', 2),
(223, '35755', 'Langston', 2),
(224, '35756', 'Madison', 2),
(224, '35757', 'Madison', 2),
(224, '35758', 'Madison', 2),
(225, '35759', 'Meridianville', 2),
(226, '35760', 'New Hope', 2),
(226, '35761', 'New Market', 2),
(227, '35763', 'Owens Cross Roads', 2),
(228, '35764', 'Paint Rock', 2),
(229, '35765', 'Pisgah', 2),
(230, '35766', 'Princeton', 2),
(231, '35768', 'Scottsboro', 2),
(231, '35769', 'Scottsboro', 2),
(232, '35771', 'Section', 2),
(233, '35772', 'Stevenson', 2),
(234, '35773', 'Toney', 2),
(235, '35774', 'Trenton', 2),
(236, '35775', 'Valhermoso Springs', 2),
(237, '35776', 'Woodville', 2),
(238, '35801', 'Huntsville', 2),
(238, '35802', 'Huntsville', 2),
(238, '35803', 'Huntsville', 2),
(238, '35805', 'Huntsville', 2),
(238, '35806', 'Huntsville', 2),
(238, '35808', 'Huntsville', 2),
(238, '35810', 'Huntsville', 2),
(238, '35811', 'Huntsville', 2),
(238, '35813', 'Huntsville', 2),
(238, '35816', 'Huntsville', 2),
(238, '35824', 'Huntsville', 2),
(239, '35901', 'Gadsden', 2),
(239, '35903', 'Gadsden', 2),
(239, '35904', 'Gadsden', 2),
(239, '35905', 'Gadsden', 2),
(239, '35907', 'Gadsden', 2),
(240, '35906', 'Rainbow City', 2),
(241, '35950', 'Albertville', 2),
(241, '35951', 'Albertville', 2),
(242, '35952', 'Altoona', 2),
(243, '35953', 'Ashville', 2),
(244, '35954', 'Attalla', 2),
(245, '35956', 'Boaz', 2),
(245, '35957', 'Boaz', 2),
(246, '35958', 'Bryant', 2),
(247, '35959', 'Cedar Bluff', 2),
(248, '35960', 'Centre', 2),
(249, '35961', 'Collinsville', 2),
(250, '35962', 'Crossville', 2),
(251, '35963', 'Dawson', 2),
(252, '35966', 'Flat Rock', 2),
(253, '35967', 'Fort Payne', 2),
(253, '35968', 'Fort Payne', 2),
(254, '35971', 'Fyffe', 2),
(255, '35972', 'Gallant', 2),
(256, '35973', 'Gaylesville', 2),
(257, '35974', 'Geraldine', 2),
(258, '35975', 'Groveoak', 2),
(259, '35976', 'Guntersville', 2),
(260, '35978', 'Henagar', 2),
(261, '35979', 'Higdon', 2),
(262, '36005', 'Banks\r\n', 2);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_clearance_level`
--

DROP TABLE IF EXISTS `hrm_clearance_level`;
CREATE TABLE IF NOT EXISTS `hrm_clearance_level` (
  `clearance_lv_id` int(11) NOT NULL,
  `clearance_lv_name` varchar(50) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_clearance_level`
--

INSERT INTO `hrm_clearance_level` (`clearance_lv_id`, `clearance_lv_name`, `create_time`, `create_user`, `update_time`, `update_user`, `is_deleted`) VALUES
(1, 'Pulbic trust:1', '2015-04-27 02:43:37', NULL, '2015-04-27 02:43:37', NULL, 0),
(2, 'Pulbic trust:2', '2015-04-27 02:43:53', NULL, '2015-04-27 02:43:53', NULL, 0),
(3, 'Pulbic trust:3', '2015-04-27 02:45:20', NULL, '2015-04-27 02:45:20', NULL, 0),
(4, 'Pulbic trust:4', '2015-04-29 05:43:39', NULL, '2015-04-29 05:43:39', NULL, 0),
(5, 'Pulbic trust:5', '2015-04-29 05:43:45', NULL, '2015-04-29 05:43:45', NULL, 0),
(6, 'Pulbic trust:6', '2015-04-29 05:43:51', NULL, '2015-04-29 05:43:51', NULL, 0),
(7, 'Secret', '2015-04-27 02:45:29', 'Secret', '2015-04-27 02:45:29', NULL, 0),
(8, 'Top Secret: CI', '2015-04-27 02:49:17', 'Top Secret: CI', '2015-04-27 02:49:17', NULL, 0),
(9, 'Top Secret: CI with poly', '2015-04-27 02:49:39', 'Top Secret: with poly', '2015-04-27 02:49:39', NULL, 0),
(10, 'Top Secret: SCI', '2015-04-27 02:49:57', NULL, '2015-04-27 02:49:57', NULL, 0),
(11, 'Top Secret: SCI with poly', '2015-04-27 02:50:41', NULL, '2015-04-27 02:50:41', NULL, 0),
(12, 'Top Secret: SCI with full Scope', '2015-05-14 07:03:38', NULL, '2015-05-14 07:03:38', NULL, 0),
(13, 'Top Secret: SCI with lifestyle', '2015-05-14 07:03:38', NULL, '2015-05-14 07:03:38', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_client`
--

DROP TABLE IF EXISTS `hrm_client`;
CREATE TABLE IF NOT EXISTS `hrm_client` (
  `client_id` varchar(20) NOT NULL,
  `client_type_id` varchar(20) NOT NULL,
  `group_id` varchar(20) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_client`
--

INSERT INTO `hrm_client` (`client_id`, `client_type_id`, `group_id`, `create_time`, `update_time`) VALUES
('1', 'PERSON', '1', NULL, '2015-04-28 06:28:58'),
('10', '1', '3', '2015-04-26 18:06:29', '2015-04-26 18:06:29'),
('2', 'PERSON', '1', '2015-01-21 17:00:00', '2015-01-21 17:00:00'),
('3', 'GROUP', '1', '2015-01-21 17:00:00', '2015-01-21 17:00:00'),
('4', 'GROUP', '1', '2015-01-21 17:00:00', '2015-01-21 17:00:00'),
('5', 'PERSON', '2', '2015-01-21 17:00:00', '2015-01-21 17:00:00'),
('6', 'GROUP', '1', '2015-01-21 17:00:00', '2015-01-21 17:00:00'),
('7', 'GROUP', '4', '2015-01-28 18:17:14', '2015-01-28 18:17:14'),
('8', 'GROUP', '4', '2015-01-29 03:20:18', '2015-01-29 05:08:32'),
('9', 'GROUP', '1', '2015-01-29 05:18:58', '2015-01-29 05:19:34');

-- --------------------------------------------------------

--
-- Table structure for table `hrm_client_contact`
--

DROP TABLE IF EXISTS `hrm_client_contact`;
CREATE TABLE IF NOT EXISTS `hrm_client_contact` (
  `client_id` varchar(20) NOT NULL,
  `contact_id` varchar(20) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_client_contact`
--

INSERT INTO `hrm_client_contact` (`client_id`, `contact_id`, `create_time`, `update_time`) VALUES
('1', '1', '2015-01-27 17:00:00', '2015-01-27 17:00:00'),
('10', '5', '2015-04-26 18:06:29', '2015-04-26 18:06:29'),
('7', '2', '2015-01-28 18:17:14', '2015-01-28 18:17:14'),
('8', '3', '2015-01-29 03:20:18', '2015-01-29 03:20:18'),
('9', '4', '2015-01-29 05:18:58', '2015-01-29 05:18:58');

-- --------------------------------------------------------

--
-- Table structure for table `hrm_client_group`
--

DROP TABLE IF EXISTS `hrm_client_group`;
CREATE TABLE IF NOT EXISTS `hrm_client_group` (
  `client_id` varchar(20) NOT NULL,
  `group_name` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_client_group`
--

INSERT INTO `hrm_client_group` (`client_id`, `group_name`, `comments`, `create_time`, `update_time`) VALUES
('1', 'Developer', 'Developer', '2015-01-20 17:00:00', '2015-01-20 17:00:00'),
('2', 'Project Manager', 'Project Manager', '2015-01-21 17:00:00', '2015-01-21 17:00:00'),
('3', 'Accounting', 'Accounting', '2015-01-21 17:00:00', '2015-01-21 17:00:00'),
('4', 'Human resource', 'Human resource', '2015-01-21 17:00:00', '2015-01-21 17:00:00'),
('5', 'Technical', 'Technical', '2015-01-21 17:00:00', '2015-01-21 17:00:00'),
('6', 'Accounting', 'Accounting', '2015-01-21 17:00:00', '2015-01-21 17:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `hrm_client_type`
--

DROP TABLE IF EXISTS `hrm_client_type`;
CREATE TABLE IF NOT EXISTS `hrm_client_type` (
  `client_type_id` varchar(20) NOT NULL,
  `description` varchar(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_client_type`
--

INSERT INTO `hrm_client_type` (`client_type_id`, `description`, `create_time`, `update_time`, `is_deleted`) VALUES
('1', '1', '2015-01-13 17:00:00', '2015-01-13 17:00:00', 0),
('GROUP', 'GROUP', '2015-01-27 17:00:00', '2015-01-27 17:00:00', 0),
('PERSON', 'PERSON', '2015-01-27 17:00:00', '2015-01-27 17:00:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_contact`
--

DROP TABLE IF EXISTS `hrm_contact`;
CREATE TABLE IF NOT EXISTS `hrm_contact` (
  `contact_id` varchar(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_contact`
--

INSERT INTO `hrm_contact` (`contact_id`, `email`, `phone`, `address`, `create_time`, `update_time`) VALUES
('1', 'vtran@directviz.com', '0949706831', '703 le hong phong', '2015-01-27 17:00:00', '2015-04-28 06:28:58'),
('2', '13sv@f.dcom', '2342', '34234', '2015-01-28 18:17:14', '2015-01-28 18:17:14'),
('3', 'ngodinhminhduc@gmail.com', 'p1', 'ad1', '2015-01-29 03:20:18', '2015-01-29 05:08:32'),
('4', 'ducngo895@gmail.com', '0949706831', '703 le hong phong', '2015-01-29 05:18:58', '2015-01-29 05:19:34'),
('5', 'hrm_demo@gmail.com', '0949706831', '212b nguyen trai, q1', '2015-04-26 18:06:29', '2015-04-26 18:06:29');

-- --------------------------------------------------------

--
-- Table structure for table `hrm_contract`
--

DROP TABLE IF EXISTS `hrm_contract`;
CREATE TABLE IF NOT EXISTS `hrm_contract` (
  `contract_id` int(11) NOT NULL,
  `contract_id_input` varchar(20) NOT NULL,
  `contract_number` varchar(12) NOT NULL,
  `contract_name` varchar(25) NOT NULL,
  `description` varchar(500) NOT NULL,
  `modification` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(255) DEFAULT NULL,
  `delete_time` timestamp NULL DEFAULT NULL,
  `delete_user` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_contract`
--

INSERT INTO `hrm_contract` (`contract_id`, `contract_id_input`, `contract_number`, `contract_name`, `description`, `modification`, `value`, `start_date`, `end_date`, `create_time`, `create_user`, `update_time`, `update_user`, `delete_time`, `delete_user`, `is_deleted`) VALUES
(1, 'ID0001', 'J82151-R-002', 'JWAC', '', '', '', '2015-05-05 17:00:00', '2015-05-05 17:00:00', '2015-04-24 08:27:25', NULL, '2015-05-06 14:17:02', 'admin', '2015-05-05 02:03:39', 'admin', 0),
(2, 'ID0002', 'A12345-R-003', 'ARMY-ACC2', '1', '1', 'value', '2015-05-06 07:21:58', '2015-05-06 07:21:58', '2015-04-24 08:27:51', NULL, '2015-05-01 05:51:04', 'admin', '2015-04-24 08:27:25', '', 0),
(3, 'ID0003', 'A12345-R-004', 'ARMY-ACC', '', '', '', '2015-05-06 07:22:03', '2015-05-06 07:22:03', '2015-04-24 08:28:18', NULL, '2015-04-30 16:08:08', 'admin', '2015-04-30 16:23:13', 'admin', 0),
(4, 'ID0004', 'R89897-R-005', 'RMITS', '', '', '', '2015-05-06 07:22:08', '2015-05-06 07:22:08', '2015-04-24 08:28:37', NULL, '2015-04-24 08:28:37', NULL, '2015-04-30 16:23:04', 'admin', 0),
(5, 'ID0005', 'Number01', 'Name01', '01 description', '01 modification *!!!!', '01 value', '2015-05-06 07:22:13', '2015-05-06 07:22:13', '2015-04-30 14:50:00', 'admin', '2015-05-01 03:14:21', 'admin', '2015-05-01 03:46:05', 'admin', 0),
(6, 'ID0001612', 'ct002', 'test002', 'test002', 'test002', 'test002', '2015-05-06 07:22:17', '2015-05-06 07:22:17', '2015-05-01 03:45:49', 'admin', '2015-05-06 07:20:35', 'admin', NULL, NULL, 0),
(7, 'ID0007', 'ct001', 'ct001 name', 'ct001 decs', 'ct001 mod', 'ct001 value', '2015-05-06 07:22:21', '2015-05-06 07:22:21', '2015-05-05 02:03:00', 'admin', '2015-05-05 02:03:47', 'admin', '2015-05-06 07:21:17', 'admin', 0),
(8, 'ID0008', '0001', 'Directviz', 'abc', 'abc1', '00333', '2015-05-06 07:22:25', '2015-05-06 07:22:25', '2015-05-05 04:10:44', 'admin', '2015-05-05 04:10:59', 'admin', NULL, NULL, 0),
(9, 'IDVOTEST1', 'VO_NUMBER-1', 'VO_NAME-1', 'description', 'modification', 'value', '2015-05-05 17:00:00', '2015-05-06 17:00:00', '2015-05-06 06:57:38', 'admin', '2015-05-06 06:57:53', 'admin', NULL, NULL, 0),
(10, 'ID0406', '04_06', 'Contract name', 'Description', 'Modification', 'Value', '2015-06-03 17:00:00', '2015-06-05 17:00:00', '2015-06-04 02:26:19', 'admin', '2015-06-04 02:26:19', 'admin', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_country`
--

DROP TABLE IF EXISTS `hrm_country`;
CREATE TABLE IF NOT EXISTS `hrm_country` (
  `country_id` int(11) NOT NULL,
  `country_name` varchar(25) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_country`
--

INSERT INTO `hrm_country` (`country_id`, `country_name`, `create_time`, `create_user`, `update_time`, `update_user`, `is_deleted`) VALUES
(1, 'United State', '2015-04-24 08:46:42', NULL, '2015-04-24 08:46:42', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_department`
--

DROP TABLE IF EXISTS `hrm_department`;
CREATE TABLE IF NOT EXISTS `hrm_department` (
  `department_id` int(11) NOT NULL,
  `department_name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hrm_department`
--

INSERT INTO `hrm_department` (`department_id`, `department_name`, `is_deleted`) VALUES
(1, 'IT', 0),
(2, 'Sale', 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_education`
--

DROP TABLE IF EXISTS `hrm_education`;
CREATE TABLE IF NOT EXISTS `hrm_education` (
  `education_id` int(11) NOT NULL,
  `education_name` varchar(255) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_education`
--

INSERT INTO `hrm_education` (`education_id`, `education_name`, `create_time`, `create_user`, `update_time`, `update_user`, `is_deleted`) VALUES
(1, 'High school diploma or equivalent', '2015-04-24 07:26:18', NULL, '2015-04-24 07:26:18', NULL, 0),
(2, 'Certification', '2015-04-24 08:24:28', NULL, '2015-04-24 08:24:28', NULL, 0),
(3, 'Some colleague coursework completed', '2015-04-27 02:55:02', NULL, '2015-04-27 02:55:02', NULL, 0),
(4, 'Associate Degree', '2015-04-27 02:55:12', NULL, '2015-04-27 02:55:12', NULL, 0),
(5, 'Bachelor''s Degree', '2015-04-27 02:55:29', NULL, '2015-04-27 02:55:29', NULL, 0),
(6, 'Master''s Degree', '2015-06-18 01:42:15', NULL, '2015-06-18 01:42:15', NULL, 0),
(7, 'Doctorate', '2015-06-18 01:42:35', NULL, '2015-06-18 01:42:35', NULL, 0),
(8, 'Professional', '2015-06-18 01:42:35', NULL, '2015-06-18 01:42:35', NULL, 0),
(9, 'Others', '2015-06-18 01:42:45', NULL, '2015-06-18 01:42:45', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_employee`
--

DROP TABLE IF EXISTS `hrm_employee`;
CREATE TABLE IF NOT EXISTS `hrm_employee` (
  `emp_id` int(11) NOT NULL,
  `emp_id_input` varchar(50) CHARACTER SET utf8 NOT NULL,
  `first_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `last_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `mid_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `street` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `state_id` int(11) NOT NULL,
  `zipcode` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `country_id` int(11) NOT NULL,
  `position_type` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `hired_date` timestamp NULL DEFAULT NULL,
  `salary` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `work_time_id` int(11) NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `mobile` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `home_number` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `clearance_lv_id` int(11) NOT NULL,
  `contract_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `program` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `program_manager` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `poc_phone` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `evaluation_date` timestamp NULL DEFAULT NULL,
  `tax_info` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `court_order` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `county` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `court_address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `termination_date` int(11) DEFAULT NULL,
  `rehire` tinyint(1) NOT NULL DEFAULT '0',
  `not_hire` tinyint(1) NOT NULL DEFAULT '0',
  `termination_reason_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) CHARACTER SET utf8 NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `update_user` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `delete_time` timestamp NULL DEFAULT NULL,
  `delete_user` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hrm_person`
--

DROP TABLE IF EXISTS `hrm_person`;
CREATE TABLE IF NOT EXISTS `hrm_person` (
  `client_id` varchar(20) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_person`
--

INSERT INTO `hrm_person` (`client_id`, `first_name`, `last_name`, `birth_date`, `create_time`, `update_time`) VALUES
('1', 'Vinnie', 'Mark', '2017-04-04', '2015-01-27 17:00:00', '2015-04-28 06:28:58'),
('10', 'HRM', 'DEMO', '2016-12-04', '2015-04-26 18:06:29', '2015-04-26 18:06:29'),
('7', '2342', '342', '2017-06-01', '2015-01-28 18:17:14', '2015-01-28 18:17:14'),
('8', 'd1', 'c1', '2017-05-01', '2015-01-29 03:20:18', '2015-01-29 05:08:32'),
('9', 'duc', 'ngo', '2017-05-01', '2015-01-29 05:18:58', '2015-01-29 05:19:34');

-- --------------------------------------------------------

--
-- Table structure for table `hrm_position`
--

DROP TABLE IF EXISTS `hrm_position`;
CREATE TABLE IF NOT EXISTS `hrm_position` (
  `position_id` int(11) NOT NULL,
  `position_title` varchar(25) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_position`
--

INSERT INTO `hrm_position` (`position_id`, `position_title`, `create_time`, `create_user`, `update_time`, `update_user`, `is_deleted`) VALUES
(1, 'Software Engineer', '2015-04-24 09:09:22', NULL, '2015-04-24 09:09:22', NULL, 0),
(2, 'System Administrator', '2015-04-24 09:09:31', NULL, '2015-04-24 09:09:31', NULL, 0),
(3, 'Sharepoint Developer', '2015-04-24 09:09:39', NULL, '2015-04-24 09:09:39', NULL, 0),
(4, 'Lead Accessor', '2015-04-24 09:09:51', NULL, '2015-04-24 09:09:51', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_recruitment`
--

DROP TABLE IF EXISTS `hrm_recruitment`;
CREATE TABLE IF NOT EXISTS `hrm_recruitment` (
  `recruitment_id` int(20) NOT NULL,
  `client_id_position` varchar(20) NOT NULL,
  `recruitment_type_id` varchar(20) NOT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `job_description` varchar(10000) DEFAULT NULL,
  `job_recruitment` varchar(10000) DEFAULT NULL,
  `enable` char(1) DEFAULT '1',
  `expired_date` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `delete_user` varchar(255) DEFAULT NULL,
  `delete_time` timestamp NULL DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_recruitment`
--

INSERT INTO `hrm_recruitment` (`recruitment_id`, `client_id_position`, `recruitment_type_id`, `title`, `job_description`, `job_recruitment`, `enable`, `expired_date`, `create_time`, `update_time`, `create_user`, `update_user`, `delete_user`, `delete_time`, `is_deleted`) VALUES
(1, '1', '2', 'Recruitment title test2', 'job_description test2', 'job_recruitment test2', '0', '2015-01-30 17:00:00', '2015-01-20 17:00:00', '2015-01-30 01:08:56', 'admin', 'admin', 'admin', '2015-04-23 08:51:08', 1),
(2, '3', '1', '1', '1', '1', '1', '2014-12-31 17:00:00', '2015-01-21 12:43:59', '2015-01-22 06:14:22', '1', 'admin', 'admin', '2015-01-22 06:14:26', 1),
(3, '1', '2', 'qwefqwef', 'qwef', 'qwef', '0', '2015-01-29 17:00:00', '2015-01-21 13:31:53', '2015-04-23 08:51:21', 'admin', 'admin', NULL, NULL, 0),
(5, '1', '1', '123', '123', '23123', '1', '2015-01-22 17:00:00', '2015-01-21 16:36:18', '2015-01-21 16:36:18', 'admin', 'admin', 'admin', '2015-01-22 04:09:46', 1),
(6, '1', '2', 'asdf', 'sfds', 'fsdfs', '0', '2015-01-23 17:00:00', '2015-01-21 16:36:45', '2015-01-21 16:36:45', 'admin', 'admin', NULL, NULL, 0),
(7, '2', '2', 'asdf', 'asdf', 'asdf', '1', '2015-01-29 17:00:00', '2015-01-22 04:02:08', '2015-01-22 04:02:08', 'admin', 'admin', NULL, NULL, 0),
(8, '4', '2', 'Tuyen humaun resource 1', 'Tuyen humaun resource 1', 'Tuyen humaun resource 1', '1', '2015-01-30 17:00:00', '2015-01-22 06:12:44', '2015-01-22 06:13:01', 'admin', 'admin', NULL, NULL, 0),
(9, '3', '1', 'tt', 't', 't', '1', '2015-01-30 17:00:00', '2015-01-30 01:09:34', '2015-01-30 01:09:34', 'admin', 'admin', NULL, NULL, 0),
(10, '1', '1', 'aaa', 'bbbbb', 'cccc', '1', '2015-04-25 17:00:00', '2015-04-25 02:16:17', '2015-04-25 02:16:17', 'admin', 'admin', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_recruitment_type`
--

DROP TABLE IF EXISTS `hrm_recruitment_type`;
CREATE TABLE IF NOT EXISTS `hrm_recruitment_type` (
  `recruitment_type_id` varchar(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_recruitment_type`
--

INSERT INTO `hrm_recruitment_type` (`recruitment_type_id`, `description`, `create_time`, `update_time`) VALUES
('1', 'Request', '2015-01-20 17:00:00', '2015-01-20 17:00:00'),
('2', 'Recruitment', '2015-01-20 17:00:00', '2015-01-20 17:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `hrm_requisition`
--

DROP TABLE IF EXISTS `hrm_requisition`;
CREATE TABLE IF NOT EXISTS `hrm_requisition` (
  `requisition_id` int(11) NOT NULL,
  `requisition_id_input` varchar(200) NOT NULL,
  `contract_id` int(11) NOT NULL,
  `requester` varchar(20) NOT NULL,
  `position_id` int(11) NOT NULL,
  `required_date` timestamp NULL DEFAULT NULL,
  `status_id` int(11) NOT NULL,
  `salary_range` varchar(200) DEFAULT '0',
  `clearance_lv_id` int(11) NOT NULL,
  `certificate_req` varchar(100) NOT NULL,
  `education_id` int(11) NOT NULL,
  `education_other` varchar(255) DEFAULT NULL,
  `street` varchar(255) NOT NULL,
  `city_name` varchar(255) NOT NULL,
  `state_id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_requisition`
--

INSERT INTO `hrm_requisition` (`requisition_id`, `requisition_id_input`, `contract_id`, `requester`, `position_id`, `required_date`, `status_id`, `salary_range`, `clearance_lv_id`, `certificate_req`, `education_id`, `education_other`, `street`, `city_name`, `state_id`, `country_id`, `attachment`, `create_time`, `create_user`, `update_time`, `update_user`, `is_deleted`) VALUES
(32, 'hai001', 1, 'abc', 2, '2015-04-27 17:00:00', 1, '100000', 12, 'abccc', 2, NULL, 'Duong So 4', 'HCM', 2, 1, '95716UPDATE LAYOUT HUMAN RESOURCE GROUP.docx', '2015-04-28 03:35:37', 'hrm_demo', '2015-05-01 09:36:42', 'admin', 0),
(33, 'test001', 1, 'test001', 1, '2015-04-29 17:00:00', 1, ' ', 1, 'test001', 1, NULL, 'Duong So 3', 'Ha Noi', 2, 1, '66038Fileve.docx', '2015-04-29 07:13:55', 'hrm_demo', '2015-04-29 07:13:55', 'hrm_demo', 0),
(34, 'test002', 1, 'test002', 1, '2015-04-29 17:00:00', 1, '5000', 12, 'test002', 1, NULL, 'Duong So 1', 'Dong Nai', 1, 1, '61968Fileve.docx', '2015-04-29 07:14:57', 'hrm_demo', '2015-04-29 07:24:08', 'hrm_demo', 0),
(35, 'votest02', 1, 'vo vo', 3, '2015-04-29 17:00:00', 1, '10000', 12, 'CCNP', 3, NULL, '', '1', 1, 1, '12822ASP.NET - Cac kien thuc co ban.docx', '2015-04-29 23:25:25', 'admin', '2015-05-02 13:55:09', 'admin', 0),
(36, 'votest01', 1, 'vo vo', 1, '2015-04-29 17:00:00', 1, '5000', 4, 'CCNP', 4, NULL, '', '3', 2, 1, '64466C#.docx', '2015-04-29 23:26:22', 'admin', '2015-05-02 14:02:21', 'admin', 0),
(37, 'ID008 V', 9, 'vo vo', 1, '2015-05-01 17:00:00', 1, '5000', 12, 'sss', 5, NULL, '77', '3', 2, 1, '31534[123doc.vn] - phuong-phap-sac-ky-long-hieu-nang-cao.doc', '2015-05-01 09:37:51', 'admin', '2015-05-07 21:24:56', 'admin', 0),
(38, '03052015', 6, 'VoVo', 3, '2015-05-30 17:00:00', 0, '20000', 4, 'CCNP', 1, '', '', '1', 1, 1, '64499PFCLopezRuizAnnex3.pdf', '2015-05-03 01:28:23', 'admin', '2015-06-20 05:17:57', 'admin', 0),
(39, 'test009', 1, 'test009', 1, '2015-05-28 17:00:00', 1, '5000', 12, 'test009', 4, NULL, '', '2', 2, 1, '52811BaoGiaWebsite_AnPhuLaw.vn_EBK.pdf', '2015-05-03 01:57:08', 'admin', '2015-05-03 01:57:08', 'admin', 0),
(40, 'Vo Test 0705', 2, 'vo vo', 1, '2015-05-06 17:00:00', 1, '5000', 4, 'CCNP', 3, NULL, 'TKTQ', 'HCM', 2, 1, '64899[123doc.vn] - phuong-phap-sac-ky-long-hieu-nang-cao.doc', '2015-05-07 13:48:34', 'admin', '2015-05-07 13:48:34', 'admin', 0),
(41, 'Vo Test 05072224', 9, 'vo vo', 1, '2015-05-06 17:00:00', 0, '6789', 4, 'VVV', 3, NULL, 'TKTQ', 'HCM', 2, 1, '65963[123doc.vn] - phuong-phap-sac-ky-long-hieu-nang-cao.doc', '2015-05-07 15:25:10', 'admin', '2015-05-07 15:25:10', 'admin', 0),
(42, 'tttt', 1, '555', 1, '2015-05-13 17:00:00', 1, '5000', 1, '5555', 1, NULL, '44', '55', 1, 1, '76549[123doc.vn] - phuong-phap-sac-ky-long-hieu-nang-cao.doc', '2015-05-07 15:40:37', 'admin', '2015-05-07 15:40:37', 'admin', 0),
(43, 'ID05080933', 7, 'Vo Vo', 2, '2015-05-07 17:00:00', 1, '5000', 4, 'CNPP', 3, NULL, 'TKTQ', 'HCM', 1, 1, '98522Phieu danh gia thuc tap.docx', '2015-05-08 02:26:47', 'admin', '2015-05-08 02:27:29', 'admin', 0),
(44, 'ads', 1, 'ad', 1, '2015-05-20 17:00:00', 1, '5000', 1, 'sa', 1, NULL, 'sf', 'sd', 1, 1, '64032BANG KE HANG NHAP THANG 6 - 2009.xlsx', '2015-05-08 03:30:14', 'admin', '2015-05-08 03:34:36', 'admin', 0),
(45, 'ABC 1', 6, 'abc', 2, '2015-05-08 17:00:00', 2, '5000', 7, 'CCNP', 1, '', '', 'HCM', 64, 1, '78365MOT SO THAO TAC VE SINH.docx', '2015-05-09 16:41:43', 'admin', '2015-06-16 04:35:00', 'admin', 0),
(46, 'test-005', 1, 'test-007', 1, '2015-05-27 17:00:00', 1, '5000', 1, 're-009111', 1, NULL, '', 'hcm', 1, 1, '19253Ebk báo giá site vé máy bay.docx', '2015-05-13 02:19:04', 'admin', '2015-05-13 02:19:04', 'admin', 0),
(47, 're-009111', 1, 'duc ngo 6', 1, '2015-05-27 17:00:00', 1, '5000', 1, 'abc 2', 1, NULL, '', 'sd', 1, 1, '38008Ebk báo giá site vé máy bay.docx', '2015-05-13 02:21:30', 'admin', '2015-05-13 02:21:30', 'admin', 0),
(48, 'test-007', 1, 're-009111', 1, '2015-05-28 17:00:00', 1, '5000', 1, 're-009111', 1, NULL, '', 'ny', 1, 1, '42687Ebk báo giá site s?n ph?m.docx', '2015-05-13 02:23:05', 'admin', '2015-05-13 02:23:05', 'admin', 0),
(49, 'test-007', 1, 'duc', 1, '2015-05-28 17:00:00', 1, '5000', 1, 're-009111', 1, NULL, '', 'ny', 1, 1, '40796Ebk báo giá site s?n ph?m.docx', '2015-05-13 02:55:39', 'admin', '2015-05-13 02:55:39', 'admin', 0),
(50, '201505181130', 9, 'Vo Vo', 3, '2015-05-18 17:00:00', 1, '5000', 3, 'sa', 3, NULL, '', 'HCM', 2, 1, '48093Phieu danh gia thuc tap.pdf', '2015-05-18 04:23:45', 'admin', '2015-05-18 04:24:12', 'admin', 0),
(51, '201505191311', 6, 'vo vo', 3, '2015-05-28 17:00:00', 1, '5000-10000', 3, 'BA', 4, NULL, '', 'HCM', 64, 1, '102318The Past Tense.docx', '2015-05-19 06:12:17', 'admin', '2015-05-19 06:13:08', 'admin', 0),
(52, '20150525', 6, 'vo vo', 2, '2015-05-24 17:00:00', 1, '5000', 3, 'BA', 3, NULL, '', 'HCM', 64, 1, '35534The Past Tense.docx', '2015-05-25 03:04:15', 'admin', '2015-05-25 03:05:15', 'admin', 0),
(53, '201505251256', 9, 'vo vo', 1, '2015-05-24 17:00:00', 1, '5000', 1, 'BA', 1, '', '', 'HCM', 64, 1, '108921The Past Tense.docx', '2015-05-25 05:56:57', 'admin', '2015-06-16 05:33:08', 'admin', 0),
(54, '201505251259', 3, 'vo vo', 1, '2015-05-25 17:00:00', 0, '5000-10000', 3, 'VBB', 3, NULL, '', 'HCM', 1, 1, '37670The Past Tense.docx', '2015-05-25 06:00:22', 'admin', '2015-05-25 06:00:22', 'admin', 0),
(55, '201505251300', 1, 'vy vy', 3, '2015-05-26 17:00:00', 1, '500-1000', 2, 'VBB', 3, '', '', 'HCM', 2, 1, '33481The Past Tense.docx', '2015-05-25 06:08:05', 'admin', '2015-06-16 08:02:45', 'admin', 0),
(56, '201505251301', 3, 'vo vo', 4, '2015-05-27 17:00:00', 1, '5000', 9, 'BA', 4, NULL, '', 'HCM', 2, 1, '15067The Past Tense.docx', '2015-05-25 06:09:01', 'admin', '2015-05-25 06:09:01', 'admin', 0),
(57, '201505251318', 6, 'vy vy', 3, '2015-05-24 17:00:00', 0, '56789', 4, 'CCSS', 4, NULL, '', 'CA', 1, 1, '23802The Past Tense.docx', '2015-05-25 06:24:44', 'admin', '2015-05-25 06:24:44', 'admin', 0),
(58, 'VO1406', 4, 'VoVo', 2, '2015-06-19 17:00:00', 1, '5678 9000', 4, 'SSSSS', 4, NULL, '', 'HCM', 64, 1, '75245erp_fix.docx', '2015-06-14 12:07:39', 'admin', '2015-06-14 12:08:28', 'admin', 0),
(59, 'ID 0616A', 3, 'vo vo', 4, '2015-06-17 17:00:00', 2, '100000', 6, 'certification requirement', 3, '', '', 'HCM', 64, 1, '58116PFCLopezRuizAnnex3.pdf', '2015-06-16 05:04:03', 'admin', '2015-06-16 05:11:54', 'admin', 0),
(60, 'ID 0616B', 3, 'vo vo', 2, '2015-06-19 17:00:00', 0, '5000 10000', 7, 'certification requirement', 5, 'Other', '', 'HCM', 64, 1, '46331PFCLopezRuizAnnex3.pdf', '2015-06-16 05:14:48', 'admin', '2015-06-16 05:17:03', 'admin', 0),
(61, 'ABC 2', 5, 'vo vo', 4, '2015-06-16 17:00:00', 2, '5678 9000', 3, 'SSSSS', 5, 'ddd', '', 'HCM', 64, 1, '13495PFCLopezRuizAnnex3.pdf', '2015-06-16 15:36:07', 'admin', '2015-06-16 15:54:09', 'admin', 0),
(62, '03052015111111111', 6, 'VoVo', 3, '2015-05-30 17:00:00', 0, '20000', 4, 'CCNP', 1, '', '', '1', 1, 1, '86334PFCLopezRuizAnnex3.pdf', '2015-06-18 01:45:12', 'admin', '2015-06-18 01:45:12', 'admin', 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_state`
--

DROP TABLE IF EXISTS `hrm_state`;
CREATE TABLE IF NOT EXISTS `hrm_state` (
  `state_id` int(11) NOT NULL,
  `state_name` varchar(255) NOT NULL,
  `no_state` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_state`
--

INSERT INTO `hrm_state` (`state_id`, `state_name`, `no_state`, `create_time`, `create_user`, `update_time`, `update_user`, `is_deleted`) VALUES
(1, 'Alabama', 0, '2015-05-04 03:42:42', NULL, '2015-05-04 03:42:42', NULL, 0),
(2, 'Alaska', 0, '2015-05-04 06:17:48', NULL, '2015-05-04 06:17:48', NULL, 0),
(3, 'Arizona', 0, '2015-06-22 01:37:18', NULL, '2015-06-22 01:37:18', NULL, 0),
(4, 'Arkansas', 0, '2015-06-22 01:37:26', NULL, '2015-06-22 01:37:26', NULL, 0),
(5, 'California', 0, '2015-06-22 01:37:33', NULL, '2015-06-22 01:37:33', NULL, 0),
(6, 'Colorado', 0, '2015-06-22 01:37:40', NULL, '2015-06-22 01:37:40', NULL, 0),
(7, 'Connecticut', 0, '2015-06-22 01:37:48', NULL, '2015-06-22 01:37:48', NULL, 0),
(8, 'Delaware', 0, '2015-06-22 01:37:55', NULL, '2015-06-22 01:37:55', NULL, 0),
(9, 'District of Columbia', 0, '2015-06-22 01:38:05', NULL, '2015-06-22 01:38:05', NULL, 0),
(10, 'Florida', 0, '2015-06-22 01:38:12', NULL, '2015-06-22 01:38:12', NULL, 0),
(11, 'Georgia', 0, '2015-06-22 01:38:18', NULL, '2015-06-22 01:38:18', NULL, 0),
(12, 'Hawaii', 0, '2015-06-22 01:38:24', NULL, '2015-06-22 01:38:24', NULL, 0),
(13, 'Idaho', 0, '2015-06-22 01:38:32', NULL, '2015-06-22 01:38:32', NULL, 0),
(14, 'Illinois', 0, '2015-06-22 01:38:44', NULL, '2015-06-22 01:38:44', NULL, 0),
(15, 'Indiana', 0, '2015-06-22 01:38:52', NULL, '2015-06-22 01:38:52', NULL, 0),
(16, 'Iowa', 0, '2015-06-22 01:38:59', NULL, '2015-06-22 01:38:59', NULL, 0),
(17, 'Kansas', 0, '2015-06-22 01:39:06', NULL, '2015-06-22 01:39:06', NULL, 0),
(18, 'Kentucky', 0, '2015-06-22 01:39:13', NULL, '2015-06-22 01:39:13', NULL, 0),
(19, 'Louisiana', 0, '2015-06-22 01:39:21', NULL, '2015-06-22 01:39:21', NULL, 0),
(20, 'Maine', 0, '2015-06-22 01:39:28', NULL, '2015-06-22 01:39:28', NULL, 0),
(21, 'Maryland', 0, '2015-06-22 01:39:36', NULL, '2015-06-22 01:39:36', NULL, 0),
(22, 'Massachusetts', 0, '2015-06-22 01:39:43', NULL, '2015-06-22 01:39:43', NULL, 0),
(23, 'Michigan', 0, '2015-06-22 01:39:50', NULL, '2015-06-22 01:39:50', NULL, 0),
(24, 'Minnesota', 0, '2015-06-22 01:39:57', NULL, '2015-06-22 01:39:57', NULL, 0),
(25, 'Mississippi', 0, '2015-06-22 01:40:05', NULL, '2015-06-22 01:40:05', NULL, 0),
(26, 'Missouri', 0, '2015-06-22 01:40:11', NULL, '2015-06-22 01:40:11', NULL, 0),
(27, 'Montana', 0, '2015-06-22 01:40:18', NULL, '2015-06-22 01:40:18', NULL, 0),
(28, 'Nebraska', 0, '2015-06-22 01:40:25', NULL, '2015-06-22 01:40:25', NULL, 0),
(29, 'Nevada', 0, '2015-06-22 01:40:32', NULL, '2015-06-22 01:40:32', NULL, 0),
(30, 'New Hampshire', 0, '2015-06-22 01:40:43', NULL, '2015-06-22 01:40:43', NULL, 0),
(31, 'New Jersey', 0, '2015-06-22 01:41:03', NULL, '2015-06-22 01:41:03', NULL, 0),
(32, 'New Mexico', 0, '2015-06-22 01:41:09', NULL, '2015-06-22 01:41:09', NULL, 0),
(33, 'New York', 0, '2015-06-22 01:41:20', NULL, '2015-06-22 01:41:20', NULL, 0),
(34, 'North Carolina', 0, '2015-06-22 01:41:26', NULL, '2015-06-22 01:41:26', NULL, 0),
(35, 'North Dakota', 0, '2015-06-22 01:41:33', NULL, '2015-06-22 01:41:33', NULL, 0),
(36, 'Ohio', 0, '2015-06-22 01:41:41', NULL, '2015-06-22 01:41:41', NULL, 0),
(37, 'Oklahoma', 0, '2015-06-22 01:41:47', NULL, '2015-06-22 01:41:47', NULL, 0),
(38, 'Oregon', 0, '2015-06-22 01:41:55', NULL, '2015-06-22 01:41:55', NULL, 0),
(39, 'Pennsylvania', 0, '2015-06-22 01:42:02', NULL, '2015-06-22 01:42:02', NULL, 0),
(40, 'Rhode Island', 0, '2015-06-22 01:42:11', NULL, '2015-06-22 01:42:11', NULL, 0),
(41, 'South Carolina', 0, '2015-06-22 01:42:18', NULL, '2015-06-22 01:42:18', NULL, 0),
(42, 'South Dakota', 0, '2015-06-22 01:42:27', NULL, '2015-06-22 01:42:27', NULL, 0),
(43, 'Tennessee', 0, '2015-06-22 01:42:33', NULL, '2015-06-22 01:42:33', NULL, 0),
(44, 'Texas', 0, '2015-06-22 01:42:39', NULL, '2015-06-22 01:42:39', NULL, 0),
(45, 'Utah', 0, '2015-06-22 01:42:47', NULL, '2015-06-22 01:42:47', NULL, 0),
(46, 'Vermont', 0, '2015-06-22 01:42:55', NULL, '2015-06-22 01:42:55', NULL, 0),
(47, 'Virginia', 0, '2015-06-22 01:43:01', NULL, '2015-06-22 01:43:01', NULL, 0),
(48, 'Washington', 0, '2015-06-22 01:43:10', NULL, '2015-06-22 01:43:10', NULL, 0),
(49, 'West Virginia', 0, '2015-06-22 01:43:16', NULL, '2015-06-22 01:43:16', NULL, 0),
(50, 'Wisconsin', 0, '2015-06-22 01:43:23', NULL, '2015-06-22 01:43:23', NULL, 0),
(51, 'Wyoming', 0, '2015-06-22 01:43:30', NULL, '2015-06-22 01:43:30', NULL, 0),
(64, ' - ', 1, '2015-05-07 15:30:30', NULL, '2015-05-07 15:30:30', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_status`
--

DROP TABLE IF EXISTS `hrm_status`;
CREATE TABLE IF NOT EXISTS `hrm_status` (
  `status_id` int(11) NOT NULL,
  `status_name` varchar(100) NOT NULL,
  `is_other` tinyint(1) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hrm_status`
--

INSERT INTO `hrm_status` (`status_id`, `status_name`, `is_other`, `create_time`, `create_user`, `update_time`, `update_user`, `is_deleted`) VALUES
(1, 'Interview', 0, '2015-05-04 05:11:03', 'admin', '2015-05-04 05:11:03', NULL, 0),
(2, 'Pending', 0, '2015-05-04 05:12:02', 'admin', '2015-05-04 05:12:02', NULL, 0),
(3, 'Interview schedule', 0, '2015-05-04 05:11:18', 'admin', '2015-05-04 05:11:18', NULL, 0),
(4, 'Position closed', 0, '2015-05-04 05:11:33', 'admin', '2015-05-04 05:11:33', NULL, 0),
(5, 'Others', 1, '2015-05-04 06:01:55', 'admin', '2015-05-04 06:01:55', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_termination_reason`
--

DROP TABLE IF EXISTS `hrm_termination_reason`;
CREATE TABLE IF NOT EXISTS `hrm_termination_reason` (
  `termination_reason_id` int(11) NOT NULL,
  `termination_reason_content` varchar(100) CHARACTER SET utf8 NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hrm_termination_reason`
--

INSERT INTO `hrm_termination_reason` (`termination_reason_id`, `termination_reason_content`, `is_deleted`) VALUES
(1, 'Reason 1', 0),
(2, 'Reason 2', 0);

-- --------------------------------------------------------

--
-- Table structure for table `hrm_work_time`
--

DROP TABLE IF EXISTS `hrm_work_time`;
CREATE TABLE IF NOT EXISTS `hrm_work_time` (
  `work_time_id` int(11) NOT NULL,
  `work_time_name` varchar(25) CHARACTER SET utf8 NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hrm_work_time`
--

INSERT INTO `hrm_work_time` (`work_time_id`, `work_time_name`, `is_deleted`) VALUES
(1, 'Full-time', 0),
(2, 'Part-time', 0),
(3, 'SCA', 0),
(4, 'Intern', 0),
(5, 'Exempt', 0),
(6, 'Non-Exempt', 0);

-- --------------------------------------------------------

--
-- Table structure for table `interview`
--

DROP TABLE IF EXISTS `interview`;
CREATE TABLE IF NOT EXISTS `interview` (
  `interview_id` varchar(20) NOT NULL,
  `client_id_applicant` varchar(20) NOT NULL,
  `client_id_interviewer` varchar(20) NOT NULL,
  `client_id_position` varchar(20) NOT NULL,
  `round_id` varchar(20) NOT NULL,
  `point` float DEFAULT NULL,
  `interview_time` timestamp NULL DEFAULT NULL,
  `note` varchar(1000) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `interview_question`
--

DROP TABLE IF EXISTS `interview_question`;
CREATE TABLE IF NOT EXISTS `interview_question` (
  `interview_question_id` varchar(20) NOT NULL,
  `client_id_position` varchar(20) NOT NULL,
  `round_id` varchar(20) NOT NULL,
  `question_content` varchar(10000) DEFAULT NULL,
  `answer_content` varchar(10000) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `menu_link`
--

DROP TABLE IF EXISTS `menu_link`;
CREATE TABLE IF NOT EXISTS `menu_link` (
  `menu_link_id` varchar(20) NOT NULL,
  `module_id` varchar(20) NOT NULL,
  `link_name` varchar(255) DEFAULT NULL,
  `href` varchar(1000) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
CREATE TABLE IF NOT EXISTS `module` (
  `module_id` varchar(20) NOT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `href` varchar(1000) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `permisstion_module`
--

DROP TABLE IF EXISTS `permisstion_module`;
CREATE TABLE IF NOT EXISTS `permisstion_module` (
  `permission_id` varchar(20) NOT NULL,
  `module_id` varchar(20) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `client_id` varchar(20) NOT NULL,
  `role_type_id` varchar(20) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role_type`
--

DROP TABLE IF EXISTS `role_type`;
CREATE TABLE IF NOT EXISTS `role_type` (
  `role_type_id` varchar(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `round`
--

DROP TABLE IF EXISTS `round`;
CREATE TABLE IF NOT EXISTS `round` (
  `round_id` varchar(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `sys_group`
--

DROP TABLE IF EXISTS `sys_group`;
CREATE TABLE IF NOT EXISTS `sys_group` (
  `group_id` varchar(20) NOT NULL,
  `group_name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `delete_user` varchar(255) DEFAULT NULL,
  `delete_time` timestamp NULL DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_group`
--

INSERT INTO `sys_group` (`group_id`, `group_name`, `description`, `create_time`, `update_time`, `create_user`, `update_user`, `delete_user`, `delete_time`, `is_deleted`) VALUES
('1', 'Administrative', 'Administrative1', '2015-01-20 10:00:00', '2015-01-25 02:29:02', NULL, 'admin', NULL, '2015-01-25 01:30:21', 0),
('10', 'test23', 'abc', '2015-01-25 22:06:00', '2015-01-25 22:06:11', 'admin', 'admin', 'admin', '2015-01-25 22:06:18', 1),
('11', 'abc', 'abc', '2015-01-29 00:17:50', '2015-01-29 00:17:50', 'admin', 'admin', 'admin', '2015-02-02 21:19:45', 1),
('2', 'Recruiters', 'Recruiters', '2015-01-20 10:00:00', '2015-01-20 10:00:00', NULL, NULL, NULL, '2015-01-25 01:33:14', 0),
('3', 'Human Resource', 'Human Resource', '2015-01-20 10:00:00', '2015-01-20 10:00:00', NULL, NULL, NULL, '2015-01-25 01:34:49', 0),
('4', 'Employee', 'Employee', '2015-01-24 10:00:00', '2015-01-24 10:00:00', NULL, NULL, NULL, '2015-01-25 01:36:06', 0),
('5', 'Finance', 'Finance', '2015-01-24 10:00:00', '2015-01-24 10:00:00', NULL, NULL, 'admin', '2015-01-25 01:37:18', 0),
('6', 'Operations', 'Operations', '2015-01-24 10:00:00', '2015-01-24 10:00:00', NULL, NULL, NULL, NULL, 0),
('7', 'test1', 'test1', '2015-01-25 20:07:38', '2015-01-25 21:54:51', 'admin', 'admin', 'admin', '2015-01-25 22:06:42', 1),
('8', 'adb1', 'abc1', '2015-01-25 21:45:28', '2015-01-25 21:45:35', 'admin', 'admin', 'admin', '2015-01-25 21:51:35', 1),
('9', 'abc', 'abc', '2015-01-25 22:00:03', '2015-01-25 22:00:03', 'admin', 'admin', 'admin', '2015-01-25 22:06:54', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE IF NOT EXISTS `sys_permission` (
  `permission_id` varchar(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_permission`
--

INSERT INTO `sys_permission` (`permission_id`, `description`, `create_time`, `update_time`) VALUES
('business_development', 'business_development_list', '2015-02-04 10:00:00', '2015-02-04 10:00:00'),
('cand_tracker_add', 'candidate_tracker_add', '2015-05-18 21:41:45', '2015-05-18 21:41:45'),
('cand_tracker_del', 'candidatetracker_delete', '2015-05-19 18:53:18', '2015-05-19 18:53:18'),
('cand_tracker_edit', 'candidate_tracker_edit', '2015-05-19 18:53:18', '2015-05-19 18:53:18'),
('cand_tracker_list', 'candidate_tracker_list', '2015-05-19 18:55:14', '2015-05-19 18:55:14'),
('cand_tracker_view', 'cand_tracker_view', '2015-05-25 06:58:01', '2015-05-25 06:58:01'),
('contract_add', 'contract_add', NULL, NULL),
('contract_delete', 'contract_delete', '2015-04-30 10:00:00', '2015-04-30 10:00:00'),
('contract_edit', 'contract_edit', '2015-04-30 10:00:00', '2015-04-30 10:00:00'),
('contract_list', 'contract_list', '2015-04-30 10:00:00', '2015-04-30 10:00:00'),
('contract_view', 'contract_view', '2015-06-04 02:48:28', '2015-06-04 02:48:28'),
('employee_add', 'employee_add', '2015-06-11 13:19:27', '2015-06-11 13:19:27'),
('employee_list', 'employee_list', '2015-02-04 10:00:00', '2015-02-04 10:00:00'),
('expense_list', 'expense_list', '2015-02-04 10:00:00', '2015-02-04 10:00:00'),
('group_add', 'group_add', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('group_delete', 'group_delete', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('group_edit', 'group_edit', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('group_list', 'view group list', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('operations_list', 'operations_list', '2015-02-04 10:00:00', '2015-02-04 10:00:00'),
('permission_add', 'permission_add', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('permission_list', 'permission_list', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('recruitment_add', 'recruitment_add', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('recruitment_delete', 'recruitment_delete', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('recruitment_edit', 'recruitment_edit', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('recruitment_list', 'recruitment_list', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('requisition_add', 'requisition_add', NULL, NULL),
('requisition_copy', 'requisition_copy', '2015-05-25 02:51:57', '2015-05-25 02:51:57'),
('requisition_delete', 'requisition_delete', NULL, NULL),
('requisition_edit', 'requisition_edit', NULL, NULL),
('requisition_list', 'requisition_list', NULL, NULL),
('requisition_view', 'requisition_view', NULL, NULL),
('user_add', 'user_add', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('user_changepassword', 'user_changepassword', '2015-02-08 10:00:00', '2015-02-08 10:00:00'),
('user_delete', 'user_delete', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('user_edit', 'user_edit', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('user_list', 'user_list', '2015-02-02 10:00:00', '2015-02-02 10:00:00'),
('view_file', 'view_file', '2015-06-20 11:21:39', '2015-06-20 11:21:39');

-- --------------------------------------------------------

--
-- Table structure for table `sys_permission_group`
--

DROP TABLE IF EXISTS `sys_permission_group`;
CREATE TABLE IF NOT EXISTS `sys_permission_group` (
  `permission_id` varchar(20) NOT NULL,
  `group_id` varchar(20) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_permission_group`
--

INSERT INTO `sys_permission_group` (`permission_id`, `group_id`, `create_time`, `update_time`) VALUES
('business_development', '1', '2015-02-04 21:51:45', '2015-02-04 21:51:45'),
('cand_tracker_add', '1', '2015-05-18 21:44:15', '2015-05-18 21:44:15'),
('cand_tracker_add', '3', '2015-05-18 21:44:15', '2015-05-18 21:44:15'),
('cand_tracker_del', '1', '2015-05-19 18:54:12', '2015-05-19 18:54:12'),
('cand_tracker_del', '3', '2015-05-19 20:59:00', '2015-05-19 20:59:00'),
('cand_tracker_edit', '1', '2015-05-19 18:54:12', '2015-05-19 18:54:12'),
('cand_tracker_edit', '3', '2015-05-19 20:59:00', '2015-05-19 20:59:00'),
('cand_tracker_list', '1', '2015-05-19 18:55:27', '2015-05-19 18:55:27'),
('cand_tracker_list', '3', '2015-05-19 20:59:00', '2015-05-19 20:59:00'),
('cand_tracker_view', '1', '2015-05-25 06:58:22', '2015-05-25 06:58:22'),
('contract_add', '1', '2015-04-30 20:44:02', '2015-04-30 20:44:02'),
('contract_add', '3', '2015-04-30 20:44:54', '2015-04-30 20:44:54'),
('contract_delete', '1', '2015-04-30 10:00:00', '2015-04-30 10:00:00'),
('contract_delete', '2', '2015-04-30 10:00:00', '2015-04-30 10:00:00'),
('contract_delete', '3', '2015-04-30 20:44:54', '2015-04-30 20:44:54'),
('contract_edit', '1', '2015-04-30 10:00:00', '2015-04-30 10:00:00'),
('contract_edit', '2', '2015-04-30 10:00:00', '2015-04-30 10:00:00'),
('contract_edit', '3', '2015-04-30 20:44:55', '2015-04-30 20:44:55'),
('contract_list', '1', '2015-04-30 10:00:00', '2015-04-30 10:00:00'),
('contract_list', '2', '2015-04-30 10:00:00', '2015-04-30 10:00:00'),
('contract_list', '3', '2015-04-30 20:44:55', '2015-04-30 20:44:55'),
('contract_view', '1', '2015-06-04 02:48:57', '2015-06-04 02:48:57'),
('employee_add', '1', '2015-06-11 13:20:00', '2015-06-11 13:20:00'),
('employee_list', '1', '2015-02-04 22:02:07', '2015-02-04 22:02:07'),
('employee_list', '2', '2015-02-04 22:00:18', '2015-02-04 22:00:18'),
('employee_list', '3', '2015-02-04 21:36:20', '2015-02-04 21:36:20'),
('employee_list', '5', '2015-02-04 22:00:40', '2015-02-04 22:00:40'),
('expense_list', '1', '2015-02-04 21:51:45', '2015-02-04 21:51:45'),
('group_add', '1', '2015-02-03 03:02:25', '2015-02-03 03:02:25'),
('group_delete', '1', '2015-02-03 03:02:25', '2015-02-03 03:02:25'),
('group_edit', '1', '2015-02-03 03:02:25', '2015-02-03 03:02:25'),
('group_list', '1', '2015-02-04 21:56:08', '2015-02-04 21:56:08'),
('operations_list', '1', '2015-02-08 21:09:15', '2015-02-08 21:09:15'),
('permission_add', '1', '2015-02-03 00:27:28', '2015-02-03 00:27:28'),
('permission_list', '1', NULL, NULL),
('recruitment_add', '1', '2015-02-03 03:10:08', '2015-02-03 03:10:08'),
('recruitment_add', '2', '2015-02-04 22:00:18', '2015-02-04 22:00:18'),
('recruitment_add', '3', '2015-02-04 21:36:20', '2015-02-04 21:36:20'),
('recruitment_delete', '1', '2015-02-03 03:10:38', '2015-02-03 03:10:38'),
('recruitment_delete', '2', '2015-02-04 22:00:18', '2015-02-04 22:00:18'),
('recruitment_delete', '3', '2015-02-04 21:36:20', '2015-02-04 21:36:20'),
('recruitment_edit', '1', '2015-02-03 03:11:01', '2015-02-03 03:11:01'),
('recruitment_edit', '2', '2015-02-04 22:00:18', '2015-02-04 22:00:18'),
('recruitment_edit', '3', '2015-02-04 21:36:20', '2015-02-04 21:36:20'),
('recruitment_list', '1', '2015-02-04 21:58:47', '2015-02-04 21:58:47'),
('recruitment_list', '2', '2015-02-04 22:00:18', '2015-02-04 22:00:18'),
('recruitment_list', '3', '2015-02-04 21:36:20', '2015-02-04 21:36:20'),
('requisition_add', '1', '2015-04-27 19:54:33', '2015-04-27 19:54:33'),
('requisition_add', '3', '2015-04-26 11:11:18', '2015-04-26 11:11:18'),
('requisition_copy', '1', '2015-05-25 02:52:27', '2015-05-25 02:52:27'),
('requisition_copy', '3', '2015-05-25 02:52:59', '2015-05-25 02:52:59'),
('requisition_delete', '1', '2015-04-27 19:54:34', '2015-04-27 19:54:34'),
('requisition_delete', '3', '2015-04-26 11:11:18', '2015-04-26 11:11:18'),
('requisition_edit', '1', '2015-04-27 19:54:34', '2015-04-27 19:54:34'),
('requisition_edit', '3', '2015-04-26 11:11:19', '2015-04-26 11:11:19'),
('requisition_list', '1', '2015-04-27 19:54:34', '2015-04-27 19:54:34'),
('requisition_list', '3', '2015-04-26 11:11:19', '2015-04-26 11:11:19'),
('requisition_view', '1', '2015-04-30 20:44:02', '2015-04-30 20:44:02'),
('requisition_view', '3', '2015-04-27 20:30:41', '2015-04-27 20:30:41'),
('user_add', '1', '2015-02-03 03:03:14', '2015-02-03 03:03:14'),
('user_changepassword', '1', '2015-02-08 21:09:15', '2015-02-08 21:09:15'),
('user_delete', '1', '2015-02-03 03:04:01', '2015-02-03 03:04:01'),
('user_edit', '1', '2015-02-03 03:03:17', '2015-02-03 03:03:17'),
('user_list', '1', '2015-02-04 21:56:08', '2015-02-04 21:56:08'),
('view_file', '1', '2015-06-20 11:22:07', '2015-06-20 11:22:07');

-- --------------------------------------------------------

--
-- Table structure for table `sys_status`
--

DROP TABLE IF EXISTS `sys_status`;
CREATE TABLE IF NOT EXISTS `sys_status` (
  `status_id` varchar(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_status`
--

INSERT INTO `sys_status` (`status_id`, `description`, `create_time`, `update_time`) VALUES
('1', 'Create', NULL, NULL),
('2', 'Approved', '2015-01-27 10:00:00', '2015-01-27 10:00:00'),
('3', 'Disable', '2015-01-27 10:00:00', '2015-01-27 10:00:00'),
('4', 'Enable', '2015-01-27 10:00:00', '2015-01-27 10:00:00'),
('5', 'Active', '2015-01-27 10:00:00', '2015-01-27 10:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `user_name` varchar(255) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `password_hint` varchar(60) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `client_id` varchar(20) NOT NULL,
  `status_id` varchar(20) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `delete_time` timestamp NULL DEFAULT NULL,
  `delete_user` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `forgot_key` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sys_user`
--

INSERT INTO `sys_user` (`user_name`, `password`, `password_hint`, `email`, `client_id`, `status_id`, `create_time`, `update_time`, `create_user`, `update_user`, `delete_time`, `delete_user`, `is_deleted`, `forgot_key`) VALUES
('admin', '123123', 'mjnhduc98', 'vtran@directviz.com', '1', '2', '2015-01-13 10:00:00', '2015-04-27 23:28:58', '', 'admin', '2015-01-28 09:43:40', 'admin', 0, 'ba326f22-b8cf-4a20-b185-2341a7f51cb1'),
('admin1', '123123', '', 'ngodinhminhduc@gmail.com', '8', '1', '2015-01-28 20:20:18', '2015-01-28 22:08:32', 'admin', 'admin', '2015-01-28 22:20:12', 'admin', 1, NULL),
('admin5', '123123', '', 'ducngo895@gmail.com', '9', '2', '2015-01-28 22:18:58', '2015-01-28 22:19:34', 'admin', 'admin', '2015-01-28 22:20:08', 'admin', 1, NULL),
('hrm_demo', '123123', '', 'hrm_demo@gmail.com', '10', '2', '2015-04-26 11:06:29', '2015-04-26 11:06:29', 'admin', 'admin', NULL, NULL, 0, NULL),
('wqwer', '123123', '', '13sv@f.dcom', '7', '1', '2015-01-28 11:17:14', '2015-01-28 11:17:14', 'admin', 'admin', '2015-01-28 22:01:04', 'admin', 1, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client_relationship`
--
ALTER TABLE `client_relationship`
  ADD PRIMARY KEY (`client_id_from`,`client_id_to`,`role_type_from`,`role_type_to`,`create_time`), ADD KEY `FKCLIENT_REL797291` (`client_id_from`), ADD KEY `FKCLIENT_REL574782` (`client_id_to`), ADD KEY `FKCLIENT_REL721027` (`role_type_to`), ADD KEY `FKCLIENT_REL868862` (`role_type_from`);

--
-- Indexes for table `general_id`
--
ALTER TABLE `general_id`
  ADD PRIMARY KEY (`general_id`);

--
-- Indexes for table `hrm_candidate_tracker`
--
ALTER TABLE `hrm_candidate_tracker`
  ADD PRIMARY KEY (`candidate_tracker_id`);

--
-- Indexes for table `hrm_city`
--
ALTER TABLE `hrm_city`
  ADD PRIMARY KEY (`city_id`,`zipcode`);

--
-- Indexes for table `hrm_clearance_level`
--
ALTER TABLE `hrm_clearance_level`
  ADD PRIMARY KEY (`clearance_lv_id`);

--
-- Indexes for table `hrm_client`
--
ALTER TABLE `hrm_client`
  ADD PRIMARY KEY (`client_id`), ADD KEY `FKCLIENT569639` (`group_id`), ADD KEY `FKCLIENT434045` (`client_type_id`);

--
-- Indexes for table `hrm_client_contact`
--
ALTER TABLE `hrm_client_contact`
  ADD PRIMARY KEY (`client_id`,`contact_id`), ADD KEY `FKCLIENT_CON413042` (`contact_id`), ADD KEY `FKCLIENT_CON302765` (`client_id`);

--
-- Indexes for table `hrm_client_group`
--
ALTER TABLE `hrm_client_group`
  ADD PRIMARY KEY (`client_id`), ADD KEY `FKCLIENT_GRO751502` (`client_id`);

--
-- Indexes for table `hrm_client_type`
--
ALTER TABLE `hrm_client_type`
  ADD PRIMARY KEY (`client_type_id`);

--
-- Indexes for table `hrm_contact`
--
ALTER TABLE `hrm_contact`
  ADD PRIMARY KEY (`contact_id`);

--
-- Indexes for table `hrm_contract`
--
ALTER TABLE `hrm_contract`
  ADD PRIMARY KEY (`contract_id`);

--
-- Indexes for table `hrm_country`
--
ALTER TABLE `hrm_country`
  ADD PRIMARY KEY (`country_id`);

--
-- Indexes for table `hrm_department`
--
ALTER TABLE `hrm_department`
  ADD PRIMARY KEY (`department_id`);

--
-- Indexes for table `hrm_education`
--
ALTER TABLE `hrm_education`
  ADD PRIMARY KEY (`education_id`);

--
-- Indexes for table `hrm_employee`
--
ALTER TABLE `hrm_employee`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `hrm_person`
--
ALTER TABLE `hrm_person`
  ADD PRIMARY KEY (`client_id`), ADD KEY `FKPERSON985816` (`client_id`);

--
-- Indexes for table `hrm_position`
--
ALTER TABLE `hrm_position`
  ADD PRIMARY KEY (`position_id`);

--
-- Indexes for table `hrm_recruitment`
--
ALTER TABLE `hrm_recruitment`
  ADD PRIMARY KEY (`recruitment_id`), ADD KEY `FKRECRUITMEN862661` (`client_id_position`), ADD KEY `FKRECRUITMEN602012` (`recruitment_type_id`);

--
-- Indexes for table `hrm_recruitment_type`
--
ALTER TABLE `hrm_recruitment_type`
  ADD PRIMARY KEY (`recruitment_type_id`);

--
-- Indexes for table `hrm_requisition`
--
ALTER TABLE `hrm_requisition`
  ADD PRIMARY KEY (`requisition_id`);

--
-- Indexes for table `hrm_state`
--
ALTER TABLE `hrm_state`
  ADD PRIMARY KEY (`state_id`);

--
-- Indexes for table `hrm_status`
--
ALTER TABLE `hrm_status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `hrm_termination_reason`
--
ALTER TABLE `hrm_termination_reason`
  ADD PRIMARY KEY (`termination_reason_id`);

--
-- Indexes for table `hrm_work_time`
--
ALTER TABLE `hrm_work_time`
  ADD PRIMARY KEY (`work_time_id`);

--
-- Indexes for table `interview`
--
ALTER TABLE `interview`
  ADD PRIMARY KEY (`interview_id`), ADD KEY `FKINTERVIEW403512` (`round_id`), ADD KEY `FKINTERVIEW410479` (`client_id_interviewer`), ADD KEY `FKINTERVIEW821774` (`client_id_position`), ADD KEY `FKINTERVIEW44599` (`client_id_applicant`);

--
-- Indexes for table `interview_question`
--
ALTER TABLE `interview_question`
  ADD PRIMARY KEY (`interview_question_id`), ADD KEY `FKINTERVIEW_907813` (`client_id_position`), ADD KEY `FKINTERVIEW_317473` (`round_id`);

--
-- Indexes for table `menu_link`
--
ALTER TABLE `menu_link`
  ADD PRIMARY KEY (`menu_link_id`), ADD KEY `FKMENU_LINK501426` (`module_id`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`module_id`);

--
-- Indexes for table `permisstion_module`
--
ALTER TABLE `permisstion_module`
  ADD PRIMARY KEY (`permission_id`,`module_id`), ADD KEY `FKPERMISSTIO544705` (`permission_id`), ADD KEY `FKPERMISSTIO838730` (`module_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`client_id`), ADD KEY `FKROLE934745` (`role_type_id`), ADD KEY `FKROLE75512` (`client_id`);

--
-- Indexes for table `role_type`
--
ALTER TABLE `role_type`
  ADD PRIMARY KEY (`role_type_id`);

--
-- Indexes for table `round`
--
ALTER TABLE `round`
  ADD PRIMARY KEY (`round_id`);

--
-- Indexes for table `sys_group`
--
ALTER TABLE `sys_group`
  ADD PRIMARY KEY (`group_id`);

--
-- Indexes for table `sys_permission`
--
ALTER TABLE `sys_permission`
  ADD PRIMARY KEY (`permission_id`);

--
-- Indexes for table `sys_permission_group`
--
ALTER TABLE `sys_permission_group`
  ADD PRIMARY KEY (`permission_id`,`group_id`), ADD KEY `FKPERMISSION909800` (`permission_id`), ADD KEY `FKPERMISSION829558` (`group_id`);

--
-- Indexes for table `sys_status`
--
ALTER TABLE `sys_status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `sys_user`
--
ALTER TABLE `sys_user`
  ADD PRIMARY KEY (`user_name`), ADD KEY `FKUSER982498` (`client_id`), ADD KEY `FKUSER970628` (`status_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hrm_candidate_tracker`
--
ALTER TABLE `hrm_candidate_tracker`
  MODIFY `candidate_tracker_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `hrm_clearance_level`
--
ALTER TABLE `hrm_clearance_level`
  MODIFY `clearance_lv_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `hrm_contract`
--
ALTER TABLE `hrm_contract`
  MODIFY `contract_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `hrm_country`
--
ALTER TABLE `hrm_country`
  MODIFY `country_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `hrm_department`
--
ALTER TABLE `hrm_department`
  MODIFY `department_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `hrm_education`
--
ALTER TABLE `hrm_education`
  MODIFY `education_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `hrm_employee`
--
ALTER TABLE `hrm_employee`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `hrm_position`
--
ALTER TABLE `hrm_position`
  MODIFY `position_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `hrm_recruitment`
--
ALTER TABLE `hrm_recruitment`
  MODIFY `recruitment_id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `hrm_requisition`
--
ALTER TABLE `hrm_requisition`
  MODIFY `requisition_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=63;
--
-- AUTO_INCREMENT for table `hrm_state`
--
ALTER TABLE `hrm_state`
  MODIFY `state_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=65;
--
-- AUTO_INCREMENT for table `hrm_status`
--
ALTER TABLE `hrm_status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `hrm_termination_reason`
--
ALTER TABLE `hrm_termination_reason`
  MODIFY `termination_reason_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `hrm_work_time`
--
ALTER TABLE `hrm_work_time`
  MODIFY `work_time_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `client_relationship`
--
ALTER TABLE `client_relationship`
ADD CONSTRAINT `FKCLIENT_REL574782` FOREIGN KEY (`client_id_to`) REFERENCES `hrm_client` (`client_id`),
ADD CONSTRAINT `FKCLIENT_REL721027` FOREIGN KEY (`role_type_to`) REFERENCES `role_type` (`role_type_id`),
ADD CONSTRAINT `FKCLIENT_REL797291` FOREIGN KEY (`client_id_from`) REFERENCES `hrm_client` (`client_id`),
ADD CONSTRAINT `FKCLIENT_REL868862` FOREIGN KEY (`role_type_from`) REFERENCES `role_type` (`role_type_id`);

--
-- Constraints for table `hrm_client`
--
ALTER TABLE `hrm_client`
ADD CONSTRAINT `FKCLIENT434045` FOREIGN KEY (`client_type_id`) REFERENCES `hrm_client_type` (`client_type_id`),
ADD CONSTRAINT `FKCLIENT569639` FOREIGN KEY (`group_id`) REFERENCES `sys_group` (`group_id`);

--
-- Constraints for table `hrm_client_contact`
--
ALTER TABLE `hrm_client_contact`
ADD CONSTRAINT `FKCLIENT_CON302765` FOREIGN KEY (`client_id`) REFERENCES `hrm_client` (`client_id`),
ADD CONSTRAINT `FKCLIENT_CON413042` FOREIGN KEY (`contact_id`) REFERENCES `hrm_contact` (`contact_id`);

--
-- Constraints for table `hrm_client_group`
--
ALTER TABLE `hrm_client_group`
ADD CONSTRAINT `FKCLIENT_GRO751502` FOREIGN KEY (`client_id`) REFERENCES `hrm_client` (`client_id`);

--
-- Constraints for table `hrm_person`
--
ALTER TABLE `hrm_person`
ADD CONSTRAINT `FKPERSON985816` FOREIGN KEY (`client_id`) REFERENCES `hrm_client` (`client_id`);

--
-- Constraints for table `hrm_recruitment`
--
ALTER TABLE `hrm_recruitment`
ADD CONSTRAINT `FKRECRUITMEN602012` FOREIGN KEY (`recruitment_type_id`) REFERENCES `hrm_recruitment_type` (`recruitment_type_id`),
ADD CONSTRAINT `FKRECRUITMEN862661` FOREIGN KEY (`client_id_position`) REFERENCES `hrm_client` (`client_id`);

--
-- Constraints for table `interview`
--
ALTER TABLE `interview`
ADD CONSTRAINT `FKINTERVIEW403512` FOREIGN KEY (`round_id`) REFERENCES `round` (`round_id`),
ADD CONSTRAINT `FKINTERVIEW410479` FOREIGN KEY (`client_id_interviewer`) REFERENCES `hrm_client` (`client_id`),
ADD CONSTRAINT `FKINTERVIEW44599` FOREIGN KEY (`client_id_applicant`) REFERENCES `hrm_client` (`client_id`),
ADD CONSTRAINT `FKINTERVIEW821774` FOREIGN KEY (`client_id_position`) REFERENCES `hrm_client` (`client_id`);

--
-- Constraints for table `interview_question`
--
ALTER TABLE `interview_question`
ADD CONSTRAINT `FKINTERVIEW_317473` FOREIGN KEY (`round_id`) REFERENCES `round` (`round_id`),
ADD CONSTRAINT `FKINTERVIEW_907813` FOREIGN KEY (`client_id_position`) REFERENCES `hrm_client` (`client_id`);

--
-- Constraints for table `menu_link`
--
ALTER TABLE `menu_link`
ADD CONSTRAINT `FKMENU_LINK501426` FOREIGN KEY (`module_id`) REFERENCES `module` (`module_id`);

--
-- Constraints for table `permisstion_module`
--
ALTER TABLE `permisstion_module`
ADD CONSTRAINT `FKPERMISSTIO544705` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`permission_id`),
ADD CONSTRAINT `FKPERMISSTIO838730` FOREIGN KEY (`module_id`) REFERENCES `module` (`module_id`);

--
-- Constraints for table `role`
--
ALTER TABLE `role`
ADD CONSTRAINT `FKROLE75512` FOREIGN KEY (`client_id`) REFERENCES `hrm_client` (`client_id`),
ADD CONSTRAINT `FKROLE934745` FOREIGN KEY (`role_type_id`) REFERENCES `role_type` (`role_type_id`);

--
-- Constraints for table `sys_permission_group`
--
ALTER TABLE `sys_permission_group`
ADD CONSTRAINT `FKPERMISSION829558` FOREIGN KEY (`group_id`) REFERENCES `sys_group` (`group_id`),
ADD CONSTRAINT `FKPERMISSION909800` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`permission_id`);

--
-- Constraints for table `sys_user`
--
ALTER TABLE `sys_user`
ADD CONSTRAINT `FKUSER970628` FOREIGN KEY (`status_id`) REFERENCES `sys_status` (`status_id`),
ADD CONSTRAINT `FKUSER982498` FOREIGN KEY (`client_id`) REFERENCES `hrm_client` (`client_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

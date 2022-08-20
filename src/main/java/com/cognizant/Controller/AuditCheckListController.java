package com.cognizant.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.feignclient.AuthClient;
import com.cognizant.model.QuestionsEntity;
import com.cognizant.pojo.AuditType;
import com.cognizant.pojo.CustomErrorResponse;
import com.cognizant.service.QuestionsService;
import com.cognizant.service.TokenService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class is handling all the end points for Audit Checklist microservice. 
 * This controller has mappings as-
 * 			postmapping-getChecklist()
 * 			postmapping-saveResponses()
 *
 */


@RestController 
@Slf4j
public class AuditCheckListController {

	@Autowired
	AuthClient authClient;
	
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	QuestionsService questionsService;
	/**
     * 
     * @param token
     * @param auditType
     * @return ResponseEntity<Response>
     * 
     * Returns the Questions according to the User's input whether he has chosen Internal or SOX audit type
	 *
     */
	@PostMapping("/getChecklist")
	public ResponseEntity<?> getChecklist(@RequestHeader(name="Authorization",required=true) String token,@RequestBody AuditType auditType){
		try {
		log.info("getchecklist starts");
		List<QuestionsEntity> questionsList = new ArrayList<>();
		ResponseEntity<?> responseEntity;
		if(tokenService.checkTokenValidity(token)) {
			log.debug("In checklist" + auditType.getAuditType());
			try {
			questionsList = questionsService.getQuestions(auditType.getAuditType());
			}catch(IndexOutOfBoundsException e) {
				log.error("array out of bounds"); 
				log.info("checklist ends");
//				responseEntity= new ResponseEntity<String>("null",HttpStatus.INTERNAL_SERVER_ERROR);
//				return responseEntity;
				
					return new ResponseEntity<Object>(new CustomErrorResponse(LocalDateTime.now(), HttpStatus.FORBIDDEN, "wrong cred", "wrong cred"), HttpStatus.FORBIDDEN);
			}
			responseEntity = new ResponseEntity<List<QuestionsEntity>>(questionsList,HttpStatus.OK);
			log.debug("response",responseEntity);
			log.info("get check list ends");
			return responseEntity;
			
		}
		else {
			log.error("token expired"); 
			log.info("checklist ends:");
			
			responseEntity= new ResponseEntity<String>("token expired. please login",HttpStatus.FORBIDDEN);
			return responseEntity;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new CustomErrorResponse(LocalDateTime.now(), HttpStatus.FORBIDDEN, "wrong cred", "wrong cred"), HttpStatus.FORBIDDEN);
		}
	}
	/**
	 * 
	 * @param token
	 * @param questionsResponse
	 * @return ResponseEntity 
	 * 
	 * This is storing the responses of the Internal/SOX Audit Questions into the database.
	 * 
	 */
	@PostMapping("/saveResponses")
	public ResponseEntity<?> saveResponses(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody List<QuestionsEntity> questionsResponse){
		List<QuestionsEntity> questionsList = new ArrayList<>();
		ResponseEntity<?> responseEntity;
		if(tokenService.checkTokenValidity(token)) {
			questionsList = questionsService.saveResponses(questionsResponse);
			responseEntity = new ResponseEntity<List<QuestionsEntity>>(questionsList,HttpStatus.OK);
			log.debug("response entity",responseEntity);
			log.info("end");

			return responseEntity;
		}
		else {
			log.error("token expired"); 
			log.info("save responses end");

			responseEntity= new ResponseEntity<String>("token expired",HttpStatus.FORBIDDEN);
			return responseEntity;
		}
	}
	
		
}

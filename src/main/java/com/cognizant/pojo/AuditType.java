package com.cognizant.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * This POJO class is used for Audit Type
 * 
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditType {

	String auditType;//Internal or SOX

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}


	
}

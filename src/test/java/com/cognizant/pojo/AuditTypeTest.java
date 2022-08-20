package com.cognizant.pojo;


import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * 
 *  	   This class contains test cases for the AuditType class
 *         which are written using junit and mockito
 */
@SpringBootTest
public class AuditTypeTest {

	
	AuditType auditType = new AuditType();
	/**
	 * Test the AuditType Setter
	 */
	@Test
	public void testSetAuditType() {
		auditType.setAuditType("Internal");
		assertEquals("Internal",auditType.getAuditType());
	}
	/**
	 * Test the AuditType Getter
	 */
	@Test
	public void testGetAuditType() {
		auditType.setAuditType("SOX");
		assertEquals("SOX",auditType.getAuditType());
	}
	/**
	 * Test the AuditType All Args Constructor
	 */
	@Test
	public void testAuditTypeConstructor() {
		AuditType auditTypeTest = new AuditType("Sox");
		assertEquals("Sox",auditTypeTest.getAuditType());
	}
	/**
	 * Test the AuditType toString
	 */
	
	
	
	@Test
	public void testEquals2()
	{
		AuditType model=new AuditType("Internal");
		auditType=new AuditType();
		assertNotEquals(model,auditType);
	}
	@Test
	public void testEquals3()
	{
		AuditType model=new AuditType();
		auditType=new AuditType("Internal");
		assertNotEquals(model, auditType);
	}
	@Test
	public void testEquals4() {
		auditType=new AuditType("Internal");
		AuditType model=auditType;
	assertEquals(auditType,model);
	}
	
}

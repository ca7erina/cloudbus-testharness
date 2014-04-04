package tests.testObject;

import java.sql.Date;

public class TestCaseResult {
	Integer resultInfoId;
	Integer executeId;
	Integer TestlinkID;
	String testSuitName;
	String casename;
	String caseSummary;
	Integer caseResult;
	Date caseExecuteTime;
	String codeName;
	String caseComment;
	
	TestCaseResult(){
		
	}

	public Integer getResultInfoId() {
		return resultInfoId;
	}

	public void setResultInfoId(Integer resultInfoId) {
		this.resultInfoId = resultInfoId;
	}

	public Integer getExecuteId() {
		return executeId;
	}

	public void setExecuteId(Integer executeId) {
		this.executeId = executeId;
	}

	public Integer getTestlinkID() {
		return TestlinkID;
	}

	public void setTestlinkID(Integer testlinkID) {
		TestlinkID = testlinkID;
	}

	public String getTestSuitName() {
		return testSuitName;
	}

	public void setTestSuitName(String testSuitName) {
		this.testSuitName = testSuitName;
	}

	public String getCasename() {
		return casename;
	}

	public void setCasename(String casename) {
		this.casename = casename;
	}

	public String getCaseSummary() {
		return caseSummary;
	}

	public void setCaseSummary(String caseSummary) {
		this.caseSummary = caseSummary;
	}

	public Integer getCaseResult() {
		return caseResult;
	}

	public void setCaseResult(Integer caseResult) {
		this.caseResult = caseResult;
	}

	public Date getCaseExecuteTime() {
		return caseExecuteTime;
	}

	public void setCaseExecuteTime(Date caseExecuteTime) {
		this.caseExecuteTime = caseExecuteTime;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCaseComment() {
		return caseComment;
	}

	public void setCaseComment(String caseComment) {
		this.caseComment = caseComment;
	}
	
	
	
	
}

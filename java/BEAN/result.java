package BEAN;

public class result {
private int resultid;
private int correctanswernum;
private int incorrectanswernum;
private String time;
private int examinationid;
private int memberid;
public result() {
	// TODO Auto-generated constructor stub
}
public result(int resultid, int correctanswernum, int incorrectanswernum, String time, int examinationid,
		int memberid) {
//	super();
	this.resultid = resultid;
	this.correctanswernum = correctanswernum;
	this.incorrectanswernum = incorrectanswernum;
	this.time = time;
	this.examinationid = examinationid;
	this.memberid = memberid;
}
public int getResultid() {
	return resultid;
}
public void setResultid(int resultid) {
	this.resultid = resultid;
}
public int getCorrectanswernum() {
	return correctanswernum;
}
public void setCorrectanswernum(int correctanswernum) {
	this.correctanswernum = correctanswernum;
}
public int getIncorrectanswernum() {
	return incorrectanswernum;
}
public void setIncorrectanswernum(int incorrectanswernum) {
	this.incorrectanswernum = incorrectanswernum;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public int getExaminationid() {
	return examinationid;
}
public void setExaminationid(int examinationid) {
	this.examinationid = examinationid;
}
public int getMemberid() {
	return memberid;
}
public void setMemberid(int memberid) {
	this.memberid = memberid;
}




}

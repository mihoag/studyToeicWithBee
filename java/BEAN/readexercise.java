package BEAN;

public class readexercise {
private int readexerciseid;
private String readname;
private String readimage;
private int checkCauHoi;
public readexercise() {
	// TODO Auto-generated constructor stub
}
public readexercise(int readexerciseid, String readname, String readimage, int checkCauHoi) {
	super();
	this.readexerciseid = readexerciseid;
	this.readname = readname;
	this.readimage = readimage;
	this.checkCauHoi = checkCauHoi;
}
public int getReadexerciseid() {
	return readexerciseid;
}
public void setReadexerciseid(int readexerciseid) {
	this.readexerciseid = readexerciseid;
}
public String getReadname() {
	return readname;
}
public void setReadname(String readname) {
	this.readname = readname;
}
public String getReadimage() {
	return readimage;
}
public void setReadimage(String readimage) {
	this.readimage = readimage;
}
public int getCheckCauHoi() {
	return checkCauHoi;
}
public void setCheckCauHoi(int checkCauHoi) {
	this.checkCauHoi = checkCauHoi;
}



}

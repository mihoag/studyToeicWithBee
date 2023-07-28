package BEAN;

public class listenexercise {
  private int listenexerciseid;
  private String listenexercisename;
  private String listenexerciseimage;
  private int checkNoiDung;
public listenexercise() {
	// TODO Auto-generated constructor stub
}
public listenexercise(int listenexerciseid, String listenexercisename, String listenexerciseimage, int checkNoiDung) {
	super();
	this.listenexerciseid = listenexerciseid;
	this.listenexercisename = listenexercisename;
	this.listenexerciseimage = listenexerciseimage;
	this.checkNoiDung = checkNoiDung;
}
public int getListenexerciseid() {
	return listenexerciseid;
}
public void setListenexerciseid(int listenexerciseid) {
	this.listenexerciseid = listenexerciseid;
}
public String getListenexercisename() {
	return listenexercisename;
}
public void setListenexercisename(String listenexercisename) {
	this.listenexercisename = listenexercisename;
}
public String getListenexerciseimage() {
	return listenexerciseimage;
}
public void setListenexerciseimage(String listenexerciseimage) {
	this.listenexerciseimage = listenexerciseimage;
}
public int getCheckNoiDung() {
	return checkNoiDung;
}
public void setCheckNoiDung(int checkNoiDung) {
	this.checkNoiDung = checkNoiDung;
}
}

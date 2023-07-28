package BEAN;

public class examination {
   private int examinationid;
   private String examinationname;
   private String examinationimage;
   private int checkcauhoi;
public int getExaminationid() {
	return examinationid;
}
public void setExaminationid(int examinationid) {
	this.examinationid = examinationid;
}
public String getExaminationname() {
	return examinationname;
}
public void setExaminationname(String examinationname) {
	this.examinationname = examinationname;
}
public String getExaminationimage() {
	return examinationimage;
}
public void setExaminationimage(String examinationimage) {
	this.examinationimage = examinationimage;
}
public int getCheckcauhoi() {
	return checkcauhoi;
}
public void setCheckcauhoi(int checkcauhoi) {
	this.checkcauhoi = checkcauhoi;
}
public examination(int examinationid, String examinationname, String examinationimage, int checkcauhoi) {
	super();
	this.examinationid = examinationid;
	this.examinationname = examinationname;
	this.examinationimage = examinationimage;
	this.checkcauhoi = checkcauhoi;
} 
}

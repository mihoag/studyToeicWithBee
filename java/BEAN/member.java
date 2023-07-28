package BEAN;

public class member {
private String membername;
private String memberpass;
private int categorymemberid;
private String name;
public member() {
	// TODO Auto-generated constructor stub
}
public member(String membername, String memberpass, int categorymemberid, String name) {
	super();
	this.membername = membername;
	this.memberpass = memberpass;
	this.categorymemberid = categorymemberid;
	this.name = name;
}
public String getMembername() {
	return membername;
}
public void setMembername(String membername) {
	this.membername = membername;
}
public String getMemberpass() {
	return memberpass;
}
public void setMemberpass(String memberpass) {
	this.memberpass = memberpass;
}
public int getCategorymemberid() {
	return categorymemberid;
}
public void setCategorymemberid(int categorymemberid) {
	this.categorymemberid = categorymemberid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}

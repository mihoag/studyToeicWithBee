package BEAN;

public class cmtgrammar {
private String cmtgrammarcontent;
private int memberid;
private int grammarguidelineid;
private String name;
public cmtgrammar(String cmtgrammarcontent, int memberid, int grammarguidelineid, String name) {
	super();
	this.cmtgrammarcontent = cmtgrammarcontent;
	this.memberid = memberid;
	this.grammarguidelineid = grammarguidelineid;
	this.name = name;
}
/**
 * 
 */
public cmtgrammar() {
	// TODO Auto-generated constructor stub
}
public String getCmtgrammarcontent() {
	return cmtgrammarcontent;
}
public void setCmtgrammarcontent(String cmtgrammarcontent) {
	this.cmtgrammarcontent = cmtgrammarcontent;
}
public int getMemberid() {
	return memberid;
}
public void setMemberid(int memberid) {
	this.memberid = memberid;
}
public int getGrammarguidelineid() {
	return grammarguidelineid;
}
public void setGrammarguidelineid(int grammarguidelineid) {
	this.grammarguidelineid = grammarguidelineid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}

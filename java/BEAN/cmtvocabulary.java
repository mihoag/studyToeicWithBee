package BEAN;

public class cmtvocabulary {
private int cmtvocabularyid;
private String cmtvocabularycontent;
private int memberid;
private int vocabularyguidelineid;
private String name;
public cmtvocabulary() {
	// TODO Auto-generated constructor stub
}
public cmtvocabulary(int cmtvocabularyid, String cmtvocabularycontent, int memberid, int vocabularyguidelineid,
		String name) {
	super();
	this.cmtvocabularyid = cmtvocabularyid;
	this.cmtvocabularycontent = cmtvocabularycontent;
	this.memberid = memberid;
	this.vocabularyguidelineid = vocabularyguidelineid;
	this.name = name;
}
public int getCmtvocabularyid() {
	return cmtvocabularyid;
}
public void setCmtvocabularyid(int cmtvocabularyid) {
	this.cmtvocabularyid = cmtvocabularyid;
}
public String getCmtvocabularycontent() {
	return cmtvocabularycontent;
}
public void setCmtvocabularycontent(String cmtvocabularycontent) {
	this.cmtvocabularycontent = cmtvocabularycontent;
}
public int getMemberid() {
	return memberid;
}
public void setMemberid(int memberid) {
	this.memberid = memberid;
}
public int getVocabularyguidelineid() {
	return vocabularyguidelineid;
}
public void setVocabularyguidelineid(int vocabularyguidelineid) {
	this.vocabularyguidelineid = vocabularyguidelineid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}



}

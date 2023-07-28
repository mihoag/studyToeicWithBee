package BEAN;

public class vocabularyguideline {
private int vocabularyguidelineid;
private String vocabularyname;
private String vocabularyimage;
private int checknoidung;
public vocabularyguideline(int vocabularyguidelineid, String vocabularyname, String vocabularyimage, int checknoidung) {
	super();
	this.vocabularyguidelineid = vocabularyguidelineid;
	this.vocabularyname = vocabularyname;
	this.vocabularyimage = vocabularyimage;
	this.checknoidung = checknoidung;
}
public vocabularyguideline() {
	// TODO Auto-generated constructor stub
}
public int getVocabularyguidelineid() {
	return vocabularyguidelineid;
}
public void setVocabularyguidelineid(int vocabularyguidelineid) {
	this.vocabularyguidelineid = vocabularyguidelineid;
}
public String getVocabularyname() {
	return vocabularyname;
}
public void setVocabularyname(String vocabularyname) {
	this.vocabularyname = vocabularyname;
}
public String getVocabularyimage() {
	return vocabularyimage;
}
public void setVocabularyimage(String vocabularyimage) {
	this.vocabularyimage = vocabularyimage;
}
public int getChecknoidung() {
	return checknoidung;
}
public void setChecknoidung(int checknoidung) {
	this.checknoidung = checknoidung;
}

}

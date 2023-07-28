package BEAN;

public class grammarguideline {
private int grammarguidelineid;
private String grammarname;
private String grammarimage;
private String content;
public grammarguideline() {
	// TODO Auto-generated constructor stub
}
public grammarguideline(int grammarguidelineid, String grammarname, String grammarimage, String content) {
	//super();
	this.grammarguidelineid = grammarguidelineid;
	this.grammarname = grammarname;
	this.grammarimage = grammarimage;
	this.content = content;
}
public int getGrammarguidelineid() {
	return grammarguidelineid;
}
public void setGrammarguidelineid(int grammarguidelineid) {
	this.grammarguidelineid = grammarguidelineid;
}
public String getGrammarname() {
	return grammarname;
}
public void setGrammarname(String grammarname) {
	this.grammarname = grammarname;
}
public String getGrammarimage() {
	return grammarimage;
}
public void setGrammarimage(String grammarimage) {
	this.grammarimage = grammarimage;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

}

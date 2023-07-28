package BEAN;

public class vocabularycontent {
private int vocabularycontentid;
private String vocabularycontentname;
private String transcribe;
private String audiomp3;
private String audiogg;
private String mean;
private int vocabularyguidelineid;
public vocabularycontent() {
	// TODO Auto-generated constructor stub
}
public vocabularycontent(int vocabularycontentid, String vocabularycontentname, String transcribe, String audiomp3,
		String audiogg, String mean, int vocabularyguidelineid) {
	super();
	this.vocabularycontentid = vocabularycontentid;
	this.vocabularycontentname = vocabularycontentname;
	this.transcribe = transcribe;
	this.audiomp3 = audiomp3;
	this.audiogg = audiogg;
	this.mean = mean;
	this.vocabularyguidelineid = vocabularyguidelineid;
}
public int getVocabularycontentid() {
	return vocabularycontentid;
}
public void setVocabularycontentid(int vocabularycontentid) {
	this.vocabularycontentid = vocabularycontentid;
}
public String getVocabularycontentname() {
	return vocabularycontentname;
}
public void setVocabularycontentname(String vocabularycontentname) {
	this.vocabularycontentname = vocabularycontentname;
}
public String getTranscribe() {
	return transcribe;
}
public void setTranscribe(String transcribe) {
	this.transcribe = transcribe;
}
public String getAudiomp3() {
	return audiomp3;
}
public void setAudiomp3(String audiomp3) {
	this.audiomp3 = audiomp3;
}
public String getAudiogg() {
	return audiogg;
}
public void setAudiogg(String audiogg) {
	this.audiogg = audiogg;
}
public String getMean() {
	return mean;
}
public void setMean(String mean) {
	this.mean = mean;
}
public int getVocabularyguidelineid() {
	return vocabularyguidelineid;
}
public void setVocabularyguidelineid(int vocabularyguidelineid) {
	this.vocabularyguidelineid = vocabularyguidelineid;
}



}

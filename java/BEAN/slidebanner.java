package BEAN;

public class slidebanner {

private int slidebannerid;
private String slidename;
private String slidecontent;
private String slideimage;
public slidebanner() {
	// TODO Auto-generated constructor stub
}
public slidebanner(int slidebannerid, String slidename, String slidecontent, String slideimage) {
	//super();
	this.slidebannerid = slidebannerid;
	this.slidename = slidename;
	this.slidecontent = slidecontent;
	this.slideimage = slideimage;
}
public int getSlidebannerid() {
	return slidebannerid;
}
public void setSlidebannerid(int slidebannerid) {
	this.slidebannerid = slidebannerid;
}
public String getSlidename() {
	return slidename;
}
public void setSlidename(String slidename) {
	this.slidename = slidename;
}
public String getSlidecontent() {
	return slidecontent;
}
public void setSlidecontent(String slidecontent) {
	this.slidecontent = slidecontent;
}
public String getSlideimage() {
	return slideimage;
}
public void setSlideimage(String slideimage) {
	this.slideimage = slideimage;
}
@Override
public String toString() {
	return "slidebanner [slidebannerid=" + slidebannerid + ", slidename=" + slidename + ", slidecontent=" + slidecontent
			+ ", slideimage=" + slideimage + "]";
}


}

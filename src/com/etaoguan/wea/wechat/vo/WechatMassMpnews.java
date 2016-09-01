package com.etaoguan.wea.wechat.vo;

/**
 * @author cunli
 * 图文消息
 */
public class WechatMassMpnews {
	private long mpnewsId;
	private long massMessageId;
	private String thumbMediaId;
	private String author;
	private String title;
	private String contentSourceUrl;
	private String content;
	private String digest;
	private int showCoverPic;
	private String ids;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public long getMpnewsId() {
		return mpnewsId;
	}
	public void setMpnewsId(long mpnewsId) {
		this.mpnewsId = mpnewsId;
	}
	public long getMassMessageId() {
		return massMessageId;
	}
	public void setMassMessageId(long massMessageId) {
		this.massMessageId = massMessageId;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentSourceUrl() {
		return contentSourceUrl;
	}
	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public int getShowCoverPic() {
		return showCoverPic;
	}
	public void setShowCoverPic(int showCoverPic) {
		this.showCoverPic = showCoverPic;
	}



}

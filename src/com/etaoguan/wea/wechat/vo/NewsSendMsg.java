package com.etaoguan.wea.wechat.vo;

import java.util.ArrayList;
import java.util.List;

public class NewsSendMsg extends SendMsg{

	private String articleCount;
	
	private String funcFlag;
	
	private List<Item> articles= new ArrayList<Item>();
	
	public String getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(String articleCount) {
		this.articleCount = articleCount;
	}
	

	public static class Item{
		
		private String title;
		
		private String description;
		
		private String picUrl;
		
		private String url;
	
	
		public String getTitle() {
			return title;
		}
	
		public void setTitle(String title) {
			this.title = title;
		}
	
		public String getDescription() {
			return description;
		}
	
		public void setDescription(String description) {
			this.description = description;
		}
	
		public String getPicUrl() {
			return picUrl;
		}
	
		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}
	
		public String getUrl() {
			return url;
		}
	
		public void setUrl(String url) {
			this.url = url;
		}
	}


	public List<Item> getArticles() {
		return articles;
	}

	public void setArticles(List<Item> articles) {
		this.articles = articles;
	}
	
	public void addArticle(Item item){
		this.articles.add(item);
	}

	public String getFuncFlag() {
		return funcFlag;
	}

	public void setFuncFlag(String funcFlag) {
		this.funcFlag = funcFlag;
	}

}

package com.etaoguan.wea.wechat.vo;

public class MusicSendMsg extends SendMsg{

	private Music music;

	
	public static class Music {

		private String title;
		
		private String description;
		
		private String musicUrl;
	
		private String hQMusicUrl;
	
		public String getMusicUrl() {
			return musicUrl;
		}
	
		public void setMusicUrl(String musicUrl) {
			this.musicUrl = musicUrl;
		}
	
		public String gethQMusicUrl() {
			return hQMusicUrl;
		}
	
		public void sethQMusicUrl(String hQMusicUrl) {
			this.hQMusicUrl = hQMusicUrl;
		}
		
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
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}



}

package edu.jeiu.diary_pjt.dto;

public class DiaryDTO {
	
	//DB에 정의된 필드
	private int id;
	private String title;
	private String writeDate;
	private String content;
	private String searchTitleName;
	
	public String getSearchTitleName() {
		return searchTitleName;
	}
	public void setSearchTitleName(String searchTitleName) {
		this.searchTitleName = searchTitleName;
	}
	//필드의 getter와 setter 정의
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}

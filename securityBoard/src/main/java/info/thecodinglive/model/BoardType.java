package info.thecodinglive.model;

public enum BoardType {
	notice("공지사항"),
	free("자유게시판"),
	event("이벤트"),
	check("체크");
	
	private String value;
	private BoardType(String value) {
		this.value=value;
	}
	
	
	public String getValue() {
		return value;
	}

	
	
}

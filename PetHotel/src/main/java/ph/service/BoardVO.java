package ph.service;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BoardVO {
	
	private int boardNo;
	private String title;
	private String content;
	private Date wdate;
	private String boardType;
	
	private String memberId;
	private String memberNickname;
	
	private String employeeId;
	private String employeeNickname;
	private String employeeRole;
	private String reviewPicturePath;

}

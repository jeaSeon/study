package info.thecodinglive.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	//댓글 번호
	private String comment;	//내용
	private Date cdate;	//날짜
	
	@PrePersist	//날짜 자동 주입
	public void beforeCreate() {
		cdate=new Date();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="board_id")
	private Board board;	//게시판정보
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="users_id")
	private Users users; //회원정보
	
	@Builder
	public Comment(String comment, Date cdate, Board board,
			 Users users) {
		this.comment=comment;
		this.cdate=cdate;
		this.board=board;
		this.users=users;
	}
}

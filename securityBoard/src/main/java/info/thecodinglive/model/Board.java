package info.thecodinglive.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//게시글 엔티티이다.
@Data
@NoArgsConstructor
@Entity
@Table(name="board")
public class Board implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="board_id")
	private Long id;			//글번호
	private String title;		//제목
	private String subTitle;	//부제목
	private String content;		//내용
	private int pageView;		//조회수
	
	@Enumerated(EnumType.STRING)
	private BoardType boardType;//게시판 타입(이넘)
	
	private Date wdate;			//날짜	
	
	@PrePersist	//->Date 값을 자동으로 넣어준다. 
	public void beforeCreate() { 
		wdate=new Date();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="users_id")
	@JsonIgnore
	private Users user;			//회원정보
 
	//mappedBy="board",
	//게시글과 댓글 사이에 참조키로 엮여져 있어서 그냥은 삭제가 안된다. --> cascade 사용
	@OneToMany(mappedBy="board",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Comment> comments;

	@Builder
	public Board(String title, String subTitle, String content,
			BoardType boardType, Date wdate,
			 Users user, List<Comment> comments) {
		this.title=title;
		this.subTitle=subTitle;
		this.content=content;
		this.boardType=boardType;
		this.wdate=wdate;
		this.user=user;
		this.comments=comments;
		
		
	}
	
}

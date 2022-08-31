package info.thecodinglive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.thecodinglive.model.Board;
import info.thecodinglive.model.Comment;

//commentrepository이다. (댓글)
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	public List<Comment> findByBoardId(long boardId);
	
	
	//UserId를 매개변수로 데이터 삭제. 
	//지금의 경우에는 @Transactional을 붙여야 실행된다.
	@Transactional
	public void deleteByUsersId(int userId);
}

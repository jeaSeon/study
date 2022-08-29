package info.thecodinglive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.thecodinglive.model.Board;
import info.thecodinglive.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	public List<Comment> findByBoardId(long boardId);
	
	
	//UserId를 매개변수로 데이터 삭제. @Transactional은 왜 붙이는거죠?
	@Transactional
	public void deleteByUsersId(int userId);
}

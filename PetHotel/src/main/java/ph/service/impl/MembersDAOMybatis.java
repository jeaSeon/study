package ph.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ph.service.MembersDAO;
import ph.service.MembersVO;

@Repository("memberDAOMybatis")
public class MembersDAOMybatis extends EgovAbstractMapper implements MembersDAO {

	//아이디 중복체크
	@Override
	public int memberId_check(String memberId) throws Exception {
		int result = selectOne("memberId_check", memberId);
		return result;
	}

	//닉네임 중복체크
	@Override
	public int memberNickname_check(String memberNickname) throws Exception {
		int result = selectOne("memberNickname_check", memberNickname);
		return result;
	}
	
	//전화번호 중복체크
	@Override
	public int memberTelNumber_check(String memberTelNumber) throws Exception {
		int result = selectOne("memberTelNumber_check", memberTelNumber);
		return result;
	}
	
	@Override
	public void signUpMember(MembersVO membersVo) throws Exception {
		insert("signUpMember", membersVo);
	}
	
	//로그인
	@Override
	public int loginMember(MembersVO membersVo) throws Exception {
		int result = selectOne("loginMember", membersVo);
		return result;
	}

	@Override
	public MembersVO selectMember(String memberId) throws Exception {		
		return selectOne("selectMember", memberId);
	}
	
	@Override
	public void updateMember() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember() throws Exception {
		// TODO Auto-generated method stub

	}

	

	@Override
	public String memberRole() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MembersVO> selectMembersList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}

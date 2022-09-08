package ph.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ph.service.MembersDAO;
import ph.service.MembersService;
import ph.service.MembersVO;

@Service("memberService")
public class MembersServiceImpl implements MembersService {
	
	@Resource(name = "memberDAOMybatis")
	private MembersDAO dao;
	
	//아이디 중복체크
	@Override
	public int memberId_check(String memberId) throws Exception {
		int result = dao.memberId_check(memberId);
		return result;
	}

	//닉네임 중복체크
	@Override
	public int memberNickname_check(String memberNickname) throws Exception {
		int result = dao.memberNickname_check(memberNickname);
		return result;
	}
	
	//전화번호 중복체크
	@Override
	public int memberTelNumber_check(String memberTelNumber) throws Exception {
		int result = dao.memberTelNumber_check(memberTelNumber);
		return result;
	}

	
	@Override
	public void signUpMember(MembersVO membersVo) throws Exception {
		dao.signUpMember(membersVo);		
	}
	
	//로그인
	@Override
	public int loginMember(MembersVO membersVo) throws Exception {
		int result = dao.loginMember(membersVo);
		return result;
	}
	
	//조회
	@Override
	public MembersVO selectMember(String memberId) throws Exception {		
		return dao.selectMember(memberId);
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

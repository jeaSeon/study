package ph.service;

import java.util.List;

public interface MembersDAO {
	
	int memberId_check(String memberId) throws Exception;
	
	int memberNickname_check(String memberNickname) throws Exception;
	
	int memberTelNumber_check(String memberTelNumber) throws Exception;

	void signUpMember(MembersVO membersVo) throws Exception;
	
	int loginMember(MembersVO membersVo) throws Exception;		
	
	MembersVO selectMember(String memberId) throws Exception;
	
	
	void updateMember() throws Exception;
	
	void deleteMember() throws Exception;
		
	String memberRole() throws Exception;
	
	List<MembersVO> selectMembersList() throws Exception;
	
	

	
}

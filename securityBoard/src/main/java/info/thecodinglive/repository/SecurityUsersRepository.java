package info.thecodinglive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.thecodinglive.model.Users;

//securityUserspository이다. (회원) 
public interface SecurityUsersRepository extends JpaRepository<Users, Integer>{
	public Users findByUsername(String username);
}

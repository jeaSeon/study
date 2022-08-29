package info.thecodinglive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.thecodinglive.model.Users;

public interface SecurityUsersRepository extends JpaRepository<Users, Integer>{
	public Users findByUsername(String username);
}

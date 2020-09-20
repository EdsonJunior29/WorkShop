package br.com.workshopmongo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.workshopmongo.domain.User;
import br.com.workshopmongo.reposytory.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll(){
		return userRepository.findAll();
	}
}

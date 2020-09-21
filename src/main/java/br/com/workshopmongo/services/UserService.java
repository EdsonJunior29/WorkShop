package br.com.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.workshopmongo.domain.User;
import br.com.workshopmongo.reposytory.UserRepository;
import br.com.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
}

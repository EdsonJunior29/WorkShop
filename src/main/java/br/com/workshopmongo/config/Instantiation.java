package br.com.workshopmongo.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.workshopmongo.domain.User;
import br.com.workshopmongo.reposytory.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	private UserRepository userRepository;
	
	public Instantiation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		//Para limpar a coleção do banco 
		  
		userRepository.deleteAll();
		
		User maria = new User(null , "Maria Brown" , "maria@gmail.com");
		User alex = new User(null , "Alex Green" , "alex@gmail.com");
		User bob = new User(null , "Bob Grey" , "bob@gmail.com");
		User jose = new User(null , "Jose Carlos" , "bob@gmail.com");
	
		userRepository.saveAll(Arrays.asList(maria, alex, bob, jose));
	}

}

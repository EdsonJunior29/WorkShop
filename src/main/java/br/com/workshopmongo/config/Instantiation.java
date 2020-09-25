package br.com.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.workshopmongo.domain.Post;
import br.com.workshopmongo.domain.User;
import br.com.workshopmongo.dto.AuthorDTO;
import br.com.workshopmongo.dto.CommentDTO;
import br.com.workshopmongo.reposytory.PostRepository;
import br.com.workshopmongo.reposytory.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	private UserRepository userRepository;
	
	public Instantiation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args0) throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null , "Maria Brown" , "maria@gmail.com");
		User alex = new User(null , "Alex Green" , "alex@gmail.com");
		User bob = new User(null , "Bob Grey" , "bob@gmail.com");
		User jose = new User(null , "Jose Carlos" , "bob@gmail.com");
	
		userRepository.saveAll(Arrays.asList(maria, alex, bob, jose));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para São Paulo. Abraços", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/032018"), "Bom Dia", "Acordei Feliz",new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		
		post1.getComment().addAll(Arrays.asList(c1, c2));
		post2.getComment().add(c3);
		
		postRepository.saveAll(Arrays.asList(post1 , post2));
		
		maria.getPots().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}

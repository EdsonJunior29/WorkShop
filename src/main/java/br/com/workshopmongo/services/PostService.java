package br.com.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.workshopmongo.domain.Post;
import br.com.workshopmongo.reposytory.PostRepository;
import br.com.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Post não encontrado....."));
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findBytitleContainingIgnoreCase(text);
	}
}

package br.com.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.workshopmongo.domain.Post;
import br.com.workshopmongo.resources.util.URL;
import br.com.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	private PostService postService;
	
	public PostResource(PostService postService) {
		this.postService = postService;
	}
	
	@RequestMapping(value ="/{id}" , method = RequestMethod.GET )
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/titlesearch" , method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text" , defaultValue = "") String text){
		text = URL.decodePara(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/fullsearch" , method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullsearch(
		@RequestParam(value = "text" , defaultValue = "") String text,
		@RequestParam(value = "dateMin" , defaultValue = "") String dateMin,
		@RequestParam(value = "dateMax" , defaultValue = "") String dateMax){
		text = URL.decodePara(text);
		Date min = URL.convertDate(dateMin, new Date(0L));
		Date max =URL.convertDate(dateMax, new Date());
		List<Post> list = postService.fullsearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}

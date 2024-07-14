package com.alrehany.joblisting.controller;

import com.alrehany.joblisting.models.Post;
import com.alrehany.joblisting.repos.PostRepository;
import com.alrehany.joblisting.repos.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {


    @Autowired
    PostRepository postRepository;

    @Autowired
    SearchRepository searchRepository;

    //every time a request send to the home page
    //it should redirect to the swagger page
    @ApiIgnore //to ignore all predefined api
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        //redirect the user to swagger home page
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){

        return  postRepository.findAll();
    }

    @GetMapping("/post/{text}")
    public List<Post> search(@PathVariable String text){

        return searchRepository.findByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post thePost){
        return postRepository.save(thePost);
    }

}

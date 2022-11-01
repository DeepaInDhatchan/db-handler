package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    BlogRepository blogRespository;

    @GetMapping("/blog")
    public List<Blog> index(){
        return blogRespository.findAll();
    }

    @GetMapping("/blog/{id}")
    public Optional<Blog> show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogRespository.findById(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return blogRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String content = body.get("content");
        return blogRespository.save(new Blog(title, content));
    }
    @PostMapping("/updateblog")
    public ModelAndView process(WebRequest request)
	{
	    String title=request.getParameter("title");
	    String content=request.getParameter("content");
	    Optional<Blog> blog=blogRespository.findById(1);
	    Optional<Blog> blogx=blogRespository.findByContent("new");
	    System.out.println(blogx);
	    blogx.get().setTitle("fhjgjj");
	    //blogRespository.saveAll(null);
	    blogRespository.save(new Blog(blogx));
	    if (blog.isPresent())
	    	System.out.println(blog.get().getTitle());
	    
	    Blog x=blogRespository.save(new Blog(title, content));
	    //return x;
	    ModelAndView mav=new ModelAndView("success.html");
	    mav.addObject("blog",x);
	    mav.addObject("blogs",blogRespository.findAll());
	    return mav;
	   /* if (user.equals(pwd))
	    	return new ModelAndView("success.html");
	    else
	    	return new ModelAndView("index.html");
	    	*/
	}
    
    @PostMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
    	System.out.println("hello");
    	
        int blogId = Integer.parseInt(id);
        // getting blog
        //Blog blog = blogRespository.findOne(blogId);
        System.out.println(body.get("title"));
        System.out.println("hellotwo");
        Blog blog=new Blog();
        Blog blognew=new Blog(10,"newtitle","newcontent");
        blogRespository.save(blognew);
        
        blog.setTitle(body.get("title"));
        blog.setContent(body.get("content"));
        return blogRespository.save(blog);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        blogRespository.deleteById(blogId);
        return true;
    }

}
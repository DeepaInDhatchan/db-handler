package com.example.demo;
import java.util.Optional;
//sdfsdfsdf
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String content;

    public Blog() {  }

    public Blog(String title, String content) {
        this.setTitle(title);
        this.setContent(content);
    }

    public Blog(int id, String title, String content) {
        this.setId(id);
        this.setTitle(title);
        this.setContent(content);
    }

    public Blog(Optional<Blog> blogx) {
		// TODO Auto-generated constructor stub
    	if (blogx.isPresent())
    	{
    		this.setId(blogx.get().getId());
    		this.setTitle(blogx.get().getTitle());
    		this.setContent(blogx.get().getContent());
    	}
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", title='" + title + "'" +
                ", content='" + content + "'" +'}';
    }
}
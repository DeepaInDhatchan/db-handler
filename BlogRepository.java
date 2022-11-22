package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    // custom query to search to blog post by title or content
    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);   
    Optional<Blog> findByContent(String text);
    @Query(value = "SELECT * FROM blog WHERE id>3",
            nativeQuery=true
    )
    public List<Blog> findByIdGT3();
    
    @Query(value = "SELECT * FROM blog t WHERE t.title LIKE CONCAT('%',:searchTerm, '%')",
            nativeQuery = true
    )
    List<Blog> findByTitleNative(@Param("searchTerm") String searchTerm);
}
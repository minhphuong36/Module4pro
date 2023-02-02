package com.blog_module4_c0922h1.service;

import com.blog_module4_c0922h1.model.Blog;
import com.blog_module4_c0922h1.repository.IBlogRepo;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class BlogService {
    @Autowired
    IBlogRepo iBlogRepo;

    public Page<Blog> getAll(Pageable pageable){

        return  iBlogRepo.findAll(pageable);
    }

    public void save(Blog blog){
        iBlogRepo.save(blog);
    }

    public void deleteById(int id){
        iBlogRepo.deleteById(id);
    }

  public Blog findById(int id){
        return iBlogRepo.findById(id).get();
  }
}

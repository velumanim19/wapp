package com.springwebapp.wapp.repositories;

import com.springwebapp.wapp.library.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {

}

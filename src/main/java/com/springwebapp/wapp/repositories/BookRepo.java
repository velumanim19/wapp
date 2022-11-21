package com.springwebapp.wapp.repositories;

import com.springwebapp.wapp.library.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Books, Long> {
}

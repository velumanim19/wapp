package com.springwebapp.wapp.bootstrap;

import com.springwebapp.wapp.library.Author;
import com.springwebapp.wapp.library.Books;
import com.springwebapp.wapp.repositories.AuthorRepo;
import com.springwebapp.wapp.repositories.BookRepo;
import org.hibernate.SessionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorrepo;
    private final BookRepo bookrepo;

    public BootStrapData(AuthorRepo authorrepo, BookRepo bookrepo) {
        this.authorrepo = authorrepo;
        this.bookrepo = bookrepo;
    }

    @Override
    public void run(String... args) throws Exception {

        try {

            Author velu = new Author("Velu", "Mani");
            Books book = new Books("Legend", "Arises");

            velu.getBooks().add(book);
            book.getAuthors().add(velu);

            authorrepo.save(velu);
            bookrepo.save(book);

            Author kkk = new Author("kkk", "lll");
            Books bbb = new Books("SunRise", "perfection");

            kkk.getBooks().add(bbb);
            bbb.getAuthors().add(kkk);

            authorrepo.save(kkk);
            bookrepo.save(bbb);

            Author sss = new Author("sss", "yyy");
            Books hhh = new Books("First World War", "History");

            sss.getBooks().add(hhh);
            hhh.getAuthors().add(sss);

            authorrepo.save(sss);
            bookrepo.save(hhh);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Bootstrap Started");
            System.out.println("Number of books :" + bookrepo.count());
            System.out.println("Book name : " + bookrepo.toString());
        }
    }
}

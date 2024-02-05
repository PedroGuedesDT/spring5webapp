package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        Publisher asa = new Publisher("ASA", "Streat of Philadelphia", "Philadelphia", "Philadelphia", "123456789");
        publisherRepository.save(asa);

        Author peter = new Author("Pedro", "Guedes");
        Book ddd = new Book("Domain Driven Design", "123456789");
        peter.getBooks().add(ddd);
        ddd.getAuthors().add(peter);

        authorRepository.save(peter);
        bookRepository.save(ddd);

        Author agatha = new Author("Agatha", "Christie");
        Book midnightTrain = new Book("The midnight train", "987654321");
        agatha.getBooks().add(midnightTrain);
        midnightTrain.getAuthors().add(agatha);

        authorRepository.save(agatha);
        bookRepository.save(midnightTrain);

        System.out.println("Started in boostrap!");
        System.out.println("Publishers: " + publisherRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
    }
}

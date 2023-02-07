package de.lubowiecki.bookstore.controler;

import de.lubowiecki.bookstore.model.Book;
import de.lubowiecki.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "list";
    }

    @GetMapping("new") // th:object aus dem Formular ist n book gebunden
    public String newForm(Book book, Model model) {
        return "form";
    }

    @PostMapping("save")
    public String save(@Valid Book book, BindingResult result, Model model) {

        // BindingResult enthält das Ergebnis der Validierung
        // book ist mit den Daten aus dem Formular gefüllt
        if(result.hasErrors()) {
            return "form";
        }

        bookRepository.save(book);
        return "redirect:/";
    }

}

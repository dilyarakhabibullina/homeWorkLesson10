package ru.itpark.ulmart.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.ulmart.domain.Product;
import ru.itpark.ulmart.repository.ProductRepository;
import ru.itpark.ulmart.service.ProductService;

@Controller
@AllArgsConstructor // сгенерирует конструктор
public class ProductController {
    private ProductService service;
    private ProductRepository repository;

    // mapping -> привязка метода к обработке URL'а

    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", repository.getAll());
        return "index"; // строчка с именем шаблона (без расширения)
    }

    @PostMapping// RequestMapping: http://localhost:8080/ -> GET, POST, PUT, DELETE, @GetMapping только на GET
    public String frontpage(Model model, @RequestParam String name) {
        service.searchByName(name);
        model.addAttribute("products", service.searchByName(name));
        return "index"; // строчка с именем шаблона (без расширения)
    }
}

package com.esprit.b8ks_web.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.b8ks_web.entities.usedbook;
import com.esprit.b8ks_web.services.usedbookService;




@RestController
@CrossOrigin("http://localhost:3306")
@RequestMapping("/usedbook")
public class usedbookController {
	@Autowired
	private usedbookService bookService;
	
	@PostMapping("/addBook")
	public usedbook addBook(@RequestBody usedbook b) {
		System.out.println(b);
		return bookService.saveBook(b);
	}

	@PostMapping("/addBooks")
	public List<usedbook> addBooks(@RequestBody List<usedbook> books) {
		return bookService.saveBooks(books);
	}

	@GetMapping("/books")
	public List<usedbook> findAllBooks(@Param("keyword") String keyword) {
		return bookService.getBooks(keyword);
	}

	@GetMapping("/books/sortLabel/{ord}")
	public List<usedbook> findAllBooksSortedByLabel(@PathVariable int ord) {
		if (ord == 1)
			return bookService.getBooksSortedByLabelASC();
		else
			return bookService.getBooksSortedByLabelDESC();
	}

	@GetMapping("/books/sortPrice/{ord}")
	public List<usedbook> findAllBooksSortedByPrice(@PathVariable int ord) {
		if (ord == 1)
			return bookService.getBooksSortedByPriceASC();
		else
			return bookService.getBooksSortedByPriceDESC();
	}

	@GetMapping("/books/categories/{names}")
	public List<usedbook> findAllBooksFilteredByCategories(@Param("names") String names) {
		return bookService.getBooksFilteredByCategories(names);
	}

	@GetMapping("/books/languages")
	public List<usedbook> findAllBooksFilteredByLanguages(@Param("names") String names) {
		return bookService.getBooksFilteredByLanguages(names);
	}
	
	@GetMapping("/books/minPrice/{min}")
	public List<usedbook> findAllBooksFilteredByMinPrice(@PathVariable double min) {
			return bookService.getBooksFilteredByMinPrice(min);
	}
	
	@GetMapping("/books/maxPrice/{max}")
	public List<usedbook> findAllBooksFilteredByMaxPrice(@PathVariable double max) {
			return bookService.getBooksFilteredByMaxPrice(max);
	}

	@GetMapping("/books/price")
	public List<usedbook> findAllBooksFilteredByPrice(@Param("min") double min,
			@Param("max") double max) {
			return bookService.getBooksFilteredByMinMaxPrice(min, max);
	}

	@GetMapping("/book/{id}")
	public usedbook getBookById(@PathVariable int id) {

		return bookService.getBookById(id);
	}

	@GetMapping("/bookLabel/{label}")
	public usedbook getBookByLabel(@PathVariable String label) {
		return bookService.getBookByLabel(label);
	}

	@PutMapping("/updateBook")
	public String updateBook(@RequestBody usedbook b) {
		return bookService.updateBook(b);
	}

	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {
		return bookService.deleteBook(id);
	}
	
	// PUSHED REQUESTS 
	@PutMapping("/books/assignCharity")
	public usedbook assignCharityToBook(@RequestBody usedbook b){
		return bookService.assignCharityToBook(b);
	}
	
	@PutMapping("/books/unassignCharity")
	public usedbook unassignCharityFromBook(@RequestBody usedbook b){
		return bookService.unassignCharityFromBook(b);
	}
	
	@GetMapping("/books/charity/{id}")
	public List<String> getBooksByCharity(@PathVariable int id){
		return bookService.getBooksLabelsByCharity(id);
	}
	

	
	@GetMapping("/books/cartTotal/{id}")
	public double getAverageTotalPriceByBook(@PathVariable int id){
		return bookService.getTotalPriceByBook(id);
	}
	
	@GetMapping("/books/mostSelected")
	public usedbook getMostSelectedBook(){
		return bookService.getMostSelectedBook();
	}
}


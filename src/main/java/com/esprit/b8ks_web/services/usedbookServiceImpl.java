package com.esprit.b8ks_web.services;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esprit.b8ks_web.entities.usedbook;

import com.esprit.b8ks_web.entities.category;

import com.esprit.b8ks_web.repositories.usedbookRepository;
import com.esprit.b8ks_web.repositories.categoryRepository;
import com.esprit.b8ks_web.controllers.usedbookController;

public class usedbookServiceImpl<PackRepository, CharityRepository, CustomerService, EventRepository> implements usedbookService{
	private static final Logger logger = LogManager.getLogger(usedbookController.class);
	@Autowired
	private usedbookRepository usedbookRepository;
	@Autowired
	private categoryRepository categoryRepository;
	@Autowired
	PackRepository packRepository;
	@Autowired
	CharityRepository charityRepository;
	@Autowired
	CustomerService customerService;
	@Autowired
	EventRepository eventRepository;

	@Override
	public usedbook saveBook(usedbook b) {
		return usedbookRepository.save(b);
	
	}

	@Override
	public List<usedbook> saveBooks(List<usedbook> books) {
		return usedbookRepository.saveAll(books);
	}

	@Override
	public List<usedbook> getBooks(String keyword) {
		List<usedbook> books = new ArrayList<>();
		if (keyword != null)
			books = usedbookRepository.searchBooksByLabel(keyword);
		else {
			books = usedbookRepository.findAll();
		}
		return books;
	}

	@Override
	public List<usedbook> getBooksSortedByLabelASC() {
		List<usedbook> books = usedbookRepository.findAll(Sort.by(Sort.Direction.ASC, "label"));
		return books;
	
	}

	@Override
	public List<usedbook> getBooksSortedByLabelDESC() {
		List<usedbook> books = usedbookRepository.findAll(Sort.by(Sort.Direction.DESC, "label"));
		return books;
	}

	@Override
	public List<usedbook> getBooksSortedByPriceASC() {
		List<usedbook> books = usedbookRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
		return books;
	}

	@Override
	public List<usedbook> getBooksSortedByPriceDESC() {
		List<usedbook> books = usedbookRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
		return books;
	}

	@Override
	public List<usedbook> getBooksFilteredByCategories(String categoriesList) {
		Set<category> categories = new HashSet<>();
		String[] liStrings = categoriesList.split(" ");
		for (String xString : liStrings) {
			categories.add(new category(1, xString));
		}
		List<usedbook> books = usedbookRepository.findAll();
		return books.stream().filter(b -> b.getcategories().containsAll(categories)).collect(Collectors.toList());
	}



	@Override
	public List<usedbook> getBooksFilteredByMinPrice(double minPrice) {
		List<usedbook> books = usedbookRepository.findAll();
		return books.stream().filter(b -> (int) b.getPrix() >= (int) minPrice).collect(Collectors.toList());
	}

	@Override
	public List<usedbook> getBooksFilteredByMaxPrice(double maxPrice) {
		List<usedbook> books = usedbookRepository.findAll();
		return books.stream().filter(b -> (int) b.getPrix() <= (int) maxPrice).collect(Collectors.toList());
	}

	@Override
	public List<usedbook> getBooksFilteredByMinMaxPrice(double minPrice, double maxPrice) {
		List<usedbook> books = usedbookRepository.findAll();
		return books.stream()
				.filter(b -> ((int) b.getPrix() <= (int) maxPrice) && ((int) b.getPrix() >= (int) minPrice))
				.collect(Collectors.toList());
	}

	@Override
	public usedbook getBookById(int id) {
		usedbook book = usedbookRepository.findById(id).orElse(null);
		if (book == null) {
			logger.warn("No Book found");
		}
		return book;
	}

	@Override
	public usedbook getBookByLabel(String label) {
		usedbook book = usedbookRepository.findByLabel(label);
		return book;
	}

	@Override
	public String deleteBook(int id) {
		usedbookRepository.deleteById(id);
		return "Book with id " + id + " removed";
	}

	@Override
	public String updateBook(usedbook b) {
		usedbook existingBook = usedbookRepository.findById(b.getId()).orElse(null);
		if (b.getLabel() != null)
			existingBook.setLabel(b.getLabel());
		
		if (b.getPrix() != 0)
			existingBook.setPrix(b.getPrix());
	
		if (b.getDescription() != null)
			existingBook.setDescription(b.getDescription());
		if (b.getcategories().size() != 0) {
			List<usedbook> categories = b.getcategories();
			for (usedbook category : categories) {
				category.setId(((usedbook) categoryRepository.findAll()).getId());
			}
			existingBook.setCategories(categories);
		}
	
		usedbookRepository.save(existingBook);
		return "Book with id " + b.getId() + " update.";
	}
// linked with charity class *****************************
	/*@Override
	public usedbook assignCharityToBook(usedbook b) {
		usedbook exisitngBook = usedbookRepository.findById(b.getId()).orElse(null);
		Charity existingCharity = charityRepository.findById(b.getCharity().getId()).orElse(null);
		exisitngBook.setCharity(existingCharity);
		return bookRepository.save(exisitngBook);;
	}

	@Override
	public usedbook unassignCharityFromBook(usedbook b) {
		usedbook existingBook = usedbookRepository.findById(b.getId()).orElse(null);
		existingBook.setCharity(null);
		return usedbookRepository.save(existingBook);
	}

	@Override
	public List<String> getBooksLabelsByCharity(int charityId) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public double getTotalPriceByBook(int bookId) {
		return usedbookRepository.getTotalPrixByUsedbook(bookId);
	}

	@Override
	public usedbook getMostSelectedBook() {
		return usedbookRepository.getMostSelectedBook();
	}
// linked with customer class *********************************************************
	/*@Override
	public List<usedbook> showRelatedBooks() {
		Customer customer = customerService.getAuthenticatedCustomer();

		List<usedbook> topSelectedBooks = usedbookRepository.getMostSelectedBooksByCustomer(null);
		topSelectedBooks = topSelectedBooks.stream().limit(3).collect(Collectors.toList());
		// GET CATEGORIES OF THESE BOOKS
		String categoriesList = "";
		for(usedbook book : topSelectedBooks){
			List<usedbook> categories = book.getcategories();
			for(usedbook category : categories){
				if(!categoriesList.contains(category.getTitre()))
						categoriesList = categoriesList + category.getTitre();
			}
		}
		List<usedbook> relatedBooks = getBooksFilteredByCategories(categoriesList);
		relatedBooks.removeAll(topSelectedBooks);
		return relatedBooks;
	}*/

	@Override
	public List<usedbook> getBooksFilteredByLanguages(String languagesList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public usedbook assignCharityToBook(usedbook b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public usedbook unassignCharityFromBook(usedbook b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getBooksLabelsByCharity(int charityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<usedbook> showRelatedBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<usedbook> showRecommendedBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<usedbook> getMostSelectedBooksByCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public usedbook openEventOnBook() {
		// TODO Auto-generated method stub
		return null;
	}



	

	/*@Override
	public List<usedbook> showRecommendedBooks() {
	
		Customer customer = customerService.getAuthenticatedCustomer();
		// CHECK INFO ABOUT THE CUSTOMER
		List<usedbook> books = new ArrayList<>();
		if (customer.getAge() <= 10)
			books = getBooksFilteredByCategories("Kids");
		else if (customer.getAge() > 10 && customer.getAge() <= 30)
			books = getBooksFilteredByCategories("Action Mystery Sci-Fi");
		else
			books = getBooksFilteredByCategories("History");
		return books;
	}

	@Override
	public List<usedbook> getMostSelectedBooksByCustomer() {
		Customer customer = customerService.getAuthenticatedCustomer();
		return usedbookRepository.getMostSelectedBooksByCustomer(customer.getId());
	}
*/
	






}

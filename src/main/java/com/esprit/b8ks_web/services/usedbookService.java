package com.esprit.b8ks_web.services;

import java.util.List;

import com.esprit.b8ks_web.entities.usedbook;

public interface usedbookService {
	public usedbook saveBook(usedbook b);

	public List<usedbook> saveBooks(List<usedbook> books);

	public List<usedbook> getBooks(String keyword);

	public List<usedbook> getBooksSortedByLabelASC();

	public List<usedbook> getBooksSortedByLabelDESC();

	public List<usedbook> getBooksSortedByPriceASC();

	public List<usedbook> getBooksSortedByPriceDESC();

	public List<usedbook> getBooksFilteredByCategories(String categoriesList);

	public List<usedbook> getBooksFilteredByLanguages(String languagesList);

	public List<usedbook> getBooksFilteredByMinPrice(double minPrice);

	public List<usedbook> getBooksFilteredByMaxPrice(double maxPrice);

	public List<usedbook> getBooksFilteredByMinMaxPrice(double minPrice, double maxPrice);

	public usedbook getBookById(int id);

	public usedbook getBookByLabel(String label);

	public String deleteBook(int id);

	public String updateBook(usedbook b);

	public usedbook assignCharityToBook(usedbook b);

	public usedbook unassignCharityFromBook(usedbook b);

	public List<String> getBooksLabelsByCharity(int charityId);

	

	public double getTotalPriceByBook(int bookId);

	public usedbook getMostSelectedBook();

	public List<usedbook> showRelatedBooks();

	public List<usedbook> showRecommendedBooks();

	public List<usedbook> getMostSelectedBooksByCustomer();

	public usedbook openEventOnBook();
}

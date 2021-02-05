package com.esprit.b8ks_web.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.esprit.b8ks_web.entities.usedbook;


public class usedbookRepositoryImpl implements usedbookRepository   {

	@Override
	public List<usedbook> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<usedbook> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<usedbook> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends usedbook> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends usedbook> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<usedbook> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public usedbook getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends usedbook> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends usedbook> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<usedbook> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends usedbook> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<usedbook> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(usedbook entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends usedbook> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends usedbook> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends usedbook> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends usedbook> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends usedbook> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public usedbook findByLabel(String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<usedbook> searchBooksByLabel(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTotalPrixByUsedbook(int usedbookId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public usedbook getMostSelectedBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<usedbook> getMostSelectedBooksByCustomer(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}


	

}

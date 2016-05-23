package app.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import app.pojos.Spittle;
import app.repository.SpittleCreator;
import app.repository.SpittleRepository;

@Repository
public class SpittleRepositoryImpl implements SpittleCreator {

	@Autowired
	private SpittleRepository spittleRepo;
	
	@Override
	public List<Spittle> spittles() {
		return createSpittles(20);
	}

	private List<Spittle> createSpittles(int maxCount) {
		List<Spittle> spittles= new ArrayList<Spittle>();
		for(int i=0;i<maxCount;i++)
			spittles.add(new Spittle("Spittle " + i, new Date()));
		return spittles;
	}

}

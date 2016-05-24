package app.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Repository;

import app.pojos.Spittle;
import app.repository.SpittleCreator;
import app.repository.SpittleRepository;
@Repository
public class SpittleRepositoryImpl implements SpittleCreator {

	
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

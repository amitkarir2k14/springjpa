package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.pojos.Spitter;

public interface SpitterRepository extends JpaRepository<Spitter, Long>{

	Spitter getByUsername(String username);
	
}

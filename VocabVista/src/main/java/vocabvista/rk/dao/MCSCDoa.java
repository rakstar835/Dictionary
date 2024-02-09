package vocabvista.rk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vocabvista.rk.model.Dictionary;

@Repository
public interface MCSCDoa extends JpaRepository<Dictionary, Long>{

	
}

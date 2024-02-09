package vocabvista.rk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vocabvista.rk.dao.MCSCDoa;
import vocabvista.rk.model.Dictionary;
import vocabvista.rk.utility.RecordNotFoundException;

@Service
public class DictionaryService {

	@Autowired
	MCSCDoa repository;

	public List<Dictionary> getAllItems() {
		List<Dictionary> mcscList = repository.findAll();

		if (mcscList.size() > 0) {
			return mcscList;
		} else {
			return new ArrayList<Dictionary>();
		}
	}

	public Dictionary getMCSCById(Long id) throws RecordNotFoundException {
		Optional<Dictionary> mcsc = repository.findById(id);

		if (mcsc.isPresent()) {
			return mcsc.get();
		} else {
			throw new RecordNotFoundException("No mcsc record exist for given id");
		}
	}

	public Dictionary createOrUpdateMCSC(Dictionary entity) throws RecordNotFoundException {
		Optional<Dictionary> mcsc = repository.findById(entity.getId());

		if (mcsc.isPresent()) {
			Dictionary newEntity = mcsc.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);
			return entity;
		}
	}
	

}

package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.exception.ResourceNotFoundException;
import spring.model.Evaluate;
import spring.repository.EvaluateRepository;

@Service
public class EvaluateService {

	@Autowired
	private EvaluateRepository evaluateRepository;
	
	@Transactional
	public List<Evaluate> getEvaluates() {
		return evaluateRepository.findAll();
	}

	@Transactional
	public void saveEvaluate(Evaluate theEvaluate) {
		evaluateRepository.save(theEvaluate);
	}

	@Transactional
	public Evaluate getEvaluate(int id) throws ResourceNotFoundException {
		return evaluateRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public void deleteEvaluate(int theId) {
		evaluateRepository.deleteById(theId);
	}
}

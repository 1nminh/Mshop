package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.exception.ResourceNotFoundException;
import spring.model.Evaluate;
import spring.repository.EvaluateRepository;

@Service
public class EvaluateServiceImpl implements EvaluateService {

	@Autowired
	private EvaluateRepository evaluateRepository;
	
	@Transactional
	@Override
	public List<Evaluate> getEvaluates() {
		return evaluateRepository.findAll();
	}

	@Transactional
	@Override
	public void saveEvaluate(Evaluate theEvaluate) {
		evaluateRepository.save(theEvaluate);
	}

	@Transactional
	@Override
	public Evaluate getEvaluate(int id) throws ResourceNotFoundException {
		return evaluateRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Transactional
	@Override
	public void deleteEvaluate(int theId) {
		evaluateRepository.deleteById(theId);
	}
}

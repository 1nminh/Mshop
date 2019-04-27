package spring.service;

import java.util.List;

import spring.exception.ResourceNotFoundException;
import spring.model.Evaluate;

public interface EvaluateService {

	public List<Evaluate> getEvaluates();

	public void saveEvaluate(Evaluate theEvaluate);

	public Evaluate getEvaluate(int theId) throws ResourceNotFoundException;

	public void deleteEvaluate(int theId) throws ResourceNotFoundException;

}

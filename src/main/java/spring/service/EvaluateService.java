package spring.service;

import java.util.List;

import spring.exception.ResourceNotFoundException;
import spring.model.Evaluate;

public interface EvaluateService {

	List<Evaluate> all();

	Evaluate newEvaluate(Evaluate newEvaluate);

	Evaluate one(int id) throws ResourceNotFoundException;

	Evaluate replaceEvaluate(Evaluate newEvaluate, int id);

	void deleteEvaluate(int id);

}

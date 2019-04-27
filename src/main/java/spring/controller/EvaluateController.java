/**
 * 
 */
package spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import spring.exception.ResourceNotFoundException;
import spring.model.Evaluate;
import spring.service.EvaluateServiceImpl;

/**
 * @author Le Ngo Minh <br/>
 *
 *         Modified Date : Apr 25, 2019
 */

@RestController
@RequestMapping("/api/evaluate")
public class EvaluateController {

	private static final Logger LOG = LoggerFactory.getLogger(EvaluateController.class);

	@Autowired
	private EvaluateServiceImpl evaluateService;

	@GetMapping()
//	@ResponseBody
	public List<Evaluate> listEvaluates() {

		List<Evaluate> evaluateList = new ArrayList<Evaluate>();
		evaluateList = evaluateService.getEvaluates();

		return evaluateList;
	}

	@GetMapping("/getEvaluate")
	public Evaluate getEvaluate(@RequestParam("evaluateId") int theId) throws ResourceNotFoundException {

		Evaluate evaluate = new Evaluate();
		evaluate = evaluateService.getEvaluate(theId);

		return evaluate;
	}

	@PostMapping("/saveEvaluate")
	@ResponseStatus(value = HttpStatus.OK)
	public void saveEvaluate(@ModelAttribute("evaluate") Evaluate theEvaluate) {
		evaluateService.saveEvaluate(theEvaluate);
	}

	@GetMapping("/updateEvaluate")
	@ResponseStatus(value = HttpStatus.OK)
	public void showFormForUpdate(@RequestParam("evaluateId") int theId, Model theModel) throws ResourceNotFoundException {
		Evaluate theEvaluate = new Evaluate();
		evaluateService.getEvaluate(theId);
	}

	@GetMapping("/delete")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteEvaluate(@RequestParam("evaluateId") int theId) throws ResourceNotFoundException {
		evaluateService.deleteEvaluate(theId);
	}

}

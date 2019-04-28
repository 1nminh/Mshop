package spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.exception.ResourceNotFoundException;
import spring.model.Banner;
import spring.service.BannerService;

@RestController
@RequestMapping("/api/banner")
public class BannerController {

	@Autowired
	private BannerService service;

	@GetMapping("/all")
	public List<Banner> all() {
		return service.all();
	}

	@PostMapping("/add")
	public Banner newBanner(@Valid @RequestBody Banner newBanner, BindingResult bindingResult) {
		return service.newBanner(newBanner, bindingResult);
	}

	@GetMapping("get/{id}")
	public Banner one(@PathVariable("id") int id) throws ResourceNotFoundException {
		return service.one(id);
	}

	@DeleteMapping("/delete/{id}")
	void deleteBanner(@PathVariable int id) {
		service.deleteBanner(id);
	}
}
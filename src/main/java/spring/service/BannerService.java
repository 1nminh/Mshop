package spring.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import spring.exception.ResourceNotFoundException;
import spring.model.Banner;

public interface BannerService {

	List<Banner> all();

	Banner newBanner(Banner newBanner, BindingResult result);

	Banner one(int id) throws ResourceNotFoundException;

	void deleteBanner(int id);

}

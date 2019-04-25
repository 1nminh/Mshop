package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.exception.ResourceNotFoundException;
import spring.model.Banner;
import spring.repository.BannerRepository;

@Service
public class BannerService {

	@Autowired
	private BannerRepository bannerRepository;
	
	@Transactional
	public List<Banner> getBanners() {
		return bannerRepository.findAll();
	}

	@Transactional
	public void saveBanner(Banner theBanner) {
		bannerRepository.save(theBanner);
	}

	@Transactional
	public Banner getBanner(int id) throws ResourceNotFoundException {
		return bannerRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public void deleteBanner(int theId) {
		bannerRepository.deleteById(theId);
	}
    
}

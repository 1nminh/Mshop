package spring.service;

import java.util.List;

import spring.exception.ResourceNotFoundException;
import spring.model.Banner;

public interface BannerService {

	public List<Banner> getBanners();

	public void saveBanner(Banner theBanner);

	public Banner getBanner(int theId) throws ResourceNotFoundException;

	public void deleteBanner(int theId) throws ResourceNotFoundException;

}

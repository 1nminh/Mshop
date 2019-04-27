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
import spring.model.Banner;
import spring.service.BannerServiceImpl;

/**
 * @author Le Ngo Minh <br/>
 *
 *         Modified Date : Apr 25, 2019
 */

@RestController
@RequestMapping("/api/banner")
public class BannerController {

	private static final Logger LOG = LoggerFactory.getLogger(BannerController.class);

	@Autowired
	private BannerServiceImpl bannerService;

	@GetMapping()
//	@ResponseBody
	public List<Banner> listBanners() {

		List<Banner> bannerList = new ArrayList<Banner>();
		bannerList = bannerService.getBanners();

		return bannerList;
	}

	@GetMapping("/getBanner")
	public Banner getBanner(@RequestParam("bannerId") int theId) throws ResourceNotFoundException {

		Banner banner = new Banner();
		banner = bannerService.getBanner(theId);

		return banner;
	}

	@PostMapping("/saveBanner")
	@ResponseStatus(value = HttpStatus.OK)
	public void saveBanner(@ModelAttribute("banner") Banner theBanner) {
		bannerService.saveBanner(theBanner);
	}

	@GetMapping("/updateBanner")
	@ResponseStatus(value = HttpStatus.OK)
	public void showFormForUpdate(@RequestParam("bannerId") int theId, Model theModel) throws ResourceNotFoundException {
		Banner theBanner = new Banner();
		bannerService.getBanner(theId);
	}

	@GetMapping("/delete")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteBanner(@RequestParam("bannerId") int theId) throws ResourceNotFoundException {
		bannerService.deleteBanner(theId);
	}

}

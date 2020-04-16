package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.Advertisement;
import com.spring.json.User;
import com.spring.service.AdvertisementService;
import com.spring.service.UserService;

@RestController
@RequestMapping("/adv")
public class AdvertisementController {

	@Autowired
	private AdvertisementService advertisementService;

	@PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Advertisement addAdvertisement(@RequestBody Advertisement advertisement, @RequestHeader String akey) {
		return advertisementService.save(advertisement, akey);
	}

	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateAdvertisement(@RequestBody Advertisement advertisement, @RequestHeader String akey) {
		return advertisementService.updateadvertisement(advertisement, akey);
	}

	@GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Advertisement> getall() {
		return advertisementService.getall();
	}

	@GetMapping(value = "/getcategory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getCategory() {
		return advertisementService.getCategory();
	}

	@GetMapping(value = "/getbysearch/{searchText}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Advertisement> getBySearch(@PathVariable(name = "searchText") String searchText) {
		return advertisementService.getBySearch(searchText);
	}

	@GetMapping(value = "/actions", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<String> returnActions() {
		return advertisementService.returnActions();
	}

}

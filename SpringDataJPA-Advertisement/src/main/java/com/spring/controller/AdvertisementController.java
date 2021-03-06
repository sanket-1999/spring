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
	
	@RequestMapping(value="/delete/{postid}",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String DeleteById(@RequestHeader String akey,@PathVariable(name ="postid") String postId) {
		 return advertisementService.deleteById(akey, postId);
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
	
	@GetMapping(value = "/asctitle", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Advertisement> AdvertiseAsc()
	{
		return advertisementService.AdvertiseAsc();
	}
	@GetMapping(value = "/desctitle", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Advertisement> AdvertiseDesc()
	{
		return advertisementService.AdvertiseDesc();
	}
	@GetMapping(value = "/ascpostid", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Advertisement> AdvertiseAscPostid()
	{
		return advertisementService.AdvertiseAscPostid();
	}
	@GetMapping(value = "/descpostid", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Advertisement> AdvertiseDescPostid()
	{
		return advertisementService.AdvertiseDescPostid();
	}
	
	@RequestMapping(value="/getadvequaltodate/{date}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Advertisement> getEqualToTheGivenDate(@PathVariable(name = "date") String date,@RequestHeader String akey){
		 return advertisementService.getEqualToTheGivenDate(date, akey);
	}
	
}

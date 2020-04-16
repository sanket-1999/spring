package com.spring.service;

import java.util.List;

import com.spring.json.Advertisement;

public interface AdvertisementService {

	public Advertisement save(Advertisement advertisement, String akey);

	public String updateadvertisement(Advertisement advertisement, String key);

	public List<String> getCategory();

	public List<Advertisement> getBySearch(String searchText);

	public List<Advertisement> getall();

	public List<String> returnActions();

	public List<Advertisement> AdvertiseAsc();

	public List<Advertisement> AdvertiseDesc();

	public List<Advertisement> AdvertiseAscPostid();

	public List<Advertisement> AdvertiseDescPostid();


}

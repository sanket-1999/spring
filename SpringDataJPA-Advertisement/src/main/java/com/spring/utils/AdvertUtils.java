package com.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.spring.entity.AdvertisementEntity;
import com.spring.entity.UserEntity;
import com.spring.json.Advertisement;
import com.spring.json.User;

public class AdvertUtils {

	public static List<Advertisement> convertAdvertisementEntityListToAdvertisementList(List<AdvertisementEntity> advertisementEntityList)
	{
		List<Advertisement> advertisementList=new ArrayList<Advertisement>();
		Consumer<AdvertisementEntity> consumer=(AdvertisementEntity advertisementEntity)->advertisementList.add(convertAdvertisementEntitytoAdvertisement(advertisementEntity));
		advertisementEntityList.stream().forEach(consumer);
		return advertisementList;
	}
	
	

	
	public static Advertisement convertAdvertisementEntitytoAdvertisement(AdvertisementEntity advertisementEntity)
	{
		return new Advertisement(advertisementEntity.getId(),advertisementEntity.getName(),advertisementEntity.getTitle(),advertisementEntity.getCategory(),
				advertisementEntity.getDescription(),advertisementEntity.getPostId(),advertisementEntity.getStatus(),advertisementEntity.getLastUpdate());
	}
	
	
	
	public static AdvertisementEntity convertAdvertisementToAdvertisementEntity(Advertisement advertisement)
	{
		return new AdvertisementEntity(advertisement.getId(),advertisement.getName(),advertisement.getTitle(),
				advertisement.getCategory(),advertisement.getDescription(),advertisement.getPostId(),advertisement.getStatus(),
				advertisement.getLastUpdate());
	}
	
	
	
	
}

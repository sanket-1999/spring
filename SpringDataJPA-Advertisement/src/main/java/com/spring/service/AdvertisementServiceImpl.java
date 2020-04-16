package com.spring.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.AdvertisementEntity;
import com.spring.entity.UserEntity;
import com.spring.json.Advertisement;
import com.spring.rest.repository.AdvertisementRepository;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.AdvertUtils;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdvertisementRepository advertisementRepository;

	@Override
	public Advertisement save(Advertisement advertisement, String akey) {
		UserEntity userEntity = userRepository.findBySessionId(akey).get(0);
		if (userEntity != null || akey != null) {
			AdvertisementEntity adEntity = AdvertUtils.convertAdvertisementToAdvertisementEntity(advertisement);
			Random r = new Random();
			int random = r.nextInt(1000);
			String randompostid = Integer.toString(random);
			adEntity.setPostId(randompostid);
			adEntity.setLastUpdate(LocalDateTime.now());
			adEntity.setUserEntity(userEntity);
			return AdvertUtils.convertAdvertisementEntitytoAdvertisement(adEntity);
		} else {
			return null;
		}
	}

	@Override
	public String updateadvertisement(Advertisement advertisement, String akey) {
		UserEntity userEntity = userRepository.findBySessionId(akey).get(0);
		if (userEntity != null || akey != null) {

			Optional<AdvertisementEntity> searchadv = userEntity.getAdvertisementEntity().stream()
					.filter((AdvertisementEntity find) -> find
							.equals(AdvertUtils.convertAdvertisementToAdvertisementEntity(advertisement)))
					.findAny();
			if (searchadv.isPresent()) {
				AdvertisementEntity adEntity = AdvertUtils.convertAdvertisementToAdvertisementEntity(advertisement);
				adEntity.setLastUpdate(LocalDateTime.now());
				adEntity.setUserEntity(userEntity);
				advertisementRepository.save(adEntity);
				return "Updated";
			}

			else {
				return "update failed";
			}
		} else {
			return "invalid token key ";
		}

	}

	@Override
	public List<String> getCategory() {

		List<String> bycategory = AdvertUtils
				.convertAdvertisementEntityListToAdvertisementList(advertisementRepository.findAll()).stream()
				.map(Advertisement::getCategory).collect(Collectors.toList());
		return bycategory;
	}

	@Override
	public List<Advertisement> getBySearch(String searchText) {

		Optional<Advertisement> adssearch = AdvertUtils
				.convertAdvertisementEntityListToAdvertisementList(advertisementRepository.findAll()).stream()
				.filter((Advertisement find) -> find.getDescription().contains(searchText)
						|| find.getCategory().contains(searchText) || find.getTitle().contains(searchText))
				.findAny();
		if (adssearch.isPresent()) {
			return AdvertUtils.convertAdvertisementEntityListToAdvertisementList(advertisementRepository.findAll())
					.stream()
					.filter((Advertisement find) -> find.getCategory().contains(searchText)
							|| find.getDescription().contains(searchText) || find.getTitle().contains(searchText))
					.collect(Collectors.toList());
		} else {
			return null;
		}

	}

	@Override
	public List<Advertisement> getall() {
		return AdvertUtils.convertAdvertisementEntityListToAdvertisementList(advertisementRepository.findAll());
	}

	@Override
	public List<String> returnActions() {
		List<String> actionslist = new ArrayList<>();
		actionslist.add("User :Register , Login , Logout  , Details of a User");
		actionslist.add("Advertisement : CRUD Actions ");
		return actionslist;

	}

	@Override
	public List<Advertisement> AdvertiseAsc() {
		return AdvertUtils
				.convertAdvertisementEntityListToAdvertisementList(advertisementRepository.findByOrderByTitleAsc());
	}

	@Override
	public List<Advertisement> AdvertiseDesc() {
		return AdvertUtils
				.convertAdvertisementEntityListToAdvertisementList(advertisementRepository.findByOrderByTitleDesc());
	}

	@Override
	public List<Advertisement> AdvertiseAscPostid() {
		return AdvertUtils
				.convertAdvertisementEntityListToAdvertisementList(advertisementRepository.findByOrderByPostIdAsc());
	}

	@Override
	public String deleteById(String akey, String postId) {
		UserEntity userEntity = userRepository.findBySessionId(akey).get(0);
		if (userEntity != null || akey != null) {
			Optional<AdvertisementEntity> findid = userEntity.getAdvertisementEntity().stream()
					.filter((AdvertisementEntity find) -> find.getPostId().equals(postId)).findAny();

			if (findid.isPresent()) {
				advertisementRepository.deleteByPostId(postId);
				return "Deleted ";
			} else {
				return "fail";
			}
		}

		else {
			return "invalid token";
		}
	}

	@Override
	public List<Advertisement> AdvertiseDescPostid() {

		return AdvertUtils
				.convertAdvertisementEntityListToAdvertisementList(advertisementRepository.findByOrderByPostIdDesc());
	}
	
	@Override
	public List<Advertisement> getEqualToTheGivenDate(String date,String akey) {
				
		UserEntity userEntity = userRepository.findBySessionId(akey).get(0);
		if (userEntity != null || akey != null) {
				LocalDate localDate=LocalDate.parse(date);
				
				Predicate<AdvertisementEntity> predicate=(AdvertisementEntity find)->find.getLastUpdate().toLocalDate().compareTo(localDate)==0;
				if(userEntity.getAdvertisementEntity().stream().filter(predicate).findAny().isPresent())
				{
					return AdvertUtils.convertAdvertisementEntityListToAdvertisementList(userEntity.getAdvertisementEntity().stream().filter(predicate).collect(Collectors.toList()));
				}
				else
				{
					return null;
				}
			}
		
			else
			{
				return null;
			}
		}

}

package com.spring.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.entity.AdvertisementEntity;

@Component
public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Long> {
	List<AdvertisementEntity> findByName(String name);
	List<AdvertisementEntity> findByPostId(long postId);
	List<AdvertisementEntity> findByPostId(String postId);
}


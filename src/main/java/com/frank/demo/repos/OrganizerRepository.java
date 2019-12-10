package com.frank.demo.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.frank.demo.entities.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}

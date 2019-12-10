package com.frank.demo.repos;

import java.time.ZoneId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.frank.demo.entities.Event;

@RepositoryRestResource
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

	Page<Event> findByName(@Param("name") String name, Pageable pageable);

	Page<Event> findByNameAndZoneId(@Param("name") String name, @Param("zoneId") ZoneId zoneId, Pageable pageable);
	
	/*@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Long id);*/

}

package org.innowise.persistance.dao.repositories;

import org.innowise.entities.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends CrudRepository<Weather, Long> {
}

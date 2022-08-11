package org.innowise.Cadence.persistance.dao.repositories;

import org.innowise.Cadence.entities.Weather;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends CrudRepository<Weather, Long> {
}

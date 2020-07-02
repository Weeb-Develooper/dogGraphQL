package com.graphql.graphqllearning.repository;

import com.graphql.graphqllearning.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface GraphqlRepo extends CrudRepository<Location, Long> {
}

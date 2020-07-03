package com.graphql.graphqllearning.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.graphqllearning.exception.LocationNotFoundException;
import com.graphql.graphqllearning.model.Location;
import com.graphql.graphqllearning.repository.GraphqlRepo;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class Mutation implements GraphQLMutationResolver {
    private GraphqlRepo graphqlRepo;

    public Mutation(GraphqlRepo graphqlRepo) {
        this.graphqlRepo = graphqlRepo;
    }

    public Boolean deleteDogBreed(Long id){
        graphqlRepo.deleteById(id);
        return true;
    }

    public Location updateDogName(Long id,String newName){
        Optional<Location> dog = graphqlRepo.findById(id);
        if(dog.isPresent()){
            Location location = dog.get();
            location.setName(newName);
            graphqlRepo.save(location);
            return location;
        }else{
            throw new LocationNotFoundException("DOG NOT FOUND", id);
        }

    }
}

package com.graphql.graphqllearning.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.graphqllearning.model.Location;
import com.graphql.graphqllearning.repository.GraphqlRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Query implements GraphQLQueryResolver {
    private GraphqlRepo graphqlRepo;

    public Query(GraphqlRepo graphqlRepo) {
        this.graphqlRepo = graphqlRepo;
    }

    public ArrayList<String> findDogBreeds(){
        Iterable<Location> dogs = graphqlRepo.findAll();
        ArrayList<String> breedNames = new ArrayList<String>();
        for(Location dog : dogs){
            breedNames.add(dog.getBreed());
        }
        return breedNames;
    }

    public String findDogBreedById(Long id){
        Optional<Location> dog = graphqlRepo.findById(id);
        Location location = dog.get();
        String dogBreed = location.getBreed();
        return dogBreed;
    }

    public ArrayList<String> findAllDogNames(){
        Iterable<Location> dogs = graphqlRepo.findAll();
        ArrayList<String> dogNames = new ArrayList<String>();
        for(Location dog : dogs){
            dogNames.add(dog.getName());
        }
        return dogNames;
    }
}

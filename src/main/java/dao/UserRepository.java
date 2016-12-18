package dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;


public interface UserRepository extends MongoRepository<User, Serializable> {

    public User findByEmail(String email);

}
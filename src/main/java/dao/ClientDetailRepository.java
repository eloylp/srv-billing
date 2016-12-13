package dao;

import model.ClientDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

public interface ClientDetailRepository extends MongoRepository<ClientDetail, Serializable> {

    public ClientDetail findByClientId(String clientId);

}
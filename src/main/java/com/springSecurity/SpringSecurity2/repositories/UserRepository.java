package com.springSecurity.SpringSecurity2.repositories;

import com.springSecurity.SpringSecurity2.models.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);


//    OTRA FORMA
//    @Query("select u from UserEntity u where u.username = ?1")
//    Optional<UserEntity> getName(String username);
}

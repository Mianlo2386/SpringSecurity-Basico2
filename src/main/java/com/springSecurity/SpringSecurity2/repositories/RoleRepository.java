package com.springSecurity.SpringSecurity2.repositories;

import com.springSecurity.SpringSecurity2.models.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}

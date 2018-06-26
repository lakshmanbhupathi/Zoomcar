package com.lakshman.sample.zoomcar.dao;

import com.lakshman.sample.zoomcar.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

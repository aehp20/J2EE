package com.aehp.template.dao;

import org.springframework.data.repository.CrudRepository;
import com.aehp.template.dao.model.User;

public interface UserDao extends CrudRepository<User,Long> {

}

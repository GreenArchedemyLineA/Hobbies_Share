package com.tenco.hobby.repository.interfaces;

import java.util.List;

import com.tenco.hobby.repository.model.User;

public interface UserRepository {

	public int insert(User user);

	public int updateById(User user);

	public int deleteById(Integer id);

	public User findById(Integer id);

	public List<User> findAll();

}

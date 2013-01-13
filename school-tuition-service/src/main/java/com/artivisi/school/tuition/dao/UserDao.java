package com.artivisi.school.tuition.dao;

import com.artivisi.school.tuition.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, String> {
	User findByUsername(String username);
}

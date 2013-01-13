package com.artivisi.school.tuition.dao;

import com.artivisi.school.tuition.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleDao extends PagingAndSortingRepository<Role, String> {
}
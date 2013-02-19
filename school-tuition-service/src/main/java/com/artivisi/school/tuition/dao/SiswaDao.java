/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.dao;
import com.artivisi.school.tuition.domain.Siswa;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author user
 */
public interface SiswaDao extends PagingAndSortingRepository<Siswa, String>{
    
}

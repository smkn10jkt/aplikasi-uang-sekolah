/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.dao;

import com.artivisi.school.tuition.domain.Kelas;
import com.artivisi.school.tuition.domain.Menu;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author user
 */
public interface KelasDao extends PagingAndSortingRepository<Kelas, String> {

    public Kelas findByUsername(String username);
    
}

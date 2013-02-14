/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.dao;

import com.artivisi.school.tuition.domain.Kelas;
import com.artivisi.school.tuition.domain.TahunAjaran;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author user
 */
public interface TahunAjaranDao extends PagingAndSortingRepository<TahunAjaran, String> {
    
}

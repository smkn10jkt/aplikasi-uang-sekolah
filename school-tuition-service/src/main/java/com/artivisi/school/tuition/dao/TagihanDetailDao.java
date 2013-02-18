/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.dao;

import com.artivisi.school.tuition.domain.TagihanDetail;
import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author axioo
 */
public interface  TagihanDetailDao extends PagingAndSortingRepository<TagihanDetail, String>{
    
}

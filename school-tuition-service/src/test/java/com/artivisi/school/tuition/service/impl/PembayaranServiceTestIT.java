/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.service.impl;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.artivisi.school.tuition.service.BelajarRestfulService;
import org.junit.Test;
import com.artivisi.school.tuition.domain.Pembayaran;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import static org.junit.Assert.*;

/**
 *
 * @author axioo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:com/artivisi/school/tuition/**/applicationContext.xml"})
public class PembayaranServiceTestIT {
   @Autowired private BelajarRestfulService belajarRestfulService;
    
   @Test
    public void testFindAll(){
        Page<Pembayaran> hasil = belajarRestfulService.findAllPembayaran(new PageRequest(0, 10));
        assertEquals(new Integer(1), new Integer(hasil.getNumberOfElements()));
    }
    
}
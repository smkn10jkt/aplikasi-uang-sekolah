/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.service.impl;

import com.artivisi.school.tuition.domain.Kelas;
import org.springframework.beans.factory.annotation.Autowired;
import com.artivisi.school.tuition.service.BelajarRestfulService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.artivisi.school.tuition.domain.Tagihan;
import java.net.URI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.data.domain.PageRequest;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 *
 * @author axioo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:com/artivisi/school/tuition/**/applicationContext.xml"})
public class KelasServiceTestIT {
   @Autowired private BelajarRestfulService belajarRestfulService;
    
   @Test
    public void testFindAll(){
        Page<Kelas> hasil = belajarRestfulService.findAllKelas(new PageRequest(0, 10));
        assertEquals(new Integer(1), new Integer(hasil.getNumberOfElements()));
    }
    
}

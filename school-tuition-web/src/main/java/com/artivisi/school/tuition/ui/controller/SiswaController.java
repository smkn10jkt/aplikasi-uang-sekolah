/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.ui.controller;

import com.artivisi.school.tuition.service.BelajarRestfulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.artivisi.school.tuition.domain.Siswa;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriTemplate;
/**
 *
 * @author siswa
 */
@Controller
public class SiswaController {
       @Autowired private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/table/siswa", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Siswa t, HttpServletRequest request, HttpServletResponse response){
        belajarRestfulService.save(t);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, t.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/table/siswa/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Siswa t){
        Siswa siswaDb = belajarRestfulService.findSiswaById(id);
        if(siswaDb == null){
            throw  new IllegalStateException();
        }
        t.setId(siswaDb.getId());
        belajarRestfulService.save(t);
    }
    
    @RequestMapping(value="/table/siswa/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Siswa siswaDb = belajarRestfulService.findSiswaById(id);
        if(siswaDb == null){
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(siswaDb);
    }
    
    @RequestMapping(value="/table/siswa/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Siswa findById(@PathVariable String id){
        return belajarRestfulService.findSiswaById(id);
    }
    
    @RequestMapping(value="/table/siswa", method=RequestMethod.GET)
    @ResponseBody
    public Page<Siswa> findKSiswas(Pageable pagination){
        return belajarRestfulService.findAllSiswa(pagination);
    }
}


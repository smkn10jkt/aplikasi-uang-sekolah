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
import com.artivisi.school.tuition.domain.Kelas;
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
 * @author kelas
 */
@Controller
public class KelasController {
    
 @Autowired private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/table/kelas", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Kelas kelas, HttpServletRequest request, HttpServletResponse response){
      belajarRestfulService.save(kelas);
       String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, kelas.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/table/kelas{id}", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Kelas kelas){
        Kelas soalDb = belajarRestfulService.findKelasById(id);
        if(soalDb !=null){
            belajarRestfulService.save(kelas);
        }
    }
    
    @RequestMapping(value="/table/kelas{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Kelas kelas = belajarRestfulService.findKelasById(id);
        if(kelas !=null){
            belajarRestfulService.delete(kelas);
        }
    }
    
    @RequestMapping(value="/table/kelas{id}", method= RequestMethod.GET)
    @ResponseBody
    public Kelas findSoalById(@PathVariable String id){
        return belajarRestfulService.findKelasById(id);
        
    }
    
    @RequestMapping(value="/master/soal", method= RequestMethod.GET)
    @ResponseBody
    public Page<Kelas> findSoal(Pageable pagination){
        return belajarRestfulService.findAllKelas(pagination);
    }
}


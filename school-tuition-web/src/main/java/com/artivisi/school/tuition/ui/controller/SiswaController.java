/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.ui.controller;

import com.artivisi.school.tuition.domain.Siswa;
import com.artivisi.school.tuition.service.BelajarRestfulService;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

/**
 *
 * @author user
 */
@Controller
public class SiswaController {
     @Autowired
    private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/table/siswa", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Siswa k, HttpServletRequest request, HttpServletResponse response){
    belajarRestfulService.save(k);
    String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, k.getId());
        response.setHeader("Location", uri.toASCIIString());
       }
      @RequestMapping(value="/table/siswa/{id}", method=RequestMethod.DELETE)
      @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
    Siswa siswaDb = belajarRestfulService.findSiswaById(id);
    if(siswaDb !=null)
    belajarRestfulService.delete(siswaDb);
    
       }
      @RequestMapping(value="/table/siswa/{id}", method=RequestMethod.GET)
      @ResponseBody
    public Siswa findById(@PathVariable String id){
        return belajarRestfulService.findSiswaById(id);
    }
      @RequestMapping(value="/table/siswa", method=RequestMethod.GET)
      @ResponseBody
    public Page<Siswa> findSiswa( Pageable pagination){
        return belajarRestfulService.findAllSiswa(pagination);
       }
}


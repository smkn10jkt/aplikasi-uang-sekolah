/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.ui.controller;

import com.artivisi.school.tuition.domain.JenisBiaya;
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
 * @author jenisbiaya
 */
@Controller
public class JenisBiayaController {
    @Autowired
    private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/master/jenisbiaya", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid JenisBiaya jb, HttpServletRequest request, HttpServletResponse response){
    belajarRestfulService.save(jb);
    String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, jb.getId());
        response.setHeader("Location", uri.toASCIIString());
       }
      @RequestMapping(value="/master/jenisbiaya/{id}", method=RequestMethod.DELETE)
      @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
    JenisBiaya jenisbiayaDb = belajarRestfulService.findJenisBiayaById(id);
    if(jenisbiayaDb !=null)
    belajarRestfulService.delete(jenisbiayaDb);
    
       }
      @RequestMapping(value="/master/jenisbiaya/{id}", method=RequestMethod.GET)
      @ResponseBody
    public JenisBiaya findById(@PathVariable String id){
        return belajarRestfulService.findJenisBiayaById(id);
    }
      @RequestMapping(value="/master/jenisbiaya", method=RequestMethod.GET)
      @ResponseBody
    public Page<JenisBiaya> findJenisBiaya( Pageable pagination){
        return belajarRestfulService.findAllJenisBiaya(pagination);
       }
}


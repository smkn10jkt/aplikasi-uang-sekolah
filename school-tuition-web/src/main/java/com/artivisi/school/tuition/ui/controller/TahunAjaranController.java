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

import com.artivisi.school.tuition.domain.TahunAjaran;
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
 * @author tahun_ajaran
 */
@Controller
public class TahunAjaranController {
    @Autowired
    private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/table/tahun_ajaran", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid TahunAjaran ta, HttpServletRequest request, HttpServletResponse response){
    belajarRestfulService.save(ta);
    String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, ta.getId());
        response.setHeader("Location", uri.toASCIIString());
       }
      @RequestMapping(value="/table/tahun_ajaran/{id}", method=RequestMethod.DELETE)
      @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
    TahunAjaran tahun_ajaranDb = belajarRestfulService.findTahunAjaranById(id);
    if(tahun_ajaranDb ==null){
        throw new IllegalStateException();
    }
    belajarRestfulService.delete(tahun_ajaranDb);
    
       }
      @RequestMapping(value="/table/tahun_ajaran/{id}", method=RequestMethod.GET)
      @ResponseBody
    public TahunAjaran findById(@PathVariable String id){
        return belajarRestfulService.findTahunAjaranById(id);
    }
      @RequestMapping(value="/table/tahun_ajaran", method=RequestMethod.GET)
      @ResponseBody
    public Page<TahunAjaran> findTahunAjarans(Pageable pagination){
        return belajarRestfulService.findAllTahunAjaran(pagination);
       }
}


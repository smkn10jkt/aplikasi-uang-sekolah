/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.ui.controller;

import com.artivisi.school.tuition.domain.JenisBiaya;
import com.artivisi.school.tuition.domain.Kelas;
import com.artivisi.school.tuition.domain.Tagihan;
import com.artivisi.school.tuition.service.BelajarRestfulService;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriTemplate;

/**
 *
 * @author user
 */
@Controller
public class TagihanController {
    @Autowired private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/table/tagihan", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Tagihan t, HttpServletRequest request, HttpServletResponse response){
        belajarRestfulService.save(t);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, t.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/table/tagihan/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Tagihan t){
        Tagihan tagihanDb = belajarRestfulService.findTagihanById(id);
        if(tagihanDb == null){
            throw  new IllegalStateException();
        }
        t.setId(tagihanDb.getId());
        belajarRestfulService.save(t);
    }
    
    @RequestMapping(value="/table/tagihan/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Tagihan tagihanDb = belajarRestfulService.findTagihanById(id);
        if(tagihanDb == null){
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(tagihanDb);
    }
    
    @RequestMapping(value="/table/tagihan/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Tagihan findById(@PathVariable String id){
        return belajarRestfulService.findTagihanById(id);
    }
    
    @RequestMapping(value="/table/tagihan", method=RequestMethod.GET)
    @ResponseBody
    public Page<Tagihan> findJenisBiaya(Pageable pagination){
        return belajarRestfulService.findAllTagihan(pagination);
    }
}
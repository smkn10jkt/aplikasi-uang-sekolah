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

import com.artivisi.school.tuition.domain.Pembayaran;
import com.artivisi.school.tuition.domain.TagihanDetail;
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
 * @author tagihan_detail
 */
@Controller
public class TagihanDetailController {
    @Autowired
    private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/table/tagihan_detail", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid TagihanDetail td, HttpServletRequest request, HttpServletResponse response){
    belajarRestfulService.save(td);
    String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, td.getId());
        response.setHeader("Location", uri.toASCIIString());
       }
      @RequestMapping(value="/table/tagihan_detail/{id}", method=RequestMethod.DELETE)
      @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
    TagihanDetail tagihan_detailDb = belajarRestfulService.findTagihanDetailById(id);
    if(tagihan_detailDb !=null)
    belajarRestfulService.delete(tagihan_detailDb);
    
       }
      @RequestMapping(value="/table/tagihan_detail/{id}", method=RequestMethod.GET)
      @ResponseBody
    public TagihanDetail findById(@PathVariable String id){
        return belajarRestfulService.findTagihanDetailById(id);
    }
      @RequestMapping(value="/table/tagihan_detail", method=RequestMethod.GET)
      @ResponseBody
    public Page<TagihanDetail> findTagihanDetail( Pageable pagination){
        return belajarRestfulService.findAllTagihanDetail(pagination);
       }
}


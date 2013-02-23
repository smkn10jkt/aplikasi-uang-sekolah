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
import com.artivisi.school.tuition.domain.KonfigurasiTagihanDetail;
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
 * @author konfigurasitagihandetail
 */
@Controller
public class KonfigurasiTagihanDetailController {
    @Autowired
    private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/master/konfigurasitagihan_detail", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid KonfigurasiTagihanDetail ktd, HttpServletRequest request, HttpServletResponse response){
    belajarRestfulService.save(ktd);
    String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, ktd.getId());
        response.setHeader("Location", uri.toASCIIString());
       }
      @RequestMapping(value="/master/konfigurasitagihan_detail/{id}", method=RequestMethod.DELETE)
      @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
    KonfigurasiTagihanDetail konfigurasitagihandetailDb = belajarRestfulService.findKonfigurasiTagihanDetailById(id);
    if(konfigurasitagihandetailDb !=null)
    belajarRestfulService.delete(konfigurasitagihandetailDb);
    
       }
      @RequestMapping(value="/master/konfigurasitagihan_detail/{id}", method=RequestMethod.GET)
      @ResponseBody
    public KonfigurasiTagihanDetail findById(@PathVariable String id){
        return belajarRestfulService.findKonfigurasiTagihanDetailById(id);
    }
      @RequestMapping(value="/master/konfigurasitagihan_detail", method=RequestMethod.GET)
      @ResponseBody
    public Page<KonfigurasiTagihanDetail> findKonfigurasiTagihanDetail( Pageable pagination){
        return belajarRestfulService.findAllKonfigurasiTagihanDetail(pagination);
       }
}


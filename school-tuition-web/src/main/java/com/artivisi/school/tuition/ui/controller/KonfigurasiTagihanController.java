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
import com.artivisi.school.tuition.domain.KonfigurasiTagihan;
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
 * @author KonfigurasiTagihan
 */
@Controller
public class KonfigurasiTagihanController {
    @Autowired
    private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/master/konfigurasitagihan", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid KonfigurasiTagihan kt, HttpServletRequest request, HttpServletResponse response){
    belajarRestfulService.save(kt);
    String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, kt.getId());
        response.setHeader("Location", uri.toASCIIString());
       }
      @RequestMapping(value="/master/konfigurasitagihan/{id}", method=RequestMethod.DELETE)
      @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
    KonfigurasiTagihan konfigurasitagihanDb = belajarRestfulService.findKonfigurasiTagihanById(id);
    if(konfigurasitagihanDb !=null)
    belajarRestfulService.delete(konfigurasitagihanDb);
    
       }
      @RequestMapping(value="/master/konfigurasitagihan/{id}", method=RequestMethod.GET)
      @ResponseBody
    public KonfigurasiTagihan findById(@PathVariable String id){
        return belajarRestfulService.findKonfigurasiTagihanById(id);
    }
      @RequestMapping(value="/master/konfigurasitagihan", method=RequestMethod.GET)
      @ResponseBody
    public Page<KonfigurasiTagihan> findKonfigurasiTagihan( Pageable pagination){
        return belajarRestfulService.findAllKonfigurasiTagihan(pagination);
       }
}


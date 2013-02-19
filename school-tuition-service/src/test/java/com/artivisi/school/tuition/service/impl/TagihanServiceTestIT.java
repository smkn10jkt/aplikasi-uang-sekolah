/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.service.impl;

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
/**
 *
 * @author axioo
 */
public class TagihanServiceTestIT {
    
     @Autowired private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/table/tagihan", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Tagihan tagihan, HttpServletRequest request, HttpServletResponse response){
      belajarRestfulService.save(tagihan);
       String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, tagihan.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/table/tagihan{id}", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Tagihan tagihan){
        Tagihan tagihanDb = belajarRestfulService.findTagihanById(id);
        if(tagihanDb !=null){
            belajarRestfulService.save(tagihan);
        }
    }
    
    @RequestMapping(value="/table/tagihan{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Tagihan tagihanDb = belajarRestfulService.findTagihanById(id);
        if(tagihanDb !=null){
            belajarRestfulService.delete(tagihanDb);
        }
    }
    
    @RequestMapping(value="/table/tagihan{id}", method= RequestMethod.GET)
    @ResponseBody
    public Tagihan findTagihanById(@PathVariable String id){
        return belajarRestfulService.findTagihanById(id);
        
    }
    
    @RequestMapping(value="/table/tagihan", method= RequestMethod.GET)
    @ResponseBody
    public Page<Tagihan> findTagihan(Pageable pagination){
        return belajarRestfulService.findAllTagihan(pagination);
    }
}

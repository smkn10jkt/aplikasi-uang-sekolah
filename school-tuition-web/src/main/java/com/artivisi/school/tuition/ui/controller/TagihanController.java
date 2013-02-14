/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.ui.controller;

import com.artivisi.school.tuition.domain.Tagihan;
import com.artivisi.school.tuition.domain.TahunAjaran;
import com.artivisi.school.tuition.service.BelajarRestfulService;
import java.net.URI;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
public class TagihanController {
     @Autowired
    private BelajarRestfulService belajarRestfulService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/Tagihan/{id}")
    @ResponseBody
     public Tagihan findByIdTagihan(@PathVariable String id) {
       Tagihan x = belajarRestfulService.findTagihanById(id);
        if (x == null) {
            throw new IllegalStateException();
        }
       return null;
        
    }
     @RequestMapping(value = "/tagihan", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid Tagihan x, HttpServletRequest request, HttpServletResponse response) {
        belajarRestfulService.save(x);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, x.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
     @RequestMapping(method = RequestMethod.PUT, value = "/tagihan/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Tagihan x) {
        Tagihan a = belajarRestfulService.findTagihanById(id);
        if (a == null) {
            logger.warn("tagihan dengan id [{}] tidak ditemukan", id);
            throw new IllegalStateException();
        }
        x.setId(a.getId());
        belajarRestfulService.save(x);
    }
      @RequestMapping(method = RequestMethod.DELETE, value = "/tagihan/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        Tagihan a = belajarRestfulService.findTagihanById(id);
        if (a == null) {
            logger.warn("Tagihan dengan id [{}] tidak ditemukan", id);
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(a);
    }
       @RequestMapping(value = "/tagihan", method = RequestMethod.GET)
    @ResponseBody
    public List<Tagihan> findAll(
            Pageable pageable,
            HttpServletResponse response) {
        List<Tagihan> hasil = belajarRestfulService.findAllTagihan(pageable).getContent();

      

        return hasil;
    }
       @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({IllegalStateException.class})
    public void handle() {
        logger.debug("Resource dengan URI tersebut tidak ditemukan");
    }
}

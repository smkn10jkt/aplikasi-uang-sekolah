/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.ui.controller;

import com.artivisi.school.tuition.domain.Siswa;
import com.artivisi.school.tuition.domain.Tagihan;
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
public class SiswaController {
     @Autowired
    private BelajarRestfulService belajarRestfulService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/Siswa/{id}")
    @ResponseBody
     public Siswa findByIdSiswa(@PathVariable String id) {
       Siswa x = belajarRestfulService.findSiswaById(id);
        if (x == null) {
            throw new IllegalStateException();
        }
       return null;
        
    }
     @RequestMapping(value = "/siswa", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid Siswa x, HttpServletRequest request, HttpServletResponse response) {
        belajarRestfulService.save(x);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, x.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
     @RequestMapping(method = RequestMethod.PUT, value = "/siswa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Siswa x) {
        Siswa a = belajarRestfulService.findSiswaById(id);
        if (a == null) {
            logger.warn("siswa dengan id [{}] tidak ditemukan", id);
            throw new IllegalStateException();
        }
        x.setId(a.getId());
        belajarRestfulService.save(x);
    }
      @RequestMapping(method = RequestMethod.DELETE, value = "/siswa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        Siswa a = belajarRestfulService.findSiswaById(id);
        if (a == null) {
            logger.warn("Siswa dengan id [{}] tidak ditemukan", id);
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(a);
    }
       @RequestMapping(value = "/siswa", method = RequestMethod.GET)
    @ResponseBody
    public List<Siswa> findAll(
            Pageable pageable,
            HttpServletResponse response) {
        List<Siswa> hasil = belajarRestfulService.findAllSiswa(pageable).getContent();

      

        return hasil;
    }
       @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({IllegalStateException.class})
    public void handle() {
        logger.debug("Resource dengan URI tersebut tidak ditemukan");
    }
}

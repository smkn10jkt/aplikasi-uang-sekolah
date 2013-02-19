/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.ui.controller;

import com.artivisi.school.tuition.domain.Kelas;
import com.artivisi.school.tuition.domain.Pembayaran;
import com.artivisi.school.tuition.domain.PembayaranDetail;
import com.artivisi.school.tuition.domain.User;
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
import org.springframework.stereotype.Controller;
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
 * @author pembayarandetail
 */
@Controller
public class PembayaranDetailController {
    
     @Autowired
    private BelajarRestfulService belajarRestfulService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/PembayaranDetail/{id}")
    @ResponseBody
     public PembayaranDetail findByIdPembayaranDetail(@PathVariable String id) {
       PembayaranDetail x = belajarRestfulService.findPembayaranDetailById(id);
        if (x == null) {
            throw new IllegalStateException();
        }
       return null;
        
    }
    @RequestMapping(value = "/pembayaran_detail", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid PembayaranDetail x, HttpServletRequest request, HttpServletResponse response) {
        belajarRestfulService.save(x);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, x.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/pembayaran_detail/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid PembayaranDetail x) {
        PembayaranDetail a = belajarRestfulService.findPembayaranDetailById(id);
        if (a == null) {
            logger.warn("PembayaranDetail dengan id [{}] tidak ditemukan", id);
            throw new IllegalStateException();
        }
        x.setId(a.getId());
        belajarRestfulService.save(x);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/pembayaran_detail/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        PembayaranDetail a = belajarRestfulService.findPembayaranDetailById(id);
        if (a == null) {
            logger.warn("PembayaranDetail dengan id [{}] tidak ditemukan", id);
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(a);
    }
       @RequestMapping(value = "/pembayaran_detail", method = RequestMethod.GET)
    @ResponseBody
    public List<PembayaranDetail> findAll(
            Pageable pageable,
            HttpServletResponse response) {
        List<PembayaranDetail> hasil = belajarRestfulService.findAllPembayaranDetail(pageable).getContent();

      

        return hasil;
    }
       @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({IllegalStateException.class})
    public void handle() {
        logger.debug("Resource dengan URI tersebut tidak ditemukan");
    }

   
}

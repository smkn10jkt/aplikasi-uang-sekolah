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
import org.springframework.data.domain.Page;
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
    
    @RequestMapping(value="/table/pembayaran_detail", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid PembayaranDetail pd, HttpServletRequest request, HttpServletResponse response){
    belajarRestfulService.save(pd);
    String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, pd.getId());
        response.setHeader("Location", uri.toASCIIString());
       }
      @RequestMapping(value="/table/pembayaran_detail/{id}", method=RequestMethod.DELETE)
      @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
    PembayaranDetail pembayarandetailDb = belajarRestfulService.findPembayaranDetailById(id);
    if(pembayarandetailDb !=null)
    belajarRestfulService.delete(pembayarandetailDb);
    
       }
      @RequestMapping(value="/table/pembayaran_detail/{id}", method=RequestMethod.GET)
      @ResponseBody
    public PembayaranDetail findById(@PathVariable String id){
        return belajarRestfulService.findPembayaranDetailById(id);
    }
      @RequestMapping(value="/table/pembayaran_detail", method=RequestMethod.GET)
      @ResponseBody
    public Page<PembayaranDetail> findPembayaranDetail( Pageable pagination){
        return belajarRestfulService.findAllPembayaranDetail(pagination);
       }

   
}

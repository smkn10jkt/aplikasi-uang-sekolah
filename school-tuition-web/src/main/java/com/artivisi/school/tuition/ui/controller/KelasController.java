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
import com.artivisi.school.tuition.domain.Kelas;
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
 * @author kelas
 */
@Controller
public class KelasController {
   @Autowired private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/table/kelas", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Kelas t, HttpServletRequest request, HttpServletResponse response){
        belajarRestfulService.save(t);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, t.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/table/kelas/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Kelas t){
        Kelas kelasDb = belajarRestfulService.findKelasById(id);
        if(kelasDb == null){
            throw  new IllegalStateException();
        }
        t.setId(kelasDb.getId());
        belajarRestfulService.save(t);
    }
    
    @RequestMapping(value="/table/kelas/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Kelas kelasDb = belajarRestfulService.findKelasById(id);
        if(kelasDb == null){
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(kelasDb);
    }
    
    @RequestMapping(value="/table/kelas/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Kelas findById(@PathVariable String id){
        return belajarRestfulService.findKelasById(id);
    }
    
    @RequestMapping(value="/table/kelas", method=RequestMethod.GET)
    @ResponseBody
    public Page<Kelas> findKelases(Pageable pagination){
        return belajarRestfulService.findAllKelas(pagination);
    }
}
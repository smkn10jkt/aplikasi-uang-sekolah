/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.tuition.ui.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author axioo
 */
@Controller
public class PaymentsController {
    @Autowired private SasService sasService;
    
    @RequestMapping(value="/master/payments", method= RequestMethod.POST)
    
    public void save(@RequestBody @Valid Payments p){
        
    }
    
    @RequestMapping(value="/master/payments/{name}", method= RequestMethod.PUT)
    public void update(){
        
    }
    
    @RequestMapping(value="/master/payments/{name}", method= RequestMethod.DELETE)
    public void delete(){
        
    }
    
    @RequestMapping(value="/master/payments/{name}", method= RequestMethod.GET)
    public PaymentsController findById(){
        return null;
    }
    
    @RequestMapping(value="/master/payments", method= RequestMethod.GET)
    public Page<PaymentsController> findPayments(){
        return null;
    }
    
}

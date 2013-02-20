package com.artivisi.school.tuition.ui.controller;

import com.artivisi.school.tuition.domain.Kelas;
import com.artivisi.school.tuition.domain.User;
import com.artivisi.school.tuition.domain.Role;
import com.artivisi.school.tuition.domain.TahunAjaran;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.with;
import com.jayway.restassured.authentication.FormAuthConfig;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.junit.Assert.*;

public class KelasControllerTestIT {

    private String target = "http://localhost:10000/table/kelas";
    private String login = "http://localhost:10000/j_spring_security_check";
    private String username = "endy";
    private String password = "123";

    @Test
    public void testSaveInvalid(){
        User u = new User();
        
        given()
            .auth().form(username, password, new FormAuthConfig(login, "j_username", "j_password"))
            .contentType("application/json")
            .body(u)
            .expect().statusCode(400).when().post(target);
    }

    @Test
    public void testSaveUpdateDelete() {

        TahunAjaran t = new TahunAjaran();
        t.setId("1a");

        Kelas k = new Kelas();
        k.setTahunAjaran(t);
        k.setId("1");
        k.setKode("rdw");
        k.setNama("al ");
        
                
        String id = testSave(target, k);
        System.out.println("Id : " + id);
        testGetExistingById(id, k);
        
        k.setNama("ridwan");
        k.setKode("raa");
        
        testUpdateExisting(id, k);
        testGetExistingById(id, k);
        testDeleteExistingById(id);
    }

    private String testSave(String target, Kelas x) {
        String location = given()
                .auth().form(username, password, new FormAuthConfig(login, "j_username", "j_password"))
                .contentType("application/json")
                .body(x)
                .expect().statusCode(201).when().post(target)
                .getHeader("Location");

        assertNotNull(location);
        assertTrue(location.startsWith(target));

        String[] locationSplit = location.split("/");
        String id = locationSplit[locationSplit.length - 1];

        return id;
    }

    private void testGetExistingById(String id, Kelas k) {
        with().header("Accept", "application/json")
                .auth().form(username, password, new FormAuthConfig(login, "j_username", "j_password"))
                .expect()
                .statusCode(200)
                .body("nama", equalTo(k.getNama()), "kode", equalTo(k.getKode()))
                .when().get(target + "/" + id);
    }

    private void testUpdateExisting(String id, Kelas k) {

        given()
                .auth().form(username, password, new FormAuthConfig(login, "j_username", "j_password"))
                .contentType("application/json")
                .body(k)
                .expect()
                .statusCode(200).when().put(target + "/" + id);
    }

    private void testDeleteExistingById(String id) {
        given().auth().form(username, password, new FormAuthConfig(login, "j_username", "j_password"))
                .expect().statusCode(200).when().delete(target + "/" + id);

        given().auth().form(username, password, new FormAuthConfig(login, "j_username", "j_password"))
                .expect().statusCode(404).when().get(target + "/" + id);
    }

    @Test
    public void testGetExistingById() {
        with().header("Accept", "application/json")
                .auth().form(username, password, new FormAuthConfig(login, "j_username", "j_password"))
                .expect()
                .statusCode(200)
                .body("id", equalTo("2"),
                "nama", equalTo("ridwan"),
                "kode", equalTo("raa")).when()
                .get(target + "/" + "2");
    }

    @Test
    public void testGetNonExistentById() {
        with()
                .auth().form(username, password, new FormAuthConfig(login, "j_username", "j_password"))
                .expect().statusCode(404).when().get(target + "/" + "/blabla");
    }

    @Test
    public void testFindAll() {
        with()
                .auth().form(username, password, new FormAuthConfig(login, "j_username", "j_password"))
                .header("Accept", "application/json").expect().statusCode(200)
                .body("id", hasItems("ridwan")).when().get(target);
    }

}

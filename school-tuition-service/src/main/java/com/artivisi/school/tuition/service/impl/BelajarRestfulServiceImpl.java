package com.artivisi.school.tuition.service.impl;

import com.artivisi.school.tuition.domain.Pembayaran;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.artivisi.school.tuition.dao.ApplicationConfigDao;
import com.artivisi.school.tuition.dao.KelasDao;
import com.artivisi.school.tuition.dao.MenuDao;
import com.artivisi.school.tuition.dao.PembayaranDao;
import com.artivisi.school.tuition.dao.PermissionDao;
import com.artivisi.school.tuition.dao.RoleDao;
import com.artivisi.school.tuition.dao.SiswaDao;
import com.artivisi.school.tuition.dao.TagihanDao;
import com.artivisi.school.tuition.dao.TahunAjaranDao;
import com.artivisi.school.tuition.dao.UserDao;
import com.artivisi.school.tuition.domain.ApplicationConfig;
import com.artivisi.school.tuition.domain.Kelas;
import com.artivisi.school.tuition.domain.Menu;
import com.artivisi.school.tuition.domain.Permission;
import com.artivisi.school.tuition.domain.Role;
import com.artivisi.school.tuition.domain.Siswa;
import com.artivisi.school.tuition.domain.Tagihan;
import com.artivisi.school.tuition.domain.TahunAjaran;
import com.artivisi.school.tuition.domain.User;
import com.artivisi.school.tuition.service.BelajarRestfulService;
import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@SuppressWarnings("unchecked")
@Service("belajarRestfulService")
@Transactional
public class BelajarRestfulServiceImpl implements BelajarRestfulService {

	@Autowired
    private ApplicationConfigDao applicationConfigDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private KelasDao kelasDao;
    @Autowired 
    private TahunAjaranDao tahunAjaran;
    @Autowired
    private TagihanDao tagihanDao;
    @Autowired 
    private SiswaDao siswaDao; 
     @Autowired 
    private PembayaranDao pembayaranDao;

    @Override
    public void save(ApplicationConfig ac) {
        applicationConfigDao.save(ac);
    }

    @Override
    public void delete(ApplicationConfig ac) {
        if (ac == null || ac.getId() == null) {
            return;
        }
        applicationConfigDao.delete(ac);
    }

    @Override
    public ApplicationConfig findApplicationConfigById(String id) {
        if (!StringUtils.hasText(id)) {
            return null;
        }
        return applicationConfigDao.findOne(id);
    }

    @Override
    public Page<ApplicationConfig> findAllApplicationConfigs(Pageable pageable) {
        if(pageable == null){
            pageable = new PageRequest(0, 20);
        }
        return applicationConfigDao.findAll(pageable);
    }

    @Override
    public Long countAllApplicationConfigs() {
        return applicationConfigDao.count();
    }

    @Override
    public Page<ApplicationConfig> findApplicationConfigs(String search, Pageable pageable) {
        if (!StringUtils.hasText(search)) {
            return findAllApplicationConfigs(pageable);
        }
        
        if(pageable == null){
            pageable = new PageRequest(0, 20);
        }

        return applicationConfigDao.search("%" + search + "%", pageable);
    }

    @Override
    public Long countApplicationConfigs(String search) {
        if (!StringUtils.hasText(search)) {
            return countAllApplicationConfigs();
        }
        return applicationConfigDao.count("%" + search + "%");
    }

    @Override
    public void save(Menu m) {
        menuDao.save(m);
    }

    @Override
    public void delete(Menu m) {
        menuDao.delete(m);
    }

    @Override
    public Menu findMenuById(String id) {
        if (!StringUtils.hasText(id)) {
            return null;
        }
        return menuDao.findOne(id);
    }

    @Override
    public List<Menu> findTopLevelMenu() {
        return menuDao.findTopLevelMenu();
    }
    
    @Override
    public Page<Menu> findAllMenu(Pageable pageable) {
        return menuDao.findAll(pageable);
    }
    
    @Override
    public Long countAllMenu() {
        return menuDao.count();
    }

    @Override
    public List<Menu> findMenuByParent(Menu m) {
        if(m == null || !StringUtils.hasText(m.getId())) {
            return new ArrayList<Menu>();
        }
        return menuDao.findMenuByParent(m.getId());
    }
    
    @Override
    public List<Menu> findMenuNotInRole(Role role){
        if(role == null){
            return new ArrayList<Menu>();
        }
        
        Role r = findRoleById(role.getId());
        if(r == null || r.getMenuSet().isEmpty()){
            return new ArrayList<Menu>();
        }
        
        List<String> ids = new ArrayList<String>();
        for (Menu m : r.getMenuSet()) {
            ids.add(m.getId());
        }
        
        return menuDao.findByIdNotIn(ids);
    }

    @Override
    public void save(Permission m) {
        permissionDao.save(m);
    }

    @Override
    public void delete(Permission m) {
        permissionDao.delete(m);
    }

    @Override
    public Permission findPermissionById(String id) {
        if(!StringUtils.hasText(id)){
            return null;
        }
        return permissionDao.findOne(id);
    }

    @Override
    public Page<Permission> findAllPermissions(Pageable pageable) {
        if(pageable == null){
            pageable = new PageRequest(0, 20);
        }
        return permissionDao.findAll(pageable);
    }

    @Override
    public Long countAllPermissions() {
        return permissionDao.count();
    }
    
    @Override
    public List<Permission> findPermissionsNotInRole(Role role) {
        if(role == null){
            return new ArrayList<Permission>();
        }
        
        Role r = findRoleById(role.getId());
        if(r == null || r.getPermissionSet().isEmpty()){
            return new ArrayList<Permission>();
        }
        
        List<String> ids = new ArrayList<String>();
        for (Permission p : r.getPermissionSet()) {
            ids.add(p.getId());
        }
        
        return permissionDao.findByIdNotIn(ids);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public void delete(Role role) {
        roleDao.delete(role);
    }

    @Override
    public Role findRoleById(String id) {
        if(!StringUtils.hasText(id)){
            return null;
        }
        
        Role r = roleDao.findOne(id);
        if(r != null){
            r.getPermissionSet().size();
            r.getMenuSet().size();
        }
        
        return r;
    }

    @Override
    public Page<Role> findAllRoles(Pageable pageable) {
        return roleDao.findAll(pageable);
    }

    @Override
    public Long countAllRoles() {
        return roleDao.count();
    }

    @Override
    public void save(User m) {
        userDao.save(m);
    }

    @Override
    public void delete(User m) {
        userDao.delete(m);
    }

    @Override
    public User findUserById(String id) {
        if(!StringUtils.hasText(id)){
            return null;
        }
        return userDao.findOne(id);
    }

    @Override
    public User findUserByUsername(String username) {
        if(!StringUtils.hasText(username)){
            return null;
        }
        return userDao.findByUsername(username);
    }

    @Override
    public Page<User> findAllUsers(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public Long countAllUsers() {
        return userDao.count();
    }

    @Override
    public void save(Kelas k) {
        kelasDao.save(k);
    }

    @Override
    public void delete(Kelas k) {
        
       kelasDao.delete(k);
    }

    @Override
    public Kelas findKelasById(String id) {
         if(!StringUtils.hasText(id)){
            return null;
        }
        return kelasDao.findOne(id);
    }

   

    @Override
    public Page<Kelas> findAllKelas(Pageable pageable) {
       return kelasDao.findAll(pageable);
    }

    @Override
    public Long countAllKelas() {
        return kelasDao.count();
    }

    @Override
    public void save(TahunAjaran t) {
        tahunAjaran.save(t);
    }

    @Override
    public void delete(TahunAjaran t) {
        tahunAjaran.delete(t);
    }

    @Override
    public TahunAjaran findTahunAjaranById(String id) {
        if(!StringUtils.hasText(id)){
            return null;
        }
        return tahunAjaran.findOne(id);
    }

    @Override
    public Page<TahunAjaran> findAllTahunAjaran(Pageable pageable) {
        return tahunAjaran.findAll(pageable);
    }

    @Override
    public Long countAllTahunAjaran() {
        return tahunAjaran.count();
    }

    @Override
    public void save(Tagihan ta) {
         tagihanDao.save(ta);
    }

    @Override
    public void delete(Tagihan ta) {
         tagihanDao.delete(ta);
    }

    @Override
    public Tagihan findTagihanById(String id) {
       if(!StringUtils.hasText(id)){
            return null;
        }
        return tagihanDao.findOne(id);
    }

    @Override
    public Page<Tagihan> findAllTagihan(Pageable pageable) {
       return tagihanDao.findAll(pageable); 
    }

    @Override
    public Long countAllTagihann() {
         return tagihanDao.count();
    }

    @Override
    public void save(Siswa s) {
        siswaDao.save(s);
    }

    @Override
    public void delete(Siswa s) {
        siswaDao.delete(s);
    }

    @Override
    public Siswa findSiswaById(String id) {
        if(!StringUtils.hasText(id)){
            return null;
        }
        return siswaDao.findOne(id);
    }

    @Override
    public Page<Siswa> findAllSiswa(Pageable pageable) {
         return siswaDao.findAll(pageable);
    }

    @Override
    public Long countAllSiswa() {
        return siswaDao.count();
    }

    @Override
    public void save(Pembayaran p) {
        pembayaranDao.save(p);
    }

    @Override
    public void delete(Pembayaran p) {
        pembayaranDao.delete(p);
    }

    @Override
    public Pembayaran findPembayaranById(String id) {
        if(!StringUtils.hasText(id)){
            return null;
        }
        return pembayaranDao.findOne(id);
    }

    @Override
    public Page<Pembayaran> findAllPembayaran(Pageable pageable) {
        return pembayaranDao.findAll(pageable);
    }

    @Override
    public Long countAllPembayaran() {
        return pembayaranDao.count();
    }
}

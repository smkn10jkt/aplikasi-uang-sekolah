package com.artivisi.school.tuition.service;

import java.util.List;

import com.artivisi.school.tuition.domain.ApplicationConfig;
import com.artivisi.school.tuition.domain.JenisBiaya;
import com.artivisi.school.tuition.domain.Kelas;
import com.artivisi.school.tuition.domain.KonfigurasiTagihan;
import com.artivisi.school.tuition.domain.Menu;
import com.artivisi.school.tuition.domain.Pembayaran;
import com.artivisi.school.tuition.domain.PembayaranDetail;
import com.artivisi.school.tuition.domain.Permission;
import com.artivisi.school.tuition.domain.Role;
import com.artivisi.school.tuition.domain.Siswa;
import com.artivisi.school.tuition.domain.Tagihan;
import com.artivisi.school.tuition.domain.TagihanDetail;
import com.artivisi.school.tuition.domain.TahunAjaran;
import com.artivisi.school.tuition.domain.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BelajarRestfulService extends MonitoredService {
	// konfigurasi aplikasi
	void save(ApplicationConfig ac);
	void delete(ApplicationConfig ac);
	ApplicationConfig findApplicationConfigById(String id);
    Page<ApplicationConfig> findAllApplicationConfigs(Pageable pageable);
	Long countAllApplicationConfigs();
	Long countApplicationConfigs(String search);
	Page<ApplicationConfig> findApplicationConfigs(String search, Pageable pageable);
        
    // menu
    void save(Menu m);
    void delete(Menu m);
    Menu findMenuById(String id);
    List<Menu> findTopLevelMenu();
    Page<Menu> findAllMenu(Pageable pageable);
    Long countAllMenu();
    List<Menu> findMenuByParent(Menu m);
    List<Menu> findMenuNotInRole(Role r);
    
    // permission
    void save(Permission m);
    void delete(Permission m);
    Permission findPermissionById(String id);
    Page<Permission> findAllPermissions(Pageable pageable);
    Long countAllPermissions();
    List<Permission> findPermissionsNotInRole(Role r);
    
    // role
    void save(Role role);
    void delete(Role role);
    Role findRoleById(String id);
    Page<Role> findAllRoles(Pageable pageable);
    Long countAllRoles();
    
    // user
    void save(User m);
    void delete(User m);
    User findUserById(String id);
    User findUserByUsername(String username);
    Page<User> findAllUsers(Pageable pageable);
    Long countAllUsers();
    
    // kelas
    void save(Kelas k);
    void delete (Kelas k);
    Kelas findKelasById(String id); 
    Page<Kelas> findAllKelas(Pageable pageable);
    Long countAllKelas();
    
     void save(TahunAjaran t);
    void delete (TahunAjaran t);
    TahunAjaran findTahunAjaranById(String id); 
    Page<TahunAjaran> findAllTahunAjaran(Pageable pageable);
    Long countAllTahunAjaran();
    
    void save(Tagihan ta);
    void delete (Tagihan ta);
    Tagihan findTagihanById(String id); 
    Page<Tagihan> findAllTagihan(Pageable pageable);
    Long countAllTagihann();
    
    void save(Siswa s);
    void delete (Siswa s);
    Siswa findSiswaById(String id); 
    Page<Siswa> findAllSiswa(Pageable pageable);
    Long countAllSiswa();
    
    void save(Pembayaran p);
    void delete (Pembayaran p);
    Pembayaran findPembayaranById(String id); 
    Page<Pembayaran> findAllPembayaran(Pageable pageable);
    Long countAllPembayaran();
    
    void save(JenisBiaya j);
    void delete (JenisBiaya j);
    JenisBiaya findJenisBiayaById(String id); 
    Page<JenisBiaya> findAllJenisBiaya(Pageable pageable);
    Long countAllJenisBiaya();
    
    void save(KonfigurasiTagihan k);
    void delete (KonfigurasiTagihan k);
    KonfigurasiTagihan findKonfigurasiTagihanById(String id); 
    Page<KonfigurasiTagihan> findAllKonfigurasiTagihan(Pageable pageable);
    Long countAllKonfigurasiTagihan();
    
    void save(TagihanDetail t);
    void delete (TagihanDetail t);
    TagihanDetail findTagihanDetailById(String id); 
    Page<TagihanDetail> findAllTagihanDetail(Pageable pageable);
    Long countAllTagihanDetail();
    
     void save(PembayaranDetail pd);
    void delete (PembayaranDetail pd);
    PembayaranDetail findPembayaranDetailById(String id); 
    Page<PembayaranDetail> findAllPembayaranDetail(Pageable pageable);
    Long countAllPembayaranDetail();
}
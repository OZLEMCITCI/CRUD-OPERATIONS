package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Kisi;
import repository.KisilerRepository;

@Service
public class KisiService {
	
	private KisilerRepository kisiRepo;
	
	@Autowired
	public KisiService(KisilerRepository kisiRepo) {
		this.kisiRepo=kisiRepo;
	}
	
	public List<Kisi> tumKisileriGetir(){
		
		return kisiRepo.findAll();
	}
	
	public Kisi kisiekle(Kisi kisi) {
		kisiRepo.save(kisi);
		return kisi;
	}
	public Optional<Kisi> idIleKisigetirenkisi(Integer id) {
		
		return kisiRepo.findById(id);// optinal dondurmesi demek bisey bulursa kisi donderecek yoksa optinal null donmesini engelliyor
	}
	
	public String idIleKisiSil(Integer id) {
		if(kisiRepo.findById(id)==null) {
			throw new IllegalStateException(id+"li kisi bulunamadi");
		}else {
			kisiRepo.deleteById(id);
			return id +"li kisi silindi";
		}
	}
	
	public Kisi  idIleKisiGuncelle(Integer id,Kisi guncelKisi) {
		
		Kisi eskiKisi=kisiRepo.findById(id).orElseThrow(()-> new IllegalStateException(id+"kisi olmadigi icin update dilemez"));
		
		eskiKisi.setAd(guncelKisi.getAd());
		eskiKisi.setSoyad(guncelKisi.getSoyad());
		eskiKisi.setYas(guncelKisi.getYas());
		
		kisiRepo.save(eskiKisi);
		return eskiKisi;
				
	}
	
	// PATCH 
		public Kisi idIleKismiGuncelle(Integer id, Kisi yeniKisi) {
						
			Kisi eskiKisi = kisiRepo.findById(id).
				orElseThrow( () -> new IllegalStateException(id + " li kisi bulunamadi"));
						
				if(yeniKisi.getAd()!="") {
					eskiKisi.setAd(yeniKisi.getAd());
				}
					
				if(yeniKisi.getSoyad()!="") {
					eskiKisi.setSoyad(yeniKisi.getSoyad());
				}
					
				if(yeniKisi.getYas()!=0) {
					eskiKisi.setYas(yeniKisi.getYas());
				}
						
				return kisiRepo.save(eskiKisi);
			}
		


}

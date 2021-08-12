package controller;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Kisi;
import service.KisiService;

@RestController
@RequestMapping("/kisiler")//bunu ekleyip her seferinde kisiler yazmaktan kurtulabilriz Asagidaki /kisiler yazan her yeri 
//silmemiz gerekir
@CrossOrigin(origins="http://localhost:8081")
public class KisiController {
	
	public KisiService kisiService;

	@Autowired
	public KisiController(KisiService kisiService) {
				this.kisiService = kisiService;
	}
	
	@GetMapping//yukarida kisiler eklersek bunu kulliyen silip @GetMapping yazabiliriz
	public List<Kisi>  kisileriGetir() {
		return kisiService.tumKisileriGetir();
	}
	
	@PostMapping(path="/ekle")
	public Kisi yeniKisiEkle(@Validated @RequestBody Kisi kisi) {
		return kisiService.kisiekle(kisi);
	}
	
	@GetMapping("/ara/{id}")
	public Optional<Kisi> idIleKisiListele(@PathVariable("id") Integer id ) {
		 return kisiService.idIleKisigetirenkisi(id);
	}
	
	@DeleteMapping("/sil/{id}")
	public String deletebyid(@PathVariable Integer id) {
		return kisiService.idIleKisiSil(id);
	}
	
	@PutMapping("/guncelle/{id}")
	public Kisi updateAll(@PathVariable("id") Integer id, @RequestBody Kisi kisi) {
		 return kisiService.idIleKisiGuncelle(id, kisi);
	}
	
	@PatchMapping("/yenile/{id}")
	public Kisi updatesome(@PathVariable("id") Integer id, @RequestBody Kisi kisi) {
		 return kisiService.idIleKismiGuncelle(id, kisi);
	}
	

}

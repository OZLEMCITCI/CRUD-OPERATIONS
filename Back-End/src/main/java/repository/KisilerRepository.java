package repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Kisi;


@Repository
public interface KisilerRepository extends JpaRepository<Kisi,Integer> {//parametre alan interfacelere generic interface diyoruz
	//<Classname,primaryKey Type>
	
	

}

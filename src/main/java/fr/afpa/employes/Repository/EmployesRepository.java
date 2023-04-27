package fr.afpa.employes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.employes.bean.Employes;


@Repository
public interface EmployesRepository extends JpaRepository<Employes, Integer>  {

}

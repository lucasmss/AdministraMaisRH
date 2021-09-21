package com.administra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.administra.models.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer>{

	@Query("select s from Servico s join s.clientes c " +
		   "where upper( c.name ) like upper( :name ) and MONTH( s.data ) =:mes ")
	List<Servico> findByNameAndMes(
			@Param("name") String name, @Param("mes") Integer mes);


}

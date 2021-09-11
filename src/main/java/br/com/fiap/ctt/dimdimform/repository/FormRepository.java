package br.com.fiap.ctt.dimdimform.repository;

//import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ctt.dimdimform.model.Form;

public interface FormRepository extends JpaRepository<Form, Integer>
{

	Page<Form> findByEmpresaLike(String empresa, Pageable pageable);

}

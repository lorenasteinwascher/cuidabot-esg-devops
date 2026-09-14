package br.com.fiap.cuidabotesg.repository;

import br.com.fiap.cuidabotesg.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
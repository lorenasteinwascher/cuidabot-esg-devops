package br.com.fiap.cuidabotesg.repository;

import br.com.fiap.cuidabotesg.model.RelatorioEsg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelatorioEsgRepository extends JpaRepository<RelatorioEsg, Long> {

    List<RelatorioEsg> findByEmpresaId(Long empresaId);
}
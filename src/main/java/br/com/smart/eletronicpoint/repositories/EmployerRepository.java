package br.com.smart.eletronicpoint.repositories;

import br.com.smart.eletronicpoint.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface EmployerRepository extends JpaRepository<Employer, Long> {

    Employer findByEmail(String email);

    Employer findByCpf(String cpf);

    Employer findByCpfOrEmail(String cpf, String email);

}

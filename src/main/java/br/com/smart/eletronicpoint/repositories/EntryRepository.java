package br.com.smart.eletronicpoint.repositories;


import br.com.smart.eletronicpoint.entities.Entry;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@NamedQueries({
        @NamedQuery(
                name = "EntryRepository.findByEmployerId",
                query = "SELECT entry FROM Entry e WHERE e.employer.id = :employerId"
        )
})

public interface EntryRepository {
    List<Entry> findByEmployerId(@Param("employerId") Long employerId);
    Page<Entry> findByEmployerId(@Param("employerId") Long employerId, Pageable pageable);
}

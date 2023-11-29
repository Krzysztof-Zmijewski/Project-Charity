package pl.coderslab.institution;

import lombok.AllArgsConstructor;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.exception.ResourceNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class InstitutionServiceImpl implements InstitutionService{
    private InstitutionRepository institutionRepository;

    @Override
    public void add(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public Institution get(Long id) {
        return institutionRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void update(Institution institution) {
        Institution toUpdate = institutionRepository.findById(institution.getId()).orElseThrow(ResourceNotFoundException::new);
        toUpdate.setDescription(institution.getDescription());
        toUpdate.setName(institution.getName());
        institutionRepository.save(toUpdate);
    }

    @Override
    public void delete(Institution institution) {
        institutionRepository.delete(institution);
    }

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }
}

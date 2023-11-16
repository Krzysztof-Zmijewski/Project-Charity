package pl.coderslab.institution;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface InstitutionService {
    public List<Institution> findAll ();
}

package pl.coderslab.institution;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface InstitutionService {
    public void add (Institution institution);

    public Institution get (Long id);

    public void update (Institution institution);

    public void delete (Institution institution);

    public List<Institution> findAll ();
}

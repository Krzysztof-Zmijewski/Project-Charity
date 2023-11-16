package pl.coderslab.institution;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService{
    private InstitutionRepository institutionRepository;
}

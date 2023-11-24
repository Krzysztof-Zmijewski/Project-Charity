package pl.coderslab.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category get(Long id) {
        return categoryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void update(Category category) {
        categoryRepository.findById(category.getId()).orElseThrow(ResourceNotFoundException::new);
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}

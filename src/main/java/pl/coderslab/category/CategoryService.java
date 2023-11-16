package pl.coderslab.category;

import java.util.List;

public interface CategoryService {
    void create (Category category);

    Category get (Long id);

    void update (Category category);

    void delete (Long id);

    List<Category> findAll ();
}

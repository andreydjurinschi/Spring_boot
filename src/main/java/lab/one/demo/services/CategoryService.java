package lab.one.demo.services;
import lab.one.demo.dtos.CategoryDto;
import lab.one.demo.entities.Category;
import lab.one.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryDto mapToDto(Category category){
        return new CategoryDto(category.getId(), category.getName());
    }
    private Category mapToEntity(CategoryDto categoryDto){
        return new Category(categoryDto.getName());
    }

    public List<CategoryDto> getAll(){
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> dtos = new ArrayList<>();
        for(Category cat : categories){
            dtos.add(mapToDto(cat));
        }
        return dtos;
    }

    public CategoryDto createCategory(CategoryDto categoryDto){
        Category category = mapToEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return mapToDto(savedCategory);
    }
}

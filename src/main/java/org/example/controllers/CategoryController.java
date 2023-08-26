package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.category.CategoryCreateDTO;
import org.example.dto.category.CategoryItemDTO;
import org.example.entities.CategoryEntity;
import org.example.mappers.CategoryMapper;
import org.example.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;
    @GetMapping("/")
    public ResponseEntity<List<CategoryItemDTO>> index(){
        var list = mapper.listCategoriesToItemDTO(categoryRepository.findAll());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/category")
    public CategoryEntity create(@RequestBody CategoryCreateDTO dto){
        CategoryEntity entity = CategoryEntity
                .builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        categoryRepository.save(entity);
        return entity;
    }
    @DeleteMapping("/category")
    public void delete(int category)
    {
        categoryRepository.deleteById(category);
    }
    @PutMapping("/category")
    public void edit(int id, @RequestBody CategoryCreateDTO dto)
    {
        CategoryEntity toEdit = categoryRepository.getById(id);
        toEdit = CategoryEntity
                .builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        categoryRepository.save(toEdit);
    }

}

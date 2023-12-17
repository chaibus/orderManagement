package softuni.restaurant.repository;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import softuni.restaurant.model.entity.CategoryEntity;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
class CategoryRepositoryTest {
    private CategoryEntity category1;
    private CategoryEntity category2;
    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        category1 = new CategoryEntity().setName("CategoryName1").setDescription("CategoryDescription1");
        category2 = new CategoryEntity().setName("CategoryName2").setDescription("CategoryDescription2");

        categoryRepository.saveAll(List.of(category1, category2));
    }

    @Test
    void deleteInBatch() {
        Long id = category1.getId();
        categoryRepository.delete(category1);
        assertFalse(categoryRepository.existsById(id));

    }

    @Test
    void existsByName() {
        assertEquals(categoryRepository.findByName("CategoryName1").get(),
                categoryRepository.findById(category1.getId()).get());
    }

    @Test
    void findAllOrderedByName() {



        List<CategoryEntity> allOrderedByName = categoryRepository.findAllOrderedByName();

        for (int i = 0; i < allOrderedByName.size()-1; i++) {
            assertEquals(allOrderedByName.get(i).getName(), allOrderedByName.get(i).getName());

        }
    }

    @Test
    void findByName() {
        assertEquals("CategoryName1", categoryRepository.findByName("CategoryName1").get().getName());
    }
}
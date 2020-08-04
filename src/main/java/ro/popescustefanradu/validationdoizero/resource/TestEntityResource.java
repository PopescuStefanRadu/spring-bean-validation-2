package ro.popescustefanradu.validationdoizero.resource;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.popescustefanradu.validationdoizero.entities.TestEntity;
import ro.popescustefanradu.validationdoizero.repositories.TestEntityRepository;

import java.sql.Types;
import java.util.List;

@RestController
@RequestMapping("test-entity")
@RequiredArgsConstructor
public class TestEntityResource {
    private final TestEntityRepository testEntityRepository;

    @GetMapping("all")
    public List<TestEntity> getAll() {
        return testEntityRepository.findAll();
    }

    @PostMapping("all")
    public void saveAll(@RequestBody List<TestEntity> testEntities) {
        testEntityRepository.saveAll(testEntities);
    }
}

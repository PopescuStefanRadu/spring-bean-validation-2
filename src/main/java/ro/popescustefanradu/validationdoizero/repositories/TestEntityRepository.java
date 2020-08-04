package ro.popescustefanradu.validationdoizero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.popescustefanradu.validationdoizero.entities.TestEntity;

public interface TestEntityRepository extends JpaRepository<TestEntity, String> {}

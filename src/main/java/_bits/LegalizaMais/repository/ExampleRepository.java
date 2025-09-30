package _bits.LegalizaMais.repository;

import _bits.LegalizaMais.domain.example.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExampleRepository extends JpaRepository<Example, UUID> {}
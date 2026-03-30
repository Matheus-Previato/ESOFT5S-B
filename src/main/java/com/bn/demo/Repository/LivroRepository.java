package com.bn.demo.Repository;

import com.bn.demo.Model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel , Long> {
}

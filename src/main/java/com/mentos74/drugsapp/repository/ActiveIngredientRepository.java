package com.mentos74.drugsapp.repository;

import com.mentos74.drugsapp.entity.ActiveIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActiveIngredientRepository extends JpaRepository<ActiveIngredient, Long> {

    List<ActiveIngredient> findByDeletedFalseOrderByUpdatedAt();

}

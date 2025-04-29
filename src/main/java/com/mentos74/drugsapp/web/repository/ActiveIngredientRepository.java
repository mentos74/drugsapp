package com.mentos74.drugsapp.web.repository;

import com.mentos74.drugsapp.web.entity.ActiveIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActiveIngredientRepository extends JpaRepository<ActiveIngredient, Long> {

    List<ActiveIngredient> findByDeletedFalseOrderByUpdatedAtDesc();

}

package com.qa.dnd.persistance.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombatRepo extends JpaRepository<Combat, Integer> {

}

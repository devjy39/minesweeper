package com.zerobase.minesweeper.repository;

import com.zerobase.minesweeper.entity.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, Long> {
    boolean existsByMail(String mail);
    Optional<Gamer> findByMail(String mail);
}

package com.example.stock.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.Vol;
@Repository
public interface VolDao extends JpaRepository<Vol, Long> {
List<Vol> findByDestination(String destination);
void deleteById(Long id);
Optional<Vol> findById(Long id);
Vol findByDestinationAndId(String destination , Long id);
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Timbua;

@Repository
public interface TimbuaRepository  extends JpaRepository<Timbua, Long>{

}

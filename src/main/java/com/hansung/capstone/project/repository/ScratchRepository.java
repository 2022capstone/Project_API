package com.hansung.capstone.project.repository;


import com.hansung.capstone.project.model.Scratch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ScratchRepository extends JpaRepository<Scratch, Integer> {

    @Query(value = "SELECT * FROM rent_scratch_count WHERE rent_id = :id",nativeQuery = true)
    Scratch getScratchByRentId(int id);


}

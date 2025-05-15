package com.Dtest.backend.repository;


import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.model.DoctorProfileDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface DoctorProfileDetailRepo extends JpaRepository<DoctorProfileDetail, String> {

    @Query("SELECT dpd FROM DoctorProfileDetail dpd WHERE dpd.code = :code")
    Optional<DoctorProfileDetail> findByCode(@Param("code") String code);

}
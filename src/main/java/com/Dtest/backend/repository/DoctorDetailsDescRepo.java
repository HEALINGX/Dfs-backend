package com.Dtest.backend.repository;

import com.Dtest.backend.model.DoctorDetailsDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DoctorDetailsDescRepo extends JpaRepository<DoctorDetailsDesc, String> {

}
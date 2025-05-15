package com.Dtest.backend.repository;

import com.Dtest.backend.model.Guarantee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuaranteeRepo extends JpaRepository<Guarantee, String> {
}

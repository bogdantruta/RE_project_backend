package com.sprinters.repository;

import com.sprinters.model.InternshipOffering;
import com.sprinters.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InternshipOfferingRepository extends JpaRepository<InternshipOffering, UUID> {
    List<InternshipOffering> findAllByOrganizationId(UUID organizationId);
}

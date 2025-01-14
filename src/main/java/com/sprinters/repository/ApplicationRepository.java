package com.sprinters.repository;

import com.sprinters.model.Application;
import com.sprinters.model.InternshipOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    List<Application> findAllByApplicantId(UUID applicantId);
    List<Application> findAllByInternshipOfferingId(UUID internshipOfferingId);
}

package com.xu.platform.persistence.lowlevel;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkItemRepo extends JpaRepositoryImplementation<LowLevelWorkItem, Long> {
}

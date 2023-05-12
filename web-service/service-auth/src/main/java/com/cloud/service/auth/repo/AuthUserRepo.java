package com.cloud.service.auth.repo;

import com.cloud.service.auth.entity.AuthUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 用户 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthUserRepo extends JpaRepositoryImplementation<AuthUser, Long> {

    @Query("""
            from auth_user
             where create between ?1 and ?2
            """)
    List<AuthUser> findAllByCreate(Date startDate, Date endDate);

}

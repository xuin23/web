package com.cloud.service.auth.repo;

import com.cloud.service.auth.entity.User;
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
public interface AuthUserRepo extends JpaRepositoryImplementation<User, Long> {

    @Query("""
            from auth_user
             where create between ?1 and ?2
             order by create desc
            """)
    List<User> findAllByCreate(Date startDate, Date endDate);


}

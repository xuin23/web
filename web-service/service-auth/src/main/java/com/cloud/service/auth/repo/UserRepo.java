package com.cloud.service.auth.repo;

import com.cloud.service.auth.entity.T_User;
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
public interface UserRepo extends JpaRepositoryImplementation<T_User, Long> {

    @Query("""
            from t_user
            where c_create between ?1 and ?2
            order by c_create desc
            """)
    List<T_User> findAllByCreate(Date startDate, Date endDate);


}
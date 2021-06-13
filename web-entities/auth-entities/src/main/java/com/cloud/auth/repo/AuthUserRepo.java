package com.cloud.auth.repo;

import com.cloud.entity.AuthUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthUserRepo extends JpaRepositoryImplementation<AuthUser, Long> {

    /**
     * 根据Email查询用户消息
     *
     * @param email email
     * @return List<AuthUser>
     */
    @Query("""
            select t from auth_user t
            where
            t.email=:email
            """)
    List<AuthUser> findByEmail(String email);

}

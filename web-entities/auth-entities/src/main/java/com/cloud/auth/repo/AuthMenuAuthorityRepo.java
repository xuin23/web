package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthMenuAuthority;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 权限菜单关联 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthMenuAuthorityRepo extends JpaRepositoryImplementation<AuthMenuAuthority, Long> {

}

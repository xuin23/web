package com.cloud.auth.repo;

import com.cloud.auth.entity.AuthMenu;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * 菜单 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthMenuRepo extends JpaRepositoryImplementation<AuthMenu, Long> {

}

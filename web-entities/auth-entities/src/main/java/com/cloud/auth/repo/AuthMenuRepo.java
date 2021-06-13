package com.cloud.auth.repo;

import com.cloud.entity.AuthMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 菜单 repo
 *
 * @author xulijian
 */
@Repository
public interface AuthMenuRepo extends JpaRepository<AuthMenu, Long> {

}

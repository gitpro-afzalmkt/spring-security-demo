package com.example.secdemo.DBAuth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionMappingRepository extends JpaRepository<RolePermissionMapping, Long> {

    @Query(nativeQuery = true, value = "select permission_id from role_perm where role_id = ?")
    List<Long> findPermissionByRole(Long roleId);

}

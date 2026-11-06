package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAccount;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectSupplierAccountDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectSupplierAccountMapper extends BaseMapper<ProjectSupplierAccount> {
   List<ProjectSupplierAccountDO> selectSubSupplier(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId);
}

package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.SubBusiness;
import com.hzchum.scim.project.core.api.pojo.dao.SubBusinessDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubBusinessMapper extends BaseMapper<SubBusiness> {
   List<SubBusinessDO> listByCondition(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("supplierId") Long supplierId);
}

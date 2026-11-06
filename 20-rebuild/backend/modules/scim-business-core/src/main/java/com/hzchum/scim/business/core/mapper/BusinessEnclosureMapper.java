package com.hzchum.scim.business.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.business.core.api.pojo._do.EnclosureSummaryDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessEnclosureMapper extends BaseMapper<BusinessEnclosure> {
   List<EnclosureSummaryDO> summary(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId);
}

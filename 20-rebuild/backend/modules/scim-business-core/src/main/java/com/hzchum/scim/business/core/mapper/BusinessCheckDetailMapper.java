package com.hzchum.scim.business.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.business.core.api.pojo._do.BusinessCheckDetailDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessCheckDetailMapper extends BaseMapper<BusinessCheckDetail> {
   List<BusinessCheckDetailDO> listByCheckId(@Param("checkId") Long checkId, @Param("projectType") Integer projectType, @Param("type") Integer type);
}

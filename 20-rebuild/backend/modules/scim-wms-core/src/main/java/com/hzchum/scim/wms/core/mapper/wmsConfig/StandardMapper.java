package com.hzchum.scim.wms.core.mapper.wmsConfig;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Standard;
import org.apache.ibatis.annotations.Select;

public interface StandardMapper extends BaseMapper<Standard> {
   @Select("select code from wms_standard ORDER BY code desc limit 1")
   Integer getMaxCode();
}

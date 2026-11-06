package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysCostingConfig;
import org.apache.ibatis.annotations.Select;

public interface SysCostingConfigMapper extends BaseMapper<SysCostingConfig> {
   @Select("<script>SELECT * FROM sys_costing_config order by id asc limit 1</script>")
   SysCostingConfig findCostingConfig();
}

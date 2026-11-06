package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesMachineToolConfig;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesMachineToolConfigDTO;
import java.util.List;

public interface MesMachineToolConfigMapper extends BaseMapper<MesMachineToolConfig> {
   List<MesMachineToolConfigDTO> findMachineToolConfigList();
}

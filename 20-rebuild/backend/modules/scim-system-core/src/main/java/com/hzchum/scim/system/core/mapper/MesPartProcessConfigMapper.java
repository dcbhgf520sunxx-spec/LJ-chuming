package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesPartProcessConfig;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesPartProcessConfigDTO;
import java.util.List;

public interface MesPartProcessConfigMapper extends BaseMapper<MesPartProcessConfig> {
   List<MesPartProcessConfigDTO> listInfo();
}

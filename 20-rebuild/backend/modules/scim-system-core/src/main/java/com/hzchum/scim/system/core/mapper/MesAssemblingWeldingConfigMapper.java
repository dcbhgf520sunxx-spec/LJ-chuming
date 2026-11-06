package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesAssemblingWeldingConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesAssemblingWeldingConfigDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesAssemblingWeldingConfigMapper extends BaseMapper<MesAssemblingWeldingConfig> {
   List<MesAssemblingWeldingConfigDTO> listInfo();

   MesAssemblingWeldingConfigDTO detailById(@Param("id") Long id);

   List<MesAssemblingWeldingConfigDTO> listInfoByIds(@Param("idList") List<Long> idList);
}

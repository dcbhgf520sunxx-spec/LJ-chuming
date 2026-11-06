package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesGroupWeldingConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesGroupWeldingConfigDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesGroupWeldingConfigMapper extends BaseMapper<MesGroupWeldingConfig> {
   List<MesGroupWeldingConfigDTO> listInfo();

   MesGroupWeldingConfigDTO detailById(@Param("id") Long id);

   List<MesGroupWeldingConfigDTO> listInfoByIds(@Param("idList") List<Long> idList);
}

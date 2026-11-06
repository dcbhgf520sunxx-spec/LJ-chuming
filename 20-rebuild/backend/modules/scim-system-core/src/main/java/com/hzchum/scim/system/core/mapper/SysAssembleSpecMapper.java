package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpec;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleSpecConfigDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleSpecDTOParam;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface SysAssembleSpecMapper extends BaseMapper<SysAssembleSpec> {
   List<AssembleSpecDTOParam> selectByCondition(
      @Param("assembleConfigId") Long assembleConfigId, @Param("specPrefix") String specPrefix, @Param("mesProductEnum") Integer mesProductEnum
   );

   List<AssembleSpecConfigDTOParam> getAssembleConfigToSpec(@Param("assembleConfigIds") Set<Long> assembleConfigIds);
}

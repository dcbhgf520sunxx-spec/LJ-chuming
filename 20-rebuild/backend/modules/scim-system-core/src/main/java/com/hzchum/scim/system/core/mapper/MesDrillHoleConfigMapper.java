package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesDrillHoleConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesDrillHoleConfigDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesDrillHoleConfigMapper extends BaseMapper<MesDrillHoleConfig> {
   List<MesDrillHoleConfigDTO> listInfo(@Param("statisticsConfigStatisticsMode") Integer statisticsConfigStatisticsMode);

   MesDrillHoleConfigDTO detailById(@Param("id") Long id);

   List<MesDrillHoleConfigDTO> listInfoByIds(@Param("idList") List<Long> idList);
}

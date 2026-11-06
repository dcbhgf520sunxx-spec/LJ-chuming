package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesLayingOffConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesLayingOffConfigDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesLayingOffConfigMapper extends BaseMapper<MesLayingOffConfig> {
   List<MesLayingOffConfigDTO> listInfo(@Param("statisticsConfigStatisticsMode") Integer statisticsConfigStatisticsMode);

   MesLayingOffConfigDTO detailById(@Param("id") Long id);

   List<MesLayingOffConfigDTO> listInfoByIds(@Param("idList") List<Long> idList);
}

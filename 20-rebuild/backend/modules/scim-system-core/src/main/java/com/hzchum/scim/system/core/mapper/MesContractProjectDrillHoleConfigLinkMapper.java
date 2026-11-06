package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectDrillHoleConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectDrillHoleConfigLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesContractProjectDrillHoleConfigLinkMapper extends BaseMapper<MesContractProjectDrillHoleConfigLink> {
   List<MesContractProjectDrillHoleConfigLinkDTO> listInfo(
      @Param("projectId") Long projectId, @Param("statisticsConfigStatisticsMode") Integer statisticsConfigStatisticsMode
   );

   List<MesContractProjectDrillHoleConfigLinkDTO> listInfoByIds(@Param("idList") List<Long> idList);

   MesContractProjectDrillHoleConfigLinkDTO detailById(@Param("id") Long id);
}

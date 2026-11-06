package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectStatisticsConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectStatisticsConfigLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesContractProjectStatisticsConfigLinkMapper extends BaseMapper<MesContractProjectStatisticsConfigLink> {
   List<MesContractProjectStatisticsConfigLinkDTO> listInfo(
      @Param("statisticsMode") Integer statisticsMode, @Param("projectNumberOrName") String projectNumberOrName
   );
}

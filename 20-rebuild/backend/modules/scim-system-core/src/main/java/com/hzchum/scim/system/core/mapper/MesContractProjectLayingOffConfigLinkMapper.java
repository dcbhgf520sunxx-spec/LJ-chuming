package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectLayingOffConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectLayingOffConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectLayingOffConfigParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesContractProjectLayingOffConfigLinkMapper extends BaseMapper<MesContractProjectLayingOffConfigLink> {
   List<MesContractProjectLayingOffConfigLinkDTO> listInfo(
      @Param("projectId") Long projectId, @Param("statisticsConfigStatisticsMode") Integer statisticsConfigStatisticsMode
   );

   List<MesContractProjectLayingOffConfigLinkDTO> listInfoByThreeCondition(
      @Param("contractProjectId") Long contractProjectId,
      @Param("steelPlateTypeEnumList") List<Integer> steelPlateTypeEnumList,
      @Param("processIdList") List<Long> processIdList
   );

   List<MesContractProjectLayingOffConfigLinkDTO> listInfoByProjectIds(@Param("projectIds") List<Long> projectIds);

   List<MesContractProjectLayingOffConfigLinkDTO> listInfoByIds(@Param("idList") List<Long> idList);

   MesContractProjectLayingOffConfigLinkDTO detailById(@Param("id") Long id);

   MesContractProjectLayingOffConfigLinkDTO getOneByCondition(@Param("param") MesContractProjectLayingOffConfigParam param);
}

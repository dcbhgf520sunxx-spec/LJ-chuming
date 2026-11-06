package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectBoltSleeveLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectBoltSleeveLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesContractProjectBoltSleeveLinkMapper extends BaseMapper<MesContractProjectBoltSleeveLink> {
   List<MesContractProjectBoltSleeveLinkDTO> selectListInfo(@Param("projectId") Long projectId);

   Boolean isTypeExistence(@Param("id") Long id, @Param("contractProjectId") Long contractProjectId, @Param("typeList") List<String> typeList);

   List<MesContractProjectBoltSleeveLinkDTO> listInfoByCondition(@Param("processId") Long processId, @Param("contractProjectIds") List<Long> contractProjectIds);

   MesContractProjectBoltSleeveLinkDTO detailById(@Param("id") Long id);

   MesContractProjectBoltSleeveLinkDTO getOneByCondition(
      @Param("projectId") Long projectId, @Param("typeName") String typeName, @Param("processId") Long processId
   );
}

package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectAssemblingWeldingConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectAssemblingWeldingConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectAssemblingWeldingConfig;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesContractProjectAssemblingWeldingConfigLinkMapper extends BaseMapper<MesContractProjectAssemblingWeldingConfigLink> {
   List<MesContractProjectAssemblingWeldingConfigLinkDTO> listInfo(@Param("projectId") Long projectId);

   List<MesContractProjectAssemblingWeldingConfigLinkDTO> listInfoByProjectIds(@Param("projectIds") List<Long> projectIds);

   List<MesContractProjectAssemblingWeldingConfigLinkDTO> listInfoByIds(@Param("idList") List<Long> idList);

   MesContractProjectAssemblingWeldingConfigLinkDTO detailById(@Param("id") Long id);

   MesContractProjectAssemblingWeldingConfigLinkDTO getOneByCondition(@Param("param") MesContractProjectAssemblingWeldingConfig param);
}

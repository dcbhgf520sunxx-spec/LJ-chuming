package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectGroupWeldingConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectGroupWeldingConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectGroupWeldingConfigParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesContractProjectGroupWeldingConfigLinkMapper extends BaseMapper<MesContractProjectGroupWeldingConfigLink> {
   List<MesContractProjectGroupWeldingConfigLinkDTO> listInfo(@Param("projectId") Long projectId);

   List<MesContractProjectGroupWeldingConfigLinkDTO> listInfoByProjectIds(@Param("projectIds") List<Long> projectIds);

   List<MesContractProjectGroupWeldingConfigLinkDTO> listInfoByIds(@Param("idList") List<Long> idList);

   MesContractProjectGroupWeldingConfigLinkDTO detailById(@Param("id") Long id);

   MesContractProjectGroupWeldingConfigLinkDTO getOneByCondition(@Param("param") MesContractProjectGroupWeldingConfigParam param);
}

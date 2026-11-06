package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectCoatingConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectCoatingConfigLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesContractProjectCoatingConfigLinkMapper extends BaseMapper<MesContractProjectCoatingConfigLink> {
   List<MesContractProjectCoatingConfigLinkDTO> listInfo(@Param("projectId") Long projectId);

   Boolean artifactClassificationIsExist(
      @Param("id") Long id, @Param("contractProjectId") Long contractProjectId, @Param("artifactClassificationIdList") List<Long> artifactClassificationIdList
   );

   List<MesContractProjectCoatingConfigLinkDTO> listInfoByContractProjectIds(@Param("contractProjectIds") List<Long> contractProjectIds);

   MesContractProjectCoatingConfigLinkDTO detailById(@Param("id") Long id);
}

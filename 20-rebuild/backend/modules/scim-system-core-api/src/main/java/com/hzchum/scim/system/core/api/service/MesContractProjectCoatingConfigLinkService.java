package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectCoatingConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectCoatingConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectCoatingConfigLinkSaveDTOParam;
import java.util.List;

public interface MesContractProjectCoatingConfigLinkService extends IService<MesContractProjectCoatingConfigLink> {
   List<MesContractProjectCoatingConfigLinkDTO> listInfo(Long projectId);

   Boolean saveContractProjectCoatingConfigLink(Long contractProjectId);

   List<MesContractProjectCoatingConfigLinkDTO> listInfoByContractProjectIds(List<Long> contractProjectIds);

   MesContractProjectCoatingConfigLinkDTO detailById(Long id);

   Boolean saveConfig(MesContractProjectCoatingConfigLinkSaveDTOParam param);

   Boolean updateConfig(MesContractProjectCoatingConfigLinkSaveDTOParam param);

   Boolean updateStatus(Long id, Boolean status);

   Boolean deleteById(Long id);
}

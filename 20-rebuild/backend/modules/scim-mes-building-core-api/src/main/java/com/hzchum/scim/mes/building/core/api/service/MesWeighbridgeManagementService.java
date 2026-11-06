package com.hzchum.scim.mes.building.core.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.device.MesWeighbridgeManagement;
import com.hzchum.scim.mes.building.core.api.pojo._dto.device.MesWeighbridgeManagementDTO;

public interface MesWeighbridgeManagementService extends IService<MesWeighbridgeManagement> {
   Boolean saveConfig(MesWeighbridgeManagementDTO dto);

   Boolean updateConfig(MesWeighbridgeManagement dto);

   Page<MesWeighbridgeManagementDTO> pageList(String name, String status, int pageNum, int pageSize);

   boolean updateStatus(Long id, Boolean status);
}

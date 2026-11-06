package com.hzchum.scim.iot.core.api.service.equiment;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.WeighingScaleEquipmentInfo;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.WeighingScaleEquipmentInfoDTO;
import java.util.List;

public interface WeighingScaleEquipmentInfoService extends IService<WeighingScaleEquipmentInfo> {
   List<WeighingScaleEquipmentInfoDTO> findMaterialDeviceList();

   Boolean updateConfig(WeighingScaleEquipmentInfo dto);

   Boolean saveConfig(WeighingScaleEquipmentInfoDTO dto);

   Page<WeighingScaleEquipmentInfoDTO> pageList(String name, String status, int pageNum, int pageSize);

   boolean updateStatus(Long id, Boolean status);
}

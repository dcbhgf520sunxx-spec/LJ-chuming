package com.hzchum.scim.mes.building.core.service.impl.machine_part_raw_material;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.machine_part_raw_material.MesMachinePartRawMaterialFeedingRecord;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.machine_part_raw_material.MachinePartReportRawMaterialFeedingRecordParam;
import com.hzchum.scim.mes.building.core.api.service.machine_part_raw_material.MesMachinePartRawMaterialFeedingRecordService;
import com.hzchum.scim.mes.building.core.mapper.machine_part_raw_material.MesMachinePartRawMaterialFeedingRecordMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesMachinePartRawMaterialFeedingRecordServiceImpl
   extends ServiceImpl<MesMachinePartRawMaterialFeedingRecordMapper, MesMachinePartRawMaterialFeedingRecord>
   implements MesMachinePartRawMaterialFeedingRecordService {
   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean machinePartReportBatchAdd(List<MachinePartReportRawMaterialFeedingRecordParam> recordParamList) {
      Long currentUserId = UserUtil.getCurrentUserId();
      List<MesMachinePartRawMaterialFeedingRecord> list = recordParamList.stream().map(i -> {
         MesMachinePartRawMaterialFeedingRecord record = BeanUtil.toBean(i, MesMachinePartRawMaterialFeedingRecord.class);
         record.setCreateUserId(currentUserId);
         return record;
      }).collect(Collectors.toList());
      this.saveBatch(list);
      return true;
   }
}

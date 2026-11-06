package com.hzchum.scim.mes.building.core.service.impl.warehouse;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingSinglePartArtifactPrintRecord;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SingPringReportDTO;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingSinglePartArtifactPrintRecordService;
import com.hzchum.scim.mes.building.core.mapper.warehouse.MesBuildingSinglePartArtifactPrintRecordMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingSinglePartArtifactPrintRecordServiceImpl
   extends ServiceImpl<MesBuildingSinglePartArtifactPrintRecordMapper, MesBuildingSinglePartArtifactPrintRecord>
   implements MesBuildingSinglePartArtifactPrintRecordService {
   @Override
   public List<SingPringReportDTO> listRecord(Long productId, Long workshopId) {
      return this.baseMapper.listRecord(productId, workshopId);
   }

   @Override
   public List<MesBuildingSinglePartArtifactPrintRecord> listBydata(List<NumberInfoDTO> infoDTOS) {
      return this.baseMapper.listBydata(infoDTOS);
   }
}

package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingSinglePartArtifactPrint;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartArtifactPrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartReportDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSinglePartArtifactPrintService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingSinglePartArtifactPrintMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingSinglePartArtifactPrintServiceImpl
   extends ServiceImpl<MesBuildingSinglePartArtifactPrintMapper, MesBuildingSinglePartArtifactPrint>
   implements MesBuildingSinglePartArtifactPrintService {
   @Override
   public List<SinglePartArtifactPrintDTO> getPrintList(
      Integer printType, List<Long> projectIds, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      return this.baseMapper.getPrintList(printType, projectIds, projectId, monomerId, areaId, serialNumber);
   }

   @Override
   public List<SinglePartArtifactPrintDTO> record(
      Long singId, List<Long> projectIds, Long projectId, Long monomerId, Long areaId, String serialNumber, String userName
   ) {
      return this.baseMapper.record(singId, projectIds, projectId, monomerId, areaId, serialNumber, userName);
   }

   @Override
   public List<MesBuildingSinglePartArtifactPrint> listByProductIds(List<SinglePartReportDTO> singlePartReportDTOS) {
      return this.baseMapper.listByProductIds(singlePartReportDTOS);
   }

   @Override
   public List<MesBuildingSinglePartArtifactPrint> listBydata(List<NumberInfoDTO> numberInfoDTOS) {
      return this.baseMapper.listBydata(numberInfoDTOS);
   }
}

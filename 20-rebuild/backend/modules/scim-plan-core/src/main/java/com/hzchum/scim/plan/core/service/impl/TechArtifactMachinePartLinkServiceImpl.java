package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.ArtifactAssociationCount;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.mapper.TechArtifactMachinePartLinkMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TechArtifactMachinePartLinkServiceImpl
   extends ServiceImpl<TechArtifactMachinePartLinkMapper, TechArtifactMachinePartLink>
   implements TechArtifactMachinePartLinkService {
   private static final Logger log = LoggerFactory.getLogger(TechArtifactMachinePartLinkServiceImpl.class);

   @Override
   public List<TechArtifactDTO> listArtifactPartByConditions(
      Long areaId,
      Long areaBatchId,
      String name,
      String serialNumber,
      String specification,
      String material,
      String machinePartSerialNumber,
      Long userId,
      String assembleSerialNumber,
      Integer permissionCheck,
      List<LocalDateTime> dateTimeList,
      String userName
   ) {
      return this.baseMapper
         .selectArtifactPartByConditions(
            areaId,
            areaBatchId,
            name,
            serialNumber,
            specification,
            material,
            machinePartSerialNumber,
            userId,
            assembleSerialNumber,
            permissionCheck,
            dateTimeList,
            userName
         );
   }

   @Override
   public List<ArtifactAssociationCount> getArtifactPartConvertCounts(List<Long> artifactId) {
      return this.baseMapper.getArtifactPartConvertCounts(artifactId);
   }
}

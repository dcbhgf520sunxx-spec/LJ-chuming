package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactProcessFileLink;
import com.hzchum.scim.plan.core.api.service.TechArtifactProcessFileLinkService;
import com.hzchum.scim.plan.core.mapper.TechArtifactProcessFileLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechArtifactProcessFileLinkServiceImpl
   extends ServiceImpl<TechArtifactProcessFileLinkMapper, TechArtifactProcessFileLink>
   implements TechArtifactProcessFileLinkService {
   @Override
   public List<TechArtifactProcessFileLink> listByCondition(
      Long processFileId, Long projectId, Long monomerId, Long structureClassId, String name, String serialNumber, String specification, String material
   ) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(TechArtifactProcessFileLink.class)
               .eq(processFileId != null, TechArtifactProcessFileLink::getProcessFileId, processFileId)
               .eq(projectId != null, TechArtifactProcessFileLink::getProjectId, projectId)
               .eq(monomerId != null, TechArtifactProcessFileLink::getMonomerId, monomerId)
               .eq(structureClassId != null, TechArtifactProcessFileLink::getStructureClassId, structureClassId)
               .like(name != null, TechArtifactProcessFileLink::getName, name)
               .like(serialNumber != null, TechArtifactProcessFileLink::getSerialNumber, serialNumber)
               .like(specification != null, TechArtifactProcessFileLink::getSpecification, specification)
               .like(material != null, TechArtifactProcessFileLink::getMaterial, material)
         );
   }
}

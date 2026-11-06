package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAssembleSaveNestingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.ArtifactAssociationCount;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.mapper.TechAssembleDetailMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechAssembleDetailServiceImpl extends ServiceImpl<TechAssembleDetailMapper, TechAssembleDetail> implements TechAssembleDetailService {
   @Override
   public List<TechAssembleSaveNestingDTO> listNestingDetail(List<Long> ids, Integer productionLineTypeEnum) {
      return this.baseMapper.listNestingDetail(ids, productionLineTypeEnum);
   }

   @Override
   public List<ArtifactAssociationCount> getArtifactPartConvertCounts(List<Long> artifactId) {
      return this.baseMapper.getArtifactPartConvertCounts(artifactId);
   }
}

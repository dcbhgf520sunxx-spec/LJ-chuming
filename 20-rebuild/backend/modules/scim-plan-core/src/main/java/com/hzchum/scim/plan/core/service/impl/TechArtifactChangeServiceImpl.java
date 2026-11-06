package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactChange;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactChangeQueryDtoParam;
import com.hzchum.scim.plan.core.api.service.TechArtifactChangeService;
import com.hzchum.scim.plan.core.mapper.TechArtifactChangeMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechArtifactChangeServiceImpl extends ServiceImpl<TechArtifactChangeMapper, TechArtifactChange> implements TechArtifactChangeService {
   @Override
   public List<TechArtifactChangeDTO> listByCondition(TechArtifactChangeQueryDtoParam param) {
      return this.baseMapper.selectByCondition(param);
   }

   @Override
   public List<TechArtifactChangeDTO> warehousingListByCondition(TechArtifactChangeQueryDtoParam param) {
      return this.baseMapper.warehousingListByCondition(param);
   }

   @Override
   public List<TechArtifactChange> listNewChanges(
      Long projectId, Long monomerId, Long areaId, String name, String serialNumber, String specification, LocalDateTime startDate, LocalDateTime endDate
   ) {
      return this.baseMapper.listNewChanges(projectId, monomerId, areaId, name, serialNumber, specification, startDate, endDate);
   }
}

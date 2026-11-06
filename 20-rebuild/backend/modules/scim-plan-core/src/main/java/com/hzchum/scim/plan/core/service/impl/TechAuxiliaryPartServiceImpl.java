package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryPart;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechAuxiliaryPartQueryDTOParam;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryPartService;
import com.hzchum.scim.plan.core.mapper.TechAuxiliaryPartMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechAuxiliaryPartServiceImpl extends ServiceImpl<TechAuxiliaryPartMapper, TechAuxiliaryPart> implements TechAuxiliaryPartService {
   @Override
   public List<TechAuxiliaryPartDTO> listAuxiliaryPart(TechAuxiliaryPartQueryDTOParam param) {
      return this.baseMapper.selectAuxiliaryPartList(param);
   }

   @Override
   public List<TechAuxiliaryPartSummaryDTO> listAuxiliaryPartSummary(Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.selectAuxiliaryPartSummary(projectId, monomerId, areaId);
   }
}

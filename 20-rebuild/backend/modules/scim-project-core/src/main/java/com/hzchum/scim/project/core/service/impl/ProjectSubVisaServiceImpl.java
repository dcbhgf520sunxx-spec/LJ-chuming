package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSubVisa;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubVisaDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectSubVisaQueryDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectSubVisaService;
import com.hzchum.scim.project.core.mapper.ProjectSubVisaMapper;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectSubVisaServiceImpl extends ServiceImpl<ProjectSubVisaMapper, ProjectSubVisa> implements ProjectSubVisaService {
   @Override
   public List<ProjectSubVisaDTO> listSubVisa(ProjectSubVisaQueryDTOParam param) {
      return this.baseMapper.selectByCondition(param);
   }

   @Override
   public BigDecimal getSumVisaAmount(Long subcontractOrderId) {
      List<ProjectSubVisa> visaList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ProjectSubVisa.class)
               .eq(ProjectSubVisa::getSubcontractOrderId, subcontractOrderId)
               .eq(ProjectSubVisa::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      return visaList.stream().map(ProjectSubVisa::getVisaAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
   }
}

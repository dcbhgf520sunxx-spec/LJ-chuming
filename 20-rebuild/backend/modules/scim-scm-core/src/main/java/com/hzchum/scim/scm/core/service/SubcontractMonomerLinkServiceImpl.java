package com.hzchum.scim.scm.core.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.scm.core.api.common.ScmConstants;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractMonomerLink;
import com.hzchum.scim.scm.core.api.pojo.dto.SubOrderMonomerDTO;
import com.hzchum.scim.scm.core.api.service.SubcontractMonomerLinkService;
import com.hzchum.scim.scm.core.mapper.SubcontractMonomerLinkMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SubcontractMonomerLinkServiceImpl
   extends ServiceImpl<SubcontractMonomerLinkMapper, SubcontractMonomerLink>
   implements SubcontractMonomerLinkService {
   @Override
   public List<SubOrderMonomerDTO> listByCondition(Long projectId, Long supplierId, Long subcontractClassId) {
      return this.baseMapper.listByCondition(projectId, supplierId, subcontractClassId);
   }

   @Override
   public List<SupplierInfo> listByMonomerId(Long monomerId) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SubcontractMonomerLink.class)
               .eq(SubcontractMonomerLink::getMonomerId, monomerId)
               .eq(SubcontractMonomerLink::getSubcontractClassId, ScmConstants.LABOR_SUB_ID)
               .eq(SubcontractMonomerLink::getBoolSettlementStatus, false)
         )
         .stream()
         .map(s -> SupplierInfo.builder().supplierId(s.getSupplierId()).supplierName(s.getSupplierName()).build())
         .collect(Collectors.toList());
   }
}

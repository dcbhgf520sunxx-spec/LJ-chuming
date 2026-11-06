package com.hzchum.scim.scm.core.service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDtoParamV2;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.scm.core.mapper.SubcontractOrderMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SubcontractOrderServiceImpl extends ServiceImpl<SubcontractOrderMapper, SubcontractOrder> implements SubcontractOrderService {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private SupplierService supplierService;

   @Override
   public List<SubcontractOrderDTO> listSubcontractOrder(SubcontractOrderQueryDTOParam param) {
      return this.baseMapper.selectSubcontractOrder(param);
   }

   @Override
   public List<SubcontractOrder> getPageList(SubcontractOrderQueryDtoParamV2 param) {
      return this.baseMapper.getPageList(param);
   }

   @Override
   public ListVO<ProjectInfo> getProjectLedger(Long projectManagerId) {
      List<SubcontractOrder> subcontractOrders = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .ne(SubcontractOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .eq(SubcontractOrder::getProjectManagerId, projectManagerId)
         );
      if (CollectionUtils.isEmpty(subcontractOrders)) {
         return new ListVO<>();
      }

      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .in(ContractProject::getId, subcontractOrders.stream().map(SubcontractOrder::getProjectId).collect(Collectors.toList()))
         );
      return new ListVO<>(projectList.stream().map(a -> BeanUtil.copy(a, ProjectInfo.class)).collect(Collectors.toList()));
   }

   @Override
   public List<SupplierInfo> getSupplierInfo(Long projectManagerId, Long projectId) {
      List<SubcontractOrder> subcontractOrderList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .ne(SubcontractOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .eq(SubcontractOrder::getProjectId, projectId)
               .eq(SubcontractOrder::getProjectManagerId, projectManagerId)
         );
      if (CollectionUtils.isEmpty(subcontractOrderList)) {
         return new ArrayList<>();
      }

      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<Long> longList = subcontractOrderList.stream().map(SubcontractOrder::getSupplierId).distinct().collect(Collectors.toList());
      return longList.stream().map(a -> SupplierInfo.builder().supplierId(a).supplierName(supplierMap.get(a).getName()).build()).collect(Collectors.toList());
   }

   @Override
   public Map<Long, String> getContractNumber(Long projectManagerId, Long projectId, Long supplierId) {
      List<SubcontractOrder> subcontractOrderList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .ne(SubcontractOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .eq(SubcontractOrder::getProjectId, projectId)
               .eq(SubcontractOrder::getProjectManagerId, projectManagerId)
               .eq(SubcontractOrder::getSupplierId, supplierId)
               .eq(SubcontractOrder::getAuditTypeEnum, AuditStatusEnum.SUCCEED.getType())
         );
      if (CollectionUtils.isEmpty(subcontractOrderList)) {
         return new HashMap<>();
      }

      Map<Long, String> map = new HashMap<>();
      subcontractOrderList.forEach(a -> map.put(a.getId(), a.getSerialNumber()));
      return map;
   }

   @Override
   public List<SubcontractOrder> pageList(SubcontractOrderQueryDtoParamV2 param) {
      return this.baseMapper.getPageList(param);
   }
}

package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ReceiptMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.QuantityMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReconciliationDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundDetailManufacturedMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class InboundDetailManufacturedServiceImpl
   extends ServiceImpl<InboundDetailManufacturedMapper, InboundDetailManufactured>
   implements InboundDetailManufacturedService {
   @Resource
   InboundDetailManufacturedMapper inboundDetailManufacturedMapper;
   @Resource
   QueryUtilService queryUtilService;

   @Override
   public List<InboundDetailManufactured> selectList(QueryInboundManufacturedDTOParam queryDTOParam) {
      return this.inboundDetailManufacturedMapper.list(queryDTOParam);
   }

   @Override
   public List<InboundDetailManufacturedDTO> convertDetailDto(List<InboundDetailManufactured> inboundDetailManufactureds) {
      List<InboundDetailManufacturedDTO> list = new ArrayList<>();
      if (CollectionUtil.isEmpty(inboundDetailManufactureds)) {
         return list;
      }

      Set<Long> inboundManufacturedIds = new TreeSet<>();
      Set<Long> projectIds = new TreeSet<>();
      Set<Long> monomerIds = new TreeSet<>();
      Set<Long> areaIds = new TreeSet<>();
      Set<Long> purchaseIds = new TreeSet<>();
      Set<Long> workshopIds = new TreeSet<>();
      Set<Long> warehouseId = new TreeSet<>();

      for (InboundDetailManufactured inboundDetailManufactured : inboundDetailManufactureds) {
         if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getInboundManufacturedId())) {
            inboundManufacturedIds.add(inboundDetailManufactured.getInboundManufacturedId());
         }

         if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getProjectId())) {
            projectIds.add(inboundDetailManufactured.getProjectId());
         }

         if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getMonomerId())) {
            monomerIds.add(inboundDetailManufactured.getMonomerId());
         }

         if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getAreaId())) {
            areaIds.add(inboundDetailManufactured.getAreaId());
         }

         if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getPurchaseId())) {
            purchaseIds.add(inboundDetailManufactured.getPurchaseId());
         }

         if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getWorkshopId())) {
            workshopIds.add(inboundDetailManufactured.getWorkshopId());
         }

         if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getWarehouseId())) {
            warehouseId.add(inboundDetailManufactured.getWarehouseId());
         }
      }

      Map<Long, InboundManufactured> inboundManufacturedMap = this.queryUtilService.getInboundManufacturedMapByIds(inboundManufacturedIds);
      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIds);
      Map<Long, PlanMonomer> planMonomerMap = this.queryUtilService.getMonomerMapByIds(monomerIds);
      Map<Long, PlanArea> planAreaMap = this.queryUtilService.getAreaMapByIds(areaIds);
      Map<Long, PurchaseOrder> purchaseOrderMap = this.queryUtilService.getPurchaseOrderMapByIds(purchaseIds);
      Map<Long, Workshop> workshopMap = this.queryUtilService.getWorkshopMapByIds(workshopIds);
      Map<Long, Warehouse> warehouseMap = this.queryUtilService.getWarehouseMapByIds(warehouseId);

      for (InboundDetailManufactured detail : inboundDetailManufactureds) {
         InboundDetailManufacturedDTO bean = BeanUtil.toBean(detail, InboundDetailManufacturedDTO.class);
         InboundManufactured inboundManufactured = inboundManufacturedMap.get(bean.getInboundManufacturedId());
         bean.setInboundManufacturedSerialNumber(inboundManufactured.getSerialNumber());
         bean.setApplicantName(inboundManufactured.getApplicantName());
         bean.setReviewPassTime(inboundManufactured.getReviewPassTime());
         if (ObjectUtil.isNotEmpty(detail.getProjectId())) {
            ContractProject contractProject = projectMap.get(detail.getProjectId());
            bean.setProject(
               IdAndNameDTO.builder().id(contractProject.getId()).name(contractProject.getName()).serialNumber(contractProject.getSerialNumber()).build()
            );
         }

         if (ObjectUtil.isNotEmpty(detail.getMonomerId())) {
            PlanMonomer monomer = planMonomerMap.get(detail.getMonomerId());
            bean.setMonomer(IdAndNameDTO.builder().id(monomer.getId()).name(monomer.getName()).build());
         }

         if (ObjectUtil.isNotEmpty(detail.getAreaId())) {
            PlanArea area = planAreaMap.get(detail.getAreaId());
            bean.setArea(IdAndNameDTO.builder().id(area.getId()).name(area.getName()).build());
         }

         if (ObjectUtil.isNotEmpty(detail.getWorkshopId())) {
            Workshop workshop = workshopMap.get(detail.getWorkshopId());
            bean.setWorkshop(IdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
         }

         if (ObjectUtil.isNotEmpty(detail.getWarehouseId())) {
            Warehouse warehouse = warehouseMap.get(detail.getWarehouseId());
            bean.setWarehouse(IdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         }

         if (ObjectUtil.isNotEmpty(detail.getPurchaseId())) {
            PurchaseOrder purchaseOrder = purchaseOrderMap.get(detail.getPurchaseId());
            bean.setPurchaseSn(purchaseOrder.getSerialNumber());
         }

         list.add(bean);
      }

      return list;
   }

   @Override
   public QuantityMeteDTO getCountMete(Long purchaseId, List<Integer> status) {
      return this.baseMapper.getCountMete(purchaseId, status);
   }

   @Override
   public List<InboundDetailManufactured> getListByApplyPurchaseId(Long applyPurchaseId) {
      return this.baseMapper.getByApplyPurchaseId(applyPurchaseId);
   }

   @Override
   public QuantityMeteDTO getPassQuantity(Long purchaseDetailId) {
      return this.baseMapper.getPassQuantity(purchaseDetailId);
   }

   @Override
   public List<InboundDetailManufactured> selectPassDetailByPurchaseDetailIds(List<Long> purchaseDetailIds) {
      return CollectionUtil.isEmpty(purchaseDetailIds) ? new ArrayList<>() : this.baseMapper.selectPassDetailByPurchaseDetailIds(purchaseDetailIds);
   }

   @Override
   public List<InboundDetailManufactured> getInboundDetailManufacturedList(Long purchaseId, Long purchaseDetailId, Integer reviewStatus) {
      return this.baseMapper.getInboundDetailManufacturedList(purchaseId, purchaseDetailId, reviewStatus);
   }

   @Override
   public List<ReconciliationDetailDTO> orderReconciliationDetail(QueryPurchaseInboundDetailDTOParam queryDTOParam) {
      return this.baseMapper.orderReconciliationDetail(queryDTOParam);
   }

   @Override
   public List<ReceiptMeteDTO> getPurchaseRejectMete(List<Long> purchaseIds) {
      return this.baseMapper.getPurchaseRejectMete(purchaseIds);
   }
}

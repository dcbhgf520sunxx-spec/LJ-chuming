package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventoryManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMaterialManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryManufacturedService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryManufacturedMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MaterialInventoryManufacturedServiceImpl
   extends ServiceImpl<MaterialInventoryManufacturedMapper, MaterialInventoryManufactured>
   implements MaterialInventoryManufacturedService {
   @Resource
   ContractProjectService projectService;
   @Resource
   QueryUtilService queryUtilService;

   @Override
   public PageVO<MaterialInventoryManufacturedDTO> pageInfo(QueryMaterialManufacturedDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      List<MaterialInventoryManufactured> list = this.baseMapper.list(param);
      List<MaterialInventoryManufacturedDTO> materialInventoryManufacturedDTOS = this.convertDetailDto(list);
      return new PageVO<>(page, materialInventoryManufacturedDTOS);
   }

   public List<MaterialInventoryManufacturedDTO> convertDetailDto(List<MaterialInventoryManufactured> materialInventoryManufactureds) {
      List<MaterialInventoryManufacturedDTO> list = new ArrayList<>();
      if (CollectionUtil.isEmpty(materialInventoryManufactureds)) {
         return list;
      }

      Set<Long> projectIds = new TreeSet<>();
      Set<Long> monomerIds = new TreeSet<>();
      Set<Long> areaIds = new TreeSet<>();
      Set<Long> worshopId = new TreeSet<>();
      Set<Long> warehouseId = new TreeSet<>();

      for (MaterialInventoryManufactured materialInventoryManufactured : materialInventoryManufactureds) {
         if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getProjectId())) {
            projectIds.add(materialInventoryManufactured.getProjectId());
         }

         if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getMonomerId())) {
            monomerIds.add(materialInventoryManufactured.getMonomerId());
         }

         if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getAreaId())) {
            areaIds.add(materialInventoryManufactured.getAreaId());
         }

         if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getWorkshopId())) {
            worshopId.add(materialInventoryManufactured.getWorkshopId());
         }

         if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getWarehouseId())) {
            warehouseId.add(materialInventoryManufactured.getWarehouseId());
         }
      }

      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIds);
      Map<Long, PlanMonomer> planMonomerMap = this.queryUtilService.getMonomerMapByIds(monomerIds);
      Map<Long, PlanArea> planAreaMap = this.queryUtilService.getAreaMapByIds(areaIds);
      Map<Long, Workshop> workshopMap = this.queryUtilService.getWorkshopMapByIds(worshopId);
      Map<Long, Warehouse> warehouseMap = this.queryUtilService.getWarehouseMapByIds(warehouseId);

      for (MaterialInventoryManufactured detail : materialInventoryManufactureds) {
         MaterialInventoryManufacturedDTO bean = BeanUtil.toBean(detail, MaterialInventoryManufacturedDTO.class);
         if (ObjectUtil.isNotEmpty(detail.getProjectId())) {
            ContractProject contractProject = projectMap.get(detail.getProjectId());
            bean.setProject(
               IdAndNameDTO.builder().id(contractProject.getId()).name(contractProject.getShortName()).serialNumber(contractProject.getSerialNumber()).build()
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

         list.add(bean);
      }

      return list;
   }

   @Override
   public List<ProjectInfo> getProject() {
      List<Long> longs = this.baseMapper.selectProjectIds();
      return CollectionUtil.isEmpty(longs) ? null : this.projectService.listSimpleByIdList(longs);
   }
}

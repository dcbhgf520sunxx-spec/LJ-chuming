package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterial;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterialDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MoveMaterialDetailDTO;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveMaterialDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveMaterialService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveMaterialDetailMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MoveMaterialDetailServiceImpl extends ServiceImpl<MoveMaterialDetailMapper, MoveMaterialDetail> implements MoveMaterialDetailService {
   @Resource
   private MoveMaterialService moveMaterialService;
   @Resource
   private QueryUtilService queryUtilService;

   @Override
   public List<MoveMaterialDetailDTO> getMoveMaterialDetailDTO(List<Long> ids) {
      Map<Long, MoveMaterial> moveMaterialMap = this.moveMaterialService
         .listByIds(ids)
         .stream()
         .collect(Collectors.toMap(MoveMaterial::getId, Function.identity()));
      List<MoveMaterialDetail> moveMaterialDetails = this.baseMapper
         .selectList((Wrapper<MoveMaterialDetail>)new LambdaQueryWrapper<MoveMaterialDetail>().in(MoveMaterialDetail::getMoveMaterialId, ids));
      List<Long> projectIds = new ArrayList<>();
      List<Long> workshopIds = new ArrayList<>();
      List<Long> warehouseIds = new ArrayList<>();
      List<Long> classifyIds = new ArrayList<>();

      for (MoveMaterialDetail moveMaterialDetail : moveMaterialDetails) {
         if (ObjectUtil.isNotEmpty(moveMaterialDetail.getProjectId())) {
            projectIds.add(moveMaterialDetail.getProjectId());
         }

         workshopIds.add(moveMaterialDetail.getSourceWorkshopId());
         workshopIds.add(moveMaterialDetail.getDirectionWorkshopId());
         warehouseIds.add(moveMaterialDetail.getSourceWarehouseId());
         warehouseIds.add(moveMaterialDetail.getDirectionWarehouseId());
         classifyIds.add(moveMaterialDetail.getClassifyId());
      }

      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIds);
      Map<Long, Workshop> workshopMap = this.queryUtilService.getWorkshopMapByIds(workshopIds);
      Map<Long, Warehouse> warehouseMap = this.queryUtilService.getWarehouseMapByIds(warehouseIds);
      Map<Long, Measure> measureMap = this.queryUtilService.getMeasureMapByClassifyIds(classifyIds);
      List<MoveMaterialDetailDTO> moveMaterialDetailDTOS = new ArrayList<>();

      for (MoveMaterialDetail moveMaterialDetail : moveMaterialDetails) {
         MoveMaterialDetailDTO moveMaterialDetailDTO = BeanUtil.copy(moveMaterialDetail, MoveMaterialDetailDTO.class);
         moveMaterialDetailDTO.setMoveSerialNumber(moveMaterialMap.get(moveMaterialDetail.getMoveMaterialId()).getSerialNumber());
         if (ObjectUtil.isNotEmpty(moveMaterialDetail.getProjectId())) {
            moveMaterialDetailDTO.setProject(BeanUtil.copy(projectMap.get(moveMaterialDetail.getProjectId()), ProjectInfo.class));
         }

         moveMaterialDetailDTO.setSourceWorkshop(BeanUtil.copy(workshopMap.get(moveMaterialDetail.getSourceWorkshopId()), NameInfo.class));
         moveMaterialDetailDTO.setDirectionWorkshop(BeanUtil.copy(workshopMap.get(moveMaterialDetail.getDirectionWorkshopId()), NameInfo.class));
         moveMaterialDetailDTO.setSourceWarehouse(BeanUtil.copy(warehouseMap.get(moveMaterialDetail.getSourceWarehouseId()), NameInfo.class));
         moveMaterialDetailDTO.setDirectionWarehouse(BeanUtil.copy(warehouseMap.get(moveMaterialDetail.getDirectionWarehouseId()), NameInfo.class));
         moveMaterialDetailDTOS.add(moveMaterialDetailDTO);
      }

      return moveMaterialDetailDTOS;
   }
}

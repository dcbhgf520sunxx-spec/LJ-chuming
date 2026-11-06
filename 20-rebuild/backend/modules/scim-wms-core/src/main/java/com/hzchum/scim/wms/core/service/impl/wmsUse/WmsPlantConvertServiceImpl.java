package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPlantConvert;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPlantConvertDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PlantConvertDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PlantConvertDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PlantConvertDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPlantConvertService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsPlantConvertDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsPlantConvertMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class WmsPlantConvertServiceImpl extends ServiceImpl<WmsPlantConvertMapper, WmsPlantConvert> implements WmsPlantConvertService {
   @Resource
   QueryUtilImpl queryUtilService;
   @Resource
   WmsPlantConvertDetailMapper wmsPlantConvertDetailMapper;

   @Override
   public Integer getMaxDayConventNumber(LocalDateTime date) {
      return this.baseMapper.getMaxDayConventNumber(date);
   }

   @Override
   public PageVO<PlantConvertDTO> pageInfo(PlantConvertDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<WmsPlantConvert> pageInfo = PageHelper.<WmsPlantConvert>startPage(pageNumber, pageSize, s)
         .doSelectPageInfo(() -> this.baseMapper.listInfo(param));
      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMap(null);
      List<PlantConvertDTO> collect = pageInfo.getList().stream().map(convert -> {
         PlantConvertDTO convertDTO = BeanUtil.copy(convert, PlantConvertDTO.class);
         if (StrUtil.isNotBlank(convertDTO.getProjectIds())) {
            List<ProjectInfo> projectInfos = new ArrayList<>();
            List<Long> ids = Arrays.stream(convertDTO.getProjectIds().split(",")).map(String::trim)
               .filter(value -> !value.isEmpty() && !"null".equalsIgnoreCase(value)).map(Long::valueOf).collect(Collectors.toList());
            ids.forEach(projectId -> {
               ContractProject project = projectMap.get(projectId);
               if (project != null) projectInfos.add(BeanUtil.copy(project, ProjectInfo.class));
            });
            convertDTO.setProjects(projectInfos);
         }

         return convertDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(pageInfo, collect);
   }

   @Override
   public ResultVO<JSONObject> convertDetail(Long id) {
      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMap(null);
      Map<Long, Workshop> workshopMap = this.queryUtilService.getWorkshopMap(null);
      Map<Long, Warehouse> warehouseMap = this.queryUtilService.getWarehouseMap(null);
      List<WmsPlantConvertDetail> list = this.wmsPlantConvertDetailMapper
         .selectList((Wrapper<WmsPlantConvertDetail>)new LambdaQueryWrapper<WmsPlantConvertDetail>().eq(WmsPlantConvertDetail::getWmsPlantConvertId, id));
      List<WmsPlantConvertDetail> collect = list.stream().filter(convert -> convert.getWmsPlantConvertDetailId() == null).collect(Collectors.toList());
      WmsPlantConvert wmsPlantConvert = this.baseMapper.selectById(id);
      List<WmsPlantConvertDetail> convertDetails = list.stream().filter(convert -> convert.getWmsPlantConvertDetailId() != null).collect(Collectors.toList());
      List<PlantConvertDetailDTO> collect1 = collect.stream().map(convert -> {
         PlantConvertDetailDTO convertDTO = BeanUtil.copy(convert, PlantConvertDetailDTO.class);
         convertDTO.setReceiptSerialNumber(wmsPlantConvert.getReceiptSerialNumber());
         convertDTO.setTaskOrderNumber(wmsPlantConvert.getTaskOrderNumber());
         convertDTO.setReviewTime(wmsPlantConvert.getReviewTime());
         if (convertDTO.getProjectId() != null) {
            ContractProject project = projectMap.get(convertDTO.getProjectId());
            ProjectInfo copy = BeanUtil.copy(project, ProjectInfo.class);
            convertDTO.setProject(copy);
         }

         Workshop workshop = workshopMap.get(convertDTO.getWorkshopId());
         if (workshop != null) {
            convertDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
         }

         Warehouse warehouse = warehouseMap.get(convertDTO.getWarehouseId());
         if (warehouse != null) {
            convertDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         }

         List<PlantConvertDetailDTO> plantConvertDetailDTOS = cn.hutool.core.bean.BeanUtil.copyToList(convertDetails, PlantConvertDetailDTO.class);
         convertDTO.setDetailList(plantConvertDetailDTOS);
         return convertDTO;
      }).collect(Collectors.toList());
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("receiptSerialNumber", wmsPlantConvert.getReceiptSerialNumber());
      jsonObject.put("taskOrderNumber", wmsPlantConvert.getTaskOrderNumber());
      jsonObject.put("reviewTime", wmsPlantConvert.getReviewTime());
      jsonObject.put("detailList", collect1);
      return ResultBuilder.success(jsonObject);
   }
}

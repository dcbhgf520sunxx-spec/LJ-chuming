package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundDetailManufacturedMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OutboundDetailManufacturedServiceImpl
   extends ServiceImpl<OutboundDetailManufacturedMapper, OutboundDetailManufactured>
   implements OutboundDetailManufacturedService {
   @Resource
   OutboundDetailManufacturedMapper outboundDetailManufacturedMapper;
   @Resource
   QueryUtilService queryUtilService;

   @Override
   public List<OutboundDetailManufactured> selectList(QueryOutboundManufacturedDTOParam param) {
      return this.outboundDetailManufacturedMapper.list(param);
   }

   @Override
   public List<OutboundDetailManufacturedDTO> convertDetailDto(List<OutboundDetailManufactured> outboundDetailManufactureds) {
      List<OutboundDetailManufacturedDTO> list = new ArrayList<>();
      if (CollectionUtil.isEmpty(outboundDetailManufactureds)) {
         return list;
      }

      Set<Long> outboundManufacturedIds = new TreeSet<>();
      Set<Long> projectIds = new TreeSet<>();
      Set<Long> monomerIds = new TreeSet<>();
      Set<Long> areaIds = new TreeSet<>();

      for (OutboundDetailManufactured outboundDetailManufactured : outboundDetailManufactureds) {
         outboundManufacturedIds.add(outboundDetailManufactured.getOutboundManufacturedId());
         if (ObjectUtil.isNotEmpty(outboundDetailManufactured.getProjectId())) {
            projectIds.add(outboundDetailManufactured.getProjectId());
         }

         if (ObjectUtil.isNotEmpty(outboundDetailManufactured.getMonomerId())) {
            monomerIds.add(outboundDetailManufactured.getMonomerId());
         }

         if (ObjectUtil.isNotEmpty(outboundDetailManufactured.getAreaId())) {
            areaIds.add(outboundDetailManufactured.getAreaId());
         }
      }

      Map<Long, OutboundManufactured> outboundManufacturedMap = this.queryUtilService.getOutboundManufacturedMapByIds(outboundManufacturedIds);
      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIds);
      Map<Long, PlanMonomer> planMonomerMap = this.queryUtilService.getMonomerMapByIds(monomerIds);
      Map<Long, PlanArea> planAreaMap = this.queryUtilService.getAreaMapByIds(areaIds);

      for (OutboundDetailManufactured detail : outboundDetailManufactureds) {
         OutboundDetailManufacturedDTO bean = BeanUtil.toBean(detail, OutboundDetailManufacturedDTO.class);
         OutboundManufactured outboundManufactured = outboundManufacturedMap.get(detail.getOutboundManufacturedId());
         bean.setOutboundManufacturedSerialNumber(outboundManufactured.getSerialNumber());
         bean.setApplicantName(outboundManufactured.getApplicantName());
         bean.setApplicationTime(outboundManufactured.getApplicationTime());
         bean.setReviewPassTime(outboundManufactured.getReviewPassTime());
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

         list.add(bean);
      }

      return list;
   }
}

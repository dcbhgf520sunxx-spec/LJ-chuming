package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailManufacturedService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnDetailManufacturedMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ReturnDetailManufacturedServiceImpl
   extends ServiceImpl<ReturnDetailManufacturedMapper, ReturnDetailManufactured>
   implements ReturnDetailManufacturedService {
   @Resource
   private ReturnDetailManufacturedMapper returnDetailManufacturedMapper;
   @Resource
   private QueryUtilService queryUtilService;

   @Override
   public List<ReturnDetailManufactured> selectList(QueryReturnManufacturedDTOParam param) {
      return this.returnDetailManufacturedMapper.list(param);
   }

   @Override
   public List<ReturnDetailManufacturedDTO> convertDetailDto(List<ReturnDetailManufactured> returnDetailManufactureds) {
      List<ReturnDetailManufacturedDTO> list = new ArrayList<>();
      if (CollectionUtil.isEmpty(returnDetailManufactureds)) {
         return list;
      }

      Set<Long> returnManufacturedIds = new TreeSet<>();
      Set<Long> projectIds = new TreeSet<>();
      Set<Long> monomerIds = new TreeSet<>();
      Set<Long> areaIds = new TreeSet<>();

      for (ReturnDetailManufactured returnDetailManufactured : returnDetailManufactureds) {
         returnManufacturedIds.add(returnDetailManufactured.getReturnManufacturedId());
         if (ObjectUtil.isNotEmpty(returnDetailManufactured.getProjectId())) {
            projectIds.add(returnDetailManufactured.getProjectId());
         }

         if (ObjectUtil.isNotEmpty(returnDetailManufactured.getMonomerId())) {
            monomerIds.add(returnDetailManufactured.getMonomerId());
         }

         if (ObjectUtil.isNotEmpty(returnDetailManufactured.getAreaId())) {
            areaIds.add(returnDetailManufactured.getAreaId());
         }
      }

      Map<Long, ReturnManufactured> returnManufacturedMap = this.queryUtilService.getReturnManufacturedMapByIds(returnManufacturedIds);
      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIds);
      Map<Long, PlanMonomer> planMonomerMap = this.queryUtilService.getMonomerMapByIds(monomerIds);
      Map<Long, PlanArea> planAreaMap = this.queryUtilService.getAreaMapByIds(areaIds);

      for (ReturnDetailManufactured detail : returnDetailManufactureds) {
         ReturnDetailManufacturedDTO bean = BeanUtil.toBean(detail, ReturnDetailManufacturedDTO.class);
         ReturnManufactured returnManufactured = returnManufacturedMap.get(detail.getReturnManufacturedId());
         bean.setReturnManufacturedSerialNumber(returnManufactured.getSerialNumber());
         bean.setApplicantName(returnManufactured.getApplicantName());
         bean.setApplicationTime(returnManufactured.getApplicationTime());
         bean.setReviewPassTime(returnManufactured.getReviewPassTime());
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

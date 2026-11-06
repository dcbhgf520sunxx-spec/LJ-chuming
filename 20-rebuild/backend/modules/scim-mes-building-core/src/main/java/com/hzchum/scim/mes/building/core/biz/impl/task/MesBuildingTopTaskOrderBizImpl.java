package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTopTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTopTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistTopTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTopTaskOrderService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTopTaskOrderMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTopTaskOrderBizImpl
   extends IBizImpl<MesBuildingTopTaskOrderService, MesBuildingTopTaskOrderMapper, MesBuildingTopTaskOrder>
   implements MesBuildingTopTaskOrderBiz {
   @Resource
   private ContractProjectService contractProjectService;

   @Override
   public PageVO<MesBuildingAssistTopTaskOrderDTO> getTopTaskOrderAssistPage(
      LocalDateTime dateTime, Long projectId, Long monomerId, Long areaId, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new PageVO<>();
      }

      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingAssistTopTaskOrderDTO> dtoList = this.baseService
         .getTopTaskOrderAssistList(dateTime, projectIds, monomerId, areaId, serialNumber)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingAssistTopTaskOrderDTO.class))
         .collect(Collectors.toList());
      return new PageVO<>(page, dtoList);
   }

   @Override
   public List<MesBuildingAssistTopTaskOrderDTO> getTopTaskOrderAssistList(LocalDateTime dateTime, Long projectId) {
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ArrayList<>();
      }

      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      return this.baseService
         .getTopTaskOrderAssistList(dateTime, projectIds, null, null, null)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingAssistTopTaskOrderDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public int getNumber(LocalDateTime now) {
      return this.baseMapper.getNumber(now);
   }
}

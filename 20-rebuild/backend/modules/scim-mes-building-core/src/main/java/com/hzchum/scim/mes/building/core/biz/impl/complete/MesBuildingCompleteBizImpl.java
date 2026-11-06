package com.hzchum.scim.mes.building.core.biz.impl.complete;

import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.biz.complete.MesBuildingCompleteBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.complete.CompleteMeteByMonthDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.complete.CompleteProductDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingCompleteBizImpl implements MesBuildingCompleteBiz {
   @Autowired
   private MesBuildingCompleteService completeService;

   @Override
   public List<CompleteProductDTO> getTeamProduction(Long teamId, Integer productType, LocalDateTime dateTime) {
      return this.completeService
         .getTeamProduction(teamId, productType, dateTime)
         .stream()
         .map(e -> BeanUtil.copy(e, CompleteProductDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<CompleteMeteByMonthDTO> getTeamMeteByMonth(Long teamId, Integer productType, LocalDateTime dateTime) {
      return this.completeService
         .getTeamMeteByMonth(teamId, productType, dateTime)
         .stream()
         .map(e -> BeanUtil.copy(e, CompleteMeteByMonthDTO.class))
         .collect(Collectors.toList());
   }
}

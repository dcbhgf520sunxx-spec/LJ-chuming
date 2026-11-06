package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuJobDirectory;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result.MesJobMachinePartSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingBoChuJobDirectoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result.NestingResultQuery;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuJobDirectoryService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingBoChuJobDirectoryMapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingBoChuJobDirectoryServiceImpl
   extends ServiceImpl<MesBuildingBoChuJobDirectoryMapper, MesBuildingBoChuJobDirectory>
   implements MesBuildingBoChuJobDirectoryService {
   @Autowired
   private MesBuildingBoChuNestingResultService boChuNestingResultService;

   @Override
   public List<MesBuildingBoChuJobDirectoryDTO> getJobTree(NestingResultQuery query) {
      List<MesBuildingBoChuJobDirectoryDTO> list = this.baseMapper.getJobList(query);
      Map<Integer, List<MesBuildingBoChuJobDirectoryDTO>> group = list.stream().collect(Collectors.groupingBy(MesBuildingBoChuJobDirectoryDTO::getParentId));
      List<Integer> jobIdList = list.stream()
         .filter(i -> Objects.equals(i.getJobType(), 1))
         .map(MesBuildingBoChuJobDirectoryDTO::getJobId)
         .distinct()
         .collect(Collectors.toList());
      List<MesJobMachinePartSummaryDTO> jobMachinePartSummaryDTOList = this.boChuNestingResultService.jobMachinePartSummaryList(jobIdList);
      Map<Integer, MesJobMachinePartSummaryDTO> jobMachinePartSummaryDTOMap = jobMachinePartSummaryDTOList.stream()
         .collect(Collectors.toMap(MesJobMachinePartSummaryDTO::getJobId, Function.identity()));
      return list.stream()
         .peek(i -> {
            i.setChildren(group.get(i.getJobId()));
            if (Objects.equals(i.getJobType(), 1)) {
               MesJobMachinePartSummaryDTO cJobMachinePartSummaryDTO = jobMachinePartSummaryDTOMap.get(i.getJobId());
               if (cJobMachinePartSummaryDTO.getTotalQuantity().compareTo(cJobMachinePartSummaryDTO.getNestedTotalQuantity()) == 0) {
                  i.setPartSchedulingStatus(1);
               } else if (cJobMachinePartSummaryDTO.getTotalQuantity().compareTo(cJobMachinePartSummaryDTO.getNestedTotalQuantity()) > 0) {
                  i.setPartSchedulingStatus(2);
               } else if (cJobMachinePartSummaryDTO.getNestedTotalQuantity().compareTo(BigDecimal.ZERO) == 0) {
                  i.setPartSchedulingStatus(0);
               }
            }
         })
         .filter(i -> Objects.equals(i.getParentId(), -1))
         .collect(Collectors.toList())
         .stream()
         .peek(this::removeEmptyChildren)
         .filter(i -> CollUtil.isNotEmpty(i.getChildren()))
         .collect(Collectors.toList());
   }

   private void removeEmptyChildren(MesBuildingBoChuJobDirectoryDTO node) {
      if (CollUtil.isNotEmpty(node.getChildren())) {
         if (Objects.equals(node.getChildren().get(0).getJobType(), 1)) {
            return;
         }

         List<MesBuildingBoChuJobDirectoryDTO> validChildren = node.getChildren()
            .stream()
            .filter(child -> CollUtil.isNotEmpty(child.getChildren()))
            .collect(Collectors.toList());
         node.setChildren(validChildren);
         validChildren.forEach(this::removeEmptyChildren);
      }
   }
}

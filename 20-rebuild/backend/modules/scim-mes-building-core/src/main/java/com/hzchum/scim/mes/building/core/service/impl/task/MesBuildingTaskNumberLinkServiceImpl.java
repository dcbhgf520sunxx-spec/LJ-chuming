package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingAssembleExtTaskCargoDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNumberLinkMapper;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskNumberLinkServiceImpl
   extends ServiceImpl<MesBuildingTaskNumberLinkMapper, MesBuildingTaskNumberLink>
   implements MesBuildingTaskNumberLinkService {
   @Override
   public List<ArtifactStatusDTO> listProductType(List<Long> artifactIds) {
      return this.baseMapper.listProductType(artifactIds);
   }

   @Override
   public List<MesBuildingTaskNumberLink> listLinksBydata(List<NumberInfoDTO> numbers, Integer taskType) {
      int BATCH_SIZE = 50;
      List<MesBuildingTaskNumberLink> totalResult = new ArrayList<>();
      if (CollectionUtils.isEmpty(numbers)) {
         return totalResult;
      }

      int total = numbers.size();

      for (int i = 0; i < total; i += 50) {
         int end = Math.min(i + 50, total);
         List<NumberInfoDTO> subBatch = numbers.subList(i, end);
         List<MesBuildingTaskNumberLink> batchList = this.baseMapper.listLinksBydata(subBatch, taskType);
         totalResult.addAll(batchList);
      }

      return totalResult;
   }

   @Override
   public List<MesBuildingAssembleExtTaskCargoDTO> listAssembleExtWarehouseStatusList(List<NumberInfoDTO> numbers) {
      return this.baseMapper.listAssembleExtWarehouseStatusList(numbers);
   }

   @Override
   public List<MesBuildingTaskNumberLink> listNumberLinksByTaskIds(List<Long> taskIds) {
      return this.baseMapper.listNumberLinksByTaskIds(taskIds);
   }
}

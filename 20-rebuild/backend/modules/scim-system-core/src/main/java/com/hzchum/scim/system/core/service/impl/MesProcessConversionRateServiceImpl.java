package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.pojo._do.MesProcessConversionRate;
import com.hzchum.scim.system.core.api.pojo.request.MesProcessConversionRateDTO;
import com.hzchum.scim.system.core.api.pojo.vo.MesProcessConversionRateVO;
import com.hzchum.scim.system.core.api.service.MesProcessConversionRateService;
import com.hzchum.scim.system.core.mapper.MesProcessConversionRateMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesProcessConversionRateServiceImpl
   extends ServiceImpl<MesProcessConversionRateMapper, MesProcessConversionRate>
   implements MesProcessConversionRateService {
   private static final Logger log = LoggerFactory.getLogger(MesProcessConversionRateServiceImpl.class);

   @Override
   public List<MesProcessConversionRateVO> listAllMesProcessConversionRate(Long artifactClassId) {
      List<MesProcessConversionRateVO> mesProcessConversionRateVOList = this.baseMapper.listAllMesProcessConversionRate(artifactClassId);
      Map<String, MesProcessConversionRateVO> uniqueByProcessId = mesProcessConversionRateVOList.stream()
         .collect(Collectors.toMap(MesProcessConversionRateVO::getProcessIds, vo -> (MesProcessConversionRateVO)vo, (existing, replacement) -> existing));
      List<MesProcessConversionRateVO> distinctList = uniqueByProcessId.values().stream().collect(Collectors.toList());
      distinctList.forEach(mesProcessConversionRateVO -> {
         String processIds = mesProcessConversionRateVO.getProcessIds();
         String[] processIdArray = processIds.split(",");
         mesProcessConversionRateVO.setProcessIdArray(processIdArray);
      });
      return distinctList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveMesProcessConversionRate(MesProcessConversionRateDTO mesProcessConversionRateDTO) {
      List<MesProcessConversionRate> mesProcessConversionRateList = mesProcessConversionRateDTO.getMesProcessConversionRateList();
      List<MesProcessConversionRate> newMesProcessConversionRateList = new ArrayList<>();
      mesProcessConversionRateList.forEach(
         mesProcessConversionRate -> {
            String processIds = mesProcessConversionRate.getProcessIds();
            String[] processIdArray = mesProcessConversionRate.getProcessIds().split(",");
            boolean hasDuplicatesx = Arrays.stream(processIdArray).distinct().count() != processIdArray.length;
            Preconditions.checkArgument(!hasDuplicatesx, "工序不能重复");
            List<MesProcessConversionRate> mesProcessConversionRateListOld = this.list(
               (Wrapper<MesProcessConversionRate>)(new LambdaQueryWrapper<MesProcessConversionRate>()
                     .eq(MesProcessConversionRate::getArtifactClassId, mesProcessConversionRateDTO.getArtifactClassId()))
                  .in(MesProcessConversionRate::getProcessId, processIdArray)
            );
            Preconditions.checkArgument(mesProcessConversionRateListOld.size() == 0, "工序已存在");

            for (String processId : processIdArray) {
               newMesProcessConversionRateList.add(
                  MesProcessConversionRate.builder()
                     .artifactClassId(mesProcessConversionRateDTO.getArtifactClassId())
                     .conversionRate(mesProcessConversionRate.getConversionRate())
                     .processIds(processIds)
                     .processId(Long.valueOf(processId))
                     .processType(mesProcessConversionRate.getProcessType())
                     .structureType(mesProcessConversionRate.getStructureType())
                     .build()
               );
            }
         }
      );
      List<Long> collect = newMesProcessConversionRateList.stream().map(MesProcessConversionRate::getProcessId).collect(Collectors.toList());
      boolean hasDuplicates = collect.stream().distinct().count() != collect.size();
      Preconditions.checkArgument(!hasDuplicates, "工序不能重复");
      return this.saveBatch(newMesProcessConversionRateList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public String updateMesProcessConversionRate(MesProcessConversionRate mesProcessConversionRate) {
      Preconditions.checkArgument(mesProcessConversionRate.getId() != null, "id不能为空");
      MesProcessConversionRate mesProcessConversionRateOld = this.getById(mesProcessConversionRate.getId());
      String processIdsOld = mesProcessConversionRateOld.getProcessIds();
      String[] processIdArrayOld = processIdsOld.split(",");
      List<MesProcessConversionRate> mesProcessConversionRateListOld = this.list(
         (Wrapper<MesProcessConversionRate>)(new LambdaQueryWrapper<MesProcessConversionRate>()
               .eq(MesProcessConversionRate::getArtifactClassId, mesProcessConversionRate.getArtifactClassId()))
            .in(MesProcessConversionRate::getProcessId, processIdArrayOld)
      );
      mesProcessConversionRateListOld.forEach(object -> this.removeById(object.getId()));
      String processIds = mesProcessConversionRate.getProcessIds();
      String[] processIdArray = processIds.split(",");
      List<MesProcessConversionRate> mesProcessConversionRateList = this.list(
         (Wrapper<MesProcessConversionRate>)new LambdaQueryWrapper<MesProcessConversionRate>().in(MesProcessConversionRate::getProcessId, processIdArray)
      );
      Preconditions.checkArgument(mesProcessConversionRateList.size() == 0, "工序已存在");

      for (String processId : processIdArray) {
         mesProcessConversionRate.setProcessId(Long.valueOf(processId));
         mesProcessConversionRate.setProcessIds(processIds);
         mesProcessConversionRate.setStructureType(mesProcessConversionRateOld.getStructureType());
         this.save(mesProcessConversionRate);
      }

      return "工序折合完工率修改成功";
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void removeMesProcessConversionRate(List<Long> ids) {
      ids.forEach(
         id -> {
            MesProcessConversionRate mesProcessConversionRate = this.getById(id);
            String processIds = mesProcessConversionRate.getProcessIds();
            String[] processIdArray = processIds.split(",");
            List<MesProcessConversionRate> mesProcessConversionRateList = this.list(
               (Wrapper<MesProcessConversionRate>)new LambdaQueryWrapper<MesProcessConversionRate>().in(MesProcessConversionRate::getProcessId, processIdArray)
            );
            mesProcessConversionRateList.forEach(object -> this.removeById(object.getId()));
            this.removeById(id);
         }
      );
   }
}

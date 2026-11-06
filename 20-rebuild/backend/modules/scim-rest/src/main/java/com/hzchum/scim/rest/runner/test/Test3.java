package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.plan.core.api.manager.TechUtilManager;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Order(4)
public class Test3 implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(Test3.class);
   @Resource
   private TechUtilManager techUtilManager;
   @Resource
   private TechMachinePartService machinePartService;

   @Transactional
   @Override
   public void run(String... args) throws Exception {
      TechConfigUtilsDTO utilsDTO = this.techUtilManager.getTechConfigUtilsDto(BuildingTypeEnum.getMesProductTypeByType(1));
      List<TechMachinePart> partList = this.machinePartService.list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().isNull(TechMachinePart::getSteelId));
      Map<String, Long> sectionMachinePartSpecMap = utilsDTO.getSectionMachinePartSpecMap();
      Map<String, Long> machinePartSpecMap = utilsDTO.getMachinePartSpecMap();
      Map<String, Map<String, Long>> steelClassSpecNameLinkMap = utilsDTO.getSteelClassSpecNameLinkMap();
      Map<Integer, List<TechMachinePart>> partMap = partList.stream().collect(Collectors.groupingBy(TechMachinePart::getSteelPlateTypeEnum));
      partMap.forEach((type, parts) -> {
         if (type.equals(SteelPlateTypeEnum.PRIMARY_MEMBER.getType())) {
            for (TechMachinePart part : parts) {
               Long l = machinePartSpecMap.get(part.getSpecPrefix());
               part.setSteelId(l);
            }

            this.machinePartService.updateBatchById(parts);
         }

         if (type.equals(SteelPlateTypeEnum.SECTIONSTEEL.getType())) {
            for (TechMachinePart part : parts) {
               Long l = sectionMachinePartSpecMap.get(part.getSpecPrefix());
               part.setSteelId(l);
            }

            this.machinePartService.updateBatchById(parts);
         }

         if (type.equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())) {
            for (TechMachinePart part : parts) {
               Long l = steelClassSpecNameLinkMap.get(part.getSpecPrefix()).get(part.getName());
               part.setSteelId(l);
            }

            this.machinePartService.updateBatchById(parts);
         }
      });
   }

   public Test3(final TechUtilManager techUtilManager, final TechMachinePartService machinePartService) {
      this.techUtilManager = techUtilManager;
      this.machinePartService = machinePartService;
   }
}

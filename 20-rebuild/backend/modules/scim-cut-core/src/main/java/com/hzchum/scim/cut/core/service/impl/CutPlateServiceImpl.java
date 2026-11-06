package com.hzchum.scim.cut.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.cut.core.api.enums.DetailEnum;
import com.hzchum.scim.cut.core.api.pojo._do.CutMachine;
import com.hzchum.scim.cut.core.api.pojo._do.CutPlate;
import com.hzchum.scim.cut.core.api.pojo._do.CutPlatePart;
import com.hzchum.scim.cut.core.api.request.MachinePartListDTO;
import com.hzchum.scim.cut.core.api.request.MachinePlateList;
import com.hzchum.scim.cut.core.api.request.NestingList;
import com.hzchum.scim.cut.core.api.request.ProjectGuide;
import com.hzchum.scim.cut.core.api.request.TechMachinePartDTO;
import com.hzchum.scim.cut.core.api.service.CutMachineService;
import com.hzchum.scim.cut.core.api.service.CutPlatePartService;
import com.hzchum.scim.cut.core.api.service.CutPlateService;
import com.hzchum.scim.cut.core.mapper.CutPlateMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CutPlateServiceImpl extends ServiceImpl<CutPlateMapper, CutPlate> implements CutPlateService {
   @Resource
   private CutPlateService plateService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private CutPlatePartService cutPlatePartService;
   @Resource
   private CutMachineService cutMachineService;
   @Resource
   private PlanAreaService planAreaService;
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   OutboundService outboundService;
   @Resource
   private KafkaTemplate kafkaTemplate;
   @Resource
   private TechMachinePartService techMachinePartService;

   @Override
   public ResultVO getPlant(
      Long projectId,
      String projectName,
      String thick,
      String plateType,
      String importTime,
      String mac,
      String plateState,
      String material,
      String machineName,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      Long plateID
   ) {
      if (pageNumber == null) {
         pageNumber = 1;
      }

      if (pageSize == null) {
         pageSize = 50;
      }

      String s = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, s);
      LambdaQueryWrapper<CutPlate> cutPlateLambdaQueryWrapper = new LambdaQueryWrapper<>();
      cutPlateLambdaQueryWrapper.like(StrUtil.isNotBlank(projectName), CutPlate::getProjectName, projectName)
         .eq(projectId != null, CutPlate::getProjectNo, projectId)
         .eq(StrUtil.isNotBlank(importTime), CutPlate::getImportTime, importTime)
         .eq(StrUtil.isNotBlank(mac), CutPlate::getMac, mac)
         .eq(StrUtil.isNotBlank(plateState), CutPlate::getPlateState, plateState)
         .eq(StrUtil.isNotBlank(material), CutPlate::getMaterial, material)
         .eq(StrUtil.isNotBlank(machineName), CutPlate::getMachineName, machineName)
         .eq(plateID != null, CutPlate::getId, plateID);
      if (StrUtil.isNotBlank(thick)) {
         cutPlateLambdaQueryWrapper.ge(CutPlate::getThick, BigDecimal.valueOf(Long.parseLong(thick)).subtract(BigDecimal.valueOf(0.5)))
            .le(CutPlate::getThick, BigDecimal.valueOf(Long.parseLong(thick)).add(BigDecimal.valueOf(0.5)));
      }

      List<CutPlate> list = this.plateService.list(cutPlateLambdaQueryWrapper);
      return ResultBuilder.success(new PageVO<>(list));
   }

   @Override
   public ResultVO getNestingList(
      Integer pageNumber, Integer pageSize, String projectNo, String projectName, String date, List<String> sort, Integer nestingState, Integer cutState
   ) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, s);
      List<ContractProject> list = this.contractProjectService
         .list(
            ((((new LambdaQueryWrapper<ContractProject>()
                           .eq(StrUtil.isNotBlank(projectNo), ContractProject::getSerialNumber, projectNo))
                        .like(StrUtil.isNotBlank(projectName), ContractProject::getName, projectName))
                     .or())
                  .like(StrUtil.isNotBlank(projectName), ContractProject::getSerialNumber, projectName))
               .like(StrUtil.isNotBlank(date), BaseEntity::getCreateTime, date)
         );
      ArrayList<NestingList> objects = new ArrayList<>();
      list.forEach(
         contractProject -> {
            List<CutPlate> list1 = this.plateService.list((Wrapper<CutPlate>)new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getProjectNo, contractProject.getId()));
            if (CollUtil.isNotEmpty(list1)) {
               NestingList nestingList = NestingList.builder()
                  .distributionNum(0)
                  .distributionWeight(BigDecimal.valueOf(0L))
                  .partNum(0)
                  .plateWeight(BigDecimal.valueOf(0L))
                  .partWeight(BigDecimal.valueOf(0L))
                  .distributionPartNum(0)
                  .distributionPartWeight(BigDecimal.valueOf(0L))
                  .build();
               nestingList.setProjectName(contractProject.getName());
               nestingList.setProjectId(contractProject.getId());
               nestingList.setProjectNumber(contractProject.getSerialNumber());
               nestingList.setPlateNum(list1.size());
               BigDecimal cutPlateReduce = list1.stream().map(CutPlate::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
               nestingList.setPlateWeight(cutPlateReduce);
               list1.forEach(no -> {
                  List<TechMachinePart> cutPart = this.cutPlatePartService.getCutPart(no.getTaskId());
                  if (CollUtil.isNotEmpty(cutPart)) {
                     int sum = cutPart.stream().mapToInt(TechMachinePart::getQuantity).sum();
                     BigDecimal reduce = cutPart.stream().map(TechMachinePart::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
                     nestingList.setPartNum(nestingList.getPartNum() + sum);
                     nestingList.setPartWeight(nestingList.getPartWeight().add(reduce));
                     nestingList.setReportUrl(no.getPlateAllReportUrl());
                  }
               });
               List<CutPlate> list3 = this.plateService
                  .list(
                     (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getProjectNo, contractProject.getId()))
                        .eq(CutPlate::getPlateState, DetailEnum.CUT.getCode())
                  );
               nestingList.setCuttingNum(list3.size());
               List<CutPlate> list2 = this.plateService
                  .list(
                     (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getProjectNo, contractProject.getId()))
                        .ne(CutPlate::getPlateState, DetailEnum.UNASSIGNED.getCode())
                  );
               if (CollUtil.isNotEmpty(list2)) {
                  BigDecimal cutPlateReduce1 = list2.stream().map(CutPlate::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
                  nestingList.setDistributionWeight(cutPlateReduce1);
                  nestingList.setDistributionNum(list2.size());
                  list2.forEach(no -> {
                     List<TechMachinePart> cutPart = this.cutPlatePartService.getCutPart(no.getTaskId());
                     if (CollUtil.isNotEmpty(cutPart)) {
                        int sum = cutPart.stream().mapToInt(TechMachinePart::getQuantity).sum();
                        BigDecimal reduce = cutPart.stream().map(TechMachinePart::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
                        nestingList.setDistributionPartNum(nestingList.getDistributionPartNum() + sum);
                        nestingList.setDistributionPartWeight(nestingList.getDistributionPartWeight().add(reduce));
                     }
                  });
               }

               if (list1.size() == list2.size()) {
                  nestingList.setNestingState(2);
               } else if (list1.size() > list2.size() && CollUtil.isNotEmpty(list2)) {
                  nestingList.setNestingState(1);
               } else {
                  nestingList.setNestingState(0);
               }

               if (list1.size() == list3.size()) {
                  nestingList.setCutState(2);
               } else if (list1.size() > list3.size() && CollUtil.isNotEmpty(list3)) {
                  nestingList.setCutState(1);
               } else {
                  nestingList.setCutState(0);
               }

               if (nestingState == null && cutState == null) {
                  objects.add(nestingList);
               } else if (nestingState != null && nestingState.equals(nestingList.getNestingState())) {
                  objects.add(nestingList);
               } else if (cutState != null && cutState.equals(nestingList.getCutState())) {
                  objects.add(nestingList);
               }
            }
         }
      );
      return ResultBuilder.success(new PageVO<>(objects));
   }

   @Override
   public ResultVO getMachinePlateList(
      Integer pageNumber,
      Integer pageSize,
      String mac,
      String machineName,
      Long factoryId,
      Long workshopInfId,
      LocalDateTime startTime,
      LocalDateTime endTime,
      List<String> sort
   ) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, s);
      List<CutMachine> list = this.cutMachineService
         .list(
            (((new LambdaQueryWrapper<CutMachine>().eq(StrUtil.isNotBlank(mac), CutMachine::getMac, mac))
                     .like(StrUtil.isNotBlank(machineName), CutMachine::getMachineName, machineName))
                  .eq(factoryId != null, CutMachine::getFactoryId, factoryId))
               .eq(workshopInfId != null, CutMachine::getWorkshopInfId, workshopInfId)
         );
      ArrayList<MachinePlateList> objects = new ArrayList<>();
      list.forEach(
         cutMachine -> {
            List<CutPlate> list2 = this.plateService
               .list(
                  ((new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getMac, cutMachine.getMac()))
                        .ge(startTime != null, CutPlate::getStartTime, startTime))
                     .le(endTime != null, CutPlate::getEndTime, endTime)
               );
            MachinePlateList machinePlateList = new MachinePlateList();
            machinePlateList.setCutMachine(cutMachine);
            machinePlateList.setFinishPartNum(0);
            machinePlateList.setFinishPartWeight(BigDecimal.valueOf(0L));
            if (CollUtil.isNotEmpty(list2)) {
               machinePlateList.setPlateNum(list2.size());
               BigDecimal reduce = list2.stream().map(CutPlate::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
               machinePlateList.setPlateWeight(reduce);
            }

            List<CutPlate> list3 = this.plateService
               .list(
                  (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getMac, cutMachine.getMac()))
                     .eq(CutPlate::getPlateState, DetailEnum.CUT.getCode())
               );
            if (CollUtil.isNotEmpty(list3)) {
               machinePlateList.setFinishNum(list3.size());
               BigDecimal reduce = list3.stream().map(CutPlate::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
               machinePlateList.setFinishWeight(reduce);
               list3.forEach(cutPlate -> {
                  List<TechMachinePart> cutPart = this.cutPlatePartService.getCutPart(cutPlate.getTaskId());
                  if (CollUtil.isNotEmpty(cutPart)) {
                     int sum = cutPart.stream().mapToInt(TechMachinePart::getQuantity).sum();
                     BigDecimal reduce1 = cutPart.stream().map(TechMachinePart::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
                     machinePlateList.setFinishPartNum(machinePlateList.getFinishPartNum() + sum);
                     machinePlateList.setFinishPartWeight(machinePlateList.getFinishPartWeight().add(reduce1));
                  }
               });
            }

            objects.add(machinePlateList);
         }
      );
      return ResultBuilder.success(new PageVO<>(objects));
   }

   @Override
   public ResultVO getMachinePartList(Integer pageNumber, Integer pageSize, String mac, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, s);
      List<CutMachine> list = this.cutMachineService.list(new LambdaQueryWrapper<CutMachine>().eq(StrUtil.isNotBlank(mac), CutMachine::getMac, mac));
      ArrayList<MachinePartListDTO> objects = new ArrayList<>();
      list.forEach(
         cutMachine -> {
            MachinePartListDTO build = MachinePartListDTO.builder().cutMachine(cutMachine).finishWeight(BigDecimal.valueOf(0L)).finishNum(0).build();
            List<CutPlate> list2 = this.plateService
               .list(
                  (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getMac, cutMachine.getMac()))
                     .eq(CutPlate::getPlateState, DetailEnum.CUT.getCode())
               );
            list2.forEach(cutPlate -> {
               List<TechMachinePart> cutPart = this.cutPlatePartService.getCutPart(cutPlate.getTaskId());
               if (CollUtil.isNotEmpty(cutPart)) {
                  int sum = cutPart.stream().mapToInt(TechMachinePart::getQuantity).sum();
                  BigDecimal reduce = cutPart.stream().map(TechMachinePart::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
                  build.setFinishNum(build.getFinishNum() + sum);
                  build.setFinishWeight(build.getFinishWeight().add(reduce));
               }
            });
            objects.add(build);
         }
      );
      return ResultBuilder.success(new PageVO<>(objects));
   }

   @Override
   public ResultVO getPartListByMac(String mac) {
      List<CutPlate> list2 = this.plateService
         .list(
            (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getMac, mac)).eq(CutPlate::getPlateState, DetailEnum.CUT.getCode())
         );
      ArrayList<TechMachinePartDTO> objects = new ArrayList<>();
      if (CollUtil.isNotEmpty(list2)) {
         list2.forEach(cutPlate -> {
            List<TechMachinePart> cutPart = this.cutPlatePartService.getCutPart(cutPlate.getTaskId());
            cutPart.forEach(techMachinePart1 -> {
               TechMachinePartDTO build = TechMachinePartDTO.builder().build();
               PlanArea planArea = this.planAreaService.getById(techMachinePart1.getAreaId());
               PlanMonomer planMonomer = this.planMonomerService.getById(techMachinePart1.getMonomerId());
               ContractProject byId = this.contractProjectService.getById(techMachinePart1.getProjectId());
               build.setAreaName(planArea.getName());
               build.setMonomerName(planMonomer.getName());
               build.setProjectName(byId.getName());
               BeanUtil.copyProperties(techMachinePart1, build);
               objects.add(build);
            });
         });
      }

      return ResultBuilder.success(objects);
   }

   @Override
   public ResultVO contrastPlant(String taskId, String barcode, String mac) {
      MaterialInventoryDTO materials = this.outboundService.getMaterials(barcode);
      List<CutPlate> list = this.plateService
         .list(
            (Wrapper<CutPlate>)(((((new LambdaQueryWrapper<CutPlate>()
                              .eq(CutPlate::getTaskId, taskId))
                           .eq(CutPlate::getWidth, materials.getWidth()))
                        .eq(CutPlate::getLength, materials.getLength()))
                     .eq(CutPlate::getThick, materials.getThickness()))
                  .eq(CutPlate::getMaterial, materials.getSpecification()))
               .eq(CutPlate::getMac, mac)
         );
      Preconditions.checkArgument(CollUtil.isNotEmpty(list), "未找到钢板");
      CutPlate cutPlate = list.get(0);
      cutPlate.setTaskSendState(DetailEnum.ASSIGNED.getCode());
      cutPlate.setPlateState(DetailEnum.CUTTING.getCode());
      this.plateService.updateById(cutPlate);
      this.kafkaTemplate.send("plateTask", JSON.toJSONString(cutPlate));
      return ResultBuilder.success("任务已发送");
   }

   @Override
   public ResultVO getProjectGuide(Long projectId) {
      ProjectGuide build = ProjectGuide.builder().partNestNum(0).partNestWeight(BigDecimal.valueOf(0L)).partNum(0).partWeight(BigDecimal.valueOf(0L)).build();
      List<TechMachinePart> techMachinePart = this.techMachinePartService
         .list(
            (Wrapper<TechMachinePart>)(new LambdaQueryWrapper<TechMachinePart>().isNotNull(TechMachinePart::getPath))
               .eq(TechMachinePart::getProjectId, projectId)
         );
      if (CollUtil.isNotEmpty(techMachinePart)) {
         int sum = techMachinePart.stream().mapToInt(TechMachinePart::getQuantity).sum();
         BigDecimal reduce = techMachinePart.stream().map(TechMachinePart::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
         build.setPartNum(sum);
         build.setPartWeight(reduce);
      }

      List<CutPlate> list2 = this.plateService.list((Wrapper<CutPlate>)new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getProjectNo, projectId));
      if (CollUtil.isNotEmpty(list2)) {
         List<String> taskIdCollect = list2.stream().map(CutPlate::getTaskId).collect(Collectors.toList());
         List<CutPlatePart> list = this.cutPlatePartService.list((Wrapper<CutPlatePart>)new LambdaQueryWrapper<CutPlatePart>().in(CutPlatePart::getTaskId, taskIdCollect));
         list.forEach(cutPlatePart -> {
            TechMachinePart techMachinePart1 = this.techMachinePartService.getById(cutPlatePart.getPartId());
            build.setPartNum(build.getPartNum() + Integer.parseInt(cutPlatePart.getQuantity()));
            BigDecimal multiply = techMachinePart1.getNetWeight().multiply(BigDecimal.valueOf(Long.parseLong(cutPlatePart.getQuantity())));
            build.setPartWeight(build.getPartWeight().add(multiply));
         });
      }

      return ResultBuilder.success(build);
   }
}

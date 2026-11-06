package com.hzchum.scim.cut.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.cut.core.api.pojo._do.CutMachinePart;
import com.hzchum.scim.cut.core.api.pojo._do.CutPlate;
import com.hzchum.scim.cut.core.api.pojo._do.CutPlatePart;
import com.hzchum.scim.cut.core.api.pojo._do.CutSurplus;
import com.hzchum.scim.cut.core.api.pojo._do.CutTaskPart;
import com.hzchum.scim.cut.core.api.pojo._do.CutTaskProject;
import com.hzchum.scim.cut.core.api.request.ProjectInformation;
import com.hzchum.scim.cut.core.api.request.TechMachinePartDTO;
import com.hzchum.scim.cut.core.api.service.CutMachinePartService;
import com.hzchum.scim.cut.core.api.service.CutPlatePartService;
import com.hzchum.scim.cut.core.api.service.CutPlateService;
import com.hzchum.scim.cut.core.api.service.CutSurplusService;
import com.hzchum.scim.cut.core.api.service.CutTaskPartService;
import com.hzchum.scim.cut.core.api.service.CutTaskProjectService;
import com.hzchum.scim.cut.core.mapper.CutTaskProjectMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CutTaskProjectServiceImpl extends ServiceImpl<CutTaskProjectMapper, CutTaskProject> implements CutTaskProjectService {
   @Resource
   private PlanAreaService planAreaService;
   @Resource
   private CutPlateService cutPlateService;
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private CutPlatePartService cutPlatePartService;
   @Resource
   private CutSurplusService cutSurplusService;
   @Resource
   private CutTaskPartService cutTaskPartService;
   @Resource
   private CutTaskProjectService cutTaskProjectService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private TechMachinePartService techMachinePartService;
   @Resource
   private CutMachinePartService cutMachinePartService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO deleteTask(String cutTaskId) {
      CutTaskProject one = this.cutTaskProjectService.getOne((Wrapper<CutTaskProject>)new LambdaQueryWrapper<CutTaskProject>().eq(CutTaskProject::getCutTaskId, cutTaskId));
      if (!"2".equals(one.getState())) {
         List<CutTaskPart> list = this.cutTaskPartService.list((Wrapper<CutTaskPart>)new LambdaQueryWrapper<CutTaskPart>().eq(CutTaskPart::getCutTaskId, cutTaskId));
         List<Long> partId = list.stream().map(CutTaskPart::getPartId).collect(Collectors.toList());
         if (CollUtil.isNotEmpty(partId)) {
            List<TechMachinePart> list1 = this.techMachinePartService
               .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().in(TechMachinePart::getId, partId));
            list1.forEach(techMachinePart -> techMachinePart.setNestingState(0));
            this.techMachinePartService.updateBatchById(list1);
         }

         this.cutTaskProjectService.remove((Wrapper<CutTaskProject>)new LambdaQueryWrapper<CutTaskProject>().eq(CutTaskProject::getCutTaskId, cutTaskId));
         this.cutTaskPartService.remove((Wrapper<CutTaskPart>)new LambdaQueryWrapper<CutTaskPart>().eq(CutTaskPart::getCutTaskId, cutTaskId));
         return ResultBuilder.success("撤销成功");
      } else {
         return ResultBuilder.failed("该清单已套料结束，不能撤销");
      }
   }

   @Override
   public ResultVO deletePlate(String plateId) {
      CutPlate byId = this.cutPlateService.getById(plateId);
      Preconditions.checkArgument(!"2".equals(byId.getPlateState()), "该清单已套料结束，不能撤销");
      List<CutPlatePart> list = this.cutPlatePartService.list((Wrapper<CutPlatePart>)new LambdaQueryWrapper<CutPlatePart>().eq(CutPlatePart::getTaskId, byId.getTaskId()));
      list.forEach(cutPlatePart -> {
         TechMachinePart byId1 = this.techMachinePartService.getById(cutPlatePart.getPartId());
         byId1.setTotalNetWeight(byId1.getNetWeight().multiply(BigDecimal.valueOf(Long.getLong(cutPlatePart.getQuantity()))));
         byId1.setQuantity(Integer.valueOf(cutPlatePart.getQuantity()));
         byId1.setNestingState(0);
         CutMachinePart cutMachinePart = new CutMachinePart();
         BeanUtil.copyProperties(byId1, cutMachinePart);
         this.cutMachinePartService.save(cutMachinePart);
      });
      return ResultBuilder.success("撤销成功");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO uploadTask(String cutTaskId) {
      List<CutTaskProject> list1 = this.cutTaskProjectService
         .list(
            (Wrapper<CutTaskProject>)(new LambdaUpdateWrapper<CutTaskProject>().eq(CutTaskProject::getCutTaskId, cutTaskId))
               .eq(CutTaskProject::getState, "0")
         );
      if (CollUtil.isNotEmpty(list1)) {
         this.cutTaskPartService
            .update(
               (Wrapper<CutTaskPart>)(new LambdaUpdateWrapper<CutTaskPart>().eq(CutTaskPart::getCutTaskId, cutTaskId)).set(CutTaskPart::getState, "1")
            );
         this.cutTaskProjectService
            .update(
               (Wrapper<CutTaskProject>)(new LambdaUpdateWrapper<CutTaskProject>().eq(CutTaskProject::getCutTaskId, cutTaskId))
                  .set(CutTaskProject::getState, "1")
            );
         return ResultBuilder.success("上传完成");
      } else {
         return ResultBuilder.failed("任务包不存在");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO getPartByCutTaskId(Integer pageNumber, Integer pageSize, String cutTaskId) {
      if (pageNumber == null) {
         pageNumber = 1;
      }

      if (pageSize == null) {
         pageSize = 50;
      }

      List<CutTaskPart> list = this.cutTaskPartService.list((Wrapper<CutTaskPart>)new LambdaQueryWrapper<CutTaskPart>().eq(CutTaskPart::getCutTaskId, cutTaskId));
      List<Long> newList = list.stream().map(CutTaskPart::getPartId).collect(Collectors.toList());
      if (CollUtil.isNotEmpty(newList)) {
         PageHelper.startPage(pageNumber, pageSize);
         List<TechMachinePart> techMachineParts = this.techMachinePartService.listByIds(newList);
         ArrayList<TechMachinePartDTO> objects = new ArrayList<>();
         techMachineParts.forEach(techMachinePart -> {
            TechMachinePartDTO build = TechMachinePartDTO.builder().build();
            BeanUtil.copyProperties(techMachinePart, build);
            PlanArea planArea = this.planAreaService.getById(techMachinePart.getAreaId());
            PlanMonomer planMonomer = this.planMonomerService.getById(techMachinePart.getMonomerId());
            build.setAreaName(planArea.getName());
            build.setMonomerName(planMonomer.getName());
            objects.add(build);
         });
         return ResultBuilder.success(new PageVO<>(objects));
      } else {
         return ResultBuilder.failed("未找到该任务");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO getTaskByProjectId(Long projectId, Long monomerId, Long areaId) {
      ContractProject byId = this.contractProjectService.getById(projectId);
      List<PlanMonomer> planMonomerList = this.planMonomerService
         .list((new LambdaQueryWrapper<PlanMonomer>().eq(PlanMonomer::getProjectId, byId.getId())).eq(monomerId != null, PlanMonomer::getId, monomerId));
      List<CutTaskProject> filterList = new ArrayList<>();
      List<Long> planMonomerIdList = planMonomerList.stream().map(PlanMonomer::getId).collect(Collectors.toList());
      if (CollUtil.isNotEmpty(planMonomerIdList)) {
         planMonomerList.forEach(
            planMonomer -> {
               List<PlanArea> planAreaList = this.planAreaService
                  .list(
                     (new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getMonomerId, planMonomer.getId())).eq(areaId != null, PlanArea::getId, areaId)
                  );
               if (CollUtil.isNotEmpty(planAreaList)) {
                  planAreaList.forEach(
                     planArea -> {
                        List<TechMachinePart> techMachinePart = this.techMachinePartService
                           .list(
                              (Wrapper<TechMachinePart>)(new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getAreaId, planArea.getId()))
                                 .in(TechMachinePart::getRelationType, this.getList())
                           );
                        List<TechMachinePart> techMachinePartListByAreaId = this.getTechMachinePartListByAreaId(planArea.getId());
                        if (CollUtil.isNotEmpty(techMachinePart)) {
                           int packNum = techMachinePartListByAreaId.stream().mapToInt(TechMachinePart::getQuantity).sum();
                           BigDecimal packWeight = techMachinePartListByAreaId.stream()
                              .map(TechMachinePart::getTotalNetWeight)
                              .reduce(BigDecimal.ZERO, BigDecimal::add);
                           int sum = techMachinePart.stream().mapToInt(TechMachinePart::getQuantity).sum();
                           BigDecimal reduce = techMachinePart.stream().map(TechMachinePart::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
                           filterList.add(
                              CutTaskProject.builder()
                                 .projectName(byId.getName())
                                 .areaName(planArea.getName())
                                 .areaId(planArea.getId())
                                 .monomerName(planMonomer.getName())
                                 .monomerId(planMonomer.getId())
                                 .importTime(DateUtil.format(techMachinePart.get(0).getCreateTime(), "yyyy-MM-dd"))
                                 .sum(sum)
                                 .reduce(reduce)
                                 .packNum(packNum)
                                 .packWeight(packWeight)
                                 .build()
                           );
                        }
                     }
                  );
               }
            }
         );
      }

      return ResultBuilder.success(filterList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO feedingOperation(
      Integer pageNumber,
      Integer pageSize,
      List<Long> areaIdList,
      Long projectId,
      String thick,
      String material,
      Integer relationType,
      String serialNumber,
      List<String> sort
   ) {
      List<TechMachinePart> techMachinePart = this.techMachinePartService
         .list(
            (Wrapper<TechMachinePart>)(((((((new LambdaQueryWrapper<TechMachinePart>()
                                    .in(TechMachinePart::getAreaId, areaIdList))
                                 .isNotNull(TechMachinePart::getPath))
                              .in(TechMachinePart::getRelationType, this.getList()))
                           .eq(StrUtil.isNotBlank(material), TechMachinePart::getMaterial, material))
                        .eq(StrUtil.isNotBlank(thick), TechMachinePart::getThick, thick))
                     .eq(relationType != null, TechMachinePart::getRelationType, relationType))
                  .eq(StrUtil.isNotBlank(serialNumber), TechMachinePart::getSerialNumber, serialNumber))
               .eq(TechMachinePart::getNestingState, 0)
         );
      ArrayList<TechMachinePartDTO> objects = new ArrayList<>();
      techMachinePart.forEach(techMachinePart1 -> {
         TechMachinePartDTO build = TechMachinePartDTO.builder().build();
         BeanUtil.copyProperties(techMachinePart1, build);
         PlanArea planArea = this.planAreaService.getById(techMachinePart1.getAreaId());
         PlanMonomer planMonomer = this.planMonomerService.getById(techMachinePart1.getMonomerId());
         build.setAreaName(planArea.getName());
         build.setMonomerName(planMonomer.getName());
         objects.add(build);
      });
      return ResultBuilder.success(new PageVO<>(objects));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO createOrder(List<Long> techMachinePartIds, Long projectId) {
      List<TechMachinePart> list = this.techMachinePartService
         .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().in(TechMachinePart::getId, techMachinePartIds));
      Map<Integer, List<TechMachinePart>> collect = list.stream().collect(Collectors.groupingBy(TechMachinePart::getRelationType));

      for (Entry<Integer, List<TechMachinePart>> entry : collect.entrySet()) {
         Integer key = entry.getKey();
         List<TechMachinePart> value = entry.getValue();
         String key1 = "";
         if (key == 2) {
            key1 = "零件";
         } else if (key == 16) {
            key1 = "腹板";
         }

         this.getTaskProject(value, projectId, key1);
      }

      return ResultBuilder.success("创建工单成功");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO updateOrder(String cutTaskId) {
      List<CutTaskPart> list1 = this.cutTaskPartService.list((Wrapper<CutTaskPart>)new LambdaQueryWrapper<CutTaskPart>().eq(CutTaskPart::getCutTaskId, cutTaskId));
      if (CollUtil.isNotEmpty(list1)) {
         ArrayList<TechMachinePartDTO> objects = new ArrayList<>();
         List<Long> partIdList = list1.stream().map(CutTaskPart::getPartId).collect(Collectors.toList());
         List<TechMachinePart> list = this.techMachinePartService
            .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().in(TechMachinePart::getId, partIdList));
         if (CollUtil.isNotEmpty(list)) {
            List<Long> areaIdList = list.stream().map(TechMachinePart::getAreaId).distinct().collect(Collectors.toList());
            List<TechMachinePart> techMachinePart = this.techMachinePartService
               .list(
                  (Wrapper<TechMachinePart>)((((new LambdaQueryWrapper<TechMachinePart>()
                                 .in(TechMachinePart::getAreaId, areaIdList))
                              .isNotNull(TechMachinePart::getPath))
                           .eq(TechMachinePart::getRelationType, list.get(0).getRelationType()))
                        .eq(TechMachinePart::getMaterial, list.get(0).getMaterial()))
                     .eq(TechMachinePart::getThick, list.get(0).getThick())
               );
            list.forEach(techMachinePart1 -> techMachinePart1.setNestingState(1));
            List<TechMachinePart> addCollect = techMachinePart.stream()
               .filter(a -> !list.stream().map(TechMachinePart::getId).collect(Collectors.toList()).contains(a.getId()))
               .collect(Collectors.toList());
            if (CollUtil.isNotEmpty(addCollect)) {
               addCollect.forEach(techMachinePart1 -> techMachinePart1.setNestingState(2));
            }

            list.addAll(addCollect);
            list.forEach(techMachinePart1 -> {
               TechMachinePartDTO build = TechMachinePartDTO.builder().build();
               BeanUtil.copyProperties(techMachinePart1, build);
               PlanArea planArea = this.planAreaService.getById(techMachinePart1.getAreaId());
               PlanMonomer planMonomer = this.planMonomerService.getById(techMachinePart1.getMonomerId());
               build.setAreaName(planArea.getName());
               build.setMonomerName(planMonomer.getName());
               objects.add(build);
            });
         }

         return ResultBuilder.success(objects);
      } else {
         return ResultBuilder.success(new ArrayList());
      }
   }

   @Override
   public ResultVO getPartByAreaId(Integer pageNumber, Integer pageSize, String areaId, List<String> sort) {
      if (pageNumber == null) {
         pageNumber = 1;
      }

      if (pageSize == null) {
         pageSize = 50;
      }

      String s = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, s);
      List<TechMachinePart> techMachineParts = this.techMachinePartService
         .list(
            (Wrapper<TechMachinePart>)(new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getAreaId, areaId))
               .in(TechMachinePart::getRelationType, this.getList())
         );
      ArrayList<TechMachinePartDTO> objects = new ArrayList<>();
      techMachineParts.forEach(techMachinePart1 -> {
         TechMachinePartDTO build = TechMachinePartDTO.builder().build();
         BeanUtil.copyProperties(techMachinePart1, build);
         PlanArea planArea = this.planAreaService.getById(techMachinePart1.getAreaId());
         PlanMonomer planMonomer = this.planMonomerService.getById(techMachinePart1.getMonomerId());
         build.setAreaName(planArea.getName());
         build.setMonomerName(planMonomer.getName());
         objects.add(build);
      });
      return ResultBuilder.success(new PageVO<>(objects));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO addPartFromOrder(List<Long> techMachinePartIds, String cutTaskId) {
      CutTaskProject one = this.cutTaskProjectService.getOne((Wrapper<CutTaskProject>)new LambdaQueryWrapper<CutTaskProject>().eq(CutTaskProject::getCutTaskId, cutTaskId));
      if ("2".equals(one.getState())) {
         return ResultBuilder.failed("该工单已套料结束");
      }

      ArrayList<CutTaskPart> objects = new ArrayList<>();
      techMachinePartIds.forEach(id -> objects.add(CutTaskPart.builder().cutTaskId(cutTaskId).partId(id).state("0").build()));
      List<TechMachinePart> list = this.techMachinePartService
         .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().in(TechMachinePart::getId, techMachinePartIds));
      int packNum = list.stream().mapToInt(TechMachinePart::getQuantity).sum();
      BigDecimal packWeight = list.stream().map(TechMachinePart::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
      this.cutTaskPartService.saveBatch(objects);
      one.setSum(one.getSum() + packNum);
      one.setReduce(one.getReduce().add(packWeight));
      this.cutTaskProjectService.updateById(one);
      return ResultBuilder.success("新增零件成功");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO deletePartFromOrder(List<Long> techMachinePartIds, String cutTaskId) {
      CutTaskProject one = this.cutTaskProjectService.getOne((Wrapper<CutTaskProject>)new LambdaQueryWrapper<CutTaskProject>().eq(CutTaskProject::getCutTaskId, cutTaskId));
      if ("2".equals(one.getState())) {
         return ResultBuilder.failed("该工单已套料结束");
      }

      this.cutTaskPartService
         .remove(
            (Wrapper<CutTaskPart>)(new LambdaQueryWrapper<CutTaskPart>().eq(CutTaskPart::getCutTaskId, cutTaskId))
               .in(CutTaskPart::getPartId, techMachinePartIds)
         );
      List<TechMachinePart> list = this.techMachinePartService
         .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().in(TechMachinePart::getId, techMachinePartIds));
      int packNum = list.stream().mapToInt(TechMachinePart::getQuantity).sum();
      BigDecimal packWeight = list.stream().map(TechMachinePart::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
      one.setSum(one.getSum() - packNum);
      one.setReduce(one.getReduce().subtract(packWeight));
      this.cutTaskProjectService.updateById(one);
      return ResultBuilder.success("从工单删除零件成功");
   }

   @Override
   public ResultVO getProjectInfo() {
      List<ContractProject> list = this.contractProjectService.list();
      ProjectInformation build = ProjectInformation.builder()
         .projectNum(0)
         .nestingNum(0)
         .partialNesting(0)
         .noNesting(0)
         .noCuttingNum(0)
         .cuttingNum(0)
         .partialNum(0)
         .build();
      list.forEach(
         contractProject -> {
            List<TechMachinePart> techMachinePart = this.techMachinePartService
               .list(
                  (Wrapper<TechMachinePart>)((new LambdaQueryWrapper<TechMachinePart>()
                           .eq(TechMachinePart::getProjectId, contractProject.getId()))
                        .in(TechMachinePart::getRelationType, this.getList()))
                     .isNotNull(TechMachinePart::getPath)
               );
            if (CollUtil.isNotEmpty(techMachinePart)) {
               build.setProjectNum(build.getProjectNum() + 1);
               List<CutTaskProject> list1 = this.cutTaskProjectService
                  .list((Wrapper<CutTaskProject>)new LambdaQueryWrapper<CutTaskProject>().eq(CutTaskProject::getProjectId, contractProject.getId()));
               List<String> cutTaskIdCollect = list1.stream().map(CutTaskProject::getCutTaskId).collect(Collectors.toList());
               if (CollUtil.isNotEmpty(cutTaskIdCollect)) {
                  List<CutTaskPart> list2 = this.cutTaskPartService
                     .list(new LambdaQueryWrapper<CutTaskPart>().in(CollUtil.isNotEmpty(cutTaskIdCollect), CutTaskPart::getCutTaskId, cutTaskIdCollect));
                  if (CollUtil.isNotEmpty(list2)) {
                     if (list2.size() == techMachinePart.size()) {
                        build.setNestingNum(build.getNestingNum() + 1);
                     } else if (list2.size() != 0 && list2.size() < techMachinePart.size()) {
                        build.setPartialNesting(build.getPartialNesting() + 1);
                     }

                     List<CutPlate> list4 = this.cutPlateService
                        .list((Wrapper<CutPlate>)new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getProjectNo, contractProject.getId()));
                     List<CutPlate> list3 = this.cutPlateService
                        .list(
                           (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getProjectNo, contractProject.getId()))
                              .eq(CutPlate::getPlateState, "4")
                        );
                     if (CollUtil.isNotEmpty(list3)) {
                        if (list4.size() == list3.size()) {
                           build.setCuttingNum(build.getCuttingNum() + 1);
                        } else if (list4.size() > list3.size()) {
                           build.setPartialNum(build.getPartialNum() + 1);
                        }
                     } else {
                        build.setNoCuttingNum(build.getNoCuttingNum() + 1);
                     }
                  }
               } else {
                  build.setNoNesting(build.getNoNesting() + 1);
               }
            }
         }
      );
      return ResultBuilder.success(build);
   }

   @Override
   public void partInspection(Long partId) {
      Preconditions.checkArgument(
         this.cutTaskPartService.count((Wrapper<CutTaskPart>)new LambdaQueryWrapper<CutTaskPart>().eq(CutTaskPart::getPartId, partId)) == 0, "零件已套料，不可删除"
      );
   }

   @Override
   public PrintVO printPartByCutTaskId(String cutTaskId) {
      List<CutTaskPart> list = this.cutTaskPartService.list((Wrapper<CutTaskPart>)new LambdaQueryWrapper<CutTaskPart>().eq(CutTaskPart::getCutTaskId, cutTaskId));
      CutTaskProject one = this.cutTaskProjectService.getOne((Wrapper<CutTaskProject>)new LambdaQueryWrapper<CutTaskProject>().eq(CutTaskProject::getCutTaskId, cutTaskId));
      ContractProject byId = this.contractProjectService.getById(one.getProjectId());
      Preconditions.checkArgument(CollUtil.isNotEmpty(list), "没有零件");
      List<Long> newList = list.stream().map(CutTaskPart::getPartId).collect(Collectors.toList());
      List<TechMachinePart> techMachineParts = this.techMachinePartService.listByIds(newList);
      ArrayList<TechMachinePartDTO> objects = new ArrayList<>();
      techMachineParts.forEach(techMachinePart -> {
         TechMachinePartDTO build = TechMachinePartDTO.builder().build();
         BeanUtil.copyProperties(techMachinePart, build);
         PlanArea planArea = this.planAreaService.getById(techMachinePart.getAreaId());
         PlanMonomer planMonomer = this.planMonomerService.getById(techMachinePart.getMonomerId());
         build.setAreaName(planArea.getName());
         build.setMonomerName(planMonomer.getName());
         objects.add(build);
      });
      List<Map<String, Object>> mapList = objects.stream().map(com.hzchum.pangu.common.util.BeanUtil::beanToMap).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectName", byId.getSerialNumber() + "-" + byId.getName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO getPartByProjectId(
      Integer pageNumber, Integer pageSize, Long projectId, String projectName, List<String> sort, Long nestingState1, String year
   ) {
      if (pageNumber == null) {
         pageNumber = 1;
      }

      if (pageSize == null) {
         pageSize = 50;
      }

      String s = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, s);
      List<ContractProject> list = this.contractProjectService
         .list(
            ((((new LambdaQueryWrapper<ContractProject>()
                           .eq(projectId != null, ContractProject::getId, projectId))
                        .like(StrUtil.isNotBlank(projectName), ContractProject::getName, projectName))
                     .like(StrUtil.isNotBlank(year), BaseEntity::getCreateTime, year))
                  .or())
               .like(StrUtil.isNotBlank(projectName), ContractProject::getSerialNumber, projectName)
         );
      List<CutTaskProject> filterList = new ArrayList<>();
      list.forEach(
         contractProject -> {
            List<TechMachinePart> techMachinePart = this.techMachinePartService
               .list(
                  (Wrapper<TechMachinePart>)((new LambdaQueryWrapper<TechMachinePart>()
                           .eq(TechMachinePart::getProjectId, contractProject.getId()))
                        .in(TechMachinePart::getRelationType, this.getList()))
                     .isNotNull(TechMachinePart::getPath)
               );
            if (CollUtil.isNotEmpty(techMachinePart)) {
               List<PlanMonomer> planMonomerList = this.planMonomerService
                  .list((Wrapper<PlanMonomer>)new LambdaQueryWrapper<PlanMonomer>().eq(PlanMonomer::getProjectId, contractProject.getId()));
               List<PlanArea> planAreaList = this.planAreaService
                  .list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getProjectId, contractProject.getId()));
               List<CutTaskProject> list1 = this.cutTaskProjectService
                  .list((Wrapper<CutTaskProject>)new LambdaQueryWrapper<CutTaskProject>().eq(CutTaskProject::getProjectId, contractProject.getId()));
               List<String> cutTaskIdCollect = list1.stream().map(CutTaskProject::getCutTaskId).collect(Collectors.toList());
               List<CutTaskPart> list2 = new ArrayList<>();
               if (CollUtil.isNotEmpty(cutTaskIdCollect)) {
                  list2 = this.cutTaskPartService
                     .list(new LambdaQueryWrapper<CutTaskPart>().in(CollUtil.isNotEmpty(cutTaskIdCollect), CutTaskPart::getCutTaskId, cutTaskIdCollect));
               }

               int nestingState;
               if (list2.size() == techMachinePart.size()) {
                  nestingState = 2;
               } else if (list2.size() != 0 && list2.size() < techMachinePart.size()) {
                  nestingState = 1;
               } else {
                  nestingState = 0;
               }

               int sum = techMachinePart.stream().mapToInt(TechMachinePart::getQuantity).sum();
               BigDecimal reduce = techMachinePart.stream().map(TechMachinePart::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
               List<CutTaskProject> list4 = this.cutTaskProjectService
                  .list(
                     (Wrapper<CutTaskProject>)(new LambdaQueryWrapper<CutTaskProject>().eq(CutTaskProject::getProjectId, contractProject.getId()))
                        .eq(CutTaskProject::getState, "2")
                  );
               int totalNum = 0;
               BigDecimal totalWeight = null;
               int plateNum = 0;
               BigDecimal plateWeight = null;
               if (CollUtil.isNotEmpty(list4)) {
                  totalNum = list4.stream().mapToInt(CutTaskProject::getTotalNum).sum();
                  totalWeight = list4.stream().map(CutTaskProject::getTotalWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
                  List<CutPlate> list3 = this.cutPlateService
                     .list((Wrapper<CutPlate>)new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getProjectNo, contractProject.getId()));
                  plateNum = list3.size();
                  plateWeight = list3.stream().map(CutPlate::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
               }

               if (nestingState1 == null) {
                  filterList.add(
                     CutTaskProject.builder()
                        .projectId(contractProject.getId())
                        .projectName(contractProject.getName())
                        .importTime(DateUtil.format(contractProject.getCreateTime(), "yyyy-MM-dd"))
                        .sum(sum)
                        .reduce(reduce)
                        .areaNum(planAreaList.size())
                        .monomerNum(planMonomerList.size())
                        .nestingState(nestingState)
                        .projectNumber(contractProject.getSerialNumber())
                        .totalNum(totalNum)
                        .totalWeight(totalWeight)
                        .plateNum(plateNum)
                        .plateWeight(plateWeight)
                        .build()
                  );
               } else if (nestingState == nestingState1) {
                  filterList.add(
                     CutTaskProject.builder()
                        .projectId(contractProject.getId())
                        .projectName(contractProject.getName())
                        .importTime(DateUtil.format(contractProject.getCreateTime(), "yyyy-MM-dd"))
                        .sum(sum)
                        .reduce(reduce)
                        .areaNum(planAreaList.size())
                        .monomerNum(planMonomerList.size())
                        .nestingState(nestingState)
                        .projectNumber(contractProject.getSerialNumber())
                        .totalNum(totalNum)
                        .totalWeight(totalWeight)
                        .plateNum(plateNum)
                        .plateWeight(plateWeight)
                        .build()
                  );
               }
            }
         }
      );
      return ResultBuilder.success(new PageVO<>(filterList));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO setPlateReport(String plateReport) {
      JSONObject jsonObject = JSON.parseObject(plateReport);
      String projectNo = jsonObject.getString("projectNo");
      String projectName = jsonObject.getString("projectName");
      String cutTaskId = jsonObject.getString("cutTaskId");
      String plateReportName = jsonObject.getString("plateReportName");
      String totalNum = jsonObject.getString("totalNum");
      String totalWeight = jsonObject.getString("totalWeight");
      String plateReportUrl = "https://cut-report.oss-cn-hangzhou.aliyuncs.com/plateReport/" + plateReportName;
      JSONArray plateList = (JSONArray)jsonObject.get("plateList");
      List<CutTaskProject> list = this.cutTaskProjectService
         .list((Wrapper<CutTaskProject>)new LambdaQueryWrapper<CutTaskProject>().eq(CutTaskProject::getCutTaskId, cutTaskId));
      Preconditions.checkArgument(CollUtil.isNotEmpty(list), "任务包不存在");
      plateList.forEach(plate -> {
         JSONObject plate1 = (JSONObject)plate;
         CutPlate cutPlate = JSON.toJavaObject(plate1, CutPlate.class);

         for (int i = 0; i < Integer.parseInt(cutPlate.getNum()); i++) {
            cutPlate.setPlateReportUrl(plateReportUrl);
            cutPlate.setProjectNo(projectNo);
            ContractProject byId = this.contractProjectService.getById(projectNo);
            cutPlate.setProjectName(byId.getName());
            cutPlate.setCutTaskId(cutTaskId);
            String taskId = RandomUtil.randomString("123456789", 8);
            cutPlate.setTaskId(taskId);
            String plateFilePath = "https://cut-plant.oss-cn-hangzhou.aliyuncs.com/plateImg/" + cutPlate.getPlatePictureName();
            String gCodePath = "https://cut-plant.oss-cn-hangzhou.aliyuncs.com/gCode/" + cutPlate.getNcName();
            String nestingReportUrl = "https://cut-report.oss-cn-hangzhou.aliyuncs.com/nestingReport/" + cutPlate.getNestingReportName();
            String platePictureReportUrl = "https://cut-report.oss-cn-hangzhou.aliyuncs.com/platePictureReport/" + cutPlate.getPlatePictureReportName();
            String allReportUrl = "https://cut-report.oss-cn-hangzhou.aliyuncs.com/allReport/" + cutTaskId + ".zip";
            String dwgReportUrl = "https://cut-report.oss-cn-hangzhou.aliyuncs.com/dwgReport/" + cutPlate.getDwgReportName();
            cutPlate.setPlateAllReportUrl(allReportUrl);
            cutPlate.setNcUrl(gCodePath);
            cutPlate.setDwgReportUrl(dwgReportUrl);
            cutPlate.setPlatePictureName(cutPlate.getPlatePictureName());
            cutPlate.setPlatePictureUrl(plateFilePath);
            cutPlate.setNestingReportName(cutPlate.getNestingReportName());
            cutPlate.setNestingReportUrl(nestingReportUrl);
            cutPlate.setPlatePictureReportName(cutPlate.getPlatePictureReportName());
            cutPlate.setPlatePictureReportUrl(platePictureReportUrl);
            cutPlate.setUploadName(UserUtil.getCurrentName());
            cutPlate.setImportTime(DateUtil.format(DateUtil.date(), "yyyy-MM-dd"));
            this.cutPlateService.save(cutPlate);
            JSONArray partList = (JSONArray)plate1.get("partList");
            partList.forEach(part -> {
               JSONObject part1 = (JSONObject)part;
               CutPlatePart cutPlatePart = JSON.toJavaObject(part1, CutPlatePart.class);
               cutPlatePart.setCutInstructionId(cutPlate.getCutInstructionId());
               cutPlatePart.setTaskId(cutPlate.getTaskId());
               cutPlatePart.setCutTaskId(cutTaskId);
               this.cutPlatePartService.save(cutPlatePart);
            });
            JSONArray surplusList = (JSONArray)plate1.get("surplusList");
            if (CollUtil.isNotEmpty(surplusList)) {
               surplusList.forEach(surplus -> {
                  JSONObject surplus1 = (JSONObject)surplus;
                  CutSurplus cutSurplus = JSON.toJavaObject(surplus1, CutSurplus.class);
                  cutSurplus.setTaskId(cutPlate.getTaskId());
                  cutSurplus.setCutInstructionId(cutPlate.getCutInstructionId());
                  cutSurplus.setMaterial(cutPlate.getMaterial());
                  cutSurplus.setProjectNo(projectNo);
                  cutSurplus.setProjectName(projectName);
                  String num = String.valueOf(Integer.parseInt(cutSurplus.getNum()) / Integer.parseInt(cutPlate.getNum()));
                  cutSurplus.setNum(num);
                  cutSurplus.setCutTaskId(cutTaskId);
                  String cutSurplusPath1 = "https://cut-plant.oss-cn-hangzhou.aliyuncs.com/surplusImg/" + cutSurplus.getSurplusPicture();
                  String surplusReportUrl = "https://cut-report.oss-cn-hangzhou.aliyuncs.com/surplusReport/" + cutSurplus.getSurplusReportName();
                  String surplusDxfPictureUrl = "https://cut-plant.oss-cn-hangzhou.aliyuncs.com/surplusImg/" + cutSurplus.getSurplusDxfPicture();
                  String surplusDrgPictureUrl = "https://cut-plant.oss-cn-hangzhou.aliyuncs.com/surplusImg/" + cutSurplus.getSurplusDrgPictureName();
                  cutSurplus.setSurplusPictureUrl(cutSurplusPath1);
                  cutSurplus.setSurplusReportUrl(surplusReportUrl);
                  cutSurplus.setSurplusDxfPictureUrl(surplusDxfPictureUrl);
                  cutSurplus.setSurplusDrgPictureUrl(surplusDrgPictureUrl);
                  this.cutSurplusService.save(cutSurplus);
               });
            }
         }
      });
      this.cutTaskProjectService
         .update(
            (Wrapper<CutTaskProject>)(((new LambdaUpdateWrapper<CutTaskProject>()
                        .eq(CutTaskProject::getCutTaskId, cutTaskId))
                     .set(CutTaskProject::getState, "2"))
                  .set(CutTaskProject::getTotalNum, totalNum))
               .set(CutTaskProject::getTotalWeight, totalWeight)
         );
      return ResultBuilder.success("接收成功");
   }

   public void getTaskProject(List<TechMachinePart> techMachinePart, Long projectId, String a) {
      Map<String, List<TechMachinePart>> collect = techMachinePart.stream().collect(Collectors.groupingBy(TechMachinePart::getThick));
      Iterator<Entry<String, List<TechMachinePart>>> entries = collect.entrySet().iterator();
      ContractProject byId1 = this.contractProjectService.getById(projectId);

      while (entries.hasNext()) {
         Entry<String, List<TechMachinePart>> entry = entries.next();
         String key = entry.getKey();
         List<TechMachinePart> value = entry.getValue();
         Map<String, List<TechMachinePart>> collectByMaterial = value.stream().collect(Collectors.groupingBy(TechMachinePart::getMaterial));

         for (Entry<String, List<TechMachinePart>> materialEntrie : collectByMaterial.entrySet()) {
            String key1 = materialEntrie.getKey();
            List<TechMachinePart> value1 = materialEntrie.getValue();
            int sum = value1.stream().mapToInt(TechMachinePart::getQuantity).sum();
            BigDecimal reduce = value1.stream().map(TechMachinePart::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
            ArrayList list1 = new ArrayList();
            String cutTaskId = RandomUtil.randomNumbers(16);
            CutTaskProject cutTaskProject = CutTaskProject.builder()
               .projectName(byId1.getName())
               .cutTaskId(cutTaskId)
               .cutTaskName(key + "mm" + key1 + a)
               .projectId(projectId)
               .areaName(list1.toString())
               .reduce(reduce)
               .sum(sum)
               .thick(value1.get(0).getThick())
               .relationType(value1.get(0).getRelationType())
               .material(value1.get(0).getMaterial())
               .state("0")
               .importTime(DateUtil.format(DateUtil.date(), "yyyy-MM-dd"))
               .currentName(UserUtil.getCurrentName())
               .build();
            this.cutTaskProjectService.save(cutTaskProject);
            value1.forEach(techMachinePart1 -> {
               techMachinePart1.setNestingState(1);
               this.techMachinePartService.updateById(techMachinePart1);
               this.cutTaskPartService.save(CutTaskPart.builder().cutTaskId(cutTaskId).partId(techMachinePart1.getId()).state("0").build());
            });
         }
      }
   }

   public List<TechMachinePart> getTechMachinePartListByAreaId(Long areaId) {
      List<TechMachinePart> techMachinePart1 = new ArrayList<>();
      List<TechMachinePart> list = this.techMachinePartService.list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getAreaId, areaId));
      List<Long> collect2 = list.stream().map(TechMachinePart::getId).collect(Collectors.toList());
      if (CollUtil.isNotEmpty(list)) {
         List<CutTaskPart> list1 = this.cutTaskPartService.list((Wrapper<CutTaskPart>)new LambdaQueryWrapper<CutTaskPart>().in(CutTaskPart::getPartId, collect2));
         if (CollUtil.isNotEmpty(list1)) {
            List<Long> collect1 = list1.stream().map(CutTaskPart::getPartId).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(collect1)) {
               techMachinePart1 = this.techMachinePartService.list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().in(TechMachinePart::getId, collect1));
            }
         }
      }

      return techMachinePart1;
   }

   public List getList() {
      ArrayList<Integer> objects = new ArrayList<>();
      objects.add(2);
      objects.add(16);
      return objects;
   }
}

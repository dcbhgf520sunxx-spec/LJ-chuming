package com.hzchum.scim.cut.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.cut.core.api.param.JobParam;
import com.hzchum.scim.cut.core.api.param.PartParam;
import com.hzchum.scim.cut.core.api.pojo._do.NestCutPlate;
import com.hzchum.scim.cut.core.api.pojo._do.NestCutPlatePart;
import com.hzchum.scim.cut.core.api.pojo._do.NestCutSurplus;
import com.hzchum.scim.cut.core.api.request.PartDTO;
import com.hzchum.scim.cut.core.api.request.PlatePartListDTO;
import com.hzchum.scim.cut.core.api.service.NestCutPlatePartService;
import com.hzchum.scim.cut.core.api.service.NestCutPlateService;
import com.hzchum.scim.cut.core.api.service.NestCutSurplusService;
import com.hzchum.scim.cut.core.mapper.NestCutPlateMapper;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingCutConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlateBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingCutConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NestCutPlateServiceImpl extends ServiceImpl<NestCutPlateMapper, NestCutPlate> implements NestCutPlateService {
   private static final Logger logger = LoggerFactory.getLogger(NestCutPlateServiceImpl.class);
   @Resource
   MesBuildingNestCutPlateBiz mesBuildingNestCutPlateBiz;
   @Resource
   private NestCutPlatePartService nestCutPlatePartService;
   @Resource
   private NestCutPlateService nestCutPlateService;
   @Resource
   private NestCutSurplusService nestCutSurplusService;
   @Resource
   private TechMachinePartService techMachinePartService;
   @Resource
   private MesBuildingMachinePartSchedulingBiz machinePartSchedulingBiz;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private PlanAreaService planAreaService;
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private MesBuildingMachinePartSchedulingLinkBiz mesBuildingMachinePartSchedulingLinkBiz;
   @Resource
   private MesBuildingCutConfigBiz mesBuildingCutConfigBiz;
   @Value("${endpoint}")
   private String endpoint;
   @Value("${accessKeyId}")
   private String accessKeyId;
   @Value("${accessKeySecret}")
   private String accessKeySecret;
   @Value("${importPartInfoUrl}")
   private String importPartInfoUrl;
   @Value("${importJobInfoUrl}")
   private String importJobInfoUrl;
   @Value("${updateNestsStatesUrl}")
   private String updateNestsStatesUrl;
   @Value("${authorization}")
   private String authorization;
   @Value("${expertUrl}")
   private String expertUrl;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO getPlateReport(String plateReport) {
      JSONObject jsonObject = JSON.parseObject(plateReport);
      logger.error("钢板报告:{}", jsonObject.toJSONString());
      JSONArray plateList1 = jsonObject.getJSONArray("plateList");
      String cutTaskId = jsonObject.getString("cutTaskId");
      List<NestCutPlate> list = this.nestCutPlateService.list((Wrapper<NestCutPlate>)new LambdaQueryWrapper<NestCutPlate>().eq(NestCutPlate::getCutTaskId, cutTaskId));
      Preconditions.checkArgument(list.size() == 0, "报告已上传");
      ArrayList<NestCutPlate> arrayList = new ArrayList<>();
      plateList1.forEach(plate -> {
         JSONObject plate1 = (JSONObject)plate;
         NestCutPlate nestCutPlate = JSON.toJavaObject((JSON)plate, NestCutPlate.class);
         String a = "00000";
         String b = nestCutPlate.getNcCode();
         if (a.length() - b.length() > 0) {
            String concat = a.substring(0, a.length() - b.length()).concat(b);
            nestCutPlate.setCutInstructionId(concat);
         } else {
            nestCutPlate.setCutInstructionId(nestCutPlate.getNcCode());
         }

         for (int i = 0; i < nestCutPlate.getNum(); i++) {
            String gCodePath = "https://cut-plant.oss-cn-hangzhou.aliyuncs.com/gCode/" + cutTaskId + "/" + nestCutPlate.getNcName();
            String pdfUrl = "https://cut-plant.oss-cn-hangzhou.aliyuncs.com/plateImg/" + cutTaskId + "/" + nestCutPlate.getPdfName();
            nestCutPlate.setOssKey("gCode/" + cutTaskId + "/" + nestCutPlate.getNcName());
            nestCutPlate.setNcUrl(gCodePath);
            nestCutPlate.setCutTaskId(cutTaskId);
            nestCutPlate.setPdfUrl(pdfUrl);
            this.nestCutPlateService.save(nestCutPlate);
            NestCutPlate nestCutPlate1 = new NestCutPlate();
            BeanUtil.copyProperties(nestCutPlate, nestCutPlate1);
            arrayList.add(nestCutPlate1);
         }

         JSONArray partList = (JSONArray)plate1.get("partList");
         partList.forEach(part -> {
            NestCutPlatePart cutPlatePart = JSON.toJavaObject((JSON)part, NestCutPlatePart.class);
            cutPlatePart.setCutInstructionId(nestCutPlate.getCutInstructionId());
            cutPlatePart.setCutTaskId(nestCutPlate.getCutTaskId());
            this.nestCutPlatePartService.save(cutPlatePart);
         });
         JSONArray surplusList = (JSONArray)plate1.get("surplusList");
         if (CollUtil.isNotEmpty(surplusList)) {
            surplusList.forEach(surplus -> {
               NestCutSurplus cutSurplus = JSON.toJavaObject((JSON)surplus, NestCutSurplus.class);
               String surplusImgUrl = "https://cut-plant.oss-cn-hangzhou.aliyuncs.com/surplusImg/" + cutTaskId + "/" + cutSurplus.getSurplusPictureName();
               cutSurplus.setSurplusPictureUrl(surplusImgUrl);
               cutSurplus.setPlantNo(nestCutPlate.getPlateNo());
               cutSurplus.setCutInstructionId(nestCutPlate.getCutInstructionId());
               cutSurplus.setMaterial(nestCutPlate.getMaterial());
               cutSurplus.setCutTaskId(nestCutPlate.getCutTaskId());
               this.nestCutSurplusService.save(cutSurplus);
            });
         }
      });
      arrayList.forEach(ad -> this.mesBuildingNestCutPlateBiz.saveMesBuildingNestCutPlate(ad));
      Boolean aBoolean = this.machinePartSchedulingBiz.updataIssueStatusEnum(cutTaskId);
      arrayList.forEach(ad -> {
         this.mesBuildingNestCutPlateBiz.saveMesBuildingNestCutPlate(ad);
         this.machinePartSchedulingBiz.updataIssueStatusEnum(cutTaskId);
      });
      return ResultBuilder.success("接收成功");
   }

   @Override
   public ResultVO uploadJobPart(List ids) {
      List<MesBuildingMachinePartScheduling> list = this.machinePartSchedulingBiz.listByIds(ids);
      JSONObject jsonObject = new JSONObject();
      JSONObject PartJsonObject = new JSONObject();
      list.forEach(
         task -> {
            MesBuildingCutConfig byId2 = this.mesBuildingCutConfigBiz.getById(task.getCutConfigId());
            ArrayList<Object> taskList = new ArrayList<>();
            ArrayList<Object> partList = new ArrayList<>();
            List<MesBuildingMachinePartSchedulingLink> list1 = this.mesBuildingMachinePartSchedulingLinkBiz
               .list(
                  (Wrapper<MesBuildingMachinePartSchedulingLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingLink>()
                     .eq(MesBuildingMachinePartSchedulingLink::getSchedulingId, task.getId())
               );
            list1.forEach(
               part -> {
                  JobParam jobParam = JobParam.builder()
                     .prdRefDst(part.getPrdRef())
                     .material(task.getMaterial())
                     .quantity(part.getQuantity())
                     .thickness(Double.valueOf(task.getThick()))
                     .machine(byId2.getName())
                     .build();
                  TechMachinePart byId = this.techMachinePartService.getById(part.getProductId());
                  if (!MachinePartRelationTypeEnum.SPACER_PARALLEL.getType().equals(byId.getRelationType())) {
                     ContractProject byId1 = this.contractProjectService.getById(byId.getProjectId());
                     PlanMonomer planMonomer = this.planMonomerService.getById(byId.getMonomerId());
                     PlanArea planArea = this.planAreaService.getById(byId.getAreaId());
                     PartParam partParam = PartParam.builder()
                        .quantity(byId.getQuantity())
                        .userdata1(byId1.getSerialNumber() + " " + byId1.getShortName())
                        .machine(byId2.getName())
                        .userdata3(String.valueOf(byId.getId()))
                        .userdata4(planMonomer.getName())
                        .userdata5(planArea.getName())
                        .downloadUrl(byId.getPath())
                        .objectName(byId.getOssRelativePath())
                        .prdRefDst(part.getPrdRef())
                        .material(task.getMaterial())
                        .userdata2(byId.getSerialNumber())
                        .thickness(Double.valueOf(task.getThick()))
                        .build();
                     partList.add(partParam);
                     jsonObject.put("fileName", byId1.getShortName());
                  } else {
                     PartParam partParam = PartParam.builder()
                        .quantity(byId.getQuantity())
                        .userdata1("/")
                        .machine(byId2.getName())
                        .userdata3(String.valueOf(byId.getId()))
                        .downloadUrl(byId.getPath())
                        .objectName(byId.getOssRelativePath())
                        .prdRefDst(part.getPrdRef())
                        .material(task.getMaterial())
                        .userdata2(byId.getSerialNumber())
                        .thickness(Double.valueOf(task.getThick()))
                        .build();
                     partList.add(partParam);
                  }

                  taskList.add(jobParam);
               }
            );
            PartJsonObject.put("id", "");
            PartJsonObject.put("name", "");
            PartJsonObject.put("timestamp", 0);
            PartJsonObject.put("partList", partList);
            jsonObject.put("id", "");
            jsonObject.put("name", "");
            jsonObject.put("timestamp", 0);
            jsonObject.put("jobRef", task.getOrderNumber());
            jsonObject.put("jobName", task.getOrderNumber());
            jsonObject.put("partList", taskList);
            HttpResponse response1 = HttpRequest.post(this.expertUrl + this.importPartInfoUrl)
               .header("Authorization", this.authorization)
               .body(PartJsonObject.toJSONString())
               .timeout(300000)
               .execute();
            Preconditions.checkArgument(response1.getStatus() == 200, "零件下发失败，请检查expert接口");
            if (response1.getStatus() == 200) {
               logger.info("零件上传成功:{}", PartJsonObject);
            } else {
               String body = response1.body();
               JSONObject jsonObject1 = JSONObject.parseObject(body);
               Object data = jsonObject1.get("data");
               logger.info("错误原因:{}", jsonObject1.getString("message") + "错误零件图:" + data.toString());
            }

            HttpResponse response = HttpRequest.post(this.expertUrl + this.importJobInfoUrl)
               .header("Authorization", this.authorization)
               .body(jsonObject.toJSONString())
               .timeout(300000)
               .execute();
            Preconditions.checkArgument(response.getStatus() == 200, "任务下发失败，请检查expert接口");
            if (response.getStatus() == 200) {
               logger.info("任务上传成功:{}", jsonObject.toJSONString());
            }
         }
      );
      return ResultBuilder.success("发送成功");
   }

   @Override
   public ResultVO addJobPart(Map<Long, Integer> map) {
      List<MesBuildingMachinePartSchedulingLink> list1 = this.mesBuildingMachinePartSchedulingLinkBiz.listByIds(map.keySet());
      MesBuildingMachinePartSchedulingLink mesBuildingMachinePartSchedulingLink = list1.get(0);
      MesBuildingMachinePartScheduling task = this.machinePartSchedulingBiz.getById(mesBuildingMachinePartSchedulingLink.getSchedulingId());
      MesBuildingCutConfig byId2 = this.mesBuildingCutConfigBiz.getById(task.getCutConfigId());
      JSONObject jsonObject = new JSONObject();
      JSONObject partJsonObject = new JSONObject();
      ArrayList<Object> taskList = new ArrayList<>();
      ArrayList<Object> partList = new ArrayList<>();
      list1.forEach(
         part -> {
            JobParam jobParam = JobParam.builder()
               .prdRefDst(part.getPrdRef())
               .material(task.getMaterial())
               .quantity(map.get(part.getId()))
               .thickness(Double.valueOf(task.getThick()))
               .machine(byId2.getName())
               .build();
            TechMachinePart byId = this.techMachinePartService.getById(part.getProductId());
            if (!MachinePartRelationTypeEnum.SPACER_PARALLEL.getType().equals(byId.getRelationType())) {
               ContractProject byId1 = this.contractProjectService.getById(byId.getProjectId());
               PlanMonomer planMonomer = this.planMonomerService.getById(byId.getMonomerId());
               PlanArea planArea = this.planAreaService.getById(byId.getAreaId());
               PartParam partParam = PartParam.builder()
                  .quantity(byId.getQuantity())
                  .userdata1(byId1.getSerialNumber() + " " + byId1.getShortName())
                  .machine(byId2.getName())
                  .userdata3(String.valueOf(byId.getId()))
                  .userdata4(planMonomer.getName())
                  .userdata5(planArea.getName())
                  .downloadUrl(byId.getPath())
                  .objectName(byId.getOssRelativePath())
                  .prdRefDst(part.getPrdRef())
                  .material(task.getMaterial())
                  .userdata2(byId.getSerialNumber())
                  .thickness(Double.valueOf(task.getThick()))
                  .build();
               partList.add(partParam);
            } else {
               PartParam partParam = PartParam.builder()
                  .quantity(map.get(part.getId()))
                  .userdata1("/")
                  .machine(byId2.getName())
                  .userdata3(String.valueOf(byId.getId()))
                  .downloadUrl(byId.getPath())
                  .objectName(byId.getOssRelativePath())
                  .prdRefDst(part.getPrdRef())
                  .material(task.getMaterial())
                  .userdata2(byId.getSerialNumber())
                  .thickness(Double.valueOf(task.getThick()))
                  .build();
               partList.add(partParam);
            }

            taskList.add(jobParam);
         }
      );
      partJsonObject.put("id", "");
      partJsonObject.put("name", "");
      partJsonObject.put("timestamp", 0);
      partJsonObject.put("partList", partList);
      jsonObject.put("id", "");
      jsonObject.put("name", "");
      jsonObject.put("timestamp", 0);
      jsonObject.put("jobRef", task.getOrderNumber());
      jsonObject.put("jobName", task.getOrderNumber());
      jsonObject.put("partList", taskList);
      HttpResponse response1 = HttpRequest.post(this.expertUrl + this.importPartInfoUrl)
         .header("Authorization", this.authorization)
         .body(partJsonObject.toJSONString())
         .timeout(300000)
         .execute();
      if (response1.getStatus() == 200) {
         logger.info("零件追加成功:{}", partJsonObject);
      }

      Preconditions.checkArgument(response1.getStatus() == 200, "零件下发失败，请检查expert接口");
      HttpResponse response = HttpRequest.post(this.expertUrl + this.importJobInfoUrl)
         .header("Authorization", this.authorization)
         .body(jsonObject.toJSONString())
         .timeout(300000)
         .execute();
      Preconditions.checkArgument(response.getStatus() == 200, "任务下发失败，请检查expert接口");
      return ResultBuilder.failed("发送成功");
   }

   @Override
   public ResultVO getPlatePartList(String barcode) {
      NestCutPlate nestCutPlate = this.nestCutPlateService
         .getOne((Wrapper<NestCutPlate>)new LambdaQueryWrapper<NestCutPlate>().eq(NestCutPlate::getCutInstructionId, barcode));
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(nestCutPlate), "排样图不存在");
      List<NestCutPlatePart> list1 = this.nestCutPlatePartService
         .list((Wrapper<NestCutPlatePart>)new LambdaQueryWrapper<NestCutPlatePart>().eq(NestCutPlatePart::getCutInstructionId, barcode));
      List<NestCutSurplus> list2 = this.nestCutSurplusService
         .list((Wrapper<NestCutSurplus>)new LambdaQueryWrapper<NestCutSurplus>().eq(NestCutSurplus::getCutInstructionId, barcode));
      PlatePartListDTO platePartListDTO = new PlatePartListDTO();
      platePartListDTO.setNcName(nestCutPlate.getNcName());
      platePartListDTO.setSpecification(nestCutPlate.getLength() + "*" + nestCutPlate.getWidth() + "*" + nestCutPlate.getThick());
      platePartListDTO.setMaterial(nestCutPlate.getMaterial());
      double sum11 = list2.stream()
         .filter(item -> StrUtil.isNotEmpty(item.getWeight()))
         .collect(Collectors.summarizingDouble(item -> Double.valueOf(item.getWeight())))
         .getSum();
      platePartListDTO.setSurplusWeight(sum11);
      platePartListDTO.setThick(nestCutPlate.getThick());
      platePartListDTO.setNum(list1.stream().mapToInt(NestCutPlatePart::getQuantity).sum());
      ArrayList<PartDTO> partDTOS = new ArrayList<>();
      list1.forEach(part -> {
         BigDecimal multiply = part.getWeight().multiply(BigDecimal.valueOf(part.getQuantity().intValue()));
         partDTOS.add(new PartDTO(part.getPartId(), part.getQuantity(), multiply, part.getWeight()));
      });
      platePartListDTO.setList(partDTOS);
      return ResultBuilder.success(platePartListDTO);
   }

   @Override
   public ResultVO uploadJob(List ids) {
      List<MesBuildingMachinePartScheduling> list = this.machinePartSchedulingBiz.listByIds(ids);
      JSONObject jsonObject = new JSONObject();
      list.forEach(
         task -> {
            MesBuildingCutConfig byId2 = this.mesBuildingCutConfigBiz.getById(task.getCutConfigId());
            ArrayList<Object> taskList = new ArrayList<>();
            List<MesBuildingMachinePartSchedulingLink> list1 = this.mesBuildingMachinePartSchedulingLinkBiz
               .list(
                  (Wrapper<MesBuildingMachinePartSchedulingLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingLink>()
                     .eq(MesBuildingMachinePartSchedulingLink::getSchedulingId, task.getId())
               );
            list1.forEach(
               part -> {
                  JobParam jobParam = JobParam.builder()
                     .prdRefDst(part.getPrdRef())
                     .material(task.getMaterial())
                     .quantity(part.getQuantity())
                     .thickness(Double.valueOf(task.getThick()))
                     .machine(byId2.getName())
                     .build();
                  taskList.add(jobParam);
               }
            );
            jsonObject.put("id", "");
            jsonObject.put("name", "");
            jsonObject.put("timestamp", 0);
            jsonObject.put("jobRef", task.getOrderNumber());
            jsonObject.put("jobName", task.getOrderNumber());
            jsonObject.put("partList", taskList);
         }
      );
      logger.info("任务:{}", jsonObject.toJSONString());
      return ResultBuilder.success(jsonObject);
   }

   @Override
   public ResultVO updateNestsStates(String ncCode) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("id", "");
      jsonObject.put("timestamp", "0");
      jsonObject.put("nstRef", ncCode);
      HttpResponse response = HttpRequest.post(this.updateNestsStatesUrl)
         .header("Authorization", this.authorization)
         .body(jsonObject.toJSONString())
         .timeout(300000)
         .execute();
      return ResultBuilder.success("解锁成功");
   }
}

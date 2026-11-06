package com.hzchum.scim.rest.controller.cut.lantek;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.cut.core.api.enums.DetailEnum;
import com.hzchum.scim.cut.core.api.param.TaskParam;
import com.hzchum.scim.cut.core.api.pojo._do.CutMachine;
import com.hzchum.scim.cut.core.api.pojo._do.CutPlate;
import com.hzchum.scim.cut.core.api.pojo._do.CutSurplus;
import com.hzchum.scim.cut.core.api.request.MachineInformationDTO;
import com.hzchum.scim.cut.core.api.request.PlateExport;
import com.hzchum.scim.cut.core.api.service.CutMachineService;
import com.hzchum.scim.cut.core.api.service.CutPlatePartService;
import com.hzchum.scim.cut.core.api.service.CutPlateService;
import com.hzchum.scim.cut.core.api.service.CutSurplusService;
import com.hzchum.scim.cut.core.api.service.MachineInformationService;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart.TechMachinePartBuilder;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "切割")
@RestController
@RequestMapping("/api/cut")
public class CutController {
   private static final Logger log = LoggerFactory.getLogger(CutController.class);
   @Resource
   private CutMachineService machineService;
   @Resource
   private CutPlateService plateService;
   @Resource
   private CutSurplusService cutSurplusService;
   @Resource
   private TechMachinePartService techMachinePartService;
   @Resource
   private CutPlatePartService cutPlatePartService;
   @Resource
   private MachineInformationService machineInformationService;

   @ApiOperation("项目数据页面查询")
   @GetMapping("/getPlant")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true),
            @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "List<String>")
      }
   )
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
      @RequestParam(required = false, name = "sort") List<String> sort,
      Long plateID
   ) {
      return this.plateService
         .getPlant(projectId, projectName, thick, plateType, importTime, mac, plateState, material, machineName, pageNumber, pageSize, sort, plateID);
   }

   @ApiOperation("删除板材")
   @DeleteMapping("/deletePlant/{id}")
   public ResultVO deletePlant(@PathVariable("id") Long id) {
      this.plateService.removeById(id);
      return ResultBuilder.success("删除成功");
   }

   @ApiOperation("id查询钢板信息")
   @GetMapping("/getPlantById/{id}")
   public ResultVO getPlantById(@PathVariable("id") Long id) {
      CutPlate byId = this.plateService.getById(id);
      return ResultBuilder.success(byId);
   }

   @ApiOperation("获取切割设备列表")
   @GetMapping("/getMachine")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   @PreAuthorize("@permission.check('machine_configuration:get')")
   public ResultVO getMachine(
      Integer pageNumber,
      Integer pageSize,
      String machineNumber,
      String machineName,
      Integer state,
      String machineType,
      Long factoryId,
      Long workshopInfId,
      @RequestParam(required = false, name = "sort") List<String> sort,
      String online
   ) {
      return this.machineService.getMachine(pageNumber, pageSize, machineNumber, machineName, state, machineType, factoryId, workshopInfId, sort, online);
   }

   @ApiOperation("增加切割设备")
   @PostMapping("/addMachine")
   @ApiImplicitParam(name = "Machine", value = "Machine", required = true, dataType = "CutMachine")
   public ResultVO addMachine(@RequestBody CutMachine machine) {
      machine.setCreateTime(LocalDateTime.now());
      return ResultBuilder.success(this.machineService.save(machine));
   }

   @ApiOperation("删除切割设备")
   @DeleteMapping("/deleteMachine/{id}")
   @PreAuthorize("@permission.check('machine_configuration:del')")
   public ResultVO deleteMachine(@PathVariable("id") Long id) {
      return ResultBuilder.success(this.machineService.removeById(id));
   }

   @ApiOperation("修改切割设备")
   @PostMapping("/updateMachine")
   @ApiImplicitParam(name = "machine", value = "Machine", required = true, dataType = "CutMachine")
   @PreAuthorize("@permission.check('machine_configuration:edit')")
   public ResultVO updateMachine(@RequestBody CutMachine machine) {
      return ResultBuilder.success(this.machineService.updateById(machine));
   }

   @ApiOperation("分配任务")
   @PostMapping("/assign")
   @ApiImplicitParam(name = "TaskParam", value = "任务参数", required = true, dataType = "TaskParam")
   public ResultVO assignTasks(@RequestBody List<TaskParam> list) {
      list.forEach(
         plate -> {
            CutMachine one = this.machineService.getOne((Wrapper<CutMachine>)new LambdaQueryWrapper<CutMachine>().eq(CutMachine::getMac, plate.getMac()));
            this.plateService
               .update(
                  (Wrapper<CutPlate>)((((((new LambdaUpdateWrapper<CutPlate>()
                                       .eq(CutPlate::getId, plate.getPlantId()))
                                    .eq(CutPlate::getPlateState, DetailEnum.UNASSIGNED.getCode()))
                                 .set(CutPlate::getMac, plate.getMac()))
                              .set(CutPlate::getPlateState, DetailEnum.ASSIGNED.getCode()))
                           .set(CutPlate::getAllocateTime, LocalDateTime.now()))
                        .set(CutPlate::getMachineName, one.getMachineName()))
                     .set(CutPlate::getEndTime, plate.getEndTime())
               );
         }
      );
      return ResultBuilder.success("任务分配成功");
   }

   @ApiOperation("下发任务")
   @PostMapping("/sentTask")
   @ApiImplicitParam(name = "list", value = "List<Long>", required = true, dataType = "List<Long>")
   public ResultVO sentTask(@RequestBody List<Long> list) {
      this.plateService
         .update(
            (Wrapper<CutPlate>)((new LambdaUpdateWrapper<CutPlate>().in(CutPlate::getId, list))
                  .eq(CutPlate::getPlateState, DetailEnum.ASSIGNED.getCode()))
               .set(CutPlate::getPlateState, DetailEnum.ISSUED.getCode())
         );
      return ResultBuilder.success("下发任务成功");
   }

   @ApiOperation("查看单机已下发")
   @GetMapping("/getTaskByMac/{mac}")
   public ResultVO getTaskByMac(@PathVariable("mac") String mac) {
      List<CutPlate> list = this.plateService
         .list(
            (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getMac, mac))
               .eq(CutPlate::getPlateState, DetailEnum.ISSUED.getCode())
         );
      return ResultBuilder.success(list);
   }

   @ApiOperation("清除任务")
   @PostMapping("/cleanTask")
   @ApiImplicitParam(name = "list", value = "List<Long>", required = false, dataType = "List<Long>")
   public ResultVO cleanTask(@RequestBody List<Long> list, String mac) {
      this.plateService
         .update(
            (Wrapper<CutPlate>)(((((new LambdaUpdateWrapper<CutPlate>()
                              .in(CollUtil.isNotEmpty(list), CutPlate::getId, list))
                           .eq(CutPlate::getPlateState, DetailEnum.ASSIGNED.getCode()))
                        .eq(CutPlate::getMac, mac))
                     .set(CutPlate::getMac, ""))
                  .set(CutPlate::getMachineName, ""))
               .set(CutPlate::getPlateState, DetailEnum.UNASSIGNED.getCode())
         );
      return ResultBuilder.success("清除任务成功");
   }

   @ApiOperation("重置任务")
   @PostMapping("/resetTask")
   @ApiImplicitParam(name = "list", value = "List<Long>", required = false, dataType = "List<Long>")
   public ResultVO resetTask(@RequestBody List<Long> list) {
      this.plateService
         .update(
            (Wrapper<CutPlate>)(((new LambdaUpdateWrapper<CutPlate>()
                        .in(CollUtil.isNotEmpty(list), CutPlate::getId, list))
                     .set(CutPlate::getMac, ""))
                  .set(CutPlate::getMachineName, ""))
               .set(CutPlate::getPlateState, DetailEnum.UNASSIGNED.getCode())
         );
      return ResultBuilder.success("重置任务成功");
   }

   @ApiOperation("转产")
   @PostMapping("/changeTask")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "list", value = "List<Long>", required = true, dataType = "List<Long>"),
            @ApiImplicitParam(name = "mac", value = "String", required = true, dataType = "String")
      }
   )
   public ResultVO changeTask(@RequestBody List<Long> list, String mac) {
      this.plateService
         .update(
            (Wrapper<CutPlate>)((new LambdaUpdateWrapper<CutPlate>().in(CollUtil.isNotEmpty(list), CutPlate::getId, list))
                  .eq(CutPlate::getPlateState, DetailEnum.ASSIGNED.getCode()))
               .set(CutPlate::getMac, mac)
         );
      return ResultBuilder.success("转产成功");
   }

   @ApiOperation("扫码切割")
   @PostMapping("/contrastPlant")
   public ResultVO contrastPlant(String taskId, String barcode, String mac) {
      return this.plateService.contrastPlant(taskId, barcode, mac);
   }

   @ApiOperation("查看已下发/未收到的任务")
   @PostMapping("/getPlantSendState/{mac}")
   public ResultVO getPlantSendState(@PathVariable("mac") String mac) {
      List<CutPlate> list = this.plateService
         .list(
            (Wrapper<CutPlate>)((new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getPlateState, DetailEnum.ISSUED.getCode()))
                  .eq(CutPlate::getTaskSendState, DetailEnum.ASSIGNED.getCode()))
               .eq(CutPlate::getMac, mac)
         );
      return ResultBuilder.success(list);
   }

   @ApiOperation("查看已收到的任务")
   @GetMapping("/getPlantSendState1/{mac}")
   public ResultVO getPlantSendState1(@PathVariable("mac") String mac) {
      List<CutPlate> list = this.plateService
         .list(
            (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getTaskSendState, DetailEnum.ISSUED.getCode()))
               .eq(CutPlate::getMac, mac)
         );
      return ResultBuilder.success(list);
   }

   @ApiOperation("查看已暂停任务")
   @GetMapping("/getPlant/{mac}")
   @ApiImplicitParam(name = "mac", value = "String", required = true, dataType = "String")
   public ResultVO getPlant(@PathVariable("mac") String mac) {
      List<CutPlate> list = this.plateService
         .list(
            (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getMac, mac))
               .eq(CutPlate::getPlateState, DetailEnum.SUSPEND.getCode())
         );
      return ResultBuilder.success(list);
   }

   @ApiOperation("mac地址查机器")
   @GetMapping("/getMachine/{mac}")
   @ApiImplicitParam(name = "mac", value = "String", required = true, dataType = "String")
   public ResultVO getMachine(@PathVariable("mac") String mac) {
      CutMachine machineServiceOne = this.machineService.getOne((Wrapper<CutMachine>)new LambdaQueryWrapper<CutMachine>().eq(CutMachine::getMac, mac));
      return ResultBuilder.success(machineServiceOne);
   }

   @ApiOperation("切割指令号查看余料")
   @GetMapping("/getCutSurplus/{taskId}")
   @ApiImplicitParam(name = "taskId", value = "String", required = true, dataType = "String")
   public ResultVO getCutSurplus(@PathVariable("taskId") String taskId) {
      List<CutSurplus> list = this.cutSurplusService.list((Wrapper<CutSurplus>)new LambdaQueryWrapper<CutSurplus>().eq(CutSurplus::getTaskId, taskId));
      return ResultBuilder.success(list);
   }

   @ApiOperation("nc文件查钢板")
   @GetMapping("/getPlantByFileName/{fileName}")
   @ApiImplicitParam(name = "fileName", value = "String", required = true, dataType = "String")
   public ResultVO getPlantByFileName(@PathVariable("fileName") String fileName) {
      List<CutPlate> list = this.plateService
         .list(
            (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getNcName, fileName))
               .eq(CutPlate::getPlateState, DetailEnum.CUTTING.getCode())
         );
      return ResultBuilder.success(list);
   }

   @ApiOperation("看零件信息")
   @GetMapping("/getCutPart/{taskId}")
   @ApiImplicitParam(name = "cutInstructionId", value = "String", required = true, dataType = "String")
   public ResultVO getCutPart(@PathVariable("taskId") String taskId) {
      return ResultBuilder.success(this.cutPlatePartService.getCutPart(taskId));
   }

   @ApiOperation("暂停任务")
   @PostMapping("/suspendTask")
   @ApiImplicitParam(name = "id", value = "List<Long>", required = true, dataType = "List<Long>")
   public ResultVO suspendTask(@RequestBody List<Long> id) {
      this.plateService
         .update(
            (Wrapper<CutPlate>)(new LambdaUpdateWrapper<CutPlate>().in(CollUtil.isNotEmpty(id), CutPlate::getId, id))
               .set(CutPlate::getPlateState, DetailEnum.SUSPEND.getCode())
         );
      return ResultBuilder.success("暂停成功");
   }

   @ApiOperation("继续任务")
   @PostMapping("/continueTask")
   @ApiImplicitParam(name = "id", value = "List", required = true, dataType = "List")
   public ResultVO continueTask(@RequestBody List<Long> id) {
      this.plateService
         .update(
            (Wrapper<CutPlate>)((new LambdaUpdateWrapper<CutPlate>().in(CollUtil.isNotEmpty(id), CutPlate::getId, id))
                  .eq(CutPlate::getPlateState, DetailEnum.SUSPEND.getCode()))
               .set(CutPlate::getPlateState, DetailEnum.ISSUED.getCode())
         );
      return ResultBuilder.success("成功");
   }

   @ApiOperation("终止任务")
   @PostMapping("/stopTask")
   @ApiImplicitParam(name = "id", value = "List", required = true, dataType = "List")
   public ResultVO stopTask(@RequestBody List<Long> id) {
      this.plateService
         .update(
            (Wrapper<CutPlate>)((new LambdaUpdateWrapper<CutPlate>().in(CollUtil.isNotEmpty(id), CutPlate::getId, id))
                  .ne(CutPlate::getPlateState, DetailEnum.CUTTING.getCode()))
               .set(CutPlate::getPlateState, DetailEnum.TARMINATION.getCode())
         );
      return ResultBuilder.success("成功");
   }

   @ApiOperation("设备监控")
   @GetMapping("/getMachineInformation/{mac}")
   @ApiImplicitParam(name = "mac", value = "String", required = true, dataType = "String")
   public ResultVO stopTask(@PathVariable("mac") String mac) {
      MachineInformationDTO one = this.machineInformationService
         .getOne((Wrapper<MachineInformationDTO>)new LambdaQueryWrapper<MachineInformationDTO>().eq(MachineInformationDTO::getMac, mac));
      return ResultBuilder.success(one);
   }

   @ApiOperation("项目查排产")
   @GetMapping("/getNestingList")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true),
            @ApiImplicitParam(name = "getProjectNo", value = "String", required = false, dataType = "String")
      }
   )
   public ResultVO getNestingList(
      Integer pageNumber,
      Integer pageSize,
      String projectNo,
      String projectName,
      String importTime,
      @RequestParam(required = false, name = "sort") List<String> sort,
      Integer nestingState,
      Integer cutState
   ) {
      return this.plateService.getNestingList(pageNumber, pageSize, projectNo, projectName, importTime, sort, nestingState, cutState);
   }

   @ApiOperation("设备查看排产")
   @GetMapping("/getMachinePlateList")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true),
            @ApiImplicitParam(name = "projectNo", value = "String", required = false, dataType = "String")
      }
   )
   public ResultVO getMachinePlateList(
      Integer pageNumber,
      Integer pageSize,
      String mac,
      String machineName,
      Long factoryId,
      Long workshopInfId,
      LocalDateTime startTime,
      LocalDateTime endTime,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      return this.plateService.getMachinePlateList(pageNumber, pageSize, mac, machineName, factoryId, workshopInfId, startTime, endTime, sort);
   }

   @ApiOperation("设备查看生产零件")
   @GetMapping("/getMachinePartList")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true),
            @ApiImplicitParam(name = "projectNo", value = "String", required = false, dataType = "String")
      }
   )
   public ResultVO getMachinePartList(Integer pageNumber, Integer pageSize, String mac, @RequestParam(required = false, name = "sort") List<String> sort) {
      return this.plateService.getMachinePartList(pageNumber, pageSize, mac, sort);
   }

   @ApiOperation("mac地址查看生产零件详情")
   @GetMapping("/getPartListByMac/{mac}")
   @ApiImplicitParams(@ApiImplicitParam(name = "mac", value = "String", required = false, dataType = "String"))
   public ResultVO getPartListByMac(@PathVariable("mac") String mac) {
      return this.plateService.getPartListByMac(mac);
   }

   @ApiOperation("项目抬头")
   @GetMapping("/getProjectGuide/{projectId}")
   @ApiImplicitParams(@ApiImplicitParam(name = "projectId", value = "String", required = true, dataType = "Long"))
   public ResultVO getProjectGuide(@PathVariable Long projectId) {
      return this.plateService.getProjectGuide(projectId);
   }

   @ApiOperation("根据项目查看钢板清单页面导出excel")
   @GetMapping("/exportByProject")
   public void exportByProject(HttpServletResponse response, String projectId) {
      List<CutPlate> list1 = this.plateService.list((Wrapper<CutPlate>)new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getProjectNo, projectId));
      List<PlateExport> list = new ArrayList<>();
      list1.forEach(
         cutPlate -> list.add(
            PlateExport.builder()
               .projectName(cutPlate.getProjectName())
               .cutInstructionId(cutPlate.getCutInstructionId())
               .material(cutPlate.getMaterial())
               .thick(cutPlate.getThick())
               .length(cutPlate.getLength())
               .width(cutPlate.getWidth())
               .weight(cutPlate.getWeight())
               .build()
         )
      );
      list1.forEach(cutPlate -> list.add(PlateExport.builder().projectName(cutPlate.getProjectName()).build()));
      ExcelWriter writer = ExcelUtil.getWriter();
      writer.addHeaderAlias("projectName", "项目名称");
      writer.addHeaderAlias("cutInstructionId", "指令号");
      writer.addHeaderAlias("material", "材质");
      writer.addHeaderAlias("length", "长");
      writer.addHeaderAlias("width", "宽");
      writer.addHeaderAlias("thick", "厚");
      writer.addHeaderAlias("weight", "重量");
      writer.merge(2, "项目钢板表");
      writer.write(list, true);
      response.setContentType("application/vnd.ms-excel;charset=utf-8");
      String name = StrUtil.utf8Str("plate");
      response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls");
      ServletOutputStream out = null;

      try {
         out = response.getOutputStream();
         writer.flush(out, true);
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         writer.close();
      }

      IoUtil.close(out);
   }

   @ApiOperation("根据设备查看钢板下载excel")
   @GetMapping("/exportByMachine")
   public void exportByMachine(HttpServletResponse response, String mac) {
      List<CutPlate> list1 = this.plateService.list((Wrapper<CutPlate>)new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getMac, mac));
      List<PlateExport> list = new ArrayList<>();
      list1.forEach(
         cutPlate -> list.add(
            PlateExport.builder()
               .projectName(cutPlate.getProjectName())
               .cutInstructionId(cutPlate.getCutInstructionId())
               .material(cutPlate.getMaterial())
               .thick(cutPlate.getThick())
               .length(cutPlate.getLength())
               .width(cutPlate.getWidth())
               .weight(cutPlate.getWeight())
               .build()
         )
      );
      ExcelWriter writer = ExcelUtil.getWriter();
      writer.addHeaderAlias("projectName", "项目名称");
      writer.addHeaderAlias("cutInstructionId", "指令号");
      writer.addHeaderAlias("material", "材质");
      writer.addHeaderAlias("length", "长");
      writer.addHeaderAlias("width", "宽");
      writer.addHeaderAlias("thick", "厚");
      writer.addHeaderAlias("weight", "重量");
      writer.merge(2, "设备切割报表");
      writer.write(list, true);
      response.setContentType("application/vnd.ms-excel;charset=utf-8");
      String name = StrUtil.utf8Str("plate");
      response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls");
      ServletOutputStream out = null;

      try {
         out = response.getOutputStream();
         writer.flush(out, true);
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         writer.close();
      }

      IoUtil.close(out);
   }

   @ApiOperation("继续任务")
   @PutMapping("/continueTask1")
   public void test() {
      ExcelReader excelReader = ExcelUtil.getReader("D:\\opcua\\零件清单M.xls");

      for (List<Object> objects : excelReader.read(0, excelReader.getRowCount())) {
         String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
         OSS ossClient = new OSSClientBuilder().build(endpoint, java.util.Objects.requireNonNull(System.getenv("LJAPS_OSS_ACCESS_KEY_ID"), "LJAPS_OSS_ACCESS_KEY_ID is required"), java.util.Objects.requireNonNull(System.getenv("LJAPS_OSS_ACCESS_KEY_SECRET"), "LJAPS_OSS_ACCESS_KEY_SECRET is required"));
         PutObjectRequest putObjectRequest = new PutObjectRequest(
            "parts-list", "parts/" + objects.get(0).toString() + ".dxf", new File("D:\\opcua\\DXF\\" + objects.get(0).toString() + ".dxf")
         );
         String filePath = "https://parts-list.oss-cn-hangzhou.aliyuncs.com/parts/" + objects.get(0).toString() + ".dxf";
         PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
         System.out.println(putObjectResult.getVersionId());
         System.out.println(filePath);
         ossClient.shutdown();
         List<String> split = StrUtil.split(objects.get(1).toString(), '*', 0, true, true);
         TechMachinePartBuilder builder = TechMachinePart.builder();
         builder.projectId(Long.valueOf("42"))
            .monomerId(Long.valueOf("4"))
            .areaId(Long.valueOf("5"))
            .serialNumber(objects.get(0).toString())
            .name(objects.get(0).toString())
            .specification(objects.get(1).toString())
            .thick(split.get(0).replace("PL", ""))
            .length(BigDecimal.valueOf(Double.parseDouble(objects.get(4).toString())))
            .material(objects.get(3).toString())
            .quantity(Integer.valueOf(objects.get(2).toString()))
            .netWeight(BigDecimal.valueOf(Double.parseDouble(objects.get(5).toString())))
            .totalNetWeight(BigDecimal.valueOf(Double.parseDouble(objects.get(6).toString())))
            .path(filePath)
            .build();
         this.techMachinePartService.save(builder.build());
      }
   }
}

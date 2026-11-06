package com.hzchum.scim.rest.controller.mes.building.scheduling;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingArtifactSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingArtifactSchedulingDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.delete.MesBuildingArtifactSchedulingRecordDeleteVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.get.MesBuildingArtifactSchedulingAsssembleVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.get.MesBuildingArtifactSchedulingVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post.MesBuildingArtifactSchedulingSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.put.MesBuildingArtifactSchedulingRecordUpdateVORequest;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "MES构件排产")
@RestController
@RequestMapping("/api/mes/building/scheduling/artifact")
public class MesBuildingArtifactSchedulingController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingArtifactSchedulingController.class);
   @Resource
   private MesBuildingArtifactSchedulingBiz artifactSchedulingBiz;
   @Autowired
   private RedisUtils redisUtils;

   @ApiOperation("分页获取构件排产列表")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('mes_scheduling_artifact:get')")
   public ResultVO getArtifactPage(
      MesBuildingArtifactSchedulingVORequest voRequest,
      String sort,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：分页获取构件排产列表");
      return ResultBuilder.success(
         this.artifactSchedulingBiz.artifactByConditionPage(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class), sort, pageNumber, pageSize)
      );
   }

   @ApiOperation("获取构件排产汇总信息")
   @GetMapping("/summary")
   public ResultVO getArtifactSummary(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：获取构件排产汇总信息");
      return ResultBuilder.success(this.artifactSchedulingBiz.artifactByConditionSummary(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)));
   }

   @ApiOperation("获取产线类型列表")
   @GetMapping("/line/type/list")
   public ResultVO getProductionLineTypeList(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：获取产线类型列表");
      return ResultBuilder.success(
         new ListVO<>(this.artifactSchedulingBiz.getProductionLineTypeList(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)))
      );
   }

   @ApiOperation("获取构件排产类型汇总列表")
   @GetMapping("/type/list")
   public ResultVO getArtifactTypeList(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：获取构件排产类型汇总列表");
      return ResultBuilder.success(
         new ListVO<>(this.artifactSchedulingBiz.getArtifactTypeList(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)))
      );
   }

   @ApiOperation("获取构件排产名称汇总列表")
   @GetMapping("/name/list")
   public ResultVO getArtifactNameList(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：获取构件排产名称汇总列表");
      return ResultBuilder.success(
         new ListVO<>(this.artifactSchedulingBiz.getArtifactNameList(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)))
      );
   }

   @ApiOperation("保存构件排产")
   @PostMapping("")
   @PreAuthorize("@permission.check('mes_scheduling_artifact:save')")
   public ResultVO saveArtifactSchedulingList(@RequestBody @Validated List<MesBuildingArtifactSchedulingSaveVORequest> voRequestList) {
      log.info("API 调用 ：保存构件排产");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .saveArtifactSchedulingList(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("保存构件排产")
   @PostMapping("/new")
   @PreAuthorize("@permission.check('mes_scheduling_artifact:save')")
   public ResultVO saveArtifactSchedulingList2(@RequestBody @Validated List<MesBuildingArtifactSchedulingSaveVORequest> voRequestList) {
      log.info("API 调用 ：保存构件排产");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .saveArtifactSchedulingList2(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("获取班组上一次排产要求完成时间")
   @PostMapping("last/scheduling/ask_time")
   public ResultVO getAllTeamLastAskTime() {
      log.info("API 调用 ：获取班组上一次排产要求完成时间");
      return ResultBuilder.success(this.redisUtils.hmget("scheduling_overweight:"));
   }

   @ApiOperation("获取构件排产记录")
   @GetMapping("/record/page")
   @PreAuthorize("@permission.check('mes_scheduling_artifact_record:get')")
   public ResultVO getArtifactSchedulingRecordPage(
      MesBuildingArtifactSchedulingVORequest voRequest,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取构件排产记录");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .getArtifactSchedulingRecordPage(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class), pageNumber, pageSize)
      );
   }

   @ApiOperation("获取构件排产记录")
   @GetMapping("/record")
   @PreAuthorize("@permission.check('mes_scheduling_artifact_record:get')")
   public ResultVO getArtifactSchedulingRecordPage(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：获取构件排产记录");
      return ResultBuilder.success(
         this.artifactSchedulingBiz.getArtifactSchedulingRecordList(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class))
      );
   }

   @ApiOperation("获取构件排产记录")
   @GetMapping("/v2/record")
   @PreAuthorize("@permission.check('mes_scheduling_artifact_record:get')")
   public ResultVO getArtifactSchedulingRecordPage2(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：获取构件排产记录");
      return ResultBuilder.success(
         this.artifactSchedulingBiz.getArtifactSchedulingRecordList2(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class))
      );
   }

   @ApiOperation("获取构件排产记录汇总")
   @GetMapping("/record/count")
   public ResultVO getArtifactSchedulingRecordCount(@RequestParam("areaIdList") List<Long> areaIdList) {
      log.info("API 调用 ：获取构件排产记录汇总");
      return ResultBuilder.success(this.artifactSchedulingBiz.getArtifactSchedulingRecordCount(areaIdList));
   }

   @ApiOperation("获取构件排产记录汇总")
   @GetMapping("/v2/record/count")
   public ResultVO getArtifactSchedulingRecordCount2(@RequestParam("areaIdList") List<Long> areaIdList) {
      log.info("API 调用 ：获取构件排产记录汇总");
      return ResultBuilder.success(this.artifactSchedulingBiz.getArtifactSchedulingRecordCount2(areaIdList));
   }

   @ApiOperation("获取构件预排产汇总信息")
   @GetMapping("/record/summary")
   public ResultVO getArtifactSchedulingRecordSummary(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：获取构件预排产汇总信息");
      return ResultBuilder.success(
         this.artifactSchedulingBiz.getArtifactSchedulingRecordSummary(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class))
      );
   }

   @ApiOperation("新获取构件预排产汇总信息")
   @GetMapping("/v2/record/summary")
   public ResultVO getArtifactSchedulingRecordSummary2(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：新获取构件预排产汇总信息");
      return ResultBuilder.success(
         this.artifactSchedulingBiz.getArtifactSchedulingRecordSummary2(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class))
      );
   }

   @ApiOperation("获取生产组构件预排产汇总信息")
   @GetMapping("/record/groups/summary")
   public ResultVO getGroupsRecordSummary(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：获取生产组构件预排产汇总信息");
      return ResultBuilder.success(
         new ListVO<>(this.artifactSchedulingBiz.getGroupsRecordSummary(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)))
      );
   }

   @ApiOperation("获取构件排产类型汇总列表")
   @GetMapping("/record/type/list")
   public ResultVO getArtifactRecordTypeList(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：分页获取构件排产类型汇总列表");
      return ResultBuilder.success(
         new ListVO<>(this.artifactSchedulingBiz.getArtifactRecordTypeList(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)))
      );
   }

   @ApiOperation("获取构件排产名称类型汇总列表")
   @GetMapping("/record/name/list")
   public ResultVO getArtifactRecordTypeList2(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：分页获取构件排产名称类型汇总列表");
      return ResultBuilder.success(
         new ListVO<>(this.artifactSchedulingBiz.getArtifactRecordNameList(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)))
      );
   }

   @ApiOperation("获取构件排产生产线类型列表")
   @GetMapping("/record/line/type/list")
   public ResultVO getRecordProductionLineTypeList(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：获取构件排产生产线类型列表");
      return ResultBuilder.success(
         new ListVO<>(this.artifactSchedulingBiz.getRecordProductionLineTypeList(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)))
      );
   }

   @ApiOperation("获取构件排产生产线类型汇总列表")
   @GetMapping("/record/production_type/list")
   public ResultVO getArtifactRecordProductionTypeList(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：分页获取构件排产类型汇总列表");
      return ResultBuilder.success(
         new ListVO<>(this.artifactSchedulingBiz.getArtifactRecordProductionTypeList(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)))
      );
   }

   @ApiOperation("修改构件排产记录")
   @PutMapping("/record")
   @PreAuthorize("@permission.check('mes_scheduling_artifact_record:edit')")
   public ResultVO updateArtifactScheduling(@RequestBody List<MesBuildingArtifactSchedulingRecordUpdateVORequest> voRequestList) {
      log.info("API 调用 ：修改构件排产记录");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .updateArtifactScheduling(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("修改构件排产记录")
   @PutMapping("/v2/record")
   @PreAuthorize("@permission.check('mes_scheduling_artifact_record:edit')")
   public ResultVO updateArtifactScheduling2(@RequestBody List<MesBuildingArtifactSchedulingRecordUpdateVORequest> voRequestList) {
      log.info("API 调用 ：修改构件排产记录");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .updateArtifactScheduling2(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("删除构件排产记录")
   @DeleteMapping("/record")
   @PreAuthorize("@permission.check('mes_scheduling_artifact_record:del')")
   public ResultVO deleteArtifactScheduling(@RequestBody List<MesBuildingArtifactSchedulingRecordDeleteVORequest> voRequestList) {
      log.info("API 调用 ：删除构件排产记录");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .deleteArtifactScheduling(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("获取计算下发构件所需部件数量列表")
   @PostMapping("/assemble")
   @PreAuthorize("@permission.check('mes_scheduling_assemble:get')")
   public ResultVO getArtifactSchedulingAssemble(@RequestBody List<MesBuildingArtifactSchedulingAsssembleVORequest> voRequestList) {
      log.info("API 调用 ：获取计算下发构件所需部件数量列表");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .getArtifactSchedulingAssemble(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("获取计算下发构件所需部件数量列表")
   @PostMapping("/v2/assemble")
   @PreAuthorize("@permission.check('mes_scheduling_assemble:get')")
   public ResultVO getArtifactSchedulingAssemble2(@RequestBody List<MesBuildingArtifactSchedulingAsssembleVORequest> voRequestList) {
      log.info("API 调用 ：获取计算下发构件所需部件数量列表");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .getArtifactSchedulingAssemble2(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("获取计算下发构件所需部件名称/规格/类型列表")
   @PostMapping("/v2/assemble/filter/criteria")
   public ResultVO getArtifactSchedulingAssembleFilterCriteria(@RequestBody List<MesBuildingArtifactSchedulingAsssembleVORequest> voRequestList) {
      log.info("API 调用 ：获取计算下发构件所需部件名称/规格/类型列表");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .getArtifactSchedulingAssembleFilterCriteria(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("下载 构件排产清单 导入模版")
   @GetMapping("/template/export")
   public void exportArtifactSchedulingTemplate(
      HttpServletResponse response, @RequestParam("areaId") Long areaId, Integer productType, Long structureClassId, Integer mesProductEnum
   ) {
      log.info("API 调用 ： 下载 构件排产清单 模版文件");
      this.artifactSchedulingBiz.exportArtifactSchedulingTemplateAV2(response, areaId, productType, structureClassId, mesProductEnum);
   }

   @ApiOperation(value = "构件排产清单excel导入", notes = "导入构件排产清单", httpMethod = "POST")
   @PostMapping("/import")
   @PreAuthorize("@permission.check('mes_scheduling_artifact:import')")
   @SignerCheck(lockKey = "#areaId", message = "操作失败,该区域正在导入排产清单，请稍后刷新重试")
   public ResultVO importArtifactScheduling(@RequestPart MultipartFile file, @RequestParam("areaId") Long areaId, Integer productType) throws IOException {
      log.info("Api调用: 构件排产清单导入接口");
      return ResultBuilder.success(this.artifactSchedulingBiz.importArtifactSchedulingAV2(file, areaId, productType));
   }

   @ApiOperation(value = "排产数据汇总", notes = "排产数据汇总")
   @GetMapping("/artifact/scheduling/summary")
   @PreAuthorize("@permission.check('scheduling_data:statistics')")
   public ResultVO artifactSchedulingSummary(
      LocalDateTime dateTime,
      Long workshopId,
      Integer type,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("Api调用: 排产数据汇总");
      return ResultBuilder.success(this.artifactSchedulingBiz.artifactSchedulingSummary(dateTime, workshopId, type, projectType, lumpSumSystemType));
   }

   @ApiOperation(value = "排产数据列表", notes = "排产数据列表")
   @GetMapping("/artifact/scheduling/list")
   @PreAuthorize("@permission.check('scheduling_data:get')")
   public ResultVO artifactSchedulingList(
      LocalDateTime dateTime,
      Long workshopId,
      Integer type,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("Api调用: 排产数据列表");
      return ResultBuilder.success(this.artifactSchedulingBiz.artifactSchedulingList(dateTime, workshopId, type, projectType, lumpSumSystemType));
   }

   @ApiOperation(value = "排产数据详情列表", notes = "排产数据详情列表")
   @GetMapping("/artifact/scheduling/detail/page")
   @PreAuthorize("@permission.check('scheduling_data:get')")
   public ResultVO artifactSchedulingDetailPage(
      LocalDateTime dateTime,
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("Api调用: 排产数据详情列表");
      return ResultBuilder.success(
         this.artifactSchedulingBiz.artifactSchedulingDetailPage(dateTime, workshopId, projectId, monomerId, areaId, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation(value = "排产数据详情打印", notes = "排产数据详情打印")
   @GetMapping("/artifact/scheduling/detail/print")
   public ResultVO artifactSchedulingDetailPrint(LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId, Long areaId, String serialNumber) {
      log.info("Api调用: 排产数据详情列表");
      return ResultBuilder.success(this.artifactSchedulingBiz.artifactSchedulingDetailPrint(dateTime, workshopId, projectId, monomerId, areaId, serialNumber));
   }

   @ApiOperation("生产监控看板汇总")
   @GetMapping("/product/monitor/kanban/summary")
   public ResultVO getProductMonitorKanbanSummary(
      Long workshopId,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("API 调用 ：生产监控看板汇总");
      return ResultBuilder.success(this.artifactSchedulingBiz.getProductMonitorKanbanSummary(workshopId, projectType, lumpSumSystemType));
   }

   @ApiOperation("生产监控看板")
   @GetMapping("/product/monitor/kanban")
   public ResultVO getProductMonitorKanbanPage(
      Long workshopId,
      Integer status,
      String name,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：生产监控看板");
      return ResultBuilder.success(
         this.artifactSchedulingBiz.getProductMonitorKanbanPage(workshopId, status, name, projectType, lumpSumSystemType, pageNumber, pageSize)
      );
   }

   @ApiOperation("生产监控看板详情")
   @GetMapping("/product/monitor/kanban/detail")
   public ResultVO getProductMonitorKanbanDetail(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：生产监控看板详情");
      return ResultBuilder.success(this.artifactSchedulingBiz.getProductMonitorKanbanDetail(workshopId, projectId, monomerId, areaId, pageNumber, pageSize));
   }

   @ApiOperation("生产监控看板详情打印")
   @GetMapping("/product/monitor/kanban/detail/print")
   public ResultVO getProductMonitorKanbanDetailPrint(Long workshopId, Long projectId, Long monomerId, Long areaId) {
      log.info("API 调用 ：生产监控看板详情");
      return ResultBuilder.success(this.artifactSchedulingBiz.getProductMonitorKanbanDetailPrint(workshopId, projectId, monomerId, areaId));
   }

   @ApiOperation("生产监控看板--班组状态")
   @GetMapping("/product/monitor/group")
   public ResultVO getProductMonitorKanbanByGroup(Long workshopId, Long processId, Integer taskTypeEnum) {
      log.info("API 调用 ：生产监控看板--班组状态");
      return ResultBuilder.success(this.artifactSchedulingBiz.getProductMonitorKanbanByGroup(workshopId, processId, taskTypeEnum));
   }

   @ApiOperation("生产监控看板--班组状态详情")
   @GetMapping("/product/monitor/group/detail")
   public ResultVO getProductMonitorKanbanByGroupDetail(
      Long workshopId,
      Long productionLineId,
      Long groupId,
      Long teamId,
      Long processId,
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：生产监控看板--班组状态详情");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .getProductMonitorKanbanByGroupDetail(
               workshopId, productionLineId, groupId, teamId, processId, taskTypeEnum, projectId, monomerId, areaId, serialNumber, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("生产监控看板--班组状态详情打印")
   @GetMapping("/product/monitor/group/detail/print")
   public ResultVO getProductMonitorKanbanByGroupDetailPrint(
      Long workshopId,
      Long productionLineId,
      Long groupId,
      Long teamId,
      Long processId,
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber
   ) {
      log.info("API 调用 ：生产监控看板--班组状态详情打印");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .getProductMonitorKanbanByGroupDetailPrint(
               workshopId, productionLineId, groupId, teamId, processId, taskTypeEnum, projectId, monomerId, areaId, serialNumber
            )
      );
   }

   @ApiOperation("产线下班组-已排产信息")
   @GetMapping("/scheduling/quantity")
   public ResultVO findTeamScheduledQuantity(Long workshopId, @RequestParam(required = false) Long projectId) {
      log.info("API 调用 ：产线下班组-已排产信息");
      return ResultBuilder.success(this.artifactSchedulingBiz.findTeamScheduledSummary(workshopId, projectId));
   }
}

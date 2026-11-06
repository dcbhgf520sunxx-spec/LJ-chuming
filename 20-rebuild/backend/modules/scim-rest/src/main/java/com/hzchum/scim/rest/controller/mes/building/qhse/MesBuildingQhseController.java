package com.hzchum.scim.rest.controller.mes.building.qhse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.building.core.api.biz.qhse.MesBuildingQhseBiz;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.qhse.MesBuildingQhseCountParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseAcceptDeviationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.MesBuildingCheckQhseDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.MesBuildingQhseDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.MesBuildingQhseRectifyDTOParam;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseAcceptDeviationService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.qhse.post.QhseSaveCheckRequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.qhse.post.QhseSaveRequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.qhse.post.RectifySaveRequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.qhse.post.RectifyUpdateVORequest;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MESQhse")
@RestController
@RequestMapping("/api/mes/building/qhse")
public class MesBuildingQhseController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingQhseController.class);
   @Autowired
   private MesBuildingQhseBiz qhseBiz;
   @Autowired
   private MesBuildingQhseService qhseService;
   @Resource
   private TechArtifactService artifactService;
   @Autowired
   private MesBuildingQhseAcceptDeviationService qhseAcceptDeviationService;

   @ApiOperation("获取QHSE")
   @GetMapping("/{id}")
   public ResultVO qhseById(@PathVariable Long id, Integer status) {
      log.info("API 调用 ：获取QHSE列表");
      return ResultBuilder.success(this.qhseBiz.getQhseById(id, status, UserUtil.getCurrentUserId()));
   }

   @ApiOperation("分页获取QHSE列表")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "QhseSaveVORequest", value = "QhseSaveVORequest", paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public ResultVO qhsePage(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "userName", required = false) String userName,
      @RequestParam(name = "dutyName", required = false) String dutyName,
      @RequestParam(name = "rectifyName", required = false) String rectifyName,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "type", required = false) Integer type,
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "boolApp", required = false, defaultValue = "true") Boolean boolApp,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize,
      @RequestParam(name = "userId", required = false) Long userId,
      @RequestParam(name = "qhseId", required = false) Long qhseId,
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "specifiedDate", required = false) LocalDateTime specifiedDate,
      @RequestParam(name = "processId", required = false) Long processId,
      @RequestParam(name = "levelOneType", required = false) Long levelOneType,
      @RequestParam(name = "levelTwoType", required = false) Long levelTwoType
   ) {
      log.info("API 调用 ：分页获取QHSE列表");
      if (boolApp == null) {
         boolApp = true;
      }

      return ResultBuilder.success(
         this.qhseBiz
            .qhsePage(
               qhseId,
               projectId,
               userName,
               dutyName,
               rectifyName,
               serialNumber,
               type,
               status,
               boolApp,
               userId == null ? UserUtil.getCurrentUserId() : userId,
               sort,
               pageNumber,
               pageSize,
               startDate,
               endDate,
               specifiedDate,
               null,
               processId,
               levelOneType,
               levelTwoType
            )
      );
   }

   @ApiOperation("分页获取QHSE列表")
   @GetMapping("/qhse_stats/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "QhseSaveVORequest", value = "QhseSaveVORequest", paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   @PreAuthorize("@permission.check('quality-problem-statistics:get')")
   public ResultVO qhseStatsPage(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "userName", required = false) String userName,
      @RequestParam(name = "dutyName", required = false) String dutyName,
      @RequestParam(name = "rectifyName", required = false) String rectifyName,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "type", required = false) Integer type,
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "boolApp", required = false, defaultValue = "true") Boolean boolApp,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize,
      @RequestParam(name = "userId", required = false) Long userId,
      @RequestParam(name = "qhseId", required = false) Long qhseId,
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "specifiedDate", required = false) LocalDateTime specifiedDate,
      @RequestParam(name = "processId", required = false) Long processId,
      @RequestParam(name = "levelOneType", required = false) Long levelOneType,
      @RequestParam(name = "levelTwoType", required = false) Long levelTwoType
   ) {
      log.info("API 调用 ：分页获取QHSE列表");
      if (boolApp == null) {
         boolApp = true;
      }

      return ResultBuilder.success(
         this.qhseBiz
            .qhsePage(
               qhseId,
               projectId,
               userName,
               dutyName,
               rectifyName,
               serialNumber,
               type,
               status,
               boolApp,
               null,
               sort,
               pageNumber,
               pageSize,
               startDate,
               endDate,
               specifiedDate,
               null,
               processId,
               levelOneType,
               levelTwoType
            )
      );
   }

   @ApiOperation("分页获取QHSE列表")
   @GetMapping("/simple/detail")
   public ResultVO qhseDetail(@RequestParam(name = "qhseId", required = false) Long qhseId) {
      log.info("API 调用 ：分页获取QHSE列表");
      return ResultBuilder.success(this.qhseBiz.qhseDetail(qhseId));
   }

   @ApiOperation("QHSE事件曝光下载")
   @GetMapping("/detail/{id}/download")
   public ResultVO qhseDetailDownload(@PathVariable Long id, HttpServletResponse response) {
      log.info("API 调用 ：QHSE事件曝光下载");
      return ResultBuilder.success(this.qhseBiz.qhseDetailDownload(id, response));
   }

   @ApiOperation("QHSE事件曝光批量下载")
   @PostMapping("/detail/download")
   public ResultVO qhseDetailDownload(@RequestBody List<Long> ids, HttpServletResponse response) {
      log.info("API 调用 ：QHSE事件曝光批量下载");
      return ResultBuilder.success(this.qhseBiz.qhseDetailAllDownload(ids, response));
   }

   @ApiOperation("新增Qhse")
   @PostMapping("")
   @PreAuthorize("@permission.check('assembleQualityManager','safetyEnvManagement')")
   public ResultVO qhseSave(@RequestBody @Valid QhseSaveRequest saveVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增Qhse");
      return ResultBuilder.success(this.qhseBiz.saveQhse(BeanUtil.copy(saveVORequest, MesBuildingQhseDTOParam.class).setUserId(UserUtil.getCurrentUserId())));
   }

   @ApiOperation("上一次抄送人")
   @GetMapping("/sendperson")
   public ResultVO LastSendPerson() {
      log.info("API 调用 ：上一次抄送人");
      return ResultBuilder.success(this.qhseBiz.LastSendPerson());
   }

   @ApiOperation("新增整改")
   @PostMapping("/rectify")
   public ResultVO saveQhseRectify(@RequestBody @Valid RectifySaveRequest saveVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增整改");
      return ResultBuilder.success(this.qhseBiz.saveQhseRectify(BeanUtil.copy(saveVORequest, MesBuildingQhseRectifyDTOParam.class)));
   }

   @ApiOperation("获取让步接收QHSE")
   @GetMapping("/accept/deviation/{id}")
   public ResultVO getAcceptOnDeviationById(@PathVariable Long id, Integer status) {
      log.info("API 调用 ：获取让步接收QHSE列表");
      return ResultBuilder.success(this.qhseBiz.getAcceptOnDeviationById(id, status, UserUtil.getCurrentUserId()));
   }

   @ApiOperation("新增让步接收审批")
   @PostMapping("/accept/deviation/add")
   public ResultVO addacceptOnDeviation(@RequestBody MesBuildingQhseAcceptDeviationDTO qhseAcceptDeviationDTO) {
      log.info("API 调用 ：新增让步接收审批");
      return ResultBuilder.success(this.qhseAcceptDeviationService.saveQhseAcceptDeviation(qhseAcceptDeviationDTO));
   }

   @ApiOperation("让步接收列表")
   @GetMapping("/accept/deviation/page")
   public ResultVO AcceptOnDeviationPage(
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：让步接收列表");
      return ResultBuilder.success(this.qhseAcceptDeviationService.findAcceptDeviationList(status, pageNumber, pageSize));
   }

   @ApiOperation("让步接收审核处理")
   @PutMapping("/accept/deviation/audit")
   public ResultVO editAcceptOnDeviation(@RequestBody MesBuildingQhseAcceptDeviationDTO qhseAcceptDeviationDTO) {
      log.info("API 调用 ：让步接收审核处理");
      return ResultBuilder.success(this.qhseAcceptDeviationService.updateQhseAcceptDeviation(qhseAcceptDeviationDTO));
   }

   @ApiOperation("修改qhse")
   @PutMapping("/close/{id}")
   public ResultVO updateQhseStatus(@PathVariable Long id) {
      log.info("API 调用 ：关闭qhse");
      return ResultBuilder.success(this.qhseBiz.updateQhseStatus(id, null));
   }

   @ApiOperation("拒绝整改")
   @PutMapping("/rectify")
   public ResultVO updateQhseRectify(@RequestBody @Valid RectifyUpdateVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：拒绝整改");
      return ResultBuilder.success(this.qhseBiz.updateQhseRectify(BeanUtil.copy(request, MesBuildingQhseRectifyDTOParam.class)));
   }

   @ApiOperation("变更整改")
   @PutMapping("/rectify/change")
   public ResultVO changeQhseRectify(@RequestBody @Valid RectifyUpdateVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：变更整改");
      return ResultBuilder.success(this.qhseBiz.changeQhseRectify(BeanUtil.copy(request, MesBuildingQhseRectifyDTOParam.class)));
   }

   @ApiOperation("查看")
   @GetMapping("/summary")
   public ResultVO qhseSummary(Long projectId) {
      log.info("API 调用 ：变更整改");
      return ResultBuilder.success(this.qhseBiz.qhseSummary(projectId));
   }

   @ApiOperation("查看qhse报表汇总")
   @GetMapping("/report/summary")
   public ResultVO findQhseReportSummary() {
      log.info("API 调用 ：查看qhse报表汇总");
      return ResultBuilder.success(
         this.qhseService.findQhseReportSummary(QhseTypeEnum.QUALITY.getType() | QhseTypeEnum.SPECIAL_QUALITY.getType() | QhseTypeEnum.SPOT_CHECK.getType())
      );
   }

   @ApiOperation("查看安全环境报表汇总")
   @GetMapping("/safety_and_quality/summary")
   public ResultVO findSafetyAndQualityReportSummary() {
      log.info("API 调用 ：查看安全环境报表汇总");
      return ResultBuilder.success(this.qhseService.findQhseReportSummary(QhseTypeEnum.SECURITY.getType() | QhseTypeEnum.ENVIRONMENT.getType()));
   }

   @ApiOperation("质检实时信息汇总")
   @GetMapping("/inspect/realtime/summary")
   public ResultVO findInspectRealtimeSummary(LocalDateTime date, Long workShopId, Long insepectUserId) {
      log.info("API 调用 ：查看安全环境报表汇总");
      return ResultBuilder.success(this.qhseService.findInspectRealtimeSummary(date, workShopId, insepectUserId));
   }

   @ApiOperation("质检实时信息")
   @GetMapping("/inspect/realtime/page")
   public ResultVO findInspectRealtimePage(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long workShopId,
      Long insepectUserId,
      Integer status,
      Long projectId,
      String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：质检实时信息");
      return ResultBuilder.success(
         this.qhseService.findInspectRealtimeInfos(startDate, endDate, projectId, workShopId, insepectUserId, status, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("质检统计列表")
   @GetMapping("/inspect/statistics")
   public ResultVO findInspectRealtimePage(
      MesBuildingQhseCountParam qhseCountParam,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：质检统计列表");
      return ResultBuilder.success(this.qhseService.findInspectCountDTO(qhseCountParam, pageNumber, pageSize));
   }

   @ApiOperation("质检统计列表 - 下载")
   @GetMapping("/inspect/statistics/download")
   public ResultVO findInspectRealtimeDownload(MesBuildingQhseCountParam qhseCountParam, HttpServletResponse response) {
      log.info("API 调用 ：质检统计列表 - 下载");
      return ResultBuilder.success(this.qhseService.findInspectCountDTODownload(qhseCountParam, response));
   }

   @ApiOperation("质检统计总数量")
   @GetMapping("/inspect/total_count")
   public ResultVO findInspectTotalCount(MesBuildingQhseCountParam qhseCountParam) {
      log.info("API 调用 ：质检统计总数量");
      return ResultBuilder.success(this.qhseService.findInspectTotalCount(qhseCountParam));
   }

   @ApiOperation(value = "质检统计-构件溯源", notes = "质检统计-构件溯源")
   @GetMapping("/source/report/list")
   public ResultVO newArtifactSourceReportProductList(Long taskProcessId, Long productId, Integer number) {
      log.info("API 调用 ：质检统计-构件溯源");
      return ResultBuilder.success(this.artifactService.newArtifactSourceReportProductList(taskProcessId, productId, number));
   }

   @ApiOperation("安环曝光")
   @GetMapping("/anhuan/exposure")
   public ResultVO anhuanExposure(
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：安环曝光");
      return ResultBuilder.success(this.qhseBiz.anhuanExposure(startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("分页导出QHSE列表")
   @GetMapping("/export/list")
   public void exportQhseList(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "userName", required = false) String userName,
      @RequestParam(name = "dutyName", required = false) String dutyName,
      @RequestParam(name = "rectifyName", required = false) String rectifyName,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "type", required = false) Integer type,
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "boolApp", required = false, defaultValue = "true") Boolean boolApp,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize,
      @RequestParam(name = "userId", required = false) Long userId,
      @RequestParam(name = "qhseId", required = false) Long qhseId,
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "specifiedDate", required = false) LocalDateTime specifiedDate,
      @RequestParam(name = "processId", required = false) Long processId,
      @RequestParam(name = "levelOneType", required = false) Long levelOneType,
      @RequestParam(name = "levelTwoType", required = false) Long levelTwoType,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：分页导出QHSE列表");
      if (boolApp == null) {
         boolApp = true;
      }

      this.qhseBiz
         .exportQhseList(
            qhseId,
            projectId,
            userName,
            dutyName,
            rectifyName,
            serialNumber,
            type,
            status,
            boolApp,
            userId == null ? UserUtil.getCurrentUserId() : userId,
            sort,
            pageNumber,
            pageSize,
            startDate,
            endDate,
            specifiedDate,
            null,
            processId,
            levelOneType,
            levelTwoType,
            response
         );
   }

   @ApiOperation("分页导出QHSE列表")
   @GetMapping("/export/qhse_stats")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "QhseSaveVORequest", value = "QhseSaveVORequest", paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public void exportQhseStats(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "userName", required = false) String userName,
      @RequestParam(name = "dutyName", required = false) String dutyName,
      @RequestParam(name = "rectifyName", required = false) String rectifyName,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "type", required = false) Integer type,
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "boolApp", required = false, defaultValue = "true") Boolean boolApp,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize,
      @RequestParam(name = "userId", required = false) Long userId,
      @RequestParam(name = "qhseId", required = false) Long qhseId,
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "specifiedDate", required = false) LocalDateTime specifiedDate,
      @RequestParam(name = "processId", required = false) Long processId,
      @RequestParam(name = "levelOneType", required = false) Long levelOneType,
      @RequestParam(name = "levelTwoType", required = false) Long levelTwoType,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：分页导出QHSE列表");
      if (boolApp == null) {
         boolApp = true;
      }

      this.qhseBiz
         .exportQhseStats(
            qhseId,
            projectId,
            userName,
            dutyName,
            rectifyName,
            serialNumber,
            type,
            status,
            boolApp,
            null,
            sort,
            pageNumber,
            pageSize,
            startDate,
            endDate,
            specifiedDate,
            null,
            processId,
            levelOneType,
            levelTwoType,
            response
         );
   }

   @ApiOperation("根据构件任务Id查询构件信息")
   @GetMapping("/task/product")
   public ResultVO getArtifactByTaskId(@RequestParam Long taskId, @RequestParam(required = false) Integer number) {
      log.info("Api调用: 根据构件任务Id查询构件信息");
      return ResultBuilder.success(this.qhseBiz.getArtifactByTaskId(taskId, number));
   }

   @ApiOperation("新增抽检信息")
   @PostMapping("/spot")
   @PreAuthorize("@permission.check('assembleQualityManager','safetyEnvManagement')")
   @SignerCheck(lockKey = "#saveVORequest.taskId", message = "当前任务正在新增抽检信息中,请稍后刷新重试")
   public ResultVO qhseSpotCheckSave(@RequestBody @Valid QhseSaveCheckRequest saveVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增抽检信息");
      return ResultBuilder.success(
         this.qhseBiz.saveQhseSpotCheck(BeanUtil.copy(saveVORequest, MesBuildingCheckQhseDTOParam.class).setUserId(UserUtil.getCurrentUserId()))
      );
   }

   @ApiOperation("抽检统计列表")
   @GetMapping("/spot/statistics")
   public ResultVO findSpotCheckListPage(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) String userName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：抽检统计列表");
      return ResultBuilder.success(this.qhseBiz.findSpotCheckListPage(projectId, projectName, userName, pageNumber, pageSize));
   }

   @ApiOperation("抽检详情列表")
   @GetMapping("/spot/statistics/detail")
   public ResultVO findSpotCheckDetailListPage(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) String userName,
      @RequestParam(required = false) String monomerName,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：抽检详情列表");
      return ResultBuilder.success(
         this.qhseBiz.findSpotCheckDetailListPage(projectId, monomerId, userName, monomerName, name, serialNumber, specification, pageNumber, pageSize)
      );
   }

   @ApiOperation("打印抽检统计列表")
   @GetMapping("/spot/statistics/print")
   public void printFindSpotCheckList(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) String userName,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：打印项目看板汇总");
      this.qhseBiz.printFindSpotCheckList(projectId, projectName, userName, response);
   }

   @ApiOperation("打印抽检详情列表")
   @GetMapping("/spot/statistics/detail/print")
   public void printFindSpotCheckDetailList(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) String userName,
      @RequestParam(required = false) String monomerName,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：打印抽检详情列表");
      this.qhseBiz.printFindSpotCheckDetailList(projectId, monomerId, userName, monomerName, name, serialNumber, specification, response);
   }

   @ApiOperation("安环问题报告下载")
   @GetMapping("/safety/environment/detail/{id}/download")
   public ResultVO qhseSafetyEnvironmentDownload(@PathVariable Long id, HttpServletResponse response) {
      log.info("API 调用 ：安环问题报告下载");
      return ResultBuilder.success(this.qhseBiz.qhseSafetyEnvironmentDownload(id, response));
   }

   @ApiOperation("质检问题报告下载")
   @GetMapping("/problem/Statistics/detail/{id}/download")
   public ResultVO qhseProblemStatisticsDownload(@PathVariable Long id, HttpServletResponse response) {
      log.info("API 调用 ：质检问题报告下载");
      return ResultBuilder.success(this.qhseBiz.qhseProblemStatisticsDownload(id, response));
   }
}

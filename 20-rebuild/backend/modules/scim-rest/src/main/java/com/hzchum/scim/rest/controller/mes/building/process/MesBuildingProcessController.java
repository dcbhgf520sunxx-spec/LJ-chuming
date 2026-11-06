package com.hzchum.scim.rest.controller.mes.building.process;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.biz.process.MesBuildingProcessBiz;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessRequestDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProcessDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.ProcessWageDTOParam;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.process.process.get.ProcessListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.process.process.post.ProcessSaveListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.process.process.post.ProcessWagePostRequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.process.process.put.ProcessUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.voUtils.IdsVoRequest;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES工序")
@RestController
@RequestMapping("/api/mes/building/process")
public class MesBuildingProcessController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingProcessController.class);
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingProcessBiz processBiz;

   @ApiOperation("获取工序列表和价格")
   @GetMapping
   public ResultVO processList(Integer productType, Boolean organizationType) {
      log.info("API 调用 ：获取工序列表和价格");
      return ResultBuilder.success(this.processBiz.listByCondition(productType, organizationType));
   }

   @ApiOperation("获取零件工序列表")
   @GetMapping("/getPartListTree")
   public ResultVO getPartListTree() {
      log.info("API 调用 ：获取零件工序列表");
      this.processBiz.getPartListTree();
      return ResultBuilder.success(this.processBiz.getPartListTree());
   }

   @ApiOperation("新Mes获取工序列表")
   @GetMapping("find")
   public ResultVO findProcessList(Integer productType, Boolean organizationType) {
      log.info("API 调用 ：新Mes获取工序列表");
      return ResultBuilder.success(this.processBiz.listByCondition(productType, organizationType));
   }

   @ApiOperation("获取工序分组列表")
   @GetMapping("/group")
   @PreAuthorize("@permission.check('process:get','process:edit')")
   public ResultVO processGroupList(Integer productionLineTypeEnum) {
      log.info("API 调用 ：获取工序分组列表");
      return ResultBuilder.success(this.processBiz.listGroupByCondition(productionLineTypeEnum));
   }

   @ApiOperation("新mes获取工序库分组")
   @GetMapping("/group2")
   public ResultVO processGroupList() {
      log.info("API 调用 ：新mes获取工序库分组");
      return ResultBuilder.success(this.processBiz.listGroupByCondition());
   }

   @ApiOperation("新mes获取工序库分组")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('process_config:get')")
   public ResultVO processList(@RequestParam(required = true) Integer boolFixedProcess, @RequestParam(required = true) Integer productType) {
      log.info("API 调用 ：新mes获取工序库分组");
      return ResultBuilder.success(this.processBiz.listByConditionV2(productType, boolFixedProcess));
   }

   @ApiOperation("获取工序")
   @GetMapping("/{id}")
   public ResultVO processById(@PathVariable Long id) {
      log.info("API 调用 ：获取工序列表");
      return ResultBuilder.success(BeanUtil.copy(this.processService.getById(id), MesBuildingProcessDTO.class));
   }

   @ApiOperation("零件切割配置查询切割方式")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "partProdMode", value = "零件生产模式", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "productCategoryType", value = "产品类别", paramType = "query", dataType = "int")
      }
   )
   @GetMapping("/partCutWayList")
   public ResultVO partCutWayList(
      @RequestParam(required = false) Integer partProdMode,
      @RequestParam(required = false) Integer productCategoryType,
      @RequestParam(required = false, defaultValue = "4") Integer type
   ) {
      log.info("API 调用 ：零件切割配置查询切割方式");
      return ResultBuilder.success(this.processBiz.partCutWayList(partProdMode, productCategoryType, type));
   }

   @ApiOperation("分页获取工序列表")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public ResultVO processPage(
      ProcessListVORequest voRequest,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取工序列表");
      return ResultBuilder.success(this.processBiz.processPage(BeanUtil.copy(voRequest, MesBuildingProcessDTOParam.class), sort, pageNumber, pageSize));
   }

   @ApiOperation("新增工序")
   @PostMapping("createOrUpdate")
   @PreAuthorize("#p0.id == null ? @permission.check('process_config:add') : @permission.check('process_config:edit')")
   public ResultVO processSave(@RequestBody @Valid MesBuildingProcessRequestDTO voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增工序");
      return ResultBuilder.success(this.processBiz.saveOrUpdateProcess(voRequest));
   }

   @ApiOperation("批量新增工序")
   @PostMapping("save/list")
   @PreAuthorize("@permission.check('process_config:edit')")
   public ResultVO processSaveList(@RequestBody @Valid ProcessSaveListVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：批量新增工序");
      return ResultBuilder.success(this.processBiz.saveList(request.getList(), request.getProductType()));
   }

   @ApiOperation("修改工序上报类型")
   @PutMapping
   @PreAuthorize("@permission.check('inspection_mode:edit','paManufacture','productionLineSummary')")
   public ResultVO processUpdate(@RequestBody @Valid ProcessUpdateVORequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：修改工序上报类型");
      Preconditions.checkArgument(voRequest.getId() != null, "id不能为空");
      return ResultBuilder.success(this.processService.updateById(BeanUtil.copy(voRequest, MesBuildingProcess.class).setUserId(UserUtil.getCurrentUserId())));
   }

   @ApiOperation("删除工序")
   @DeleteMapping
   @PreAuthorize("@permission.check('process_config:del')")
   public ResultVO processDelete(@RequestBody IdsVoRequest voRequest) {
      return ResultBuilder.success(this.processBiz.removeByIds(voRequest.getIds()));
   }

   @ApiOperation("获取用户可质检和生产的工序列表")
   @GetMapping("/user")
   public ResultVO processList(Boolean type, Integer taskTypeEnum, Integer productType) {
      log.info("API 调用 ：获取用户可质检和生产的工序列表");
      return ResultBuilder.success(
         new ListVO<>(this.processService.listByCondition2(type, taskTypeEnum == null ? productType : taskTypeEnum, UserUtil.getCurrentUserId()))
      );
   }

   @ApiOperation("设置工序价格")
   @PostMapping("/wage")
   public ResultVO processWage(@RequestBody List<ProcessWagePostRequest> requestList) {
      log.info("API 调用 ：设置工序价格");
      return ResultBuilder.success(
         this.processBiz.saveProcessWage(requestList.stream().map(e -> BeanUtil.copy(e, ProcessWageDTOParam.class)).collect(Collectors.toList()))
      );
   }

   @ApiOperation("根据任务id获取工序 ")
   @GetMapping("/task/{id}")
   public ResultVO getByProcess(@PathVariable Long id) {
      log.info("API 调用 ：根据任务id获取工序 ");
      return ResultBuilder.success(new ListVO<>(this.processBiz.getByProcess(id)));
   }

   @ApiOperation("根据任务id和工序id获取班组  ")
   @GetMapping("/team")
   public ResultVO getByTeam(Long taskId, Long processId) {
      log.info("API 调用 ：根据任务id和工序id获取班组  ");
      return ResultBuilder.success(new ListVO<>(this.processBiz.getByTeam(taskId, processId)));
   }

   @ApiOperation("获取构件-组铆焊工序列表")
   @GetMapping("/rivetWeld")
   public ResultVO processRivetWeldListByArtyFact() {
      log.info("API 调用 ：获取构件-组铆焊工序列表");
      return ResultBuilder.success(this.processBiz.listRivetWeldArtyFactList());
   }

   @ApiOperation("获取部件-组铆焊工序列表")
   @GetMapping("/rivetWeld/assemble")
   public ResultVO processRivetWeldListByAssemble() {
      log.info("API 调用 ：获取部件-组铆焊工序列表");
      return ResultBuilder.success(this.processBiz.listRivetWeldAssembleList());
   }

   @ApiOperation("获取构件工序选择列表")
   @GetMapping("/artifact-process-list")
   public ResultVO artifactProcessList() {
      log.info("API 调用 ：获取构件工序选择列表");
      List<MesBuildingProcess> processList = this.processService
         .list(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType()));
      List<NameInfo> nameInfoList = cn.hutool.core.bean.BeanUtil.copyToList(processList, NameInfo.class);
      return ResultBuilder.success(nameInfoList);
   }

   @ApiOperation("获取部件工序选择列表")
   @GetMapping("/assemble-process-list")
   public ResultVO assembleProcessList() {
      log.info("API 调用 ：获取部件工序选择列表");
      List<MesBuildingProcess> processList = this.processService
         .list(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getProductType, ProductTypeEnum.ASSEMBLE.getType()));
      List<NameInfo> nameInfoList = cn.hutool.core.bean.BeanUtil.copyToList(processList, NameInfo.class);
      return ResultBuilder.success(nameInfoList);
   }

   @ApiOperation("获取零件工序选择列表")
   @GetMapping("/machine-part-process-list")
   public ResultVO machinePartProcessList(@RequestParam(required = false) @ApiParam("零件工序类型(4: 下料, 8: 钻孔)") Integer processType) {
      log.info("API 调用 ：获取零件工序选择列表");
      if (processType != null) {
         List<Integer> processTypeEnum = CollUtil.newArrayList(ProcessTypeEnum.MAKINGS.getType(), ProcessTypeEnum.DRILL_HOLE.getType());
         Preconditions.checkArgument(processTypeEnum.contains(processType), "零件工序类型不存在");
      }

      List<MesBuildingProcess> processList = this.processService
         .list(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
               .eq(processType != null, MesBuildingProcess::getType, processType)
         );
      List<NameInfo> nameInfoList = cn.hutool.core.bean.BeanUtil.copyToList(processList, NameInfo.class);
      return ResultBuilder.success(nameInfoList);
   }
}

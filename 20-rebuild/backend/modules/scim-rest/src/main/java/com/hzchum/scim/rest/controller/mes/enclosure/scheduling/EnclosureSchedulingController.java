package com.hzchum.scim.rest.controller.mes.enclosure.scheduling;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureTeamBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureSchedulingBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureFactoryDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.SchedulingTeamTreeDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureSchedulingDTOParam;
import com.hzchum.scim.plan.core.api.biz.TechEnclosureBiz;
import com.hzchum.scim.plan.core.api.pojo._do.ProjectSchedulingTreeDO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureNeedSchedulingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosurePlanDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectSchedulingStateDTO;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.groups.get.GroupsVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目排产-围护")
@RestController
@RequestMapping("/api/mes/enclosure/scheduling")
public class EnclosureSchedulingController {
   private static final Logger log = LoggerFactory.getLogger(EnclosureSchedulingController.class);
   @Autowired
   private TechEnclosureBiz techEnclosureBiz;
   @Autowired
   private MesEnclosureSchedulingBiz enclosureSchedulingBiz;
   @Autowired
   private MesEnclosureTeamBiz enclosureTeamBizteamBiz;

   @ApiOperation("获取所有项目及排产状态(围护)")
   @GetMapping("/project")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份"),
            @ApiImplicitParam(name = "state", value = "排产状态 1: 未排产 2:部分排产 4:已完全排产"),
            @ApiImplicitParam(name = "name", value = "模糊查询字段"),
            @ApiImplicitParam(name = "projectType", value = "项目产品类型"),
            @ApiImplicitParam(name = "lumpSumSystemType", value = "包干制项目管理类型")
      }
   )
   @PreAuthorize("@permission.check('enclosure_scheduling_manage:get')")
   public ResultVO<List<EnclosureProjectSchedulingStateDTO>> processPage(
      Integer year, Integer state, String name, @RequestParam(required = false) Integer projectType, @RequestParam(required = false) Integer lumpSumSystemType
   ) {
      log.info("API 调用 ：获取所有项目及排产状态(围护)");
      return ResultBuilder.success(this.techEnclosureBiz.listByType(year, state, name, projectType, lumpSumSystemType));
   }

   @ApiOperation("获取未排产项目")
   @GetMapping("/project_tree")
   @ApiImplicitParams(@ApiImplicitParam(name = "year", value = "年份"))
   @PreAuthorize("@permission.check('enclosure_scheduling_manage:get')")
   public ResultVO<List<ProjectSchedulingTreeDO>> enclosureSchedulingTree(Integer year, Integer state, String name) {
      log.info("API 调用 ：获取所有项目及排产状态(围护)");
      return ResultBuilder.success(this.techEnclosureBiz.enclosureSchedulingTree(year, state, name));
   }

   @ApiOperation("获取所有项目下全部的围护种类(围护)")
   @GetMapping("/category")
   @ApiImplicitParams(@ApiImplicitParam(name = "projectId", value = "项目id"))
   public ResultVO<List<Integer>> projectCategory(Long projectId) {
      log.info("API 调用 ：获取所有项目下全部的围护种类(围护)");
      return ResultBuilder.success(this.techEnclosureBiz.projectCategory(projectId));
   }

   @ApiOperation("(新)获取所有项目下全部的围护种类(围护)")
   @GetMapping("/dictionary")
   @ApiImplicitParams(@ApiImplicitParam(name = "projectId", value = "项目id"))
   public ResultVO<Map<Long, String>> projectEnclosureDictionary(@RequestParam("areaIds") List<Long> areaIds) {
      log.info("API 调用 ：获取所有项目下全部的围护种类(围护)");
      return ResultBuilder.success(this.techEnclosureBiz.projectEnclosureDictionary(areaIds));
   }

   @ApiOperation("依据项目和板材类型获取批次(围护)")
   @GetMapping("/plans")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "projectId", value = "项目id"), @ApiImplicitParam(name = "category", value = "围护类型 2压型(彩)板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 ")}
   )
   public ResultVO<List<EnclosurePlanDTO>> planByCondition(Long projectId, Integer category) {
      log.info("API 调用 ：依据项目和板材类型获取批次(围护)");
      return ResultBuilder.success(this.techEnclosureBiz.planByCondition(projectId, category));
   }

   @ApiOperation("依据板材类型和批次获取全部的待排产数据(围护)")
   @GetMapping("/list")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "planIds", value = "批次id"), @ApiImplicitParam(name = "category", value = "围护类型 2压型(彩)板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 ")}
   )
   public ResultVO<PageVO<EnclosureNeedSchedulingDTO>> listEnclosure(
      @RequestParam("planIds") List<Long> planIds,
      Integer category,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：依据项目和板材类型获取批次(围护)");
      return ResultBuilder.success(this.techEnclosureBiz.listEnclosure(planIds, category, pageNumber, pageSize));
   }

   @ApiOperation("依据板材类型和批次获取全部的待排产数据(围护)")
   @GetMapping("/v2/list")
   @ApiImplicitParams({@ApiImplicitParam(name = "areaIds", value = "区域ids"), @ApiImplicitParam(name = "distionaryId", value = "围护字典类型")})
   public ResultVO<PageVO<EnclosureNeedSchedulingDTO>> listEnclosureV2(
      @RequestParam("areaIds") List<Long> areaIds,
      @RequestParam Long dictionaryId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：依据项目和板材类型获取批次(围护)");
      return ResultBuilder.success(this.techEnclosureBiz.listEnclosureV2(areaIds, dictionaryId, pageNumber, pageSize));
   }

   @ApiOperation("获取可排产生产组树")
   @GetMapping("/tree")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "请求类", dataTypeClass = GroupsVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public ResultVO<List<MesEnclosureFactoryDO>> getSchedulingGroupsTree(@Validated SchedulingTeamTreeDTO voRequest) {
      log.info("API 调用 ：分页获取生产组分页列表");
      return ResultBuilder.success(this.enclosureTeamBizteamBiz.getSchedulingGroupsTree(voRequest));
   }

   @ApiOperation("获取可排产生产组树")
   @GetMapping("/v2/tree")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "请求类", dataTypeClass = GroupsVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public ResultVO<List<MesEnclosureFactoryDO>> getSchedulingGroupsTreeV2(@Validated SchedulingTeamTreeDTO voRequest) {
      log.info("API 调用 ：分页获取生产组分页列表");
      return ResultBuilder.success(this.enclosureTeamBizteamBiz.getSchedulingGroupsTreeV2(voRequest));
   }

   @ApiOperation("生产排产-任务下发(围护)")
   @PostMapping
   @SignerCheck(boolMethodAndClassName = true, message = "正在下发任务中,清稍后刷新重试!")
   @PreAuthorize("@permission.check('enclosure_scheduling_manage:add')")
   public ResultVO saveScheduling(@RequestBody MesEnclosureSchedulingDTOParam schedulings) {
      log.info("API 调用 ：生产排产-任务下发(围护)");
      return ResultBuilder.success(this.enclosureSchedulingBiz.saveScheduling(schedulings));
   }

   @ApiOperation("(新)生产排产-任务下发(围护)")
   @PostMapping("/allots")
   @SignerCheck(boolMethodAndClassName = true, message = "正在下发任务中,清稍后刷新重试!")
   @PreAuthorize("@permission.check('enclosure_scheduling_manage:add')")
   public ResultVO saveSchedulingV2(@RequestBody @Validated MesEnclosureSchedulingDTOParam schedulings) {
      log.info("API 调用 ：(新)生产排产-任务下发(围护)");
      return ResultBuilder.success(this.enclosureSchedulingBiz.saveSchedulingV2(schedulings));
   }

   @ApiOperation("生产排产-获取区域下的量(围护)")
   @GetMapping("/totalLength")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "planIds", value = "批次id"),
            @ApiImplicitParam(name = "category", value = "围护类型 2压型(彩)板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 "),
            @ApiImplicitParam(name = "projectId", value = "项目id")
      }
   )
   public ResultVO getTotalLength(
      @RequestParam(value = "planIds", required = false) List<Long> planIds,
      @RequestParam("projectId") Long projectId,
      @RequestParam("category") Integer category
   ) {
      log.info("API 调用 ：生产排产-获取区域下的量(围护)");
      return ResultBuilder.success(this.enclosureSchedulingBiz.getTotalLength(projectId, planIds, category));
   }

   @ApiOperation("生产排产-获取区域下的量(围护)")
   @GetMapping("/v2/totalLength")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "planIds", value = "批次id"),
            @ApiImplicitParam(name = "category", value = "围护类型 2压型(彩)板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 "),
            @ApiImplicitParam(name = "projectId", value = "项目id")
      }
   )
   public ResultVO getTotalLengthV2(
      @RequestParam(value = "areaIds", required = false) List<Long> areaIds,
      @RequestParam("projectId") Long projectId,
      @RequestParam("dictionaryId") Integer dictionaryId
   ) {
      log.info("API 调用 ：生产排产-获取区域下的量(围护)");
      return ResultBuilder.success(this.enclosureSchedulingBiz.getTotalLengthV2(projectId, areaIds, dictionaryId));
   }
}

package com.hzchum.scim.rest.controller.mes.enclosure.order;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosurePlanDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProductDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectOverviewStateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目任务项目看板-围护")
@RestController
@RequestMapping("/api/mes/enclosure/overview")
public class EnclosureProjectOverviewController {
   private static final Logger log = LoggerFactory.getLogger(EnclosureProjectOverviewController.class);
   @Resource
   private MesEnclosureTaskBiz taskBiz;

   @ApiOperation("获取所有项目生产状态(围护)")
   @GetMapping("/project")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份"),
            @ApiImplicitParam(name = "state", value = "排产状态 1: 生产中 2:已完成"),
            @ApiImplicitParam(name = "name", value = "模糊查询字段")
      }
   )
   @PreAuthorize("@permission.check('enclosure_project_overview:get')")
   public ResultVO<List<EnclosureProjectOverviewStateDTO>> getProjectOverview(
      Integer year,
      Integer state,
      String name,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("API 调用 ：获取所有项目生产状态(围护)");
      return ResultBuilder.success(this.taskBiz.getProjectOverview(year, state, name, projectType, lumpSumSystemType));
   }

   @ApiOperation("依据项目获取,项目下板材信息(围护)")
   @GetMapping("/project/category")
   public ResultVO<List<Integer>> getProjectCategory(Long projectId) {
      log.info("API 调用 ：项目下板材信息(围护)");
      return ResultBuilder.success(this.taskBiz.getProjectCategory(projectId));
   }

   @ApiOperation("依据项目获取,项目下板材信息(围护)")
   @GetMapping("/v2/project/category")
   public ResultVO<Map<Long, String>> getProjectCategoryV2(
      @RequestParam(name = "projectId", required = false) Long projectId, @RequestParam(name = "areaIds", required = false) List<Long> areaIds
   ) {
      log.info("API 调用 ：项目下板材信息(围护)");
      return ResultBuilder.success(this.taskBiz.getProjectCategoryV2(projectId, areaIds));
   }

   @ApiOperation("依据项目和类型获取区域信息(围护)")
   @GetMapping("/plans")
   public ResultVO<List<EnclosurePlanDTO>> getPlan(Long projectId, Integer category) {
      log.info("API 调用 ：依据项目和类型获取区域信息(围护)");
      return ResultBuilder.success(this.taskBiz.getPlan(projectId, category));
   }

   @ApiOperation("依据项目和类型获取区域信息(围护)")
   @GetMapping("/areas")
   public ResultVO<List<PlanAreaDTO>> getArea(Long projectId, Long dictionaryId) {
      log.info("API 调用 ：依据项目和类型获取区域信息(围护)");
      return ResultBuilder.success(this.taskBiz.getArea(projectId, dictionaryId));
   }

   @ApiOperation("依据区域和产品状态查询产品详细信息(围护)")
   @GetMapping("/product/detail")
   public ResultVO<PageVO<EnclosureProductDetailDTO>> getproductDetaile(
      @RequestParam("planIds") List<Long> planIds,
      Integer status,
      Integer category,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：依据区域和产品状态查询产品详细信息(围护)");
      return ResultBuilder.success(this.taskBiz.getproductDetaile(planIds, status, category, pageNumber, pageSize));
   }

   @ApiOperation("(新)依据区域和产品状态查询产品详细信息(围护)")
   @GetMapping("/v2/product/detail")
   public ResultVO<PageVO<EnclosureProductDetailDTO>> getproductDetaileV2(
      @RequestParam("areaIds") List<Long> areaIds,
      Integer status,
      Long dictionaryId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：(新)依据区域和产品状态查询产品详细信息(围护)");
      return ResultBuilder.success(this.taskBiz.getproductDetaileV2(areaIds, status, dictionaryId, pageNumber, pageSize));
   }

   @ApiOperation("依据区域和产品状态查询产品生产汇总(围护)")
   @GetMapping("/product/total")
   public ResultVO<Map> getproductTotal(@RequestParam(value = "planIds", required = false) List<Long> planIds, Long projectId, Integer category) {
      log.info("API 调用 ：依据区域和产品状态查询产品生产汇总(围护)");
      return ResultBuilder.success(this.taskBiz.getproductTotal(projectId, planIds, category));
   }

   @ApiOperation("依据区域和产品状态查询产品生产汇总(围护)")
   @GetMapping("/v2/product/total")
   public ResultVO<Map> getproductTotalV2(@RequestParam(value = "areaIds", required = false) List<Long> areaIds, Long projectId, Long dictionaryId) {
      log.info("API 调用 ：依据区域和产品状态查询产品生产汇总(围护)");
      return ResultBuilder.success(this.taskBiz.getProductTotalV2(projectId, areaIds, dictionaryId));
   }
}

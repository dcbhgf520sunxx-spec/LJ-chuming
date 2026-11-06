package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.plan.core.api.biz.TechMachinePartBiz;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSimpleDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSummaryDTO;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-零件")
@RestController
@RequestMapping("/api/plan/machinePart")
public class MachinePartApi {
   private static final Logger log = LoggerFactory.getLogger(MachinePartApi.class);
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechMachinePartBiz machinePartBiz;

   @ApiOperation(value = "零件清单列表", notes = "零件清单列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query"),
            @ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "零件类型", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "零件编号", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "零件规格", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "零件材质", paramType = "query"),
            @ApiImplicitParam(name = "steelPlateTypeEnum", value = "零件类型 1.零件版 2翼腹板 4成品型材 ", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query")
      }
   )
   @GetMapping("/listByCondition")
   @PreAuthorize("@permission.check('plan_machine_part_list:get')")
   public ResultVO listPageArtifactByCondition(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      Integer type,
      String serialNumber,
      String specification,
      String material,
      String thick,
      @RequestParam(required = false) @EnumValidator(value = SteelPlateTypeEnum.class, message = "零件类型不存在!") Integer steelPlateTypeEnum,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ： 多条件查询 零件清单 列表");
      PageVO<MachinePartResponseDTO> pageVO = this.machinePartBiz
         .pageListByCondition(
            projectId, monomerId, areaId, areaBatchId, status, type, serialNumber, specification, material, thick, steelPlateTypeEnum, pageNumber, pageSize
         );
      return ResultBuilder.success(pageVO);
   }

   @ApiOperation(value = "零件清单明细导出", notes = "零件清单明细导出")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query"),
            @ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "零件类型", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "零件编号", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "零件规格", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "零件材质", paramType = "query"),
            @ApiImplicitParam(name = "steelPlateTypeEnum", value = "零件类型 2.零件版 2翼腹板 4成品型材 ", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query")
      }
   )
   @GetMapping("/listByCondition/export")
   @PreAuthorize("@permission.check('plan_machine_part_list:get')")
   public void listPageArtifactByConditionExport(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      Integer type,
      String serialNumber,
      String specification,
      String material,
      String thick,
      @RequestParam(required = false) @EnumValidator(value = SteelPlateTypeEnum.class, message = "零件类型不存在!") Integer steelPlateTypeEnum,
      HttpServletResponse response
   ) {
      log.info("API 调用 ： 多条件查询并且导出 零件清单 列表");
      this.machinePartBiz
         .pageListByConditionExport(
            projectId, monomerId, areaId, areaBatchId, status, type, serialNumber, specification, material, thick, steelPlateTypeEnum, response
         );
   }

   @ApiOperation("根据零件id 查询零件信息")
   @ApiImplicitParam(name = "id", value = "零件id", paramType = "path", required = true)
   @GetMapping("/getById/{id}")
   public ResultVO<MachinePartDTO> getMachinePartById(@PathVariable("id") Long id) {
      log.info("Api调用: 根据构件id查询构件信息");
      return ResultBuilder.success(this.machinePartBiz.getMachinePartInfoById(id));
   }

   @ApiOperation("根据单体id,查询下面零件简单信息列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "serialNumber", value = "零件编号", paramType = "query")
      }
   )
   @GetMapping("/listSimple")
   public ResultVO<ListVO<MachinePartSimpleDTO>> listSimple(Long monomerId, String serialNumber) {
      log.info("Api调用: 根据单体id,查询一个单体内零件简单信息列表");
      return ResultBuilder.success(new ListVO<>(this.machinePartService.listSimpleByMonomerId(monomerId, serialNumber)));
   }

   @ApiOperation("零件汇总")
   @GetMapping("/list-summary")
   @PreAuthorize("@permission.check('plan_machine_part_list:get')")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query"),
            @ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query"),
            @ApiImplicitParam(name = "steelPlateTypeEnum", value = "零件类型 1.零件版 2翼腹板 4成品型材", paramType = "query")
      }
   )
   public ResultVO<List<MachinePartSummaryDTO>> listPartSummary(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long areaBatchId,
      @RequestParam(required = false) @EnumValidator(value = MachinePartRelationTypeEnum.class, message = "零件关联类型不存在!") Integer steelPlateTypeEnum,
      @RequestParam(value = "permissionCheck", required = false) Integer permissionCheck
   ) {
      log.info("Api调用: 根据零件厚度和材质汇总列表");
      return ResultBuilder.success(this.machinePartService.listSummary(projectId, monomerId, areaId, areaBatchId, steelPlateTypeEnum, permissionCheck));
   }

   @ApiOperation("下载零件汇总")
   @GetMapping("/list-summary/export")
   @PreAuthorize("@permission.check('plan_machine_part_list:get')")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query"),
            @ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query"),
            @ApiImplicitParam(name = "steelPlateTypeEnum", value = "零件类型 2.零件版 2翼腹板 4成品型材 ", paramType = "query")
      }
   )
   public void listSummaryExport(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long areaBatchId,
      @RequestParam(required = false) @EnumValidator(value = SteelPlateTypeEnum.class, message = "零件类型不存在!") Integer steelPlateTypeEnum,
      HttpServletResponse response
   ) {
      log.info("Api调用: 根据零件厚度和材质汇总列表");
      this.machinePartService.listSummaryExport(projectId, monomerId, areaId, areaBatchId, steelPlateTypeEnum, response);
   }
}

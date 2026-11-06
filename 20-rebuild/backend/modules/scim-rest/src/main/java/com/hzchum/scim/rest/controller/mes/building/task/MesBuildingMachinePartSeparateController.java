package com.hzchum.scim.rest.controller.mes.building.task;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingMachinePartSeparateBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES任务工单")
@RestController
@RequestMapping("/api/mes/building/machine_part/separate")
public class MesBuildingMachinePartSeparateController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingMachinePartSeparateController.class);
   @Resource
   private MesBuildingMachinePartSeparateBiz separateBiz;

   @ApiOperation("根据任务单号查询零件分拣信息")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "cutId", value = "切割指令id", paramType = "query", required = true),
            @ApiImplicitParam(name = "processType", value = "类型(4:切割 8:钻孔)", paramType = "query")
      }
   )
   @GetMapping
   @PreAuthorize("@permission.check('mes_work_order_machine_part:detail')")
   public ResultVO getListByTaskOrderId(Long cutId, Integer processType) {
      log.info("API 调用 ：根据任务单号查询零件分拣信息");
      return ResultBuilder.success(new ListVO<>(this.separateBiz.getListByTaskOrderId(cutId, processType)));
   }

   @ApiOperation("根据任务单号查询零件分拣信息(分页)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "cutId", value = "切割指令id", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true),
            @ApiImplicitParam(name = "processType", value = "类型(4:切割 8:钻孔)", paramType = "query")
      }
   )
   @GetMapping("/page")
   public ResultVO getListByTaskOrderIdPage(
      Long cutId,
      Integer processType,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：根据任务单号查询零件分拣信息");
      return ResultBuilder.success(this.separateBiz.getListByTaskOrderIdPage(cutId, processType, pageSize, pageNumber));
   }

   @ApiOperation("零件打印标记接口")
   @ApiImplicitParams(@ApiImplicitParam(name = "cutId", value = "切割指令id", paramType = "query", required = true))
   @GetMapping("/print/sign")
   public ResultVO getListByTaskOrderIdSign(Long cutId, Integer processType) {
      log.info("API 调用 ：零件打印标记接口");
      return ResultBuilder.success(this.separateBiz.getListByTaskOrderIdSign(cutId, processType));
   }
}

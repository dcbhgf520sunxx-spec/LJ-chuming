package com.hzchum.scim.rest.controller.enclosure;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.pojo.dto.change.EnclosureChangeExamineDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.EnclosureQuantityChangeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.DeleteTaskOrderVoParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.EnclosureChangeVoParam;
import com.hzchum.scim.plan.core.api.service.TechEnclosureChangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "围护变更撤回")
@RestController
@RequestMapping("/api/enclosure")
public class EnclosureChangeController {
   private static final Logger log = LoggerFactory.getLogger(EnclosureChangeController.class);
   @Resource
   TechEnclosureChangeService changeService;

   @ApiOperation(value = "围护清单变更", notes = "围护清单变更")
   @ApiImplicitParam(name = "Authorization", value = "token", paramType = "header", required = true)
   @PostMapping("/change")
   public ResultVO changeEnclosure(@RequestBody @Valid EnclosureQuantityChangeDTOParam param) {
      log.info("Api调用: 围护清单变更");
      return ResultBuilder.success(this.changeService.changeEnclosure(param));
   }

   @ApiOperation(value = "围护清单变更审核", notes = "围护清单变更审核")
   @ApiImplicitParam(name = "Authorization", value = "token", paramType = "header", required = true)
   @PostMapping("/examine")
   public ResultVO changeExamine(@RequestBody EnclosureChangeExamineDTO examineDTO) {
      log.info("Api调用: 围护清单变更审核");
      return ResultBuilder.success(this.changeService.handleChange(examineDTO));
   }

   @ApiOperation(value = "变更记录集合", notes = "变更记录集合")
   @ApiImplicitParam(name = "Authorization", value = "token", paramType = "header", required = true)
   @GetMapping("/entities")
   public ResultVO findAllEnclosureList(EnclosureChangeVoParam voParam, Integer pageNumber, Integer pageSize) {
      log.info("Api调用: 变更记录集合");
      return ResultBuilder.success(this.changeService.findAllEnclosureList(voParam, pageNumber, pageSize));
   }

   @ApiOperation(value = "工单详细删除", notes = "工单详细删除")
   @ApiImplicitParam(name = "Authorization", value = "token", paramType = "header", required = true)
   @PostMapping("/order/detail/delete")
   public ResultVO deleteEnclosureTask(@RequestBody DeleteTaskOrderVoParam voParam) {
      log.info("Api调用: 工单详细删除");
      return ResultBuilder.success(this.changeService.deleteEnclosureTask(voParam.getOrderId(), voParam.getTaskIds()));
   }
}

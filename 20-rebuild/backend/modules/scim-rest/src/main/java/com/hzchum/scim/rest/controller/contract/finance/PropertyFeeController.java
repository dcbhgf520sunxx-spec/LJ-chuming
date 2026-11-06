package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractPropertyFeeBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractPropertyFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractPropertyFeeDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-物业费")
@RestController
@RequestMapping("/api/contract/property-fee")
public class PropertyFeeController {
   private static final Logger log = LoggerFactory.getLogger(PropertyFeeController.class);
   @Resource
   private ContractPropertyFeeBiz propertyFeeBiz;

   @ApiOperation("物业费-列表")
   @GetMapping
   @PreAuthorize("@permission.check('property_cost:get')")
   public ResultVO<ListVO<ContractPropertyFeeDTO>> list(@RequestParam Integer year) {
      log.info("Api调用:物业费记录列表");
      return ResultBuilder.success(this.propertyFeeBiz.listByCondition(year));
   }

   @ApiOperation("物业费-新增/修改")
   @PostMapping
   @PreAuthorize("@permission.check('property_cost:add','property_cost:edit')")
   public ResultVO saveList(@RequestBody @Valid List<ContractPropertyFeeDtoParam> paramList) {
      log.info("Api调用:物业费记录新增/修改");
      return ResultBuilder.success(this.propertyFeeBiz.saveList(paramList));
   }

   @ApiOperation("物业费-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('property_cost:del')")
   public ResultVO removeList(@RequestBody List<Long> ids) {
      log.info("Api调用:物业费记录删除");
      return ResultBuilder.success(this.propertyFeeBiz.deleteList(ids));
   }

   @ApiOperation("物业费-打印")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('property_cost:print')")
   public ResultVO printList(@RequestParam Integer year) {
      log.info("Api调用:物业费记录打印");
      return ResultBuilder.success(this.propertyFeeBiz.printList(year));
   }
}

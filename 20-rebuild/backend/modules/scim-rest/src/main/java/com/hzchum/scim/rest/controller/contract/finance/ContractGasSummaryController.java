package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractGasSummaryBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGasSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.WmsGasClassificationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractGasSummaryDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-气体统计")
@Validated
@RestController
@RequestMapping("/api/contract/gas-summary")
public class ContractGasSummaryController {
   private static final Logger log = LoggerFactory.getLogger(ContractGasSummaryController.class);
   @Resource
   private ContractGasSummaryBiz gasSummaryBiz;

   @ApiOperation("气体类型列表")
   @GetMapping("/list-gas-class")
   public ResultVO<ListVO<WmsGasClassificationDTO>> listGasClass() {
      log.info("Api调用: 气体类型列表");
      return ResultBuilder.success(this.gasSummaryBiz.listWmsGasClass());
   }

   @ApiOperation("气体费用统计-列表")
   @GetMapping
   @PreAuthorize("@permission.check('gas_cost:get')")
   public ResultVO<ListVO<ContractGasSummaryDTO>> listGasSummary(Long classifyId, Integer year) {
      log.info("Api调用:气体费用统计列表 ");
      return ResultBuilder.success(this.gasSummaryBiz.listGasSummary(classifyId, year));
   }

   @ApiOperation("气体费用统计-增加/修改")
   @PostMapping
   @PreAuthorize("@permission.check('gas_cost:add','gas_cost:edit')")
   public ResultVO saveList(@RequestBody @Valid List<ContractGasSummaryDtoParam> paramList) {
      log.info("Api调用:气体费用统计增加或修改 ");
      return ResultBuilder.success(this.gasSummaryBiz.saveList(paramList));
   }

   @ApiOperation("气体费用统计-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('gas_cost:del')")
   public ResultVO remove(@RequestBody List<Long> ids) {
      log.info("Api调用:气体费用统计删除 ");
      return ResultBuilder.success(this.gasSummaryBiz.deleteList(ids));
   }

   @ApiOperation("气体费用统计-列表打印")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('gas_cost:print')")
   public ResultVO print(Long classifyId, Integer year) {
      log.info("Api调用:气体费用统计列表打印 ");
      return ResultBuilder.success(this.gasSummaryBiz.printList(classifyId, year));
   }
}

package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractInvoiceBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceSaveParamV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-开票")
@Validated
@RestController
@RequestMapping("/api/contract/invoice")
public class InvoiceControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(InvoiceControllerV2.class);
   @Resource
   private ContractInvoiceBiz invoiceBiz;

   @ApiOperation("新增开票数据回显")
   @GetMapping("/getInvoice")
   @PreAuthorize("@contractCollectionAccess.invoiceWrite(#projectId,#level,null)")
   public ResultVO getInvoice(@RequestParam Long projectId, @RequestParam Integer level) {
      log.info("Api调用: 新增开票回显");
      return ResultBuilder.success(this.invoiceBiz.getProject(projectId, level));
   }

   @ApiOperation("项目台账-开票列表")
   @GetMapping("/V2/listPage")
   @PreAuthorize("@contractCollectionAccess.read(#projectId,#level)")
   public ResultVO<PageVO<ContractInvoiceV2DTO>> listPageLedger(
      Long projectId, Integer level, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      return ResultBuilder.success(this.invoiceBiz.listPageLedger(projectId, level, pageNumber, pageSize));
   }

   @ApiOperation("新增开票")
   @PostMapping("/save")
   @PreAuthorize("@contractCollectionAccess.invoiceWrite(#saveDTOParam.projectId,#saveDTOParam.level,#saveDTOParam.invoiceUnitId)")
   public ResultVO saveCollection(@RequestBody @Valid ContractInvoiceSaveParamV2 saveDTOParam) {
      log.info("Api调用: 新增开票");
      return ResultBuilder.success(this.invoiceBiz.saveInvoice(saveDTOParam));
   }

   @ApiOperation("项目台账-开票列表-打印")
   @GetMapping("/downloadInvoice/{projectId}")
   @PreAuthorize("@contractCollectionAccess.readPrint(#projectId,#level)")
   public ResultVO listPageLedger(@PathVariable Long projectId, Integer level) {
      return ResultBuilder.success(this.invoiceBiz.downloadInvoice(projectId, level));
   }
}

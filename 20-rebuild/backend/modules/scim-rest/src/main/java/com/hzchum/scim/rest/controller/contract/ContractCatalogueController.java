package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractCatalogueQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCatalogueDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractCatalogueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同目录")
@RestController
@RequestMapping("/api/contract/catalogue")
public class ContractCatalogueController {
   private static final Logger log = LoggerFactory.getLogger(ContractCatalogueController.class);
   @Resource
   private ContractCatalogueService contractCatalogueService;

   @ApiOperation("获取合同目录列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('catalog_contract_list:get')")
   public ResultVO getContractFiledConfig(
      ContractCatalogueQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:获取合同目录列表");
      return ResultBuilder.success(this.contractCatalogueService.getList(param, pageNumber, pageSize));
   }

   @ApiOperation("根据ID查看合同目录详情")
   @GetMapping("/{id}")
   @PreAuthorize("@permission.check('catalog_contract_list:detail')")
   public ResultVO selectById(@PathVariable("id") Long id) {
      log.info("Api调用:根据ID查看合同目录详情");
      return ResultBuilder.success(this.contractCatalogueService.selectById(id));
   }

   @ApiOperation("编辑合同目录")
   @PutMapping("/edit")
   @PreAuthorize("@permission.check('catalog_contract_list:edit')")
   public ResultVO edit(@RequestBody ContractCatalogueDTOParam dtoParam) {
      log.info("API 调用 ：编辑合同目录");
      return ResultBuilder.success(this.contractCatalogueService.edit(dtoParam));
   }

   @ApiOperation("合同目录编号录入")
   @PutMapping("/editContractNumber")
   @PreAuthorize("@permission.check('catalog_contract_list:edit')")
   public ResultVO editContractNumber(@RequestBody List<ContractCatalogueDTOParam> dtoParams) {
      log.info("API 调用 ：合同目录编号录入");
      return ResultBuilder.success(this.contractCatalogueService.editContractNumber(dtoParams));
   }

   @ApiOperation("合同目录下载")
   @GetMapping("/export")
   @PreAuthorize("@permission.check('catalog_contract_list:download')")
   public ResultVO export(ContractCatalogueQueryDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：合同目录下载");
      return ResultBuilder.success(this.contractCatalogueService.export(param, response));
   }

   @ApiOperation("获取所有不为增补合同并且存在合同编号的合同目录信息")
   @GetMapping("/getNoSupplementAndNumber")
   public ResultVO getNoSupplementAndNumber() {
      log.info("API 调用 ：获取所有不为增补合同并且存在合同编号的合同目录信息");
      return ResultBuilder.success(this.contractCatalogueService.getNoSupplementAndNumber());
   }

   @ApiOperation("修改合同目录状态")
   @PutMapping("/cancellation/{id}/{reviewStatus}")
   @PreAuthorize("@permission.check('catalog_contract_list:cancel')")
   public ResultVO cancellation(@PathVariable("id") Long id, @PathVariable("reviewStatus") Integer reviewStatus) {
      log.info("API 调用 ：修改合同目录状态");
      return ResultBuilder.success(this.contractCatalogueService.cancellation(id, reviewStatus));
   }
}

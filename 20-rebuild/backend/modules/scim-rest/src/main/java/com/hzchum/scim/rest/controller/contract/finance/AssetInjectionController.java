package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.contract.core.api.biz.finance.ContractProjectAssetInjectionBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectAssetInjectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectAssetInjectionDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectAssetInjectionPutDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.InjectionExpendituresDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractProjectAssetInjectionDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目台账-注资")
@RestController
@RequestMapping("/api/contract/Injection")
@Validated
public class AssetInjectionController {
   private static final Logger log = LoggerFactory.getLogger(AssetInjectionController.class);
   @Resource
   private ContractProjectAssetInjectionBiz assetInjectionBiz;

   @ApiOperation("项目台账-内包/合营-注资分页")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "contractSignBodyId", value = "签约主体id", dataType = "Long"),
            @ApiImplicitParam(name = "projectManagerId", value = "项目经理id", dataType = "Long"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long")
      }
   )
   @GetMapping("/page")
   public ResultVO<PageVO<ContractProjectAssetInjectionDTO>> getPage(
      Long contractSignBodyId,
      Long projectManagerId,
      @RequestParam Long projectId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ： 项目台账-合营注资分页");
      return ResultBuilder.success(this.assetInjectionBiz.getAssetInjectionPage(contractSignBodyId, projectManagerId, projectId, pageNumber, pageSize));
   }

   @ApiOperation("项目台账-注资信息")
   @GetMapping("/getAssetInjection/{projectId}")
   public ResultVO<Map<String, String>> getAssetInjection(@PathVariable Long projectId) {
      log.info("API 调用 ： 项目台账-注资信息");
      return ResultBuilder.success(this.assetInjectionBiz.getInjectionAmount(projectId));
   }

   @ApiOperation("项目台账-注资新增")
   @PostMapping
   public ResultVO save(@RequestBody @Valid ContractProjectAssetInjectionDTOParam param) {
      log.info("API 调用 ： 项目台账-注资新增");
      return ResultBuilder.success(this.assetInjectionBiz.saveAssetInjection(param));
   }

   @ApiOperation("项目台账-注资修改")
   @PutMapping
   public ResultVO update(@RequestBody @Valid ContractProjectAssetInjectionDTOParam param) {
      log.info("API 调用 ： 项目台账-注资修改");
      return ResultBuilder.success(this.assetInjectionBiz.updateAssetInjection(param));
   }

   @ApiOperation("项目台账-注资删除")
   @DeleteMapping("/{id}")
   public ResultVO delete(@PathVariable Long id) {
      log.info("API 调用 ： 项目台账-注资删除");
      return ResultBuilder.success(this.assetInjectionBiz.deleteAssetInjection(id));
   }

   @ApiOperation("项目台账-注资人")
   @GetMapping("/getAssetInjectionPersonnel/{projectId}")
   public ResultVO<Map<String, Map<Long, String>>> getAssetInjectionPersonnel(@PathVariable Long projectId) {
      log.info("API 调用 ： 项目台账-注资人");
      return ResultBuilder.success(this.assetInjectionBiz.getAssetInjection(projectId));
   }

   @ApiOperation("项目台账-注资回显")
   @GetMapping("/getPutAssetInjection/{id}")
   public ResultVO<ContractProjectAssetInjectionPutDTO> getPutAssetInjection(@PathVariable Long id) {
      log.info("API 调用 ： 项目台账-注资回显");
      return ResultBuilder.success(this.assetInjectionBiz.getPutAssetInjection(id));
   }

   @ApiOperation("项目台账-注资使用明细")
   @GetMapping("/getAssetInjectionDetail/{projectId}")
   public ResultVO<List<ContractProjectAssetInjectionDetailDTO>> getAssetInjectionDetail(@PathVariable Long projectId, Long supplierId) {
      log.info("API 调用 ： 项目台账-注资使用明细");
      return ResultBuilder.success(this.assetInjectionBiz.getAssetInjectionDetail(projectId, supplierId));
   }

   @ApiOperation("项目台账-注资明细导出")
   @GetMapping("/getInjectionDetailDownload/{projectId}/{supplierId}")
   public ResultVO getInjectionDetailDownload(@PathVariable Long projectId, @PathVariable Long supplierId) {
      log.info("API 调用 ： 项目台账-注资明细导出");
      return ResultBuilder.success(this.assetInjectionBiz.getInjectionDetailDownload(projectId, supplierId));
   }

   @ApiOperation("项目台账-合同签订采购供应商信息")
   @GetMapping("/getPurchaseOrder/{projectId}")
   public ResultVO<List<SupplierInfo>> getPurchaseOrder(@PathVariable Long projectId) {
      log.info("API 调用 ： 项目台账-合同签订采购供应商信息");
      return ResultBuilder.success(this.assetInjectionBiz.getPurchaseOrder(projectId));
   }

   @ApiOperation("项目台账-注资明细")
   @GetMapping("/getProjectDetail/{projectId}")
   public ResultVO<ContractProjectAssetInjectionDetailDTO> getProjectDetail(@PathVariable Long projectId) {
      log.info("API 调用 ： 项目台账-注资明细");
      return ResultBuilder.success(this.assetInjectionBiz.getProjectDetail(projectId));
   }

   @ApiOperation("项目台账-注资使用明细")
   @GetMapping("/getUseDetail")
   public ResultVO<PageVO<InjectionExpendituresDetailDTO>> getUseDetail(
      @RequestParam Long projectId,
      Long supplierId,
      Long orderId,
      LocalDateTime startTime,
      LocalDateTime endTime,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ： 项目台账-注资使用明细");
      return ResultBuilder.success(this.assetInjectionBiz.getUseDetail(projectId, supplierId, orderId, startTime, endTime, pageNumber, pageSize));
   }
}

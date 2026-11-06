package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionSaveDTOParam;
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

@Api(tags = "合同管理-收款")
@RestController
@RequestMapping("/api/contract/collection/v2")
@Validated
public class CollectionControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(CollectionControllerV2.class);
   @Resource
   private ContractCollectionBiz contractCollectionBiz;

   @ApiOperation(" 新增收款数据返回")
   @GetMapping("/getCollection")
   @PreAuthorize("@contractCollectionAccess.write(#projectId,#level,null)")
   public ResultVO getCollection(@RequestParam Long projectId, @RequestParam Integer level) {
      log.info("Api调用: 批量新增收款数据返回");
      return ResultBuilder.success(this.contractCollectionBiz.getProject(projectId, level));
   }

   @ApiOperation("收款台账-收款列表")
   @GetMapping("/listPage")
   @PreAuthorize("@contractCollectionAccess.read(#projectId,#level)")
   public ResultVO<PageVO<ContractCollectionV2DTO>> listCollectionLedger(
      Long projectId, Integer level, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:收款台账-查看收款列表");
      return ResultBuilder.success(this.contractCollectionBiz.listCollectionLedger(projectId, level, pageNumber, pageSize));
   }

   @ApiOperation("新增收款")
   @PostMapping("/save")
   @PreAuthorize("@contractCollectionAccess.write(#param.projectId,#param.level,#param.collectionUnitId)")
   public ResultVO saveCollection(@RequestBody @Valid ContractCollectionSaveDTOParam param) {
      log.info("Api调用: 新增收款");
      return ResultBuilder.success(this.contractCollectionBiz.saveCollection(param));
   }

   @ApiOperation("项目台账-收款列表-打印")
   @GetMapping("/downloadCollection/{projectId}")
   @PreAuthorize("@contractCollectionAccess.readPrint(#projectId,#level)")
   public ResultVO downloadCollectionLedger(@PathVariable Long projectId, Integer level) {
      log.info("Api调用:收款台账-查看收款列表");
      return ResultBuilder.success(this.contractCollectionBiz.downloadCollectionLedger(projectId, level));
   }
}

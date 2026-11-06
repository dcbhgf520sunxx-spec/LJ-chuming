package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractFieldConfigDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同配置信息")
@RestController
@RequestMapping("/api/contract/config")
public class ContractConfigController {
   private static final Logger log = LoggerFactory.getLogger(ContractConfigController.class);
   @Resource
   ContractConfigService contractConfigService;

   @ApiOperation("获取合同目录表字段配置")
   @GetMapping("/filedConfig")
   @PreAuthorize("@permission.check('catalog_content_config:get')")
   public ResultVO getContractFiledConfig() {
      log.info("Api调用:获取合同目录表字段配置");
      return ResultBuilder.success(this.contractConfigService.getContractFiledConfig());
   }

   @ApiOperation("新增合同目录字段配置")
   @PostMapping("/filedConfig")
   @PreAuthorize("@permission.check('catalog_content_config:add')")
   public ResultVO saveContractFiledConfig(@RequestBody ContractFieldConfigDTOParam dtoParam) {
      log.info("Api调用:新增合同目录字段配置");
      return ResultBuilder.success(this.contractConfigService.saveContractFiledConfig(dtoParam));
   }

   @ApiOperation("修改合同目录字段配置")
   @PutMapping("/filedConfig")
   @PreAuthorize("@permission.check('catalog_content_config:edit')")
   public ResultVO updateContractFiledConfig(@RequestBody ContractFieldConfigDTOParam dtoParam) {
      log.info("Api调用:获取合同目录表字段配置");
      return ResultBuilder.success(this.contractConfigService.updateContractFiledConfig(dtoParam));
   }

   @ApiOperation("删除合同目录字段配置")
   @DeleteMapping("/filedConfig")
   @PreAuthorize("@permission.check('catalog_content_config:del')")
   public ResultVO deleteContractFiledConfig(@RequestBody List<Long> ids) {
      log.info("Api调用:删除合同目录字段配置");
      return ResultBuilder.success(this.contractConfigService.deleteContractFiledConfig(ids));
   }
}

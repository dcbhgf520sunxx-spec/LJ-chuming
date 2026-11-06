package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.AnnualContractDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.AnnualContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-年度合同")
@RestController
@RequestMapping("/api/wms/annualContract")
public class AnnualContractController {
   private static final Logger log = LoggerFactory.getLogger(AnnualContractController.class);
   @Resource
   AnnualContractService annualContractService;

   @ApiOperation("根据条件分页查询年度合同")
   @GetMapping("/annualContract")
   @PreAuthorize("@permission.check('annual-contract-management:get')")
   public ResultVO list(
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(name = "status", required = false) Boolean status,
      @RequestParam(name = "supplierId", required = false) Long supplierId,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询年度合同");
      return ResultBuilder.success(this.annualContractService.pageInfo(pageNumber, pageSize, sort, status, supplierId));
   }

   @ApiOperation("修改年度合同")
   @PutMapping("/updateAnnualContract")
   @PreAuthorize("@permission.check('annual-contract-management:edit')")
   public ResultVO updateAnnualContract(@Valid @RequestBody AnnualContractDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：修改年度合同");
      return ResultBuilder.success(this.annualContractService.updateAnnualContract(param));
   }

   @ApiOperation("新增年度合同")
   @PutMapping("/addAnnualContract")
   @PreAuthorize("@permission.check('annual-contract-management:add')")
   public ResultVO addAnnualContract(@Valid @RequestBody AnnualContractDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增年度合同");
      return ResultBuilder.success(this.annualContractService.addAnnualContract(param));
   }

   @ApiOperation("删除年度合同")
   @DeleteMapping("/deleteAnnualContract")
   @PreAuthorize("@permission.check('annual-contract-management:del')")
   public ResultVO deleteAnnualContract(Long id) {
      log.info("API 调用 ：删除年度合同");
      return ResultBuilder.success(this.annualContractService.deleteAnnualContract(id));
   }

   @ApiOperation("修改年度合同状态")
   @PutMapping("/updateAnnualContractStatus")
   @PreAuthorize("@permission.check('annual-contract-management:edit')")
   public ResultVO updateAnnualContractStatus(@RequestParam("id") Long id, @RequestParam("status") Boolean status) {
      log.info("API 调用 ： 修改年度合同状态");
      return ResultBuilder.success(this.annualContractService.updateAnnualContractStatus(id, status));
   }
}

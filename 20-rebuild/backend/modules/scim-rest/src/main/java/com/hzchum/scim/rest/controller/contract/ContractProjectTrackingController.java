package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.business.core.api.biz.BusinessBiz;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionBiz;
import com.hzchum.scim.contract.core.api.biz.ContractInvoiceBiz;
import com.hzchum.scim.contract.core.api.enums.CollectionTypeEnum;
import com.hzchum.scim.contract.core.api.enums.CreateInvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.voParam.CollectionProjectQueryVoParam;
import com.hzchum.scim.contract.core.api.pojo.voParam.InvoiceProjectQueryVoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-订单跟踪")
@RestController
@RequestMapping("/api/project/tracking")
public class ContractProjectTrackingController {
   private static final Logger log = LoggerFactory.getLogger(ContractProjectTrackingController.class);
   @Autowired
   private BusinessBiz businessBiz;
   @Autowired
   private ContractCollectionBiz contractCollectionBiz;
   @Autowired
   private ContractInvoiceBiz invoiceBiz;

   @ApiOperation("销售管理-销售台账")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型: 2构件 4围护 8配套件", paramType = "query"),
            @ApiImplicitParam(name = "orderSourceType", value = "订单来源类型: 1内部 2外部", paramType = "query")
      }
   )
   @GetMapping
   @PreAuthorize("@permission.check('order_tracking:get')")
   public ResultVO listSalesLedger(
      Integer year,
      Integer projectStatus,
      String name,
      Integer orderSourceType,
      Integer productType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：销售管理-销售台账");
      return ResultBuilder.success(this.businessBiz.pageListSalesLedger(year, projectStatus, name, orderSourceType, productType, pageNumber, pageSize));
   }

   @ApiOperation("销售管理-销售台账打印")
   @GetMapping("print")
   @PreAuthorize("@permission.check('order_tracking:print')")
   public ResultVO printTracking(Integer year, Integer projectStatus, String name, Integer orderSourceType, Integer productType) {
      log.info("API 调用 ：销售管理-打印订单跟踪");
      return ResultBuilder.success(this.businessBiz.printListSalesLedger(year, projectStatus, name, orderSourceType, productType));
   }

   @ApiOperation("销售管理-发运记录")
   @GetMapping("record")
   public ResultVO get(
      Long projectId,
      Long monomerId,
      Integer productType,
      String name,
      String serialNumber,
      LocalDateTime auditStartDate,
      LocalDateTime auditEndDate,
      Integer pageNumber,
      Integer pageSize
   ) {
      log.info("API 调用 ：销售管理-发运记录");
      return ResultBuilder.success(
         this.businessBiz.pageTracking(projectId, monomerId, productType, name, serialNumber, auditStartDate, auditEndDate, pageNumber, pageSize)
      );
   }

   @ApiOperation("销售管理-发运记录打印")
   @GetMapping("record/print")
   public ResultVO print(
      Long projectId, Long monomerId, Integer productType, String name, String serialNumber, LocalDateTime auditStartDate, LocalDateTime auditEndDate
   ) {
      log.info("API 调用 ：销售管理-发运记录打印");
      return ResultBuilder.success(this.businessBiz.printTracking(projectId, monomerId, productType, name, serialNumber, auditStartDate, auditEndDate));
   }

   @ApiOperation("销售管理-收款列表")
   @GetMapping("/collection")
   public ResultVO<PageVO<ContractCollectionDTO>> listProjectCollection(
      CollectionProjectQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:销售管理-收款列表");
      ContractCollectionQueryDtoParam dtoParam = BeanUtil.copy(param, ContractCollectionQueryDtoParam.class);
      dtoParam.setType(CollectionTypeEnum.PROJECT_COLLECTION.getType());
      return ResultBuilder.success(this.contractCollectionBiz.pageList(dtoParam, pageNumber, pageSize));
   }

   @ApiOperation("销售管理-收款列表-打印")
   @GetMapping("/collection/print")
   public ResultVO printListProjectCollection(CollectionProjectQueryVoParam param) {
      log.info("Api调用:销售管理-收款列表打印");
      ContractCollectionQueryDtoParam dtoParam = BeanUtil.copy(param, ContractCollectionQueryDtoParam.class);
      dtoParam.setType(CollectionTypeEnum.PROJECT_COLLECTION.getType());
      return ResultBuilder.success(this.contractCollectionBiz.printList(dtoParam));
   }

   @ApiOperation("销售管理-开票列表")
   @GetMapping("/invoice")
   public ResultVO<PageVO<ContractInvoiceDTO>> listProjectInvoice(
      InvoiceProjectQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:销售管理-开票列表");
      ContractInvoiceQueryDtoParam dtoParam = BeanUtil.copy(param, ContractInvoiceQueryDtoParam.class);
      dtoParam.setType(CreateInvoiceTypeEnum.PROJECT_COLLECTION.getType());
      return ResultBuilder.success(this.invoiceBiz.pageList(dtoParam, pageNumber, pageSize));
   }

   @ApiOperation("销售管理-开票列表-打印")
   @GetMapping("/invoice/print")
   public ResultVO printListProjectInvoice(InvoiceProjectQueryVoParam param) {
      log.info("Api调用:销售管理-开票列表打印");
      ContractInvoiceQueryDtoParam dtoParam = BeanUtil.copy(param, ContractInvoiceQueryDtoParam.class);
      dtoParam.setType(CreateInvoiceTypeEnum.PROJECT_COLLECTION.getType());
      return ResultBuilder.success(this.invoiceBiz.printList(dtoParam));
   }
}

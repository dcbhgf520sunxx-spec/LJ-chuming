package com.hzchum.scim.rest.controller.business;

import org.springframework.security.access.prepost.PreAuthorize;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.business.core.api.biz.BusinessBiz;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessReturnProductDTO;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "销售管理-发运跟踪")
@RestController
@RequestMapping("/api/business/ship")
public class BusinessCargoShipController {
   private static final Logger log = LoggerFactory.getLogger(BusinessCargoShipController.class);
   @Resource
   private BusinessBiz businessBiz;

   @ApiOperation("发运跟踪-获取发运汇总")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "材质", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "编号", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "产品名称", paramType = "query")
      }
   )
   @GetMapping("/summary")
   @PreAuthorize("@permission.check('shipment_tracking:summary')")
   public ResultVO shipCargoSummary(
      @EnumValidator(value = ProductTypeEnum.class, message = "产类型错误") @RequestParam Integer productType,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam LocalDateTime startDate,
      @RequestParam LocalDateTime endDate,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) Integer projectStatus
   ) {
      log.info("API 调用 ：发运跟踪-获取发运汇总");
      return ResultBuilder.success(
         this.businessBiz
            .shipCargoSummary(productType, projectId, monomerId, areaId, startDate, endDate, specification, material, serialNumber, name, projectStatus)
      );
   }

   @ApiOperation("发运跟踪-获取构件发运详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query"),
            @ApiImplicitParam(name = "monomerName", value = "单体名称", paramType = "query"),
            @ApiImplicitParam(name = "areaName", value = "区域名称", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "材质", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "编号", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页面", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "产品名称", paramType = "query")
      }
   )
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('shipment_tracking:get')")
   public ResultVO shipCargoDetail(
      @EnumValidator(value = ProductTypeEnum.class, message = "产类型错误") @RequestParam Integer productType,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Integer handleMethod,
      @RequestParam(required = false) String monomerName,
      @RequestParam(required = false) String areaName,
      @RequestParam LocalDateTime startDate,
      @RequestParam LocalDateTime endDate,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort,
      @RequestParam(required = false) String name
   ) {
      log.info("API 调用 ：发运跟踪-获取构件发运详情");
      return ResultBuilder.success(
         this.businessBiz
            .pageShipCargoDetail(
               productType,
               projectId,
               monomerId,
               areaId,
               handleMethod,
               monomerName,
               areaName,
               startDate,
               endDate,
               specification,
               material,
               serialNumber,
               pageNumber,
               pageSize,
               sort,
               name
            )
      );
   }

   @ApiOperation("发运跟踪-获取配套件发运详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页面", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "产品名称", paramType = "query")
      }
   )
   @GetMapping("/detail/standard")
   @PreAuthorize("@permission.check('shipment_tracking:get')")
   public ResultVO shipCargoDetail(
      @EnumValidator(value = ProductTypeEnum.class, message = "产类型错误") @RequestParam Integer productType,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam LocalDateTime startDate,
      @RequestParam LocalDateTime endDate,
      @RequestParam(required = false) String specification,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort,
      @RequestParam(required = false) String name
   ) {
      log.info("API 调用 ：发运跟踪-获取配套件发运详情");
      return ResultBuilder.success(
         this.businessBiz
            .pageShipStandardPartCargoDetail(productType, projectId, monomerId, areaId, startDate, endDate, specification, pageNumber, pageSize, sort, name)
      );
   }

   @ApiOperation("发运跟踪-获取围护发运详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "enclosurePlanId", value = "围护计划id", paramType = "query"),
            @ApiImplicitParam(name = "planName", value = "围护计划名称", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "plate", value = "版型", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "编号", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页面", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "产品名称", paramType = "query")
      }
   )
   @GetMapping("/enclosure/detail")
   @PreAuthorize("@permission.check('shipment_tracking:get')")
   public ResultVO shipCargoEnclosureDetail(
      @EnumValidator(value = ProductTypeEnum.class, message = "产类型错误") @RequestParam Integer productType,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) String planName,
      @RequestParam LocalDateTime startDate,
      @RequestParam LocalDateTime endDate,
      @RequestParam(required = false) String plate,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort,
      @RequestParam(required = false) String name
   ) {
      log.info("API 调用 ：发运跟踪-获取围护发运详情");
      return ResultBuilder.success(
         this.businessBiz
            .pageShipCargoEnclosureDetail(
               productType, projectId, enclosurePlanId, planName, startDate, endDate, plate, serialNumber, pageNumber, pageSize, sort, name
            )
      );
   }

   @ApiOperation("打印:发运跟踪详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "enclosurePlanId", value = "围护计划id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query"),
            @ApiImplicitParam(name = "monomerName", value = "单体名称", paramType = "query"),
            @ApiImplicitParam(name = "areaName", value = "区域名称", paramType = "query"),
            @ApiImplicitParam(name = "planName", value = "围护计划名称", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "plate", value = "版型", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "材质", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "编号", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "产品名称", paramType = "query")
      }
   )
   @GetMapping("/detail/print")
   @PreAuthorize("@permission.check('shipment_tracking:print')")
   public ResultVO printShipCargoDetail(
      @EnumValidator(value = ProductTypeEnum.class, message = "产类型错误") @RequestParam Integer productType,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) Integer handleMethod,
      @RequestParam(required = false) String monomerName,
      @RequestParam(required = false) String areaName,
      @RequestParam(required = false) String planName,
      @RequestParam LocalDateTime startDate,
      @RequestParam LocalDateTime endDate,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String plate,
      @RequestParam(required = false) String material,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String name
   ) {
      log.info("API 调用 ： 打印:发运跟踪详情");
      return ResultBuilder.success(
         this.businessBiz
            .printShipCargoDetail(
               productType,
               projectId,
               monomerId,
               areaId,
               enclosurePlanId,
               handleMethod,
               monomerName,
               areaName,
               planName,
               startDate,
               endDate,
               specification,
               plate,
               material,
               serialNumber,
               name
            )
      );
   }

   @ApiOperation("下载:发运跟踪汇总和详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "enclosurePlanId", value = "围护计划id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query"),
            @ApiImplicitParam(name = "monomerName", value = "单体名称", paramType = "query"),
            @ApiImplicitParam(name = "areaName", value = "区域名称", paramType = "query"),
            @ApiImplicitParam(name = "planName", value = "围护计划名称", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "plate", value = "版型", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "材质", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "编号", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "产品名称", paramType = "query")
      }
   )
   @GetMapping("/detail/download")
   @PreAuthorize("@permission.check('shipment_tracking:print')")
   public void downloadShipCargoDetail(
      @EnumValidator(value = ProductTypeEnum.class, message = "产类型错误") @RequestParam Integer productType,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) Integer handleMethod,
      @RequestParam(required = false) String monomerName,
      @RequestParam(required = false) String areaName,
      @RequestParam(required = false) String planName,
      @RequestParam LocalDateTime startDate,
      @RequestParam LocalDateTime endDate,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String plate,
      @RequestParam(required = false) String material,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String name,
      HttpServletResponse response
   ) {
      log.info("API 调用 ： 下载:发运跟踪汇总和详情");
      this.businessBiz
         .downloadShipCargoDetail(
            productType,
            projectId,
            monomerId,
            areaId,
            enclosurePlanId,
            handleMethod,
            monomerName,
            areaName,
            planName,
            startDate,
            endDate,
            specification,
            plate,
            material,
            serialNumber,
            name,
            response
         );
   }

   @ApiOperation("发运跟踪-获取直发件发运详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query"),
            @ApiImplicitParam(name = "monomerName", value = "单体名称", paramType = "query"),
            @ApiImplicitParam(name = "areaName", value = "区域名称", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "材质", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "编号", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页面", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "产品名称", paramType = "query")
      }
   )
   @GetMapping("/direct/detail")
   @PreAuthorize("@permission.check('shipment_tracking:get')")
   public ResultVO shipDirectCargoDetail(
      @EnumValidator(value = ProductTypeEnum.class, message = "产类型错误") @RequestParam Integer productType,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String monomerName,
      @RequestParam(required = false) String areaName,
      @RequestParam LocalDateTime startDate,
      @RequestParam LocalDateTime endDate,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort,
      @RequestParam(required = false) String name
   ) {
      log.info("API 调用 ：发运跟踪-获取直发件发运详情");
      return ResultBuilder.success(
         this.businessBiz
            .pageShipDirectCargoDetail(
               productType,
               projectId,
               monomerId,
               areaId,
               monomerName,
               areaName,
               startDate,
               endDate,
               specification,
               material,
               serialNumber,
               pageNumber,
               pageSize,
               sort,
               name
            )
      );
   }

   @ApiOperation("制成品-退货列表")
   @GetMapping("/return/list")
   @PreAuthorize("@permission.check('shipment_tracking:get')")
   public ResultVO<ListVO<BusinessReturnProductDTO>> listReturnProduct(@RequestParam Long linkId) {
      log.info("APi调用:发运跟踪-产品退货列表");
      return ResultBuilder.success(new ListVO<>(this.businessBiz.listReturnProduct(linkId)));
   }

   @ApiOperation("制成品-退货列表-打印")
   @GetMapping("/return/list/print")
   @PreAuthorize("@permission.check('shipment_tracking:print')")
   public ResultVO<PrintVO<List<BusinessReturnProductDTO>>> printListReturnProduct(@RequestParam Long linkId) {
      log.info("APi调用:发运跟踪-产品退货列表-打印");
      return ResultBuilder.success(this.businessBiz.printListReturnProduct(linkId));
   }
}

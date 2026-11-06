package com.hzchum.scim.rest.controller.supplychain;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.biz.LogisticsBiz;
import com.hzchum.scim.contract.core.api.enums.logistics.LogisticsTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsRecordDTO;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ChangeFreightEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应链管理-物流记录")
@RestController
@RequestMapping("/api/supply-chain/logistics")
public class LogisticsRecordController {
   private static final Logger log = LoggerFactory.getLogger(LogisticsRecordController.class);
   @Autowired
   private LogisticsBiz logisticsBiz;

   @ApiOperation("物流汇总")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "type", value = "  1原材料物流 2制成品物流 4物流公司 8 个人", paramType = "query", required = true),
            @ApiImplicitParam(name = "name", value = " 根据type具有不同含义: 1采购编号 2项目名称  4物流公司 8 车牌", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "条数", paramType = "query", defaultValue = "20")
      }
   )
   @GetMapping("summary")
   @PreAuthorize("@permission.check('supplier_logistics_Log:get')")
   public ResultVO<PageVO<LogisticsDTO>> summary(
      @RequestParam @EnumValidator(value = LogisticsTypeEnum.class, message = "物流类型不存在") Integer type,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(required = false) Integer pageNumber,
      @RequestParam(required = false) Integer pageSize
   ) {
      log.info("API 调用 ：物流汇总");
      return ResultBuilder.success(this.logisticsBiz.summary(type, name, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("物流记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "type", value = "  1原材料物流 2制成品物流 4物流公司 8 个人", paramType = "query", required = true),
            @ApiImplicitParam(name = "id", value = " 根据type具有不同含义: 1订单id , 2项目id, 4供应商id,8 个人车牌id", paramType = "query", required = true),
            @ApiImplicitParam(name = "branchCompanyId", value = " 合同主体id", paramType = "query"),
            @ApiImplicitParam(name = "supplierId", value = " 物流单位id", paramType = "query"),
            @ApiImplicitParam(name = "changeFreight", value = " 运费类型", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = " 页码", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = " 页大小", paramType = "query")
      }
   )
   @GetMapping("record")
   @PreAuthorize("@permission.check('supplier_logistics_Log:detail','contract_supplier_logistics_log:get')")
   public ResultVO<PageVO<LogisticsRecordDTO>> record(
      @RequestParam Integer type,
      @RequestParam(required = false) Long id,
      @RequestParam(required = false) Long branchCompanyId,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(required = false) @EnumValidator(value = ChangeFreightEnum.class, message = "运费类型不存在") Integer changeFreight,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：物流记录");
      return ResultBuilder.success(this.logisticsBiz.record(type, id, branchCompanyId, supplierId, changeFreight, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("打印物流记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "type", value = " 1原材料物流 2制成品物流 4物流公司 8 个人", paramType = "query", required = true),
            @ApiImplicitParam(name = "id", value = " 根据type具有不同含义: 1订单id , 2项目id, 4供应商id,8 个人车牌id", paramType = "query", required = true),
            @ApiImplicitParam(name = "branchCompanyId", value = " 合同主体id", paramType = "query"),
            @ApiImplicitParam(name = "changeFreight", value = " 运费类型", paramType = "query")
      }
   )
   @GetMapping("/record/print")
   @PreAuthorize("@permission.check('supplier_logistics_Log:print','contract_supplier_logistics_log:print')")
   public ResultVO printRecord(
      @RequestParam Integer type,
      @RequestParam Long id,
      @RequestParam(required = false) Long branchCompanyId,
      Long supplierId,
      @RequestParam(required = false) @EnumValidator(value = ChangeFreightEnum.class, message = "运费类型不存在") Integer changeFreight,
      LocalDate startDate,
      LocalDate endDate
   ) {
      log.info("API 调用 ：打印物流记录");
      return ResultBuilder.success(this.logisticsBiz.printRecord(type, id, branchCompanyId, supplierId, changeFreight, startDate, endDate));
   }
}

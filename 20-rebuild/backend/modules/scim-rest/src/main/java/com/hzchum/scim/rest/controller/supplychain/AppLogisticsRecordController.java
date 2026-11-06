package com.hzchum.scim.rest.controller.supplychain;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.biz.LogisticsBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsRecordDTO;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ChangeFreightEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP物流管理")
@RestController
@RequestMapping("/api/app/supply-chain/logistics")
public class AppLogisticsRecordController {
   private static final Logger log = LoggerFactory.getLogger(AppLogisticsRecordController.class);
   @Resource
   private LogisticsBiz logisticsBiz;

   @ApiOperation("物流汇总")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "type", value = "  1原材料物流 2制成品物流 4物流公司", paramType = "query", required = true),
            @ApiImplicitParam(name = "name", value = " 根据type具有不同含义: 1采购编号 2项目名称  4物流公司", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "条数", paramType = "query", defaultValue = "20")
      }
   )
   @GetMapping("summary")
   @PreAuthorize("@permission.check('logisticsManager','bridgeLogisticsManager')")
   public ResultVO<PageVO<LogisticsDTO>> summary(
      @RequestParam Integer type,
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
            @ApiImplicitParam(name = "type", value = " 1原材料物流 2制成品物流 4物流公司", paramType = "query", required = true),
            @ApiImplicitParam(name = "id", value = " 根据type具有不同含义: 1订单id , 2项目id,4供应商id", paramType = "query", required = true),
            @ApiImplicitParam(name = "boolPersonalEnum", value = " 承运方是否个人", paramType = "query"),
            @ApiImplicitParam(name = "supplierId", value = " 物流配置id", paramType = "query"),
            @ApiImplicitParam(name = "changeFreight", value = " 运费类型", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = " 页码", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = " 页大小", paramType = "query")
      }
   )
   @GetMapping("record")
   @PreAuthorize("@permission.check('logisticsManager','bridgeLogisticsManager')")
   public ResultVO<PageVO<LogisticsRecordDTO>> record(
      @RequestParam Integer type,
      @RequestParam(required = false) Long id,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(required = false) @EnumValidator(value = ChangeFreightEnum.class, message = "运费类型不存在") Integer changeFreight,
      LocalDate startDate,
      LocalDate endDate,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：物流记录");
      return ResultBuilder.success(this.logisticsBiz.record(type, id, null, supplierId, changeFreight, startDate, endDate, pageNumber, pageSize));
   }
}

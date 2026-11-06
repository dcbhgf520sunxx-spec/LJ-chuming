package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.biz.CommonTokenBiz;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDeviceByMaterialDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchDeviceOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.DeviceQueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialIdsDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-维修配件领用")
@RestController
@RequestMapping("/api/wms/device")
public class DeviceController {
   private static final Logger log = LoggerFactory.getLogger(DeviceController.class);
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   private CommonTokenBiz commonTokenBiz;
   @Resource
   MoveOutboundDetailService moveOutboundDetailService;

   @ApiOperation("辅材查询")
   @GetMapping("/auxiliary-material")
   public ResultVO getAuxiliaryMaterial(
      DeviceQueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：辅材查询");
      return ResultBuilder.success(this.materialInventoryService.devicePageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("设备配件领料")
   @PutMapping("/auxiliary-material/saveOutBound")
   public ResultVO steelPlateBatch(@Valid @RequestBody BatchDeviceOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：设备配件领料");
      return ResultBuilder.success(this.moveOutboundDetailService.batchOutbound(param));
   }

   @ApiOperation("设备领用(明细)")
   @PostMapping("/getDeviceDetail")
   public ResultVO getDeviceDetail(@RequestBody QueryDeviceByMaterialDtoParam queryReceiveDateDTOParam) {
      log.info("API 调用 : 设备领用");
      return ResultBuilder.success(this.moveOutboundDetailService.getDeviceDetail(queryReceiveDateDTOParam));
   }

   @ApiOperation("物料仓-根据IDs查询")
   @GetMapping("/ids")
   public ResultVO getByIds(QueryByMaterialIdsDTOParam param) {
      log.info("API 调用 ：物料仓-根据IDs查询物料");
      return ResultBuilder.success(this.materialInventoryService.getMatByIds(param));
   }
}

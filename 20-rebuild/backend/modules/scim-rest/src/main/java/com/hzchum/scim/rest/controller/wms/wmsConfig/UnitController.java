package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.rest.pojo.vo.wms.wmsConfig.UnitVORequest;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.UnitDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.UnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms配置-单位配置")
@RestController
@RequestMapping("/api/config/base-config/unit")
public class UnitController {
   private static final Logger log = LoggerFactory.getLogger(UnitController.class);
   @Resource
   UnitService unitService;

   @ApiOperation("条件获取单位列表")
   @GetMapping
   @PreAuthorize("@permission.check('config_unitConfig:get')")
   public ResultVO list(
      @RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "type", required = false) Integer type,
      @RequestParam(name = "enabled", required = false) Boolean enabled,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：条件获取单位列表");
      return ResultBuilder.success(this.unitService.pageInfo(pageNumber, pageSize, sort, name, type, enabled));
   }

   @ApiOperation("批量新增单位")
   @PostMapping("/batch")
   @PreAuthorize("@permission.check('config_unitConfig:add')")
   public ResultVO addWarehouse(@Valid @RequestBody ValidList<UnitVORequest> unitVORequests, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：批量新增单位");
      List<UnitDTOParam> dtoParams = unitVORequests.stream().map(request -> BeanUtil.copy(request, UnitDTOParam.class)).collect(Collectors.toList());
      return ResultBuilder.success(this.unitService.addUnit(dtoParams));
   }

   @ApiOperation("修改单位使用状态")
   @PutMapping("/enabled")
   @PreAuthorize("@permission.check('config_unitConfig:edit')")
   public ResultVO update(@RequestParam("id") Integer id, @RequestParam("enabled") Boolean enabled) {
      log.info("API 调用 ：修改单位使用状态");
      return ResultBuilder.success(this.unitService.updateUnitStatus(id, enabled));
   }

   @ApiOperation("批量删除单位")
   @DeleteMapping
   @PreAuthorize("@permission.check('config_unitConfig:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 ：批量删除单位");
      return ResultBuilder.success(this.unitService.delete(ids));
   }

   @ApiOperation("获取全部单位列表")
   @GetMapping("/all")
   public ResultVO listAll() {
      log.info("API 调用 ：获取全部单位列表");
      return ResultBuilder.success(this.unitService.listInfo(null, null, null));
   }
}

package com.hzchum.scim.rest.controller.mes.building.statistica;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.AddBatch;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingLayingOffConfigDTO;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingLayingOffConfigService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica.MesBuildingLayingOffConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES零件-下料配置")
@RestController
@RequestMapping("/api/mes/building/layingOff")
public class MesBuildingLayingOffConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingLayingOffConfigController.class);
   @Resource
   private MesBuildingLayingOffConfigService mesBuildingLayingOffConfigService;

   @ApiOperation("批量新增零件下料配置")
   @PostMapping("")
   @PreAuthorize("@permission.check('statistical_parts_laying_config:add')")
   public ResultVO saveLayingOffList(@Validated(AddBatch.class) @RequestBody List<MesBuildingLayingOffConfigVO> vos) {
      log.info("API 调用 ：批量新增零件下料配置");
      List<MesBuildingLayingOffConfigDTO> dtoList = vos.stream().map(vo -> BeanUtil.copy(vo, MesBuildingLayingOffConfigDTO.class)).collect(Collectors.toList());
      return ResultBuilder.success(this.mesBuildingLayingOffConfigService.saveLayingOffList(dtoList));
   }

   @ApiOperation("查询零件下料配置列表")
   @GetMapping("")
   @PreAuthorize("@permission.check('statistical_parts_laying_config:get')")
   public ResultVO getLayingOffList() {
      log.info("API 调用 ：查询零件下料配置列表");
      return ResultBuilder.success(this.mesBuildingLayingOffConfigService.getLayingOffList());
   }

   @ApiOperation("修改零件下料配置")
   @PutMapping("")
   @PreAuthorize("@permission.check('statistical_parts_laying_config:edit')")
   public ResultVO updateLayingOff(@Validated(Update.class) @RequestBody MesBuildingLayingOffConfigVO vo) {
      log.info("API 调用 ：修改零件下料配置");
      MesBuildingLayingOffConfigDTO copy = BeanUtil.copy(vo, MesBuildingLayingOffConfigDTO.class);
      return ResultBuilder.success(this.mesBuildingLayingOffConfigService.updateLayingOff(copy));
   }

   @ApiOperation("删除零件下料配置")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('statistical_parts_laying_config:del')")
   public ResultVO removeLayingOff(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除零件下料配置");
      return ResultBuilder.success(this.mesBuildingLayingOffConfigService.removeLayingOff(ids));
   }
}

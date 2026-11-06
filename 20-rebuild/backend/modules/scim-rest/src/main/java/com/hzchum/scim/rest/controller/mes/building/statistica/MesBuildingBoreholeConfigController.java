package com.hzchum.scim.rest.controller.mes.building.statistica;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.AddBatch;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingBoreholeConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingBoreholeConfigLinkDTO;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingBoreholeConfigService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica.MesBuildingBoreholeConfigLinkVO;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica.MesBuildingBoreholeConfigVO;
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

@Api(tags = "MES钻孔配置")
@RestController
@RequestMapping("/api/mes/building/borehole")
public class MesBuildingBoreholeConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingBoreholeConfigController.class);
   @Resource
   private MesBuildingBoreholeConfigService mesBuildingBoreholeConfigService;

   @ApiOperation("查询钻孔配置列表")
   @GetMapping("")
   @PreAuthorize("@permission.check('statistical_drill_hole_config:get')")
   public ResultVO getBoreholeList() {
      log.info("API 调用 ：查询钻孔配置列表");
      return ResultBuilder.success(this.mesBuildingBoreholeConfigService.getBoreholeList());
   }

   @ApiOperation("批量新增钻孔配置")
   @PostMapping("")
   @PreAuthorize("@permission.check('statistical_drill_hole_config:add')")
   public ResultVO saveBoreholeList(@Validated(AddBatch.class) @RequestBody List<MesBuildingBoreholeConfigVO> vos) {
      log.info("API 调用 ：批量新增钻孔配置");
      List<MesBuildingBoreholeConfigDTO> configDTOS = vos.stream().map(e -> BeanUtil.copy(e, MesBuildingBoreholeConfigDTO.class)).collect(Collectors.toList());
      return ResultBuilder.success(this.mesBuildingBoreholeConfigService.saveBoreholeList(configDTOS));
   }

   @ApiOperation("修改钻孔配置")
   @PutMapping("")
   @PreAuthorize("@permission.check('statistical_drill_hole_config:edit')")
   public ResultVO updateBoreholeList(@Validated(Update.class) @RequestBody MesBuildingBoreholeConfigVO vo) {
      log.info("API 调用 ：修改钻孔配置");
      MesBuildingBoreholeConfigDTO copy = BeanUtil.copy(vo, MesBuildingBoreholeConfigDTO.class);
      return ResultBuilder.success(this.mesBuildingBoreholeConfigService.updateBoreholeList(copy));
   }

   @ApiOperation("新增钻孔关联配置")
   @PostMapping("/link")
   public ResultVO saveBoreholeLinkList(@Validated(AddBatch.class) @RequestBody MesBuildingBoreholeConfigLinkVO vo) {
      log.info("API 调用 ：批量新增钻孔关联配置");
      MesBuildingBoreholeConfigLinkDTO linkDTO = BeanUtil.copy(vo, MesBuildingBoreholeConfigLinkDTO.class);
      return ResultBuilder.success(this.mesBuildingBoreholeConfigService.saveBoreholeLinkList(linkDTO));
   }

   @ApiOperation("修改钻孔关联配置")
   @PutMapping("/link")
   @PreAuthorize("@permission.check('statistical_drill_hole_config:edit')")
   public ResultVO updateBoreholeLinkList(@Validated(Update.class) @RequestBody MesBuildingBoreholeConfigLinkVO vo) {
      log.info("API 调用 ：修改钻孔关联配置");
      MesBuildingBoreholeConfigLinkDTO linkDTO = BeanUtil.copy(vo, MesBuildingBoreholeConfigLinkDTO.class);
      return ResultBuilder.success(this.mesBuildingBoreholeConfigService.updateBoreholeLinkList(linkDTO));
   }

   @ApiOperation("删除钻孔配置")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('statistical_drill_hole_config:del')")
   public ResultVO removeBoreholeList(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除钻孔配置");
      return ResultBuilder.success(this.mesBuildingBoreholeConfigService.removeBoreholeList(ids));
   }

   @ApiOperation("删除钻孔关联配置")
   @DeleteMapping("/link")
   @PreAuthorize("@permission.check('statistical_drill_hole_config:del')")
   public ResultVO removeBoreholeLinkList(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除钻孔配置");
      return ResultBuilder.success(this.mesBuildingBoreholeConfigService.removeBoreholeLinkList(ids));
   }
}

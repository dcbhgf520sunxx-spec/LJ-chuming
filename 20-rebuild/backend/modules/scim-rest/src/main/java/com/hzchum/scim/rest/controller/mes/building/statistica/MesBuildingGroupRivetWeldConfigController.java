package com.hzchum.scim.rest.controller.mes.building.statistica;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.AddBatch;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingArtifactTypeConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingAssembleLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingStructureClassificationTypeLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingStructureProcessPriceDTO;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingArtifactTypeConfigService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingAssembleRiveWeldLinkService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingStructureClassificationTypeLinkService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica.MesBuildingArtifactTypeConfigVO;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica.MesBuildingAssembleLinkVO;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica.MesBuildingStructureClassificationTypeLinkVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES组铆焊配置")
@RestController
@RequestMapping("/api/mes/building/rivetWeld")
public class MesBuildingGroupRivetWeldConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingGroupRivetWeldConfigController.class);
   @Resource
   private MesBuildingArtifactTypeConfigService mesBuildingArtifactTypeConfigService;
   @Resource
   private MesBuildingStructureClassificationTypeLinkService mesBuildingStructureClassificationTypeLinkService;
   @Resource
   private MesBuildingAssembleRiveWeldLinkService mesBuildingAssembleRiveWeldLinkService;

   @ApiOperation("查询构件种类配置列表")
   @GetMapping("/artifact/type")
   @PreAuthorize("@permission.check('statistical_artifact_type_config:get')")
   public ResultVO getArtifactTypeConfig() {
      log.info("API 调用 ：查询构件种类配置列表");
      return ResultBuilder.success(this.mesBuildingArtifactTypeConfigService.getArtifactTypeConfig());
   }

   @ApiOperation("查询构件种类配置列表")
   @GetMapping("/artifact/type/find")
   public ResultVO findArtifactTypeConfig() {
      log.info("API 调用 ：查询构件种类配置列表");
      return ResultBuilder.success(this.mesBuildingArtifactTypeConfigService.getArtifactTypeConfig());
   }

   @ApiOperation("新增构件种类配置")
   @PostMapping("/artifact/type")
   @PreAuthorize("@permission.check('statistical_artifact_type_config:add')")
   public ResultVO setArtifactTypeConfig(@Validated(Add.class) @RequestBody MesBuildingArtifactTypeConfigVO vo) {
      log.info("API 调用 ：新增构件种类配置");
      MesBuildingArtifactTypeConfigDTO copy = BeanUtil.copy(vo, MesBuildingArtifactTypeConfigDTO.class);
      return ResultBuilder.success(this.mesBuildingArtifactTypeConfigService.setArtifactTypeConfig(copy));
   }

   @ApiOperation("更新构件种类配置")
   @PutMapping("/artifact/type")
   @PreAuthorize("@permission.check('statistical_artifact_type_config:edit')")
   public ResultVO updateArtifactTypeConfig(@Validated(Update.class) @RequestBody MesBuildingArtifactTypeConfigVO vo) {
      log.info("API 调用 ：更新构件种类配置");
      MesBuildingArtifactTypeConfigDTO copy = BeanUtil.copy(vo, MesBuildingArtifactTypeConfigDTO.class);
      return ResultBuilder.success(this.mesBuildingArtifactTypeConfigService.updateArtifactTypeConfig(copy));
   }

   @ApiOperation("删除构件种类配置")
   @DeleteMapping("/artifact/type")
   @PreAuthorize("@permission.check('statistical_artifact_type_config:del')")
   public ResultVO removeArtifactTypeConfig(@RequestBody Set<Long> ids) {
      log.info("API 调用 ：删除构件种类配置");
      return ResultBuilder.success(this.mesBuildingArtifactTypeConfigService.removeArtifactTypeConfig(ids));
   }

   @ApiOperation("查询构件-组铆焊配置列表")
   @ApiImplicitParam(name = "id", value = "构件种类id", paramType = "query")
   @GetMapping
   @PreAuthorize("@permission.check('statistical_artifact_rivet_weld_config:get')")
   public ResultVO getArtifactRivetWeldConfig(@RequestParam Long id) {
      log.info("API 调用 ：查询构件-组铆焊配置列表");
      return ResultBuilder.success(this.mesBuildingStructureClassificationTypeLinkService.getArtifactRivetWeldConfig(id));
   }

   @ApiOperation("批量新增构件-组铆焊配置")
   @PostMapping
   @PreAuthorize("@permission.check('statistical_artifact_rivet_weld_config:add')")
   public ResultVO saveRivetWeldConfig(@Validated(AddBatch.class) @RequestBody List<MesBuildingStructureClassificationTypeLinkVO> vos) {
      log.info("API 调用 ：批量新增构件-组铆焊配置");
      List<MesBuildingStructureClassificationTypeLinkDTO> dtoList = new ArrayList<>();
      vos.forEach(
         vo -> {
            MesBuildingStructureClassificationTypeLinkDTO copy = BeanUtil.copy(vo, MesBuildingStructureClassificationTypeLinkDTO.class);
            copy.setStructureProcessPriceList(
               vo.getStructureProcessPriceList().stream().map(e -> BeanUtil.copy(e, MesBuildingStructureProcessPriceDTO.class)).collect(Collectors.toList())
            );
            dtoList.add(copy);
         }
      );
      return ResultBuilder.success(this.mesBuildingStructureClassificationTypeLinkService.saveRivetWeldConfig(dtoList));
   }

   @ApiOperation("修改构件-组铆焊配置")
   @PutMapping
   @PreAuthorize("@permission.check('statistical_artifact_rivet_weld_config:edit')")
   public ResultVO updateRivetWeldConfig(@Validated(Update.class) @RequestBody MesBuildingStructureClassificationTypeLinkVO vo) {
      log.info("API 调用 ：修改构件-组铆焊配置");
      MesBuildingStructureClassificationTypeLinkDTO copy = BeanUtil.copy(vo, MesBuildingStructureClassificationTypeLinkDTO.class);
      copy.setStructureProcessPriceList(
         vo.getStructureProcessPriceList().stream().map(e -> BeanUtil.copy(e, MesBuildingStructureProcessPriceDTO.class)).collect(Collectors.toList())
      );
      return ResultBuilder.success(this.mesBuildingStructureClassificationTypeLinkService.updateRivetWeldConfig(copy));
   }

   @ApiOperation("删除构件-组铆焊配置")
   @DeleteMapping
   @PreAuthorize("@permission.check('statistical_artifact_rivet_weld_config:del')")
   public ResultVO removeRivetWeldConfig(@RequestBody Set<Long> ids) {
      log.info("API 调用 ：删除构件-组铆焊配置");
      return ResultBuilder.success(this.mesBuildingStructureClassificationTypeLinkService.removeRivetWeldConfig(ids));
   }

   @ApiOperation("查询部件-组铆焊配置列表")
   @GetMapping("/assemble")
   @PreAuthorize("@permission.check('statistical_assemble_rivet_weld_config:get')")
   public ResultVO getAssembleRivetWeldConfig() {
      log.info("API 调用 ：查询部件-组铆焊配置列表");
      return ResultBuilder.success(this.mesBuildingAssembleRiveWeldLinkService.getAssembleRivetWeldConfig());
   }

   @ApiOperation("批量新增部件-组铆焊配置")
   @PostMapping("/assemble")
   @PreAuthorize("@permission.check('statistical_assemble_rivet_weld_config:add')")
   public ResultVO saveAssembleRivetWeldConfig(@Validated(AddBatch.class) @RequestBody List<MesBuildingAssembleLinkVO> vos) {
      log.info("API 调用 ：批量新增部件-组铆焊配置");
      List<MesBuildingAssembleLinkDTO> dtoList = new ArrayList<>();
      vos.forEach(
         vo -> {
            MesBuildingAssembleLinkDTO copy = BeanUtil.copy(vo, MesBuildingAssembleLinkDTO.class);
            copy.setStructureProcessPriceList(
               vo.getStructureProcessPriceList().stream().map(e -> BeanUtil.copy(e, MesBuildingStructureProcessPriceDTO.class)).collect(Collectors.toList())
            );
            dtoList.add(copy);
         }
      );
      return ResultBuilder.success(this.mesBuildingAssembleRiveWeldLinkService.saveAssembleRivetWeldConfig(dtoList));
   }

   @ApiOperation("修改部件-组铆焊配置")
   @PutMapping("/assemble")
   @PreAuthorize("@permission.check('statistical_assemble_rivet_weld_config:edit')")
   public ResultVO updateAssembleRivetWeldConfig(@Validated(Update.class) @RequestBody MesBuildingAssembleLinkVO vo) {
      log.info("API 调用 ：修改部件-组铆焊配置");
      MesBuildingAssembleLinkDTO copy = BeanUtil.copy(vo, MesBuildingAssembleLinkDTO.class);
      copy.setStructureProcessPriceList(
         vo.getStructureProcessPriceList().stream().map(e -> BeanUtil.copy(e, MesBuildingStructureProcessPriceDTO.class)).collect(Collectors.toList())
      );
      return ResultBuilder.success(this.mesBuildingAssembleRiveWeldLinkService.updateAssembleRivetWeldConfig(copy));
   }

   @ApiOperation("删除部件-组铆焊配置")
   @DeleteMapping("/assemble")
   @PreAuthorize("@permission.check('statistical_assemble_rivet_weld_config:del')")
   public ResultVO removeAssembleRivetWeldConfig(@RequestBody Set<Long> ids) {
      log.info("API 调用 ：删除部件-组铆焊配置");
      return ResultBuilder.success(this.mesBuildingAssembleRiveWeldLinkService.removeAssembleRivetWeldConfig(ids));
   }

   @ApiOperation("查询产品组铆焊总价")
   @GetMapping("/weldConfig/type")
   public ResultVO getRivetWeldConfig(@RequestParam Long productId) {
      log.info("API 调用 ：查询产品组铆焊总价");
      return ResultBuilder.success(this.mesBuildingArtifactTypeConfigService.getArtifactTypeConfig());
   }
}

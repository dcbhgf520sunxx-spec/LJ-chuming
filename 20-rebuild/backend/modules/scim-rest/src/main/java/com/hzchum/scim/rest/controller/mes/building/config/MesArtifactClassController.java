package com.hzchum.scim.rest.controller.mes.building.config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClass;
import com.hzchum.scim.system.core.api.pojo.request.MesArtifactClassDTO;
import com.hzchum.scim.system.core.api.service.MesArtifactClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mes/building/mes_artifact_class")
@Api(tags = "构件类别")
public class MesArtifactClassController {
   private static final Logger log = LoggerFactory.getLogger(MesArtifactClassController.class);
   @Autowired
   private MesArtifactClassService mesArtifactClassService;

   @GetMapping("/listAll")
   @PreAuthorize("@permission.check('conversion_rate_config:get')")
   @ApiOperation("构件类别查询")
   public ResultVO listAll() {
      return ResultBuilder.success(this.mesArtifactClassService.list());
   }

   @ApiOperation("保存")
   @ApiImplicitParams(
      @ApiImplicitParam(name = "vo", value = "保存参数", paramType = "add", required = true, dataType = "MesArtifactClass", dataTypeClass = MesArtifactClass.class)
   )
   @PostMapping("/save")
   @PreAuthorize("@permission.check('conversion_rate_config:add')")
   public ResultVO saveMesArtifactClass(@RequestBody MesArtifactClassDTO mesArtifactClassDTO) {
      log.info("API调用:保存构件类别，参数{}", mesArtifactClassDTO);
      return ResultBuilder.success(this.mesArtifactClassService.saveMesArtifactClass(mesArtifactClassDTO));
   }

   @PutMapping("/update")
   @PreAuthorize("@permission.check('conversion_rate_config:edit')")
   @ApiOperation("修改")
   public ResultVO updateMesArtifactClass(@RequestBody @Valid MesArtifactClass vo) {
      log.info("API调用:修改构件类别，参数{}", vo);
      return ResultBuilder.success(this.mesArtifactClassService.updateMesArtifactClass(vo));
   }

   @DeleteMapping("/delete")
   @PreAuthorize("@permission.check('conversion_rate_config:del')")
   @ApiOperation("删除")
   public ResultVO deleteMesArtifactClassByIds(@RequestBody List<Long> idList) {
      log.info("API调用:删除构件类别，参数{}", idList);
      return ResultBuilder.success(this.mesArtifactClassService.deleteMesArtifactClassByIds(idList));
   }

   public MesArtifactClassController(final MesArtifactClassService mesArtifactClassService) {
      this.mesArtifactClassService = mesArtifactClassService;
   }
}

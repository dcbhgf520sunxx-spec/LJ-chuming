package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.pojo.dto.TraceConfigItemDTO;
import com.hzchum.scim.system.core.api.pojo.dto.TraceConfigItemVO;
import com.hzchum.scim.system.core.api.service.TraceConfigItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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

@Api(tags = "溯源配置")
@RestController
@RequestMapping("/api/trace/config/traceability")
public class TraceConfigItemController {
   private static final Logger log = LoggerFactory.getLogger(TraceConfigItemController.class);
   @Resource
   private TraceConfigItemService traceConfigItemService;

   @ApiOperation("列表-溯源配置明细")
   @GetMapping
   public ResultVO<ListVO<TraceConfigItemVO>> list() {
      log.info("Api调用:溯源配置明细列表");
      return ResultBuilder.success(new ListVO<>(this.traceConfigItemService.listVO()));
   }

   @ApiOperation("批量新增-溯源配置明细")
   @PostMapping
   @PreAuthorize("@permission.check('mes_label_artifact:traceabilitySettingEdit')")
   public ResultVO save(@RequestBody @Validated(Add.class) List<TraceConfigItemDTO> dtoList) {
      log.info("Api调用:批量新增溯源配置明细");
      return ResultBuilder.success(this.traceConfigItemService.saveBatch(dtoList));
   }

   @ApiOperation("修改-溯源配置明细")
   @PutMapping
   @PreAuthorize("@permission.check('mes_label_artifact:traceabilitySettingEdit')")
   public ResultVO update(@RequestBody @Validated(Update.class) TraceConfigItemDTO dto) {
      log.info("Api调用:修改溯源配置明细");
      return ResultBuilder.success(this.traceConfigItemService.updateOne(dto));
   }

   @ApiOperation("删除-溯源配置明细")
   @DeleteMapping
   @PreAuthorize("@permission.check('mes_label_artifact:traceabilitySettingEdit')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("Api调用:删除溯源配置明细");
      return ResultBuilder.success(this.traceConfigItemService.removeByIds(ids));
   }
}

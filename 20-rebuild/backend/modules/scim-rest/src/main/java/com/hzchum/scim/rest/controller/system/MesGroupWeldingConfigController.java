package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.system.core.api.pojo.request.MesGroupWeldingConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesGroupWeldingConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工价配置-组焊配置")
@RequestMapping("/api/system/group-welding-config")
@RestController
@Validated
public class MesGroupWeldingConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesGroupWeldingConfigController.class);
   @Autowired
   private MesGroupWeldingConfigService groupWeldingConfigService;

   @ApiOperation("组焊配置列表")
   @GetMapping("list")
   public ResultVO list() {
      log.info("API 调用 ：组焊配置列表");
      return ResultBuilder.success(new ListVO<>(this.groupWeldingConfigService.listInfo()));
   }

   @ApiOperation("组焊配置分页")
   @GetMapping("page")
   public ResultVO page(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
      log.info("API 调用 ：组焊配置分页");
      return ResultBuilder.success(this.groupWeldingConfigService.pageInfo(pageNumber, pageSize));
   }

   @ApiOperation("组焊配置详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：组焊配置详情");
      return ResultBuilder.success(this.groupWeldingConfigService.detailById(id));
   }

   @ApiOperation("组焊配置新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesGroupWeldingConfigSaveDTOParam param) {
      log.info("API 调用 ：组焊配置新增");
      return ResultBuilder.success(this.groupWeldingConfigService.saveMesGroupWeldingConfig(param));
   }

   @ApiOperation("组焊配置批量新增")
   @PostMapping("batch-save")
   public ResultVO batchSave(@RequestBody @Validated(Add.class) ValidList<MesGroupWeldingConfigSaveDTOParam> paramList) {
      log.info("API 调用 ：组焊配置批量新增");
      return ResultBuilder.success(this.groupWeldingConfigService.batchSaveMesGroupWeldingConfig(paramList));
   }

   @ApiOperation("组焊配置修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesGroupWeldingConfigSaveDTOParam param) {
      log.info("API 调用 ：组焊配置修改");
      return ResultBuilder.success(this.groupWeldingConfigService.updateMesGroupWeldingConfig(param));
   }

   @ApiOperation("组焊配置批量删除")
   @DeleteMapping("batch-delete")
   public ResultVO batchDelete(@RequestBody @NotEmpty(message = "idList不能为空") List<Long> idList) {
      log.info("API 调用 ：组焊配置批量删除");
      return ResultBuilder.success(this.groupWeldingConfigService.batchDelete(idList));
   }
}

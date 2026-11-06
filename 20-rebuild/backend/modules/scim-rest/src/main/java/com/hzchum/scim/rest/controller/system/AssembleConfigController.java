package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.SysAssembleConfigBiz;
import com.hzchum.scim.system.core.api.biz.SysAssembleConfigChangeBiz;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.AssembleConfigChangeAuditDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.AssembleConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.AssembleConfigUpdateDTOParam;
import com.hzchum.scim.system.core.api.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-组立配置")
@RestController
@RequestMapping("/api/system/assemble-config")
public class AssembleConfigController {
   private static final Logger log = LoggerFactory.getLogger(AssembleConfigController.class);
   @Resource
   private SysAssembleConfigBiz assembleConfigBiz;
   @Resource
   private SysAssembleConfigChangeBiz assembleConfigChangeBiz;
   @Resource
   private ConfigService configService;

   @ApiOperation("组立配置列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "组立名称", paramType = "query"),
            @ApiImplicitParam(name = "specPrefix", value = "组立规格前缀", paramType = "query"),
            @ApiImplicitParam(name = "mesProductEnum", value = "mes分类 1建刚构件 2桥梁构件", paramType = "query")
      }
   )
   @GetMapping("")
   @PreAuthorize("@permission.check('machine_part_config:get')")
   public ResultVO<PageVO<AssembleConfigDTO>> list(
      @RequestParam(required = false) Boolean boolSectionSteel,
      Integer productionLineTypeEnum,
      String name,
      String specPrefix,
      @RequestParam Integer mesProductEnum,
      @RequestParam(required = false) String sectionAndNameAndType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:组立配置列表");
      return ResultBuilder.success(
         this.assembleConfigBiz
            .listPage(boolSectionSteel, productionLineTypeEnum, name, specPrefix, mesProductEnum, sectionAndNameAndType, pageNumber, pageSize)
      );
   }

   @ApiOperation("部件(单元件)配置全部列表")
   @GetMapping("list-info")
   public ResultVO listInfo(@RequestParam(required = false) Integer mesProductEnum) {
      log.info("Api调用:部件(单元件)配置全部列表");
      return ResultBuilder.success(this.assembleConfigBiz.listAll(mesProductEnum));
   }

   @ApiOperation("部件(单元件)配置全部列表(焊接)")
   @GetMapping("/welding/list-info")
   public ResultVO listWeldingInfo(@RequestParam(required = false) Integer mesProductEnum) {
      log.info("Api调用:部件(单元件)配置全部列表(焊接)");
      return ResultBuilder.success(this.assembleConfigBiz.listWeldingAll(mesProductEnum));
   }

   @ApiOperation("新增组立配置")
   @PostMapping
   @PreAuthorize("@permission.check('machine_part_config:add')")
   public ResultVO saveList(@RequestBody @Valid AssembleConfigSaveDTOParam param) {
      log.info("Api调用:新增组立配置");
      return ResultBuilder.success(this.assembleConfigBiz.add(param));
   }

   @ApiOperation("修改组立配置")
   @PutMapping
   @PreAuthorize("@permission.check('machine_part_config:edit')")
   public ResultVO update(@RequestBody @Valid AssembleConfigUpdateDTOParam param) {
      log.info("Api调用:修改组立配置");
      Boolean result;
      if (this.configService.getFeatureDefinitionConfig().getAuditType()) {
         result = this.assembleConfigChangeBiz.change(param);
      } else {
         result = this.assembleConfigBiz.updateAssembleConfig(param);
      }

      return ResultBuilder.success(result);
   }

   @ApiOperation("审批修改组立配置")
   @PutMapping("/auditUpdate")
   @PreAuthorize("@permission.check('machine_part_config:audit')")
   public ResultVO auditUpdate(@RequestBody @Valid AssembleConfigChangeAuditDTOParam param) {
      log.info("Api调用:变更审批组立配置");
      return ResultBuilder.success(this.assembleConfigChangeBiz.audit(param));
   }

   @ApiOperation("删除组立配置")
   @DeleteMapping
   @PreAuthorize("@permission.check('machine_part_config:del')")
   public ResultVO deleteList(@RequestBody @Valid List<Long> ids) {
      log.info("Api调用:删除组立配置");
      return ResultBuilder.success(this.assembleConfigBiz.deleteList(ids));
   }
}

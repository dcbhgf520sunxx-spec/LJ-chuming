package com.hzchum.scim.rest.controller.plan.change;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.plan.core.api.biz.change.TechChangeRecordBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ZnTechChangeImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeCheckDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeQueryDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeSaveDtoParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechChangeRecordQueryVoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "构件变更")
@RestController
@RequestMapping("/api/plan/tech-change")
public class TechChangeRecordController {
   private static final Logger log = LoggerFactory.getLogger(TechChangeRecordController.class);
   private final TechChangeRecordBiz changeRecordBiz;

   @ApiOperation("变更-获取构件列表")
   @GetMapping("/list-artifact")
   public ResultVO<PageVO<ArtifactResponseDTO>> pageListArtifact(
      @RequestParam Long projectId,
      @RequestParam Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long areaBatchId,
      @RequestParam(required = false) Integer artifactType,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:变更-获取构件列表");
      return ResultBuilder.success(
         this.changeRecordBiz.pageListArtifact(projectId, monomerId, areaId, areaBatchId, artifactType, name, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("导入变更清单")
   @PostMapping("/import/v1")
   @SignerCheck(lockKey = "#monomerId", message = "该单体正在导入变更清单,请勿重复提交")
   public ResultVO<TechChangeImportDTO> importChangeArtifact(@RequestParam Long monomerId, @RequestPart MultipartFile file) {
      log.info("Api调用:构件变更-导入变更清单(二次利用)");
      return ResultBuilder.success(this.changeRecordBiz.importChangeArtifactList(monomerId, file));
   }

   @ApiOperation("导入变更清单V2")
   @PostMapping("/import")
   @SignerCheck(lockKey = "#monomerId", message = "该单体正在导入变更清单,请勿重复提交")
   public ResultVO<ZnTechChangeImportDTO> importChangeArtifactV2(@RequestParam Long monomerId, @RequestPart MultipartFile file, HttpServletResponse response) {
      log.info("Api调用:构件变更-导入变更清单");
      return ResultBuilder.success(this.changeRecordBiz.importChangeArtifactListV2(monomerId, file, response));
   }

   @ApiOperation("导入变更清单(清单批量变更)")
   @PostMapping("/import/direct")
   @SignerCheck(lockKey = "#monomerId", message = "该单体正在导入变更清单,请勿重复提交")
   public void importListDirectChange(
      @RequestParam Long monomerId,
      @RequestParam Long areaId,
      @RequestParam Integer inventoryTypeEnum,
      @RequestParam Long changeReasonId,
      @RequestParam(required = false) String remark,
      @RequestPart MultipartFile file,
      HttpServletResponse response
   ) {
      log.info("Api调用:构件变更-导入变更清单(清单批量变更)");
      this.changeRecordBiz.importListDirectChange(monomerId, areaId, inventoryTypeEnum, changeReasonId, remark, file, response);
   }

   @ApiOperation("构件详情列表")
   @GetMapping("/list-artifact-detail")
   public ResultVO<ListVO<TechArtifactChangeDetailDTO>> listChangeArtifactDetail(@Valid TechChangeQueryDtoParam param) {
      log.info("Api调用:构件变更-构件一物一码详情列表");
      return ResultBuilder.success(new ListVO<>(this.changeRecordBiz.listChangeArtifactDetail(param)));
   }

   @ApiOperation("构件原来零部件列表")
   @GetMapping("/list-old-part")
   public ResultVO<ListVO<TechChangeMachinePartDTO>> listArtifactOldPart(@RequestParam Long monomerId, @RequestParam String serialNumber) {
      log.info("Api调用:构件变更-构件原来使用的零部件列表");
      return ResultBuilder.success(new ListVO<>(this.changeRecordBiz.listMachinePart(monomerId, serialNumber)));
   }

   @ApiOperation("变更记录-列表")
   @GetMapping
   public ResultVO<PageVO<TechChangeRecordDTO>> pageListChangeRecord(
      TechChangeRecordQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:构件变更-变更记录列表");
      return ResultBuilder.success(this.changeRecordBiz.pageListChangeRecord(param, pageNumber, pageSize));
   }

   @ApiOperation("变更记录-保存")
   @PostMapping
   @SignerCheck(lockKey = "#param.monomerId", message = "该单体正在发起变更中,请稍后刷新页面重试!", timeout = 200L)
   public ResultVO commitChange(@RequestBody @Valid TechChangeSaveDtoParam param) {
      log.info("Api调用:构件变更-提交变更");
      return ResultBuilder.success(this.changeRecordBiz.commitChangeRecordV2(param));
   }

   @ApiOperation("变更记录-审核")
   @PostMapping("/check")
   @SignerCheck(lockKey = "#param.id", message = "该记录正在发起审核中,请稍后刷新页面重试!")
   public ResultVO checkChange(@RequestBody @Valid TechChangeCheckDtoParam param) {
      log.info("Api调用:构件变更-审核变更");
      return ResultBuilder.success(this.changeRecordBiz.checkChange(param));
   }

   @ApiOperation("变更记录-列表下载")
   @GetMapping("/export/list")
   public void exportChangeRecord(
      TechChangeRecordQueryVoParam param,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      HttpServletResponse response
   ) {
      log.info("Api调用:构件变更-变更记录下载");
      this.changeRecordBiz.exportChangeRecord(param, pageNumber, pageSize, response);
   }

   public TechChangeRecordController(final TechChangeRecordBiz changeRecordBiz) {
      this.changeRecordBiz = changeRecordBiz;
   }
}

package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechArtifactProcessFileBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactClassSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactProcessFileAttachmentDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSnDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactProcessFileDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactProcessFileLinkDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactProcessFileBindDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileEditDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileQueryDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileSaveDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-技术清单-工艺文件")
@RestController
@RequestMapping("/api/plan/artifact-processFile")
public class TechArtifactProcessFileController {
   private static final Logger log = LoggerFactory.getLogger(TechArtifactProcessFileController.class);
   private final TechArtifactProcessFileBiz artifactProcessFileBiz;

   @ApiOperation("工艺文件-列表")
   @GetMapping
   @PreAuthorize("@permission.check('plan_process_list:get')")
   public ResultVO<PageVO<TechArtifactProcessFileDTO>> pageList(
      TechArtifactProcessFileQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:工艺文件列表");
      return ResultBuilder.success(this.artifactProcessFileBiz.pageListProcessFileByCondition(param, pageNumber, pageSize));
   }

   @ApiOperation("工艺文件-新增")
   @PostMapping
   @PreAuthorize("@permission.check('plan_process_list:add')")
   public ResultVO saveList(@RequestBody @Valid TechArtifactProcessFileSaveDTOParam param) throws RuntimeException {
      log.info("Api调用:新增工艺文件");
      return ResultBuilder.success(this.artifactProcessFileBiz.newSaveProcessFile(param));
   }

   @ApiOperation("工艺文件-修改")
   @PutMapping
   @PreAuthorize("@permission.check('plan_process_list:edit')")
   public ResultVO update(@RequestBody @Valid TechArtifactProcessFileEditDTOParam param) {
      log.info("Api调用:修改工艺文件");
      return ResultBuilder.success(this.artifactProcessFileBiz.updateProcessFile(param));
   }

   @ApiOperation("工艺文件-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('plan_process_list:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("Api调用:删除工艺文件");
      return ResultBuilder.success(this.artifactProcessFileBiz.deleteList(ids));
   }

   @ApiOperation("每种分类-构件编号数量")
   @GetMapping("/artifactClass-snQuantity")
   public ResultVO<ListVO<ArtifactClassSummaryDTO>> listClassSnQuantity(
      Integer processType, Boolean boolBindStatus, @RequestParam Long projectId, Long monomerId
   ) {
      log.info("Api调用:每种分类的构件编号数量");
      return ResultBuilder.success(new ListVO<>(this.artifactProcessFileBiz.listClassSnQuantity(processType, boolBindStatus, projectId, monomerId)));
   }

   @ApiOperation("构件编号-列表")
   @GetMapping("/artifactSnList")
   public ResultVO<ListVO<ArtifactSnDTO>> listArtifactSn(
      @RequestParam Long projectId,
      Long monomerId,
      @RequestParam Long processFileId,
      Boolean boolBindStatus,
      String name,
      String serialNumber,
      String specification,
      String material,
      String structureClassIds
   ) {
      log.info("Api调用: ");
      return ResultBuilder.success(
         new ListVO<>(
            this.artifactProcessFileBiz
               .listArtifactSn(projectId, monomerId, processFileId, boolBindStatus, name, serialNumber, specification, material, structureClassIds)
         )
      );
   }

   @ApiOperation("绑定构件")
   @PostMapping("/bind")
   @PreAuthorize("@permission.check('plan_process_list:bind')")
   public ResultVO bindArtifactProcessFile(@RequestBody @Valid ArtifactProcessFileBindDTOParam param) {
      return ResultBuilder.success(this.artifactProcessFileBiz.bindArtifactProcessFile(param));
   }

   @ApiOperation("已绑定构件列表")
   @GetMapping("/listBind")
   @PreAuthorize("@permission.check('plan_process_list:detail')")
   public ResultVO<PageVO<TechArtifactProcessFileLinkDTO>> pageListBind(
      @RequestParam Long processFileId,
      Long projectId,
      Long monomerId,
      Long structureClassId,
      String name,
      String serialNumber,
      String specification,
      String material,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 工艺文件绑定构件编号");
      return ResultBuilder.success(
         this.artifactProcessFileBiz
            .listBindByCondition(processFileId, projectId, monomerId, structureClassId, name, serialNumber, specification, material, pageNumber, pageSize)
      );
   }

   @ApiOperation("解绑-构件")
   @PutMapping("/unbind")
   @PreAuthorize("@permission.check('plan_process_list:unbind')")
   public ResultVO unBind(@RequestBody @Valid ArtifactProcessFileBindDTOParam param) {
      log.info("Api调用: 工艺文件解绑构件编号");
      return ResultBuilder.success(this.artifactProcessFileBiz.unbind(param));
   }

   @ApiOperation("解绑-全部构件")
   @PutMapping("/unbindAll/{processFileId}")
   @PreAuthorize("@permission.check('plan_process_list:unbind')")
   public ResultVO unBindAll(@PathVariable Long processFileId) {
      log.info("Api调用: 工艺文件解绑全部构件");
      return ResultBuilder.success(this.artifactProcessFileBiz.unbindAllArtifact(processFileId));
   }

   @ApiOperation("工艺文件附件-列表")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "monomerId", value = "单体id", required = true), @ApiImplicitParam(name = "serialNumber", value = "构件编号", required = true)}
   )
   @GetMapping("/app/list-attachment")
   public ResultVO<ListVO<ArtifactProcessFileAttachmentDTO>> listAttachment(@RequestParam Long monomerId, @RequestParam String serialNumber) {
      log.info("Api调用:查看构件的工艺文件列表");
      return ResultBuilder.success(new ListVO<>(this.artifactProcessFileBiz.listAttachment(monomerId, serialNumber)));
   }

   public TechArtifactProcessFileController(final TechArtifactProcessFileBiz artifactProcessFileBiz) {
      this.artifactProcessFileBiz = artifactProcessFileBiz;
   }
}

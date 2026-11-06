package com.hzchum.scim.rest.controller.plan.change;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechArtifactChangeBiz;
import com.hzchum.scim.plan.core.api.biz.change.TechChangeBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactInfoChangeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactQuantityChangeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactChangeQueryDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-构件变更")
@RestController
@RequestMapping("/api/plan/artifact/change")
public class ArtifactChangeApi {
   private static final Logger log = LoggerFactory.getLogger(ArtifactChangeApi.class);
   @Autowired
   private TechChangeBiz techChangeBiz;
   @Resource
   private TechArtifactChangeBiz artifactChangeBiz;

   @ApiOperation("构件变更记录")
   @GetMapping
   @PreAuthorize("@permission.check('mes_change_record:get')")
   public ResultVO<PageVO<TechArtifactChangeDTO>> listChange(
      TechArtifactChangeQueryDtoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：构件变更记录");
      return ResultBuilder.success(this.artifactChangeBiz.pageList(param, pageNumber, pageSize));
   }

   @ApiOperation("入库构件变更记录")
   @GetMapping("warehousing")
   public ResultVO<PageVO<TechArtifactChangeDTO>> warehousingListChange(
      TechArtifactChangeQueryDtoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：入库构件变更记录");
      return ResultBuilder.success(this.artifactChangeBiz.warehousingList(param, pageNumber, pageSize));
   }

   @ApiOperation("入库构件变更记录下载")
   @GetMapping("warehousing/download")
   public void warehousingListChangeDownload(
      HttpServletResponse response,
      TechArtifactChangeQueryDtoParam param,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：入库构件变更记录");
      this.artifactChangeBiz.warehousingListChangeDownload(response, param, pageNumber, pageSize);
   }

   @GetMapping("{id}")
   public ResultVO listChange(@PathVariable Long id) {
      log.info("API 调用 ：构件变更详情");
      return ResultBuilder.success(this.techChangeBiz.getChange(id));
   }

   @ApiOperation("构件数量变更")
   @PutMapping("/quantity")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:editNum')")
   public ResultVO changeArtifactQuantity(@RequestBody @Valid ArtifactQuantityChangeDTOParam param) {
      log.info("API 调用 ：构件数量变更");
      return ResultBuilder.success(this.artifactChangeBiz.changeArtifactQuantity(param));
   }

   @PutMapping("/info")
   public ResultVO changeArtifactInfo(@RequestBody @Valid ArtifactInfoChangeDTOParam param) {
      log.info("API 调用 ：构件信息变更");
      return ResultBuilder.success(this.techChangeBiz.changeArtifactInfo(param));
   }
}

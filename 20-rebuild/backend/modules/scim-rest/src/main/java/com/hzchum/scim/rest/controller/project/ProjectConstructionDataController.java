package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.ProjectConstructionDataBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectConstructionDataDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ConstructionDataQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ConstructionDataSaveDTOParam;
import io.swagger.annotations.Api;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "项目管理-资料管理-施工资料")
@RestController
@RequestMapping("/api/project/construction-data")
public class ProjectConstructionDataController {
   private static final Logger log = LoggerFactory.getLogger(ProjectConstructionDataController.class);
   @Resource
   private ProjectConstructionDataBiz constructionDataBiz;

   @ApiOperation("施工资料列表")
   @GetMapping
   @PreAuthorize("@permission.check('construction_data:get')")
   public ResultVO<PageVO<ProjectConstructionDataDTO>> list(
      @Valid ConstructionDataQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：施工资料列表");
      return ResultBuilder.success(this.constructionDataBiz.list(param, pageNumber, pageSize));
   }

   @ApiOperation("新增施工资料")
   @PostMapping("")
   @PreAuthorize("@permission.check('construction_data:add')")
   public ResultVO uploadFile(@RequestPart MultipartFile file, @Valid ConstructionDataSaveDTOParam param) {
      log.info("API 调用 ：新增施工资料");
      return ResultBuilder.success(this.constructionDataBiz.uploadFile(file, param));
   }

   @ApiOperation("删除施工资料")
   @DeleteMapping
   @PreAuthorize("@permission.check('construction_data:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除施工资料");
      return ResultBuilder.success(this.constructionDataBiz.removeData(ids));
   }
}

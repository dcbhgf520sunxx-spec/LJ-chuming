package com.hzchum.scim.rest.controller.project;

import cn.hutool.core.date.DateUtil;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.ProjectWasteProductBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectWasteProductMainDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectWasteProductMainDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "退货管理-废品库")
@RestController
@RequestMapping("/api/project/wasteProductMain")
public class ProjectWasteProductMainController {
   private static final Logger log = LoggerFactory.getLogger(ProjectWasteProductMainController.class);
   private final ProjectWasteProductBiz projectWasteProductBiz;

   @ApiOperation("废品库主表分页查询")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('waste_storage_record:get')")
   public ResultVO<PageVO<ProjectWasteProductMainDTO>> page(
      @RequestParam(required = false) Integer productType,
      @RequestParam(required = false) Integer relationType,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) String createTimeStart,
      @RequestParam(required = false) String createTimeEnd,
      @RequestParam(required = false) String createUserName,
      @RequestParam(required = false) String auditUserName,
      @RequestParam(required = false) Integer auditStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      Date createTimeStartDate = null;
      Date createTimeEndDate = null;
      if (createTimeStart != null && createTimeEnd != null) {
         createTimeStartDate = new Date(Long.parseLong(createTimeStart));
         createTimeEndDate = new Date(Long.parseLong(createTimeEnd));
         createTimeEndDate = DateUtil.endOfDay(createTimeEndDate);
      }

      log.info("Api调用:废品库主表分页查询");
      return ResultBuilder.success(
         this.projectWasteProductBiz
            .pageListWasteMain(
               productType,
               relationType,
               serialNumber,
               projectName,
               createTimeStartDate,
               createTimeEndDate,
               createUserName,
               auditUserName,
               auditStatus,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("打印废品库主表")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('waste_storage_record:print')")
   public ResultVO<PrintVO<List<ProjectWasteProductMainDTO>>> wasteProductPrint(
      @RequestParam(required = false) Integer productType,
      @RequestParam(required = false) Integer relationType,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) String createTimeStart,
      @RequestParam(required = false) String createTimeEnd,
      @RequestParam(required = false) String createUserName,
      @RequestParam(required = false) String auditUserName,
      @RequestParam(required = false) Integer auditStatus
   ) {
      log.info("Api调用:废品库主表打印");
      Date createTimeStartDate = null;
      Date createTimeEndDate = null;
      if (createTimeStart != null && createTimeEnd != null) {
         createTimeStartDate = new Date(Long.parseLong(createTimeStart));
         createTimeEndDate = new Date(Long.parseLong(createTimeEnd));
      }

      return ResultBuilder.success(
         this.projectWasteProductBiz
            .printListWasteMain(
               productType, relationType, serialNumber, projectName, createTimeStartDate, createTimeEndDate, createUserName, auditUserName, auditStatus
            )
      );
   }

   @ApiOperation("出库-保存")
   @PostMapping("/save")
   public ResultVO<Boolean> save(@RequestBody @Valid ProjectWasteProductMainDTOParam vo) {
      log.info("Api调用:废品库主表保存");
      return ResultBuilder.success(this.projectWasteProductBiz.saveWasteHandle(vo));
   }

   @ApiOperation("出库-审批")
   @PostMapping("/audit")
   public ResultVO<Boolean> audit(@RequestBody @Valid ProjectReturnProductCheckDTOParam param) {
      log.info("Api调用:废品库出库记录审核");
      return ResultBuilder.success(this.projectWasteProductBiz.auditWasteHandle(param));
   }

   @ApiOperation("出库-删除")
   @DeleteMapping
   public ResultVO<Boolean> delete(@RequestBody List<Long> idList) {
      log.info("Api调用:废品库主表删除");
      return ResultBuilder.success(this.projectWasteProductBiz.delete(idList));
   }

   public ProjectWasteProductMainController(final ProjectWasteProductBiz projectWasteProductBiz) {
      this.projectWasteProductBiz = projectWasteProductBiz;
   }
}

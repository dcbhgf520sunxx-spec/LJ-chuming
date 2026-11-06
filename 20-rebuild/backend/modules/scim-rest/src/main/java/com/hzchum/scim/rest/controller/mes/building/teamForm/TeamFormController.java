package com.hzchum.scim.rest.controller.mes.building.teamForm;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.teamForm.TeamFormBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.teamForm.TeamFormDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.teamForm.get.TeamFormRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES班组报表")
@RestController
@RequestMapping("/api/mes/building/team_form")
public class TeamFormController {
   private static final Logger log = LoggerFactory.getLogger(TeamFormController.class);
   @Autowired
   private TeamFormBiz teamFormBiz;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;

   @ApiOperation("获取构件组立生产详情")
   @GetMapping("/artifact_assemble/details")
   public ResultVO teamFormProcessDetails(TeamFormRequest voRequest) {
      log.info("API 调用 ：获取构件组立生产详情");
      return ResultBuilder.success(
         new ListVO<>(this.teamFormBiz.teamFormProcessDetails(BeanUtil.copy(voRequest, TeamFormDTOParam.class).setProjectIds(this.utilsBiz.getProjectIds())))
      );
   }

   @ApiOperation("获取构件组立生产详情")
   @GetMapping("/artifact_assemble/details/page")
   public ResultVO teamFormProcessDetailsPage(
      TeamFormRequest voRequest,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：获取构件组立生产详情");
      return ResultBuilder.success(
         this.teamFormBiz
            .teamFormProcessDetailsPage(
               BeanUtil.copy(voRequest, TeamFormDTOParam.class).setProjectIds(this.utilsBiz.getProjectIds()), sort, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("获取构件组立生产详情打印")
   @GetMapping("/artifact_assemble/details/print")
   public ResultVO teamFormProcessDetailsPrint(TeamFormRequest voRequest) {
      log.info("API 调用 ：获取构件组立生产详情打印");
      return ResultBuilder.success(this.teamFormBiz.teamFormProcessDetailsPrint(BeanUtil.copy(voRequest, TeamFormDTOParam.class)));
   }

   @ApiOperation("获取构件组立生产工序")
   @GetMapping("/artifact_assemble/process")
   public ResultVO teamFormProcess(TeamFormRequest voRequest) {
      log.info("API 调用 ：获取构件组立生产工序详情");
      return ResultBuilder.success(
         this.teamFormBiz.teamFormProcess(BeanUtil.copy(voRequest, TeamFormDTOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
      );
   }

   @ApiOperation("获取构件组立生产工序")
   @GetMapping("/artifact_assemble/process/page")
   public ResultVO teamFormProcessPage(
      TeamFormRequest voRequest,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：获取构件组立生产工序详情");
      return ResultBuilder.success(
         this.teamFormBiz
            .teamFormProcessPage(BeanUtil.copy(voRequest, TeamFormDTOParam.class).setProjectIds(this.utilsBiz.getProjectIds()), sort, pageNumber, pageSize)
      );
   }

   @ApiOperation("获取构件组立生产工序打印")
   @GetMapping("/artifact_assemble/process/print")
   public ResultVO teamFormProcessPrint(TeamFormRequest voRequest) {
      log.info("API 调用 ：获取构件组立生产工序打印");
      return ResultBuilder.success(this.teamFormBiz.teamFormProcessPrint(BeanUtil.copy(voRequest, TeamFormDTOParam.class)));
   }

   @ApiOperation("获取围护生产汇总")
   @GetMapping("/enclosure")
   public ResultVO teamFormEnclosure(TeamFormRequest voRequest) {
      log.info("API 调用 ：获取围护生产汇总");
      return ResultBuilder.success(this.teamFormBiz.teamFormEnclosure(BeanUtil.copy(voRequest, TeamFormDTOParam.class)));
   }

   @ApiOperation("获取围护生产详情")
   @GetMapping("/enclosure/details")
   public ResultVO teamFormEnclosureDetails(TeamFormRequest voRequest) {
      log.info("API 调用 ：获取围护生产详情");
      return ResultBuilder.success(this.teamFormBiz.teamFormEnclosureDetails(BeanUtil.copy(voRequest, TeamFormDTOParam.class)));
   }

   @ApiOperation("获取围护生产详情打印")
   @GetMapping("/enclosure/details/print")
   public ResultVO teamFormEnclosureDetailsPrint(TeamFormRequest voRequest) {
      log.info("API 调用 ：获取围护生产详情打印");
      return ResultBuilder.success(this.teamFormBiz.teamFormEnclosureDetailsPrint(BeanUtil.copy(voRequest, TeamFormDTOParam.class)));
   }
}

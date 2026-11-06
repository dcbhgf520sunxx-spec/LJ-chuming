package com.hzchum.scim.rest.controller.mes.building.laborManagement;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.biz.laborManagement.MesRosterBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesRosterQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesRosterSaveParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES-劳务管理-花名册")
@RequestMapping("/api/mes/building/labor-management/roster")
@RestController
public class MesRosterController {
   private static final Logger log = LoggerFactory.getLogger(MesRosterController.class);
   @Autowired
   private MesRosterBiz rosterBiz;

   @ApiOperation("花名册人员信息分页")
   @GetMapping("page")
   public ResultVO rosterPage(
      MesRosterQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API 调用 ：花名册人员信息分页查询");
      return ResultBuilder.success(this.rosterBiz.rosterPage(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("花名册人员信息下载")
   @GetMapping("/download")
   public void rosterDownload(MesRosterQuery query, HttpServletResponse response) {
      log.info("API 调用 ：花名册人员信息下载");
      this.rosterBiz.rosterDownload(query, response);
   }

   @ApiOperation("民族列表")
   @GetMapping("nation-list")
   public ResultVO nationList() {
      log.info("API 调用 ：民族列表");
      return ResultBuilder.success(this.rosterBiz.nationList());
   }

   @ApiOperation("按年龄统计人数")
   @GetMapping("age-statistics")
   public ResultVO ageStatistics() {
      log.info("API 调用 ：按年龄统计人数");
      return ResultBuilder.success(this.rosterBiz.ageStatistics());
   }

   @ApiOperation("花名册人员详情查询")
   @GetMapping("getRosterInfo")
   public ResultVO getRosterInfo(@RequestParam Long id) {
      log.info("API 调用 ：花名册人员详情查询");
      return ResultBuilder.success(this.rosterBiz.getRosterInfo(id));
   }

   @ApiOperation("花名册人员信息二维码打印")
   @GetMapping("qr-code/print")
   public ResultVO qrCodePrint(@RequestParam Long id) {
      log.info("API 调用 ：花名册人员信息二维码打印");
      return ResultBuilder.success(this.rosterBiz.qrCodePrint(id));
   }

   @ApiOperation("花名册信息注册")
   @PostMapping
   public ResultVO saveRoster(@RequestBody @Validated(Add.class) MesRosterSaveParam param) {
      log.info("API 调用 ：花名册信息注册");
      return ResultBuilder.success(this.rosterBiz.saveRoster(param));
   }

   @ApiOperation("花名册人员信息修改")
   @PutMapping
   @SignerCheck(lockKey = "#param.id", message = "花名册人员信息正在修改请刷新稍后重试")
   public ResultVO updateRoster(@RequestBody @Validated(Update.class) MesRosterSaveParam param) {
      log.info("API 调用 ：花名册人员信息修改");
      return ResultBuilder.success(this.rosterBiz.updateRoster(param));
   }

   @ApiOperation("花名册人员状态修改")
   @PutMapping("updateStatus")
   @PreAuthorize("@permission.check('roster_config:editStatus')")
   @SignerCheck(lockKey = "#id", message = "花名册人员正在修改请刷新稍后重试")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Integer status) {
      log.info("API 调用 ：花名册人员状态修改");
      return ResultBuilder.success(this.rosterBiz.updateStatus(id, status));
   }

   @ApiOperation("花名册人员删除")
   @DeleteMapping
   @SignerCheck(lockKey = "#id", message = "花名册人员正在删除请刷新稍后重试")
   public ResultVO deleteRoster(@RequestParam Long id) {
      log.info("API 调用 ：删除花名册");
      return ResultBuilder.success(this.rosterBiz.deleteRoster(id));
   }

   @ApiOperation("花名册人员详情查询")
   @GetMapping("/wxApp/info")
   public ResultVO getWxAppRosterInfo() {
      log.info("API 调用 ：花名册人员详情查询");
      return ResultBuilder.success(this.rosterBiz.getWxAppRosterInfo());
   }
}

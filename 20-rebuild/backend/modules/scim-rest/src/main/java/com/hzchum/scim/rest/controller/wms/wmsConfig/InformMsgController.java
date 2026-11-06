package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.service.WmsInformMsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-通知表")
@Validated
@RequestMapping("/api/v2/wms/inform/msg")
@RestController
public class InformMsgController {
   private static final Logger log = LoggerFactory.getLogger(InformMsgController.class);
   @Resource
   private WmsInformMsgService wmsInformMsgService;

   @ApiOperation("获取InformMsg信息")
   @GetMapping("/getAll")
   public ResultVO list(@RequestParam(value = "status", required = false) Integer status) {
      log.info("API 调用 ：获取InformMsg信息");
      return ResultBuilder.success(this.wmsInformMsgService.getAll(status));
   }

   @ApiOperation("根据ID修改已读状态")
   @PutMapping("/update/status")
   public ResultVO updateStatusById(@RequestParam("id") Long id, @RequestParam("status") Boolean status) {
      log.info("API 调用 ：根据ID修改已读状态");
      return ResultBuilder.success(this.wmsInformMsgService.updateStatusById(id, status));
   }

   @ApiOperation("删除通知信息")
   @DeleteMapping("/delIds")
   public ResultVO del(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除通知信息");
      return ResultBuilder.success(this.wmsInformMsgService.del(ids));
   }

   @ApiOperation("一键已读通知信息")
   @PutMapping("/readAll")
   public ResultVO readAll() {
      log.info("API 调用 ：一键已读通知信息");
      return ResultBuilder.success(this.wmsInformMsgService.readAll());
   }

   @ApiOperation("一键清空已读通知信息")
   @PutMapping("/cleanReadAll")
   public ResultVO cleanReadAll() {
      log.info("API 调用 ：一键清空已读通知信息");
      return ResultBuilder.success(this.wmsInformMsgService.cleanReadAll());
   }

   @ApiOperation("判断该通知信息需要跳转到哪个页面《1：审核页面 2：详情页面 3：重写页面 SkipPageEnum》")
   @GetMapping("/getSkipPage")
   public ResultVO getSkipPage(@RequestParam(value = "id", required = true) Long id) {
      log.info("API 调用 ：判断该通知信息需要跳转到哪个页面《1：审核页面 2：详情页面 3：重写页面 SkipPageEnum》");
      return ResultBuilder.success(this.wmsInformMsgService.getSkipPage(id));
   }
}

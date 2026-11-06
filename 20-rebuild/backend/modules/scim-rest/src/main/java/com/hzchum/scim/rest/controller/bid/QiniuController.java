package com.hzchum.scim.rest.controller.bid;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.bid.core.api.service.QiniuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "公共-文件")
@RestController
@RequestMapping("/api/file")
public class QiniuController {
   private static final Logger log = LoggerFactory.getLogger(QiniuController.class);
   @Resource
   private QiniuService qiniuService;

   @ApiOperation("文件上传回调")
   @PostMapping("callback")
   public ResultVO callback(HttpServletRequest request) {
      log.info("API 调用 ：文件上传回调");
      return ResultBuilder.success(this.qiniuService.callback(request));
   }

   @ApiOperation("获取七牛云凭证")
   @GetMapping
   public ResultVO getToken(Integer type) {
      log.info("API 调用 ：获取七牛云凭证");
      return ResultBuilder.success(this.qiniuService.getToken(type));
   }

   @ApiOperation("文件下载")
   @GetMapping("download/{id}")
   public ResultVO download(@PathVariable Long id) {
      log.info("API 调用 ：文件下载");
      return ResultBuilder.success(this.qiniuService.getUrl(id));
   }
}

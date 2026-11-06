package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationLevelConfigBiz;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationLevelConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationLevelConfigSaveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "推送管理-等级配置")
@RestController
@RequestMapping("/api/level/config")
public class NotificationLevelConfigController {
   private static final Logger log = LoggerFactory.getLogger(NotificationLevelConfigController.class);
   @Resource
   private SysPushNotificationLevelConfigBiz sysPushNotificationLevelConfigBiz;
   @Resource
   private RedisTemplate redisTemplate;

   @ApiOperation("推送等级配置编辑")
   @PostMapping("")
   public ResultVO saveConfig(@RequestBody @Valid List<NotificationLevelConfigSaveVO> vo) {
      log.info("API调用:推送等级配置编辑");
      return ResultBuilder.success(
         this.sysPushNotificationLevelConfigBiz
            .saveConfig(vo.stream().map(item -> BeanUtil.copy(item, NotificationLevelConfigSaveDTOParam.class)).collect(Collectors.toList()))
      );
   }

   @ApiOperation("获取推送等级配置")
   @GetMapping("")
   public ResultVO getConfig() {
      log.info("APi调用:获取推送等级配置");
      return ResultBuilder.success(this.sysPushNotificationLevelConfigBiz.getConfig());
   }

   public NotificationLevelConfigController(final SysPushNotificationLevelConfigBiz sysPushNotificationLevelConfigBiz, final RedisTemplate redisTemplate) {
      this.sysPushNotificationLevelConfigBiz = sysPushNotificationLevelConfigBiz;
      this.redisTemplate = redisTemplate;
   }
}

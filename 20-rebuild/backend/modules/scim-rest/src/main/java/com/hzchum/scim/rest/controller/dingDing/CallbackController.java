package com.hzchum.scim.rest.controller.dingDing;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse.ProcessInstanceTopVo;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.ApproveInstanceStatusEnum;
import com.hzchum.scim.common.core.api.enums.EventHandleStatusEnum;
import com.hzchum.scim.common.core.api.enums.ResultEnum;
import com.hzchum.scim.common.core.api.pojo.common.TaskChangeInfo;
import com.hzchum.scim.rest.common.DingCallbackCrypto;
import com.hzchum.scim.system.core.api.common.constant.EventTypeConstants;
import com.hzchum.scim.system.core.api.common.enums.ApproveStatusEnum;
import com.hzchum.scim.system.core.api.common.utils.DingDingUtils;
import com.hzchum.scim.system.core.api.pojo._do.ApproveInstance;
import com.hzchum.scim.system.core.api.service.ApproveInstanceService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dd/callback")
public class CallbackController {
   private static final Logger log = LoggerFactory.getLogger(CallbackController.class);
   @Resource
   private ConfigProperties configProperties;
   @Resource
   ApproveInstanceService approveInstanceService;
   @Resource
   UserService userService;

   @PostMapping
   @ResponseBody
   public Map<String, String> callback(
      @RequestParam(value = "signature", required = false) String signature,
      @RequestParam(value = "timestamp", required = false) String timestamp,
      @RequestParam(value = "nonce", required = false) String nonce,
      @RequestBody(required = false) JSONObject json
   ) {
      DingCallbackCrypto callbackCrypto = null;
      String processInstanceId = null;

      try {
         callbackCrypto = new DingCallbackCrypto(this.configProperties.getToken(), this.configProperties.getAesKey(), this.configProperties.getCorpId());
         String encryptMsg = json.getString("encrypt");
         String plainText = callbackCrypto.getDecryptMsg(signature, timestamp, nonce, encryptMsg);
         JSONObject obj = JSON.parseObject(plainText);
         String eventType = obj.getString("EventType");
         TaskChangeInfo info = JSON.parseObject(plainText, TaskChangeInfo.class);
         if (EventTypeConstants.BPMS_TASK_CHANGE.equals(eventType)) {
            processInstanceId = info.getProcessInstanceId();
            if (EventHandleStatusEnum.FINISH.getName().equals(info.getType())) {
               log.info("审批任务完成事件处理-------------------------------------");
               ProcessInstanceTopVo processInstance = DingDingUtils.getProcessInstance(info.getProcessInstanceId());
               Integer approveStatus = this.getApproveInstanceStatus(processInstance);
               if (approveStatus != null) {
                  ApproveInstance approveInstance = this.approveInstanceService
                     .getOne((Wrapper<ApproveInstance>)Wrappers.<ApproveInstance>lambdaQuery().eq(ApproveInstance::getInstanceId, processInstanceId));
                  if (approveInstance != null
                     && (
                        !approveInstance.getStatus().equals(ApproveStatusEnum.PASS.getType())
                           || !approveInstance.getStatus().equals(ApproveStatusEnum.FAIL.getType())
                     )) {
                     log.info("收到PM审批任务进度更新: " + plainText);
                     this.approveInstanceService.handleApproveInstanceService(approveStatus, approveInstance, info.getStaffId());
                     this.approveInstanceService.updateById(approveInstance);
                  }
               }
            }
         } else if (EventTypeConstants.BPMS_INSTANCE_CHANGE.equals(eventType)) {
            if (info.getType().equals("terminate")) {
               log.info("审批实例撤销事件处理-------------------------------------");
               ApproveInstance approveInstance = this.approveInstanceService
                  .getOne(
                     (Wrapper<ApproveInstance>)((new LambdaQueryWrapper<ApproveInstance>()
                              .eq(ApproveInstance::getInstanceId, info.getProcessInstanceId()))
                           .or())
                        .eq(ApproveInstance::getInstanceId, info.getProcessInstanceId())
                  );
               Preconditions.checkArgument(approveInstance.getStatus().equals(ApproveStatusEnum.WAIT.getType()), "只能撤销待审核");
               approveInstance.setStatus(ApproveStatusEnum.CANCEL.getType());
               this.approveInstanceService.updateById(approveInstance);
               this.approveInstanceService.handleApproveInstanceService(ApproveStatusEnum.CANCEL.getType(), approveInstance, info.getStaffId());
            }
         } else if ("user_add_org".equals(eventType)) {
            log.info(eventType + "通讯录用户增加事件处理---------------------------------" + obj);
            this.userService.ddChangeUser(plainText);
         } else if ("user_modify_org".equals(eventType)) {
            log.info(eventType + "通讯录用户更改事件处理---------------------------------" + obj);
            this.userService.ddChangeUser(plainText);
         } else if ("user_leave_org".equals(eventType)) {
            log.info(eventType + "通讯录用户离职事件处理---------------------------------" + obj);
            this.userService.ddChangeUser(plainText);
         }

         return callbackCrypto.getEncryptedMap("success");
      } catch (DingCallbackCrypto.DingTalkEncryptException e) {
         e.printStackTrace();
         return null;
      }
   }

   private Integer getApproveInstanceStatus(ProcessInstanceTopVo processInstance) {
      Integer approveStatus = null;
      if (ApproveInstanceStatusEnum.COMPLETED.getName().equals(processInstance.getStatus())) {
         if (ResultEnum.AGREE.getName().equals(processInstance.getResult())) {
            approveStatus = ApproveStatusEnum.PASS.getType();
         } else {
            approveStatus = ApproveStatusEnum.FAIL.getType();
         }
      } else if (!ApproveInstanceStatusEnum.TERMINATED.getName().equals(processInstance.getStatus())) {
         if (ApproveInstanceStatusEnum.RUNNING.getName().equals(processInstance.getStatus())) {
            approveStatus = ApproveStatusEnum.WAIT.getType();
         } else {
            log.info("其他事件状态处理---------------------------------");
         }
      }

      return approveStatus;
   }
}

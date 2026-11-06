package com.hzchum.scim.system.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.dingtalkworkflow_1_0.Client;
import com.aliyun.teaopenapi.models.Config;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest.FormComponentValueVo;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest.ProcessInstanceApproverVo;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.ApproveUserInfo;
import com.hzchum.scim.common.core.api.pojo.common.FormComponentValue;
import com.hzchum.scim.common.core.api.pojo.vo.ApproveInfoVO;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.ApproveProcessTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ApproveStatusEnum;
import com.hzchum.scim.system.core.api.common.enums.TaskActionTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.DingDingUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.ApproveInstance;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DingDing.ApproveProcessDTO;
import com.hzchum.scim.system.core.api.service.ApproveInstanceService;
import com.hzchum.scim.system.core.api.service.ApproveProcessService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.ApproveInstanceMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class ApproveInstanceServiceImpl extends ServiceImpl<ApproveInstanceMapper, ApproveInstance> implements ApproveInstanceService {
   @Resource
   ApproveProcessService approveProcessService;
   @Resource
   UserService userService;
   @Resource
   ApplyPurchaseService applyPurchaseService;

   @Override
   public void createApproveInstance(Long id, Long approveProcessId, List<FormComponentValue> values, String info) {
      ApproveProcessDTO process = this.approveProcessService.byId(approveProcessId);

      for (ApproveInfoVO approver : process.getApprovers()) {
         for (ApproveUserInfo user : approver.getUsers()) {
            User one = this.userService.getOne((Wrapper<User>)Wrappers.<User>lambdaQuery().eq(User::getDdUserId, user.getDdUserId()));
            Preconditions.checkArgument(one.getIsEnabled(), "当前审批人员已在钉钉中禁用或删除,请修改核对审批流程.");
         }
      }

      ApproveInstance record = new ApproveInstance();
      record.setCreateUserId(UserUtil.getCurrentUserId());
      record.setCreateUserName(UserUtil.getCurrentName());
      record.setTemplateId(process.getId());
      record.setType(process.getType());
      record.setInfo(info);
      record.setFromValue(JSON.toJSONString(values));
      record.setActualId(id);
      record.setApproveProcess(JSON.toJSONString(process));
      String processInstanceId = null;

      try {
         processInstanceId = this.sendProcessInstance(process.getCode(), process, values);
      } catch (Exception e) {
         e.printStackTrace();
      }

      record.setInstanceId(processInstanceId);
      record.setStatus(ApproveStatusEnum.WAIT.getType());
      this.baseMapper.insert(record);
   }

   @Override
   public void handleApproveInstanceService(Integer approveStatus, ApproveInstance approveInstance, String staffId) {
      if (approveStatus.equals(ApproveStatusEnum.PASS.getType())) {
         if (ApproveProcessTypeEnum.APPLY_PURCHASE.getType().equals(approveInstance.getType())) {
            this.applyPurchaseService.updateStatus(approveInstance.getActualId(), ReviewStatusEnum.REVIEWED.getType());
         }
      } else if (approveStatus.equals(ApproveStatusEnum.FAIL.getType())) {
         if (ApproveProcessTypeEnum.APPLY_PURCHASE.getType().equals(approveInstance.getType())) {
            this.applyPurchaseService.updateStatus(approveInstance.getActualId(), ReviewStatusEnum.RETURNED.getType());
         }
      } else if (approveStatus.equals(ApproveStatusEnum.WAIT.getType())) {
         if (ApproveProcessTypeEnum.APPLY_PURCHASE.getType().equals(approveInstance.getType())) {
            this.applyPurchaseService.updateStatus(approveInstance.getActualId(), ReviewStatusEnum.AUDITING.getType());
         }
      } else if (approveStatus.equals(ApproveStatusEnum.CANCEL.getType()) && ApproveProcessTypeEnum.APPLY_PURCHASE.getType().equals(approveInstance.getType())) {
         this.applyPurchaseService.updateStatus(approveInstance.getActualId(), ReviewStatusEnum.CANCEL.getType());
      }
   }

   private String sendProcessInstance(String code, ApproveProcessDTO process, List<FormComponentValue> values) throws Exception {
      Config config = new Config();
      config.protocol = "https";
      config.regionId = "central";
      new Client(config);
      OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
      request.setProcessCode(code);
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user.getDdUserId() != null, "请联系管理员在钉钉创建与当前用户手机号相同的账号");
      request.setDeptId(user.getDdDeptId());
      request.setOriginatorUserId(user.getDdUserId());
      List<ProcessInstanceApproverVo> approverList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(process.getApprovers())) {
         process.getApprovers().forEach(item -> {
            ProcessInstanceApproverVo approver = new ProcessInstanceApproverVo();
            approver.setTaskActionType(TaskActionTypeEnum.getNameByType(item.getType()));
            approver.setUserIds(item.getUsers().stream().map(ApproveUserInfo::getDdUserId).collect(Collectors.toList()));
            approverList.add(approver);
         });
      }

      request.setApproversV2(approverList);
      List<FormComponentValueVo> formComponentValues = new ArrayList<>();
      values.forEach(item -> {
         FormComponentValueVo value = new FormComponentValueVo();
         value.setName(item.getName());
         value.setValue(item.getValue() == null ? "" : item.getValue());
         value.setExtValue(item.getExt_value());
         formComponentValues.add(value);
      });
      request.setFormComponentValues(formComponentValues);
      return DingDingUtils.createProcessInstance(request);
   }
}

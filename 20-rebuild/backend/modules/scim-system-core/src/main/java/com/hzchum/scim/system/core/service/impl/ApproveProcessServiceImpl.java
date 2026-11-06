package com.hzchum.scim.system.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.ApproveInfo;
import com.hzchum.scim.common.core.api.pojo.common.ApproveUserInfo;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.vo.ApproveInfoVO;
import com.hzchum.scim.contract.core.api.common.MapConstants;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.system.core.api.common.enums.ApproveProcessTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.TaskActionTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.DingDingUtils;
import com.hzchum.scim.system.core.api.pojo._do.ApproveCode;
import com.hzchum.scim.system.core.api.pojo._do.ApproveProcess;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DingDing.ApproveProcessDTO;
import com.hzchum.scim.system.core.api.pojo.request.ApprovalProcessDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.ApproverDTOParam;
import com.hzchum.scim.system.core.api.service.ApproveProcessService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.ApproveCodeMapper;
import com.hzchum.scim.system.core.mapper.ApproveProcessMapper;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApproveProcessServiceImpl extends ServiceImpl<ApproveProcessMapper, ApproveProcess> implements ApproveProcessService {
   @Resource
   UserService userService;
   @Resource
   ApproveCodeMapper approveCodeMapper;
   @Resource
   ApplyPurchaseService applyPurchaseService;
   @Resource
   ConfigService configService;

   @Override
   public void create(ApproveProcessTypeEnum type) {
      String token = MapConstants.getStringConstantsMap().get("ddAccessToken");
      String code = DingDingUtils.getProcess(type.getName(), token);
      String newCode = DingDingUtils.saveProcess(type.getName(), code, token);
      ApproveCode approveCode = this.approveCodeMapper.selectOne((Wrapper<ApproveCode>)Wrappers.<ApproveCode>lambdaQuery().eq(ApproveCode::getTemplateType, type.getType()));
      if (approveCode != null) {
         approveCode.setCode(newCode);
         this.approveCodeMapper.updateById(approveCode);
      } else {
         this.approveCodeMapper.insert(ApproveCode.builder().templateType(type.getType()).code(newCode).build());
      }
   }

   @Override
   public List<ApproveProcessDTO> getList(Integer type) {
      return this.baseMapper.selectList(Wrappers.<ApproveProcess>lambdaQuery().eq(type != null, ApproveProcess::getType, type)).stream().map(ap -> {
         ApproveProcessDTO dto = BeanUtil.copy(ap, ApproveProcessDTO.class);
         dto.setApplicantIds(CommonUtil.spilt(ap.getApplicantIds(), ","));
         dto.setApprovers(this.getObjInfo(ap.getApproveInfo()));
         dto.setUpdateTime(ap.getUpdateTime());
         return dto;
      }).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateAP(ApprovalProcessDTOParam param) {
      ApproveProcess approveProcess = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(approveProcess != null, "审批模板异常,请核对后重试.");
      approveProcess.setApplicantIds(this.userService.checkUserIds(param.getApplicantIds(), "当前设置的可发起审批用户不存在"));
      approveProcess.setApproveInfoName(param.getApproveInfoName());
      approveProcess.setApproveInfo(this.getStrInfo(param.getList()));
      approveProcess.setType(param.getType());
      return this.baseMapper.updateById(approveProcess) == 1;
   }

   @Override
   public String getStrInfo(List<ApproverDTOParam> approveInfos) {
      return CollectionUtils.isEmpty(approveInfos) ? "[]" : JSON.toJSONString(approveInfos.stream().map(info -> {
         List<User> users = this.userService.listByIds(info.getApproverIds());
         Preconditions.checkArgument(users.size() == info.getApproverIds().size(), "审批人不存在");
         if (TaskActionTypeEnum.NONE.getType() == info.getType()) {
            Preconditions.checkArgument(info.getApproverIds().size() == 1, "审批类型为会签/或签，必须设置两个及两个以上审批人");
         } else {
            Preconditions.checkArgument(info.getApproverIds().size() > 1, "审批类型为单人，只能设置一个审批人");
         }

         ApproveInfo approveInfo = BeanUtil.copy(info, ApproveInfo.class);
         approveInfo.setUsers(users.stream().map(e -> {
            ApproveUserInfo userInfo = new ApproveUserInfo();
            userInfo.setUserId(e.getId());
            userInfo.setDdUserId(e.getDdUserId());
            return userInfo;
         }).collect(Collectors.toList()));
         return approveInfo;
      }).collect(Collectors.toList()));
   }

   @Override
   public List<ApproveInfoVO> getObjInfo(String approveInfo) {
      if (StringUtils.isBlank(approveInfo)) {
         return new ArrayList<>();
      }

      List<ApproveInfo> approveInfos = JSONArray.parseArray(approveInfo, ApproveInfo.class);
      return approveInfos.stream().map(info -> {
         ApproveInfoVO infoVO = BeanUtil.copy(info, ApproveInfoVO.class);
         infoVO.setUserName(info.getUsers().stream().map(e -> this.userService.getUserNameWithDeptName(e.getUserId())).collect(Collectors.joining(",")));
         return infoVO;
      }).collect(Collectors.toList());
   }

   @Override
   public ApproveProcessDTO byId(Long id) {
      ApproveProcess approveProcess = this.baseMapper.selectById(id);
      ApproveProcessDTO dto = BeanUtil.copy(approveProcess, ApproveProcessDTO.class);
      dto.setApprovers(this.getObjInfo(approveProcess.getApproveInfo()));
      return dto;
   }

   @Override
   public List<NameInfo> getCode() {
      return this.approveCodeMapper
         .selectList(null)
         .stream()
         .map(c -> NameInfo.builder().id(c.getTemplateType().longValue()).name(c.getCode()).build())
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveAP(ApprovalProcessDTOParam param) {
      Preconditions.checkArgument(
         this.baseMapper.selectOne((Wrapper<ApproveProcess>)Wrappers.<ApproveProcess>lambdaQuery().eq(ApproveProcess::getApproveInfoName, param.getApproveInfoName())) == null,
         "当前审批流程名称[" + param.getApproveInfoName() + "]已经存在"
      );
      ApproveProcess approveProcess = ApproveProcess.builder()
         .code(param.getApprovalCode())
         .approveInfoName(param.getApproveInfoName())
         .type(param.getType())
         .build();
      approveProcess.setApplicantIds(this.userService.checkUserIds(param.getApplicantIds(), "当前设置的可发起审批用户不存在"));
      approveProcess.setApproveInfo(this.getStrInfo(param.getList()));
      return this.baseMapper.insert(approveProcess) == 1;
   }

   @Override
   public Boolean delete(List<Long> ids) {
      for (Long id : ids) {
         ApproveProcess approveProcess = this.baseMapper.selectById(id);
         Preconditions.checkArgument(approveProcess != null, "审批流程不存在");
         Preconditions.checkArgument(
            com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isEmpty(
               this.applyPurchaseService.list((Wrapper<ApplyPurchase>)Wrappers.<ApplyPurchase>lambdaQuery().eq(ApplyPurchase::getApproveProcessId, id))
            ),
            "删除失败，当前审批流程已被使用"
         );
         this.baseMapper.deleteById(id);
      }

      return true;
   }

   @Override
   public Boolean updateStatus(Integer status) {
      this.configService
         .update(
            Config.builder().code("APPROVE_STATUS").value(status == 1 ? "1" : "0").name("钉钉审批是否开启").build(),
            (Wrapper<Config>)Wrappers.<Config>lambdaQuery().eq(Config::getCode, "APPROVE_STATUS")
         );
      return true;
   }

   @Override
   public Boolean getStatus() {
      Config config = this.configService.getOne((Wrapper<Config>)Wrappers.<Config>lambdaQuery().eq(Config::getCode, "APPROVE_STATUS"));
      if (config != null) {
         return config.getValue().equals("1");
      }

      this.configService.save(Config.builder().code("APPROVE_STATUS").name("钉钉审批是否开启").value("0").build());
      return false;
   }
}

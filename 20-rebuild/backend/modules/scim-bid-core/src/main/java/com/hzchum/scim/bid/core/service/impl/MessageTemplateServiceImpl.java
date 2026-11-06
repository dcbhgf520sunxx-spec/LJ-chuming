package com.hzchum.scim.bid.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.SmsUtil;
import com.hzchum.scim.bid.core.api.enums.MessageTemplateStatusEnum;
import com.hzchum.scim.bid.core.api.enums.MessageTypeEnum;
import com.hzchum.scim.bid.core.api.enums.SourceEnum;
import com.hzchum.scim.bid.core.api.pojo._do.MessageTemplate;
import com.hzchum.scim.bid.core.api.pojo.dto.SmsDTO;
import com.hzchum.scim.bid.core.api.pojo.vo.SmsVO;
import com.hzchum.scim.bid.core.api.service.MessageTemplateService;
import com.hzchum.scim.bid.core.mapper.MessageTemplateMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@DS("master")
@Service
public class MessageTemplateServiceImpl extends ServiceImpl<MessageTemplateMapper, MessageTemplate> implements MessageTemplateService {
   @Resource
   private SmsUtil smsUtil;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public ListVO<SmsVO> getAll() {
      List<MessageTemplate> messageTemplates = this.baseMapper.selectList(new LambdaQueryWrapper<>());
      if (CollectionUtils.isEmpty(messageTemplates)) {
         return new ListVO<>();
      }

      for (MessageTemplate messageTemplate : messageTemplates) {
         if (!messageTemplate.getTemplateStatus().equals(MessageTemplateStatusEnum.APPROVE.getType())) {
            JSONObject jsonObject = this.smsUtil.querySmsTemplate(messageTemplate.getTemplateCode());
            SmsVO sms = JSONObject.parseObject(String.valueOf(jsonObject), SmsVO.class);
            messageTemplate.setTemplateStatus(sms.getTemplateStatus());
            messageTemplate.setReason(sms.getReason());
            this.baseMapper.updateById(messageTemplate);
         }
      }

      return new ListVO<>(messageTemplates.stream().map(e -> BeanUtil.copy(e, SmsVO.class)).collect(Collectors.toList()));
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Integer saveMessage(SmsDTO dto) {
      MessageTemplate template = this.baseMapper
         .selectOne((Wrapper<MessageTemplate>)new LambdaQueryWrapper<MessageTemplate>().eq(MessageTemplate::getTemplateName, dto.getTemplateName()));
      Preconditions.checkArgument(template == null, "模板名称重复");
      MessageTemplate build = MessageTemplate.builder()
         .remark("用于发送招标短信通知")
         .source(SourceEnum.CUSTOM.getType())
         .templateContent(dto.getTemplateContent())
         .templateName(dto.getTemplateName())
         .templateType(MessageTypeEnum.SHORT_NOTE.getType())
         .build();
      String templateCode = this.smsUtil
         .addSmsTemplate(build.getTemplateType().toString(), build.getTemplateName(), build.getTemplateContent(), build.getRemark())
         .get("TemplateCode")
         .toString();
      build.setTemplateCode(templateCode);
      return this.baseMapper.insert(build);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Integer updateMessage(SmsDTO dto) {
      MessageTemplate template = this.baseMapper.selectById(dto.getId());
      MessageTemplate messageTemplate = this.baseMapper
         .selectOne((Wrapper<MessageTemplate>)new LambdaQueryWrapper<MessageTemplate>().eq(MessageTemplate::getTemplateName, dto.getTemplateName()));
      Preconditions.checkArgument(template != null, "该短信模板不存在");
      if (messageTemplate != null && !messageTemplate.getId().equals(dto.getId())) {
         throw new IllegalArgumentException("短信模板名称重复");
      }

      Preconditions.checkArgument(template.getTemplateStatus().equals(MessageTemplateStatusEnum.AUDIT_FAILURE.getType()), "只可修改审核失败的短信模板");
      template.setTemplateName(dto.getTemplateName());
      template.setTemplateContent(dto.getTemplateContent());
      String templateCode = this.smsUtil
         .modifySmsTemplate(
            template.getTemplateType().toString(), template.getTemplateName(), template.getTemplateContent(), template.getRemark(), template.getTemplateCode()
         )
         .get("TemplateCode")
         .toString();
      template.setTemplateCode(templateCode);
      int updateById = this.baseMapper.updateById(template);
      Preconditions.checkArgument(updateById == 1, "修改失败,请刷新后重试");
      return updateById;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteMessage(Long id) {
      MessageTemplate messageTemplate = this.baseMapper.selectById(id);
      Preconditions.checkArgument(messageTemplate != null, "该短信模板不存在");
      Preconditions.checkArgument(!messageTemplate.getTemplateStatus().equals(MessageTemplateStatusEnum.IN_REVIEW.getType()), "不可删除审核中的短信模板");
      JSONObject json = this.smsUtil.deleteSmsTemplate(messageTemplate.getTemplateCode());
      return "OK".equals(json.getString("Code")) && this.baseMapper.deleteById(id) == 1;
   }
}

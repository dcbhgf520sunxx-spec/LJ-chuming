package com.hzchum.scim.bid.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.bid.core.api.pojo._do.MessageTemplate;
import com.hzchum.scim.bid.core.api.pojo.dto.SmsDTO;
import com.hzchum.scim.bid.core.api.pojo.vo.SmsVO;

public interface MessageTemplateService extends IService<MessageTemplate> {
   ListVO<SmsVO> getAll();

   Integer saveMessage(SmsDTO dto);

   Integer updateMessage(SmsDTO dto);

   Boolean deleteMessage(Long id);
}

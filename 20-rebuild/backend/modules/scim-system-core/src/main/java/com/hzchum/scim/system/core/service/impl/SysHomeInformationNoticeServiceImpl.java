package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysHomeInformationNotice;
import com.hzchum.scim.system.core.api.service.SysHomeInformationNoticeService;
import com.hzchum.scim.system.core.mapper.SysHomeInformationNoticeMapper;
import org.springframework.stereotype.Service;

@Service
public class SysHomeInformationNoticeServiceImpl
   extends ServiceImpl<SysHomeInformationNoticeMapper, SysHomeInformationNotice>
   implements SysHomeInformationNoticeService {
}

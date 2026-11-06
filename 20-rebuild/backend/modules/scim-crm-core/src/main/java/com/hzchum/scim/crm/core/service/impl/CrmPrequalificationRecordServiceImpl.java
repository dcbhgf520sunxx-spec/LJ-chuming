package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPrequalificationRecord;
import com.hzchum.scim.crm.core.api.service.CrmPrequalificationRecordService;
import com.hzchum.scim.crm.core.mapper.CrmPrequalificationRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmPrequalificationRecordServiceImpl
   extends ServiceImpl<CrmPrequalificationRecordMapper, CrmPrequalificationRecord>
   implements CrmPrequalificationRecordService {
}

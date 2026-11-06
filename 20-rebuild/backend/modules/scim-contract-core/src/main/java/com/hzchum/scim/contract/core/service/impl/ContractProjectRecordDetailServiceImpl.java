package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectRecordDetail;
import com.hzchum.scim.contract.core.api.service.ContractProjectRecordDetailService;
import com.hzchum.scim.contract.core.mapper.ContractProjectRecordDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractProjectRecordDetailServiceImpl
   extends ServiceImpl<ContractProjectRecordDetailMapper, ContractProjectRecordDetail>
   implements ContractProjectRecordDetailService {
}

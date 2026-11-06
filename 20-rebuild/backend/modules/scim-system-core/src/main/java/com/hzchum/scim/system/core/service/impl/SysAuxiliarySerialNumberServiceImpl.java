package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysAuxiliarySerialNumber;
import com.hzchum.scim.system.core.api.service.SysAuxiliarySerialNumberService;
import com.hzchum.scim.system.core.mapper.SysAuxiliarySerialNumberMapper;
import org.springframework.stereotype.Service;

@Service
public class SysAuxiliarySerialNumberServiceImpl
   extends ServiceImpl<SysAuxiliarySerialNumberMapper, SysAuxiliarySerialNumber>
   implements SysAuxiliarySerialNumberService {
}

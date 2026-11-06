package com.hzchum.scim.cut.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.cut.core.api.request.MachineInformationDTO;
import com.hzchum.scim.cut.core.api.service.MachineInformationService;
import com.hzchum.scim.cut.core.mapper.MachineInformationMapper;
import org.springframework.stereotype.Service;

@Service
public class MachineInformationServiceImpl extends ServiceImpl<MachineInformationMapper, MachineInformationDTO> implements MachineInformationService {
}

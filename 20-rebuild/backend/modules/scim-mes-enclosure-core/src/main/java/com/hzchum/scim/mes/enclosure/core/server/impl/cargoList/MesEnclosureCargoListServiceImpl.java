package com.hzchum.scim.mes.enclosure.core.server.impl.cargoList;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureCargoList;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureCargoListService;
import com.hzchum.scim.mes.enclosure.core.mapper.cargoList.MesEnclosureCargoListMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesEnclosureCargoListServiceImpl extends ServiceImpl<MesEnclosureCargoListMapper, MesEnclosureCargoList> implements MesEnclosureCargoListService {
   @Resource
   private ContractProjectService projectService;
}

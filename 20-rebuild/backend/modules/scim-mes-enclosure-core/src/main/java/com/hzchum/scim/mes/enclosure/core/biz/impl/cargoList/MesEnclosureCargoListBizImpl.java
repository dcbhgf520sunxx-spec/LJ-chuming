package com.hzchum.scim.mes.enclosure.core.biz.impl.cargoList;

import com.hzchum.scim.mes.enclosure.core.api.biz.cargoList.MesEnclosureCargoListBiz;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureCargoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesEnclosureCargoListBizImpl implements MesEnclosureCargoListBiz {
   @Autowired
   private MesEnclosureCargoListService cargoListService;
}

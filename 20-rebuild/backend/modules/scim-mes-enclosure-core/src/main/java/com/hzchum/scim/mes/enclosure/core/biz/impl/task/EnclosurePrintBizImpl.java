package com.hzchum.scim.mes.enclosure.core.biz.impl.task;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.EnclosurePrintBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.EnclosurePrint;
import com.hzchum.scim.mes.enclosure.core.api.service.task.EnclosurePrintService;
import com.hzchum.scim.mes.enclosure.core.mapper.task.EnclosurePrintMapper;
import org.springframework.stereotype.Service;

@Service
public class EnclosurePrintBizImpl extends IBizImpl<EnclosurePrintService, EnclosurePrintMapper, EnclosurePrint> implements EnclosurePrintBiz {
}

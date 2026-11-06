package com.hzchum.scim.project.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.project.core.api.biz.ProjectPurchaseOrderReceivedOperateRecordBiz;
import com.hzchum.scim.project.core.api.pojo._doModel.ProjectPurchaseOrderReceivedOperateRecord;
import com.hzchum.scim.project.core.api.service.ProjectPurchaseOrderReceivedOperateRecordService;
import com.hzchum.scim.project.core.mapper.ProjectPurchaseOrderReceivedOperateRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectPurchaseOrderReceivedOperateRecordBizImpl
   extends IBizImpl<ProjectPurchaseOrderReceivedOperateRecordService, ProjectPurchaseOrderReceivedOperateRecordMapper, ProjectPurchaseOrderReceivedOperateRecord>
   implements ProjectPurchaseOrderReceivedOperateRecordBiz {
}

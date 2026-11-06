package com.hzchum.scim.mes.building.core.service.impl.report_work;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReportDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportDetailDTO;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesMaterialFeedingReportDetailService;
import com.hzchum.scim.mes.building.core.mapper.report_work.MesMaterialFeedingReportDetailMapper;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesMaterialFeedingReportDetailServiceImpl
   extends ServiceImpl<MesMaterialFeedingReportDetailMapper, MesMaterialFeedingReportDetail>
   implements MesMaterialFeedingReportDetailService {
   @Override
   public List<MesMaterialFeedingReportDetailDTO> listByMaterialFeedingReportIdList(List<Long> materialFeedingReportIdList) {
      return CollUtil.isEmpty(materialFeedingReportIdList)
         ? Collections.emptyList()
         : this.baseMapper.listByMaterialFeedingReportIdList(materialFeedingReportIdList);
   }

   @Override
   public List<MesMaterialFeedingReportDetailDTO> allFeedingList(Long workshopId, String structureType) {
      return this.baseMapper.allFeedingList(workshopId, structureType);
   }
}

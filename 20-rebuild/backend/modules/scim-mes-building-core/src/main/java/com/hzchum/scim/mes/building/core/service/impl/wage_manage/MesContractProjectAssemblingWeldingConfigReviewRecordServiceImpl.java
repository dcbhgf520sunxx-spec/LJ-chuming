package com.hzchum.scim.mes.building.core.service.impl.wage_manage;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesContractProjectAssemblingWeldingConfigReviewRecord;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesContractProjectAssemblingWeldingConfigReviewRecordService;
import com.hzchum.scim.mes.building.core.mapper.wage_manage.MesContractProjectAssemblingWeldingConfigReviewRecordMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesContractProjectAssemblingWeldingConfigReviewRecordServiceImpl
   extends ServiceImpl<MesContractProjectAssemblingWeldingConfigReviewRecordMapper, MesContractProjectAssemblingWeldingConfigReviewRecord>
   implements MesContractProjectAssemblingWeldingConfigReviewRecordService {
   @Override
   public PageVO<MesContractProjectAssemblingWeldingConfigReviewRecord> pageInfo(
      MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam queryDTOParam, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<MesContractProjectAssemblingWeldingConfigReviewRecord> reviewRecordList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesContractProjectAssemblingWeldingConfigReviewRecord.class)
               .apply("YEAR(initiation_date) = {0}", queryDTOParam.getYear())
               .like(
                  StrUtil.isNotBlank(queryDTOParam.getContractProjectShortName()),
                  MesContractProjectAssemblingWeldingConfigReviewRecord::getContractProjectShortName,
                  queryDTOParam.getContractProjectShortName()
               )
               .like(
                  StrUtil.isNotBlank(queryDTOParam.getInitiatorName()),
                  MesContractProjectAssemblingWeldingConfigReviewRecord::getInitiatorName,
                  queryDTOParam.getInitiatorName()
               )
               .like(
                  StrUtil.isNotBlank(queryDTOParam.getArtifactClassificationName()),
                  MesContractProjectAssemblingWeldingConfigReviewRecord::getArtifactClassificationName,
                  queryDTOParam.getArtifactClassificationName()
               )
               .like(
                  StrUtil.isNotBlank(queryDTOParam.getReviewerName()),
                  MesContractProjectAssemblingWeldingConfigReviewRecord::getReviewerName,
                  queryDTOParam.getReviewerName()
               )
         );
      return new PageVO<>(new PageInfo<>(reviewRecordList));
   }
}

package com.hzchum.scim.mes.building.core.service.impl.record;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingPrintRecord;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingPrintRecordService;
import com.hzchum.scim.mes.building.core.mapper.record.MesBuildingPrintRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingPrintRecordServiceImpl
   extends ServiceImpl<MesBuildingPrintRecordMapper, MesBuildingPrintRecord>
   implements MesBuildingPrintRecordService {
   @Override
   public ListVO<MesBuildingPrintRecord> listPrintRecord(Long id, Integer type) {
      return new ListVO<>(
         this.baseMapper
            .selectList(
               (Wrapper<MesBuildingPrintRecord>)((Wrappers.<MesBuildingPrintRecord>lambdaQuery().eq(MesBuildingPrintRecord::getRelateId, id))
                     .eq(MesBuildingPrintRecord::getType, type))
                  .orderByDesc(BaseEntity::getCreateTime)
            )
      );
   }
}

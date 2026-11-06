package com.hzchum.scim.mes.enclosure.core.server.impl.process;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.process.MesEnclosureProcess;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process.MesEnclosureProcessDTO;
import com.hzchum.scim.mes.enclosure.core.api.service.process.MesEnclosureProcessService;
import com.hzchum.scim.mes.enclosure.core.mapper.process.MesEnclosureProcessMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MesEnclosureProcessServiceImpl extends ServiceImpl<MesEnclosureProcessMapper, MesEnclosureProcess> implements MesEnclosureProcessService {
   @Autowired
   private MesEnclosureTaskBiz taskBiz;

   @Override
   public List<MesEnclosureProcess> listByCondition(Boolean type, Long userId) {
      return this.baseMapper.listByUserId(type, userId);
   }

   @Override
   public List<MesEnclosureProcess> selectProcessByLine(Long ProductionLineId) {
      return this.baseMapper.selectProcessByLine(ProductionLineId);
   }

   @Override
   public List<MesEnclosureProcessDTO> getWorkshopByProcessList(Long workshopId) {
      return this.baseMapper.getWorkshopByProcessList(workshopId);
   }
}

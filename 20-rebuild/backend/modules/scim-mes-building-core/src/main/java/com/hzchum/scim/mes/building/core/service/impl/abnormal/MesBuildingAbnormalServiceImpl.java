package com.hzchum.scim.mes.building.core.service.impl.abnormal;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbnormalPreviewDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbnormalProcessPreviewDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.MesBuildingAbnormalDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.abnormal.MesBuildingAbnormal;
import com.hzchum.scim.mes.building.core.api.pojo._dto.abnormal.MesBuildingAbnormalDTO;
import com.hzchum.scim.mes.building.core.api.service.abnormal.MesBuildingAbnormalService;
import com.hzchum.scim.mes.building.core.mapper.abnormal.MesBuildingAbnormalMapper;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingAbnormalServiceImpl extends ServiceImpl<MesBuildingAbnormalMapper, MesBuildingAbnormal> implements MesBuildingAbnormalService {
   @Autowired
   private SysDictionaryService dictionaryService;

   @Override
   public List<MesBuildingAbnormalDTO> abnormalList(
      Long id, Integer productType, String projectName, String serialNumber, Integer status, Long projectId, Long monomerId, Long areaId, LocalDateTime date
   ) {
      return null;
   }

   @Override
   public PageVO<MesBuildingAbnormalDTO> abnormalPage(
      Long id,
      Integer productType,
      String projectName,
      String serialNumber,
      Integer status,
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime date,
      String sort,
      Integer pageNumber,
      Integer pageSize
   ) {
      return null;
   }

   @Override
   public MesBuildingAbnormalDO selectDetailById(Long id) {
      return this.baseMapper.selectDetailById(id);
   }

   @Override
   public List<AbnormalProcessPreviewDO> changePreview(Long productId, Integer productType) {
      return this.baseMapper.changePreview(productId, productType);
   }

   @Override
   public List<AbnormalPreviewDO> preview(Long productId, Integer productType, Integer type) {
      return this.baseMapper.preview(productId, productType, type);
   }
}

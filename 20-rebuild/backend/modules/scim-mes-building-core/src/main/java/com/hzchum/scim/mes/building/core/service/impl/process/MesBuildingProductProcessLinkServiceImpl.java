package com.hzchum.scim.mes.building.core.service.impl.process;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProductProcessLinkDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.mapper.process.MesBuildingProcessMapper;
import com.hzchum.scim.mes.building.core.mapper.process.MesBuildingProductProcessLinkMapper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingProductProcessLinkServiceImpl
   extends ServiceImpl<MesBuildingProductProcessLinkMapper, MesBuildingProductProcessLink>
   implements MesBuildingProductProcessLinkService {
   @Resource
   private MesBuildingProcessMapper mesBuildingProcessMapper;
   @Resource
   private MesBuildingProductProcessLinkMapper mesBuildingProductProcessLinkMapper;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean checkProductProcessLinkAndInsert(List<MesBuildingProductProcessLink> productProcessLinkList) {
      Set<Integer> sequenceSet = new HashSet<>();
      List<Integer> sequenceList = new ArrayList<>();
      productProcessLinkList.forEach(e -> {
         Preconditions.checkArgument(e.getSequence() != null, "添加失败，传入工序顺序不能为空");
         Preconditions.checkArgument(this.mesBuildingProcessMapper.selectById(e.getProcessId()) != null, "添加失败，传入工序有误");
         sequenceSet.add(e.getSequence());
         sequenceList.add(e.getSequence());
      });
      Preconditions.checkArgument(sequenceSet.size() == sequenceList.size(), "添加失败，传入工序顺序不能重复");
      Preconditions.checkArgument(productProcessLinkList.get(0).getSequence() == 0, "添加失败，传入工序顺序初始顺序不正确");
      Preconditions.checkArgument(
         productProcessLinkList.get(productProcessLinkList.size() - 1).getSequence() == productProcessLinkList.size() - 1, "添加失败，传入工序顺序最后顺序不正确"
      );
      productProcessLinkList.forEach(e -> this.mesBuildingProductProcessLinkMapper.insert(e));
      return true;
   }

   @Override
   public List<MesBuildingProductProcessLinkDO> getProcessListByTypeIdAndProductType(Long id, Integer productType) {
      return this.baseMapper.getProcessListByTypeIdAndProductType(id, productType);
   }

   @Override
   public List<MesBuildingProductProcessLinkDTO> findProcessLinkByLineAndClass(Long prodLineId, Long classId, Integer taskTypeEnum) {
      return this.baseMapper.findProcessLinkByLineAndClass(prodLineId, classId, taskTypeEnum);
   }

   @Override
   public Integer isExistProductProcessLink(Long productId, Integer productType) {
      return this.baseMapper.isExistProductProcessLink(productId, productType);
   }
}

package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClassificationDetail;
import com.hzchum.scim.system.core.api.service.MesArtifactClassificationDetailService;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigDetailService;
import com.hzchum.scim.system.core.mapper.MesArtifactClassificationDetailMapper;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesArtifactClassificationDetailServiceImpl
   extends ServiceImpl<MesArtifactClassificationDetailMapper, MesArtifactClassificationDetail>
   implements MesArtifactClassificationDetailService {
   @Autowired
   private MesSectionWarehouseConfigDetailService sectionWarehouseConfigDetailService;

   @Override
   public Map<Long, Map<Integer, List<String>>> getNameAndTypeByArtifactClassificationIdList(List<Long> artifactClassificationIdList) {
      List<MesArtifactClassificationDetail> list = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesArtifactClassificationDetail.class)
               .in(MesArtifactClassificationDetail::getArtifactClassificationId, artifactClassificationIdList)
         );
      return list.stream()
         .collect(
            Collectors.groupingBy(
               MesArtifactClassificationDetail::getArtifactClassificationId,
               Collectors.groupingBy(
                  MesArtifactClassificationDetail::getNameOrType, Collectors.mapping(MesArtifactClassificationDetail::getIndexName, Collectors.toList())
               )
            )
         );
   }

   @Override
   public Map<Integer, List<String>> getNameAndTypeByArtifactClassificationId(Long artifactClassificationId) {
      List<MesArtifactClassificationDetail> list = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesArtifactClassificationDetail.class)
               .eq(MesArtifactClassificationDetail::getArtifactClassificationId, artifactClassificationId)
         );
      return list.stream()
         .collect(
            Collectors.groupingBy(
               MesArtifactClassificationDetail::getNameOrType, Collectors.mapping(MesArtifactClassificationDetail::getIndexName, Collectors.toList())
            )
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeByArtifactClassificationId(Long artifactClassificationId) {
      this.baseMapper.deleteByArtifactClassificationId(artifactClassificationId);
      return Boolean.TRUE;
   }
}

package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClassification;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClassificationDetail;
import com.hzchum.scim.system.core.api.pojo.dto.MesArtifactClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesArtifactClassificationSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesArtifactClassificationDetailService;
import com.hzchum.scim.system.core.api.service.MesArtifactClassificationService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesArtifactClassificationMapper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesArtifactClassificationServiceImpl
   extends ServiceImpl<MesArtifactClassificationMapper, MesArtifactClassification>
   implements MesArtifactClassificationService {
   @Autowired
   private MesArtifactClassificationDetailService artifactClassificationDetailService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;

   @Override
   public List<MesArtifactClassificationDTO> listInfo() {
      List<MesArtifactClassification> list = this.list();
      if (CollUtil.isEmpty(list)) {
         return new ArrayList<>();
      }

      List<MesArtifactClassificationDTO> artifactClassificationDTOList = BeanUtil.copyToList(list, MesArtifactClassificationDTO.class);
      List<Long> idList = CollUtil.getFieldValues(artifactClassificationDTOList, "id", Long.class);
      Map<Long, Map<Integer, List<String>>> nameAndTypeListMap = this.artifactClassificationDetailService.getNameAndTypeByArtifactClassificationIdList(idList);
      return artifactClassificationDTOList;
   }

   @Override
   public List<MesArtifactClassificationDTO> listInfoByIds(List<Long> idList) {
      List<MesArtifactClassification> list = this.baseMapper.selectBatchIds(idList);
      if (CollUtil.isEmpty(list)) {
         return new ArrayList<>();
      }

      List<MesArtifactClassificationDTO> artifactClassificationDTOList = BeanUtil.copyToList(list, MesArtifactClassificationDTO.class);
      Map<Long, Map<Integer, List<String>>> nameAndTypeListMap = this.artifactClassificationDetailService.getNameAndTypeByArtifactClassificationIdList(idList);
      return artifactClassificationDTOList;
   }

   @Override
   public MesArtifactClassificationDTO detailById(Long id) {
      MesArtifactClassification artifactClassification = this.baseMapper.selectById(id);
      Preconditions.checkArgument(artifactClassification != null, "当前构件分类不存在");
      MesArtifactClassificationDTO artifactClassificationDTO = BeanUtil.toBean(artifactClassification, MesArtifactClassificationDTO.class);
      Map<Integer, List<String>> nameAndTypeListMap = this.artifactClassificationDetailService.getNameAndTypeByArtifactClassificationId(id);
      artifactClassificationDTO.setNameIndexList(nameAndTypeListMap.get(1));
      artifactClassificationDTO.setTypeIndexList(nameAndTypeListMap.get(2));
      return artifactClassificationDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveArtifactClassification(MesArtifactClassificationSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      Integer repeat = this.baseMapper
         .selectCount(Wrappers.lambdaQuery(MesArtifactClassification.class).eq(MesArtifactClassification::getClassification, param.getClassification()));
      Preconditions.checkArgument(repeat == 0, "构件分类不能重复");
      List<MesArtifactClassificationDetail> nameIndexList = this.artifactClassificationDetailService
         .list(
            Wrappers.lambdaQuery(MesArtifactClassificationDetail.class)
               .and(
                  a -> {
                     LambdaQueryWrapper var10000 = a.eq(MesArtifactClassificationDetail::getNameOrType, 1)
                        .in(MesArtifactClassificationDetail::getIndexName, param.getNameIndexList());
                  }
               )
         );
      if (CollUtil.isNotEmpty(nameIndexList)) {
         Set<Long> artifactClassificationIdSet = CollUtil.newHashSet(CollUtil.getFieldValues(nameIndexList, "artifactClassificationId", Long.class));
         List<Long> artifactClassificationIdList = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(MesArtifactClassification.class)
                  .eq(MesArtifactClassification::getArtifactType, param.getArtifactType())
                  .in(MesArtifactClassification::getId, artifactClassificationIdSet)
            )
            .stream()
            .map(MesArtifactClassification::getId)
            .collect(Collectors.toList());
         if (CollUtil.isNotEmpty(artifactClassificationIdList)) {
            List<MesArtifactClassificationDetail> typeIndexList = this.artifactClassificationDetailService
               .list(
                  Wrappers.lambdaQuery(MesArtifactClassificationDetail.class)
                     .in(MesArtifactClassificationDetail::getArtifactClassificationId, artifactClassificationIdList)
                     .and(
                        a -> {
                           LambdaQueryWrapper var10000 = a.eq(MesArtifactClassificationDetail::getNameOrType, 2)
                              .in(MesArtifactClassificationDetail::getIndexName, param.getTypeIndexList());
                        }
                     )
               );
            Preconditions.checkArgument(CollUtil.isEmpty(typeIndexList), "清单构件名称索引或截面类型索引已存在");
         }
      }

      MesArtifactClassification artifactClassification = BeanUtil.toBean(param, MesArtifactClassification.class);
      this.baseMapper.insert(artifactClassification);
      List<MesArtifactClassificationDetail> details = new ArrayList<>();
      param.getNameIndexList().forEach(e -> {
         MesArtifactClassificationDetail detail = new MesArtifactClassificationDetail();
         detail.setArtifactClassificationId(artifactClassification.getId());
         detail.setNameOrType(1);
         detail.setIndexName(e);
         details.add(detail);
      });
      param.getTypeIndexList().forEach(e -> {
         MesArtifactClassificationDetail detail = new MesArtifactClassificationDetail();
         detail.setArtifactClassificationId(artifactClassification.getId());
         detail.setNameOrType(2);
         detail.setIndexName(e);
         details.add(detail);
      });
      this.artifactClassificationDetailService.saveBatch(details);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editArtifactClassification(MesArtifactClassificationSaveDTOParam param) {
      Preconditions.checkArgument(!this.baseMapper.hasIdBeenUsed(param.getId()), "当前构件分类已被使用, 不能修改");
      Integer repeat = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(MesArtifactClassification.class)
               .ne(MesArtifactClassification::getId, param.getId())
               .eq(MesArtifactClassification::getClassification, param.getClassification())
         );
      Preconditions.checkArgument(repeat == 0, "构件分类不能重复");
      List<MesArtifactClassificationDetail> nameIndexList = this.artifactClassificationDetailService
         .list(
            Wrappers.lambdaQuery(MesArtifactClassificationDetail.class)
               .ne(MesArtifactClassificationDetail::getArtifactClassificationId, param.getId())
               .and(
                  a -> {
                     LambdaQueryWrapper var10000 = a.eq(MesArtifactClassificationDetail::getNameOrType, 1)
                        .in(MesArtifactClassificationDetail::getIndexName, param.getNameIndexList());
                  }
               )
         );
      if (CollUtil.isNotEmpty(nameIndexList)) {
         HashSet<Long> artifactClassificationIdSet = CollUtil.newHashSet(CollUtil.getFieldValues(nameIndexList, "artifactClassificationId", Long.class));
         List<MesArtifactClassificationDetail> typeIndexList = this.artifactClassificationDetailService
            .list(
               Wrappers.lambdaQuery(MesArtifactClassificationDetail.class)
                  .ne(MesArtifactClassificationDetail::getArtifactClassificationId, param.getId())
                  .in(MesArtifactClassificationDetail::getArtifactClassificationId, artifactClassificationIdSet)
                  .and(
                     a -> {
                        LambdaQueryWrapper var10000 = a.eq(MesArtifactClassificationDetail::getNameOrType, 2)
                           .in(MesArtifactClassificationDetail::getIndexName, param.getTypeIndexList());
                     }
                  )
            );
         Preconditions.checkArgument(CollUtil.isEmpty(typeIndexList), "清单构件名称索引或截面类型索引已存在");
      }

      MesArtifactClassification artifactClassification = BeanUtil.toBean(param, MesArtifactClassification.class);
      this.baseMapper.updateById(artifactClassification);
      this.artifactClassificationDetailService
         .remove(Wrappers.lambdaQuery(MesArtifactClassificationDetail.class).eq(MesArtifactClassificationDetail::getArtifactClassificationId, param.getId()));
      List<MesArtifactClassificationDetail> details = new ArrayList<>();
      param.getNameIndexList().forEach(e -> {
         MesArtifactClassificationDetail detail = new MesArtifactClassificationDetail();
         detail.setArtifactClassificationId(artifactClassification.getId());
         detail.setNameOrType(1);
         detail.setIndexName(e);
         details.add(detail);
      });
      param.getTypeIndexList().forEach(e -> {
         MesArtifactClassificationDetail detail = new MesArtifactClassificationDetail();
         detail.setArtifactClassificationId(artifactClassification.getId());
         detail.setNameOrType(2);
         detail.setIndexName(e);
         details.add(detail);
      });
      this.artifactClassificationDetailService.saveBatch(details);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      Preconditions.checkArgument(!this.baseMapper.hasIdBeenUsed(id), "当前构件分类已被使用, 不能修改");
      MesArtifactClassification artifactClassification = this.baseMapper.selectById(id);
      Preconditions.checkArgument(artifactClassification != null, "当前构件分类不存在");
      this.baseMapper.deleteById(id);
      this.artifactClassificationDetailService
         .remove(Wrappers.lambdaQuery(MesArtifactClassificationDetail.class).eq(MesArtifactClassificationDetail::getArtifactClassificationId, id));
      return Boolean.TRUE;
   }
}

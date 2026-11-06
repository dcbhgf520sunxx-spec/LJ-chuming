package com.hzchum.scim.mes.building.core.service.impl._package;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.PackageStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.PackageDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.PackageDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackage;
import com.hzchum.scim.mes.building.core.api.pojo._doParam._package.MesBuildingPackageDOParam;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageService;
import com.hzchum.scim.mes.building.core.mapper._package.MesBuildingPackageMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesBuildingPackageServiceImpl extends ServiceImpl<MesBuildingPackageMapper, MesBuildingPackage> implements MesBuildingPackageService {
   @Resource
   private AttachmentService attachmentService;

   @Override
   public List<PackageDetailDO> listByPackageIds(List<Long> packageIds) {
      return this.baseMapper
         .listByCondition(MesBuildingPackageDOParam.builder().packageIds(packageIds).build())
         .stream()
         .map(e -> BeanUtil.copy(e, PackageDetailDO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<PackageDO> packagePage(MesBuildingPackageDOParam param) {
      PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      List<PackageDO> packageDTOList = this.baseMapper.listByCondition(param);
      return new PageVO<>(packageDTOList);
   }

   @Override
   public List<PackageDO> listByProjectId(Long projectId) {
      List<MesBuildingPackage> mesBuildingPackages = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingPackage>)((Wrappers.<MesBuildingPackage>lambdaQuery().orderByDesc(MesBuildingPackage::getId))
                  .eq(MesBuildingPackage::getProjectId, projectId))
               .eq(MesBuildingPackage::getStatus, PackageStatusEnum.UNLOADING.getType())
         );
      return mesBuildingPackages.stream().map(e -> {
         PackageDO copy = BeanUtil.copy(e, PackageDO.class);
         if (StringUtils.isNotBlank(e.getAttachmentIds())) {
            copy.setAttachmentDTOS(this.attachmentService.listByIds(e.getAttachmentIds()));
         }

         return copy;
      }).collect(Collectors.toList());
   }

   @Override
   public Integer countByDate(Long projectId, LocalDateTime now) {
      return this.baseMapper.countByDate(projectId, now);
   }

   @Override
   public void setStatus(Long packageId, Integer status) {
      MesBuildingPackage pack = this.baseMapper.selectById(packageId);
      Preconditions.checkArgument(pack != null, "包不存在");
      pack.setStatus(status);
      this.baseMapper.updateById(pack);
   }
}

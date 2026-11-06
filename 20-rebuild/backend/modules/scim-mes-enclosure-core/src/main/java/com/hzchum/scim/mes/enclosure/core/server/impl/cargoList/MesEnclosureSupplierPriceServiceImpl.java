package com.hzchum.scim.mes.enclosure.core.server.impl.cargoList;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.AppSupplierPersonalDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.SupplierPriceDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureSupplierPrice;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureSupplierPriceCarLink;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureSupplierPriceCarLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureSupplierPriceService;
import com.hzchum.scim.mes.enclosure.core.mapper.cargoList.MesEnclosureSupplierPriceMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesEnclosureSupplierPriceServiceImpl
   extends ServiceImpl<MesEnclosureSupplierPriceMapper, MesEnclosureSupplierPrice>
   implements MesEnclosureSupplierPriceService {
   @Resource
   private MesEnclosureSupplierPriceCarLinkService mesEnclosureSupplierPriceCarLinkService;
   @Resource
   private ContractProjectService projectService;

   @Override
   public List<SupplierPriceDO> listByCondition(Long projectId, String name, Integer status, String licensePlate) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ArrayList<>();
      }

      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      for (SupplierPriceDO supplierPriceDO : this.baseMapper.listByCondition(projectIds, name, status, licensePlate)) {
         if (supplierPriceDO.getBoolPersonalEnum()) {
            MesEnclosureSupplierPriceCarLink carLinkServiceOne = this.mesEnclosureSupplierPriceCarLinkService
               .getOne(
                  (Wrapper<MesEnclosureSupplierPriceCarLink>)(new LambdaQueryWrapper<MesEnclosureSupplierPriceCarLink>()
                        .eq(MesEnclosureSupplierPriceCarLink::getProjectId, supplierPriceDO.getProject().getId()))
                     .eq(MesEnclosureSupplierPriceCarLink::getSupplierPriceId, supplierPriceDO.getId())
               );
            Preconditions.checkArgument(carLinkServiceOne != null, "个人承运的车型记录不存在!!!");
            supplierPriceDO.setCarModel(carLinkServiceOne.getCarModel());
         }
      }

      return this.baseMapper.listByCondition(projectIds, name, status, licensePlate);
   }

   @Override
   public PageVO page(Long projectId, String name, Integer status, Integer pageNumber, Integer pageSize) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new PageVO();
      }

      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      for (SupplierPriceDO supplierPriceDO : this.baseMapper.listByCondition(projectIds, name, status, null)) {
         if (supplierPriceDO.getBoolPersonalEnum()) {
            MesEnclosureSupplierPriceCarLink carLinkServiceOne = this.mesEnclosureSupplierPriceCarLinkService
               .getOne(
                  (Wrapper<MesEnclosureSupplierPriceCarLink>)(new LambdaQueryWrapper<MesEnclosureSupplierPriceCarLink>()
                        .eq(MesEnclosureSupplierPriceCarLink::getProjectId, supplierPriceDO.getProject().getId()))
                     .eq(MesEnclosureSupplierPriceCarLink::getSupplierPriceId, supplierPriceDO.getId())
               );
            Preconditions.checkArgument(carLinkServiceOne != null, "个人承运的车型记录不存在!!!");
            supplierPriceDO.setCarModel(carLinkServiceOne.getCarModel());
         }
      }

      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.baseMapper.listByCondition(projectIds, name, status, null));
   }

   @Override
   public List<AppSupplierPersonalDO> getSupplierAndLicensePlate(Long projectId) {
      return this.baseMapper.getSupplierAndLicensePlate(projectId);
   }
}

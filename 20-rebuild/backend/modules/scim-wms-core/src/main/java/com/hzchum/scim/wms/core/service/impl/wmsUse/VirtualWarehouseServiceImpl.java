package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.MaterialOutboundModeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundRelationTypeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.VirtualWarehouse;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.VirtualWarehouseService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveOutboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.VirtualWarehouseMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VirtualWarehouseServiceImpl extends ServiceImpl<VirtualWarehouseMapper, VirtualWarehouse> implements VirtualWarehouseService {
   @Resource
   OutboundService outboundService;
   @Resource
   OutboundMapper outboundMapper;
   @Resource
   MoveOutboundDetailMapper moveOutboundDetailMapper;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   UserService userService;

   @Override
   public PageVO<VirtualWarehouse> pageInfo(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize, s);
      return null;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void setOutbound() {
      List<VirtualWarehouse> virtualWarehouses = this.baseMapper
         .selectList((Wrapper<VirtualWarehouse>)Wrappers.<VirtualWarehouse>lambdaQuery().eq(VirtualWarehouse::getBoolOutbound, false));
      if (CollectionUtils.isNotEmpty(virtualWarehouses)) {
         Long id = this.userService.getOne((Wrapper<User>)Wrappers.<User>lambdaQuery().eq(User::getName, "超级管理员")).getId();
         LocalDateTime now = LocalDateTime.now();
         Outbound outbound = Outbound.builder()
            .applicantId(id)
            .applicantName("超级管理员")
            .userUpdateTime(now)
            .reviewStatus(OutboundStatusEnum.UN_REVIEWED.getType())
            .outboundStartTime(now)
            .outboundEndTime(now)
            .build();
         String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_APPLY, this.outboundMapper.getCount(now));
         outbound.setApplicationSn(serviceNumber);
         this.outboundMapper.insert(outbound);
         List<MoveOutboundDetail> outboundDetailList = new ArrayList<>();

         for (VirtualWarehouse virtualWarehouse : virtualWarehouses) {
            MaterialInventory materialInventory = this.materialInventoryService.getById(virtualWarehouse.getMaterialId());
            MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
               .warehouseId(materialInventory.getWarehouseId())
               .materialIsWhole(materialInventory.getMaterialIsWhole())
               .workshopId(materialInventory.getWorkshopId())
               .materialInventoryId(materialInventory.getId())
               .outboundId(outbound.getId())
               .basicClass(materialInventory.getBasicClass())
               .classifyId(materialInventory.getClassifyId())
               .specification(materialInventory.getSpecification())
               .sourceProjectId(materialInventory.getProjectId())
               .sourceMonomerId(materialInventory.getMonomerId())
               .sourceAreaId(materialInventory.getAreaId())
               .thickness(materialInventory.getThickness())
               .theoryThickness(materialInventory.getTheoryThickness())
               .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
               .brand(materialInventory.getBrand())
               .outboundTime(now)
               .color(materialInventory.getColor())
               .recipientId(virtualWarehouse.getRecipientId())
               .outboundMode(1)
               .outboundRelationType(OutboundRelationTypeEnum.ROUTINE.getType())
               .boolPartyA(materialInventory.getBoolPartyA())
               .taxRate(materialInventory.getTaxRate())
               .invoiceType(materialInventory.getInvoiceType())
               .standardId(materialInventory.getStandardId())
               .standardName(materialInventory.getStandardName())
               .materialSn(materialInventory.getSerialNumber())
               .workshopId(virtualWarehouse.getWorkshopId())
               .length(virtualWarehouse.getLength())
               .width(virtualWarehouse.getWidth())
               .mete(virtualWarehouse.getMete())
               .quantity(virtualWarehouse.getQuantity())
               .build();
            moveOutboundDetail.setProjectId(virtualWarehouse.getProjectId());
            moveOutboundDetail.setMonomerId(virtualWarehouse.getMonomerId());
            moveOutboundDetail.setAreaId(virtualWarehouse.getAreaId());
            moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
            if (moveOutboundDetail.getProjectId() != null) {
               if (StrUtil.isNotBlank(outbound.getProjectIds())) {
                  List<Long> list = CommonUtil.spilt(outbound.getProjectIds(), ",");
                  if (!list.contains(moveOutboundDetail.getProjectId())) {
                     outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
                  }
               } else {
                  outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
               }
            }

            outbound.setContainBasicClass(
               outbound.getContainBasicClass() != null
                  ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass()
                  : moveOutboundDetail.getBasicClass()
            );
            this.moveOutboundDetailMapper.insert(moveOutboundDetail);
            outboundDetailList.add(moveOutboundDetail);
            virtualWarehouse.setBoolOutbound(true);
            this.baseMapper.updateById(virtualWarehouse);
         }

         this.outboundMapper.updateById(outbound);
         this.outboundService
            .passed(
               OutboundDTOParam.builder()
                  .id(outbound.getId())
                  .defaultName("超级管理员")
                  .defaultId(id)
                  .list(
                     outboundDetailList.stream()
                        .map(l -> OutboundDetailDTO.builder().id(l.getId()).outboundTime(LocalDateTime.now()).build())
                        .collect(Collectors.toList())
                  )
                  .build()
            );
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void setOutboundUser(MonthTimeRange monthTimeRange) {
      List<VirtualWarehouse> virtualWarehouses = this.baseMapper
         .selectList((Wrapper<VirtualWarehouse>)Wrappers.<VirtualWarehouse>lambdaQuery().eq(VirtualWarehouse::getBoolOutbound, false));
      if (CollectionUtils.isNotEmpty(virtualWarehouses)) {
         Long id = this.userService.getOne((Wrapper<User>)Wrappers.<User>lambdaQuery().eq(User::getName, "超级管理员")).getId();
         LocalDateTime now = LocalDateTime.now();
         Outbound outbound = Outbound.builder()
            .applicantId(id)
            .applicantName("超级管理员")
            .userUpdateTime(now)
            .reviewStatus(OutboundStatusEnum.UN_REVIEWED.getType())
            .outboundStartTime(now)
            .outboundEndTime(now)
            .build();
         String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_APPLY, this.outboundMapper.getCount(now));
         outbound.setApplicationSn(serviceNumber);
         this.outboundMapper.insert(outbound);
         List<MoveOutboundDetail> outboundDetailList = new ArrayList<>();

         for (VirtualWarehouse virtualWarehouse : virtualWarehouses) {
            MaterialInventory materialInventory = this.materialInventoryService.getById(virtualWarehouse.getMaterialId());
            MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
               .warehouseId(materialInventory.getWarehouseId())
               .materialIsWhole(materialInventory.getMaterialIsWhole())
               .workshopId(materialInventory.getWorkshopId())
               .materialInventoryId(materialInventory.getId())
               .outboundId(outbound.getId())
               .basicClass(materialInventory.getBasicClass())
               .classifyId(materialInventory.getClassifyId())
               .specification(materialInventory.getSpecification())
               .sourceProjectId(materialInventory.getProjectId())
               .sourceMonomerId(materialInventory.getMonomerId())
               .sourceAreaId(materialInventory.getAreaId())
               .thickness(materialInventory.getThickness())
               .theoryThickness(materialInventory.getTheoryThickness())
               .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
               .brand(materialInventory.getBrand())
               .outboundTime(monthTimeRange.getEndTime().plusMinutes(5L))
               .color(materialInventory.getColor())
               .recipientId(virtualWarehouse.getRecipientId())
               .outboundMode(1)
               .outboundRelationType(OutboundRelationTypeEnum.ROUTINE.getType())
               .boolPartyA(materialInventory.getBoolPartyA())
               .taxRate(materialInventory.getTaxRate())
               .invoiceType(materialInventory.getInvoiceType())
               .standardId(materialInventory.getStandardId())
               .standardName(materialInventory.getStandardName())
               .materialSn(materialInventory.getSerialNumber())
               .workshopId(virtualWarehouse.getWorkshopId())
               .length(virtualWarehouse.getLength())
               .width(virtualWarehouse.getWidth())
               .mete(virtualWarehouse.getMete())
               .quantity(virtualWarehouse.getQuantity())
               .build();
            moveOutboundDetail.setProjectId(virtualWarehouse.getProjectId());
            moveOutboundDetail.setMonomerId(virtualWarehouse.getMonomerId());
            moveOutboundDetail.setAreaId(virtualWarehouse.getAreaId());
            moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
            if (moveOutboundDetail.getProjectId() != null) {
               if (StrUtil.isNotBlank(outbound.getProjectIds())) {
                  List<Long> list = CommonUtil.spilt(outbound.getProjectIds(), ",");
                  if (!list.contains(moveOutboundDetail.getProjectId())) {
                     outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
                  }
               } else {
                  outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
               }
            }

            outbound.setContainBasicClass(
               outbound.getContainBasicClass() != null
                  ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass()
                  : moveOutboundDetail.getBasicClass()
            );
            this.moveOutboundDetailMapper.insert(moveOutboundDetail);
            outboundDetailList.add(moveOutboundDetail);
            virtualWarehouse.setBoolOutbound(true);
            this.baseMapper.updateById(virtualWarehouse);
         }

         this.outboundMapper.updateById(outbound);
         this.outboundService
            .passed(
               OutboundDTOParam.builder()
                  .id(outbound.getId())
                  .defaultName("超级管理员")
                  .defaultId(id)
                  .list(
                     outboundDetailList.stream()
                        .map(l -> OutboundDetailDTO.builder().id(l.getId()).outboundTime(LocalDateTime.now()).build())
                        .collect(Collectors.toList())
                  )
                  .build()
            );
      }
   }
}

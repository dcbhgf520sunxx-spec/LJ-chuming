package com.hzchum.scim.mes.building.core.biz.impl.scheduling;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.cut.core.api.pojo._do.NestCutPlate;
import com.hzchum.scim.cut.core.api.pojo._do.NestCutPlatePart;
import com.hzchum.scim.cut.core.api.service.NestCutPlatePartService;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlateBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlatePartBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNestCutPlateBindingLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingNestCutPlateDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingNestCutPlateBindingLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingNestCutPlateDTOParam;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlateService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingNestCutPlateMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAppService;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingNestCutPlateBizImpl
   extends IBizImpl<MesBuildingNestCutPlateService, MesBuildingNestCutPlateMapper, MesBuildingNestCutPlate>
   implements MesBuildingNestCutPlateBiz {
   @Autowired
   private MesBuildingMachinePartSchedulingBiz machinePartSchedulingBiz;
   @Autowired
   private MesBuildingMachinePartSchedulingLinkBiz schedulingLinkBiz;
   @Autowired
   private MesBuildingNestCutPlatePartBiz mesBuildingNestCutPlatePartBiz;
   @Autowired
   private NestCutPlatePartService nestCutPlatePartService;
   @Autowired
   private MaterialInventoryService inventoryService;
   @Autowired
   private WmsAppService wmsAppService;
   @Autowired
   private MesBuildingNestCutPlateBindingLinkBiz bindingLinkBiz;
   @Autowired
   private ConfigService configService;
   @Autowired
   private MesBuildingProcessService processService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean saveMesBuildingNestCutPlate(NestCutPlate nestCutPlate) {
      MesBuildingNestCutPlate mesBuildingNestCutPlate = BeanUtil.copy(nestCutPlate, MesBuildingNestCutPlate.class);
      mesBuildingNestCutPlate.setNestCutPlateId(nestCutPlate.getId());
      mesBuildingNestCutPlate.setUserId(UserUtil.getCurrentUserId());
      mesBuildingNestCutPlate.setMachinePartSchedulingId(
         this.machinePartSchedulingBiz
            .getOne(
               Wrappers.lambdaQuery(MesBuildingMachinePartScheduling.class).eq(MesBuildingMachinePartScheduling::getOrderNumber, nestCutPlate.getCutTaskId())
            )
            .getId()
      );
      mesBuildingNestCutPlate.setBoolIssueEnum(Boolean.FALSE);
      int cun = this.list(
               Wrappers.lambdaQuery(MesBuildingNestCutPlate.class)
                  .eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, mesBuildingNestCutPlate.getMachinePartSchedulingId())
            )
            .size()
         + 1;
      mesBuildingNestCutPlate.setCutNumber(
         this.machinePartSchedulingBiz.getById(mesBuildingNestCutPlate.getMachinePartSchedulingId()).getOrderNumber() + "-" + cun
      );
      mesBuildingNestCutPlate.setBoolNestCutEnum(Boolean.TRUE);
      this.save(mesBuildingNestCutPlate);
      Map<Long, Integer> limkQuantity = new HashMap<>();
      List<MesBuildingMachinePartSchedulingLink> linkList = this.schedulingLinkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class)
               .eq(MesBuildingMachinePartSchedulingLink::getSchedulingId, mesBuildingNestCutPlate.getMachinePartSchedulingId())
         );
      List<MesBuildingNestCutPlatePart> nestCutPlatePartList = this.mesBuildingNestCutPlatePartBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class)
               .eq(
                  MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId,
                  this.list(
                     Wrappers.lambdaQuery(MesBuildingNestCutPlate.class)
                        .eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, mesBuildingNestCutPlate.getMachinePartSchedulingId())
                  )
               )
         );
      linkList.forEach(
         e -> {
            Integer var10000 = limkQuantity.put(
               e.getProductId(),
               e.getQuantity()
                  - nestCutPlatePartList.stream().filter(i -> i.getPartId().equals(e.getProductId())).mapToInt(MesBuildingNestCutPlatePart::getQuantity).sum()
            );
         }
      );
      this.nestCutPlatePartService
         .list(Wrappers.lambdaQuery(NestCutPlatePart.class).eq(NestCutPlatePart::getCutInstructionId, nestCutPlate.getCutInstructionId()))
         .forEach(
            e -> {
               if (limkQuantity.get(Long.valueOf(e.getPartId())) != null && e.getQuantity() <= limkQuantity.get(Long.valueOf(e.getPartId()))) {
                  this.mesBuildingNestCutPlatePartBiz
                     .save(
                        MesBuildingNestCutPlatePart.builder()
                           .id(e.getId())
                           .mesBuildingNestCutPlateId(mesBuildingNestCutPlate.getId())
                           .cutInstructionId(e.getCutInstructionId())
                           .cutTaskId(e.getCutTaskId())
                           .taskOrderId(mesBuildingNestCutPlate.getTaskOrderId())
                           .partId(Long.valueOf(e.getPartId()))
                           .quantity(e.getQuantity())
                           .sendState(e.getSendState())
                           .taskId(e.getTaskId())
                           .build()
                     );
               } else {
                  throw new IllegalArgumentException("操作失败：套料数量超过排产数量");
               }
            }
         );
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean bindingSteelPlate(MesBuildingNestCutPlateDTOParam dtoParam) {
      MesBuildingNestCutPlate nestCutPlate = this.getById(dtoParam.getId());
      Preconditions.checkArgument(nestCutPlate != null, "传入id不正确");
      MaterialInventory inventory = this.inventoryService
         .getOne(Wrappers.lambdaQuery(MaterialInventory.class).eq(MaterialInventory::getBarcode, dtoParam.getNumber()));
      Preconditions.checkArgument(inventory != null, "操作失败，未找到钢板信息");
      Preconditions.checkArgument(
         nestCutPlate.getLength().compareTo(inventory.getLength()) == 0
            && nestCutPlate.getThick().compareTo(inventory.getThickness()) == 0
            && nestCutPlate.getWeight().compareTo(inventory.getWidth()) == 0
            && nestCutPlate.getMaterial().equals(inventory.getSpecification()),
         "操作失败，钢板规格材质不匹配"
      );
      nestCutPlate.setPlateNo(String.valueOf(inventory.getId()));
      this.updateById(nestCutPlate);
      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingMachineTaskOrderDTO> getAllnetCut(
      Integer boolNestCut,
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      String serialNumber,
      Integer processType,
      List<Long> processIds,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String cutNumber,
      Long cutConfigId
   ) {
      return this.baseMapper
         .getAllnetCut(
            boolNestCut, projectIds, monomerIds, areaIds, serialNumber, processType, processIds, printType, workshopId, localDateTime, cutNumber, cutConfigId
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean savePlateBinding(Long nestCutPlateId, String barcode) {
      MesBuildingNestCutPlate cutPlate = this.getById(nestCutPlateId);
      Preconditions.checkArgument(cutPlate != null, "操作失败，任务指令不存在");
      MaterialInventoryDTO inventory = this.wmsAppService.getOutboundMaterial(barcode);
      Preconditions.checkArgument(inventory != null, "操作失败，任务指令不存在");
      Preconditions.checkArgument(
         cutPlate.getThick().compareTo(inventory.getThickness()) == 0
            && cutPlate.getWidth().compareTo(inventory.getWidth()) == 0
            && cutPlate.getLength().compareTo(inventory.getLength()) == 0
            && cutPlate.getMaterial().equals(inventory.getSpecification()),
         "操作失败：钢板规格不匹配"
      );
      this.updateById(MesBuildingNestCutPlate.builder().id(nestCutPlateId).boolBindingEnum(Boolean.TRUE).build());
      MesBuildingNestCutPlateBindingLink bindingLink = this.bindingLinkBiz
         .getOne(
            Wrappers.lambdaQuery(MesBuildingNestCutPlateBindingLink.class)
               .eq(MesBuildingNestCutPlateBindingLink::getPlateNo, barcode)
               .eq(MesBuildingNestCutPlateBindingLink::getNestCutPlateId, cutPlate.getId())
         );
      if (bindingLink == null) {
         this.bindingLinkBiz
            .save(
               MesBuildingNestCutPlateBindingLink.builder()
                  .nestCutPlateId(cutPlate.getId())
                  .machinePartSchedulingId(cutPlate.getMachinePartSchedulingId())
                  .taskOrderId(cutPlate.getId())
                  .plateNo(barcode)
                  .quantity(1)
                  .userId(UserUtil.getCurrentUserId())
                  .build()
            );
      } else {
         bindingLink.setQuantity(bindingLink.getQuantity() + 1);
         this.bindingLinkBiz.updateById(bindingLink);
      }

      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingNestCutPlateBindingLink> getPlateBindingLinkList(Long nestCutPlateId) {
      return this.bindingLinkBiz.list(Wrappers.lambdaQuery(MesBuildingNestCutPlateBindingLink.builder().nestCutPlateId(nestCutPlateId).build()));
   }

   @Override
   public List<MesBuildingNestCutPlateDO> getMachinePartTaskIssuedDetails(Long id) {
      return this.baseMapper.getMachinePartTaskIssuedDetails(id);
   }

   @Override
   public Boolean deletePlateBinding(List<Long> bindingIds) {
      bindingIds.forEach(bindingId -> {
         MesBuildingNestCutPlateBindingLink bindingLink = this.bindingLinkBiz.getById(bindingId);
         Preconditions.checkArgument(bindingLink != null, "钢板不存在");
         this.bindingLinkBiz.removeById(bindingId);
      });
      return Boolean.TRUE;
   }
}

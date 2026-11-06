package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.enums.TableNameTypeEnum;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterial;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Return;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo.dto.common.DTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.SupplementDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MoveMaterialDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.TransferDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryByStr;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveMaterialDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveMaterialService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReceiptPrintService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnManufacturedService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveMaterialMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.SupplementMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ReceiptPrintServiceImpl implements ReceiptPrintService {
   @Resource
   InboundMapper inboundMapper;
   @Resource
   PurchaseOrderService purchaseOrderService;
   @Resource
   SupplierService supplierService;
   @Resource
   InboundDetailMapper inboundDetailMapper;
   @Resource
   OutboundMapper outboundMapper;
   @Resource
   ReturnMapper returnMapper;
   @Resource
   ReturnDetailMapper returnDetailMapper;
   @Resource
   RejectMapper rejectMapper;
   @Resource
   RejectDetailMapper rejectDetailMapper;
   @Resource
   TransferMapper transferMapper;
   @Resource
   TransferDetailMapper transferDetailMapper;
   @Resource
   ClassificationService classificationService;
   @Resource
   SupplementMapper supplementMapper;
   @Resource
   LogisticsOrderService logisticsOrderService;
   @Resource
   MoveMaterialMapper moveMaterialMapper;
   @Resource
   MoveMaterialDetailService moveMaterialDetailService;
   @Resource
   MoveMaterialService moveMaterialService;
   @Resource
   WarehouseService warehouseService;
   @Resource
   WorkshopService workshopService;
   @Resource
   MesBuildingFactoryService mesBuildingFactoryService;
   @Resource
   MesBuildingWorkshopService mesWorkshopService;
   @Resource
   QueryUtilService queryUtilService;
   @Resource
   InboundManufacturedService inboundManufacturedService;
   @Resource
   InboundDetailManufacturedService inboundDetailManufacturedService;
   @Resource
   OutboundManufacturedService outboundManufacturedService;
   @Resource
   OutboundDetailManufacturedService outboundDetailManufacturedService;
   @Resource
   ReturnManufacturedService returnManufacturedService;
   @Resource
   ReturnDetailManufacturedService returnDetailManufacturedService;
   @Resource
   QueryUtilImpl queryUtil;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;

   @Override
   public PrintVO<List<MaterialInventoryDTO>> inboundPrint(Long id) {
      Inbound inbound = this.inboundMapper.selectById(id);
      Preconditions.checkArgument(inbound != null, "入库单异常");
      PrintVO<List<MaterialInventoryDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("inboundSN", inbound.getSerialNumber());
      header.put("purchaseSN", inbound.getPurchaseSn());
      header.put("inboundWay", inbound.getInboundWay());
      if (inbound.getPurchaseId() != null) {
         PurchaseOrder order = this.purchaseOrderService.getById(inbound.getPurchaseId());
         LogisticsOrder one = this.logisticsOrderService
            .getOne(
               (Wrapper<LogisticsOrder>)(new LambdaQueryWrapper<LogisticsOrder>().eq(LogisticsOrder::getInboundId, inbound.getId()))
                  .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
            );
         if (one != null) {
            header.put("logisticsSupplierName", one.getSupplierName());
            header.put("freight", one.getFreight());
            header.put("freightWeight", one.getFreightWeight());
         }

         header.put("weightMeasurementMode", order.getWeightMeasurementMode());
         header.put("logisticsPayerType", order.getLogisticsPayerType());
      } else {
         header.put("weightMeasurementMode", "-");
         header.put("logisticsPayerType", "-");
      }

      header.put("supplierName", inbound.getSupplierId() != null ? this.supplierService.getById(inbound.getSupplierId()).getName() : null);
      header.put("reviewer", this.wmsApproveRecordService.getApproveUserInfo(inbound.getApproveRecordId(), "、"));
      header.put("inboundTime", inbound.getReviewTime());
      header.put("licensePlate", inbound.getLicensePlate());
      header.put("shipmentNumber", inbound.getShipmentNumber());
      header.put("mesWorkshopName", inbound.getMesWorkshopId() != null ? this.mesWorkshopService.getWorkshopById(inbound.getMesWorkshopId()).getName() : null);
      List<MaterialInventoryDTO> table = this.inboundDetailMapper.getByInId(inbound.getId());
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      List<MaterialInventoryDTO> result = table.stream().map(detailDO -> {
         String s1 = this.queryUtil.buildCompositeKey(detailDO.getClassifyId(), detailDO.getSpecification(), detailDO.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         detailDO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
         return (MaterialInventoryDTO)detailDO;
      }).collect(Collectors.toList());
      vo.setHeader(header);
      vo.setTable(result);
      return vo;
   }

   @Override
   public PrintVO<List<InboundDetailManufacturedDTO>> inboundManufacturedPrint(Long id) {
      InboundManufactured inboundManufactured = this.inboundManufacturedService.getById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundManufactured), "未获取到制成品入库单信息");
      PrintVO<List<InboundDetailManufacturedDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("inboundSN", inboundManufactured.getSerialNumber());
      header.put("purchaseSN", inboundManufactured.getPurchaseSn());
      if (inboundManufactured.getPurchaseId() != null) {
         PurchaseOrder order = this.purchaseOrderService.getById(inboundManufactured.getPurchaseId());
         LogisticsOrder one = this.logisticsOrderService
            .getOne(
               (Wrapper<LogisticsOrder>)(new LambdaQueryWrapper<LogisticsOrder>().eq(LogisticsOrder::getInboundId, inboundManufactured.getId()))
                  .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND_MANUFACTURED.getType())
            );
         if (one != null) {
            header.put("logisticsSupplierName", one.getSupplierName());
            header.put("freight", one.getFreight());
            header.put("freightWeight", one.getFreightWeight());
         }

         header.put("weightMeasurementMode", order.getWeightMeasurementMode());
         header.put("logisticsPayerType", order.getLogisticsPayerType());
      } else {
         header.put("weightMeasurementMode", "-");
         header.put("logisticsPayerType", "-");
      }

      header.put(
         "supplierName", inboundManufactured.getSupplierId() != null ? this.supplierService.getById(inboundManufactured.getSupplierId()).getName() : null
      );
      header.put("inboundTime", inboundManufactured.getReviewPassTime());
      header.put("licensePlate", inboundManufactured.getLicensePlate());
      header.put("shipmentNumber", inboundManufactured.getShipmentNumber());
      List<InboundDetailManufactured> inboundDetailManufactureds = this.inboundDetailManufacturedService
         .list(
            (Wrapper<InboundDetailManufactured>)new LambdaQueryWrapper<InboundDetailManufactured>().eq(InboundDetailManufactured::getInboundManufacturedId, inboundManufactured.getId())
         );
      List<InboundDetailManufacturedDTO> inboundDetailManufacturedDTOS = this.inboundDetailManufacturedService.convertDetailDto(inboundDetailManufactureds);
      vo.setHeader(header);
      vo.setTable(inboundDetailManufacturedDTOS);
      return vo;
   }

   @Override
   public Boolean inboundPrintState(Long id) {
      Inbound inbound = this.inboundMapper.selectById(id);
      Preconditions.checkArgument(inbound != null, "当前单据不存在");
      inbound.setPrintStatus(true);
      this.inboundMapper.updateById(inbound);
      return true;
   }

   @Override
   public PrintVO<List<OutboundDetailDTO>> outboundPrint(Long id) {
      Outbound outbound = this.outboundMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单异常");
      PrintVO<List<OutboundDetailDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("outboundSN", outbound.getSerialNumber());
      header.put("reviewer", this.wmsApproveRecordService.getApproveUserInfo(outbound.getApproveRecordId(), "、"));
      ArrayList<LocalDateTime> localDateTimes = new ArrayList<>();
      localDateTimes.add(outbound.getOutboundStartTime());
      localDateTimes.add(outbound.getOutboundEndTime());
      header.put("outboundTime", localDateTimes);
      List<OutboundDetailDTO> ta = this.outboundMapper.getByOutId(outbound.getId());
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      List<OutboundDetailDTO> result = ta.stream().map(detailDO -> {
         String s1 = this.queryUtil.buildCompositeKey(detailDO.getClassifyId(), detailDO.getSpecification(), detailDO.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         detailDO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
         return (OutboundDetailDTO)detailDO;
      }).collect(Collectors.toList());
      vo.setTable(result);
      vo.setHeader(header);
      return vo;
   }

   @Override
   public PrintVO<List<OutboundDetailManufacturedDTO>> outboundManufacturedPrint(Long id) {
      OutboundManufactured outboundManufactured = this.outboundManufacturedService.getById(id);
      Preconditions.checkArgument(outboundManufactured != null, "未获取到制成品出库单信息！！！");
      PrintVO<List<OutboundDetailManufacturedDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("outboundSN", outboundManufactured.getSerialNumber());
      header.put("basicClassName", BasicClassEnum.getNameByType(outboundManufactured.getBasicClass()));
      header.put("applicationName", outboundManufactured.getApplicantName());
      header.put("applicationTime", outboundManufactured.getApplicationTime());
      List<OutboundDetailManufactured> outboundDetailManufactureds = this.outboundDetailManufacturedService
         .list(
            (Wrapper<OutboundDetailManufactured>)new LambdaQueryWrapper<OutboundDetailManufactured>()
               .eq(OutboundDetailManufactured::getOutboundManufacturedId, outboundManufactured.getId())
         );
      List<OutboundDetailManufacturedDTO> list = this.outboundDetailManufacturedService.convertDetailDto(outboundDetailManufactureds);
      vo.setTable(list);
      vo.setHeader(header);
      return vo;
   }

   @Override
   public PrintVO<List<MaterialInventoryDTO>> returnPrint(Long id) {
      Return re = this.returnMapper.selectById(id);
      Preconditions.checkArgument(re != null, "退库单异常");
      PrintVO<List<MaterialInventoryDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("returnSN", re.getSerialNumber());
      header.put("reviewer", this.wmsApproveRecordService.getApproveUserInfo(re.getApproveRecordId(), "、"));
      header.put("applicant", re.getApplicantName());
      header.put("returnTime", re.getReturnTime());
      List<MaterialInventoryDTO> table = this.returnDetailMapper.getByReId(re.getId());
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      List<MaterialInventoryDTO> result = table.stream().map(detailDO -> {
         String s1 = this.queryUtil.buildCompositeKey(detailDO.getClassifyId(), detailDO.getSpecification(), detailDO.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         detailDO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
         return (MaterialInventoryDTO)detailDO;
      }).collect(Collectors.toList());
      vo.setHeader(header);
      vo.setTable(result);
      return vo;
   }

   @Override
   public PrintVO<List<ReturnDetailManufacturedDTO>> returnManufacturedPrint(Long id) {
      ReturnManufactured returnManufactured = this.returnManufacturedService.getById(id);
      Preconditions.checkArgument(returnManufactured != null, "未获取到制成品退库单信息！！！");
      PrintVO<List<ReturnDetailManufacturedDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("returnSN", returnManufactured.getSerialNumber());
      List<ReturnDetailManufactured> returnDetailManufactureds = this.returnDetailManufacturedService
         .list((Wrapper<ReturnDetailManufactured>)new LambdaQueryWrapper<ReturnDetailManufactured>().eq(ReturnDetailManufactured::getReturnManufacturedId, returnManufactured.getId()));
      List<ReturnDetailManufacturedDTO> returnDetailManufacturedDTOS = this.returnDetailManufacturedService.convertDetailDto(returnDetailManufactureds);
      vo.setTable(returnDetailManufacturedDTOS);
      vo.setHeader(header);
      return vo;
   }

   @Override
   public PrintVO<List<MaterialInventoryDTO>> rejectPrint(Long id) {
      PrintVO<List<MaterialInventoryDTO>> vo = new PrintVO<>();
      Reject reject = this.rejectMapper.selectById(id);
      Preconditions.checkArgument(reject != null, "退货单异常");
      Inbound inbound = this.inboundMapper.selectById(reject.getInboundId());
      PurchaseOrder order = this.purchaseOrderService.getById(inbound.getPurchaseId());
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("inboundSN", inbound.getSerialNumber());
      header.put("rejectSN", reject.getSerialNumber());
      header.put("purchaseSN", inbound.getPurchaseSn());
      header.put("logisticsPayerType", ObjectUtil.isNotEmpty(order) ? order.getLogisticsPayerType() : null);
      header.put("supplierName", ObjectUtil.isNotEmpty(inbound.getSupplierId()) ? this.supplierService.getById(inbound.getSupplierId()).getName() : "");
      header.put("reviewer", reject.getReviewerName());
      header.put("applicant", reject.getApplicantName());
      header.put("inboundTime", inbound.getReviewTime());
      header.put("rejectTime", reject.getReviewTime());
      header.put("remark", reject.getRemark());
      List<MaterialInventoryDTO> table = this.rejectDetailMapper.getByReId(reject.getId());
      vo.setHeader(header);
      vo.setTable(table);
      return vo;
   }

   @Override
   public PrintVO<List<MaterialInventoryDTO>> transferPrint(Long id) {
      TransferDTO transfer = this.transferMapper.getTransfer(id);
      Preconditions.checkArgument(transfer != null, "调拨单异常");
      PrintVO<List<MaterialInventoryDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("transferSN", transfer.getSerialNumber());
      header.put("transferTime", transfer.getReviewTime());
      header.put("applicant", transfer.getApplicantName());
      header.put("reviewer", transfer.getReviewerName());
      header.put("direction", transfer.getDirection());
      header.put("transferType", transfer.getTransferType());
      List<DTO> source = new ArrayList<>();
      List<MaterialInventoryDTO> table = this.transferDetailMapper.getByTrId(transfer.getId());

      for (MaterialInventoryDTO dto : table) {
         source.add(
            DTO.builder()
               .project(dto.getProject())
               .workshop(dto.getWorkshop())
               .warehouse(dto.getWarehouse())
               .monomerName(dto.getMonomerName())
               .areaName(dto.getAreaName())
               .build()
         );
      }

      header.put("source", source);
      vo.setHeader(header);
      vo.setTable(table);
      return vo;
   }

   @Override
   public PrintVO<List<SupplementDTO>> supplementPrint(QueryDetailDTOParam param, List<String> sort) {
      param.setClassifyIds(this.queryUtilService.getLateClassificationList(param.getClassifyId()));
      PrintVO<List<SupplementDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      vo.setTable(this.supplementMapper.list(param));
      vo.setHeader(header);
      return vo;
   }

   @Override
   public PrintVO<List<MoveMaterialDetailDTO>> moveMaterialPrint(Long id) {
      this.moveMaterialService.queryById(id);
      MoveMaterial moveMaterial = this.moveMaterialMapper.selectById(id);
      Preconditions.checkArgument(moveMaterial != null, "出库单异常");
      PrintVO<List<MoveMaterialDetailDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("moveMaterialSN", moveMaterial.getSerialNumber());
      header.put("reviewer", moveMaterial.getReviewerNames());
      ArrayList<LocalDateTime> localDateTimes = new ArrayList<>();
      localDateTimes.add(moveMaterial.getCreateTime());
      localDateTimes.add(moveMaterial.getReviewEndTime());
      header.put("moveMaterialTime", localDateTimes);
      Warehouse warehouse = this.warehouseService.getById(moveMaterial.getDirectionWarehouseId());
      header.put("directionWarehouse", ObjectUtil.isNotEmpty(warehouse) ? warehouse.getName() : "");
      Workshop workshop = this.workshopService.getById(moveMaterial.getDirectionWorkshopId());
      header.put("directionWorkshop", ObjectUtil.isNotEmpty(workshop) ? workshop.getName() : "");
      List<Long> ids = new ArrayList<>();
      ids.add(moveMaterial.getId());
      List<MoveMaterialDetailDTO> moveMaterialDetailDTO = this.moveMaterialDetailService.getMoveMaterialDetailDTO(ids);
      vo.setTable(moveMaterialDetailDTO);
      vo.setHeader(header);
      return vo;
   }

   @Override
   public PrintVO<List<MoveMaterialDetailDTO>> moveMaterialDetails(QueryByStr query) {
      List<Long> ids = Arrays.stream(query.getIdsStr().split(",")).map(Long::valueOf).collect(Collectors.toList());
      ids.forEach(this.moveMaterialService::queryById);
      List<MoveMaterialDetailDTO> moveMaterialDetailDTOS = this.moveMaterialDetailService.getMoveMaterialDetailDTO(ids);
      PrintVO<List<MoveMaterialDetailDTO>> vo = new PrintVO<>();
      vo.setTable(moveMaterialDetailDTOS);
      return vo;
   }

   @Override
   public Boolean outboundPrintState(Long id) {
      Outbound outbound = this.outboundMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "当前单据不存在");
      outbound.setBoolPrinted(true);
      this.outboundMapper.updateById(outbound);
      return Boolean.TRUE;
   }

   @Override
   public Boolean returnPrintState(Long id) {
      Return aReturn = this.returnMapper.selectById(id);
      Preconditions.checkArgument(aReturn != null, "当前单据不存在");
      aReturn.setBoolPrinted(true);
      this.returnMapper.updateById(aReturn);
      return Boolean.TRUE;
   }

   @Override
   public Boolean rejectPrintState(Long id) {
      Reject reject = this.rejectMapper.selectById(id);
      Preconditions.checkArgument(reject != null, "当前单据不存在");
      reject.setBoolPrinted(true);
      this.rejectMapper.updateById(reject);
      return Boolean.TRUE;
   }

   @Override
   public Boolean transferPrintState(Long id) {
      Transfer transfer = this.transferMapper.selectById(id);
      Preconditions.checkArgument(transfer != null, "当前单据不存在");
      transfer.setBoolPrinted(true);
      this.transferMapper.updateById(transfer);
      return Boolean.TRUE;
   }
}

package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class QueryDetailDTOParam {
   private List<Long> detailIds;
   private Integer basicClass;
   private Integer orderSupplyType;
   private Long workshopId;
   private Long warehouseId;
   private Integer materialIsWhole;
   private List<LocalDateTime> outboundTime;
   private List<LocalDateTime> materialOutboundTime;
   private List<LocalDateTime> reviewTime;
   private int timeType;
   private List<LocalDateTime> returnTime;
   private List<LocalDateTime> realTime;
   private String outboundSN;
   private String transferSN;
   private String moveMaterialSN;
   private Long recipientId;
   private Long monomerId;
   private Long areaId;
   private Integer outReviewStatus;
   private String operatorName;
   private List<Long> classifyId;
   private List<Long> classifyIds;
   private Long projectId;
   private List<Long> projectIds;
   private BigDecimal minLength;
   private BigDecimal maxLength;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal theoryThickness;
   private BigDecimal thickness;
   private String heatNoAndBatchNo;
   private String specification;
   private String color;
   private String brand;
   private Integer projectWarehouseType;
   private String serialNumber;
   private Long factoryId;
   private Integer outboundTypeSelection;
   private Long sourceProjectId;
   private Long directionProjectId;
   private Integer weightMeasurementMode;
   private Long sourceWorkshopId;
   private Long branchCompanyId;
   private Integer functionType;
   private Integer transferType;
   private Boolean boolScheduling;
   private List<Long> sourceWorkshopIds;
   private Integer transferCreateType;
   private String outboundSn;

   public static QueryDetailDTOParam.QueryDetailDTOParamBuilder builder() {
      return new QueryDetailDTOParam.QueryDetailDTOParamBuilder();
   }

   public List<Long> getDetailIds() {
      return this.detailIds;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getOrderSupplyType() {
      return this.orderSupplyType;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public List<LocalDateTime> getOutboundTime() {
      return this.outboundTime;
   }

   public List<LocalDateTime> getMaterialOutboundTime() {
      return this.materialOutboundTime;
   }

   public List<LocalDateTime> getReviewTime() {
      return this.reviewTime;
   }

   public int getTimeType() {
      return this.timeType;
   }

   public List<LocalDateTime> getReturnTime() {
      return this.returnTime;
   }

   public List<LocalDateTime> getRealTime() {
      return this.realTime;
   }

   public String getOutboundSN() {
      return this.outboundSN;
   }

   public String getTransferSN() {
      return this.transferSN;
   }

   public String getMoveMaterialSN() {
      return this.moveMaterialSN;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getOutReviewStatus() {
      return this.outReviewStatus;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public List<Long> getClassifyId() {
      return this.classifyId;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public BigDecimal getMinLength() {
      return this.minLength;
   }

   public BigDecimal getMaxLength() {
      return this.maxLength;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Long getSourceProjectId() {
      return this.sourceProjectId;
   }

   public Long getDirectionProjectId() {
      return this.directionProjectId;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Long getSourceWorkshopId() {
      return this.sourceWorkshopId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getFunctionType() {
      return this.functionType;
   }

   public Integer getTransferType() {
      return this.transferType;
   }

   public Boolean getBoolScheduling() {
      return this.boolScheduling;
   }

   public List<Long> getSourceWorkshopIds() {
      return this.sourceWorkshopIds;
   }

   public Integer getTransferCreateType() {
      return this.transferCreateType;
   }

   public void setDetailIds(final List<Long> detailIds) {
      this.detailIds = detailIds;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setOrderSupplyType(final Integer orderSupplyType) {
      this.orderSupplyType = orderSupplyType;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   public void setOutboundTime(final List<LocalDateTime> outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setMaterialOutboundTime(final List<LocalDateTime> materialOutboundTime) {
      this.materialOutboundTime = materialOutboundTime;
   }

   public void setReviewTime(final List<LocalDateTime> reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setTimeType(final int timeType) {
      this.timeType = timeType;
   }

   public void setReturnTime(final List<LocalDateTime> returnTime) {
      this.returnTime = returnTime;
   }

   public void setRealTime(final List<LocalDateTime> realTime) {
      this.realTime = realTime;
   }

   public void setOutboundSN(final String outboundSN) {
      this.outboundSN = outboundSN;
   }

   public void setTransferSN(final String transferSN) {
      this.transferSN = transferSN;
   }

   public void setMoveMaterialSN(final String moveMaterialSN) {
      this.moveMaterialSN = moveMaterialSN;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setOutReviewStatus(final Integer outReviewStatus) {
      this.outReviewStatus = outReviewStatus;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setClassifyId(final List<Long> classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   public void setMinLength(final BigDecimal minLength) {
      this.minLength = minLength;
   }

   public void setMaxLength(final BigDecimal maxLength) {
      this.maxLength = maxLength;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setSourceProjectId(final Long sourceProjectId) {
      this.sourceProjectId = sourceProjectId;
   }

   public void setDirectionProjectId(final Long directionProjectId) {
      this.directionProjectId = directionProjectId;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setFunctionType(final Integer functionType) {
      this.functionType = functionType;
   }

   public void setTransferType(final Integer transferType) {
      this.transferType = transferType;
   }

   public void setBoolScheduling(final Boolean boolScheduling) {
      this.boolScheduling = boolScheduling;
   }

   public void setSourceWorkshopIds(final List<Long> sourceWorkshopIds) {
      this.sourceWorkshopIds = sourceWorkshopIds;
   }

   public void setTransferCreateType(final Integer transferCreateType) {
      this.transferCreateType = transferCreateType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryDetailDTOParam)) {
         return false;
      }

      QueryDetailDTOParam other = (QueryDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getTimeType() != other.getTimeType()) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$orderSupplyType = this.getOrderSupplyType();
         Object other$orderSupplyType = other.getOrderSupplyType();
         if (this$orderSupplyType == null ? other$orderSupplyType == null : this$orderSupplyType.equals(other$orderSupplyType)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$warehouseId = this.getWarehouseId();
               Object other$warehouseId = other.getWarehouseId();
               if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                  Object this$materialIsWhole = this.getMaterialIsWhole();
                  Object other$materialIsWhole = other.getMaterialIsWhole();
                  if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                     Object this$recipientId = this.getRecipientId();
                     Object other$recipientId = other.getRecipientId();
                     if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                        Object this$monomerId = this.getMonomerId();
                        Object other$monomerId = other.getMonomerId();
                        if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                           Object this$areaId = this.getAreaId();
                           Object other$areaId = other.getAreaId();
                           if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                              Object this$outReviewStatus = this.getOutReviewStatus();
                              Object other$outReviewStatus = other.getOutReviewStatus();
                              if (this$outReviewStatus == null ? other$outReviewStatus == null : this$outReviewStatus.equals(other$outReviewStatus)) {
                                 Object this$projectId = this.getProjectId();
                                 Object other$projectId = other.getProjectId();
                                 if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                    Object this$projectWarehouseType = this.getProjectWarehouseType();
                                    Object other$projectWarehouseType = other.getProjectWarehouseType();
                                    if (this$projectWarehouseType == null
                                       ? other$projectWarehouseType == null
                                       : this$projectWarehouseType.equals(other$projectWarehouseType)) {
                                       Object this$factoryId = this.getFactoryId();
                                       Object other$factoryId = other.getFactoryId();
                                       if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                          Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                                          Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                                          if (this$outboundTypeSelection == null
                                             ? other$outboundTypeSelection == null
                                             : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                                             Object this$sourceProjectId = this.getSourceProjectId();
                                             Object other$sourceProjectId = other.getSourceProjectId();
                                             if (this$sourceProjectId == null
                                                ? other$sourceProjectId == null
                                                : this$sourceProjectId.equals(other$sourceProjectId)) {
                                                Object this$directionProjectId = this.getDirectionProjectId();
                                                Object other$directionProjectId = other.getDirectionProjectId();
                                                if (this$directionProjectId == null
                                                   ? other$directionProjectId == null
                                                   : this$directionProjectId.equals(other$directionProjectId)) {
                                                   Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                                   Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                                   if (this$weightMeasurementMode == null
                                                      ? other$weightMeasurementMode == null
                                                      : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                                      Object this$sourceWorkshopId = this.getSourceWorkshopId();
                                                      Object other$sourceWorkshopId = other.getSourceWorkshopId();
                                                      if (this$sourceWorkshopId == null
                                                         ? other$sourceWorkshopId == null
                                                         : this$sourceWorkshopId.equals(other$sourceWorkshopId)) {
                                                         Object this$branchCompanyId = this.getBranchCompanyId();
                                                         Object other$branchCompanyId = other.getBranchCompanyId();
                                                         if (this$branchCompanyId == null
                                                            ? other$branchCompanyId == null
                                                            : this$branchCompanyId.equals(other$branchCompanyId)) {
                                                            Object this$functionType = this.getFunctionType();
                                                            Object other$functionType = other.getFunctionType();
                                                            if (this$functionType == null
                                                               ? other$functionType == null
                                                               : this$functionType.equals(other$functionType)) {
                                                               Object this$transferType = this.getTransferType();
                                                               Object other$transferType = other.getTransferType();
                                                               if (this$transferType == null
                                                                  ? other$transferType == null
                                                                  : this$transferType.equals(other$transferType)) {
                                                                  Object this$boolScheduling = this.getBoolScheduling();
                                                                  Object other$boolScheduling = other.getBoolScheduling();
                                                                  if (this$boolScheduling == null
                                                                     ? other$boolScheduling == null
                                                                     : this$boolScheduling.equals(other$boolScheduling)) {
                                                                     Object this$transferCreateType = this.getTransferCreateType();
                                                                     Object other$transferCreateType = other.getTransferCreateType();
                                                                     if (this$transferCreateType == null
                                                                        ? other$transferCreateType == null
                                                                        : this$transferCreateType.equals(other$transferCreateType)) {
                                                                        Object this$detailIds = this.getDetailIds();
                                                                        Object other$detailIds = other.getDetailIds();
                                                                        if (this$detailIds == null
                                                                           ? other$detailIds == null
                                                                           : this$detailIds.equals(other$detailIds)) {
                                                                           Object this$outboundTime = this.getOutboundTime();
                                                                           Object other$outboundTime = other.getOutboundTime();
                                                                           if (this$outboundTime == null
                                                                              ? other$outboundTime == null
                                                                              : this$outboundTime.equals(other$outboundTime)) {
                                                                              Object this$materialOutboundTime = this.getMaterialOutboundTime();
                                                                              Object other$materialOutboundTime = other.getMaterialOutboundTime();
                                                                              if (this$materialOutboundTime == null
                                                                                 ? other$materialOutboundTime == null
                                                                                 : this$materialOutboundTime.equals(other$materialOutboundTime)) {
                                                                                 Object this$reviewTime = this.getReviewTime();
                                                                                 Object other$reviewTime = other.getReviewTime();
                                                                                 if (this$reviewTime == null
                                                                                    ? other$reviewTime == null
                                                                                    : this$reviewTime.equals(other$reviewTime)) {
                                                                                    Object this$returnTime = this.getReturnTime();
                                                                                    Object other$returnTime = other.getReturnTime();
                                                                                    if (this$returnTime == null
                                                                                       ? other$returnTime == null
                                                                                       : this$returnTime.equals(other$returnTime)) {
                                                                                       Object this$realTime = this.getRealTime();
                                                                                       Object other$realTime = other.getRealTime();
                                                                                       if (this$realTime == null
                                                                                          ? other$realTime == null
                                                                                          : this$realTime.equals(other$realTime)) {
                                                                                          Object this$outboundSN = this.getOutboundSN();
                                                                                          Object other$outboundSN = other.getOutboundSN();
                                                                                          if (this$outboundSN == null
                                                                                             ? other$outboundSN == null
                                                                                             : this$outboundSN.equals(other$outboundSN)) {
                                                                                             Object this$transferSN = this.getTransferSN();
                                                                                             Object other$transferSN = other.getTransferSN();
                                                                                             if (this$transferSN == null
                                                                                                ? other$transferSN == null
                                                                                                : this$transferSN.equals(other$transferSN)) {
                                                                                                Object this$moveMaterialSN = this.getMoveMaterialSN();
                                                                                                Object other$moveMaterialSN = other.getMoveMaterialSN();
                                                                                                if (this$moveMaterialSN == null
                                                                                                   ? other$moveMaterialSN == null
                                                                                                   : this$moveMaterialSN.equals(other$moveMaterialSN)) {
                                                                                                   Object this$operatorName = this.getOperatorName();
                                                                                                   Object other$operatorName = other.getOperatorName();
                                                                                                   if (this$operatorName == null
                                                                                                      ? other$operatorName == null
                                                                                                      : this$operatorName.equals(other$operatorName)) {
                                                                                                      Object this$classifyId = this.getClassifyId();
                                                                                                      Object other$classifyId = other.getClassifyId();
                                                                                                      if (this$classifyId == null
                                                                                                         ? other$classifyId == null
                                                                                                         : this$classifyId.equals(other$classifyId)) {
                                                                                                         Object this$classifyIds = this.getClassifyIds();
                                                                                                         Object other$classifyIds = other.getClassifyIds();
                                                                                                         if (this$classifyIds == null
                                                                                                            ? other$classifyIds == null
                                                                                                            : this$classifyIds.equals(other$classifyIds)) {
                                                                                                            Object this$projectIds = this.getProjectIds();
                                                                                                            Object other$projectIds = other.getProjectIds();
                                                                                                            if (this$projectIds == null
                                                                                                               ? other$projectIds == null
                                                                                                               : this$projectIds.equals(other$projectIds)) {
                                                                                                               Object this$minLength = this.getMinLength();
                                                                                                               Object other$minLength = other.getMinLength();
                                                                                                               if (this$minLength == null
                                                                                                                  ? other$minLength == null
                                                                                                                  : this$minLength.equals(other$minLength)) {
                                                                                                                  Object this$maxLength = this.getMaxLength();
                                                                                                                  Object other$maxLength = other.getMaxLength();
                                                                                                                  if (this$maxLength == null
                                                                                                                     ? other$maxLength == null
                                                                                                                     : this$maxLength.equals(other$maxLength)) {
                                                                                                                     Object this$length = this.getLength();
                                                                                                                     Object other$length = other.getLength();
                                                                                                                     if (this$length == null
                                                                                                                        ? other$length == null
                                                                                                                        : this$length.equals(other$length)) {
                                                                                                                        Object this$width = this.getWidth();
                                                                                                                        Object other$width = other.getWidth();
                                                                                                                        if (this$width == null
                                                                                                                           ? other$width == null
                                                                                                                           : this$width.equals(other$width)) {
                                                                                                                           Object this$theoryThickness = this.getTheoryThickness();
                                                                                                                           Object other$theoryThickness = other.getTheoryThickness();
                                                                                                                           if (this$theoryThickness == null
                                                                                                                              ? other$theoryThickness == null
                                                                                                                              : this$theoryThickness.equals(
                                                                                                                                 other$theoryThickness
                                                                                                                              )) {
                                                                                                                              Object this$thickness = this.getThickness();
                                                                                                                              Object other$thickness = other.getThickness();
                                                                                                                              if (this$thickness == null
                                                                                                                                 ? other$thickness == null
                                                                                                                                 : this$thickness.equals(
                                                                                                                                    other$thickness
                                                                                                                                 )) {
                                                                                                                                 Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                                                 Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                                                 if (this$heatNoAndBatchNo
                                                                                                                                       == null
                                                                                                                                    ? other$heatNoAndBatchNo
                                                                                                                                       == null
                                                                                                                                    : this$heatNoAndBatchNo.equals(
                                                                                                                                       other$heatNoAndBatchNo
                                                                                                                                    )) {
                                                                                                                                    Object this$specification = this.getSpecification();
                                                                                                                                    Object other$specification = other.getSpecification();
                                                                                                                                    if (this$specification
                                                                                                                                          == null
                                                                                                                                       ? other$specification
                                                                                                                                          == null
                                                                                                                                       : this$specification.equals(
                                                                                                                                          other$specification
                                                                                                                                       )) {
                                                                                                                                       Object this$color = this.getColor();
                                                                                                                                       Object other$color = other.getColor();
                                                                                                                                       if (this$color == null
                                                                                                                                          ? other$color == null
                                                                                                                                          : this$color.equals(
                                                                                                                                             other$color
                                                                                                                                          )) {
                                                                                                                                          Object this$brand = this.getBrand();
                                                                                                                                          Object other$brand = other.getBrand();
                                                                                                                                          if (this$brand
                                                                                                                                                == null
                                                                                                                                             ? other$brand
                                                                                                                                                == null
                                                                                                                                             : this$brand.equals(
                                                                                                                                                other$brand
                                                                                                                                             )) {
                                                                                                                                             Object this$serialNumber = this.getSerialNumber();
                                                                                                                                             Object other$serialNumber = other.getSerialNumber();
                                                                                                                                             if (this$serialNumber
                                                                                                                                                   == null
                                                                                                                                                ? other$serialNumber
                                                                                                                                                   == null
                                                                                                                                                : this$serialNumber.equals(
                                                                                                                                                   other$serialNumber
                                                                                                                                                )) {
                                                                                                                                                Object this$sourceWorkshopIds = this.getSourceWorkshopIds();
                                                                                                                                                Object other$sourceWorkshopIds = other.getSourceWorkshopIds();
                                                                                                                                                if (this$sourceWorkshopIds
                                                                                                                                                      == null
                                                                                                                                                   ? other$sourceWorkshopIds
                                                                                                                                                      == null
                                                                                                                                                   : this$sourceWorkshopIds.equals(
                                                                                                                                                      other$sourceWorkshopIds
                                                                                                                                                   )) {
                                                                                                                                                   Object this$outboundSn = this.getOutboundSN();
                                                                                                                                                   Object other$outboundSn = other.getOutboundSN();
                                                                                                                                                   return this$outboundSn
                                                                                                                                                         == null
                                                                                                                                                      ? other$outboundSn
                                                                                                                                                         == null
                                                                                                                                                      : this$outboundSn.equals(
                                                                                                                                                         other$outboundSn
                                                                                                                                                      );
                                                                                                                                                } else {
                                                                                                                                                   return false;
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                return false;
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             return false;
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          return false;
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       return false;
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    return false;
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 return false;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              return false;
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           return false;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        return false;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     return false;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  return false;
                                                                                                               }
                                                                                                            } else {
                                                                                                               return false;
                                                                                                            }
                                                                                                         } else {
                                                                                                            return false;
                                                                                                         }
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getTimeType();
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $orderSupplyType = this.getOrderSupplyType();
      result = result * 59 + ($orderSupplyType == null ? 43 : $orderSupplyType.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $outReviewStatus = this.getOutReviewStatus();
      result = result * 59 + ($outReviewStatus == null ? 43 : $outReviewStatus.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $sourceProjectId = this.getSourceProjectId();
      result = result * 59 + ($sourceProjectId == null ? 43 : $sourceProjectId.hashCode());
      Object $directionProjectId = this.getDirectionProjectId();
      result = result * 59 + ($directionProjectId == null ? 43 : $directionProjectId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $sourceWorkshopId = this.getSourceWorkshopId();
      result = result * 59 + ($sourceWorkshopId == null ? 43 : $sourceWorkshopId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $functionType = this.getFunctionType();
      result = result * 59 + ($functionType == null ? 43 : $functionType.hashCode());
      Object $transferType = this.getTransferType();
      result = result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
      Object $boolScheduling = this.getBoolScheduling();
      result = result * 59 + ($boolScheduling == null ? 43 : $boolScheduling.hashCode());
      Object $transferCreateType = this.getTransferCreateType();
      result = result * 59 + ($transferCreateType == null ? 43 : $transferCreateType.hashCode());
      Object $detailIds = this.getDetailIds();
      result = result * 59 + ($detailIds == null ? 43 : $detailIds.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $materialOutboundTime = this.getMaterialOutboundTime();
      result = result * 59 + ($materialOutboundTime == null ? 43 : $materialOutboundTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $returnTime = this.getReturnTime();
      result = result * 59 + ($returnTime == null ? 43 : $returnTime.hashCode());
      Object $realTime = this.getRealTime();
      result = result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
      Object $outboundSN = this.getOutboundSN();
      result = result * 59 + ($outboundSN == null ? 43 : $outboundSN.hashCode());
      Object $transferSN = this.getTransferSN();
      result = result * 59 + ($transferSN == null ? 43 : $transferSN.hashCode());
      Object $moveMaterialSN = this.getMoveMaterialSN();
      result = result * 59 + ($moveMaterialSN == null ? 43 : $moveMaterialSN.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $minLength = this.getMinLength();
      result = result * 59 + ($minLength == null ? 43 : $minLength.hashCode());
      Object $maxLength = this.getMaxLength();
      result = result * 59 + ($maxLength == null ? 43 : $maxLength.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $sourceWorkshopIds = this.getSourceWorkshopIds();
      result = result * 59 + ($sourceWorkshopIds == null ? 43 : $sourceWorkshopIds.hashCode());
      Object $outboundSn = this.getOutboundSN();
      return result * 59 + ($outboundSn == null ? 43 : $outboundSn.hashCode());
   }

   @Override
   public String toString() {
      return "QueryDetailDTOParam(detailIds="
         + this.getDetailIds()
         + ", basicClass="
         + this.getBasicClass()
         + ", orderSupplyType="
         + this.getOrderSupplyType()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", materialOutboundTime="
         + this.getMaterialOutboundTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", timeType="
         + this.getTimeType()
         + ", returnTime="
         + this.getReturnTime()
         + ", realTime="
         + this.getRealTime()
         + ", outboundSN="
         + this.getOutboundSN()
         + ", transferSN="
         + this.getTransferSN()
         + ", moveMaterialSN="
         + this.getMoveMaterialSN()
         + ", recipientId="
         + this.getRecipientId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", outReviewStatus="
         + this.getOutReviewStatus()
         + ", operatorName="
         + this.getOperatorName()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", projectId="
         + this.getProjectId()
         + ", projectIds="
         + this.getProjectIds()
         + ", minLength="
         + this.getMinLength()
         + ", maxLength="
         + this.getMaxLength()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", thickness="
         + this.getThickness()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", specification="
         + this.getSpecification()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", factoryId="
         + this.getFactoryId()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", sourceProjectId="
         + this.getSourceProjectId()
         + ", directionProjectId="
         + this.getDirectionProjectId()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", sourceWorkshopId="
         + this.getSourceWorkshopId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", functionType="
         + this.getFunctionType()
         + ", transferType="
         + this.getTransferType()
         + ", boolScheduling="
         + this.getBoolScheduling()
         + ", sourceWorkshopIds="
         + this.getSourceWorkshopIds()
         + ", transferCreateType="
         + this.getTransferCreateType()
         + ", outboundSn="
         + this.getOutboundSN()
         + ")";
   }

   public QueryDetailDTOParam(
      final List<Long> detailIds,
      final Integer basicClass,
      final Integer orderSupplyType,
      final Long workshopId,
      final Long warehouseId,
      final Integer materialIsWhole,
      final List<LocalDateTime> outboundTime,
      final List<LocalDateTime> materialOutboundTime,
      final List<LocalDateTime> reviewTime,
      final int timeType,
      final List<LocalDateTime> returnTime,
      final List<LocalDateTime> realTime,
      final String outboundSN,
      final String transferSN,
      final String moveMaterialSN,
      final Long recipientId,
      final Long monomerId,
      final Long areaId,
      final Integer outReviewStatus,
      final String operatorName,
      final List<Long> classifyId,
      final List<Long> classifyIds,
      final Long projectId,
      final List<Long> projectIds,
      final BigDecimal minLength,
      final BigDecimal maxLength,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal theoryThickness,
      final BigDecimal thickness,
      final String heatNoAndBatchNo,
      final String specification,
      final String color,
      final String brand,
      final Integer projectWarehouseType,
      final String serialNumber,
      final Long factoryId,
      final Integer outboundTypeSelection,
      final Long sourceProjectId,
      final Long directionProjectId,
      final Integer weightMeasurementMode,
      final Long sourceWorkshopId,
      final Long branchCompanyId,
      final Integer functionType,
      final Integer transferType,
      final Boolean boolScheduling,
      final List<Long> sourceWorkshopIds,
      final Integer transferCreateType,
      final String outboundSn
   ) {
      this.detailIds = detailIds;
      this.basicClass = basicClass;
      this.orderSupplyType = orderSupplyType;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.materialIsWhole = materialIsWhole;
      this.outboundTime = outboundTime;
      this.materialOutboundTime = materialOutboundTime;
      this.reviewTime = reviewTime;
      this.timeType = timeType;
      this.returnTime = returnTime;
      this.realTime = realTime;
      this.outboundSN = outboundSN;
      this.transferSN = transferSN;
      this.moveMaterialSN = moveMaterialSN;
      this.recipientId = recipientId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.outReviewStatus = outReviewStatus;
      this.operatorName = operatorName;
      this.classifyId = classifyId;
      this.classifyIds = classifyIds;
      this.projectId = projectId;
      this.projectIds = projectIds;
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.length = length;
      this.width = width;
      this.theoryThickness = theoryThickness;
      this.thickness = thickness;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.specification = specification;
      this.color = color;
      this.brand = brand;
      this.projectWarehouseType = projectWarehouseType;
      this.serialNumber = serialNumber;
      this.factoryId = factoryId;
      this.outboundTypeSelection = outboundTypeSelection;
      this.sourceProjectId = sourceProjectId;
      this.directionProjectId = directionProjectId;
      this.weightMeasurementMode = weightMeasurementMode;
      this.sourceWorkshopId = sourceWorkshopId;
      this.branchCompanyId = branchCompanyId;
      this.functionType = functionType;
      this.transferType = transferType;
      this.boolScheduling = boolScheduling;
      this.sourceWorkshopIds = sourceWorkshopIds;
      this.transferCreateType = transferCreateType;
      this.outboundSn = outboundSn;
   }

   public QueryDetailDTOParam() {
   }

   public static class QueryDetailDTOParamBuilder {
      private List<Long> detailIds;
      private Integer basicClass;
      private Integer orderSupplyType;
      private Long workshopId;
      private Long warehouseId;
      private Integer materialIsWhole;
      private List<LocalDateTime> outboundTime;
      private List<LocalDateTime> materialOutboundTime;
      private List<LocalDateTime> reviewTime;
      private int timeType;
      private List<LocalDateTime> returnTime;
      private List<LocalDateTime> realTime;
      private String outboundSN;
      private String transferSN;
      private String moveMaterialSN;
      private Long recipientId;
      private Long monomerId;
      private Long areaId;
      private Integer outReviewStatus;
      private String operatorName;
      private List<Long> classifyId;
      private List<Long> classifyIds;
      private Long projectId;
      private List<Long> projectIds;
      private BigDecimal minLength;
      private BigDecimal maxLength;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal theoryThickness;
      private BigDecimal thickness;
      private String heatNoAndBatchNo;
      private String specification;
      private String color;
      private String brand;
      private Integer projectWarehouseType;
      private String serialNumber;
      private Long factoryId;
      private Integer outboundTypeSelection;
      private Long sourceProjectId;
      private Long directionProjectId;
      private Integer weightMeasurementMode;
      private Long sourceWorkshopId;
      private Long branchCompanyId;
      private Integer functionType;
      private Integer transferType;
      private Boolean boolScheduling;
      private List<Long> sourceWorkshopIds;
      private Integer transferCreateType;
      private String outboundSn;

      QueryDetailDTOParamBuilder() {
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder detailIds(final List<Long> detailIds) {
         this.detailIds = detailIds;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder orderSupplyType(final Integer orderSupplyType) {
         this.orderSupplyType = orderSupplyType;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder outboundTime(final List<LocalDateTime> outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder materialOutboundTime(final List<LocalDateTime> materialOutboundTime) {
         this.materialOutboundTime = materialOutboundTime;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder reviewTime(final List<LocalDateTime> reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder timeType(final int timeType) {
         this.timeType = timeType;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder returnTime(final List<LocalDateTime> returnTime) {
         this.returnTime = returnTime;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder realTime(final List<LocalDateTime> realTime) {
         this.realTime = realTime;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder outboundSN(final String outboundSN) {
         this.outboundSN = outboundSN;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder transferSN(final String transferSN) {
         this.transferSN = transferSN;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder moveMaterialSN(final String moveMaterialSN) {
         this.moveMaterialSN = moveMaterialSN;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder outReviewStatus(final Integer outReviewStatus) {
         this.outReviewStatus = outReviewStatus;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder classifyId(final List<Long> classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder minLength(final BigDecimal minLength) {
         this.minLength = minLength;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder maxLength(final BigDecimal maxLength) {
         this.maxLength = maxLength;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder sourceProjectId(final Long sourceProjectId) {
         this.sourceProjectId = sourceProjectId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder directionProjectId(final Long directionProjectId) {
         this.directionProjectId = directionProjectId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder sourceWorkshopId(final Long sourceWorkshopId) {
         this.sourceWorkshopId = sourceWorkshopId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder functionType(final Integer functionType) {
         this.functionType = functionType;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder transferType(final Integer transferType) {
         this.transferType = transferType;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder boolScheduling(final Boolean boolScheduling) {
         this.boolScheduling = boolScheduling;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder sourceWorkshopIds(final List<Long> sourceWorkshopIds) {
         this.sourceWorkshopIds = sourceWorkshopIds;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder transferCreateType(final Integer transferCreateType) {
         this.transferCreateType = transferCreateType;
         return this;
      }

      public QueryDetailDTOParam.QueryDetailDTOParamBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      public QueryDetailDTOParam build() {
         return new QueryDetailDTOParam(
            this.detailIds,
            this.basicClass,
            this.orderSupplyType,
            this.workshopId,
            this.warehouseId,
            this.materialIsWhole,
            this.outboundTime,
            this.materialOutboundTime,
            this.reviewTime,
            this.timeType,
            this.returnTime,
            this.realTime,
            this.outboundSN,
            this.transferSN,
            this.moveMaterialSN,
            this.recipientId,
            this.monomerId,
            this.areaId,
            this.outReviewStatus,
            this.operatorName,
            this.classifyId,
            this.classifyIds,
            this.projectId,
            this.projectIds,
            this.minLength,
            this.maxLength,
            this.length,
            this.width,
            this.theoryThickness,
            this.thickness,
            this.heatNoAndBatchNo,
            this.specification,
            this.color,
            this.brand,
            this.projectWarehouseType,
            this.serialNumber,
            this.factoryId,
            this.outboundTypeSelection,
            this.sourceProjectId,
            this.directionProjectId,
            this.weightMeasurementMode,
            this.sourceWorkshopId,
            this.branchCompanyId,
            this.functionType,
            this.transferType,
            this.boolScheduling,
            this.sourceWorkshopIds,
            this.transferCreateType,
            this.outboundSn
         );
      }

      @Override
      public String toString() {
         return "QueryDetailDTOParam.QueryDetailDTOParamBuilder(detailIds="
            + this.detailIds
            + ", basicClass="
            + this.basicClass
            + ", orderSupplyType="
            + this.orderSupplyType
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", outboundTime="
            + this.outboundTime
            + ", materialOutboundTime="
            + this.materialOutboundTime
            + ", reviewTime="
            + this.reviewTime
            + ", timeType="
            + this.timeType
            + ", returnTime="
            + this.returnTime
            + ", realTime="
            + this.realTime
            + ", outboundSN="
            + this.outboundSN
            + ", transferSN="
            + this.transferSN
            + ", moveMaterialSN="
            + this.moveMaterialSN
            + ", recipientId="
            + this.recipientId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", outReviewStatus="
            + this.outReviewStatus
            + ", operatorName="
            + this.operatorName
            + ", classifyId="
            + this.classifyId
            + ", classifyIds="
            + this.classifyIds
            + ", projectId="
            + this.projectId
            + ", projectIds="
            + this.projectIds
            + ", minLength="
            + this.minLength
            + ", maxLength="
            + this.maxLength
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", theoryThickness="
            + this.theoryThickness
            + ", thickness="
            + this.thickness
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", specification="
            + this.specification
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ", serialNumber="
            + this.serialNumber
            + ", factoryId="
            + this.factoryId
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", sourceProjectId="
            + this.sourceProjectId
            + ", directionProjectId="
            + this.directionProjectId
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", sourceWorkshopId="
            + this.sourceWorkshopId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", functionType="
            + this.functionType
            + ", transferType="
            + this.transferType
            + ", boolScheduling="
            + this.boolScheduling
            + ", sourceWorkshopIds="
            + this.sourceWorkshopIds
            + ", transferCreateType="
            + this.transferCreateType
            + ", outboundSn="
            + this.outboundSn
            + ")";
      }
   }
}

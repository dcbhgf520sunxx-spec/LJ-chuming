package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "物流信息")
public class MesEnclosureCargoListDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "transportMode", value = "运输方式 1运送到场 2客户自提", notes = "运输方式 1运送到场 2客户自提")
   private Integer transportMode;
   @ApiModelProperty(name = "structureMeasureMode", value = "结构计量方式 1理论计算 2磅记", notes = "结构计量方式 1理论计算 2磅记")
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "enclosureMeasureMode", value = "围护计量方式 1 长度计量 2 面积计量", notes = "围护计量方式 1 长度计量 2 面积计量")
   private Integer enclosureMeasureMode;
   @ApiModelProperty(name = "supplierPriceId", value = "物流单位价格id", notes = "物流单位价格id")
   private Long supplierPriceId;
   @ApiModelProperty(name = "manufactureType", value = "制造类型 自制,2外包", notes = "制造类型 自制,2外包")
   private Integer manufactureType;
   @ApiModelProperty(name = "productType", value = "装载类型", notes = "装载类型")
   private Integer productType;
   @ApiModelProperty(name = "serialNumber", value = "车次编号", notes = "车次编号")
   private String serialNumber;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "carModel", value = "车型", notes = "车型")
   private String carModel;
   @ApiModelProperty(name = "driverName", value = "司机姓名", notes = "司机姓名")
   private String driverName;
   @ApiModelProperty(name = "driverPhone", value = "司机电话", notes = "司机电话")
   private String driverPhone;
   @ApiModelProperty(name = "receiptName", value = "接收人", notes = "接收人")
   private String receiptName;
   @ApiModelProperty(name = "receiptPhone", value = "接收人电话", notes = "接收人电话")
   private String receiptPhone;
   @ApiModelProperty(name = "quantity", value = "总数", notes = "总数")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重量", notes = "总净重量")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重量", notes = "总毛重量")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "actualWeight", value = "过磅净量", notes = "过磅净量")
   private BigDecimal actualWeight;
   @ApiModelProperty(name = "actualGrossWeight", value = "过磅毛重", notes = "过磅毛重")
   private BigDecimal actualGrossWeight;
   @ApiModelProperty(name = "status", value = "发运状态 [1 装车, 2 过磅，4发运，8收货 16 未装车]", notes = "发运状态 [1 装车, 2 过磅，4发运，8收货 16 未装车]")
   private Integer status;
   @ApiModelProperty(name = "userId", value = "装车人id", notes = "装车人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "装车人名称", notes = "装车人名称")
   private String userName;
   @ApiModelProperty(name = "actualUserId", value = "过磅人id", notes = "过磅人id")
   private Long actualUserId;
   @ApiModelProperty(name = "actualUserName", value = "过磅人名称", notes = "过磅人名称")
   private String actualUserName;
   @ApiModelProperty(name = "actualTime", value = "过磅日期", notes = "过磅日期")
   private LocalDateTime actualTime;
   @ApiModelProperty(name = "auditUserId", value = "发运审核人id", notes = "发运审核人id")
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "发运审核人名称", notes = "发运审核人名称")
   private String auditUserName;
   @ApiModelProperty(name = "auditTime", value = "发运审核时间", notes = "发运审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditReceiptId", value = "实际收货人id", notes = "实际收货人id")
   private Long auditReceiptId;
   @ApiModelProperty(name = "auditReceiptName", value = "实际收货人名称", notes = "实际收货人名称")
   private String auditReceiptName;
   @ApiModelProperty(name = "auditReceiptTime", value = "收货日期", notes = "收货日期")
   private LocalDateTime auditReceiptTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   private Integer category;
   @ApiModelProperty(name = "boolProblemReceiving", value = "是否问题收货 1问题收货 0正常收货 ", notes = "是否问题收货 1问题收货 0正常收货")
   private Boolean boolProblemReceiving;
   @ApiModelProperty(name = "problemDesc", value = "问题收货描述 ", notes = "问题收货描述")
   private String problemDesc;
   @ApiModelProperty(name = "totalPrice", value = "运输费 ", notes = "运输费")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "price", value = "单价 ", notes = "单价")
   private BigDecimal price;
   @ApiModelProperty(name = "priceType", value = "计价方式 ", notes = "计价方式")
   private Integer priceType;
   @ApiModelProperty(name = "deliveryStatus", value = "发运状态(发运记录) ", notes = "发运状态(发运记录)")
   private Integer deliveryStatus;
   @ApiModelProperty(name = "shipmentStatus", value = "发运状态(收货记录) ", notes = "发运状态(收货记录)")
   private Integer shipmentStatus;
   @ApiModelProperty(name = "statusUpdateDate", value = "状态更新日期", notes = "状态更新日期")
   private LocalDateTime statusUpdateDate;
   @ApiModelProperty(name = "emptyCars", value = "空车重量 ", notes = "空车重量")
   private BigDecimal emptyCars;

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getTransportMode() {
      return this.transportMode;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public Integer getEnclosureMeasureMode() {
      return this.enclosureMeasureMode;
   }

   public Long getSupplierPriceId() {
      return this.supplierPriceId;
   }

   public Integer getManufactureType() {
      return this.manufactureType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getCarModel() {
      return this.carModel;
   }

   public String getDriverName() {
      return this.driverName;
   }

   public String getDriverPhone() {
      return this.driverPhone;
   }

   public String getReceiptName() {
      return this.receiptName;
   }

   public String getReceiptPhone() {
      return this.receiptPhone;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getActualWeight() {
      return this.actualWeight;
   }

   public BigDecimal getActualGrossWeight() {
      return this.actualGrossWeight;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getActualUserId() {
      return this.actualUserId;
   }

   public String getActualUserName() {
      return this.actualUserName;
   }

   public LocalDateTime getActualTime() {
      return this.actualTime;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getAuditReceiptId() {
      return this.auditReceiptId;
   }

   public String getAuditReceiptName() {
      return this.auditReceiptName;
   }

   public LocalDateTime getAuditReceiptTime() {
      return this.auditReceiptTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Boolean getBoolProblemReceiving() {
      return this.boolProblemReceiving;
   }

   public String getProblemDesc() {
      return this.problemDesc;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public Integer getDeliveryStatus() {
      return this.deliveryStatus;
   }

   public Integer getShipmentStatus() {
      return this.shipmentStatus;
   }

   public LocalDateTime getStatusUpdateDate() {
      return this.statusUpdateDate;
   }

   public BigDecimal getEmptyCars() {
      return this.emptyCars;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
   }

   public void setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
   }

   public void setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
   }

   public void setSupplierPriceId(final Long supplierPriceId) {
      this.supplierPriceId = supplierPriceId;
   }

   public void setManufactureType(final Integer manufactureType) {
      this.manufactureType = manufactureType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setCarModel(final String carModel) {
      this.carModel = carModel;
   }

   public void setDriverName(final String driverName) {
      this.driverName = driverName;
   }

   public void setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
   }

   public void setReceiptName(final String receiptName) {
      this.receiptName = receiptName;
   }

   public void setReceiptPhone(final String receiptPhone) {
      this.receiptPhone = receiptPhone;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
   }

   public void setActualGrossWeight(final BigDecimal actualGrossWeight) {
      this.actualGrossWeight = actualGrossWeight;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setActualUserId(final Long actualUserId) {
      this.actualUserId = actualUserId;
   }

   public void setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
   }

   public void setActualTime(final LocalDateTime actualTime) {
      this.actualTime = actualTime;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setAuditReceiptId(final Long auditReceiptId) {
      this.auditReceiptId = auditReceiptId;
   }

   public void setAuditReceiptName(final String auditReceiptName) {
      this.auditReceiptName = auditReceiptName;
   }

   public void setAuditReceiptTime(final LocalDateTime auditReceiptTime) {
      this.auditReceiptTime = auditReceiptTime;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setBoolProblemReceiving(final Boolean boolProblemReceiving) {
      this.boolProblemReceiving = boolProblemReceiving;
   }

   public void setProblemDesc(final String problemDesc) {
      this.problemDesc = problemDesc;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
   }

   public void setDeliveryStatus(final Integer deliveryStatus) {
      this.deliveryStatus = deliveryStatus;
   }

   public void setShipmentStatus(final Integer shipmentStatus) {
      this.shipmentStatus = shipmentStatus;
   }

   public void setStatusUpdateDate(final LocalDateTime statusUpdateDate) {
      this.statusUpdateDate = statusUpdateDate;
   }

   public void setEmptyCars(final BigDecimal emptyCars) {
      this.emptyCars = emptyCars;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureCargoListDTO)) {
         return false;
      }

      MesEnclosureCargoListDTO other = (MesEnclosureCargoListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$transportMode = this.getTransportMode();
            Object other$transportMode = other.getTransportMode();
            if (this$transportMode == null ? other$transportMode == null : this$transportMode.equals(other$transportMode)) {
               Object this$structureMeasureMode = this.getStructureMeasureMode();
               Object other$structureMeasureMode = other.getStructureMeasureMode();
               if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
                  Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
                  Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
                  if (this$enclosureMeasureMode == null ? other$enclosureMeasureMode == null : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
                     Object this$supplierPriceId = this.getSupplierPriceId();
                     Object other$supplierPriceId = other.getSupplierPriceId();
                     if (this$supplierPriceId == null ? other$supplierPriceId == null : this$supplierPriceId.equals(other$supplierPriceId)) {
                        Object this$manufactureType = this.getManufactureType();
                        Object other$manufactureType = other.getManufactureType();
                        if (this$manufactureType == null ? other$manufactureType == null : this$manufactureType.equals(other$manufactureType)) {
                           Object this$productType = this.getProductType();
                           Object other$productType = other.getProductType();
                           if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$status = this.getStatus();
                                 Object other$status = other.getStatus();
                                 if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$actualUserId = this.getActualUserId();
                                       Object other$actualUserId = other.getActualUserId();
                                       if (this$actualUserId == null ? other$actualUserId == null : this$actualUserId.equals(other$actualUserId)) {
                                          Object this$auditUserId = this.getAuditUserId();
                                          Object other$auditUserId = other.getAuditUserId();
                                          if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                                             Object this$auditReceiptId = this.getAuditReceiptId();
                                             Object other$auditReceiptId = other.getAuditReceiptId();
                                             if (this$auditReceiptId == null ? other$auditReceiptId == null : this$auditReceiptId.equals(other$auditReceiptId)) {
                                                Object this$category = this.getCategory();
                                                Object other$category = other.getCategory();
                                                if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                                   Object this$boolProblemReceiving = this.getBoolProblemReceiving();
                                                   Object other$boolProblemReceiving = other.getBoolProblemReceiving();
                                                   if (this$boolProblemReceiving == null
                                                      ? other$boolProblemReceiving == null
                                                      : this$boolProblemReceiving.equals(other$boolProblemReceiving)) {
                                                      Object this$priceType = this.getPriceType();
                                                      Object other$priceType = other.getPriceType();
                                                      if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
                                                         Object this$deliveryStatus = this.getDeliveryStatus();
                                                         Object other$deliveryStatus = other.getDeliveryStatus();
                                                         if (this$deliveryStatus == null
                                                            ? other$deliveryStatus == null
                                                            : this$deliveryStatus.equals(other$deliveryStatus)) {
                                                            Object this$shipmentStatus = this.getShipmentStatus();
                                                            Object other$shipmentStatus = other.getShipmentStatus();
                                                            if (this$shipmentStatus == null
                                                               ? other$shipmentStatus == null
                                                               : this$shipmentStatus.equals(other$shipmentStatus)) {
                                                               Object this$serialNumber = this.getSerialNumber();
                                                               Object other$serialNumber = other.getSerialNumber();
                                                               if (this$serialNumber == null
                                                                  ? other$serialNumber == null
                                                                  : this$serialNumber.equals(other$serialNumber)) {
                                                                  Object this$licensePlate = this.getLicensePlate();
                                                                  Object other$licensePlate = other.getLicensePlate();
                                                                  if (this$licensePlate == null
                                                                     ? other$licensePlate == null
                                                                     : this$licensePlate.equals(other$licensePlate)) {
                                                                     Object this$carModel = this.getCarModel();
                                                                     Object other$carModel = other.getCarModel();
                                                                     if (this$carModel == null ? other$carModel == null : this$carModel.equals(other$carModel)) {
                                                                        Object this$driverName = this.getDriverName();
                                                                        Object other$driverName = other.getDriverName();
                                                                        if (this$driverName == null
                                                                           ? other$driverName == null
                                                                           : this$driverName.equals(other$driverName)) {
                                                                           Object this$driverPhone = this.getDriverPhone();
                                                                           Object other$driverPhone = other.getDriverPhone();
                                                                           if (this$driverPhone == null
                                                                              ? other$driverPhone == null
                                                                              : this$driverPhone.equals(other$driverPhone)) {
                                                                              Object this$receiptName = this.getReceiptName();
                                                                              Object other$receiptName = other.getReceiptName();
                                                                              if (this$receiptName == null
                                                                                 ? other$receiptName == null
                                                                                 : this$receiptName.equals(other$receiptName)) {
                                                                                 Object this$receiptPhone = this.getReceiptPhone();
                                                                                 Object other$receiptPhone = other.getReceiptPhone();
                                                                                 if (this$receiptPhone == null
                                                                                    ? other$receiptPhone == null
                                                                                    : this$receiptPhone.equals(other$receiptPhone)) {
                                                                                    Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                    Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                    if (this$totalNetWeight == null
                                                                                       ? other$totalNetWeight == null
                                                                                       : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                                       Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                                       Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                                       if (this$totalGrossWeight == null
                                                                                          ? other$totalGrossWeight == null
                                                                                          : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                                          Object this$actualWeight = this.getActualWeight();
                                                                                          Object other$actualWeight = other.getActualWeight();
                                                                                          if (this$actualWeight == null
                                                                                             ? other$actualWeight == null
                                                                                             : this$actualWeight.equals(other$actualWeight)) {
                                                                                             Object this$actualGrossWeight = this.getActualGrossWeight();
                                                                                             Object other$actualGrossWeight = other.getActualGrossWeight();
                                                                                             if (this$actualGrossWeight == null
                                                                                                ? other$actualGrossWeight == null
                                                                                                : this$actualGrossWeight.equals(other$actualGrossWeight)) {
                                                                                                Object this$userName = this.getUserName();
                                                                                                Object other$userName = other.getUserName();
                                                                                                if (this$userName == null
                                                                                                   ? other$userName == null
                                                                                                   : this$userName.equals(other$userName)) {
                                                                                                   Object this$actualUserName = this.getActualUserName();
                                                                                                   Object other$actualUserName = other.getActualUserName();
                                                                                                   if (this$actualUserName == null
                                                                                                      ? other$actualUserName == null
                                                                                                      : this$actualUserName.equals(other$actualUserName)) {
                                                                                                      Object this$actualTime = this.getActualTime();
                                                                                                      Object other$actualTime = other.getActualTime();
                                                                                                      if (this$actualTime == null
                                                                                                         ? other$actualTime == null
                                                                                                         : this$actualTime.equals(other$actualTime)) {
                                                                                                         Object this$auditUserName = this.getAuditUserName();
                                                                                                         Object other$auditUserName = other.getAuditUserName();
                                                                                                         if (this$auditUserName == null
                                                                                                            ? other$auditUserName == null
                                                                                                            : this$auditUserName.equals(other$auditUserName)) {
                                                                                                            Object this$auditTime = this.getAuditTime();
                                                                                                            Object other$auditTime = other.getAuditTime();
                                                                                                            if (this$auditTime == null
                                                                                                               ? other$auditTime == null
                                                                                                               : this$auditTime.equals(other$auditTime)) {
                                                                                                               Object this$auditReceiptName = this.getAuditReceiptName();
                                                                                                               Object other$auditReceiptName = other.getAuditReceiptName();
                                                                                                               if (this$auditReceiptName == null
                                                                                                                  ? other$auditReceiptName == null
                                                                                                                  : this$auditReceiptName.equals(
                                                                                                                     other$auditReceiptName
                                                                                                                  )) {
                                                                                                                  Object this$auditReceiptTime = this.getAuditReceiptTime();
                                                                                                                  Object other$auditReceiptTime = other.getAuditReceiptTime();
                                                                                                                  if (this$auditReceiptTime == null
                                                                                                                     ? other$auditReceiptTime == null
                                                                                                                     : this$auditReceiptTime.equals(
                                                                                                                        other$auditReceiptTime
                                                                                                                     )) {
                                                                                                                     Object this$remark = this.getRemark();
                                                                                                                     Object other$remark = other.getRemark();
                                                                                                                     if (this$remark == null
                                                                                                                        ? other$remark == null
                                                                                                                        : this$remark.equals(other$remark)) {
                                                                                                                        Object this$problemDesc = this.getProblemDesc();
                                                                                                                        Object other$problemDesc = other.getProblemDesc();
                                                                                                                        if (this$problemDesc == null
                                                                                                                           ? other$problemDesc == null
                                                                                                                           : this$problemDesc.equals(
                                                                                                                              other$problemDesc
                                                                                                                           )) {
                                                                                                                           Object this$totalPrice = this.getTotalPrice();
                                                                                                                           Object other$totalPrice = other.getTotalPrice();
                                                                                                                           if (this$totalPrice == null
                                                                                                                              ? other$totalPrice == null
                                                                                                                              : this$totalPrice.equals(
                                                                                                                                 other$totalPrice
                                                                                                                              )) {
                                                                                                                              Object this$price = this.getPrice();
                                                                                                                              Object other$price = other.getPrice();
                                                                                                                              if (this$price == null
                                                                                                                                 ? other$price == null
                                                                                                                                 : this$price.equals(
                                                                                                                                    other$price
                                                                                                                                 )) {
                                                                                                                                 Object this$statusUpdateDate = this.getStatusUpdateDate();
                                                                                                                                 Object other$statusUpdateDate = other.getStatusUpdateDate();
                                                                                                                                 if (this$statusUpdateDate
                                                                                                                                       == null
                                                                                                                                    ? other$statusUpdateDate
                                                                                                                                       == null
                                                                                                                                    : this$statusUpdateDate.equals(
                                                                                                                                       other$statusUpdateDate
                                                                                                                                    )) {
                                                                                                                                    Object this$emptyCars = this.getEmptyCars();
                                                                                                                                    Object other$emptyCars = other.getEmptyCars();
                                                                                                                                    return this$emptyCars
                                                                                                                                          == null
                                                                                                                                       ? other$emptyCars
                                                                                                                                          == null
                                                                                                                                       : this$emptyCars.equals(
                                                                                                                                          other$emptyCars
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureCargoListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $transportMode = this.getTransportMode();
      result = result * 59 + ($transportMode == null ? 43 : $transportMode.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $supplierPriceId = this.getSupplierPriceId();
      result = result * 59 + ($supplierPriceId == null ? 43 : $supplierPriceId.hashCode());
      Object $manufactureType = this.getManufactureType();
      result = result * 59 + ($manufactureType == null ? 43 : $manufactureType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $actualUserId = this.getActualUserId();
      result = result * 59 + ($actualUserId == null ? 43 : $actualUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditReceiptId = this.getAuditReceiptId();
      result = result * 59 + ($auditReceiptId == null ? 43 : $auditReceiptId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $boolProblemReceiving = this.getBoolProblemReceiving();
      result = result * 59 + ($boolProblemReceiving == null ? 43 : $boolProblemReceiving.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $deliveryStatus = this.getDeliveryStatus();
      result = result * 59 + ($deliveryStatus == null ? 43 : $deliveryStatus.hashCode());
      Object $shipmentStatus = this.getShipmentStatus();
      result = result * 59 + ($shipmentStatus == null ? 43 : $shipmentStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $carModel = this.getCarModel();
      result = result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $driverPhone = this.getDriverPhone();
      result = result * 59 + ($driverPhone == null ? 43 : $driverPhone.hashCode());
      Object $receiptName = this.getReceiptName();
      result = result * 59 + ($receiptName == null ? 43 : $receiptName.hashCode());
      Object $receiptPhone = this.getReceiptPhone();
      result = result * 59 + ($receiptPhone == null ? 43 : $receiptPhone.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $actualGrossWeight = this.getActualGrossWeight();
      result = result * 59 + ($actualGrossWeight == null ? 43 : $actualGrossWeight.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $actualUserName = this.getActualUserName();
      result = result * 59 + ($actualUserName == null ? 43 : $actualUserName.hashCode());
      Object $actualTime = this.getActualTime();
      result = result * 59 + ($actualTime == null ? 43 : $actualTime.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $auditReceiptName = this.getAuditReceiptName();
      result = result * 59 + ($auditReceiptName == null ? 43 : $auditReceiptName.hashCode());
      Object $auditReceiptTime = this.getAuditReceiptTime();
      result = result * 59 + ($auditReceiptTime == null ? 43 : $auditReceiptTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $problemDesc = this.getProblemDesc();
      result = result * 59 + ($problemDesc == null ? 43 : $problemDesc.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $statusUpdateDate = this.getStatusUpdateDate();
      result = result * 59 + ($statusUpdateDate == null ? 43 : $statusUpdateDate.hashCode());
      Object $emptyCars = this.getEmptyCars();
      return result * 59 + ($emptyCars == null ? 43 : $emptyCars.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureCargoListDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", transportMode="
         + this.getTransportMode()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", supplierPriceId="
         + this.getSupplierPriceId()
         + ", manufactureType="
         + this.getManufactureType()
         + ", productType="
         + this.getProductType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", carModel="
         + this.getCarModel()
         + ", driverName="
         + this.getDriverName()
         + ", driverPhone="
         + this.getDriverPhone()
         + ", receiptName="
         + this.getReceiptName()
         + ", receiptPhone="
         + this.getReceiptPhone()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", actualWeight="
         + this.getActualWeight()
         + ", actualGrossWeight="
         + this.getActualGrossWeight()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", actualUserId="
         + this.getActualUserId()
         + ", actualUserName="
         + this.getActualUserName()
         + ", actualTime="
         + this.getActualTime()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditReceiptId="
         + this.getAuditReceiptId()
         + ", auditReceiptName="
         + this.getAuditReceiptName()
         + ", auditReceiptTime="
         + this.getAuditReceiptTime()
         + ", remark="
         + this.getRemark()
         + ", category="
         + this.getCategory()
         + ", boolProblemReceiving="
         + this.getBoolProblemReceiving()
         + ", problemDesc="
         + this.getProblemDesc()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", price="
         + this.getPrice()
         + ", priceType="
         + this.getPriceType()
         + ", deliveryStatus="
         + this.getDeliveryStatus()
         + ", shipmentStatus="
         + this.getShipmentStatus()
         + ", statusUpdateDate="
         + this.getStatusUpdateDate()
         + ", emptyCars="
         + this.getEmptyCars()
         + ")";
   }
}

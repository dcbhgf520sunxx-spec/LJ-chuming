package com.hzchum.scim.scm.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ApplyPurchaseInboundDetailDTO {
   @ApiModelProperty(name = "inboundId", value = "入库单ID")
   private Long inboundId;
   @ApiModelProperty(name = "inboundSerialNumber", value = "入库单号")
   private String inboundSerialNumber;
   @ApiModelProperty(name = "purchaseSerialNumber", value = "采购单号")
   private String purchaseSerialNumber;
   @ApiModelProperty(name = "inboundDetailId", value = "入库详情表ID")
   private Long inboundDetailId;
   @ApiModelProperty(name = "basicClassEnum", value = "物料总类")
   private Integer basicClassEnum;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @ApiModelProperty(name = "unit", value = "计量单位")
   private String unit;
   @ApiModelProperty(name = "classifyId", value = "科目id")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "物料名称")
   private String classifyName;
   @ApiModelProperty(name = "supplier", value = "供应商信息")
   private SupplierAllBriefDTO supplier;
   @ApiModelProperty(name = "quantity", value = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "realityQuantity", value = "实际入库数量")
   private BigDecimal realityQuantity;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "mete", value = "核算量(在计量单位未设置时,数量=核算量)")
   private BigDecimal mete;
   @ApiModelProperty(name = "realityMete", value = "实际入库核算量")
   private BigDecimal realityMete;
   @ApiModelProperty(name = "price", value = "单价(含税不含运费)")
   private BigDecimal price;
   @ApiModelProperty(name = "amount", value = "金额(含税不含运费)")
   private BigDecimal amount;
   @ApiModelProperty(name = "priceExcludingVat", value = "不含税单价(不含运费)")
   private BigDecimal priceExcludingVat;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价(不含运费)")
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "rejectAmount", value = "退货金额")
   private BigDecimal rejectAmount;
   @ApiModelProperty(name = "differentAmount", value = "调整金额")
   private BigDecimal differentAmount;
   @ApiModelProperty(name = "applicantId", value = "办理人")
   private NameInfo applicant;
   @ApiModelProperty(name = "applicantDate", value = "办理人日期")
   private LocalDateTime applicantDate;
   @ApiModelProperty(name = "reviewerId", value = "审核人")
   private NameInfo reviewer;
   @ApiModelProperty(name = "reviewerDate", value = "审核人日期")
   private LocalDateTime reviewerDate;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "project", value = "入库项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "manufacturedName", value = "制成品名称")
   @JsonInclude(Include.NON_NULL)
   private String manufacturedName;
   @ApiModelProperty(name = "manufacturedSn", value = "制成品编号")
   @JsonInclude(Include.NON_NULL)
   private String manufacturedSn;
   @ApiModelProperty(
      name = "manufacturedType",
      value = "制成品类型 结构制品 ArtifactTypeEnum  围护制品 EnclosureCategoryEnum",
      notes = "制成品类型 结构制品 ArtifactTypeEnum  围护制品 EnclosureCategoryEnum"
   )
   @JsonInclude(Include.NON_NULL)
   private Integer manufacturedType;
   @ApiModelProperty(name = "wageQuotaType", value = "制成品计价方式 WmsWageQuotaTypeEnum", notes = "制成品计价方式 计价方式 WmsWageQuotaTypeEnum")
   @JsonInclude(Include.NON_NULL)
   private Integer wageQuotaType;
   @ApiModelProperty(name = "actualReceivedMete", value = "工地收货实际收货量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal actualReceivedMete;
   @ApiModelProperty(name = "rejectActualReceivedMete", value = "实际退货量")
   private BigDecimal rejectActualReceivedMete;
   @ApiModelProperty(name = "rejectQuantity", value = "退货数量 ", notes = "退货数量")
   private BigDecimal rejectQuantity;
   @ApiModelProperty(name = "rejectMete", value = "退货核算量 ", notes = "退货核算量")
   private BigDecimal rejectMete;
   @ApiModelProperty(name = "type", value = "类型 1入库明细 2制成品入库明细 3工地收货")
   private Integer type;
   @ApiModelProperty(name = "realityInboundAmount", value = "实际入库金额含税", notes = "实际入库金额含税")
   private BigDecimal realityInboundAmount;
   @ApiModelProperty(name = "finishedGoodsTypeName", value = "制成品分类", notes = "制成品分类")
   private String finishedGoodsTypeName;
   @ApiModelProperty(name = "material", value = "制成品材质", notes = "制成品材质")
   private String material;

   public static ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder builder() {
      return new ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder();
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public String getInboundSerialNumber() {
      return this.inboundSerialNumber;
   }

   public String getPurchaseSerialNumber() {
      return this.purchaseSerialNumber;
   }

   public Long getInboundDetailId() {
      return this.inboundDetailId;
   }

   public Integer getBasicClassEnum() {
      return this.basicClassEnum;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getUnit() {
      return this.unit;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public SupplierAllBriefDTO getSupplier() {
      return this.supplier;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getRealityQuantity() {
      return this.realityQuantity;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getRealityMete() {
      return this.realityMete;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getPriceExcludingVat() {
      return this.priceExcludingVat;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getRejectAmount() {
      return this.rejectAmount;
   }

   public BigDecimal getDifferentAmount() {
      return this.differentAmount;
   }

   public NameInfo getApplicant() {
      return this.applicant;
   }

   public LocalDateTime getApplicantDate() {
      return this.applicantDate;
   }

   public NameInfo getReviewer() {
      return this.reviewer;
   }

   public LocalDateTime getReviewerDate() {
      return this.reviewerDate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getManufacturedName() {
      return this.manufacturedName;
   }

   public String getManufacturedSn() {
      return this.manufacturedSn;
   }

   public Integer getManufacturedType() {
      return this.manufacturedType;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getActualReceivedMete() {
      return this.actualReceivedMete;
   }

   public BigDecimal getRejectActualReceivedMete() {
      return this.rejectActualReceivedMete;
   }

   public BigDecimal getRejectQuantity() {
      return this.rejectQuantity;
   }

   public BigDecimal getRejectMete() {
      return this.rejectMete;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getRealityInboundAmount() {
      return this.realityInboundAmount;
   }

   public String getFinishedGoodsTypeName() {
      return this.finishedGoodsTypeName;
   }

   public String getMaterial() {
      return this.material;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setInboundSerialNumber(final String inboundSerialNumber) {
      this.inboundSerialNumber = inboundSerialNumber;
   }

   public void setPurchaseSerialNumber(final String purchaseSerialNumber) {
      this.purchaseSerialNumber = purchaseSerialNumber;
   }

   public void setInboundDetailId(final Long inboundDetailId) {
      this.inboundDetailId = inboundDetailId;
   }

   public void setBasicClassEnum(final Integer basicClassEnum) {
      this.basicClassEnum = basicClassEnum;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSupplier(final SupplierAllBriefDTO supplier) {
      this.supplier = supplier;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setRealityQuantity(final BigDecimal realityQuantity) {
      this.realityQuantity = realityQuantity;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setRealityMete(final BigDecimal realityMete) {
      this.realityMete = realityMete;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setPriceExcludingVat(final BigDecimal priceExcludingVat) {
      this.priceExcludingVat = priceExcludingVat;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setRejectAmount(final BigDecimal rejectAmount) {
      this.rejectAmount = rejectAmount;
   }

   public void setDifferentAmount(final BigDecimal differentAmount) {
      this.differentAmount = differentAmount;
   }

   public void setApplicant(final NameInfo applicant) {
      this.applicant = applicant;
   }

   public void setApplicantDate(final LocalDateTime applicantDate) {
      this.applicantDate = applicantDate;
   }

   public void setReviewer(final NameInfo reviewer) {
      this.reviewer = reviewer;
   }

   public void setReviewerDate(final LocalDateTime reviewerDate) {
      this.reviewerDate = reviewerDate;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setManufacturedName(final String manufacturedName) {
      this.manufacturedName = manufacturedName;
   }

   public void setManufacturedSn(final String manufacturedSn) {
      this.manufacturedSn = manufacturedSn;
   }

   public void setManufacturedType(final Integer manufacturedType) {
      this.manufacturedType = manufacturedType;
   }

   public void setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
   }

   public void setActualReceivedMete(final BigDecimal actualReceivedMete) {
      this.actualReceivedMete = actualReceivedMete;
   }

   public void setRejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
      this.rejectActualReceivedMete = rejectActualReceivedMete;
   }

   public void setRejectQuantity(final BigDecimal rejectQuantity) {
      this.rejectQuantity = rejectQuantity;
   }

   public void setRejectMete(final BigDecimal rejectMete) {
      this.rejectMete = rejectMete;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setRealityInboundAmount(final BigDecimal realityInboundAmount) {
      this.realityInboundAmount = realityInboundAmount;
   }

   public void setFinishedGoodsTypeName(final String finishedGoodsTypeName) {
      this.finishedGoodsTypeName = finishedGoodsTypeName;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApplyPurchaseInboundDetailDTO)) {
         return false;
      }

      ApplyPurchaseInboundDetailDTO other = (ApplyPurchaseInboundDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inboundId = this.getInboundId();
      Object other$inboundId = other.getInboundId();
      if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
         Object this$inboundDetailId = this.getInboundDetailId();
         Object other$inboundDetailId = other.getInboundDetailId();
         if (this$inboundDetailId == null ? other$inboundDetailId == null : this$inboundDetailId.equals(other$inboundDetailId)) {
            Object this$basicClassEnum = this.getBasicClassEnum();
            Object other$basicClassEnum = other.getBasicClassEnum();
            if (this$basicClassEnum == null ? other$basicClassEnum == null : this$basicClassEnum.equals(other$basicClassEnum)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$manufacturedType = this.getManufacturedType();
                     Object other$manufacturedType = other.getManufacturedType();
                     if (this$manufacturedType == null ? other$manufacturedType == null : this$manufacturedType.equals(other$manufacturedType)) {
                        Object this$wageQuotaType = this.getWageQuotaType();
                        Object other$wageQuotaType = other.getWageQuotaType();
                        if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                           Object this$type = this.getType();
                           Object other$type = other.getType();
                           if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                              Object this$inboundSerialNumber = this.getInboundSerialNumber();
                              Object other$inboundSerialNumber = other.getInboundSerialNumber();
                              if (this$inboundSerialNumber == null
                                 ? other$inboundSerialNumber == null
                                 : this$inboundSerialNumber.equals(other$inboundSerialNumber)) {
                                 Object this$purchaseSerialNumber = this.getPurchaseSerialNumber();
                                 Object other$purchaseSerialNumber = other.getPurchaseSerialNumber();
                                 if (this$purchaseSerialNumber == null
                                    ? other$purchaseSerialNumber == null
                                    : this$purchaseSerialNumber.equals(other$purchaseSerialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$brand = this.getBrand();
                                       Object other$brand = other.getBrand();
                                       if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                          Object this$color = this.getColor();
                                          Object other$color = other.getColor();
                                          if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                             Object this$unit = this.getUnit();
                                             Object other$unit = other.getUnit();
                                             if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                                Object this$classifyName = this.getClassifyName();
                                                Object other$classifyName = other.getClassifyName();
                                                if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                                   Object this$supplier = this.getSupplier();
                                                   Object other$supplier = other.getSupplier();
                                                   if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                                                      Object this$quantity = this.getQuantity();
                                                      Object other$quantity = other.getQuantity();
                                                      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                         Object this$realityQuantity = this.getRealityQuantity();
                                                         Object other$realityQuantity = other.getRealityQuantity();
                                                         if (this$realityQuantity == null
                                                            ? other$realityQuantity == null
                                                            : this$realityQuantity.equals(other$realityQuantity)) {
                                                            Object this$accountingUnit = this.getAccountingUnit();
                                                            Object other$accountingUnit = other.getAccountingUnit();
                                                            if (this$accountingUnit == null
                                                               ? other$accountingUnit == null
                                                               : this$accountingUnit.equals(other$accountingUnit)) {
                                                               Object this$mete = this.getMete();
                                                               Object other$mete = other.getMete();
                                                               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                  Object this$realityMete = this.getRealityMete();
                                                                  Object other$realityMete = other.getRealityMete();
                                                                  if (this$realityMete == null
                                                                     ? other$realityMete == null
                                                                     : this$realityMete.equals(other$realityMete)) {
                                                                     Object this$price = this.getPrice();
                                                                     Object other$price = other.getPrice();
                                                                     if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                                        Object this$amount = this.getAmount();
                                                                        Object other$amount = other.getAmount();
                                                                        if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                           Object this$priceExcludingVat = this.getPriceExcludingVat();
                                                                           Object other$priceExcludingVat = other.getPriceExcludingVat();
                                                                           if (this$priceExcludingVat == null
                                                                              ? other$priceExcludingVat == null
                                                                              : this$priceExcludingVat.equals(other$priceExcludingVat)) {
                                                                              Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                              Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                              if (this$amountExcludingVat == null
                                                                                 ? other$amountExcludingVat == null
                                                                                 : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                                 Object this$rejectAmount = this.getRejectAmount();
                                                                                 Object other$rejectAmount = other.getRejectAmount();
                                                                                 if (this$rejectAmount == null
                                                                                    ? other$rejectAmount == null
                                                                                    : this$rejectAmount.equals(other$rejectAmount)) {
                                                                                    Object this$differentAmount = this.getDifferentAmount();
                                                                                    Object other$differentAmount = other.getDifferentAmount();
                                                                                    if (this$differentAmount == null
                                                                                       ? other$differentAmount == null
                                                                                       : this$differentAmount.equals(other$differentAmount)) {
                                                                                       Object this$applicant = this.getApplicant();
                                                                                       Object other$applicant = other.getApplicant();
                                                                                       if (this$applicant == null
                                                                                          ? other$applicant == null
                                                                                          : this$applicant.equals(other$applicant)) {
                                                                                          Object this$applicantDate = this.getApplicantDate();
                                                                                          Object other$applicantDate = other.getApplicantDate();
                                                                                          if (this$applicantDate == null
                                                                                             ? other$applicantDate == null
                                                                                             : this$applicantDate.equals(other$applicantDate)) {
                                                                                             Object this$reviewer = this.getReviewer();
                                                                                             Object other$reviewer = other.getReviewer();
                                                                                             if (this$reviewer == null
                                                                                                ? other$reviewer == null
                                                                                                : this$reviewer.equals(other$reviewer)) {
                                                                                                Object this$reviewerDate = this.getReviewerDate();
                                                                                                Object other$reviewerDate = other.getReviewerDate();
                                                                                                if (this$reviewerDate == null
                                                                                                   ? other$reviewerDate == null
                                                                                                   : this$reviewerDate.equals(other$reviewerDate)) {
                                                                                                   Object this$project = this.getProject();
                                                                                                   Object other$project = other.getProject();
                                                                                                   if (this$project == null
                                                                                                      ? other$project == null
                                                                                                      : this$project.equals(other$project)) {
                                                                                                      Object this$manufacturedName = this.getManufacturedName();
                                                                                                      Object other$manufacturedName = other.getManufacturedName();
                                                                                                      if (this$manufacturedName == null
                                                                                                         ? other$manufacturedName == null
                                                                                                         : this$manufacturedName.equals(other$manufacturedName)
                                                                                                         )
                                                                                                       {
                                                                                                         Object this$manufacturedSn = this.getManufacturedSn();
                                                                                                         Object other$manufacturedSn = other.getManufacturedSn();
                                                                                                         if (this$manufacturedSn == null
                                                                                                            ? other$manufacturedSn == null
                                                                                                            : this$manufacturedSn.equals(other$manufacturedSn)) {
                                                                                                            Object this$actualReceivedMete = this.getActualReceivedMete();
                                                                                                            Object other$actualReceivedMete = other.getActualReceivedMete();
                                                                                                            if (this$actualReceivedMete == null
                                                                                                               ? other$actualReceivedMete == null
                                                                                                               : this$actualReceivedMete.equals(
                                                                                                                  other$actualReceivedMete
                                                                                                               )) {
                                                                                                               Object this$rejectActualReceivedMete = this.getRejectActualReceivedMete();
                                                                                                               Object other$rejectActualReceivedMete = other.getRejectActualReceivedMete();
                                                                                                               if (this$rejectActualReceivedMete == null
                                                                                                                  ? other$rejectActualReceivedMete == null
                                                                                                                  : this$rejectActualReceivedMete.equals(
                                                                                                                     other$rejectActualReceivedMete
                                                                                                                  )) {
                                                                                                                  Object this$rejectQuantity = this.getRejectQuantity();
                                                                                                                  Object other$rejectQuantity = other.getRejectQuantity();
                                                                                                                  if (this$rejectQuantity == null
                                                                                                                     ? other$rejectQuantity == null
                                                                                                                     : this$rejectQuantity.equals(
                                                                                                                        other$rejectQuantity
                                                                                                                     )) {
                                                                                                                     Object this$rejectMete = this.getRejectMete();
                                                                                                                     Object other$rejectMete = other.getRejectMete();
                                                                                                                     if (this$rejectMete == null
                                                                                                                        ? other$rejectMete == null
                                                                                                                        : this$rejectMete.equals(
                                                                                                                           other$rejectMete
                                                                                                                        )) {
                                                                                                                        Object this$realityInboundAmount = this.getRealityInboundAmount();
                                                                                                                        Object other$realityInboundAmount = other.getRealityInboundAmount();
                                                                                                                        if (this$realityInboundAmount == null
                                                                                                                           ? other$realityInboundAmount == null
                                                                                                                           : this$realityInboundAmount.equals(
                                                                                                                              other$realityInboundAmount
                                                                                                                           )) {
                                                                                                                           Object this$finishedGoodsTypeName = this.getFinishedGoodsTypeName();
                                                                                                                           Object other$finishedGoodsTypeName = other.getFinishedGoodsTypeName();
                                                                                                                           if (this$finishedGoodsTypeName
                                                                                                                                 == null
                                                                                                                              ? other$finishedGoodsTypeName
                                                                                                                                 == null
                                                                                                                              : this$finishedGoodsTypeName.equals(
                                                                                                                                 other$finishedGoodsTypeName
                                                                                                                              )) {
                                                                                                                              Object this$material = this.getMaterial();
                                                                                                                              Object other$material = other.getMaterial();
                                                                                                                              return this$material == null
                                                                                                                                 ? other$material == null
                                                                                                                                 : this$material.equals(
                                                                                                                                    other$material
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApplyPurchaseInboundDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $inboundDetailId = this.getInboundDetailId();
      result = result * 59 + ($inboundDetailId == null ? 43 : $inboundDetailId.hashCode());
      Object $basicClassEnum = this.getBasicClassEnum();
      result = result * 59 + ($basicClassEnum == null ? 43 : $basicClassEnum.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $manufacturedType = this.getManufacturedType();
      result = result * 59 + ($manufacturedType == null ? 43 : $manufacturedType.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $inboundSerialNumber = this.getInboundSerialNumber();
      result = result * 59 + ($inboundSerialNumber == null ? 43 : $inboundSerialNumber.hashCode());
      Object $purchaseSerialNumber = this.getPurchaseSerialNumber();
      result = result * 59 + ($purchaseSerialNumber == null ? 43 : $purchaseSerialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $realityQuantity = this.getRealityQuantity();
      result = result * 59 + ($realityQuantity == null ? 43 : $realityQuantity.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $realityMete = this.getRealityMete();
      result = result * 59 + ($realityMete == null ? 43 : $realityMete.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $priceExcludingVat = this.getPriceExcludingVat();
      result = result * 59 + ($priceExcludingVat == null ? 43 : $priceExcludingVat.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $rejectAmount = this.getRejectAmount();
      result = result * 59 + ($rejectAmount == null ? 43 : $rejectAmount.hashCode());
      Object $differentAmount = this.getDifferentAmount();
      result = result * 59 + ($differentAmount == null ? 43 : $differentAmount.hashCode());
      Object $applicant = this.getApplicant();
      result = result * 59 + ($applicant == null ? 43 : $applicant.hashCode());
      Object $applicantDate = this.getApplicantDate();
      result = result * 59 + ($applicantDate == null ? 43 : $applicantDate.hashCode());
      Object $reviewer = this.getReviewer();
      result = result * 59 + ($reviewer == null ? 43 : $reviewer.hashCode());
      Object $reviewerDate = this.getReviewerDate();
      result = result * 59 + ($reviewerDate == null ? 43 : $reviewerDate.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $manufacturedName = this.getManufacturedName();
      result = result * 59 + ($manufacturedName == null ? 43 : $manufacturedName.hashCode());
      Object $manufacturedSn = this.getManufacturedSn();
      result = result * 59 + ($manufacturedSn == null ? 43 : $manufacturedSn.hashCode());
      Object $actualReceivedMete = this.getActualReceivedMete();
      result = result * 59 + ($actualReceivedMete == null ? 43 : $actualReceivedMete.hashCode());
      Object $rejectActualReceivedMete = this.getRejectActualReceivedMete();
      result = result * 59 + ($rejectActualReceivedMete == null ? 43 : $rejectActualReceivedMete.hashCode());
      Object $rejectQuantity = this.getRejectQuantity();
      result = result * 59 + ($rejectQuantity == null ? 43 : $rejectQuantity.hashCode());
      Object $rejectMete = this.getRejectMete();
      result = result * 59 + ($rejectMete == null ? 43 : $rejectMete.hashCode());
      Object $realityInboundAmount = this.getRealityInboundAmount();
      result = result * 59 + ($realityInboundAmount == null ? 43 : $realityInboundAmount.hashCode());
      Object $finishedGoodsTypeName = this.getFinishedGoodsTypeName();
      result = result * 59 + ($finishedGoodsTypeName == null ? 43 : $finishedGoodsTypeName.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "ApplyPurchaseInboundDetailDTO(inboundId="
         + this.getInboundId()
         + ", inboundSerialNumber="
         + this.getInboundSerialNumber()
         + ", purchaseSerialNumber="
         + this.getPurchaseSerialNumber()
         + ", inboundDetailId="
         + this.getInboundDetailId()
         + ", basicClassEnum="
         + this.getBasicClassEnum()
         + ", specification="
         + this.getSpecification()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", unit="
         + this.getUnit()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", supplier="
         + this.getSupplier()
         + ", quantity="
         + this.getQuantity()
         + ", realityQuantity="
         + this.getRealityQuantity()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", realityMete="
         + this.getRealityMete()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", priceExcludingVat="
         + this.getPriceExcludingVat()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", rejectAmount="
         + this.getRejectAmount()
         + ", differentAmount="
         + this.getDifferentAmount()
         + ", applicant="
         + this.getApplicant()
         + ", applicantDate="
         + this.getApplicantDate()
         + ", reviewer="
         + this.getReviewer()
         + ", reviewerDate="
         + this.getReviewerDate()
         + ", projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", manufacturedName="
         + this.getManufacturedName()
         + ", manufacturedSn="
         + this.getManufacturedSn()
         + ", manufacturedType="
         + this.getManufacturedType()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", actualReceivedMete="
         + this.getActualReceivedMete()
         + ", rejectActualReceivedMete="
         + this.getRejectActualReceivedMete()
         + ", rejectQuantity="
         + this.getRejectQuantity()
         + ", rejectMete="
         + this.getRejectMete()
         + ", type="
         + this.getType()
         + ", realityInboundAmount="
         + this.getRealityInboundAmount()
         + ", finishedGoodsTypeName="
         + this.getFinishedGoodsTypeName()
         + ", material="
         + this.getMaterial()
         + ")";
   }

   public ApplyPurchaseInboundDetailDTO(
      final Long inboundId,
      final String inboundSerialNumber,
      final String purchaseSerialNumber,
      final Long inboundDetailId,
      final Integer basicClassEnum,
      final String specification,
      final String brand,
      final String color,
      final String unit,
      final Long classifyId,
      final String classifyName,
      final SupplierAllBriefDTO supplier,
      final BigDecimal quantity,
      final BigDecimal realityQuantity,
      final String accountingUnit,
      final BigDecimal mete,
      final BigDecimal realityMete,
      final BigDecimal price,
      final BigDecimal amount,
      final BigDecimal priceExcludingVat,
      final BigDecimal amountExcludingVat,
      final BigDecimal rejectAmount,
      final BigDecimal differentAmount,
      final NameInfo applicant,
      final LocalDateTime applicantDate,
      final NameInfo reviewer,
      final LocalDateTime reviewerDate,
      final Long projectId,
      final ProjectInfo project,
      final String manufacturedName,
      final String manufacturedSn,
      final Integer manufacturedType,
      final Integer wageQuotaType,
      final BigDecimal actualReceivedMete,
      final BigDecimal rejectActualReceivedMete,
      final BigDecimal rejectQuantity,
      final BigDecimal rejectMete,
      final Integer type,
      final BigDecimal realityInboundAmount,
      final String finishedGoodsTypeName,
      final String material
   ) {
      this.inboundId = inboundId;
      this.inboundSerialNumber = inboundSerialNumber;
      this.purchaseSerialNumber = purchaseSerialNumber;
      this.inboundDetailId = inboundDetailId;
      this.basicClassEnum = basicClassEnum;
      this.specification = specification;
      this.brand = brand;
      this.color = color;
      this.unit = unit;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.supplier = supplier;
      this.quantity = quantity;
      this.realityQuantity = realityQuantity;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.realityMete = realityMete;
      this.price = price;
      this.amount = amount;
      this.priceExcludingVat = priceExcludingVat;
      this.amountExcludingVat = amountExcludingVat;
      this.rejectAmount = rejectAmount;
      this.differentAmount = differentAmount;
      this.applicant = applicant;
      this.applicantDate = applicantDate;
      this.reviewer = reviewer;
      this.reviewerDate = reviewerDate;
      this.projectId = projectId;
      this.project = project;
      this.manufacturedName = manufacturedName;
      this.manufacturedSn = manufacturedSn;
      this.manufacturedType = manufacturedType;
      this.wageQuotaType = wageQuotaType;
      this.actualReceivedMete = actualReceivedMete;
      this.rejectActualReceivedMete = rejectActualReceivedMete;
      this.rejectQuantity = rejectQuantity;
      this.rejectMete = rejectMete;
      this.type = type;
      this.realityInboundAmount = realityInboundAmount;
      this.finishedGoodsTypeName = finishedGoodsTypeName;
      this.material = material;
   }

   public ApplyPurchaseInboundDetailDTO() {
   }

   public static class ApplyPurchaseInboundDetailDTOBuilder {
      private Long inboundId;
      private String inboundSerialNumber;
      private String purchaseSerialNumber;
      private Long inboundDetailId;
      private Integer basicClassEnum;
      private String specification;
      private String brand;
      private String color;
      private String unit;
      private Long classifyId;
      private String classifyName;
      private SupplierAllBriefDTO supplier;
      private BigDecimal quantity;
      private BigDecimal realityQuantity;
      private String accountingUnit;
      private BigDecimal mete;
      private BigDecimal realityMete;
      private BigDecimal price;
      private BigDecimal amount;
      private BigDecimal priceExcludingVat;
      private BigDecimal amountExcludingVat;
      private BigDecimal rejectAmount;
      private BigDecimal differentAmount;
      private NameInfo applicant;
      private LocalDateTime applicantDate;
      private NameInfo reviewer;
      private LocalDateTime reviewerDate;
      private Long projectId;
      private ProjectInfo project;
      private String manufacturedName;
      private String manufacturedSn;
      private Integer manufacturedType;
      private Integer wageQuotaType;
      private BigDecimal actualReceivedMete;
      private BigDecimal rejectActualReceivedMete;
      private BigDecimal rejectQuantity;
      private BigDecimal rejectMete;
      private Integer type;
      private BigDecimal realityInboundAmount;
      private String finishedGoodsTypeName;
      private String material;

      ApplyPurchaseInboundDetailDTOBuilder() {
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder inboundSerialNumber(final String inboundSerialNumber) {
         this.inboundSerialNumber = inboundSerialNumber;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder purchaseSerialNumber(final String purchaseSerialNumber) {
         this.purchaseSerialNumber = purchaseSerialNumber;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder inboundDetailId(final Long inboundDetailId) {
         this.inboundDetailId = inboundDetailId;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder basicClassEnum(final Integer basicClassEnum) {
         this.basicClassEnum = basicClassEnum;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder supplier(final SupplierAllBriefDTO supplier) {
         this.supplier = supplier;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder realityQuantity(final BigDecimal realityQuantity) {
         this.realityQuantity = realityQuantity;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder realityMete(final BigDecimal realityMete) {
         this.realityMete = realityMete;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder priceExcludingVat(final BigDecimal priceExcludingVat) {
         this.priceExcludingVat = priceExcludingVat;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder rejectAmount(final BigDecimal rejectAmount) {
         this.rejectAmount = rejectAmount;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder differentAmount(final BigDecimal differentAmount) {
         this.differentAmount = differentAmount;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder applicant(final NameInfo applicant) {
         this.applicant = applicant;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder applicantDate(final LocalDateTime applicantDate) {
         this.applicantDate = applicantDate;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder reviewer(final NameInfo reviewer) {
         this.reviewer = reviewer;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder reviewerDate(final LocalDateTime reviewerDate) {
         this.reviewerDate = reviewerDate;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder manufacturedType(final Integer manufacturedType) {
         this.manufacturedType = manufacturedType;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder actualReceivedMete(final BigDecimal actualReceivedMete) {
         this.actualReceivedMete = actualReceivedMete;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder rejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
         this.rejectActualReceivedMete = rejectActualReceivedMete;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder rejectQuantity(final BigDecimal rejectQuantity) {
         this.rejectQuantity = rejectQuantity;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder rejectMete(final BigDecimal rejectMete) {
         this.rejectMete = rejectMete;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder realityInboundAmount(final BigDecimal realityInboundAmount) {
         this.realityInboundAmount = realityInboundAmount;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder finishedGoodsTypeName(final String finishedGoodsTypeName) {
         this.finishedGoodsTypeName = finishedGoodsTypeName;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ApplyPurchaseInboundDetailDTO build() {
         return new ApplyPurchaseInboundDetailDTO(
            this.inboundId,
            this.inboundSerialNumber,
            this.purchaseSerialNumber,
            this.inboundDetailId,
            this.basicClassEnum,
            this.specification,
            this.brand,
            this.color,
            this.unit,
            this.classifyId,
            this.classifyName,
            this.supplier,
            this.quantity,
            this.realityQuantity,
            this.accountingUnit,
            this.mete,
            this.realityMete,
            this.price,
            this.amount,
            this.priceExcludingVat,
            this.amountExcludingVat,
            this.rejectAmount,
            this.differentAmount,
            this.applicant,
            this.applicantDate,
            this.reviewer,
            this.reviewerDate,
            this.projectId,
            this.project,
            this.manufacturedName,
            this.manufacturedSn,
            this.manufacturedType,
            this.wageQuotaType,
            this.actualReceivedMete,
            this.rejectActualReceivedMete,
            this.rejectQuantity,
            this.rejectMete,
            this.type,
            this.realityInboundAmount,
            this.finishedGoodsTypeName,
            this.material
         );
      }

      @Override
      public String toString() {
         return "ApplyPurchaseInboundDetailDTO.ApplyPurchaseInboundDetailDTOBuilder(inboundId="
            + this.inboundId
            + ", inboundSerialNumber="
            + this.inboundSerialNumber
            + ", purchaseSerialNumber="
            + this.purchaseSerialNumber
            + ", inboundDetailId="
            + this.inboundDetailId
            + ", basicClassEnum="
            + this.basicClassEnum
            + ", specification="
            + this.specification
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", unit="
            + this.unit
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", supplier="
            + this.supplier
            + ", quantity="
            + this.quantity
            + ", realityQuantity="
            + this.realityQuantity
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", realityMete="
            + this.realityMete
            + ", price="
            + this.price
            + ", amount="
            + this.amount
            + ", priceExcludingVat="
            + this.priceExcludingVat
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", rejectAmount="
            + this.rejectAmount
            + ", differentAmount="
            + this.differentAmount
            + ", applicant="
            + this.applicant
            + ", applicantDate="
            + this.applicantDate
            + ", reviewer="
            + this.reviewer
            + ", reviewerDate="
            + this.reviewerDate
            + ", projectId="
            + this.projectId
            + ", project="
            + this.project
            + ", manufacturedName="
            + this.manufacturedName
            + ", manufacturedSn="
            + this.manufacturedSn
            + ", manufacturedType="
            + this.manufacturedType
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", actualReceivedMete="
            + this.actualReceivedMete
            + ", rejectActualReceivedMete="
            + this.rejectActualReceivedMete
            + ", rejectQuantity="
            + this.rejectQuantity
            + ", rejectMete="
            + this.rejectMete
            + ", type="
            + this.type
            + ", realityInboundAmount="
            + this.realityInboundAmount
            + ", finishedGoodsTypeName="
            + this.finishedGoodsTypeName
            + ", material="
            + this.material
            + ")";
      }
   }
}

package com.hzchum.scim.project.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProjectRejectDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "receivedId", value = "收货记录id", notes = "收货记录id")
   private Long receivedId;
   @ApiModelProperty(name = "receivedDate", value = "收货日期", notes = "收货日期")
   private LocalDateTime receivedDate;
   @ApiModelProperty(name = "supplierId", value = "供应商", notes = "供应商")
   private Long supplierId;
   @ApiModelProperty(name = "purchaseId", value = "采购单id", notes = "采购单id")
   private Long purchaseId;
   @ApiModelProperty(name = "purchaseSn", value = "采购单编号", notes = "采购单编号")
   private String purchaseSn;
   @ApiModelProperty(name = "receivedUserName", value = "收货人", notes = "收货人")
   private String receivedUserName;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "rejectQuantity", value = "退货量 ", notes = "退货量")
   private BigDecimal rejectQuantity;
   @ApiModelProperty(name = "rejectMete", value = "退货核算量 ", notes = "退货核算量")
   private BigDecimal rejectMete;
   @ApiModelProperty(name = "rejectActualReceivedMete", value = "实际退货量 ", notes = "实际退货量")
   private BigDecimal rejectActualReceivedMete;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   private String applicantName;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态", notes = "审核状态")
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID", notes = "审核人ID")
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称", notes = "审核人名称")
   private String reviewerName;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "rejectSn", value = "单据编号", notes = "单据编号")
   private String rejectSn;
   @ApiModelProperty(name = "rejectId", value = "单据id", notes = "单据id")
   private Long rejectId;
   @ApiModelProperty(name = "purchaseDetailsId", value = "采购详情id", notes = "采购详情id")
   private Long purchaseDetailsId;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "classifyId", notes = "科目id")
   private Long classifyId;
   @ApiModelProperty(name = "basicClass", value = "材料类型", notes = "材料类型")
   private Integer basicClass;
   @ApiModelProperty(name = "wageQuotaType", value = "制成品计价方式 WmsWageQuotaTypeEnum", notes = "制成品计价方式 计价方式 WmsWageQuotaTypeEnum")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "measurePrecision", value = "计量精度")
   private Integer measurePrecision;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "supplier", value = "供应商")
   private NameInfo supplier;
   @ApiModelProperty(name = "project", value = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo batch;
   @ApiModelProperty(name = "brand", value = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @JsonInclude(Include.NON_NULL)
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @JsonInclude(Include.NON_NULL)
   private String color;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal thickness;

   public static ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder builder() {
      return new ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder();
   }

   public ProjectRejectDetailDTO() {
   }

   public ProjectRejectDetailDTO(
      final Long id,
      final Long receivedId,
      final LocalDateTime receivedDate,
      final Long supplierId,
      final Long purchaseId,
      final String purchaseSn,
      final String receivedUserName,
      final Integer productType,
      final Long productId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String serialNumber,
      final String name,
      final String specification,
      final BigDecimal rejectQuantity,
      final BigDecimal rejectMete,
      final BigDecimal rejectActualReceivedMete,
      final Long applicantId,
      final String applicantName,
      final Integer reviewStatus,
      final Long reviewerId,
      final String reviewerName,
      final LocalDateTime createTime,
      final LocalDateTime reviewTime,
      final String rejectSn,
      final Long rejectId,
      final Long purchaseDetailsId,
      final String accountingUnit,
      final String measureUnit,
      final Long classifyId,
      final Integer basicClass,
      final Integer wageQuotaType,
      final Integer measurePrecision,
      final Integer accountingPrecision,
      final NameInfo monomer,
      final NameInfo area,
      final NameInfo supplier,
      final ProjectInfo project,
      final NameInfo batch,
      final String brand,
      final String color,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness
   ) {
      this.id = id;
      this.receivedId = receivedId;
      this.receivedDate = receivedDate;
      this.supplierId = supplierId;
      this.purchaseId = purchaseId;
      this.purchaseSn = purchaseSn;
      this.receivedUserName = receivedUserName;
      this.productType = productType;
      this.productId = productId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.serialNumber = serialNumber;
      this.name = name;
      this.specification = specification;
      this.rejectQuantity = rejectQuantity;
      this.rejectMete = rejectMete;
      this.rejectActualReceivedMete = rejectActualReceivedMete;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewStatus = reviewStatus;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.createTime = createTime;
      this.reviewTime = reviewTime;
      this.rejectSn = rejectSn;
      this.rejectId = rejectId;
      this.purchaseDetailsId = purchaseDetailsId;
      this.accountingUnit = accountingUnit;
      this.measureUnit = measureUnit;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.wageQuotaType = wageQuotaType;
      this.measurePrecision = measurePrecision;
      this.accountingPrecision = accountingPrecision;
      this.monomer = monomer;
      this.area = area;
      this.supplier = supplier;
      this.project = project;
      this.batch = batch;
      this.brand = brand;
      this.color = color;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
   }

   public Long getId() {
      return this.id;
   }

   public Long getReceivedId() {
      return this.receivedId;
   }

   public LocalDateTime getReceivedDate() {
      return this.receivedDate;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public String getPurchaseSn() {
      return this.purchaseSn;
   }

   public String getReceivedUserName() {
      return this.receivedUserName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getRejectQuantity() {
      return this.rejectQuantity;
   }

   public BigDecimal getRejectMete() {
      return this.rejectMete;
   }

   public BigDecimal getRejectActualReceivedMete() {
      return this.rejectActualReceivedMete;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public String getRejectSn() {
      return this.rejectSn;
   }

   public Long getRejectId() {
      return this.rejectId;
   }

   public Long getPurchaseDetailsId() {
      return this.purchaseDetailsId;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public NameInfo getSupplier() {
      return this.supplier;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getBatch() {
      return this.batch;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setReceivedId(final Long receivedId) {
      this.receivedId = receivedId;
   }

   public void setReceivedDate(final LocalDateTime receivedDate) {
      this.receivedDate = receivedDate;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
   }

   public void setReceivedUserName(final String receivedUserName) {
      this.receivedUserName = receivedUserName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setRejectQuantity(final BigDecimal rejectQuantity) {
      this.rejectQuantity = rejectQuantity;
   }

   public void setRejectMete(final BigDecimal rejectMete) {
      this.rejectMete = rejectMete;
   }

   public void setRejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
      this.rejectActualReceivedMete = rejectActualReceivedMete;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setRejectSn(final String rejectSn) {
      this.rejectSn = rejectSn;
   }

   public void setRejectId(final Long rejectId) {
      this.rejectId = rejectId;
   }

   public void setPurchaseDetailsId(final Long purchaseDetailsId) {
      this.purchaseDetailsId = purchaseDetailsId;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setSupplier(final NameInfo supplier) {
      this.supplier = supplier;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setBatch(final NameInfo batch) {
      this.batch = batch;
   }

   @JsonProperty("brand")
   public void setBrand(final String brand) {
      this.brand = brand;
   }

   @JsonProperty("color")
   public void setColor(final String color) {
      this.color = color;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("width")
   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   @JsonProperty("thickness")
   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectRejectDetailDTO)) {
         return false;
      }

      ProjectRejectDetailDTO other = (ProjectRejectDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$receivedId = this.getReceivedId();
         Object other$receivedId = other.getReceivedId();
         if (this$receivedId == null ? other$receivedId == null : this$receivedId.equals(other$receivedId)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$purchaseId = this.getPurchaseId();
               Object other$purchaseId = other.getPurchaseId();
               if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$monomerId = this.getMonomerId();
                           Object other$monomerId = other.getMonomerId();
                           if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                              Object this$areaId = this.getAreaId();
                              Object other$areaId = other.getAreaId();
                              if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                 Object this$applicantId = this.getApplicantId();
                                 Object other$applicantId = other.getApplicantId();
                                 if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                                    Object this$reviewStatus = this.getReviewStatus();
                                    Object other$reviewStatus = other.getReviewStatus();
                                    if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                                       Object this$reviewerId = this.getReviewerId();
                                       Object other$reviewerId = other.getReviewerId();
                                       if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                                          Object this$rejectId = this.getRejectId();
                                          Object other$rejectId = other.getRejectId();
                                          if (this$rejectId == null ? other$rejectId == null : this$rejectId.equals(other$rejectId)) {
                                             Object this$purchaseDetailsId = this.getPurchaseDetailsId();
                                             Object other$purchaseDetailsId = other.getPurchaseDetailsId();
                                             if (this$purchaseDetailsId == null
                                                ? other$purchaseDetailsId == null
                                                : this$purchaseDetailsId.equals(other$purchaseDetailsId)) {
                                                Object this$classifyId = this.getClassifyId();
                                                Object other$classifyId = other.getClassifyId();
                                                if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                                   Object this$basicClass = this.getBasicClass();
                                                   Object other$basicClass = other.getBasicClass();
                                                   if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                                                      Object this$wageQuotaType = this.getWageQuotaType();
                                                      Object other$wageQuotaType = other.getWageQuotaType();
                                                      if (this$wageQuotaType == null
                                                         ? other$wageQuotaType == null
                                                         : this$wageQuotaType.equals(other$wageQuotaType)) {
                                                         Object this$measurePrecision = this.getMeasurePrecision();
                                                         Object other$measurePrecision = other.getMeasurePrecision();
                                                         if (this$measurePrecision == null
                                                            ? other$measurePrecision == null
                                                            : this$measurePrecision.equals(other$measurePrecision)) {
                                                            Object this$accountingPrecision = this.getAccountingPrecision();
                                                            Object other$accountingPrecision = other.getAccountingPrecision();
                                                            if (this$accountingPrecision == null
                                                               ? other$accountingPrecision == null
                                                               : this$accountingPrecision.equals(other$accountingPrecision)) {
                                                               Object this$receivedDate = this.getReceivedDate();
                                                               Object other$receivedDate = other.getReceivedDate();
                                                               if (this$receivedDate == null
                                                                  ? other$receivedDate == null
                                                                  : this$receivedDate.equals(other$receivedDate)) {
                                                                  Object this$purchaseSn = this.getPurchaseSn();
                                                                  Object other$purchaseSn = other.getPurchaseSn();
                                                                  if (this$purchaseSn == null
                                                                     ? other$purchaseSn == null
                                                                     : this$purchaseSn.equals(other$purchaseSn)) {
                                                                     Object this$receivedUserName = this.getReceivedUserName();
                                                                     Object other$receivedUserName = other.getReceivedUserName();
                                                                     if (this$receivedUserName == null
                                                                        ? other$receivedUserName == null
                                                                        : this$receivedUserName.equals(other$receivedUserName)) {
                                                                        Object this$serialNumber = this.getSerialNumber();
                                                                        Object other$serialNumber = other.getSerialNumber();
                                                                        if (this$serialNumber == null
                                                                           ? other$serialNumber == null
                                                                           : this$serialNumber.equals(other$serialNumber)) {
                                                                           Object this$name = this.getName();
                                                                           Object other$name = other.getName();
                                                                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                              Object this$specification = this.getSpecification();
                                                                              Object other$specification = other.getSpecification();
                                                                              if (this$specification == null
                                                                                 ? other$specification == null
                                                                                 : this$specification.equals(other$specification)) {
                                                                                 Object this$rejectQuantity = this.getRejectQuantity();
                                                                                 Object other$rejectQuantity = other.getRejectQuantity();
                                                                                 if (this$rejectQuantity == null
                                                                                    ? other$rejectQuantity == null
                                                                                    : this$rejectQuantity.equals(other$rejectQuantity)) {
                                                                                    Object this$rejectMete = this.getRejectMete();
                                                                                    Object other$rejectMete = other.getRejectMete();
                                                                                    if (this$rejectMete == null
                                                                                       ? other$rejectMete == null
                                                                                       : this$rejectMete.equals(other$rejectMete)) {
                                                                                       Object this$rejectActualReceivedMete = this.getRejectActualReceivedMete();
                                                                                       Object other$rejectActualReceivedMete = other.getRejectActualReceivedMete();
                                                                                       if (this$rejectActualReceivedMete == null
                                                                                          ? other$rejectActualReceivedMete == null
                                                                                          : this$rejectActualReceivedMete.equals(other$rejectActualReceivedMete)
                                                                                          )
                                                                                        {
                                                                                          Object this$applicantName = this.getApplicantName();
                                                                                          Object other$applicantName = other.getApplicantName();
                                                                                          if (this$applicantName == null
                                                                                             ? other$applicantName == null
                                                                                             : this$applicantName.equals(other$applicantName)) {
                                                                                             Object this$reviewerName = this.getReviewerName();
                                                                                             Object other$reviewerName = other.getReviewerName();
                                                                                             if (this$reviewerName == null
                                                                                                ? other$reviewerName == null
                                                                                                : this$reviewerName.equals(other$reviewerName)) {
                                                                                                Object this$createTime = this.getCreateTime();
                                                                                                Object other$createTime = other.getCreateTime();
                                                                                                if (this$createTime == null
                                                                                                   ? other$createTime == null
                                                                                                   : this$createTime.equals(other$createTime)) {
                                                                                                   Object this$reviewTime = this.getReviewTime();
                                                                                                   Object other$reviewTime = other.getReviewTime();
                                                                                                   if (this$reviewTime == null
                                                                                                      ? other$reviewTime == null
                                                                                                      : this$reviewTime.equals(other$reviewTime)) {
                                                                                                      Object this$rejectSn = this.getRejectSn();
                                                                                                      Object other$rejectSn = other.getRejectSn();
                                                                                                      if (this$rejectSn == null
                                                                                                         ? other$rejectSn == null
                                                                                                         : this$rejectSn.equals(other$rejectSn)) {
                                                                                                         Object this$accountingUnit = this.getAccountingUnit();
                                                                                                         Object other$accountingUnit = other.getAccountingUnit();
                                                                                                         if (this$accountingUnit == null
                                                                                                            ? other$accountingUnit == null
                                                                                                            : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                                            Object this$measureUnit = this.getMeasureUnit();
                                                                                                            Object other$measureUnit = other.getMeasureUnit();
                                                                                                            if (this$measureUnit == null
                                                                                                               ? other$measureUnit == null
                                                                                                               : this$measureUnit.equals(other$measureUnit)) {
                                                                                                               Object this$monomer = this.getMonomer();
                                                                                                               Object other$monomer = other.getMonomer();
                                                                                                               if (this$monomer == null
                                                                                                                  ? other$monomer == null
                                                                                                                  : this$monomer.equals(other$monomer)) {
                                                                                                                  Object this$area = this.getArea();
                                                                                                                  Object other$area = other.getArea();
                                                                                                                  if (this$area == null
                                                                                                                     ? other$area == null
                                                                                                                     : this$area.equals(other$area)) {
                                                                                                                     Object this$supplier = this.getSupplier();
                                                                                                                     Object other$supplier = other.getSupplier();
                                                                                                                     if (this$supplier == null
                                                                                                                        ? other$supplier == null
                                                                                                                        : this$supplier.equals(other$supplier)) {
                                                                                                                        Object this$project = this.getProject();
                                                                                                                        Object other$project = other.getProject();
                                                                                                                        if (this$project == null
                                                                                                                           ? other$project == null
                                                                                                                           : this$project.equals(other$project)
                                                                                                                           )
                                                                                                                         {
                                                                                                                           Object this$batch = this.getBatch();
                                                                                                                           Object other$batch = other.getBatch();
                                                                                                                           if (this$batch == null
                                                                                                                              ? other$batch == null
                                                                                                                              : this$batch.equals(other$batch)) {
                                                                                                                              Object this$brand = this.getBrand();
                                                                                                                              Object other$brand = other.getBrand();
                                                                                                                              if (this$brand == null
                                                                                                                                 ? other$brand == null
                                                                                                                                 : this$brand.equals(
                                                                                                                                    other$brand
                                                                                                                                 )) {
                                                                                                                                 Object this$color = this.getColor();
                                                                                                                                 Object other$color = other.getColor();
                                                                                                                                 if (this$color == null
                                                                                                                                    ? other$color == null
                                                                                                                                    : this$color.equals(
                                                                                                                                       other$color
                                                                                                                                    )) {
                                                                                                                                    Object this$length = this.getLength();
                                                                                                                                    Object other$length = other.getLength();
                                                                                                                                    if (this$length == null
                                                                                                                                       ? other$length == null
                                                                                                                                       : this$length.equals(
                                                                                                                                          other$length
                                                                                                                                       )) {
                                                                                                                                       Object this$width = this.getWidth();
                                                                                                                                       Object other$width = other.getWidth();
                                                                                                                                       if (this$width == null
                                                                                                                                          ? other$width == null
                                                                                                                                          : this$width.equals(
                                                                                                                                             other$width
                                                                                                                                          )) {
                                                                                                                                          Object this$thickness = this.getThickness();
                                                                                                                                          Object other$thickness = other.getThickness();
                                                                                                                                          return this$thickness
                                                                                                                                                == null
                                                                                                                                             ? other$thickness
                                                                                                                                                == null
                                                                                                                                             : this$thickness.equals(
                                                                                                                                                other$thickness
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectRejectDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $receivedId = this.getReceivedId();
      result = result * 59 + ($receivedId == null ? 43 : $receivedId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $rejectId = this.getRejectId();
      result = result * 59 + ($rejectId == null ? 43 : $rejectId.hashCode());
      Object $purchaseDetailsId = this.getPurchaseDetailsId();
      result = result * 59 + ($purchaseDetailsId == null ? 43 : $purchaseDetailsId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $receivedDate = this.getReceivedDate();
      result = result * 59 + ($receivedDate == null ? 43 : $receivedDate.hashCode());
      Object $purchaseSn = this.getPurchaseSn();
      result = result * 59 + ($purchaseSn == null ? 43 : $purchaseSn.hashCode());
      Object $receivedUserName = this.getReceivedUserName();
      result = result * 59 + ($receivedUserName == null ? 43 : $receivedUserName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $rejectQuantity = this.getRejectQuantity();
      result = result * 59 + ($rejectQuantity == null ? 43 : $rejectQuantity.hashCode());
      Object $rejectMete = this.getRejectMete();
      result = result * 59 + ($rejectMete == null ? 43 : $rejectMete.hashCode());
      Object $rejectActualReceivedMete = this.getRejectActualReceivedMete();
      result = result * 59 + ($rejectActualReceivedMete == null ? 43 : $rejectActualReceivedMete.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $rejectSn = this.getRejectSn();
      result = result * 59 + ($rejectSn == null ? 43 : $rejectSn.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $batch = this.getBatch();
      result = result * 59 + ($batch == null ? 43 : $batch.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      return result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectRejectDetailDTO(id="
         + this.getId()
         + ", receivedId="
         + this.getReceivedId()
         + ", receivedDate="
         + this.getReceivedDate()
         + ", supplierId="
         + this.getSupplierId()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", purchaseSn="
         + this.getPurchaseSn()
         + ", receivedUserName="
         + this.getReceivedUserName()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", rejectQuantity="
         + this.getRejectQuantity()
         + ", rejectMete="
         + this.getRejectMete()
         + ", rejectActualReceivedMete="
         + this.getRejectActualReceivedMete()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", rejectSn="
         + this.getRejectSn()
         + ", rejectId="
         + this.getRejectId()
         + ", purchaseDetailsId="
         + this.getPurchaseDetailsId()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", supplier="
         + this.getSupplier()
         + ", project="
         + this.getProject()
         + ", batch="
         + this.getBatch()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ")";
   }

   public static class ProjectRejectDetailDTOBuilder {
      private Long id;
      private Long receivedId;
      private LocalDateTime receivedDate;
      private Long supplierId;
      private Long purchaseId;
      private String purchaseSn;
      private String receivedUserName;
      private Integer productType;
      private Long productId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String serialNumber;
      private String name;
      private String specification;
      private BigDecimal rejectQuantity;
      private BigDecimal rejectMete;
      private BigDecimal rejectActualReceivedMete;
      private Long applicantId;
      private String applicantName;
      private Integer reviewStatus;
      private Long reviewerId;
      private String reviewerName;
      private LocalDateTime createTime;
      private LocalDateTime reviewTime;
      private String rejectSn;
      private Long rejectId;
      private Long purchaseDetailsId;
      private String accountingUnit;
      private String measureUnit;
      private Long classifyId;
      private Integer basicClass;
      private Integer wageQuotaType;
      private Integer measurePrecision;
      private Integer accountingPrecision;
      private NameInfo monomer;
      private NameInfo area;
      private NameInfo supplier;
      private ProjectInfo project;
      private NameInfo batch;
      private String brand;
      private String color;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;

      ProjectRejectDetailDTOBuilder() {
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder receivedId(final Long receivedId) {
         this.receivedId = receivedId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder receivedDate(final LocalDateTime receivedDate) {
         this.receivedDate = receivedDate;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder receivedUserName(final String receivedUserName) {
         this.receivedUserName = receivedUserName;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder rejectQuantity(final BigDecimal rejectQuantity) {
         this.rejectQuantity = rejectQuantity;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder rejectMete(final BigDecimal rejectMete) {
         this.rejectMete = rejectMete;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder rejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
         this.rejectActualReceivedMete = rejectActualReceivedMete;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder rejectSn(final String rejectSn) {
         this.rejectSn = rejectSn;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder rejectId(final Long rejectId) {
         this.rejectId = rejectId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder purchaseDetailsId(final Long purchaseDetailsId) {
         this.purchaseDetailsId = purchaseDetailsId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder supplier(final NameInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder batch(final NameInfo batch) {
         this.batch = batch;
         return this;
      }

      @JsonProperty("brand")
      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("color")
      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("length")
      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ProjectRejectDetailDTO build() {
         return new ProjectRejectDetailDTO(
            this.id,
            this.receivedId,
            this.receivedDate,
            this.supplierId,
            this.purchaseId,
            this.purchaseSn,
            this.receivedUserName,
            this.productType,
            this.productId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.serialNumber,
            this.name,
            this.specification,
            this.rejectQuantity,
            this.rejectMete,
            this.rejectActualReceivedMete,
            this.applicantId,
            this.applicantName,
            this.reviewStatus,
            this.reviewerId,
            this.reviewerName,
            this.createTime,
            this.reviewTime,
            this.rejectSn,
            this.rejectId,
            this.purchaseDetailsId,
            this.accountingUnit,
            this.measureUnit,
            this.classifyId,
            this.basicClass,
            this.wageQuotaType,
            this.measurePrecision,
            this.accountingPrecision,
            this.monomer,
            this.area,
            this.supplier,
            this.project,
            this.batch,
            this.brand,
            this.color,
            this.length,
            this.width,
            this.thickness
         );
      }

      @Override
      public String toString() {
         return "ProjectRejectDetailDTO.ProjectRejectDetailDTOBuilder(id="
            + this.id
            + ", receivedId="
            + this.receivedId
            + ", receivedDate="
            + this.receivedDate
            + ", supplierId="
            + this.supplierId
            + ", purchaseId="
            + this.purchaseId
            + ", purchaseSn="
            + this.purchaseSn
            + ", receivedUserName="
            + this.receivedUserName
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", rejectQuantity="
            + this.rejectQuantity
            + ", rejectMete="
            + this.rejectMete
            + ", rejectActualReceivedMete="
            + this.rejectActualReceivedMete
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", createTime="
            + this.createTime
            + ", reviewTime="
            + this.reviewTime
            + ", rejectSn="
            + this.rejectSn
            + ", rejectId="
            + this.rejectId
            + ", purchaseDetailsId="
            + this.purchaseDetailsId
            + ", accountingUnit="
            + this.accountingUnit
            + ", measureUnit="
            + this.measureUnit
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", supplier="
            + this.supplier
            + ", project="
            + this.project
            + ", batch="
            + this.batch
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ")";
      }
   }
}

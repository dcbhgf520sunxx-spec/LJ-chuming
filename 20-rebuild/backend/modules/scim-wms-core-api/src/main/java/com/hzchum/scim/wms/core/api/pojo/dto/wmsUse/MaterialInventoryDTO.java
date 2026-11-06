package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;

public class MaterialInventoryDTO {
   private Long id;
   @JsonInclude(Include.NON_NULL)
   private Integer basicClass;
   @JsonInclude(Include.NON_NULL)
   private Long classifyId;
   @JsonInclude(Include.NON_NULL)
   private String classifyName;
   @JsonInclude(Include.NON_NULL)
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   private ProjectInfo project;
   @JsonInclude(Include.NON_NULL)
   private String monomerName;
   @JsonInclude(Include.NON_NULL)
   private Long monomerId;
   @JsonInclude(Include.NON_NULL)
   private String areaName;
   @JsonInclude(Include.NON_NULL)
   private Long areaId;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal quantity;
   @JsonInclude(Include.NON_NULL)
   private String specification;
   @JsonInclude(Include.NON_NULL)
   private String standardName;
   @JsonInclude(Include.NON_NULL)
   private String model;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal width;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal thickness;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal mete;
   @JsonInclude(Include.NON_NULL)
   private String nationalStandard;
   @JsonInclude(Include.NON_NULL)
   private Boolean boolPartyA;
   @JsonInclude(Include.NON_NULL)
   private String brand;
   @JsonInclude(Include.NON_NULL)
   private String remark;
   @JsonInclude(Include.NON_NULL)
   private String heatNoAndBatchNo;
   @JsonInclude(Include.NON_NULL)
   private String barcode;
   @JsonInclude(Include.NON_NULL)
   private String color;
   @JsonInclude(Include.NON_NULL)
   private BriefIdAndNameDTO warehouse;
   @JsonInclude(Include.NON_NULL)
   private BriefIdAndNameDTO workshop;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitNet;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal frozenMete;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal frozenQuantity;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPrice;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPriceExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amount;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amountExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inputVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPriceNoFreight;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPriceExcludingVATNoFreight;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amountNoFreight;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amountExcludingVATNoFreight;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inputVATNoFreight;
   @JsonInclude(Include.NON_NULL)
   private Boolean boolHasFrozen;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime createTime;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime updateTime;
   @JsonInclude(Include.NON_NULL)
   private Integer sort = 0;
   @JsonInclude(Include.NON_NULL)
   private String weightedAverageSpec;
   @JsonInclude(Include.NON_NULL)
   private Long standardId;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal rejectQuantity;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal rejectMete;
   @JsonInclude(Include.NON_NULL)
   private String surplusGraphicsPath;
   @JsonInclude(Include.NON_NULL)
   private String measureUnit;
   @JsonInclude(Include.NON_NULL)
   private String accountingUnit;
   @JsonInclude(Include.NON_NULL)
   private Integer accountingPrecision;
   @JsonInclude(Include.NON_NULL)
   private Integer measurePrecision;
   @JsonInclude(Include.NON_NULL)
   private List<ProjectToFreezeDTO> projectFrozen;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型[1 公共库,2 项目库]")
   private Integer warehouseType;
   @ApiModelProperty(name = "branchCompanyId", value = "签订主体ID")
   private Long branchCompanyId;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态(1 整料, 2余料)")
   private Integer materialIsWhole;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式 [1理计 , 2 磅计 ,混合计]")
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "dxfUrl", value = "app拍照dxfUrl", notes = "app拍照dxfUrl")
   @JsonProperty("dxfUrl")
   @JSONField(name = "dxfUrl")
   @TableField("dxf_url")
   @Column(name = "dxf_url", columnDefinition = "varchar(5000)  COMMENT 'app拍照dxfUrl'", nullable = true)
   private String dxfUrl;
   @ApiModelProperty(name = "imgUrl", value = "app拍照缩略图", notes = "app拍照缩略图")
   @JsonProperty("imgUrl")
   @JSONField(name = "imgUrl")
   @TableField("img_url")
   @Column(name = "img_url", columnDefinition = "varchar(5000)  COMMENT 'app拍照缩略图'", nullable = true)
   private String imgUrl;
   @ApiModelProperty(name = "area", value = "柏楚余料面积", notes = "柏楚余料面积")
   @JsonProperty("area")
   @JSONField(name = "area")
   @TableField("area")
   @Column(name = "area", columnDefinition = "decimal(32,12)  COMMENT ' 柏楚余料面积'", nullable = true)
   private BigDecimal area;
   private String surplusSn;
   private LocalDateTime realTime;
   private String materialSnNew;

   public static MaterialInventoryDTO.MaterialInventoryDTOBuilder builder() {
      return new MaterialInventoryDTO.MaterialInventoryDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public String getModel() {
      return this.model;
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

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getBarcode() {
      return this.barcode;
   }

   public String getColor() {
      return this.color;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public BigDecimal getFrozenMete() {
      return this.frozenMete;
   }

   public BigDecimal getFrozenQuantity() {
      return this.frozenQuantity;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVAT() {
      return this.unitPriceExcludingVAT;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public BigDecimal getInputVAT() {
      return this.inputVAT;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVATNoFreight() {
      return this.unitPriceExcludingVATNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVATNoFreight() {
      return this.amountExcludingVATNoFreight;
   }

   public BigDecimal getInputVATNoFreight() {
      return this.inputVATNoFreight;
   }

   public Boolean getBoolHasFrozen() {
      return this.boolHasFrozen;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getWeightedAverageSpec() {
      return this.weightedAverageSpec;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public BigDecimal getRejectQuantity() {
      return this.rejectQuantity;
   }

   public BigDecimal getRejectMete() {
      return this.rejectMete;
   }

   public String getSurplusGraphicsPath() {
      return this.surplusGraphicsPath;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public List<ProjectToFreezeDTO> getProjectFrozen() {
      return this.projectFrozen;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public String getDxfUrl() {
      return this.dxfUrl;
   }

   public String getImgUrl() {
      return this.imgUrl;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public String getSurplusSn() {
      return this.surplusSn;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setStandardName(final String standardName) {
      this.standardName = standardName;
   }

   public void setModel(final String model) {
      this.model = model;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setBarcode(final String barcode) {
      this.barcode = barcode;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   public void setFrozenMete(final BigDecimal frozenMete) {
      this.frozenMete = frozenMete;
   }

   public void setFrozenQuantity(final BigDecimal frozenQuantity) {
      this.frozenQuantity = frozenQuantity;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setUnitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setInputVAT(final BigDecimal inputVAT) {
      this.inputVAT = inputVAT;
   }

   public void setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
   }

   public void setUnitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
   }

   public void setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
   }

   public void setAmountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
   }

   public void setInputVATNoFreight(final BigDecimal inputVATNoFreight) {
      this.inputVATNoFreight = inputVATNoFreight;
   }

   public void setBoolHasFrozen(final Boolean boolHasFrozen) {
      this.boolHasFrozen = boolHasFrozen;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setWeightedAverageSpec(final String weightedAverageSpec) {
      this.weightedAverageSpec = weightedAverageSpec;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setRejectQuantity(final BigDecimal rejectQuantity) {
      this.rejectQuantity = rejectQuantity;
   }

   public void setRejectMete(final BigDecimal rejectMete) {
      this.rejectMete = rejectMete;
   }

   public void setSurplusGraphicsPath(final String surplusGraphicsPath) {
      this.surplusGraphicsPath = surplusGraphicsPath;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setProjectFrozen(final List<ProjectToFreezeDTO> projectFrozen) {
      this.projectFrozen = projectFrozen;
   }

   public void setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   @JsonProperty("dxfUrl")
   public void setDxfUrl(final String dxfUrl) {
      this.dxfUrl = dxfUrl;
   }

   @JsonProperty("imgUrl")
   public void setImgUrl(final String imgUrl) {
      this.imgUrl = imgUrl;
   }

   @JsonProperty("area")
   public void setArea(final BigDecimal area) {
      this.area = area;
   }

   public void setSurplusSn(final String surplusSn) {
      this.surplusSn = surplusSn;
   }

   public void setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialInventoryDTO)) {
         return false;
      }

      MaterialInventoryDTO other = (MaterialInventoryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$boolPartyA = this.getBoolPartyA();
                     Object other$boolPartyA = other.getBoolPartyA();
                     if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                        Object this$boolHasFrozen = this.getBoolHasFrozen();
                        Object other$boolHasFrozen = other.getBoolHasFrozen();
                        if (this$boolHasFrozen == null ? other$boolHasFrozen == null : this$boolHasFrozen.equals(other$boolHasFrozen)) {
                           Object this$sort = this.getSort();
                           Object other$sort = other.getSort();
                           if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                              Object this$standardId = this.getStandardId();
                              Object other$standardId = other.getStandardId();
                              if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                 Object this$accountingPrecision = this.getAccountingPrecision();
                                 Object other$accountingPrecision = other.getAccountingPrecision();
                                 if (this$accountingPrecision == null
                                    ? other$accountingPrecision == null
                                    : this$accountingPrecision.equals(other$accountingPrecision)) {
                                    Object this$measurePrecision = this.getMeasurePrecision();
                                    Object other$measurePrecision = other.getMeasurePrecision();
                                    if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                                       Object this$warehouseType = this.getWarehouseType();
                                       Object other$warehouseType = other.getWarehouseType();
                                       if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                                          Object this$branchCompanyId = this.getBranchCompanyId();
                                          Object other$branchCompanyId = other.getBranchCompanyId();
                                          if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)
                                             )
                                           {
                                             Object this$materialIsWhole = this.getMaterialIsWhole();
                                             Object other$materialIsWhole = other.getMaterialIsWhole();
                                             if (this$materialIsWhole == null
                                                ? other$materialIsWhole == null
                                                : this$materialIsWhole.equals(other$materialIsWhole)) {
                                                Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                                Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                                if (this$weightMeasurementMode == null
                                                   ? other$weightMeasurementMode == null
                                                   : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                                   Object this$classifyName = this.getClassifyName();
                                                   Object other$classifyName = other.getClassifyName();
                                                   if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                                      Object this$serialNumber = this.getSerialNumber();
                                                      Object other$serialNumber = other.getSerialNumber();
                                                      if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)
                                                         )
                                                       {
                                                         Object this$project = this.getProject();
                                                         Object other$project = other.getProject();
                                                         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                            Object this$monomerName = this.getMonomerName();
                                                            Object other$monomerName = other.getMonomerName();
                                                            if (this$monomerName == null
                                                               ? other$monomerName == null
                                                               : this$monomerName.equals(other$monomerName)) {
                                                               Object this$areaName = this.getAreaName();
                                                               Object other$areaName = other.getAreaName();
                                                               if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                                  Object this$quantity = this.getQuantity();
                                                                  Object other$quantity = other.getQuantity();
                                                                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                                     Object this$specification = this.getSpecification();
                                                                     Object other$specification = other.getSpecification();
                                                                     if (this$specification == null
                                                                        ? other$specification == null
                                                                        : this$specification.equals(other$specification)) {
                                                                        Object this$standardName = this.getStandardName();
                                                                        Object other$standardName = other.getStandardName();
                                                                        if (this$standardName == null
                                                                           ? other$standardName == null
                                                                           : this$standardName.equals(other$standardName)) {
                                                                           Object this$model = this.getModel();
                                                                           Object other$model = other.getModel();
                                                                           if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                                                                              Object this$length = this.getLength();
                                                                              Object other$length = other.getLength();
                                                                              if (this$length == null ? other$length == null : this$length.equals(other$length)
                                                                                 )
                                                                               {
                                                                                 Object this$width = this.getWidth();
                                                                                 Object other$width = other.getWidth();
                                                                                 if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                                    Object this$thickness = this.getThickness();
                                                                                    Object other$thickness = other.getThickness();
                                                                                    if (this$thickness == null
                                                                                       ? other$thickness == null
                                                                                       : this$thickness.equals(other$thickness)) {
                                                                                       Object this$mete = this.getMete();
                                                                                       Object other$mete = other.getMete();
                                                                                       if (this$mete == null
                                                                                          ? other$mete == null
                                                                                          : this$mete.equals(other$mete)) {
                                                                                          Object this$nationalStandard = this.getNationalStandard();
                                                                                          Object other$nationalStandard = other.getNationalStandard();
                                                                                          if (this$nationalStandard == null
                                                                                             ? other$nationalStandard == null
                                                                                             : this$nationalStandard.equals(other$nationalStandard)) {
                                                                                             Object this$brand = this.getBrand();
                                                                                             Object other$brand = other.getBrand();
                                                                                             if (this$brand == null
                                                                                                ? other$brand == null
                                                                                                : this$brand.equals(other$brand)) {
                                                                                                Object this$remark = this.getRemark();
                                                                                                Object other$remark = other.getRemark();
                                                                                                if (this$remark == null
                                                                                                   ? other$remark == null
                                                                                                   : this$remark.equals(other$remark)) {
                                                                                                   Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                   Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                   if (this$heatNoAndBatchNo == null
                                                                                                      ? other$heatNoAndBatchNo == null
                                                                                                      : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                                      Object this$barcode = this.getBarcode();
                                                                                                      Object other$barcode = other.getBarcode();
                                                                                                      if (this$barcode == null
                                                                                                         ? other$barcode == null
                                                                                                         : this$barcode.equals(other$barcode)) {
                                                                                                         Object this$color = this.getColor();
                                                                                                         Object other$color = other.getColor();
                                                                                                         if (this$color == null
                                                                                                            ? other$color == null
                                                                                                            : this$color.equals(other$color)) {
                                                                                                            Object this$warehouse = this.getWarehouse();
                                                                                                            Object other$warehouse = other.getWarehouse();
                                                                                                            if (this$warehouse == null
                                                                                                               ? other$warehouse == null
                                                                                                               : this$warehouse.equals(other$warehouse)) {
                                                                                                               Object this$workshop = this.getWorkshop();
                                                                                                               Object other$workshop = other.getWorkshop();
                                                                                                               if (this$workshop == null
                                                                                                                  ? other$workshop == null
                                                                                                                  : this$workshop.equals(other$workshop)) {
                                                                                                                  Object this$unitNet = this.getUnitNet();
                                                                                                                  Object other$unitNet = other.getUnitNet();
                                                                                                                  if (this$unitNet == null
                                                                                                                     ? other$unitNet == null
                                                                                                                     : this$unitNet.equals(other$unitNet)) {
                                                                                                                     Object this$frozenMete = this.getFrozenMete();
                                                                                                                     Object other$frozenMete = other.getFrozenMete();
                                                                                                                     if (this$frozenMete == null
                                                                                                                        ? other$frozenMete == null
                                                                                                                        : this$frozenMete.equals(
                                                                                                                           other$frozenMete
                                                                                                                        )) {
                                                                                                                        Object this$frozenQuantity = this.getFrozenQuantity();
                                                                                                                        Object other$frozenQuantity = other.getFrozenQuantity();
                                                                                                                        if (this$frozenQuantity == null
                                                                                                                           ? other$frozenQuantity == null
                                                                                                                           : this$frozenQuantity.equals(
                                                                                                                              other$frozenQuantity
                                                                                                                           )) {
                                                                                                                           Object this$unitPrice = this.getUnitPrice();
                                                                                                                           Object other$unitPrice = other.getUnitPrice();
                                                                                                                           if (this$unitPrice == null
                                                                                                                              ? other$unitPrice == null
                                                                                                                              : this$unitPrice.equals(
                                                                                                                                 other$unitPrice
                                                                                                                              )) {
                                                                                                                              Object this$unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
                                                                                                                              Object other$unitPriceExcludingVAT = other.getUnitPriceExcludingVAT();
                                                                                                                              if (this$unitPriceExcludingVAT
                                                                                                                                    == null
                                                                                                                                 ? other$unitPriceExcludingVAT
                                                                                                                                    == null
                                                                                                                                 : this$unitPriceExcludingVAT.equals(
                                                                                                                                    other$unitPriceExcludingVAT
                                                                                                                                 )) {
                                                                                                                                 Object this$amount = this.getAmount();
                                                                                                                                 Object other$amount = other.getAmount();
                                                                                                                                 if (this$amount == null
                                                                                                                                    ? other$amount == null
                                                                                                                                    : this$amount.equals(
                                                                                                                                       other$amount
                                                                                                                                    )) {
                                                                                                                                    Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                                                                                                                                    Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                                                                                                                                    if (this$amountExcludingVAT
                                                                                                                                          == null
                                                                                                                                       ? other$amountExcludingVAT
                                                                                                                                          == null
                                                                                                                                       : this$amountExcludingVAT.equals(
                                                                                                                                          other$amountExcludingVAT
                                                                                                                                       )) {
                                                                                                                                       Object this$inputVAT = this.getInputVAT();
                                                                                                                                       Object other$inputVAT = other.getInputVAT();
                                                                                                                                       if (this$inputVAT
                                                                                                                                             == null
                                                                                                                                          ? other$inputVAT
                                                                                                                                             == null
                                                                                                                                          : this$inputVAT.equals(
                                                                                                                                             other$inputVAT
                                                                                                                                          )) {
                                                                                                                                          Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                                                                          Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                                                                          if (this$unitPriceNoFreight
                                                                                                                                                == null
                                                                                                                                             ? other$unitPriceNoFreight
                                                                                                                                                == null
                                                                                                                                             : this$unitPriceNoFreight.equals(
                                                                                                                                                other$unitPriceNoFreight
                                                                                                                                             )) {
                                                                                                                                             Object this$unitPriceExcludingVATNoFreight = this.getUnitPriceExcludingVATNoFreight();
                                                                                                                                             Object other$unitPriceExcludingVATNoFreight = other.getUnitPriceExcludingVATNoFreight();
                                                                                                                                             if (this$unitPriceExcludingVATNoFreight
                                                                                                                                                   == null
                                                                                                                                                ? other$unitPriceExcludingVATNoFreight
                                                                                                                                                   == null
                                                                                                                                                : this$unitPriceExcludingVATNoFreight.equals(
                                                                                                                                                   other$unitPriceExcludingVATNoFreight
                                                                                                                                                )) {
                                                                                                                                                Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                                                                                Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                                                                                if (this$amountNoFreight
                                                                                                                                                      == null
                                                                                                                                                   ? other$amountNoFreight
                                                                                                                                                      == null
                                                                                                                                                   : this$amountNoFreight.equals(
                                                                                                                                                      other$amountNoFreight
                                                                                                                                                   )) {
                                                                                                                                                   Object this$amountExcludingVATNoFreight = this.getAmountExcludingVATNoFreight();
                                                                                                                                                   Object other$amountExcludingVATNoFreight = other.getAmountExcludingVATNoFreight();
                                                                                                                                                   if (this$amountExcludingVATNoFreight
                                                                                                                                                         == null
                                                                                                                                                      ? other$amountExcludingVATNoFreight
                                                                                                                                                         == null
                                                                                                                                                      : this$amountExcludingVATNoFreight.equals(
                                                                                                                                                         other$amountExcludingVATNoFreight
                                                                                                                                                      )) {
                                                                                                                                                      Object this$inputVATNoFreight = this.getInputVATNoFreight();
                                                                                                                                                      Object other$inputVATNoFreight = other.getInputVATNoFreight();
                                                                                                                                                      if (this$inputVATNoFreight
                                                                                                                                                            == null
                                                                                                                                                         ? other$inputVATNoFreight
                                                                                                                                                            == null
                                                                                                                                                         : this$inputVATNoFreight.equals(
                                                                                                                                                            other$inputVATNoFreight
                                                                                                                                                         )) {
                                                                                                                                                         Object this$createTime = this.getCreateTime();
                                                                                                                                                         Object other$createTime = other.getCreateTime();
                                                                                                                                                         if (this$createTime
                                                                                                                                                               == null
                                                                                                                                                            ? other$createTime
                                                                                                                                                               == null
                                                                                                                                                            : this$createTime.equals(
                                                                                                                                                               other$createTime
                                                                                                                                                            )) {
                                                                                                                                                            Object this$updateTime = this.getUpdateTime();
                                                                                                                                                            Object other$updateTime = other.getUpdateTime();
                                                                                                                                                            if (this$updateTime
                                                                                                                                                                  == null
                                                                                                                                                               ? other$updateTime
                                                                                                                                                                  == null
                                                                                                                                                               : this$updateTime.equals(
                                                                                                                                                                  other$updateTime
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$weightedAverageSpec = this.getWeightedAverageSpec();
                                                                                                                                                               Object other$weightedAverageSpec = other.getWeightedAverageSpec();
                                                                                                                                                               if (this$weightedAverageSpec
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$weightedAverageSpec
                                                                                                                                                                     == null
                                                                                                                                                                  : this$weightedAverageSpec.equals(
                                                                                                                                                                     other$weightedAverageSpec
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$rejectQuantity = this.getRejectQuantity();
                                                                                                                                                                  Object other$rejectQuantity = other.getRejectQuantity();
                                                                                                                                                                  if (this$rejectQuantity
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$rejectQuantity
                                                                                                                                                                        == null
                                                                                                                                                                     : this$rejectQuantity.equals(
                                                                                                                                                                        other$rejectQuantity
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$rejectMete = this.getRejectMete();
                                                                                                                                                                     Object other$rejectMete = other.getRejectMete();
                                                                                                                                                                     if (this$rejectMete
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$rejectMete
                                                                                                                                                                           == null
                                                                                                                                                                        : this$rejectMete.equals(
                                                                                                                                                                           other$rejectMete
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$surplusGraphicsPath = this.getSurplusGraphicsPath();
                                                                                                                                                                        Object other$surplusGraphicsPath = other.getSurplusGraphicsPath();
                                                                                                                                                                        if (this$surplusGraphicsPath
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$surplusGraphicsPath
                                                                                                                                                                              == null
                                                                                                                                                                           : this$surplusGraphicsPath.equals(
                                                                                                                                                                              other$surplusGraphicsPath
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$measureUnit = this.getMeasureUnit();
                                                                                                                                                                           Object other$measureUnit = other.getMeasureUnit();
                                                                                                                                                                           if (this$measureUnit
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$measureUnit
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$measureUnit.equals(
                                                                                                                                                                                 other$measureUnit
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$accountingUnit = this.getAccountingUnit();
                                                                                                                                                                              Object other$accountingUnit = other.getAccountingUnit();
                                                                                                                                                                              if (this$accountingUnit
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$accountingUnit
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$accountingUnit.equals(
                                                                                                                                                                                    other$accountingUnit
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$projectFrozen = this.getProjectFrozen();
                                                                                                                                                                                 Object other$projectFrozen = other.getProjectFrozen();
                                                                                                                                                                                 if (this$projectFrozen
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$projectFrozen
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$projectFrozen.equals(
                                                                                                                                                                                       other$projectFrozen
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$dxfUrl = this.getDxfUrl();
                                                                                                                                                                                    Object other$dxfUrl = other.getDxfUrl();
                                                                                                                                                                                    if (this$dxfUrl
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$dxfUrl
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$dxfUrl.equals(
                                                                                                                                                                                          other$dxfUrl
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$imgUrl = this.getImgUrl();
                                                                                                                                                                                       Object other$imgUrl = other.getImgUrl();
                                                                                                                                                                                       if (this$imgUrl
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$imgUrl
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$imgUrl.equals(
                                                                                                                                                                                             other$imgUrl
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$area = this.getArea();
                                                                                                                                                                                          Object other$area = other.getArea();
                                                                                                                                                                                          if (this$area
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$area
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$area.equals(
                                                                                                                                                                                                other$area
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$surplusSn = this.getSurplusSn();
                                                                                                                                                                                             Object other$surplusSn = other.getSurplusSn();
                                                                                                                                                                                             if (this$surplusSn
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$surplusSn
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$surplusSn.equals(
                                                                                                                                                                                                   other$surplusSn
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$realTime = this.getRealTime();
                                                                                                                                                                                                Object other$realTime = other.getRealTime();
                                                                                                                                                                                                if (this$realTime
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$realTime
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$realTime.equals(
                                                                                                                                                                                                      other$realTime
                                                                                                                                                                                                   )
                                                                                                                                                                                                   )
                                                                                                                                                                                                 {
                                                                                                                                                                                                   Object this$materialSnNew = this.getMaterialSnNew();
                                                                                                                                                                                                   Object other$materialSnNew = other.getMaterialSnNew();
                                                                                                                                                                                                   return this$materialSnNew
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      ? other$materialSnNew
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      : this$materialSnNew.equals(
                                                                                                                                                                                                         other$materialSnNew
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
      return other instanceof MaterialInventoryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $boolHasFrozen = this.getBoolHasFrozen();
      result = result * 59 + ($boolHasFrozen == null ? 43 : $boolHasFrozen.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $barcode = this.getBarcode();
      result = result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $frozenMete = this.getFrozenMete();
      result = result * 59 + ($frozenMete == null ? 43 : $frozenMete.hashCode());
      Object $frozenQuantity = this.getFrozenQuantity();
      result = result * 59 + ($frozenQuantity == null ? 43 : $frozenQuantity.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
      result = result * 59 + ($unitPriceExcludingVAT == null ? 43 : $unitPriceExcludingVAT.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $inputVAT = this.getInputVAT();
      result = result * 59 + ($inputVAT == null ? 43 : $inputVAT.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $unitPriceExcludingVATNoFreight = this.getUnitPriceExcludingVATNoFreight();
      result = result * 59 + ($unitPriceExcludingVATNoFreight == null ? 43 : $unitPriceExcludingVATNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVATNoFreight = this.getAmountExcludingVATNoFreight();
      result = result * 59 + ($amountExcludingVATNoFreight == null ? 43 : $amountExcludingVATNoFreight.hashCode());
      Object $inputVATNoFreight = this.getInputVATNoFreight();
      result = result * 59 + ($inputVATNoFreight == null ? 43 : $inputVATNoFreight.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $weightedAverageSpec = this.getWeightedAverageSpec();
      result = result * 59 + ($weightedAverageSpec == null ? 43 : $weightedAverageSpec.hashCode());
      Object $rejectQuantity = this.getRejectQuantity();
      result = result * 59 + ($rejectQuantity == null ? 43 : $rejectQuantity.hashCode());
      Object $rejectMete = this.getRejectMete();
      result = result * 59 + ($rejectMete == null ? 43 : $rejectMete.hashCode());
      Object $surplusGraphicsPath = this.getSurplusGraphicsPath();
      result = result * 59 + ($surplusGraphicsPath == null ? 43 : $surplusGraphicsPath.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $projectFrozen = this.getProjectFrozen();
      result = result * 59 + ($projectFrozen == null ? 43 : $projectFrozen.hashCode());
      Object $dxfUrl = this.getDxfUrl();
      result = result * 59 + ($dxfUrl == null ? 43 : $dxfUrl.hashCode());
      Object $imgUrl = this.getImgUrl();
      result = result * 59 + ($imgUrl == null ? 43 : $imgUrl.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $surplusSn = this.getSurplusSn();
      result = result * 59 + ($surplusSn == null ? 43 : $surplusSn.hashCode());
      Object $realTime = this.getRealTime();
      result = result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      return result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialInventoryDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaName="
         + this.getAreaName()
         + ", areaId="
         + this.getAreaId()
         + ", quantity="
         + this.getQuantity()
         + ", specification="
         + this.getSpecification()
         + ", standardName="
         + this.getStandardName()
         + ", model="
         + this.getModel()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", mete="
         + this.getMete()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", brand="
         + this.getBrand()
         + ", remark="
         + this.getRemark()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", barcode="
         + this.getBarcode()
         + ", color="
         + this.getColor()
         + ", warehouse="
         + this.getWarehouse()
         + ", workshop="
         + this.getWorkshop()
         + ", unitNet="
         + this.getUnitNet()
         + ", frozenMete="
         + this.getFrozenMete()
         + ", frozenQuantity="
         + this.getFrozenQuantity()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVAT="
         + this.getUnitPriceExcludingVAT()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", inputVAT="
         + this.getInputVAT()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", unitPriceExcludingVATNoFreight="
         + this.getUnitPriceExcludingVATNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVATNoFreight="
         + this.getAmountExcludingVATNoFreight()
         + ", inputVATNoFreight="
         + this.getInputVATNoFreight()
         + ", boolHasFrozen="
         + this.getBoolHasFrozen()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", sort="
         + this.getSort()
         + ", weightedAverageSpec="
         + this.getWeightedAverageSpec()
         + ", standardId="
         + this.getStandardId()
         + ", rejectQuantity="
         + this.getRejectQuantity()
         + ", rejectMete="
         + this.getRejectMete()
         + ", surplusGraphicsPath="
         + this.getSurplusGraphicsPath()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", projectFrozen="
         + this.getProjectFrozen()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", dxfUrl="
         + this.getDxfUrl()
         + ", imgUrl="
         + this.getImgUrl()
         + ", area="
         + this.getArea()
         + ", surplusSn="
         + this.getSurplusSn()
         + ", realTime="
         + this.getRealTime()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ")";
   }

   public MaterialInventoryDTO(
      final Long id,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String serialNumber,
      final ProjectInfo project,
      final String monomerName,
      final Long monomerId,
      final String areaName,
      final Long areaId,
      final BigDecimal quantity,
      final String specification,
      final String standardName,
      final String model,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal mete,
      final String nationalStandard,
      final Boolean boolPartyA,
      final String brand,
      final String remark,
      final String heatNoAndBatchNo,
      final String barcode,
      final String color,
      final BriefIdAndNameDTO warehouse,
      final BriefIdAndNameDTO workshop,
      final BigDecimal unitNet,
      final BigDecimal frozenMete,
      final BigDecimal frozenQuantity,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVATNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVATNoFreight,
      final BigDecimal inputVATNoFreight,
      final Boolean boolHasFrozen,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final Integer sort,
      final String weightedAverageSpec,
      final Long standardId,
      final BigDecimal rejectQuantity,
      final BigDecimal rejectMete,
      final String surplusGraphicsPath,
      final String measureUnit,
      final String accountingUnit,
      final Integer accountingPrecision,
      final Integer measurePrecision,
      final List<ProjectToFreezeDTO> projectFrozen,
      final Integer warehouseType,
      final Long branchCompanyId,
      final Integer materialIsWhole,
      final Integer weightMeasurementMode,
      final String dxfUrl,
      final String imgUrl,
      final BigDecimal area,
      final String surplusSn,
      final LocalDateTime realTime,
      final String materialSnNew
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.serialNumber = serialNumber;
      this.project = project;
      this.monomerName = monomerName;
      this.monomerId = monomerId;
      this.areaName = areaName;
      this.areaId = areaId;
      this.quantity = quantity;
      this.specification = specification;
      this.standardName = standardName;
      this.model = model;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.mete = mete;
      this.nationalStandard = nationalStandard;
      this.boolPartyA = boolPartyA;
      this.brand = brand;
      this.remark = remark;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.barcode = barcode;
      this.color = color;
      this.warehouse = warehouse;
      this.workshop = workshop;
      this.unitNet = unitNet;
      this.frozenMete = frozenMete;
      this.frozenQuantity = frozenQuantity;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
      this.inputVATNoFreight = inputVATNoFreight;
      this.boolHasFrozen = boolHasFrozen;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.sort = sort;
      this.weightedAverageSpec = weightedAverageSpec;
      this.standardId = standardId;
      this.rejectQuantity = rejectQuantity;
      this.rejectMete = rejectMete;
      this.surplusGraphicsPath = surplusGraphicsPath;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.measurePrecision = measurePrecision;
      this.projectFrozen = projectFrozen;
      this.warehouseType = warehouseType;
      this.branchCompanyId = branchCompanyId;
      this.materialIsWhole = materialIsWhole;
      this.weightMeasurementMode = weightMeasurementMode;
      this.dxfUrl = dxfUrl;
      this.imgUrl = imgUrl;
      this.area = area;
      this.surplusSn = surplusSn;
      this.realTime = realTime;
      this.materialSnNew = materialSnNew;
   }

   public MaterialInventoryDTO() {
   }

   public static class MaterialInventoryDTOBuilder {
      private Long id;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String serialNumber;
      private ProjectInfo project;
      private String monomerName;
      private Long monomerId;
      private String areaName;
      private Long areaId;
      private BigDecimal quantity;
      private String specification;
      private String standardName;
      private String model;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal mete;
      private String nationalStandard;
      private Boolean boolPartyA;
      private String brand;
      private String remark;
      private String heatNoAndBatchNo;
      private String barcode;
      private String color;
      private BriefIdAndNameDTO warehouse;
      private BriefIdAndNameDTO workshop;
      private BigDecimal unitNet;
      private BigDecimal frozenMete;
      private BigDecimal frozenQuantity;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVATNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVATNoFreight;
      private BigDecimal inputVATNoFreight;
      private Boolean boolHasFrozen;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private Integer sort;
      private String weightedAverageSpec;
      private Long standardId;
      private BigDecimal rejectQuantity;
      private BigDecimal rejectMete;
      private String surplusGraphicsPath;
      private String measureUnit;
      private String accountingUnit;
      private Integer accountingPrecision;
      private Integer measurePrecision;
      private List<ProjectToFreezeDTO> projectFrozen;
      private Integer warehouseType;
      private Long branchCompanyId;
      private Integer materialIsWhole;
      private Integer weightMeasurementMode;
      private String dxfUrl;
      private String imgUrl;
      private BigDecimal area;
      private String surplusSn;
      private LocalDateTime realTime;
      private String materialSnNew;

      MaterialInventoryDTOBuilder() {
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder model(final String model) {
         this.model = model;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder frozenMete(final BigDecimal frozenMete) {
         this.frozenMete = frozenMete;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder frozenQuantity(final BigDecimal frozenQuantity) {
         this.frozenQuantity = frozenQuantity;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder unitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
         this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder amountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
         this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder inputVATNoFreight(final BigDecimal inputVATNoFreight) {
         this.inputVATNoFreight = inputVATNoFreight;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder boolHasFrozen(final Boolean boolHasFrozen) {
         this.boolHasFrozen = boolHasFrozen;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder weightedAverageSpec(final String weightedAverageSpec) {
         this.weightedAverageSpec = weightedAverageSpec;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder rejectQuantity(final BigDecimal rejectQuantity) {
         this.rejectQuantity = rejectQuantity;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder rejectMete(final BigDecimal rejectMete) {
         this.rejectMete = rejectMete;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder surplusGraphicsPath(final String surplusGraphicsPath) {
         this.surplusGraphicsPath = surplusGraphicsPath;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder projectFrozen(final List<ProjectToFreezeDTO> projectFrozen) {
         this.projectFrozen = projectFrozen;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      @JsonProperty("dxfUrl")
      public MaterialInventoryDTO.MaterialInventoryDTOBuilder dxfUrl(final String dxfUrl) {
         this.dxfUrl = dxfUrl;
         return this;
      }

      @JsonProperty("imgUrl")
      public MaterialInventoryDTO.MaterialInventoryDTOBuilder imgUrl(final String imgUrl) {
         this.imgUrl = imgUrl;
         return this;
      }

      @JsonProperty("area")
      public MaterialInventoryDTO.MaterialInventoryDTOBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder surplusSn(final String surplusSn) {
         this.surplusSn = surplusSn;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public MaterialInventoryDTO.MaterialInventoryDTOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public MaterialInventoryDTO build() {
         return new MaterialInventoryDTO(
            this.id,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.serialNumber,
            this.project,
            this.monomerName,
            this.monomerId,
            this.areaName,
            this.areaId,
            this.quantity,
            this.specification,
            this.standardName,
            this.model,
            this.length,
            this.width,
            this.thickness,
            this.mete,
            this.nationalStandard,
            this.boolPartyA,
            this.brand,
            this.remark,
            this.heatNoAndBatchNo,
            this.barcode,
            this.color,
            this.warehouse,
            this.workshop,
            this.unitNet,
            this.frozenMete,
            this.frozenQuantity,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVATNoFreight,
            this.amountNoFreight,
            this.amountExcludingVATNoFreight,
            this.inputVATNoFreight,
            this.boolHasFrozen,
            this.createTime,
            this.updateTime,
            this.sort,
            this.weightedAverageSpec,
            this.standardId,
            this.rejectQuantity,
            this.rejectMete,
            this.surplusGraphicsPath,
            this.measureUnit,
            this.accountingUnit,
            this.accountingPrecision,
            this.measurePrecision,
            this.projectFrozen,
            this.warehouseType,
            this.branchCompanyId,
            this.materialIsWhole,
            this.weightMeasurementMode,
            this.dxfUrl,
            this.imgUrl,
            this.area,
            this.surplusSn,
            this.realTime,
            this.materialSnNew
         );
      }

      @Override
      public String toString() {
         return "MaterialInventoryDTO.MaterialInventoryDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", serialNumber="
            + this.serialNumber
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", monomerId="
            + this.monomerId
            + ", areaName="
            + this.areaName
            + ", areaId="
            + this.areaId
            + ", quantity="
            + this.quantity
            + ", specification="
            + this.specification
            + ", standardName="
            + this.standardName
            + ", model="
            + this.model
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", mete="
            + this.mete
            + ", nationalStandard="
            + this.nationalStandard
            + ", boolPartyA="
            + this.boolPartyA
            + ", brand="
            + this.brand
            + ", remark="
            + this.remark
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", barcode="
            + this.barcode
            + ", color="
            + this.color
            + ", warehouse="
            + this.warehouse
            + ", workshop="
            + this.workshop
            + ", unitNet="
            + this.unitNet
            + ", frozenMete="
            + this.frozenMete
            + ", frozenQuantity="
            + this.frozenQuantity
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVAT="
            + this.unitPriceExcludingVAT
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", inputVAT="
            + this.inputVAT
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", unitPriceExcludingVATNoFreight="
            + this.unitPriceExcludingVATNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVATNoFreight="
            + this.amountExcludingVATNoFreight
            + ", inputVATNoFreight="
            + this.inputVATNoFreight
            + ", boolHasFrozen="
            + this.boolHasFrozen
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", sort="
            + this.sort
            + ", weightedAverageSpec="
            + this.weightedAverageSpec
            + ", standardId="
            + this.standardId
            + ", rejectQuantity="
            + this.rejectQuantity
            + ", rejectMete="
            + this.rejectMete
            + ", surplusGraphicsPath="
            + this.surplusGraphicsPath
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", measurePrecision="
            + this.measurePrecision
            + ", projectFrozen="
            + this.projectFrozen
            + ", warehouseType="
            + this.warehouseType
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", dxfUrl="
            + this.dxfUrl
            + ", imgUrl="
            + this.imgUrl
            + ", area="
            + this.area
            + ", surplusSn="
            + this.surplusSn
            + ", realTime="
            + this.realTime
            + ", materialSnNew="
            + this.materialSnNew
            + ")";
      }
   }
}

package com.hzchum.scim.scm.core.api.pojo.dto;

import java.math.BigDecimal;
import java.util.List;

public class ArtifactAndAssembleDTO {
   private Long id;
   private Long projectId;
   private Long monomerId;
   private String monomerName;
   private Long areaId;
   private String areaName;
   private Long oldArtifactId;
   private String oldArtifactSerialNumber;
   private Boolean boolStatusEnum;
   private Boolean boolAbnormalEnum;
   private String name;
   private String serialNumber;
   private String specification;
   private BigDecimal length;
   private String material;
   private Integer quantity;
   private BigDecimal netWeight;
   private BigDecimal totalNetWeight;
   private BigDecimal grossWeight;
   private BigDecimal totalGrossWeight;
   private BigDecimal surfaceArea;
   private String drawingNumber;
   private String remark;
   private Long userId;
   private Long businessId;
   private Integer producedQuantity;
   private Integer areaType;
   private String specPrefix;
   private Integer usedQuantity;
   private String machinePartFront;
   private Long machinePartId;
   private Boolean boolSchedulingEnum;
   private Integer issuedQuantity;
   private Integer issuedTotalQuantity;
   private Integer inboundQuantity;
   private Integer category;
   private String brand;
   private String plate;
   private String color;
   private BigDecimal weight;
   private BigDecimal thickness;
   private String coating;
   private String plating;
   private BigDecimal width;
   private BigDecimal unfoldedWidth;
   private BigDecimal totalLength;
   private BigDecimal totalArea;
   private Long attachmentId;
   private Integer bendTimes;
   private List<BriefIdAndSNDTO> techChange;

   public static ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder builder() {
      return new ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getOldArtifactId() {
      return this.oldArtifactId;
   }

   public String getOldArtifactSerialNumber() {
      return this.oldArtifactSerialNumber;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public String getMachinePartFront() {
      return this.machinePartFront;
   }

   public Long getMachinePartId() {
      return this.machinePartId;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Integer getIssuedQuantity() {
      return this.issuedQuantity;
   }

   public Integer getIssuedTotalQuantity() {
      return this.issuedTotalQuantity;
   }

   public Integer getInboundQuantity() {
      return this.inboundQuantity;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getCoating() {
      return this.coating;
   }

   public String getPlating() {
      return this.plating;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public Integer getBendTimes() {
      return this.bendTimes;
   }

   public List<BriefIdAndSNDTO> getTechChange() {
      return this.techChange;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setOldArtifactId(final Long oldArtifactId) {
      this.oldArtifactId = oldArtifactId;
   }

   public void setOldArtifactSerialNumber(final String oldArtifactSerialNumber) {
      this.oldArtifactSerialNumber = oldArtifactSerialNumber;
   }

   public void setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
   }

   public void setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setBusinessId(final Long businessId) {
      this.businessId = businessId;
   }

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setAreaType(final Integer areaType) {
      this.areaType = areaType;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
   }

   public void setMachinePartFront(final String machinePartFront) {
      this.machinePartFront = machinePartFront;
   }

   public void setMachinePartId(final Long machinePartId) {
      this.machinePartId = machinePartId;
   }

   public void setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   public void setIssuedQuantity(final Integer issuedQuantity) {
      this.issuedQuantity = issuedQuantity;
   }

   public void setIssuedTotalQuantity(final Integer issuedTotalQuantity) {
      this.issuedTotalQuantity = issuedTotalQuantity;
   }

   public void setInboundQuantity(final Integer inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setCoating(final String coating) {
      this.coating = coating;
   }

   public void setPlating(final String plating) {
      this.plating = plating;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
   }

   public void setTechChange(final List<BriefIdAndSNDTO> techChange) {
      this.techChange = techChange;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactAndAssembleDTO)) {
         return false;
      }

      ArtifactAndAssembleDTO other = (ArtifactAndAssembleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$oldArtifactId = this.getOldArtifactId();
                  Object other$oldArtifactId = other.getOldArtifactId();
                  if (this$oldArtifactId == null ? other$oldArtifactId == null : this$oldArtifactId.equals(other$oldArtifactId)) {
                     Object this$boolStatusEnum = this.getBoolStatusEnum();
                     Object other$boolStatusEnum = other.getBoolStatusEnum();
                     if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                        Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                        Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                        if (this$boolAbnormalEnum == null ? other$boolAbnormalEnum == null : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$businessId = this.getBusinessId();
                                 Object other$businessId = other.getBusinessId();
                                 if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                                    Object this$producedQuantity = this.getProducedQuantity();
                                    Object other$producedQuantity = other.getProducedQuantity();
                                    if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                                       Object this$areaType = this.getAreaType();
                                       Object other$areaType = other.getAreaType();
                                       if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
                                          Object this$usedQuantity = this.getUsedQuantity();
                                          Object other$usedQuantity = other.getUsedQuantity();
                                          if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                                             Object this$machinePartId = this.getMachinePartId();
                                             Object other$machinePartId = other.getMachinePartId();
                                             if (this$machinePartId == null ? other$machinePartId == null : this$machinePartId.equals(other$machinePartId)) {
                                                Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
                                                Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
                                                if (this$boolSchedulingEnum == null
                                                   ? other$boolSchedulingEnum == null
                                                   : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                                                   Object this$issuedQuantity = this.getIssuedQuantity();
                                                   Object other$issuedQuantity = other.getIssuedQuantity();
                                                   if (this$issuedQuantity == null
                                                      ? other$issuedQuantity == null
                                                      : this$issuedQuantity.equals(other$issuedQuantity)) {
                                                      Object this$issuedTotalQuantity = this.getIssuedTotalQuantity();
                                                      Object other$issuedTotalQuantity = other.getIssuedTotalQuantity();
                                                      if (this$issuedTotalQuantity == null
                                                         ? other$issuedTotalQuantity == null
                                                         : this$issuedTotalQuantity.equals(other$issuedTotalQuantity)) {
                                                         Object this$inboundQuantity = this.getInboundQuantity();
                                                         Object other$inboundQuantity = other.getInboundQuantity();
                                                         if (this$inboundQuantity == null
                                                            ? other$inboundQuantity == null
                                                            : this$inboundQuantity.equals(other$inboundQuantity)) {
                                                            Object this$category = this.getCategory();
                                                            Object other$category = other.getCategory();
                                                            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                                               Object this$attachmentId = this.getAttachmentId();
                                                               Object other$attachmentId = other.getAttachmentId();
                                                               if (this$attachmentId == null
                                                                  ? other$attachmentId == null
                                                                  : this$attachmentId.equals(other$attachmentId)) {
                                                                  Object this$bendTimes = this.getBendTimes();
                                                                  Object other$bendTimes = other.getBendTimes();
                                                                  if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)
                                                                     )
                                                                   {
                                                                     Object this$monomerName = this.getMonomerName();
                                                                     Object other$monomerName = other.getMonomerName();
                                                                     if (this$monomerName == null
                                                                        ? other$monomerName == null
                                                                        : this$monomerName.equals(other$monomerName)) {
                                                                        Object this$areaName = this.getAreaName();
                                                                        Object other$areaName = other.getAreaName();
                                                                        if (this$areaName == null
                                                                           ? other$areaName == null
                                                                           : this$areaName.equals(other$areaName)) {
                                                                           Object this$oldArtifactSerialNumber = this.getOldArtifactSerialNumber();
                                                                           Object other$oldArtifactSerialNumber = other.getOldArtifactSerialNumber();
                                                                           if (this$oldArtifactSerialNumber == null
                                                                              ? other$oldArtifactSerialNumber == null
                                                                              : this$oldArtifactSerialNumber.equals(other$oldArtifactSerialNumber)) {
                                                                              Object this$name = this.getName();
                                                                              Object other$name = other.getName();
                                                                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                                 Object this$serialNumber = this.getSerialNumber();
                                                                                 Object other$serialNumber = other.getSerialNumber();
                                                                                 if (this$serialNumber == null
                                                                                    ? other$serialNumber == null
                                                                                    : this$serialNumber.equals(other$serialNumber)) {
                                                                                    Object this$specification = this.getSpecification();
                                                                                    Object other$specification = other.getSpecification();
                                                                                    if (this$specification == null
                                                                                       ? other$specification == null
                                                                                       : this$specification.equals(other$specification)) {
                                                                                       Object this$length = this.getLength();
                                                                                       Object other$length = other.getLength();
                                                                                       if (this$length == null
                                                                                          ? other$length == null
                                                                                          : this$length.equals(other$length)) {
                                                                                          Object this$material = this.getMaterial();
                                                                                          Object other$material = other.getMaterial();
                                                                                          if (this$material == null
                                                                                             ? other$material == null
                                                                                             : this$material.equals(other$material)) {
                                                                                             Object this$netWeight = this.getNetWeight();
                                                                                             Object other$netWeight = other.getNetWeight();
                                                                                             if (this$netWeight == null
                                                                                                ? other$netWeight == null
                                                                                                : this$netWeight.equals(other$netWeight)) {
                                                                                                Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                                Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                                if (this$totalNetWeight == null
                                                                                                   ? other$totalNetWeight == null
                                                                                                   : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                                                   Object this$grossWeight = this.getGrossWeight();
                                                                                                   Object other$grossWeight = other.getGrossWeight();
                                                                                                   if (this$grossWeight == null
                                                                                                      ? other$grossWeight == null
                                                                                                      : this$grossWeight.equals(other$grossWeight)) {
                                                                                                      Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                                                      Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                                                      if (this$totalGrossWeight == null
                                                                                                         ? other$totalGrossWeight == null
                                                                                                         : this$totalGrossWeight.equals(other$totalGrossWeight)
                                                                                                         )
                                                                                                       {
                                                                                                         Object this$surfaceArea = this.getSurfaceArea();
                                                                                                         Object other$surfaceArea = other.getSurfaceArea();
                                                                                                         if (this$surfaceArea == null
                                                                                                            ? other$surfaceArea == null
                                                                                                            : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                                            Object this$drawingNumber = this.getDrawingNumber();
                                                                                                            Object other$drawingNumber = other.getDrawingNumber();
                                                                                                            if (this$drawingNumber == null
                                                                                                               ? other$drawingNumber == null
                                                                                                               : this$drawingNumber.equals(other$drawingNumber)
                                                                                                               )
                                                                                                             {
                                                                                                               Object this$remark = this.getRemark();
                                                                                                               Object other$remark = other.getRemark();
                                                                                                               if (this$remark == null
                                                                                                                  ? other$remark == null
                                                                                                                  : this$remark.equals(other$remark)) {
                                                                                                                  Object this$specPrefix = this.getSpecPrefix();
                                                                                                                  Object other$specPrefix = other.getSpecPrefix();
                                                                                                                  if (this$specPrefix == null
                                                                                                                     ? other$specPrefix == null
                                                                                                                     : this$specPrefix.equals(other$specPrefix)
                                                                                                                     )
                                                                                                                   {
                                                                                                                     Object this$machinePartFront = this.getMachinePartFront();
                                                                                                                     Object other$machinePartFront = other.getMachinePartFront();
                                                                                                                     if (this$machinePartFront == null
                                                                                                                        ? other$machinePartFront == null
                                                                                                                        : this$machinePartFront.equals(
                                                                                                                           other$machinePartFront
                                                                                                                        )) {
                                                                                                                        Object this$brand = this.getBrand();
                                                                                                                        Object other$brand = other.getBrand();
                                                                                                                        if (this$brand == null
                                                                                                                           ? other$brand == null
                                                                                                                           : this$brand.equals(other$brand)) {
                                                                                                                           Object this$plate = this.getPlate();
                                                                                                                           Object other$plate = other.getPlate();
                                                                                                                           if (this$plate == null
                                                                                                                              ? other$plate == null
                                                                                                                              : this$plate.equals(other$plate)) {
                                                                                                                              Object this$color = this.getColor();
                                                                                                                              Object other$color = other.getColor();
                                                                                                                              if (this$color == null
                                                                                                                                 ? other$color == null
                                                                                                                                 : this$color.equals(
                                                                                                                                    other$color
                                                                                                                                 )) {
                                                                                                                                 Object this$weight = this.getWeight();
                                                                                                                                 Object other$weight = other.getWeight();
                                                                                                                                 if (this$weight == null
                                                                                                                                    ? other$weight == null
                                                                                                                                    : this$weight.equals(
                                                                                                                                       other$weight
                                                                                                                                    )) {
                                                                                                                                    Object this$thickness = this.getThickness();
                                                                                                                                    Object other$thickness = other.getThickness();
                                                                                                                                    if (this$thickness == null
                                                                                                                                       ? other$thickness
                                                                                                                                          == null
                                                                                                                                       : this$thickness.equals(
                                                                                                                                          other$thickness
                                                                                                                                       )) {
                                                                                                                                       Object this$coating = this.getCoating();
                                                                                                                                       Object other$coating = other.getCoating();
                                                                                                                                       if (this$coating == null
                                                                                                                                          ? other$coating
                                                                                                                                             == null
                                                                                                                                          : this$coating.equals(
                                                                                                                                             other$coating
                                                                                                                                          )) {
                                                                                                                                          Object this$plating = this.getPlating();
                                                                                                                                          Object other$plating = other.getPlating();
                                                                                                                                          if (this$plating
                                                                                                                                                == null
                                                                                                                                             ? other$plating
                                                                                                                                                == null
                                                                                                                                             : this$plating.equals(
                                                                                                                                                other$plating
                                                                                                                                             )) {
                                                                                                                                             Object this$width = this.getWidth();
                                                                                                                                             Object other$width = other.getWidth();
                                                                                                                                             if (this$width
                                                                                                                                                   == null
                                                                                                                                                ? other$width
                                                                                                                                                   == null
                                                                                                                                                : this$width.equals(
                                                                                                                                                   other$width
                                                                                                                                                )) {
                                                                                                                                                Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                                                                                                                Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                                                                                                                if (this$unfoldedWidth
                                                                                                                                                      == null
                                                                                                                                                   ? other$unfoldedWidth
                                                                                                                                                      == null
                                                                                                                                                   : this$unfoldedWidth.equals(
                                                                                                                                                      other$unfoldedWidth
                                                                                                                                                   )) {
                                                                                                                                                   Object this$totalLength = this.getTotalLength();
                                                                                                                                                   Object other$totalLength = other.getTotalLength();
                                                                                                                                                   if (this$totalLength
                                                                                                                                                         == null
                                                                                                                                                      ? other$totalLength
                                                                                                                                                         == null
                                                                                                                                                      : this$totalLength.equals(
                                                                                                                                                         other$totalLength
                                                                                                                                                      )) {
                                                                                                                                                      Object this$totalArea = this.getTotalArea();
                                                                                                                                                      Object other$totalArea = other.getTotalArea();
                                                                                                                                                      if (this$totalArea
                                                                                                                                                            == null
                                                                                                                                                         ? other$totalArea
                                                                                                                                                            == null
                                                                                                                                                         : this$totalArea.equals(
                                                                                                                                                            other$totalArea
                                                                                                                                                         )) {
                                                                                                                                                         Object this$techChange = this.getTechChange();
                                                                                                                                                         Object other$techChange = other.getTechChange();
                                                                                                                                                         return this$techChange
                                                                                                                                                               == null
                                                                                                                                                            ? other$techChange
                                                                                                                                                               == null
                                                                                                                                                            : this$techChange.equals(
                                                                                                                                                               other$techChange
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactAndAssembleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $oldArtifactId = this.getOldArtifactId();
      result = result * 59 + ($oldArtifactId == null ? 43 : $oldArtifactId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $machinePartId = this.getMachinePartId();
      result = result * 59 + ($machinePartId == null ? 43 : $machinePartId.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $issuedQuantity = this.getIssuedQuantity();
      result = result * 59 + ($issuedQuantity == null ? 43 : $issuedQuantity.hashCode());
      Object $issuedTotalQuantity = this.getIssuedTotalQuantity();
      result = result * 59 + ($issuedTotalQuantity == null ? 43 : $issuedTotalQuantity.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $oldArtifactSerialNumber = this.getOldArtifactSerialNumber();
      result = result * 59 + ($oldArtifactSerialNumber == null ? 43 : $oldArtifactSerialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $machinePartFront = this.getMachinePartFront();
      result = result * 59 + ($machinePartFront == null ? 43 : $machinePartFront.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $techChange = this.getTechChange();
      return result * 59 + ($techChange == null ? 43 : $techChange.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactAndAssembleDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", oldArtifactId="
         + this.getOldArtifactId()
         + ", oldArtifactSerialNumber="
         + this.getOldArtifactSerialNumber()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", businessId="
         + this.getBusinessId()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", areaType="
         + this.getAreaType()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", machinePartFront="
         + this.getMachinePartFront()
         + ", machinePartId="
         + this.getMachinePartId()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", issuedQuantity="
         + this.getIssuedQuantity()
         + ", issuedTotalQuantity="
         + this.getIssuedTotalQuantity()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", category="
         + this.getCategory()
         + ", brand="
         + this.getBrand()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", weight="
         + this.getWeight()
         + ", thickness="
         + this.getThickness()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", width="
         + this.getWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", bendTimes="
         + this.getBendTimes()
         + ", techChange="
         + this.getTechChange()
         + ")";
   }

   public ArtifactAndAssembleDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final String monomerName,
      final Long areaId,
      final String areaName,
      final Long oldArtifactId,
      final String oldArtifactSerialNumber,
      final Boolean boolStatusEnum,
      final Boolean boolAbnormalEnum,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final String drawingNumber,
      final String remark,
      final Long userId,
      final Long businessId,
      final Integer producedQuantity,
      final Integer areaType,
      final String specPrefix,
      final Integer usedQuantity,
      final String machinePartFront,
      final Long machinePartId,
      final Boolean boolSchedulingEnum,
      final Integer issuedQuantity,
      final Integer issuedTotalQuantity,
      final Integer inboundQuantity,
      final Integer category,
      final String brand,
      final String plate,
      final String color,
      final BigDecimal weight,
      final BigDecimal thickness,
      final String coating,
      final String plating,
      final BigDecimal width,
      final BigDecimal unfoldedWidth,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final Long attachmentId,
      final Integer bendTimes,
      final List<BriefIdAndSNDTO> techChange
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.oldArtifactId = oldArtifactId;
      this.oldArtifactSerialNumber = oldArtifactSerialNumber;
      this.boolStatusEnum = boolStatusEnum;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.drawingNumber = drawingNumber;
      this.remark = remark;
      this.userId = userId;
      this.businessId = businessId;
      this.producedQuantity = producedQuantity;
      this.areaType = areaType;
      this.specPrefix = specPrefix;
      this.usedQuantity = usedQuantity;
      this.machinePartFront = machinePartFront;
      this.machinePartId = machinePartId;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.issuedQuantity = issuedQuantity;
      this.issuedTotalQuantity = issuedTotalQuantity;
      this.inboundQuantity = inboundQuantity;
      this.category = category;
      this.brand = brand;
      this.plate = plate;
      this.color = color;
      this.weight = weight;
      this.thickness = thickness;
      this.coating = coating;
      this.plating = plating;
      this.width = width;
      this.unfoldedWidth = unfoldedWidth;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.attachmentId = attachmentId;
      this.bendTimes = bendTimes;
      this.techChange = techChange;
   }

   public ArtifactAndAssembleDTO() {
   }

   public static class ArtifactAndAssembleDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private String monomerName;
      private Long areaId;
      private String areaName;
      private Long oldArtifactId;
      private String oldArtifactSerialNumber;
      private Boolean boolStatusEnum;
      private Boolean boolAbnormalEnum;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private String drawingNumber;
      private String remark;
      private Long userId;
      private Long businessId;
      private Integer producedQuantity;
      private Integer areaType;
      private String specPrefix;
      private Integer usedQuantity;
      private String machinePartFront;
      private Long machinePartId;
      private Boolean boolSchedulingEnum;
      private Integer issuedQuantity;
      private Integer issuedTotalQuantity;
      private Integer inboundQuantity;
      private Integer category;
      private String brand;
      private String plate;
      private String color;
      private BigDecimal weight;
      private BigDecimal thickness;
      private String coating;
      private String plating;
      private BigDecimal width;
      private BigDecimal unfoldedWidth;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private Long attachmentId;
      private Integer bendTimes;
      private List<BriefIdAndSNDTO> techChange;

      ArtifactAndAssembleDTOBuilder() {
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder oldArtifactId(final Long oldArtifactId) {
         this.oldArtifactId = oldArtifactId;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder oldArtifactSerialNumber(final String oldArtifactSerialNumber) {
         this.oldArtifactSerialNumber = oldArtifactSerialNumber;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder machinePartFront(final String machinePartFront) {
         this.machinePartFront = machinePartFront;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder machinePartId(final Long machinePartId) {
         this.machinePartId = machinePartId;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder issuedQuantity(final Integer issuedQuantity) {
         this.issuedQuantity = issuedQuantity;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder issuedTotalQuantity(final Integer issuedTotalQuantity) {
         this.issuedTotalQuantity = issuedTotalQuantity;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder inboundQuantity(final Integer inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder bendTimes(final Integer bendTimes) {
         this.bendTimes = bendTimes;
         return this;
      }

      public ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder techChange(final List<BriefIdAndSNDTO> techChange) {
         this.techChange = techChange;
         return this;
      }

      public ArtifactAndAssembleDTO build() {
         return new ArtifactAndAssembleDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.monomerName,
            this.areaId,
            this.areaName,
            this.oldArtifactId,
            this.oldArtifactSerialNumber,
            this.boolStatusEnum,
            this.boolAbnormalEnum,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.drawingNumber,
            this.remark,
            this.userId,
            this.businessId,
            this.producedQuantity,
            this.areaType,
            this.specPrefix,
            this.usedQuantity,
            this.machinePartFront,
            this.machinePartId,
            this.boolSchedulingEnum,
            this.issuedQuantity,
            this.issuedTotalQuantity,
            this.inboundQuantity,
            this.category,
            this.brand,
            this.plate,
            this.color,
            this.weight,
            this.thickness,
            this.coating,
            this.plating,
            this.width,
            this.unfoldedWidth,
            this.totalLength,
            this.totalArea,
            this.attachmentId,
            this.bendTimes,
            this.techChange
         );
      }

      @Override
      public String toString() {
         return "ArtifactAndAssembleDTO.ArtifactAndAssembleDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", oldArtifactId="
            + this.oldArtifactId
            + ", oldArtifactSerialNumber="
            + this.oldArtifactSerialNumber
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", drawingNumber="
            + this.drawingNumber
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", businessId="
            + this.businessId
            + ", producedQuantity="
            + this.producedQuantity
            + ", areaType="
            + this.areaType
            + ", specPrefix="
            + this.specPrefix
            + ", usedQuantity="
            + this.usedQuantity
            + ", machinePartFront="
            + this.machinePartFront
            + ", machinePartId="
            + this.machinePartId
            + ", boolSchedulingEnum="
            + this.boolSchedulingEnum
            + ", issuedQuantity="
            + this.issuedQuantity
            + ", issuedTotalQuantity="
            + this.issuedTotalQuantity
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", category="
            + this.category
            + ", brand="
            + this.brand
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", weight="
            + this.weight
            + ", thickness="
            + this.thickness
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ", width="
            + this.width
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", attachmentId="
            + this.attachmentId
            + ", bendTimes="
            + this.bendTimes
            + ", techChange="
            + this.techChange
            + ")";
      }
   }
}

package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("零构件清单列表 返回构件类")
public class TechArtifactDTO {
   @ApiModelProperty(name = "id", value = "构件id")
   private Long id;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id")
   private Long areaBatchId;
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   private String structureType;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（㎡）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "topFlangeArea", value = "上翼缘(单)面积（m²）")
   private BigDecimal topFlangeArea;
   @ApiModelProperty(name = "totalSurfaceArea", value = "总面积（㎡）")
   private BigDecimal totalSurfaceArea;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 0暂停 1进行中")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "producedQuantity", value = "已生产数量")
   private Integer producedQuantity;
   @ApiModelProperty(name = "userId", value = "上传人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "上传人名称")
   private String userName;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("审核人名字")
   private String auditUserName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "hasMachinePart", value = "是否有零件 1有 0无")
   private int hasMachinePart;
   @ApiModelProperty(name = "abnormal", value = "是否异常 1异常 0正常")
   private int abnormal = 0;
   @ApiModelProperty("第一道工序名称")
   private String firstProcessName;
   @ApiModelProperty("构件产品序列号集合")
   private List<Integer> numbers;
   @ApiModelProperty("构件产品序列号和图号")
   private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;
   @ApiModelProperty(name = "smartLineMarkWord", value = "智能生产线标记词")
   private String smartLineMarkWord;
   @ApiModelProperty(name = "batchNumber", value = "导入批次号")
   private String batchNumber;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @ApiModelProperty("构件类型 1普通构件 2次构件")
   private Integer artifactType;
   @ApiModelProperty(name = "boolBlastingEnum", value = "是否抛丸 true是 false否")
   private Boolean boolBlastingEnum;
   @ApiModelProperty(name = "boolCoatingEnum", value = "是否涂装 true是 false否")
   private Boolean boolCoatingEnum;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否可以排产")
   private Boolean boolSchedulingEnum;
   @ApiModelProperty("扫码方式 1:一物一码  2:一码多物(批量) 枚举: CodingTypeEnum")
   private Integer codingType;
   @ApiModelProperty("构件种类表id")
   private Long structureClassId;
   @ApiModelProperty("截取的规格")
   private BigDecimal cutSpecification;
   @ApiModelProperty("图纸单重")
   private BigDecimal drawingWeight;
   @ApiModelProperty("图纸总重")
   private BigDecimal totalDrawingWeight;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "printedCode", value = "喷印编码")
   private String printedCode;

   public Long getId() {
      return this.id;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getStructureType() {
      return this.structureType;
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

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   public BigDecimal getTotalSurfaceArea() {
      return this.totalSurfaceArea;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public int getHasMachinePart() {
      return this.hasMachinePart;
   }

   public int getAbnormal() {
      return this.abnormal;
   }

   public String getFirstProcessName() {
      return this.firstProcessName;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   public String getSmartLineMarkWord() {
      return this.smartLineMarkWord;
   }

   public String getBatchNumber() {
      return this.batchNumber;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Boolean getBoolBlastingEnum() {
      return this.boolBlastingEnum;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public BigDecimal getCutSpecification() {
      return this.cutSpecification;
   }

   public BigDecimal getDrawingWeight() {
      return this.drawingWeight;
   }

   public BigDecimal getTotalDrawingWeight() {
      return this.totalDrawingWeight;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public String getPrintedCode() {
      return this.printedCode;
   }

   public TechArtifactDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechArtifactDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechArtifactDTO setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   public TechArtifactDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public TechArtifactDTO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public TechArtifactDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public TechArtifactDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechArtifactDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechArtifactDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public TechArtifactDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public TechArtifactDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechArtifactDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public TechArtifactDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public TechArtifactDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public TechArtifactDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public TechArtifactDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public TechArtifactDTO setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
      return this;
   }

   public TechArtifactDTO setTotalSurfaceArea(final BigDecimal totalSurfaceArea) {
      this.totalSurfaceArea = totalSurfaceArea;
      return this;
   }

   public TechArtifactDTO setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   public TechArtifactDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechArtifactDTO setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   public TechArtifactDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   public TechArtifactDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechArtifactDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public TechArtifactDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public TechArtifactDTO setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public TechArtifactDTO setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public TechArtifactDTO setHasMachinePart(final int hasMachinePart) {
      this.hasMachinePart = hasMachinePart;
      return this;
   }

   public TechArtifactDTO setAbnormal(final int abnormal) {
      this.abnormal = abnormal;
      return this;
   }

   public TechArtifactDTO setFirstProcessName(final String firstProcessName) {
      this.firstProcessName = firstProcessName;
      return this;
   }

   public TechArtifactDTO setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
      return this;
   }

   public TechArtifactDTO setDrawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
      return this;
   }

   public TechArtifactDTO setSmartLineMarkWord(final String smartLineMarkWord) {
      this.smartLineMarkWord = smartLineMarkWord;
      return this;
   }

   public TechArtifactDTO setBatchNumber(final String batchNumber) {
      this.batchNumber = batchNumber;
      return this;
   }

   public TechArtifactDTO setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   public TechArtifactDTO setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   public TechArtifactDTO setBoolBlastingEnum(final Boolean boolBlastingEnum) {
      this.boolBlastingEnum = boolBlastingEnum;
      return this;
   }

   public TechArtifactDTO setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
      return this;
   }

   public TechArtifactDTO setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
      return this;
   }

   public TechArtifactDTO setCodingType(final Integer codingType) {
      this.codingType = codingType;
      return this;
   }

   public TechArtifactDTO setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   public TechArtifactDTO setCutSpecification(final BigDecimal cutSpecification) {
      this.cutSpecification = cutSpecification;
      return this;
   }

   public TechArtifactDTO setDrawingWeight(final BigDecimal drawingWeight) {
      this.drawingWeight = drawingWeight;
      return this;
   }

   public TechArtifactDTO setTotalDrawingWeight(final BigDecimal totalDrawingWeight) {
      this.totalDrawingWeight = totalDrawingWeight;
      return this;
   }

   public TechArtifactDTO setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   public TechArtifactDTO setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactDTO)) {
         return false;
      }

      TechArtifactDTO other = (TechArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getHasMachinePart() != other.getHasMachinePart()) {
         return false;
      }

      if (this.getAbnormal() != other.getAbnormal()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaBatchId = this.getAreaBatchId();
            Object other$areaBatchId = other.getAreaBatchId();
            if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$boolStatusEnum = this.getBoolStatusEnum();
                     Object other$boolStatusEnum = other.getBoolStatusEnum();
                     if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                        Object this$producedQuantity = this.getProducedQuantity();
                        Object other$producedQuantity = other.getProducedQuantity();
                        if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                              Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                              if (this$productionLineTypeEnum == null
                                 ? other$productionLineTypeEnum == null
                                 : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                                 Object this$artifactType = this.getArtifactType();
                                 Object other$artifactType = other.getArtifactType();
                                 if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
                                    Object this$boolBlastingEnum = this.getBoolBlastingEnum();
                                    Object other$boolBlastingEnum = other.getBoolBlastingEnum();
                                    if (this$boolBlastingEnum == null ? other$boolBlastingEnum == null : this$boolBlastingEnum.equals(other$boolBlastingEnum)) {
                                       Object this$boolCoatingEnum = this.getBoolCoatingEnum();
                                       Object other$boolCoatingEnum = other.getBoolCoatingEnum();
                                       if (this$boolCoatingEnum == null ? other$boolCoatingEnum == null : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
                                          Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
                                          Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
                                          if (this$boolSchedulingEnum == null
                                             ? other$boolSchedulingEnum == null
                                             : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                                             Object this$codingType = this.getCodingType();
                                             Object other$codingType = other.getCodingType();
                                             if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                                                Object this$structureClassId = this.getStructureClassId();
                                                Object other$structureClassId = other.getStructureClassId();
                                                if (this$structureClassId == null
                                                   ? other$structureClassId == null
                                                   : this$structureClassId.equals(other$structureClassId)) {
                                                   Object this$boolSendDirectly = this.getBoolSendDirectly();
                                                   Object other$boolSendDirectly = other.getBoolSendDirectly();
                                                   if (this$boolSendDirectly == null
                                                      ? other$boolSendDirectly == null
                                                      : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                                                      Object this$structureType = this.getStructureType();
                                                      Object other$structureType = other.getStructureType();
                                                      if (this$structureType == null
                                                         ? other$structureType == null
                                                         : this$structureType.equals(other$structureType)) {
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
                                                                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                     Object this$material = this.getMaterial();
                                                                     Object other$material = other.getMaterial();
                                                                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
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
                                                                                    : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                                    Object this$surfaceArea = this.getSurfaceArea();
                                                                                    Object other$surfaceArea = other.getSurfaceArea();
                                                                                    if (this$surfaceArea == null
                                                                                       ? other$surfaceArea == null
                                                                                       : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                       Object this$topFlangeArea = this.getTopFlangeArea();
                                                                                       Object other$topFlangeArea = other.getTopFlangeArea();
                                                                                       if (this$topFlangeArea == null
                                                                                          ? other$topFlangeArea == null
                                                                                          : this$topFlangeArea.equals(other$topFlangeArea)) {
                                                                                          Object this$totalSurfaceArea = this.getTotalSurfaceArea();
                                                                                          Object other$totalSurfaceArea = other.getTotalSurfaceArea();
                                                                                          if (this$totalSurfaceArea == null
                                                                                             ? other$totalSurfaceArea == null
                                                                                             : this$totalSurfaceArea.equals(other$totalSurfaceArea)) {
                                                                                             Object this$drawingNumber = this.getDrawingNumber();
                                                                                             Object other$drawingNumber = other.getDrawingNumber();
                                                                                             if (this$drawingNumber == null
                                                                                                ? other$drawingNumber == null
                                                                                                : this$drawingNumber.equals(other$drawingNumber)) {
                                                                                                Object this$remark = this.getRemark();
                                                                                                Object other$remark = other.getRemark();
                                                                                                if (this$remark == null
                                                                                                   ? other$remark == null
                                                                                                   : this$remark.equals(other$remark)) {
                                                                                                   Object this$userName = this.getUserName();
                                                                                                   Object other$userName = other.getUserName();
                                                                                                   if (this$userName == null
                                                                                                      ? other$userName == null
                                                                                                      : this$userName.equals(other$userName)) {
                                                                                                      Object this$createTime = this.getCreateTime();
                                                                                                      Object other$createTime = other.getCreateTime();
                                                                                                      if (this$createTime == null
                                                                                                         ? other$createTime == null
                                                                                                         : this$createTime.equals(other$createTime)) {
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
                                                                                                               Object this$firstProcessName = this.getFirstProcessName();
                                                                                                               Object other$firstProcessName = other.getFirstProcessName();
                                                                                                               if (this$firstProcessName == null
                                                                                                                  ? other$firstProcessName == null
                                                                                                                  : this$firstProcessName.equals(
                                                                                                                     other$firstProcessName
                                                                                                                  )) {
                                                                                                                  Object this$numbers = this.getNumbers();
                                                                                                                  Object other$numbers = other.getNumbers();
                                                                                                                  if (this$numbers == null
                                                                                                                     ? other$numbers == null
                                                                                                                     : this$numbers.equals(other$numbers)) {
                                                                                                                     Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                                                                                                     Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                                                                                                     if (this$drawingAndSerialNumber == null
                                                                                                                        ? other$drawingAndSerialNumber == null
                                                                                                                        : this$drawingAndSerialNumber.equals(
                                                                                                                           other$drawingAndSerialNumber
                                                                                                                        )) {
                                                                                                                        Object this$smartLineMarkWord = this.getSmartLineMarkWord();
                                                                                                                        Object other$smartLineMarkWord = other.getSmartLineMarkWord();
                                                                                                                        if (this$smartLineMarkWord == null
                                                                                                                           ? other$smartLineMarkWord == null
                                                                                                                           : this$smartLineMarkWord.equals(
                                                                                                                              other$smartLineMarkWord
                                                                                                                           )) {
                                                                                                                           Object this$batchNumber = this.getBatchNumber();
                                                                                                                           Object other$batchNumber = other.getBatchNumber();
                                                                                                                           if (this$batchNumber == null
                                                                                                                              ? other$batchNumber == null
                                                                                                                              : this$batchNumber.equals(
                                                                                                                                 other$batchNumber
                                                                                                                              )) {
                                                                                                                              Object this$cutSpecification = this.getCutSpecification();
                                                                                                                              Object other$cutSpecification = other.getCutSpecification();
                                                                                                                              if (this$cutSpecification == null
                                                                                                                                 ? other$cutSpecification
                                                                                                                                    == null
                                                                                                                                 : this$cutSpecification.equals(
                                                                                                                                    other$cutSpecification
                                                                                                                                 )) {
                                                                                                                                 Object this$drawingWeight = this.getDrawingWeight();
                                                                                                                                 Object other$drawingWeight = other.getDrawingWeight();
                                                                                                                                 if (this$drawingWeight == null
                                                                                                                                    ? other$drawingWeight
                                                                                                                                       == null
                                                                                                                                    : this$drawingWeight.equals(
                                                                                                                                       other$drawingWeight
                                                                                                                                    )) {
                                                                                                                                    Object this$totalDrawingWeight = this.getTotalDrawingWeight();
                                                                                                                                    Object other$totalDrawingWeight = other.getTotalDrawingWeight();
                                                                                                                                    if (this$totalDrawingWeight
                                                                                                                                          == null
                                                                                                                                       ? other$totalDrawingWeight
                                                                                                                                          == null
                                                                                                                                       : this$totalDrawingWeight.equals(
                                                                                                                                          other$totalDrawingWeight
                                                                                                                                       )) {
                                                                                                                                       Object this$printedCode = this.getPrintedCode();
                                                                                                                                       Object other$printedCode = other.getPrintedCode();
                                                                                                                                       return this$printedCode
                                                                                                                                             == null
                                                                                                                                          ? other$printedCode
                                                                                                                                             == null
                                                                                                                                          : this$printedCode.equals(
                                                                                                                                             other$printedCode
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getHasMachinePart();
      result = result * 59 + this.getAbnormal();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $boolBlastingEnum = this.getBoolBlastingEnum();
      result = result * 59 + ($boolBlastingEnum == null ? 43 : $boolBlastingEnum.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
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
      Object $topFlangeArea = this.getTopFlangeArea();
      result = result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
      Object $totalSurfaceArea = this.getTotalSurfaceArea();
      result = result * 59 + ($totalSurfaceArea == null ? 43 : $totalSurfaceArea.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $firstProcessName = this.getFirstProcessName();
      result = result * 59 + ($firstProcessName == null ? 43 : $firstProcessName.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      result = result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
      Object $smartLineMarkWord = this.getSmartLineMarkWord();
      result = result * 59 + ($smartLineMarkWord == null ? 43 : $smartLineMarkWord.hashCode());
      Object $batchNumber = this.getBatchNumber();
      result = result * 59 + ($batchNumber == null ? 43 : $batchNumber.hashCode());
      Object $cutSpecification = this.getCutSpecification();
      result = result * 59 + ($cutSpecification == null ? 43 : $cutSpecification.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $totalDrawingWeight = this.getTotalDrawingWeight();
      result = result * 59 + ($totalDrawingWeight == null ? 43 : $totalDrawingWeight.hashCode());
      Object $printedCode = this.getPrintedCode();
      return result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactDTO(id="
         + this.getId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", productType="
         + this.getProductType()
         + ", structureType="
         + this.getStructureType()
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
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ", totalSurfaceArea="
         + this.getTotalSurfaceArea()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", hasMachinePart="
         + this.getHasMachinePart()
         + ", abnormal="
         + this.getAbnormal()
         + ", firstProcessName="
         + this.getFirstProcessName()
         + ", numbers="
         + this.getNumbers()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ", smartLineMarkWord="
         + this.getSmartLineMarkWord()
         + ", batchNumber="
         + this.getBatchNumber()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", artifactType="
         + this.getArtifactType()
         + ", boolBlastingEnum="
         + this.getBoolBlastingEnum()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", codingType="
         + this.getCodingType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", cutSpecification="
         + this.getCutSpecification()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", totalDrawingWeight="
         + this.getTotalDrawingWeight()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", printedCode="
         + this.getPrintedCode()
         + ")";
   }

   public TechArtifactDTO() {
   }

   public TechArtifactDTO(
      final Long id,
      final Long monomerId,
      final Long areaBatchId,
      final Integer productType,
      final String structureType,
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
      final BigDecimal topFlangeArea,
      final BigDecimal totalSurfaceArea,
      final String drawingNumber,
      final String remark,
      final Boolean boolStatusEnum,
      final Integer producedQuantity,
      final Long userId,
      final String userName,
      final LocalDateTime createTime,
      final String auditUserName,
      final LocalDateTime auditTime,
      final int hasMachinePart,
      final int abnormal,
      final String firstProcessName,
      final List<Integer> numbers,
      final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber,
      final String smartLineMarkWord,
      final String batchNumber,
      final Integer productionLineTypeEnum,
      final Integer artifactType,
      final Boolean boolBlastingEnum,
      final Boolean boolCoatingEnum,
      final Boolean boolSchedulingEnum,
      final Integer codingType,
      final Long structureClassId,
      final BigDecimal cutSpecification,
      final BigDecimal drawingWeight,
      final BigDecimal totalDrawingWeight,
      final Boolean boolSendDirectly,
      final String printedCode
   ) {
      this.id = id;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.productType = productType;
      this.structureType = structureType;
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
      this.topFlangeArea = topFlangeArea;
      this.totalSurfaceArea = totalSurfaceArea;
      this.drawingNumber = drawingNumber;
      this.remark = remark;
      this.boolStatusEnum = boolStatusEnum;
      this.producedQuantity = producedQuantity;
      this.userId = userId;
      this.userName = userName;
      this.createTime = createTime;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.hasMachinePart = hasMachinePart;
      this.abnormal = abnormal;
      this.firstProcessName = firstProcessName;
      this.numbers = numbers;
      this.drawingAndSerialNumber = drawingAndSerialNumber;
      this.smartLineMarkWord = smartLineMarkWord;
      this.batchNumber = batchNumber;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.artifactType = artifactType;
      this.boolBlastingEnum = boolBlastingEnum;
      this.boolCoatingEnum = boolCoatingEnum;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.codingType = codingType;
      this.structureClassId = structureClassId;
      this.cutSpecification = cutSpecification;
      this.drawingWeight = drawingWeight;
      this.totalDrawingWeight = totalDrawingWeight;
      this.boolSendDirectly = boolSendDirectly;
      this.printedCode = printedCode;
   }
}

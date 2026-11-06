package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do._package.PackageDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do._package.TechStandardPartDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(description = "发运信息")
public class CargoListDetailsDTO {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("车次编号")
   private String serialNumber;
   @ApiModelProperty("车型")
   private String carModel;
   @ApiModelProperty("项目计价方式 [0 理计, 1 磅计]")
   private Integer projectSettlementType;
   @ApiModelProperty("物流单位价格id")
   private Long supplierPriceId;
   @ApiModelProperty("物流价格")
   private BigDecimal supplierPrice;
   @ApiModelProperty("装载类型")
   private Integer productType;
   @ApiModelProperty("制造类型【1：自制，2：外包】")
   private Integer manufactureType;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("司机姓名")
   private String driverName;
   @ApiModelProperty("司机电话")
   private String driverPhone;
   @ApiModelProperty("清单数量")
   private Integer quantity;
   @ApiModelProperty("总净重量")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("总毛重量")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("过磅净重")
   private BigDecimal actualWeight;
   @ApiModelProperty("过磅毛重")
   private BigDecimal actualGrossWeight;
   @ApiModelProperty(name = "emptyCars", value = "空车重量 ", notes = "空车重量")
   private BigDecimal emptyCars;
   @ApiModelProperty("发运状态 [0 毛重 1 装车, 2 过磅，4发运，8收货]")
   private Integer status;
   @ApiModelProperty("装车人id")
   private Long userId;
   @ApiModelProperty("装车人名称")
   private String userName;
   @ApiModelProperty("过磅人id")
   private Long actualUserId;
   @ApiModelProperty("过磅人名称")
   private String actualUserName;
   @ApiModelProperty("过磅时间")
   private LocalDateTime actualTime;
   @ApiModelProperty("发运审核人id")
   private Long auditUserId;
   @ApiModelProperty("发运审核人名称")
   private String auditUserName;
   @ApiModelProperty("发运时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("收货人")
   private String receiptName;
   @ApiModelProperty("收货人电话")
   private String receiptPhone;
   @ApiModelProperty("实际收货人")
   private String auditReceiptName;
   @ApiModelProperty("实际收货人电话")
   private String auditReceiptPhone;
   @ApiModelProperty("收货日期")
   private LocalDateTime receiptTime;
   @ApiModelProperty("构件")
   private List<ArtifactDetailDO> artifactList;
   @ApiModelProperty("零件-直发件")
   private List<SendDirectlyDetailDO> partList;
   @ApiModelProperty("部件-直发件")
   private List<SendDirectlyDetailDO> assembleList;
   @ApiModelProperty("围护")
   private List<EnclosureDetailDO> enclosureList;
   @ApiModelProperty("配套件")
   private List<TechStandardPartDetailDO> auxiliaryMaterialList;
   @ApiModelProperty("包")
   private List<PackageDetailDO> packageList;
   @ApiModelProperty("过磅证据拍照")
   private List<AttachmentDTO> attachmentDTOS;
   @ApiModelProperty("构件对应未发运的直发件列表")
   private List<SendDirectlyDetailDO> unshippedPartList;

   public static CargoListDetailsDTO.CargoListDetailsDTOBuilder builder() {
      return new CargoListDetailsDTO.CargoListDetailsDTOBuilder();
   }

   public CargoListDetailsDTO(
      final ProjectInfo project,
      final String serialNumber,
      final String carModel,
      final Integer projectSettlementType,
      final Long supplierPriceId,
      final BigDecimal supplierPrice,
      final Integer productType,
      final Integer manufactureType,
      final String licensePlate,
      final String driverName,
      final String driverPhone,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal actualWeight,
      final BigDecimal actualGrossWeight,
      final BigDecimal emptyCars,
      final Integer status,
      final Long userId,
      final String userName,
      final Long actualUserId,
      final String actualUserName,
      final LocalDateTime actualTime,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final String receiptName,
      final String receiptPhone,
      final String auditReceiptName,
      final String auditReceiptPhone,
      final LocalDateTime receiptTime,
      final List<ArtifactDetailDO> artifactList,
      final List<SendDirectlyDetailDO> partList,
      final List<SendDirectlyDetailDO> assembleList,
      final List<EnclosureDetailDO> enclosureList,
      final List<TechStandardPartDetailDO> auxiliaryMaterialList,
      final List<PackageDetailDO> packageList,
      final List<AttachmentDTO> attachmentDTOS,
      final List<SendDirectlyDetailDO> unshippedPartList
   ) {
      this.project = project;
      this.serialNumber = serialNumber;
      this.carModel = carModel;
      this.projectSettlementType = projectSettlementType;
      this.supplierPriceId = supplierPriceId;
      this.supplierPrice = supplierPrice;
      this.productType = productType;
      this.manufactureType = manufactureType;
      this.licensePlate = licensePlate;
      this.driverName = driverName;
      this.driverPhone = driverPhone;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.actualWeight = actualWeight;
      this.actualGrossWeight = actualGrossWeight;
      this.emptyCars = emptyCars;
      this.status = status;
      this.userId = userId;
      this.userName = userName;
      this.actualUserId = actualUserId;
      this.actualUserName = actualUserName;
      this.actualTime = actualTime;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.receiptName = receiptName;
      this.receiptPhone = receiptPhone;
      this.auditReceiptName = auditReceiptName;
      this.auditReceiptPhone = auditReceiptPhone;
      this.receiptTime = receiptTime;
      this.artifactList = artifactList;
      this.partList = partList;
      this.assembleList = assembleList;
      this.enclosureList = enclosureList;
      this.auxiliaryMaterialList = auxiliaryMaterialList;
      this.packageList = packageList;
      this.attachmentDTOS = attachmentDTOS;
      this.unshippedPartList = unshippedPartList;
   }

   public CargoListDetailsDTO() {
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getCarModel() {
      return this.carModel;
   }

   public Integer getProjectSettlementType() {
      return this.projectSettlementType;
   }

   public Long getSupplierPriceId() {
      return this.supplierPriceId;
   }

   public BigDecimal getSupplierPrice() {
      return this.supplierPrice;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getManufactureType() {
      return this.manufactureType;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getDriverName() {
      return this.driverName;
   }

   public String getDriverPhone() {
      return this.driverPhone;
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

   public BigDecimal getEmptyCars() {
      return this.emptyCars;
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

   public String getReceiptName() {
      return this.receiptName;
   }

   public String getReceiptPhone() {
      return this.receiptPhone;
   }

   public String getAuditReceiptName() {
      return this.auditReceiptName;
   }

   public String getAuditReceiptPhone() {
      return this.auditReceiptPhone;
   }

   public LocalDateTime getReceiptTime() {
      return this.receiptTime;
   }

   public List<ArtifactDetailDO> getArtifactList() {
      return this.artifactList;
   }

   public List<SendDirectlyDetailDO> getPartList() {
      return this.partList;
   }

   public List<SendDirectlyDetailDO> getAssembleList() {
      return this.assembleList;
   }

   public List<EnclosureDetailDO> getEnclosureList() {
      return this.enclosureList;
   }

   public List<TechStandardPartDetailDO> getAuxiliaryMaterialList() {
      return this.auxiliaryMaterialList;
   }

   public List<PackageDetailDO> getPackageList() {
      return this.packageList;
   }

   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   public List<SendDirectlyDetailDO> getUnshippedPartList() {
      return this.unshippedPartList;
   }

   public CargoListDetailsDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public CargoListDetailsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CargoListDetailsDTO setCarModel(final String carModel) {
      this.carModel = carModel;
      return this;
   }

   public CargoListDetailsDTO setProjectSettlementType(final Integer projectSettlementType) {
      this.projectSettlementType = projectSettlementType;
      return this;
   }

   public CargoListDetailsDTO setSupplierPriceId(final Long supplierPriceId) {
      this.supplierPriceId = supplierPriceId;
      return this;
   }

   public CargoListDetailsDTO setSupplierPrice(final BigDecimal supplierPrice) {
      this.supplierPrice = supplierPrice;
      return this;
   }

   public CargoListDetailsDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public CargoListDetailsDTO setManufactureType(final Integer manufactureType) {
      this.manufactureType = manufactureType;
      return this;
   }

   public CargoListDetailsDTO setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   public CargoListDetailsDTO setDriverName(final String driverName) {
      this.driverName = driverName;
      return this;
   }

   public CargoListDetailsDTO setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
      return this;
   }

   public CargoListDetailsDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public CargoListDetailsDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public CargoListDetailsDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public CargoListDetailsDTO setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
      return this;
   }

   public CargoListDetailsDTO setActualGrossWeight(final BigDecimal actualGrossWeight) {
      this.actualGrossWeight = actualGrossWeight;
      return this;
   }

   public CargoListDetailsDTO setEmptyCars(final BigDecimal emptyCars) {
      this.emptyCars = emptyCars;
      return this;
   }

   public CargoListDetailsDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public CargoListDetailsDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public CargoListDetailsDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public CargoListDetailsDTO setActualUserId(final Long actualUserId) {
      this.actualUserId = actualUserId;
      return this;
   }

   public CargoListDetailsDTO setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
      return this;
   }

   public CargoListDetailsDTO setActualTime(final LocalDateTime actualTime) {
      this.actualTime = actualTime;
      return this;
   }

   public CargoListDetailsDTO setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   public CargoListDetailsDTO setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public CargoListDetailsDTO setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public CargoListDetailsDTO setReceiptName(final String receiptName) {
      this.receiptName = receiptName;
      return this;
   }

   public CargoListDetailsDTO setReceiptPhone(final String receiptPhone) {
      this.receiptPhone = receiptPhone;
      return this;
   }

   public CargoListDetailsDTO setAuditReceiptName(final String auditReceiptName) {
      this.auditReceiptName = auditReceiptName;
      return this;
   }

   public CargoListDetailsDTO setAuditReceiptPhone(final String auditReceiptPhone) {
      this.auditReceiptPhone = auditReceiptPhone;
      return this;
   }

   public CargoListDetailsDTO setReceiptTime(final LocalDateTime receiptTime) {
      this.receiptTime = receiptTime;
      return this;
   }

   public CargoListDetailsDTO setArtifactList(final List<ArtifactDetailDO> artifactList) {
      this.artifactList = artifactList;
      return this;
   }

   public CargoListDetailsDTO setPartList(final List<SendDirectlyDetailDO> partList) {
      this.partList = partList;
      return this;
   }

   public CargoListDetailsDTO setAssembleList(final List<SendDirectlyDetailDO> assembleList) {
      this.assembleList = assembleList;
      return this;
   }

   public CargoListDetailsDTO setEnclosureList(final List<EnclosureDetailDO> enclosureList) {
      this.enclosureList = enclosureList;
      return this;
   }

   public CargoListDetailsDTO setAuxiliaryMaterialList(final List<TechStandardPartDetailDO> auxiliaryMaterialList) {
      this.auxiliaryMaterialList = auxiliaryMaterialList;
      return this;
   }

   public CargoListDetailsDTO setPackageList(final List<PackageDetailDO> packageList) {
      this.packageList = packageList;
      return this;
   }

   public CargoListDetailsDTO setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
      return this;
   }

   public CargoListDetailsDTO setUnshippedPartList(final List<SendDirectlyDetailDO> unshippedPartList) {
      this.unshippedPartList = unshippedPartList;
      return this;
   }

   @Override
   public String toString() {
      return "CargoListDetailsDTO(project="
         + this.getProject()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", carModel="
         + this.getCarModel()
         + ", projectSettlementType="
         + this.getProjectSettlementType()
         + ", supplierPriceId="
         + this.getSupplierPriceId()
         + ", supplierPrice="
         + this.getSupplierPrice()
         + ", productType="
         + this.getProductType()
         + ", manufactureType="
         + this.getManufactureType()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", driverName="
         + this.getDriverName()
         + ", driverPhone="
         + this.getDriverPhone()
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
         + ", emptyCars="
         + this.getEmptyCars()
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
         + ", receiptName="
         + this.getReceiptName()
         + ", receiptPhone="
         + this.getReceiptPhone()
         + ", auditReceiptName="
         + this.getAuditReceiptName()
         + ", auditReceiptPhone="
         + this.getAuditReceiptPhone()
         + ", receiptTime="
         + this.getReceiptTime()
         + ", artifactList="
         + this.getArtifactList()
         + ", partList="
         + this.getPartList()
         + ", assembleList="
         + this.getAssembleList()
         + ", enclosureList="
         + this.getEnclosureList()
         + ", auxiliaryMaterialList="
         + this.getAuxiliaryMaterialList()
         + ", packageList="
         + this.getPackageList()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ", unshippedPartList="
         + this.getUnshippedPartList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListDetailsDTO)) {
         return false;
      }

      CargoListDetailsDTO other = (CargoListDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectSettlementType = this.getProjectSettlementType();
      Object other$projectSettlementType = other.getProjectSettlementType();
      if (this$projectSettlementType == null ? other$projectSettlementType == null : this$projectSettlementType.equals(other$projectSettlementType)) {
         Object this$supplierPriceId = this.getSupplierPriceId();
         Object other$supplierPriceId = other.getSupplierPriceId();
         if (this$supplierPriceId == null ? other$supplierPriceId == null : this$supplierPriceId.equals(other$supplierPriceId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$manufactureType = this.getManufactureType();
               Object other$manufactureType = other.getManufactureType();
               if (this$manufactureType == null ? other$manufactureType == null : this$manufactureType.equals(other$manufactureType)) {
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
                                 Object this$project = this.getProject();
                                 Object other$project = other.getProject();
                                 if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$carModel = this.getCarModel();
                                       Object other$carModel = other.getCarModel();
                                       if (this$carModel == null ? other$carModel == null : this$carModel.equals(other$carModel)) {
                                          Object this$supplierPrice = this.getSupplierPrice();
                                          Object other$supplierPrice = other.getSupplierPrice();
                                          if (this$supplierPrice == null ? other$supplierPrice == null : this$supplierPrice.equals(other$supplierPrice)) {
                                             Object this$licensePlate = this.getLicensePlate();
                                             Object other$licensePlate = other.getLicensePlate();
                                             if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                                Object this$driverName = this.getDriverName();
                                                Object other$driverName = other.getDriverName();
                                                if (this$driverName == null ? other$driverName == null : this$driverName.equals(other$driverName)) {
                                                   Object this$driverPhone = this.getDriverPhone();
                                                   Object other$driverPhone = other.getDriverPhone();
                                                   if (this$driverPhone == null ? other$driverPhone == null : this$driverPhone.equals(other$driverPhone)) {
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
                                                                  Object this$emptyCars = this.getEmptyCars();
                                                                  Object other$emptyCars = other.getEmptyCars();
                                                                  if (this$emptyCars == null ? other$emptyCars == null : this$emptyCars.equals(other$emptyCars)
                                                                     )
                                                                   {
                                                                     Object this$userName = this.getUserName();
                                                                     Object other$userName = other.getUserName();
                                                                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
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
                                                                                          Object this$auditReceiptName = this.getAuditReceiptName();
                                                                                          Object other$auditReceiptName = other.getAuditReceiptName();
                                                                                          if (this$auditReceiptName == null
                                                                                             ? other$auditReceiptName == null
                                                                                             : this$auditReceiptName.equals(other$auditReceiptName)) {
                                                                                             Object this$auditReceiptPhone = this.getAuditReceiptPhone();
                                                                                             Object other$auditReceiptPhone = other.getAuditReceiptPhone();
                                                                                             if (this$auditReceiptPhone == null
                                                                                                ? other$auditReceiptPhone == null
                                                                                                : this$auditReceiptPhone.equals(other$auditReceiptPhone)) {
                                                                                                Object this$receiptTime = this.getReceiptTime();
                                                                                                Object other$receiptTime = other.getReceiptTime();
                                                                                                if (this$receiptTime == null
                                                                                                   ? other$receiptTime == null
                                                                                                   : this$receiptTime.equals(other$receiptTime)) {
                                                                                                   Object this$artifactList = this.getArtifactList();
                                                                                                   Object other$artifactList = other.getArtifactList();
                                                                                                   if (this$artifactList == null
                                                                                                      ? other$artifactList == null
                                                                                                      : this$artifactList.equals(other$artifactList)) {
                                                                                                      Object this$partList = this.getPartList();
                                                                                                      Object other$partList = other.getPartList();
                                                                                                      if (this$partList == null
                                                                                                         ? other$partList == null
                                                                                                         : this$partList.equals(other$partList)) {
                                                                                                         Object this$assembleList = this.getAssembleList();
                                                                                                         Object other$assembleList = other.getAssembleList();
                                                                                                         if (this$assembleList == null
                                                                                                            ? other$assembleList == null
                                                                                                            : this$assembleList.equals(other$assembleList)) {
                                                                                                            Object this$enclosureList = this.getEnclosureList();
                                                                                                            Object other$enclosureList = other.getEnclosureList();
                                                                                                            if (this$enclosureList == null
                                                                                                               ? other$enclosureList == null
                                                                                                               : this$enclosureList.equals(other$enclosureList)
                                                                                                               )
                                                                                                             {
                                                                                                               Object this$auxiliaryMaterialList = this.getAuxiliaryMaterialList();
                                                                                                               Object other$auxiliaryMaterialList = other.getAuxiliaryMaterialList();
                                                                                                               if (this$auxiliaryMaterialList == null
                                                                                                                  ? other$auxiliaryMaterialList == null
                                                                                                                  : this$auxiliaryMaterialList.equals(
                                                                                                                     other$auxiliaryMaterialList
                                                                                                                  )) {
                                                                                                                  Object this$packageList = this.getPackageList();
                                                                                                                  Object other$packageList = other.getPackageList();
                                                                                                                  if (this$packageList == null
                                                                                                                     ? other$packageList == null
                                                                                                                     : this$packageList.equals(
                                                                                                                        other$packageList
                                                                                                                     )) {
                                                                                                                     Object this$attachmentDTOS = this.getAttachmentDTOS();
                                                                                                                     Object other$attachmentDTOS = other.getAttachmentDTOS();
                                                                                                                     if (this$attachmentDTOS == null
                                                                                                                        ? other$attachmentDTOS == null
                                                                                                                        : this$attachmentDTOS.equals(
                                                                                                                           other$attachmentDTOS
                                                                                                                        )) {
                                                                                                                        Object this$unshippedPartList = this.getUnshippedPartList();
                                                                                                                        Object other$unshippedPartList = other.getUnshippedPartList();
                                                                                                                        return this$unshippedPartList == null
                                                                                                                           ? other$unshippedPartList == null
                                                                                                                           : this$unshippedPartList.equals(
                                                                                                                              other$unshippedPartList
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoListDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectSettlementType = this.getProjectSettlementType();
      result = result * 59 + ($projectSettlementType == null ? 43 : $projectSettlementType.hashCode());
      Object $supplierPriceId = this.getSupplierPriceId();
      result = result * 59 + ($supplierPriceId == null ? 43 : $supplierPriceId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $manufactureType = this.getManufactureType();
      result = result * 59 + ($manufactureType == null ? 43 : $manufactureType.hashCode());
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
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $carModel = this.getCarModel();
      result = result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
      Object $supplierPrice = this.getSupplierPrice();
      result = result * 59 + ($supplierPrice == null ? 43 : $supplierPrice.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $driverPhone = this.getDriverPhone();
      result = result * 59 + ($driverPhone == null ? 43 : $driverPhone.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $actualGrossWeight = this.getActualGrossWeight();
      result = result * 59 + ($actualGrossWeight == null ? 43 : $actualGrossWeight.hashCode());
      Object $emptyCars = this.getEmptyCars();
      result = result * 59 + ($emptyCars == null ? 43 : $emptyCars.hashCode());
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
      Object $receiptName = this.getReceiptName();
      result = result * 59 + ($receiptName == null ? 43 : $receiptName.hashCode());
      Object $receiptPhone = this.getReceiptPhone();
      result = result * 59 + ($receiptPhone == null ? 43 : $receiptPhone.hashCode());
      Object $auditReceiptName = this.getAuditReceiptName();
      result = result * 59 + ($auditReceiptName == null ? 43 : $auditReceiptName.hashCode());
      Object $auditReceiptPhone = this.getAuditReceiptPhone();
      result = result * 59 + ($auditReceiptPhone == null ? 43 : $auditReceiptPhone.hashCode());
      Object $receiptTime = this.getReceiptTime();
      result = result * 59 + ($receiptTime == null ? 43 : $receiptTime.hashCode());
      Object $artifactList = this.getArtifactList();
      result = result * 59 + ($artifactList == null ? 43 : $artifactList.hashCode());
      Object $partList = this.getPartList();
      result = result * 59 + ($partList == null ? 43 : $partList.hashCode());
      Object $assembleList = this.getAssembleList();
      result = result * 59 + ($assembleList == null ? 43 : $assembleList.hashCode());
      Object $enclosureList = this.getEnclosureList();
      result = result * 59 + ($enclosureList == null ? 43 : $enclosureList.hashCode());
      Object $auxiliaryMaterialList = this.getAuxiliaryMaterialList();
      result = result * 59 + ($auxiliaryMaterialList == null ? 43 : $auxiliaryMaterialList.hashCode());
      Object $packageList = this.getPackageList();
      result = result * 59 + ($packageList == null ? 43 : $packageList.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      result = result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
      Object $unshippedPartList = this.getUnshippedPartList();
      return result * 59 + ($unshippedPartList == null ? 43 : $unshippedPartList.hashCode());
   }

   public static class CargoListDetailsDTOBuilder {
      private ProjectInfo project;
      private String serialNumber;
      private String carModel;
      private Integer projectSettlementType;
      private Long supplierPriceId;
      private BigDecimal supplierPrice;
      private Integer productType;
      private Integer manufactureType;
      private String licensePlate;
      private String driverName;
      private String driverPhone;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal actualWeight;
      private BigDecimal actualGrossWeight;
      private BigDecimal emptyCars;
      private Integer status;
      private Long userId;
      private String userName;
      private Long actualUserId;
      private String actualUserName;
      private LocalDateTime actualTime;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private String receiptName;
      private String receiptPhone;
      private String auditReceiptName;
      private String auditReceiptPhone;
      private LocalDateTime receiptTime;
      private List<ArtifactDetailDO> artifactList;
      private List<SendDirectlyDetailDO> partList;
      private List<SendDirectlyDetailDO> assembleList;
      private List<EnclosureDetailDO> enclosureList;
      private List<TechStandardPartDetailDO> auxiliaryMaterialList;
      private List<PackageDetailDO> packageList;
      private List<AttachmentDTO> attachmentDTOS;
      private List<SendDirectlyDetailDO> unshippedPartList;

      CargoListDetailsDTOBuilder() {
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder carModel(final String carModel) {
         this.carModel = carModel;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder projectSettlementType(final Integer projectSettlementType) {
         this.projectSettlementType = projectSettlementType;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder supplierPriceId(final Long supplierPriceId) {
         this.supplierPriceId = supplierPriceId;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder supplierPrice(final BigDecimal supplierPrice) {
         this.supplierPrice = supplierPrice;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder manufactureType(final Integer manufactureType) {
         this.manufactureType = manufactureType;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder driverName(final String driverName) {
         this.driverName = driverName;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder driverPhone(final String driverPhone) {
         this.driverPhone = driverPhone;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder actualWeight(final BigDecimal actualWeight) {
         this.actualWeight = actualWeight;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder actualGrossWeight(final BigDecimal actualGrossWeight) {
         this.actualGrossWeight = actualGrossWeight;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder emptyCars(final BigDecimal emptyCars) {
         this.emptyCars = emptyCars;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder actualUserId(final Long actualUserId) {
         this.actualUserId = actualUserId;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder actualUserName(final String actualUserName) {
         this.actualUserName = actualUserName;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder actualTime(final LocalDateTime actualTime) {
         this.actualTime = actualTime;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder receiptName(final String receiptName) {
         this.receiptName = receiptName;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder receiptPhone(final String receiptPhone) {
         this.receiptPhone = receiptPhone;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder auditReceiptName(final String auditReceiptName) {
         this.auditReceiptName = auditReceiptName;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder auditReceiptPhone(final String auditReceiptPhone) {
         this.auditReceiptPhone = auditReceiptPhone;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder receiptTime(final LocalDateTime receiptTime) {
         this.receiptTime = receiptTime;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder artifactList(final List<ArtifactDetailDO> artifactList) {
         this.artifactList = artifactList;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder partList(final List<SendDirectlyDetailDO> partList) {
         this.partList = partList;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder assembleList(final List<SendDirectlyDetailDO> assembleList) {
         this.assembleList = assembleList;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder enclosureList(final List<EnclosureDetailDO> enclosureList) {
         this.enclosureList = enclosureList;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder auxiliaryMaterialList(final List<TechStandardPartDetailDO> auxiliaryMaterialList) {
         this.auxiliaryMaterialList = auxiliaryMaterialList;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder packageList(final List<PackageDetailDO> packageList) {
         this.packageList = packageList;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder attachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
         this.attachmentDTOS = attachmentDTOS;
         return this;
      }

      public CargoListDetailsDTO.CargoListDetailsDTOBuilder unshippedPartList(final List<SendDirectlyDetailDO> unshippedPartList) {
         this.unshippedPartList = unshippedPartList;
         return this;
      }

      public CargoListDetailsDTO build() {
         return new CargoListDetailsDTO(
            this.project,
            this.serialNumber,
            this.carModel,
            this.projectSettlementType,
            this.supplierPriceId,
            this.supplierPrice,
            this.productType,
            this.manufactureType,
            this.licensePlate,
            this.driverName,
            this.driverPhone,
            this.quantity,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.actualWeight,
            this.actualGrossWeight,
            this.emptyCars,
            this.status,
            this.userId,
            this.userName,
            this.actualUserId,
            this.actualUserName,
            this.actualTime,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.receiptName,
            this.receiptPhone,
            this.auditReceiptName,
            this.auditReceiptPhone,
            this.receiptTime,
            this.artifactList,
            this.partList,
            this.assembleList,
            this.enclosureList,
            this.auxiliaryMaterialList,
            this.packageList,
            this.attachmentDTOS,
            this.unshippedPartList
         );
      }

      @Override
      public String toString() {
         return "CargoListDetailsDTO.CargoListDetailsDTOBuilder(project="
            + this.project
            + ", serialNumber="
            + this.serialNumber
            + ", carModel="
            + this.carModel
            + ", projectSettlementType="
            + this.projectSettlementType
            + ", supplierPriceId="
            + this.supplierPriceId
            + ", supplierPrice="
            + this.supplierPrice
            + ", productType="
            + this.productType
            + ", manufactureType="
            + this.manufactureType
            + ", licensePlate="
            + this.licensePlate
            + ", driverName="
            + this.driverName
            + ", driverPhone="
            + this.driverPhone
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", actualWeight="
            + this.actualWeight
            + ", actualGrossWeight="
            + this.actualGrossWeight
            + ", emptyCars="
            + this.emptyCars
            + ", status="
            + this.status
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", actualUserId="
            + this.actualUserId
            + ", actualUserName="
            + this.actualUserName
            + ", actualTime="
            + this.actualTime
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", receiptName="
            + this.receiptName
            + ", receiptPhone="
            + this.receiptPhone
            + ", auditReceiptName="
            + this.auditReceiptName
            + ", auditReceiptPhone="
            + this.auditReceiptPhone
            + ", receiptTime="
            + this.receiptTime
            + ", artifactList="
            + this.artifactList
            + ", partList="
            + this.partList
            + ", assembleList="
            + this.assembleList
            + ", enclosureList="
            + this.enclosureList
            + ", auxiliaryMaterialList="
            + this.auxiliaryMaterialList
            + ", packageList="
            + this.packageList
            + ", attachmentDTOS="
            + this.attachmentDTOS
            + ", unshippedPartList="
            + this.unshippedPartList
            + ")";
      }
   }
}

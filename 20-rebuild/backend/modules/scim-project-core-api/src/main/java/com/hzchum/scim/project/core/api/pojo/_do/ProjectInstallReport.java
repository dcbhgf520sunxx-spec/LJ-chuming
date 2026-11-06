package com.hzchum.scim.project.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ProjectInstallReport对象", description = "项目安装填报表 ")
@Entity
@TableName("project_install_report")
@Table(name = "project_install_report")
@org.hibernate.annotations.Table(appliesTo = "project_install_report", comment = "项目安装填报表 ")
public class ProjectInstallReport extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库", notes = "项目类型 1建钢项目 2桥梁项目 4立体停车库")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) default 1  COMMENT '项目类型 1建钢项目 2桥梁项目 4立体停车库'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "productType", value = "产品类型(2构件 , 4围护 , 8配套件)", notes = "产品类型(2构件 , 4围护 , 8配套件)")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型(2构件 , 4围护 , 8配套件)'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT '围护类型'")
   private Integer category;
   @ApiModelProperty(name = "productId", value = "产品ID(构件、围护、配套件id)", notes = "产品ID(构件、围护、配套件id)")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品ID(构件、围护、配套件id)'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64)  COMMENT '产品编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '产品名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(64)  COMMENT '规格'")
   private String specification;
   @ApiModelProperty(name = "reportQuantity", value = "填报数量", notes = "填报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   @TableField("report_quantity")
   @Column(name = "report_quantity", columnDefinition = "DECIMAL(18,4)  COMMENT '填报数量'", nullable = false)
   private BigDecimal reportQuantity;
   @ApiModelProperty(name = "reportMete", value = "填报量(重量kg/长度mm)", notes = "填报量(重量kg/长度mm)")
   @JsonProperty("reportMete")
   @JSONField(name = "reportMete")
   @TableField("report_mete")
   @Column(name = "report_mete", columnDefinition = "decimal(32,8)  COMMENT '填报量(重量kg/长度mm)'", nullable = false)
   private BigDecimal reportMete;
   @ApiModelProperty(name = "reportTotalArea", value = "填报总面积(mm2)", notes = "填报总面积(mm2)")
   @JsonProperty("reportTotalArea")
   @JSONField(name = "reportTotalArea")
   @TableField("report_total_area")
   @Column(name = "report_total_area", columnDefinition = "decimal(32,8) DEFAULT 0.00000000 COMMENT '填报总面积(mm2)'")
   private BigDecimal reportTotalArea;
   @ApiModelProperty(name = "supplierId", value = "安装供应商id", notes = "安装供应商id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '安装供应商id'", nullable = false)
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "安装供应商名称", notes = "安装供应商名称")
   @JsonProperty("supplierName")
   @JSONField(name = "supplierName")
   @TableField("supplier_name")
   @Column(name = "supplier_name", columnDefinition = "varchar(64)  COMMENT '安装供应商名称'")
   private String supplierName;
   @ApiModelProperty(name = "userId", value = "填报用户id", notes = "填报用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '填报用户id'", updatable = false)
   private Long userId;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "tinyint(1) default '1' COMMENT '审核状态 1未审核 2审核通过 4驳回'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty(name = "actualQuantity", value = "实际数量", notes = "实际数量")
   @JsonProperty("actualQuantity")
   @JSONField(name = "actualQuantity")
   @TableField("actual_quantity")
   @Column(name = "actual_quantity", columnDefinition = "decimal(18,4)  COMMENT '实际数量'")
   private BigDecimal actualQuantity;
   @ApiModelProperty(name = "actualMete", value = "实际量(重量kg/长度m)", notes = "实际量(重量kg/长度mm)")
   @JsonProperty("actualMete")
   @JSONField(name = "actualMete")
   @TableField("actual_mete")
   @Column(name = "actual_mete", columnDefinition = "decimal(32,8)  COMMENT '实际量(重量kg/长度mm)'")
   private BigDecimal actualMete;
   @ApiModelProperty(name = "actualTotalArea", value = "实际总面积(mm2)", notes = "实际总面积(mm2)")
   @JsonProperty("actualTotalArea")
   @JSONField(name = "actualTotalArea")
   @TableField("actual_total_area")
   @Column(name = "actual_total_area", columnDefinition = "decimal(32,8) COMMENT '实际总面积(mm2)'")
   private BigDecimal actualTotalArea;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime(6)  COMMENT '审核时间'")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   @JsonProperty("auditUserId")
   @JSONField(name = "auditUserId")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '审核人id'")
   private Long auditUserId;
   @ApiModelProperty(name = "reportMethod", value = "填报方式 1:app端 0:pc端", notes = "填报方式 1:app端 0:pc端")
   @JsonProperty("reportMethod")
   @JSONField(name = "reportMethod")
   @TableField("report_method")
   @Column(name = "report_method", columnDefinition = "tinyint(11)  COMMENT '填报方式 1:app端 0:pc端'", nullable = false)
   private Integer reportMethod;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(64)  COMMENT '计量单位'")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(64)  COMMENT '核算单位'")
   private String accountingUnit;

   public static ProjectInstallReport.ProjectInstallReportBuilder builder() {
      return new ProjectInstallReport.ProjectInstallReportBuilder();
   }

   public ProjectInstallReport() {
   }

   public ProjectInstallReport(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer projectType,
      final Integer productType,
      final Integer category,
      final Long productId,
      final String serialNumber,
      final String name,
      final String specification,
      final BigDecimal reportQuantity,
      final BigDecimal reportMete,
      final BigDecimal reportTotalArea,
      final Long supplierId,
      final String supplierName,
      final Long userId,
      final Integer auditStatus,
      final BigDecimal actualQuantity,
      final BigDecimal actualMete,
      final BigDecimal actualTotalArea,
      final LocalDateTime auditTime,
      final Long auditUserId,
      final Integer reportMethod,
      final String measureUnit,
      final String accountingUnit
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.projectType = projectType;
      this.productType = productType;
      this.category = category;
      this.productId = productId;
      this.serialNumber = serialNumber;
      this.name = name;
      this.specification = specification;
      this.reportQuantity = reportQuantity;
      this.reportMete = reportMete;
      this.reportTotalArea = reportTotalArea;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.userId = userId;
      this.auditStatus = auditStatus;
      this.actualQuantity = actualQuantity;
      this.actualMete = actualMete;
      this.actualTotalArea = actualTotalArea;
      this.auditTime = auditTime;
      this.auditUserId = auditUserId;
      this.reportMethod = reportMethod;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
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

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getProductId() {
      return this.productId;
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

   public BigDecimal getReportQuantity() {
      return this.reportQuantity;
   }

   public BigDecimal getReportMete() {
      return this.reportMete;
   }

   public BigDecimal getReportTotalArea() {
      return this.reportTotalArea;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public BigDecimal getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getActualMete() {
      return this.actualMete;
   }

   public BigDecimal getActualTotalArea() {
      return this.actualTotalArea;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public Integer getReportMethod() {
      return this.reportMethod;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   @JsonProperty("id")
   public ProjectInstallReport setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectInstallReport setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProjectInstallReport setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ProjectInstallReport setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public ProjectInstallReport setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   @JsonProperty("productType")
   public ProjectInstallReport setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("category")
   public ProjectInstallReport setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("productId")
   public ProjectInstallReport setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProjectInstallReport setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("name")
   public ProjectInstallReport setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("specification")
   public ProjectInstallReport setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("reportQuantity")
   public ProjectInstallReport setReportQuantity(final BigDecimal reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("reportMete")
   public ProjectInstallReport setReportMete(final BigDecimal reportMete) {
      this.reportMete = reportMete;
      return this;
   }

   @JsonProperty("reportTotalArea")
   public ProjectInstallReport setReportTotalArea(final BigDecimal reportTotalArea) {
      this.reportTotalArea = reportTotalArea;
      return this;
   }

   @JsonProperty("supplierId")
   public ProjectInstallReport setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("supplierName")
   public ProjectInstallReport setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   @JsonProperty("userId")
   public ProjectInstallReport setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("auditStatus")
   public ProjectInstallReport setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @JsonProperty("actualQuantity")
   public ProjectInstallReport setActualQuantity(final BigDecimal actualQuantity) {
      this.actualQuantity = actualQuantity;
      return this;
   }

   @JsonProperty("actualMete")
   public ProjectInstallReport setActualMete(final BigDecimal actualMete) {
      this.actualMete = actualMete;
      return this;
   }

   @JsonProperty("actualTotalArea")
   public ProjectInstallReport setActualTotalArea(final BigDecimal actualTotalArea) {
      this.actualTotalArea = actualTotalArea;
      return this;
   }

   @JsonProperty("auditTime")
   public ProjectInstallReport setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @JsonProperty("auditUserId")
   public ProjectInstallReport setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   @JsonProperty("reportMethod")
   public ProjectInstallReport setReportMethod(final Integer reportMethod) {
      this.reportMethod = reportMethod;
      return this;
   }

   public ProjectInstallReport setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public ProjectInstallReport setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInstallReport(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", projectType="
         + this.getProjectType()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", productId="
         + this.getProductId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportMete="
         + this.getReportMete()
         + ", reportTotalArea="
         + this.getReportTotalArea()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", userId="
         + this.getUserId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", actualQuantity="
         + this.getActualQuantity()
         + ", actualMete="
         + this.getActualMete()
         + ", actualTotalArea="
         + this.getActualTotalArea()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", reportMethod="
         + this.getReportMethod()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallReport)) {
         return false;
      }

      ProjectInstallReport other = (ProjectInstallReport)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                  Object this$projectType = this.getProjectType();
                  Object other$projectType = other.getProjectType();
                  if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$supplierId = this.getSupplierId();
                              Object other$supplierId = other.getSupplierId();
                              if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                 Object this$userId = this.getUserId();
                                 Object other$userId = other.getUserId();
                                 if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                    Object this$auditStatus = this.getAuditStatus();
                                    Object other$auditStatus = other.getAuditStatus();
                                    if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                       Object this$auditUserId = this.getAuditUserId();
                                       Object other$auditUserId = other.getAuditUserId();
                                       if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                                          Object this$reportMethod = this.getReportMethod();
                                          Object other$reportMethod = other.getReportMethod();
                                          if (this$reportMethod == null ? other$reportMethod == null : this$reportMethod.equals(other$reportMethod)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$name = this.getName();
                                                Object other$name = other.getName();
                                                if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$reportQuantity = this.getReportQuantity();
                                                      Object other$reportQuantity = other.getReportQuantity();
                                                      if (this$reportQuantity == null
                                                         ? other$reportQuantity == null
                                                         : this$reportQuantity.equals(other$reportQuantity)) {
                                                         Object this$reportMete = this.getReportMete();
                                                         Object other$reportMete = other.getReportMete();
                                                         if (this$reportMete == null ? other$reportMete == null : this$reportMete.equals(other$reportMete)) {
                                                            Object this$reportTotalArea = this.getReportTotalArea();
                                                            Object other$reportTotalArea = other.getReportTotalArea();
                                                            if (this$reportTotalArea == null
                                                               ? other$reportTotalArea == null
                                                               : this$reportTotalArea.equals(other$reportTotalArea)) {
                                                               Object this$supplierName = this.getSupplierName();
                                                               Object other$supplierName = other.getSupplierName();
                                                               if (this$supplierName == null
                                                                  ? other$supplierName == null
                                                                  : this$supplierName.equals(other$supplierName)) {
                                                                  Object this$actualQuantity = this.getActualQuantity();
                                                                  Object other$actualQuantity = other.getActualQuantity();
                                                                  if (this$actualQuantity == null
                                                                     ? other$actualQuantity == null
                                                                     : this$actualQuantity.equals(other$actualQuantity)) {
                                                                     Object this$actualMete = this.getActualMete();
                                                                     Object other$actualMete = other.getActualMete();
                                                                     if (this$actualMete == null
                                                                        ? other$actualMete == null
                                                                        : this$actualMete.equals(other$actualMete)) {
                                                                        Object this$actualTotalArea = this.getActualTotalArea();
                                                                        Object other$actualTotalArea = other.getActualTotalArea();
                                                                        if (this$actualTotalArea == null
                                                                           ? other$actualTotalArea == null
                                                                           : this$actualTotalArea.equals(other$actualTotalArea)) {
                                                                           Object this$auditTime = this.getAuditTime();
                                                                           Object other$auditTime = other.getAuditTime();
                                                                           if (this$auditTime == null
                                                                              ? other$auditTime == null
                                                                              : this$auditTime.equals(other$auditTime)) {
                                                                              Object this$measureUnit = this.getMeasureUnit();
                                                                              Object other$measureUnit = other.getMeasureUnit();
                                                                              if (this$measureUnit == null
                                                                                 ? other$measureUnit == null
                                                                                 : this$measureUnit.equals(other$measureUnit)) {
                                                                                 Object this$accountingUnit = this.getAccountingUnit();
                                                                                 Object other$accountingUnit = other.getAccountingUnit();
                                                                                 return this$accountingUnit == null
                                                                                    ? other$accountingUnit == null
                                                                                    : this$accountingUnit.equals(other$accountingUnit);
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInstallReport;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $reportMethod = this.getReportMethod();
      result = result * 59 + ($reportMethod == null ? 43 : $reportMethod.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $reportMete = this.getReportMete();
      result = result * 59 + ($reportMete == null ? 43 : $reportMete.hashCode());
      Object $reportTotalArea = this.getReportTotalArea();
      result = result * 59 + ($reportTotalArea == null ? 43 : $reportTotalArea.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $actualTotalArea = this.getActualTotalArea();
      result = result * 59 + ($actualTotalArea == null ? 43 : $actualTotalArea.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   public static class ProjectInstallReportBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer projectType;
      private Integer productType;
      private Integer category;
      private Long productId;
      private String serialNumber;
      private String name;
      private String specification;
      private BigDecimal reportQuantity;
      private BigDecimal reportMete;
      private BigDecimal reportTotalArea;
      private Long supplierId;
      private String supplierName;
      private Long userId;
      private Integer auditStatus;
      private BigDecimal actualQuantity;
      private BigDecimal actualMete;
      private BigDecimal actualTotalArea;
      private LocalDateTime auditTime;
      private Long auditUserId;
      private Integer reportMethod;
      private String measureUnit;
      private String accountingUnit;

      ProjectInstallReportBuilder() {
      }

      @JsonProperty("id")
      public ProjectInstallReport.ProjectInstallReportBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectInstallReport.ProjectInstallReportBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProjectInstallReport.ProjectInstallReportBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ProjectInstallReport.ProjectInstallReportBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectInstallReport.ProjectInstallReportBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      @JsonProperty("productType")
      public ProjectInstallReport.ProjectInstallReportBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("category")
      public ProjectInstallReport.ProjectInstallReportBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("productId")
      public ProjectInstallReport.ProjectInstallReportBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectInstallReport.ProjectInstallReportBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public ProjectInstallReport.ProjectInstallReportBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("specification")
      public ProjectInstallReport.ProjectInstallReportBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("reportQuantity")
      public ProjectInstallReport.ProjectInstallReportBuilder reportQuantity(final BigDecimal reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("reportMete")
      public ProjectInstallReport.ProjectInstallReportBuilder reportMete(final BigDecimal reportMete) {
         this.reportMete = reportMete;
         return this;
      }

      @JsonProperty("reportTotalArea")
      public ProjectInstallReport.ProjectInstallReportBuilder reportTotalArea(final BigDecimal reportTotalArea) {
         this.reportTotalArea = reportTotalArea;
         return this;
      }

      @JsonProperty("supplierId")
      public ProjectInstallReport.ProjectInstallReportBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("supplierName")
      public ProjectInstallReport.ProjectInstallReportBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      @JsonProperty("userId")
      public ProjectInstallReport.ProjectInstallReportBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("auditStatus")
      public ProjectInstallReport.ProjectInstallReportBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      @JsonProperty("actualQuantity")
      public ProjectInstallReport.ProjectInstallReportBuilder actualQuantity(final BigDecimal actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      @JsonProperty("actualMete")
      public ProjectInstallReport.ProjectInstallReportBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      @JsonProperty("actualTotalArea")
      public ProjectInstallReport.ProjectInstallReportBuilder actualTotalArea(final BigDecimal actualTotalArea) {
         this.actualTotalArea = actualTotalArea;
         return this;
      }

      @JsonProperty("auditTime")
      public ProjectInstallReport.ProjectInstallReportBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      @JsonProperty("auditUserId")
      public ProjectInstallReport.ProjectInstallReportBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      @JsonProperty("reportMethod")
      public ProjectInstallReport.ProjectInstallReportBuilder reportMethod(final Integer reportMethod) {
         this.reportMethod = reportMethod;
         return this;
      }

      public ProjectInstallReport.ProjectInstallReportBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectInstallReport.ProjectInstallReportBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectInstallReport build() {
         return new ProjectInstallReport(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.projectType,
            this.productType,
            this.category,
            this.productId,
            this.serialNumber,
            this.name,
            this.specification,
            this.reportQuantity,
            this.reportMete,
            this.reportTotalArea,
            this.supplierId,
            this.supplierName,
            this.userId,
            this.auditStatus,
            this.actualQuantity,
            this.actualMete,
            this.actualTotalArea,
            this.auditTime,
            this.auditUserId,
            this.reportMethod,
            this.measureUnit,
            this.accountingUnit
         );
      }

      @Override
      public String toString() {
         return "ProjectInstallReport.ProjectInstallReportBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", projectType="
            + this.projectType
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", productId="
            + this.productId
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", reportQuantity="
            + this.reportQuantity
            + ", reportMete="
            + this.reportMete
            + ", reportTotalArea="
            + this.reportTotalArea
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", userId="
            + this.userId
            + ", auditStatus="
            + this.auditStatus
            + ", actualQuantity="
            + this.actualQuantity
            + ", actualMete="
            + this.actualMete
            + ", actualTotalArea="
            + this.actualTotalArea
            + ", auditTime="
            + this.auditTime
            + ", auditUserId="
            + this.auditUserId
            + ", reportMethod="
            + this.reportMethod
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ")";
      }
   }
}

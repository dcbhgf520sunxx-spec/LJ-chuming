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

@ApiModel(value = "ProjectRejectDetail对象", description = "")
@Entity
@TableName("project_reject_detail")
@Table(name = "project_reject_detail")
@org.hibernate.annotations.Table(appliesTo = "project_reject_detail")
public class ProjectRejectDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "receivedId", value = "收货记录id", notes = "收货记录id")
   @TableField("received_id")
   @Column(name = "received_id", columnDefinition = "bigint  COMMENT '收货记录id'", nullable = true)
   private Long receivedId;
   @ApiModelProperty(name = "receivedDate", value = "收货日期", notes = "收货日期")
   @TableField("received_date")
   @Column(name = "received_date", columnDefinition = "datetime  COMMENT '收货日期'", nullable = true)
   private LocalDateTime receivedDate;
   @ApiModelProperty(name = "supplierId", value = "供应商", notes = "供应商")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint  COMMENT '供应商'", nullable = true)
   private Long supplierId;
   @ApiModelProperty(name = "purchaseId", value = "采购单id", notes = "采购单id")
   @TableField("purchase_id")
   @Column(name = "purchase_id", columnDefinition = "bigint  COMMENT '采购单id'", nullable = true)
   private Long purchaseId;
   @ApiModelProperty(name = "purchaseSn", value = "采购单编号", notes = "采购单编号")
   @TableField("purchase_sn")
   @Column(name = "purchase_sn", columnDefinition = "varchar(255)  COMMENT '采购单编号'", nullable = true)
   private String purchaseSn;
   @ApiModelProperty(name = "receivedUserName", value = "收货人", notes = "收货人")
   @TableField("received_user_name")
   @Column(name = "received_user_name", columnDefinition = "varchar(255)  COMMENT '收货人'", nullable = true)
   private String receivedUserName;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库", notes = "项目类型 1建钢项目 2桥梁项目 4立体停车库")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) default 1  COMMENT '项目类型 1建钢项目 2桥梁项目 4立体停车库'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int  COMMENT '产品类型'", nullable = true)
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint  COMMENT '产品id'", nullable = true)
   private Long productId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT '区域id'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64)  COMMENT '产品编号'")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '产品名称'")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(64)  COMMENT '规格'")
   private String specification;
   @ApiModelProperty(name = "rejectQuantity", value = "退货量 ", notes = "退货量")
   @JsonProperty("rejectQuantity")
   @JSONField(name = "rejectQuantity")
   @TableField("reject_quantity")
   @Column(name = "reject_quantity", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '退货数量'", nullable = true)
   private BigDecimal rejectQuantity;
   @ApiModelProperty(name = "rejectMete", value = "退货核算量 ", notes = "退货核算量")
   @JsonProperty("rejectMete")
   @JSONField(name = "rejectMete")
   @TableField("reject_mete")
   @Column(name = "reject_mete", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '退货核算量'", nullable = true)
   private BigDecimal rejectMete;
   @ApiModelProperty(name = "rejectActualReceivedMete", value = "实际退货量 ", notes = "实际退货量")
   @JsonProperty("rejectActualReceivedMete")
   @JSONField(name = "rejectActualReceivedMete")
   @TableField("reject_actual_received_mete")
   @Column(name = "reject_actual_received_mete", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '实际退货量'", nullable = true)
   private BigDecimal rejectActualReceivedMete;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态", notes = "审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID", notes = "审核人ID")
   @JsonProperty("reviewerId")
   @JSONField(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id", columnDefinition = "bigint  COMMENT '审核人ID'", nullable = true)
   private Long reviewerId;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint(20)  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称", notes = "审核人名称")
   @JsonProperty("reviewerName")
   @JSONField(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name", columnDefinition = "varchar(255)  COMMENT '审核人名称'", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "rejectSn", value = "单据编号", notes = "单据编号")
   @JsonProperty("rejectSn")
   @JSONField(name = "rejectSn")
   @TableField("reject_sn")
   @Column(name = "reject_sn", columnDefinition = "varchar(64)  COMMENT '单据编号'")
   private String rejectSn;
   @ApiModelProperty(name = "rejectId", value = "单据id", notes = "单据id")
   @JsonProperty("rejectId")
   @JSONField(name = "rejectId")
   @TableField("reject_id")
   @Column(name = "reject_id", columnDefinition = "bigint  COMMENT '单据id'")
   private Long rejectId;
   @ApiModelProperty(name = "purchaseDetailsId", value = "采购详情id", notes = "采购详情id")
   @JsonProperty("purchaseDetailsId")
   @JSONField(name = "purchaseDetailsId")
   @TableField("purchase_details_id")
   @Column(name = "purchase_details_id", columnDefinition = "bigint(20)  COMMENT '采购详情id'")
   private Long purchaseDetailsId;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(64)  COMMENT '核算单位'")
   private String accountingUnit;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   @JsonProperty("measureUnit")
   @JSONField(name = "measureUnit")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(64)  COMMENT '计量单位'")
   private String measureUnit;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   @TableField("enclosure_plan_id")
   @Column(name = "enclosure_plan_id", columnDefinition = "bigint(20) DEFAULT NULL comment '围护计划表id'")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "wageQuotaType", value = "制成品计价方式 WmsWageQuotaTypeEnum", notes = "制成品计价方式 计价方式 WmsWageQuotaTypeEnum")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   @TableField("wage_quota_type")
   @Column(name = "wage_quota_type", columnDefinition = "int(11)  COMMENT '制成品计价方式 计价方式 WmsWageQuotaTypeEnum'", nullable = true)
   private Integer wageQuotaType;
   @ApiModelProperty(name = "category")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT ''", nullable = true)
   private Integer category;

   public static ProjectRejectDetail.ProjectRejectDetailBuilder builder() {
      return new ProjectRejectDetail.ProjectRejectDetailBuilder();
   }

   public ProjectRejectDetail() {
   }

   public ProjectRejectDetail(
      final Long id,
      final Long receivedId,
      final LocalDateTime receivedDate,
      final Long supplierId,
      final Long purchaseId,
      final String purchaseSn,
      final String receivedUserName,
      final Integer projectType,
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
      final Long classifyId,
      final String reviewerName,
      final LocalDateTime reviewTime,
      final String rejectSn,
      final Long rejectId,
      final Long purchaseDetailsId,
      final String accountingUnit,
      final String measureUnit,
      final Long enclosurePlanId,
      final Integer wageQuotaType,
      final Integer category
   ) {
      this.id = id;
      this.receivedId = receivedId;
      this.receivedDate = receivedDate;
      this.supplierId = supplierId;
      this.purchaseId = purchaseId;
      this.purchaseSn = purchaseSn;
      this.receivedUserName = receivedUserName;
      this.projectType = projectType;
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
      this.classifyId = classifyId;
      this.reviewerName = reviewerName;
      this.reviewTime = reviewTime;
      this.rejectSn = rejectSn;
      this.rejectId = rejectId;
      this.purchaseDetailsId = purchaseDetailsId;
      this.accountingUnit = accountingUnit;
      this.measureUnit = measureUnit;
      this.enclosurePlanId = enclosurePlanId;
      this.wageQuotaType = wageQuotaType;
      this.category = category;
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

   public Integer getProjectType() {
      return this.projectType;
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

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getReviewerName() {
      return this.reviewerName;
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

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public ProjectRejectDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectRejectDetail setReceivedId(final Long receivedId) {
      this.receivedId = receivedId;
      return this;
   }

   public ProjectRejectDetail setReceivedDate(final LocalDateTime receivedDate) {
      this.receivedDate = receivedDate;
      return this;
   }

   public ProjectRejectDetail setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ProjectRejectDetail setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
      return this;
   }

   public ProjectRejectDetail setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
      return this;
   }

   public ProjectRejectDetail setReceivedUserName(final String receivedUserName) {
      this.receivedUserName = receivedUserName;
      return this;
   }

   public ProjectRejectDetail setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   public ProjectRejectDetail setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public ProjectRejectDetail setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public ProjectRejectDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectRejectDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public ProjectRejectDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProjectRejectDetail setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("name")
   public ProjectRejectDetail setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("specification")
   public ProjectRejectDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("rejectQuantity")
   public ProjectRejectDetail setRejectQuantity(final BigDecimal rejectQuantity) {
      this.rejectQuantity = rejectQuantity;
      return this;
   }

   @JsonProperty("rejectMete")
   public ProjectRejectDetail setRejectMete(final BigDecimal rejectMete) {
      this.rejectMete = rejectMete;
      return this;
   }

   @JsonProperty("rejectActualReceivedMete")
   public ProjectRejectDetail setRejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
      this.rejectActualReceivedMete = rejectActualReceivedMete;
      return this;
   }

   @JsonProperty("applicantId")
   public ProjectRejectDetail setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public ProjectRejectDetail setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("reviewStatus")
   public ProjectRejectDetail setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("reviewerId")
   public ProjectRejectDetail setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("classifyId")
   public ProjectRejectDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("reviewerName")
   public ProjectRejectDetail setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("reviewTime")
   public ProjectRejectDetail setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("rejectSn")
   public ProjectRejectDetail setRejectSn(final String rejectSn) {
      this.rejectSn = rejectSn;
      return this;
   }

   @JsonProperty("rejectId")
   public ProjectRejectDetail setRejectId(final Long rejectId) {
      this.rejectId = rejectId;
      return this;
   }

   @JsonProperty("purchaseDetailsId")
   public ProjectRejectDetail setPurchaseDetailsId(final Long purchaseDetailsId) {
      this.purchaseDetailsId = purchaseDetailsId;
      return this;
   }

   @JsonProperty("accountingUnit")
   public ProjectRejectDetail setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("measureUnit")
   public ProjectRejectDetail setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public ProjectRejectDetail setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public ProjectRejectDetail setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("category")
   public ProjectRejectDetail setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectRejectDetail(id="
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
         + ", projectType="
         + this.getProjectType()
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
         + ", classifyId="
         + this.getClassifyId()
         + ", reviewerName="
         + this.getReviewerName()
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
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", category="
         + this.getCategory()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectRejectDetail)) {
         return false;
      }

      ProjectRejectDetail other = (ProjectRejectDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                  Object this$projectType = this.getProjectType();
                  Object other$projectType = other.getProjectType();
                  if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
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
                                             Object this$classifyId = this.getClassifyId();
                                             Object other$classifyId = other.getClassifyId();
                                             if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                                Object this$rejectId = this.getRejectId();
                                                Object other$rejectId = other.getRejectId();
                                                if (this$rejectId == null ? other$rejectId == null : this$rejectId.equals(other$rejectId)) {
                                                   Object this$purchaseDetailsId = this.getPurchaseDetailsId();
                                                   Object other$purchaseDetailsId = other.getPurchaseDetailsId();
                                                   if (this$purchaseDetailsId == null
                                                      ? other$purchaseDetailsId == null
                                                      : this$purchaseDetailsId.equals(other$purchaseDetailsId)) {
                                                      Object this$enclosurePlanId = this.getEnclosurePlanId();
                                                      Object other$enclosurePlanId = other.getEnclosurePlanId();
                                                      if (this$enclosurePlanId == null
                                                         ? other$enclosurePlanId == null
                                                         : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                                                         Object this$wageQuotaType = this.getWageQuotaType();
                                                         Object other$wageQuotaType = other.getWageQuotaType();
                                                         if (this$wageQuotaType == null
                                                            ? other$wageQuotaType == null
                                                            : this$wageQuotaType.equals(other$wageQuotaType)) {
                                                            Object this$category = this.getCategory();
                                                            Object other$category = other.getCategory();
                                                            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
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
                                                                                                         return this$measureUnit == null
                                                                                                            ? other$measureUnit == null
                                                                                                            : this$measureUnit.equals(other$measureUnit);
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof ProjectRejectDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $receivedId = this.getReceivedId();
      result = result * 59 + ($receivedId == null ? 43 : $receivedId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
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
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $rejectId = this.getRejectId();
      result = result * 59 + ($rejectId == null ? 43 : $rejectId.hashCode());
      Object $purchaseDetailsId = this.getPurchaseDetailsId();
      result = result * 59 + ($purchaseDetailsId == null ? 43 : $purchaseDetailsId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
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
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $rejectSn = this.getRejectSn();
      result = result * 59 + ($rejectSn == null ? 43 : $rejectSn.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      return result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
   }

   public static class ProjectRejectDetailBuilder {
      private Long id;
      private Long receivedId;
      private LocalDateTime receivedDate;
      private Long supplierId;
      private Long purchaseId;
      private String purchaseSn;
      private String receivedUserName;
      private Integer projectType;
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
      private Long classifyId;
      private String reviewerName;
      private LocalDateTime reviewTime;
      private String rejectSn;
      private Long rejectId;
      private Long purchaseDetailsId;
      private String accountingUnit;
      private String measureUnit;
      private Long enclosurePlanId;
      private Integer wageQuotaType;
      private Integer category;

      ProjectRejectDetailBuilder() {
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder receivedId(final Long receivedId) {
         this.receivedId = receivedId;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder receivedDate(final LocalDateTime receivedDate) {
         this.receivedDate = receivedDate;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder receivedUserName(final String receivedUserName) {
         this.receivedUserName = receivedUserName;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectRejectDetail.ProjectRejectDetailBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public ProjectRejectDetail.ProjectRejectDetailBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("specification")
      public ProjectRejectDetail.ProjectRejectDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("rejectQuantity")
      public ProjectRejectDetail.ProjectRejectDetailBuilder rejectQuantity(final BigDecimal rejectQuantity) {
         this.rejectQuantity = rejectQuantity;
         return this;
      }

      @JsonProperty("rejectMete")
      public ProjectRejectDetail.ProjectRejectDetailBuilder rejectMete(final BigDecimal rejectMete) {
         this.rejectMete = rejectMete;
         return this;
      }

      @JsonProperty("rejectActualReceivedMete")
      public ProjectRejectDetail.ProjectRejectDetailBuilder rejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
         this.rejectActualReceivedMete = rejectActualReceivedMete;
         return this;
      }

      @JsonProperty("applicantId")
      public ProjectRejectDetail.ProjectRejectDetailBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public ProjectRejectDetail.ProjectRejectDetailBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("reviewStatus")
      public ProjectRejectDetail.ProjectRejectDetailBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("reviewerId")
      public ProjectRejectDetail.ProjectRejectDetailBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("classifyId")
      public ProjectRejectDetail.ProjectRejectDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("reviewerName")
      public ProjectRejectDetail.ProjectRejectDetailBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("reviewTime")
      public ProjectRejectDetail.ProjectRejectDetailBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("rejectSn")
      public ProjectRejectDetail.ProjectRejectDetailBuilder rejectSn(final String rejectSn) {
         this.rejectSn = rejectSn;
         return this;
      }

      @JsonProperty("rejectId")
      public ProjectRejectDetail.ProjectRejectDetailBuilder rejectId(final Long rejectId) {
         this.rejectId = rejectId;
         return this;
      }

      @JsonProperty("purchaseDetailsId")
      public ProjectRejectDetail.ProjectRejectDetailBuilder purchaseDetailsId(final Long purchaseDetailsId) {
         this.purchaseDetailsId = purchaseDetailsId;
         return this;
      }

      @JsonProperty("accountingUnit")
      public ProjectRejectDetail.ProjectRejectDetailBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("measureUnit")
      public ProjectRejectDetail.ProjectRejectDetailBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectRejectDetail.ProjectRejectDetailBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public ProjectRejectDetail.ProjectRejectDetailBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("category")
      public ProjectRejectDetail.ProjectRejectDetailBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProjectRejectDetail build() {
         return new ProjectRejectDetail(
            this.id,
            this.receivedId,
            this.receivedDate,
            this.supplierId,
            this.purchaseId,
            this.purchaseSn,
            this.receivedUserName,
            this.projectType,
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
            this.classifyId,
            this.reviewerName,
            this.reviewTime,
            this.rejectSn,
            this.rejectId,
            this.purchaseDetailsId,
            this.accountingUnit,
            this.measureUnit,
            this.enclosurePlanId,
            this.wageQuotaType,
            this.category
         );
      }

      @Override
      public String toString() {
         return "ProjectRejectDetail.ProjectRejectDetailBuilder(id="
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
            + ", projectType="
            + this.projectType
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
            + ", classifyId="
            + this.classifyId
            + ", reviewerName="
            + this.reviewerName
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
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", category="
            + this.category
            + ")";
      }
   }
}

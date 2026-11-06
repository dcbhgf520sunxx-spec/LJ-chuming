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
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ProjectQhseProblem对象", description = "质安问题表 ")
@Entity
@TableName("project_qhse_problem")
@Table(name = "project_qhse_problem")
@org.hibernate.annotations.Table(appliesTo = "project_qhse_problem", comment = "质安问题表 ")
public class ProjectQhseProblem extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "number", value = "流水号", notes = "流水号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "varchar(64)  COMMENT '流水号'", nullable = false)
   private String number;
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
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'")
   private Long monomerId;
   @ApiModelProperty(name = "subcontractOrderId", value = "分包订单ID", notes = "分包订单ID")
   @JsonProperty("subcontractOrderId")
   @JSONField(name = "subcontractOrderId")
   @TableField("subcontract_order_id")
   @Column(name = "subcontract_order_id", columnDefinition = "bigint(20)  COMMENT '分包订单ID'", nullable = true)
   private Long subcontractOrderId;
   @ApiModelProperty(name = "supplierId", value = "分包单位ID", notes = "分包单位ID")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '分包单位ID'")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位", notes = "分包单位")
   @JsonProperty("supplierName")
   @JSONField(name = "supplierName")
   @TableField("supplier_name")
   @Column(name = "supplier_name", columnDefinition = "varchar(128)  COMMENT '分包单位'")
   private String supplierName;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   @JsonProperty("subcontractClassId")
   @JSONField(name = "subcontractClassId")
   @TableField("subcontract_class_id")
   @Column(name = "subcontract_class_id", columnDefinition = "bigint(20)  COMMENT '分包类别id'")
   private Long subcontractClassId;
   @ApiModelProperty(name = "subcontractClassName", value = "分包类别", notes = "分包类别")
   @JsonProperty("subcontractClassName")
   @JSONField(name = "subcontractClassName")
   @TableField("subcontract_class_name")
   @Column(name = "subcontract_class_name", columnDefinition = "varchar(128)  COMMENT '分包类别'")
   private String subcontractClassName;
   @ApiModelProperty(name = "problemDate", value = "日期", notes = "日期")
   @JsonProperty("problemDate")
   @JSONField(name = "problemDate")
   @TableField("problem_date")
   @Column(name = "problem_date", columnDefinition = "date  COMMENT '日期'", nullable = false)
   private LocalDate problemDate;
   @ApiModelProperty(name = "promoterId", value = "发起人id", notes = "发起人id")
   @JsonProperty("promoterId")
   @JSONField(name = "promoterId")
   @TableField("promoter_id")
   @Column(name = "promoter_id", columnDefinition = "bigint(20)  COMMENT '发起人id'", nullable = false)
   private Long promoterId;
   @ApiModelProperty(name = "promoterName", value = "发起人", notes = "发起人")
   @JsonProperty("promoterName")
   @JSONField(name = "promoterName")
   @TableField("promoter_name")
   @Column(name = "promoter_name", columnDefinition = "varchar(128)  COMMENT '发起人'")
   private String promoterName;
   @ApiModelProperty(name = "problemTypeId", value = "问题类型ID", notes = "问题类型ID")
   @JsonProperty("problemTypeId")
   @JSONField(name = "problemTypeId")
   @TableField("problem_type_id")
   @Column(name = "problem_type_id", columnDefinition = "bigint(20)  COMMENT '问题类型ID'")
   private Long problemTypeId;
   @ApiModelProperty(name = "problemTypeName", value = "问题类型", notes = "问题类型")
   @JsonProperty("problemTypeName")
   @JSONField(name = "problemTypeName")
   @TableField("problem_type_name")
   @Column(name = "problem_type_name", columnDefinition = "varchar(128)  COMMENT '问题类型'")
   private String problemTypeName;
   @ApiModelProperty(name = "beforeChangeImgs", value = "整改前图片", notes = "整改前图片")
   @JsonProperty("beforeChangeImgs")
   @JSONField(name = "beforeChangeImgs")
   @TableField("before_change_imgs")
   @Column(name = "before_change_imgs", columnDefinition = "varchar(2048)  COMMENT '整改前图片'")
   private String beforeChangeImgs;
   @ApiModelProperty(name = "afterChangeImgs", value = "整改后图片", notes = "整改后图片")
   @JsonProperty("afterChangeImgs")
   @JSONField(name = "afterChangeImgs")
   @TableField("after_change_imgs")
   @Column(name = "after_change_imgs", columnDefinition = "varchar(2048)  COMMENT '整改后图片'")
   private String afterChangeImgs;
   @ApiModelProperty(name = "boolChangeStatus", value = "整改状态 0未整改1已整改", notes = "整改状态 0未整改1已整改")
   @JsonProperty("boolChangeStatus")
   @JSONField(name = "boolChangeStatus")
   @TableField("bool_change_status")
   @Column(name = "bool_change_status", columnDefinition = "tinyint(1) default '0' COMMENT '整改状态 0未整改1已整改'", nullable = false)
   private Boolean boolChangeStatus;
   @ApiModelProperty(name = "penalty", value = "违约金", notes = "违约金")
   @JsonProperty("penalty")
   @JSONField(name = "penalty")
   @TableField("penalty")
   @Column(name = "penalty", columnDefinition = "decimal(32,8) default 0.0 COMMENT '违约金'")
   private BigDecimal penalty;
   @ApiModelProperty("是否已扣除 true 已扣除 false 未扣除")
   @JsonProperty("boolDeductStatus")
   @JSONField(name = "boolDeductStatus")
   @TableField("bool_deduct_status")
   @Column(name = "bool_deduct_status", columnDefinition = "tinyint(1) default 0 COMMENT '扣除状态 0未扣除 1已扣除'", nullable = false)
   private Boolean boolDeductStatus;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(2048)  COMMENT '备注'")
   private String remark;
   @ApiModelProperty("是否回复 true回复 false不回复")
   @JsonProperty("boolReply")
   @JSONField(name = "boolReply")
   @TableField("bool_reply")
   @Column(name = "bool_reply", columnDefinition = "tinyint(1) default 0 COMMENT '是否回复 1回复 0不回复'", nullable = false)
   private Boolean boolReply;
   @ApiModelProperty(name = "isInternal", value = "0外部 1内部 ")
   @JsonProperty("isInternal")
   @JSONField(name = "isInternal")
   @TableField("is_internal")
   @Column(name = "is_internal", columnDefinition = "tinyint(1) default '0' COMMENT '0外部 1内部'", nullable = false)
   private Boolean isInternal;
   @ApiModelProperty(name = "boolChangeStatusV2", value = "整改状态", notes = "整改状态")
   @JsonProperty("boolChangeStatusV2")
   @JSONField(name = "boolChangeStatusV2")
   @TableField("bool_change_statusV2")
   @Column(name = "bool_change_statusV2", columnDefinition = "tinyint(1) default '0' COMMENT '整改状态'", nullable = false)
   private Integer boolChangeStatusV2;
   @ApiModelProperty(name = "type", value = "问题类型", notes = "问题类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(5) COMMENT '问题类型'")
   private Integer type;
   @ApiModelProperty(name = "problemId", value = "问题id", notes = "问题id")
   @JsonProperty("problemId")
   @JSONField(name = "problemId")
   @TableField("problem_id")
   @Column(name = "problem_id", columnDefinition = "bigint(20)  COMMENT '问题id'")
   private Long problemId;
   @ApiModelProperty(name = "userId", value = "责任人", notes = "责任人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) COMMENT '责任人'")
   private Long userId;

   public static ProjectQhseProblem.ProjectQhseProblemBuilder builder() {
      return new ProjectQhseProblem.ProjectQhseProblemBuilder();
   }

   public ProjectQhseProblem() {
   }

   public ProjectQhseProblem(
      final Long id,
      final String number,
      final Long projectId,
      final Long monomerId,
      final Long subcontractOrderId,
      final Long supplierId,
      final String supplierName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final LocalDate problemDate,
      final Long promoterId,
      final String promoterName,
      final Long problemTypeId,
      final String problemTypeName,
      final String beforeChangeImgs,
      final String afterChangeImgs,
      final Boolean boolChangeStatus,
      final BigDecimal penalty,
      final Boolean boolDeductStatus,
      final String remark,
      final Boolean boolReply,
      final Boolean isInternal,
      final Integer boolChangeStatusV2,
      final Integer type,
      final Long problemId,
      final Long userId
   ) {
      this.id = id;
      this.number = number;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.subcontractOrderId = subcontractOrderId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.problemDate = problemDate;
      this.promoterId = promoterId;
      this.promoterName = promoterName;
      this.problemTypeId = problemTypeId;
      this.problemTypeName = problemTypeName;
      this.beforeChangeImgs = beforeChangeImgs;
      this.afterChangeImgs = afterChangeImgs;
      this.boolChangeStatus = boolChangeStatus;
      this.penalty = penalty;
      this.boolDeductStatus = boolDeductStatus;
      this.remark = remark;
      this.boolReply = boolReply;
      this.isInternal = isInternal;
      this.boolChangeStatusV2 = boolChangeStatusV2;
      this.type = type;
      this.problemId = problemId;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public String getNumber() {
      return this.number;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getSubcontractOrderId() {
      return this.subcontractOrderId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public String getSubcontractClassName() {
      return this.subcontractClassName;
   }

   public LocalDate getProblemDate() {
      return this.problemDate;
   }

   public Long getPromoterId() {
      return this.promoterId;
   }

   public String getPromoterName() {
      return this.promoterName;
   }

   public Long getProblemTypeId() {
      return this.problemTypeId;
   }

   public String getProblemTypeName() {
      return this.problemTypeName;
   }

   public String getBeforeChangeImgs() {
      return this.beforeChangeImgs;
   }

   public String getAfterChangeImgs() {
      return this.afterChangeImgs;
   }

   public Boolean getBoolChangeStatus() {
      return this.boolChangeStatus;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public Boolean getBoolDeductStatus() {
      return this.boolDeductStatus;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolReply() {
      return this.boolReply;
   }

   public Boolean getIsInternal() {
      return this.isInternal;
   }

   public Integer getBoolChangeStatusV2() {
      return this.boolChangeStatusV2;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getProblemId() {
      return this.problemId;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public ProjectQhseProblem setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("number")
   public ProjectQhseProblem setNumber(final String number) {
      this.number = number;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectQhseProblem setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProjectQhseProblem setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("subcontractOrderId")
   public ProjectQhseProblem setSubcontractOrderId(final Long subcontractOrderId) {
      this.subcontractOrderId = subcontractOrderId;
      return this;
   }

   @JsonProperty("supplierId")
   public ProjectQhseProblem setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("supplierName")
   public ProjectQhseProblem setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   @JsonProperty("subcontractClassId")
   public ProjectQhseProblem setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
      return this;
   }

   @JsonProperty("subcontractClassName")
   public ProjectQhseProblem setSubcontractClassName(final String subcontractClassName) {
      this.subcontractClassName = subcontractClassName;
      return this;
   }

   @JsonProperty("problemDate")
   public ProjectQhseProblem setProblemDate(final LocalDate problemDate) {
      this.problemDate = problemDate;
      return this;
   }

   @JsonProperty("promoterId")
   public ProjectQhseProblem setPromoterId(final Long promoterId) {
      this.promoterId = promoterId;
      return this;
   }

   @JsonProperty("promoterName")
   public ProjectQhseProblem setPromoterName(final String promoterName) {
      this.promoterName = promoterName;
      return this;
   }

   @JsonProperty("problemTypeId")
   public ProjectQhseProblem setProblemTypeId(final Long problemTypeId) {
      this.problemTypeId = problemTypeId;
      return this;
   }

   @JsonProperty("problemTypeName")
   public ProjectQhseProblem setProblemTypeName(final String problemTypeName) {
      this.problemTypeName = problemTypeName;
      return this;
   }

   @JsonProperty("beforeChangeImgs")
   public ProjectQhseProblem setBeforeChangeImgs(final String beforeChangeImgs) {
      this.beforeChangeImgs = beforeChangeImgs;
      return this;
   }

   @JsonProperty("afterChangeImgs")
   public ProjectQhseProblem setAfterChangeImgs(final String afterChangeImgs) {
      this.afterChangeImgs = afterChangeImgs;
      return this;
   }

   @JsonProperty("boolChangeStatus")
   public ProjectQhseProblem setBoolChangeStatus(final Boolean boolChangeStatus) {
      this.boolChangeStatus = boolChangeStatus;
      return this;
   }

   @JsonProperty("penalty")
   public ProjectQhseProblem setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
      return this;
   }

   @JsonProperty("boolDeductStatus")
   public ProjectQhseProblem setBoolDeductStatus(final Boolean boolDeductStatus) {
      this.boolDeductStatus = boolDeductStatus;
      return this;
   }

   @JsonProperty("remark")
   public ProjectQhseProblem setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("boolReply")
   public ProjectQhseProblem setBoolReply(final Boolean boolReply) {
      this.boolReply = boolReply;
      return this;
   }

   @JsonProperty("isInternal")
   public ProjectQhseProblem setIsInternal(final Boolean isInternal) {
      this.isInternal = isInternal;
      return this;
   }

   @JsonProperty("boolChangeStatusV2")
   public ProjectQhseProblem setBoolChangeStatusV2(final Integer boolChangeStatusV2) {
      this.boolChangeStatusV2 = boolChangeStatusV2;
      return this;
   }

   @JsonProperty("type")
   public ProjectQhseProblem setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("problemId")
   public ProjectQhseProblem setProblemId(final Long problemId) {
      this.problemId = problemId;
      return this;
   }

   @JsonProperty("userId")
   public ProjectQhseProblem setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectQhseProblem(id="
         + this.getId()
         + ", number="
         + this.getNumber()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", subcontractOrderId="
         + this.getSubcontractOrderId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", subcontractClassName="
         + this.getSubcontractClassName()
         + ", problemDate="
         + this.getProblemDate()
         + ", promoterId="
         + this.getPromoterId()
         + ", promoterName="
         + this.getPromoterName()
         + ", problemTypeId="
         + this.getProblemTypeId()
         + ", problemTypeName="
         + this.getProblemTypeName()
         + ", beforeChangeImgs="
         + this.getBeforeChangeImgs()
         + ", afterChangeImgs="
         + this.getAfterChangeImgs()
         + ", boolChangeStatus="
         + this.getBoolChangeStatus()
         + ", penalty="
         + this.getPenalty()
         + ", boolDeductStatus="
         + this.getBoolDeductStatus()
         + ", remark="
         + this.getRemark()
         + ", boolReply="
         + this.getBoolReply()
         + ", isInternal="
         + this.getIsInternal()
         + ", boolChangeStatusV2="
         + this.getBoolChangeStatusV2()
         + ", type="
         + this.getType()
         + ", problemId="
         + this.getProblemId()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectQhseProblem)) {
         return false;
      }

      ProjectQhseProblem other = (ProjectQhseProblem)o;
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
               Object this$subcontractOrderId = this.getSubcontractOrderId();
               Object other$subcontractOrderId = other.getSubcontractOrderId();
               if (this$subcontractOrderId == null ? other$subcontractOrderId == null : this$subcontractOrderId.equals(other$subcontractOrderId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$subcontractClassId = this.getSubcontractClassId();
                     Object other$subcontractClassId = other.getSubcontractClassId();
                     if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
                        Object this$promoterId = this.getPromoterId();
                        Object other$promoterId = other.getPromoterId();
                        if (this$promoterId == null ? other$promoterId == null : this$promoterId.equals(other$promoterId)) {
                           Object this$problemTypeId = this.getProblemTypeId();
                           Object other$problemTypeId = other.getProblemTypeId();
                           if (this$problemTypeId == null ? other$problemTypeId == null : this$problemTypeId.equals(other$problemTypeId)) {
                              Object this$boolChangeStatus = this.getBoolChangeStatus();
                              Object other$boolChangeStatus = other.getBoolChangeStatus();
                              if (this$boolChangeStatus == null ? other$boolChangeStatus == null : this$boolChangeStatus.equals(other$boolChangeStatus)) {
                                 Object this$boolDeductStatus = this.getBoolDeductStatus();
                                 Object other$boolDeductStatus = other.getBoolDeductStatus();
                                 if (this$boolDeductStatus == null ? other$boolDeductStatus == null : this$boolDeductStatus.equals(other$boolDeductStatus)) {
                                    Object this$boolReply = this.getBoolReply();
                                    Object other$boolReply = other.getBoolReply();
                                    if (this$boolReply == null ? other$boolReply == null : this$boolReply.equals(other$boolReply)) {
                                       Object this$isInternal = this.getIsInternal();
                                       Object other$isInternal = other.getIsInternal();
                                       if (this$isInternal == null ? other$isInternal == null : this$isInternal.equals(other$isInternal)) {
                                          Object this$boolChangeStatusV2 = this.getBoolChangeStatusV2();
                                          Object other$boolChangeStatusV2 = other.getBoolChangeStatusV2();
                                          if (this$boolChangeStatusV2 == null
                                             ? other$boolChangeStatusV2 == null
                                             : this$boolChangeStatusV2.equals(other$boolChangeStatusV2)) {
                                             Object this$type = this.getType();
                                             Object other$type = other.getType();
                                             if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                                Object this$problemId = this.getProblemId();
                                                Object other$problemId = other.getProblemId();
                                                if (this$problemId == null ? other$problemId == null : this$problemId.equals(other$problemId)) {
                                                   Object this$userId = this.getUserId();
                                                   Object other$userId = other.getUserId();
                                                   if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                      Object this$number = this.getNumber();
                                                      Object other$number = other.getNumber();
                                                      if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                                         Object this$supplierName = this.getSupplierName();
                                                         Object other$supplierName = other.getSupplierName();
                                                         if (this$supplierName == null
                                                            ? other$supplierName == null
                                                            : this$supplierName.equals(other$supplierName)) {
                                                            Object this$subcontractClassName = this.getSubcontractClassName();
                                                            Object other$subcontractClassName = other.getSubcontractClassName();
                                                            if (this$subcontractClassName == null
                                                               ? other$subcontractClassName == null
                                                               : this$subcontractClassName.equals(other$subcontractClassName)) {
                                                               Object this$problemDate = this.getProblemDate();
                                                               Object other$problemDate = other.getProblemDate();
                                                               if (this$problemDate == null
                                                                  ? other$problemDate == null
                                                                  : this$problemDate.equals(other$problemDate)) {
                                                                  Object this$promoterName = this.getPromoterName();
                                                                  Object other$promoterName = other.getPromoterName();
                                                                  if (this$promoterName == null
                                                                     ? other$promoterName == null
                                                                     : this$promoterName.equals(other$promoterName)) {
                                                                     Object this$problemTypeName = this.getProblemTypeName();
                                                                     Object other$problemTypeName = other.getProblemTypeName();
                                                                     if (this$problemTypeName == null
                                                                        ? other$problemTypeName == null
                                                                        : this$problemTypeName.equals(other$problemTypeName)) {
                                                                        Object this$beforeChangeImgs = this.getBeforeChangeImgs();
                                                                        Object other$beforeChangeImgs = other.getBeforeChangeImgs();
                                                                        if (this$beforeChangeImgs == null
                                                                           ? other$beforeChangeImgs == null
                                                                           : this$beforeChangeImgs.equals(other$beforeChangeImgs)) {
                                                                           Object this$afterChangeImgs = this.getAfterChangeImgs();
                                                                           Object other$afterChangeImgs = other.getAfterChangeImgs();
                                                                           if (this$afterChangeImgs == null
                                                                              ? other$afterChangeImgs == null
                                                                              : this$afterChangeImgs.equals(other$afterChangeImgs)) {
                                                                              Object this$penalty = this.getPenalty();
                                                                              Object other$penalty = other.getPenalty();
                                                                              if (this$penalty == null
                                                                                 ? other$penalty == null
                                                                                 : this$penalty.equals(other$penalty)) {
                                                                                 Object this$remark = this.getRemark();
                                                                                 Object other$remark = other.getRemark();
                                                                                 return this$remark == null
                                                                                    ? other$remark == null
                                                                                    : this$remark.equals(other$remark);
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof ProjectQhseProblem;
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
      Object $subcontractOrderId = this.getSubcontractOrderId();
      result = result * 59 + ($subcontractOrderId == null ? 43 : $subcontractOrderId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $promoterId = this.getPromoterId();
      result = result * 59 + ($promoterId == null ? 43 : $promoterId.hashCode());
      Object $problemTypeId = this.getProblemTypeId();
      result = result * 59 + ($problemTypeId == null ? 43 : $problemTypeId.hashCode());
      Object $boolChangeStatus = this.getBoolChangeStatus();
      result = result * 59 + ($boolChangeStatus == null ? 43 : $boolChangeStatus.hashCode());
      Object $boolDeductStatus = this.getBoolDeductStatus();
      result = result * 59 + ($boolDeductStatus == null ? 43 : $boolDeductStatus.hashCode());
      Object $boolReply = this.getBoolReply();
      result = result * 59 + ($boolReply == null ? 43 : $boolReply.hashCode());
      Object $isInternal = this.getIsInternal();
      result = result * 59 + ($isInternal == null ? 43 : $isInternal.hashCode());
      Object $boolChangeStatusV2 = this.getBoolChangeStatusV2();
      result = result * 59 + ($boolChangeStatusV2 == null ? 43 : $boolChangeStatusV2.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $problemId = this.getProblemId();
      result = result * 59 + ($problemId == null ? 43 : $problemId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $problemDate = this.getProblemDate();
      result = result * 59 + ($problemDate == null ? 43 : $problemDate.hashCode());
      Object $promoterName = this.getPromoterName();
      result = result * 59 + ($promoterName == null ? 43 : $promoterName.hashCode());
      Object $problemTypeName = this.getProblemTypeName();
      result = result * 59 + ($problemTypeName == null ? 43 : $problemTypeName.hashCode());
      Object $beforeChangeImgs = this.getBeforeChangeImgs();
      result = result * 59 + ($beforeChangeImgs == null ? 43 : $beforeChangeImgs.hashCode());
      Object $afterChangeImgs = this.getAfterChangeImgs();
      result = result * 59 + ($afterChangeImgs == null ? 43 : $afterChangeImgs.hashCode());
      Object $penalty = this.getPenalty();
      result = result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ProjectQhseProblemBuilder {
      private Long id;
      private String number;
      private Long projectId;
      private Long monomerId;
      private Long subcontractOrderId;
      private Long supplierId;
      private String supplierName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private LocalDate problemDate;
      private Long promoterId;
      private String promoterName;
      private Long problemTypeId;
      private String problemTypeName;
      private String beforeChangeImgs;
      private String afterChangeImgs;
      private Boolean boolChangeStatus;
      private BigDecimal penalty;
      private Boolean boolDeductStatus;
      private String remark;
      private Boolean boolReply;
      private Boolean isInternal;
      private Integer boolChangeStatusV2;
      private Integer type;
      private Long problemId;
      private Long userId;

      ProjectQhseProblemBuilder() {
      }

      @JsonProperty("id")
      public ProjectQhseProblem.ProjectQhseProblemBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("number")
      public ProjectQhseProblem.ProjectQhseProblemBuilder number(final String number) {
         this.number = number;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectQhseProblem.ProjectQhseProblemBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProjectQhseProblem.ProjectQhseProblemBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("subcontractOrderId")
      public ProjectQhseProblem.ProjectQhseProblemBuilder subcontractOrderId(final Long subcontractOrderId) {
         this.subcontractOrderId = subcontractOrderId;
         return this;
      }

      @JsonProperty("supplierId")
      public ProjectQhseProblem.ProjectQhseProblemBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("supplierName")
      public ProjectQhseProblem.ProjectQhseProblemBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      @JsonProperty("subcontractClassId")
      public ProjectQhseProblem.ProjectQhseProblemBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      @JsonProperty("subcontractClassName")
      public ProjectQhseProblem.ProjectQhseProblemBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      @JsonProperty("problemDate")
      public ProjectQhseProblem.ProjectQhseProblemBuilder problemDate(final LocalDate problemDate) {
         this.problemDate = problemDate;
         return this;
      }

      @JsonProperty("promoterId")
      public ProjectQhseProblem.ProjectQhseProblemBuilder promoterId(final Long promoterId) {
         this.promoterId = promoterId;
         return this;
      }

      @JsonProperty("promoterName")
      public ProjectQhseProblem.ProjectQhseProblemBuilder promoterName(final String promoterName) {
         this.promoterName = promoterName;
         return this;
      }

      @JsonProperty("problemTypeId")
      public ProjectQhseProblem.ProjectQhseProblemBuilder problemTypeId(final Long problemTypeId) {
         this.problemTypeId = problemTypeId;
         return this;
      }

      @JsonProperty("problemTypeName")
      public ProjectQhseProblem.ProjectQhseProblemBuilder problemTypeName(final String problemTypeName) {
         this.problemTypeName = problemTypeName;
         return this;
      }

      @JsonProperty("beforeChangeImgs")
      public ProjectQhseProblem.ProjectQhseProblemBuilder beforeChangeImgs(final String beforeChangeImgs) {
         this.beforeChangeImgs = beforeChangeImgs;
         return this;
      }

      @JsonProperty("afterChangeImgs")
      public ProjectQhseProblem.ProjectQhseProblemBuilder afterChangeImgs(final String afterChangeImgs) {
         this.afterChangeImgs = afterChangeImgs;
         return this;
      }

      @JsonProperty("boolChangeStatus")
      public ProjectQhseProblem.ProjectQhseProblemBuilder boolChangeStatus(final Boolean boolChangeStatus) {
         this.boolChangeStatus = boolChangeStatus;
         return this;
      }

      @JsonProperty("penalty")
      public ProjectQhseProblem.ProjectQhseProblemBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      @JsonProperty("boolDeductStatus")
      public ProjectQhseProblem.ProjectQhseProblemBuilder boolDeductStatus(final Boolean boolDeductStatus) {
         this.boolDeductStatus = boolDeductStatus;
         return this;
      }

      @JsonProperty("remark")
      public ProjectQhseProblem.ProjectQhseProblemBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("boolReply")
      public ProjectQhseProblem.ProjectQhseProblemBuilder boolReply(final Boolean boolReply) {
         this.boolReply = boolReply;
         return this;
      }

      @JsonProperty("isInternal")
      public ProjectQhseProblem.ProjectQhseProblemBuilder isInternal(final Boolean isInternal) {
         this.isInternal = isInternal;
         return this;
      }

      @JsonProperty("boolChangeStatusV2")
      public ProjectQhseProblem.ProjectQhseProblemBuilder boolChangeStatusV2(final Integer boolChangeStatusV2) {
         this.boolChangeStatusV2 = boolChangeStatusV2;
         return this;
      }

      @JsonProperty("type")
      public ProjectQhseProblem.ProjectQhseProblemBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("problemId")
      public ProjectQhseProblem.ProjectQhseProblemBuilder problemId(final Long problemId) {
         this.problemId = problemId;
         return this;
      }

      @JsonProperty("userId")
      public ProjectQhseProblem.ProjectQhseProblemBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectQhseProblem build() {
         return new ProjectQhseProblem(
            this.id,
            this.number,
            this.projectId,
            this.monomerId,
            this.subcontractOrderId,
            this.supplierId,
            this.supplierName,
            this.subcontractClassId,
            this.subcontractClassName,
            this.problemDate,
            this.promoterId,
            this.promoterName,
            this.problemTypeId,
            this.problemTypeName,
            this.beforeChangeImgs,
            this.afterChangeImgs,
            this.boolChangeStatus,
            this.penalty,
            this.boolDeductStatus,
            this.remark,
            this.boolReply,
            this.isInternal,
            this.boolChangeStatusV2,
            this.type,
            this.problemId,
            this.userId
         );
      }

      @Override
      public String toString() {
         return "ProjectQhseProblem.ProjectQhseProblemBuilder(id="
            + this.id
            + ", number="
            + this.number
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", subcontractOrderId="
            + this.subcontractOrderId
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", subcontractClassName="
            + this.subcontractClassName
            + ", problemDate="
            + this.problemDate
            + ", promoterId="
            + this.promoterId
            + ", promoterName="
            + this.promoterName
            + ", problemTypeId="
            + this.problemTypeId
            + ", problemTypeName="
            + this.problemTypeName
            + ", beforeChangeImgs="
            + this.beforeChangeImgs
            + ", afterChangeImgs="
            + this.afterChangeImgs
            + ", boolChangeStatus="
            + this.boolChangeStatus
            + ", penalty="
            + this.penalty
            + ", boolDeductStatus="
            + this.boolDeductStatus
            + ", remark="
            + this.remark
            + ", boolReply="
            + this.boolReply
            + ", isInternal="
            + this.isInternal
            + ", boolChangeStatusV2="
            + this.boolChangeStatusV2
            + ", type="
            + this.type
            + ", problemId="
            + this.problemId
            + ", userId="
            + this.userId
            + ")";
      }
   }
}

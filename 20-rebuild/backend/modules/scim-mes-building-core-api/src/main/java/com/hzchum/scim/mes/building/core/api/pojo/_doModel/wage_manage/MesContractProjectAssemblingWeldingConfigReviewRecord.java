package com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "MesContractProjectAssemblingWeldingConfigReviewRecord对象", description = "项目装焊配置工价修改审批记录表")
@Entity
@TableName("mes_contract_project_assembling_welding_config_review_record")
@Table(name = "mes_contract_project_assembling_welding_config_review_record")
@org.hibernate.annotations.Table(appliesTo = "mes_contract_project_assembling_welding_config_review_record", comment = "项目装焊配置工价修改审批记录表")
public class MesContractProjectAssemblingWeldingConfigReviewRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "contractProjectAssemblingWeldingConfigReviewId", value = "项目装焊配置工价修改审批ID", notes = "项目装焊配置工价修改审批ID")
   @TableField("contract_project_assembling_welding_config_review_id")
   @Column(name = "contract_project_assembling_welding_config_review_id", columnDefinition = "bigint(20)  COMMENT '项目装焊配置工价修改审批ID'", nullable = true)
   private Long contractProjectAssemblingWeldingConfigReviewId;
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   @TableField("contract_project_id")
   @Column(name = "contract_project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = true)
   private Long contractProjectId;
   @ApiModelProperty(name = "contractProjectSerialNumber", value = "项目编号", notes = "项目编号")
   @TableField("contract_project_serial_number")
   @Column(name = "contract_project_serial_number", columnDefinition = "varchar(255)  COMMENT '项目编号'", nullable = true)
   private String contractProjectSerialNumber;
   @ApiModelProperty(name = "contractProjectShortName", value = "项目简称", notes = "项目简称")
   @TableField("contract_project_short_name")
   @Column(name = "contract_project_short_name", columnDefinition = "varchar(255)  COMMENT '项目简称'", nullable = true)
   private String contractProjectShortName;
   @ApiModelProperty(name = "contractProjectAssemblingWeldingConfigId", value = "项目装焊配置ID", notes = "项目装焊配置ID")
   @TableField("contract_project_assembling_welding_config_id")
   @Column(name = "contract_project_assembling_welding_config_id", columnDefinition = "bigint(20)  COMMENT '项目装焊配置ID'", nullable = true)
   private Long contractProjectAssemblingWeldingConfigId;
   @ApiModelProperty(name = "contractProjectAssemblingWeldingConfigDetailId", value = "项目装焊配置详情ID", notes = "项目装焊配置详情ID")
   @TableField("contract_project_assembling_welding_config_detail_id")
   @Column(name = "contract_project_assembling_welding_config_detail_id", columnDefinition = "bigint(20)  COMMENT '项目装焊配置详情ID'", nullable = true)
   private Long contractProjectAssemblingWeldingConfigDetailId;
   @ApiModelProperty(name = "initiatorId", value = "发起人ID", notes = "发起人ID")
   @TableField("initiator_id")
   @Column(name = "initiator_id", columnDefinition = "bigint(20)  COMMENT '发起人ID'", nullable = true)
   private Long initiatorId;
   @ApiModelProperty(name = "initiatorName", value = "发起人名称", notes = "发起人名称")
   @TableField("initiator_name")
   @Column(name = "initiator_name", columnDefinition = "varchar(255)  COMMENT '发起人名称'", nullable = true)
   private String initiatorName;
   @ApiModelProperty(name = "initiationDate", value = "发起日期", notes = "发起日期")
   @TableField("initiation_date")
   @Column(name = "initiation_date", columnDefinition = "datetime  COMMENT '发起日期'", nullable = true)
   private LocalDateTime initiationDate;
   @ApiModelProperty(name = "reviewerId", value = "审批人ID", notes = "审批人ID")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id", columnDefinition = "bigint(20)  COMMENT '审批人ID'", nullable = true)
   private Long reviewerId;
   @ApiModelProperty(name = "reviewDate", value = "审批日期", notes = "审批日期")
   @TableField("review_date")
   @Column(name = "review_date", columnDefinition = "datetime  COMMENT '审批日期'", nullable = true)
   private LocalDateTime reviewDate;
   @ApiModelProperty(name = "reviewerName", value = "审批人名称", notes = "审批人名称")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name", columnDefinition = "varchar(255)  COMMENT '审批人名称'", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "process", value = "生产工序", notes = "生产工序")
   @TableField("process")
   @Column(name = "process", columnDefinition = "varchar(255)  COMMENT '生产工序'", nullable = true)
   private String process;
   @ApiModelProperty(name = "artifactClassificationName", value = "构件分类名称", notes = "构件分类名称")
   @TableField("artifact_classification_name")
   @Column(name = "artifact_classification_name", columnDefinition = "varchar(255)  COMMENT '构件分类名称'", nullable = true)
   private String artifactClassificationName;
   @ApiModelProperty(name = "pricingMannerName", value = "计价方式名称", notes = "计价方式名称")
   @TableField("pricing_manner_name")
   @Column(name = "pricing_manner_name", columnDefinition = "varchar(255)  COMMENT '计价方式名称'", nullable = true)
   private String pricingMannerName;
   @ApiModelProperty(name = "comparisonOperatorOneSymbol", value = "比较运算符1", notes = "比较运算符1")
   @TableField("comparison_operator_one_symbol")
   @Column(name = "comparison_operator_one_symbol", columnDefinition = "varchar(255)  COMMENT '比较运算符1'", nullable = true)
   private String comparisonOperatorOneSymbol;
   @ApiModelProperty(name = "numberOne", value = "数字1", notes = "数字1")
   @TableField("number_one")
   @Column(name = "number_one", columnDefinition = "int(11)  COMMENT '数字1'", nullable = true)
   private Integer numberOne;
   @ApiModelProperty(name = "comparisonOperatorTwoSymbol", value = "比较运算符2", notes = "比较运算符2")
   @TableField("comparison_operator_two_symbol")
   @Column(name = "comparison_operator_two_symbol", columnDefinition = "varchar(255)  COMMENT '比较运算符2'", nullable = true)
   private String comparisonOperatorTwoSymbol;
   @ApiModelProperty(name = "numberTwo", value = "数字2", notes = "数字2")
   @TableField("number_two")
   @Column(name = "number_two", columnDefinition = "int(11)  COMMENT '数字2'", nullable = true)
   private Integer numberTwo;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(255)  COMMENT '计量单位'", nullable = true)
   private String measureUnit;
   @ApiModelProperty(name = "oldOrganizationInsidePrice", value = "旧编制内单价(元)", notes = "旧编制内单价(元)")
   @TableField("old_organization_inside_price")
   @Column(name = "old_organization_inside_price", columnDefinition = "decimal(32,8)  COMMENT '旧编制内单价(元)'", nullable = true)
   private BigDecimal oldOrganizationInsidePrice;
   @ApiModelProperty(name = "oldOrganizationOutsidePrice", value = "旧编制外单价(元)", notes = "旧编制外单价(元)")
   @TableField("old_organization_outside_price")
   @Column(name = "old_organization_outside_price", columnDefinition = "decimal(32,8)  COMMENT '旧编制外单价(元)'", nullable = true)
   private BigDecimal oldOrganizationOutsidePrice;
   @ApiModelProperty(name = "newOrganizationInsidePrice", value = "新编制内单价(元)", notes = "新编制内单价(元)")
   @TableField("new_organization_inside_price")
   @Column(name = "new_organization_inside_price", columnDefinition = "decimal(32,8)  COMMENT '新编制内单价(元)'", nullable = true)
   private BigDecimal newOrganizationInsidePrice;
   @ApiModelProperty(name = "newOrganizationOutsidePrice", value = "新编制外单价(元)", notes = "新编制外单价(元)")
   @TableField("new_organization_outside_price")
   @Column(name = "new_organization_outside_price", columnDefinition = "decimal(32,8)  COMMENT '新编制外单价(元)'", nullable = true)
   private BigDecimal newOrganizationOutsidePrice;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(500)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "reviewStatus", value = "审批状态(AuditStatusEnum)", notes = "审批状态(AuditStatusEnum)")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int(11)  COMMENT '审批状态(AuditStatusEnum)'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewStatusName", value = "审批状态名称", notes = "审批状态名称")
   @TableField("review_status_name")
   @Column(name = "review_status_name", columnDefinition = "varchar(255)  COMMENT '审批状态名称'", nullable = true)
   private String reviewStatusName;
   @ApiModelProperty(name = "reviewRemark", value = "审批备注", notes = "审批备注")
   @TableField("review_remark")
   @Column(name = "review_remark", columnDefinition = "varchar(500)  COMMENT '审批备注'", nullable = true)
   private String reviewRemark;

   public static MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder builder() {
      return new MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder();
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord() {
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord(
      final Long id,
      final Long contractProjectAssemblingWeldingConfigReviewId,
      final Long contractProjectId,
      final String contractProjectSerialNumber,
      final String contractProjectShortName,
      final Long contractProjectAssemblingWeldingConfigId,
      final Long contractProjectAssemblingWeldingConfigDetailId,
      final Long initiatorId,
      final String initiatorName,
      final LocalDateTime initiationDate,
      final Long reviewerId,
      final LocalDateTime reviewDate,
      final String reviewerName,
      final String process,
      final String artifactClassificationName,
      final String pricingMannerName,
      final String comparisonOperatorOneSymbol,
      final Integer numberOne,
      final String comparisonOperatorTwoSymbol,
      final Integer numberTwo,
      final String measureUnit,
      final BigDecimal oldOrganizationInsidePrice,
      final BigDecimal oldOrganizationOutsidePrice,
      final BigDecimal newOrganizationInsidePrice,
      final BigDecimal newOrganizationOutsidePrice,
      final String remark,
      final Integer reviewStatus,
      final String reviewStatusName,
      final String reviewRemark
   ) {
      this.id = id;
      this.contractProjectAssemblingWeldingConfigReviewId = contractProjectAssemblingWeldingConfigReviewId;
      this.contractProjectId = contractProjectId;
      this.contractProjectSerialNumber = contractProjectSerialNumber;
      this.contractProjectShortName = contractProjectShortName;
      this.contractProjectAssemblingWeldingConfigId = contractProjectAssemblingWeldingConfigId;
      this.contractProjectAssemblingWeldingConfigDetailId = contractProjectAssemblingWeldingConfigDetailId;
      this.initiatorId = initiatorId;
      this.initiatorName = initiatorName;
      this.initiationDate = initiationDate;
      this.reviewerId = reviewerId;
      this.reviewDate = reviewDate;
      this.reviewerName = reviewerName;
      this.process = process;
      this.artifactClassificationName = artifactClassificationName;
      this.pricingMannerName = pricingMannerName;
      this.comparisonOperatorOneSymbol = comparisonOperatorOneSymbol;
      this.numberOne = numberOne;
      this.comparisonOperatorTwoSymbol = comparisonOperatorTwoSymbol;
      this.numberTwo = numberTwo;
      this.measureUnit = measureUnit;
      this.oldOrganizationInsidePrice = oldOrganizationInsidePrice;
      this.oldOrganizationOutsidePrice = oldOrganizationOutsidePrice;
      this.newOrganizationInsidePrice = newOrganizationInsidePrice;
      this.newOrganizationOutsidePrice = newOrganizationOutsidePrice;
      this.remark = remark;
      this.reviewStatus = reviewStatus;
      this.reviewStatusName = reviewStatusName;
      this.reviewRemark = reviewRemark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectAssemblingWeldingConfigReviewId() {
      return this.contractProjectAssemblingWeldingConfigReviewId;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public String getContractProjectSerialNumber() {
      return this.contractProjectSerialNumber;
   }

   public String getContractProjectShortName() {
      return this.contractProjectShortName;
   }

   public Long getContractProjectAssemblingWeldingConfigId() {
      return this.contractProjectAssemblingWeldingConfigId;
   }

   public Long getContractProjectAssemblingWeldingConfigDetailId() {
      return this.contractProjectAssemblingWeldingConfigDetailId;
   }

   public Long getInitiatorId() {
      return this.initiatorId;
   }

   public String getInitiatorName() {
      return this.initiatorName;
   }

   public LocalDateTime getInitiationDate() {
      return this.initiationDate;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public LocalDateTime getReviewDate() {
      return this.reviewDate;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public String getProcess() {
      return this.process;
   }

   public String getArtifactClassificationName() {
      return this.artifactClassificationName;
   }

   public String getPricingMannerName() {
      return this.pricingMannerName;
   }

   public String getComparisonOperatorOneSymbol() {
      return this.comparisonOperatorOneSymbol;
   }

   public Integer getNumberOne() {
      return this.numberOne;
   }

   public String getComparisonOperatorTwoSymbol() {
      return this.comparisonOperatorTwoSymbol;
   }

   public Integer getNumberTwo() {
      return this.numberTwo;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getOldOrganizationInsidePrice() {
      return this.oldOrganizationInsidePrice;
   }

   public BigDecimal getOldOrganizationOutsidePrice() {
      return this.oldOrganizationOutsidePrice;
   }

   public BigDecimal getNewOrganizationInsidePrice() {
      return this.newOrganizationInsidePrice;
   }

   public BigDecimal getNewOrganizationOutsidePrice() {
      return this.newOrganizationOutsidePrice;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getReviewStatusName() {
      return this.reviewStatusName;
   }

   public String getReviewRemark() {
      return this.reviewRemark;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setContractProjectAssemblingWeldingConfigReviewId(
      final Long contractProjectAssemblingWeldingConfigReviewId
   ) {
      this.contractProjectAssemblingWeldingConfigReviewId = contractProjectAssemblingWeldingConfigReviewId;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setContractProjectSerialNumber(final String contractProjectSerialNumber) {
      this.contractProjectSerialNumber = contractProjectSerialNumber;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setContractProjectShortName(final String contractProjectShortName) {
      this.contractProjectShortName = contractProjectShortName;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setContractProjectAssemblingWeldingConfigId(final Long contractProjectAssemblingWeldingConfigId) {
      this.contractProjectAssemblingWeldingConfigId = contractProjectAssemblingWeldingConfigId;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setContractProjectAssemblingWeldingConfigDetailId(
      final Long contractProjectAssemblingWeldingConfigDetailId
   ) {
      this.contractProjectAssemblingWeldingConfigDetailId = contractProjectAssemblingWeldingConfigDetailId;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setInitiatorId(final Long initiatorId) {
      this.initiatorId = initiatorId;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setInitiatorName(final String initiatorName) {
      this.initiatorName = initiatorName;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setInitiationDate(final LocalDateTime initiationDate) {
      this.initiationDate = initiationDate;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setReviewDate(final LocalDateTime reviewDate) {
      this.reviewDate = reviewDate;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setProcess(final String process) {
      this.process = process;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setArtifactClassificationName(final String artifactClassificationName) {
      this.artifactClassificationName = artifactClassificationName;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setPricingMannerName(final String pricingMannerName) {
      this.pricingMannerName = pricingMannerName;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setComparisonOperatorOneSymbol(final String comparisonOperatorOneSymbol) {
      this.comparisonOperatorOneSymbol = comparisonOperatorOneSymbol;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setNumberOne(final Integer numberOne) {
      this.numberOne = numberOne;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setComparisonOperatorTwoSymbol(final String comparisonOperatorTwoSymbol) {
      this.comparisonOperatorTwoSymbol = comparisonOperatorTwoSymbol;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setNumberTwo(final Integer numberTwo) {
      this.numberTwo = numberTwo;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setOldOrganizationInsidePrice(final BigDecimal oldOrganizationInsidePrice) {
      this.oldOrganizationInsidePrice = oldOrganizationInsidePrice;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setOldOrganizationOutsidePrice(final BigDecimal oldOrganizationOutsidePrice) {
      this.oldOrganizationOutsidePrice = oldOrganizationOutsidePrice;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setNewOrganizationInsidePrice(final BigDecimal newOrganizationInsidePrice) {
      this.newOrganizationInsidePrice = newOrganizationInsidePrice;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setNewOrganizationOutsidePrice(final BigDecimal newOrganizationOutsidePrice) {
      this.newOrganizationOutsidePrice = newOrganizationOutsidePrice;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setReviewStatusName(final String reviewStatusName) {
      this.reviewStatusName = reviewStatusName;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecord setReviewRemark(final String reviewRemark) {
      this.reviewRemark = reviewRemark;
      return this;
   }

   @Override
   public String toString() {
      return "MesContractProjectAssemblingWeldingConfigReviewRecord(id="
         + this.getId()
         + ", contractProjectAssemblingWeldingConfigReviewId="
         + this.getContractProjectAssemblingWeldingConfigReviewId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", contractProjectSerialNumber="
         + this.getContractProjectSerialNumber()
         + ", contractProjectShortName="
         + this.getContractProjectShortName()
         + ", contractProjectAssemblingWeldingConfigId="
         + this.getContractProjectAssemblingWeldingConfigId()
         + ", contractProjectAssemblingWeldingConfigDetailId="
         + this.getContractProjectAssemblingWeldingConfigDetailId()
         + ", initiatorId="
         + this.getInitiatorId()
         + ", initiatorName="
         + this.getInitiatorName()
         + ", initiationDate="
         + this.getInitiationDate()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewDate="
         + this.getReviewDate()
         + ", reviewerName="
         + this.getReviewerName()
         + ", process="
         + this.getProcess()
         + ", artifactClassificationName="
         + this.getArtifactClassificationName()
         + ", pricingMannerName="
         + this.getPricingMannerName()
         + ", comparisonOperatorOneSymbol="
         + this.getComparisonOperatorOneSymbol()
         + ", numberOne="
         + this.getNumberOne()
         + ", comparisonOperatorTwoSymbol="
         + this.getComparisonOperatorTwoSymbol()
         + ", numberTwo="
         + this.getNumberTwo()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", oldOrganizationInsidePrice="
         + this.getOldOrganizationInsidePrice()
         + ", oldOrganizationOutsidePrice="
         + this.getOldOrganizationOutsidePrice()
         + ", newOrganizationInsidePrice="
         + this.getNewOrganizationInsidePrice()
         + ", newOrganizationOutsidePrice="
         + this.getNewOrganizationOutsidePrice()
         + ", remark="
         + this.getRemark()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewStatusName="
         + this.getReviewStatusName()
         + ", reviewRemark="
         + this.getReviewRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectAssemblingWeldingConfigReviewRecord)) {
         return false;
      }

      MesContractProjectAssemblingWeldingConfigReviewRecord other = (MesContractProjectAssemblingWeldingConfigReviewRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectAssemblingWeldingConfigReviewId = this.getContractProjectAssemblingWeldingConfigReviewId();
         Object other$contractProjectAssemblingWeldingConfigReviewId = other.getContractProjectAssemblingWeldingConfigReviewId();
         if (this$contractProjectAssemblingWeldingConfigReviewId == null
            ? other$contractProjectAssemblingWeldingConfigReviewId == null
            : this$contractProjectAssemblingWeldingConfigReviewId.equals(other$contractProjectAssemblingWeldingConfigReviewId)) {
            Object this$contractProjectId = this.getContractProjectId();
            Object other$contractProjectId = other.getContractProjectId();
            if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
               Object this$contractProjectAssemblingWeldingConfigId = this.getContractProjectAssemblingWeldingConfigId();
               Object other$contractProjectAssemblingWeldingConfigId = other.getContractProjectAssemblingWeldingConfigId();
               if (this$contractProjectAssemblingWeldingConfigId == null
                  ? other$contractProjectAssemblingWeldingConfigId == null
                  : this$contractProjectAssemblingWeldingConfigId.equals(other$contractProjectAssemblingWeldingConfigId)) {
                  Object this$contractProjectAssemblingWeldingConfigDetailId = this.getContractProjectAssemblingWeldingConfigDetailId();
                  Object other$contractProjectAssemblingWeldingConfigDetailId = other.getContractProjectAssemblingWeldingConfigDetailId();
                  if (this$contractProjectAssemblingWeldingConfigDetailId == null
                     ? other$contractProjectAssemblingWeldingConfigDetailId == null
                     : this$contractProjectAssemblingWeldingConfigDetailId.equals(other$contractProjectAssemblingWeldingConfigDetailId)) {
                     Object this$initiatorId = this.getInitiatorId();
                     Object other$initiatorId = other.getInitiatorId();
                     if (this$initiatorId == null ? other$initiatorId == null : this$initiatorId.equals(other$initiatorId)) {
                        Object this$reviewerId = this.getReviewerId();
                        Object other$reviewerId = other.getReviewerId();
                        if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                           Object this$numberOne = this.getNumberOne();
                           Object other$numberOne = other.getNumberOne();
                           if (this$numberOne == null ? other$numberOne == null : this$numberOne.equals(other$numberOne)) {
                              Object this$numberTwo = this.getNumberTwo();
                              Object other$numberTwo = other.getNumberTwo();
                              if (this$numberTwo == null ? other$numberTwo == null : this$numberTwo.equals(other$numberTwo)) {
                                 Object this$reviewStatus = this.getReviewStatus();
                                 Object other$reviewStatus = other.getReviewStatus();
                                 if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                                    Object this$contractProjectSerialNumber = this.getContractProjectSerialNumber();
                                    Object other$contractProjectSerialNumber = other.getContractProjectSerialNumber();
                                    if (this$contractProjectSerialNumber == null
                                       ? other$contractProjectSerialNumber == null
                                       : this$contractProjectSerialNumber.equals(other$contractProjectSerialNumber)) {
                                       Object this$contractProjectShortName = this.getContractProjectShortName();
                                       Object other$contractProjectShortName = other.getContractProjectShortName();
                                       if (this$contractProjectShortName == null
                                          ? other$contractProjectShortName == null
                                          : this$contractProjectShortName.equals(other$contractProjectShortName)) {
                                          Object this$initiatorName = this.getInitiatorName();
                                          Object other$initiatorName = other.getInitiatorName();
                                          if (this$initiatorName == null ? other$initiatorName == null : this$initiatorName.equals(other$initiatorName)) {
                                             Object this$initiationDate = this.getInitiationDate();
                                             Object other$initiationDate = other.getInitiationDate();
                                             if (this$initiationDate == null ? other$initiationDate == null : this$initiationDate.equals(other$initiationDate)) {
                                                Object this$reviewDate = this.getReviewDate();
                                                Object other$reviewDate = other.getReviewDate();
                                                if (this$reviewDate == null ? other$reviewDate == null : this$reviewDate.equals(other$reviewDate)) {
                                                   Object this$reviewerName = this.getReviewerName();
                                                   Object other$reviewerName = other.getReviewerName();
                                                   if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                                      Object this$process = this.getProcess();
                                                      Object other$process = other.getProcess();
                                                      if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                                         Object this$artifactClassificationName = this.getArtifactClassificationName();
                                                         Object other$artifactClassificationName = other.getArtifactClassificationName();
                                                         if (this$artifactClassificationName == null
                                                            ? other$artifactClassificationName == null
                                                            : this$artifactClassificationName.equals(other$artifactClassificationName)) {
                                                            Object this$pricingMannerName = this.getPricingMannerName();
                                                            Object other$pricingMannerName = other.getPricingMannerName();
                                                            if (this$pricingMannerName == null
                                                               ? other$pricingMannerName == null
                                                               : this$pricingMannerName.equals(other$pricingMannerName)) {
                                                               Object this$comparisonOperatorOneSymbol = this.getComparisonOperatorOneSymbol();
                                                               Object other$comparisonOperatorOneSymbol = other.getComparisonOperatorOneSymbol();
                                                               if (this$comparisonOperatorOneSymbol == null
                                                                  ? other$comparisonOperatorOneSymbol == null
                                                                  : this$comparisonOperatorOneSymbol.equals(other$comparisonOperatorOneSymbol)) {
                                                                  Object this$comparisonOperatorTwoSymbol = this.getComparisonOperatorTwoSymbol();
                                                                  Object other$comparisonOperatorTwoSymbol = other.getComparisonOperatorTwoSymbol();
                                                                  if (this$comparisonOperatorTwoSymbol == null
                                                                     ? other$comparisonOperatorTwoSymbol == null
                                                                     : this$comparisonOperatorTwoSymbol.equals(other$comparisonOperatorTwoSymbol)) {
                                                                     Object this$measureUnit = this.getMeasureUnit();
                                                                     Object other$measureUnit = other.getMeasureUnit();
                                                                     if (this$measureUnit == null
                                                                        ? other$measureUnit == null
                                                                        : this$measureUnit.equals(other$measureUnit)) {
                                                                        Object this$oldOrganizationInsidePrice = this.getOldOrganizationInsidePrice();
                                                                        Object other$oldOrganizationInsidePrice = other.getOldOrganizationInsidePrice();
                                                                        if (this$oldOrganizationInsidePrice == null
                                                                           ? other$oldOrganizationInsidePrice == null
                                                                           : this$oldOrganizationInsidePrice.equals(other$oldOrganizationInsidePrice)) {
                                                                           Object this$oldOrganizationOutsidePrice = this.getOldOrganizationOutsidePrice();
                                                                           Object other$oldOrganizationOutsidePrice = other.getOldOrganizationOutsidePrice();
                                                                           if (this$oldOrganizationOutsidePrice == null
                                                                              ? other$oldOrganizationOutsidePrice == null
                                                                              : this$oldOrganizationOutsidePrice.equals(other$oldOrganizationOutsidePrice)) {
                                                                              Object this$newOrganizationInsidePrice = this.getNewOrganizationInsidePrice();
                                                                              Object other$newOrganizationInsidePrice = other.getNewOrganizationInsidePrice();
                                                                              if (this$newOrganizationInsidePrice == null
                                                                                 ? other$newOrganizationInsidePrice == null
                                                                                 : this$newOrganizationInsidePrice.equals(other$newOrganizationInsidePrice)) {
                                                                                 Object this$newOrganizationOutsidePrice = this.getNewOrganizationOutsidePrice();
                                                                                 Object other$newOrganizationOutsidePrice = other.getNewOrganizationOutsidePrice();
                                                                                 if (this$newOrganizationOutsidePrice == null
                                                                                    ? other$newOrganizationOutsidePrice == null
                                                                                    : this$newOrganizationOutsidePrice.equals(other$newOrganizationOutsidePrice)
                                                                                    )
                                                                                  {
                                                                                    Object this$remark = this.getRemark();
                                                                                    Object other$remark = other.getRemark();
                                                                                    if (this$remark == null
                                                                                       ? other$remark == null
                                                                                       : this$remark.equals(other$remark)) {
                                                                                       Object this$reviewStatusName = this.getReviewStatusName();
                                                                                       Object other$reviewStatusName = other.getReviewStatusName();
                                                                                       if (this$reviewStatusName == null
                                                                                          ? other$reviewStatusName == null
                                                                                          : this$reviewStatusName.equals(other$reviewStatusName)) {
                                                                                          Object this$reviewRemark = this.getReviewRemark();
                                                                                          Object other$reviewRemark = other.getReviewRemark();
                                                                                          return this$reviewRemark == null
                                                                                             ? other$reviewRemark == null
                                                                                             : this$reviewRemark.equals(other$reviewRemark);
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesContractProjectAssemblingWeldingConfigReviewRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectAssemblingWeldingConfigReviewId = this.getContractProjectAssemblingWeldingConfigReviewId();
      result = result * 59 + ($contractProjectAssemblingWeldingConfigReviewId == null ? 43 : $contractProjectAssemblingWeldingConfigReviewId.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $contractProjectAssemblingWeldingConfigId = this.getContractProjectAssemblingWeldingConfigId();
      result = result * 59 + ($contractProjectAssemblingWeldingConfigId == null ? 43 : $contractProjectAssemblingWeldingConfigId.hashCode());
      Object $contractProjectAssemblingWeldingConfigDetailId = this.getContractProjectAssemblingWeldingConfigDetailId();
      result = result * 59 + ($contractProjectAssemblingWeldingConfigDetailId == null ? 43 : $contractProjectAssemblingWeldingConfigDetailId.hashCode());
      Object $initiatorId = this.getInitiatorId();
      result = result * 59 + ($initiatorId == null ? 43 : $initiatorId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $numberOne = this.getNumberOne();
      result = result * 59 + ($numberOne == null ? 43 : $numberOne.hashCode());
      Object $numberTwo = this.getNumberTwo();
      result = result * 59 + ($numberTwo == null ? 43 : $numberTwo.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $contractProjectSerialNumber = this.getContractProjectSerialNumber();
      result = result * 59 + ($contractProjectSerialNumber == null ? 43 : $contractProjectSerialNumber.hashCode());
      Object $contractProjectShortName = this.getContractProjectShortName();
      result = result * 59 + ($contractProjectShortName == null ? 43 : $contractProjectShortName.hashCode());
      Object $initiatorName = this.getInitiatorName();
      result = result * 59 + ($initiatorName == null ? 43 : $initiatorName.hashCode());
      Object $initiationDate = this.getInitiationDate();
      result = result * 59 + ($initiationDate == null ? 43 : $initiationDate.hashCode());
      Object $reviewDate = this.getReviewDate();
      result = result * 59 + ($reviewDate == null ? 43 : $reviewDate.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $artifactClassificationName = this.getArtifactClassificationName();
      result = result * 59 + ($artifactClassificationName == null ? 43 : $artifactClassificationName.hashCode());
      Object $pricingMannerName = this.getPricingMannerName();
      result = result * 59 + ($pricingMannerName == null ? 43 : $pricingMannerName.hashCode());
      Object $comparisonOperatorOneSymbol = this.getComparisonOperatorOneSymbol();
      result = result * 59 + ($comparisonOperatorOneSymbol == null ? 43 : $comparisonOperatorOneSymbol.hashCode());
      Object $comparisonOperatorTwoSymbol = this.getComparisonOperatorTwoSymbol();
      result = result * 59 + ($comparisonOperatorTwoSymbol == null ? 43 : $comparisonOperatorTwoSymbol.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $oldOrganizationInsidePrice = this.getOldOrganizationInsidePrice();
      result = result * 59 + ($oldOrganizationInsidePrice == null ? 43 : $oldOrganizationInsidePrice.hashCode());
      Object $oldOrganizationOutsidePrice = this.getOldOrganizationOutsidePrice();
      result = result * 59 + ($oldOrganizationOutsidePrice == null ? 43 : $oldOrganizationOutsidePrice.hashCode());
      Object $newOrganizationInsidePrice = this.getNewOrganizationInsidePrice();
      result = result * 59 + ($newOrganizationInsidePrice == null ? 43 : $newOrganizationInsidePrice.hashCode());
      Object $newOrganizationOutsidePrice = this.getNewOrganizationOutsidePrice();
      result = result * 59 + ($newOrganizationOutsidePrice == null ? 43 : $newOrganizationOutsidePrice.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $reviewStatusName = this.getReviewStatusName();
      result = result * 59 + ($reviewStatusName == null ? 43 : $reviewStatusName.hashCode());
      Object $reviewRemark = this.getReviewRemark();
      return result * 59 + ($reviewRemark == null ? 43 : $reviewRemark.hashCode());
   }

   public static class MesContractProjectAssemblingWeldingConfigReviewRecordBuilder {
      private Long id;
      private Long contractProjectAssemblingWeldingConfigReviewId;
      private Long contractProjectId;
      private String contractProjectSerialNumber;
      private String contractProjectShortName;
      private Long contractProjectAssemblingWeldingConfigId;
      private Long contractProjectAssemblingWeldingConfigDetailId;
      private Long initiatorId;
      private String initiatorName;
      private LocalDateTime initiationDate;
      private Long reviewerId;
      private LocalDateTime reviewDate;
      private String reviewerName;
      private String process;
      private String artifactClassificationName;
      private String pricingMannerName;
      private String comparisonOperatorOneSymbol;
      private Integer numberOne;
      private String comparisonOperatorTwoSymbol;
      private Integer numberTwo;
      private String measureUnit;
      private BigDecimal oldOrganizationInsidePrice;
      private BigDecimal oldOrganizationOutsidePrice;
      private BigDecimal newOrganizationInsidePrice;
      private BigDecimal newOrganizationOutsidePrice;
      private String remark;
      private Integer reviewStatus;
      private String reviewStatusName;
      private String reviewRemark;

      MesContractProjectAssemblingWeldingConfigReviewRecordBuilder() {
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder contractProjectAssemblingWeldingConfigReviewId(
         final Long contractProjectAssemblingWeldingConfigReviewId
      ) {
         this.contractProjectAssemblingWeldingConfigReviewId = contractProjectAssemblingWeldingConfigReviewId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder contractProjectId(
         final Long contractProjectId
      ) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder contractProjectSerialNumber(
         final String contractProjectSerialNumber
      ) {
         this.contractProjectSerialNumber = contractProjectSerialNumber;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder contractProjectShortName(
         final String contractProjectShortName
      ) {
         this.contractProjectShortName = contractProjectShortName;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder contractProjectAssemblingWeldingConfigId(
         final Long contractProjectAssemblingWeldingConfigId
      ) {
         this.contractProjectAssemblingWeldingConfigId = contractProjectAssemblingWeldingConfigId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder contractProjectAssemblingWeldingConfigDetailId(
         final Long contractProjectAssemblingWeldingConfigDetailId
      ) {
         this.contractProjectAssemblingWeldingConfigDetailId = contractProjectAssemblingWeldingConfigDetailId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder initiatorId(
         final Long initiatorId
      ) {
         this.initiatorId = initiatorId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder initiatorName(
         final String initiatorName
      ) {
         this.initiatorName = initiatorName;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder initiationDate(
         final LocalDateTime initiationDate
      ) {
         this.initiationDate = initiationDate;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder reviewerId(
         final Long reviewerId
      ) {
         this.reviewerId = reviewerId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder reviewDate(
         final LocalDateTime reviewDate
      ) {
         this.reviewDate = reviewDate;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder reviewerName(
         final String reviewerName
      ) {
         this.reviewerName = reviewerName;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder process(final String process) {
         this.process = process;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder artifactClassificationName(
         final String artifactClassificationName
      ) {
         this.artifactClassificationName = artifactClassificationName;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder pricingMannerName(
         final String pricingMannerName
      ) {
         this.pricingMannerName = pricingMannerName;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder comparisonOperatorOneSymbol(
         final String comparisonOperatorOneSymbol
      ) {
         this.comparisonOperatorOneSymbol = comparisonOperatorOneSymbol;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder numberOne(
         final Integer numberOne
      ) {
         this.numberOne = numberOne;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder comparisonOperatorTwoSymbol(
         final String comparisonOperatorTwoSymbol
      ) {
         this.comparisonOperatorTwoSymbol = comparisonOperatorTwoSymbol;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder numberTwo(
         final Integer numberTwo
      ) {
         this.numberTwo = numberTwo;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder measureUnit(
         final String measureUnit
      ) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder oldOrganizationInsidePrice(
         final BigDecimal oldOrganizationInsidePrice
      ) {
         this.oldOrganizationInsidePrice = oldOrganizationInsidePrice;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder oldOrganizationOutsidePrice(
         final BigDecimal oldOrganizationOutsidePrice
      ) {
         this.oldOrganizationOutsidePrice = oldOrganizationOutsidePrice;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder newOrganizationInsidePrice(
         final BigDecimal newOrganizationInsidePrice
      ) {
         this.newOrganizationInsidePrice = newOrganizationInsidePrice;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder newOrganizationOutsidePrice(
         final BigDecimal newOrganizationOutsidePrice
      ) {
         this.newOrganizationOutsidePrice = newOrganizationOutsidePrice;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder reviewStatus(
         final Integer reviewStatus
      ) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder reviewStatusName(
         final String reviewStatusName
      ) {
         this.reviewStatusName = reviewStatusName;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder reviewRemark(
         final String reviewRemark
      ) {
         this.reviewRemark = reviewRemark;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecord build() {
         return new MesContractProjectAssemblingWeldingConfigReviewRecord(
            this.id,
            this.contractProjectAssemblingWeldingConfigReviewId,
            this.contractProjectId,
            this.contractProjectSerialNumber,
            this.contractProjectShortName,
            this.contractProjectAssemblingWeldingConfigId,
            this.contractProjectAssemblingWeldingConfigDetailId,
            this.initiatorId,
            this.initiatorName,
            this.initiationDate,
            this.reviewerId,
            this.reviewDate,
            this.reviewerName,
            this.process,
            this.artifactClassificationName,
            this.pricingMannerName,
            this.comparisonOperatorOneSymbol,
            this.numberOne,
            this.comparisonOperatorTwoSymbol,
            this.numberTwo,
            this.measureUnit,
            this.oldOrganizationInsidePrice,
            this.oldOrganizationOutsidePrice,
            this.newOrganizationInsidePrice,
            this.newOrganizationOutsidePrice,
            this.remark,
            this.reviewStatus,
            this.reviewStatusName,
            this.reviewRemark
         );
      }

      @Override
      public String toString() {
         return "MesContractProjectAssemblingWeldingConfigReviewRecord.MesContractProjectAssemblingWeldingConfigReviewRecordBuilder(id="
            + this.id
            + ", contractProjectAssemblingWeldingConfigReviewId="
            + this.contractProjectAssemblingWeldingConfigReviewId
            + ", contractProjectId="
            + this.contractProjectId
            + ", contractProjectSerialNumber="
            + this.contractProjectSerialNumber
            + ", contractProjectShortName="
            + this.contractProjectShortName
            + ", contractProjectAssemblingWeldingConfigId="
            + this.contractProjectAssemblingWeldingConfigId
            + ", contractProjectAssemblingWeldingConfigDetailId="
            + this.contractProjectAssemblingWeldingConfigDetailId
            + ", initiatorId="
            + this.initiatorId
            + ", initiatorName="
            + this.initiatorName
            + ", initiationDate="
            + this.initiationDate
            + ", reviewerId="
            + this.reviewerId
            + ", reviewDate="
            + this.reviewDate
            + ", reviewerName="
            + this.reviewerName
            + ", process="
            + this.process
            + ", artifactClassificationName="
            + this.artifactClassificationName
            + ", pricingMannerName="
            + this.pricingMannerName
            + ", comparisonOperatorOneSymbol="
            + this.comparisonOperatorOneSymbol
            + ", numberOne="
            + this.numberOne
            + ", comparisonOperatorTwoSymbol="
            + this.comparisonOperatorTwoSymbol
            + ", numberTwo="
            + this.numberTwo
            + ", measureUnit="
            + this.measureUnit
            + ", oldOrganizationInsidePrice="
            + this.oldOrganizationInsidePrice
            + ", oldOrganizationOutsidePrice="
            + this.oldOrganizationOutsidePrice
            + ", newOrganizationInsidePrice="
            + this.newOrganizationInsidePrice
            + ", newOrganizationOutsidePrice="
            + this.newOrganizationOutsidePrice
            + ", remark="
            + this.remark
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewStatusName="
            + this.reviewStatusName
            + ", reviewRemark="
            + this.reviewRemark
            + ")";
      }
   }
}

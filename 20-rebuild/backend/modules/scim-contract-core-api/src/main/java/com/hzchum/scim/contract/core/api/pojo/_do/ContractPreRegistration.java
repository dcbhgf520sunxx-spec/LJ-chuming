package com.hzchum.scim.contract.core.api.pojo._do;

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

@ApiModel(value = "ContractPreRegistration对象", description = "合同预登记")
@Entity
@TableName("contract_pre_registration")
@Table(name = "contract_pre_registration")
public class ContractPreRegistration extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "preRegistrationNo", value = "合同预登记编号", notes = "合同预登记编号")
   @JsonProperty("preRegistrationNo")
   @JSONField(name = "preRegistrationNo")
   @TableField("pre_registration_no")
   @Column(name = "pre_registration_no", columnDefinition = "varchar(255) comment '合同预登记编号'")
   private String preRegistrationNo;
   @ApiModelProperty(name = "contractNumber", value = "合同目录编号", notes = "合同目录编号")
   @JsonProperty("contractNumber")
   @JSONField(name = "contractNumber")
   @TableField("contract_number")
   @Column(name = "contract_number", columnDefinition = "varchar(255) comment '合同目录编号'")
   private String contractNumber;
   @ApiModelProperty(name = "partyType", value = "甲方类别", notes = "甲方类别")
   @JsonProperty("partyType")
   @JSONField(name = "partyType")
   @TableField("party_type")
   @Column(name = "party_type", columnDefinition = "bigint(20) comment '甲方类别'")
   private Long partyType;
   @ApiModelProperty(name = "partyName", value = "甲方或业主名称", notes = "甲方或业主名称")
   @JsonProperty("partyName")
   @JSONField(name = "partyName")
   @TableField("party_name")
   @Column(name = "party_name", columnDefinition = "varchar(255) comment '甲方或业主名称'")
   private String partyName;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   @TableField("project_name")
   @Column(name = "project_name", columnDefinition = "varchar(255) comment '项目名称'")
   private String projectName;
   @ApiModelProperty(name = "contractAmount", value = "合同金额（元）", notes = "合同金额（元）")
   @JsonProperty("contractAmount")
   @JSONField(name = "contractAmount")
   @TableField("contract_amount")
   @Column(name = "contract_amount", columnDefinition = "decimal(19,2) comment '合同金额（元）'")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "boolBidWinningNotice", value = "是否存在中标通知书", notes = "是否存在中标通知书")
   @JsonProperty("boolBidWinningNotice")
   @JSONField(name = "boolBidWinningNotice")
   @TableField("bool_bid_winning_notice")
   @Column(name = "bool_bid_winning_notice", nullable = false, columnDefinition = "tinyint(1) comment '是否存在中标通知书'")
   private Boolean boolBidWinningNotice;
   @ApiModelProperty(name = "structureType", value = "结构类型", notes = "结构类型")
   @JsonProperty("structureType")
   @JSONField(name = "structureType")
   @TableField("structure_type")
   @Column(name = "structure_type", columnDefinition = "bigint(20) comment '结构类型'")
   private Long structureType;
   @ApiModelProperty(name = "contractualNature", value = "承包性质", notes = "承包性质")
   @JsonProperty("contractualNature")
   @JSONField(name = "contractualNature")
   @TableField("contractual_nature")
   @Column(name = "contractual_nature", columnDefinition = "bigint(20) comment '承包性质'")
   private Long contractualNature;
   @ApiModelProperty(name = "signerId", value = "签订人ID", notes = "签订人ID")
   @JsonProperty("signerId")
   @JSONField(name = "signerId")
   @TableField("signer_id")
   @Column(name = "signer_id", columnDefinition = "bigint comment '签订人ID'")
   private Long signerId;
   @ApiModelProperty(name = "signerName", value = "签订人姓名", notes = "签订人姓名")
   @JsonProperty("signerName")
   @JSONField(name = "signerName")
   @TableField("signer_name")
   @Column(name = "signer_name", columnDefinition = "varchar(255) comment '签订人姓名'")
   private String signerName;
   @ApiModelProperty(name = "locationId", value = "区域Id", notes = "区域Id")
   @JsonProperty("locationId")
   @JSONField(name = "locationId")
   @TableField("location_id")
   @Column(name = "location_id", columnDefinition = "bigint comment '区域Id'")
   private Long locationId;
   @ApiModelProperty(name = "countryId", value = "国家ID", notes = "国家ID")
   @JsonProperty("countryId")
   @JSONField(name = "countryId")
   @TableField("country_id")
   @Column(name = "country_id", columnDefinition = "bigint comment '国家ID'")
   private Long countryId;
   @ApiModelProperty(name = "provinceId", value = "省份ID", notes = "省份ID")
   @JsonProperty("provinceId")
   @JSONField(name = "provinceId")
   @TableField("province_id")
   @Column(name = "province_id", columnDefinition = "bigint comment '省份ID'")
   private Long provinceId;
   @ApiModelProperty(name = "cityId", value = "城市ID", notes = "城市ID")
   @JsonProperty("cityId")
   @JSONField(name = "cityId")
   @TableField("city_id")
   @Column(name = "city_id", columnDefinition = "bigint comment '城市ID'")
   private Long cityId;
   @ApiModelProperty(name = "regionId", value = "区ID", notes = "区ID")
   @JsonProperty("regionId")
   @JSONField(name = "regionId")
   @TableField("region_id")
   @Column(name = "region_id", columnDefinition = "bigint comment '区ID'")
   private Long regionId;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   @JsonProperty("address")
   @JSONField(name = "address")
   @TableField("address")
   @Column(name = "address", columnDefinition = "varchar(1000) comment '详细地址'")
   private String address;
   @ApiModelProperty(name = "structureArea", value = "建筑面积（平方米）", notes = "建筑面积（平方米）")
   @JsonProperty("structureArea")
   @JSONField(name = "structureArea")
   @TableField("structure_area")
   @Column(name = "structure_area", columnDefinition = "decimal(32,8) comment '建筑面积（平方米）'")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "infoSource", value = "信息来源", notes = "信息来源")
   @JsonProperty("infoSource")
   @JSONField(name = "infoSource")
   @TableField("info_source")
   @Column(name = "info_source", columnDefinition = "bigint comment '信息来源'")
   private Integer infoSource;
   @ApiModelProperty(name = "boolQuote", value = "是否引用", notes = "是否引用")
   @JsonProperty("boolQuote")
   @JSONField(name = "boolQuote")
   @TableField("bool_quote")
   @Column(name = "bool_quote", nullable = false, columnDefinition = "tinyint(1) DEFAULT 0 comment '是否引用'")
   private Boolean boolQuote;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint comment '申请人ID'")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255) comment '申请人名称'")
   private String applicantName;
   @ApiModelProperty(name = "applicantDeptId", value = "申请人部门Id", notes = "申请人部门Id")
   @JsonProperty("applicantDeptId")
   @JSONField(name = "applicantDeptId")
   @TableField("applicant_dept_id")
   @Column(name = "applicant_dept_id", columnDefinition = "bigint comment '申请人部门Id'")
   private Long applicantDeptId;
   @ApiModelProperty(name = "applicationDate", value = "申请时间", notes = "申请时间")
   @JsonProperty("applicationDate")
   @JSONField(name = "applicationDate")
   @TableField("application_date")
   @Column(name = "application_date", columnDefinition = "datetime comment '申请时间'")
   private LocalDateTime applicationDate;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 [1未审核, 2审核通过, 4退回]", notes = "审核状态 [1未审核, 2审核通过, 4退回]")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态 [1未审核, 2审核通过, 4退回]'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "reviewPassTime", value = "审批通过时间", notes = "审批通过时间")
   @JsonProperty("reviewPassTime")
   @JSONField(name = "reviewPassTime")
   @TableField("review_pass_time")
   @Column(name = "review_pass_time", columnDefinition = "datetime comment '审批通过时间'")
   private LocalDateTime reviewPassTime;
   @ApiModelProperty(name = "initDataId", value = "初始数据ID", notes = "初始数据ID")
   @JsonProperty("initDataId")
   @JSONField(name = "initDataId")
   @TableField("init_data_id")
   @Column(name = "init_data_id", columnDefinition = "bigint comment '初始数据ID'")
   private Long initDataId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1000) comment '备注'")
   private String remark;

   public static ContractPreRegistration.ContractPreRegistrationBuilder builder() {
      return new ContractPreRegistration.ContractPreRegistrationBuilder();
   }

   public ContractPreRegistration() {
   }

   public ContractPreRegistration(
      final Long id,
      final String preRegistrationNo,
      final String contractNumber,
      final Long partyType,
      final String partyName,
      final String projectName,
      final BigDecimal contractAmount,
      final Boolean boolBidWinningNotice,
      final Long structureType,
      final Long contractualNature,
      final Long signerId,
      final String signerName,
      final Long locationId,
      final Long countryId,
      final Long provinceId,
      final Long cityId,
      final Long regionId,
      final String address,
      final BigDecimal structureArea,
      final Integer infoSource,
      final Boolean boolQuote,
      final Long applicantId,
      final String applicantName,
      final Long applicantDeptId,
      final LocalDateTime applicationDate,
      final Integer reviewStatus,
      final Long approveRecordId,
      final LocalDateTime reviewPassTime,
      final Long initDataId,
      final String remark
   ) {
      this.id = id;
      this.preRegistrationNo = preRegistrationNo;
      this.contractNumber = contractNumber;
      this.partyType = partyType;
      this.partyName = partyName;
      this.projectName = projectName;
      this.contractAmount = contractAmount;
      this.boolBidWinningNotice = boolBidWinningNotice;
      this.structureType = structureType;
      this.contractualNature = contractualNature;
      this.signerId = signerId;
      this.signerName = signerName;
      this.locationId = locationId;
      this.countryId = countryId;
      this.provinceId = provinceId;
      this.cityId = cityId;
      this.regionId = regionId;
      this.address = address;
      this.structureArea = structureArea;
      this.infoSource = infoSource;
      this.boolQuote = boolQuote;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.applicantDeptId = applicantDeptId;
      this.applicationDate = applicationDate;
      this.reviewStatus = reviewStatus;
      this.approveRecordId = approveRecordId;
      this.reviewPassTime = reviewPassTime;
      this.initDataId = initDataId;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getPreRegistrationNo() {
      return this.preRegistrationNo;
   }

   public String getContractNumber() {
      return this.contractNumber;
   }

   public Long getPartyType() {
      return this.partyType;
   }

   public String getPartyName() {
      return this.partyName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public Boolean getBoolBidWinningNotice() {
      return this.boolBidWinningNotice;
   }

   public Long getStructureType() {
      return this.structureType;
   }

   public Long getContractualNature() {
      return this.contractualNature;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public Long getLocationId() {
      return this.locationId;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getAddress() {
      return this.address;
   }

   public BigDecimal getStructureArea() {
      return this.structureArea;
   }

   public Integer getInfoSource() {
      return this.infoSource;
   }

   public Boolean getBoolQuote() {
      return this.boolQuote;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getApplicantDeptId() {
      return this.applicantDeptId;
   }

   public LocalDateTime getApplicationDate() {
      return this.applicationDate;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public Long getInitDataId() {
      return this.initDataId;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public ContractPreRegistration setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("preRegistrationNo")
   public ContractPreRegistration setPreRegistrationNo(final String preRegistrationNo) {
      this.preRegistrationNo = preRegistrationNo;
      return this;
   }

   @JsonProperty("contractNumber")
   public ContractPreRegistration setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
      return this;
   }

   @JsonProperty("partyType")
   public ContractPreRegistration setPartyType(final Long partyType) {
      this.partyType = partyType;
      return this;
   }

   @JsonProperty("partyName")
   public ContractPreRegistration setPartyName(final String partyName) {
      this.partyName = partyName;
      return this;
   }

   @JsonProperty("projectName")
   public ContractPreRegistration setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("contractAmount")
   public ContractPreRegistration setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   @JsonProperty("boolBidWinningNotice")
   public ContractPreRegistration setBoolBidWinningNotice(final Boolean boolBidWinningNotice) {
      this.boolBidWinningNotice = boolBidWinningNotice;
      return this;
   }

   @JsonProperty("structureType")
   public ContractPreRegistration setStructureType(final Long structureType) {
      this.structureType = structureType;
      return this;
   }

   @JsonProperty("contractualNature")
   public ContractPreRegistration setContractualNature(final Long contractualNature) {
      this.contractualNature = contractualNature;
      return this;
   }

   @JsonProperty("signerId")
   public ContractPreRegistration setSignerId(final Long signerId) {
      this.signerId = signerId;
      return this;
   }

   @JsonProperty("signerName")
   public ContractPreRegistration setSignerName(final String signerName) {
      this.signerName = signerName;
      return this;
   }

   @JsonProperty("locationId")
   public ContractPreRegistration setLocationId(final Long locationId) {
      this.locationId = locationId;
      return this;
   }

   @JsonProperty("countryId")
   public ContractPreRegistration setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   @JsonProperty("provinceId")
   public ContractPreRegistration setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   @JsonProperty("cityId")
   public ContractPreRegistration setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   @JsonProperty("regionId")
   public ContractPreRegistration setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   @JsonProperty("address")
   public ContractPreRegistration setAddress(final String address) {
      this.address = address;
      return this;
   }

   @JsonProperty("structureArea")
   public ContractPreRegistration setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
      return this;
   }

   @JsonProperty("infoSource")
   public ContractPreRegistration setInfoSource(final Integer infoSource) {
      this.infoSource = infoSource;
      return this;
   }

   @JsonProperty("boolQuote")
   public ContractPreRegistration setBoolQuote(final Boolean boolQuote) {
      this.boolQuote = boolQuote;
      return this;
   }

   @JsonProperty("applicantId")
   public ContractPreRegistration setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public ContractPreRegistration setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("applicantDeptId")
   public ContractPreRegistration setApplicantDeptId(final Long applicantDeptId) {
      this.applicantDeptId = applicantDeptId;
      return this;
   }

   @JsonProperty("applicationDate")
   public ContractPreRegistration setApplicationDate(final LocalDateTime applicationDate) {
      this.applicationDate = applicationDate;
      return this;
   }

   @JsonProperty("reviewStatus")
   public ContractPreRegistration setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("approveRecordId")
   public ContractPreRegistration setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @JsonProperty("reviewPassTime")
   public ContractPreRegistration setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
      return this;
   }

   @JsonProperty("initDataId")
   public ContractPreRegistration setInitDataId(final Long initDataId) {
      this.initDataId = initDataId;
      return this;
   }

   @JsonProperty("remark")
   public ContractPreRegistration setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "ContractPreRegistration(id="
         + this.getId()
         + ", preRegistrationNo="
         + this.getPreRegistrationNo()
         + ", contractNumber="
         + this.getContractNumber()
         + ", partyType="
         + this.getPartyType()
         + ", partyName="
         + this.getPartyName()
         + ", projectName="
         + this.getProjectName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", boolBidWinningNotice="
         + this.getBoolBidWinningNotice()
         + ", structureType="
         + this.getStructureType()
         + ", contractualNature="
         + this.getContractualNature()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", locationId="
         + this.getLocationId()
         + ", countryId="
         + this.getCountryId()
         + ", provinceId="
         + this.getProvinceId()
         + ", cityId="
         + this.getCityId()
         + ", regionId="
         + this.getRegionId()
         + ", address="
         + this.getAddress()
         + ", structureArea="
         + this.getStructureArea()
         + ", infoSource="
         + this.getInfoSource()
         + ", boolQuote="
         + this.getBoolQuote()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicantDeptId="
         + this.getApplicantDeptId()
         + ", applicationDate="
         + this.getApplicationDate()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", initDataId="
         + this.getInitDataId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractPreRegistration)) {
         return false;
      }

      ContractPreRegistration other = (ContractPreRegistration)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$partyType = this.getPartyType();
         Object other$partyType = other.getPartyType();
         if (this$partyType == null ? other$partyType == null : this$partyType.equals(other$partyType)) {
            Object this$boolBidWinningNotice = this.getBoolBidWinningNotice();
            Object other$boolBidWinningNotice = other.getBoolBidWinningNotice();
            if (this$boolBidWinningNotice == null ? other$boolBidWinningNotice == null : this$boolBidWinningNotice.equals(other$boolBidWinningNotice)) {
               Object this$structureType = this.getStructureType();
               Object other$structureType = other.getStructureType();
               if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                  Object this$contractualNature = this.getContractualNature();
                  Object other$contractualNature = other.getContractualNature();
                  if (this$contractualNature == null ? other$contractualNature == null : this$contractualNature.equals(other$contractualNature)) {
                     Object this$signerId = this.getSignerId();
                     Object other$signerId = other.getSignerId();
                     if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
                        Object this$locationId = this.getLocationId();
                        Object other$locationId = other.getLocationId();
                        if (this$locationId == null ? other$locationId == null : this$locationId.equals(other$locationId)) {
                           Object this$countryId = this.getCountryId();
                           Object other$countryId = other.getCountryId();
                           if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
                              Object this$provinceId = this.getProvinceId();
                              Object other$provinceId = other.getProvinceId();
                              if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
                                 Object this$cityId = this.getCityId();
                                 Object other$cityId = other.getCityId();
                                 if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
                                    Object this$regionId = this.getRegionId();
                                    Object other$regionId = other.getRegionId();
                                    if (this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId)) {
                                       Object this$infoSource = this.getInfoSource();
                                       Object other$infoSource = other.getInfoSource();
                                       if (this$infoSource == null ? other$infoSource == null : this$infoSource.equals(other$infoSource)) {
                                          Object this$boolQuote = this.getBoolQuote();
                                          Object other$boolQuote = other.getBoolQuote();
                                          if (this$boolQuote == null ? other$boolQuote == null : this$boolQuote.equals(other$boolQuote)) {
                                             Object this$applicantId = this.getApplicantId();
                                             Object other$applicantId = other.getApplicantId();
                                             if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                                                Object this$applicantDeptId = this.getApplicantDeptId();
                                                Object other$applicantDeptId = other.getApplicantDeptId();
                                                if (this$applicantDeptId == null
                                                   ? other$applicantDeptId == null
                                                   : this$applicantDeptId.equals(other$applicantDeptId)) {
                                                   Object this$reviewStatus = this.getReviewStatus();
                                                   Object other$reviewStatus = other.getReviewStatus();
                                                   if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                                                      Object this$approveRecordId = this.getApproveRecordId();
                                                      Object other$approveRecordId = other.getApproveRecordId();
                                                      if (this$approveRecordId == null
                                                         ? other$approveRecordId == null
                                                         : this$approveRecordId.equals(other$approveRecordId)) {
                                                         Object this$initDataId = this.getInitDataId();
                                                         Object other$initDataId = other.getInitDataId();
                                                         if (this$initDataId == null ? other$initDataId == null : this$initDataId.equals(other$initDataId)) {
                                                            Object this$preRegistrationNo = this.getPreRegistrationNo();
                                                            Object other$preRegistrationNo = other.getPreRegistrationNo();
                                                            if (this$preRegistrationNo == null
                                                               ? other$preRegistrationNo == null
                                                               : this$preRegistrationNo.equals(other$preRegistrationNo)) {
                                                               Object this$contractNumber = this.getContractNumber();
                                                               Object other$contractNumber = other.getContractNumber();
                                                               if (this$contractNumber == null
                                                                  ? other$contractNumber == null
                                                                  : this$contractNumber.equals(other$contractNumber)) {
                                                                  Object this$partyName = this.getPartyName();
                                                                  Object other$partyName = other.getPartyName();
                                                                  if (this$partyName == null ? other$partyName == null : this$partyName.equals(other$partyName)
                                                                     )
                                                                   {
                                                                     Object this$projectName = this.getProjectName();
                                                                     Object other$projectName = other.getProjectName();
                                                                     if (this$projectName == null
                                                                        ? other$projectName == null
                                                                        : this$projectName.equals(other$projectName)) {
                                                                        Object this$contractAmount = this.getContractAmount();
                                                                        Object other$contractAmount = other.getContractAmount();
                                                                        if (this$contractAmount == null
                                                                           ? other$contractAmount == null
                                                                           : this$contractAmount.equals(other$contractAmount)) {
                                                                           Object this$signerName = this.getSignerName();
                                                                           Object other$signerName = other.getSignerName();
                                                                           if (this$signerName == null
                                                                              ? other$signerName == null
                                                                              : this$signerName.equals(other$signerName)) {
                                                                              Object this$address = this.getAddress();
                                                                              Object other$address = other.getAddress();
                                                                              if (this$address == null
                                                                                 ? other$address == null
                                                                                 : this$address.equals(other$address)) {
                                                                                 Object this$structureArea = this.getStructureArea();
                                                                                 Object other$structureArea = other.getStructureArea();
                                                                                 if (this$structureArea == null
                                                                                    ? other$structureArea == null
                                                                                    : this$structureArea.equals(other$structureArea)) {
                                                                                    Object this$applicantName = this.getApplicantName();
                                                                                    Object other$applicantName = other.getApplicantName();
                                                                                    if (this$applicantName == null
                                                                                       ? other$applicantName == null
                                                                                       : this$applicantName.equals(other$applicantName)) {
                                                                                       Object this$applicationDate = this.getApplicationDate();
                                                                                       Object other$applicationDate = other.getApplicationDate();
                                                                                       if (this$applicationDate == null
                                                                                          ? other$applicationDate == null
                                                                                          : this$applicationDate.equals(other$applicationDate)) {
                                                                                          Object this$reviewPassTime = this.getReviewPassTime();
                                                                                          Object other$reviewPassTime = other.getReviewPassTime();
                                                                                          if (this$reviewPassTime == null
                                                                                             ? other$reviewPassTime == null
                                                                                             : this$reviewPassTime.equals(other$reviewPassTime)) {
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
               } else {
                  return false;
               }
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
      return other instanceof ContractPreRegistration;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partyType = this.getPartyType();
      result = result * 59 + ($partyType == null ? 43 : $partyType.hashCode());
      Object $boolBidWinningNotice = this.getBoolBidWinningNotice();
      result = result * 59 + ($boolBidWinningNotice == null ? 43 : $boolBidWinningNotice.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $contractualNature = this.getContractualNature();
      result = result * 59 + ($contractualNature == null ? 43 : $contractualNature.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $locationId = this.getLocationId();
      result = result * 59 + ($locationId == null ? 43 : $locationId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $boolQuote = this.getBoolQuote();
      result = result * 59 + ($boolQuote == null ? 43 : $boolQuote.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $applicantDeptId = this.getApplicantDeptId();
      result = result * 59 + ($applicantDeptId == null ? 43 : $applicantDeptId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $initDataId = this.getInitDataId();
      result = result * 59 + ($initDataId == null ? 43 : $initDataId.hashCode());
      Object $preRegistrationNo = this.getPreRegistrationNo();
      result = result * 59 + ($preRegistrationNo == null ? 43 : $preRegistrationNo.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $partyName = this.getPartyName();
      result = result * 59 + ($partyName == null ? 43 : $partyName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $applicationDate = this.getApplicationDate();
      result = result * 59 + ($applicationDate == null ? 43 : $applicationDate.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ContractPreRegistrationBuilder {
      private Long id;
      private String preRegistrationNo;
      private String contractNumber;
      private Long partyType;
      private String partyName;
      private String projectName;
      private BigDecimal contractAmount;
      private Boolean boolBidWinningNotice;
      private Long structureType;
      private Long contractualNature;
      private Long signerId;
      private String signerName;
      private Long locationId;
      private Long countryId;
      private Long provinceId;
      private Long cityId;
      private Long regionId;
      private String address;
      private BigDecimal structureArea;
      private Integer infoSource;
      private Boolean boolQuote;
      private Long applicantId;
      private String applicantName;
      private Long applicantDeptId;
      private LocalDateTime applicationDate;
      private Integer reviewStatus;
      private Long approveRecordId;
      private LocalDateTime reviewPassTime;
      private Long initDataId;
      private String remark;

      ContractPreRegistrationBuilder() {
      }

      @JsonProperty("id")
      public ContractPreRegistration.ContractPreRegistrationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("preRegistrationNo")
      public ContractPreRegistration.ContractPreRegistrationBuilder preRegistrationNo(final String preRegistrationNo) {
         this.preRegistrationNo = preRegistrationNo;
         return this;
      }

      @JsonProperty("contractNumber")
      public ContractPreRegistration.ContractPreRegistrationBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      @JsonProperty("partyType")
      public ContractPreRegistration.ContractPreRegistrationBuilder partyType(final Long partyType) {
         this.partyType = partyType;
         return this;
      }

      @JsonProperty("partyName")
      public ContractPreRegistration.ContractPreRegistrationBuilder partyName(final String partyName) {
         this.partyName = partyName;
         return this;
      }

      @JsonProperty("projectName")
      public ContractPreRegistration.ContractPreRegistrationBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("contractAmount")
      public ContractPreRegistration.ContractPreRegistrationBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      @JsonProperty("boolBidWinningNotice")
      public ContractPreRegistration.ContractPreRegistrationBuilder boolBidWinningNotice(final Boolean boolBidWinningNotice) {
         this.boolBidWinningNotice = boolBidWinningNotice;
         return this;
      }

      @JsonProperty("structureType")
      public ContractPreRegistration.ContractPreRegistrationBuilder structureType(final Long structureType) {
         this.structureType = structureType;
         return this;
      }

      @JsonProperty("contractualNature")
      public ContractPreRegistration.ContractPreRegistrationBuilder contractualNature(final Long contractualNature) {
         this.contractualNature = contractualNature;
         return this;
      }

      @JsonProperty("signerId")
      public ContractPreRegistration.ContractPreRegistrationBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      @JsonProperty("signerName")
      public ContractPreRegistration.ContractPreRegistrationBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      @JsonProperty("locationId")
      public ContractPreRegistration.ContractPreRegistrationBuilder locationId(final Long locationId) {
         this.locationId = locationId;
         return this;
      }

      @JsonProperty("countryId")
      public ContractPreRegistration.ContractPreRegistrationBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      @JsonProperty("provinceId")
      public ContractPreRegistration.ContractPreRegistrationBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      @JsonProperty("cityId")
      public ContractPreRegistration.ContractPreRegistrationBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      @JsonProperty("regionId")
      public ContractPreRegistration.ContractPreRegistrationBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      @JsonProperty("address")
      public ContractPreRegistration.ContractPreRegistrationBuilder address(final String address) {
         this.address = address;
         return this;
      }

      @JsonProperty("structureArea")
      public ContractPreRegistration.ContractPreRegistrationBuilder structureArea(final BigDecimal structureArea) {
         this.structureArea = structureArea;
         return this;
      }

      @JsonProperty("infoSource")
      public ContractPreRegistration.ContractPreRegistrationBuilder infoSource(final Integer infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      @JsonProperty("boolQuote")
      public ContractPreRegistration.ContractPreRegistrationBuilder boolQuote(final Boolean boolQuote) {
         this.boolQuote = boolQuote;
         return this;
      }

      @JsonProperty("applicantId")
      public ContractPreRegistration.ContractPreRegistrationBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public ContractPreRegistration.ContractPreRegistrationBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("applicantDeptId")
      public ContractPreRegistration.ContractPreRegistrationBuilder applicantDeptId(final Long applicantDeptId) {
         this.applicantDeptId = applicantDeptId;
         return this;
      }

      @JsonProperty("applicationDate")
      public ContractPreRegistration.ContractPreRegistrationBuilder applicationDate(final LocalDateTime applicationDate) {
         this.applicationDate = applicationDate;
         return this;
      }

      @JsonProperty("reviewStatus")
      public ContractPreRegistration.ContractPreRegistrationBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("approveRecordId")
      public ContractPreRegistration.ContractPreRegistrationBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      @JsonProperty("reviewPassTime")
      public ContractPreRegistration.ContractPreRegistrationBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      @JsonProperty("initDataId")
      public ContractPreRegistration.ContractPreRegistrationBuilder initDataId(final Long initDataId) {
         this.initDataId = initDataId;
         return this;
      }

      @JsonProperty("remark")
      public ContractPreRegistration.ContractPreRegistrationBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractPreRegistration build() {
         return new ContractPreRegistration(
            this.id,
            this.preRegistrationNo,
            this.contractNumber,
            this.partyType,
            this.partyName,
            this.projectName,
            this.contractAmount,
            this.boolBidWinningNotice,
            this.structureType,
            this.contractualNature,
            this.signerId,
            this.signerName,
            this.locationId,
            this.countryId,
            this.provinceId,
            this.cityId,
            this.regionId,
            this.address,
            this.structureArea,
            this.infoSource,
            this.boolQuote,
            this.applicantId,
            this.applicantName,
            this.applicantDeptId,
            this.applicationDate,
            this.reviewStatus,
            this.approveRecordId,
            this.reviewPassTime,
            this.initDataId,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractPreRegistration.ContractPreRegistrationBuilder(id="
            + this.id
            + ", preRegistrationNo="
            + this.preRegistrationNo
            + ", contractNumber="
            + this.contractNumber
            + ", partyType="
            + this.partyType
            + ", partyName="
            + this.partyName
            + ", projectName="
            + this.projectName
            + ", contractAmount="
            + this.contractAmount
            + ", boolBidWinningNotice="
            + this.boolBidWinningNotice
            + ", structureType="
            + this.structureType
            + ", contractualNature="
            + this.contractualNature
            + ", signerId="
            + this.signerId
            + ", signerName="
            + this.signerName
            + ", locationId="
            + this.locationId
            + ", countryId="
            + this.countryId
            + ", provinceId="
            + this.provinceId
            + ", cityId="
            + this.cityId
            + ", regionId="
            + this.regionId
            + ", address="
            + this.address
            + ", structureArea="
            + this.structureArea
            + ", infoSource="
            + this.infoSource
            + ", boolQuote="
            + this.boolQuote
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", applicantDeptId="
            + this.applicantDeptId
            + ", applicationDate="
            + this.applicationDate
            + ", reviewStatus="
            + this.reviewStatus
            + ", approveRecordId="
            + this.approveRecordId
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", initDataId="
            + this.initDataId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}

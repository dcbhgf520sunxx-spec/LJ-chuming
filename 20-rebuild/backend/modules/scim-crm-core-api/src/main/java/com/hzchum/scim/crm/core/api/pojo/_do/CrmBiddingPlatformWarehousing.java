package com.hzchum.scim.crm.core.api.pojo._do;

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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CrmBiddingPlatformWarehousing对象", description = "招标备案")
@Entity
@TableName("crm_bidding_platform_warehousing")
@Table(name = "crm_bidding_platform_warehousing")
@org.hibernate.annotations.Table(appliesTo = "crm_bidding_platform_warehousing")
public class CrmBiddingPlatformWarehousing extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serial_number", notes = "备案编号")
   @JsonProperty("serial_number")
   @JSONField(name = "serial_number")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) comment '备案编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   @TableField("informant_user_id")
   @Column(name = "informant_user_id", columnDefinition = "bigint(20)  COMMENT '填报人'", nullable = true)
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   @TableField("informant_user_name")
   @Column(name = "informant_user_name", columnDefinition = "varchar(255)  COMMENT '填报人名称'", nullable = true)
   private String informantUserName;
   @ApiModelProperty(name = "departmentId", value = "部门id", notes = "部门id")
   @TableField("department_id")
   @Column(name = "department_id", columnDefinition = "bigint(20)  COMMENT '部门id'", nullable = true)
   private Long departmentId;
   @ApiModelProperty(name = "crmRecordTypeEnum", value = "备案状态", notes = "备案状态")
   @TableField("crm_record_type_enum")
   @Column(name = "crm_record_type_enum", columnDefinition = "int(11)  COMMENT '备案状态'", nullable = true)
   private Integer crmRecordTypeEnum;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   @TableField("informant_date_time")
   @Column(name = "informant_date_time", columnDefinition = "datetime  COMMENT '填报日期'", nullable = true)
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "biddingPlatformName", value = "招标平台名称", notes = "招标平台名称")
   @TableField("bidding_platform_name")
   @Column(name = "bidding_platform_name", columnDefinition = "varchar(255)  COMMENT '招标平台名称'", nullable = true)
   private String biddingPlatformName;
   @ApiModelProperty(name = "reasonForRegistration", value = "报名事由", notes = "报名事由")
   @TableField("reason_for_registration")
   @Column(name = "reason_for_registration", columnDefinition = "varchar(255)  COMMENT '报名事由'", nullable = true)
   private String reasonForRegistration;
   @ApiModelProperty(name = "countryId", value = "国家id", notes = "国家id")
   @TableField("country_id")
   @Column(name = "country_id", columnDefinition = "bigint(20)  COMMENT '国家id'", nullable = true)
   private Long countryId;
   @ApiModelProperty(name = "countryName", value = "国家名称", notes = "国家名称")
   @TableField("country_name")
   @Column(name = "country_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '国家名称'", nullable = true)
   private String countryName;
   @ApiModelProperty(name = "provinceId", value = "省份id", notes = "省份id")
   @TableField("province_id")
   @Column(name = "province_id", columnDefinition = "bigint(20)  COMMENT '省份id'", nullable = true)
   private Long provinceId;
   @ApiModelProperty(name = "provinceName", value = "省份名称", notes = "省份名称")
   @TableField("province_name")
   @Column(name = "province_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '省份名称'", nullable = true)
   private String provinceName;
   @ApiModelProperty(name = "cityId", value = "城市id", notes = "城市id")
   @TableField("city_id")
   @Column(name = "city_id", columnDefinition = "bigint(20)  COMMENT '城市id'", nullable = true)
   private Long cityId;
   @ApiModelProperty(name = "cityName", value = "城市名称", notes = "城市名称")
   @TableField("city_name")
   @Column(name = "city_name", columnDefinition = "varchar(255) DEFAULT ''  COMMENT '城市名称'", nullable = true)
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "地区id", notes = "地区id")
   @TableField("region_id")
   @Column(name = "region_id", columnDefinition = "bigint(20)  COMMENT '地区id'", nullable = true)
   private Long regionId;
   @ApiModelProperty(name = "regionName", value = "地区名称", notes = "地区名称")
   @TableField("region_name")
   @Column(name = "region_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '地区名称'", nullable = true)
   private String regionName;
   @ApiModelProperty(name = "attachmentIds", value = "附件", notes = "附件")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '附件'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "acceptanceAddress", value = "受理地址", notes = "受理地址")
   @TableField("acceptance_address")
   @Column(name = "acceptance_address", columnDefinition = "varchar(255)  COMMENT '受理地址'", nullable = true)
   private String acceptanceAddress;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "受理截至日期", notes = "受理截至日期")
   @TableField("deadline_for_acceptance_time")
   @Column(name = "deadline_for_acceptance_time", columnDefinition = "datetime  COMMENT '受理截至日期'", nullable = true)
   private LocalDateTime deadlineForAcceptanceTime;
   @ApiModelProperty(name = "cost", value = "费用", notes = "费用")
   @TableField("cost")
   @Column(name = "cost", columnDefinition = "decimal(10,2)  COMMENT '费用'", nullable = true)
   private BigDecimal cost;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint(20)  COMMENT '审批id'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = true)
   private Long createUserId;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   @TableField("crm_check_status_enum")
   @Column(name = "crm_check_status_enum", columnDefinition = "int(11)  COMMENT '审核状态 参考枚举 CrmCheckStatusEnum'", nullable = true)
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   @TableField("crm_project_information_warehousing_id")
   @Column(name = "crm_project_information_warehousing_id", columnDefinition = "bigint(20)  COMMENT '项目备案id'", nullable = true)
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "overruleUserName", value = "驳回人名称", notes = "驳回人名称")
   @TableField("overrule_user_name")
   @Column(name = "overrule_user_name", columnDefinition = "varchar(255)  COMMENT '驳回人名称'", nullable = true)
   private String overruleUserName;
   @ApiModelProperty(name = "CALockDate", value = "锁定日期", notes = "锁定日期")
   @TableField("ca_lock_date")
   @Column(name = "ca_lock_date", columnDefinition = "date  COMMENT '锁定日期'", nullable = true)
   private LocalDate caLockDate;
   @ApiModelProperty(name = "platformFees", value = "平台费用", notes = "平台费用")
   @TableField("platform_fees")
   @Column(name = "platform_fees", columnDefinition = "decimal(10,2)  COMMENT '平台费用'", nullable = true)
   private BigDecimal platformFees;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   @TableField("crm_enterprise_warehousing_id")
   @Column(name = "crm_enterprise_warehousing_id", columnDefinition = "bigint(20)  COMMENT '企业备案id'", nullable = true)
   private Long crmEnterpriseWarehousingId;

   public static CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder builder() {
      return new CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder();
   }

   public CrmBiddingPlatformWarehousing() {
   }

   public CrmBiddingPlatformWarehousing(
      final Long id,
      final String serialNumber,
      final Long informantUserId,
      final String informantUserName,
      final Long departmentId,
      final Integer crmRecordTypeEnum,
      final LocalDateTime informantDateTime,
      final String biddingPlatformName,
      final String reasonForRegistration,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String attachmentIds,
      final String acceptanceAddress,
      final LocalDateTime deadlineForAcceptanceTime,
      final BigDecimal cost,
      final String remark,
      final Long approveRecordId,
      final Long createUserId,
      final Integer crmCheckStatusEnum,
      final Long crmProjectInformationWarehousingId,
      final String overruleUserName,
      final LocalDate caLockDate,
      final BigDecimal platformFees,
      final Long crmEnterpriseWarehousingId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.departmentId = departmentId;
      this.crmRecordTypeEnum = crmRecordTypeEnum;
      this.informantDateTime = informantDateTime;
      this.biddingPlatformName = biddingPlatformName;
      this.reasonForRegistration = reasonForRegistration;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.attachmentIds = attachmentIds;
      this.acceptanceAddress = acceptanceAddress;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.cost = cost;
      this.remark = remark;
      this.approveRecordId = approveRecordId;
      this.createUserId = createUserId;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.overruleUserName = overruleUserName;
      this.caLockDate = caLockDate;
      this.platformFees = platformFees;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public Integer getCrmRecordTypeEnum() {
      return this.crmRecordTypeEnum;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getBiddingPlatformName() {
      return this.biddingPlatformName;
   }

   public String getReasonForRegistration() {
      return this.reasonForRegistration;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getProvinceName() {
      return this.provinceName;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getCityName() {
      return this.cityName;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getAcceptanceAddress() {
      return this.acceptanceAddress;
   }

   public LocalDateTime getDeadlineForAcceptanceTime() {
      return this.deadlineForAcceptanceTime;
   }

   public BigDecimal getCost() {
      return this.cost;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public String getOverruleUserName() {
      return this.overruleUserName;
   }

   public LocalDate getCaLockDate() {
      return this.caLockDate;
   }

   public BigDecimal getPlatformFees() {
      return this.platformFees;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public CrmBiddingPlatformWarehousing setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serial_number")
   public CrmBiddingPlatformWarehousing setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmBiddingPlatformWarehousing setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmBiddingPlatformWarehousing setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmBiddingPlatformWarehousing setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmBiddingPlatformWarehousing setCrmRecordTypeEnum(final Integer crmRecordTypeEnum) {
      this.crmRecordTypeEnum = crmRecordTypeEnum;
      return this;
   }

   public CrmBiddingPlatformWarehousing setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmBiddingPlatformWarehousing setBiddingPlatformName(final String biddingPlatformName) {
      this.biddingPlatformName = biddingPlatformName;
      return this;
   }

   public CrmBiddingPlatformWarehousing setReasonForRegistration(final String reasonForRegistration) {
      this.reasonForRegistration = reasonForRegistration;
      return this;
   }

   public CrmBiddingPlatformWarehousing setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmBiddingPlatformWarehousing setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmBiddingPlatformWarehousing setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmBiddingPlatformWarehousing setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmBiddingPlatformWarehousing setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmBiddingPlatformWarehousing setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmBiddingPlatformWarehousing setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   public CrmBiddingPlatformWarehousing setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmBiddingPlatformWarehousing setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmBiddingPlatformWarehousing setAcceptanceAddress(final String acceptanceAddress) {
      this.acceptanceAddress = acceptanceAddress;
      return this;
   }

   public CrmBiddingPlatformWarehousing setDeadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      return this;
   }

   public CrmBiddingPlatformWarehousing setCost(final BigDecimal cost) {
      this.cost = cost;
      return this;
   }

   public CrmBiddingPlatformWarehousing setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmBiddingPlatformWarehousing setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmBiddingPlatformWarehousing setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmBiddingPlatformWarehousing setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmBiddingPlatformWarehousing setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmBiddingPlatformWarehousing setOverruleUserName(final String overruleUserName) {
      this.overruleUserName = overruleUserName;
      return this;
   }

   public CrmBiddingPlatformWarehousing setCaLockDate(final LocalDate caLockDate) {
      this.caLockDate = caLockDate;
      return this;
   }

   public CrmBiddingPlatformWarehousing setPlatformFees(final BigDecimal platformFees) {
      this.platformFees = platformFees;
      return this;
   }

   public CrmBiddingPlatformWarehousing setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBiddingPlatformWarehousing(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", crmRecordTypeEnum="
         + this.getCrmRecordTypeEnum()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", biddingPlatformName="
         + this.getBiddingPlatformName()
         + ", reasonForRegistration="
         + this.getReasonForRegistration()
         + ", countryId="
         + this.getCountryId()
         + ", countryName="
         + this.getCountryName()
         + ", provinceId="
         + this.getProvinceId()
         + ", provinceName="
         + this.getProvinceName()
         + ", cityId="
         + this.getCityId()
         + ", cityName="
         + this.getCityName()
         + ", regionId="
         + this.getRegionId()
         + ", regionName="
         + this.getRegionName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", acceptanceAddress="
         + this.getAcceptanceAddress()
         + ", deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", cost="
         + this.getCost()
         + ", remark="
         + this.getRemark()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", overruleUserName="
         + this.getOverruleUserName()
         + ", caLockDate="
         + this.getCaLockDate()
         + ", platformFees="
         + this.getPlatformFees()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBiddingPlatformWarehousing)) {
         return false;
      }

      CrmBiddingPlatformWarehousing other = (CrmBiddingPlatformWarehousing)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$informantUserId = this.getInformantUserId();
         Object other$informantUserId = other.getInformantUserId();
         if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
            Object this$departmentId = this.getDepartmentId();
            Object other$departmentId = other.getDepartmentId();
            if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
               Object this$crmRecordTypeEnum = this.getCrmRecordTypeEnum();
               Object other$crmRecordTypeEnum = other.getCrmRecordTypeEnum();
               if (this$crmRecordTypeEnum == null ? other$crmRecordTypeEnum == null : this$crmRecordTypeEnum.equals(other$crmRecordTypeEnum)) {
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
                              Object this$approveRecordId = this.getApproveRecordId();
                              Object other$approveRecordId = other.getApproveRecordId();
                              if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                                 Object this$createUserId = this.getCreateUserId();
                                 Object other$createUserId = other.getCreateUserId();
                                 if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                                    Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
                                    Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
                                    if (this$crmCheckStatusEnum == null
                                       ? other$crmCheckStatusEnum == null
                                       : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                                       Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
                                       Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
                                       if (this$crmProjectInformationWarehousingId == null
                                          ? other$crmProjectInformationWarehousingId == null
                                          : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
                                          Object this$crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
                                          Object other$crmEnterpriseWarehousingId = other.getCrmEnterpriseWarehousingId();
                                          if (this$crmEnterpriseWarehousingId == null
                                             ? other$crmEnterpriseWarehousingId == null
                                             : this$crmEnterpriseWarehousingId.equals(other$crmEnterpriseWarehousingId)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$informantUserName = this.getInformantUserName();
                                                Object other$informantUserName = other.getInformantUserName();
                                                if (this$informantUserName == null
                                                   ? other$informantUserName == null
                                                   : this$informantUserName.equals(other$informantUserName)) {
                                                   Object this$informantDateTime = this.getInformantDateTime();
                                                   Object other$informantDateTime = other.getInformantDateTime();
                                                   if (this$informantDateTime == null
                                                      ? other$informantDateTime == null
                                                      : this$informantDateTime.equals(other$informantDateTime)) {
                                                      Object this$biddingPlatformName = this.getBiddingPlatformName();
                                                      Object other$biddingPlatformName = other.getBiddingPlatformName();
                                                      if (this$biddingPlatformName == null
                                                         ? other$biddingPlatformName == null
                                                         : this$biddingPlatformName.equals(other$biddingPlatformName)) {
                                                         Object this$reasonForRegistration = this.getReasonForRegistration();
                                                         Object other$reasonForRegistration = other.getReasonForRegistration();
                                                         if (this$reasonForRegistration == null
                                                            ? other$reasonForRegistration == null
                                                            : this$reasonForRegistration.equals(other$reasonForRegistration)) {
                                                            Object this$countryName = this.getCountryName();
                                                            Object other$countryName = other.getCountryName();
                                                            if (this$countryName == null
                                                               ? other$countryName == null
                                                               : this$countryName.equals(other$countryName)) {
                                                               Object this$provinceName = this.getProvinceName();
                                                               Object other$provinceName = other.getProvinceName();
                                                               if (this$provinceName == null
                                                                  ? other$provinceName == null
                                                                  : this$provinceName.equals(other$provinceName)) {
                                                                  Object this$cityName = this.getCityName();
                                                                  Object other$cityName = other.getCityName();
                                                                  if (this$cityName == null ? other$cityName == null : this$cityName.equals(other$cityName)) {
                                                                     Object this$regionName = this.getRegionName();
                                                                     Object other$regionName = other.getRegionName();
                                                                     if (this$regionName == null
                                                                        ? other$regionName == null
                                                                        : this$regionName.equals(other$regionName)) {
                                                                        Object this$attachmentIds = this.getAttachmentIds();
                                                                        Object other$attachmentIds = other.getAttachmentIds();
                                                                        if (this$attachmentIds == null
                                                                           ? other$attachmentIds == null
                                                                           : this$attachmentIds.equals(other$attachmentIds)) {
                                                                           Object this$acceptanceAddress = this.getAcceptanceAddress();
                                                                           Object other$acceptanceAddress = other.getAcceptanceAddress();
                                                                           if (this$acceptanceAddress == null
                                                                              ? other$acceptanceAddress == null
                                                                              : this$acceptanceAddress.equals(other$acceptanceAddress)) {
                                                                              Object this$deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
                                                                              Object other$deadlineForAcceptanceTime = other.getDeadlineForAcceptanceTime();
                                                                              if (this$deadlineForAcceptanceTime == null
                                                                                 ? other$deadlineForAcceptanceTime == null
                                                                                 : this$deadlineForAcceptanceTime.equals(other$deadlineForAcceptanceTime)) {
                                                                                 Object this$cost = this.getCost();
                                                                                 Object other$cost = other.getCost();
                                                                                 if (this$cost == null ? other$cost == null : this$cost.equals(other$cost)) {
                                                                                    Object this$remark = this.getRemark();
                                                                                    Object other$remark = other.getRemark();
                                                                                    if (this$remark == null
                                                                                       ? other$remark == null
                                                                                       : this$remark.equals(other$remark)) {
                                                                                       Object this$overruleUserName = this.getOverruleUserName();
                                                                                       Object other$overruleUserName = other.getOverruleUserName();
                                                                                       if (this$overruleUserName == null
                                                                                          ? other$overruleUserName == null
                                                                                          : this$overruleUserName.equals(other$overruleUserName)) {
                                                                                          Object this$caLockDate = this.getCaLockDate();
                                                                                          Object other$caLockDate = other.getCaLockDate();
                                                                                          if (this$caLockDate == null
                                                                                             ? other$caLockDate == null
                                                                                             : this$caLockDate.equals(other$caLockDate)) {
                                                                                             Object this$platformFees = this.getPlatformFees();
                                                                                             Object other$platformFees = other.getPlatformFees();
                                                                                             return this$platformFees == null
                                                                                                ? other$platformFees == null
                                                                                                : this$platformFees.equals(other$platformFees);
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof CrmBiddingPlatformWarehousing;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $crmRecordTypeEnum = this.getCrmRecordTypeEnum();
      result = result * 59 + ($crmRecordTypeEnum == null ? 43 : $crmRecordTypeEnum.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $biddingPlatformName = this.getBiddingPlatformName();
      result = result * 59 + ($biddingPlatformName == null ? 43 : $biddingPlatformName.hashCode());
      Object $reasonForRegistration = this.getReasonForRegistration();
      result = result * 59 + ($reasonForRegistration == null ? 43 : $reasonForRegistration.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $acceptanceAddress = this.getAcceptanceAddress();
      result = result * 59 + ($acceptanceAddress == null ? 43 : $acceptanceAddress.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $cost = this.getCost();
      result = result * 59 + ($cost == null ? 43 : $cost.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $overruleUserName = this.getOverruleUserName();
      result = result * 59 + ($overruleUserName == null ? 43 : $overruleUserName.hashCode());
      Object $caLockDate = this.getCaLockDate();
      result = result * 59 + ($caLockDate == null ? 43 : $caLockDate.hashCode());
      Object $platformFees = this.getPlatformFees();
      return result * 59 + ($platformFees == null ? 43 : $platformFees.hashCode());
   }

   public static class CrmBiddingPlatformWarehousingBuilder {
      private Long id;
      private String serialNumber;
      private Long informantUserId;
      private String informantUserName;
      private Long departmentId;
      private Integer crmRecordTypeEnum;
      private LocalDateTime informantDateTime;
      private String biddingPlatformName;
      private String reasonForRegistration;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private String attachmentIds;
      private String acceptanceAddress;
      private LocalDateTime deadlineForAcceptanceTime;
      private BigDecimal cost;
      private String remark;
      private Long approveRecordId;
      private Long createUserId;
      private Integer crmCheckStatusEnum;
      private Long crmProjectInformationWarehousingId;
      private String overruleUserName;
      private LocalDate caLockDate;
      private BigDecimal platformFees;
      private Long crmEnterpriseWarehousingId;

      CrmBiddingPlatformWarehousingBuilder() {
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serial_number")
      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder crmRecordTypeEnum(final Integer crmRecordTypeEnum) {
         this.crmRecordTypeEnum = crmRecordTypeEnum;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder biddingPlatformName(final String biddingPlatformName) {
         this.biddingPlatformName = biddingPlatformName;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder reasonForRegistration(final String reasonForRegistration) {
         this.reasonForRegistration = reasonForRegistration;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder acceptanceAddress(final String acceptanceAddress) {
         this.acceptanceAddress = acceptanceAddress;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder deadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
         this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder cost(final BigDecimal cost) {
         this.cost = cost;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder overruleUserName(final String overruleUserName) {
         this.overruleUserName = overruleUserName;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder caLockDate(final LocalDate caLockDate) {
         this.caLockDate = caLockDate;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder platformFees(final BigDecimal platformFees) {
         this.platformFees = platformFees;
         return this;
      }

      public CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder crmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
         this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
         return this;
      }

      public CrmBiddingPlatformWarehousing build() {
         return new CrmBiddingPlatformWarehousing(
            this.id,
            this.serialNumber,
            this.informantUserId,
            this.informantUserName,
            this.departmentId,
            this.crmRecordTypeEnum,
            this.informantDateTime,
            this.biddingPlatformName,
            this.reasonForRegistration,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.attachmentIds,
            this.acceptanceAddress,
            this.deadlineForAcceptanceTime,
            this.cost,
            this.remark,
            this.approveRecordId,
            this.createUserId,
            this.crmCheckStatusEnum,
            this.crmProjectInformationWarehousingId,
            this.overruleUserName,
            this.caLockDate,
            this.platformFees,
            this.crmEnterpriseWarehousingId
         );
      }

      @Override
      public String toString() {
         return "CrmBiddingPlatformWarehousing.CrmBiddingPlatformWarehousingBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", departmentId="
            + this.departmentId
            + ", crmRecordTypeEnum="
            + this.crmRecordTypeEnum
            + ", informantDateTime="
            + this.informantDateTime
            + ", biddingPlatformName="
            + this.biddingPlatformName
            + ", reasonForRegistration="
            + this.reasonForRegistration
            + ", countryId="
            + this.countryId
            + ", countryName="
            + this.countryName
            + ", provinceId="
            + this.provinceId
            + ", provinceName="
            + this.provinceName
            + ", cityId="
            + this.cityId
            + ", cityName="
            + this.cityName
            + ", regionId="
            + this.regionId
            + ", regionName="
            + this.regionName
            + ", attachmentIds="
            + this.attachmentIds
            + ", acceptanceAddress="
            + this.acceptanceAddress
            + ", deadlineForAcceptanceTime="
            + this.deadlineForAcceptanceTime
            + ", cost="
            + this.cost
            + ", remark="
            + this.remark
            + ", approveRecordId="
            + this.approveRecordId
            + ", createUserId="
            + this.createUserId
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", overruleUserName="
            + this.overruleUserName
            + ", caLockDate="
            + this.caLockDate
            + ", platformFees="
            + this.platformFees
            + ", crmEnterpriseWarehousingId="
            + this.crmEnterpriseWarehousingId
            + ")";
      }
   }
}

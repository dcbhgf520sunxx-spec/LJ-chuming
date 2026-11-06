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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CrmEnterpriseWarehousing对象", description = "企业备案")
@Entity
@TableName("crm_enterprise_warehousing")
@Table(name = "crm_enterprise_warehousing")
@org.hibernate.annotations.Table(appliesTo = "crm_enterprise_warehousing")
public class CrmEnterpriseWarehousing extends BaseEntity<Long> {
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
   @Column(name = "serial_number", columnDefinition = "varchar(255) comment '备案编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   @TableField("informant_user_id")
   @Column(name = "informant_user_id", columnDefinition = "bigint(20)  COMMENT '填报人'", nullable = true)
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   @TableField("informant_user_name")
   @Column(name = "informant_user_name", columnDefinition = "varchar(255)  COMMENT '填报人名称'", nullable = true)
   private String informantUserName;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = true)
   private Long createUserId;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   @TableField("crm_check_status_enum")
   @Column(name = "crm_check_status_enum", columnDefinition = "int(11)  COMMENT '审核状态 参考枚举 CrmCheckStatusEnum'", nullable = true)
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "departmentId", value = "部门id", notes = "部门id")
   @TableField("department_id")
   @Column(name = "department_id", columnDefinition = "bigint(20)  COMMENT '部门id'", nullable = true)
   private Long departmentId;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   @TableField("informant_date_time")
   @Column(name = "informant_date_time", columnDefinition = "datetime  COMMENT '填报日期'", nullable = true)
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "businessName", value = "企业名称", notes = "企业名称")
   @TableField("business_name")
   @Column(name = "business_name", columnDefinition = "varchar(255)  COMMENT '企业名称'", nullable = true)
   private String businessName;
   @ApiModelProperty(name = "unitPropertyAllocationConfigId", value = "单位类别id  参考crm_basics_config", notes = "单位类别id  参考crm_basics_config")
   @TableField("unit_property_allocation_config_id")
   @Column(name = "unit_property_allocation_config_id", columnDefinition = "bigint(20)  COMMENT '单位类别id  参考crm_basics_config'", nullable = true)
   private Long unitPropertyAllocationConfigId;
   @ApiModelProperty(name = "unitClassConfigurationId", value = "单位性质id  参考crm_basics_config", notes = "单位性质id  参考crm_basics_config")
   @TableField("unit_class_configuration_id")
   @Column(name = "unit_class_configuration_id", columnDefinition = "bigint(20)  COMMENT '单位性质id  参考crm_basics_config'", nullable = true)
   private Long unitClassConfigurationId;
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
   @Column(name = "city_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '城市名称'", nullable = true)
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "地区id", notes = "地区id")
   @TableField("region_id")
   @Column(name = "region_id", columnDefinition = "bigint(20)  COMMENT '地区id'", nullable = true)
   private Long regionId;
   @ApiModelProperty(name = "regionName", value = "地区名称", notes = "地区名称")
   @TableField("region_name")
   @Column(name = "region_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '地区名称'", nullable = true)
   private String regionName;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   @TableField("address")
   @Column(name = "address", columnDefinition = "varchar(255)  COMMENT '详细地址'", nullable = true)
   private String address;
   @ApiModelProperty(name = "creditCode", value = "社会统一信用代码", notes = "社会统一信用代码")
   @TableField("credit_code")
   @Column(name = "credit_code", columnDefinition = "varchar(255)  COMMENT '社会统一信用代码'", nullable = true)
   private String creditCode;
   @ApiModelProperty(name = "industryConfigurationId", value = "单位所属行业id  参考 crm_basice_config", notes = "单位所属行业id  参考 crm_basice_config")
   @TableField("industry_configuration_id")
   @Column(name = "industry_configuration_id", columnDefinition = "bigint(20)  COMMENT '单位所属行业id  参考 crm_basice_config'", nullable = true)
   private Long industryConfigurationId;
   @ApiModelProperty(name = "businessPhone", value = "单位电话", notes = "单位电话")
   @TableField("business_phone")
   @Column(name = "business_phone", columnDefinition = "varchar(255)  COMMENT '单位电话'", nullable = true)
   private String businessPhone;
   @ApiModelProperty(name = "businessEmail", value = "单位邮箱", notes = "单位邮箱")
   @TableField("business_email")
   @Column(name = "business_email", columnDefinition = "varchar(255)  COMMENT '单位邮箱'", nullable = true)
   private String businessEmail;
   @ApiModelProperty(name = "liaisons", value = "联系人", notes = "联系人")
   @TableField("liaisons")
   @Column(name = "liaisons", columnDefinition = "varchar(255)  COMMENT '联系人'", nullable = true)
   private String liaisons;
   @ApiModelProperty(name = "qualificationAndAbility", value = "资质能力", notes = "资质能力")
   @TableField("qualification_and_ability")
   @Column(name = "qualification_and_ability", columnDefinition = "varchar(255)  COMMENT '资质能力'", nullable = true)
   private String qualificationAndAbility;
   @ApiModelProperty(name = "attachmentIds", value = "附件id 字符串", notes = "附件id 字符串")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '附件id 字符串'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "crmCountryTypeEnum", value = "国家类型枚举（CrmCountryTypeEnum）", notes = "国家类型枚举（CrmCountryTypeEnum）")
   @TableField("crm_country_type_enum")
   @Column(name = "crm_country_type_enum", columnDefinition = "int(11)  COMMENT '国家类型枚举（CrmCountryTypeEnum）'", nullable = true)
   private Integer crmCountryTypeEnum;
   @ApiModelProperty(name = "remark", value = "其他信息备注", notes = "其他信息备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '其他信息备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "unitReputationAllocationConfigId", value = "企业信誉  参考 crm_basice_config", notes = "企业信誉  参考 crm_basice_config")
   @TableField("unit_reputation_allocation_config_id")
   @Column(name = "unit_reputation_allocation_config_id", columnDefinition = "bigint(20)  COMMENT '企业信誉  参考 crm_basice_config'", nullable = true)
   private Long unitReputationAllocationConfigId;

   public static CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder builder() {
      return new CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder();
   }

   public CrmEnterpriseWarehousing() {
   }

   public CrmEnterpriseWarehousing(
      final Long id,
      final String serialNumber,
      final Long informantUserId,
      final String informantUserName,
      final Long createUserId,
      final Integer crmCheckStatusEnum,
      final Long departmentId,
      final LocalDateTime informantDateTime,
      final String businessName,
      final Long unitPropertyAllocationConfigId,
      final Long unitClassConfigurationId,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String address,
      final String creditCode,
      final Long industryConfigurationId,
      final String businessPhone,
      final String businessEmail,
      final String liaisons,
      final String qualificationAndAbility,
      final String attachmentIds,
      final Integer crmCountryTypeEnum,
      final String remark,
      final Long unitReputationAllocationConfigId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.createUserId = createUserId;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.departmentId = departmentId;
      this.informantDateTime = informantDateTime;
      this.businessName = businessName;
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      this.unitClassConfigurationId = unitClassConfigurationId;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.address = address;
      this.creditCode = creditCode;
      this.industryConfigurationId = industryConfigurationId;
      this.businessPhone = businessPhone;
      this.businessEmail = businessEmail;
      this.liaisons = liaisons;
      this.qualificationAndAbility = qualificationAndAbility;
      this.attachmentIds = attachmentIds;
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      this.remark = remark;
      this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
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

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getBusinessName() {
      return this.businessName;
   }

   public Long getUnitPropertyAllocationConfigId() {
      return this.unitPropertyAllocationConfigId;
   }

   public Long getUnitClassConfigurationId() {
      return this.unitClassConfigurationId;
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

   public String getAddress() {
      return this.address;
   }

   public String getCreditCode() {
      return this.creditCode;
   }

   public Long getIndustryConfigurationId() {
      return this.industryConfigurationId;
   }

   public String getBusinessPhone() {
      return this.businessPhone;
   }

   public String getBusinessEmail() {
      return this.businessEmail;
   }

   public String getLiaisons() {
      return this.liaisons;
   }

   public String getQualificationAndAbility() {
      return this.qualificationAndAbility;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public Integer getCrmCountryTypeEnum() {
      return this.crmCountryTypeEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUnitReputationAllocationConfigId() {
      return this.unitReputationAllocationConfigId;
   }

   public CrmEnterpriseWarehousing setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serial_number")
   public CrmEnterpriseWarehousing setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmEnterpriseWarehousing setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmEnterpriseWarehousing setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmEnterpriseWarehousing setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmEnterpriseWarehousing setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmEnterpriseWarehousing setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmEnterpriseWarehousing setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmEnterpriseWarehousing setBusinessName(final String businessName) {
      this.businessName = businessName;
      return this;
   }

   public CrmEnterpriseWarehousing setUnitPropertyAllocationConfigId(final Long unitPropertyAllocationConfigId) {
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      return this;
   }

   public CrmEnterpriseWarehousing setUnitClassConfigurationId(final Long unitClassConfigurationId) {
      this.unitClassConfigurationId = unitClassConfigurationId;
      return this;
   }

   public CrmEnterpriseWarehousing setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmEnterpriseWarehousing setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmEnterpriseWarehousing setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmEnterpriseWarehousing setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmEnterpriseWarehousing setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmEnterpriseWarehousing setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmEnterpriseWarehousing setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   public CrmEnterpriseWarehousing setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmEnterpriseWarehousing setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmEnterpriseWarehousing setCreditCode(final String creditCode) {
      this.creditCode = creditCode;
      return this;
   }

   public CrmEnterpriseWarehousing setIndustryConfigurationId(final Long industryConfigurationId) {
      this.industryConfigurationId = industryConfigurationId;
      return this;
   }

   public CrmEnterpriseWarehousing setBusinessPhone(final String businessPhone) {
      this.businessPhone = businessPhone;
      return this;
   }

   public CrmEnterpriseWarehousing setBusinessEmail(final String businessEmail) {
      this.businessEmail = businessEmail;
      return this;
   }

   public CrmEnterpriseWarehousing setLiaisons(final String liaisons) {
      this.liaisons = liaisons;
      return this;
   }

   public CrmEnterpriseWarehousing setQualificationAndAbility(final String qualificationAndAbility) {
      this.qualificationAndAbility = qualificationAndAbility;
      return this;
   }

   public CrmEnterpriseWarehousing setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmEnterpriseWarehousing setCrmCountryTypeEnum(final Integer crmCountryTypeEnum) {
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      return this;
   }

   public CrmEnterpriseWarehousing setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmEnterpriseWarehousing setUnitReputationAllocationConfigId(final Long unitReputationAllocationConfigId) {
      this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
      return this;
   }

   @Override
   public String toString() {
      return "CrmEnterpriseWarehousing(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", createUserId="
         + this.getCreateUserId()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", departmentId="
         + this.getDepartmentId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", businessName="
         + this.getBusinessName()
         + ", unitPropertyAllocationConfigId="
         + this.getUnitPropertyAllocationConfigId()
         + ", unitClassConfigurationId="
         + this.getUnitClassConfigurationId()
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
         + ", address="
         + this.getAddress()
         + ", creditCode="
         + this.getCreditCode()
         + ", industryConfigurationId="
         + this.getIndustryConfigurationId()
         + ", businessPhone="
         + this.getBusinessPhone()
         + ", businessEmail="
         + this.getBusinessEmail()
         + ", liaisons="
         + this.getLiaisons()
         + ", qualificationAndAbility="
         + this.getQualificationAndAbility()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", crmCountryTypeEnum="
         + this.getCrmCountryTypeEnum()
         + ", remark="
         + this.getRemark()
         + ", unitReputationAllocationConfigId="
         + this.getUnitReputationAllocationConfigId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmEnterpriseWarehousing)) {
         return false;
      }

      CrmEnterpriseWarehousing other = (CrmEnterpriseWarehousing)o;
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
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
               Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
               if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                  Object this$departmentId = this.getDepartmentId();
                  Object other$departmentId = other.getDepartmentId();
                  if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
                     Object this$unitPropertyAllocationConfigId = this.getUnitPropertyAllocationConfigId();
                     Object other$unitPropertyAllocationConfigId = other.getUnitPropertyAllocationConfigId();
                     if (this$unitPropertyAllocationConfigId == null
                        ? other$unitPropertyAllocationConfigId == null
                        : this$unitPropertyAllocationConfigId.equals(other$unitPropertyAllocationConfigId)) {
                        Object this$unitClassConfigurationId = this.getUnitClassConfigurationId();
                        Object other$unitClassConfigurationId = other.getUnitClassConfigurationId();
                        if (this$unitClassConfigurationId == null
                           ? other$unitClassConfigurationId == null
                           : this$unitClassConfigurationId.equals(other$unitClassConfigurationId)) {
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
                                       Object this$industryConfigurationId = this.getIndustryConfigurationId();
                                       Object other$industryConfigurationId = other.getIndustryConfigurationId();
                                       if (this$industryConfigurationId == null
                                          ? other$industryConfigurationId == null
                                          : this$industryConfigurationId.equals(other$industryConfigurationId)) {
                                          Object this$crmCountryTypeEnum = this.getCrmCountryTypeEnum();
                                          Object other$crmCountryTypeEnum = other.getCrmCountryTypeEnum();
                                          if (this$crmCountryTypeEnum == null
                                             ? other$crmCountryTypeEnum == null
                                             : this$crmCountryTypeEnum.equals(other$crmCountryTypeEnum)) {
                                             Object this$unitReputationAllocationConfigId = this.getUnitReputationAllocationConfigId();
                                             Object other$unitReputationAllocationConfigId = other.getUnitReputationAllocationConfigId();
                                             if (this$unitReputationAllocationConfigId == null
                                                ? other$unitReputationAllocationConfigId == null
                                                : this$unitReputationAllocationConfigId.equals(other$unitReputationAllocationConfigId)) {
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
                                                         Object this$businessName = this.getBusinessName();
                                                         Object other$businessName = other.getBusinessName();
                                                         if (this$businessName == null
                                                            ? other$businessName == null
                                                            : this$businessName.equals(other$businessName)) {
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
                                                                        Object this$address = this.getAddress();
                                                                        Object other$address = other.getAddress();
                                                                        if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                                           Object this$creditCode = this.getCreditCode();
                                                                           Object other$creditCode = other.getCreditCode();
                                                                           if (this$creditCode == null
                                                                              ? other$creditCode == null
                                                                              : this$creditCode.equals(other$creditCode)) {
                                                                              Object this$businessPhone = this.getBusinessPhone();
                                                                              Object other$businessPhone = other.getBusinessPhone();
                                                                              if (this$businessPhone == null
                                                                                 ? other$businessPhone == null
                                                                                 : this$businessPhone.equals(other$businessPhone)) {
                                                                                 Object this$businessEmail = this.getBusinessEmail();
                                                                                 Object other$businessEmail = other.getBusinessEmail();
                                                                                 if (this$businessEmail == null
                                                                                    ? other$businessEmail == null
                                                                                    : this$businessEmail.equals(other$businessEmail)) {
                                                                                    Object this$liaisons = this.getLiaisons();
                                                                                    Object other$liaisons = other.getLiaisons();
                                                                                    if (this$liaisons == null
                                                                                       ? other$liaisons == null
                                                                                       : this$liaisons.equals(other$liaisons)) {
                                                                                       Object this$qualificationAndAbility = this.getQualificationAndAbility();
                                                                                       Object other$qualificationAndAbility = other.getQualificationAndAbility();
                                                                                       if (this$qualificationAndAbility == null
                                                                                          ? other$qualificationAndAbility == null
                                                                                          : this$qualificationAndAbility.equals(other$qualificationAndAbility)) {
                                                                                          Object this$attachmentIds = this.getAttachmentIds();
                                                                                          Object other$attachmentIds = other.getAttachmentIds();
                                                                                          if (this$attachmentIds == null
                                                                                             ? other$attachmentIds == null
                                                                                             : this$attachmentIds.equals(other$attachmentIds)) {
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
      return other instanceof CrmEnterpriseWarehousing;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $unitPropertyAllocationConfigId = this.getUnitPropertyAllocationConfigId();
      result = result * 59 + ($unitPropertyAllocationConfigId == null ? 43 : $unitPropertyAllocationConfigId.hashCode());
      Object $unitClassConfigurationId = this.getUnitClassConfigurationId();
      result = result * 59 + ($unitClassConfigurationId == null ? 43 : $unitClassConfigurationId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $industryConfigurationId = this.getIndustryConfigurationId();
      result = result * 59 + ($industryConfigurationId == null ? 43 : $industryConfigurationId.hashCode());
      Object $crmCountryTypeEnum = this.getCrmCountryTypeEnum();
      result = result * 59 + ($crmCountryTypeEnum == null ? 43 : $crmCountryTypeEnum.hashCode());
      Object $unitReputationAllocationConfigId = this.getUnitReputationAllocationConfigId();
      result = result * 59 + ($unitReputationAllocationConfigId == null ? 43 : $unitReputationAllocationConfigId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $businessName = this.getBusinessName();
      result = result * 59 + ($businessName == null ? 43 : $businessName.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $creditCode = this.getCreditCode();
      result = result * 59 + ($creditCode == null ? 43 : $creditCode.hashCode());
      Object $businessPhone = this.getBusinessPhone();
      result = result * 59 + ($businessPhone == null ? 43 : $businessPhone.hashCode());
      Object $businessEmail = this.getBusinessEmail();
      result = result * 59 + ($businessEmail == null ? 43 : $businessEmail.hashCode());
      Object $liaisons = this.getLiaisons();
      result = result * 59 + ($liaisons == null ? 43 : $liaisons.hashCode());
      Object $qualificationAndAbility = this.getQualificationAndAbility();
      result = result * 59 + ($qualificationAndAbility == null ? 43 : $qualificationAndAbility.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class CrmEnterpriseWarehousingBuilder {
      private Long id;
      private String serialNumber;
      private Long informantUserId;
      private String informantUserName;
      private Long createUserId;
      private Integer crmCheckStatusEnum;
      private Long departmentId;
      private LocalDateTime informantDateTime;
      private String businessName;
      private Long unitPropertyAllocationConfigId;
      private Long unitClassConfigurationId;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private String address;
      private String creditCode;
      private Long industryConfigurationId;
      private String businessPhone;
      private String businessEmail;
      private String liaisons;
      private String qualificationAndAbility;
      private String attachmentIds;
      private Integer crmCountryTypeEnum;
      private String remark;
      private Long unitReputationAllocationConfigId;

      CrmEnterpriseWarehousingBuilder() {
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serial_number")
      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder businessName(final String businessName) {
         this.businessName = businessName;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder unitPropertyAllocationConfigId(final Long unitPropertyAllocationConfigId) {
         this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder unitClassConfigurationId(final Long unitClassConfigurationId) {
         this.unitClassConfigurationId = unitClassConfigurationId;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder creditCode(final String creditCode) {
         this.creditCode = creditCode;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder industryConfigurationId(final Long industryConfigurationId) {
         this.industryConfigurationId = industryConfigurationId;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder businessPhone(final String businessPhone) {
         this.businessPhone = businessPhone;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder businessEmail(final String businessEmail) {
         this.businessEmail = businessEmail;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder liaisons(final String liaisons) {
         this.liaisons = liaisons;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder qualificationAndAbility(final String qualificationAndAbility) {
         this.qualificationAndAbility = qualificationAndAbility;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder crmCountryTypeEnum(final Integer crmCountryTypeEnum) {
         this.crmCountryTypeEnum = crmCountryTypeEnum;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder unitReputationAllocationConfigId(final Long unitReputationAllocationConfigId) {
         this.unitReputationAllocationConfigId = unitReputationAllocationConfigId;
         return this;
      }

      public CrmEnterpriseWarehousing build() {
         return new CrmEnterpriseWarehousing(
            this.id,
            this.serialNumber,
            this.informantUserId,
            this.informantUserName,
            this.createUserId,
            this.crmCheckStatusEnum,
            this.departmentId,
            this.informantDateTime,
            this.businessName,
            this.unitPropertyAllocationConfigId,
            this.unitClassConfigurationId,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.address,
            this.creditCode,
            this.industryConfigurationId,
            this.businessPhone,
            this.businessEmail,
            this.liaisons,
            this.qualificationAndAbility,
            this.attachmentIds,
            this.crmCountryTypeEnum,
            this.remark,
            this.unitReputationAllocationConfigId
         );
      }

      @Override
      public String toString() {
         return "CrmEnterpriseWarehousing.CrmEnterpriseWarehousingBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", createUserId="
            + this.createUserId
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", departmentId="
            + this.departmentId
            + ", informantDateTime="
            + this.informantDateTime
            + ", businessName="
            + this.businessName
            + ", unitPropertyAllocationConfigId="
            + this.unitPropertyAllocationConfigId
            + ", unitClassConfigurationId="
            + this.unitClassConfigurationId
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
            + ", address="
            + this.address
            + ", creditCode="
            + this.creditCode
            + ", industryConfigurationId="
            + this.industryConfigurationId
            + ", businessPhone="
            + this.businessPhone
            + ", businessEmail="
            + this.businessEmail
            + ", liaisons="
            + this.liaisons
            + ", qualificationAndAbility="
            + this.qualificationAndAbility
            + ", attachmentIds="
            + this.attachmentIds
            + ", crmCountryTypeEnum="
            + this.crmCountryTypeEnum
            + ", remark="
            + this.remark
            + ", unitReputationAllocationConfigId="
            + this.unitReputationAllocationConfigId
            + ")";
      }
   }
}

package com.hzchum.scim.scm.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "Supplier对象", description = "供应商 ")
@Entity
@TableName("scm_supplier")
@Table(name = "scm_supplier")
public class Supplier extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", notes = "供应商名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "供应商简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   @TableField("short_name")
   @Column(name = "short_name")
   private String shortName;
   @ApiModelProperty(name = "supplierNumber", notes = "供应商编号")
   @JsonProperty("supplierNumber")
   @JSONField(name = "supplierNumber")
   @TableField("supplier_number")
   @Column(name = "supplier_number")
   private String supplierNumber;
   @ApiModelProperty(name = "countryId", notes = "国家id")
   @JsonProperty("countryId")
   @JSONField(name = "countryId")
   @TableField("country_id")
   @Column(name = "country_id")
   private Long countryId;
   @ApiModelProperty(name = "provinceId", notes = "省/洲id")
   @JsonProperty("provinceId")
   @JSONField(name = "provinceId")
   @TableField("province_id")
   @Column(name = "province_id")
   private Long provinceId;
   @ApiModelProperty(name = "cityId", notes = "市id")
   @JsonProperty("cityId")
   @JSONField(name = "cityId")
   @TableField("city_id")
   @Column(name = "city_id")
   private Long cityId;
   @ApiModelProperty(name = "regionId", notes = "区/县id")
   @JsonProperty("regionId")
   @JSONField(name = "regionId")
   @TableField("region_id")
   @Column(name = "region_id")
   private Long regionId;
   @ApiModelProperty(name = "address", notes = "详细地址")
   @JsonProperty("address")
   @JSONField(name = "address")
   @TableField("address")
   @Column(name = "address")
   private String address;
   @ApiModelProperty(name = "socialCode", notes = "社会统一代码")
   @JsonProperty("socialCode")
   @JSONField(name = "socialCode")
   @TableField("social_code")
   @Column(name = "social_code")
   private String socialCode;
   @ApiModelProperty(name = "registrationDate", notes = "成立时间")
   @JsonProperty("registrationDate")
   @JSONField(name = "registrationDate")
   @TableField("registration_date")
   @Column(name = "registration_date")
   private LocalDate registrationDate;
   @ApiModelProperty(name = "businessTerm", notes = "营业期限")
   @JsonProperty("businessTerm")
   @JSONField(name = "businessTerm")
   @TableField("business_term")
   @Column(name = "business_term")
   private String businessTerm;
   @ApiModelProperty(name = "legalRepresentative", notes = "法定代表人")
   @JsonProperty("legalRepresentative")
   @JSONField(name = "legalRepresentative")
   @TableField("legal_representative")
   @Column(name = "legal_representative")
   private String legalRepresentative;
   @ApiModelProperty(name = "registeredCapital", notes = "注册资本")
   @JsonProperty("registeredCapital")
   @JSONField(name = "registeredCapital")
   @TableField("registered_capital")
   @Column(name = "registered_capital")
   private String registeredCapital;
   @ApiModelProperty(name = "enterpriseType", notes = "企业类型")
   @JsonProperty("enterpriseType")
   @JSONField(name = "enterpriseType")
   @TableField("enterprise_type")
   @Column(name = "enterprise_type")
   private String enterpriseType;
   @ApiModelProperty(name = "bankName", notes = "开户行名称")
   @JsonProperty("bankName")
   @JSONField(name = "bankName")
   @TableField("bank_name")
   @Column(name = "bank_name")
   private String bankName;
   @ApiModelProperty(name = "bankAccount", notes = "银行账户")
   @JsonProperty("bankAccount")
   @JSONField(name = "bankAccount")
   @TableField("bank_account")
   @Column(name = "bank_account")
   private String bankAccount;
   @ApiModelProperty(name = "website", notes = "公司官网")
   @JsonProperty("website")
   @JSONField(name = "website")
   @TableField("website")
   @Column(name = "website")
   private String website;
   @ApiModelProperty(name = "companyEmail", notes = "单位邮箱")
   @JsonProperty("companyEmail")
   @JSONField(name = "companyEmail")
   @TableField("company_email")
   @Column(name = "company_email")
   private String companyEmail;
   @ApiModelProperty(name = "companyPhone", notes = "公司电话")
   @JsonProperty("companyPhone")
   @JSONField(name = "companyPhone")
   @TableField("company_phone")
   @Column(name = "company_phone")
   private String companyPhone;
   @ApiModelProperty(name = "mainBusiness", notes = "主营业务")
   @JsonProperty("mainBusiness")
   @JSONField(name = "mainBusiness")
   @TableField("main_business")
   @Column(name = "main_business")
   private String mainBusiness;
   @ApiModelProperty(name = "attachments", notes = "附件ID集")
   @JsonProperty("attachments")
   @JSONField(name = "attachments")
   @TableField(value = "attachments", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachments")
   private String attachments;
   @ApiModelProperty(name = "boolHide", notes = "是否隐藏,[0 不隐藏,1 隐藏]")
   @JsonProperty("boolHide")
   @JSONField(name = "boolHide")
   @TableField("bool_hide")
   @Column(name = "bool_hide")
   private Boolean boolHide;
   @ApiModelProperty(name = "supplierClassification", notes = "供应商分类")
   @JsonProperty("supplierClassification")
   @JSONField(name = "supplierClassification")
   @TableField("supplier_classification")
   @Column(name = "supplier_classification")
   private Integer supplierClassification;
   @ApiModelProperty(name = "createSource", notes = "创建来源")
   @JsonProperty("createSource")
   @JSONField(name = "createSource")
   @TableField("create_source")
   @Column(name = "create_source")
   private Integer createSource;
   @ApiModelProperty(name = "boolPersonalEnum", value = "是否个人  ", notes = "是否个人 ")
   @JsonProperty("boolPersonalEnum")
   @JSONField(name = "boolPersonalEnum")
   @TableField("bool_personal_enum")
   @Column(name = "bool_personal_enum", columnDefinition = "tinyint(1) default '0'  COMMENT '是否个人'", nullable = false)
   private Boolean boolPersonalEnum;
   @ApiModelProperty(name = "classifyId", value = "分类id", notes = "分类id")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '分类id'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "qualificationsId", value = "资质id", notes = "资质id")
   @TableField("qualifications_id")
   @Column(name = "qualifications_id", columnDefinition = "bigint  COMMENT '资质id'", nullable = true)
   private Long qualificationsId;
   @ApiModelProperty(name = "boolAnnualEvaluated", value = "今年是否已评价", notes = "今年是否已评价")
   @TableField("bool_annual_evaluated")
   @Column(name = "bool_annual_evaluated", columnDefinition = "tinyint(1) default '0'  COMMENT '今年是否已评价'", nullable = false)
   private Boolean boolAnnualEvaluated;

   public static Supplier.SupplierBuilder builder() {
      return new Supplier.SupplierBuilder();
   }

   public Supplier() {
   }

   public Supplier(
      final Long id,
      final String name,
      final String shortName,
      final String supplierNumber,
      final Long countryId,
      final Long provinceId,
      final Long cityId,
      final Long regionId,
      final String address,
      final String socialCode,
      final LocalDate registrationDate,
      final String businessTerm,
      final String legalRepresentative,
      final String registeredCapital,
      final String enterpriseType,
      final String bankName,
      final String bankAccount,
      final String website,
      final String companyEmail,
      final String companyPhone,
      final String mainBusiness,
      final String attachments,
      final Boolean boolHide,
      final Integer supplierClassification,
      final Integer createSource,
      final Boolean boolPersonalEnum,
      final Long classifyId,
      final Long qualificationsId,
      final Boolean boolAnnualEvaluated
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.supplierNumber = supplierNumber;
      this.countryId = countryId;
      this.provinceId = provinceId;
      this.cityId = cityId;
      this.regionId = regionId;
      this.address = address;
      this.socialCode = socialCode;
      this.registrationDate = registrationDate;
      this.businessTerm = businessTerm;
      this.legalRepresentative = legalRepresentative;
      this.registeredCapital = registeredCapital;
      this.enterpriseType = enterpriseType;
      this.bankName = bankName;
      this.bankAccount = bankAccount;
      this.website = website;
      this.companyEmail = companyEmail;
      this.companyPhone = companyPhone;
      this.mainBusiness = mainBusiness;
      this.attachments = attachments;
      this.boolHide = boolHide;
      this.supplierClassification = supplierClassification;
      this.createSource = createSource;
      this.boolPersonalEnum = boolPersonalEnum;
      this.classifyId = classifyId;
      this.qualificationsId = qualificationsId;
      this.boolAnnualEvaluated = boolAnnualEvaluated;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSupplierNumber() {
      return this.supplierNumber;
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

   public String getSocialCode() {
      return this.socialCode;
   }

   public LocalDate getRegistrationDate() {
      return this.registrationDate;
   }

   public String getBusinessTerm() {
      return this.businessTerm;
   }

   public String getLegalRepresentative() {
      return this.legalRepresentative;
   }

   public String getRegisteredCapital() {
      return this.registeredCapital;
   }

   public String getEnterpriseType() {
      return this.enterpriseType;
   }

   public String getBankName() {
      return this.bankName;
   }

   public String getBankAccount() {
      return this.bankAccount;
   }

   public String getWebsite() {
      return this.website;
   }

   public String getCompanyEmail() {
      return this.companyEmail;
   }

   public String getCompanyPhone() {
      return this.companyPhone;
   }

   public String getMainBusiness() {
      return this.mainBusiness;
   }

   public String getAttachments() {
      return this.attachments;
   }

   public Boolean getBoolHide() {
      return this.boolHide;
   }

   public Integer getSupplierClassification() {
      return this.supplierClassification;
   }

   public Integer getCreateSource() {
      return this.createSource;
   }

   public Boolean getBoolPersonalEnum() {
      return this.boolPersonalEnum;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Long getQualificationsId() {
      return this.qualificationsId;
   }

   public Boolean getBoolAnnualEvaluated() {
      return this.boolAnnualEvaluated;
   }

   @JsonProperty("id")
   public Supplier setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public Supplier setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("shortName")
   public Supplier setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("supplierNumber")
   public Supplier setSupplierNumber(final String supplierNumber) {
      this.supplierNumber = supplierNumber;
      return this;
   }

   @JsonProperty("countryId")
   public Supplier setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   @JsonProperty("provinceId")
   public Supplier setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   @JsonProperty("cityId")
   public Supplier setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   @JsonProperty("regionId")
   public Supplier setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   @JsonProperty("address")
   public Supplier setAddress(final String address) {
      this.address = address;
      return this;
   }

   @JsonProperty("socialCode")
   public Supplier setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
      return this;
   }

   @JsonProperty("registrationDate")
   public Supplier setRegistrationDate(final LocalDate registrationDate) {
      this.registrationDate = registrationDate;
      return this;
   }

   @JsonProperty("businessTerm")
   public Supplier setBusinessTerm(final String businessTerm) {
      this.businessTerm = businessTerm;
      return this;
   }

   @JsonProperty("legalRepresentative")
   public Supplier setLegalRepresentative(final String legalRepresentative) {
      this.legalRepresentative = legalRepresentative;
      return this;
   }

   @JsonProperty("registeredCapital")
   public Supplier setRegisteredCapital(final String registeredCapital) {
      this.registeredCapital = registeredCapital;
      return this;
   }

   @JsonProperty("enterpriseType")
   public Supplier setEnterpriseType(final String enterpriseType) {
      this.enterpriseType = enterpriseType;
      return this;
   }

   @JsonProperty("bankName")
   public Supplier setBankName(final String bankName) {
      this.bankName = bankName;
      return this;
   }

   @JsonProperty("bankAccount")
   public Supplier setBankAccount(final String bankAccount) {
      this.bankAccount = bankAccount;
      return this;
   }

   @JsonProperty("website")
   public Supplier setWebsite(final String website) {
      this.website = website;
      return this;
   }

   @JsonProperty("companyEmail")
   public Supplier setCompanyEmail(final String companyEmail) {
      this.companyEmail = companyEmail;
      return this;
   }

   @JsonProperty("companyPhone")
   public Supplier setCompanyPhone(final String companyPhone) {
      this.companyPhone = companyPhone;
      return this;
   }

   @JsonProperty("mainBusiness")
   public Supplier setMainBusiness(final String mainBusiness) {
      this.mainBusiness = mainBusiness;
      return this;
   }

   @JsonProperty("attachments")
   public Supplier setAttachments(final String attachments) {
      this.attachments = attachments;
      return this;
   }

   @JsonProperty("boolHide")
   public Supplier setBoolHide(final Boolean boolHide) {
      this.boolHide = boolHide;
      return this;
   }

   @JsonProperty("supplierClassification")
   public Supplier setSupplierClassification(final Integer supplierClassification) {
      this.supplierClassification = supplierClassification;
      return this;
   }

   @JsonProperty("createSource")
   public Supplier setCreateSource(final Integer createSource) {
      this.createSource = createSource;
      return this;
   }

   @JsonProperty("boolPersonalEnum")
   public Supplier setBoolPersonalEnum(final Boolean boolPersonalEnum) {
      this.boolPersonalEnum = boolPersonalEnum;
      return this;
   }

   public Supplier setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   public Supplier setQualificationsId(final Long qualificationsId) {
      this.qualificationsId = qualificationsId;
      return this;
   }

   public Supplier setBoolAnnualEvaluated(final Boolean boolAnnualEvaluated) {
      this.boolAnnualEvaluated = boolAnnualEvaluated;
      return this;
   }

   @Override
   public String toString() {
      return "Supplier(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", supplierNumber="
         + this.getSupplierNumber()
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
         + ", socialCode="
         + this.getSocialCode()
         + ", registrationDate="
         + this.getRegistrationDate()
         + ", businessTerm="
         + this.getBusinessTerm()
         + ", legalRepresentative="
         + this.getLegalRepresentative()
         + ", registeredCapital="
         + this.getRegisteredCapital()
         + ", enterpriseType="
         + this.getEnterpriseType()
         + ", bankName="
         + this.getBankName()
         + ", bankAccount="
         + this.getBankAccount()
         + ", website="
         + this.getWebsite()
         + ", companyEmail="
         + this.getCompanyEmail()
         + ", companyPhone="
         + this.getCompanyPhone()
         + ", mainBusiness="
         + this.getMainBusiness()
         + ", attachments="
         + this.getAttachments()
         + ", boolHide="
         + this.getBoolHide()
         + ", supplierClassification="
         + this.getSupplierClassification()
         + ", createSource="
         + this.getCreateSource()
         + ", boolPersonalEnum="
         + this.getBoolPersonalEnum()
         + ", classifyId="
         + this.getClassifyId()
         + ", qualificationsId="
         + this.getQualificationsId()
         + ", boolAnnualEvaluated="
         + this.getBoolAnnualEvaluated()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Supplier)) {
         return false;
      }

      Supplier other = (Supplier)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
                     Object this$boolHide = this.getBoolHide();
                     Object other$boolHide = other.getBoolHide();
                     if (this$boolHide == null ? other$boolHide == null : this$boolHide.equals(other$boolHide)) {
                        Object this$supplierClassification = this.getSupplierClassification();
                        Object other$supplierClassification = other.getSupplierClassification();
                        if (this$supplierClassification == null
                           ? other$supplierClassification == null
                           : this$supplierClassification.equals(other$supplierClassification)) {
                           Object this$createSource = this.getCreateSource();
                           Object other$createSource = other.getCreateSource();
                           if (this$createSource == null ? other$createSource == null : this$createSource.equals(other$createSource)) {
                              Object this$boolPersonalEnum = this.getBoolPersonalEnum();
                              Object other$boolPersonalEnum = other.getBoolPersonalEnum();
                              if (this$boolPersonalEnum == null ? other$boolPersonalEnum == null : this$boolPersonalEnum.equals(other$boolPersonalEnum)) {
                                 Object this$classifyId = this.getClassifyId();
                                 Object other$classifyId = other.getClassifyId();
                                 if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                    Object this$qualificationsId = this.getQualificationsId();
                                    Object other$qualificationsId = other.getQualificationsId();
                                    if (this$qualificationsId == null ? other$qualificationsId == null : this$qualificationsId.equals(other$qualificationsId)) {
                                       Object this$boolAnnualEvaluated = this.getBoolAnnualEvaluated();
                                       Object other$boolAnnualEvaluated = other.getBoolAnnualEvaluated();
                                       if (this$boolAnnualEvaluated == null
                                          ? other$boolAnnualEvaluated == null
                                          : this$boolAnnualEvaluated.equals(other$boolAnnualEvaluated)) {
                                          Object this$name = this.getName();
                                          Object other$name = other.getName();
                                          if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                             Object this$shortName = this.getShortName();
                                             Object other$shortName = other.getShortName();
                                             if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                                Object this$supplierNumber = this.getSupplierNumber();
                                                Object other$supplierNumber = other.getSupplierNumber();
                                                if (this$supplierNumber == null
                                                   ? other$supplierNumber == null
                                                   : this$supplierNumber.equals(other$supplierNumber)) {
                                                   Object this$address = this.getAddress();
                                                   Object other$address = other.getAddress();
                                                   if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                      Object this$socialCode = this.getSocialCode();
                                                      Object other$socialCode = other.getSocialCode();
                                                      if (this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode)) {
                                                         Object this$registrationDate = this.getRegistrationDate();
                                                         Object other$registrationDate = other.getRegistrationDate();
                                                         if (this$registrationDate == null
                                                            ? other$registrationDate == null
                                                            : this$registrationDate.equals(other$registrationDate)) {
                                                            Object this$businessTerm = this.getBusinessTerm();
                                                            Object other$businessTerm = other.getBusinessTerm();
                                                            if (this$businessTerm == null
                                                               ? other$businessTerm == null
                                                               : this$businessTerm.equals(other$businessTerm)) {
                                                               Object this$legalRepresentative = this.getLegalRepresentative();
                                                               Object other$legalRepresentative = other.getLegalRepresentative();
                                                               if (this$legalRepresentative == null
                                                                  ? other$legalRepresentative == null
                                                                  : this$legalRepresentative.equals(other$legalRepresentative)) {
                                                                  Object this$registeredCapital = this.getRegisteredCapital();
                                                                  Object other$registeredCapital = other.getRegisteredCapital();
                                                                  if (this$registeredCapital == null
                                                                     ? other$registeredCapital == null
                                                                     : this$registeredCapital.equals(other$registeredCapital)) {
                                                                     Object this$enterpriseType = this.getEnterpriseType();
                                                                     Object other$enterpriseType = other.getEnterpriseType();
                                                                     if (this$enterpriseType == null
                                                                        ? other$enterpriseType == null
                                                                        : this$enterpriseType.equals(other$enterpriseType)) {
                                                                        Object this$bankName = this.getBankName();
                                                                        Object other$bankName = other.getBankName();
                                                                        if (this$bankName == null
                                                                           ? other$bankName == null
                                                                           : this$bankName.equals(other$bankName)) {
                                                                           Object this$bankAccount = this.getBankAccount();
                                                                           Object other$bankAccount = other.getBankAccount();
                                                                           if (this$bankAccount == null
                                                                              ? other$bankAccount == null
                                                                              : this$bankAccount.equals(other$bankAccount)) {
                                                                              Object this$website = this.getWebsite();
                                                                              Object other$website = other.getWebsite();
                                                                              if (this$website == null
                                                                                 ? other$website == null
                                                                                 : this$website.equals(other$website)) {
                                                                                 Object this$companyEmail = this.getCompanyEmail();
                                                                                 Object other$companyEmail = other.getCompanyEmail();
                                                                                 if (this$companyEmail == null
                                                                                    ? other$companyEmail == null
                                                                                    : this$companyEmail.equals(other$companyEmail)) {
                                                                                    Object this$companyPhone = this.getCompanyPhone();
                                                                                    Object other$companyPhone = other.getCompanyPhone();
                                                                                    if (this$companyPhone == null
                                                                                       ? other$companyPhone == null
                                                                                       : this$companyPhone.equals(other$companyPhone)) {
                                                                                       Object this$mainBusiness = this.getMainBusiness();
                                                                                       Object other$mainBusiness = other.getMainBusiness();
                                                                                       if (this$mainBusiness == null
                                                                                          ? other$mainBusiness == null
                                                                                          : this$mainBusiness.equals(other$mainBusiness)) {
                                                                                          Object this$attachments = this.getAttachments();
                                                                                          Object other$attachments = other.getAttachments();
                                                                                          return this$attachments == null
                                                                                             ? other$attachments == null
                                                                                             : this$attachments.equals(other$attachments);
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof Supplier;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $boolHide = this.getBoolHide();
      result = result * 59 + ($boolHide == null ? 43 : $boolHide.hashCode());
      Object $supplierClassification = this.getSupplierClassification();
      result = result * 59 + ($supplierClassification == null ? 43 : $supplierClassification.hashCode());
      Object $createSource = this.getCreateSource();
      result = result * 59 + ($createSource == null ? 43 : $createSource.hashCode());
      Object $boolPersonalEnum = this.getBoolPersonalEnum();
      result = result * 59 + ($boolPersonalEnum == null ? 43 : $boolPersonalEnum.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $qualificationsId = this.getQualificationsId();
      result = result * 59 + ($qualificationsId == null ? 43 : $qualificationsId.hashCode());
      Object $boolAnnualEvaluated = this.getBoolAnnualEvaluated();
      result = result * 59 + ($boolAnnualEvaluated == null ? 43 : $boolAnnualEvaluated.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $supplierNumber = this.getSupplierNumber();
      result = result * 59 + ($supplierNumber == null ? 43 : $supplierNumber.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $socialCode = this.getSocialCode();
      result = result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
      Object $registrationDate = this.getRegistrationDate();
      result = result * 59 + ($registrationDate == null ? 43 : $registrationDate.hashCode());
      Object $businessTerm = this.getBusinessTerm();
      result = result * 59 + ($businessTerm == null ? 43 : $businessTerm.hashCode());
      Object $legalRepresentative = this.getLegalRepresentative();
      result = result * 59 + ($legalRepresentative == null ? 43 : $legalRepresentative.hashCode());
      Object $registeredCapital = this.getRegisteredCapital();
      result = result * 59 + ($registeredCapital == null ? 43 : $registeredCapital.hashCode());
      Object $enterpriseType = this.getEnterpriseType();
      result = result * 59 + ($enterpriseType == null ? 43 : $enterpriseType.hashCode());
      Object $bankName = this.getBankName();
      result = result * 59 + ($bankName == null ? 43 : $bankName.hashCode());
      Object $bankAccount = this.getBankAccount();
      result = result * 59 + ($bankAccount == null ? 43 : $bankAccount.hashCode());
      Object $website = this.getWebsite();
      result = result * 59 + ($website == null ? 43 : $website.hashCode());
      Object $companyEmail = this.getCompanyEmail();
      result = result * 59 + ($companyEmail == null ? 43 : $companyEmail.hashCode());
      Object $companyPhone = this.getCompanyPhone();
      result = result * 59 + ($companyPhone == null ? 43 : $companyPhone.hashCode());
      Object $mainBusiness = this.getMainBusiness();
      result = result * 59 + ($mainBusiness == null ? 43 : $mainBusiness.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   public static class SupplierBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String supplierNumber;
      private Long countryId;
      private Long provinceId;
      private Long cityId;
      private Long regionId;
      private String address;
      private String socialCode;
      private LocalDate registrationDate;
      private String businessTerm;
      private String legalRepresentative;
      private String registeredCapital;
      private String enterpriseType;
      private String bankName;
      private String bankAccount;
      private String website;
      private String companyEmail;
      private String companyPhone;
      private String mainBusiness;
      private String attachments;
      private Boolean boolHide;
      private Integer supplierClassification;
      private Integer createSource;
      private Boolean boolPersonalEnum;
      private Long classifyId;
      private Long qualificationsId;
      private Boolean boolAnnualEvaluated;

      SupplierBuilder() {
      }

      @JsonProperty("id")
      public Supplier.SupplierBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public Supplier.SupplierBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public Supplier.SupplierBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("supplierNumber")
      public Supplier.SupplierBuilder supplierNumber(final String supplierNumber) {
         this.supplierNumber = supplierNumber;
         return this;
      }

      @JsonProperty("countryId")
      public Supplier.SupplierBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      @JsonProperty("provinceId")
      public Supplier.SupplierBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      @JsonProperty("cityId")
      public Supplier.SupplierBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      @JsonProperty("regionId")
      public Supplier.SupplierBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      @JsonProperty("address")
      public Supplier.SupplierBuilder address(final String address) {
         this.address = address;
         return this;
      }

      @JsonProperty("socialCode")
      public Supplier.SupplierBuilder socialCode(final String socialCode) {
         this.socialCode = socialCode;
         return this;
      }

      @JsonProperty("registrationDate")
      public Supplier.SupplierBuilder registrationDate(final LocalDate registrationDate) {
         this.registrationDate = registrationDate;
         return this;
      }

      @JsonProperty("businessTerm")
      public Supplier.SupplierBuilder businessTerm(final String businessTerm) {
         this.businessTerm = businessTerm;
         return this;
      }

      @JsonProperty("legalRepresentative")
      public Supplier.SupplierBuilder legalRepresentative(final String legalRepresentative) {
         this.legalRepresentative = legalRepresentative;
         return this;
      }

      @JsonProperty("registeredCapital")
      public Supplier.SupplierBuilder registeredCapital(final String registeredCapital) {
         this.registeredCapital = registeredCapital;
         return this;
      }

      @JsonProperty("enterpriseType")
      public Supplier.SupplierBuilder enterpriseType(final String enterpriseType) {
         this.enterpriseType = enterpriseType;
         return this;
      }

      @JsonProperty("bankName")
      public Supplier.SupplierBuilder bankName(final String bankName) {
         this.bankName = bankName;
         return this;
      }

      @JsonProperty("bankAccount")
      public Supplier.SupplierBuilder bankAccount(final String bankAccount) {
         this.bankAccount = bankAccount;
         return this;
      }

      @JsonProperty("website")
      public Supplier.SupplierBuilder website(final String website) {
         this.website = website;
         return this;
      }

      @JsonProperty("companyEmail")
      public Supplier.SupplierBuilder companyEmail(final String companyEmail) {
         this.companyEmail = companyEmail;
         return this;
      }

      @JsonProperty("companyPhone")
      public Supplier.SupplierBuilder companyPhone(final String companyPhone) {
         this.companyPhone = companyPhone;
         return this;
      }

      @JsonProperty("mainBusiness")
      public Supplier.SupplierBuilder mainBusiness(final String mainBusiness) {
         this.mainBusiness = mainBusiness;
         return this;
      }

      @JsonProperty("attachments")
      public Supplier.SupplierBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      @JsonProperty("boolHide")
      public Supplier.SupplierBuilder boolHide(final Boolean boolHide) {
         this.boolHide = boolHide;
         return this;
      }

      @JsonProperty("supplierClassification")
      public Supplier.SupplierBuilder supplierClassification(final Integer supplierClassification) {
         this.supplierClassification = supplierClassification;
         return this;
      }

      @JsonProperty("createSource")
      public Supplier.SupplierBuilder createSource(final Integer createSource) {
         this.createSource = createSource;
         return this;
      }

      @JsonProperty("boolPersonalEnum")
      public Supplier.SupplierBuilder boolPersonalEnum(final Boolean boolPersonalEnum) {
         this.boolPersonalEnum = boolPersonalEnum;
         return this;
      }

      public Supplier.SupplierBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public Supplier.SupplierBuilder qualificationsId(final Long qualificationsId) {
         this.qualificationsId = qualificationsId;
         return this;
      }

      public Supplier.SupplierBuilder boolAnnualEvaluated(final Boolean boolAnnualEvaluated) {
         this.boolAnnualEvaluated = boolAnnualEvaluated;
         return this;
      }

      public Supplier build() {
         return new Supplier(
            this.id,
            this.name,
            this.shortName,
            this.supplierNumber,
            this.countryId,
            this.provinceId,
            this.cityId,
            this.regionId,
            this.address,
            this.socialCode,
            this.registrationDate,
            this.businessTerm,
            this.legalRepresentative,
            this.registeredCapital,
            this.enterpriseType,
            this.bankName,
            this.bankAccount,
            this.website,
            this.companyEmail,
            this.companyPhone,
            this.mainBusiness,
            this.attachments,
            this.boolHide,
            this.supplierClassification,
            this.createSource,
            this.boolPersonalEnum,
            this.classifyId,
            this.qualificationsId,
            this.boolAnnualEvaluated
         );
      }

      @Override
      public String toString() {
         return "Supplier.SupplierBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", supplierNumber="
            + this.supplierNumber
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
            + ", socialCode="
            + this.socialCode
            + ", registrationDate="
            + this.registrationDate
            + ", businessTerm="
            + this.businessTerm
            + ", legalRepresentative="
            + this.legalRepresentative
            + ", registeredCapital="
            + this.registeredCapital
            + ", enterpriseType="
            + this.enterpriseType
            + ", bankName="
            + this.bankName
            + ", bankAccount="
            + this.bankAccount
            + ", website="
            + this.website
            + ", companyEmail="
            + this.companyEmail
            + ", companyPhone="
            + this.companyPhone
            + ", mainBusiness="
            + this.mainBusiness
            + ", attachments="
            + this.attachments
            + ", boolHide="
            + this.boolHide
            + ", supplierClassification="
            + this.supplierClassification
            + ", createSource="
            + this.createSource
            + ", boolPersonalEnum="
            + this.boolPersonalEnum
            + ", classifyId="
            + this.classifyId
            + ", qualificationsId="
            + this.qualificationsId
            + ", boolAnnualEvaluated="
            + this.boolAnnualEvaluated
            + ")";
      }
   }
}

package com.hzchum.scim.bid.core.api.pojo._do;

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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "招标列表", description = "")
@TableName("project_tendering")
@Table(name = "project_tendering")
public class ProjectTendering extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "创建人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name")
   private String userName;
   @ApiModelProperty(name = "name", value = "招标项目名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "projectType", value = "项目类型(一级科目id)")
   @JsonProperty("projectType")
   @JSONField(name = "projectType")
   @TableField("project_type")
   @Column(name = "project_type")
   private Integer projectType;
   @ApiModelProperty(name = "contractNo", value = "项目编号")
   @JsonProperty("contractNo")
   @JSONField(name = "contractNo")
   @TableField("contract_no")
   @Column(name = "contract_no")
   private String contractNo;
   @ApiModelProperty(name = "biddingType", value = "招采方式")
   @JsonProperty("biddingType")
   @JSONField(name = "biddingType")
   @TableField("bidding_type")
   @Column(name = "bidding_type")
   private Integer biddingType;
   @ApiModelProperty(name = "cashDeposit", value = "保证金")
   @JsonProperty("cashDeposit")
   @JSONField(name = "cashDeposit")
   @TableField("cash_deposit")
   @Column(name = "cash_deposit")
   private BigDecimal cashDeposit;
   @ApiModelProperty(name = "isCashDeposit", value = "是否需要保证金")
   @JsonProperty("isCashDeposit")
   @JSONField(name = "isCashDeposit")
   @TableField("is_cash_deposit")
   @Column(name = "is_cash_deposit")
   private Integer isCashDeposit;
   @ApiModelProperty(name = "bankAccountName", value = "保证金账户户名")
   @JsonProperty("bankAccountName")
   @JSONField(name = "bankAccountName")
   @TableField("bank_account_name")
   @Column(name = "bank_account_name")
   private String bankAccountName;
   @ApiModelProperty(name = "bankAccount", value = "保证金账户账号")
   @JsonProperty("bankAccount")
   @JSONField(name = "bankAccount")
   @TableField("bank_account")
   @Column(name = "bank_account")
   private String bankAccount;
   @ApiModelProperty(name = "depositBank", value = "保证金账户开户行")
   @JsonProperty("depositBank")
   @JSONField(name = "depositBank")
   @TableField("deposit_bank")
   @Column(name = "deposit_bank")
   private String depositBank;
   @ApiModelProperty(name = "companyName", value = "招标单位名称")
   @JsonProperty("companyName")
   @JSONField(name = "companyName")
   @TableField("company_name")
   @Column(name = "company_name")
   private String companyName;
   @ApiModelProperty(name = "verifierId", value = "审核人id")
   @JsonProperty("verifierId")
   @JSONField(name = "verifierId")
   @TableField("verifier_id")
   @Column(name = "verifier_id")
   private Long verifierId;
   @ApiModelProperty(name = "verifierName", value = "审核人名称")
   @JsonProperty("verifierName")
   @JSONField(name = "verifierName")
   @TableField("verifier_name")
   @Column(name = "verifier_name")
   private Long verifierName;
   @ApiModelProperty(name = "verifierTime", value = "审核日期")
   @JsonProperty("verifierTime")
   @JSONField(name = "verifierTime")
   @TableField("verifier_time")
   @Column(name = "verifier_time")
   private Date verifierTime;
   @ApiModelProperty(name = "status", value = "项目状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int default 0")
   private Integer status;
   @ApiModelProperty(name = "projectProgress", value = "项目进度")
   @JsonProperty("projectProgress")
   @JSONField(name = "projectProgress")
   @TableField("project_progress")
   @Column(name = "project_progress", columnDefinition = "int default 0")
   private Integer projectProgress;
   @ApiModelProperty(name = "contactPerson", value = "联系人")
   @JsonProperty("contactPerson")
   @JSONField(name = "contactPerson")
   @TableField("contact_person")
   @Column(name = "contact_person")
   private String contactPerson;
   @ApiModelProperty(name = "phone", value = "联系人电话")
   @JsonProperty("phone")
   @JSONField(name = "phone")
   @TableField("phone")
   @Column(name = "phone")
   private String phone;
   @ApiModelProperty(name = "deliveryAddress", value = "交货地点")
   @JsonProperty("deliveryAddress")
   @JSONField(name = "deliveryAddress")
   @TableField("delivery_address")
   @Column(name = "delivery_address")
   private String deliveryAddress;
   @ApiModelProperty(name = "deliveryTime", value = "交货时间")
   @JsonProperty("deliveryTime")
   @JSONField(name = "deliveryTime")
   @TableField("delivery_time")
   @Column(name = "delivery_time")
   private Date deliveryTime;
   @ApiModelProperty(name = "deliveryType", value = "交货交货方式时间")
   @JsonProperty("deliveryType")
   @JSONField(name = "deliveryType")
   @TableField("delivery_type")
   @Column(name = "delivery_type")
   private Integer deliveryType;
   @ApiModelProperty(name = "invoiceType", value = "发票类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type")
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "发票税点")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate")
   private Double taxRate;
   @ApiModelProperty(name = "invitingNum", value = "邀请单位数量")
   @JsonProperty("invitingNum")
   @JSONField(name = "invitingNum")
   @TableField("inviting_num")
   @Column(name = "inviting_num", columnDefinition = "int default 0")
   private Integer invitingNum;
   @ApiModelProperty(name = "isOpen", value = "是否已开标")
   @JsonProperty("isOpen")
   @JSONField(name = "isOpen")
   @TableField("is_open")
   @Column(name = "is_open", columnDefinition = "int default 0")
   private Integer isOpen;
   @ApiModelProperty(name = "remark", value = "项目描述")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "UUID", value = "系统唯一id")
   @JsonProperty("UUID")
   @JSONField(name = "UUID")
   @TableField("UUID")
   @Column(name = "UUID")
   private String UUID;
   @ApiModelProperty(name = "tenderValue", value = "招标公告内容(txt格式)")
   @JsonProperty("tenderValue")
   @JSONField(name = "tenderValue")
   @TableField("tender_value")
   @Column(name = "tender_value", columnDefinition = "txt")
   private String tenderValue;

   public static ProjectTendering.ProjectTenderingBuilder builder() {
      return new ProjectTendering.ProjectTenderingBuilder();
   }

   public ProjectTendering() {
   }

   public ProjectTendering(
      final Long id,
      final Long userId,
      final String userName,
      final String name,
      final Integer projectType,
      final String contractNo,
      final Integer biddingType,
      final BigDecimal cashDeposit,
      final Integer isCashDeposit,
      final String bankAccountName,
      final String bankAccount,
      final String depositBank,
      final String companyName,
      final Long verifierId,
      final Long verifierName,
      final Date verifierTime,
      final Integer status,
      final Integer projectProgress,
      final String contactPerson,
      final String phone,
      final String deliveryAddress,
      final Date deliveryTime,
      final Integer deliveryType,
      final Integer invoiceType,
      final Double taxRate,
      final Integer invitingNum,
      final Integer isOpen,
      final String remark,
      final String UUID,
      final String tenderValue
   ) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.name = name;
      this.projectType = projectType;
      this.contractNo = contractNo;
      this.biddingType = biddingType;
      this.cashDeposit = cashDeposit;
      this.isCashDeposit = isCashDeposit;
      this.bankAccountName = bankAccountName;
      this.bankAccount = bankAccount;
      this.depositBank = depositBank;
      this.companyName = companyName;
      this.verifierId = verifierId;
      this.verifierName = verifierName;
      this.verifierTime = verifierTime;
      this.status = status;
      this.projectProgress = projectProgress;
      this.contactPerson = contactPerson;
      this.phone = phone;
      this.deliveryAddress = deliveryAddress;
      this.deliveryTime = deliveryTime;
      this.deliveryType = deliveryType;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.invitingNum = invitingNum;
      this.isOpen = isOpen;
      this.remark = remark;
      this.UUID = UUID;
      this.tenderValue = tenderValue;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public String getContractNo() {
      return this.contractNo;
   }

   public Integer getBiddingType() {
      return this.biddingType;
   }

   public BigDecimal getCashDeposit() {
      return this.cashDeposit;
   }

   public Integer getIsCashDeposit() {
      return this.isCashDeposit;
   }

   public String getBankAccountName() {
      return this.bankAccountName;
   }

   public String getBankAccount() {
      return this.bankAccount;
   }

   public String getDepositBank() {
      return this.depositBank;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public Long getVerifierId() {
      return this.verifierId;
   }

   public Long getVerifierName() {
      return this.verifierName;
   }

   public Date getVerifierTime() {
      return this.verifierTime;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getProjectProgress() {
      return this.projectProgress;
   }

   public String getContactPerson() {
      return this.contactPerson;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getDeliveryAddress() {
      return this.deliveryAddress;
   }

   public Date getDeliveryTime() {
      return this.deliveryTime;
   }

   public Integer getDeliveryType() {
      return this.deliveryType;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Double getTaxRate() {
      return this.taxRate;
   }

   public Integer getInvitingNum() {
      return this.invitingNum;
   }

   public Integer getIsOpen() {
      return this.isOpen;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getUUID() {
      return this.UUID;
   }

   public String getTenderValue() {
      return this.tenderValue;
   }

   @JsonProperty("id")
   public ProjectTendering setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("userId")
   public ProjectTendering setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public ProjectTendering setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("name")
   public ProjectTendering setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("projectType")
   public ProjectTendering setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   @JsonProperty("contractNo")
   public ProjectTendering setContractNo(final String contractNo) {
      this.contractNo = contractNo;
      return this;
   }

   @JsonProperty("biddingType")
   public ProjectTendering setBiddingType(final Integer biddingType) {
      this.biddingType = biddingType;
      return this;
   }

   @JsonProperty("cashDeposit")
   public ProjectTendering setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
      return this;
   }

   @JsonProperty("isCashDeposit")
   public ProjectTendering setIsCashDeposit(final Integer isCashDeposit) {
      this.isCashDeposit = isCashDeposit;
      return this;
   }

   @JsonProperty("bankAccountName")
   public ProjectTendering setBankAccountName(final String bankAccountName) {
      this.bankAccountName = bankAccountName;
      return this;
   }

   @JsonProperty("bankAccount")
   public ProjectTendering setBankAccount(final String bankAccount) {
      this.bankAccount = bankAccount;
      return this;
   }

   @JsonProperty("depositBank")
   public ProjectTendering setDepositBank(final String depositBank) {
      this.depositBank = depositBank;
      return this;
   }

   @JsonProperty("companyName")
   public ProjectTendering setCompanyName(final String companyName) {
      this.companyName = companyName;
      return this;
   }

   @JsonProperty("verifierId")
   public ProjectTendering setVerifierId(final Long verifierId) {
      this.verifierId = verifierId;
      return this;
   }

   @JsonProperty("verifierName")
   public ProjectTendering setVerifierName(final Long verifierName) {
      this.verifierName = verifierName;
      return this;
   }

   @JsonProperty("verifierTime")
   public ProjectTendering setVerifierTime(final Date verifierTime) {
      this.verifierTime = verifierTime;
      return this;
   }

   @JsonProperty("status")
   public ProjectTendering setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("projectProgress")
   public ProjectTendering setProjectProgress(final Integer projectProgress) {
      this.projectProgress = projectProgress;
      return this;
   }

   @JsonProperty("contactPerson")
   public ProjectTendering setContactPerson(final String contactPerson) {
      this.contactPerson = contactPerson;
      return this;
   }

   @JsonProperty("phone")
   public ProjectTendering setPhone(final String phone) {
      this.phone = phone;
      return this;
   }

   @JsonProperty("deliveryAddress")
   public ProjectTendering setDeliveryAddress(final String deliveryAddress) {
      this.deliveryAddress = deliveryAddress;
      return this;
   }

   @JsonProperty("deliveryTime")
   public ProjectTendering setDeliveryTime(final Date deliveryTime) {
      this.deliveryTime = deliveryTime;
      return this;
   }

   @JsonProperty("deliveryType")
   public ProjectTendering setDeliveryType(final Integer deliveryType) {
      this.deliveryType = deliveryType;
      return this;
   }

   @JsonProperty("invoiceType")
   public ProjectTendering setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("taxRate")
   public ProjectTendering setTaxRate(final Double taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("invitingNum")
   public ProjectTendering setInvitingNum(final Integer invitingNum) {
      this.invitingNum = invitingNum;
      return this;
   }

   @JsonProperty("isOpen")
   public ProjectTendering setIsOpen(final Integer isOpen) {
      this.isOpen = isOpen;
      return this;
   }

   @JsonProperty("remark")
   public ProjectTendering setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("UUID")
   public ProjectTendering setUUID(final String UUID) {
      this.UUID = UUID;
      return this;
   }

   @JsonProperty("tenderValue")
   public ProjectTendering setTenderValue(final String tenderValue) {
      this.tenderValue = tenderValue;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectTendering(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", name="
         + this.getName()
         + ", projectType="
         + this.getProjectType()
         + ", contractNo="
         + this.getContractNo()
         + ", biddingType="
         + this.getBiddingType()
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", isCashDeposit="
         + this.getIsCashDeposit()
         + ", bankAccountName="
         + this.getBankAccountName()
         + ", bankAccount="
         + this.getBankAccount()
         + ", depositBank="
         + this.getDepositBank()
         + ", companyName="
         + this.getCompanyName()
         + ", verifierId="
         + this.getVerifierId()
         + ", verifierName="
         + this.getVerifierName()
         + ", verifierTime="
         + this.getVerifierTime()
         + ", status="
         + this.getStatus()
         + ", projectProgress="
         + this.getProjectProgress()
         + ", contactPerson="
         + this.getContactPerson()
         + ", phone="
         + this.getPhone()
         + ", deliveryAddress="
         + this.getDeliveryAddress()
         + ", deliveryTime="
         + this.getDeliveryTime()
         + ", deliveryType="
         + this.getDeliveryType()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", invitingNum="
         + this.getInvitingNum()
         + ", isOpen="
         + this.getIsOpen()
         + ", remark="
         + this.getRemark()
         + ", UUID="
         + this.getUUID()
         + ", tenderValue="
         + this.getTenderValue()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectTendering)) {
         return false;
      }

      ProjectTendering other = (ProjectTendering)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$projectType = this.getProjectType();
            Object other$projectType = other.getProjectType();
            if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
               Object this$biddingType = this.getBiddingType();
               Object other$biddingType = other.getBiddingType();
               if (this$biddingType == null ? other$biddingType == null : this$biddingType.equals(other$biddingType)) {
                  Object this$isCashDeposit = this.getIsCashDeposit();
                  Object other$isCashDeposit = other.getIsCashDeposit();
                  if (this$isCashDeposit == null ? other$isCashDeposit == null : this$isCashDeposit.equals(other$isCashDeposit)) {
                     Object this$verifierId = this.getVerifierId();
                     Object other$verifierId = other.getVerifierId();
                     if (this$verifierId == null ? other$verifierId == null : this$verifierId.equals(other$verifierId)) {
                        Object this$verifierName = this.getVerifierName();
                        Object other$verifierName = other.getVerifierName();
                        if (this$verifierName == null ? other$verifierName == null : this$verifierName.equals(other$verifierName)) {
                           Object this$status = this.getStatus();
                           Object other$status = other.getStatus();
                           if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                              Object this$projectProgress = this.getProjectProgress();
                              Object other$projectProgress = other.getProjectProgress();
                              if (this$projectProgress == null ? other$projectProgress == null : this$projectProgress.equals(other$projectProgress)) {
                                 Object this$deliveryType = this.getDeliveryType();
                                 Object other$deliveryType = other.getDeliveryType();
                                 if (this$deliveryType == null ? other$deliveryType == null : this$deliveryType.equals(other$deliveryType)) {
                                    Object this$invoiceType = this.getInvoiceType();
                                    Object other$invoiceType = other.getInvoiceType();
                                    if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                       Object this$taxRate = this.getTaxRate();
                                       Object other$taxRate = other.getTaxRate();
                                       if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                          Object this$invitingNum = this.getInvitingNum();
                                          Object other$invitingNum = other.getInvitingNum();
                                          if (this$invitingNum == null ? other$invitingNum == null : this$invitingNum.equals(other$invitingNum)) {
                                             Object this$isOpen = this.getIsOpen();
                                             Object other$isOpen = other.getIsOpen();
                                             if (this$isOpen == null ? other$isOpen == null : this$isOpen.equals(other$isOpen)) {
                                                Object this$userName = this.getUserName();
                                                Object other$userName = other.getUserName();
                                                if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                   Object this$name = this.getName();
                                                   Object other$name = other.getName();
                                                   if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                      Object this$contractNo = this.getContractNo();
                                                      Object other$contractNo = other.getContractNo();
                                                      if (this$contractNo == null ? other$contractNo == null : this$contractNo.equals(other$contractNo)) {
                                                         Object this$cashDeposit = this.getCashDeposit();
                                                         Object other$cashDeposit = other.getCashDeposit();
                                                         if (this$cashDeposit == null ? other$cashDeposit == null : this$cashDeposit.equals(other$cashDeposit)) {
                                                            Object this$bankAccountName = this.getBankAccountName();
                                                            Object other$bankAccountName = other.getBankAccountName();
                                                            if (this$bankAccountName == null
                                                               ? other$bankAccountName == null
                                                               : this$bankAccountName.equals(other$bankAccountName)) {
                                                               Object this$bankAccount = this.getBankAccount();
                                                               Object other$bankAccount = other.getBankAccount();
                                                               if (this$bankAccount == null
                                                                  ? other$bankAccount == null
                                                                  : this$bankAccount.equals(other$bankAccount)) {
                                                                  Object this$depositBank = this.getDepositBank();
                                                                  Object other$depositBank = other.getDepositBank();
                                                                  if (this$depositBank == null
                                                                     ? other$depositBank == null
                                                                     : this$depositBank.equals(other$depositBank)) {
                                                                     Object this$companyName = this.getCompanyName();
                                                                     Object other$companyName = other.getCompanyName();
                                                                     if (this$companyName == null
                                                                        ? other$companyName == null
                                                                        : this$companyName.equals(other$companyName)) {
                                                                        Object this$verifierTime = this.getVerifierTime();
                                                                        Object other$verifierTime = other.getVerifierTime();
                                                                        if (this$verifierTime == null
                                                                           ? other$verifierTime == null
                                                                           : this$verifierTime.equals(other$verifierTime)) {
                                                                           Object this$contactPerson = this.getContactPerson();
                                                                           Object other$contactPerson = other.getContactPerson();
                                                                           if (this$contactPerson == null
                                                                              ? other$contactPerson == null
                                                                              : this$contactPerson.equals(other$contactPerson)) {
                                                                              Object this$phone = this.getPhone();
                                                                              Object other$phone = other.getPhone();
                                                                              if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                                                                                 Object this$deliveryAddress = this.getDeliveryAddress();
                                                                                 Object other$deliveryAddress = other.getDeliveryAddress();
                                                                                 if (this$deliveryAddress == null
                                                                                    ? other$deliveryAddress == null
                                                                                    : this$deliveryAddress.equals(other$deliveryAddress)) {
                                                                                    Object this$deliveryTime = this.getDeliveryTime();
                                                                                    Object other$deliveryTime = other.getDeliveryTime();
                                                                                    if (this$deliveryTime == null
                                                                                       ? other$deliveryTime == null
                                                                                       : this$deliveryTime.equals(other$deliveryTime)) {
                                                                                       Object this$remark = this.getRemark();
                                                                                       Object other$remark = other.getRemark();
                                                                                       if (this$remark == null
                                                                                          ? other$remark == null
                                                                                          : this$remark.equals(other$remark)) {
                                                                                          Object this$UUID = this.getUUID();
                                                                                          Object other$UUID = other.getUUID();
                                                                                          if (this$UUID == null
                                                                                             ? other$UUID == null
                                                                                             : this$UUID.equals(other$UUID)) {
                                                                                             Object this$tenderValue = this.getTenderValue();
                                                                                             Object other$tenderValue = other.getTenderValue();
                                                                                             return this$tenderValue == null
                                                                                                ? other$tenderValue == null
                                                                                                : this$tenderValue.equals(other$tenderValue);
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof ProjectTendering;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $biddingType = this.getBiddingType();
      result = result * 59 + ($biddingType == null ? 43 : $biddingType.hashCode());
      Object $isCashDeposit = this.getIsCashDeposit();
      result = result * 59 + ($isCashDeposit == null ? 43 : $isCashDeposit.hashCode());
      Object $verifierId = this.getVerifierId();
      result = result * 59 + ($verifierId == null ? 43 : $verifierId.hashCode());
      Object $verifierName = this.getVerifierName();
      result = result * 59 + ($verifierName == null ? 43 : $verifierName.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $projectProgress = this.getProjectProgress();
      result = result * 59 + ($projectProgress == null ? 43 : $projectProgress.hashCode());
      Object $deliveryType = this.getDeliveryType();
      result = result * 59 + ($deliveryType == null ? 43 : $deliveryType.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $invitingNum = this.getInvitingNum();
      result = result * 59 + ($invitingNum == null ? 43 : $invitingNum.hashCode());
      Object $isOpen = this.getIsOpen();
      result = result * 59 + ($isOpen == null ? 43 : $isOpen.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $contractNo = this.getContractNo();
      result = result * 59 + ($contractNo == null ? 43 : $contractNo.hashCode());
      Object $cashDeposit = this.getCashDeposit();
      result = result * 59 + ($cashDeposit == null ? 43 : $cashDeposit.hashCode());
      Object $bankAccountName = this.getBankAccountName();
      result = result * 59 + ($bankAccountName == null ? 43 : $bankAccountName.hashCode());
      Object $bankAccount = this.getBankAccount();
      result = result * 59 + ($bankAccount == null ? 43 : $bankAccount.hashCode());
      Object $depositBank = this.getDepositBank();
      result = result * 59 + ($depositBank == null ? 43 : $depositBank.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $verifierTime = this.getVerifierTime();
      result = result * 59 + ($verifierTime == null ? 43 : $verifierTime.hashCode());
      Object $contactPerson = this.getContactPerson();
      result = result * 59 + ($contactPerson == null ? 43 : $contactPerson.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $deliveryAddress = this.getDeliveryAddress();
      result = result * 59 + ($deliveryAddress == null ? 43 : $deliveryAddress.hashCode());
      Object $deliveryTime = this.getDeliveryTime();
      result = result * 59 + ($deliveryTime == null ? 43 : $deliveryTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $UUID = this.getUUID();
      result = result * 59 + ($UUID == null ? 43 : $UUID.hashCode());
      Object $tenderValue = this.getTenderValue();
      return result * 59 + ($tenderValue == null ? 43 : $tenderValue.hashCode());
   }

   public static class ProjectTenderingBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private String name;
      private Integer projectType;
      private String contractNo;
      private Integer biddingType;
      private BigDecimal cashDeposit;
      private Integer isCashDeposit;
      private String bankAccountName;
      private String bankAccount;
      private String depositBank;
      private String companyName;
      private Long verifierId;
      private Long verifierName;
      private Date verifierTime;
      private Integer status;
      private Integer projectProgress;
      private String contactPerson;
      private String phone;
      private String deliveryAddress;
      private Date deliveryTime;
      private Integer deliveryType;
      private Integer invoiceType;
      private Double taxRate;
      private Integer invitingNum;
      private Integer isOpen;
      private String remark;
      private String UUID;
      private String tenderValue;

      ProjectTenderingBuilder() {
      }

      @JsonProperty("id")
      public ProjectTendering.ProjectTenderingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("userId")
      public ProjectTendering.ProjectTenderingBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public ProjectTendering.ProjectTenderingBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("name")
      public ProjectTendering.ProjectTenderingBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("projectType")
      public ProjectTendering.ProjectTenderingBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      @JsonProperty("contractNo")
      public ProjectTendering.ProjectTenderingBuilder contractNo(final String contractNo) {
         this.contractNo = contractNo;
         return this;
      }

      @JsonProperty("biddingType")
      public ProjectTendering.ProjectTenderingBuilder biddingType(final Integer biddingType) {
         this.biddingType = biddingType;
         return this;
      }

      @JsonProperty("cashDeposit")
      public ProjectTendering.ProjectTenderingBuilder cashDeposit(final BigDecimal cashDeposit) {
         this.cashDeposit = cashDeposit;
         return this;
      }

      @JsonProperty("isCashDeposit")
      public ProjectTendering.ProjectTenderingBuilder isCashDeposit(final Integer isCashDeposit) {
         this.isCashDeposit = isCashDeposit;
         return this;
      }

      @JsonProperty("bankAccountName")
      public ProjectTendering.ProjectTenderingBuilder bankAccountName(final String bankAccountName) {
         this.bankAccountName = bankAccountName;
         return this;
      }

      @JsonProperty("bankAccount")
      public ProjectTendering.ProjectTenderingBuilder bankAccount(final String bankAccount) {
         this.bankAccount = bankAccount;
         return this;
      }

      @JsonProperty("depositBank")
      public ProjectTendering.ProjectTenderingBuilder depositBank(final String depositBank) {
         this.depositBank = depositBank;
         return this;
      }

      @JsonProperty("companyName")
      public ProjectTendering.ProjectTenderingBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      @JsonProperty("verifierId")
      public ProjectTendering.ProjectTenderingBuilder verifierId(final Long verifierId) {
         this.verifierId = verifierId;
         return this;
      }

      @JsonProperty("verifierName")
      public ProjectTendering.ProjectTenderingBuilder verifierName(final Long verifierName) {
         this.verifierName = verifierName;
         return this;
      }

      @JsonProperty("verifierTime")
      public ProjectTendering.ProjectTenderingBuilder verifierTime(final Date verifierTime) {
         this.verifierTime = verifierTime;
         return this;
      }

      @JsonProperty("status")
      public ProjectTendering.ProjectTenderingBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("projectProgress")
      public ProjectTendering.ProjectTenderingBuilder projectProgress(final Integer projectProgress) {
         this.projectProgress = projectProgress;
         return this;
      }

      @JsonProperty("contactPerson")
      public ProjectTendering.ProjectTenderingBuilder contactPerson(final String contactPerson) {
         this.contactPerson = contactPerson;
         return this;
      }

      @JsonProperty("phone")
      public ProjectTendering.ProjectTenderingBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      @JsonProperty("deliveryAddress")
      public ProjectTendering.ProjectTenderingBuilder deliveryAddress(final String deliveryAddress) {
         this.deliveryAddress = deliveryAddress;
         return this;
      }

      @JsonProperty("deliveryTime")
      public ProjectTendering.ProjectTenderingBuilder deliveryTime(final Date deliveryTime) {
         this.deliveryTime = deliveryTime;
         return this;
      }

      @JsonProperty("deliveryType")
      public ProjectTendering.ProjectTenderingBuilder deliveryType(final Integer deliveryType) {
         this.deliveryType = deliveryType;
         return this;
      }

      @JsonProperty("invoiceType")
      public ProjectTendering.ProjectTenderingBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("taxRate")
      public ProjectTendering.ProjectTenderingBuilder taxRate(final Double taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("invitingNum")
      public ProjectTendering.ProjectTenderingBuilder invitingNum(final Integer invitingNum) {
         this.invitingNum = invitingNum;
         return this;
      }

      @JsonProperty("isOpen")
      public ProjectTendering.ProjectTenderingBuilder isOpen(final Integer isOpen) {
         this.isOpen = isOpen;
         return this;
      }

      @JsonProperty("remark")
      public ProjectTendering.ProjectTenderingBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("UUID")
      public ProjectTendering.ProjectTenderingBuilder UUID(final String UUID) {
         this.UUID = UUID;
         return this;
      }

      @JsonProperty("tenderValue")
      public ProjectTendering.ProjectTenderingBuilder tenderValue(final String tenderValue) {
         this.tenderValue = tenderValue;
         return this;
      }

      public ProjectTendering build() {
         return new ProjectTendering(
            this.id,
            this.userId,
            this.userName,
            this.name,
            this.projectType,
            this.contractNo,
            this.biddingType,
            this.cashDeposit,
            this.isCashDeposit,
            this.bankAccountName,
            this.bankAccount,
            this.depositBank,
            this.companyName,
            this.verifierId,
            this.verifierName,
            this.verifierTime,
            this.status,
            this.projectProgress,
            this.contactPerson,
            this.phone,
            this.deliveryAddress,
            this.deliveryTime,
            this.deliveryType,
            this.invoiceType,
            this.taxRate,
            this.invitingNum,
            this.isOpen,
            this.remark,
            this.UUID,
            this.tenderValue
         );
      }

      @Override
      public String toString() {
         return "ProjectTendering.ProjectTenderingBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", name="
            + this.name
            + ", projectType="
            + this.projectType
            + ", contractNo="
            + this.contractNo
            + ", biddingType="
            + this.biddingType
            + ", cashDeposit="
            + this.cashDeposit
            + ", isCashDeposit="
            + this.isCashDeposit
            + ", bankAccountName="
            + this.bankAccountName
            + ", bankAccount="
            + this.bankAccount
            + ", depositBank="
            + this.depositBank
            + ", companyName="
            + this.companyName
            + ", verifierId="
            + this.verifierId
            + ", verifierName="
            + this.verifierName
            + ", verifierTime="
            + this.verifierTime
            + ", status="
            + this.status
            + ", projectProgress="
            + this.projectProgress
            + ", contactPerson="
            + this.contactPerson
            + ", phone="
            + this.phone
            + ", deliveryAddress="
            + this.deliveryAddress
            + ", deliveryTime="
            + this.deliveryTime
            + ", deliveryType="
            + this.deliveryType
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", invitingNum="
            + this.invitingNum
            + ", isOpen="
            + this.isOpen
            + ", remark="
            + this.remark
            + ", UUID="
            + this.UUID
            + ", tenderValue="
            + this.tenderValue
            + ")";
      }
   }
}

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractReimbursement对象", description = "报销表")
@Entity
@TableName("contract_reimbursement")
@Table(name = "contract_reimbursement")
public class ContractReimbursement extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   @TableField("project_name")
   @Column(name = "project_name")
   private String projectName;
   @ApiModelProperty(name = "applyAmount", value = "申请金额")
   @JsonProperty("applyAmount")
   @JSONField(name = "applyAmount")
   @TableField("apply_amount")
   @Column(name = "apply_amount")
   private BigDecimal applyAmount;
   @ApiModelProperty(name = "actuallyPayAmount", value = "实付金额")
   @JsonProperty("actuallyPayAmount")
   @JSONField(name = "actuallyPayAmount")
   @TableField("actually_pay_amount")
   @Column(name = "actually_pay_amount")
   private BigDecimal actuallyPayAmount;
   @ApiModelProperty(name = "applyDepartId", value = "申请人部门id")
   @JsonProperty("applyDepartId")
   @JSONField(name = "applyDepartId")
   @TableField("apply_depart_id")
   @Column(name = "apply_depart_id")
   private Long applyDepartId;
   @ApiModelProperty(name = "applyDepartName", value = "申请部门名称")
   @JsonProperty("applyDepartName")
   @JSONField(name = "applyDepartName")
   @TableField("apply_depart_name")
   @Column(name = "apply_depart_name")
   private String applyDepartName;
   @ApiModelProperty(name = "applyDate", value = "申请日期")
   @JsonProperty("applyDate")
   @JSONField(name = "applyDate")
   @TableField("apply_date")
   @Column(name = "apply_date")
   private LocalDate applyDate;
   @ApiModelProperty(name = "applyUserId", value = "申请人id")
   @JsonProperty("applyUserId")
   @JSONField(name = "applyUserId")
   @TableField("apply_user_id")
   @Column(name = "apply_user_id")
   private Long applyUserId;
   @ApiModelProperty(name = "applyUserName", value = "申请人名字")
   @JsonProperty("applyUserName")
   @JSONField(name = "applyUserName")
   @TableField("apply_user_name")
   @Column(name = "apply_user_name")
   private String applyUserName;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款开户行")
   @JsonProperty("collectionDepositBank")
   @JSONField(name = "collectionDepositBank")
   @TableField("collection_deposit_bank")
   @Column(name = "collection_deposit_bank")
   private String collectionDepositBank;
   @ApiModelProperty(name = "collectionBankAccount", value = "收款银行账号")
   @JsonProperty("collectionBankAccount")
   @JSONField(name = "collectionBankAccount")
   @TableField("collection_bank_account")
   @Column(name = "collection_bank_account")
   private String collectionBankAccount;
   @ApiModelProperty(name = "collectionUserId", value = "收款人id (默认是申请人)")
   @JsonProperty("collectionUserId")
   @JSONField(name = "collectionUserId")
   @TableField("collection_user_id")
   @Column(name = "collection_user_id")
   private Long collectionUserId;
   @ApiModelProperty(name = "collectionUserName", value = "收款人名字")
   @JsonProperty("collectionUserName")
   @JSONField(name = "collectionUserName")
   @TableField("collection_user_name")
   @Column(name = "collection_user_name")
   private String collectionUserName;
   @ApiModelProperty(name = "writtenById", value = "填报人id")
   @JsonProperty("writtenById")
   @JSONField(name = "writtenById")
   @TableField("written_by_id")
   @Column(name = "written_by_id")
   private Long writtenById;
   @ApiModelProperty(name = "writtenByName", value = "填报人名字")
   @JsonProperty("writtenByName")
   @JSONField(name = "writtenByName")
   @TableField("written_by_name")
   @Column(name = "written_by_name")
   private String writtenByName;
   @ApiModelProperty(name = "confirmUserId", value = "确认人id")
   @JsonProperty("confirmUserId")
   @JSONField(name = "confirmUserId")
   @TableField("confirm_user_id")
   @Column(name = "confirm_user_id")
   private Long confirmUserId;
   @ApiModelProperty(name = "confirmUserName", value = "确认人名字")
   @JsonProperty("confirmUserName")
   @JSONField(name = "confirmUserName")
   @TableField("confirm_user_name")
   @Column(name = "confirm_user_name")
   private String confirmUserName;
   @ApiModelProperty(name = "confirmTime", value = "确认时间")
   @JsonProperty("confirmTime")
   @JSONField(name = "confirmTime")
   @TableField("confirm_time")
   @Column(name = "confirm_time")
   private LocalDateTime confirmTime;
   @ApiModelProperty(name = "confirmStatus", value = "确认状态 1确认中 2已确认 4已退回")
   @JsonProperty("confirmStatus")
   @JSONField(name = "confirmStatus")
   @TableField("confirm_status")
   @Column(name = "confirm_status")
   private Integer confirmStatus;
   @ApiModelProperty(name = "lastEditorUserId", value = "最后编辑人id")
   @JsonProperty("lastEditorUserId")
   @JSONField(name = "lastEditorUserId")
   @TableField("last_editor_user_id")
   @Column(name = "last_editor_user_id")
   private Long lastEditorUserId;
   @ApiModelProperty(name = "paymentUnitId", value = "付款单位id")
   @JsonProperty("paymentUnitId")
   @JSONField(name = "paymentUnitId")
   @TableField("payment_unit_id")
   @Column(name = "payment_unit_id")
   private Long paymentUnitId;
   @ApiModelProperty(name = "paymentUnit", value = "付款单位")
   @JsonProperty("paymentUnit")
   @JSONField(name = "paymentUnit")
   @TableField("payment_unit")
   @Column(name = "payment_unit")
   private String paymentUnit;
   @ApiModelProperty(name = "paymentDepositBank", value = "付款开户行")
   @JsonProperty("paymentDepositBank")
   @JSONField(name = "paymentDepositBank")
   @TableField("payment_deposit_bank")
   @Column(name = "payment_deposit_bank")
   private String paymentDepositBank;
   @ApiModelProperty(name = "paymentBankAccount", value = "付款账号")
   @JsonProperty("paymentBankAccount")
   @JSONField(name = "paymentBankAccount")
   @TableField("payment_bank_account")
   @Column(name = "payment_bank_account")
   private String paymentBankAccount;
   @ApiModelProperty(name = "source", value = "来源 1当前系统 2钉钉")
   @JsonProperty("source")
   @JSONField(name = "source")
   @TableField("source")
   @Column(name = "source")
   private Integer source;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;

   public static ContractReimbursement.ContractReimbursementBuilder builder() {
      return new ContractReimbursement.ContractReimbursementBuilder();
   }

   public ContractReimbursement() {
   }

   public ContractReimbursement(
      final Long id,
      final Long projectId,
      final String projectName,
      final BigDecimal applyAmount,
      final BigDecimal actuallyPayAmount,
      final Long applyDepartId,
      final String applyDepartName,
      final LocalDate applyDate,
      final Long applyUserId,
      final String applyUserName,
      final String collectionDepositBank,
      final String collectionBankAccount,
      final Long collectionUserId,
      final String collectionUserName,
      final Long writtenById,
      final String writtenByName,
      final Long confirmUserId,
      final String confirmUserName,
      final LocalDateTime confirmTime,
      final Integer confirmStatus,
      final Long lastEditorUserId,
      final Long paymentUnitId,
      final String paymentUnit,
      final String paymentDepositBank,
      final String paymentBankAccount,
      final Integer source,
      final String remark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.projectName = projectName;
      this.applyAmount = applyAmount;
      this.actuallyPayAmount = actuallyPayAmount;
      this.applyDepartId = applyDepartId;
      this.applyDepartName = applyDepartName;
      this.applyDate = applyDate;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.collectionDepositBank = collectionDepositBank;
      this.collectionBankAccount = collectionBankAccount;
      this.collectionUserId = collectionUserId;
      this.collectionUserName = collectionUserName;
      this.writtenById = writtenById;
      this.writtenByName = writtenByName;
      this.confirmUserId = confirmUserId;
      this.confirmUserName = confirmUserName;
      this.confirmTime = confirmTime;
      this.confirmStatus = confirmStatus;
      this.lastEditorUserId = lastEditorUserId;
      this.paymentUnitId = paymentUnitId;
      this.paymentUnit = paymentUnit;
      this.paymentDepositBank = paymentDepositBank;
      this.paymentBankAccount = paymentBankAccount;
      this.source = source;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public BigDecimal getActuallyPayAmount() {
      return this.actuallyPayAmount;
   }

   public Long getApplyDepartId() {
      return this.applyDepartId;
   }

   public String getApplyDepartName() {
      return this.applyDepartName;
   }

   public LocalDate getApplyDate() {
      return this.applyDate;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public String getCollectionBankAccount() {
      return this.collectionBankAccount;
   }

   public Long getCollectionUserId() {
      return this.collectionUserId;
   }

   public String getCollectionUserName() {
      return this.collectionUserName;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public String getWrittenByName() {
      return this.writtenByName;
   }

   public Long getConfirmUserId() {
      return this.confirmUserId;
   }

   public String getConfirmUserName() {
      return this.confirmUserName;
   }

   public LocalDateTime getConfirmTime() {
      return this.confirmTime;
   }

   public Integer getConfirmStatus() {
      return this.confirmStatus;
   }

   public Long getLastEditorUserId() {
      return this.lastEditorUserId;
   }

   public Long getPaymentUnitId() {
      return this.paymentUnitId;
   }

   public String getPaymentUnit() {
      return this.paymentUnit;
   }

   public String getPaymentDepositBank() {
      return this.paymentDepositBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public Integer getSource() {
      return this.source;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public ContractReimbursement setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ContractReimbursement setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("projectName")
   public ContractReimbursement setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("applyAmount")
   public ContractReimbursement setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
      return this;
   }

   @JsonProperty("actuallyPayAmount")
   public ContractReimbursement setActuallyPayAmount(final BigDecimal actuallyPayAmount) {
      this.actuallyPayAmount = actuallyPayAmount;
      return this;
   }

   @JsonProperty("applyDepartId")
   public ContractReimbursement setApplyDepartId(final Long applyDepartId) {
      this.applyDepartId = applyDepartId;
      return this;
   }

   @JsonProperty("applyDepartName")
   public ContractReimbursement setApplyDepartName(final String applyDepartName) {
      this.applyDepartName = applyDepartName;
      return this;
   }

   @JsonProperty("applyDate")
   public ContractReimbursement setApplyDate(final LocalDate applyDate) {
      this.applyDate = applyDate;
      return this;
   }

   @JsonProperty("applyUserId")
   public ContractReimbursement setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
      return this;
   }

   @JsonProperty("applyUserName")
   public ContractReimbursement setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
      return this;
   }

   @JsonProperty("collectionDepositBank")
   public ContractReimbursement setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
      return this;
   }

   @JsonProperty("collectionBankAccount")
   public ContractReimbursement setCollectionBankAccount(final String collectionBankAccount) {
      this.collectionBankAccount = collectionBankAccount;
      return this;
   }

   @JsonProperty("collectionUserId")
   public ContractReimbursement setCollectionUserId(final Long collectionUserId) {
      this.collectionUserId = collectionUserId;
      return this;
   }

   @JsonProperty("collectionUserName")
   public ContractReimbursement setCollectionUserName(final String collectionUserName) {
      this.collectionUserName = collectionUserName;
      return this;
   }

   @JsonProperty("writtenById")
   public ContractReimbursement setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
      return this;
   }

   @JsonProperty("writtenByName")
   public ContractReimbursement setWrittenByName(final String writtenByName) {
      this.writtenByName = writtenByName;
      return this;
   }

   @JsonProperty("confirmUserId")
   public ContractReimbursement setConfirmUserId(final Long confirmUserId) {
      this.confirmUserId = confirmUserId;
      return this;
   }

   @JsonProperty("confirmUserName")
   public ContractReimbursement setConfirmUserName(final String confirmUserName) {
      this.confirmUserName = confirmUserName;
      return this;
   }

   @JsonProperty("confirmTime")
   public ContractReimbursement setConfirmTime(final LocalDateTime confirmTime) {
      this.confirmTime = confirmTime;
      return this;
   }

   @JsonProperty("confirmStatus")
   public ContractReimbursement setConfirmStatus(final Integer confirmStatus) {
      this.confirmStatus = confirmStatus;
      return this;
   }

   @JsonProperty("lastEditorUserId")
   public ContractReimbursement setLastEditorUserId(final Long lastEditorUserId) {
      this.lastEditorUserId = lastEditorUserId;
      return this;
   }

   @JsonProperty("paymentUnitId")
   public ContractReimbursement setPaymentUnitId(final Long paymentUnitId) {
      this.paymentUnitId = paymentUnitId;
      return this;
   }

   @JsonProperty("paymentUnit")
   public ContractReimbursement setPaymentUnit(final String paymentUnit) {
      this.paymentUnit = paymentUnit;
      return this;
   }

   @JsonProperty("paymentDepositBank")
   public ContractReimbursement setPaymentDepositBank(final String paymentDepositBank) {
      this.paymentDepositBank = paymentDepositBank;
      return this;
   }

   @JsonProperty("paymentBankAccount")
   public ContractReimbursement setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
      return this;
   }

   @JsonProperty("source")
   public ContractReimbursement setSource(final Integer source) {
      this.source = source;
      return this;
   }

   @JsonProperty("remark")
   public ContractReimbursement setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "ContractReimbursement(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", actuallyPayAmount="
         + this.getActuallyPayAmount()
         + ", applyDepartId="
         + this.getApplyDepartId()
         + ", applyDepartName="
         + this.getApplyDepartName()
         + ", applyDate="
         + this.getApplyDate()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", collectionBankAccount="
         + this.getCollectionBankAccount()
         + ", collectionUserId="
         + this.getCollectionUserId()
         + ", collectionUserName="
         + this.getCollectionUserName()
         + ", writtenById="
         + this.getWrittenById()
         + ", writtenByName="
         + this.getWrittenByName()
         + ", confirmUserId="
         + this.getConfirmUserId()
         + ", confirmUserName="
         + this.getConfirmUserName()
         + ", confirmTime="
         + this.getConfirmTime()
         + ", confirmStatus="
         + this.getConfirmStatus()
         + ", lastEditorUserId="
         + this.getLastEditorUserId()
         + ", paymentUnitId="
         + this.getPaymentUnitId()
         + ", paymentUnit="
         + this.getPaymentUnit()
         + ", paymentDepositBank="
         + this.getPaymentDepositBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", source="
         + this.getSource()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractReimbursement)) {
         return false;
      }

      ContractReimbursement other = (ContractReimbursement)o;
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
            Object this$applyDepartId = this.getApplyDepartId();
            Object other$applyDepartId = other.getApplyDepartId();
            if (this$applyDepartId == null ? other$applyDepartId == null : this$applyDepartId.equals(other$applyDepartId)) {
               Object this$applyUserId = this.getApplyUserId();
               Object other$applyUserId = other.getApplyUserId();
               if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                  Object this$collectionUserId = this.getCollectionUserId();
                  Object other$collectionUserId = other.getCollectionUserId();
                  if (this$collectionUserId == null ? other$collectionUserId == null : this$collectionUserId.equals(other$collectionUserId)) {
                     Object this$writtenById = this.getWrittenById();
                     Object other$writtenById = other.getWrittenById();
                     if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                        Object this$confirmUserId = this.getConfirmUserId();
                        Object other$confirmUserId = other.getConfirmUserId();
                        if (this$confirmUserId == null ? other$confirmUserId == null : this$confirmUserId.equals(other$confirmUserId)) {
                           Object this$confirmStatus = this.getConfirmStatus();
                           Object other$confirmStatus = other.getConfirmStatus();
                           if (this$confirmStatus == null ? other$confirmStatus == null : this$confirmStatus.equals(other$confirmStatus)) {
                              Object this$lastEditorUserId = this.getLastEditorUserId();
                              Object other$lastEditorUserId = other.getLastEditorUserId();
                              if (this$lastEditorUserId == null ? other$lastEditorUserId == null : this$lastEditorUserId.equals(other$lastEditorUserId)) {
                                 Object this$paymentUnitId = this.getPaymentUnitId();
                                 Object other$paymentUnitId = other.getPaymentUnitId();
                                 if (this$paymentUnitId == null ? other$paymentUnitId == null : this$paymentUnitId.equals(other$paymentUnitId)) {
                                    Object this$source = this.getSource();
                                    Object other$source = other.getSource();
                                    if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                                       Object this$projectName = this.getProjectName();
                                       Object other$projectName = other.getProjectName();
                                       if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                          Object this$applyAmount = this.getApplyAmount();
                                          Object other$applyAmount = other.getApplyAmount();
                                          if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
                                             Object this$actuallyPayAmount = this.getActuallyPayAmount();
                                             Object other$actuallyPayAmount = other.getActuallyPayAmount();
                                             if (this$actuallyPayAmount == null
                                                ? other$actuallyPayAmount == null
                                                : this$actuallyPayAmount.equals(other$actuallyPayAmount)) {
                                                Object this$applyDepartName = this.getApplyDepartName();
                                                Object other$applyDepartName = other.getApplyDepartName();
                                                if (this$applyDepartName == null
                                                   ? other$applyDepartName == null
                                                   : this$applyDepartName.equals(other$applyDepartName)) {
                                                   Object this$applyDate = this.getApplyDate();
                                                   Object other$applyDate = other.getApplyDate();
                                                   if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
                                                      Object this$applyUserName = this.getApplyUserName();
                                                      Object other$applyUserName = other.getApplyUserName();
                                                      if (this$applyUserName == null
                                                         ? other$applyUserName == null
                                                         : this$applyUserName.equals(other$applyUserName)) {
                                                         Object this$collectionDepositBank = this.getCollectionDepositBank();
                                                         Object other$collectionDepositBank = other.getCollectionDepositBank();
                                                         if (this$collectionDepositBank == null
                                                            ? other$collectionDepositBank == null
                                                            : this$collectionDepositBank.equals(other$collectionDepositBank)) {
                                                            Object this$collectionBankAccount = this.getCollectionBankAccount();
                                                            Object other$collectionBankAccount = other.getCollectionBankAccount();
                                                            if (this$collectionBankAccount == null
                                                               ? other$collectionBankAccount == null
                                                               : this$collectionBankAccount.equals(other$collectionBankAccount)) {
                                                               Object this$collectionUserName = this.getCollectionUserName();
                                                               Object other$collectionUserName = other.getCollectionUserName();
                                                               if (this$collectionUserName == null
                                                                  ? other$collectionUserName == null
                                                                  : this$collectionUserName.equals(other$collectionUserName)) {
                                                                  Object this$writtenByName = this.getWrittenByName();
                                                                  Object other$writtenByName = other.getWrittenByName();
                                                                  if (this$writtenByName == null
                                                                     ? other$writtenByName == null
                                                                     : this$writtenByName.equals(other$writtenByName)) {
                                                                     Object this$confirmUserName = this.getConfirmUserName();
                                                                     Object other$confirmUserName = other.getConfirmUserName();
                                                                     if (this$confirmUserName == null
                                                                        ? other$confirmUserName == null
                                                                        : this$confirmUserName.equals(other$confirmUserName)) {
                                                                        Object this$confirmTime = this.getConfirmTime();
                                                                        Object other$confirmTime = other.getConfirmTime();
                                                                        if (this$confirmTime == null
                                                                           ? other$confirmTime == null
                                                                           : this$confirmTime.equals(other$confirmTime)) {
                                                                           Object this$paymentUnit = this.getPaymentUnit();
                                                                           Object other$paymentUnit = other.getPaymentUnit();
                                                                           if (this$paymentUnit == null
                                                                              ? other$paymentUnit == null
                                                                              : this$paymentUnit.equals(other$paymentUnit)) {
                                                                              Object this$paymentDepositBank = this.getPaymentDepositBank();
                                                                              Object other$paymentDepositBank = other.getPaymentDepositBank();
                                                                              if (this$paymentDepositBank == null
                                                                                 ? other$paymentDepositBank == null
                                                                                 : this$paymentDepositBank.equals(other$paymentDepositBank)) {
                                                                                 Object this$paymentBankAccount = this.getPaymentBankAccount();
                                                                                 Object other$paymentBankAccount = other.getPaymentBankAccount();
                                                                                 if (this$paymentBankAccount == null
                                                                                    ? other$paymentBankAccount == null
                                                                                    : this$paymentBankAccount.equals(other$paymentBankAccount)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractReimbursement;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $applyDepartId = this.getApplyDepartId();
      result = result * 59 + ($applyDepartId == null ? 43 : $applyDepartId.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $collectionUserId = this.getCollectionUserId();
      result = result * 59 + ($collectionUserId == null ? 43 : $collectionUserId.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $confirmUserId = this.getConfirmUserId();
      result = result * 59 + ($confirmUserId == null ? 43 : $confirmUserId.hashCode());
      Object $confirmStatus = this.getConfirmStatus();
      result = result * 59 + ($confirmStatus == null ? 43 : $confirmStatus.hashCode());
      Object $lastEditorUserId = this.getLastEditorUserId();
      result = result * 59 + ($lastEditorUserId == null ? 43 : $lastEditorUserId.hashCode());
      Object $paymentUnitId = this.getPaymentUnitId();
      result = result * 59 + ($paymentUnitId == null ? 43 : $paymentUnitId.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $actuallyPayAmount = this.getActuallyPayAmount();
      result = result * 59 + ($actuallyPayAmount == null ? 43 : $actuallyPayAmount.hashCode());
      Object $applyDepartName = this.getApplyDepartName();
      result = result * 59 + ($applyDepartName == null ? 43 : $applyDepartName.hashCode());
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $collectionBankAccount = this.getCollectionBankAccount();
      result = result * 59 + ($collectionBankAccount == null ? 43 : $collectionBankAccount.hashCode());
      Object $collectionUserName = this.getCollectionUserName();
      result = result * 59 + ($collectionUserName == null ? 43 : $collectionUserName.hashCode());
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $confirmUserName = this.getConfirmUserName();
      result = result * 59 + ($confirmUserName == null ? 43 : $confirmUserName.hashCode());
      Object $confirmTime = this.getConfirmTime();
      result = result * 59 + ($confirmTime == null ? 43 : $confirmTime.hashCode());
      Object $paymentUnit = this.getPaymentUnit();
      result = result * 59 + ($paymentUnit == null ? 43 : $paymentUnit.hashCode());
      Object $paymentDepositBank = this.getPaymentDepositBank();
      result = result * 59 + ($paymentDepositBank == null ? 43 : $paymentDepositBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ContractReimbursementBuilder {
      private Long id;
      private Long projectId;
      private String projectName;
      private BigDecimal applyAmount;
      private BigDecimal actuallyPayAmount;
      private Long applyDepartId;
      private String applyDepartName;
      private LocalDate applyDate;
      private Long applyUserId;
      private String applyUserName;
      private String collectionDepositBank;
      private String collectionBankAccount;
      private Long collectionUserId;
      private String collectionUserName;
      private Long writtenById;
      private String writtenByName;
      private Long confirmUserId;
      private String confirmUserName;
      private LocalDateTime confirmTime;
      private Integer confirmStatus;
      private Long lastEditorUserId;
      private Long paymentUnitId;
      private String paymentUnit;
      private String paymentDepositBank;
      private String paymentBankAccount;
      private Integer source;
      private String remark;

      ContractReimbursementBuilder() {
      }

      @JsonProperty("id")
      public ContractReimbursement.ContractReimbursementBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ContractReimbursement.ContractReimbursementBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("projectName")
      public ContractReimbursement.ContractReimbursementBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("applyAmount")
      public ContractReimbursement.ContractReimbursementBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      @JsonProperty("actuallyPayAmount")
      public ContractReimbursement.ContractReimbursementBuilder actuallyPayAmount(final BigDecimal actuallyPayAmount) {
         this.actuallyPayAmount = actuallyPayAmount;
         return this;
      }

      @JsonProperty("applyDepartId")
      public ContractReimbursement.ContractReimbursementBuilder applyDepartId(final Long applyDepartId) {
         this.applyDepartId = applyDepartId;
         return this;
      }

      @JsonProperty("applyDepartName")
      public ContractReimbursement.ContractReimbursementBuilder applyDepartName(final String applyDepartName) {
         this.applyDepartName = applyDepartName;
         return this;
      }

      @JsonProperty("applyDate")
      public ContractReimbursement.ContractReimbursementBuilder applyDate(final LocalDate applyDate) {
         this.applyDate = applyDate;
         return this;
      }

      @JsonProperty("applyUserId")
      public ContractReimbursement.ContractReimbursementBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      @JsonProperty("applyUserName")
      public ContractReimbursement.ContractReimbursementBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      @JsonProperty("collectionDepositBank")
      public ContractReimbursement.ContractReimbursementBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      @JsonProperty("collectionBankAccount")
      public ContractReimbursement.ContractReimbursementBuilder collectionBankAccount(final String collectionBankAccount) {
         this.collectionBankAccount = collectionBankAccount;
         return this;
      }

      @JsonProperty("collectionUserId")
      public ContractReimbursement.ContractReimbursementBuilder collectionUserId(final Long collectionUserId) {
         this.collectionUserId = collectionUserId;
         return this;
      }

      @JsonProperty("collectionUserName")
      public ContractReimbursement.ContractReimbursementBuilder collectionUserName(final String collectionUserName) {
         this.collectionUserName = collectionUserName;
         return this;
      }

      @JsonProperty("writtenById")
      public ContractReimbursement.ContractReimbursementBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      @JsonProperty("writtenByName")
      public ContractReimbursement.ContractReimbursementBuilder writtenByName(final String writtenByName) {
         this.writtenByName = writtenByName;
         return this;
      }

      @JsonProperty("confirmUserId")
      public ContractReimbursement.ContractReimbursementBuilder confirmUserId(final Long confirmUserId) {
         this.confirmUserId = confirmUserId;
         return this;
      }

      @JsonProperty("confirmUserName")
      public ContractReimbursement.ContractReimbursementBuilder confirmUserName(final String confirmUserName) {
         this.confirmUserName = confirmUserName;
         return this;
      }

      @JsonProperty("confirmTime")
      public ContractReimbursement.ContractReimbursementBuilder confirmTime(final LocalDateTime confirmTime) {
         this.confirmTime = confirmTime;
         return this;
      }

      @JsonProperty("confirmStatus")
      public ContractReimbursement.ContractReimbursementBuilder confirmStatus(final Integer confirmStatus) {
         this.confirmStatus = confirmStatus;
         return this;
      }

      @JsonProperty("lastEditorUserId")
      public ContractReimbursement.ContractReimbursementBuilder lastEditorUserId(final Long lastEditorUserId) {
         this.lastEditorUserId = lastEditorUserId;
         return this;
      }

      @JsonProperty("paymentUnitId")
      public ContractReimbursement.ContractReimbursementBuilder paymentUnitId(final Long paymentUnitId) {
         this.paymentUnitId = paymentUnitId;
         return this;
      }

      @JsonProperty("paymentUnit")
      public ContractReimbursement.ContractReimbursementBuilder paymentUnit(final String paymentUnit) {
         this.paymentUnit = paymentUnit;
         return this;
      }

      @JsonProperty("paymentDepositBank")
      public ContractReimbursement.ContractReimbursementBuilder paymentDepositBank(final String paymentDepositBank) {
         this.paymentDepositBank = paymentDepositBank;
         return this;
      }

      @JsonProperty("paymentBankAccount")
      public ContractReimbursement.ContractReimbursementBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      @JsonProperty("source")
      public ContractReimbursement.ContractReimbursementBuilder source(final Integer source) {
         this.source = source;
         return this;
      }

      @JsonProperty("remark")
      public ContractReimbursement.ContractReimbursementBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractReimbursement build() {
         return new ContractReimbursement(
            this.id,
            this.projectId,
            this.projectName,
            this.applyAmount,
            this.actuallyPayAmount,
            this.applyDepartId,
            this.applyDepartName,
            this.applyDate,
            this.applyUserId,
            this.applyUserName,
            this.collectionDepositBank,
            this.collectionBankAccount,
            this.collectionUserId,
            this.collectionUserName,
            this.writtenById,
            this.writtenByName,
            this.confirmUserId,
            this.confirmUserName,
            this.confirmTime,
            this.confirmStatus,
            this.lastEditorUserId,
            this.paymentUnitId,
            this.paymentUnit,
            this.paymentDepositBank,
            this.paymentBankAccount,
            this.source,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractReimbursement.ContractReimbursementBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", applyAmount="
            + this.applyAmount
            + ", actuallyPayAmount="
            + this.actuallyPayAmount
            + ", applyDepartId="
            + this.applyDepartId
            + ", applyDepartName="
            + this.applyDepartName
            + ", applyDate="
            + this.applyDate
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", collectionBankAccount="
            + this.collectionBankAccount
            + ", collectionUserId="
            + this.collectionUserId
            + ", collectionUserName="
            + this.collectionUserName
            + ", writtenById="
            + this.writtenById
            + ", writtenByName="
            + this.writtenByName
            + ", confirmUserId="
            + this.confirmUserId
            + ", confirmUserName="
            + this.confirmUserName
            + ", confirmTime="
            + this.confirmTime
            + ", confirmStatus="
            + this.confirmStatus
            + ", lastEditorUserId="
            + this.lastEditorUserId
            + ", paymentUnitId="
            + this.paymentUnitId
            + ", paymentUnit="
            + this.paymentUnit
            + ", paymentDepositBank="
            + this.paymentDepositBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", source="
            + this.source
            + ", remark="
            + this.remark
            + ")";
      }
   }
}

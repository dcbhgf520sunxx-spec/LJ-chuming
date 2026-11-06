package com.hzchum.scim.contract.core.api.pojo._do.finance;

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

@ApiModel(value = "ContractGivingCredit对象", description = "授信 ")
@Entity
@TableName("contract_giving_credit")
@Table(name = "contract_giving_credit")
@org.hibernate.annotations.Table(appliesTo = "contract_giving_credit", comment = "授信 ")
public class ContractGivingCredit extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "startDate", value = "授信开始时间", notes = "授信开始时间")
   @TableField("start_date")
   @Column(name = "start_date", columnDefinition = "datetime(6)  COMMENT '授信开始时间'", nullable = false)
   private LocalDateTime startDate;
   @ApiModelProperty(name = "closingDate", value = "有效截至日期", notes = "有效截至日期")
   @TableField("closing_date")
   @Column(name = "closing_date", columnDefinition = "datetime(6)  COMMENT '有效截至日期'", nullable = false)
   private LocalDateTime closingDate;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "constructionAgentId", value = "代建人", notes = "代建人")
   @TableField("construction_agent_id")
   @Column(name = "construction_agent_id", columnDefinition = "bigint(20)  COMMENT '代建人'", nullable = false)
   private Long constructionAgentId;
   @ApiModelProperty(name = "accreditingPartyId", value = "授信人员", notes = "授信人员")
   @TableField("accrediting_party_id")
   @Column(name = "accrediting_party_id", columnDefinition = "bigint(20)  COMMENT '授信人员'", nullable = false)
   private Long accreditingPartyId;
   @ApiModelProperty(name = "accreditingIdNumber", value = "身份证号码", notes = "身份证号码")
   @TableField("accrediting_id_number")
   @Column(name = "accrediting_id_number", columnDefinition = "varchar(64)  COMMENT '担保人身份证号码'", nullable = false)
   private String accreditingIdNumber;
   @ApiModelProperty(name = "suretyName", value = "担保人姓名", notes = "担保人姓名")
   @TableField("surety_name")
   @Column(name = "surety_name", columnDefinition = "varchar(64)  COMMENT '担保人姓名'", nullable = false)
   private String suretyName;
   @ApiModelProperty(name = "idNumber", value = "身份证号码", notes = "身份证号码")
   @TableField("id_number")
   @Column(name = "id_number", columnDefinition = "varchar(64)  COMMENT '身份证号码'", nullable = false)
   private String idNumber;
   @ApiModelProperty(name = "lineOfCredit", value = "授信额度(金额)", notes = "授信额度(金额)")
   @TableField("line_of_credit")
   @Column(name = "line_of_credit", columnDefinition = "decimal(32,8)  DEFAULT 0.0 COMMENT '授信额度(金额)'", nullable = false)
   private BigDecimal lineOfCredit;
   @ApiModelProperty(name = "annualInterest", value = "年利息(%)", notes = "年利息(%)")
   @TableField("annual_interest")
   @Column(name = "annual_interest", columnDefinition = "decimal(32,8) DEFAULT 0.00 COMMENT '年利息(%)'", nullable = false)
   private BigDecimal annualInterest;
   @ApiModelProperty(name = "monthlyInterest", value = "月利息(%)", notes = "月利息(%)")
   @TableField("monthly_interest")
   @Column(name = "monthly_interest", columnDefinition = "decimal(32,8) DEFAULT 0.00  COMMENT '月利息(%)'", nullable = false)
   private BigDecimal monthlyInterest;
   @ApiModelProperty(name = "dayInterest", value = "日利息(%)", notes = "日利息(%)")
   @TableField("day_interest")
   @Column(name = "day_interest", columnDefinition = "decimal(32,8) DEFAULT 0.00 COMMENT '日利息(%)'", nullable = false)
   private BigDecimal dayInterest;
   @ApiModelProperty(name = "usedCredit", value = "已使用额度", notes = "已使用额度")
   @TableField("used_credit")
   @Column(name = "used_credit", columnDefinition = "decimal(32,4) DEFAULT 0.00 COMMENT '已使用额度'", nullable = false)
   private BigDecimal usedCredit;
   @ApiModelProperty(name = "remainingSum", value = "剩余额度", notes = "剩余额度")
   @TableField("remaining_sum")
   @Column(name = "remaining_sum", columnDefinition = "decimal(32,4)  COMMENT '剩余额度'", nullable = false)
   private BigDecimal remainingSum;
   @ApiModelProperty(name = "status", value = "状态 状态 1启用 0禁用", notes = "状态 状态 1启用 0禁用")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default 1 COMMENT '状态 状态 1启用 0禁用'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "accessoryId", value = "附件id", notes = "附件id")
   @TableField("accessory_id")
   @Column(name = "accessory_id", columnDefinition = "bigint(20)  COMMENT '附件id'", nullable = true)
   private Long accessoryId;

   public static ContractGivingCredit.ContractGivingCreditBuilder builder() {
      return new ContractGivingCredit.ContractGivingCreditBuilder();
   }

   public ContractGivingCredit() {
   }

   public ContractGivingCredit(
      final Long id,
      final LocalDateTime startDate,
      final LocalDateTime closingDate,
      final Long userId,
      final Long projectId,
      final Long constructionAgentId,
      final Long accreditingPartyId,
      final String accreditingIdNumber,
      final String suretyName,
      final String idNumber,
      final BigDecimal lineOfCredit,
      final BigDecimal annualInterest,
      final BigDecimal monthlyInterest,
      final BigDecimal dayInterest,
      final BigDecimal usedCredit,
      final BigDecimal remainingSum,
      final Integer status,
      final Long accessoryId
   ) {
      this.id = id;
      this.startDate = startDate;
      this.closingDate = closingDate;
      this.userId = userId;
      this.projectId = projectId;
      this.constructionAgentId = constructionAgentId;
      this.accreditingPartyId = accreditingPartyId;
      this.accreditingIdNumber = accreditingIdNumber;
      this.suretyName = suretyName;
      this.idNumber = idNumber;
      this.lineOfCredit = lineOfCredit;
      this.annualInterest = annualInterest;
      this.monthlyInterest = monthlyInterest;
      this.dayInterest = dayInterest;
      this.usedCredit = usedCredit;
      this.remainingSum = remainingSum;
      this.status = status;
      this.accessoryId = accessoryId;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getClosingDate() {
      return this.closingDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getConstructionAgentId() {
      return this.constructionAgentId;
   }

   public Long getAccreditingPartyId() {
      return this.accreditingPartyId;
   }

   public String getAccreditingIdNumber() {
      return this.accreditingIdNumber;
   }

   public String getSuretyName() {
      return this.suretyName;
   }

   public String getIdNumber() {
      return this.idNumber;
   }

   public BigDecimal getLineOfCredit() {
      return this.lineOfCredit;
   }

   public BigDecimal getAnnualInterest() {
      return this.annualInterest;
   }

   public BigDecimal getMonthlyInterest() {
      return this.monthlyInterest;
   }

   public BigDecimal getDayInterest() {
      return this.dayInterest;
   }

   public BigDecimal getUsedCredit() {
      return this.usedCredit;
   }

   public BigDecimal getRemainingSum() {
      return this.remainingSum;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getAccessoryId() {
      return this.accessoryId;
   }

   public ContractGivingCredit setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractGivingCredit setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public ContractGivingCredit setClosingDate(final LocalDateTime closingDate) {
      this.closingDate = closingDate;
      return this;
   }

   public ContractGivingCredit setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractGivingCredit setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractGivingCredit setConstructionAgentId(final Long constructionAgentId) {
      this.constructionAgentId = constructionAgentId;
      return this;
   }

   public ContractGivingCredit setAccreditingPartyId(final Long accreditingPartyId) {
      this.accreditingPartyId = accreditingPartyId;
      return this;
   }

   public ContractGivingCredit setAccreditingIdNumber(final String accreditingIdNumber) {
      this.accreditingIdNumber = accreditingIdNumber;
      return this;
   }

   public ContractGivingCredit setSuretyName(final String suretyName) {
      this.suretyName = suretyName;
      return this;
   }

   public ContractGivingCredit setIdNumber(final String idNumber) {
      this.idNumber = idNumber;
      return this;
   }

   public ContractGivingCredit setLineOfCredit(final BigDecimal lineOfCredit) {
      this.lineOfCredit = lineOfCredit;
      return this;
   }

   public ContractGivingCredit setAnnualInterest(final BigDecimal annualInterest) {
      this.annualInterest = annualInterest;
      return this;
   }

   public ContractGivingCredit setMonthlyInterest(final BigDecimal monthlyInterest) {
      this.monthlyInterest = monthlyInterest;
      return this;
   }

   public ContractGivingCredit setDayInterest(final BigDecimal dayInterest) {
      this.dayInterest = dayInterest;
      return this;
   }

   public ContractGivingCredit setUsedCredit(final BigDecimal usedCredit) {
      this.usedCredit = usedCredit;
      return this;
   }

   public ContractGivingCredit setRemainingSum(final BigDecimal remainingSum) {
      this.remainingSum = remainingSum;
      return this;
   }

   public ContractGivingCredit setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public ContractGivingCredit setAccessoryId(final Long accessoryId) {
      this.accessoryId = accessoryId;
      return this;
   }

   @Override
   public String toString() {
      return "ContractGivingCredit(id="
         + this.getId()
         + ", startDate="
         + this.getStartDate()
         + ", closingDate="
         + this.getClosingDate()
         + ", userId="
         + this.getUserId()
         + ", projectId="
         + this.getProjectId()
         + ", constructionAgentId="
         + this.getConstructionAgentId()
         + ", accreditingPartyId="
         + this.getAccreditingPartyId()
         + ", accreditingIdNumber="
         + this.getAccreditingIdNumber()
         + ", suretyName="
         + this.getSuretyName()
         + ", idNumber="
         + this.getIdNumber()
         + ", lineOfCredit="
         + this.getLineOfCredit()
         + ", annualInterest="
         + this.getAnnualInterest()
         + ", monthlyInterest="
         + this.getMonthlyInterest()
         + ", dayInterest="
         + this.getDayInterest()
         + ", usedCredit="
         + this.getUsedCredit()
         + ", remainingSum="
         + this.getRemainingSum()
         + ", status="
         + this.getStatus()
         + ", accessoryId="
         + this.getAccessoryId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractGivingCredit)) {
         return false;
      }

      ContractGivingCredit other = (ContractGivingCredit)o;
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
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$constructionAgentId = this.getConstructionAgentId();
               Object other$constructionAgentId = other.getConstructionAgentId();
               if (this$constructionAgentId == null ? other$constructionAgentId == null : this$constructionAgentId.equals(other$constructionAgentId)) {
                  Object this$accreditingPartyId = this.getAccreditingPartyId();
                  Object other$accreditingPartyId = other.getAccreditingPartyId();
                  if (this$accreditingPartyId == null ? other$accreditingPartyId == null : this$accreditingPartyId.equals(other$accreditingPartyId)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$accessoryId = this.getAccessoryId();
                        Object other$accessoryId = other.getAccessoryId();
                        if (this$accessoryId == null ? other$accessoryId == null : this$accessoryId.equals(other$accessoryId)) {
                           Object this$startDate = this.getStartDate();
                           Object other$startDate = other.getStartDate();
                           if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                              Object this$closingDate = this.getClosingDate();
                              Object other$closingDate = other.getClosingDate();
                              if (this$closingDate == null ? other$closingDate == null : this$closingDate.equals(other$closingDate)) {
                                 Object this$accreditingIdNumber = this.getAccreditingIdNumber();
                                 Object other$accreditingIdNumber = other.getAccreditingIdNumber();
                                 if (this$accreditingIdNumber == null
                                    ? other$accreditingIdNumber == null
                                    : this$accreditingIdNumber.equals(other$accreditingIdNumber)) {
                                    Object this$suretyName = this.getSuretyName();
                                    Object other$suretyName = other.getSuretyName();
                                    if (this$suretyName == null ? other$suretyName == null : this$suretyName.equals(other$suretyName)) {
                                       Object this$idNumber = this.getIdNumber();
                                       Object other$idNumber = other.getIdNumber();
                                       if (this$idNumber == null ? other$idNumber == null : this$idNumber.equals(other$idNumber)) {
                                          Object this$lineOfCredit = this.getLineOfCredit();
                                          Object other$lineOfCredit = other.getLineOfCredit();
                                          if (this$lineOfCredit == null ? other$lineOfCredit == null : this$lineOfCredit.equals(other$lineOfCredit)) {
                                             Object this$annualInterest = this.getAnnualInterest();
                                             Object other$annualInterest = other.getAnnualInterest();
                                             if (this$annualInterest == null ? other$annualInterest == null : this$annualInterest.equals(other$annualInterest)) {
                                                Object this$monthlyInterest = this.getMonthlyInterest();
                                                Object other$monthlyInterest = other.getMonthlyInterest();
                                                if (this$monthlyInterest == null
                                                   ? other$monthlyInterest == null
                                                   : this$monthlyInterest.equals(other$monthlyInterest)) {
                                                   Object this$dayInterest = this.getDayInterest();
                                                   Object other$dayInterest = other.getDayInterest();
                                                   if (this$dayInterest == null ? other$dayInterest == null : this$dayInterest.equals(other$dayInterest)) {
                                                      Object this$usedCredit = this.getUsedCredit();
                                                      Object other$usedCredit = other.getUsedCredit();
                                                      if (this$usedCredit == null ? other$usedCredit == null : this$usedCredit.equals(other$usedCredit)) {
                                                         Object this$remainingSum = this.getRemainingSum();
                                                         Object other$remainingSum = other.getRemainingSum();
                                                         return this$remainingSum == null
                                                            ? other$remainingSum == null
                                                            : this$remainingSum.equals(other$remainingSum);
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
      return other instanceof ContractGivingCredit;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $constructionAgentId = this.getConstructionAgentId();
      result = result * 59 + ($constructionAgentId == null ? 43 : $constructionAgentId.hashCode());
      Object $accreditingPartyId = this.getAccreditingPartyId();
      result = result * 59 + ($accreditingPartyId == null ? 43 : $accreditingPartyId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $accessoryId = this.getAccessoryId();
      result = result * 59 + ($accessoryId == null ? 43 : $accessoryId.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $closingDate = this.getClosingDate();
      result = result * 59 + ($closingDate == null ? 43 : $closingDate.hashCode());
      Object $accreditingIdNumber = this.getAccreditingIdNumber();
      result = result * 59 + ($accreditingIdNumber == null ? 43 : $accreditingIdNumber.hashCode());
      Object $suretyName = this.getSuretyName();
      result = result * 59 + ($suretyName == null ? 43 : $suretyName.hashCode());
      Object $idNumber = this.getIdNumber();
      result = result * 59 + ($idNumber == null ? 43 : $idNumber.hashCode());
      Object $lineOfCredit = this.getLineOfCredit();
      result = result * 59 + ($lineOfCredit == null ? 43 : $lineOfCredit.hashCode());
      Object $annualInterest = this.getAnnualInterest();
      result = result * 59 + ($annualInterest == null ? 43 : $annualInterest.hashCode());
      Object $monthlyInterest = this.getMonthlyInterest();
      result = result * 59 + ($monthlyInterest == null ? 43 : $monthlyInterest.hashCode());
      Object $dayInterest = this.getDayInterest();
      result = result * 59 + ($dayInterest == null ? 43 : $dayInterest.hashCode());
      Object $usedCredit = this.getUsedCredit();
      result = result * 59 + ($usedCredit == null ? 43 : $usedCredit.hashCode());
      Object $remainingSum = this.getRemainingSum();
      return result * 59 + ($remainingSum == null ? 43 : $remainingSum.hashCode());
   }

   public static class ContractGivingCreditBuilder {
      private Long id;
      private LocalDateTime startDate;
      private LocalDateTime closingDate;
      private Long userId;
      private Long projectId;
      private Long constructionAgentId;
      private Long accreditingPartyId;
      private String accreditingIdNumber;
      private String suretyName;
      private String idNumber;
      private BigDecimal lineOfCredit;
      private BigDecimal annualInterest;
      private BigDecimal monthlyInterest;
      private BigDecimal dayInterest;
      private BigDecimal usedCredit;
      private BigDecimal remainingSum;
      private Integer status;
      private Long accessoryId;

      ContractGivingCreditBuilder() {
      }

      public ContractGivingCredit.ContractGivingCreditBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder closingDate(final LocalDateTime closingDate) {
         this.closingDate = closingDate;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder constructionAgentId(final Long constructionAgentId) {
         this.constructionAgentId = constructionAgentId;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder accreditingPartyId(final Long accreditingPartyId) {
         this.accreditingPartyId = accreditingPartyId;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder accreditingIdNumber(final String accreditingIdNumber) {
         this.accreditingIdNumber = accreditingIdNumber;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder suretyName(final String suretyName) {
         this.suretyName = suretyName;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder idNumber(final String idNumber) {
         this.idNumber = idNumber;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder lineOfCredit(final BigDecimal lineOfCredit) {
         this.lineOfCredit = lineOfCredit;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder annualInterest(final BigDecimal annualInterest) {
         this.annualInterest = annualInterest;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder monthlyInterest(final BigDecimal monthlyInterest) {
         this.monthlyInterest = monthlyInterest;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder dayInterest(final BigDecimal dayInterest) {
         this.dayInterest = dayInterest;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder usedCredit(final BigDecimal usedCredit) {
         this.usedCredit = usedCredit;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder remainingSum(final BigDecimal remainingSum) {
         this.remainingSum = remainingSum;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ContractGivingCredit.ContractGivingCreditBuilder accessoryId(final Long accessoryId) {
         this.accessoryId = accessoryId;
         return this;
      }

      public ContractGivingCredit build() {
         return new ContractGivingCredit(
            this.id,
            this.startDate,
            this.closingDate,
            this.userId,
            this.projectId,
            this.constructionAgentId,
            this.accreditingPartyId,
            this.accreditingIdNumber,
            this.suretyName,
            this.idNumber,
            this.lineOfCredit,
            this.annualInterest,
            this.monthlyInterest,
            this.dayInterest,
            this.usedCredit,
            this.remainingSum,
            this.status,
            this.accessoryId
         );
      }

      @Override
      public String toString() {
         return "ContractGivingCredit.ContractGivingCreditBuilder(id="
            + this.id
            + ", startDate="
            + this.startDate
            + ", closingDate="
            + this.closingDate
            + ", userId="
            + this.userId
            + ", projectId="
            + this.projectId
            + ", constructionAgentId="
            + this.constructionAgentId
            + ", accreditingPartyId="
            + this.accreditingPartyId
            + ", accreditingIdNumber="
            + this.accreditingIdNumber
            + ", suretyName="
            + this.suretyName
            + ", idNumber="
            + this.idNumber
            + ", lineOfCredit="
            + this.lineOfCredit
            + ", annualInterest="
            + this.annualInterest
            + ", monthlyInterest="
            + this.monthlyInterest
            + ", dayInterest="
            + this.dayInterest
            + ", usedCredit="
            + this.usedCredit
            + ", remainingSum="
            + this.remainingSum
            + ", status="
            + this.status
            + ", accessoryId="
            + this.accessoryId
            + ")";
      }
   }
}

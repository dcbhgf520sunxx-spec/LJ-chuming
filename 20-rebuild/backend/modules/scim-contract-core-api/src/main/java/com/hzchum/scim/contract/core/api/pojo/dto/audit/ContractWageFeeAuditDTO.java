package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "ContractWageFee对象", description = "工资费用表")
public class ContractWageFeeAuditDTO extends ContractFeeBaseInfo {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "fillInDate", value = "填写日期", notes = "填写日期")
   private LocalDateTime fillInDate;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   private Long branchCompanyId;
   @ApiModelProperty("费用归属名称")
   private String branchCompanyName;
   @ApiModelProperty(name = "expenseTypeId", value = "费用类型", notes = "费用类型")
   private Long expenseTypeId;
   @ApiModelProperty("费用类型名称")
   private String expenseTypeName;
   @ApiModelProperty(name = "founderId", value = "创建人ID", notes = "创建人ID")
   private Long founderId;
   @ApiModelProperty("创建人名称")
   private String founderName;
   @ApiModelProperty(name = "totalWage", value = "工资总额(元)", notes = "工资总额(元)")
   private BigDecimal totalWage;
   @ApiModelProperty(name = "employeeQuantity", value = "员工数量", notes = "员工数量")
   private Integer employeeQuantity;
   @ApiModelProperty(name = "averageWage", value = "平均工资", notes = "平均工资")
   private BigDecimal averageWage;
   @ApiModelProperty(name = "auditStatusEnum", value = "审批状态 1未审批 2已通过 4已驳回", notes = "审批状态 1未审批 2已通过 4已驳回")
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人名字")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   private LocalDateTime auditTime;

   public static ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder builder() {
      return new ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWageFeeAuditDTO)) {
         return false;
      }

      ContractWageFeeAuditDTO other = (ContractWageFeeAuditDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$expenseTypeId = this.getExpenseTypeId();
            Object other$expenseTypeId = other.getExpenseTypeId();
            if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
               Object this$founderId = this.getFounderId();
               Object other$founderId = other.getFounderId();
               if (this$founderId == null ? other$founderId == null : this$founderId.equals(other$founderId)) {
                  Object this$employeeQuantity = this.getEmployeeQuantity();
                  Object other$employeeQuantity = other.getEmployeeQuantity();
                  if (this$employeeQuantity == null ? other$employeeQuantity == null : this$employeeQuantity.equals(other$employeeQuantity)) {
                     Object this$auditStatusEnum = this.getAuditStatusEnum();
                     Object other$auditStatusEnum = other.getAuditStatusEnum();
                     if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                        Object this$auditorId = this.getAuditorId();
                        Object other$auditorId = other.getAuditorId();
                        if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                           Object this$fillInDate = this.getFillInDate();
                           Object other$fillInDate = other.getFillInDate();
                           if (this$fillInDate == null ? other$fillInDate == null : this$fillInDate.equals(other$fillInDate)) {
                              Object this$branchCompanyName = this.getBranchCompanyName();
                              Object other$branchCompanyName = other.getBranchCompanyName();
                              if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                                 Object this$expenseTypeName = this.getExpenseTypeName();
                                 Object other$expenseTypeName = other.getExpenseTypeName();
                                 if (this$expenseTypeName == null ? other$expenseTypeName == null : this$expenseTypeName.equals(other$expenseTypeName)) {
                                    Object this$founderName = this.getFounderName();
                                    Object other$founderName = other.getFounderName();
                                    if (this$founderName == null ? other$founderName == null : this$founderName.equals(other$founderName)) {
                                       Object this$totalWage = this.getTotalWage();
                                       Object other$totalWage = other.getTotalWage();
                                       if (this$totalWage == null ? other$totalWage == null : this$totalWage.equals(other$totalWage)) {
                                          Object this$averageWage = this.getAverageWage();
                                          Object other$averageWage = other.getAverageWage();
                                          if (this$averageWage == null ? other$averageWage == null : this$averageWage.equals(other$averageWage)) {
                                             Object this$auditorName = this.getAuditorName();
                                             Object other$auditorName = other.getAuditorName();
                                             if (this$auditorName == null ? other$auditorName == null : this$auditorName.equals(other$auditorName)) {
                                                Object this$auditTime = this.getAuditTime();
                                                Object other$auditTime = other.getAuditTime();
                                                return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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
      return other instanceof ContractWageFeeAuditDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $founderId = this.getFounderId();
      result = result * 59 + ($founderId == null ? 43 : $founderId.hashCode());
      Object $employeeQuantity = this.getEmployeeQuantity();
      result = result * 59 + ($employeeQuantity == null ? 43 : $employeeQuantity.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $fillInDate = this.getFillInDate();
      result = result * 59 + ($fillInDate == null ? 43 : $fillInDate.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $expenseTypeName = this.getExpenseTypeName();
      result = result * 59 + ($expenseTypeName == null ? 43 : $expenseTypeName.hashCode());
      Object $founderName = this.getFounderName();
      result = result * 59 + ($founderName == null ? 43 : $founderName.hashCode());
      Object $totalWage = this.getTotalWage();
      result = result * 59 + ($totalWage == null ? 43 : $totalWage.hashCode());
      Object $averageWage = this.getAverageWage();
      result = result * 59 + ($averageWage == null ? 43 : $averageWage.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   public ContractWageFeeAuditDTO() {
   }

   public ContractWageFeeAuditDTO(
      final Long id,
      final LocalDateTime fillInDate,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long expenseTypeId,
      final String expenseTypeName,
      final Long founderId,
      final String founderName,
      final BigDecimal totalWage,
      final Integer employeeQuantity,
      final BigDecimal averageWage,
      final Integer auditStatusEnum,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime
   ) {
      this.id = id;
      this.fillInDate = fillInDate;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.expenseTypeId = expenseTypeId;
      this.expenseTypeName = expenseTypeName;
      this.founderId = founderId;
      this.founderName = founderName;
      this.totalWage = totalWage;
      this.employeeQuantity = employeeQuantity;
      this.averageWage = averageWage;
      this.auditStatusEnum = auditStatusEnum;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getFillInDate() {
      return this.fillInDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public String getExpenseTypeName() {
      return this.expenseTypeName;
   }

   public Long getFounderId() {
      return this.founderId;
   }

   public String getFounderName() {
      return this.founderName;
   }

   public BigDecimal getTotalWage() {
      return this.totalWage;
   }

   public Integer getEmployeeQuantity() {
      return this.employeeQuantity;
   }

   public BigDecimal getAverageWage() {
      return this.averageWage;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public Long getAuditorId() {
      return this.auditorId;
   }

   public String getAuditorName() {
      return this.auditorName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFillInDate(final LocalDateTime fillInDate) {
      this.fillInDate = fillInDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
   }

   public void setExpenseTypeName(final String expenseTypeName) {
      this.expenseTypeName = expenseTypeName;
   }

   public void setFounderId(final Long founderId) {
      this.founderId = founderId;
   }

   public void setFounderName(final String founderName) {
      this.founderName = founderName;
   }

   public void setTotalWage(final BigDecimal totalWage) {
      this.totalWage = totalWage;
   }

   public void setEmployeeQuantity(final Integer employeeQuantity) {
      this.employeeQuantity = employeeQuantity;
   }

   public void setAverageWage(final BigDecimal averageWage) {
      this.averageWage = averageWage;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
   }

   public void setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   @Override
   public String toString() {
      return "ContractWageFeeAuditDTO(id="
         + this.getId()
         + ", fillInDate="
         + this.getFillInDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", expenseTypeName="
         + this.getExpenseTypeName()
         + ", founderId="
         + this.getFounderId()
         + ", founderName="
         + this.getFounderName()
         + ", totalWage="
         + this.getTotalWage()
         + ", employeeQuantity="
         + this.getEmployeeQuantity()
         + ", averageWage="
         + this.getAverageWage()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }

   public static class ContractWageFeeAuditDTOBuilder {
      private Long id;
      private LocalDateTime fillInDate;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long expenseTypeId;
      private String expenseTypeName;
      private Long founderId;
      private String founderName;
      private BigDecimal totalWage;
      private Integer employeeQuantity;
      private BigDecimal averageWage;
      private Integer auditStatusEnum;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;

      ContractWageFeeAuditDTOBuilder() {
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder fillInDate(final LocalDateTime fillInDate) {
         this.fillInDate = fillInDate;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder expenseTypeId(final Long expenseTypeId) {
         this.expenseTypeId = expenseTypeId;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder expenseTypeName(final String expenseTypeName) {
         this.expenseTypeName = expenseTypeName;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder founderId(final Long founderId) {
         this.founderId = founderId;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder founderName(final String founderName) {
         this.founderName = founderName;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder totalWage(final BigDecimal totalWage) {
         this.totalWage = totalWage;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder employeeQuantity(final Integer employeeQuantity) {
         this.employeeQuantity = employeeQuantity;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder averageWage(final BigDecimal averageWage) {
         this.averageWage = averageWage;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractWageFeeAuditDTO build() {
         return new ContractWageFeeAuditDTO(
            this.id,
            this.fillInDate,
            this.branchCompanyId,
            this.branchCompanyName,
            this.expenseTypeId,
            this.expenseTypeName,
            this.founderId,
            this.founderName,
            this.totalWage,
            this.employeeQuantity,
            this.averageWage,
            this.auditStatusEnum,
            this.auditorId,
            this.auditorName,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "ContractWageFeeAuditDTO.ContractWageFeeAuditDTOBuilder(id="
            + this.id
            + ", fillInDate="
            + this.fillInDate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", expenseTypeId="
            + this.expenseTypeId
            + ", expenseTypeName="
            + this.expenseTypeName
            + ", founderId="
            + this.founderId
            + ", founderName="
            + this.founderName
            + ", totalWage="
            + this.totalWage
            + ", employeeQuantity="
            + this.employeeQuantity
            + ", averageWage="
            + this.averageWage
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", auditTime="
            + this.auditTime
            + ")";
      }
   }
}

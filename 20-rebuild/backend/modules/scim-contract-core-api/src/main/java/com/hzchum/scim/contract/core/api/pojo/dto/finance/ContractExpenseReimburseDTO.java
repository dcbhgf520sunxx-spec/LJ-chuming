package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(value = "ContractExpenseReimburse对象dto", description = "费用报销表 ")
public class ContractExpenseReimburseDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "reimburseDate", value = "报销日期", notes = "报销日期")
   private LocalDate reimburseDate;
   @ApiModelProperty(name = "yearMonthValue", value = "年月(格式 202208)", notes = "年月(格式 202208)")
   private Integer yearMonthValue;
   @ApiModelProperty(name = "reimburseUserId", value = "报销人ID", notes = "报销人ID")
   private Long reimburseUserId;
   @ApiModelProperty(name = "reimburseUserName", value = "报销人", notes = "报销人")
   private String reimburseUserName;
   @ApiModelProperty(name = "deptId", value = "部门ID", notes = "部门ID")
   private Long deptId;
   @ApiModelProperty(name = "deptName", value = "部门", notes = "部门")
   private String deptName;
   @ApiModelProperty(name = "reimburseAmount", value = "报销金额", notes = "报销金额")
   private BigDecimal reimburseAmount;
   @ApiModelProperty(name = "expenseTypeId", value = "费用分类ID", notes = "费用分类ID")
   private Long expenseTypeId;
   @ApiModelProperty(name = "expenseTypeName", value = "费用分类", notes = "费用分类")
   private String expenseTypeName;
   @ApiModelProperty(name = "expenseSubjectId", value = "费用科目ID", notes = "费用科目ID")
   private Long expenseSubjectId;
   @ApiModelProperty(name = "expenseSubjectName", value = "费用科目", notes = "费用科目")
   private String expenseSubjectName;
   @ApiModelProperty(name = "project", value = "关联项目(可不填)", notes = "关联项目(可不填)")
   private ProjectInfo project;
   @ApiModelProperty(name = "writtenById", value = "填报人id", notes = "填报人id")
   private Long writtenById;
   @ApiModelProperty(name = "writtenByName", value = "填报人", notes = "填报人")
   private String writtenByName;
   @ApiModelProperty(name = "boolConfirmStatus", value = "报销确认状态 0未确认 1已确认", notes = "报销确认状态 0未确认 1已确认")
   private Boolean boolConfirmStatus;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder builder() {
      return new ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder();
   }

   public ContractExpenseReimburseDTO() {
   }

   public ContractExpenseReimburseDTO(
      final Long id,
      final LocalDate reimburseDate,
      final Integer yearMonthValue,
      final Long reimburseUserId,
      final String reimburseUserName,
      final Long deptId,
      final String deptName,
      final BigDecimal reimburseAmount,
      final Long expenseTypeId,
      final String expenseTypeName,
      final Long expenseSubjectId,
      final String expenseSubjectName,
      final ProjectInfo project,
      final Long writtenById,
      final String writtenByName,
      final Boolean boolConfirmStatus,
      final String remark
   ) {
      this.id = id;
      this.reimburseDate = reimburseDate;
      this.yearMonthValue = yearMonthValue;
      this.reimburseUserId = reimburseUserId;
      this.reimburseUserName = reimburseUserName;
      this.deptId = deptId;
      this.deptName = deptName;
      this.reimburseAmount = reimburseAmount;
      this.expenseTypeId = expenseTypeId;
      this.expenseTypeName = expenseTypeName;
      this.expenseSubjectId = expenseSubjectId;
      this.expenseSubjectName = expenseSubjectName;
      this.project = project;
      this.writtenById = writtenById;
      this.writtenByName = writtenByName;
      this.boolConfirmStatus = boolConfirmStatus;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getReimburseDate() {
      return this.reimburseDate;
   }

   public Integer getYearMonthValue() {
      return this.yearMonthValue;
   }

   public Long getReimburseUserId() {
      return this.reimburseUserId;
   }

   public String getReimburseUserName() {
      return this.reimburseUserName;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public BigDecimal getReimburseAmount() {
      return this.reimburseAmount;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public String getExpenseTypeName() {
      return this.expenseTypeName;
   }

   public Long getExpenseSubjectId() {
      return this.expenseSubjectId;
   }

   public String getExpenseSubjectName() {
      return this.expenseSubjectName;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public String getWrittenByName() {
      return this.writtenByName;
   }

   public Boolean getBoolConfirmStatus() {
      return this.boolConfirmStatus;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setReimburseDate(final LocalDate reimburseDate) {
      this.reimburseDate = reimburseDate;
   }

   public void setYearMonthValue(final Integer yearMonthValue) {
      this.yearMonthValue = yearMonthValue;
   }

   public void setReimburseUserId(final Long reimburseUserId) {
      this.reimburseUserId = reimburseUserId;
   }

   public void setReimburseUserName(final String reimburseUserName) {
      this.reimburseUserName = reimburseUserName;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   public void setReimburseAmount(final BigDecimal reimburseAmount) {
      this.reimburseAmount = reimburseAmount;
   }

   public void setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
   }

   public void setExpenseTypeName(final String expenseTypeName) {
      this.expenseTypeName = expenseTypeName;
   }

   public void setExpenseSubjectId(final Long expenseSubjectId) {
      this.expenseSubjectId = expenseSubjectId;
   }

   public void setExpenseSubjectName(final String expenseSubjectName) {
      this.expenseSubjectName = expenseSubjectName;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
   }

   public void setWrittenByName(final String writtenByName) {
      this.writtenByName = writtenByName;
   }

   public void setBoolConfirmStatus(final Boolean boolConfirmStatus) {
      this.boolConfirmStatus = boolConfirmStatus;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractExpenseReimburseDTO)) {
         return false;
      }

      ContractExpenseReimburseDTO other = (ContractExpenseReimburseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$yearMonthValue = this.getYearMonthValue();
         Object other$yearMonthValue = other.getYearMonthValue();
         if (this$yearMonthValue == null ? other$yearMonthValue == null : this$yearMonthValue.equals(other$yearMonthValue)) {
            Object this$reimburseUserId = this.getReimburseUserId();
            Object other$reimburseUserId = other.getReimburseUserId();
            if (this$reimburseUserId == null ? other$reimburseUserId == null : this$reimburseUserId.equals(other$reimburseUserId)) {
               Object this$deptId = this.getDeptId();
               Object other$deptId = other.getDeptId();
               if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
                  Object this$expenseTypeId = this.getExpenseTypeId();
                  Object other$expenseTypeId = other.getExpenseTypeId();
                  if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
                     Object this$expenseSubjectId = this.getExpenseSubjectId();
                     Object other$expenseSubjectId = other.getExpenseSubjectId();
                     if (this$expenseSubjectId == null ? other$expenseSubjectId == null : this$expenseSubjectId.equals(other$expenseSubjectId)) {
                        Object this$writtenById = this.getWrittenById();
                        Object other$writtenById = other.getWrittenById();
                        if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                           Object this$boolConfirmStatus = this.getBoolConfirmStatus();
                           Object other$boolConfirmStatus = other.getBoolConfirmStatus();
                           if (this$boolConfirmStatus == null ? other$boolConfirmStatus == null : this$boolConfirmStatus.equals(other$boolConfirmStatus)) {
                              Object this$reimburseDate = this.getReimburseDate();
                              Object other$reimburseDate = other.getReimburseDate();
                              if (this$reimburseDate == null ? other$reimburseDate == null : this$reimburseDate.equals(other$reimburseDate)) {
                                 Object this$reimburseUserName = this.getReimburseUserName();
                                 Object other$reimburseUserName = other.getReimburseUserName();
                                 if (this$reimburseUserName == null ? other$reimburseUserName == null : this$reimburseUserName.equals(other$reimburseUserName)) {
                                    Object this$deptName = this.getDeptName();
                                    Object other$deptName = other.getDeptName();
                                    if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
                                       Object this$reimburseAmount = this.getReimburseAmount();
                                       Object other$reimburseAmount = other.getReimburseAmount();
                                       if (this$reimburseAmount == null ? other$reimburseAmount == null : this$reimburseAmount.equals(other$reimburseAmount)) {
                                          Object this$expenseTypeName = this.getExpenseTypeName();
                                          Object other$expenseTypeName = other.getExpenseTypeName();
                                          if (this$expenseTypeName == null ? other$expenseTypeName == null : this$expenseTypeName.equals(other$expenseTypeName)
                                             )
                                           {
                                             Object this$expenseSubjectName = this.getExpenseSubjectName();
                                             Object other$expenseSubjectName = other.getExpenseSubjectName();
                                             if (this$expenseSubjectName == null
                                                ? other$expenseSubjectName == null
                                                : this$expenseSubjectName.equals(other$expenseSubjectName)) {
                                                Object this$project = this.getProject();
                                                Object other$project = other.getProject();
                                                if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                   Object this$writtenByName = this.getWrittenByName();
                                                   Object other$writtenByName = other.getWrittenByName();
                                                   if (this$writtenByName == null
                                                      ? other$writtenByName == null
                                                      : this$writtenByName.equals(other$writtenByName)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ContractExpenseReimburseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $yearMonthValue = this.getYearMonthValue();
      result = result * 59 + ($yearMonthValue == null ? 43 : $yearMonthValue.hashCode());
      Object $reimburseUserId = this.getReimburseUserId();
      result = result * 59 + ($reimburseUserId == null ? 43 : $reimburseUserId.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $expenseSubjectId = this.getExpenseSubjectId();
      result = result * 59 + ($expenseSubjectId == null ? 43 : $expenseSubjectId.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $boolConfirmStatus = this.getBoolConfirmStatus();
      result = result * 59 + ($boolConfirmStatus == null ? 43 : $boolConfirmStatus.hashCode());
      Object $reimburseDate = this.getReimburseDate();
      result = result * 59 + ($reimburseDate == null ? 43 : $reimburseDate.hashCode());
      Object $reimburseUserName = this.getReimburseUserName();
      result = result * 59 + ($reimburseUserName == null ? 43 : $reimburseUserName.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $reimburseAmount = this.getReimburseAmount();
      result = result * 59 + ($reimburseAmount == null ? 43 : $reimburseAmount.hashCode());
      Object $expenseTypeName = this.getExpenseTypeName();
      result = result * 59 + ($expenseTypeName == null ? 43 : $expenseTypeName.hashCode());
      Object $expenseSubjectName = this.getExpenseSubjectName();
      result = result * 59 + ($expenseSubjectName == null ? 43 : $expenseSubjectName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractExpenseReimburseDTO(id="
         + this.getId()
         + ", reimburseDate="
         + this.getReimburseDate()
         + ", yearMonthValue="
         + this.getYearMonthValue()
         + ", reimburseUserId="
         + this.getReimburseUserId()
         + ", reimburseUserName="
         + this.getReimburseUserName()
         + ", deptId="
         + this.getDeptId()
         + ", deptName="
         + this.getDeptName()
         + ", reimburseAmount="
         + this.getReimburseAmount()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", expenseTypeName="
         + this.getExpenseTypeName()
         + ", expenseSubjectId="
         + this.getExpenseSubjectId()
         + ", expenseSubjectName="
         + this.getExpenseSubjectName()
         + ", project="
         + this.getProject()
         + ", writtenById="
         + this.getWrittenById()
         + ", writtenByName="
         + this.getWrittenByName()
         + ", boolConfirmStatus="
         + this.getBoolConfirmStatus()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ContractExpenseReimburseDTOBuilder {
      private Long id;
      private LocalDate reimburseDate;
      private Integer yearMonthValue;
      private Long reimburseUserId;
      private String reimburseUserName;
      private Long deptId;
      private String deptName;
      private BigDecimal reimburseAmount;
      private Long expenseTypeId;
      private String expenseTypeName;
      private Long expenseSubjectId;
      private String expenseSubjectName;
      private ProjectInfo project;
      private Long writtenById;
      private String writtenByName;
      private Boolean boolConfirmStatus;
      private String remark;

      ContractExpenseReimburseDTOBuilder() {
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder reimburseDate(final LocalDate reimburseDate) {
         this.reimburseDate = reimburseDate;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder yearMonthValue(final Integer yearMonthValue) {
         this.yearMonthValue = yearMonthValue;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder reimburseUserId(final Long reimburseUserId) {
         this.reimburseUserId = reimburseUserId;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder reimburseUserName(final String reimburseUserName) {
         this.reimburseUserName = reimburseUserName;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder deptName(final String deptName) {
         this.deptName = deptName;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder reimburseAmount(final BigDecimal reimburseAmount) {
         this.reimburseAmount = reimburseAmount;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder expenseTypeId(final Long expenseTypeId) {
         this.expenseTypeId = expenseTypeId;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder expenseTypeName(final String expenseTypeName) {
         this.expenseTypeName = expenseTypeName;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder expenseSubjectId(final Long expenseSubjectId) {
         this.expenseSubjectId = expenseSubjectId;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder expenseSubjectName(final String expenseSubjectName) {
         this.expenseSubjectName = expenseSubjectName;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder writtenByName(final String writtenByName) {
         this.writtenByName = writtenByName;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder boolConfirmStatus(final Boolean boolConfirmStatus) {
         this.boolConfirmStatus = boolConfirmStatus;
         return this;
      }

      public ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractExpenseReimburseDTO build() {
         return new ContractExpenseReimburseDTO(
            this.id,
            this.reimburseDate,
            this.yearMonthValue,
            this.reimburseUserId,
            this.reimburseUserName,
            this.deptId,
            this.deptName,
            this.reimburseAmount,
            this.expenseTypeId,
            this.expenseTypeName,
            this.expenseSubjectId,
            this.expenseSubjectName,
            this.project,
            this.writtenById,
            this.writtenByName,
            this.boolConfirmStatus,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractExpenseReimburseDTO.ContractExpenseReimburseDTOBuilder(id="
            + this.id
            + ", reimburseDate="
            + this.reimburseDate
            + ", yearMonthValue="
            + this.yearMonthValue
            + ", reimburseUserId="
            + this.reimburseUserId
            + ", reimburseUserName="
            + this.reimburseUserName
            + ", deptId="
            + this.deptId
            + ", deptName="
            + this.deptName
            + ", reimburseAmount="
            + this.reimburseAmount
            + ", expenseTypeId="
            + this.expenseTypeId
            + ", expenseTypeName="
            + this.expenseTypeName
            + ", expenseSubjectId="
            + this.expenseSubjectId
            + ", expenseSubjectName="
            + this.expenseSubjectName
            + ", project="
            + this.project
            + ", writtenById="
            + this.writtenById
            + ", writtenByName="
            + this.writtenByName
            + ", boolConfirmStatus="
            + this.boolConfirmStatus
            + ", remark="
            + this.remark
            + ")";
      }
   }
}

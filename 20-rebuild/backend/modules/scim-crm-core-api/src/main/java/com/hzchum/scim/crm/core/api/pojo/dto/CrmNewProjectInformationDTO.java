package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CrmNewProjectInformationDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "departmentId", value = "填报人所在部门", notes = "填报人所在部门")
   private Long departmentId;
   @ApiModelProperty(name = "departmentName", value = "填报人所在部门名称", notes = "填报人所在部门名称")
   private String departmentName;
   @ApiModelProperty(name = "informantUserName", value = "填报人姓名", notes = "销售人姓名")
   private String informantUserName;
   @ApiModelProperty(name = "informantDateTime", value = "填报时间", notes = "填报时间")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "estimatedCost", value = "预估造价", notes = "预估造价")
   private BigDecimal estimatedCost;
   @ApiModelProperty(name = "amount", value = "合同额", notes = "合同额")
   private BigDecimal amount;
   @ApiModelProperty(name = "isWinningBidder", value = "是否中标", notes = "是否中标")
   private Boolean isWinningBidder;

   public CrmNewProjectInformationDTO(
      final Long id,
      final String projectName,
      final Long departmentId,
      final String departmentName,
      final String informantUserName,
      final LocalDateTime informantDateTime,
      final BigDecimal estimatedCost,
      final BigDecimal amount,
      final Boolean isWinningBidder
   ) {
      this.id = id;
      this.projectName = projectName;
      this.departmentId = departmentId;
      this.departmentName = departmentName;
      this.informantUserName = informantUserName;
      this.informantDateTime = informantDateTime;
      this.estimatedCost = estimatedCost;
      this.amount = amount;
      this.isWinningBidder = isWinningBidder;
   }

   public CrmNewProjectInformationDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public BigDecimal getEstimatedCost() {
      return this.estimatedCost;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Boolean getIsWinningBidder() {
      return this.isWinningBidder;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
   }

   public void setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
   }

   public void setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
   }

   public void setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
   }

   public void setEstimatedCost(final BigDecimal estimatedCost) {
      this.estimatedCost = estimatedCost;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setIsWinningBidder(final Boolean isWinningBidder) {
      this.isWinningBidder = isWinningBidder;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmNewProjectInformationDTO)) {
         return false;
      }

      CrmNewProjectInformationDTO other = (CrmNewProjectInformationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$departmentId = this.getDepartmentId();
         Object other$departmentId = other.getDepartmentId();
         if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
            Object this$isWinningBidder = this.getIsWinningBidder();
            Object other$isWinningBidder = other.getIsWinningBidder();
            if (this$isWinningBidder == null ? other$isWinningBidder == null : this$isWinningBidder.equals(other$isWinningBidder)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$departmentName = this.getDepartmentName();
                  Object other$departmentName = other.getDepartmentName();
                  if (this$departmentName == null ? other$departmentName == null : this$departmentName.equals(other$departmentName)) {
                     Object this$informantUserName = this.getInformantUserName();
                     Object other$informantUserName = other.getInformantUserName();
                     if (this$informantUserName == null ? other$informantUserName == null : this$informantUserName.equals(other$informantUserName)) {
                        Object this$informantDateTime = this.getInformantDateTime();
                        Object other$informantDateTime = other.getInformantDateTime();
                        if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
                           Object this$estimatedCost = this.getEstimatedCost();
                           Object other$estimatedCost = other.getEstimatedCost();
                           if (this$estimatedCost == null ? other$estimatedCost == null : this$estimatedCost.equals(other$estimatedCost)) {
                              Object this$amount = this.getAmount();
                              Object other$amount = other.getAmount();
                              return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
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
      return other instanceof CrmNewProjectInformationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $isWinningBidder = this.getIsWinningBidder();
      result = result * 59 + ($isWinningBidder == null ? 43 : $isWinningBidder.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $estimatedCost = this.getEstimatedCost();
      result = result * 59 + ($estimatedCost == null ? 43 : $estimatedCost.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "CrmNewProjectInformationDTO(id="
         + this.getId()
         + ", projectName="
         + this.getProjectName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", departmentName="
         + this.getDepartmentName()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", estimatedCost="
         + this.getEstimatedCost()
         + ", amount="
         + this.getAmount()
         + ", isWinningBidder="
         + this.getIsWinningBidder()
         + ")";
   }
}

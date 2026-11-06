package com.hzchum.scim.contract.core.api.pojo.dtoParam.project;

import io.swagger.annotations.ApiModel;
import java.time.LocalDateTime;

@ApiModel("项目台账列表查询类")
public class ProjectLedgerDtoParam {
   private LocalDateTime year;
   private Integer level;
   private Long branchCompanyId;
   private Integer settlementStatus;
   private Integer projectAttribute;
   private Long projectManagerId;
   private Long salesLeaderId;
   private Long projectId;

   public LocalDateTime getYear() {
      return this.year;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public Long getSalesLeaderId() {
      return this.salesLeaderId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public void setYear(final LocalDateTime year) {
      this.year = year;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setSalesLeaderId(final Long salesLeaderId) {
      this.salesLeaderId = salesLeaderId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLedgerDtoParam)) {
         return false;
      }

      ProjectLedgerDtoParam other = (ProjectLedgerDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$level = this.getLevel();
      Object other$level = other.getLevel();
      if (this$level == null ? other$level == null : this$level.equals(other$level)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$settlementStatus = this.getSettlementStatus();
            Object other$settlementStatus = other.getSettlementStatus();
            if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
               Object this$projectAttribute = this.getProjectAttribute();
               Object other$projectAttribute = other.getProjectAttribute();
               if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                  Object this$projectManagerId = this.getProjectManagerId();
                  Object other$projectManagerId = other.getProjectManagerId();
                  if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                     Object this$salesLeaderId = this.getSalesLeaderId();
                     Object other$salesLeaderId = other.getSalesLeaderId();
                     if (this$salesLeaderId == null ? other$salesLeaderId == null : this$salesLeaderId.equals(other$salesLeaderId)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$year = this.getYear();
                           Object other$year = other.getYear();
                           return this$year == null ? other$year == null : this$year.equals(other$year);
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
      return other instanceof ProjectLedgerDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $salesLeaderId = this.getSalesLeaderId();
      result = result * 59 + ($salesLeaderId == null ? 43 : $salesLeaderId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $year = this.getYear();
      return result * 59 + ($year == null ? 43 : $year.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLedgerDtoParam(year="
         + this.getYear()
         + ", level="
         + this.getLevel()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", salesLeaderId="
         + this.getSalesLeaderId()
         + ", projectId="
         + this.getProjectId()
         + ")";
   }
}

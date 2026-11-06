package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目深化量")
public class DeepenRecordProjectDTO {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("项目编号")
   private String serialNumber;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("简称")
   private String shortName;
   @ApiModelProperty("深化量(t/m)")
   private BigDecimal mete;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("计划总量")
   private BigDecimal planMete;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getPlanMete() {
      return this.planMete;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setPlanMete(final BigDecimal planMete) {
      this.planMete = planMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeepenRecordProjectDTO)) {
         return false;
      }

      DeepenRecordProjectDTO other = (DeepenRecordProjectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$shortName = this.getShortName();
               Object other$shortName = other.getShortName();
               if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$planMete = this.getPlanMete();
                     Object other$planMete = other.getPlanMete();
                     return this$planMete == null ? other$planMete == null : this$planMete.equals(other$planMete);
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
      return other instanceof DeepenRecordProjectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $planMete = this.getPlanMete();
      return result * 59 + ($planMete == null ? 43 : $planMete.hashCode());
   }

   @Override
   public String toString() {
      return "DeepenRecordProjectDTO(projectId="
         + this.getProjectId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", mete="
         + this.getMete()
         + ", planMete="
         + this.getPlanMete()
         + ")";
   }
}

package com.hzchum.scim.contract.core.api.pojo.dto.visa;

import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectContentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "签证 ")
public class ContractVisaSettlementDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty("是否提交结算")
   private Boolean isSubmitSettle;
   @ApiModelProperty(name = "businessType", value = "业务类型 1加工承揽 2项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库 8围护项目")
   private Integer projectType;
   @ApiModelProperty(name = "projectContentList", notes = "项目内容列表")
   private List<ProjectContentDTO> projectContentList;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Boolean getIsSubmitSettle() {
      return this.isSubmitSettle;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public List<ProjectContentDTO> getProjectContentList() {
      return this.projectContentList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setIsSubmitSettle(final Boolean isSubmitSettle) {
      this.isSubmitSettle = isSubmitSettle;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProjectContentList(final List<ProjectContentDTO> projectContentList) {
      this.projectContentList = projectContentList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractVisaSettlementDTO)) {
         return false;
      }

      ContractVisaSettlementDTO other = (ContractVisaSettlementDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$isSubmitSettle = this.getIsSubmitSettle();
         Object other$isSubmitSettle = other.getIsSubmitSettle();
         if (this$isSubmitSettle == null ? other$isSubmitSettle == null : this$isSubmitSettle.equals(other$isSubmitSettle)) {
            Object this$businessType = this.getBusinessType();
            Object other$businessType = other.getBusinessType();
            if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
               Object this$projectType = this.getProjectType();
               Object other$projectType = other.getProjectType();
               if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$shortName = this.getShortName();
                     Object other$shortName = other.getShortName();
                     if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$projectContentList = this.getProjectContentList();
                           Object other$projectContentList = other.getProjectContentList();
                           return this$projectContentList == null ? other$projectContentList == null : this$projectContentList.equals(other$projectContentList);
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
      return other instanceof ContractVisaSettlementDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $isSubmitSettle = this.getIsSubmitSettle();
      result = result * 59 + ($isSubmitSettle == null ? 43 : $isSubmitSettle.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectContentList = this.getProjectContentList();
      return result * 59 + ($projectContentList == null ? 43 : $projectContentList.hashCode());
   }

   @Override
   public String toString() {
      return "ContractVisaSettlementDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", isSubmitSettle="
         + this.getIsSubmitSettle()
         + ", businessType="
         + this.getBusinessType()
         + ", projectType="
         + this.getProjectType()
         + ", projectContentList="
         + this.getProjectContentList()
         + ")";
   }
}

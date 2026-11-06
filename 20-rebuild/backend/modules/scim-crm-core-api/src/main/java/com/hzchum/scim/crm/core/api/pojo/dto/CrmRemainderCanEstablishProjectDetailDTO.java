package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmRemainderCanEstablishProjectDetailDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "businessName", value = "企业名称", notes = "企业名称")
   private String businessName;
   @ApiModelProperty(name = "regionNameList", value = "地区名称列表", notes = "地区名称列表")
   private String regionNameList;
   @ApiModelProperty(name = "industryConfigurationName", value = "单位所属行业id  参考 crm_basice_config", notes = "单位所属行业id  参考 crm_basice_config")
   private String industryConfigurationName;
   @ApiModelProperty(name = "departmentName", value = "部门名称", notes = "部门名称")
   private String departmentName;

   public static CrmRemainderCanEstablishProjectDetailDTO.CrmRemainderCanEstablishProjectDetailDTOBuilder builder() {
      return new CrmRemainderCanEstablishProjectDetailDTO.CrmRemainderCanEstablishProjectDetailDTOBuilder();
   }

   public CrmRemainderCanEstablishProjectDetailDTO() {
   }

   public CrmRemainderCanEstablishProjectDetailDTO(
      final Long id, final String businessName, final String regionNameList, final String industryConfigurationName, final String departmentName
   ) {
      this.id = id;
      this.businessName = businessName;
      this.regionNameList = regionNameList;
      this.industryConfigurationName = industryConfigurationName;
      this.departmentName = departmentName;
   }

   public Long getId() {
      return this.id;
   }

   public String getBusinessName() {
      return this.businessName;
   }

   public String getRegionNameList() {
      return this.regionNameList;
   }

   public String getIndustryConfigurationName() {
      return this.industryConfigurationName;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public CrmRemainderCanEstablishProjectDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmRemainderCanEstablishProjectDetailDTO setBusinessName(final String businessName) {
      this.businessName = businessName;
      return this;
   }

   public CrmRemainderCanEstablishProjectDetailDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmRemainderCanEstablishProjectDetailDTO setIndustryConfigurationName(final String industryConfigurationName) {
      this.industryConfigurationName = industryConfigurationName;
      return this;
   }

   public CrmRemainderCanEstablishProjectDetailDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmRemainderCanEstablishProjectDetailDTO(id="
         + this.getId()
         + ", businessName="
         + this.getBusinessName()
         + ", regionNameList="
         + this.getRegionNameList()
         + ", industryConfigurationName="
         + this.getIndustryConfigurationName()
         + ", departmentName="
         + this.getDepartmentName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmRemainderCanEstablishProjectDetailDTO)) {
         return false;
      }

      CrmRemainderCanEstablishProjectDetailDTO other = (CrmRemainderCanEstablishProjectDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$businessName = this.getBusinessName();
         Object other$businessName = other.getBusinessName();
         if (this$businessName == null ? other$businessName == null : this$businessName.equals(other$businessName)) {
            Object this$regionNameList = this.getRegionNameList();
            Object other$regionNameList = other.getRegionNameList();
            if (this$regionNameList == null ? other$regionNameList == null : this$regionNameList.equals(other$regionNameList)) {
               Object this$industryConfigurationName = this.getIndustryConfigurationName();
               Object other$industryConfigurationName = other.getIndustryConfigurationName();
               if (this$industryConfigurationName == null
                  ? other$industryConfigurationName == null
                  : this$industryConfigurationName.equals(other$industryConfigurationName)) {
                  Object this$departmentName = this.getDepartmentName();
                  Object other$departmentName = other.getDepartmentName();
                  return this$departmentName == null ? other$departmentName == null : this$departmentName.equals(other$departmentName);
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
      return other instanceof CrmRemainderCanEstablishProjectDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $businessName = this.getBusinessName();
      result = result * 59 + ($businessName == null ? 43 : $businessName.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
      Object $industryConfigurationName = this.getIndustryConfigurationName();
      result = result * 59 + ($industryConfigurationName == null ? 43 : $industryConfigurationName.hashCode());
      Object $departmentName = this.getDepartmentName();
      return result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
   }

   public static class CrmRemainderCanEstablishProjectDetailDTOBuilder {
      private Long id;
      private String businessName;
      private String regionNameList;
      private String industryConfigurationName;
      private String departmentName;

      CrmRemainderCanEstablishProjectDetailDTOBuilder() {
      }

      public CrmRemainderCanEstablishProjectDetailDTO.CrmRemainderCanEstablishProjectDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmRemainderCanEstablishProjectDetailDTO.CrmRemainderCanEstablishProjectDetailDTOBuilder businessName(final String businessName) {
         this.businessName = businessName;
         return this;
      }

      public CrmRemainderCanEstablishProjectDetailDTO.CrmRemainderCanEstablishProjectDetailDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmRemainderCanEstablishProjectDetailDTO.CrmRemainderCanEstablishProjectDetailDTOBuilder industryConfigurationName(
         final String industryConfigurationName
      ) {
         this.industryConfigurationName = industryConfigurationName;
         return this;
      }

      public CrmRemainderCanEstablishProjectDetailDTO.CrmRemainderCanEstablishProjectDetailDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmRemainderCanEstablishProjectDetailDTO build() {
         return new CrmRemainderCanEstablishProjectDetailDTO(
            this.id, this.businessName, this.regionNameList, this.industryConfigurationName, this.departmentName
         );
      }

      @Override
      public String toString() {
         return "CrmRemainderCanEstablishProjectDetailDTO.CrmRemainderCanEstablishProjectDetailDTOBuilder(id="
            + this.id
            + ", businessName="
            + this.businessName
            + ", regionNameList="
            + this.regionNameList
            + ", industryConfigurationName="
            + this.industryConfigurationName
            + ", departmentName="
            + this.departmentName
            + ")";
      }
   }
}

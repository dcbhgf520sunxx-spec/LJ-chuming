package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import java.util.List;

@ApiModel("SHR返回对象")
public class SHRDeptInfoDTO {
   @JsonProperty("部门编码")
   private String orgCode;
   @JsonProperty("部门名称")
   private String orgName;
   @JsonProperty("上级部门编码")
   private String parentOrgCode;
   @JsonProperty("上级部门名称")
   private String parentOrgName;
   private List<SHRDeptInfoDTO> children = new ArrayList<>();

   public static SHRDeptInfoDTO.SHRDeptInfoDTOBuilder builder() {
      return new SHRDeptInfoDTO.SHRDeptInfoDTOBuilder();
   }

   public SHRDeptInfoDTO() {
   }

   public SHRDeptInfoDTO(
      final String orgCode, final String orgName, final String parentOrgCode, final String parentOrgName, final List<SHRDeptInfoDTO> children
   ) {
      this.orgCode = orgCode;
      this.orgName = orgName;
      this.parentOrgCode = parentOrgCode;
      this.parentOrgName = parentOrgName;
      this.children = children;
   }

   public String getOrgCode() {
      return this.orgCode;
   }

   public String getOrgName() {
      return this.orgName;
   }

   public String getParentOrgCode() {
      return this.parentOrgCode;
   }

   public String getParentOrgName() {
      return this.parentOrgName;
   }

   public List<SHRDeptInfoDTO> getChildren() {
      return this.children;
   }

   @JsonProperty("部门编码")
   public SHRDeptInfoDTO setOrgCode(final String orgCode) {
      this.orgCode = orgCode;
      return this;
   }

   @JsonProperty("部门名称")
   public SHRDeptInfoDTO setOrgName(final String orgName) {
      this.orgName = orgName;
      return this;
   }

   @JsonProperty("上级部门编码")
   public SHRDeptInfoDTO setParentOrgCode(final String parentOrgCode) {
      this.parentOrgCode = parentOrgCode;
      return this;
   }

   @JsonProperty("上级部门名称")
   public SHRDeptInfoDTO setParentOrgName(final String parentOrgName) {
      this.parentOrgName = parentOrgName;
      return this;
   }

   public SHRDeptInfoDTO setChildren(final List<SHRDeptInfoDTO> children) {
      this.children = children;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SHRDeptInfoDTO)) {
         return false;
      }

      SHRDeptInfoDTO other = (SHRDeptInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orgCode = this.getOrgCode();
      Object other$orgCode = other.getOrgCode();
      if (this$orgCode == null ? other$orgCode == null : this$orgCode.equals(other$orgCode)) {
         Object this$orgName = this.getOrgName();
         Object other$orgName = other.getOrgName();
         if (this$orgName == null ? other$orgName == null : this$orgName.equals(other$orgName)) {
            Object this$parentOrgCode = this.getParentOrgCode();
            Object other$parentOrgCode = other.getParentOrgCode();
            if (this$parentOrgCode == null ? other$parentOrgCode == null : this$parentOrgCode.equals(other$parentOrgCode)) {
               Object this$parentOrgName = this.getParentOrgName();
               Object other$parentOrgName = other.getParentOrgName();
               if (this$parentOrgName == null ? other$parentOrgName == null : this$parentOrgName.equals(other$parentOrgName)) {
                  Object this$children = this.getChildren();
                  Object other$children = other.getChildren();
                  return this$children == null ? other$children == null : this$children.equals(other$children);
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
      return other instanceof SHRDeptInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orgCode = this.getOrgCode();
      result = result * 59 + ($orgCode == null ? 43 : $orgCode.hashCode());
      Object $orgName = this.getOrgName();
      result = result * 59 + ($orgName == null ? 43 : $orgName.hashCode());
      Object $parentOrgCode = this.getParentOrgCode();
      result = result * 59 + ($parentOrgCode == null ? 43 : $parentOrgCode.hashCode());
      Object $parentOrgName = this.getParentOrgName();
      result = result * 59 + ($parentOrgName == null ? 43 : $parentOrgName.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SHRDeptInfoDTO(orgCode="
         + this.getOrgCode()
         + ", orgName="
         + this.getOrgName()
         + ", parentOrgCode="
         + this.getParentOrgCode()
         + ", parentOrgName="
         + this.getParentOrgName()
         + ", children="
         + this.getChildren()
         + ")";
   }

   public static class SHRDeptInfoDTOBuilder {
      private String orgCode;
      private String orgName;
      private String parentOrgCode;
      private String parentOrgName;
      private List<SHRDeptInfoDTO> children;

      SHRDeptInfoDTOBuilder() {
      }

      @JsonProperty("部门编码")
      public SHRDeptInfoDTO.SHRDeptInfoDTOBuilder orgCode(final String orgCode) {
         this.orgCode = orgCode;
         return this;
      }

      @JsonProperty("部门名称")
      public SHRDeptInfoDTO.SHRDeptInfoDTOBuilder orgName(final String orgName) {
         this.orgName = orgName;
         return this;
      }

      @JsonProperty("上级部门编码")
      public SHRDeptInfoDTO.SHRDeptInfoDTOBuilder parentOrgCode(final String parentOrgCode) {
         this.parentOrgCode = parentOrgCode;
         return this;
      }

      @JsonProperty("上级部门名称")
      public SHRDeptInfoDTO.SHRDeptInfoDTOBuilder parentOrgName(final String parentOrgName) {
         this.parentOrgName = parentOrgName;
         return this;
      }

      public SHRDeptInfoDTO.SHRDeptInfoDTOBuilder children(final List<SHRDeptInfoDTO> children) {
         this.children = children;
         return this;
      }

      public SHRDeptInfoDTO build() {
         return new SHRDeptInfoDTO(this.orgCode, this.orgName, this.parentOrgCode, this.parentOrgName, this.children);
      }

      @Override
      public String toString() {
         return "SHRDeptInfoDTO.SHRDeptInfoDTOBuilder(orgCode="
            + this.orgCode
            + ", orgName="
            + this.orgName
            + ", parentOrgCode="
            + this.parentOrgCode
            + ", parentOrgName="
            + this.parentOrgName
            + ", children="
            + this.children
            + ")";
      }
   }
}

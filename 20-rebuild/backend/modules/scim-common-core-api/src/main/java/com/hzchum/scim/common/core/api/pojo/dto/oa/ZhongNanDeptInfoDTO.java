package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import java.util.List;

@ApiModel("OA返回对象")
public class ZhongNanDeptInfoDTO {
   @JsonProperty("部门id")
   private String id;
   @JsonProperty("部门名称")
   private String departmentname;
   @JsonProperty("上级部门id")
   private String supdepid;
   private List<ZhongNanDeptInfoDTO> children = new ArrayList<>();

   public static ZhongNanDeptInfoDTO.ZhongNanDeptInfoDTOBuilder builder() {
      return new ZhongNanDeptInfoDTO.ZhongNanDeptInfoDTOBuilder();
   }

   public ZhongNanDeptInfoDTO() {
   }

   public ZhongNanDeptInfoDTO(final String id, final String departmentname, final String supdepid, final List<ZhongNanDeptInfoDTO> children) {
      this.id = id;
      this.departmentname = departmentname;
      this.supdepid = supdepid;
      this.children = children;
   }

   public String getId() {
      return this.id;
   }

   public String getDepartmentname() {
      return this.departmentname;
   }

   public String getSupdepid() {
      return this.supdepid;
   }

   public List<ZhongNanDeptInfoDTO> getChildren() {
      return this.children;
   }

   @JsonProperty("部门id")
   public ZhongNanDeptInfoDTO setId(final String id) {
      this.id = id;
      return this;
   }

   @JsonProperty("部门名称")
   public ZhongNanDeptInfoDTO setDepartmentname(final String departmentname) {
      this.departmentname = departmentname;
      return this;
   }

   @JsonProperty("上级部门id")
   public ZhongNanDeptInfoDTO setSupdepid(final String supdepid) {
      this.supdepid = supdepid;
      return this;
   }

   public ZhongNanDeptInfoDTO setChildren(final List<ZhongNanDeptInfoDTO> children) {
      this.children = children;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZhongNanDeptInfoDTO)) {
         return false;
      }

      ZhongNanDeptInfoDTO other = (ZhongNanDeptInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$departmentname = this.getDepartmentname();
         Object other$departmentname = other.getDepartmentname();
         if (this$departmentname == null ? other$departmentname == null : this$departmentname.equals(other$departmentname)) {
            Object this$supdepid = this.getSupdepid();
            Object other$supdepid = other.getSupdepid();
            if (this$supdepid == null ? other$supdepid == null : this$supdepid.equals(other$supdepid)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ZhongNanDeptInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $departmentname = this.getDepartmentname();
      result = result * 59 + ($departmentname == null ? 43 : $departmentname.hashCode());
      Object $supdepid = this.getSupdepid();
      result = result * 59 + ($supdepid == null ? 43 : $supdepid.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanDeptInfoDTO(id="
         + this.getId()
         + ", departmentname="
         + this.getDepartmentname()
         + ", supdepid="
         + this.getSupdepid()
         + ", children="
         + this.getChildren()
         + ")";
   }

   public static class ZhongNanDeptInfoDTOBuilder {
      private String id;
      private String departmentname;
      private String supdepid;
      private List<ZhongNanDeptInfoDTO> children;

      ZhongNanDeptInfoDTOBuilder() {
      }

      @JsonProperty("部门id")
      public ZhongNanDeptInfoDTO.ZhongNanDeptInfoDTOBuilder id(final String id) {
         this.id = id;
         return this;
      }

      @JsonProperty("部门名称")
      public ZhongNanDeptInfoDTO.ZhongNanDeptInfoDTOBuilder departmentname(final String departmentname) {
         this.departmentname = departmentname;
         return this;
      }

      @JsonProperty("上级部门id")
      public ZhongNanDeptInfoDTO.ZhongNanDeptInfoDTOBuilder supdepid(final String supdepid) {
         this.supdepid = supdepid;
         return this;
      }

      public ZhongNanDeptInfoDTO.ZhongNanDeptInfoDTOBuilder children(final List<ZhongNanDeptInfoDTO> children) {
         this.children = children;
         return this;
      }

      public ZhongNanDeptInfoDTO build() {
         return new ZhongNanDeptInfoDTO(this.id, this.departmentname, this.supdepid, this.children);
      }

      @Override
      public String toString() {
         return "ZhongNanDeptInfoDTO.ZhongNanDeptInfoDTOBuilder(id="
            + this.id
            + ", departmentname="
            + this.departmentname
            + ", supdepid="
            + this.supdepid
            + ", children="
            + this.children
            + ")";
      }
   }
}

package com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Delete;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingArtifactTypeConfigVO", description = "构件种类配置VO ")
public class MesBuildingArtifactTypeConfigVO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "构件种类配置id不能为空", groups = {Delete.class, Update.class})
   private Long id;
   @ApiModelProperty(name = "typeName", value = "构件种类名称")
   @NotNull(message = "构件种类名称不能为空", groups = Add.class)
   private String typeName;
   @ApiModelProperty(name = "typeName", value = "清单构件编号")
   private Set<String> inventoryNames;

   public static MesBuildingArtifactTypeConfigVO.MesBuildingArtifactTypeConfigVOBuilder builder() {
      return new MesBuildingArtifactTypeConfigVO.MesBuildingArtifactTypeConfigVOBuilder();
   }

   public MesBuildingArtifactTypeConfigVO() {
   }

   public MesBuildingArtifactTypeConfigVO(final Long id, final String typeName, final Set<String> inventoryNames) {
      this.id = id;
      this.typeName = typeName;
      this.inventoryNames = inventoryNames;
   }

   public Long getId() {
      return this.id;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public Set<String> getInventoryNames() {
      return this.inventoryNames;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setInventoryNames(final Set<String> inventoryNames) {
      this.inventoryNames = inventoryNames;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactTypeConfigVO(id=" + this.getId() + ", typeName=" + this.getTypeName() + ", inventoryNames=" + this.getInventoryNames() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactTypeConfigVO)) {
         return false;
      }

      MesBuildingArtifactTypeConfigVO other = (MesBuildingArtifactTypeConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$typeName = this.getTypeName();
         Object other$typeName = other.getTypeName();
         if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
            Object this$inventoryNames = this.getInventoryNames();
            Object other$inventoryNames = other.getInventoryNames();
            return this$inventoryNames == null ? other$inventoryNames == null : this$inventoryNames.equals(other$inventoryNames);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactTypeConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $inventoryNames = this.getInventoryNames();
      return result * 59 + ($inventoryNames == null ? 43 : $inventoryNames.hashCode());
   }

   public static class MesBuildingArtifactTypeConfigVOBuilder {
      private Long id;
      private String typeName;
      private Set<String> inventoryNames;

      MesBuildingArtifactTypeConfigVOBuilder() {
      }

      public MesBuildingArtifactTypeConfigVO.MesBuildingArtifactTypeConfigVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingArtifactTypeConfigVO.MesBuildingArtifactTypeConfigVOBuilder typeName(final String typeName) {
         this.typeName = typeName;
         return this;
      }

      public MesBuildingArtifactTypeConfigVO.MesBuildingArtifactTypeConfigVOBuilder inventoryNames(final Set<String> inventoryNames) {
         this.inventoryNames = inventoryNames;
         return this;
      }

      public MesBuildingArtifactTypeConfigVO build() {
         return new MesBuildingArtifactTypeConfigVO(this.id, this.typeName, this.inventoryNames);
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactTypeConfigVO.MesBuildingArtifactTypeConfigVOBuilder(id="
            + this.id
            + ", typeName="
            + this.typeName
            + ", inventoryNames="
            + this.inventoryNames
            + ")";
      }
   }
}

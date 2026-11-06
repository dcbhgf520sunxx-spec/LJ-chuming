package com.hzchum.scim.mes.enclosure.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectSchedulingDetailDO", description = "项目信息 ")
public class ProjectSchedulingTreeDO extends ProjectDetailDO {
   @ApiModelProperty(name = "id", notes = "项目id", value = "项目id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "shortName", notes = "项目简称", value = "项目简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "monomerSchedulingDetailDO", notes = "单体信息")
   @JsonProperty("monomerSchedulingDetailDO")
   @JSONField(name = "monomerSchedulingDetailDO")
   private List<MonomerSchedulingTreeDO> monomerSchedulingTreeDO;

   @Override
   public Long getId() {
      return this.id;
   }

   @Override
   public String getShortName() {
      return this.shortName;
   }

   public List<MonomerSchedulingTreeDO> getMonomerSchedulingTreeDO() {
      return this.monomerSchedulingTreeDO;
   }

   @JsonProperty("id")
   public ProjectSchedulingTreeDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("shortName")
   public ProjectSchedulingTreeDO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("monomerSchedulingDetailDO")
   public ProjectSchedulingTreeDO setMonomerSchedulingTreeDO(final List<MonomerSchedulingTreeDO> monomerSchedulingTreeDO) {
      this.monomerSchedulingTreeDO = monomerSchedulingTreeDO;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSchedulingTreeDO(id="
         + this.getId()
         + ", shortName="
         + this.getShortName()
         + ", monomerSchedulingTreeDO="
         + this.getMonomerSchedulingTreeDO()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSchedulingTreeDO)) {
         return false;
      }

      ProjectSchedulingTreeDO other = (ProjectSchedulingTreeDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$shortName = this.getShortName();
         Object other$shortName = other.getShortName();
         if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
            Object this$monomerSchedulingTreeDO = this.getMonomerSchedulingTreeDO();
            Object other$monomerSchedulingTreeDO = other.getMonomerSchedulingTreeDO();
            return this$monomerSchedulingTreeDO == null
               ? other$monomerSchedulingTreeDO == null
               : this$monomerSchedulingTreeDO.equals(other$monomerSchedulingTreeDO);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSchedulingTreeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $monomerSchedulingTreeDO = this.getMonomerSchedulingTreeDO();
      return result * 59 + ($monomerSchedulingTreeDO == null ? 43 : $monomerSchedulingTreeDO.hashCode());
   }
}

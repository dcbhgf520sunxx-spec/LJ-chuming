package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "OutPreparationFreezeDO对象", description = "备料冻结出库记录 ")
@Entity
@TableName("out_preparation_freeze")
@Table(name = "out_preparation_freeze")
public class OutPreparationFreezeDO implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "materialId", notes = "物料id")
   @JsonProperty("materialId")
   @JSONField(name = "materialId")
   @TableField("material_id")
   @Column(name = "material_id")
   private String materialId;
   @ApiModelProperty(name = "projectId", value = "项目id(出库目标)")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "outQuantity", value = "冻结出库数量")
   @JsonProperty("outQuantity")
   @JSONField(name = "outQuantity")
   @TableField("out_quantity")
   @Column(name = "out_quantity")
   private BigDecimal outQuantity;
   @ApiModelProperty(name = "outMete", value = "冻结出库核算量")
   @JsonProperty("outMete")
   @JSONField(name = "outMete")
   @TableField("out_mete")
   @Column(name = "out_mete")
   private BigDecimal outMete;
   @ApiModelProperty(hidden = true)
   @Version
   @Column
   @JsonIgnore
   private Integer version;

   public static OutPreparationFreezeDO.OutPreparationFreezeDOBuilder builder() {
      return new OutPreparationFreezeDO.OutPreparationFreezeDOBuilder();
   }

   public OutPreparationFreezeDO() {
   }

   public OutPreparationFreezeDO(
      final Long id, final String materialId, final Long projectId, final BigDecimal outQuantity, final BigDecimal outMete, final Integer version
   ) {
      this.id = id;
      this.materialId = materialId;
      this.projectId = projectId;
      this.outQuantity = outQuantity;
      this.outMete = outMete;
      this.version = version;
   }

   public Long getId() {
      return this.id;
   }

   public String getMaterialId() {
      return this.materialId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getOutQuantity() {
      return this.outQuantity;
   }

   public BigDecimal getOutMete() {
      return this.outMete;
   }

   public Integer getVersion() {
      return this.version;
   }

   @JsonProperty("id")
   public OutPreparationFreezeDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("materialId")
   public OutPreparationFreezeDO setMaterialId(final String materialId) {
      this.materialId = materialId;
      return this;
   }

   @JsonProperty("projectId")
   public OutPreparationFreezeDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("outQuantity")
   public OutPreparationFreezeDO setOutQuantity(final BigDecimal outQuantity) {
      this.outQuantity = outQuantity;
      return this;
   }

   @JsonProperty("outMete")
   public OutPreparationFreezeDO setOutMete(final BigDecimal outMete) {
      this.outMete = outMete;
      return this;
   }

   @JsonIgnore
   public OutPreparationFreezeDO setVersion(final Integer version) {
      this.version = version;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutPreparationFreezeDO)) {
         return false;
      }

      OutPreparationFreezeDO other = (OutPreparationFreezeDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$version = this.getVersion();
            Object other$version = other.getVersion();
            if (this$version == null ? other$version == null : this$version.equals(other$version)) {
               Object this$materialId = this.getMaterialId();
               Object other$materialId = other.getMaterialId();
               if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
                  Object this$outQuantity = this.getOutQuantity();
                  Object other$outQuantity = other.getOutQuantity();
                  if (this$outQuantity == null ? other$outQuantity == null : this$outQuantity.equals(other$outQuantity)) {
                     Object this$outMete = this.getOutMete();
                     Object other$outMete = other.getOutMete();
                     return this$outMete == null ? other$outMete == null : this$outMete.equals(other$outMete);
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
      return other instanceof OutPreparationFreezeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $outQuantity = this.getOutQuantity();
      result = result * 59 + ($outQuantity == null ? 43 : $outQuantity.hashCode());
      Object $outMete = this.getOutMete();
      return result * 59 + ($outMete == null ? 43 : $outMete.hashCode());
   }

   @Override
   public String toString() {
      return "OutPreparationFreezeDO(id="
         + this.getId()
         + ", materialId="
         + this.getMaterialId()
         + ", projectId="
         + this.getProjectId()
         + ", outQuantity="
         + this.getOutQuantity()
         + ", outMete="
         + this.getOutMete()
         + ", version="
         + this.getVersion()
         + ")";
   }

   public static class OutPreparationFreezeDOBuilder {
      private Long id;
      private String materialId;
      private Long projectId;
      private BigDecimal outQuantity;
      private BigDecimal outMete;
      private Integer version;

      OutPreparationFreezeDOBuilder() {
      }

      @JsonProperty("id")
      public OutPreparationFreezeDO.OutPreparationFreezeDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("materialId")
      public OutPreparationFreezeDO.OutPreparationFreezeDOBuilder materialId(final String materialId) {
         this.materialId = materialId;
         return this;
      }

      @JsonProperty("projectId")
      public OutPreparationFreezeDO.OutPreparationFreezeDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("outQuantity")
      public OutPreparationFreezeDO.OutPreparationFreezeDOBuilder outQuantity(final BigDecimal outQuantity) {
         this.outQuantity = outQuantity;
         return this;
      }

      @JsonProperty("outMete")
      public OutPreparationFreezeDO.OutPreparationFreezeDOBuilder outMete(final BigDecimal outMete) {
         this.outMete = outMete;
         return this;
      }

      @JsonIgnore
      public OutPreparationFreezeDO.OutPreparationFreezeDOBuilder version(final Integer version) {
         this.version = version;
         return this;
      }

      public OutPreparationFreezeDO build() {
         return new OutPreparationFreezeDO(this.id, this.materialId, this.projectId, this.outQuantity, this.outMete, this.version);
      }

      @Override
      public String toString() {
         return "OutPreparationFreezeDO.OutPreparationFreezeDOBuilder(id="
            + this.id
            + ", materialId="
            + this.materialId
            + ", projectId="
            + this.projectId
            + ", outQuantity="
            + this.outQuantity
            + ", outMete="
            + this.outMete
            + ", version="
            + this.version
            + ")";
      }
   }
}

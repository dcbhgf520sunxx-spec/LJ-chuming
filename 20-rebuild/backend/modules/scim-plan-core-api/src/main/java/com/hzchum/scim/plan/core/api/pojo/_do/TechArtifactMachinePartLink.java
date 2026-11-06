package com.hzchum.scim.plan.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "TechArtifactMachinePartLink对象", description = "构件零件关联 ")
@Entity
@TableName("tech_artifact_machine_part_link")
@Table(
   name = "tech_artifact_machine_part_link",
   indexes = {@Index(name = "artifact_id", columnList = "artifact_id"), @Index(name = "machine_part_id", columnList = "machine_part_id")}
)
public class TechArtifactMachinePartLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "artifactId", value = "构件id")
   @JsonProperty("artifactId")
   @JSONField(name = "artifactId")
   @TableField("artifact_id")
   @Column(name = "artifact_id")
   private Long artifactId;
   @ApiModelProperty(name = "machinePartId", value = "零件id")
   @JsonProperty("machinePartId")
   @JSONField(name = "machinePartId")
   @TableField("machine_part_id")
   @Column(name = "machine_part_id")
   private Long machinePartId;
   @ApiModelProperty(name = "quantity", value = "零件和构件的数量比例")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) comment '零件和构件的数量比例'")
   private Integer quantity;
   @ApiModelProperty(name = "remark", value = "该构件内零件备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024) comment '该构件内零件备注'")
   private String remark;

   public static TechArtifactMachinePartLink.TechArtifactMachinePartLinkBuilder builder() {
      return new TechArtifactMachinePartLink.TechArtifactMachinePartLinkBuilder();
   }

   public TechArtifactMachinePartLink() {
   }

   public TechArtifactMachinePartLink(final Long id, final Long artifactId, final Long machinePartId, final Integer quantity, final String remark) {
      this.id = id;
      this.artifactId = artifactId;
      this.machinePartId = machinePartId;
      this.quantity = quantity;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Long getMachinePartId() {
      return this.machinePartId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public TechArtifactMachinePartLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("artifactId")
   public TechArtifactMachinePartLink setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   @JsonProperty("machinePartId")
   public TechArtifactMachinePartLink setMachinePartId(final Long machinePartId) {
      this.machinePartId = machinePartId;
      return this;
   }

   public TechArtifactMachinePartLink setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechArtifactMachinePartLink setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactMachinePartLink(id="
         + this.getId()
         + ", artifactId="
         + this.getArtifactId()
         + ", machinePartId="
         + this.getMachinePartId()
         + ", quantity="
         + this.getQuantity()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactMachinePartLink)) {
         return false;
      }

      TechArtifactMachinePartLink other = (TechArtifactMachinePartLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactId = this.getArtifactId();
         Object other$artifactId = other.getArtifactId();
         if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
            Object this$machinePartId = this.getMachinePartId();
            Object other$machinePartId = other.getMachinePartId();
            if (this$machinePartId == null ? other$machinePartId == null : this$machinePartId.equals(other$machinePartId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactMachinePartLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $machinePartId = this.getMachinePartId();
      result = result * 59 + ($machinePartId == null ? 43 : $machinePartId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class TechArtifactMachinePartLinkBuilder {
      private Long id;
      private Long artifactId;
      private Long machinePartId;
      private Integer quantity;
      private String remark;

      TechArtifactMachinePartLinkBuilder() {
      }

      @JsonProperty("id")
      public TechArtifactMachinePartLink.TechArtifactMachinePartLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("artifactId")
      public TechArtifactMachinePartLink.TechArtifactMachinePartLinkBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      @JsonProperty("machinePartId")
      public TechArtifactMachinePartLink.TechArtifactMachinePartLinkBuilder machinePartId(final Long machinePartId) {
         this.machinePartId = machinePartId;
         return this;
      }

      public TechArtifactMachinePartLink.TechArtifactMachinePartLinkBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechArtifactMachinePartLink.TechArtifactMachinePartLinkBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechArtifactMachinePartLink build() {
         return new TechArtifactMachinePartLink(this.id, this.artifactId, this.machinePartId, this.quantity, this.remark);
      }

      @Override
      public String toString() {
         return "TechArtifactMachinePartLink.TechArtifactMachinePartLinkBuilder(id="
            + this.id
            + ", artifactId="
            + this.artifactId
            + ", machinePartId="
            + this.machinePartId
            + ", quantity="
            + this.quantity
            + ", remark="
            + this.remark
            + ")";
      }
   }
}

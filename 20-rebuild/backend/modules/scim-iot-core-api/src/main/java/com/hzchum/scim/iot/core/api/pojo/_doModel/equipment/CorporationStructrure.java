package com.hzchum.scim.iot.core.api.pojo._doModel.equipment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CorporationStructrure对象", description = "公司结构表")
@Entity
@TableName("corporation_structrure")
@Table(name = "corporation_structrure")
@org.hibernate.annotations.Table(appliesTo = "corporation_structrure", comment = "公司结构表")
public class CorporationStructrure extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id", notes = "主键id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "iotId", value = "物联主键", notes = "物联主键")
   @TableField("iot_id")
   @Column(name = "iot_id", columnDefinition = "bigint(20)  COMMENT '物联主键'", nullable = true)
   private Long iotId;
   @ApiModelProperty(name = "pid", value = "父级id", notes = "父级id")
   @TableField("pid")
   @Column(name = "pid", columnDefinition = "bigint(20)  COMMENT '父级id'", nullable = true)
   private Long pid;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(20)  COMMENT '名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "type", value = "类型（1.公司，2.工厂，3.车间，4.产线，5.工位）", notes = "类型（1.公司，2.工厂，3.车间，4.产线，5.工位）")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '类型（1.公司，2.工厂，3.车间，4.产线，5.工位）'", nullable = true)
   private Integer type;
   @ApiModelProperty(name = "createBy", value = "创建人标识", notes = "创建人标识")
   @TableField("create_by")
   @Column(name = "create_by", columnDefinition = "bigint(20)  COMMENT '创建人标识'", nullable = true)
   private Long createBy;
   @ApiModelProperty(name = "updateBy", value = "更新人标识", notes = "更新人标识")
   @TableField("update_by")
   @Column(name = "update_by", columnDefinition = "bigint(20)  COMMENT '更新人标识'", nullable = true)
   private Long updateBy;

   public static CorporationStructrure.CorporationStructrureBuilder builder() {
      return new CorporationStructrure.CorporationStructrureBuilder();
   }

   public CorporationStructrure() {
   }

   public CorporationStructrure(
      final Long id, final Long iotId, final Long pid, final String name, final Integer type, final Long createBy, final Long updateBy
   ) {
      this.id = id;
      this.iotId = iotId;
      this.pid = pid;
      this.name = name;
      this.type = type;
      this.createBy = createBy;
      this.updateBy = updateBy;
   }

   public Long getId() {
      return this.id;
   }

   public Long getIotId() {
      return this.iotId;
   }

   public Long getPid() {
      return this.pid;
   }

   public String getName() {
      return this.name;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getCreateBy() {
      return this.createBy;
   }

   public Long getUpdateBy() {
      return this.updateBy;
   }

   public CorporationStructrure setId(final Long id) {
      this.id = id;
      return this;
   }

   public CorporationStructrure setIotId(final Long iotId) {
      this.iotId = iotId;
      return this;
   }

   public CorporationStructrure setPid(final Long pid) {
      this.pid = pid;
      return this;
   }

   public CorporationStructrure setName(final String name) {
      this.name = name;
      return this;
   }

   public CorporationStructrure setType(final Integer type) {
      this.type = type;
      return this;
   }

   public CorporationStructrure setCreateBy(final Long createBy) {
      this.createBy = createBy;
      return this;
   }

   public CorporationStructrure setUpdateBy(final Long updateBy) {
      this.updateBy = updateBy;
      return this;
   }

   @Override
   public String toString() {
      return "CorporationStructrure(id="
         + this.getId()
         + ", iotId="
         + this.getIotId()
         + ", pid="
         + this.getPid()
         + ", name="
         + this.getName()
         + ", type="
         + this.getType()
         + ", createBy="
         + this.getCreateBy()
         + ", updateBy="
         + this.getUpdateBy()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CorporationStructrure)) {
         return false;
      }

      CorporationStructrure other = (CorporationStructrure)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$iotId = this.getIotId();
         Object other$iotId = other.getIotId();
         if (this$iotId == null ? other$iotId == null : this$iotId.equals(other$iotId)) {
            Object this$pid = this.getPid();
            Object other$pid = other.getPid();
            if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$createBy = this.getCreateBy();
                  Object other$createBy = other.getCreateBy();
                  if (this$createBy == null ? other$createBy == null : this$createBy.equals(other$createBy)) {
                     Object this$updateBy = this.getUpdateBy();
                     Object other$updateBy = other.getUpdateBy();
                     if (this$updateBy == null ? other$updateBy == null : this$updateBy.equals(other$updateBy)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        return this$name == null ? other$name == null : this$name.equals(other$name);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CorporationStructrure;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $iotId = this.getIotId();
      result = result * 59 + ($iotId == null ? 43 : $iotId.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $createBy = this.getCreateBy();
      result = result * 59 + ($createBy == null ? 43 : $createBy.hashCode());
      Object $updateBy = this.getUpdateBy();
      result = result * 59 + ($updateBy == null ? 43 : $updateBy.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class CorporationStructrureBuilder {
      private Long id;
      private Long iotId;
      private Long pid;
      private String name;
      private Integer type;
      private Long createBy;
      private Long updateBy;

      CorporationStructrureBuilder() {
      }

      public CorporationStructrure.CorporationStructrureBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CorporationStructrure.CorporationStructrureBuilder iotId(final Long iotId) {
         this.iotId = iotId;
         return this;
      }

      public CorporationStructrure.CorporationStructrureBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      public CorporationStructrure.CorporationStructrureBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CorporationStructrure.CorporationStructrureBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public CorporationStructrure.CorporationStructrureBuilder createBy(final Long createBy) {
         this.createBy = createBy;
         return this;
      }

      public CorporationStructrure.CorporationStructrureBuilder updateBy(final Long updateBy) {
         this.updateBy = updateBy;
         return this;
      }

      public CorporationStructrure build() {
         return new CorporationStructrure(this.id, this.iotId, this.pid, this.name, this.type, this.createBy, this.updateBy);
      }

      @Override
      public String toString() {
         return "CorporationStructrure.CorporationStructrureBuilder(id="
            + this.id
            + ", iotId="
            + this.iotId
            + ", pid="
            + this.pid
            + ", name="
            + this.name
            + ", type="
            + this.type
            + ", createBy="
            + this.createBy
            + ", updateBy="
            + this.updateBy
            + ")";
      }
   }
}

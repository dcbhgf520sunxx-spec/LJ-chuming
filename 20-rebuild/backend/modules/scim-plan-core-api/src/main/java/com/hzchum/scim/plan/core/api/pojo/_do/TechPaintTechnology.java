package com.hzchum.scim.plan.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "TechPaintTechnology对象", description = "喷漆工艺表 ")
@Entity
@TableName("tech_paint_technology")
@Table(name = "tech_paint_technology", indexes = @Index(name = "project_id", columnList = "project_id"))
@org.hibernate.annotations.Table(appliesTo = "tech_paint_technology", comment = "喷漆工艺表 ")
public class TechPaintTechnology extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "工艺编号", notes = "工艺编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '工艺编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "rangeTypeEnum", value = "范围类型 1手动选择 2整个项目 4整个单体", notes = "范围类型 1手动选择 2整个项目 4整个单体")
   @TableField("range_type_enum")
   @Column(name = "range_type_enum", columnDefinition = "int(11)  COMMENT '范围类型 1手动选择 2整个项目 4整个单体'", nullable = false)
   private Integer rangeTypeEnum;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField(value = "monomer_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "maxCalculateNumber", value = "计算记录-最大流水号", notes = "计算记录-最大流水号")
   @TableField("max_calculate_number")
   @Column(name = "max_calculate_number", columnDefinition = "int(11) DEFAULT '0' COMMENT '计算记录-最大流水号'", nullable = false)
   private Integer maxCalculateNumber;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(255)  COMMENT '创建人'", nullable = false)
   private String createUserName;
   @ApiModelProperty(name = "lastEditUserId", value = "最近修改人id", notes = "最近修改人id")
   @TableField("last_edit_user_id")
   @Column(name = "last_edit_user_id", columnDefinition = "bigint(20)  COMMENT '最近修改人id'")
   private Long lastEditUserId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'")
   private String remark;

   public static TechPaintTechnology.TechPaintTechnologyBuilder builder() {
      return new TechPaintTechnology.TechPaintTechnologyBuilder();
   }

   public TechPaintTechnology() {
   }

   public TechPaintTechnology(
      final Long id,
      final String serialNumber,
      final Integer rangeTypeEnum,
      final Long projectId,
      final Long monomerId,
      final Integer maxCalculateNumber,
      final Long createUserId,
      final String createUserName,
      final Long lastEditUserId,
      final String remark
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.rangeTypeEnum = rangeTypeEnum;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.maxCalculateNumber = maxCalculateNumber;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.lastEditUserId = lastEditUserId;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getRangeTypeEnum() {
      return this.rangeTypeEnum;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getMaxCalculateNumber() {
      return this.maxCalculateNumber;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getLastEditUserId() {
      return this.lastEditUserId;
   }

   public String getRemark() {
      return this.remark;
   }

   public TechPaintTechnology setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechPaintTechnology setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechPaintTechnology setRangeTypeEnum(final Integer rangeTypeEnum) {
      this.rangeTypeEnum = rangeTypeEnum;
      return this;
   }

   public TechPaintTechnology setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechPaintTechnology setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechPaintTechnology setMaxCalculateNumber(final Integer maxCalculateNumber) {
      this.maxCalculateNumber = maxCalculateNumber;
      return this;
   }

   public TechPaintTechnology setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public TechPaintTechnology setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public TechPaintTechnology setLastEditUserId(final Long lastEditUserId) {
      this.lastEditUserId = lastEditUserId;
      return this;
   }

   public TechPaintTechnology setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "TechPaintTechnology(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", rangeTypeEnum="
         + this.getRangeTypeEnum()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", maxCalculateNumber="
         + this.getMaxCalculateNumber()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", lastEditUserId="
         + this.getLastEditUserId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechPaintTechnology)) {
         return false;
      }

      TechPaintTechnology other = (TechPaintTechnology)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$rangeTypeEnum = this.getRangeTypeEnum();
         Object other$rangeTypeEnum = other.getRangeTypeEnum();
         if (this$rangeTypeEnum == null ? other$rangeTypeEnum == null : this$rangeTypeEnum.equals(other$rangeTypeEnum)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$maxCalculateNumber = this.getMaxCalculateNumber();
                  Object other$maxCalculateNumber = other.getMaxCalculateNumber();
                  if (this$maxCalculateNumber == null ? other$maxCalculateNumber == null : this$maxCalculateNumber.equals(other$maxCalculateNumber)) {
                     Object this$createUserId = this.getCreateUserId();
                     Object other$createUserId = other.getCreateUserId();
                     if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                        Object this$lastEditUserId = this.getLastEditUserId();
                        Object other$lastEditUserId = other.getLastEditUserId();
                        if (this$lastEditUserId == null ? other$lastEditUserId == null : this$lastEditUserId.equals(other$lastEditUserId)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$createUserName = this.getCreateUserName();
                              Object other$createUserName = other.getCreateUserName();
                              if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
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
      return other instanceof TechPaintTechnology;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $rangeTypeEnum = this.getRangeTypeEnum();
      result = result * 59 + ($rangeTypeEnum == null ? 43 : $rangeTypeEnum.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $maxCalculateNumber = this.getMaxCalculateNumber();
      result = result * 59 + ($maxCalculateNumber == null ? 43 : $maxCalculateNumber.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $lastEditUserId = this.getLastEditUserId();
      result = result * 59 + ($lastEditUserId == null ? 43 : $lastEditUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class TechPaintTechnologyBuilder {
      private Long id;
      private String serialNumber;
      private Integer rangeTypeEnum;
      private Long projectId;
      private Long monomerId;
      private Integer maxCalculateNumber;
      private Long createUserId;
      private String createUserName;
      private Long lastEditUserId;
      private String remark;

      TechPaintTechnologyBuilder() {
      }

      public TechPaintTechnology.TechPaintTechnologyBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechPaintTechnology.TechPaintTechnologyBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechPaintTechnology.TechPaintTechnologyBuilder rangeTypeEnum(final Integer rangeTypeEnum) {
         this.rangeTypeEnum = rangeTypeEnum;
         return this;
      }

      public TechPaintTechnology.TechPaintTechnologyBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechPaintTechnology.TechPaintTechnologyBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechPaintTechnology.TechPaintTechnologyBuilder maxCalculateNumber(final Integer maxCalculateNumber) {
         this.maxCalculateNumber = maxCalculateNumber;
         return this;
      }

      public TechPaintTechnology.TechPaintTechnologyBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public TechPaintTechnology.TechPaintTechnologyBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public TechPaintTechnology.TechPaintTechnologyBuilder lastEditUserId(final Long lastEditUserId) {
         this.lastEditUserId = lastEditUserId;
         return this;
      }

      public TechPaintTechnology.TechPaintTechnologyBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechPaintTechnology build() {
         return new TechPaintTechnology(
            this.id,
            this.serialNumber,
            this.rangeTypeEnum,
            this.projectId,
            this.monomerId,
            this.maxCalculateNumber,
            this.createUserId,
            this.createUserName,
            this.lastEditUserId,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "TechPaintTechnology.TechPaintTechnologyBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", rangeTypeEnum="
            + this.rangeTypeEnum
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", maxCalculateNumber="
            + this.maxCalculateNumber
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", lastEditUserId="
            + this.lastEditUserId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}

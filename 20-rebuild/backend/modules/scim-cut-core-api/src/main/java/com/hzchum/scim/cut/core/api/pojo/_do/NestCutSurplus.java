package com.hzchum.scim.cut.core.api.pojo._do;

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
import javax.persistence.Table;

@ApiModel(value = "NestCutSurplus对象", description = "")
@Entity
@TableName("nest_cut_surplus")
@Table(name = "nest_cut_surplus")
public class NestCutSurplus extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "plantNo")
   @JsonProperty("plantNo")
   @JSONField(name = "plantNo")
   @TableField("plant_no")
   @Column(name = "plant_no", columnDefinition = "varchar(255)  COMMENT '钢板编号'", nullable = true)
   private String plantNo;
   @ApiModelProperty(name = "surplusState")
   @JsonProperty("surplusState")
   @JSONField(name = "surplusState")
   @TableField("surplus_state")
   @Column(name = "surplus_state", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusState;
   @ApiModelProperty(name = "surplusPictureName")
   @JsonProperty("surplusPictureName")
   @JSONField(name = "surplusPictureName")
   @TableField("surplus_picture_name")
   @Column(name = "surplus_picture_name", columnDefinition = "varchar(255)  COMMENT '余料图名'", nullable = true)
   private String surplusPictureName;
   @ApiModelProperty(name = "surplusPictureUrl")
   @JsonProperty("surplusPictureUrl")
   @JSONField(name = "surplusPictureUrl")
   @TableField("surplus_picture_url")
   @Column(name = "surplus_picture_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusPictureUrl;
   @ApiModelProperty(name = "cutInstructionId")
   @JsonProperty("cutInstructionId")
   @JSONField(name = "cutInstructionId")
   @TableField("cut_instruction_id")
   @Column(name = "cut_instruction_id", columnDefinition = "varchar(255)  COMMENT '切割指令号=nc文件编号'", nullable = true)
   private String cutInstructionId;
   @ApiModelProperty(name = "cutTaskId")
   @JsonProperty("cutTaskId")
   @JSONField(name = "cutTaskId")
   @TableField("cut_task_id")
   @Column(name = "cut_task_id", columnDefinition = "varchar(255)  COMMENT '任务id'", nullable = true)
   private String cutTaskId;
   @ApiModelProperty(name = "material")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String material;
   @ApiModelProperty(name = "num")
   @JsonProperty("num")
   @JSONField(name = "num")
   @TableField("num")
   @Column(name = "num", columnDefinition = "int(11) default 0 comment '数量'", nullable = true)
   private Integer num;
   @ApiModelProperty(name = "number")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "varchar(255)  COMMENT '余料编号'", nullable = true)
   private String number;
   @ApiModelProperty(name = "specification")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "taskId")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String taskId;
   @ApiModelProperty(name = "weight")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String weight;

   public static NestCutSurplus.NestCutSurplusBuilder builder() {
      return new NestCutSurplus.NestCutSurplusBuilder();
   }

   public NestCutSurplus() {
   }

   public NestCutSurplus(
      final Long id,
      final String plantNo,
      final String surplusState,
      final String surplusPictureName,
      final String surplusPictureUrl,
      final String cutInstructionId,
      final String cutTaskId,
      final String material,
      final Integer num,
      final String number,
      final String specification,
      final String taskId,
      final String weight
   ) {
      this.id = id;
      this.plantNo = plantNo;
      this.surplusState = surplusState;
      this.surplusPictureName = surplusPictureName;
      this.surplusPictureUrl = surplusPictureUrl;
      this.cutInstructionId = cutInstructionId;
      this.cutTaskId = cutTaskId;
      this.material = material;
      this.num = num;
      this.number = number;
      this.specification = specification;
      this.taskId = taskId;
      this.weight = weight;
   }

   public Long getId() {
      return this.id;
   }

   public String getPlantNo() {
      return this.plantNo;
   }

   public String getSurplusState() {
      return this.surplusState;
   }

   public String getSurplusPictureName() {
      return this.surplusPictureName;
   }

   public String getSurplusPictureUrl() {
      return this.surplusPictureUrl;
   }

   public String getCutInstructionId() {
      return this.cutInstructionId;
   }

   public String getCutTaskId() {
      return this.cutTaskId;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getNum() {
      return this.num;
   }

   public String getNumber() {
      return this.number;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getTaskId() {
      return this.taskId;
   }

   public String getWeight() {
      return this.weight;
   }

   @JsonProperty("id")
   public NestCutSurplus setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("plantNo")
   public NestCutSurplus setPlantNo(final String plantNo) {
      this.plantNo = plantNo;
      return this;
   }

   @JsonProperty("surplusState")
   public NestCutSurplus setSurplusState(final String surplusState) {
      this.surplusState = surplusState;
      return this;
   }

   @JsonProperty("surplusPictureName")
   public NestCutSurplus setSurplusPictureName(final String surplusPictureName) {
      this.surplusPictureName = surplusPictureName;
      return this;
   }

   @JsonProperty("surplusPictureUrl")
   public NestCutSurplus setSurplusPictureUrl(final String surplusPictureUrl) {
      this.surplusPictureUrl = surplusPictureUrl;
      return this;
   }

   @JsonProperty("cutInstructionId")
   public NestCutSurplus setCutInstructionId(final String cutInstructionId) {
      this.cutInstructionId = cutInstructionId;
      return this;
   }

   @JsonProperty("cutTaskId")
   public NestCutSurplus setCutTaskId(final String cutTaskId) {
      this.cutTaskId = cutTaskId;
      return this;
   }

   @JsonProperty("material")
   public NestCutSurplus setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("num")
   public NestCutSurplus setNum(final Integer num) {
      this.num = num;
      return this;
   }

   @JsonProperty("number")
   public NestCutSurplus setNumber(final String number) {
      this.number = number;
      return this;
   }

   @JsonProperty("specification")
   public NestCutSurplus setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("taskId")
   public NestCutSurplus setTaskId(final String taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("weight")
   public NestCutSurplus setWeight(final String weight) {
      this.weight = weight;
      return this;
   }

   @Override
   public String toString() {
      return "NestCutSurplus(id="
         + this.getId()
         + ", plantNo="
         + this.getPlantNo()
         + ", surplusState="
         + this.getSurplusState()
         + ", surplusPictureName="
         + this.getSurplusPictureName()
         + ", surplusPictureUrl="
         + this.getSurplusPictureUrl()
         + ", cutInstructionId="
         + this.getCutInstructionId()
         + ", cutTaskId="
         + this.getCutTaskId()
         + ", material="
         + this.getMaterial()
         + ", num="
         + this.getNum()
         + ", number="
         + this.getNumber()
         + ", specification="
         + this.getSpecification()
         + ", taskId="
         + this.getTaskId()
         + ", weight="
         + this.getWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestCutSurplus)) {
         return false;
      }

      NestCutSurplus other = (NestCutSurplus)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$num = this.getNum();
         Object other$num = other.getNum();
         if (this$num == null ? other$num == null : this$num.equals(other$num)) {
            Object this$plantNo = this.getPlantNo();
            Object other$plantNo = other.getPlantNo();
            if (this$plantNo == null ? other$plantNo == null : this$plantNo.equals(other$plantNo)) {
               Object this$surplusState = this.getSurplusState();
               Object other$surplusState = other.getSurplusState();
               if (this$surplusState == null ? other$surplusState == null : this$surplusState.equals(other$surplusState)) {
                  Object this$surplusPictureName = this.getSurplusPictureName();
                  Object other$surplusPictureName = other.getSurplusPictureName();
                  if (this$surplusPictureName == null ? other$surplusPictureName == null : this$surplusPictureName.equals(other$surplusPictureName)) {
                     Object this$surplusPictureUrl = this.getSurplusPictureUrl();
                     Object other$surplusPictureUrl = other.getSurplusPictureUrl();
                     if (this$surplusPictureUrl == null ? other$surplusPictureUrl == null : this$surplusPictureUrl.equals(other$surplusPictureUrl)) {
                        Object this$cutInstructionId = this.getCutInstructionId();
                        Object other$cutInstructionId = other.getCutInstructionId();
                        if (this$cutInstructionId == null ? other$cutInstructionId == null : this$cutInstructionId.equals(other$cutInstructionId)) {
                           Object this$cutTaskId = this.getCutTaskId();
                           Object other$cutTaskId = other.getCutTaskId();
                           if (this$cutTaskId == null ? other$cutTaskId == null : this$cutTaskId.equals(other$cutTaskId)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$number = this.getNumber();
                                 Object other$number = other.getNumber();
                                 if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$taskId = this.getTaskId();
                                       Object other$taskId = other.getTaskId();
                                       if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                                          Object this$weight = this.getWeight();
                                          Object other$weight = other.getWeight();
                                          return this$weight == null ? other$weight == null : this$weight.equals(other$weight);
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
      return other instanceof NestCutSurplus;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $num = this.getNum();
      result = result * 59 + ($num == null ? 43 : $num.hashCode());
      Object $plantNo = this.getPlantNo();
      result = result * 59 + ($plantNo == null ? 43 : $plantNo.hashCode());
      Object $surplusState = this.getSurplusState();
      result = result * 59 + ($surplusState == null ? 43 : $surplusState.hashCode());
      Object $surplusPictureName = this.getSurplusPictureName();
      result = result * 59 + ($surplusPictureName == null ? 43 : $surplusPictureName.hashCode());
      Object $surplusPictureUrl = this.getSurplusPictureUrl();
      result = result * 59 + ($surplusPictureUrl == null ? 43 : $surplusPictureUrl.hashCode());
      Object $cutInstructionId = this.getCutInstructionId();
      result = result * 59 + ($cutInstructionId == null ? 43 : $cutInstructionId.hashCode());
      Object $cutTaskId = this.getCutTaskId();
      result = result * 59 + ($cutTaskId == null ? 43 : $cutTaskId.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   public static class NestCutSurplusBuilder {
      private Long id;
      private String plantNo;
      private String surplusState;
      private String surplusPictureName;
      private String surplusPictureUrl;
      private String cutInstructionId;
      private String cutTaskId;
      private String material;
      private Integer num;
      private String number;
      private String specification;
      private String taskId;
      private String weight;

      NestCutSurplusBuilder() {
      }

      @JsonProperty("id")
      public NestCutSurplus.NestCutSurplusBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("plantNo")
      public NestCutSurplus.NestCutSurplusBuilder plantNo(final String plantNo) {
         this.plantNo = plantNo;
         return this;
      }

      @JsonProperty("surplusState")
      public NestCutSurplus.NestCutSurplusBuilder surplusState(final String surplusState) {
         this.surplusState = surplusState;
         return this;
      }

      @JsonProperty("surplusPictureName")
      public NestCutSurplus.NestCutSurplusBuilder surplusPictureName(final String surplusPictureName) {
         this.surplusPictureName = surplusPictureName;
         return this;
      }

      @JsonProperty("surplusPictureUrl")
      public NestCutSurplus.NestCutSurplusBuilder surplusPictureUrl(final String surplusPictureUrl) {
         this.surplusPictureUrl = surplusPictureUrl;
         return this;
      }

      @JsonProperty("cutInstructionId")
      public NestCutSurplus.NestCutSurplusBuilder cutInstructionId(final String cutInstructionId) {
         this.cutInstructionId = cutInstructionId;
         return this;
      }

      @JsonProperty("cutTaskId")
      public NestCutSurplus.NestCutSurplusBuilder cutTaskId(final String cutTaskId) {
         this.cutTaskId = cutTaskId;
         return this;
      }

      @JsonProperty("material")
      public NestCutSurplus.NestCutSurplusBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("num")
      public NestCutSurplus.NestCutSurplusBuilder num(final Integer num) {
         this.num = num;
         return this;
      }

      @JsonProperty("number")
      public NestCutSurplus.NestCutSurplusBuilder number(final String number) {
         this.number = number;
         return this;
      }

      @JsonProperty("specification")
      public NestCutSurplus.NestCutSurplusBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("taskId")
      public NestCutSurplus.NestCutSurplusBuilder taskId(final String taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("weight")
      public NestCutSurplus.NestCutSurplusBuilder weight(final String weight) {
         this.weight = weight;
         return this;
      }

      public NestCutSurplus build() {
         return new NestCutSurplus(
            this.id,
            this.plantNo,
            this.surplusState,
            this.surplusPictureName,
            this.surplusPictureUrl,
            this.cutInstructionId,
            this.cutTaskId,
            this.material,
            this.num,
            this.number,
            this.specification,
            this.taskId,
            this.weight
         );
      }

      @Override
      public String toString() {
         return "NestCutSurplus.NestCutSurplusBuilder(id="
            + this.id
            + ", plantNo="
            + this.plantNo
            + ", surplusState="
            + this.surplusState
            + ", surplusPictureName="
            + this.surplusPictureName
            + ", surplusPictureUrl="
            + this.surplusPictureUrl
            + ", cutInstructionId="
            + this.cutInstructionId
            + ", cutTaskId="
            + this.cutTaskId
            + ", material="
            + this.material
            + ", num="
            + this.num
            + ", number="
            + this.number
            + ", specification="
            + this.specification
            + ", taskId="
            + this.taskId
            + ", weight="
            + this.weight
            + ")";
      }
   }
}

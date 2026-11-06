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

@ApiModel(value = "CutSurplus对象", description = "")
@Entity
@TableName("cut_surplus")
@Table(name = "cut_surplus")
public class CutSurplus extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "area")
   @JsonProperty("area")
   @JSONField(name = "area")
   @TableField("area")
   @Column(name = "area", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String area;
   @ApiModelProperty(name = "figureUrl")
   @JsonProperty("figureUrl")
   @JSONField(name = "figureUrl")
   @TableField("figure_url")
   @Column(name = "figure_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String figureUrl;
   @ApiModelProperty(name = "plantNo")
   @JsonProperty("plantNo")
   @JSONField(name = "plantNo")
   @TableField("plant_no")
   @Column(name = "plant_no", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String plantNo;
   @ApiModelProperty(name = "projectName")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   @TableField("project_name")
   @Column(name = "project_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String projectName;
   @ApiModelProperty(name = "projectNo")
   @JsonProperty("projectNo")
   @JSONField(name = "projectNo")
   @TableField("project_no")
   @Column(name = "project_no", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String projectNo;
   @ApiModelProperty(name = "surplusState")
   @JsonProperty("surplusState")
   @JSONField(name = "surplusState")
   @TableField("surplus_state")
   @Column(name = "surplus_state", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusState;
   @ApiModelProperty(name = "cutInstructionId")
   @JsonProperty("cutInstructionId")
   @JSONField(name = "cutInstructionId")
   @TableField("cut_instruction_id")
   @Column(name = "cut_instruction_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String cutInstructionId;
   @ApiModelProperty(name = "cutTaskId")
   @JsonProperty("cutTaskId")
   @JSONField(name = "cutTaskId")
   @TableField("cut_task_id")
   @Column(name = "cut_task_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
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
   @Column(name = "num", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String num;
   @ApiModelProperty(name = "number")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String number;
   @ApiModelProperty(name = "specification")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String specification;
   @ApiModelProperty(name = "surplusDrgPictureName")
   @JsonProperty("surplusDrgPictureName")
   @JSONField(name = "surplusDrgPictureName")
   @TableField("surplus_drg_picture_name")
   @Column(name = "surplus_drg_picture_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusDrgPictureName;
   @ApiModelProperty(name = "surplusDrgPictureUrl")
   @JsonProperty("surplusDrgPictureUrl")
   @JSONField(name = "surplusDrgPictureUrl")
   @TableField("surplus_drg_picture_url")
   @Column(name = "surplus_drg_picture_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusDrgPictureUrl;
   @ApiModelProperty(name = "surplusDxfPicture")
   @JsonProperty("surplusDxfPicture")
   @JSONField(name = "surplusDxfPicture")
   @TableField("surplus_dxf_picture")
   @Column(name = "surplus_dxf_picture", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusDxfPicture;
   @ApiModelProperty(name = "surplusDxfPictureUrl")
   @JsonProperty("surplusDxfPictureUrl")
   @JSONField(name = "surplusDxfPictureUrl")
   @TableField("surplus_dxf_picture_url")
   @Column(name = "surplus_dxf_picture_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusDxfPictureUrl;
   @ApiModelProperty(name = "surplusPicture")
   @JsonProperty("surplusPicture")
   @JSONField(name = "surplusPicture")
   @TableField("surplus_picture")
   @Column(name = "surplus_picture", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusPicture;
   @ApiModelProperty(name = "surplusPictureUrl")
   @JsonProperty("surplusPictureUrl")
   @JSONField(name = "surplusPictureUrl")
   @TableField("surplus_picture_url")
   @Column(name = "surplus_picture_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusPictureUrl;
   @ApiModelProperty(name = "surplusReportName")
   @JsonProperty("surplusReportName")
   @JSONField(name = "surplusReportName")
   @TableField("surplus_report_name")
   @Column(name = "surplus_report_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusReportName;
   @ApiModelProperty(name = "surplusReportUrl")
   @JsonProperty("surplusReportUrl")
   @JSONField(name = "surplusReportUrl")
   @TableField("surplus_report_url")
   @Column(name = "surplus_report_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusReportUrl;
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
   @ApiModelProperty(name = "sendState")
   @JsonProperty("sendState")
   @JSONField(name = "sendState")
   @TableField("send_state")
   @Column(name = "send_state", columnDefinition = "varchar(255) default '0' COMMENT ''", nullable = true)
   private String sendState;

   public static CutSurplus.CutSurplusBuilder builder() {
      return new CutSurplus.CutSurplusBuilder();
   }

   public CutSurplus() {
   }

   public CutSurplus(
      final Long id,
      final String area,
      final String figureUrl,
      final String plantNo,
      final String projectName,
      final String projectNo,
      final String surplusState,
      final String cutInstructionId,
      final String cutTaskId,
      final String material,
      final String num,
      final String number,
      final String specification,
      final String surplusDrgPictureName,
      final String surplusDrgPictureUrl,
      final String surplusDxfPicture,
      final String surplusDxfPictureUrl,
      final String surplusPicture,
      final String surplusPictureUrl,
      final String surplusReportName,
      final String surplusReportUrl,
      final String taskId,
      final String weight,
      final String sendState
   ) {
      this.id = id;
      this.area = area;
      this.figureUrl = figureUrl;
      this.plantNo = plantNo;
      this.projectName = projectName;
      this.projectNo = projectNo;
      this.surplusState = surplusState;
      this.cutInstructionId = cutInstructionId;
      this.cutTaskId = cutTaskId;
      this.material = material;
      this.num = num;
      this.number = number;
      this.specification = specification;
      this.surplusDrgPictureName = surplusDrgPictureName;
      this.surplusDrgPictureUrl = surplusDrgPictureUrl;
      this.surplusDxfPicture = surplusDxfPicture;
      this.surplusDxfPictureUrl = surplusDxfPictureUrl;
      this.surplusPicture = surplusPicture;
      this.surplusPictureUrl = surplusPictureUrl;
      this.surplusReportName = surplusReportName;
      this.surplusReportUrl = surplusReportUrl;
      this.taskId = taskId;
      this.weight = weight;
      this.sendState = sendState;
   }

   public Long getId() {
      return this.id;
   }

   public String getArea() {
      return this.area;
   }

   public String getFigureUrl() {
      return this.figureUrl;
   }

   public String getPlantNo() {
      return this.plantNo;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectNo() {
      return this.projectNo;
   }

   public String getSurplusState() {
      return this.surplusState;
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

   public String getNum() {
      return this.num;
   }

   public String getNumber() {
      return this.number;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getSurplusDrgPictureName() {
      return this.surplusDrgPictureName;
   }

   public String getSurplusDrgPictureUrl() {
      return this.surplusDrgPictureUrl;
   }

   public String getSurplusDxfPicture() {
      return this.surplusDxfPicture;
   }

   public String getSurplusDxfPictureUrl() {
      return this.surplusDxfPictureUrl;
   }

   public String getSurplusPicture() {
      return this.surplusPicture;
   }

   public String getSurplusPictureUrl() {
      return this.surplusPictureUrl;
   }

   public String getSurplusReportName() {
      return this.surplusReportName;
   }

   public String getSurplusReportUrl() {
      return this.surplusReportUrl;
   }

   public String getTaskId() {
      return this.taskId;
   }

   public String getWeight() {
      return this.weight;
   }

   public String getSendState() {
      return this.sendState;
   }

   @JsonProperty("id")
   public CutSurplus setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("area")
   public CutSurplus setArea(final String area) {
      this.area = area;
      return this;
   }

   @JsonProperty("figureUrl")
   public CutSurplus setFigureUrl(final String figureUrl) {
      this.figureUrl = figureUrl;
      return this;
   }

   @JsonProperty("plantNo")
   public CutSurplus setPlantNo(final String plantNo) {
      this.plantNo = plantNo;
      return this;
   }

   @JsonProperty("projectName")
   public CutSurplus setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("projectNo")
   public CutSurplus setProjectNo(final String projectNo) {
      this.projectNo = projectNo;
      return this;
   }

   @JsonProperty("surplusState")
   public CutSurplus setSurplusState(final String surplusState) {
      this.surplusState = surplusState;
      return this;
   }

   @JsonProperty("cutInstructionId")
   public CutSurplus setCutInstructionId(final String cutInstructionId) {
      this.cutInstructionId = cutInstructionId;
      return this;
   }

   @JsonProperty("cutTaskId")
   public CutSurplus setCutTaskId(final String cutTaskId) {
      this.cutTaskId = cutTaskId;
      return this;
   }

   @JsonProperty("material")
   public CutSurplus setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("num")
   public CutSurplus setNum(final String num) {
      this.num = num;
      return this;
   }

   @JsonProperty("number")
   public CutSurplus setNumber(final String number) {
      this.number = number;
      return this;
   }

   @JsonProperty("specification")
   public CutSurplus setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("surplusDrgPictureName")
   public CutSurplus setSurplusDrgPictureName(final String surplusDrgPictureName) {
      this.surplusDrgPictureName = surplusDrgPictureName;
      return this;
   }

   @JsonProperty("surplusDrgPictureUrl")
   public CutSurplus setSurplusDrgPictureUrl(final String surplusDrgPictureUrl) {
      this.surplusDrgPictureUrl = surplusDrgPictureUrl;
      return this;
   }

   @JsonProperty("surplusDxfPicture")
   public CutSurplus setSurplusDxfPicture(final String surplusDxfPicture) {
      this.surplusDxfPicture = surplusDxfPicture;
      return this;
   }

   @JsonProperty("surplusDxfPictureUrl")
   public CutSurplus setSurplusDxfPictureUrl(final String surplusDxfPictureUrl) {
      this.surplusDxfPictureUrl = surplusDxfPictureUrl;
      return this;
   }

   @JsonProperty("surplusPicture")
   public CutSurplus setSurplusPicture(final String surplusPicture) {
      this.surplusPicture = surplusPicture;
      return this;
   }

   @JsonProperty("surplusPictureUrl")
   public CutSurplus setSurplusPictureUrl(final String surplusPictureUrl) {
      this.surplusPictureUrl = surplusPictureUrl;
      return this;
   }

   @JsonProperty("surplusReportName")
   public CutSurplus setSurplusReportName(final String surplusReportName) {
      this.surplusReportName = surplusReportName;
      return this;
   }

   @JsonProperty("surplusReportUrl")
   public CutSurplus setSurplusReportUrl(final String surplusReportUrl) {
      this.surplusReportUrl = surplusReportUrl;
      return this;
   }

   @JsonProperty("taskId")
   public CutSurplus setTaskId(final String taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("weight")
   public CutSurplus setWeight(final String weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("sendState")
   public CutSurplus setSendState(final String sendState) {
      this.sendState = sendState;
      return this;
   }

   @Override
   public String toString() {
      return "CutSurplus(id="
         + this.getId()
         + ", area="
         + this.getArea()
         + ", figureUrl="
         + this.getFigureUrl()
         + ", plantNo="
         + this.getPlantNo()
         + ", projectName="
         + this.getProjectName()
         + ", projectNo="
         + this.getProjectNo()
         + ", surplusState="
         + this.getSurplusState()
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
         + ", surplusDrgPictureName="
         + this.getSurplusDrgPictureName()
         + ", surplusDrgPictureUrl="
         + this.getSurplusDrgPictureUrl()
         + ", surplusDxfPicture="
         + this.getSurplusDxfPicture()
         + ", surplusDxfPictureUrl="
         + this.getSurplusDxfPictureUrl()
         + ", surplusPicture="
         + this.getSurplusPicture()
         + ", surplusPictureUrl="
         + this.getSurplusPictureUrl()
         + ", surplusReportName="
         + this.getSurplusReportName()
         + ", surplusReportUrl="
         + this.getSurplusReportUrl()
         + ", taskId="
         + this.getTaskId()
         + ", weight="
         + this.getWeight()
         + ", sendState="
         + this.getSendState()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutSurplus)) {
         return false;
      }

      CutSurplus other = (CutSurplus)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$area = this.getArea();
         Object other$area = other.getArea();
         if (this$area == null ? other$area == null : this$area.equals(other$area)) {
            Object this$figureUrl = this.getFigureUrl();
            Object other$figureUrl = other.getFigureUrl();
            if (this$figureUrl == null ? other$figureUrl == null : this$figureUrl.equals(other$figureUrl)) {
               Object this$plantNo = this.getPlantNo();
               Object other$plantNo = other.getPlantNo();
               if (this$plantNo == null ? other$plantNo == null : this$plantNo.equals(other$plantNo)) {
                  Object this$projectName = this.getProjectName();
                  Object other$projectName = other.getProjectName();
                  if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                     Object this$projectNo = this.getProjectNo();
                     Object other$projectNo = other.getProjectNo();
                     if (this$projectNo == null ? other$projectNo == null : this$projectNo.equals(other$projectNo)) {
                        Object this$surplusState = this.getSurplusState();
                        Object other$surplusState = other.getSurplusState();
                        if (this$surplusState == null ? other$surplusState == null : this$surplusState.equals(other$surplusState)) {
                           Object this$cutInstructionId = this.getCutInstructionId();
                           Object other$cutInstructionId = other.getCutInstructionId();
                           if (this$cutInstructionId == null ? other$cutInstructionId == null : this$cutInstructionId.equals(other$cutInstructionId)) {
                              Object this$cutTaskId = this.getCutTaskId();
                              Object other$cutTaskId = other.getCutTaskId();
                              if (this$cutTaskId == null ? other$cutTaskId == null : this$cutTaskId.equals(other$cutTaskId)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                    Object this$num = this.getNum();
                                    Object other$num = other.getNum();
                                    if (this$num == null ? other$num == null : this$num.equals(other$num)) {
                                       Object this$number = this.getNumber();
                                       Object other$number = other.getNumber();
                                       if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                          Object this$specification = this.getSpecification();
                                          Object other$specification = other.getSpecification();
                                          if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                             Object this$surplusDrgPictureName = this.getSurplusDrgPictureName();
                                             Object other$surplusDrgPictureName = other.getSurplusDrgPictureName();
                                             if (this$surplusDrgPictureName == null
                                                ? other$surplusDrgPictureName == null
                                                : this$surplusDrgPictureName.equals(other$surplusDrgPictureName)) {
                                                Object this$surplusDrgPictureUrl = this.getSurplusDrgPictureUrl();
                                                Object other$surplusDrgPictureUrl = other.getSurplusDrgPictureUrl();
                                                if (this$surplusDrgPictureUrl == null
                                                   ? other$surplusDrgPictureUrl == null
                                                   : this$surplusDrgPictureUrl.equals(other$surplusDrgPictureUrl)) {
                                                   Object this$surplusDxfPicture = this.getSurplusDxfPicture();
                                                   Object other$surplusDxfPicture = other.getSurplusDxfPicture();
                                                   if (this$surplusDxfPicture == null
                                                      ? other$surplusDxfPicture == null
                                                      : this$surplusDxfPicture.equals(other$surplusDxfPicture)) {
                                                      Object this$surplusDxfPictureUrl = this.getSurplusDxfPictureUrl();
                                                      Object other$surplusDxfPictureUrl = other.getSurplusDxfPictureUrl();
                                                      if (this$surplusDxfPictureUrl == null
                                                         ? other$surplusDxfPictureUrl == null
                                                         : this$surplusDxfPictureUrl.equals(other$surplusDxfPictureUrl)) {
                                                         Object this$surplusPicture = this.getSurplusPicture();
                                                         Object other$surplusPicture = other.getSurplusPicture();
                                                         if (this$surplusPicture == null
                                                            ? other$surplusPicture == null
                                                            : this$surplusPicture.equals(other$surplusPicture)) {
                                                            Object this$surplusPictureUrl = this.getSurplusPictureUrl();
                                                            Object other$surplusPictureUrl = other.getSurplusPictureUrl();
                                                            if (this$surplusPictureUrl == null
                                                               ? other$surplusPictureUrl == null
                                                               : this$surplusPictureUrl.equals(other$surplusPictureUrl)) {
                                                               Object this$surplusReportName = this.getSurplusReportName();
                                                               Object other$surplusReportName = other.getSurplusReportName();
                                                               if (this$surplusReportName == null
                                                                  ? other$surplusReportName == null
                                                                  : this$surplusReportName.equals(other$surplusReportName)) {
                                                                  Object this$surplusReportUrl = this.getSurplusReportUrl();
                                                                  Object other$surplusReportUrl = other.getSurplusReportUrl();
                                                                  if (this$surplusReportUrl == null
                                                                     ? other$surplusReportUrl == null
                                                                     : this$surplusReportUrl.equals(other$surplusReportUrl)) {
                                                                     Object this$taskId = this.getTaskId();
                                                                     Object other$taskId = other.getTaskId();
                                                                     if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                                                                        Object this$weight = this.getWeight();
                                                                        Object other$weight = other.getWeight();
                                                                        if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                           Object this$sendState = this.getSendState();
                                                                           Object other$sendState = other.getSendState();
                                                                           return this$sendState == null
                                                                              ? other$sendState == null
                                                                              : this$sendState.equals(other$sendState);
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
      return other instanceof CutSurplus;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $figureUrl = this.getFigureUrl();
      result = result * 59 + ($figureUrl == null ? 43 : $figureUrl.hashCode());
      Object $plantNo = this.getPlantNo();
      result = result * 59 + ($plantNo == null ? 43 : $plantNo.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectNo = this.getProjectNo();
      result = result * 59 + ($projectNo == null ? 43 : $projectNo.hashCode());
      Object $surplusState = this.getSurplusState();
      result = result * 59 + ($surplusState == null ? 43 : $surplusState.hashCode());
      Object $cutInstructionId = this.getCutInstructionId();
      result = result * 59 + ($cutInstructionId == null ? 43 : $cutInstructionId.hashCode());
      Object $cutTaskId = this.getCutTaskId();
      result = result * 59 + ($cutTaskId == null ? 43 : $cutTaskId.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $num = this.getNum();
      result = result * 59 + ($num == null ? 43 : $num.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $surplusDrgPictureName = this.getSurplusDrgPictureName();
      result = result * 59 + ($surplusDrgPictureName == null ? 43 : $surplusDrgPictureName.hashCode());
      Object $surplusDrgPictureUrl = this.getSurplusDrgPictureUrl();
      result = result * 59 + ($surplusDrgPictureUrl == null ? 43 : $surplusDrgPictureUrl.hashCode());
      Object $surplusDxfPicture = this.getSurplusDxfPicture();
      result = result * 59 + ($surplusDxfPicture == null ? 43 : $surplusDxfPicture.hashCode());
      Object $surplusDxfPictureUrl = this.getSurplusDxfPictureUrl();
      result = result * 59 + ($surplusDxfPictureUrl == null ? 43 : $surplusDxfPictureUrl.hashCode());
      Object $surplusPicture = this.getSurplusPicture();
      result = result * 59 + ($surplusPicture == null ? 43 : $surplusPicture.hashCode());
      Object $surplusPictureUrl = this.getSurplusPictureUrl();
      result = result * 59 + ($surplusPictureUrl == null ? 43 : $surplusPictureUrl.hashCode());
      Object $surplusReportName = this.getSurplusReportName();
      result = result * 59 + ($surplusReportName == null ? 43 : $surplusReportName.hashCode());
      Object $surplusReportUrl = this.getSurplusReportUrl();
      result = result * 59 + ($surplusReportUrl == null ? 43 : $surplusReportUrl.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $sendState = this.getSendState();
      return result * 59 + ($sendState == null ? 43 : $sendState.hashCode());
   }

   public static class CutSurplusBuilder {
      private Long id;
      private String area;
      private String figureUrl;
      private String plantNo;
      private String projectName;
      private String projectNo;
      private String surplusState;
      private String cutInstructionId;
      private String cutTaskId;
      private String material;
      private String num;
      private String number;
      private String specification;
      private String surplusDrgPictureName;
      private String surplusDrgPictureUrl;
      private String surplusDxfPicture;
      private String surplusDxfPictureUrl;
      private String surplusPicture;
      private String surplusPictureUrl;
      private String surplusReportName;
      private String surplusReportUrl;
      private String taskId;
      private String weight;
      private String sendState;

      CutSurplusBuilder() {
      }

      @JsonProperty("id")
      public CutSurplus.CutSurplusBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("area")
      public CutSurplus.CutSurplusBuilder area(final String area) {
         this.area = area;
         return this;
      }

      @JsonProperty("figureUrl")
      public CutSurplus.CutSurplusBuilder figureUrl(final String figureUrl) {
         this.figureUrl = figureUrl;
         return this;
      }

      @JsonProperty("plantNo")
      public CutSurplus.CutSurplusBuilder plantNo(final String plantNo) {
         this.plantNo = plantNo;
         return this;
      }

      @JsonProperty("projectName")
      public CutSurplus.CutSurplusBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("projectNo")
      public CutSurplus.CutSurplusBuilder projectNo(final String projectNo) {
         this.projectNo = projectNo;
         return this;
      }

      @JsonProperty("surplusState")
      public CutSurplus.CutSurplusBuilder surplusState(final String surplusState) {
         this.surplusState = surplusState;
         return this;
      }

      @JsonProperty("cutInstructionId")
      public CutSurplus.CutSurplusBuilder cutInstructionId(final String cutInstructionId) {
         this.cutInstructionId = cutInstructionId;
         return this;
      }

      @JsonProperty("cutTaskId")
      public CutSurplus.CutSurplusBuilder cutTaskId(final String cutTaskId) {
         this.cutTaskId = cutTaskId;
         return this;
      }

      @JsonProperty("material")
      public CutSurplus.CutSurplusBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("num")
      public CutSurplus.CutSurplusBuilder num(final String num) {
         this.num = num;
         return this;
      }

      @JsonProperty("number")
      public CutSurplus.CutSurplusBuilder number(final String number) {
         this.number = number;
         return this;
      }

      @JsonProperty("specification")
      public CutSurplus.CutSurplusBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("surplusDrgPictureName")
      public CutSurplus.CutSurplusBuilder surplusDrgPictureName(final String surplusDrgPictureName) {
         this.surplusDrgPictureName = surplusDrgPictureName;
         return this;
      }

      @JsonProperty("surplusDrgPictureUrl")
      public CutSurplus.CutSurplusBuilder surplusDrgPictureUrl(final String surplusDrgPictureUrl) {
         this.surplusDrgPictureUrl = surplusDrgPictureUrl;
         return this;
      }

      @JsonProperty("surplusDxfPicture")
      public CutSurplus.CutSurplusBuilder surplusDxfPicture(final String surplusDxfPicture) {
         this.surplusDxfPicture = surplusDxfPicture;
         return this;
      }

      @JsonProperty("surplusDxfPictureUrl")
      public CutSurplus.CutSurplusBuilder surplusDxfPictureUrl(final String surplusDxfPictureUrl) {
         this.surplusDxfPictureUrl = surplusDxfPictureUrl;
         return this;
      }

      @JsonProperty("surplusPicture")
      public CutSurplus.CutSurplusBuilder surplusPicture(final String surplusPicture) {
         this.surplusPicture = surplusPicture;
         return this;
      }

      @JsonProperty("surplusPictureUrl")
      public CutSurplus.CutSurplusBuilder surplusPictureUrl(final String surplusPictureUrl) {
         this.surplusPictureUrl = surplusPictureUrl;
         return this;
      }

      @JsonProperty("surplusReportName")
      public CutSurplus.CutSurplusBuilder surplusReportName(final String surplusReportName) {
         this.surplusReportName = surplusReportName;
         return this;
      }

      @JsonProperty("surplusReportUrl")
      public CutSurplus.CutSurplusBuilder surplusReportUrl(final String surplusReportUrl) {
         this.surplusReportUrl = surplusReportUrl;
         return this;
      }

      @JsonProperty("taskId")
      public CutSurplus.CutSurplusBuilder taskId(final String taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("weight")
      public CutSurplus.CutSurplusBuilder weight(final String weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("sendState")
      public CutSurplus.CutSurplusBuilder sendState(final String sendState) {
         this.sendState = sendState;
         return this;
      }

      public CutSurplus build() {
         return new CutSurplus(
            this.id,
            this.area,
            this.figureUrl,
            this.plantNo,
            this.projectName,
            this.projectNo,
            this.surplusState,
            this.cutInstructionId,
            this.cutTaskId,
            this.material,
            this.num,
            this.number,
            this.specification,
            this.surplusDrgPictureName,
            this.surplusDrgPictureUrl,
            this.surplusDxfPicture,
            this.surplusDxfPictureUrl,
            this.surplusPicture,
            this.surplusPictureUrl,
            this.surplusReportName,
            this.surplusReportUrl,
            this.taskId,
            this.weight,
            this.sendState
         );
      }

      @Override
      public String toString() {
         return "CutSurplus.CutSurplusBuilder(id="
            + this.id
            + ", area="
            + this.area
            + ", figureUrl="
            + this.figureUrl
            + ", plantNo="
            + this.plantNo
            + ", projectName="
            + this.projectName
            + ", projectNo="
            + this.projectNo
            + ", surplusState="
            + this.surplusState
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
            + ", surplusDrgPictureName="
            + this.surplusDrgPictureName
            + ", surplusDrgPictureUrl="
            + this.surplusDrgPictureUrl
            + ", surplusDxfPicture="
            + this.surplusDxfPicture
            + ", surplusDxfPictureUrl="
            + this.surplusDxfPictureUrl
            + ", surplusPicture="
            + this.surplusPicture
            + ", surplusPictureUrl="
            + this.surplusPictureUrl
            + ", surplusReportName="
            + this.surplusReportName
            + ", surplusReportUrl="
            + this.surplusReportUrl
            + ", taskId="
            + this.taskId
            + ", weight="
            + this.weight
            + ", sendState="
            + this.sendState
            + ")";
      }
   }
}

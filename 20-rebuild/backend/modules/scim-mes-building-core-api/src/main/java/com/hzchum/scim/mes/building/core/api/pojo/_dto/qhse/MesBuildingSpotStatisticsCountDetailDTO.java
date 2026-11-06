package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingSpotStatisticsCountDetailDTO对象", description = "抽检详情 ")
public class MesBuildingSpotStatisticsCountDetailDTO {
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private NameInfo monomer;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "specification", value = "产品规格", notes = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "qualifiedQuantity", value = "合格数", notes = "合格数")
   @JsonProperty("qualifiedQuantity")
   @JSONField(name = "qualifiedQuantity")
   private Integer qualifiedQuantity;
   @ApiModelProperty(name = "unQualifiedQuantity", value = "不合格数", notes = "不合格数")
   @JsonProperty("unQualifiedQuantity")
   @JSONField(name = "unQualifiedQuantity")
   private Integer unQualifiedQuantity;
   @ApiModelProperty(name = "spotCheckRemark", value = "抽检备注", notes = "抽检备注")
   @JsonProperty("spotCheckRemark")
   @JSONField(name = "spotCheckRemark")
   private String spotCheckRemark;
   @ApiModelProperty(name = "spotCheckUserName", value = "抽检人", notes = "抽检人")
   @JsonProperty("spotCheckUserName")
   @JSONField(name = "spotCheckUserName")
   private String spotCheckUserName;
   @ApiModelProperty(name = "spotCheckDate", value = "抽检时间(年月日)", notes = "年月日")
   @JsonProperty("spotCheckDate")
   @JSONField(name = "spotCheckDate")
   private String spotCheckDate;
   @ApiModelProperty(name = "spotCheckDateTime", value = "抽检时间", notes = "抽检时间")
   @JsonProperty("spotCheckDateTime")
   @JSONField(name = "spotCheckDateTime")
   private String spotCheckDateTime;

   public static MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder builder() {
      return new MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder();
   }

   public MesBuildingSpotStatisticsCountDetailDTO() {
   }

   public MesBuildingSpotStatisticsCountDetailDTO(
      final ProjectInfo project,
      final NameInfo monomer,
      final String serialNumber,
      final String name,
      final String specification,
      final Integer qualifiedQuantity,
      final Integer unQualifiedQuantity,
      final String spotCheckRemark,
      final String spotCheckUserName,
      final String spotCheckDate,
      final String spotCheckDateTime
   ) {
      this.project = project;
      this.monomer = monomer;
      this.serialNumber = serialNumber;
      this.name = name;
      this.specification = specification;
      this.qualifiedQuantity = qualifiedQuantity;
      this.unQualifiedQuantity = unQualifiedQuantity;
      this.spotCheckRemark = spotCheckRemark;
      this.spotCheckUserName = spotCheckUserName;
      this.spotCheckDate = spotCheckDate;
      this.spotCheckDateTime = spotCheckDateTime;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQualifiedQuantity() {
      return this.qualifiedQuantity;
   }

   public Integer getUnQualifiedQuantity() {
      return this.unQualifiedQuantity;
   }

   public String getSpotCheckRemark() {
      return this.spotCheckRemark;
   }

   public String getSpotCheckUserName() {
      return this.spotCheckUserName;
   }

   public String getSpotCheckDate() {
      return this.spotCheckDate;
   }

   public String getSpotCheckDateTime() {
      return this.spotCheckDateTime;
   }

   @JsonProperty("project")
   public MesBuildingSpotStatisticsCountDetailDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingSpotStatisticsCountDetailDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingSpotStatisticsCountDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingSpotStatisticsCountDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingSpotStatisticsCountDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("qualifiedQuantity")
   public MesBuildingSpotStatisticsCountDetailDTO setQualifiedQuantity(final Integer qualifiedQuantity) {
      this.qualifiedQuantity = qualifiedQuantity;
      return this;
   }

   @JsonProperty("unQualifiedQuantity")
   public MesBuildingSpotStatisticsCountDetailDTO setUnQualifiedQuantity(final Integer unQualifiedQuantity) {
      this.unQualifiedQuantity = unQualifiedQuantity;
      return this;
   }

   @JsonProperty("spotCheckRemark")
   public MesBuildingSpotStatisticsCountDetailDTO setSpotCheckRemark(final String spotCheckRemark) {
      this.spotCheckRemark = spotCheckRemark;
      return this;
   }

   @JsonProperty("spotCheckUserName")
   public MesBuildingSpotStatisticsCountDetailDTO setSpotCheckUserName(final String spotCheckUserName) {
      this.spotCheckUserName = spotCheckUserName;
      return this;
   }

   @JsonProperty("spotCheckDate")
   public MesBuildingSpotStatisticsCountDetailDTO setSpotCheckDate(final String spotCheckDate) {
      this.spotCheckDate = spotCheckDate;
      return this;
   }

   @JsonProperty("spotCheckDateTime")
   public MesBuildingSpotStatisticsCountDetailDTO setSpotCheckDateTime(final String spotCheckDateTime) {
      this.spotCheckDateTime = spotCheckDateTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSpotStatisticsCountDetailDTO)) {
         return false;
      }

      MesBuildingSpotStatisticsCountDetailDTO other = (MesBuildingSpotStatisticsCountDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$qualifiedQuantity = this.getQualifiedQuantity();
      Object other$qualifiedQuantity = other.getQualifiedQuantity();
      if (this$qualifiedQuantity == null ? other$qualifiedQuantity == null : this$qualifiedQuantity.equals(other$qualifiedQuantity)) {
         Object this$unQualifiedQuantity = this.getUnQualifiedQuantity();
         Object other$unQualifiedQuantity = other.getUnQualifiedQuantity();
         if (this$unQualifiedQuantity == null ? other$unQualifiedQuantity == null : this$unQualifiedQuantity.equals(other$unQualifiedQuantity)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$spotCheckRemark = this.getSpotCheckRemark();
                           Object other$spotCheckRemark = other.getSpotCheckRemark();
                           if (this$spotCheckRemark == null ? other$spotCheckRemark == null : this$spotCheckRemark.equals(other$spotCheckRemark)) {
                              Object this$spotCheckUserName = this.getSpotCheckUserName();
                              Object other$spotCheckUserName = other.getSpotCheckUserName();
                              if (this$spotCheckUserName == null ? other$spotCheckUserName == null : this$spotCheckUserName.equals(other$spotCheckUserName)) {
                                 Object this$spotCheckDate = this.getSpotCheckDate();
                                 Object other$spotCheckDate = other.getSpotCheckDate();
                                 if (this$spotCheckDate == null ? other$spotCheckDate == null : this$spotCheckDate.equals(other$spotCheckDate)) {
                                    Object this$spotCheckDateTime = this.getSpotCheckDateTime();
                                    Object other$spotCheckDateTime = other.getSpotCheckDateTime();
                                    return this$spotCheckDateTime == null
                                       ? other$spotCheckDateTime == null
                                       : this$spotCheckDateTime.equals(other$spotCheckDateTime);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingSpotStatisticsCountDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $qualifiedQuantity = this.getQualifiedQuantity();
      result = result * 59 + ($qualifiedQuantity == null ? 43 : $qualifiedQuantity.hashCode());
      Object $unQualifiedQuantity = this.getUnQualifiedQuantity();
      result = result * 59 + ($unQualifiedQuantity == null ? 43 : $unQualifiedQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $spotCheckRemark = this.getSpotCheckRemark();
      result = result * 59 + ($spotCheckRemark == null ? 43 : $spotCheckRemark.hashCode());
      Object $spotCheckUserName = this.getSpotCheckUserName();
      result = result * 59 + ($spotCheckUserName == null ? 43 : $spotCheckUserName.hashCode());
      Object $spotCheckDate = this.getSpotCheckDate();
      result = result * 59 + ($spotCheckDate == null ? 43 : $spotCheckDate.hashCode());
      Object $spotCheckDateTime = this.getSpotCheckDateTime();
      return result * 59 + ($spotCheckDateTime == null ? 43 : $spotCheckDateTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingSpotStatisticsCountDetailDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", qualifiedQuantity="
         + this.getQualifiedQuantity()
         + ", unQualifiedQuantity="
         + this.getUnQualifiedQuantity()
         + ", spotCheckRemark="
         + this.getSpotCheckRemark()
         + ", spotCheckUserName="
         + this.getSpotCheckUserName()
         + ", spotCheckDate="
         + this.getSpotCheckDate()
         + ", spotCheckDateTime="
         + this.getSpotCheckDateTime()
         + ")";
   }

   public static class MesBuildingSpotStatisticsCountDetailDTOBuilder {
      private ProjectInfo project;
      private NameInfo monomer;
      private String serialNumber;
      private String name;
      private String specification;
      private Integer qualifiedQuantity;
      private Integer unQualifiedQuantity;
      private String spotCheckRemark;
      private String spotCheckUserName;
      private String spotCheckDate;
      private String spotCheckDateTime;

      MesBuildingSpotStatisticsCountDetailDTOBuilder() {
      }

      @JsonProperty("project")
      public MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("qualifiedQuantity")
      public MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder qualifiedQuantity(final Integer qualifiedQuantity) {
         this.qualifiedQuantity = qualifiedQuantity;
         return this;
      }

      @JsonProperty("unQualifiedQuantity")
      public MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder unQualifiedQuantity(final Integer unQualifiedQuantity) {
         this.unQualifiedQuantity = unQualifiedQuantity;
         return this;
      }

      @JsonProperty("spotCheckRemark")
      public MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder spotCheckRemark(final String spotCheckRemark) {
         this.spotCheckRemark = spotCheckRemark;
         return this;
      }

      @JsonProperty("spotCheckUserName")
      public MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder spotCheckUserName(final String spotCheckUserName) {
         this.spotCheckUserName = spotCheckUserName;
         return this;
      }

      @JsonProperty("spotCheckDate")
      public MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder spotCheckDate(final String spotCheckDate) {
         this.spotCheckDate = spotCheckDate;
         return this;
      }

      @JsonProperty("spotCheckDateTime")
      public MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder spotCheckDateTime(final String spotCheckDateTime) {
         this.spotCheckDateTime = spotCheckDateTime;
         return this;
      }

      public MesBuildingSpotStatisticsCountDetailDTO build() {
         return new MesBuildingSpotStatisticsCountDetailDTO(
            this.project,
            this.monomer,
            this.serialNumber,
            this.name,
            this.specification,
            this.qualifiedQuantity,
            this.unQualifiedQuantity,
            this.spotCheckRemark,
            this.spotCheckUserName,
            this.spotCheckDate,
            this.spotCheckDateTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSpotStatisticsCountDetailDTO.MesBuildingSpotStatisticsCountDetailDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", qualifiedQuantity="
            + this.qualifiedQuantity
            + ", unQualifiedQuantity="
            + this.unQualifiedQuantity
            + ", spotCheckRemark="
            + this.spotCheckRemark
            + ", spotCheckUserName="
            + this.spotCheckUserName
            + ", spotCheckDate="
            + this.spotCheckDate
            + ", spotCheckDateTime="
            + this.spotCheckDateTime
            + ")";
      }
   }
}

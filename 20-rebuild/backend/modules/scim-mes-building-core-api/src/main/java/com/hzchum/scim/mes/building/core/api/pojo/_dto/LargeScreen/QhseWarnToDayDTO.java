package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "问题提醒")
public class QhseWarnToDayDTO {
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty("项目编号")
   private String serialNumber;
   @ApiModelProperty(name = "qhseNumber", value = "编号")
   @JsonProperty("qhseNumber")
   @JSONField(name = "qhseNumber")
   private String qhseNumber;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号")
   @JsonProperty("productSerialNumber")
   @JSONField(name = "productSerialNumber")
   private String productSerialNumber;
   @ApiModelProperty(name = "inspectUserName", value = "质检人", notes = "质检人")
   private String inspectUserName;
   @ApiModelProperty(name = "processName", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "levelOneType", value = "一级分类id")
   @JsonProperty("levelOneType")
   @JSONField(name = "levelOneType")
   private Long levelOneType;
   @ApiModelProperty(name = "levelOneTypeName", value = "一级分类名称")
   @JsonProperty("levelOneTypeName")
   @JSONField(name = "levelOneTypeName")
   private String levelOneTypeName;
   @ApiModelProperty(name = "levelTwoType", value = "二级分类id")
   @JsonProperty("levelTwoType")
   @JSONField(name = "levelTwoType")
   private Long levelTwoType;
   @ApiModelProperty(name = "levelTwoTypeName", value = "二级分类名称")
   @JsonProperty("levelTwoTypeName")
   @JSONField(name = "levelTwoTypeName")
   private String levelTwoTypeName;
   @ApiModelProperty(name = "teamLeaderName", notes = "班组组长")
   @JsonProperty("teamLeaderName")
   @JSONField(name = "teamLeaderName")
   private String teamLeaderName;

   public static QhseWarnToDayDTO.QhseWarnToDayDTOBuilder builder() {
      return new QhseWarnToDayDTO.QhseWarnToDayDTOBuilder();
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getQhseNumber() {
      return this.qhseNumber;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public String getInspectUserName() {
      return this.inspectUserName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Long getLevelOneType() {
      return this.levelOneType;
   }

   public String getLevelOneTypeName() {
      return this.levelOneTypeName;
   }

   public Long getLevelTwoType() {
      return this.levelTwoType;
   }

   public String getLevelTwoTypeName() {
      return this.levelTwoTypeName;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("qhseNumber")
   public void setQhseNumber(final String qhseNumber) {
      this.qhseNumber = qhseNumber;
   }

   @JsonProperty("productSerialNumber")
   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setInspectUserName(final String inspectUserName) {
      this.inspectUserName = inspectUserName;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("levelOneType")
   public void setLevelOneType(final Long levelOneType) {
      this.levelOneType = levelOneType;
   }

   @JsonProperty("levelOneTypeName")
   public void setLevelOneTypeName(final String levelOneTypeName) {
      this.levelOneTypeName = levelOneTypeName;
   }

   @JsonProperty("levelTwoType")
   public void setLevelTwoType(final Long levelTwoType) {
      this.levelTwoType = levelTwoType;
   }

   @JsonProperty("levelTwoTypeName")
   public void setLevelTwoTypeName(final String levelTwoTypeName) {
      this.levelTwoTypeName = levelTwoTypeName;
   }

   @JsonProperty("teamLeaderName")
   public void setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseWarnToDayDTO)) {
         return false;
      }

      QhseWarnToDayDTO other = (QhseWarnToDayDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$levelOneType = this.getLevelOneType();
      Object other$levelOneType = other.getLevelOneType();
      if (this$levelOneType == null ? other$levelOneType == null : this$levelOneType.equals(other$levelOneType)) {
         Object this$levelTwoType = this.getLevelTwoType();
         Object other$levelTwoType = other.getLevelTwoType();
         if (this$levelTwoType == null ? other$levelTwoType == null : this$levelTwoType.equals(other$levelTwoType)) {
            Object this$shortName = this.getShortName();
            Object other$shortName = other.getShortName();
            if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$qhseNumber = this.getQhseNumber();
                  Object other$qhseNumber = other.getQhseNumber();
                  if (this$qhseNumber == null ? other$qhseNumber == null : this$qhseNumber.equals(other$qhseNumber)) {
                     Object this$productSerialNumber = this.getProductSerialNumber();
                     Object other$productSerialNumber = other.getProductSerialNumber();
                     if (this$productSerialNumber == null ? other$productSerialNumber == null : this$productSerialNumber.equals(other$productSerialNumber)) {
                        Object this$inspectUserName = this.getInspectUserName();
                        Object other$inspectUserName = other.getInspectUserName();
                        if (this$inspectUserName == null ? other$inspectUserName == null : this$inspectUserName.equals(other$inspectUserName)) {
                           Object this$processName = this.getProcessName();
                           Object other$processName = other.getProcessName();
                           if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                              Object this$levelOneTypeName = this.getLevelOneTypeName();
                              Object other$levelOneTypeName = other.getLevelOneTypeName();
                              if (this$levelOneTypeName == null ? other$levelOneTypeName == null : this$levelOneTypeName.equals(other$levelOneTypeName)) {
                                 Object this$levelTwoTypeName = this.getLevelTwoTypeName();
                                 Object other$levelTwoTypeName = other.getLevelTwoTypeName();
                                 if (this$levelTwoTypeName == null ? other$levelTwoTypeName == null : this$levelTwoTypeName.equals(other$levelTwoTypeName)) {
                                    Object this$teamLeaderName = this.getTeamLeaderName();
                                    Object other$teamLeaderName = other.getTeamLeaderName();
                                    return this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName);
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
      return other instanceof QhseWarnToDayDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $levelOneType = this.getLevelOneType();
      result = result * 59 + ($levelOneType == null ? 43 : $levelOneType.hashCode());
      Object $levelTwoType = this.getLevelTwoType();
      result = result * 59 + ($levelTwoType == null ? 43 : $levelTwoType.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $qhseNumber = this.getQhseNumber();
      result = result * 59 + ($qhseNumber == null ? 43 : $qhseNumber.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $inspectUserName = this.getInspectUserName();
      result = result * 59 + ($inspectUserName == null ? 43 : $inspectUserName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $levelOneTypeName = this.getLevelOneTypeName();
      result = result * 59 + ($levelOneTypeName == null ? 43 : $levelOneTypeName.hashCode());
      Object $levelTwoTypeName = this.getLevelTwoTypeName();
      result = result * 59 + ($levelTwoTypeName == null ? 43 : $levelTwoTypeName.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      return result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
   }

   @Override
   public String toString() {
      return "QhseWarnToDayDTO(super="
         + super.toString()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", qhseNumber="
         + this.getQhseNumber()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", inspectUserName="
         + this.getInspectUserName()
         + ", processName="
         + this.getProcessName()
         + ", levelOneType="
         + this.getLevelOneType()
         + ", levelOneTypeName="
         + this.getLevelOneTypeName()
         + ", levelTwoType="
         + this.getLevelTwoType()
         + ", levelTwoTypeName="
         + this.getLevelTwoTypeName()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ")";
   }

   public QhseWarnToDayDTO(
      final String shortName,
      final String serialNumber,
      final String qhseNumber,
      final String productSerialNumber,
      final String inspectUserName,
      final String processName,
      final Long levelOneType,
      final String levelOneTypeName,
      final Long levelTwoType,
      final String levelTwoTypeName,
      final String teamLeaderName
   ) {
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.qhseNumber = qhseNumber;
      this.productSerialNumber = productSerialNumber;
      this.inspectUserName = inspectUserName;
      this.processName = processName;
      this.levelOneType = levelOneType;
      this.levelOneTypeName = levelOneTypeName;
      this.levelTwoType = levelTwoType;
      this.levelTwoTypeName = levelTwoTypeName;
      this.teamLeaderName = teamLeaderName;
   }

   public QhseWarnToDayDTO() {
   }

   public static class QhseWarnToDayDTOBuilder {
      private String shortName;
      private String serialNumber;
      private String qhseNumber;
      private String productSerialNumber;
      private String inspectUserName;
      private String processName;
      private Long levelOneType;
      private String levelOneTypeName;
      private Long levelTwoType;
      private String levelTwoTypeName;
      private String teamLeaderName;

      QhseWarnToDayDTOBuilder() {
      }

      public QhseWarnToDayDTO.QhseWarnToDayDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public QhseWarnToDayDTO.QhseWarnToDayDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("qhseNumber")
      public QhseWarnToDayDTO.QhseWarnToDayDTOBuilder qhseNumber(final String qhseNumber) {
         this.qhseNumber = qhseNumber;
         return this;
      }

      @JsonProperty("productSerialNumber")
      public QhseWarnToDayDTO.QhseWarnToDayDTOBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public QhseWarnToDayDTO.QhseWarnToDayDTOBuilder inspectUserName(final String inspectUserName) {
         this.inspectUserName = inspectUserName;
         return this;
      }

      @JsonProperty("processName")
      public QhseWarnToDayDTO.QhseWarnToDayDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("levelOneType")
      public QhseWarnToDayDTO.QhseWarnToDayDTOBuilder levelOneType(final Long levelOneType) {
         this.levelOneType = levelOneType;
         return this;
      }

      @JsonProperty("levelOneTypeName")
      public QhseWarnToDayDTO.QhseWarnToDayDTOBuilder levelOneTypeName(final String levelOneTypeName) {
         this.levelOneTypeName = levelOneTypeName;
         return this;
      }

      @JsonProperty("levelTwoType")
      public QhseWarnToDayDTO.QhseWarnToDayDTOBuilder levelTwoType(final Long levelTwoType) {
         this.levelTwoType = levelTwoType;
         return this;
      }

      @JsonProperty("levelTwoTypeName")
      public QhseWarnToDayDTO.QhseWarnToDayDTOBuilder levelTwoTypeName(final String levelTwoTypeName) {
         this.levelTwoTypeName = levelTwoTypeName;
         return this;
      }

      @JsonProperty("teamLeaderName")
      public QhseWarnToDayDTO.QhseWarnToDayDTOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      public QhseWarnToDayDTO build() {
         return new QhseWarnToDayDTO(
            this.shortName,
            this.serialNumber,
            this.qhseNumber,
            this.productSerialNumber,
            this.inspectUserName,
            this.processName,
            this.levelOneType,
            this.levelOneTypeName,
            this.levelTwoType,
            this.levelTwoTypeName,
            this.teamLeaderName
         );
      }

      @Override
      public String toString() {
         return "QhseWarnToDayDTO.QhseWarnToDayDTOBuilder(shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", qhseNumber="
            + this.qhseNumber
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", inspectUserName="
            + this.inspectUserName
            + ", processName="
            + this.processName
            + ", levelOneType="
            + this.levelOneType
            + ", levelOneTypeName="
            + this.levelOneTypeName
            + ", levelTwoType="
            + this.levelTwoType
            + ", levelTwoTypeName="
            + this.levelTwoTypeName
            + ", teamLeaderName="
            + this.teamLeaderName
            + ")";
      }
   }
}

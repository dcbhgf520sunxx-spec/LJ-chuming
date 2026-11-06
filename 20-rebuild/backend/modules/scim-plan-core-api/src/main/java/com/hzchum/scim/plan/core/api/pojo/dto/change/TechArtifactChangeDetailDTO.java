package com.hzchum.scim.plan.core.api.pojo.dto.change;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModelProperty;

public class TechArtifactChangeDetailDTO {
   @ApiModelProperty(name = "id", value = "构件id")
   private Long artifactId;
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "sortNumber", value = "序号", notes = "序号")
   private Integer sortNumber;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 false暂停 true进行中")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "productionLine", value = "生产线", notes = "生产线")
   private NameInfo productionLine;
   @ApiModelProperty(name = "group", value = "生产组", notes = "生产组")
   private NameInfo groups;
   @ApiModelProperty(name = "status", value = "当前状态", notes = "当前状态")
   private String status;
   @ApiModelProperty(name = "status", value = "部件构件是否都未进入发运", notes = "部件构件是否都未进入发运")
   private Boolean boolCargo;
   @ApiModelProperty(name = "构件特征定义id", value = "构件特征定义id")
   private Long structureClassId;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "team", value = "生产班组", notes = "生产班组")
   private NameInfo team;
   @ApiModelProperty(name = "importUserName", value = "导入人")
   private String importUserName;

   public static TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder builder() {
      return new TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder();
   }

   public TechArtifactChangeDetailDTO() {
   }

   public TechArtifactChangeDetailDTO(
      final Long artifactId,
      final NameInfo area,
      final String serialNumber,
      final Integer sortNumber,
      final Boolean boolStatusEnum,
      final NameInfo productionLine,
      final NameInfo groups,
      final String status,
      final Boolean boolCargo,
      final Long structureClassId,
      final Boolean boolAllPartSendDirectly,
      final String material,
      final NameInfo team,
      final String importUserName
   ) {
      this.artifactId = artifactId;
      this.area = area;
      this.serialNumber = serialNumber;
      this.sortNumber = sortNumber;
      this.boolStatusEnum = boolStatusEnum;
      this.productionLine = productionLine;
      this.groups = groups;
      this.status = status;
      this.boolCargo = boolCargo;
      this.structureClassId = structureClassId;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.material = material;
      this.team = team;
      this.importUserName = importUserName;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public NameInfo getProductionLine() {
      return this.productionLine;
   }

   public NameInfo getGroups() {
      return this.groups;
   }

   public String getStatus() {
      return this.status;
   }

   public Boolean getBoolCargo() {
      return this.boolCargo;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public String getMaterial() {
      return this.material;
   }

   public NameInfo getTeam() {
      return this.team;
   }

   public String getImportUserName() {
      return this.importUserName;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
   }

   public void setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
   }

   public void setProductionLine(final NameInfo productionLine) {
      this.productionLine = productionLine;
   }

   public void setGroups(final NameInfo groups) {
      this.groups = groups;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   public void setBoolCargo(final Boolean boolCargo) {
      this.boolCargo = boolCargo;
   }

   public void setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setTeam(final NameInfo team) {
      this.team = team;
   }

   public void setImportUserName(final String importUserName) {
      this.importUserName = importUserName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactChangeDetailDTO)) {
         return false;
      }

      TechArtifactChangeDetailDTO other = (TechArtifactChangeDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$sortNumber = this.getSortNumber();
         Object other$sortNumber = other.getSortNumber();
         if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
            Object this$boolStatusEnum = this.getBoolStatusEnum();
            Object other$boolStatusEnum = other.getBoolStatusEnum();
            if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
               Object this$boolCargo = this.getBoolCargo();
               Object other$boolCargo = other.getBoolCargo();
               if (this$boolCargo == null ? other$boolCargo == null : this$boolCargo.equals(other$boolCargo)) {
                  Object this$structureClassId = this.getStructureClassId();
                  Object other$structureClassId = other.getStructureClassId();
                  if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                     Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                     Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                     if (this$boolAllPartSendDirectly == null
                        ? other$boolAllPartSendDirectly == null
                        : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                        Object this$area = this.getArea();
                        Object other$area = other.getArea();
                        if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$productionLine = this.getProductionLine();
                              Object other$productionLine = other.getProductionLine();
                              if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                 Object this$groups = this.getGroups();
                                 Object other$groups = other.getGroups();
                                 if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                                    Object this$status = this.getStatus();
                                    Object other$status = other.getStatus();
                                    if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$team = this.getTeam();
                                          Object other$team = other.getTeam();
                                          if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                                             Object this$importUserName = this.getImportUserName();
                                             Object other$importUserName = other.getImportUserName();
                                             return this$importUserName == null
                                                ? other$importUserName == null
                                                : this$importUserName.equals(other$importUserName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactChangeDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $boolCargo = this.getBoolCargo();
      result = result * 59 + ($boolCargo == null ? 43 : $boolCargo.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $importUserName = this.getImportUserName();
      return result * 59 + ($importUserName == null ? 43 : $importUserName.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactChangeDetailDTO(artifactId="
         + this.getArtifactId()
         + ", area="
         + this.getArea()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", sortNumber="
         + this.getSortNumber()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", status="
         + this.getStatus()
         + ", boolCargo="
         + this.getBoolCargo()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", material="
         + this.getMaterial()
         + ", team="
         + this.getTeam()
         + ", importUserName="
         + this.getImportUserName()
         + ")";
   }

   public static class TechArtifactChangeDetailDTOBuilder {
      private Long artifactId;
      private NameInfo area;
      private String serialNumber;
      private Integer sortNumber;
      private Boolean boolStatusEnum;
      private NameInfo productionLine;
      private NameInfo groups;
      private String status;
      private Boolean boolCargo;
      private Long structureClassId;
      private Boolean boolAllPartSendDirectly;
      private String material;
      private NameInfo team;
      private String importUserName;

      TechArtifactChangeDetailDTOBuilder() {
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder productionLine(final NameInfo productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder groups(final NameInfo groups) {
         this.groups = groups;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder status(final String status) {
         this.status = status;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder boolCargo(final Boolean boolCargo) {
         this.boolCargo = boolCargo;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder team(final NameInfo team) {
         this.team = team;
         return this;
      }

      public TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder importUserName(final String importUserName) {
         this.importUserName = importUserName;
         return this;
      }

      public TechArtifactChangeDetailDTO build() {
         return new TechArtifactChangeDetailDTO(
            this.artifactId,
            this.area,
            this.serialNumber,
            this.sortNumber,
            this.boolStatusEnum,
            this.productionLine,
            this.groups,
            this.status,
            this.boolCargo,
            this.structureClassId,
            this.boolAllPartSendDirectly,
            this.material,
            this.team,
            this.importUserName
         );
      }

      @Override
      public String toString() {
         return "TechArtifactChangeDetailDTO.TechArtifactChangeDetailDTOBuilder(artifactId="
            + this.artifactId
            + ", area="
            + this.area
            + ", serialNumber="
            + this.serialNumber
            + ", sortNumber="
            + this.sortNumber
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", status="
            + this.status
            + ", boolCargo="
            + this.boolCargo
            + ", structureClassId="
            + this.structureClassId
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", material="
            + this.material
            + ", team="
            + this.team
            + ", importUserName="
            + this.importUserName
            + ")";
      }
   }
}

package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesEnclosureDetailDTO", description = "工单详情返回类 ")
public class MesEnclosureDetailDTO {
   @ApiModelProperty(notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", notes = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", notes = "生产线名")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "操作人名", notes = "操作人名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "enclosures", value = "产品信息", notes = "产品信息")
   @JsonProperty("enclosures")
   @JSONField(name = "enclosures")
   private List<TechEnclosureDetailDTO> enclosures;

   public static MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder builder() {
      return new MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder();
   }

   public MesEnclosureDetailDTO() {
   }

   public MesEnclosureDetailDTO(
      final ProjectInfo project,
      final Long workshopId,
      final String workshopName,
      final Long productionLineId,
      final String productionLineName,
      final Long teamId,
      final Long userId,
      final String userName,
      final List<TechEnclosureDetailDTO> enclosures
   ) {
      this.project = project;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.teamId = teamId;
      this.userId = userId;
      this.userName = userName;
      this.enclosures = enclosures;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public List<TechEnclosureDetailDTO> getEnclosures() {
      return this.enclosures;
   }

   public MesEnclosureDetailDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureDetailDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public MesEnclosureDetailDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureDetailDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public MesEnclosureDetailDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureDetailDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureDetailDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureDetailDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("enclosures")
   public MesEnclosureDetailDTO setEnclosures(final List<TechEnclosureDetailDTO> enclosures) {
      this.enclosures = enclosures;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureDetailDTO(project="
         + this.getProject()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", enclosures="
         + this.getEnclosures()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureDetailDTO)) {
         return false;
      }

      MesEnclosureDetailDTO other = (MesEnclosureDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$workshopName = this.getWorkshopName();
                     Object other$workshopName = other.getWorkshopName();
                     if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                        Object this$productionLineName = this.getProductionLineName();
                        Object other$productionLineName = other.getProductionLineName();
                        if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                           Object this$userName = this.getUserName();
                           Object other$userName = other.getUserName();
                           if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                              Object this$enclosures = this.getEnclosures();
                              Object other$enclosures = other.getEnclosures();
                              return this$enclosures == null ? other$enclosures == null : this$enclosures.equals(other$enclosures);
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
      return other instanceof MesEnclosureDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $enclosures = this.getEnclosures();
      return result * 59 + ($enclosures == null ? 43 : $enclosures.hashCode());
   }

   public static class MesEnclosureDetailDTOBuilder {
      private ProjectInfo project;
      private Long workshopId;
      private String workshopName;
      private Long productionLineId;
      private String productionLineName;
      private Long teamId;
      private Long userId;
      private String userName;
      private List<TechEnclosureDetailDTO> enclosures;

      MesEnclosureDetailDTOBuilder() {
      }

      public MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("enclosures")
      public MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder enclosures(final List<TechEnclosureDetailDTO> enclosures) {
         this.enclosures = enclosures;
         return this;
      }

      public MesEnclosureDetailDTO build() {
         return new MesEnclosureDetailDTO(
            this.project,
            this.workshopId,
            this.workshopName,
            this.productionLineId,
            this.productionLineName,
            this.teamId,
            this.userId,
            this.userName,
            this.enclosures
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureDetailDTO.MesEnclosureDetailDTOBuilder(project="
            + this.project
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", teamId="
            + this.teamId
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", enclosures="
            + this.enclosures
            + ")";
      }
   }
}

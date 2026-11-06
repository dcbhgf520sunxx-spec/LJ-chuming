package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingInspectionTeamDTO", description = "质检班组请求类")
public class MesBuildingInspectionTeamDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "userId", notes = "操作人", value = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "userLinkList", notes = "质检人员")
   @JsonProperty("userLinkList")
   @JSONField(name = "userLinkList")
   private List<MesBuildingInspectionTeamUserLinkDTO> userLinkList;

   public static MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder builder() {
      return new MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder();
   }

   public MesBuildingInspectionTeamDTO() {
   }

   public MesBuildingInspectionTeamDTO(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long processId,
      final String processName,
      final Integer productType,
      final Long userId,
      final Integer productionLineTypeEnum,
      final List<MesBuildingInspectionTeamUserLinkDTO> userLinkList
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.processId = processId;
      this.processName = processName;
      this.productType = productType;
      this.userId = userId;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.userLinkList = userLinkList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public List<MesBuildingInspectionTeamUserLinkDTO> getUserLinkList() {
      return this.userLinkList;
   }

   @JsonProperty("id")
   public MesBuildingInspectionTeamDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingInspectionTeamDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingInspectionTeamDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingInspectionTeamDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingInspectionTeamDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesBuildingInspectionTeamDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingInspectionTeamDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingInspectionTeamDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingInspectionTeamDTO setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("userLinkList")
   public MesBuildingInspectionTeamDTO setUserLinkList(final List<MesBuildingInspectionTeamUserLinkDTO> userLinkList) {
      this.userLinkList = userLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingInspectionTeamDTO(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", productType="
         + this.getProductType()
         + ", userId="
         + this.getUserId()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", userLinkList="
         + this.getUserLinkList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingInspectionTeamDTO)) {
         return false;
      }

      MesBuildingInspectionTeamDTO other = (MesBuildingInspectionTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                           Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                           if (this$productionLineTypeEnum == null
                              ? other$productionLineTypeEnum == null
                              : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                              Object this$processName = this.getProcessName();
                              Object other$processName = other.getProcessName();
                              if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                 Object this$userLinkList = this.getUserLinkList();
                                 Object other$userLinkList = other.getUserLinkList();
                                 return this$userLinkList == null ? other$userLinkList == null : this$userLinkList.equals(other$userLinkList);
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
      return other instanceof MesBuildingInspectionTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $userLinkList = this.getUserLinkList();
      return result * 59 + ($userLinkList == null ? 43 : $userLinkList.hashCode());
   }

   public static class MesBuildingInspectionTeamDTOBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long processId;
      private String processName;
      private Integer productType;
      private Long userId;
      private Integer productionLineTypeEnum;
      private List<MesBuildingInspectionTeamUserLinkDTO> userLinkList;

      MesBuildingInspectionTeamDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("userLinkList")
      public MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder userLinkList(final List<MesBuildingInspectionTeamUserLinkDTO> userLinkList) {
         this.userLinkList = userLinkList;
         return this;
      }

      public MesBuildingInspectionTeamDTO build() {
         return new MesBuildingInspectionTeamDTO(
            this.id,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.processId,
            this.processName,
            this.productType,
            this.userId,
            this.productionLineTypeEnum,
            this.userLinkList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingInspectionTeamDTO.MesBuildingInspectionTeamDTOBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", productType="
            + this.productType
            + ", userId="
            + this.userId
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", userLinkList="
            + this.userLinkList
            + ")";
      }
   }
}

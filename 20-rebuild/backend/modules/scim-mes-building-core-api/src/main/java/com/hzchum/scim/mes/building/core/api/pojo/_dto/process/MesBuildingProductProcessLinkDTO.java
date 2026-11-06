package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingProductProcessLinkDOParam对象", description = "")
public class MesBuildingProductProcessLinkDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "shopId", value = "车间id", notes = "车间id")
   @JsonProperty("shopId")
   @JSONField(name = "shopId")
   private Long shopId;
   @ApiModelProperty(name = "shopName", value = "车间名", notes = "车间名")
   @JsonProperty("shopName")
   @JSONField(name = "shopName")
   private String shopName;
   @ApiModelProperty(name = "lineId", value = "产线id", notes = "产线id")
   @JsonProperty("lineId")
   @JSONField(name = "lineId")
   private Long lineId;
   @ApiModelProperty(name = "lineName", value = "产线名", notes = "产线名")
   @JsonProperty("lineName")
   @JSONField(name = "lineName")
   private String lineName;
   @ApiModelProperty(name = "classId", value = "'零构部种类id'", notes = "'零构部种类id'")
   @JsonProperty("classId")
   @JSONField(name = "classId")
   private Long classId;
   @ApiModelProperty(name = "productProcessId", notes = "产品工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "sequence", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   @NotNull(message = "工序顺序不能为空")
   private Integer sequence;
   @ApiModelProperty(name = "name", notes = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "nodeTime", notes = "时间节点")
   @JsonProperty("nodeTime")
   @JSONField(name = "nodeTime")
   private Integer nodeTime;
   @ApiModelProperty(name = "productType", notes = "工序类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "type", value = "工序类型", notes = "工序类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "typeId", value = "类型id", notes = "类型id")
   @JsonProperty("typeId")
   @JSONField(name = "typeId")
   private Long typeId;
   @ApiModelProperty("零件类型[1 板材零件 2 型材零件]")
   @JsonProperty("partType")
   @JSONField(name = "partType")
   private Integer partType;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "teamLeaderName", value = "班组长", notes = "班组长")
   @JsonProperty("teamLeaderName")
   @JSONField(name = "teamLeaderName")
   private String teamLeaderName;

   public static MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder builder() {
      return new MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder();
   }

   public MesBuildingProductProcessLinkDTO() {
   }

   public MesBuildingProductProcessLinkDTO(
      final Long id,
      final Long shopId,
      final String shopName,
      final Long lineId,
      final String lineName,
      final Long classId,
      final Long productProcessId,
      final Long processId,
      final String processName,
      final Integer sequence,
      final String name,
      final Integer nodeTime,
      final Integer productType,
      final Integer type,
      final Long typeId,
      final Integer partType,
      final Long teamId,
      final String teamLeaderName
   ) {
      this.id = id;
      this.shopId = shopId;
      this.shopName = shopName;
      this.lineId = lineId;
      this.lineName = lineName;
      this.classId = classId;
      this.productProcessId = productProcessId;
      this.processId = processId;
      this.processName = processName;
      this.sequence = sequence;
      this.name = name;
      this.nodeTime = nodeTime;
      this.productType = productType;
      this.type = type;
      this.typeId = typeId;
      this.partType = partType;
      this.teamId = teamId;
      this.teamLeaderName = teamLeaderName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getShopId() {
      return this.shopId;
   }

   public String getShopName() {
      return this.shopName;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public String getLineName() {
      return this.lineName;
   }

   public Long getClassId() {
      return this.classId;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public String getName() {
      return this.name;
   }

   public Integer getNodeTime() {
      return this.nodeTime;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getTypeId() {
      return this.typeId;
   }

   public Integer getPartType() {
      return this.partType;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   @JsonProperty("id")
   public MesBuildingProductProcessLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("shopId")
   public MesBuildingProductProcessLinkDTO setShopId(final Long shopId) {
      this.shopId = shopId;
      return this;
   }

   @JsonProperty("shopName")
   public MesBuildingProductProcessLinkDTO setShopName(final String shopName) {
      this.shopName = shopName;
      return this;
   }

   @JsonProperty("lineId")
   public MesBuildingProductProcessLinkDTO setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   @JsonProperty("lineName")
   public MesBuildingProductProcessLinkDTO setLineName(final String lineName) {
      this.lineName = lineName;
      return this;
   }

   @JsonProperty("classId")
   public MesBuildingProductProcessLinkDTO setClassId(final Long classId) {
      this.classId = classId;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesBuildingProductProcessLinkDTO setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProductProcessLinkDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesBuildingProductProcessLinkDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingProductProcessLinkDTO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProductProcessLinkDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("nodeTime")
   public MesBuildingProductProcessLinkDTO setNodeTime(final Integer nodeTime) {
      this.nodeTime = nodeTime;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProductProcessLinkDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingProductProcessLinkDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("typeId")
   public MesBuildingProductProcessLinkDTO setTypeId(final Long typeId) {
      this.typeId = typeId;
      return this;
   }

   @JsonProperty("partType")
   public MesBuildingProductProcessLinkDTO setPartType(final Integer partType) {
      this.partType = partType;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingProductProcessLinkDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("teamLeaderName")
   public MesBuildingProductProcessLinkDTO setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductProcessLinkDTO(id="
         + this.getId()
         + ", shopId="
         + this.getShopId()
         + ", shopName="
         + this.getShopName()
         + ", lineId="
         + this.getLineId()
         + ", lineName="
         + this.getLineName()
         + ", classId="
         + this.getClassId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", sequence="
         + this.getSequence()
         + ", name="
         + this.getName()
         + ", nodeTime="
         + this.getNodeTime()
         + ", productType="
         + this.getProductType()
         + ", type="
         + this.getType()
         + ", typeId="
         + this.getTypeId()
         + ", partType="
         + this.getPartType()
         + ", teamId="
         + this.getTeamId()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductProcessLinkDTO)) {
         return false;
      }

      MesBuildingProductProcessLinkDTO other = (MesBuildingProductProcessLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$shopId = this.getShopId();
         Object other$shopId = other.getShopId();
         if (this$shopId == null ? other$shopId == null : this$shopId.equals(other$shopId)) {
            Object this$lineId = this.getLineId();
            Object other$lineId = other.getLineId();
            if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
               Object this$classId = this.getClassId();
               Object other$classId = other.getClassId();
               if (this$classId == null ? other$classId == null : this$classId.equals(other$classId)) {
                  Object this$productProcessId = this.getProductProcessId();
                  Object other$productProcessId = other.getProductProcessId();
                  if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
                     Object this$processId = this.getProcessId();
                     Object other$processId = other.getProcessId();
                     if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                        Object this$sequence = this.getSequence();
                        Object other$sequence = other.getSequence();
                        if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                           Object this$nodeTime = this.getNodeTime();
                           Object other$nodeTime = other.getNodeTime();
                           if (this$nodeTime == null ? other$nodeTime == null : this$nodeTime.equals(other$nodeTime)) {
                              Object this$productType = this.getProductType();
                              Object other$productType = other.getProductType();
                              if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                 Object this$type = this.getType();
                                 Object other$type = other.getType();
                                 if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                    Object this$typeId = this.getTypeId();
                                    Object other$typeId = other.getTypeId();
                                    if (this$typeId == null ? other$typeId == null : this$typeId.equals(other$typeId)) {
                                       Object this$partType = this.getPartType();
                                       Object other$partType = other.getPartType();
                                       if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
                                          Object this$teamId = this.getTeamId();
                                          Object other$teamId = other.getTeamId();
                                          if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                             Object this$shopName = this.getShopName();
                                             Object other$shopName = other.getShopName();
                                             if (this$shopName == null ? other$shopName == null : this$shopName.equals(other$shopName)) {
                                                Object this$lineName = this.getLineName();
                                                Object other$lineName = other.getLineName();
                                                if (this$lineName == null ? other$lineName == null : this$lineName.equals(other$lineName)) {
                                                   Object this$processName = this.getProcessName();
                                                   Object other$processName = other.getProcessName();
                                                   if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                                      Object this$name = this.getName();
                                                      Object other$name = other.getName();
                                                      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                         Object this$teamLeaderName = this.getTeamLeaderName();
                                                         Object other$teamLeaderName = other.getTeamLeaderName();
                                                         return this$teamLeaderName == null
                                                            ? other$teamLeaderName == null
                                                            : this$teamLeaderName.equals(other$teamLeaderName);
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
      return other instanceof MesBuildingProductProcessLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $shopId = this.getShopId();
      result = result * 59 + ($shopId == null ? 43 : $shopId.hashCode());
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $classId = this.getClassId();
      result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $nodeTime = this.getNodeTime();
      result = result * 59 + ($nodeTime == null ? 43 : $nodeTime.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $typeId = this.getTypeId();
      result = result * 59 + ($typeId == null ? 43 : $typeId.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $shopName = this.getShopName();
      result = result * 59 + ($shopName == null ? 43 : $shopName.hashCode());
      Object $lineName = this.getLineName();
      result = result * 59 + ($lineName == null ? 43 : $lineName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      return result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
   }

   public static class MesBuildingProductProcessLinkDTOBuilder {
      private Long id;
      private Long shopId;
      private String shopName;
      private Long lineId;
      private String lineName;
      private Long classId;
      private Long productProcessId;
      private Long processId;
      private String processName;
      private Integer sequence;
      private String name;
      private Integer nodeTime;
      private Integer productType;
      private Integer type;
      private Long typeId;
      private Integer partType;
      private Long teamId;
      private String teamLeaderName;

      MesBuildingProductProcessLinkDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("shopId")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder shopId(final Long shopId) {
         this.shopId = shopId;
         return this;
      }

      @JsonProperty("shopName")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder shopName(final String shopName) {
         this.shopName = shopName;
         return this;
      }

      @JsonProperty("lineId")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      @JsonProperty("lineName")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder lineName(final String lineName) {
         this.lineName = lineName;
         return this;
      }

      @JsonProperty("classId")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder classId(final Long classId) {
         this.classId = classId;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("nodeTime")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder nodeTime(final Integer nodeTime) {
         this.nodeTime = nodeTime;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("typeId")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder typeId(final Long typeId) {
         this.typeId = typeId;
         return this;
      }

      @JsonProperty("partType")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder partType(final Integer partType) {
         this.partType = partType;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("teamLeaderName")
      public MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      public MesBuildingProductProcessLinkDTO build() {
         return new MesBuildingProductProcessLinkDTO(
            this.id,
            this.shopId,
            this.shopName,
            this.lineId,
            this.lineName,
            this.classId,
            this.productProcessId,
            this.processId,
            this.processName,
            this.sequence,
            this.name,
            this.nodeTime,
            this.productType,
            this.type,
            this.typeId,
            this.partType,
            this.teamId,
            this.teamLeaderName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductProcessLinkDTO.MesBuildingProductProcessLinkDTOBuilder(id="
            + this.id
            + ", shopId="
            + this.shopId
            + ", shopName="
            + this.shopName
            + ", lineId="
            + this.lineId
            + ", lineName="
            + this.lineName
            + ", classId="
            + this.classId
            + ", productProcessId="
            + this.productProcessId
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", sequence="
            + this.sequence
            + ", name="
            + this.name
            + ", nodeTime="
            + this.nodeTime
            + ", productType="
            + this.productType
            + ", type="
            + this.type
            + ", typeId="
            + this.typeId
            + ", partType="
            + this.partType
            + ", teamId="
            + this.teamId
            + ", teamLeaderName="
            + this.teamLeaderName
            + ")";
      }
   }
}

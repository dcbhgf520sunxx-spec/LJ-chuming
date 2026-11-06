package com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureTeamDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;

@ApiModel(value = "MesEnclosureProductionLineDTO对象", description = "")
public class MesEnclosureProductionLineDO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "生产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "禁用状态 禁用状态 启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "userId", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "factoryName", notes = "工厂名", value = "工厂名")
   @JsonProperty("factoryName")
   @JSONField(name = "factoryName")
   private String factoryName;
   @ApiModelProperty(name = "workshopName", notes = "车间名", value = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "type", value = "可生产板材类型", notes = "可生产板材类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '排序'", nullable = true)
   private Integer type;
   @ApiModelProperty(name = "targetProduction", value = "目标产量", notes = "目标产量")
   @JsonProperty("targetProduction")
   @JSONField(name = "targetProduction")
   private BigDecimal targetProduction;
   @ApiModelProperty(name = "linkIdList", value = "产品种类", notes = "产品种类")
   @JsonProperty("linkIdList")
   @JSONField(name = "linkIdList")
   private List<Long> linkIdList;
   @ApiModelProperty(name = "teamList", notes = "生产组列表", value = "生产组列表")
   @JsonProperty("teamList")
   @JSONField(name = "teamList")
   @JsonInclude(Include.NON_NULL)
   private List<MesEnclosureTeamDTO> teamList;

   public static MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder builder() {
      return new MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getTargetProduction() {
      return this.targetProduction;
   }

   public List<Long> getLinkIdList() {
      return this.linkIdList;
   }

   public List<MesEnclosureTeamDTO> getTeamList() {
      return this.teamList;
   }

   @JsonProperty("id")
   public MesEnclosureProductionLineDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureProductionLineDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public MesEnclosureProductionLineDO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesEnclosureProductionLineDO setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureProductionLineDO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureProductionLineDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureProductionLineDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureProductionLineDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("factoryName")
   public MesEnclosureProductionLineDO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @JsonProperty("workshopName")
   public MesEnclosureProductionLineDO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("type")
   public MesEnclosureProductionLineDO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("targetProduction")
   public MesEnclosureProductionLineDO setTargetProduction(final BigDecimal targetProduction) {
      this.targetProduction = targetProduction;
      return this;
   }

   @JsonProperty("linkIdList")
   public MesEnclosureProductionLineDO setLinkIdList(final List<Long> linkIdList) {
      this.linkIdList = linkIdList;
      return this;
   }

   @JsonProperty("teamList")
   public MesEnclosureProductionLineDO setTeamList(final List<MesEnclosureTeamDTO> teamList) {
      this.teamList = teamList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductionLineDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", remark="
         + this.getRemark()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", userId="
         + this.getUserId()
         + ", factoryName="
         + this.getFactoryName()
         + ", workshopName="
         + this.getWorkshopName()
         + ", type="
         + this.getType()
         + ", targetProduction="
         + this.getTargetProduction()
         + ", linkIdList="
         + this.getLinkIdList()
         + ", teamList="
         + this.getTeamList()
         + ")";
   }

   public MesEnclosureProductionLineDO(
      final Long id,
      final String name,
      final Integer sort,
      final Boolean boolEnabledEnum,
      final String remark,
      final Long factoryId,
      final Long workshopId,
      final Long userId,
      final String factoryName,
      final String workshopName,
      final Integer type,
      final BigDecimal targetProduction,
      final List<Long> linkIdList,
      final List<MesEnclosureTeamDTO> teamList
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.boolEnabledEnum = boolEnabledEnum;
      this.remark = remark;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.userId = userId;
      this.factoryName = factoryName;
      this.workshopName = workshopName;
      this.type = type;
      this.targetProduction = targetProduction;
      this.linkIdList = linkIdList;
      this.teamList = teamList;
   }

   public MesEnclosureProductionLineDO() {
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductionLineDO)) {
         return false;
      }

      MesEnclosureProductionLineDO other = (MesEnclosureProductionLineDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$boolEnabledEnum = this.getBoolEnabledEnum();
            Object other$boolEnabledEnum = other.getBoolEnabledEnum();
            if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$factoryName = this.getFactoryName();
                                 Object other$factoryName = other.getFactoryName();
                                 if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                                    Object this$workshopName = this.getWorkshopName();
                                    Object other$workshopName = other.getWorkshopName();
                                    if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                       Object this$targetProduction = this.getTargetProduction();
                                       Object other$targetProduction = other.getTargetProduction();
                                       if (this$targetProduction == null
                                          ? other$targetProduction == null
                                          : this$targetProduction.equals(other$targetProduction)) {
                                          Object this$linkIdList = this.getLinkIdList();
                                          Object other$linkIdList = other.getLinkIdList();
                                          if (this$linkIdList == null ? other$linkIdList == null : this$linkIdList.equals(other$linkIdList)) {
                                             Object this$teamList = this.getTeamList();
                                             Object other$teamList = other.getTeamList();
                                             return this$teamList == null ? other$teamList == null : this$teamList.equals(other$teamList);
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
      return other instanceof MesEnclosureProductionLineDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $targetProduction = this.getTargetProduction();
      result = result * 59 + ($targetProduction == null ? 43 : $targetProduction.hashCode());
      Object $linkIdList = this.getLinkIdList();
      result = result * 59 + ($linkIdList == null ? 43 : $linkIdList.hashCode());
      Object $teamList = this.getTeamList();
      return result * 59 + ($teamList == null ? 43 : $teamList.hashCode());
   }

   public static class MesEnclosureProductionLineDOBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Boolean boolEnabledEnum;
      private String remark;
      private Long factoryId;
      private Long workshopId;
      private Long userId;
      private String factoryName;
      private String workshopName;
      private Integer type;
      private BigDecimal targetProduction;
      private List<Long> linkIdList;
      private List<MesEnclosureTeamDTO> teamList;

      MesEnclosureProductionLineDOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("factoryName")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      @JsonProperty("workshopName")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("type")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("targetProduction")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder targetProduction(final BigDecimal targetProduction) {
         this.targetProduction = targetProduction;
         return this;
      }

      @JsonProperty("linkIdList")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder linkIdList(final List<Long> linkIdList) {
         this.linkIdList = linkIdList;
         return this;
      }

      @JsonProperty("teamList")
      public MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder teamList(final List<MesEnclosureTeamDTO> teamList) {
         this.teamList = teamList;
         return this;
      }

      public MesEnclosureProductionLineDO build() {
         return new MesEnclosureProductionLineDO(
            this.id,
            this.name,
            this.sort,
            this.boolEnabledEnum,
            this.remark,
            this.factoryId,
            this.workshopId,
            this.userId,
            this.factoryName,
            this.workshopName,
            this.type,
            this.targetProduction,
            this.linkIdList,
            this.teamList
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureProductionLineDO.MesEnclosureProductionLineDOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", remark="
            + this.remark
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", userId="
            + this.userId
            + ", factoryName="
            + this.factoryName
            + ", workshopName="
            + this.workshopName
            + ", type="
            + this.type
            + ", targetProduction="
            + this.targetProduction
            + ", linkIdList="
            + this.linkIdList
            + ", teamList="
            + this.teamList
            + ")";
      }
   }
}

package com.hzchum.scim.mes.enclosure.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureMachinePartSchedulingDO", description = "零件信息")
public class MesEnclosureMachinePartSchedulingDO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "userId", value = "操作人id", notes = "操作人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "操作人名称", notes = "操作人名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "layWayConfigId", value = "下料配置id", notes = "下料配置id")
   @JsonProperty("layWayConfigId")
   @JSONField(name = "layWayConfigId")
   private Long layWayConfigId;
   @ApiModelProperty(name = "name", value = "下料方式名称", notes = "下料方式名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "orderNumber", value = "任务单号", notes = "任务单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "date", value = "排产日期", notes = "排产日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "thick", value = "厚度", notes = "厚度")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   private String thick;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "issueStatusEnum", value = "任务状态 [1 未套料 2 套料中 4 套料完成 8 已下发]", notes = "任务状态 [1 未套料 2 套料中 4 套料完成 8 已下发]")
   @JsonProperty("issueStatusEnum")
   @JSONField(name = "issueStatusEnum")
   private Integer issueStatusEnum;
   @ApiModelProperty(name = "nestingTime", value = "套料时间", notes = "套料时间")
   @JsonProperty("nestingTime")
   @JSONField(name = "nestingTime")
   private LocalDateTime nestingTime;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   private Long cutConfigId;
   @ApiModelProperty(name = "cutConfigName", value = "切割配置名称", notes = "切割配置名称")
   @JsonProperty("cutConfigName")
   @JSONField(name = "cutConfigName")
   private String cutConfigName;
   @ApiModelProperty(name = "boolNestCutEnum", value = "是否是套料", notes = "是否是套料")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   private Boolean boolNestCutEnum;

   public static MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder builder() {
      return new MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder();
   }

   public MesEnclosureMachinePartSchedulingDO(
      final Long id,
      final Long userId,
      final String userName,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final Long layWayConfigId,
      final String name,
      final String orderNumber,
      final String date,
      final String thick,
      final LocalDateTime askCompleteTime,
      final Integer issueStatusEnum,
      final LocalDateTime nestingTime,
      final Long cutConfigId,
      final String cutConfigName,
      final Boolean boolNestCutEnum
   ) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.layWayConfigId = layWayConfigId;
      this.name = name;
      this.orderNumber = orderNumber;
      this.date = date;
      this.thick = thick;
      this.askCompleteTime = askCompleteTime;
      this.issueStatusEnum = issueStatusEnum;
      this.nestingTime = nestingTime;
      this.cutConfigId = cutConfigId;
      this.cutConfigName = cutConfigName;
      this.boolNestCutEnum = boolNestCutEnum;
   }

   public MesEnclosureMachinePartSchedulingDO() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Long getLayWayConfigId() {
      return this.layWayConfigId;
   }

   public String getName() {
      return this.name;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getDate() {
      return this.date;
   }

   public String getThick() {
      return this.thick;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Integer getIssueStatusEnum() {
      return this.issueStatusEnum;
   }

   public LocalDateTime getNestingTime() {
      return this.nestingTime;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public String getCutConfigName() {
      return this.cutConfigName;
   }

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   @JsonProperty("id")
   public MesEnclosureMachinePartSchedulingDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureMachinePartSchedulingDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureMachinePartSchedulingDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureMachinePartSchedulingDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesEnclosureMachinePartSchedulingDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesEnclosureMachinePartSchedulingDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public MesEnclosureMachinePartSchedulingDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureMachinePartSchedulingDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesEnclosureMachinePartSchedulingDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesEnclosureMachinePartSchedulingDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesEnclosureMachinePartSchedulingDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("layWayConfigId")
   public MesEnclosureMachinePartSchedulingDO setLayWayConfigId(final Long layWayConfigId) {
      this.layWayConfigId = layWayConfigId;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureMachinePartSchedulingDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesEnclosureMachinePartSchedulingDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("date")
   public MesEnclosureMachinePartSchedulingDO setDate(final String date) {
      this.date = date;
      return this;
   }

   @JsonProperty("thick")
   public MesEnclosureMachinePartSchedulingDO setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureMachinePartSchedulingDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("issueStatusEnum")
   public MesEnclosureMachinePartSchedulingDO setIssueStatusEnum(final Integer issueStatusEnum) {
      this.issueStatusEnum = issueStatusEnum;
      return this;
   }

   @JsonProperty("nestingTime")
   public MesEnclosureMachinePartSchedulingDO setNestingTime(final LocalDateTime nestingTime) {
      this.nestingTime = nestingTime;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesEnclosureMachinePartSchedulingDO setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("cutConfigName")
   public MesEnclosureMachinePartSchedulingDO setCutConfigName(final String cutConfigName) {
      this.cutConfigName = cutConfigName;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public MesEnclosureMachinePartSchedulingDO setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureMachinePartSchedulingDO(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", layWayConfigId="
         + this.getLayWayConfigId()
         + ", name="
         + this.getName()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", date="
         + this.getDate()
         + ", thick="
         + this.getThick()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", issueStatusEnum="
         + this.getIssueStatusEnum()
         + ", nestingTime="
         + this.getNestingTime()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", cutConfigName="
         + this.getCutConfigName()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachinePartSchedulingDO)) {
         return false;
      }

      MesEnclosureMachinePartSchedulingDO other = (MesEnclosureMachinePartSchedulingDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$layWayConfigId = this.getLayWayConfigId();
               Object other$layWayConfigId = other.getLayWayConfigId();
               if (this$layWayConfigId == null ? other$layWayConfigId == null : this$layWayConfigId.equals(other$layWayConfigId)) {
                  Object this$issueStatusEnum = this.getIssueStatusEnum();
                  Object other$issueStatusEnum = other.getIssueStatusEnum();
                  if (this$issueStatusEnum == null ? other$issueStatusEnum == null : this$issueStatusEnum.equals(other$issueStatusEnum)) {
                     Object this$cutConfigId = this.getCutConfigId();
                     Object other$cutConfigId = other.getCutConfigId();
                     if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
                        Object this$boolNestCutEnum = this.getBoolNestCutEnum();
                        Object other$boolNestCutEnum = other.getBoolNestCutEnum();
                        if (this$boolNestCutEnum == null ? other$boolNestCutEnum == null : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
                           Object this$userName = this.getUserName();
                           Object other$userName = other.getUserName();
                           if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$length = this.getLength();
                                    Object other$length = other.getLength();
                                    if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$netWeight = this.getNetWeight();
                                          Object other$netWeight = other.getNetWeight();
                                          if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                             Object this$totalNetWeight = this.getTotalNetWeight();
                                             Object other$totalNetWeight = other.getTotalNetWeight();
                                             if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                Object this$grossWeight = this.getGrossWeight();
                                                Object other$grossWeight = other.getGrossWeight();
                                                if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                   Object this$name = this.getName();
                                                   Object other$name = other.getName();
                                                   if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                      Object this$orderNumber = this.getOrderNumber();
                                                      Object other$orderNumber = other.getOrderNumber();
                                                      if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                                         Object this$date = this.getDate();
                                                         Object other$date = other.getDate();
                                                         if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                                                            Object this$thick = this.getThick();
                                                            Object other$thick = other.getThick();
                                                            if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                               Object this$askCompleteTime = this.getAskCompleteTime();
                                                               Object other$askCompleteTime = other.getAskCompleteTime();
                                                               if (this$askCompleteTime == null
                                                                  ? other$askCompleteTime == null
                                                                  : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                  Object this$nestingTime = this.getNestingTime();
                                                                  Object other$nestingTime = other.getNestingTime();
                                                                  if (this$nestingTime == null
                                                                     ? other$nestingTime == null
                                                                     : this$nestingTime.equals(other$nestingTime)) {
                                                                     Object this$cutConfigName = this.getCutConfigName();
                                                                     Object other$cutConfigName = other.getCutConfigName();
                                                                     return this$cutConfigName == null
                                                                        ? other$cutConfigName == null
                                                                        : this$cutConfigName.equals(other$cutConfigName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureMachinePartSchedulingDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $layWayConfigId = this.getLayWayConfigId();
      result = result * 59 + ($layWayConfigId == null ? 43 : $layWayConfigId.hashCode());
      Object $issueStatusEnum = this.getIssueStatusEnum();
      result = result * 59 + ($issueStatusEnum == null ? 43 : $issueStatusEnum.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $nestingTime = this.getNestingTime();
      result = result * 59 + ($nestingTime == null ? 43 : $nestingTime.hashCode());
      Object $cutConfigName = this.getCutConfigName();
      return result * 59 + ($cutConfigName == null ? 43 : $cutConfigName.hashCode());
   }

   public static class MesEnclosureMachinePartSchedulingDOBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private Long layWayConfigId;
      private String name;
      private String orderNumber;
      private String date;
      private String thick;
      private LocalDateTime askCompleteTime;
      private Integer issueStatusEnum;
      private LocalDateTime nestingTime;
      private Long cutConfigId;
      private String cutConfigName;
      private Boolean boolNestCutEnum;

      MesEnclosureMachinePartSchedulingDOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("layWayConfigId")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder layWayConfigId(final Long layWayConfigId) {
         this.layWayConfigId = layWayConfigId;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("date")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      @JsonProperty("thick")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("issueStatusEnum")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder issueStatusEnum(final Integer issueStatusEnum) {
         this.issueStatusEnum = issueStatusEnum;
         return this;
      }

      @JsonProperty("nestingTime")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder nestingTime(final LocalDateTime nestingTime) {
         this.nestingTime = nestingTime;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("cutConfigName")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder cutConfigName(final String cutConfigName) {
         this.cutConfigName = cutConfigName;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      public MesEnclosureMachinePartSchedulingDO build() {
         return new MesEnclosureMachinePartSchedulingDO(
            this.id,
            this.userId,
            this.userName,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.layWayConfigId,
            this.name,
            this.orderNumber,
            this.date,
            this.thick,
            this.askCompleteTime,
            this.issueStatusEnum,
            this.nestingTime,
            this.cutConfigId,
            this.cutConfigName,
            this.boolNestCutEnum
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureMachinePartSchedulingDO.MesEnclosureMachinePartSchedulingDOBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", layWayConfigId="
            + this.layWayConfigId
            + ", name="
            + this.name
            + ", orderNumber="
            + this.orderNumber
            + ", date="
            + this.date
            + ", thick="
            + this.thick
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", issueStatusEnum="
            + this.issueStatusEnum
            + ", nestingTime="
            + this.nestingTime
            + ", cutConfigId="
            + this.cutConfigId
            + ", cutConfigName="
            + this.cutConfigName
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ")";
      }
   }
}

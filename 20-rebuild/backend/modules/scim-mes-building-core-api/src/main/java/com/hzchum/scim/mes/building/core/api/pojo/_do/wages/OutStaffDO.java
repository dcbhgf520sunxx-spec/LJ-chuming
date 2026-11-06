package com.hzchum.scim.mes.building.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "OutStaffDO", description = "")
public class OutStaffDO {
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "areaDetail", notes = "区域")
   @JsonProperty("areaDetail")
   @JSONField(name = "areaDetail")
   private AreaDetailDO areaDetail;
   @ApiModelProperty(name = "leaderName", notes = "班组长名")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "userName", notes = "操作人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成重量")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务净重")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskLength", notes = "任务长度")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "mate", notes = "核算量")
   @JsonProperty("mate")
   @JSONField(name = "mate")
   private BigDecimal mate;
   @ApiModelProperty(name = "wage", notes = "单价")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   private BigDecimal wage;
   @ApiModelProperty(name = "price", notes = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private BigDecimal wageQuotaType;
   @ApiModelProperty(name = "productType", notes = "类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "userId", value = "修改人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "auditUserId", value = "审核人")
   @JsonProperty("auditUserId")
   @JSONField(name = "auditUserId")
   private Long auditUserId;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "createTime", value = "修改时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "auditStatus", value = "审核状态")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   private Integer auditStatus;
   @ApiModelProperty(name = "id", value = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;

   public static OutStaffDO.OutStaffDOBuilder builder() {
      return new OutStaffDO.OutStaffDOBuilder();
   }

   public OutStaffDO(
      final MonomerDetailDO monomer,
      final AreaDetailDO areaDetail,
      final String leaderName,
      final String userName,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Integer completeQuantity,
      final Integer taskQuantity,
      final BigDecimal completeNetWeight,
      final BigDecimal taskNetWeight,
      final BigDecimal taskLength,
      final BigDecimal mate,
      final BigDecimal wage,
      final BigDecimal price,
      final BigDecimal wageQuotaType,
      final Integer productType,
      final Long productId,
      final Long teamId,
      final Long userId,
      final Long auditUserId,
      final LocalDateTime auditTime,
      final LocalDateTime createTime,
      final Integer auditStatus,
      final Long id
   ) {
      this.monomer = monomer;
      this.areaDetail = areaDetail;
      this.leaderName = leaderName;
      this.userName = userName;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.completeQuantity = completeQuantity;
      this.taskQuantity = taskQuantity;
      this.completeNetWeight = completeNetWeight;
      this.taskNetWeight = taskNetWeight;
      this.taskLength = taskLength;
      this.mate = mate;
      this.wage = wage;
      this.price = price;
      this.wageQuotaType = wageQuotaType;
      this.productType = productType;
      this.productId = productId;
      this.teamId = teamId;
      this.userId = userId;
      this.auditUserId = auditUserId;
      this.auditTime = auditTime;
      this.createTime = createTime;
      this.auditStatus = auditStatus;
      this.id = id;
   }

   public OutStaffDO() {
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getAreaDetail() {
      return this.areaDetail;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getMate() {
      return this.mate;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getId() {
      return this.id;
   }

   @JsonProperty("monomer")
   public OutStaffDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public OutStaffDO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("leaderName")
   public OutStaffDO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("userName")
   public OutStaffDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("name")
   public OutStaffDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public OutStaffDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public OutStaffDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public OutStaffDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("completeQuantity")
   public OutStaffDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public OutStaffDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public OutStaffDO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public OutStaffDO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskLength")
   public OutStaffDO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("mate")
   public OutStaffDO setMate(final BigDecimal mate) {
      this.mate = mate;
      return this;
   }

   @JsonProperty("wage")
   public OutStaffDO setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   @JsonProperty("price")
   public OutStaffDO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public OutStaffDO setWageQuotaType(final BigDecimal wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("productType")
   public OutStaffDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productId")
   public OutStaffDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("teamId")
   public OutStaffDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("userId")
   public OutStaffDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("auditUserId")
   public OutStaffDO setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   @JsonProperty("auditTime")
   public OutStaffDO setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @JsonProperty("createTime")
   public OutStaffDO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("auditStatus")
   public OutStaffDO setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @JsonProperty("id")
   public OutStaffDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @Override
   public String toString() {
      return "OutStaffDO(monomer="
         + this.getMonomer()
         + ", areaDetail="
         + this.getAreaDetail()
         + ", leaderName="
         + this.getLeaderName()
         + ", userName="
         + this.getUserName()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskLength="
         + this.getTaskLength()
         + ", mate="
         + this.getMate()
         + ", wage="
         + this.getWage()
         + ", price="
         + this.getPrice()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditTime="
         + this.getAuditTime()
         + ", createTime="
         + this.getCreateTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", id="
         + this.getId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutStaffDO)) {
         return false;
      }

      OutStaffDO other = (OutStaffDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$completeQuantity = this.getCompleteQuantity();
      Object other$completeQuantity = other.getCompleteQuantity();
      if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$teamId = this.getTeamId();
                  Object other$teamId = other.getTeamId();
                  if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$auditUserId = this.getAuditUserId();
                        Object other$auditUserId = other.getAuditUserId();
                        if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                           Object this$auditStatus = this.getAuditStatus();
                           Object other$auditStatus = other.getAuditStatus();
                           if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                              Object this$id = this.getId();
                              Object other$id = other.getId();
                              if (this$id == null ? other$id == null : this$id.equals(other$id)) {
                                 Object this$monomer = this.getMonomer();
                                 Object other$monomer = other.getMonomer();
                                 if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                    Object this$areaDetail = this.getAreaDetail();
                                    Object other$areaDetail = other.getAreaDetail();
                                    if (this$areaDetail == null ? other$areaDetail == null : this$areaDetail.equals(other$areaDetail)) {
                                       Object this$leaderName = this.getLeaderName();
                                       Object other$leaderName = other.getLeaderName();
                                       if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                                          Object this$userName = this.getUserName();
                                          Object other$userName = other.getUserName();
                                          if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                             Object this$name = this.getName();
                                             Object other$name = other.getName();
                                             if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$completeNetWeight = this.getCompleteNetWeight();
                                                         Object other$completeNetWeight = other.getCompleteNetWeight();
                                                         if (this$completeNetWeight == null
                                                            ? other$completeNetWeight == null
                                                            : this$completeNetWeight.equals(other$completeNetWeight)) {
                                                            Object this$taskNetWeight = this.getTaskNetWeight();
                                                            Object other$taskNetWeight = other.getTaskNetWeight();
                                                            if (this$taskNetWeight == null
                                                               ? other$taskNetWeight == null
                                                               : this$taskNetWeight.equals(other$taskNetWeight)) {
                                                               Object this$taskLength = this.getTaskLength();
                                                               Object other$taskLength = other.getTaskLength();
                                                               if (this$taskLength == null
                                                                  ? other$taskLength == null
                                                                  : this$taskLength.equals(other$taskLength)) {
                                                                  Object this$mate = this.getMate();
                                                                  Object other$mate = other.getMate();
                                                                  if (this$mate == null ? other$mate == null : this$mate.equals(other$mate)) {
                                                                     Object this$wage = this.getWage();
                                                                     Object other$wage = other.getWage();
                                                                     if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                                                        Object this$price = this.getPrice();
                                                                        Object other$price = other.getPrice();
                                                                        if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                                           Object this$wageQuotaType = this.getWageQuotaType();
                                                                           Object other$wageQuotaType = other.getWageQuotaType();
                                                                           if (this$wageQuotaType == null
                                                                              ? other$wageQuotaType == null
                                                                              : this$wageQuotaType.equals(other$wageQuotaType)) {
                                                                              Object this$auditTime = this.getAuditTime();
                                                                              Object other$auditTime = other.getAuditTime();
                                                                              if (this$auditTime == null
                                                                                 ? other$auditTime == null
                                                                                 : this$auditTime.equals(other$auditTime)) {
                                                                                 Object this$createTime = this.getCreateTime();
                                                                                 Object other$createTime = other.getCreateTime();
                                                                                 return this$createTime == null
                                                                                    ? other$createTime == null
                                                                                    : this$createTime.equals(other$createTime);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OutStaffDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $areaDetail = this.getAreaDetail();
      result = result * 59 + ($areaDetail == null ? 43 : $areaDetail.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $mate = this.getMate();
      result = result * 59 + ($mate == null ? 43 : $mate.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   public static class OutStaffDOBuilder {
      private MonomerDetailDO monomer;
      private AreaDetailDO areaDetail;
      private String leaderName;
      private String userName;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Integer completeQuantity;
      private Integer taskQuantity;
      private BigDecimal completeNetWeight;
      private BigDecimal taskNetWeight;
      private BigDecimal taskLength;
      private BigDecimal mate;
      private BigDecimal wage;
      private BigDecimal price;
      private BigDecimal wageQuotaType;
      private Integer productType;
      private Long productId;
      private Long teamId;
      private Long userId;
      private Long auditUserId;
      private LocalDateTime auditTime;
      private LocalDateTime createTime;
      private Integer auditStatus;
      private Long id;

      OutStaffDOBuilder() {
      }

      @JsonProperty("monomer")
      public OutStaffDO.OutStaffDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public OutStaffDO.OutStaffDOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("leaderName")
      public OutStaffDO.OutStaffDOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("userName")
      public OutStaffDO.OutStaffDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("name")
      public OutStaffDO.OutStaffDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public OutStaffDO.OutStaffDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public OutStaffDO.OutStaffDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public OutStaffDO.OutStaffDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("completeQuantity")
      public OutStaffDO.OutStaffDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public OutStaffDO.OutStaffDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public OutStaffDO.OutStaffDOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public OutStaffDO.OutStaffDOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskLength")
      public OutStaffDO.OutStaffDOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("mate")
      public OutStaffDO.OutStaffDOBuilder mate(final BigDecimal mate) {
         this.mate = mate;
         return this;
      }

      @JsonProperty("wage")
      public OutStaffDO.OutStaffDOBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      @JsonProperty("price")
      public OutStaffDO.OutStaffDOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public OutStaffDO.OutStaffDOBuilder wageQuotaType(final BigDecimal wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("productType")
      public OutStaffDO.OutStaffDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("productId")
      public OutStaffDO.OutStaffDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("teamId")
      public OutStaffDO.OutStaffDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("userId")
      public OutStaffDO.OutStaffDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("auditUserId")
      public OutStaffDO.OutStaffDOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      @JsonProperty("auditTime")
      public OutStaffDO.OutStaffDOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      @JsonProperty("createTime")
      public OutStaffDO.OutStaffDOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("auditStatus")
      public OutStaffDO.OutStaffDOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      @JsonProperty("id")
      public OutStaffDO.OutStaffDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OutStaffDO build() {
         return new OutStaffDO(
            this.monomer,
            this.areaDetail,
            this.leaderName,
            this.userName,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.completeQuantity,
            this.taskQuantity,
            this.completeNetWeight,
            this.taskNetWeight,
            this.taskLength,
            this.mate,
            this.wage,
            this.price,
            this.wageQuotaType,
            this.productType,
            this.productId,
            this.teamId,
            this.userId,
            this.auditUserId,
            this.auditTime,
            this.createTime,
            this.auditStatus,
            this.id
         );
      }

      @Override
      public String toString() {
         return "OutStaffDO.OutStaffDOBuilder(monomer="
            + this.monomer
            + ", areaDetail="
            + this.areaDetail
            + ", leaderName="
            + this.leaderName
            + ", userName="
            + this.userName
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", completeQuantity="
            + this.completeQuantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskLength="
            + this.taskLength
            + ", mate="
            + this.mate
            + ", wage="
            + this.wage
            + ", price="
            + this.price
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", teamId="
            + this.teamId
            + ", userId="
            + this.userId
            + ", auditUserId="
            + this.auditUserId
            + ", auditTime="
            + this.auditTime
            + ", createTime="
            + this.createTime
            + ", auditStatus="
            + this.auditStatus
            + ", id="
            + this.id
            + ")";
      }
   }
}

package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;

@ApiModel(value = "MesEnclosureTaskOrderDTO", description = "任务工单分配表")
public class MesEnclosureTaskOrderDTO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "factoryName", notes = "工厂名")
   @JsonProperty("factoryName")
   @JSONField(name = "factoryName")
   private String factoryName;
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
   @ApiModelProperty(name = "leaderName", value = "组长名", notes = "组长名")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "操作人名", notes = "操作人名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeLength", notes = "已完成长度")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;
   @ApiModelProperty(name = "completeTime", value = "完成日期", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "booleanlag", notes = "是否滞后 1:正常 0:滞后")
   @JsonProperty("booleanlag")
   @JSONField(name = "booleanlag")
   private Integer booleanlag;
   @ApiModelProperty(name = "totalLength", value = "总长度", notes = "总长度")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "printQuantity", value = "打印次数", notes = "打印次数")
   @JsonProperty("printQuantity")
   @JSONField(name = "printQuantity")
   private Integer printQuantity;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "dictionaryName", notes = "类型名称")
   @JsonProperty("dictionaryName")
   @JSONField(name = "dictionaryName")
   private String dictionaryName;
   @ApiModelProperty(name = "booleanProduce", notes = "是否进入生产")
   @JsonProperty("booleanProduce")
   @JSONField(name = "booleanProduce")
   private Boolean booleanProduce;
   @ApiModelProperty(name = "inProductionTime", value = "进入生产日期", notes = "进入生产日期")
   @JsonProperty("inProductionTime")
   @JSONField(name = "inProductionTime")
   @TableField("in_production_time")
   @Column(name = "in_production_time", columnDefinition = "datetime  COMMENT '进入生产日期'", nullable = true)
   private LocalDateTime inProductionTime;

   public static MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder builder() {
      return new MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder();
   }

   public MesEnclosureTaskOrderDTO() {
   }

   public MesEnclosureTaskOrderDTO(
      final Long id,
      final Long factoryId,
      final String factoryName,
      final Long workshopId,
      final String workshopName,
      final Long productionLineId,
      final String productionLineName,
      final Long teamId,
      final String leaderName,
      final Long projectId,
      final LocalDateTime askCompleteTime,
      final Long userId,
      final String userName,
      final String orderNumber,
      final Integer quantity,
      final Integer completeQuantity,
      final BigDecimal completeLength,
      final LocalDateTime completeTime,
      final Integer booleanlag,
      final BigDecimal totalLength,
      final Integer printQuantity,
      final Integer category,
      final String dictionaryName,
      final Boolean booleanProduce,
      final LocalDateTime inProductionTime
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.factoryName = factoryName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.teamId = teamId;
      this.leaderName = leaderName;
      this.projectId = projectId;
      this.askCompleteTime = askCompleteTime;
      this.userId = userId;
      this.userName = userName;
      this.orderNumber = orderNumber;
      this.quantity = quantity;
      this.completeQuantity = completeQuantity;
      this.completeLength = completeLength;
      this.completeTime = completeTime;
      this.booleanlag = booleanlag;
      this.totalLength = totalLength;
      this.printQuantity = printQuantity;
      this.category = category;
      this.dictionaryName = dictionaryName;
      this.booleanProduce = booleanProduce;
      this.inProductionTime = inProductionTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getFactoryName() {
      return this.factoryName;
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

   public String getLeaderName() {
      return this.leaderName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Integer getBooleanlag() {
      return this.booleanlag;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getDictionaryName() {
      return this.dictionaryName;
   }

   public Boolean getBooleanProduce() {
      return this.booleanProduce;
   }

   public LocalDateTime getInProductionTime() {
      return this.inProductionTime;
   }

   @JsonProperty("id")
   public MesEnclosureTaskOrderDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureTaskOrderDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("factoryName")
   public MesEnclosureTaskOrderDTO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureTaskOrderDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public MesEnclosureTaskOrderDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureTaskOrderDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public MesEnclosureTaskOrderDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureTaskOrderDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("leaderName")
   public MesEnclosureTaskOrderDTO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureTaskOrderDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureTaskOrderDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTaskOrderDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureTaskOrderDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesEnclosureTaskOrderDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureTaskOrderDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesEnclosureTaskOrderDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeLength")
   public MesEnclosureTaskOrderDTO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("completeTime")
   public MesEnclosureTaskOrderDTO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("booleanlag")
   public MesEnclosureTaskOrderDTO setBooleanlag(final Integer booleanlag) {
      this.booleanlag = booleanlag;
      return this;
   }

   @JsonProperty("totalLength")
   public MesEnclosureTaskOrderDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesEnclosureTaskOrderDTO setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @JsonProperty("category")
   public MesEnclosureTaskOrderDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("dictionaryName")
   public MesEnclosureTaskOrderDTO setDictionaryName(final String dictionaryName) {
      this.dictionaryName = dictionaryName;
      return this;
   }

   @JsonProperty("booleanProduce")
   public MesEnclosureTaskOrderDTO setBooleanProduce(final Boolean booleanProduce) {
      this.booleanProduce = booleanProduce;
      return this;
   }

   @JsonProperty("inProductionTime")
   public MesEnclosureTaskOrderDTO setInProductionTime(final LocalDateTime inProductionTime) {
      this.inProductionTime = inProductionTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrderDTO(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", factoryName="
         + this.getFactoryName()
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
         + ", leaderName="
         + this.getLeaderName()
         + ", projectId="
         + this.getProjectId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", quantity="
         + this.getQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeLength="
         + this.getCompleteLength()
         + ", completeTime="
         + this.getCompleteTime()
         + ", booleanlag="
         + this.getBooleanlag()
         + ", totalLength="
         + this.getTotalLength()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", category="
         + this.getCategory()
         + ", dictionaryName="
         + this.getDictionaryName()
         + ", booleanProduce="
         + this.getBooleanProduce()
         + ", inProductionTime="
         + this.getInProductionTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrderDTO)) {
         return false;
      }

      MesEnclosureTaskOrderDTO other = (MesEnclosureTaskOrderDTO)o;
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
                  Object this$teamId = this.getTeamId();
                  Object other$teamId = other.getTeamId();
                  if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$completeQuantity = this.getCompleteQuantity();
                              Object other$completeQuantity = other.getCompleteQuantity();
                              if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                                 Object this$booleanlag = this.getBooleanlag();
                                 Object other$booleanlag = other.getBooleanlag();
                                 if (this$booleanlag == null ? other$booleanlag == null : this$booleanlag.equals(other$booleanlag)) {
                                    Object this$printQuantity = this.getPrintQuantity();
                                    Object other$printQuantity = other.getPrintQuantity();
                                    if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                                       Object this$category = this.getCategory();
                                       Object other$category = other.getCategory();
                                       if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                          Object this$booleanProduce = this.getBooleanProduce();
                                          Object other$booleanProduce = other.getBooleanProduce();
                                          if (this$booleanProduce == null ? other$booleanProduce == null : this$booleanProduce.equals(other$booleanProduce)) {
                                             Object this$factoryName = this.getFactoryName();
                                             Object other$factoryName = other.getFactoryName();
                                             if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                                                Object this$workshopName = this.getWorkshopName();
                                                Object other$workshopName = other.getWorkshopName();
                                                if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                                   Object this$productionLineName = this.getProductionLineName();
                                                   Object other$productionLineName = other.getProductionLineName();
                                                   if (this$productionLineName == null
                                                      ? other$productionLineName == null
                                                      : this$productionLineName.equals(other$productionLineName)) {
                                                      Object this$leaderName = this.getLeaderName();
                                                      Object other$leaderName = other.getLeaderName();
                                                      if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                                                         Object this$askCompleteTime = this.getAskCompleteTime();
                                                         Object other$askCompleteTime = other.getAskCompleteTime();
                                                         if (this$askCompleteTime == null
                                                            ? other$askCompleteTime == null
                                                            : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                            Object this$userName = this.getUserName();
                                                            Object other$userName = other.getUserName();
                                                            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                               Object this$orderNumber = this.getOrderNumber();
                                                               Object other$orderNumber = other.getOrderNumber();
                                                               if (this$orderNumber == null
                                                                  ? other$orderNumber == null
                                                                  : this$orderNumber.equals(other$orderNumber)) {
                                                                  Object this$completeLength = this.getCompleteLength();
                                                                  Object other$completeLength = other.getCompleteLength();
                                                                  if (this$completeLength == null
                                                                     ? other$completeLength == null
                                                                     : this$completeLength.equals(other$completeLength)) {
                                                                     Object this$completeTime = this.getCompleteTime();
                                                                     Object other$completeTime = other.getCompleteTime();
                                                                     if (this$completeTime == null
                                                                        ? other$completeTime == null
                                                                        : this$completeTime.equals(other$completeTime)) {
                                                                        Object this$totalLength = this.getTotalLength();
                                                                        Object other$totalLength = other.getTotalLength();
                                                                        if (this$totalLength == null
                                                                           ? other$totalLength == null
                                                                           : this$totalLength.equals(other$totalLength)) {
                                                                           Object this$dictionaryName = this.getDictionaryName();
                                                                           Object other$dictionaryName = other.getDictionaryName();
                                                                           if (this$dictionaryName == null
                                                                              ? other$dictionaryName == null
                                                                              : this$dictionaryName.equals(other$dictionaryName)) {
                                                                              Object this$inProductionTime = this.getInProductionTime();
                                                                              Object other$inProductionTime = other.getInProductionTime();
                                                                              return this$inProductionTime == null
                                                                                 ? other$inProductionTime == null
                                                                                 : this$inProductionTime.equals(other$inProductionTime);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTaskOrderDTO;
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
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $booleanlag = this.getBooleanlag();
      result = result * 59 + ($booleanlag == null ? 43 : $booleanlag.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $booleanProduce = this.getBooleanProduce();
      result = result * 59 + ($booleanProduce == null ? 43 : $booleanProduce.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $dictionaryName = this.getDictionaryName();
      result = result * 59 + ($dictionaryName == null ? 43 : $dictionaryName.hashCode());
      Object $inProductionTime = this.getInProductionTime();
      return result * 59 + ($inProductionTime == null ? 43 : $inProductionTime.hashCode());
   }

   public static class MesEnclosureTaskOrderDTOBuilder {
      private Long id;
      private Long factoryId;
      private String factoryName;
      private Long workshopId;
      private String workshopName;
      private Long productionLineId;
      private String productionLineName;
      private Long teamId;
      private String leaderName;
      private Long projectId;
      private LocalDateTime askCompleteTime;
      private Long userId;
      private String userName;
      private String orderNumber;
      private Integer quantity;
      private Integer completeQuantity;
      private BigDecimal completeLength;
      private LocalDateTime completeTime;
      private Integer booleanlag;
      private BigDecimal totalLength;
      private Integer printQuantity;
      private Integer category;
      private String dictionaryName;
      private Boolean booleanProduce;
      private LocalDateTime inProductionTime;

      MesEnclosureTaskOrderDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("factoryName")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("leaderName")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeLength")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("completeTime")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("booleanlag")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder booleanlag(final Integer booleanlag) {
         this.booleanlag = booleanlag;
         return this;
      }

      @JsonProperty("totalLength")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      @JsonProperty("category")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("dictionaryName")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder dictionaryName(final String dictionaryName) {
         this.dictionaryName = dictionaryName;
         return this;
      }

      @JsonProperty("booleanProduce")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder booleanProduce(final Boolean booleanProduce) {
         this.booleanProduce = booleanProduce;
         return this;
      }

      @JsonProperty("inProductionTime")
      public MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder inProductionTime(final LocalDateTime inProductionTime) {
         this.inProductionTime = inProductionTime;
         return this;
      }

      public MesEnclosureTaskOrderDTO build() {
         return new MesEnclosureTaskOrderDTO(
            this.id,
            this.factoryId,
            this.factoryName,
            this.workshopId,
            this.workshopName,
            this.productionLineId,
            this.productionLineName,
            this.teamId,
            this.leaderName,
            this.projectId,
            this.askCompleteTime,
            this.userId,
            this.userName,
            this.orderNumber,
            this.quantity,
            this.completeQuantity,
            this.completeLength,
            this.completeTime,
            this.booleanlag,
            this.totalLength,
            this.printQuantity,
            this.category,
            this.dictionaryName,
            this.booleanProduce,
            this.inProductionTime
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskOrderDTO.MesEnclosureTaskOrderDTOBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", factoryName="
            + this.factoryName
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
            + ", leaderName="
            + this.leaderName
            + ", projectId="
            + this.projectId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", orderNumber="
            + this.orderNumber
            + ", quantity="
            + this.quantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeLength="
            + this.completeLength
            + ", completeTime="
            + this.completeTime
            + ", booleanlag="
            + this.booleanlag
            + ", totalLength="
            + this.totalLength
            + ", printQuantity="
            + this.printQuantity
            + ", category="
            + this.category
            + ", dictionaryName="
            + this.dictionaryName
            + ", booleanProduce="
            + this.booleanProduce
            + ", inProductionTime="
            + this.inProductionTime
            + ")";
      }
   }
}

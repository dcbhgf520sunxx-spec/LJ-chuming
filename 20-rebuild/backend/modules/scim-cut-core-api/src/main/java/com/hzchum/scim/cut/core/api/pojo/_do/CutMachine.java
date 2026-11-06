package com.hzchum.scim.cut.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CutMachine对象", description = "")
@Entity
@TableName("cut_machine")
@Table(name = "cut_machine")
public class CutMachine extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "brand")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String brand;
   @ApiModelProperty(name = "code")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String code;
   @ApiModelProperty(name = "director")
   @JsonProperty("director")
   @JSONField(name = "director")
   @TableField("director")
   @Column(name = "director", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String director;
   @ApiModelProperty(name = "mac")
   @JsonProperty("mac")
   @JSONField(name = "mac")
   @TableField("mac")
   @Column(name = "mac", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String mac;
   @ApiModelProperty(name = "machineName")
   @JsonProperty("machineName")
   @JSONField(name = "machineName")
   @TableField("machine_name")
   @Column(name = "machine_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String machineName;
   @ApiModelProperty(name = "machineNumber")
   @JsonProperty("machineNumber")
   @JSONField(name = "machineNumber")
   @TableField("machine_number")
   @Column(name = "machine_number", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String machineNumber;
   @ApiModelProperty(name = "machineType")
   @JsonProperty("machineType")
   @JSONField(name = "machineType")
   @TableField("machine_type")
   @Column(name = "machine_type", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String machineType;
   @ApiModelProperty(name = "online")
   @JsonProperty("online")
   @JSONField(name = "online")
   @TableField("online")
   @Column(name = "online", columnDefinition = "int default '0' COMMENT ''", nullable = true)
   private Integer online;
   @ApiModelProperty(name = "opcUrl")
   @JsonProperty("opcUrl")
   @JSONField(name = "opcUrl")
   @TableField("opc_url")
   @Column(name = "opc_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String opcUrl;
   @ApiModelProperty(name = "position")
   @JsonProperty("position")
   @JSONField(name = "position")
   @TableField("position")
   @Column(name = "position", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String position;
   @ApiModelProperty(name = "state")
   @JsonProperty("state")
   @JSONField(name = "state")
   @TableField("state")
   @Column(name = "state", columnDefinition = "int default '0' COMMENT ''", nullable = true)
   private Integer state;
   @ApiModelProperty(name = "workshopInf")
   @JsonProperty("workshopInf")
   @JSONField(name = "workshopInf")
   @TableField("workshop_inf")
   @Column(name = "workshop_inf", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String workshopInf;
   @ApiModelProperty(name = "assignNum")
   @JsonProperty("assignNum")
   @JSONField(name = "assignNum")
   @TableField("assign_num")
   @Column(name = "assign_num", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer assignNum;
   @ApiModelProperty(name = "assignWeight")
   @JsonProperty("assignWeight")
   @JSONField(name = "assignWeight")
   @TableField("assign_weight")
   @Column(name = "assign_weight", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal assignWeight;
   @ApiModelProperty(name = "sentNum")
   @JsonProperty("sentNum")
   @JSONField(name = "sentNum")
   @TableField("sent_num")
   @Column(name = "sent_num", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer sentNum;
   @ApiModelProperty(name = "sentWeight")
   @JsonProperty("sentWeight")
   @JSONField(name = "sentWeight")
   @TableField("sent_weight")
   @Column(name = "sent_weight", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal sentWeight;
   @ApiModelProperty(name = "factory")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   @TableField("factory")
   @Column(name = "factory", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String factory;
   @ApiModelProperty(name = "productionLine")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   @TableField("production_line")
   @Column(name = "production_line", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String productionLine;
   @ApiModelProperty(name = "factoryId")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long factoryId;
   @ApiModelProperty(name = "productionLineId")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long productionLineId;
   @ApiModelProperty(name = "workshopInfId")
   @JsonProperty("workshopInfId")
   @JSONField(name = "workshopInfId")
   @TableField("workshop_inf_id")
   @Column(name = "workshop_inf_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long workshopInfId;
   @ApiModelProperty(name = "directorId")
   @JsonProperty("directorId")
   @JSONField(name = "directorId")
   @TableField("director_id")
   @Column(name = "director_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long directorId;

   public static CutMachine.CutMachineBuilder builder() {
      return new CutMachine.CutMachineBuilder();
   }

   public CutMachine() {
   }

   public CutMachine(
      final Long id,
      final String brand,
      final String code,
      final String director,
      final String mac,
      final String machineName,
      final String machineNumber,
      final String machineType,
      final Integer online,
      final String opcUrl,
      final String position,
      final Integer state,
      final String workshopInf,
      final Integer assignNum,
      final BigDecimal assignWeight,
      final Integer sentNum,
      final BigDecimal sentWeight,
      final String factory,
      final String productionLine,
      final Long factoryId,
      final Long productionLineId,
      final Long workshopInfId,
      final Long directorId
   ) {
      this.id = id;
      this.brand = brand;
      this.code = code;
      this.director = director;
      this.mac = mac;
      this.machineName = machineName;
      this.machineNumber = machineNumber;
      this.machineType = machineType;
      this.online = online;
      this.opcUrl = opcUrl;
      this.position = position;
      this.state = state;
      this.workshopInf = workshopInf;
      this.assignNum = assignNum;
      this.assignWeight = assignWeight;
      this.sentNum = sentNum;
      this.sentWeight = sentWeight;
      this.factory = factory;
      this.productionLine = productionLine;
      this.factoryId = factoryId;
      this.productionLineId = productionLineId;
      this.workshopInfId = workshopInfId;
      this.directorId = directorId;
   }

   public Long getId() {
      return this.id;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getCode() {
      return this.code;
   }

   public String getDirector() {
      return this.director;
   }

   public String getMac() {
      return this.mac;
   }

   public String getMachineName() {
      return this.machineName;
   }

   public String getMachineNumber() {
      return this.machineNumber;
   }

   public String getMachineType() {
      return this.machineType;
   }

   public Integer getOnline() {
      return this.online;
   }

   public String getOpcUrl() {
      return this.opcUrl;
   }

   public String getPosition() {
      return this.position;
   }

   public Integer getState() {
      return this.state;
   }

   public String getWorkshopInf() {
      return this.workshopInf;
   }

   public Integer getAssignNum() {
      return this.assignNum;
   }

   public BigDecimal getAssignWeight() {
      return this.assignWeight;
   }

   public Integer getSentNum() {
      return this.sentNum;
   }

   public BigDecimal getSentWeight() {
      return this.sentWeight;
   }

   public String getFactory() {
      return this.factory;
   }

   public String getProductionLine() {
      return this.productionLine;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getWorkshopInfId() {
      return this.workshopInfId;
   }

   public Long getDirectorId() {
      return this.directorId;
   }

   @JsonProperty("id")
   public CutMachine setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("brand")
   public CutMachine setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("code")
   public CutMachine setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("director")
   public CutMachine setDirector(final String director) {
      this.director = director;
      return this;
   }

   @JsonProperty("mac")
   public CutMachine setMac(final String mac) {
      this.mac = mac;
      return this;
   }

   @JsonProperty("machineName")
   public CutMachine setMachineName(final String machineName) {
      this.machineName = machineName;
      return this;
   }

   @JsonProperty("machineNumber")
   public CutMachine setMachineNumber(final String machineNumber) {
      this.machineNumber = machineNumber;
      return this;
   }

   @JsonProperty("machineType")
   public CutMachine setMachineType(final String machineType) {
      this.machineType = machineType;
      return this;
   }

   @JsonProperty("online")
   public CutMachine setOnline(final Integer online) {
      this.online = online;
      return this;
   }

   @JsonProperty("opcUrl")
   public CutMachine setOpcUrl(final String opcUrl) {
      this.opcUrl = opcUrl;
      return this;
   }

   @JsonProperty("position")
   public CutMachine setPosition(final String position) {
      this.position = position;
      return this;
   }

   @JsonProperty("state")
   public CutMachine setState(final Integer state) {
      this.state = state;
      return this;
   }

   @JsonProperty("workshopInf")
   public CutMachine setWorkshopInf(final String workshopInf) {
      this.workshopInf = workshopInf;
      return this;
   }

   @JsonProperty("assignNum")
   public CutMachine setAssignNum(final Integer assignNum) {
      this.assignNum = assignNum;
      return this;
   }

   @JsonProperty("assignWeight")
   public CutMachine setAssignWeight(final BigDecimal assignWeight) {
      this.assignWeight = assignWeight;
      return this;
   }

   @JsonProperty("sentNum")
   public CutMachine setSentNum(final Integer sentNum) {
      this.sentNum = sentNum;
      return this;
   }

   @JsonProperty("sentWeight")
   public CutMachine setSentWeight(final BigDecimal sentWeight) {
      this.sentWeight = sentWeight;
      return this;
   }

   @JsonProperty("factory")
   public CutMachine setFactory(final String factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("productionLine")
   public CutMachine setProductionLine(final String productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("factoryId")
   public CutMachine setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("productionLineId")
   public CutMachine setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("workshopInfId")
   public CutMachine setWorkshopInfId(final Long workshopInfId) {
      this.workshopInfId = workshopInfId;
      return this;
   }

   @JsonProperty("directorId")
   public CutMachine setDirectorId(final Long directorId) {
      this.directorId = directorId;
      return this;
   }

   @Override
   public String toString() {
      return "CutMachine(id="
         + this.getId()
         + ", brand="
         + this.getBrand()
         + ", code="
         + this.getCode()
         + ", director="
         + this.getDirector()
         + ", mac="
         + this.getMac()
         + ", machineName="
         + this.getMachineName()
         + ", machineNumber="
         + this.getMachineNumber()
         + ", machineType="
         + this.getMachineType()
         + ", online="
         + this.getOnline()
         + ", opcUrl="
         + this.getOpcUrl()
         + ", position="
         + this.getPosition()
         + ", state="
         + this.getState()
         + ", workshopInf="
         + this.getWorkshopInf()
         + ", assignNum="
         + this.getAssignNum()
         + ", assignWeight="
         + this.getAssignWeight()
         + ", sentNum="
         + this.getSentNum()
         + ", sentWeight="
         + this.getSentWeight()
         + ", factory="
         + this.getFactory()
         + ", productionLine="
         + this.getProductionLine()
         + ", factoryId="
         + this.getFactoryId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", workshopInfId="
         + this.getWorkshopInfId()
         + ", directorId="
         + this.getDirectorId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutMachine)) {
         return false;
      }

      CutMachine other = (CutMachine)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$online = this.getOnline();
         Object other$online = other.getOnline();
         if (this$online == null ? other$online == null : this$online.equals(other$online)) {
            Object this$state = this.getState();
            Object other$state = other.getState();
            if (this$state == null ? other$state == null : this$state.equals(other$state)) {
               Object this$assignNum = this.getAssignNum();
               Object other$assignNum = other.getAssignNum();
               if (this$assignNum == null ? other$assignNum == null : this$assignNum.equals(other$assignNum)) {
                  Object this$sentNum = this.getSentNum();
                  Object other$sentNum = other.getSentNum();
                  if (this$sentNum == null ? other$sentNum == null : this$sentNum.equals(other$sentNum)) {
                     Object this$factoryId = this.getFactoryId();
                     Object other$factoryId = other.getFactoryId();
                     if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                        Object this$productionLineId = this.getProductionLineId();
                        Object other$productionLineId = other.getProductionLineId();
                        if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                           Object this$workshopInfId = this.getWorkshopInfId();
                           Object other$workshopInfId = other.getWorkshopInfId();
                           if (this$workshopInfId == null ? other$workshopInfId == null : this$workshopInfId.equals(other$workshopInfId)) {
                              Object this$directorId = this.getDirectorId();
                              Object other$directorId = other.getDirectorId();
                              if (this$directorId == null ? other$directorId == null : this$directorId.equals(other$directorId)) {
                                 Object this$brand = this.getBrand();
                                 Object other$brand = other.getBrand();
                                 if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                    Object this$code = this.getCode();
                                    Object other$code = other.getCode();
                                    if (this$code == null ? other$code == null : this$code.equals(other$code)) {
                                       Object this$director = this.getDirector();
                                       Object other$director = other.getDirector();
                                       if (this$director == null ? other$director == null : this$director.equals(other$director)) {
                                          Object this$mac = this.getMac();
                                          Object other$mac = other.getMac();
                                          if (this$mac == null ? other$mac == null : this$mac.equals(other$mac)) {
                                             Object this$machineName = this.getMachineName();
                                             Object other$machineName = other.getMachineName();
                                             if (this$machineName == null ? other$machineName == null : this$machineName.equals(other$machineName)) {
                                                Object this$machineNumber = this.getMachineNumber();
                                                Object other$machineNumber = other.getMachineNumber();
                                                if (this$machineNumber == null ? other$machineNumber == null : this$machineNumber.equals(other$machineNumber)) {
                                                   Object this$machineType = this.getMachineType();
                                                   Object other$machineType = other.getMachineType();
                                                   if (this$machineType == null ? other$machineType == null : this$machineType.equals(other$machineType)) {
                                                      Object this$opcUrl = this.getOpcUrl();
                                                      Object other$opcUrl = other.getOpcUrl();
                                                      if (this$opcUrl == null ? other$opcUrl == null : this$opcUrl.equals(other$opcUrl)) {
                                                         Object this$position = this.getPosition();
                                                         Object other$position = other.getPosition();
                                                         if (this$position == null ? other$position == null : this$position.equals(other$position)) {
                                                            Object this$workshopInf = this.getWorkshopInf();
                                                            Object other$workshopInf = other.getWorkshopInf();
                                                            if (this$workshopInf == null
                                                               ? other$workshopInf == null
                                                               : this$workshopInf.equals(other$workshopInf)) {
                                                               Object this$assignWeight = this.getAssignWeight();
                                                               Object other$assignWeight = other.getAssignWeight();
                                                               if (this$assignWeight == null
                                                                  ? other$assignWeight == null
                                                                  : this$assignWeight.equals(other$assignWeight)) {
                                                                  Object this$sentWeight = this.getSentWeight();
                                                                  Object other$sentWeight = other.getSentWeight();
                                                                  if (this$sentWeight == null
                                                                     ? other$sentWeight == null
                                                                     : this$sentWeight.equals(other$sentWeight)) {
                                                                     Object this$factory = this.getFactory();
                                                                     Object other$factory = other.getFactory();
                                                                     if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                                                                        Object this$productionLine = this.getProductionLine();
                                                                        Object other$productionLine = other.getProductionLine();
                                                                        return this$productionLine == null
                                                                           ? other$productionLine == null
                                                                           : this$productionLine.equals(other$productionLine);
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
      return other instanceof CutMachine;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $online = this.getOnline();
      result = result * 59 + ($online == null ? 43 : $online.hashCode());
      Object $state = this.getState();
      result = result * 59 + ($state == null ? 43 : $state.hashCode());
      Object $assignNum = this.getAssignNum();
      result = result * 59 + ($assignNum == null ? 43 : $assignNum.hashCode());
      Object $sentNum = this.getSentNum();
      result = result * 59 + ($sentNum == null ? 43 : $sentNum.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $workshopInfId = this.getWorkshopInfId();
      result = result * 59 + ($workshopInfId == null ? 43 : $workshopInfId.hashCode());
      Object $directorId = this.getDirectorId();
      result = result * 59 + ($directorId == null ? 43 : $directorId.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $director = this.getDirector();
      result = result * 59 + ($director == null ? 43 : $director.hashCode());
      Object $mac = this.getMac();
      result = result * 59 + ($mac == null ? 43 : $mac.hashCode());
      Object $machineName = this.getMachineName();
      result = result * 59 + ($machineName == null ? 43 : $machineName.hashCode());
      Object $machineNumber = this.getMachineNumber();
      result = result * 59 + ($machineNumber == null ? 43 : $machineNumber.hashCode());
      Object $machineType = this.getMachineType();
      result = result * 59 + ($machineType == null ? 43 : $machineType.hashCode());
      Object $opcUrl = this.getOpcUrl();
      result = result * 59 + ($opcUrl == null ? 43 : $opcUrl.hashCode());
      Object $position = this.getPosition();
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $workshopInf = this.getWorkshopInf();
      result = result * 59 + ($workshopInf == null ? 43 : $workshopInf.hashCode());
      Object $assignWeight = this.getAssignWeight();
      result = result * 59 + ($assignWeight == null ? 43 : $assignWeight.hashCode());
      Object $sentWeight = this.getSentWeight();
      result = result * 59 + ($sentWeight == null ? 43 : $sentWeight.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $productionLine = this.getProductionLine();
      return result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
   }

   public static class CutMachineBuilder {
      private Long id;
      private String brand;
      private String code;
      private String director;
      private String mac;
      private String machineName;
      private String machineNumber;
      private String machineType;
      private Integer online;
      private String opcUrl;
      private String position;
      private Integer state;
      private String workshopInf;
      private Integer assignNum;
      private BigDecimal assignWeight;
      private Integer sentNum;
      private BigDecimal sentWeight;
      private String factory;
      private String productionLine;
      private Long factoryId;
      private Long productionLineId;
      private Long workshopInfId;
      private Long directorId;

      CutMachineBuilder() {
      }

      @JsonProperty("id")
      public CutMachine.CutMachineBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("brand")
      public CutMachine.CutMachineBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("code")
      public CutMachine.CutMachineBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("director")
      public CutMachine.CutMachineBuilder director(final String director) {
         this.director = director;
         return this;
      }

      @JsonProperty("mac")
      public CutMachine.CutMachineBuilder mac(final String mac) {
         this.mac = mac;
         return this;
      }

      @JsonProperty("machineName")
      public CutMachine.CutMachineBuilder machineName(final String machineName) {
         this.machineName = machineName;
         return this;
      }

      @JsonProperty("machineNumber")
      public CutMachine.CutMachineBuilder machineNumber(final String machineNumber) {
         this.machineNumber = machineNumber;
         return this;
      }

      @JsonProperty("machineType")
      public CutMachine.CutMachineBuilder machineType(final String machineType) {
         this.machineType = machineType;
         return this;
      }

      @JsonProperty("online")
      public CutMachine.CutMachineBuilder online(final Integer online) {
         this.online = online;
         return this;
      }

      @JsonProperty("opcUrl")
      public CutMachine.CutMachineBuilder opcUrl(final String opcUrl) {
         this.opcUrl = opcUrl;
         return this;
      }

      @JsonProperty("position")
      public CutMachine.CutMachineBuilder position(final String position) {
         this.position = position;
         return this;
      }

      @JsonProperty("state")
      public CutMachine.CutMachineBuilder state(final Integer state) {
         this.state = state;
         return this;
      }

      @JsonProperty("workshopInf")
      public CutMachine.CutMachineBuilder workshopInf(final String workshopInf) {
         this.workshopInf = workshopInf;
         return this;
      }

      @JsonProperty("assignNum")
      public CutMachine.CutMachineBuilder assignNum(final Integer assignNum) {
         this.assignNum = assignNum;
         return this;
      }

      @JsonProperty("assignWeight")
      public CutMachine.CutMachineBuilder assignWeight(final BigDecimal assignWeight) {
         this.assignWeight = assignWeight;
         return this;
      }

      @JsonProperty("sentNum")
      public CutMachine.CutMachineBuilder sentNum(final Integer sentNum) {
         this.sentNum = sentNum;
         return this;
      }

      @JsonProperty("sentWeight")
      public CutMachine.CutMachineBuilder sentWeight(final BigDecimal sentWeight) {
         this.sentWeight = sentWeight;
         return this;
      }

      @JsonProperty("factory")
      public CutMachine.CutMachineBuilder factory(final String factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("productionLine")
      public CutMachine.CutMachineBuilder productionLine(final String productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("factoryId")
      public CutMachine.CutMachineBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("productionLineId")
      public CutMachine.CutMachineBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("workshopInfId")
      public CutMachine.CutMachineBuilder workshopInfId(final Long workshopInfId) {
         this.workshopInfId = workshopInfId;
         return this;
      }

      @JsonProperty("directorId")
      public CutMachine.CutMachineBuilder directorId(final Long directorId) {
         this.directorId = directorId;
         return this;
      }

      public CutMachine build() {
         return new CutMachine(
            this.id,
            this.brand,
            this.code,
            this.director,
            this.mac,
            this.machineName,
            this.machineNumber,
            this.machineType,
            this.online,
            this.opcUrl,
            this.position,
            this.state,
            this.workshopInf,
            this.assignNum,
            this.assignWeight,
            this.sentNum,
            this.sentWeight,
            this.factory,
            this.productionLine,
            this.factoryId,
            this.productionLineId,
            this.workshopInfId,
            this.directorId
         );
      }

      @Override
      public String toString() {
         return "CutMachine.CutMachineBuilder(id="
            + this.id
            + ", brand="
            + this.brand
            + ", code="
            + this.code
            + ", director="
            + this.director
            + ", mac="
            + this.mac
            + ", machineName="
            + this.machineName
            + ", machineNumber="
            + this.machineNumber
            + ", machineType="
            + this.machineType
            + ", online="
            + this.online
            + ", opcUrl="
            + this.opcUrl
            + ", position="
            + this.position
            + ", state="
            + this.state
            + ", workshopInf="
            + this.workshopInf
            + ", assignNum="
            + this.assignNum
            + ", assignWeight="
            + this.assignWeight
            + ", sentNum="
            + this.sentNum
            + ", sentWeight="
            + this.sentWeight
            + ", factory="
            + this.factory
            + ", productionLine="
            + this.productionLine
            + ", factoryId="
            + this.factoryId
            + ", productionLineId="
            + this.productionLineId
            + ", workshopInfId="
            + this.workshopInfId
            + ", directorId="
            + this.directorId
            + ")";
      }
   }
}

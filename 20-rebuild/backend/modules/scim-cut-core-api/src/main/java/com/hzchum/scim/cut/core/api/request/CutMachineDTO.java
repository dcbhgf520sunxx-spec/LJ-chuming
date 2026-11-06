package com.hzchum.scim.cut.core.api.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CutMachineDTO {
   private static final long serialVersionUID = 1L;
   @Id
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "machineNumber", notes = "机器编号")
   @JsonProperty("machineNumber")
   @JSONField(name = "machineNumber")
   @TableField("machine_number")
   @Column(name = "machine_number")
   private String machineNumber;
   @ApiModelProperty(name = "machineName", notes = "机器名")
   @JsonProperty("machineName")
   @JSONField(name = "machineName")
   @TableField("machine_name")
   @Column(name = "machine_name")
   private String machineName;
   @ApiModelProperty(name = "machineType", notes = "机器类型")
   @JsonProperty("machineType")
   @JSONField(name = "machineType")
   @TableField("machine_type")
   @Column(name = "machine_type")
   private String machineType;
   @ApiModelProperty(name = "factoryId", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id")
   private Long factoryId;
   @ApiModelProperty(name = "factory", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   @TableField("factory")
   @Column(name = "factory")
   private String factory;
   @ApiModelProperty(name = "workshopInfId", value = "车间id")
   @JsonProperty("workshopInfId")
   @JSONField(name = "workshopInfId")
   @TableField("workshop_inf_id")
   @Column(name = "workshop_inf_id")
   private Long workshopInfId;
   @ApiModelProperty(name = "workshopInf", notes = "车间")
   @JsonProperty("workshopInf")
   @JSONField(name = "workshopInf")
   @TableField("workshop_inf")
   @Column(name = "workshop_inf")
   private String workshopInf;
   @ApiModelProperty(name = "productionLineId", value = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLine", notes = "产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   @TableField("production_line")
   @Column(name = "production_line")
   private String productionLine;
   @ApiModelProperty(name = "position", notes = "位置")
   @JsonProperty("position")
   @JSONField(name = "position")
   @TableField("position")
   @Column(name = "position")
   private String position;
   @ApiModelProperty(name = "director", notes = "负责人")
   @JsonProperty("director")
   @JSONField(name = "director")
   @TableField("director")
   @Column(name = "director")
   private String director;
   @ApiModelProperty(name = "code", notes = "代号")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code")
   private String code;
   @ApiModelProperty(name = "brand", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand")
   private String brand;
   @ApiModelProperty(name = "state", notes = "0关闭  1开启")
   @JsonProperty("state")
   @JSONField(name = "state")
   @TableField("state")
   @Column(name = "state")
   private Integer state;
   @ApiModelProperty(name = "online", notes = "0离线  1在线  2连接中")
   @JsonProperty("online")
   @JSONField(name = "online")
   @TableField("online")
   @Column(name = "online")
   private Integer online;
   @ApiModelProperty(name = "opcUrl", notes = "工控机  opcua地址")
   @JsonProperty("opcUrl")
   @JSONField(name = "opcUrl")
   @TableField("opc_url")
   @Column(name = "opc_url")
   private String opcUrl;
   @ApiModelProperty(name = "mac", notes = "mac物理地址 作为机器唯一标识 很重要")
   @JsonProperty("mac")
   @JSONField(name = "mac")
   @TableField("mac")
   @Column(name = "mac")
   private String mac;
   @ApiModelProperty(name = "assignNum", notes = "量")
   @JsonProperty("assignNum")
   @JSONField(name = "assignNum")
   @TableField(exist = false)
   private Integer assignNum;
   @ApiModelProperty(name = "sentNum", notes = "下发量")
   @JsonProperty("sentNum")
   @JSONField(name = "sentNum")
   @TableField(exist = false)
   private Integer sentNum;
   @ApiModelProperty(name = "assignWeight", notes = "分配重")
   @JsonProperty("assignWeight")
   @JSONField(name = "assignWeight")
   @TableField(exist = false)
   private BigDecimal assignWeight;
   @ApiModelProperty(name = "sentWeight", notes = "下发重")
   @JsonProperty("sentWeight")
   @JSONField(name = "sentWeight")
   @TableField(exist = false)
   private BigDecimal sentWeight;

   CutMachineDTO(
      final Long id,
      final String machineNumber,
      final String machineName,
      final String machineType,
      final Long factoryId,
      final String factory,
      final Long workshopInfId,
      final String workshopInf,
      final Long productionLineId,
      final String productionLine,
      final String position,
      final String director,
      final String code,
      final String brand,
      final Integer state,
      final Integer online,
      final String opcUrl,
      final String mac,
      final Integer assignNum,
      final Integer sentNum,
      final BigDecimal assignWeight,
      final BigDecimal sentWeight
   ) {
      this.id = id;
      this.machineNumber = machineNumber;
      this.machineName = machineName;
      this.machineType = machineType;
      this.factoryId = factoryId;
      this.factory = factory;
      this.workshopInfId = workshopInfId;
      this.workshopInf = workshopInf;
      this.productionLineId = productionLineId;
      this.productionLine = productionLine;
      this.position = position;
      this.director = director;
      this.code = code;
      this.brand = brand;
      this.state = state;
      this.online = online;
      this.opcUrl = opcUrl;
      this.mac = mac;
      this.assignNum = assignNum;
      this.sentNum = sentNum;
      this.assignWeight = assignWeight;
      this.sentWeight = sentWeight;
   }

   public static CutMachineDTO.CutMachineDTOBuilder builder() {
      return new CutMachineDTO.CutMachineDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getMachineNumber() {
      return this.machineNumber;
   }

   public String getMachineName() {
      return this.machineName;
   }

   public String getMachineType() {
      return this.machineType;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getFactory() {
      return this.factory;
   }

   public Long getWorkshopInfId() {
      return this.workshopInfId;
   }

   public String getWorkshopInf() {
      return this.workshopInf;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLine() {
      return this.productionLine;
   }

   public String getPosition() {
      return this.position;
   }

   public String getDirector() {
      return this.director;
   }

   public String getCode() {
      return this.code;
   }

   public String getBrand() {
      return this.brand;
   }

   public Integer getState() {
      return this.state;
   }

   public Integer getOnline() {
      return this.online;
   }

   public String getOpcUrl() {
      return this.opcUrl;
   }

   public String getMac() {
      return this.mac;
   }

   public Integer getAssignNum() {
      return this.assignNum;
   }

   public Integer getSentNum() {
      return this.sentNum;
   }

   public BigDecimal getAssignWeight() {
      return this.assignWeight;
   }

   public BigDecimal getSentWeight() {
      return this.sentWeight;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("machineNumber")
   public void setMachineNumber(final String machineNumber) {
      this.machineNumber = machineNumber;
   }

   @JsonProperty("machineName")
   public void setMachineName(final String machineName) {
      this.machineName = machineName;
   }

   @JsonProperty("machineType")
   public void setMachineType(final String machineType) {
      this.machineType = machineType;
   }

   @JsonProperty("factoryId")
   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   @JsonProperty("factory")
   public void setFactory(final String factory) {
      this.factory = factory;
   }

   @JsonProperty("workshopInfId")
   public void setWorkshopInfId(final Long workshopInfId) {
      this.workshopInfId = workshopInfId;
   }

   @JsonProperty("workshopInf")
   public void setWorkshopInf(final String workshopInf) {
      this.workshopInf = workshopInf;
   }

   @JsonProperty("productionLineId")
   public void setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
   }

   @JsonProperty("productionLine")
   public void setProductionLine(final String productionLine) {
      this.productionLine = productionLine;
   }

   @JsonProperty("position")
   public void setPosition(final String position) {
      this.position = position;
   }

   @JsonProperty("director")
   public void setDirector(final String director) {
      this.director = director;
   }

   @JsonProperty("code")
   public void setCode(final String code) {
      this.code = code;
   }

   @JsonProperty("brand")
   public void setBrand(final String brand) {
      this.brand = brand;
   }

   @JsonProperty("state")
   public void setState(final Integer state) {
      this.state = state;
   }

   @JsonProperty("online")
   public void setOnline(final Integer online) {
      this.online = online;
   }

   @JsonProperty("opcUrl")
   public void setOpcUrl(final String opcUrl) {
      this.opcUrl = opcUrl;
   }

   @JsonProperty("mac")
   public void setMac(final String mac) {
      this.mac = mac;
   }

   @JsonProperty("assignNum")
   public void setAssignNum(final Integer assignNum) {
      this.assignNum = assignNum;
   }

   @JsonProperty("sentNum")
   public void setSentNum(final Integer sentNum) {
      this.sentNum = sentNum;
   }

   @JsonProperty("assignWeight")
   public void setAssignWeight(final BigDecimal assignWeight) {
      this.assignWeight = assignWeight;
   }

   @JsonProperty("sentWeight")
   public void setSentWeight(final BigDecimal sentWeight) {
      this.sentWeight = sentWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutMachineDTO)) {
         return false;
      }

      CutMachineDTO other = (CutMachineDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopInfId = this.getWorkshopInfId();
            Object other$workshopInfId = other.getWorkshopInfId();
            if (this$workshopInfId == null ? other$workshopInfId == null : this$workshopInfId.equals(other$workshopInfId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$state = this.getState();
                  Object other$state = other.getState();
                  if (this$state == null ? other$state == null : this$state.equals(other$state)) {
                     Object this$online = this.getOnline();
                     Object other$online = other.getOnline();
                     if (this$online == null ? other$online == null : this$online.equals(other$online)) {
                        Object this$assignNum = this.getAssignNum();
                        Object other$assignNum = other.getAssignNum();
                        if (this$assignNum == null ? other$assignNum == null : this$assignNum.equals(other$assignNum)) {
                           Object this$sentNum = this.getSentNum();
                           Object other$sentNum = other.getSentNum();
                           if (this$sentNum == null ? other$sentNum == null : this$sentNum.equals(other$sentNum)) {
                              Object this$machineNumber = this.getMachineNumber();
                              Object other$machineNumber = other.getMachineNumber();
                              if (this$machineNumber == null ? other$machineNumber == null : this$machineNumber.equals(other$machineNumber)) {
                                 Object this$machineName = this.getMachineName();
                                 Object other$machineName = other.getMachineName();
                                 if (this$machineName == null ? other$machineName == null : this$machineName.equals(other$machineName)) {
                                    Object this$machineType = this.getMachineType();
                                    Object other$machineType = other.getMachineType();
                                    if (this$machineType == null ? other$machineType == null : this$machineType.equals(other$machineType)) {
                                       Object this$factory = this.getFactory();
                                       Object other$factory = other.getFactory();
                                       if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                                          Object this$workshopInf = this.getWorkshopInf();
                                          Object other$workshopInf = other.getWorkshopInf();
                                          if (this$workshopInf == null ? other$workshopInf == null : this$workshopInf.equals(other$workshopInf)) {
                                             Object this$productionLine = this.getProductionLine();
                                             Object other$productionLine = other.getProductionLine();
                                             if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                                Object this$position = this.getPosition();
                                                Object other$position = other.getPosition();
                                                if (this$position == null ? other$position == null : this$position.equals(other$position)) {
                                                   Object this$director = this.getDirector();
                                                   Object other$director = other.getDirector();
                                                   if (this$director == null ? other$director == null : this$director.equals(other$director)) {
                                                      Object this$code = this.getCode();
                                                      Object other$code = other.getCode();
                                                      if (this$code == null ? other$code == null : this$code.equals(other$code)) {
                                                         Object this$brand = this.getBrand();
                                                         Object other$brand = other.getBrand();
                                                         if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                            Object this$opcUrl = this.getOpcUrl();
                                                            Object other$opcUrl = other.getOpcUrl();
                                                            if (this$opcUrl == null ? other$opcUrl == null : this$opcUrl.equals(other$opcUrl)) {
                                                               Object this$mac = this.getMac();
                                                               Object other$mac = other.getMac();
                                                               if (this$mac == null ? other$mac == null : this$mac.equals(other$mac)) {
                                                                  Object this$assignWeight = this.getAssignWeight();
                                                                  Object other$assignWeight = other.getAssignWeight();
                                                                  if (this$assignWeight == null
                                                                     ? other$assignWeight == null
                                                                     : this$assignWeight.equals(other$assignWeight)) {
                                                                     Object this$sentWeight = this.getSentWeight();
                                                                     Object other$sentWeight = other.getSentWeight();
                                                                     return this$sentWeight == null
                                                                        ? other$sentWeight == null
                                                                        : this$sentWeight.equals(other$sentWeight);
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
      return other instanceof CutMachineDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopInfId = this.getWorkshopInfId();
      result = result * 59 + ($workshopInfId == null ? 43 : $workshopInfId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $state = this.getState();
      result = result * 59 + ($state == null ? 43 : $state.hashCode());
      Object $online = this.getOnline();
      result = result * 59 + ($online == null ? 43 : $online.hashCode());
      Object $assignNum = this.getAssignNum();
      result = result * 59 + ($assignNum == null ? 43 : $assignNum.hashCode());
      Object $sentNum = this.getSentNum();
      result = result * 59 + ($sentNum == null ? 43 : $sentNum.hashCode());
      Object $machineNumber = this.getMachineNumber();
      result = result * 59 + ($machineNumber == null ? 43 : $machineNumber.hashCode());
      Object $machineName = this.getMachineName();
      result = result * 59 + ($machineName == null ? 43 : $machineName.hashCode());
      Object $machineType = this.getMachineType();
      result = result * 59 + ($machineType == null ? 43 : $machineType.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshopInf = this.getWorkshopInf();
      result = result * 59 + ($workshopInf == null ? 43 : $workshopInf.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $position = this.getPosition();
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $director = this.getDirector();
      result = result * 59 + ($director == null ? 43 : $director.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $opcUrl = this.getOpcUrl();
      result = result * 59 + ($opcUrl == null ? 43 : $opcUrl.hashCode());
      Object $mac = this.getMac();
      result = result * 59 + ($mac == null ? 43 : $mac.hashCode());
      Object $assignWeight = this.getAssignWeight();
      result = result * 59 + ($assignWeight == null ? 43 : $assignWeight.hashCode());
      Object $sentWeight = this.getSentWeight();
      return result * 59 + ($sentWeight == null ? 43 : $sentWeight.hashCode());
   }

   @Override
   public String toString() {
      return "CutMachineDTO(id="
         + this.getId()
         + ", machineNumber="
         + this.getMachineNumber()
         + ", machineName="
         + this.getMachineName()
         + ", machineType="
         + this.getMachineType()
         + ", factoryId="
         + this.getFactoryId()
         + ", factory="
         + this.getFactory()
         + ", workshopInfId="
         + this.getWorkshopInfId()
         + ", workshopInf="
         + this.getWorkshopInf()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLine="
         + this.getProductionLine()
         + ", position="
         + this.getPosition()
         + ", director="
         + this.getDirector()
         + ", code="
         + this.getCode()
         + ", brand="
         + this.getBrand()
         + ", state="
         + this.getState()
         + ", online="
         + this.getOnline()
         + ", opcUrl="
         + this.getOpcUrl()
         + ", mac="
         + this.getMac()
         + ", assignNum="
         + this.getAssignNum()
         + ", sentNum="
         + this.getSentNum()
         + ", assignWeight="
         + this.getAssignWeight()
         + ", sentWeight="
         + this.getSentWeight()
         + ")";
   }

   public static class CutMachineDTOBuilder {
      private Long id;
      private String machineNumber;
      private String machineName;
      private String machineType;
      private Long factoryId;
      private String factory;
      private Long workshopInfId;
      private String workshopInf;
      private Long productionLineId;
      private String productionLine;
      private String position;
      private String director;
      private String code;
      private String brand;
      private Integer state;
      private Integer online;
      private String opcUrl;
      private String mac;
      private Integer assignNum;
      private Integer sentNum;
      private BigDecimal assignWeight;
      private BigDecimal sentWeight;

      CutMachineDTOBuilder() {
      }

      @JsonProperty("id")
      public CutMachineDTO.CutMachineDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("machineNumber")
      public CutMachineDTO.CutMachineDTOBuilder machineNumber(final String machineNumber) {
         this.machineNumber = machineNumber;
         return this;
      }

      @JsonProperty("machineName")
      public CutMachineDTO.CutMachineDTOBuilder machineName(final String machineName) {
         this.machineName = machineName;
         return this;
      }

      @JsonProperty("machineType")
      public CutMachineDTO.CutMachineDTOBuilder machineType(final String machineType) {
         this.machineType = machineType;
         return this;
      }

      @JsonProperty("factoryId")
      public CutMachineDTO.CutMachineDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("factory")
      public CutMachineDTO.CutMachineDTOBuilder factory(final String factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshopInfId")
      public CutMachineDTO.CutMachineDTOBuilder workshopInfId(final Long workshopInfId) {
         this.workshopInfId = workshopInfId;
         return this;
      }

      @JsonProperty("workshopInf")
      public CutMachineDTO.CutMachineDTOBuilder workshopInf(final String workshopInf) {
         this.workshopInf = workshopInf;
         return this;
      }

      @JsonProperty("productionLineId")
      public CutMachineDTO.CutMachineDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLine")
      public CutMachineDTO.CutMachineDTOBuilder productionLine(final String productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("position")
      public CutMachineDTO.CutMachineDTOBuilder position(final String position) {
         this.position = position;
         return this;
      }

      @JsonProperty("director")
      public CutMachineDTO.CutMachineDTOBuilder director(final String director) {
         this.director = director;
         return this;
      }

      @JsonProperty("code")
      public CutMachineDTO.CutMachineDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("brand")
      public CutMachineDTO.CutMachineDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("state")
      public CutMachineDTO.CutMachineDTOBuilder state(final Integer state) {
         this.state = state;
         return this;
      }

      @JsonProperty("online")
      public CutMachineDTO.CutMachineDTOBuilder online(final Integer online) {
         this.online = online;
         return this;
      }

      @JsonProperty("opcUrl")
      public CutMachineDTO.CutMachineDTOBuilder opcUrl(final String opcUrl) {
         this.opcUrl = opcUrl;
         return this;
      }

      @JsonProperty("mac")
      public CutMachineDTO.CutMachineDTOBuilder mac(final String mac) {
         this.mac = mac;
         return this;
      }

      @JsonProperty("assignNum")
      public CutMachineDTO.CutMachineDTOBuilder assignNum(final Integer assignNum) {
         this.assignNum = assignNum;
         return this;
      }

      @JsonProperty("sentNum")
      public CutMachineDTO.CutMachineDTOBuilder sentNum(final Integer sentNum) {
         this.sentNum = sentNum;
         return this;
      }

      @JsonProperty("assignWeight")
      public CutMachineDTO.CutMachineDTOBuilder assignWeight(final BigDecimal assignWeight) {
         this.assignWeight = assignWeight;
         return this;
      }

      @JsonProperty("sentWeight")
      public CutMachineDTO.CutMachineDTOBuilder sentWeight(final BigDecimal sentWeight) {
         this.sentWeight = sentWeight;
         return this;
      }

      public CutMachineDTO build() {
         return new CutMachineDTO(
            this.id,
            this.machineNumber,
            this.machineName,
            this.machineType,
            this.factoryId,
            this.factory,
            this.workshopInfId,
            this.workshopInf,
            this.productionLineId,
            this.productionLine,
            this.position,
            this.director,
            this.code,
            this.brand,
            this.state,
            this.online,
            this.opcUrl,
            this.mac,
            this.assignNum,
            this.sentNum,
            this.assignWeight,
            this.sentWeight
         );
      }

      @Override
      public String toString() {
         return "CutMachineDTO.CutMachineDTOBuilder(id="
            + this.id
            + ", machineNumber="
            + this.machineNumber
            + ", machineName="
            + this.machineName
            + ", machineType="
            + this.machineType
            + ", factoryId="
            + this.factoryId
            + ", factory="
            + this.factory
            + ", workshopInfId="
            + this.workshopInfId
            + ", workshopInf="
            + this.workshopInf
            + ", productionLineId="
            + this.productionLineId
            + ", productionLine="
            + this.productionLine
            + ", position="
            + this.position
            + ", director="
            + this.director
            + ", code="
            + this.code
            + ", brand="
            + this.brand
            + ", state="
            + this.state
            + ", online="
            + this.online
            + ", opcUrl="
            + this.opcUrl
            + ", mac="
            + this.mac
            + ", assignNum="
            + this.assignNum
            + ", sentNum="
            + this.sentNum
            + ", assignWeight="
            + this.assignWeight
            + ", sentWeight="
            + this.sentWeight
            + ")";
      }
   }
}

package com.hzchum.scim.iot.core.api.pojo._doModel.equipment;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "WeighingScaleEquipmentInfo对象", description = "地磅设备信息表")
@Entity
@TableName("weighing_scale_equipment_info")
@Table(name = "weighing_scale_equipment_info")
@org.hibernate.annotations.Table(appliesTo = "weighing_scale_equipment_info", comment = "地磅设备信息表")
public class WeighingScaleEquipmentInfo extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "业务主键", notes = "业务主键")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20) default '1'  COMMENT '工厂id'", nullable = true)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20) default null COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "deviceId", value = "设备编码", notes = "设备编码")
   @TableField("device_id")
   @Column(name = "device_id", columnDefinition = "varchar(255)  COMMENT '设备编码'", nullable = true)
   private Long deviceId;
   @ApiModelProperty(name = "deviceName", value = "设备名称", notes = "设备名称")
   @TableField("device_name")
   @Column(name = "device_name", columnDefinition = "varchar(255)  COMMENT '设备名称'", nullable = false)
   private String deviceName;
   @ApiModelProperty(name = "company_name", value = "公司名称", notes = "公司名称")
   @TableField("company_name")
   @Column(name = "company_name", columnDefinition = "varchar(255)  COMMENT '公司名称'", nullable = false)
   private String companyName;
   @ApiModelProperty(name = "url", value = "请求路径", notes = "请求路径")
   @TableField("url")
   @Column(name = "url", columnDefinition = "varchar(255) default '' COMMENT '请求路径'", nullable = true)
   private String url;
   @ApiModelProperty(name = "status", value = "状态 0禁用 1启用", notes = "状态 0禁用 1启用")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '状态 0禁用 1启用'", nullable = true)
   private Boolean status;
   @ApiModelProperty(name = "dockingMethod", value = "三方地磅对接模式", notes = "三方地磅对接模式")
   @TableField("docking_method")
   @Column(name = "docking_method", columnDefinition = "int default '1' COMMENT '三方地磅对接模式'", nullable = false)
   private Integer dockingMethod;
   @ApiModelProperty(name = "lastEditorUserId", value = "最后编辑人id", notes = "最后编辑人id")
   @TableField("last_editor_user_id")
   @Column(name = "last_editor_user_id", columnDefinition = "bigint(20) default '1' COMMENT '最后编辑人id'", nullable = true)
   private Long lastEditorUserId;
   @ApiModelProperty(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) default '1'  COMMENT ''", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "cmc", value = "网络通信方式", notes = "网络通信方式")
   @TableField("cmc")
   @Column(name = "cmc", columnDefinition = "varchar(255) default '' COMMENT '网络通信方式'", nullable = true)
   private String cmc;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder builder() {
      return new WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder();
   }

   public WeighingScaleEquipmentInfo() {
   }

   public WeighingScaleEquipmentInfo(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long deviceId,
      final String deviceName,
      final String companyName,
      final String url,
      final Boolean status,
      final Integer dockingMethod,
      final Long lastEditorUserId,
      final Long userId,
      final String cmc,
      final String remark
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.deviceId = deviceId;
      this.deviceName = deviceName;
      this.companyName = companyName;
      this.url = url;
      this.status = status;
      this.dockingMethod = dockingMethod;
      this.lastEditorUserId = lastEditorUserId;
      this.userId = userId;
      this.cmc = cmc;
      this.remark = remark;
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

   public Long getDeviceId() {
      return this.deviceId;
   }

   public String getDeviceName() {
      return this.deviceName;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getUrl() {
      return this.url;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Integer getDockingMethod() {
      return this.dockingMethod;
   }

   public Long getLastEditorUserId() {
      return this.lastEditorUserId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getCmc() {
      return this.cmc;
   }

   public String getRemark() {
      return this.remark;
   }

   public WeighingScaleEquipmentInfo setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public WeighingScaleEquipmentInfo setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public WeighingScaleEquipmentInfo setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public WeighingScaleEquipmentInfo setDeviceId(final Long deviceId) {
      this.deviceId = deviceId;
      return this;
   }

   public WeighingScaleEquipmentInfo setDeviceName(final String deviceName) {
      this.deviceName = deviceName;
      return this;
   }

   public WeighingScaleEquipmentInfo setCompanyName(final String companyName) {
      this.companyName = companyName;
      return this;
   }

   public WeighingScaleEquipmentInfo setUrl(final String url) {
      this.url = url;
      return this;
   }

   public WeighingScaleEquipmentInfo setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   public WeighingScaleEquipmentInfo setDockingMethod(final Integer dockingMethod) {
      this.dockingMethod = dockingMethod;
      return this;
   }

   public WeighingScaleEquipmentInfo setLastEditorUserId(final Long lastEditorUserId) {
      this.lastEditorUserId = lastEditorUserId;
      return this;
   }

   public WeighingScaleEquipmentInfo setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public WeighingScaleEquipmentInfo setCmc(final String cmc) {
      this.cmc = cmc;
      return this;
   }

   public WeighingScaleEquipmentInfo setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "WeighingScaleEquipmentInfo(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", deviceId="
         + this.getDeviceId()
         + ", deviceName="
         + this.getDeviceName()
         + ", companyName="
         + this.getCompanyName()
         + ", url="
         + this.getUrl()
         + ", status="
         + this.getStatus()
         + ", dockingMethod="
         + this.getDockingMethod()
         + ", lastEditorUserId="
         + this.getLastEditorUserId()
         + ", userId="
         + this.getUserId()
         + ", cmc="
         + this.getCmc()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WeighingScaleEquipmentInfo)) {
         return false;
      }

      WeighingScaleEquipmentInfo other = (WeighingScaleEquipmentInfo)o;
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
               Object this$deviceId = this.getDeviceId();
               Object other$deviceId = other.getDeviceId();
               if (this$deviceId == null ? other$deviceId == null : this$deviceId.equals(other$deviceId)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$dockingMethod = this.getDockingMethod();
                     Object other$dockingMethod = other.getDockingMethod();
                     if (this$dockingMethod == null ? other$dockingMethod == null : this$dockingMethod.equals(other$dockingMethod)) {
                        Object this$lastEditorUserId = this.getLastEditorUserId();
                        Object other$lastEditorUserId = other.getLastEditorUserId();
                        if (this$lastEditorUserId == null ? other$lastEditorUserId == null : this$lastEditorUserId.equals(other$lastEditorUserId)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$deviceName = this.getDeviceName();
                              Object other$deviceName = other.getDeviceName();
                              if (this$deviceName == null ? other$deviceName == null : this$deviceName.equals(other$deviceName)) {
                                 Object this$companyName = this.getCompanyName();
                                 Object other$companyName = other.getCompanyName();
                                 if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
                                    Object this$url = this.getUrl();
                                    Object other$url = other.getUrl();
                                    if (this$url == null ? other$url == null : this$url.equals(other$url)) {
                                       Object this$cmc = this.getCmc();
                                       Object other$cmc = other.getCmc();
                                       if (this$cmc == null ? other$cmc == null : this$cmc.equals(other$cmc)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof WeighingScaleEquipmentInfo;
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
      Object $deviceId = this.getDeviceId();
      result = result * 59 + ($deviceId == null ? 43 : $deviceId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $dockingMethod = this.getDockingMethod();
      result = result * 59 + ($dockingMethod == null ? 43 : $dockingMethod.hashCode());
      Object $lastEditorUserId = this.getLastEditorUserId();
      result = result * 59 + ($lastEditorUserId == null ? 43 : $lastEditorUserId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $deviceName = this.getDeviceName();
      result = result * 59 + ($deviceName == null ? 43 : $deviceName.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $url = this.getUrl();
      result = result * 59 + ($url == null ? 43 : $url.hashCode());
      Object $cmc = this.getCmc();
      result = result * 59 + ($cmc == null ? 43 : $cmc.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class WeighingScaleEquipmentInfoBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long deviceId;
      private String deviceName;
      private String companyName;
      private String url;
      private Boolean status;
      private Integer dockingMethod;
      private Long lastEditorUserId;
      private Long userId;
      private String cmc;
      private String remark;

      WeighingScaleEquipmentInfoBuilder() {
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder deviceId(final Long deviceId) {
         this.deviceId = deviceId;
         return this;
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder deviceName(final String deviceName) {
         this.deviceName = deviceName;
         return this;
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder url(final String url) {
         this.url = url;
         return this;
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder dockingMethod(final Integer dockingMethod) {
         this.dockingMethod = dockingMethod;
         return this;
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder lastEditorUserId(final Long lastEditorUserId) {
         this.lastEditorUserId = lastEditorUserId;
         return this;
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder cmc(final String cmc) {
         this.cmc = cmc;
         return this;
      }

      public WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WeighingScaleEquipmentInfo build() {
         return new WeighingScaleEquipmentInfo(
            this.id,
            this.factoryId,
            this.workshopId,
            this.deviceId,
            this.deviceName,
            this.companyName,
            this.url,
            this.status,
            this.dockingMethod,
            this.lastEditorUserId,
            this.userId,
            this.cmc,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "WeighingScaleEquipmentInfo.WeighingScaleEquipmentInfoBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", deviceId="
            + this.deviceId
            + ", deviceName="
            + this.deviceName
            + ", companyName="
            + this.companyName
            + ", url="
            + this.url
            + ", status="
            + this.status
            + ", dockingMethod="
            + this.dockingMethod
            + ", lastEditorUserId="
            + this.lastEditorUserId
            + ", userId="
            + this.userId
            + ", cmc="
            + this.cmc
            + ", remark="
            + this.remark
            + ")";
      }
   }
}

package com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesRosterCert对象", description = "花名册证书表")
@Entity
@TableName("mes_roster_cert")
@Table(name = "mes_roster_cert")
@org.hibernate.annotations.Table(appliesTo = "mes_roster_cert", comment = "花名册证书表")
public class MesRosterCert extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("花名册ID")
   @TableField("roster_id")
   @Column(name = "roster_id", columnDefinition = "bigint(20) COMMENT '花名册ID'", nullable = true)
   private Long rosterId;
   @ApiModelProperty("证书类型")
   @TableField("cert_type")
   @Column(name = "cert_type", columnDefinition = "varchar(255) COMMENT '证书类型'", nullable = true)
   private String certType;
   @ApiModelProperty("到期时间")
   @TableField("expiration_time")
   @Column(name = "expiration_time", columnDefinition = "datetime COMMENT '到期时间'", nullable = true)
   private LocalDateTime expirationTime;

   public static MesRosterCert.MesRosterCertBuilder builder() {
      return new MesRosterCert.MesRosterCertBuilder();
   }

   public MesRosterCert() {
   }

   public MesRosterCert(final Long id, final Long rosterId, final String certType, final LocalDateTime expirationTime) {
      this.id = id;
      this.rosterId = rosterId;
      this.certType = certType;
      this.expirationTime = expirationTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getRosterId() {
      return this.rosterId;
   }

   public String getCertType() {
      return this.certType;
   }

   public LocalDateTime getExpirationTime() {
      return this.expirationTime;
   }

   public MesRosterCert setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesRosterCert setRosterId(final Long rosterId) {
      this.rosterId = rosterId;
      return this;
   }

   public MesRosterCert setCertType(final String certType) {
      this.certType = certType;
      return this;
   }

   public MesRosterCert setExpirationTime(final LocalDateTime expirationTime) {
      this.expirationTime = expirationTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesRosterCert(id="
         + this.getId()
         + ", rosterId="
         + this.getRosterId()
         + ", certType="
         + this.getCertType()
         + ", expirationTime="
         + this.getExpirationTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesRosterCert)) {
         return false;
      }

      MesRosterCert other = (MesRosterCert)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$rosterId = this.getRosterId();
         Object other$rosterId = other.getRosterId();
         if (this$rosterId == null ? other$rosterId == null : this$rosterId.equals(other$rosterId)) {
            Object this$certType = this.getCertType();
            Object other$certType = other.getCertType();
            if (this$certType == null ? other$certType == null : this$certType.equals(other$certType)) {
               Object this$expirationTime = this.getExpirationTime();
               Object other$expirationTime = other.getExpirationTime();
               return this$expirationTime == null ? other$expirationTime == null : this$expirationTime.equals(other$expirationTime);
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
      return other instanceof MesRosterCert;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $rosterId = this.getRosterId();
      result = result * 59 + ($rosterId == null ? 43 : $rosterId.hashCode());
      Object $certType = this.getCertType();
      result = result * 59 + ($certType == null ? 43 : $certType.hashCode());
      Object $expirationTime = this.getExpirationTime();
      return result * 59 + ($expirationTime == null ? 43 : $expirationTime.hashCode());
   }

   public static class MesRosterCertBuilder {
      private Long id;
      private Long rosterId;
      private String certType;
      private LocalDateTime expirationTime;

      MesRosterCertBuilder() {
      }

      public MesRosterCert.MesRosterCertBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesRosterCert.MesRosterCertBuilder rosterId(final Long rosterId) {
         this.rosterId = rosterId;
         return this;
      }

      public MesRosterCert.MesRosterCertBuilder certType(final String certType) {
         this.certType = certType;
         return this;
      }

      public MesRosterCert.MesRosterCertBuilder expirationTime(final LocalDateTime expirationTime) {
         this.expirationTime = expirationTime;
         return this;
      }

      public MesRosterCert build() {
         return new MesRosterCert(this.id, this.rosterId, this.certType, this.expirationTime);
      }

      @Override
      public String toString() {
         return "MesRosterCert.MesRosterCertBuilder(id="
            + this.id
            + ", rosterId="
            + this.rosterId
            + ", certType="
            + this.certType
            + ", expirationTime="
            + this.expirationTime
            + ")";
      }
   }
}

package com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRosterCert;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "花名册证书信息DTO")
public class MesRosterCertDTO extends MesRosterCert {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesRosterCertDTO)) {
         return false;
      }

      MesRosterCertDTO other = (MesRosterCertDTO)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesRosterCertDTO;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "MesRosterCertDTO(super=" + super.toString() + ")";
   }
}

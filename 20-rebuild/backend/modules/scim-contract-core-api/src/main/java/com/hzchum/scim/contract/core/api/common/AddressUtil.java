package com.hzchum.scim.contract.core.api.common;

import com.google.common.base.Preconditions;
import com.hzchum.scim.contract.core.api.enums.ProjectAddressTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectTemp;

public class AddressUtil {
   public static String getAddress(ContractProject project, Integer addressType) {
      Preconditions.checkArgument(ProjectAddressTypeEnum.isExist(addressType), "地址类型错误!");
      StringBuilder sb = new StringBuilder();
      if (addressType.equals(ProjectAddressTypeEnum.PROJECT_ADDRESS.getType())) {
         sb.append(project.getCountryName() != null ? project.getCountryName() : "")
            .append(project.getProvinceName() != null ? project.getProvinceName() : "")
            .append(project.getCityName() != null ? project.getCityName() : "")
            .append(project.getRegionName() != null ? project.getRegionName() : "");
      }

      if (addressType.equals(ProjectAddressTypeEnum.CUSTOMER_ADDRESS.getType())) {
         sb.append(project.getCustomerCountryName() != null ? project.getCustomerCountryName() : "")
            .append(project.getCustomerProvinceName() != null ? project.getCustomerProvinceName() : "")
            .append(project.getCustomerCityName() != null ? project.getCustomerCityName() : "")
            .append(project.getCustomerRegionName() != null ? project.getCustomerRegionName() : "");
      }

      return sb.toString();
   }

   public static String getAddress(ContractProjectTemp projectTemp, Integer addressType) {
      Preconditions.checkArgument(ProjectAddressTypeEnum.isExist(addressType), "地址类型错误!");
      StringBuilder sb = new StringBuilder();
      if (addressType.equals(ProjectAddressTypeEnum.PROJECT_ADDRESS.getType())) {
         sb.append(projectTemp.getCountryName() != null ? projectTemp.getCountryName() : "")
            .append(projectTemp.getProvinceName() != null ? projectTemp.getProvinceName() : "")
            .append(projectTemp.getCityName() != null ? projectTemp.getCityName() : "")
            .append(projectTemp.getRegionName() != null ? projectTemp.getRegionName() : "");
      }

      if (addressType.equals(ProjectAddressTypeEnum.CUSTOMER_ADDRESS.getType())) {
         sb.append(projectTemp.getCustomerCountryName() != null ? projectTemp.getCustomerCountryName() : "")
            .append(projectTemp.getCustomerProvinceName() != null ? projectTemp.getCustomerProvinceName() : "")
            .append(projectTemp.getCustomerCityName() != null ? projectTemp.getCustomerCityName() : "")
            .append(projectTemp.getCustomerRegionName() != null ? projectTemp.getCustomerRegionName() : "");
      }

      return sb.toString();
   }
}

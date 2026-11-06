package com.hzchum.scim.project.core.api.utils;

import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallMeteSummaryDTO;
import javax.validation.constraints.NotNull;

public interface ProjectInstallBizUtil {
   ProjectInstallMeteSummaryDTO getActualInstallMete(@NotNull Long areaId);

   ProjectInstallMeteSummaryDTO getActualInstallMete(Long projectId, Long monomerId, Long areaId, @NotNull Integer productType, Integer category);

   ProjectInstallMeteSummaryDTO getActualInstallMete(@NotNull Integer projectType, @NotNull Long productId, @NotNull Integer productType);

   ProjectInstallMeteSummaryDTO getActualInstallMete(@NotNull Long supplierId, @NotNull Long areaId);

   ProjectInstallMeteSummaryDTO getActualInstallMete(Long supplierId, Long projectId, Long monomerId, Long areaId, Integer productType, Integer category);
}

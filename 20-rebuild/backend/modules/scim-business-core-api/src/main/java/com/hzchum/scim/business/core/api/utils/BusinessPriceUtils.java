package com.hzchum.scim.business.core.api.utils;

import com.hzchum.scim.common.core.api.pojo.common.CargoListProductLinkPriceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import java.util.Collection;
import java.util.List;

public interface BusinessPriceUtils {
   List<CargoListProductLinkPriceDTO> getCargoLinkPrice(Collection<Long> cargoListIds);

   List<CargoListProductLinkPriceDTO> getCargoLinkPrice(List<MesBuildingCargoListProductLink> cargoListProductLinkList);

   List<CargoListProductLinkPriceDTO> getCargoLinkPriceByLinkIds(Collection<Long> cargoListProductLinkIds);
}

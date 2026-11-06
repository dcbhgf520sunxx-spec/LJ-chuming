package com.hzchum.scim.mes.building.core.api.biz.onecodeChange;

import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeArtifactDelDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeArtifactUseDtoParam;
import java.util.List;

public interface MesBuildingOneCodeChangBiz {
   Boolean deleteArtifacts(List<TechChangeArtifactDelDtoParam> changeList, Boolean secodeUser);

   Boolean useArtifact(List<TechChangeArtifactUseDtoParam> useArtifacts);
}

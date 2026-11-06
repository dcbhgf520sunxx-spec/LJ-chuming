package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.plan.core.api.pojo._do.ProjectSchedulingTreeDO;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureDrawingDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureFreezeOrNotDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureListQueryDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureSimpleSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProductDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectOverviewStateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectSchedulingStateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.EnclosureCategoryMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.ArtifactSimpleVO;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TechEnclosureService extends IService<TechEnclosure> {
   void downloadEnclosureTemplate(Integer category);

   List<EnclosureResponseDTO> listByCondition(EnclosureListQueryDTOParam queryDTOParam);

   List<String> listPlateTypeList(Long projectId, Integer category);

   EnclosureSimpleSumDTO getSumEnclosure(EnclosureListQueryDTOParam param);

   EnclosureSimpleSumDTO getSumEnclosure2(EnclosureListQueryDTOParam param);

   void exportEnclosureList(EnclosureListQueryDTOParam queryDTOParam, HttpServletResponse response);

   void exportEnclosureList2(EnclosureListQueryDTOParam queryDTOParam, HttpServletResponse response);

   ListVO<EnclosureSumDTO> listSum(Long projectId, Long monomerId, Integer category);

   Long importEnclosureAttachment(MultipartFile file);

   Boolean saveEnclosureDrawing(EnclosureDrawingDTOParam drawingDTOParam);

   void downEnclosureAttachment(Long attachmentId);

   List<TechEnclosure> listByBusinessId(Long businessId);

   ProductMeteDTO sumMeteByProjectIdOrMonomerId(Long projectId, Long monomerId, Long areaId);

   List<EnclosureCategoryMeteDTO> sumCategoryMete(Long projectId);

   List<EnclosureCategoryMeteDTO> sumCategoryByAreaId(Long areaId);

   List<ProductMeteGroupDTO> sumMeteGroup(Long projectId, Long monomerId, Integer category, Integer permissionCheck, Long userId);

   TechEnclosure getByIdIgnoreDelete(Long id);

   Boolean importEnclosureAttachmentDrawing(MultipartFile file, Long id);

   Boolean importEnclosureAttachmentZip(MultipartFile file, Long planId);

   List<EnclosureProjectSchedulingStateDTO> listByType(Integer year, String name);

   List<EnclosureProjectOverviewStateDTO> getProjectOverview(List<Long> projectIds);

   List<EnclosureProductDetailDTO> getproductDetaile(List<Long> planIds, Integer status, Integer category);

   List<EnclosureProductDetailDTO> getproductDetaileV2(List<Long> areaIds, Integer status, Long dictionaryId);

   List<EnclosureFreezeOrNotDTO> findFreezeStatusByOrder(List<Long> orderIds);

   void downloadInventoryEnclosureTemplate();

   List<ProjectSchedulingTreeDO> getSchedulingTree(Integer year, String name);

   List<ArtifactSimpleVO> getEnclosure(String serialNumber, Long projectId, Long monomerId, Long areaId);
}

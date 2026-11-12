package com.ljaps.rebuild.business;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductPassTaskRecordBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductWeldCountDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bim/ifc/{projectId}/{monomerId}")
@PreAuthorize("@permission.menu(1009)")
public class IfcModelController {
    private static final String REVISION = "[0-9a-f]{64}";
    private final Path root;
    private final ContractProjectService projects;
    private final PlanMonomerService monomers;
    private final PlanAreaService areas;
    private final JdbcTemplate jdbc;
    private final TechArtifactService artifacts;
    private final MesBuildingTaskService tasks;
    private final TechCappCraftProductPassTaskRecordBiz welding;

    public IfcModelController(@Value("${ljaps.bim.ifc.directory:/evidence/ifc-models}") String directory,
                              ContractProjectService projects, PlanMonomerService monomers,
                              PlanAreaService areas, JdbcTemplate jdbc, TechArtifactService artifacts,
                              MesBuildingTaskService tasks, TechCappCraftProductPassTaskRecordBiz welding) {
        this.root = Paths.get(directory).toAbsolutePath().normalize();
        this.projects = projects;
        this.monomers = monomers;
        this.areas = areas;
        this.jdbc = jdbc;
        this.artifacts = artifacts;
        this.tasks = tasks;
        this.welding = welding;
    }

    @GetMapping("/areas")
    public ResultVO<List<Map<String, Object>>> list(@PathVariable Long projectId, @PathVariable Long monomerId) throws IOException {
        requireMonomer(projectId, monomerId);
        List<Map<String, Object>> result = new ArrayList<>();
        for (PlanArea area : areas.listAreaByMonomerId(monomerId)) {
            if (!Objects.equals(area.getProjectId(), projectId)) continue;
            Path directory = areaDirectory(projectId, monomerId, area.getId());
            Map<String, Object> item = new LinkedHashMap<>();
            item.put("id", area.getId().toString());
            item.put("name", area.getName());
            item.put("revision", currentRevision(directory));
            result.add(item);
        }
        return ResultBuilder.success(result);
    }

    @GetMapping("/{areaId}/{revision}/index")
    public ResponseEntity<Resource> index(@PathVariable Long projectId, @PathVariable Long monomerId,
                                          @PathVariable Long areaId, @PathVariable String revision) throws IOException {
        return file(projectId, monomerId, areaId, revision, "index.json", MediaType.APPLICATION_JSON);
    }

    @GetMapping("/{areaId}/{revision}/geometry")
    public ResponseEntity<Resource> geometry(@PathVariable Long projectId, @PathVariable Long monomerId,
                                             @PathVariable Long areaId, @PathVariable String revision) throws IOException {
        return file(projectId, monomerId, areaId, revision, "model.glb", MediaType.parseMediaType("model/gltf-binary"));
    }

    @GetMapping("/{areaId}/{revision}/progress")
    public ResultVO<List<Map<String, Object>>> progress(@PathVariable Long projectId, @PathVariable Long monomerId,
                                                        @PathVariable Long areaId, @PathVariable String revision) throws IOException {
        requireBundle(projectId, monomerId, areaId, revision);
        return ResultBuilder.success(jdbc.queryForList(
            "WITH target AS (SELECT id,serial_number,name,quantity,gross_weight FROM tech_artifact"
            + " WHERE bool_delete_enum=0 AND monomer_id=? AND area_id=?),"
            + " task AS (SELECT t.product_id,SUM(t.complete_quantity) AS complete,"
            + " SUM(t.in_production_quantity) AS inProduction FROM mes_building_task t"
            + " JOIN target a ON a.id=t.product_id WHERE t.bool_delete_enum=0 AND t.task_type_enum=2 GROUP BY t.product_id),"
            + " warehouse AS (SELECT t.product_id,SUM(CASE WHEN t.type=1 THEN t.quantity ELSE 0 END) AS inbound,"
            + " SUM(CASE WHEN t.type=2 THEN t.quantity ELSE 0 END) AS outbound FROM mes_building_warehouse_summary t"
            + " JOIN target a ON a.id=t.product_id WHERE t.bool_delete_enum=0 AND t.product_type=2 GROUP BY t.product_id),"
            + " received AS (SELECT t.product_id,SUM(t.quantity) AS received FROM project_receiving_summary t"
            + " JOIN target a ON a.id=t.product_id WHERE t.bool_delete_enum=0 AND t.product_type=2 GROUP BY t.product_id),"
            + " installed AS (SELECT t.product_id,SUM(t.actual_quantity) AS installed FROM project_install_summary t"
            + " JOIN target a ON a.id=t.product_id WHERE t.bool_delete_enum=0 AND t.product_type=2 GROUP BY t.product_id)"
            + " SELECT a.serial_number AS mark, MAX(a.name) AS name, SUM(a.quantity) AS quantity,"
            + " SUM(a.quantity * COALESCE(a.gross_weight,0)) AS totalGrossWeight,"
            + " SUM(COALESCE(task.complete,0)) AS complete,"
            + " SUM(COALESCE(task.inProduction,0)) AS inProduction,"
            + " SUM(COALESCE(warehouse.inbound,0)) AS inbound,"
            + " SUM(COALESCE(warehouse.outbound,0)) AS outbound,"
            + " SUM(COALESCE(received.received,0)) AS received,"
            + " SUM(COALESCE(installed.installed,0)) AS installed,"
            + " SUM(COALESCE(task.complete,0) * COALESCE(a.gross_weight,0)) AS completeWeight,"
            + " SUM(COALESCE(task.inProduction,0) * COALESCE(a.gross_weight,0)) AS inProductionWeight,"
            + " SUM(COALESCE(warehouse.inbound,0) * COALESCE(a.gross_weight,0)) AS inboundWeight,"
            + " SUM(COALESCE(warehouse.outbound,0) * COALESCE(a.gross_weight,0)) AS outboundWeight,"
            + " SUM(COALESCE(received.received,0) * COALESCE(a.gross_weight,0)) AS receivedWeight,"
            + " SUM(COALESCE(installed.installed,0) * COALESCE(a.gross_weight,0)) AS installedWeight"
            + " FROM target a LEFT JOIN task ON task.product_id=a.id"
            + " LEFT JOIN warehouse ON warehouse.product_id=a.id LEFT JOIN received ON received.product_id=a.id"
            + " LEFT JOIN installed ON installed.product_id=a.id"
            + " GROUP BY a.serial_number", monomerId, areaId));
    }

    @GetMapping("/{areaId}/{revision}/components")
    public ResultVO<List<Map<String, Object>>> components(@PathVariable Long projectId, @PathVariable Long monomerId,
            @PathVariable Long areaId, @PathVariable String revision, @RequestParam String mark,
            @RequestParam(defaultValue="component") String mode) throws IOException {
        requireBundle(projectId, monomerId, areaId, revision);
        if (!java.util.Arrays.asList("component", "production", "shipment", "installation").contains(mode)) {
            throw new IllegalArgumentException("查看模式不存在");
        }
        List<Map<String, Object>> result = new ArrayList<>();
        for (Long id : jdbc.queryForList("SELECT id FROM tech_artifact WHERE bool_delete_enum=0"
                + " AND project_id=? AND monomer_id=? AND area_id=? AND serial_number=? ORDER BY id", Long.class,
                projectId, monomerId, areaId, mark)) {
            Map<String, Object> item = new LinkedHashMap<>();
            item.put("artifact", artifacts.getInfoById(id));
            if ("production".equals(mode)) {
                item.put("processSummaryDetailsList", tasks.getSummaryByIdAndType(id, 2));
            } else {
                item.put("productWeldCount", welding.productWeldCount(CappCraftCardProductWeldCountDTO.builder()
                    .productId(id).monomerId(monomerId).areaId(areaId).build()));
            }
            item.put("drawings", jdbc.queryForList("SELECT number, file_name AS fileName FROM tech_drawing"
                + " WHERE bool_delete_enum=0 AND monomer_id=? AND serial_number=? AND data_type=1 AND product_type=2"
                + " ORDER BY number, id", monomerId, mark));
            result.add(item);
        }
        return ResultBuilder.success(result);
    }

    private ResponseEntity<Resource> file(Long projectId, Long monomerId, Long areaId, String revision,
                                          String name, MediaType type) throws IOException {
        Path file = requireBundle(projectId, monomerId, areaId, revision).resolve(name);
        // Spring evaluates conditional requests only after the complete bundle authorization above.
        return ResponseEntity.ok().cacheControl(CacheControl.noCache().cachePrivate().mustRevalidate())
            .eTag("\"" + revision + "/" + name + "\"").varyBy(HttpHeaders.AUTHORIZATION, HttpHeaders.ACCEPT_ENCODING).contentType(type)
            .contentLength(Files.size(file)).body(new FileSystemResource(file));
    }

    private Path requireBundle(Long projectId, Long monomerId, Long areaId, String revision) throws IOException {
        requireMonomer(projectId, monomerId);
        PlanArea area = areas.getById(areaId);
        if (area == null || !Objects.equals(area.getProjectId(), projectId)
            || !Objects.equals(area.getMonomerId(), monomerId)) {
            throw new IllegalArgumentException("区域不存在");
        }
        Path directory = areaDirectory(projectId, monomerId, areaId);
        if (!revision.matches(REVISION) || !revision.equals(currentRevision(directory))) {
            throw new IllegalArgumentException("IFC 模型版本已更新或不存在");
        }
        return directory.resolve(revision);
    }

    private void requireMonomer(Long projectId, Long monomerId) {
        SecurityUser user = UserUtil.getCurrentUser();
        if (user == null || (!user.isAdmin() && !projects.listProjectIdByUser(user.getId(), null).contains(projectId))) {
            throw new IllegalArgumentException("无权查看该项目的模型");
        }
        PlanMonomer monomer = monomers.getById(monomerId);
        if (monomer == null || !Objects.equals(monomer.getProjectId(), projectId)) {
            throw new IllegalArgumentException("单体不存在");
        }
    }

    private Path areaDirectory(Long projectId, Long monomerId, Long areaId) {
        return root.resolve(projectId.toString()).resolve(monomerId.toString()).resolve(areaId.toString());
    }

    private String currentRevision(Path area) throws IOException {
        Path pointer = area.resolve("current");
        if (!Files.isRegularFile(pointer, LinkOption.NOFOLLOW_LINKS) || Files.size(pointer) > 65) return null;
        String revision = new String(Files.readAllBytes(pointer), StandardCharsets.US_ASCII).trim();
        if (!revision.matches(REVISION)) return null;
        Path bundle = area.resolve(revision);
        if (!Files.isRegularFile(bundle.resolve("index.json"), LinkOption.NOFOLLOW_LINKS)
            || !Files.isRegularFile(bundle.resolve("model.glb"), LinkOption.NOFOLLOW_LINKS)
            || !bundle.toRealPath().startsWith(root.toRealPath())) return null;
        return revision;
    }
}

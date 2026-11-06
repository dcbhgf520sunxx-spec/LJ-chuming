const w1 = { PROCESS_NOWORK: { L: "不加工", K: "PROCESS_NOWORK", V: "process_nowork" }, PROCESS_MARKING: { L: "打标", K: "PROCESS_MARKING", V: "process_mark" }, PROCESS_WORK1: { L: "加工1", K: "PROCESS_WORK1", V: "process_work1" }, PROCESS_WORK2: { L: "加工2", K: "PROCESS_WORK2", V: "process_work2" }, PROCESS_WORK3: { L: "加工3", K: "PROCESS_WORK3", V: "process_work3" } };
ve(w1);
const S1 = { ENTITY: { L: "实体", K: "ENTITY", V: 0 }, TEXT: { L: "文本", K: "TEXT", V: 1 } };
ve(S1);
const v1 = { PASS: { L: "通过", K: "PASS", V: true, COLOR: "#35D552" }, REJECT: { L: "不通过", K: "REJECT", V: false, COLOR: "#E82121" } };
ve(v1);
const R1 = { NORMAL: { L: "厚度正常", K: "NORMAL", V: true, COLOR: "#35D552" }, ABNORMAL: { L: "厚度异常", K: "ABNORMAL", V: false, COLOR: "#E82121" } };
ve(R1);
const M1 = { AVERAGE_THICK: { L: "平均厚度", K: "AVERAGE_THICK", V: true }, ACTUAL_THICK: { L: "实际测量厚度", K: "ACTUAL_THICK", V: false } };
ve(M1);
const A1 = { UNDERWAY: { L: "生产中", K: "UNDERWAY", V: 1 }, COMPLETED: { L: "已完工", K: "COMPLETED", V: 4 } };
ve(A1);
const N1 = { STEEL_PLATE_PRODUCT: { L: "钢板", K: "STEEL_PLATE_PRODUCT", V: 8 }, SECTION_PRODUCT: { L: "型材", K: "SECTION_PRODUCT", V: 4 } };
ve(N1);
const L1 = { DELETE_NESTING_AND_PART: { L: "删除套料板和零件", K: "DELETE_NESTING_AND_PART", V: 1 }, DELETE_NESTING: { L: "仅删除套料板", K: "DELETE_NESTING", V: 2 } };
ve(L1);
const I1 = { NET_WEIGHT: { L: "净重", K: "NET_WEIGHT", V: 1 }, GROSS_WEIGHT: { L: "毛重", K: "NET_WEIGHT", V: 2 } };
ve(I1);
const C1 = { PROJECT: { L: "项目点工", K: "PROJECT", V: 1 }, NON_PROJECT: { L: "非项目点工", K: "NON_PROJECT", V: 2 } };
ve(C1);
const P1 = { PASS: { L: "已通过", K: "PASS", V: 2, T: "success" }, PENDING: { L: "审批中", K: "PENDING", V: 16, T: "warning" }, REJECT: { L: "已拒绝", K: "REJECT", V: 4, T: "danger" } };
ve(P1);
const O1 = { QUANTITY_RATIO: { L: "数量比", K: "QUANTITY_RATIO", V: 1 }, WEIGHT_RATIO: { L: "重量比", K: "WEIGHT_RATIO", V: 2 } };
ve(O1);
const WA = { teamTypeEnum: Oh, teamAttributeEnum: kh, componentTypeEnum: li, processMaterialListTypeEnum: hs, processCategoryEnum: Dh, processInspectTypeEnum: xh, processReportTypeEnum: Uh, taskReportTypeEnum: Yh, wageQuotaTypeEnum: Ca, PieceworkSystemEnum: Fh, mesEnclosureTypeEnum: Mc, floorPlateTypeEnum: Gr, taskIssueTypeEnum: Hh, PartsSchedulingStatusEnum: Gh, taskIssueNumberTypeEnum: Qh, machinePartSchedulingIssueStatusEnum: fs, machinePartNestingStatusEnum: Xh, packTypeEnum: lf, packStatusTypeEnum: of, receiptStatusEnum: nf, logisticsPriceTypeEnum: sf, shipAuditStatusEnum: rf, abnormalHandleTypeEnum: uf, abnormalHandleStatusEnum: cf, changeHandleStatusEnum: df, abnormalReportTypeEnum: pf, abnormalChangeTypeEnum: _f, abnormalStatusEnum: hf, improveStatusEnum: bf, projectComponentTypeEnum: zh, artifactProcessEnum: Wh, paintingTypeEnum: Ac, coatingTypeEnum: Vf, coatingTypeWeightEnum: wf, reportComponentTypeEnum: Bh, labelTypeEnum: Sf, printProductTypeEnum: vf, surplusHandleStatusEnum: mf, inProductionDetailReportEnum: Rf, schedulingStatusEnum: Ef, artifactProductLineEnum: Mf, traditionLineEnum: Af, intellectParentType: Nf, minEqualTypeEnum: Lf, maxEqualTypeEnum: If, cuttingConfigEnum: Df, deliveryStatusEnum: xf, deliveryReceiptStatusEnum: Uf, searchDateTypeEnum: Yf, freightChangeTypeEnum: Kf, mesWarehouseStateTypeEnum: jh, artifactTypeEnum: Cf, smallArtifactClassEnum: Of, codingTypeEnum: kf, partKeyWordEnum: Wf, hasHoleEnum: jf, artifactSpecReviseEnum: Ff, taskTrackingSchedulingStatusEnum: zf, projectNestingStatusEnum: Bf, MesBuildingTypesettingStatusEnum: Hf, nestingFileTypeEnum: qf, nestingSettingTypeEnum: Gf, mesBuildingTypeSettingAssembleTypeEnum: Qf, mesSchedulingStatusEnum: Jh, mesMachinePartOrderTypeEnum: Zf, shipStatusEnum: Jf, workOrderTypeEnum: Xf, assembleTypeEnum: $f, taskTypeENUM: Kh, fileNC1TypeEnum: tg, sortingListEnum: ig, productSearchTypeEnum: ag, projectSearchTypeEnum: lg, drillListEnum: og, structureOrderTypeEnum: ng, auxiliaryMaterialTypeEnum: sg, machinePartDxfTypeEnum: rg, machinePartIssuedWayEnum: ug, nestingTypeEnum: cg, productionKanbanTypeEnum: dg, steelOutBoundRecordTypeEnum: mg, contractSaleTypeEnum: Gl, machinePartSchedulingTypeEnum: pg, changeTypeEnum: Pf, lossStatisticsProjectStatusEnum: hg, lossStatisticsproductionStatusEnum: fg, productClassificationEnum: gg, productPickEnum: Eg, productSectionNameEnum: Oo, outputAffirmTimeEnum: yg, statisticsModelEnum: Tg, projectProductionReportEnum: _g, projectReportStatusEnum: bg, projectReportCategoryEnum: Vg, taskCompanyStatusEnum: wg, projectReportModelEnum: Sg, accessoryTypeEnum: vg, projectReportProcessStatusEnum: Rg, projectReportCategoryStatusEnum: Mg, wagesReportDetailEnum: Ag, sectionSourceEnum: Ng, schedulingTypeEnum: yf, manufactureTypeEnum: Tf, assemblyUnitEnum: eg, productCategoryTypeEnum: Lg, qualityTaskTypeEnum: Ig, teamConfigTaskTypeEnum: Cg, partProdModeEnum: Pg, inspectTypeEnum: Og, qualityTypeEnum: kg, genderEnum: xg, workStateEnum: Dg, employeeCategoryEnum: Ug, boolCertificateEnum: Yg, boolDeductionEnum: Kg, hourlyWorkTypeEnum: nc, expenseTypeCategoryEnum: Wg, quotaSpecificationClassifyEnum: jg, ArtifactCalculationWayEnum: Fg, assembleClassificationWayEnum: zg, machinePartCalculationWayEnum: Bg, assembleCalculationWayEnum: Hg, createWayEnum: qg, mapTypeEnum: Gg, avoidTimeEnum: Qg, machineCheckStatusEnum: Zg, inspectionStatusEnum: Jg, inspectRealtimeColorsEnum: Xg, machinePartTaskStatusEnum: Zh, machinePartHoleTypeEnum: $h, machineShowTypeEnum: tf, machineStoreTypeEnum: af, machinePartTypeEnum: ef, hourlyWorkTypeEnum: nc, attendanceStatusEnum: ff, attendanceTypeEnum: gf, enumEnclosureProduQuotaConfigSpecificationClassEnum: a1, meteUnitEnum: $g, coatingProcessProjectStatusEnum: e1, projectPaintCalculationWayEnum: t1, projectPaintSortEnum: i1, KanBanProcessTypeEnum: l1, KanBanShippingStateEnum: o1, IssuedToNestingSoftwareStatusEnum: qh, boolFixedProcessEnum: n1, laborPriceQuotaTypeEunm: d1, quotaConfigArtifactConditionEnum: m1, quotaConfigAssembleConditionEnum: p1, quotaConfigMachinePartConditionEnum: h1, quotaConfigMeasureUnitEnum: f1, lossStatisticsDimensionEnum: s1, rawMaterialLossEnum: r1, lossStatisticsPickTypeEnum: u1, mesLossWorkProgressStatisticsEnum: $s, mesMachinePartTypeEnum: c1, reportingManageViewTypeEnum: g1, teamPayrollSummaryViewTypeEnum: E1, mesNestTaskConfigEnum: y1, mesCuttingStateEnum: _1, mesCuttingStateTabelEnum: b1, boolSendDirectlyEnum: V1, drawingProcessingLayerTypeEnum: w1, inspectionStatusTypeEnum: v1, thickStatusTypeEnum: R1, averageThickTypeEnum: M1, drawingEntityTypeEnum: S1, nestingResultDeletionRangeEnum: L1, workInProgressShowTypeEnum: T1, mesLossStatisticsProjectStatusEnum: A1, mesFeedingMaterialsTypeEnum: N1, weightTypeEnum: I1, tempWorkReasonEnum: C1, tempWorkAuditStatusEnum: P1, completionRatioTypeEnum: O1 }, uw = Object.freeze(Object.defineProperty({ __proto__: null, ArtifactCalculationWayEnum: Fg, IssuedToNestingSoftwareStatusEnum: qh, KanBanProcessTypeEnum: l1, KanBanShippingStateEnum: o1, MesBuildingTypesettingStatusEnum: Hf, PartsSchedulingStatusEnum: Gh, PieceworkSystemEnum: Fh, abnormalChangeTypeEnum: _f, abnormalHandleStatusEnum: cf, abnormalHandleTypeEnum: uf, abnormalReportTypeEnum: pf, abnormalStatusEnum: hf, accessoryTypeEnum: vg, artifactProcessEnum: Wh, artifactProductLineEnum: Mf, artifactSpecReviseEnum: Ff, artifactTypeEnum: Cf, assembleCalculationWayEnum: Hg, assembleClassificationWayEnum: zg, assembleTypeEnum: $f, assemblyUnitEnum: eg, attendanceStatusEnum: ff, attendanceTypeEnum: gf, auxiliaryMaterialTypeEnum: sg, averageThickTypeEnum: M1, avoidTimeEnum: Qg, boolCertificateEnum: Yg, boolDeductionEnum: Kg, boolFixedProcessEnum: n1, boolSendDirectlyEnum: V1, changeHandleStatusEnum: df, changeTypeEnum: Pf, coatingProcessProjectStatusEnum: e1, coatingTypeEnum: Vf, coatingTypeWeightEnum: wf, codingTypeEnum: kf, completionRatioTypeEnum: O1, componentTypeEnum: li, contractSaleTypeEnum: Gl, createWayEnum: qg, cuttingConfigEnum: Df, default: WA, deliveryReceiptStatusEnum: Uf, deliveryStatusEnum: xf, drawingEntityTypeEnum: S1, drawingProcessingLayerTypeEnum: w1, drillListEnum: og, employeeCategoryEnum: Ug, enumEnclosureProduQuotaConfigSpecificationClassEnum: a1, expenseTypeCategoryEnum: Wg, fileNC1TypeEnum: tg, floorPlateTypeEnum: Gr, freightChangeTypeEnum: Kf, genderEnum: xg, hasHoleEnum: jf, hourlyWorkTypeEnum: nc, improveStatusEnum: bf, inProductionDetailReportEnum: Rf, inspectRealtimeColorsEnum: Xg, inspectTypeEnum: Og, inspectionStatusEnum: Jg, inspectionStatusTypeEnum: v1, intellectParentType: Nf, labelTypeEnum: Sf, laborPriceQuotaTypeEunm: d1, logisticsPriceTypeEnum: sf, lossStatisticsDimensionEnum: s1, lossStatisticsPickTypeEnum: u1, lossStatisticsProjectStatusEnum: hg, lossStatisticsproductionStatusEnum: fg, machineCheckStatusEnum: Zg, machinePartCalculationWayEnum: Bg, machinePartDxfTypeEnum: rg, machinePartHoleTypeEnum: $h, machinePartIssuedWayEnum: ug, machinePartNestingStatusEnum: Xh, machinePartSchedulingIssueStatusEnum: fs, machinePartSchedulingTypeEnum: pg, machinePartTaskStatusEnum: Zh, machinePartTypeEnum: ef, machineShowTypeEnum: tf, machineStoreTypeEnum: af, manufactureTypeEnum: Tf, mapTypeEnum: Gg, maxEqualTypeEnum: If, mesBuildingTypeSettingAssembleTypeEnum: Qf, mesCuttingStateEnum: _1, mesCuttingStateTabelEnum: b1, mesEnclosureTypeEnum: Mc, mesFeedingMaterialsTypeEnum: N1, mesLossStatisticsProjectStatusEnum: A1, mesLossWorkProgressStatisticsEnum: $s, mesMachinePartOrderTypeEnum: Zf, mesMachinePartTypeEnum: c1, mesNestTaskConfigEnum: y1, mesSchedulingStatusEnum: Jh, mesWarehouseStateTypeEnum: jh, meteUnitEnum: $g, minEqualTypeEnum: Lf, nestingFileTypeEnum: qf, nestingResultDeletionRangeEnum: L1, nestingSettingTypeEnum: Gf, nestingTypeEnum: cg, outputAffirmTimeEnum: yg, packStatusTypeEnum: of, packTypeEnum: lf, paintingTypeEnum: Ac, partKeyWordEnum: Wf, partProdModeEnum: Pg, printProductTypeEnum: vf, processCategoryEnum: Dh, processInspectTypeEnum: xh, processMaterialListTypeEnum: hs, processReportTypeEnum: Uh, productCategoryTypeEnum: Lg, productClassificationEnum: gg, productPickEnum: Eg, productSearchTypeEnum: ag, productSectionNameEnum: Oo, productionKanbanTypeEnum: dg, projectComponentTypeEnum: zh, projectNestingStatusEnum: Bf, projectPaintCalculationWayEnum: t1, projectPaintSortEnum: i1, projectProductionReportEnum: _g, projectReportCategoryEnum: Vg, projectReportCategoryStatusEnum: Mg, projectReportModelEnum: Sg, projectReportProcessStatusEnum: Rg, projectReportStatusEnum: bg, projectSearchTypeEnum: lg, qualityTaskTypeEnum: Ig, qualityTypeEnum: kg, quotaConfigArtifactConditionEnum: m1, quotaConfigAssembleConditionEnum: p1, quotaConfigMachinePartConditionEnum: h1, quotaConfigMeasureUnitEnum: f1, quotaSpecificationClassifyEnum: jg, rawMaterialLossEnum: r1, receiptStatusEnum: nf, reportComponentTypeEnum: Bh, reportingManageViewTypeEnum: g1, schedulingStatusEnum: Ef, schedulingTypeEnum: yf, searchDateTypeEnum: Yf, sectionSourceEnum: Ng, shipAuditStatusEnum: rf, shipStatusEnum: Jf, smallArtifactClassEnum: Of, sortingListEnum: ig, statisticsModelEnum: Tg, steelOutBoundRecordTypeEnum: mg, structureOrderTypeEnum: ng, surplusHandleStatusEnum: mf, taskCompanyStatusEnum: wg, taskIssueNumberTypeEnum: Qh, taskIssueTypeEnum: Hh, taskReportTypeEnum: Yh, taskTrackingSchedulingStatusEnum: zf, taskTypeENUM: Kh, teamAttributeEnum: kh, teamConfigTaskTypeEnum: Cg, teamPayrollSummaryViewTypeEnum: E1, teamTypeEnum: Oh, tempWorkAuditStatusEnum: P1, tempWorkReasonEnum: C1, thickStatusTypeEnum: R1, traditionLineEnum: Af, wageQuotaTypeEnum: Ca, wagesReportDetailEnum: Ag, weightTypeEnum: I1, workInProgressShowTypeEnum: T1, workOrderTypeEnum: Xf, workStateEnum: Dg }, Symbol.toStringTag, { value: "Module" })), jA = "#1682e6", $lt = "#1682e6", ua = Ge.STEEL_PLATE.V | Ge.SECTION_STEEL.V | Ge.STEEL_COIL.V, sl = Pe.STEEL_PLATE.V | Pe.SECTION_STEEL.V | Pe.STEEL_COIL.V | Pe.OTHER_STEEL_MATERIALS.V, ho = Ge.STRUC_MANUFACTURED.V | Ge.ENCL_MANUFACTURED.V, eot = { [hs.ARTIFACT.V]: Ca.WEIGHT.V | Ca.LENGTH.V | Ca.QUANTITY.V | Ca.AREA.V, [hs.ASSEMBLE.V]: Ca.WEIGHT.V | Ca.LENGTH.V | Ca.QUANTITY.V, [hs.MACHINE_PART.V]: Ca.WEIGHT.V | Ca.QUANTITY.V, [hs.ENCLOSURE.V]: Ca.LENGTH.V | Ca.QUANTITY.V | Ca.AREA.V }, Ot = Object.keys($e.VL).reduce((e, o) => e | o, 0), nr = "kg", tm = 8, vi = {};
vi[Ge.STEEL_PLATE.V] = { measure: { unit: "张", precision: 0 }, weight: { unit: "t", precision: 3 }, length: { unit: "mm", precision: 0 }, width: { unit: "mm", precision: 0 }, thickness: { unit: "mm", precision: 2 } };
vi[Ge.SECTION_STEEL.V] = { measure: { unit: "根", precision: 0 }, weight: { unit: "t", precision: 3 }, length: { unit: "mm", precision: 0 }, width: { unit: "mm", precision: 0 } };
vi[Ge.STEEL_COIL.V] = { measure: { unit: "m", precision: 0 }, weight: { unit: "t", precision: 3 }, length: { unit: "m", precision: 3 }, width: { unit: "mm", precision: 0 }, thickness: { unit: "mm", precision: 3 } };
vi[Ge.STRUC_MANUFACTURED.V] = { measure: { unit: "件", precision: 0, type: Ka.VOLUME.V }, showWeight: { unit: "kg", precision: 3, symbol: "kg", type: Ka.WEIGHT.V }, area: { unit: "㎡", precision: 6, symbol: "㎡", type: Ka.AREA.V }, weight: { unit: "t", precision: 6, symbol: "t", type: Ka.WEIGHT.V }, length: { unit: "m", precision: 3, symbol: "m", type: Ka.LENGTH.V }, quantity: { unit: "件", precision: 0, symbol: "件", type: Ka.DIGIT.V } };
vi[Ge.ENCL_MANUFACTURED.V] = { measure: { unit: "张", precision: 0, type: Ka.VOLUME.V }, showWeight: { unit: "kg", precision: 3, symbol: "kg", type: Ka.WEIGHT.V }, area: { unit: "㎡", precision: 6, symbol: "㎡", type: Ka.AREA.V }, weight: { unit: "t", precision: 6, symbol: "t", type: Ka.WEIGHT.V }, length: { unit: "m", precision: 3, symbol: "m", type: Ka.LENGTH.V }, quantity: { unit: "张", precision: 0, symbol: "张", type: Ka.DIGIT.V } };
vi[ua] = { measure: { unit: "件", precision: 0 }, weight: { unit: "t", precision: 3 }, length: { unit: "mm", precision: 0 }, width: { unit: "mm", precision: 0 } };
const ei = vi[ua], Ft = { LENGTH: "mm", LENGTH_DP: 3, WEIGHT: "g", WEIGHT_DP: 3, THICKNESS: "mm", THICKNESS_DP: 3, AREA: "mm²", AREA_DP: 0, VOLUME: "mm³", VOLUME_DP: 0 }, rt = { T_WEIGHT: "t", T_WEIGHT_DP: 2, WEIGHT: "kg", WEIGHT_DP: 2, LENGTH: "mm", LENGTH_DP: 3 }, er = { QR_SCAN_ARTIFACT_TASK: "/s/s/a", QR_SCAN_ENCLOSURE_TASK: "/s/s/e", QR_SCAN_AUXILIARY_MATERIAL: "/s/s/m", QR_SCAN_BRIDGE_BOX_TASK: "/s/b/b", QR_SCAN_BRIDGE_SINGLE_ELEMENT_TASK: "/s/b/s", QR_SCAN_BRIDGE_AUXILIARY_MATERIAL: "/s/b/m" }, FA = "/mobile-model-preview", tot = { MEW_PRODUCTION: 1, MES_PACKAGE_SHIP: 2, BRIDGE_PRODUCTION: 16, BRIDGE_PACKAGE_SHIP: 32 }, iot = { MES_PACKAGE: 1, MES_SHIP_LIST: 2 }, Ao = {};
Ao[Gn.STRUCTURE.V] = { unit: "kg", normal: "kg", smallest: "g", precision: 3 };
Ao[Gn.ENCLOSURE.V] = {};
Ao[Gn.ENCLOSURE.V][Cs.LENGTH.V] = { unit: "m", normal: "m", smallest: "mm", precision: 3 };
Ao[Gn.ENCLOSURE.V][Cs.AREA.V] = { unit: "㎡", normal: "m2", smallest: "mm2", precision: 3 };
Ao[Gn.AUXILIARY_MATERIAL.V] = { unit: "件" };
Ao[un.ARTIFACT.V] = { unit: "kg", normal: "kg", smallest: "g", precision: 3 };
Ao[un.MACHINE_PART.V] = { unit: "kg", normal: "kg", smallest: "g", precision: 3 };
Ao[un.ARTIFACT_TREE.V] = { unit: "kg", normal: "kg", smallest: "g", precision: 3 };
Ao[un.ENCLOSURE.V] = {};
Ao[un.ENCLOSURE.V][Cs.LENGTH.V] = { unit: "m", normal: "m", smallest: "mm", precision: 3 };
Ao[un.ENCLOSURE.V][Cs.AREA.V] = { unit: "㎡", normal: "m2", smallest: "mm2", precision: 3 };
Ao[un.AUXILIARY_MATERIAL.V] = { unit: "件" };
const Ze = { COM_WT__T: 5, COM_WT__KG: 2, COM_L__M: 2, COM_L__MM: 0, COM_WT__G: 3, COM_AREA__M2: 2, COM_ENCLOSURE_AREA__M2: 3, COM_VOLUME__L: 2, COM_T__MM: 3, COM_UNIT__KG_M3: 2, COM_UNIT__KG_M2: 2, COM_UNIT__KG_M: 2, MES_ARTIFACT_L__MM: 0, MES_ARTIFACT_L__M: 2, MES_MACHINE_PART_L__MM: 0, MES_MACHINE_PART_L__M: 2, MES_ENCLOSURE_L__MM: 0, MES_ENCLOSURE_L__M: 3, MES_ENCLOSURE_W__MM: 0, MES_ENCLOSURE_T__MM: 3, YUAN: 2, ACCOUNTING: 2 }, k1 = [{ text: "最近一周", value: () => {
  const e = /* @__PURE__ */ new Date(), o = /* @__PURE__ */ new Date();
  return o.setTime(o.getTime() - 3600 * 1e3 * 24 * 7), [o, e];
} }, { text: "当前月份", value: () => {
  const e = /* @__PURE__ */ new Date(), o = /* @__PURE__ */ new Date();
  return o.setDate(1), o.setHours(0), o.setSeconds(0), o.setMinutes(0), [o, e];
} }, { text: "最近一个月", value: () => {
  const e = /* @__PURE__ */ new Date(), o = /* @__PURE__ */ new Date();
  return o.setTime(o.getTime() - 3600 * 1e3 * 24 * 30), [o, e];
} }, { text: "最近三个月", value: () => {
  const e = /* @__PURE__ */ new Date(), o = /* @__PURE__ */ new Date();
  return o.setTime(o.getTime() - 3600 * 1e3 * 24 * 90), [o, e];
} }, { text: "最近六个月", value: () => {
  const e = /* @__PURE__ */ new Date(), o = /* @__PURE__ */ new Date();
  return o.setMonth(o.getMonth() - 6), [o, e];
} }, { text: "今年至今", value: () => {
  const e = /* @__PURE__ */ new Date();
  return [new Date((/* @__PURE__ */ new Date()).getFullYear(), 0), e];
} }], aot = [{ text: "最近一周", value: () => {
  const e = /* @__PURE__ */ new Date(), o = /* @__PURE__ */ new Date();
  return o.setTime(o.getTime() - 3600 * 1e3 * 24 * 7), [o, e];
} }, { text: "当前月份", value: () => {
  const e = /* @__PURE__ */ new Date(), o = /* @__PURE__ */ new Date();
  return o.setDate(1), o.setHours(0), o.setSeconds(0), o.setMinutes(0), [o, e];
} }, { text: "最近一个月", value: () => {
  const e = /* @__PURE__ */ new Date(), o = /* @__PURE__ */ new Date();
  return o.setTime(o.getTime() - 3600 * 1e3 * 24 * 30), [o, e];
} }];
const zA = { id: "app" }, BA = { __name: "App", setup(e) {
  const o = Ht(), n = eu();
  return Ce(() => n.path, () => {
    n.meta.projectType = n.path === "/" || n.path === "/login" ? Ot : n.meta.ownProductType || n.meta.projectType, pt(() => {
      o.dispatch("project/setRouteProjectByMeta", n.meta);
    });
  }), document.addEventListener("visibilitychange", function() {
    var c;
    document.visibilityState === "visible" ? (console.log("页面切换到前台"), $V((c = n.meta) == null ? void 0 : c.branchCompanyId)) : document.visibilityState === "hidden" && console.log("页面切换到后台");
  }), (c, u) => {
    const r = Ve("router-view");
    return w(), Q("div", zA, [s(l(V6), { locale: l(b6) }, { default: p(() => [s(r)]), _: 1 }, 8, ["locale"])]);
  };
} }, HA = "modulepreload", qA = function(e) {
  return "/" + e;
}, M2 = {}, d = function(o, n, c) {
  n = (n || []).filter((asset) => asset.endsWith(".css"));
  if (!n || n.length === 0) return o();
  const u = document.getElementsByTagName("link");
  return Promise.all(n.map((r) => {
    if (r = qA(r), r in M2) return;
    M2[r] = true;
    const E = r.endsWith(".css"), y = E ? '[rel="stylesheet"]' : "";
    if (!!c) for (let M = u.length - 1; M >= 0; M--) {
      const g = u[M];
      if (g.href === r && (!E || g.rel === "stylesheet")) return;
    }
    else if (document.querySelector(`link[href="${r}"]${y}`)) return;
    const V = document.createElement("link");
    if (V.rel = E ? "stylesheet" : HA, E || (V.as = "script", V.crossOrigin = ""), V.href = r, document.head.appendChild(V), E) return new Promise((M, g) => {
      V.addEventListener("load", M), V.addEventListener("error", () => g(new Error(`Unable to preload CSS for ${r}`)));
    });
  })).then(() => o()).catch((r) => {
    const E = new Event("vite:preloadError", { cancelable: true });
    if (E.payload = r, window.dispatchEvent(E), !E.defaultPrevented) throw r;
  });
}, ka = (e) => {
  const o = Ht();
  if (A(e)) {
    if (e instanceof Array) return Object.fromEntries(e.map((n) => [n, Ee(() => o.getters[n])]));
    if (typeof e == "string") return Object.fromEntries([[e, Ee(() => o.getters[e])]]);
  }
  return Object.fromEntries(Object.keys(o.getters).map((n) => [n, Ee(() => o.getters[n])]));
};
const ut = (e, o) => {
  const n = e.__vccOpts || e;
  for (const [c, u] of o) n[c] = u;
  return n;
}, GA = { id: "app-main", class: "app-main" }, QA = { style: { margin: "20px" } }, ZA = { __name: "AppMain", setup(e) {
  const o = eu(), { globalProjectId: n, cachedViews: c } = ka(["globalProjectId", "cachedViews"]), u = Ee(() => o.path), r = Ee(() => {
    if (n.value) return false;
    const E = o.meta.needProject;
    return typeof E == "boolean" && E;
  });
  return Ce(() => o.path, (E) => {
    setTimeout(() => {
      const y = document.getElementById("navbar").offsetHeight, b = document.getElementById("app-main");
      b.style.paddingTop = `${y}px`;
    }, 0);
  }, { immediate: true, deep: true }), (E, y) => {
    const b = Ve("router-view"), V = wi;
    return w(), Q("section", GA, [r.value ? (w(), U($d, { key: 1, mode: "out-in", name: "fade-transform" }, { default: p(() => [C("div", QA, [s(V, { size: "large", style: { "margin-bottom": "10px" }, type: "danger" }, { default: p(() => y[0] || (y[0] = [Te(" * 您好，请先选择项目，当前页面需要选择项目方可查看 ")])), _: 1, __: [0] }), y[2] || (y[2] = C("br", null, null, -1)), s(V, { size: "large" }, { default: p(() => y[1] || (y[1] = [Te(" 可通过网页头部的“项目下拉选择框”选择项目，若选择框中不存在您所在的项目，请联系项目负责人将您拉入项目中 ")])), _: 1, __: [1] })])]), _: 1 })) : (w(), U(b, { key: 0 }, { default: p(({ Component: M, route: g }) => [s($d, { name: g.meta.transition ? g.meta.transition : "fade-transform", mode: "out-in" }, { default: p(() => [(w(), U(Ri(M), { key: u.value }))]), _: 2 }, 1032, ["name"])]), _: 1 }))]);
  };
} }, cw = ut(ZA, [["__scopeId", "data-v-0fa949f2"]]);
const JA = { name: "Hamburger" }, XA = Object.assign(JA, { props: { isActive: { type: Boolean, default: false } }, emits: ["toggleClick"], setup(e, { emit: o }) {
  const n = e, c = o;
  function u() {
    c("toggleClick");
  }
  return (r, E) => (w(), Q("div", { onClick: u }, [(w(), Q("svg", { class: Zt([{ "is-active": n.isActive }, "hamburger"]), viewBox: "0 0 1024 1024", xmlns: "http://www.w3.org/2000/svg", width: "64", height: "64" }, E[0] || (E[0] = [C("path", { d: "M408 442h480c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8H408c-4.4 0-8 3.6-8 8v56c0 4.4 3.6 8 8 8zm-8 204c0 4.4 3.6 8 8 8h480c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8H408c-4.4 0-8 3.6-8 8v56zm504-486H120c-4.4 0-8 3.6-8 8v56c0 4.4 3.6 8 8 8h784c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8zm0 632H120c-4.4 0-8 3.6-8 8v56c0 4.4 3.6 8 8 8h784c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8zM142.4 642.1L298.7 519a8.84 8.84 0 0 0 0-13.9L142.4 381.9c-5.8-4.6-14.4-.5-14.4 6.9v246.3a8.9 8.9 0 0 0 14.4 7z" }, null, -1)]), 2))]));
} }), D1 = ut(XA, [["__scopeId", "data-v-a163cda8"]]), $A = "/static/jpg/header-ddbc7794.jpg";
function dw(e, o) {
  return !!e.className.match(new RegExp("(\\s|^)" + o + "(\\s|$)"));
}
function eN(e, o) {
  dw(e, o) || (e.className += " " + o);
}

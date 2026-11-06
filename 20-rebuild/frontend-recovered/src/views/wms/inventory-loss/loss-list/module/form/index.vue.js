import { ElNotification as K } from "element-plus";
import { useStore as ui } from "vuex";
import { ref as te } from "vue";
import { computed as pe } from "vue";
import { provide as Ae } from "vue";
import { reactive as mi } from "vue";
import { watch as $e } from "vue";
import { nextTick as ke } from "vue";
import { resolveComponent as we } from "vue";
import { openBlock as Ve } from "vue";
import { createBlock as je } from "vue";
import { withCtx as ye } from "vue";
import { createVNode as ue } from "vue";
import { createTextVNode as qe } from "vue";
import { createElementVNode as ge } from "vue";
import { createElementBlock as hi } from "vue";
import { toDisplayString as Oe } from "vue";
import { createCommentVNode as pi } from "vue";
import { unref as he } from "vue";
import { resolveDynamicComponent as yi } from "vue";
import { mergeProps as gi } from "vue";
import { isRef as _i } from "vue";
import { ElMessageBox as bi } from "element-plus";
import { ElMessage as Fe } from "element-plus";
import { ElForm as Ni } from "element-plus";
import { rJ as _e, am as q, vP as H, vQ as Ce, j as s, V as z, z as G, vR as J, i as M, b as O, f3 as X, xy as Z, aI as ee, sT as He, iX as v, vS as re, xz as ie, sU as ze, v9 as Ge, va as Je, cP as ne, vT as Q, _ as xi, jY as Pi, mx as Ei, ku as Ti, bl as Y, cJ as me, o as Ii, u as wi, hg as fe, L as Li, xA as Mi, vv as Ci, xB as Vi, cO as Fi, jl as Si, cS as Se } from "../../../../../../shared/runtime.js";
import We from "./components/steel-plate-table.vue.js";
import ve from "./components/section-steel-table.vue.js";
import Re from "./components/steel-coil-table.vue.js";
import Be from "./components/other-steel-material-table.vue.js";
import De from "./components/auxiliary-material.vue.js";
import Qe from "./components/gas-table.vue.js";
import Ke from "./components/other-table.vue.js";
import Ui from "./submit-preview.vue.js";
const { handleMeteChangeCalcPrice: Yi } = re("weighingTotalWeight"), Ee = _e[q.STEEL_PLATE.V];
function Ai(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function $i(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "钢板盘盈清单-错误清单", sheetName: "错误清单" });
}
const Xe = { title: "钢板盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Ee.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Ee.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Ee.length.precision, excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", precision: Ee.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: Ee.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_14" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_15" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_16" }, { label: "备注", field: "remark", excelField: "__EMPTY_17" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], length: [{ required: true, message: "长度不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], diffQuantity: [{ validator: Ai, message: "盘亏情况下数量需大于0" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }] }, format: async (u) => {
  var a;
  const _ = u.filter((i) => i.boolLoss === "是");
  if (!H(_, Xe.rules)) return;
  const P = await Ce();
  s.state.wms.loaded.steelDensityCfg || await s.dispatch("config/fetchSteelDensityCfg");
  const y = s.state.wms.steelDensityCfg;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const h = s.state.config.rawMatClsList.filter((i) => i.basicClass === q.STEEL_PLATE.V), m = s.state.config.rawMatClsKV, g = z(_), E = [];
  let b = [];
  const f = [], N = [], C = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const w = s.state.config.workshopNameV2, A = s.state.config.warehouseV2, V = s.state.project.projectAllType.map((i) => (i.fullName = G(i, null, false), i)), x = s.state.config.suppliers;
  g.forEach((i, n) => {
    let l = false;
    const t = J(i.classifyName.split("/"));
    if (t.length === 1) {
      const d = h.filter((r) => r.name === i.classifyName) || [];
      if (M(d)) if (d.length === 1) l = true, i.classifyId = d[0].id, E.push(d[0].id);
      else {
        const r = [];
        for (const p of d) if (p.isLeaf) for (let I = 0; I < p.fullPathId.length; I++) p.id !== p.fullPathId[I] && r.push(p.fullPathId[I]);
        const c = d.find((p) => O(p.parent) && !r.includes(p.id));
        if (M(c)) l = true, i.classifyId = c.id, E.push(c.id);
        else {
          const p = d.filter((I) => I.isLeaf) || [];
          if (p.length === 1) {
            let I = true;
            d.forEach((oe) => {
              p[0].fullPathId.includes(oe.id) || (I = false);
            }), I && (l = true, i.classifyId = p[0].id, E.push(p[0].id));
          } else for (const I of d) M(I.parent) && !r.includes(I.id) && f.push(I);
        }
      }
      f.length > 1 && C.push({ rowIndex: n + 1, error: `科目名称"${i.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const d of h) if (d.fullPathName.length >= t.length && X(d.fullPathName.slice(-t.length), t)) {
      l = true, i.classifyId = d.id, E.push(d.id);
      break;
    }
    l || (b.push(i.classifyName), N.some((d) => d.classifyName === i.classifyName) || N.push({ rowIndex: n + 1, classifyName: i.classifyName }));
    const o = q.STEEL_PLATE.V;
    Z(i, n, { workshopNameV2List: w, warehouseV2List: A, arr: V, errorList: C, supplierList: x, basicClass: o });
  }), b = Array.from(new Set(b)), b.length > 0 && (C.push({ rowIndex: N[0].rowIndex, error: `${N.map((i) => `"${i.classifyName}"`).join("、")}${N.length > 1 ? "等" : ""}物料种类不存在` }), N.shift());
  const T = s.state.config.classifySpec, e = [];
  for (let i = 0; i < E.length; i++) T[E[i]] === void 0 && !e.includes(E[i]) && e.push(E[i]);
  e.length > 0 && (e.forEach((i) => {
    T[i] = {};
  }), await s.dispatch("config/fetchMarClsSpec", e));
  for (const i of g) {
    if (((a = m == null ? void 0 : m[i.classifyId]) == null ? void 0 : a.isLeaf) === false) {
      C.push({ rowIndex: g.indexOf(i) + 1, error: `${i.classifyName}不是末级科目` });
      continue;
    }
    const n = T[i.classifyId];
    if ((n == null ? void 0 : n.hasUnitConfig) === false) {
      C.push({ rowIndex: g.indexOf(i) + 1, error: `${i.classifyName}未配置核算单位` });
      continue;
    }
    let l;
    const t = i.material ?? "";
    if (n && Array.isArray(n.specList)) {
      for (const o of n.specList) if (t === o.spec) {
        l = o;
        break;
      }
    }
    if (l) {
      i.uid = ee(), i.sn = l.sn, i.specificationLabels = l.specificationLabels, i.classifySerialNumber = l.classify.serialNumber, i.serialNumber = l.serialNumber, i.classifyId = l.classify.id, i.classifyFullName = l.classify.fullName, i.classifyName = l.classify.name, i.classifyParentFullName = l.classify.parentFullName, i.basicClass = l.classify.basicClass, i.specification = l.spec, i.specificationMap = l.specKV, i.measureUnit = l.classify.measureUnit, i.accountingUnit = l.classify.accountingUnit, i.accountingPrecision = l.classify.accountingPrecision, i.measurePrecision = l.classify.measurePrecision;
      let o = 0;
      for (const d in y) Number(d) === i.classifyId && (o = y[d]);
      i.steelDensity = o, i.theoryWeight = await He({ classifyId: i.classifyId, name: i.classifyFullName, length: i.length, width: i.width, thickness: i.thickness }), M(i.theoryWeight) && i.quantity ? i.theoryTotalWeight = v(i.theoryWeight * i.quantity, P[q.STEEL_PLATE.V].weight.precision) : i.theoryTotalWeight = void 0, i.weighingTotalWeight = i.theoryTotalWeight || i.weighingTotalWeight, i.mete = i.weighingTotalWeight, (!i.unitPrice || !i.amount) && Yi(i), i.basicClassifyName = i.basicClass + "_" + i.classifyName, i.isImport = true;
    } else {
      const o = `${i.classifyName}下不存在规格为"${t}"的材料，请联系管理员/仓库人员添加`;
      C.some((d) => d.error === o) || C.push({ rowIndex: g.indexOf(i) + 1, error: o });
      continue;
    }
  }
  if (C.length > 0) $i(C);
  else return g;
} }, { handleMeteChangeCalcPrice: ki } = re("weighingTotalWeight"), Ue = _e[q.SECTION_STEEL.V];
function ji(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function qi(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "型材盘盈清单-错误清单", sheetName: "错误清单" });
}
const Ze = { title: "型材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "规格", field: "specification", excelField: "__EMPTY_2" }, { label: "型材库标准", field: "profileLibraryStandard", excelField: "__EMPTY_3" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: Ue.length.precision, excelField: "__EMPTY_4" }, { label: "数量（根）", field: "quantity", type: "number", precision: Ue.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: Ue.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_14" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_15" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_16" }, { label: "备注", field: "remark", excelField: "__EMPTY_17" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "规格不能为空" }], length: [{ required: true, message: "定尺长度不能为空" }], quantity: [{ required: true, message: "数量不能为空" }], diffQuantity: [{ validator: ji, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }] }, format: async (u) => {
  var e, a;
  const _ = u.filter((i) => i.boolLoss === "是");
  if (!H(_, Ze.rules)) return;
  const P = await Ce();
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const y = s.state.config.rawMatClsList.filter((i) => i.basicClass === q.SECTION_STEEL.V), h = s.state.config.rawMatClsKV, m = z(_), g = [];
  let E = [];
  const b = [], f = [], N = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const C = s.state.config.workshopNameV2, w = s.state.config.warehouseV2, j = s.state.project.projectAllType.map((i) => (i.fullName = G(i, null, false), i)), V = s.state.config.suppliers;
  m.forEach((i, n) => {
    let l = false;
    const t = J(i.classifyName.split("/"));
    if (t.length === 1) {
      const d = y.filter((r) => r.name === i.classifyName) || [];
      if (M(d)) if (d.length === 1) l = true, i.classifyId = d[0].id, g.push(d[0].id);
      else {
        const r = [];
        for (const p of d) if (p.isLeaf) for (let I = 0; I < p.fullPathId.length; I++) p.id !== p.fullPathId[I] && r.push(p.fullPathId[I]);
        const c = d.find((p) => O(p.parent) && !r.includes(p.id));
        if (M(c)) l = true, i.classifyId = c.id, g.push(c.id);
        else {
          const p = d.filter((I) => I.isLeaf) || [];
          if (p.length === 1) {
            let I = true;
            d.forEach((oe) => {
              p[0].fullPathId.includes(oe.id) || (I = false);
            }), I && (l = true, i.classifyId = p[0].id, g.push(p[0].id));
          } else for (const I of d) M(I.parent) && !r.includes(I.id) && b.push(I);
        }
      }
      b.length > 1 && N.push({ rowIndex: n + 1, error: `科目名称"${i.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const d of y) if (d.fullPathName.length >= t.length && X(d.fullPathName.slice(-t.length), t)) {
      l = true, i.classifyId = d.id, g.push(d.id);
      break;
    }
    l || (E.push(i.classifyName), f.some((d) => d.classifyName === i.classifyName) || f.push({ rowIndex: n + 1, classifyName: i.classifyName }));
    const o = q.SECTION_STEEL.V;
    Z(i, n, { workshopNameV2List: C, warehouseV2List: w, arr: j, errorList: N, supplierList: V, basicClass: o });
  }), E = Array.from(new Set(E)), E.length > 0 && (N.push({ rowIndex: f[0].rowIndex, error: `${f.map((i) => `"${i.classifyName}"`).join("、")}${f.length > 1 ? "等" : ""}物料种类不存在` }), f.shift());
  const x = s.state.config.classifySpec, T = [];
  for (let i = 0; i < g.length; i++) x[g[i]] === void 0 && !T.includes(g[i]) && T.push(g[i]);
  T.length > 0 && (T.forEach((i) => {
    x[i] = {};
  }), await s.dispatch("config/fetchMarClsSpec", T));
  for (const i of m) {
    if (((e = h == null ? void 0 : h[i.classifyId]) == null ? void 0 : e.isLeaf) === false) {
      N.push({ rowIndex: m.indexOf(i) + 1, error: `${i.classifyName}不是末级科目` });
      continue;
    }
    const n = x[i.classifyId];
    if ((n == null ? void 0 : n.hasUnitConfig) === false) {
      N.push({ rowIndex: m.indexOf(i) + 1, error: `${i.classifyName}未配置核算单位` });
      continue;
    }
    let l;
    const t = `${i.specification} * ${i.material}`;
    if (n && Array.isArray(n.specList)) {
      for (const o of n.specList) if (t === o.spec) {
        l = o;
        break;
      }
    }
    if (l) {
      const o = (a = l.nationalStandardOptions.find((c) => c.boolDefault === true)) == null ? void 0 : a.standardId;
      i.uid = ee(), i.sn = l.sn, i.specificationLabels = l.specificationLabels, i.serialNumber = l.serialNumber, i.classifySerialNumber = l.classify.serialNumber, i.classifyId = l.classify.id, i.classifyFullName = l.classify.fullName, i.classifyName = l.classify.name, i.classifyParentFullName = l.classify.parentFullName, i.basicClass = l.classify.basicClass, i.specification = l.spec.split("*").slice(0, -1).join("*"), i.specificationMap = l.specKV, i.measureUnit = l.classify.measureUnit, i.accountingUnit = l.classify.accountingUnit, i.accountingPrecision = l.classify.accountingPrecision, i.measurePrecision = l.classify.measurePrecision, i.unitWeight = l.unitWeight, i.nationalStandardOptions = l.nationalStandardOptions, i.standardId = o;
      let d;
      const r = [];
      for (const c in i.specificationMap) c.indexOf("standard") > -1 ? d = i.specificationMap[c] : r.push(i.specificationMap[c]);
      i.sectionSteelSpec = d, i.doNotSectionSteelSpec = r.join(" * "), i.theoryWeight = await ze({ length: i.length, unitWeight: i.unitWeight }), M(i.theoryWeight) && i.quantity ? i.theoryTotalWeight = v(i.theoryWeight * i.quantity, P[q.SECTION_STEEL.V].weight.precision) : i.theoryTotalWeight = void 0, i.weighingTotalWeight = i.weighingTotalWeight || i.theoryTotalWeight, i.mete = i.weighingTotalWeight, Oi(i), (!i.unitPrice || !i.amount) && ki(i), i.basicClassifyName = i.basicClass + "_" + i.classifyName, i.isImport = true;
    } else {
      const o = `${i.classifyName}下不存在规格为"${t}"的材料，请联系管理员/仓库人员添加`;
      N.some((d) => d.error === o) || N.push({ rowIndex: m.indexOf(i) + 1, error: o });
      continue;
    }
  }
  if (N.length > 0) qi(N);
  else return m;
} };
function Oi(u) {
  M(u.length) && u.quantity ? u.totalLength = Ge({ length: u.length, quantity: u.quantity }) : u.totalLength = void 0;
}
const { handleMeteChangeCalcPrice: Wi } = re("weighingTotalWeight"), Le = _e[q.STEEL_COIL.V];
function vi(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function Ri(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "钢卷盘盈清单-错误清单", sheetName: "错误清单" });
}
const ei = { title: "钢卷盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Le.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Le.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Le.length.precision, excelField: "__EMPTY_4" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: Le.weight.precision, excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "卷号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_14" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_15" }, { label: "备注", field: "remark", excelField: "__EMPTY_16" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], weighingTotalWeight: [{ required: true, message: "总重不能为空" }], diffQuantity: [{ validator: vi, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var e;
  const _ = u.filter((a) => a.boolLoss === "是");
  if (!H(_, ei.rules)) return;
  s.state.wms.loaded.steelDensityCfg || await s.dispatch("config/fetchSteelDensityCfg");
  const P = s.state.wms.steelDensityCfg;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const y = s.state.config.rawMatClsList.filter((a) => a.basicClass === q.STEEL_COIL.V), h = s.state.config.rawMatClsKV, m = z(_), g = [];
  let E = [];
  const b = [], f = [], N = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType");
  const C = s.state.config.workshopNameV2, w = s.state.config.warehouseV2, j = s.state.project.projectAllType.map((a) => (a.fullName = G(a, null, false), a)), V = s.state.config.suppliers;
  m.forEach((a, i) => {
    let n = false;
    const l = J(a.classifyName.split("/"));
    if (l.length === 1) {
      const o = y.filter((d) => d.name === a.classifyName) || [];
      if (M(o)) if (o.length === 1) n = true, a.classifyId = o[0].id, g.push(o[0].id);
      else {
        const d = [];
        for (const c of o) if (c.isLeaf) for (let p = 0; p < c.fullPathId.length; p++) c.id !== c.fullPathId[p] && d.push(c.fullPathId[p]);
        const r = o.find((c) => O(c.parent) && !d.includes(c.id));
        if (M(r)) n = true, a.classifyId = r.id, g.push(r.id);
        else {
          const c = o.filter((p) => p.isLeaf) || [];
          if (c.length === 1) {
            let p = true;
            o.forEach((I) => {
              c[0].fullPathId.includes(I.id) || (p = false);
            }), p && (n = true, a.classifyId = c[0].id, g.push(c[0].id));
          } else for (const p of o) M(p.parent) && !d.includes(p.id) && b.push(p);
        }
      }
      b.length > 1 && N.push({ rowIndex: i + 1, error: `科目名称"${a.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const o of y) if (o.fullPathName.length >= l.length && X(o.fullPathName.slice(-l.length), l)) {
      n = true, a.classifyId = o.id, g.push(o.id);
      break;
    }
    n || (E.push(a.classifyName), f.some((o) => o.classifyName === a.classifyName) || f.push({ rowIndex: i + 1, classifyName: a.classifyName }));
    const t = q.STEEL_COIL.V;
    Z(a, i, { workshopNameV2List: C, warehouseV2List: w, arr: j, errorList: N, supplierList: V, basicClass: t });
  }), E = Array.from(new Set(E)), E.length > 0 && (N.push({ rowIndex: f[0].rowIndex, error: `${f.map((a) => `"${a.classifyName}"`).join("、")}${f.length > 1 ? "等" : ""}物料种类不存在` }), f.shift());
  const x = s.state.config.classifySpec, T = [];
  for (let a = 0; a < g.length; a++) x[g[a]] === void 0 && !T.includes(g[a]) && T.push(g[a]);
  T.length > 0 && (T.forEach((a) => {
    x[a] = {};
  }), await s.dispatch("config/fetchMarClsSpec", T));
  for (const a of m) {
    if (((e = h == null ? void 0 : h[a.classifyId]) == null ? void 0 : e.isLeaf) === false) {
      N.push({ rowIndex: m.indexOf(a) + 1, error: `${a.classifyName}不是末级科目` });
      continue;
    }
    const i = x[a.classifyId];
    if ((i == null ? void 0 : i.hasUnitConfig) === false) {
      N.push({ rowIndex: m.indexOf(a) + 1, error: `${a.classifyName}未配置核算单位` });
      continue;
    }
    let n;
    const l = a.material ?? "";
    if (i && Array.isArray(i.specList)) {
      for (const t of i.specList) if (l === t.spec) {
        n = t;
        break;
      }
    }
    if (n) {
      a.uid = ee(), a.sn = n.sn, a.specificationLabels = n.specificationLabels, a.serialNumber = n.serialNumber, a.classifySerialNumber = n.classify.serialNumber, a.classifyId = n.classify.id, a.classifyFullName = n.classify.fullName, a.classifyName = n.classify.name, a.classifyParentFullName = n.classify.parentFullName, a.basicClass = n.classify.basicClass, a.specification = n.spec, a.specificationMap = n.specKV, a.measureUnit = n.classify.measureUnit, a.accountingUnit = n.classify.accountingUnit, a.accountingPrecision = n.classify.accountingPrecision, a.measurePrecision = n.classify.measurePrecision;
      let t = 0;
      for (const o in P) Number(o) === a.classifyId && (t = P[o]);
      a.steelDensity = t, await Bi(a), a.length = a.length || a.theoryLength, (!a.unitPrice || !a.amount) && Wi(a), a.mete = a.weighingTotalWeight, a.basicClassifyName = a.basicClass + "_" + a.classifyName, a.isImport = true;
    } else {
      const t = `${a.classifyName}下不存在规格为"${l}"的材料，请联系管理员/仓库人员添加`;
      N.some((o) => o.error === t) || N.push({ rowIndex: m.indexOf(a) + 1, error: t });
      continue;
    }
  }
  if (N.length > 0) Ri(N);
  else return m;
} };
async function Bi(u) {
  u.theoryLength = await Je({ classifyId: u.classifyId, name: u.classifyFullName, weight: u.weighingTotalWeight, width: u.width, thickness: u.thickness });
}
const { handleMeteChangeCalcPrice: Di } = re("mete");
function Qi(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function Ki(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "其他钢材盘盈清单-错误清单", sheetName: "错误清单" });
}
const ii = { title: "其它钢材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_13" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_14" }, { label: "备注", field: "remark", excelField: "__EMPTY_15" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], diffQuantity: [{ validator: Qi, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var T;
  const _ = u.filter((e) => e.boolLoss === "是");
  if (!H(_, ii.rules)) return;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const P = s.state.config.rawMatClsList.filter((e) => e.basicClass === ne.OTHER_STEEL_MATERIALS.V), y = s.state.config.rawMatClsKV, h = z(_), m = [];
  let g = [];
  const E = [], b = [], f = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const N = s.state.config.workshopNameV2, C = s.state.config.warehouseV2, A = s.state.project.projectAllType.map((e) => (e.fullName = G(e, null, false), e)), j = s.state.config.suppliers;
  h.forEach((e, a) => {
    let i = false;
    const n = J(e.classifyName.split("/"));
    if (n.length === 1) {
      const t = P.filter((o) => o.name === e.classifyName) || [];
      if (M(t)) if (t.length === 1) i = true, e.classifyId = t[0].id, m.push(t[0].id);
      else {
        const o = [];
        for (const r of t) if (r.isLeaf) for (let c = 0; c < r.fullPathId.length; c++) r.id !== r.fullPathId[c] && o.push(r.fullPathId[c]);
        const d = t.find((r) => O(r.parent) && !o.includes(r.id));
        if (M(d)) i = true, e.classifyId = d.id, m.push(d.id);
        else {
          const r = t.filter((c) => c.isLeaf) || [];
          if (r.length === 1) {
            let c = true;
            t.forEach((p) => {
              r[0].fullPathId.includes(p.id) || (c = false);
            }), c && (i = true, e.classifyId = r[0].id, m.push(r[0].id));
          } else for (const c of t) M(c.parent) && !o.includes(c.id) && E.push(c);
        }
      }
      E.length > 1 && f.push({ rowIndex: a + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const t of P) if (t.fullPathName.length >= n.length && X(t.fullPathName.slice(-n.length), n)) {
      i = true, e.classifyId = t.id, m.push(t.id);
      break;
    }
    i || (g.push(e.classifyName), b.some((t) => t.classifyName === e.classifyName) || b.push({ rowIndex: a + 1, classifyName: e.classifyName }));
    const l = ne.OTHER_STEEL_MATERIALS.V;
    Z(e, a, { workshopNameV2List: N, warehouseV2List: C, arr: A, errorList: f, supplierList: j, basicClass: l });
  }), g = Array.from(new Set(g)), g.length > 0 && (f.push({ rowIndex: b[0].rowIndex, error: `${b.map((e) => `"${e.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const V = s.state.config.classifySpec, x = [];
  for (let e = 0; e < m.length; e++) V[m[e]] === void 0 && !x.includes(m[e]) && x.push(m[e]);
  x.length > 0 && (x.forEach((e) => {
    V[e] = {};
  }), await s.dispatch("config/fetchMarClsSpec", x));
  for (const e of h) {
    if (((T = y == null ? void 0 : y[e.classifyId]) == null ? void 0 : T.isLeaf) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const a = V[e.classifyId];
    if ((a == null ? void 0 : a.hasUnitConfig) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let i;
    const n = e.specification ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const l of a.specList) if (n === l.spec) {
        if (i = l, e.measureUnit && (i.classify.measureUnit || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` }), !await Q(i.classify.measureUnit, e.measureUnit))) {
          f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${i.classify.measureUnit}”` });
          continue;
        }
        e.accountingUnit && (await Q(i.classify.accountingUnit, e.accountingUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${i.classify.accountingUnit}”` }));
        break;
      }
    }
    if (i) e.uid = ee(), e.sn = i.sn, e.specificationLabels = i.specificationLabels, e.serialNumber = i.serialNumber, e.classifySerialNumber = i.classify.serialNumber, e.classifyId = i.classify.id, e.classifyFullPathId = i.classify.fullPathId, e.classifyFullName = i.classify.fullName, e.classifyName = i.classify.name, e.classifyParentFullName = i.classify.parentFullName, e.basicClass = i.classify.basicClass, e.specification = i.spec, e.specificationMap = i.specKV, e.measureUnit = i.classify.measureUnit, e.accountingUnit = i.classify.accountingUnit, e.accountingPrecision = i.classify.accountingPrecision, e.measurePrecision = i.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = v(e.quantity, e.measurePrecision)), e.mete && (e.mete = v(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), (!e.unitPrice || !e.amount) && Di(e), e.basicClassifyName = e.basicClass + "_" + e.classifyName, e.isImport = true;
    else {
      const l = `${e.classifyName}下不存在规格为"${n}"的材料，请联系管理员/仓库人员添加`;
      f.some((t) => t.error === l) || f.push({ rowIndex: h.indexOf(e) + 1, error: l });
    }
  }
  if (f.length > 0) Ki(f);
  else return h;
} }, { handleMeteChangeCalcPrice: Hi } = re("mete");
function zi(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function Gi(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "辅材盘盈清单-错误清单", sheetName: "错误清单" });
}
const si = { title: "辅材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_13" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_14" }, { label: "备注", field: "remark", excelField: "__EMPTY_15" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], diffQuantity: [{ validator: zi, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var T;
  const _ = u.filter((e) => e.boolLoss === "是");
  if (!H(_, si.rules)) return;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const P = s.state.config.rawMatClsList.filter((e) => e.basicClass === ne.MATERIAL.V), y = s.state.config.rawMatClsKV, h = z(_), m = [];
  let g = [];
  const E = [], b = [], f = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const N = s.state.config.workshopNameV2, C = s.state.config.warehouseV2, A = s.state.project.projectAllType.map((e) => (e.fullName = G(e, null, false), e)), j = s.state.config.suppliers;
  h.forEach((e, a) => {
    let i = false;
    const n = J(e.classifyName.split("/"));
    if (n.length === 1) {
      const t = P.filter((o) => o.name === e.classifyName) || [];
      if (M(t)) if (t.length === 1) i = true, e.classifyId = t[0].id, m.push(t[0].id);
      else {
        const o = [];
        for (const r of t) if (r.isLeaf) for (let c = 0; c < r.fullPathId.length; c++) r.id !== r.fullPathId[c] && o.push(r.fullPathId[c]);
        const d = t.find((r) => O(r.parent) && !o.includes(r.id));
        if (M(d)) i = true, e.classifyId = d.id, m.push(d.id);
        else {
          const r = t.filter((c) => c.isLeaf) || [];
          if (r.length === 1) {
            let c = true;
            t.forEach((p) => {
              r[0].fullPathId.includes(p.id) || (c = false);
            }), c && (i = true, e.classifyId = r[0].id, m.push(r[0].id));
          } else for (const c of t) M(c.parent) && !o.includes(c.id) && E.push(c);
        }
      }
      E.length > 1 && f.push({ rowIndex: a + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const t of P) if (t.fullPathName.length >= n.length && X(t.fullPathName.slice(-n.length), n)) {
      i = true, e.classifyId = t.id, m.push(t.id);
      break;
    }
    i || (g.push(e.classifyName), b.some((t) => t.classifyName === e.classifyName) || b.push({ rowIndex: a + 1, classifyName: e.classifyName }));
    const l = ne.MATERIAL.V;
    Z(e, a, { workshopNameV2List: N, warehouseV2List: C, arr: A, errorList: f, supplierList: j, basicClass: l });
  }), g = Array.from(new Set(g)), g.length > 0 && (f.push({ rowIndex: b[0].rowIndex, error: `${b.map((e) => `"${e.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const V = s.state.config.classifySpec, x = [];
  for (let e = 0; e < m.length; e++) V[m[e]] === void 0 && !x.includes(m[e]) && x.push(m[e]);
  x.length > 0 && (x.forEach((e) => {
    V[e] = {};
  }), await s.dispatch("config/fetchMarClsSpec", x));
  for (const e of h) {
    if (((T = y == null ? void 0 : y[e.classifyId]) == null ? void 0 : T.isLeaf) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const a = V[e.classifyId];
    if ((a == null ? void 0 : a.hasUnitConfig) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let i;
    const n = e.specification ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const l of a.specList) if (n === l.spec) {
        i = l, e.measureUnit && (i.classify.measureUnit || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` }), await Q(i.classify.measureUnit, e.measureUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${i.classify.measureUnit}”` })), e.accountingUnit && (await Q(i.classify.accountingUnit, e.accountingUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${i.classify.accountingUnit}”` }));
        break;
      }
    }
    if (i) e.uid = ee(), e.sn = i.sn, e.specificationLabels = i.specificationLabels, e.serialNumber = i.serialNumber, e.classifySerialNumber = i.classify.serialNumber, e.classifyId = i.classify.id, e.classifyFullPathId = i.classify.fullPathId, e.classifyFullName = i.classify.fullName, e.classifyName = i.classify.name, e.classifyParentFullName = i.classify.parentFullName, e.basicClass = i.classify.basicClass, e.specification = i.spec, e.specificationMap = i.specKV, e.measureUnit = i.classify.measureUnit, e.accountingUnit = i.classify.accountingUnit, e.accountingPrecision = i.classify.accountingPrecision, e.measurePrecision = i.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = v(e.quantity, e.measurePrecision)), e.mete && (e.mete = v(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), (!e.unitPrice || !e.amount) && Hi(e), e.basicClassifyName = e.basicClass + "_" + e.classifyName, e.isImport = true;
    else {
      const l = `${e.classifyName}下不存在规格为"${n}"的材料，请联系管理员/仓库人员添加`;
      f.some((t) => t.error === l) || f.push({ rowIndex: h.indexOf(e) + 1, error: l });
    }
  }
  if (f.length > 0) Gi(f);
  else return h;
} };
function Ji(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function Xi(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "办公用品盘盈清单-错误清单", sheetName: "错误清单" });
}
const ai = { title: "办公用品盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_13" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_14" }, { label: "备注", field: "remark", excelField: "__EMPTY_15" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], diffQuantity: [{ validator: Ji, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var T;
  const _ = u.filter((e) => e.boolLoss === "是");
  if (!H(_, ai.rules)) return;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const P = s.state.config.rawMatClsList.filter((e) => e.basicClass === q.OTHER.V), y = s.state.config.rawMatClsKV, h = z(_), m = [];
  let g = [];
  const E = [], b = [], f = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const N = s.state.config.workshopNameV2, C = s.state.config.warehouseV2, A = s.state.project.projectAllType.map((e) => (e.fullName = G(e, null, false), e)), j = s.state.config.suppliers;
  h.forEach((e, a) => {
    let i = false;
    const n = J(e.classifyName.split("/"));
    if (n.length === 1) {
      const t = P.filter((o) => o.name === e.classifyName) || [];
      if (M(t)) if (t.length === 1) i = true, e.classifyId = t[0].id, m.push(t[0].id);
      else {
        const o = [];
        for (const r of t) if (r.isLeaf) for (let c = 0; c < r.fullPathId.length; c++) r.id !== r.fullPathId[c] && o.push(r.fullPathId[c]);
        const d = t.find((r) => O(r.parent) && !o.includes(r.id));
        if (M(d)) i = true, e.classifyId = d.id, m.push(d.id);
        else {
          const r = t.filter((c) => c.isLeaf) || [];
          if (r.length === 1) {
            let c = true;
            t.forEach((p) => {
              r[0].fullPathId.includes(p.id) || (c = false);
            }), c && (i = true, e.classifyId = r[0].id, m.push(r[0].id));
          } else for (const c of t) M(c.parent) && !o.includes(c.id) && E.push(c);
        }
      }
      E.length > 1 && f.push({ rowIndex: a + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const t of P) if (t.fullPathName.length >= n.length && X(t.fullPathName.slice(-n.length), n)) {
      i = true, e.classifyId = t.id, m.push(t.id);
      break;
    }
    i || (g.push(e.classifyName), b.some((t) => t.classifyName === e.classifyName) || b.push({ rowIndex: a + 1, classifyName: e.classifyName }));
    const l = q.OTHER.V;
    Z(e, a, { workshopNameV2List: N, warehouseV2List: C, arr: A, errorList: f, supplierList: j, basicClass: l });
  }), g = Array.from(new Set(g)), g.length > 0 && (f.push({ rowIndex: b[0].rowIndex, error: `${b.map((e) => `"${e.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const V = s.state.config.classifySpec, x = [];
  for (let e = 0; e < m.length; e++) V[m[e]] === void 0 && !x.includes(m[e]) && x.push(m[e]);
  x.length > 0 && (x.forEach((e) => {
    V[e] = {};
  }), await s.dispatch("config/fetchMarClsSpec", x));
  for (const e of h) {
    if (((T = y == null ? void 0 : y[e.classifyId]) == null ? void 0 : T.isLeaf) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const a = V[e.classifyId];
    if ((a == null ? void 0 : a.hasUnitConfig) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let i;
    const n = e.specification ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const l of a.specList) if (n === l.spec) {
        i = l, e.measureUnit && (i.classify.measureUnit || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` }), await Q(i.classify.measureUnit, e.measureUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${i.classify.measureUnit}”` })), e.accountingUnit && (await Q(i.classify.accountingUnit, e.accountingUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${i.classify.accountingUnit}”` }));
        break;
      }
    }
    if (i) e.uid = ee(), e.sn = i.sn, e.specificationLabels = i.specificationLabels, e.serialNumber = i.serialNumber, e.classifySerialNumber = i.classify.serialNumber, e.classifyId = i.classify.id, e.classifyFullPathId = i.classify.fullPathId, e.classifyFullName = i.classify.fullName, e.classifyName = i.classify.name, e.classifyParentFullName = i.classify.parentFullName, e.basicClass = i.classify.basicClass, e.specification = i.spec, e.specificationMap = i.specKV, e.measureUnit = i.classify.measureUnit, e.accountingUnit = i.classify.accountingUnit, e.accountingPrecision = i.classify.accountingPrecision, e.measurePrecision = i.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = v(e.quantity, e.measurePrecision)), e.mete && (e.mete = v(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), e.basicClassifyName = e.basicClass + "_" + e.classifyName, e.isImport = true;
    else {
      const l = `${e.classifyName}下不存在规格为"${n}"的材料，请联系管理员/仓库人员添加`;
      f.some((t) => t.error === l) || f.push({ rowIndex: h.indexOf(e) + 1, error: l });
    }
  }
  if (f.length > 0) Xi(f);
  else return h;
} };
function Zi(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function es(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "气体盘盈清单-错误清单", sheetName: "错误清单" });
}
const ti = { title: "气体盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_13" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_14" }, { label: "备注", field: "remark", excelField: "__EMPTY_15" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], diffQuantity: [{ validator: Zi, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var T;
  const _ = u.filter((e) => e.boolLoss === "是");
  if (!H(_, ti.rules)) return;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const P = s.state.config.rawMatClsList.filter((e) => e.basicClass === ne.GAS.V), y = s.state.config.rawMatClsKV, h = z(_), m = [];
  let g = [];
  const E = [], b = [], f = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const N = s.state.config.workshopNameV2, C = s.state.config.warehouseV2, A = s.state.project.projectAllType.map((e) => (e.fullName = G(e, null, false), e)), j = s.state.config.suppliers;
  h.forEach((e, a) => {
    let i = false;
    const n = J(e.classifyName.split("/"));
    if (n.length === 1) {
      const t = P.filter((o) => o.name === e.classifyName) || [];
      if (M(t)) if (t.length === 1) i = true, e.classifyId = t[0].id, m.push(t[0].id);
      else {
        const o = [];
        for (const r of t) if (r.isLeaf) for (let c = 0; c < r.fullPathId.length; c++) r.id !== r.fullPathId[c] && o.push(r.fullPathId[c]);
        const d = t.find((r) => O(r.parent) && !o.includes(r.id));
        if (M(d)) i = true, e.classifyId = d.id, m.push(d.id);
        else {
          const r = t.filter((c) => c.isLeaf) || [];
          if (r.length === 1) {
            let c = true;
            t.forEach((p) => {
              r[0].fullPathId.includes(p.id) || (c = false);
            }), c && (i = true, e.classifyId = r[0].id, m.push(r[0].id));
          } else for (const c of t) M(c.parent) && !o.includes(c.id) && E.push(c);
        }
      }
      E.length > 1 && f.push({ rowIndex: a + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const t of P) if (t.fullPathName.length >= n.length && X(t.fullPathName.slice(-n.length), n)) {
      i = true, e.classifyId = t.id, m.push(t.id);
      break;
    }
    i || (g.push(e.classifyName), b.some((t) => t.classifyName === e.classifyName) || b.push({ rowIndex: a + 1, classifyName: e.classifyName }));
    const l = ne.GAS.V;
    Z(e, a, { workshopNameV2List: N, warehouseV2List: C, arr: A, errorList: f, supplierList: j, basicClass: l });
  }), g = Array.from(new Set(g)), g.length > 0 && (f.push({ rowIndex: b[0].rowIndex, error: `${b.map((e) => `"${e.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const V = s.state.config.classifySpec, x = [];
  for (let e = 0; e < m.length; e++) V[m[e]] === void 0 && !x.includes(m[e]) && x.push(m[e]);
  x.length > 0 && (x.forEach((e) => {
    V[e] = {};
  }), await s.dispatch("config/fetchMarClsSpec", x));
  for (const e of h) {
    if (((T = y == null ? void 0 : y[e.classifyId]) == null ? void 0 : T.isLeaf) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const a = V[e.classifyId];
    if ((a == null ? void 0 : a.hasUnitConfig) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let i;
    const n = e.specification ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const l of a.specList) if (n === l.spec) {
        if (i = l, e.measureUnit && e.measureUnit !== "-") {
          if (!i.classify.measureUnit) {
            f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` });
            continue;
          }
          await Q(i.classify.measureUnit, e.measureUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${i.classify.measureUnit}”` });
        }
        e.accountingUnit && (await Q(i.classify.accountingUnit, e.accountingUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${i.classify.accountingUnit}”` }));
        break;
      }
    }
    if (i) e.uid = ee(), e.sn = i.sn, e.specificationLabels = i.specificationLabels, e.serialNumber = i.serialNumber, e.classifySerialNumber = i.classify.serialNumber, e.classifyId = i.classify.id, e.classifyFullPathId = i.classify.fullPathId, e.classifyFullName = i.classify.fullName, e.classifyName = i.classify.name, e.classifyParentFullName = i.classify.parentFullName, e.basicClass = i.classify.basicClass, e.specification = i.spec, e.specificationMap = i.specKV, e.measureUnit = i.classify.measureUnit, e.accountingUnit = i.classify.accountingUnit, e.accountingPrecision = i.classify.accountingPrecision, e.measurePrecision = i.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = v(e.quantity, e.measurePrecision)), e.mete && (e.mete = v(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), e.basicClassifyName = e.basicClass + "_" + e.classifyName, e.isImport = true;
    else {
      const l = `${e.classifyName}下不存在规格为"${n}"的材料，请联系管理员/仓库人员添加`;
      f.some((t) => t.error === l) || f.push({ rowIndex: h.indexOf(e) + 1, error: l });
    }
  }
  if (f.length > 0) es(f);
  else return h;
} }, { handleMeteChangeCalcPrice: is } = re("weighingTotalWeight"), Te = _e[q.STEEL_PLATE.V];
function ss(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function as(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "钢板盘盈清单-错误清单", sheetName: "错误清单" });
}
const li = { title: "钢板盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Te.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Te.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Te.length.precision, excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", precision: Te.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: Te.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_14" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_15" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_16" }, { label: "归属项目", field: "deficitProjectName", excelField: "__EMPTY_17" }, { label: "备注", field: "remark", excelField: "__EMPTY_18" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], length: [{ required: true, message: "长度不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], diffQuantity: [{ validator: ss, message: "盘亏情况下数量需大于0" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }] }, format: async (u) => {
  var a;
  const _ = u.filter((i) => i.boolLoss === "是");
  if (!H(_, li.rules)) return;
  const P = await Ce();
  s.state.wms.loaded.steelDensityCfg || await s.dispatch("config/fetchSteelDensityCfg");
  const y = s.state.wms.steelDensityCfg;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const h = s.state.config.rawMatClsList.filter((i) => i.basicClass === q.STEEL_PLATE.V), m = s.state.config.rawMatClsKV, g = z(_), E = [];
  let b = [];
  const f = [], N = [], C = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const w = s.state.config.workshopNameV2, A = s.state.config.warehouseV2, V = s.state.project.projectAllType.map((i) => (i.fullName = G(i, null, false), i)), x = s.state.config.suppliers;
  g.forEach((i, n) => {
    let l = false;
    const t = J(i.classifyName.split("/"));
    if (t.length === 1) {
      const d = h.filter((r) => r.name === i.classifyName) || [];
      if (M(d)) if (d.length === 1) l = true, i.classifyId = d[0].id, E.push(d[0].id);
      else {
        const r = [];
        for (const p of d) if (p.isLeaf) for (let I = 0; I < p.fullPathId.length; I++) p.id !== p.fullPathId[I] && r.push(p.fullPathId[I]);
        const c = d.find((p) => O(p.parent) && !r.includes(p.id));
        if (M(c)) l = true, i.classifyId = c.id, E.push(c.id);
        else {
          const p = d.filter((I) => I.isLeaf) || [];
          if (p.length === 1) {
            let I = true;
            d.forEach((oe) => {
              p[0].fullPathId.includes(oe.id) || (I = false);
            }), I && (l = true, i.classifyId = p[0].id, E.push(p[0].id));
          } else for (const I of d) M(I.parent) && !r.includes(I.id) && f.push(I);
        }
      }
      f.length > 1 && C.push({ rowIndex: n + 1, error: `科目名称"${i.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const d of h) if (d.fullPathName.length >= t.length && X(d.fullPathName.slice(-t.length), t)) {
      l = true, i.classifyId = d.id, E.push(d.id);
      break;
    }
    l || (b.push(i.classifyName), N.some((d) => d.classifyName === i.classifyName) || N.push({ rowIndex: n + 1, classifyName: i.classifyName }));
    const o = q.STEEL_PLATE.V;
    Z(i, n, { workshopNameV2List: w, warehouseV2List: A, arr: V, errorList: C, supplierList: x, basicClass: o });
  }), b = Array.from(new Set(b)), b.length > 0 && (C.push({ rowIndex: N[0].rowIndex, error: `${N.map((i) => `"${i.classifyName}"`).join("、")}${N.length > 1 ? "等" : ""}物料种类不存在` }), N.shift());
  const T = s.state.config.classifySpec, e = [];
  for (let i = 0; i < E.length; i++) T[E[i]] === void 0 && !e.includes(E[i]) && e.push(E[i]);
  e.length > 0 && (e.forEach((i) => {
    T[i] = {};
  }), await s.dispatch("config/fetchMarClsSpec", e));
  for (const i of g) {
    if (((a = m == null ? void 0 : m[i.classifyId]) == null ? void 0 : a.isLeaf) === false) {
      C.push({ rowIndex: g.indexOf(i) + 1, error: `${i.classifyName}不是末级科目` });
      continue;
    }
    const n = T[i.classifyId];
    if ((n == null ? void 0 : n.hasUnitConfig) === false) {
      C.push({ rowIndex: g.indexOf(i) + 1, error: `${i.classifyName}未配置核算单位` });
      continue;
    }
    let l;
    const t = i.material ?? "";
    if (n && Array.isArray(n.specList)) {
      for (const o of n.specList) if (t === o.spec) {
        l = o;
        break;
      }
    }
    if (l) {
      i.uid = ee(), i.sn = l.sn, i.specificationLabels = l.specificationLabels, i.classifySerialNumber = l.classify.serialNumber, i.serialNumber = l.serialNumber, i.classifyId = l.classify.id, i.classifyFullName = l.classify.fullName, i.classifyName = l.classify.name, i.classifyParentFullName = l.classify.parentFullName, i.basicClass = l.classify.basicClass, i.specification = l.spec, i.specificationMap = l.specKV, i.measureUnit = l.classify.measureUnit, i.accountingUnit = l.classify.accountingUnit, i.accountingPrecision = l.classify.accountingPrecision, i.measurePrecision = l.classify.measurePrecision;
      let o = 0;
      for (const d in y) Number(d) === i.classifyId && (o = y[d]);
      i.steelDensity = o, i.theoryWeight = await He({ classifyId: i.classifyId, name: i.classifyFullName, length: i.length, width: i.width, thickness: i.thickness }), M(i.theoryWeight) && i.quantity ? i.theoryTotalWeight = v(i.theoryWeight * i.quantity, P[q.STEEL_PLATE.V].weight.precision) : i.theoryTotalWeight = void 0, i.weighingTotalWeight = i.theoryTotalWeight || i.weighingTotalWeight, i.mete = i.weighingTotalWeight, (!i.unitPrice || !i.amount) && is(i), i.basicClassifyName = i.basicClass + "_" + i.classifyName, i.isImport = true;
    } else {
      const o = `${i.classifyName}下不存在规格为"${t}"的材料，请联系管理员/仓库人员添加`;
      C.some((d) => d.error === o) || C.push({ rowIndex: g.indexOf(i) + 1, error: o });
      continue;
    }
  }
  if (C.length > 0) as(C);
  else return g;
} }, { handleMeteChangeCalcPrice: ts } = re("weighingTotalWeight"), Ye = _e[q.SECTION_STEEL.V];
function ls(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function cs(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "型材盘盈清单-错误清单", sheetName: "错误清单" });
}
const ci = { title: "型材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "规格", field: "specification", excelField: "__EMPTY_2" }, { label: "型材库标准", field: "profileLibraryStandard", excelField: "__EMPTY_3" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: Ye.length.precision, excelField: "__EMPTY_4" }, { label: "数量（根）", field: "quantity", type: "number", precision: Ye.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: Ye.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_14" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_15" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_16" }, { label: "归属项目", field: "deficitProjectName", excelField: "__EMPTY_17" }, { label: "备注", field: "remark", excelField: "__EMPTY_18" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "规格不能为空" }], length: [{ required: true, message: "定尺长度不能为空" }], quantity: [{ required: true, message: "数量不能为空" }], diffQuantity: [{ validator: ls, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }] }, format: async (u) => {
  var e, a;
  const _ = u.filter((i) => i.boolLoss === "是");
  if (!H(_, ci.rules)) return;
  const P = await Ce();
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const y = s.state.config.rawMatClsList.filter((i) => i.basicClass === q.SECTION_STEEL.V), h = s.state.config.rawMatClsKV, m = z(_), g = [];
  let E = [];
  const b = [], f = [], N = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const C = s.state.config.workshopNameV2, w = s.state.config.warehouseV2, j = s.state.project.projectAllType.map((i) => (i.fullName = G(i, null, false), i)), V = s.state.config.suppliers;
  m.forEach((i, n) => {
    let l = false;
    const t = J(i.classifyName.split("/"));
    if (t.length === 1) {
      const d = y.filter((r) => r.name === i.classifyName) || [];
      if (M(d)) if (d.length === 1) l = true, i.classifyId = d[0].id, g.push(d[0].id);
      else {
        const r = [];
        for (const p of d) if (p.isLeaf) for (let I = 0; I < p.fullPathId.length; I++) p.id !== p.fullPathId[I] && r.push(p.fullPathId[I]);
        const c = d.find((p) => O(p.parent) && !r.includes(p.id));
        if (M(c)) l = true, i.classifyId = c.id, g.push(c.id);
        else {
          const p = d.filter((I) => I.isLeaf) || [];
          if (p.length === 1) {
            let I = true;
            d.forEach((oe) => {
              p[0].fullPathId.includes(oe.id) || (I = false);
            }), I && (l = true, i.classifyId = p[0].id, g.push(p[0].id));
          } else for (const I of d) M(I.parent) && !r.includes(I.id) && b.push(I);
        }
      }
      b.length > 1 && N.push({ rowIndex: n + 1, error: `科目名称"${i.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const d of y) if (d.fullPathName.length >= t.length && X(d.fullPathName.slice(-t.length), t)) {
      l = true, i.classifyId = d.id, g.push(d.id);
      break;
    }
    l || (E.push(i.classifyName), f.some((d) => d.classifyName === i.classifyName) || f.push({ rowIndex: n + 1, classifyName: i.classifyName }));
    const o = q.SECTION_STEEL.V;
    Z(i, n, { workshopNameV2List: C, warehouseV2List: w, arr: j, errorList: N, supplierList: V, basicClass: o });
  }), E = Array.from(new Set(E)), E.length > 0 && (N.push({ rowIndex: f[0].rowIndex, error: `${f.map((i) => `"${i.classifyName}"`).join("、")}${f.length > 1 ? "等" : ""}物料种类不存在` }), f.shift());
  const x = s.state.config.classifySpec, T = [];
  for (let i = 0; i < g.length; i++) x[g[i]] === void 0 && !T.includes(g[i]) && T.push(g[i]);
  T.length > 0 && (T.forEach((i) => {
    x[i] = {};
  }), await s.dispatch("config/fetchMarClsSpec", T));
  for (const i of m) {
    if (((e = h == null ? void 0 : h[i.classifyId]) == null ? void 0 : e.isLeaf) === false) {
      N.push({ rowIndex: m.indexOf(i) + 1, error: `${i.classifyName}不是末级科目` });
      continue;
    }
    const n = x[i.classifyId];
    if ((n == null ? void 0 : n.hasUnitConfig) === false) {
      N.push({ rowIndex: m.indexOf(i) + 1, error: `${i.classifyName}未配置核算单位` });
      continue;
    }
    let l;
    const t = `${i.specification} * ${i.material}`;
    if (n && Array.isArray(n.specList)) {
      for (const o of n.specList) if (t === o.spec) {
        l = o;
        break;
      }
    }
    if (l) {
      const o = (a = l.nationalStandardOptions.find((c) => c.boolDefault === true)) == null ? void 0 : a.standardId;
      i.uid = ee(), i.sn = l.sn, i.specificationLabels = l.specificationLabels, i.serialNumber = l.serialNumber, i.classifySerialNumber = l.classify.serialNumber, i.classifyId = l.classify.id, i.classifyFullName = l.classify.fullName, i.classifyName = l.classify.name, i.classifyParentFullName = l.classify.parentFullName, i.basicClass = l.classify.basicClass, i.specification = l.spec.split("*").slice(0, -1).join("*"), i.specificationMap = l.specKV, i.measureUnit = l.classify.measureUnit, i.accountingUnit = l.classify.accountingUnit, i.accountingPrecision = l.classify.accountingPrecision, i.measurePrecision = l.classify.measurePrecision, i.unitWeight = l.unitWeight, i.nationalStandardOptions = l.nationalStandardOptions, i.standardId = o;
      let d;
      const r = [];
      for (const c in i.specificationMap) c.indexOf("standard") > -1 ? d = i.specificationMap[c] : r.push(i.specificationMap[c]);
      i.sectionSteelSpec = d, i.doNotSectionSteelSpec = r.join(" * "), i.theoryWeight = await ze({ length: i.length, unitWeight: i.unitWeight }), M(i.theoryWeight) && i.quantity ? i.theoryTotalWeight = v(i.theoryWeight * i.quantity, P[q.SECTION_STEEL.V].weight.precision) : i.theoryTotalWeight = void 0, i.weighingTotalWeight = i.weighingTotalWeight || i.theoryTotalWeight, i.mete = i.weighingTotalWeight, ns(i), (!i.unitPrice || !i.amount) && ts(i), i.basicClassifyName = i.basicClass + "_" + i.classifyName, i.isImport = true;
    } else {
      const o = `${i.classifyName}下不存在规格为"${t}"的材料，请联系管理员/仓库人员添加`;
      N.some((d) => d.error === o) || N.push({ rowIndex: m.indexOf(i) + 1, error: o });
      continue;
    }
  }
  if (N.length > 0) cs(N);
  else return m;
} };
function ns(u) {
  M(u.length) && u.quantity ? u.totalLength = Ge({ length: u.length, quantity: u.quantity }) : u.totalLength = void 0;
}
const { handleMeteChangeCalcPrice: rs } = re("weighingTotalWeight"), Me = _e[q.STEEL_COIL.V];
function os(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function fs(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "钢卷盘盈清单-错误清单", sheetName: "错误清单" });
}
const ni = { title: "钢卷盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Me.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Me.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Me.length.precision, excelField: "__EMPTY_4" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: Me.weight.precision, excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "卷号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_14" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_15" }, { label: "归属项目", field: "deficitProjectName", excelField: "__EMPTY_16" }, { label: "备注", field: "remark", excelField: "__EMPTY_17" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], weighingTotalWeight: [{ required: true, message: "总重不能为空" }], diffQuantity: [{ validator: os, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var e;
  const _ = u.filter((a) => a.boolLoss === "是");
  if (!H(_, ni.rules)) return;
  s.state.wms.loaded.steelDensityCfg || await s.dispatch("config/fetchSteelDensityCfg");
  const P = s.state.wms.steelDensityCfg;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const y = s.state.config.rawMatClsList.filter((a) => a.basicClass === q.STEEL_COIL.V), h = s.state.config.rawMatClsKV, m = z(_), g = [];
  let E = [];
  const b = [], f = [], N = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType");
  const C = s.state.config.workshopNameV2, w = s.state.config.warehouseV2, j = s.state.project.projectAllType.map((a) => (a.fullName = G(a, null, false), a)), V = s.state.config.suppliers;
  m.forEach((a, i) => {
    let n = false;
    const l = J(a.classifyName.split("/"));
    if (l.length === 1) {
      const o = y.filter((d) => d.name === a.classifyName) || [];
      if (M(o)) if (o.length === 1) n = true, a.classifyId = o[0].id, g.push(o[0].id);
      else {
        const d = [];
        for (const c of o) if (c.isLeaf) for (let p = 0; p < c.fullPathId.length; p++) c.id !== c.fullPathId[p] && d.push(c.fullPathId[p]);
        const r = o.find((c) => O(c.parent) && !d.includes(c.id));
        if (M(r)) n = true, a.classifyId = r.id, g.push(r.id);
        else {
          const c = o.filter((p) => p.isLeaf) || [];
          if (c.length === 1) {
            let p = true;
            o.forEach((I) => {
              c[0].fullPathId.includes(I.id) || (p = false);
            }), p && (n = true, a.classifyId = c[0].id, g.push(c[0].id));
          } else for (const p of o) M(p.parent) && !d.includes(p.id) && b.push(p);
        }
      }
      b.length > 1 && N.push({ rowIndex: i + 1, error: `科目名称"${a.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const o of y) if (o.fullPathName.length >= l.length && X(o.fullPathName.slice(-l.length), l)) {
      n = true, a.classifyId = o.id, g.push(o.id);
      break;
    }
    n || (E.push(a.classifyName), f.some((o) => o.classifyName === a.classifyName) || f.push({ rowIndex: i + 1, classifyName: a.classifyName }));
    const t = q.STEEL_COIL.V;
    Z(a, i, { workshopNameV2List: C, warehouseV2List: w, arr: j, errorList: N, supplierList: V, basicClass: t });
  }), E = Array.from(new Set(E)), E.length > 0 && (N.push({ rowIndex: f[0].rowIndex, error: `${f.map((a) => `"${a.classifyName}"`).join("、")}${f.length > 1 ? "等" : ""}物料种类不存在` }), f.shift());
  const x = s.state.config.classifySpec, T = [];
  for (let a = 0; a < g.length; a++) x[g[a]] === void 0 && !T.includes(g[a]) && T.push(g[a]);
  T.length > 0 && (T.forEach((a) => {
    x[a] = {};
  }), await s.dispatch("config/fetchMarClsSpec", T));
  for (const a of m) {
    if (((e = h == null ? void 0 : h[a.classifyId]) == null ? void 0 : e.isLeaf) === false) {
      N.push({ rowIndex: m.indexOf(a) + 1, error: `${a.classifyName}不是末级科目` });
      continue;
    }
    const i = x[a.classifyId];
    if ((i == null ? void 0 : i.hasUnitConfig) === false) {
      N.push({ rowIndex: m.indexOf(a) + 1, error: `${a.classifyName}未配置核算单位` });
      continue;
    }
    let n;
    const l = a.material ?? "";
    if (i && Array.isArray(i.specList)) {
      for (const t of i.specList) if (l === t.spec) {
        n = t;
        break;
      }
    }
    if (n) {
      a.uid = ee(), a.sn = n.sn, a.specificationLabels = n.specificationLabels, a.serialNumber = n.serialNumber, a.classifySerialNumber = n.classify.serialNumber, a.classifyId = n.classify.id, a.classifyFullName = n.classify.fullName, a.classifyName = n.classify.name, a.classifyParentFullName = n.classify.parentFullName, a.basicClass = n.classify.basicClass, a.specification = n.spec, a.specificationMap = n.specKV, a.measureUnit = n.classify.measureUnit, a.accountingUnit = n.classify.accountingUnit, a.accountingPrecision = n.classify.accountingPrecision, a.measurePrecision = n.classify.measurePrecision;
      let t = 0;
      for (const o in P) Number(o) === a.classifyId && (t = P[o]);
      a.steelDensity = t, await ds(a), a.length = a.length || a.theoryLength, (!a.unitPrice || !a.amount) && rs(a), a.mete = a.weighingTotalWeight, a.basicClassifyName = a.basicClass + "_" + a.classifyName, a.isImport = true;
    } else {
      const t = `${a.classifyName}下不存在规格为"${l}"的材料，请联系管理员/仓库人员添加`;
      N.some((o) => o.error === t) || N.push({ rowIndex: m.indexOf(a) + 1, error: t });
      continue;
    }
  }
  if (N.length > 0) fs(N);
  else return m;
} };
async function ds(u) {
  u.theoryLength = await Je({ classifyId: u.classifyId, name: u.classifyFullName, weight: u.weighingTotalWeight, width: u.width, thickness: u.thickness });
}
const { handleMeteChangeCalcPrice: us } = re("mete");
function ms(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function hs(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "其他钢材盘盈清单-错误清单", sheetName: "错误清单" });
}
const ri = { title: "其它钢材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_13" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_14" }, { label: "归属项目", field: "deficitProjectName", excelField: "__EMPTY_15" }, { label: "备注", field: "remark", excelField: "__EMPTY_16" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], diffQuantity: [{ validator: ms, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var T;
  const _ = u.filter((e) => e.boolLoss === "是");
  if (!H(_, ri.rules)) return;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const P = s.state.config.rawMatClsList.filter((e) => e.basicClass === ne.OTHER_STEEL_MATERIALS.V), y = s.state.config.rawMatClsKV, h = z(_), m = [];
  let g = [];
  const E = [], b = [], f = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const N = s.state.config.workshopNameV2, C = s.state.config.warehouseV2, A = s.state.project.projectAllType.map((e) => (e.fullName = G(e, null, false), e)), j = s.state.config.suppliers;
  h.forEach((e, a) => {
    let i = false;
    const n = J(e.classifyName.split("/"));
    if (n.length === 1) {
      const t = P.filter((o) => o.name === e.classifyName) || [];
      if (M(t)) if (t.length === 1) i = true, e.classifyId = t[0].id, m.push(t[0].id);
      else {
        const o = [];
        for (const r of t) if (r.isLeaf) for (let c = 0; c < r.fullPathId.length; c++) r.id !== r.fullPathId[c] && o.push(r.fullPathId[c]);
        const d = t.find((r) => O(r.parent) && !o.includes(r.id));
        if (M(d)) i = true, e.classifyId = d.id, m.push(d.id);
        else {
          const r = t.filter((c) => c.isLeaf) || [];
          if (r.length === 1) {
            let c = true;
            t.forEach((p) => {
              r[0].fullPathId.includes(p.id) || (c = false);
            }), c && (i = true, e.classifyId = r[0].id, m.push(r[0].id));
          } else for (const c of t) M(c.parent) && !o.includes(c.id) && E.push(c);
        }
      }
      E.length > 1 && f.push({ rowIndex: a + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const t of P) if (t.fullPathName.length >= n.length && X(t.fullPathName.slice(-n.length), n)) {
      i = true, e.classifyId = t.id, m.push(t.id);
      break;
    }
    i || (g.push(e.classifyName), b.some((t) => t.classifyName === e.classifyName) || b.push({ rowIndex: a + 1, classifyName: e.classifyName }));
    const l = ne.OTHER_STEEL_MATERIALS.V;
    Z(e, a, { workshopNameV2List: N, warehouseV2List: C, arr: A, errorList: f, supplierList: j, basicClass: l });
  }), g = Array.from(new Set(g)), g.length > 0 && (f.push({ rowIndex: b[0].rowIndex, error: `${b.map((e) => `"${e.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const V = s.state.config.classifySpec, x = [];
  for (let e = 0; e < m.length; e++) V[m[e]] === void 0 && !x.includes(m[e]) && x.push(m[e]);
  x.length > 0 && (x.forEach((e) => {
    V[e] = {};
  }), await s.dispatch("config/fetchMarClsSpec", x));
  for (const e of h) {
    if (((T = y == null ? void 0 : y[e.classifyId]) == null ? void 0 : T.isLeaf) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const a = V[e.classifyId];
    if ((a == null ? void 0 : a.hasUnitConfig) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let i;
    const n = e.specification ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const l of a.specList) if (n === l.spec) {
        if (i = l, e.measureUnit && (i.classify.measureUnit || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` }), !await Q(i.classify.measureUnit, e.measureUnit))) {
          f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${i.classify.measureUnit}”` });
          continue;
        }
        e.accountingUnit && (await Q(i.classify.accountingUnit, e.accountingUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${i.classify.accountingUnit}”` }));
        break;
      }
    }
    if (i) e.uid = ee(), e.sn = i.sn, e.specificationLabels = i.specificationLabels, e.serialNumber = i.serialNumber, e.classifySerialNumber = i.classify.serialNumber, e.classifyId = i.classify.id, e.classifyFullPathId = i.classify.fullPathId, e.classifyFullName = i.classify.fullName, e.classifyName = i.classify.name, e.classifyParentFullName = i.classify.parentFullName, e.basicClass = i.classify.basicClass, e.specification = i.spec, e.specificationMap = i.specKV, e.measureUnit = i.classify.measureUnit, e.accountingUnit = i.classify.accountingUnit, e.accountingPrecision = i.classify.accountingPrecision, e.measurePrecision = i.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = v(e.quantity, e.measurePrecision)), e.mete && (e.mete = v(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), (!e.unitPrice || !e.amount) && us(e), e.basicClassifyName = e.basicClass + "_" + e.classifyName, e.isImport = true;
    else {
      const l = `${e.classifyName}下不存在规格为"${n}"的材料，请联系管理员/仓库人员添加`;
      f.some((t) => t.error === l) || f.push({ rowIndex: h.indexOf(e) + 1, error: l });
    }
  }
  if (f.length > 0) hs(f);
  else return h;
} }, { handleMeteChangeCalcPrice: ps } = re("mete");
function ys(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function gs(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "辅材盘盈清单-错误清单", sheetName: "错误清单" });
}
const oi = { title: "辅材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_13" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_14" }, { label: "归属项目", field: "deficitProjectName", excelField: "__EMPTY_15" }, { label: "备注", field: "remark", excelField: "__EMPTY_16" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], diffQuantity: [{ validator: ys, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var T;
  const _ = u.filter((e) => e.boolLoss === "是");
  if (!H(_, oi.rules)) return;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const P = s.state.config.rawMatClsList.filter((e) => e.basicClass === ne.MATERIAL.V), y = s.state.config.rawMatClsKV, h = z(_), m = [];
  let g = [];
  const E = [], b = [], f = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const N = s.state.config.workshopNameV2, C = s.state.config.warehouseV2, A = s.state.project.projectAllType.map((e) => (e.fullName = G(e, null, false), e)), j = s.state.config.suppliers;
  h.forEach((e, a) => {
    let i = false;
    const n = J(e.classifyName.split("/"));
    if (n.length === 1) {
      const t = P.filter((o) => o.name === e.classifyName) || [];
      if (M(t)) if (t.length === 1) i = true, e.classifyId = t[0].id, m.push(t[0].id);
      else {
        const o = [];
        for (const r of t) if (r.isLeaf) for (let c = 0; c < r.fullPathId.length; c++) r.id !== r.fullPathId[c] && o.push(r.fullPathId[c]);
        const d = t.find((r) => O(r.parent) && !o.includes(r.id));
        if (M(d)) i = true, e.classifyId = d.id, m.push(d.id);
        else {
          const r = t.filter((c) => c.isLeaf) || [];
          if (r.length === 1) {
            let c = true;
            t.forEach((p) => {
              r[0].fullPathId.includes(p.id) || (c = false);
            }), c && (i = true, e.classifyId = r[0].id, m.push(r[0].id));
          } else for (const c of t) M(c.parent) && !o.includes(c.id) && E.push(c);
        }
      }
      E.length > 1 && f.push({ rowIndex: a + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const t of P) if (t.fullPathName.length >= n.length && X(t.fullPathName.slice(-n.length), n)) {
      i = true, e.classifyId = t.id, m.push(t.id);
      break;
    }
    i || (g.push(e.classifyName), b.some((t) => t.classifyName === e.classifyName) || b.push({ rowIndex: a + 1, classifyName: e.classifyName }));
    const l = ne.MATERIAL.V;
    Z(e, a, { workshopNameV2List: N, warehouseV2List: C, arr: A, errorList: f, supplierList: j, basicClass: l });
  }), g = Array.from(new Set(g)), g.length > 0 && (f.push({ rowIndex: b[0].rowIndex, error: `${b.map((e) => `"${e.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const V = s.state.config.classifySpec, x = [];
  for (let e = 0; e < m.length; e++) V[m[e]] === void 0 && !x.includes(m[e]) && x.push(m[e]);
  x.length > 0 && (x.forEach((e) => {
    V[e] = {};
  }), await s.dispatch("config/fetchMarClsSpec", x));
  for (const e of h) {
    if (((T = y == null ? void 0 : y[e.classifyId]) == null ? void 0 : T.isLeaf) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const a = V[e.classifyId];
    if ((a == null ? void 0 : a.hasUnitConfig) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let i;
    const n = e.specification ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const l of a.specList) if (n === l.spec) {
        i = l, e.measureUnit && (i.classify.measureUnit || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` }), await Q(i.classify.measureUnit, e.measureUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${i.classify.measureUnit}”` })), e.accountingUnit && (await Q(i.classify.accountingUnit, e.accountingUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${i.classify.accountingUnit}”` }));
        break;
      }
    }
    if (i) e.uid = ee(), e.sn = i.sn, e.specificationLabels = i.specificationLabels, e.serialNumber = i.serialNumber, e.classifySerialNumber = i.classify.serialNumber, e.classifyId = i.classify.id, e.classifyFullPathId = i.classify.fullPathId, e.classifyFullName = i.classify.fullName, e.classifyName = i.classify.name, e.classifyParentFullName = i.classify.parentFullName, e.basicClass = i.classify.basicClass, e.specification = i.spec, e.specificationMap = i.specKV, e.measureUnit = i.classify.measureUnit, e.accountingUnit = i.classify.accountingUnit, e.accountingPrecision = i.classify.accountingPrecision, e.measurePrecision = i.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = v(e.quantity, e.measurePrecision)), e.mete && (e.mete = v(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), (!e.unitPrice || !e.amount) && ps(e), e.basicClassifyName = e.basicClass + "_" + e.classifyName, e.isImport = true;
    else {
      const l = `${e.classifyName}下不存在规格为"${n}"的材料，请联系管理员/仓库人员添加`;
      f.some((t) => t.error === l) || f.push({ rowIndex: h.indexOf(e) + 1, error: l });
    }
  }
  if (f.length > 0) gs(f);
  else return h;
} };
function _s(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function bs(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "办公用品盘盈清单-错误清单", sheetName: "错误清单" });
}
const fi = { title: "办公用品盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_13" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_14" }, { label: "归属项目", field: "deficitProjectName", excelField: "__EMPTY_15" }, { label: "备注", field: "remark", excelField: "__EMPTY_16" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], diffQuantity: [{ validator: _s, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var T;
  const _ = u.filter((e) => e.boolLoss === "是");
  if (!H(_, fi.rules)) return;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const P = s.state.config.rawMatClsList.filter((e) => e.basicClass === q.OTHER.V), y = s.state.config.rawMatClsKV, h = z(_), m = [];
  let g = [];
  const E = [], b = [], f = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const N = s.state.config.workshopNameV2, C = s.state.config.warehouseV2, A = s.state.project.projectAllType.map((e) => (e.fullName = G(e, null, false), e)), j = s.state.config.suppliers;
  h.forEach((e, a) => {
    let i = false;
    const n = J(e.classifyName.split("/"));
    if (n.length === 1) {
      const t = P.filter((o) => o.name === e.classifyName) || [];
      if (M(t)) if (t.length === 1) i = true, e.classifyId = t[0].id, m.push(t[0].id);
      else {
        const o = [];
        for (const r of t) if (r.isLeaf) for (let c = 0; c < r.fullPathId.length; c++) r.id !== r.fullPathId[c] && o.push(r.fullPathId[c]);
        const d = t.find((r) => O(r.parent) && !o.includes(r.id));
        if (M(d)) i = true, e.classifyId = d.id, m.push(d.id);
        else {
          const r = t.filter((c) => c.isLeaf) || [];
          if (r.length === 1) {
            let c = true;
            t.forEach((p) => {
              r[0].fullPathId.includes(p.id) || (c = false);
            }), c && (i = true, e.classifyId = r[0].id, m.push(r[0].id));
          } else for (const c of t) M(c.parent) && !o.includes(c.id) && E.push(c);
        }
      }
      E.length > 1 && f.push({ rowIndex: a + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const t of P) if (t.fullPathName.length >= n.length && X(t.fullPathName.slice(-n.length), n)) {
      i = true, e.classifyId = t.id, m.push(t.id);
      break;
    }
    i || (g.push(e.classifyName), b.some((t) => t.classifyName === e.classifyName) || b.push({ rowIndex: a + 1, classifyName: e.classifyName }));
    const l = q.OTHER.V;
    Z(e, a, { workshopNameV2List: N, warehouseV2List: C, arr: A, errorList: f, supplierList: j, basicClass: l });
  }), g = Array.from(new Set(g)), g.length > 0 && (f.push({ rowIndex: b[0].rowIndex, error: `${b.map((e) => `"${e.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const V = s.state.config.classifySpec, x = [];
  for (let e = 0; e < m.length; e++) V[m[e]] === void 0 && !x.includes(m[e]) && x.push(m[e]);
  x.length > 0 && (x.forEach((e) => {
    V[e] = {};
  }), await s.dispatch("config/fetchMarClsSpec", x));
  for (const e of h) {
    if (((T = y == null ? void 0 : y[e.classifyId]) == null ? void 0 : T.isLeaf) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const a = V[e.classifyId];
    if ((a == null ? void 0 : a.hasUnitConfig) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let i;
    const n = e.specification ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const l of a.specList) if (n === l.spec) {
        i = l, e.measureUnit && (i.classify.measureUnit || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` }), await Q(i.classify.measureUnit, e.measureUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${i.classify.measureUnit}”` })), e.accountingUnit && (await Q(i.classify.accountingUnit, e.accountingUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${i.classify.accountingUnit}”` }));
        break;
      }
    }
    if (i) e.uid = ee(), e.sn = i.sn, e.specificationLabels = i.specificationLabels, e.serialNumber = i.serialNumber, e.classifySerialNumber = i.classify.serialNumber, e.classifyId = i.classify.id, e.classifyFullPathId = i.classify.fullPathId, e.classifyFullName = i.classify.fullName, e.classifyName = i.classify.name, e.classifyParentFullName = i.classify.parentFullName, e.basicClass = i.classify.basicClass, e.specification = i.spec, e.specificationMap = i.specKV, e.measureUnit = i.classify.measureUnit, e.accountingUnit = i.classify.accountingUnit, e.accountingPrecision = i.classify.accountingPrecision, e.measurePrecision = i.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = v(e.quantity, e.measurePrecision)), e.mete && (e.mete = v(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), e.basicClassifyName = e.basicClass + "_" + e.classifyName, e.isImport = true;
    else {
      const l = `${e.classifyName}下不存在规格为"${n}"的材料，请联系管理员/仓库人员添加`;
      f.some((t) => t.error === l) || f.push({ rowIndex: h.indexOf(e) + 1, error: l });
    }
  }
  if (f.length > 0) bs(f);
  else return h;
} };
function Ns(u, _) {
  return _.boolLoss === "是" ? Number(u) >= 0 : true;
}
function xs(u, _) {
  const F = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], P = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  K({ type: "error", title: "导入失败,请查看错误清单" }), ie({ headers: F, data: P, filename: "气体盘盈清单-错误清单", sheetName: "错误清单" });
}
const di = { title: "气体盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVAT", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }, { label: "是否盘亏", field: "boolLoss", excelField: "__EMPTY_13" }, { label: "盘亏数量", field: "diffQuantity", excelField: "__EMPTY_14" }, { label: "归属项目", field: "deficitProjectName", excelField: "__EMPTY_15" }, { label: "备注", field: "remark", excelField: "__EMPTY_16" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], diffQuantity: [{ validator: Ns, message: "盘亏情况下数量需大于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var T;
  const _ = u.filter((e) => e.boolLoss === "是");
  if (!H(_, di.rules)) return;
  s.state.config.loaded.matClsTree || await s.dispatch("config/fetchMatClsTree");
  const P = s.state.config.rawMatClsList.filter((e) => e.basicClass === ne.GAS.V), y = s.state.config.rawMatClsKV, h = z(_), m = [];
  let g = [];
  const E = [], b = [], f = [];
  s.state.config.loaded.workshopNameV2 || await s.dispatch("config/fetchWorkshopNameV2"), s.state.config.loaded.warehouseV2 || await s.dispatch("config/fetchWarehouseV2"), s.state.project.projectAllTypeLoaded || await s.dispatch("project/fetchProjectAllType"), s.state.config.loaded.suppliers || s.dispatch("config/fetchSuppliers");
  const N = s.state.config.workshopNameV2, C = s.state.config.warehouseV2, A = s.state.project.projectAllType.map((e) => (e.fullName = G(e, null, false), e)), j = s.state.config.suppliers;
  h.forEach((e, a) => {
    let i = false;
    const n = J(e.classifyName.split("/"));
    if (n.length === 1) {
      const t = P.filter((o) => o.name === e.classifyName) || [];
      if (M(t)) if (t.length === 1) i = true, e.classifyId = t[0].id, m.push(t[0].id);
      else {
        const o = [];
        for (const r of t) if (r.isLeaf) for (let c = 0; c < r.fullPathId.length; c++) r.id !== r.fullPathId[c] && o.push(r.fullPathId[c]);
        const d = t.find((r) => O(r.parent) && !o.includes(r.id));
        if (M(d)) i = true, e.classifyId = d.id, m.push(d.id);
        else {
          const r = t.filter((c) => c.isLeaf) || [];
          if (r.length === 1) {
            let c = true;
            t.forEach((p) => {
              r[0].fullPathId.includes(p.id) || (c = false);
            }), c && (i = true, e.classifyId = r[0].id, m.push(r[0].id));
          } else for (const c of t) M(c.parent) && !o.includes(c.id) && E.push(c);
        }
      }
      E.length > 1 && f.push({ rowIndex: a + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const t of P) if (t.fullPathName.length >= n.length && X(t.fullPathName.slice(-n.length), n)) {
      i = true, e.classifyId = t.id, m.push(t.id);
      break;
    }
    i || (g.push(e.classifyName), b.some((t) => t.classifyName === e.classifyName) || b.push({ rowIndex: a + 1, classifyName: e.classifyName }));
    const l = ne.GAS.V;
    Z(e, a, { workshopNameV2List: N, warehouseV2List: C, arr: A, errorList: f, supplierList: j, basicClass: l });
  }), g = Array.from(new Set(g)), g.length > 0 && (f.push({ rowIndex: b[0].rowIndex, error: `${b.map((e) => `"${e.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const V = s.state.config.classifySpec, x = [];
  for (let e = 0; e < m.length; e++) V[m[e]] === void 0 && !x.includes(m[e]) && x.push(m[e]);
  x.length > 0 && (x.forEach((e) => {
    V[e] = {};
  }), await s.dispatch("config/fetchMarClsSpec", x));
  for (const e of h) {
    if (((T = y == null ? void 0 : y[e.classifyId]) == null ? void 0 : T.isLeaf) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const a = V[e.classifyId];
    if ((a == null ? void 0 : a.hasUnitConfig) === false) {
      f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let i;
    const n = e.specification ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const l of a.specList) if (n === l.spec) {
        if (i = l, e.measureUnit && e.measureUnit !== "-") {
          if (!i.classify.measureUnit) {
            f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` });
            continue;
          }
          await Q(i.classify.measureUnit, e.measureUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${i.classify.measureUnit}”` });
        }
        e.accountingUnit && (await Q(i.classify.accountingUnit, e.accountingUnit) || f.push({ rowIndex: h.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${i.classify.accountingUnit}”` }));
        break;
      }
    }
    if (i) e.uid = ee(), e.sn = i.sn, e.specificationLabels = i.specificationLabels, e.serialNumber = i.serialNumber, e.classifySerialNumber = i.classify.serialNumber, e.classifyId = i.classify.id, e.classifyFullPathId = i.classify.fullPathId, e.classifyFullName = i.classify.fullName, e.classifyName = i.classify.name, e.classifyParentFullName = i.classify.parentFullName, e.basicClass = i.classify.basicClass, e.specification = i.spec, e.specificationMap = i.specKV, e.measureUnit = i.classify.measureUnit, e.accountingUnit = i.classify.accountingUnit, e.accountingPrecision = i.classify.accountingPrecision, e.measurePrecision = i.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = v(e.quantity, e.measurePrecision)), e.mete && (e.mete = v(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), e.basicClassifyName = e.basicClass + "_" + e.classifyName, e.isImport = true;
    else {
      const l = `${e.classifyName}下不存在规格为"${n}"的材料，请联系管理员/仓库人员添加`;
      f.some((t) => t.error === l) || f.push({ rowIndex: h.indexOf(e) + 1, error: l });
    }
  }
  if (f.length > 0) xs(f);
  else return h;
} };
const Ps = { class: "flex-rbc", style: { "margin-bottom": "10px" } }, Es = { style: { display: "flex" } }, Ts = { key: 0 }, Is = { class: "inventory" }, ws = { class: "right-box" }, Ls = { __name: "index", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["success", "update:modelValue"], setup(u, { emit: _ }) {
  const F = _, P = ui(), y = u, { inventoryLossCfg: h } = Pi(), m = te(), g = te(false), E = te(), b = te(false), f = te([]), { userProjectsMap: N } = Ei(), C = pe(() => N.value[Ti] || []), w = te({ currentBasicClass: Y.STEEL_PLATE.V, steelPlateList: [], sectionSteelList: [], steelCoilList: [], auxiliaryMaterialList: [], gasList: [], otherList: [], otherSteelMaterialList: [] }), A = te({});
  Ae("form", w), Ae("classifyNameInventory", A);
  const j = te([]);
  te(false);
  const V = [{ K: "steelPlateList", L: "钢板", V: Y.STEEL_PLATE.V, TABLE: We }, { K: "sectionSteelList", L: "型材", V: Y.SECTION_STEEL.V, TABLE: ve }, { K: "steelCoilList", L: "钢卷", V: Y.STEEL_COIL.V, TABLE: Re }, { K: "otherSteelMaterialList", L: "其它钢材", V: me.OTHER_STEEL_MATERIALS.V, TABLE: Be }, { K: "auxiliaryMaterialList", L: "辅材", V: Y.MATERIAL.V, TABLE: De }, { K: "gasList", L: "气体", V: Y.GAS.V, TABLE: Qe }, { K: "otherList", L: "其它", V: Y.OTHER.V, TABLE: Ke }], x = te({ 1: ["specification", "thickness", "width", "length", "brand", "heatNoAndBatchNo", "projectId", "warehouseId"], 2: ["specification", "length", "brand", "heatNoAndBatchNo", "projectId", "warehouseId"], 4: ["specification", "thickness", "width", "brand", "heatNoAndBatchNo", "projectId", "warehouseId"], 8: ["specification", "brand", "projectId", "color", "warehouseId"], 16: ["specification", "brand", "projectId", "warehouseId"], 128: ["specification", "brand", "projectId", "color", "warehouseId"], 256: ["specification", "brand", "projectId", "color", "warehouseId"] }), T = te({ specification: " 规格:", thickness: " 厚度:", width: " 宽度:", length: " 长度:", brand: " 品牌:", heatNoAndBatchNo: " 炉批号:", projectSerialNumber: " 所属项目合同编号:", warehouseName: " 仓库:", color: " 颜色:" }), e = mi({ steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null, auxiliaryMaterialList: null, gasList: null, otherList: null }), a = pe(() => "新增盘亏"), { maxHeight: i } = Ii({ mainBox: ".inventory-loss-application-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => pe(() => !g.value)), { visible: n, handleClose: l } = wi({ emit: F, props: y });
  $e(() => n, ($) => {
    var S;
    w.value = { currentBasicClass: Y.STEEL_PLATE.V, steelPlateList: [], sectionSteelList: [], steelCoilList: [], auxiliaryMaterialList: [], otherSteelMaterialList: [], gasList: [], otherList: [], deficitType: ((S = h.value) == null ? void 0 : S.inventoryType) || fe.COMPANY.V }, ke(() => {
      var U;
      const R = "steelPlateList";
      e[R] || (e[R] = E.value), (U = w.value[R]) == null || U.forEach((se) => {
        var W;
        return (W = te[R]) == null ? void 0 : W.rowWatch(se);
      });
    });
  }, { immediate: true, deep: true }), $e(() => w.value.currentBasicClass, ($) => {
    $ && ke(() => {
      var R;
      let S = "";
      switch ($) {
        case Y.STEEL_PLATE.V:
          S = "steelPlateList";
          break;
        case Y.SECTION_STEEL.V:
          S = "sectionSteelList";
          break;
        case Y.STEEL_COIL.V:
          S = "steelCoilList";
          break;
        case Y.MATERIAL.V:
          S = "auxiliaryMaterialList";
          break;
        case Y.GAS.V:
          S = "gasList";
          break;
        case Y.OTHER.V:
          S = "otherList";
          break;
        case me.OTHER_STEEL_MATERIALS.V:
          S = "otherSteelMaterialList";
          break;
      }
      e[S] || (e[S] = E.value), (R = w.value[S]) == null || R.forEach((U) => {
        var se;
        return (se = te[S]) == null ? void 0 : se.rowWatch(U);
      });
    });
  }, { immediate: true });
  const t = pe(() => {
    let $ = "";
    switch (w.value.currentBasicClass) {
      case Y.STEEL_PLATE.V:
        $ = "steelPlateList";
        break;
      case Y.SECTION_STEEL.V:
        $ = "sectionSteelList";
        break;
      case Y.STEEL_COIL.V:
        $ = "steelCoilList";
        break;
      case Y.MATERIAL.V:
        $ = "auxiliaryMaterialList";
        break;
      case Y.GAS.V:
        $ = "gasList";
        break;
      case Y.OTHER.V:
        $ = "otherList";
        break;
      case me.OTHER_STEEL_MATERIALS.V:
        $ = "otherSteelMaterialList";
        break;
    }
    return $;
  }), o = pe(() => {
    switch (w.value.currentBasicClass) {
      case Y.STEEL_PLATE.V:
        return w.value.deficitType === fe.PROJECT.V ? li : Xe;
      case Y.SECTION_STEEL.V:
        return w.value.deficitType === fe.PROJECT.V ? ci : Ze;
      case Y.STEEL_COIL.V:
        return w.value.deficitType === fe.PROJECT.V ? ni : ei;
      case me.OTHER_STEEL_MATERIALS.V:
        return w.value.deficitType === fe.PROJECT.V ? ri : ii;
      case Y.OTHER.V:
        return w.value.deficitType === fe.PROJECT.V ? fi : ai;
      case Y.GAS.V:
        return w.value.deficitType === fe.PROJECT.V ? di : ti;
      default:
        return w.value.deficitType === fe.PROJECT.V ? oi : si;
    }
  }), d = pe(() => {
    switch (w.value.currentBasicClass) {
      case Y.STEEL_PLATE.V:
        return We;
      case Y.SECTION_STEEL.V:
        return ve;
      case Y.STEEL_COIL.V:
        return Re;
      case me.OTHER_STEEL_MATERIALS.V:
        return Be;
      case Y.OTHER.V:
        return Ke;
      case Y.GAS.V:
        return Qe;
      default:
        return De;
    }
  });
  async function r($) {
    var be, Ne;
    if (O($)) return;
    j.value = [];
    const S = [], R = (be = $[0]) == null ? void 0 : be.basicClass, U = x.value[R];
    $.forEach((L) => {
      O(A.value[L.classifyName]) && (S.push(L.classifyName), A.value[L.classifyName] = []);
      for (let ce = 0; ce < U.length; ce++) L[U[ce]] = L[U[ce]] || "-";
    });
    const se = [];
    if (!O(S)) {
      const L = [], ce = await Vi({ basicClass: R, classifyNames: S });
      for (const de in ce) L.push(ce[de][0].classifyId), (Ne = ce[de]) == null || Ne.forEach((k) => {
        var xe, Pe;
        k.projectId = ((xe = k.project) == null ? void 0 : xe.id) || "-", k.warehouseId = ((Pe = k.warehouse) == null ? void 0 : Pe.id) || "-", k.basicClassifyName = R + "_" + k.classifyName, se.push(k);
      });
      M(L) && await P.dispatch("config/fetchFinalMatClsByIdList", L), await Fi(se), await Si(se, { toSmallest: false, toNum: true }), se.forEach((de) => {
        for (let k = 0; k < U.length; k++) de[U[k]] = de[U[k]] || "-";
        A.value[de.classifyName].push(de);
      });
    }
    const W = [], le = [];
    $ == null || $.forEach((L, ce) => {
      var xe, Pe;
      const k = (A.value[L.classifyName] || []).find((ae) => {
        let D = true;
        for (let Ie = 0; Ie < U.length; Ie++) L[U[Ie]] !== ae[U[Ie]] && (D = false);
        return D;
      });
      if (M(k)) if (((xe = w.value[t.value]) == null ? void 0 : xe.findIndex((ae) => ae.materialId === k.id)) > -1) {
        let ae = `${me.VL[k.basicClass]} ${k.classifyName}`;
        for (let D = 0; D < U.length; D++) U[D] === "warehouseId" ? ae += T.value.warehouseName + (L.warehouseName || "-") : U[D] === "projectId" ? ae += T.value.projectSerialNumber + (L.projectSerialNumber || "-") : ae += T.value[U[D]] + L[U[D]];
        le.push({ msg: `${ae}----表格已存在相同物料}` });
      } else L.quantity = k.quantity, L.mete = k.mete, L.materialId = k.id, L.factoryId = (Pe = k.factory) == null ? void 0 : Pe.id, L.operateQuantity = (k.quantity || 0) - (k.frozenQuantity || 0), L.operateMete = k.mete - (k.frozenMete || 0), L.outboundUnitType = k.outboundUnitType, L.maxQuantity = L.outboundUnitType === Se.MEASURE.V ? L.operateQuantity : L.operateMete, L.outboundUnitPrecision = L.outboundUnitType === Se.MEASURE.V ? L.measurePrecision : L.accountingPrecision, L.outboundUnit = L.outboundUnitType === Se.MEASURE.V ? L.measureUnit : L.accountingUnit, L.project = k.project, L.warehouse = k.warehouse, L.realTime = (/* @__PURE__ */ new Date()).getTime(), L.maxQuantity <= 0 ? L.diffQuantity = void 0 : L.diffQuantity = L.diffQuantity > L.maxQuantity ? L.maxQuantity : L.diffQuantity, W.push(L);
      else {
        let ae = `${me.VL[L.basicClass]} ${L.classifyName}`;
        for (let D = 0; D < U.length; D++) U[D] === "warehouseId" ? ae += T.value.warehouseName + (L.warehouseName || "-") : U[D] === "projectId" ? ae += T.value.projectSerialNumber + (L.projectSerialNumber || "-") : ae += T.value[U[D]] + L[U[D]];
        le.push({ msg: `${ae}----库存不存在这条物料` });
      }
    });
    let B = true;
    if (M(le)) {
      const L = le.map((ce) => `<div>${ce.msg}<div>`).join("");
      await bi.confirm("<div>异常导入明细如下,请确认！<div>" + L, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "排除异常数据继续导入", cancelButtonText: "取消导入" }).then(() => {
        B = true;
      }).catch((ce) => {
        B = false;
      });
    }
    if (!B) return false;
    W.forEach((L) => {
      M(w.value[t.value]) ? w.value[t.value].push(L) : w.value[t.value] = [L];
    });
  }
  function c() {
    return Object.keys(e).every(($) => e[$] ? e[$].validate() : true);
  }
  function p() {
    var S;
    if (!w.value.deficitType) {
      Fe.error("请选择成本归属");
      return;
    }
    if (f.value = [], O(w.value.steelPlateList) && O(w.value.sectionSteelList) && O(w.value.steelCoilList) && O(w.value.auxiliaryMaterialList) && O(w.value.gasList) && O(w.value.otherList) && O(w.value.otherSteelMaterialList)) return Fe.warning("请填写数据"), false;
    if (c()) {
      const R = ["steelPlateList", "sectionSteelList", "steelCoilList", "auxiliaryMaterialList", "gasList", "otherList", "otherSteelMaterialList"];
      for (let U = 0; U < R.length; U++) {
        const se = R[U];
        (S = w.value[se]) == null || S.forEach((W) => {
          W.diffQuantity && (W.isImport || (W.project = W.projectIdOptions.find((le) => le.id === W.projectId) || {}, W.warehouse = W.warehouseIdOptions.find((le) => le.id === W.warehouseId) || {}), W.deficitProjectId && (W.deficitProject = C.value.find((le) => le.id === W.deficitProjectId) || {}), f.value.push(W));
        });
      }
      f.value.length > 0 ? b.value = true : Fe.warning("请填写盘亏数据");
    }
  }
  function I() {
    var $;
    ($ = E.value) == null || $.addRow();
  }
  function oe() {
    l(), F("success");
  }
  return ($, S) => {
    const R = we("common-button"), U = we("common-radio-button"), se = we("common-radio"), W = Ni, le = we("common-drawer");
    return Ve(), je(le, { ref_key: "drawerRef", ref: m, modelValue: he(n), "onUpdate:modelValue": S[3] || (S[3] = (B) => _i(n) ? n.value = B : null), "content-loading": g.value, "before-close": he(l), title: a.value, "show-close": true, size: "100%", "custom-class": "inventory-loss-application-form" }, { titleRight: ye(() => [ue(R, { type: "primary", size: "default", onClick: p }, { default: ye(() => S[4] || (S[4] = [qe("提交预览")])), _: 1, __: [4] })]), content: ye(() => [ue(W, { class: "form" }, { default: ye(() => [ge("div", Ps, [ge("div", Es, [ue(U, { modelValue: w.value.currentBasicClass, "onUpdate:modelValue": S[0] || (S[0] = (B) => w.value.currentBasicClass = B), "data-structure": { key: "V", label: "L", value: "V" }, options: V, clearable: "", style: { "vertical-align": "middle", "margin-right": "6px" }, type: "other" }, { suffix: ye(({ item: B }) => {
      var be, Ne;
      return [w.value[B.K] && w.value[B.K].length && ((be = w.value[B.K]) != null && be.filter((L) => L.diffQuantity > 0).length) ? (Ve(), hi("span", Ts, "(" + Oe((Ne = w.value[B.K]) == null ? void 0 : Ne.filter((L) => L.diffQuantity > 0).length) + ")", 1)) : pi("", true)];
    }), _: 1 }, 8, ["modelValue"]), ge("div", Is, [S[5] || (S[5] = ge("div", { class: "left-box" }, " 成本归属 ", -1)), ge("div", ws, [ue(se, { modelValue: w.value.deficitType, "onUpdate:modelValue": S[1] || (S[1] = (B) => w.value.deficitType = B), options: he(fe).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])])])]), ge("div", null, [ue(Li, { fn: he(Mi), params: { basicClass: w.value.currentBasicClass, deficitType: w.value.deficitType } }, { default: ye(() => [qe(Oe(he(me).VL[w.value.currentBasicClass]) + "库存清单下载 ", 1)]), _: 1 }, 8, ["fn", "params"]), ue(Ci, { template: o.value, "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", icon: "el-icon-upload", "open-loading": "", style: { margin: "0 10px", "vertical-align": "middle" }, onSuccess: r }, null, 8, ["template"]), ue(R, { icon: "el-icon-plus", size: "default", type: "success", onClick: I })])]), (Ve(), je(yi(d.value), gi({ ref_key: "steelRef", ref: E, "max-height": he(i) }, $.$attrs), null, 16, ["max-height"]))]), _: 1 }), ue(he(Ui), { list: f.value, modelValue: b.value, "onUpdate:modelValue": S[2] || (S[2] = (B) => b.value = B), onSuccess: oe, form: w.value }, null, 8, ["list", "modelValue", "form"])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]);
  };
} }, js = xi(Ls, [["__scopeId", "data-v-e405b2e2"]]);
export {
  js as default
};

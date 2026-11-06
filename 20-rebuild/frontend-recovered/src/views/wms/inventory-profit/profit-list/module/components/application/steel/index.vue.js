import { ElNotification as q } from "element-plus";
import { ref as G } from "vue";
import { reactive as Fe } from "vue";
import { provide as ke } from "vue";
import { inject as Ye } from "vue";
import { computed as he } from "vue";
import { watch as me } from "vue";
import { nextTick as re } from "vue";
import { resolveComponent as pe } from "vue";
import { openBlock as ce } from "vue";
import { createElementBlock as ge } from "vue";
import { createElementVNode as se } from "vue";
import { renderSlot as $e } from "vue";
import { createVNode as W } from "vue";
import { withCtx as J } from "vue";
import { Fragment as ye } from "vue";
import { renderList as Ue } from "vue";
import { createTextVNode as oe } from "vue";
import { toDisplayString as fe } from "vue";
import { unref as U } from "vue";
import { ElRadioGroup as Ae } from "element-plus";
import { createBlock as We } from "vue";
import { resolveDynamicComponent as qe } from "vue";
import { normalizeStyle as je } from "vue";
import { ElRadioButton as ve } from "element-plus";
import { ElForm as Oe } from "element-plus";
import { rJ as X, am as L, vP as j, vQ as le, j as t, V as v, ku as O, z as R, vR as B, i as T, b as D, f3 as K, xy as H, aI as z, sT as Ne, iX as A, vS as ne, xz as Q, sU as be, v9 as xe, va as Pe, cP as $, vT as ae, o as _e, vv as Re, xO as Be, L as De, cQ as Ke, D as He } from "../../../../../../../../shared/runtime.js";
import ze from "./module/steel-plate-table.vue.js";
import Qe from "./module/section-steel-table.vue.js";
import Ge from "./module/steel-coil-table.vue.js";
import Je from "../other/module/other-steel-material-table.vue.js";
import "../price-set-columns.vue.js";
import "../../../../../../../../modules/supplier-select-0ce6adf5.js";
const { handleMeteChangeCalcPrice: Xe } = ne("weighingTotalWeight"), Z = X[L.STEEL_PLATE.V];
function Ze(u, M) {
  return Number(u) >= 0;
}
function es(u, M) {
  const b = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], x = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  q({ type: "error", title: "导入失败,请查看错误清单" }), Q({ headers: b, data: x, filename: "钢板盘盈清单-错误清单", sheetName: "错误清单" });
}
const Ee = { title: "钢板盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Z.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Z.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Z.length.precision, excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", precision: Z.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: Z.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_9" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "供应商", field: "supplierName", excelField: "__EMPTY_12" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_13" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_14" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_15" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], length: [{ required: true, message: "长度不能为空" }], quantity: [{ required: true, message: "数量不能为空" }], unitPrice: [{ required: true, message: "含税单价不能为空" }, { validator: Ze, message: "含税单价不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }] }, format: async (u) => {
  var i;
  if (!j(u, Ee.rules)) return;
  const b = await le();
  t.state.wms.loaded.steelDensityCfg || await t.dispatch("config/fetchSteelDensityCfg");
  const x = t.state.wms.steelDensityCfg;
  t.state.config.loaded.matClsTree || await t.dispatch("config/fetchMatClsTree");
  const y = t.state.config.rawMatClsList.filter((e) => e.basicClass === L.STEEL_PLATE.V), N = t.state.config.rawMatClsKV, g = v(u), _ = [];
  let P = [];
  const p = [], m = [], w = [];
  t.state.config.loaded.workshopNameV2 || await t.dispatch("config/fetchWorkshopNameV2"), t.state.config.loaded.warehouseV2 || await t.dispatch("config/fetchWarehouseV2"), t.state.project.loaded || await t.dispatch("project/fetchUserProjects"), t.state.config.loaded.suppliers || t.dispatch("config/fetchSuppliers");
  const C = t.state.config.workshopNameV2, Y = t.state.config.warehouseV2, S = t.state.project.userProjectsMap[O].map((e) => (e.fullName = R(e, null, false), e)), I = t.state.config.suppliers;
  g.forEach((e, r) => {
    let a = false;
    const c = B(e.classifyName.split("/"));
    if (c.length === 1) {
      const l = y.filter((h) => h.name === e.classifyName) || [];
      if (T(l)) if (l.length === 1) a = true, e.classifyId = l[0].id, _.push(l[0].id);
      else {
        const h = [];
        for (const o of l) if (o.isLeaf) for (let d = 0; d < o.fullPathId.length; d++) o.id !== o.fullPathId[d] && h.push(o.fullPathId[d]);
        const f = l.find((o) => D(o.parent) && !h.includes(o.id));
        if (T(f)) a = true, e.classifyId = f.id, _.push(f.id);
        else {
          const o = l.filter((d) => d.isLeaf) || [];
          if (o.length === 1) {
            let d = true;
            l.forEach((V) => {
              o[0].fullPathId.includes(V.id) || (d = false);
            }), d && (a = true, e.classifyId = o[0].id, _.push(o[0].id));
          } else for (const d of l) T(d.parent) && !h.includes(d.id) && p.push(d);
        }
      }
      p.length > 1 && w.push({ rowIndex: r + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const l of y) if (l.fullPathName.length >= c.length && K(l.fullPathName.slice(-c.length), c)) {
      a = true, e.classifyId = l.id, _.push(l.id);
      break;
    }
    a || (P.push(e.classifyName), m.some((l) => l.classifyName === e.classifyName) || m.push({ rowIndex: r + 1, classifyName: e.classifyName }));
    const n = L.STEEL_PLATE.V;
    H(e, r, { workshopNameV2List: C, warehouseV2List: Y, arr: S, errorList: w, supplierList: I, basicClass: n });
  }), P = Array.from(new Set(P)), P.length > 0 && (w.push({ rowIndex: m[0].rowIndex, error: `${m.map((e) => `"${e.classifyName}"`).join("、")}${m.length > 1 ? "等" : ""}物料种类不存在` }), m.shift());
  const E = t.state.config.classifySpec, s = [];
  for (let e = 0; e < _.length; e++) E[_[e]] === void 0 && !s.includes(_[e]) && s.push(_[e]);
  s.length > 0 && (s.forEach((e) => {
    E[e] = {};
  }), await t.dispatch("config/fetchMarClsSpec", s));
  for (const e of g) {
    if (((i = N == null ? void 0 : N[e.classifyId]) == null ? void 0 : i.isLeaf) === false) {
      w.push({ rowIndex: g.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const r = E[e.classifyId];
    if ((r == null ? void 0 : r.hasUnitConfig) === false) {
      w.push({ rowIndex: g.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let a;
    const c = e.material ?? "";
    if (r && Array.isArray(r.specList)) {
      for (const n of r.specList) if (c === n.spec) {
        a = n;
        break;
      }
    }
    if (a) {
      e.uid = z(), e.sn = a.sn, e.specificationLabels = a.specificationLabels, e.classifySerialNumber = a.classify.serialNumber, e.serialNumber = a.serialNumber, e.classifyId = a.classify.id, e.classifyFullName = a.classify.fullName, e.classifyName = a.classify.name, e.classifyParentFullName = a.classify.parentFullName, e.basicClass = a.classify.basicClass, e.specification = a.spec, e.specificationMap = a.specKV, e.measureUnit = a.classify.measureUnit, e.accountingUnit = a.classify.accountingUnit, e.accountingPrecision = a.classify.accountingPrecision, e.measurePrecision = a.classify.measurePrecision;
      let n = 0;
      for (const l in x) Number(l) === e.classifyId && (n = x[l]);
      e.steelDensity = n, e.theoryWeight = await Ne({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness }), T(e.theoryWeight) && e.quantity ? e.theoryTotalWeight = A(e.theoryWeight * e.quantity, b[L.STEEL_PLATE.V].weight.precision) : e.theoryTotalWeight = void 0, e.weighingTotalWeight = e.theoryTotalWeight || e.weighingTotalWeight, e.mete = e.weighingTotalWeight, (!e.unitPrice || !e.amount) && Xe(e);
    } else {
      const n = `${e.classifyName}下不存在规格为"${c}"的材料，请联系管理员/仓库人员添加`;
      w.some((l) => l.error === n) || w.push({ rowIndex: g.indexOf(e) + 1, error: n });
      continue;
    }
  }
  if (w.length > 0) es(w);
  else return g;
} }, { handleMeteChangeCalcPrice: ss } = ne("weighingTotalWeight"), de = X[L.SECTION_STEEL.V];
function is(u, M) {
  return Number(u) >= 0;
}
function ts(u, M) {
  const b = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], x = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  q({ type: "error", title: "导入失败,请查看错误清单" }), Q({ headers: b, data: x, filename: "型材盘盈清单-错误清单", sheetName: "错误清单" });
}
const we = { title: "型材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "规格", field: "specification", excelField: "__EMPTY_2" }, { label: "型材库标准", field: "profileLibraryStandard", excelField: "__EMPTY_3" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: de.length.precision, excelField: "__EMPTY_4" }, { label: "数量（根）", field: "quantity", type: "number", precision: de.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: de.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_9" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "供应商", field: "supplierName", excelField: "__EMPTY_12" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_13" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_14" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_15" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "规格不能为空" }], length: [{ required: true, message: "定尺长度不能为空" }], quantity: [{ required: true, message: "数量不能为空" }], unitPrice: [{ required: true, message: "含税单价不能为空" }, { validator: is, message: "含税单价不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }] }, format: async (u) => {
  var s, i;
  if (!j(u, we.rules)) return;
  const b = await le();
  t.state.config.loaded.matClsTree || await t.dispatch("config/fetchMatClsTree");
  const x = t.state.config.rawMatClsList.filter((e) => e.basicClass === L.SECTION_STEEL.V), y = t.state.config.rawMatClsKV, N = v(u), g = [];
  let _ = [];
  const P = [], p = [], m = [];
  t.state.config.loaded.workshopNameV2 || await t.dispatch("config/fetchWorkshopNameV2"), t.state.config.loaded.warehouseV2 || await t.dispatch("config/fetchWarehouseV2"), t.state.project.loaded || await t.dispatch("project/fetchUserProjects"), t.state.config.loaded.suppliers || t.dispatch("config/fetchSuppliers");
  const w = t.state.config.workshopNameV2, C = t.state.config.warehouseV2, k = t.state.project.userProjectsMap[O].map((e) => (e.fullName = R(e, null, false), e)), S = t.state.config.suppliers;
  N.forEach((e, r) => {
    let a = false;
    const c = B(e.classifyName.split("/"));
    if (c.length === 1) {
      const l = x.filter((h) => h.name === e.classifyName) || [];
      if (T(l)) if (l.length === 1) a = true, e.classifyId = l[0].id, g.push(l[0].id);
      else {
        const h = [];
        for (const o of l) if (o.isLeaf) for (let d = 0; d < o.fullPathId.length; d++) o.id !== o.fullPathId[d] && h.push(o.fullPathId[d]);
        const f = l.find((o) => D(o.parent) && !h.includes(o.id));
        if (T(f)) a = true, e.classifyId = f.id, g.push(f.id);
        else {
          const o = l.filter((d) => d.isLeaf) || [];
          if (o.length === 1) {
            let d = true;
            l.forEach((V) => {
              o[0].fullPathId.includes(V.id) || (d = false);
            }), d && (a = true, e.classifyId = o[0].id, g.push(o[0].id));
          } else for (const d of l) T(d.parent) && !h.includes(d.id) && P.push(d);
        }
      }
      P.length > 1 && m.push({ rowIndex: r + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const l of x) if (l.fullPathName.length >= c.length && K(l.fullPathName.slice(-c.length), c)) {
      a = true, e.classifyId = l.id, g.push(l.id);
      break;
    }
    a || (_.push(e.classifyName), p.some((l) => l.classifyName === e.classifyName) || p.push({ rowIndex: r + 1, classifyName: e.classifyName }));
    const n = L.SECTION_STEEL.V;
    H(e, r, { workshopNameV2List: w, warehouseV2List: C, arr: k, errorList: m, supplierList: S, basicClass: n });
  }), _ = Array.from(new Set(_)), _.length > 0 && (m.push({ rowIndex: p[0].rowIndex, error: `${p.map((e) => `"${e.classifyName}"`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在` }), p.shift());
  const I = t.state.config.classifySpec, E = [];
  for (let e = 0; e < g.length; e++) I[g[e]] === void 0 && !E.includes(g[e]) && E.push(g[e]);
  E.length > 0 && (E.forEach((e) => {
    I[e] = {};
  }), await t.dispatch("config/fetchMarClsSpec", E));
  for (const e of N) {
    if (((s = y == null ? void 0 : y[e.classifyId]) == null ? void 0 : s.isLeaf) === false) {
      m.push({ rowIndex: N.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const r = I[e.classifyId];
    if ((r == null ? void 0 : r.hasUnitConfig) === false) {
      m.push({ rowIndex: N.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let a;
    const c = `${e.specification} * ${e.material}`;
    if (r && Array.isArray(r.specList)) {
      for (const n of r.specList) if (c === n.spec) {
        a = n;
        break;
      }
    }
    if (a) {
      const n = (i = a.nationalStandardOptions.find((f) => f.boolDefault === true)) == null ? void 0 : i.standardId;
      e.uid = z(), e.sn = a.sn, e.specificationLabels = a.specificationLabels, e.serialNumber = a.serialNumber, e.classifySerialNumber = a.classify.serialNumber, e.classifyId = a.classify.id, e.classifyFullName = a.classify.fullName, e.classifyName = a.classify.name, e.classifyParentFullName = a.classify.parentFullName, e.basicClass = a.classify.basicClass, e.specification = a.spec.split("*").slice(0, -1).join("*"), e.specificationMap = a.specKV, e.measureUnit = a.classify.measureUnit, e.accountingUnit = a.classify.accountingUnit, e.accountingPrecision = a.classify.accountingPrecision, e.measurePrecision = a.classify.measurePrecision, e.unitWeight = a.unitWeight, e.nationalStandardOptions = a.nationalStandardOptions, e.standardId = n;
      let l;
      const h = [];
      for (const f in e.specificationMap) f.indexOf("standard") > -1 ? l = e.specificationMap[f] : h.push(e.specificationMap[f]);
      e.sectionSteelSpec = l, e.doNotSectionSteelSpec = h.join(" * "), e.theoryWeight = await be({ length: e.length, unitWeight: e.unitWeight }), T(e.theoryWeight) && e.quantity ? e.theoryTotalWeight = A(e.theoryWeight * e.quantity, b[L.SECTION_STEEL.V].weight.precision) : e.theoryTotalWeight = void 0, e.weighingTotalWeight = e.weighingTotalWeight || e.theoryTotalWeight, e.mete = e.weighingTotalWeight, as(e), (!e.unitPrice || !e.amount) && ss(e);
    } else {
      const n = `${e.classifyName}下不存在规格为"${c}"的材料，请联系管理员/仓库人员添加`;
      m.some((l) => l.error === n) || m.push({ rowIndex: N.indexOf(e) + 1, error: n });
      continue;
    }
  }
  if (m.length > 0) ts(m);
  else return N;
} };
function as(u) {
  T(u.length) && u.quantity ? u.totalLength = xe({ length: u.length, quantity: u.quantity }) : u.totalLength = void 0;
}
const { handleMeteChangeCalcPrice: ls } = ne("weighingTotalWeight"), ie = X[L.STEEL_COIL.V];
function ns(u, M) {
  return Number(u) >= 0;
}
function rs(u, M) {
  const b = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], x = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  q({ type: "error", title: "导入失败,请查看错误清单" }), Q({ headers: b, data: x, filename: "钢卷盘盈清单-错误清单", sheetName: "错误清单" });
}
const Ie = { title: "钢卷盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: ie.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: ie.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: ie.length.precision, excelField: "__EMPTY_4" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: ie.weight.precision, excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "卷号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_9" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "供应商", field: "supplierName", excelField: "__EMPTY_12" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_13" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_14" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], weighingTotalWeight: [{ required: true, message: "总重不能为空" }], unitPrice: [{ required: true, message: "含税单价不能为空" }, { validator: ns, message: "含税单价不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var s;
  if (!j(u, Ie.rules)) return;
  t.state.wms.loaded.steelDensityCfg || await t.dispatch("config/fetchSteelDensityCfg");
  const b = t.state.wms.steelDensityCfg;
  t.state.config.loaded.matClsTree || await t.dispatch("config/fetchMatClsTree"), t.state.config.loaded.suppliers || t.dispatch("config/fetchSuppliers");
  const x = t.state.config.rawMatClsList.filter((i) => i.basicClass === L.STEEL_COIL.V), y = t.state.config.rawMatClsKV, N = v(u), g = [];
  let _ = [];
  const P = [], p = [], m = [];
  t.state.config.loaded.workshopNameV2 || await t.dispatch("config/fetchWorkshopNameV2"), t.state.config.loaded.warehouseV2 || await t.dispatch("config/fetchWarehouseV2"), t.state.project.loaded || await t.dispatch("project/fetchUserProjects");
  const w = t.state.config.workshopNameV2, C = t.state.config.warehouseV2, k = t.state.project.userProjectsMap[O].map((i) => (i.fullName = R(i, null, false), i)), S = t.state.config.suppliers;
  N.forEach((i, e) => {
    let r = false;
    const a = B(i.classifyName.split("/"));
    if (a.length === 1) {
      const n = x.filter((l) => l.name === i.classifyName) || [];
      if (T(n)) if (n.length === 1) r = true, i.classifyId = n[0].id, g.push(n[0].id);
      else {
        const l = [];
        for (const f of n) if (f.isLeaf) for (let o = 0; o < f.fullPathId.length; o++) f.id !== f.fullPathId[o] && l.push(f.fullPathId[o]);
        const h = n.find((f) => D(f.parent) && !l.includes(f.id));
        if (T(h)) r = true, i.classifyId = h.id, g.push(h.id);
        else {
          const f = n.filter((o) => o.isLeaf) || [];
          if (f.length === 1) {
            let o = true;
            n.forEach((d) => {
              f[0].fullPathId.includes(d.id) || (o = false);
            }), o && (r = true, i.classifyId = f[0].id, g.push(f[0].id));
          } else for (const o of n) T(o.parent) && !l.includes(o.id) && P.push(o);
        }
      }
      P.length > 1 && m.push({ rowIndex: e + 1, error: `科目名称"${i.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const n of x) if (n.fullPathName.length >= a.length && K(n.fullPathName.slice(-a.length), a)) {
      r = true, i.classifyId = n.id, g.push(n.id);
      break;
    }
    r || (_.push(i.classifyName), p.some((n) => n.classifyName === i.classifyName) || p.push({ rowIndex: e + 1, classifyName: i.classifyName }));
    const c = L.STEEL_COIL.V;
    H(i, e, { workshopNameV2List: w, warehouseV2List: C, arr: k, errorList: m, supplierList: S, basicClass: c });
  }), _ = Array.from(new Set(_)), _.length > 0 && (m.push({ rowIndex: p[0].rowIndex, error: `${p.map((i) => `"${i.classifyName}"`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在` }), p.shift());
  const I = t.state.config.classifySpec, E = [];
  for (let i = 0; i < g.length; i++) I[g[i]] === void 0 && !E.includes(g[i]) && E.push(g[i]);
  E.length > 0 && (E.forEach((i) => {
    I[i] = {};
  }), await t.dispatch("config/fetchMarClsSpec", E));
  for (const i of N) {
    if (((s = y == null ? void 0 : y[i.classifyId]) == null ? void 0 : s.isLeaf) === false) {
      m.push({ rowIndex: N.indexOf(i) + 1, error: `${i.classifyName}不是末级科目` });
      continue;
    }
    const e = I[i.classifyId];
    if ((e == null ? void 0 : e.hasUnitConfig) === false) {
      m.push({ rowIndex: N.indexOf(i) + 1, error: `${i.classifyName}未配置核算单位` });
      continue;
    }
    let r;
    const a = i.material ?? "";
    if (e && Array.isArray(e.specList)) {
      for (const c of e.specList) if (a === c.spec) {
        r = c;
        break;
      }
    }
    if (r) {
      i.uid = z(), i.sn = r.sn, i.specificationLabels = r.specificationLabels, i.serialNumber = r.serialNumber, i.classifySerialNumber = r.classify.serialNumber, i.classifyId = r.classify.id, i.classifyFullName = r.classify.fullName, i.classifyName = r.classify.name, i.classifyParentFullName = r.classify.parentFullName, i.basicClass = r.classify.basicClass, i.specification = r.spec, i.specificationMap = r.specKV, i.measureUnit = r.classify.measureUnit, i.accountingUnit = r.classify.accountingUnit, i.accountingPrecision = r.classify.accountingPrecision, i.measurePrecision = r.classify.measurePrecision;
      let c = 0;
      for (const n in b) Number(n) === i.classifyId && (c = b[n]);
      i.steelDensity = c, await cs(i), i.length = i.length || i.theoryLength, (!i.unitPrice || !i.amount) && ls(i), i.mete = i.weighingTotalWeight;
    } else {
      const c = `${i.classifyName}下不存在规格为"${a}"的材料，请联系管理员/仓库人员添加`;
      m.some((n) => n.error === c) || m.push({ rowIndex: N.indexOf(i) + 1, error: c });
      continue;
    }
  }
  if (m.length > 0) rs(m);
  else return N;
} };
async function cs(u) {
  u.theoryLength = await Pe({ classifyId: u.classifyId, name: u.classifyFullName, weight: u.weighingTotalWeight, width: u.width, thickness: u.thickness });
}
const { handleMeteChangeCalcPrice: os } = ne("mete");
function fs(u, M) {
  return Number(u) >= 0;
}
function ds(u, M) {
  const b = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], x = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  q({ type: "error", title: "导入失败,请查看错误清单" }), Q({ headers: b, data: x, filename: "其他钢材盘盈清单-错误清单", sheetName: "错误清单" });
}
const Te = { title: "其它钢材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "供应商", field: "supplierName", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], unitPrice: [{ required: true, message: "含税单价不能为空" }, { validator: fs, message: "含税单价不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var E;
  if (!j(u, Te.rules)) return;
  t.state.config.loaded.matClsTree || await t.dispatch("config/fetchMatClsTree");
  const b = t.state.config.rawMatClsList.filter((s) => s.basicClass === $.OTHER_STEEL_MATERIALS.V), x = t.state.config.rawMatClsKV, y = v(u), N = [];
  let g = [];
  const _ = [], P = [], p = [];
  t.state.config.loaded.workshopNameV2 || await t.dispatch("config/fetchWorkshopNameV2"), t.state.config.loaded.warehouseV2 || await t.dispatch("config/fetchWarehouseV2"), t.state.project.loaded || await t.dispatch("project/fetchUserProjects"), t.state.config.loaded.suppliers || t.dispatch("config/fetchSuppliers");
  const m = t.state.project.userProjectsMap, w = t.state.config.workshopNameV2, C = t.state.config.warehouseV2, Y = m[O].map((s) => (s.fullName = R(s, null, false), s)), k = t.state.config.suppliers;
  y.forEach((s, i) => {
    let e = false;
    const r = B(s.classifyName.split("/"));
    if (r.length === 1) {
      const c = b.filter((n) => n.name === s.classifyName) || [];
      if (T(c)) if (c.length === 1) e = true, s.classifyId = c[0].id, N.push(c[0].id);
      else {
        const n = [];
        for (const h of c) if (h.isLeaf) for (let f = 0; f < h.fullPathId.length; f++) h.id !== h.fullPathId[f] && n.push(h.fullPathId[f]);
        const l = c.find((h) => D(h.parent) && !n.includes(h.id));
        if (T(l)) e = true, s.classifyId = l.id, N.push(l.id);
        else {
          const h = c.filter((f) => f.isLeaf) || [];
          if (h.length === 1) {
            let f = true;
            c.forEach((o) => {
              h[0].fullPathId.includes(o.id) || (f = false);
            }), f && (e = true, s.classifyId = h[0].id, N.push(h[0].id));
          } else for (const f of c) T(f.parent) && !n.includes(f.id) && _.push(f);
        }
      }
      _.length > 1 && p.push({ rowIndex: i + 1, error: `科目名称"${s.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const c of b) if (c.fullPathName.length >= r.length && K(c.fullPathName.slice(-r.length), r)) {
      e = true, s.classifyId = c.id, N.push(c.id);
      break;
    }
    e || (g.push(s.classifyName), P.some((c) => c.classifyName === s.classifyName) || P.push({ rowIndex: i + 1, classifyName: s.classifyName }));
    const a = $.OTHER_STEEL_MATERIALS.V;
    H(s, i, { workshopNameV2List: w, warehouseV2List: C, arr: Y, errorList: p, supplierList: k, basicClass: a });
  }), g = Array.from(new Set(g)), g.length > 0 && (p.push({ rowIndex: P[0].rowIndex, error: `${P.map((s) => `"${s.classifyName}"`).join("、")}${P.length > 1 ? "等" : ""}物料种类不存在` }), P.shift());
  const S = t.state.config.classifySpec, I = [];
  for (let s = 0; s < N.length; s++) S[N[s]] === void 0 && !I.includes(N[s]) && I.push(N[s]);
  I.length > 0 && (I.forEach((s) => {
    S[s] = {};
  }), await t.dispatch("config/fetchMarClsSpec", I));
  for (const s of y) {
    if (((E = x == null ? void 0 : x[s.classifyId]) == null ? void 0 : E.isLeaf) === false) {
      p.push({ rowIndex: y.indexOf(s) + 1, error: `${s.classifyName}不是末级科目` });
      continue;
    }
    const i = S[s.classifyId];
    if ((i == null ? void 0 : i.hasUnitConfig) === false) {
      p.push({ rowIndex: y.indexOf(s) + 1, error: `${s.classifyName}未配置核算单位` });
      continue;
    }
    let e;
    const r = s.specification ?? "";
    if (i && Array.isArray(i.specList)) {
      for (const a of i.specList) if (r === a.spec) {
        if (e = a, s.measureUnit && (e.classify.measureUnit || p.push({ rowIndex: y.indexOf(s) + 1, error: `${s.classifyName}不存在计量单位` }), !await ae(e.classify.measureUnit, s.measureUnit))) {
          p.push({ rowIndex: y.indexOf(s) + 1, error: `${s.classifyName}填写的计量单位错误，单位应为：“${e.classify.measureUnit}”` });
          continue;
        }
        s.accountingUnit && (await ae(e.classify.accountingUnit, s.accountingUnit) || p.push({ rowIndex: y.indexOf(s) + 1, error: `${s.classifyName}填写的核算单位错误，单位应为：“${e.classify.accountingUnit}”` }));
        break;
      }
    }
    if (e) s.uid = z(), s.sn = e.sn, s.specificationLabels = e.specificationLabels, s.serialNumber = e.serialNumber, s.classifySerialNumber = e.classify.serialNumber, s.classifyId = e.classify.id, s.classifyFullPathId = e.classify.fullPathId, s.classifyFullName = e.classify.fullName, s.classifyName = e.classify.name, s.classifyParentFullName = e.classify.parentFullName, s.basicClass = e.classify.basicClass, s.specification = e.spec, s.specificationMap = e.specKV, s.measureUnit = e.classify.measureUnit, s.accountingUnit = e.classify.accountingUnit, s.accountingPrecision = e.classify.accountingPrecision, s.measurePrecision = e.classify.measurePrecision, s.measureUnit || (s.quantity = void 0), s.quantity && (s.quantity = A(s.quantity, s.measurePrecision)), s.mete && (s.mete = A(s.mete, s.accountingPrecision)), s.measureUnit || (s.quantity = void 0), (!s.unitPrice || !s.amount) && os(s);
    else {
      const a = `${s.classifyName}下不存在规格为"${r}"的材料，请联系管理员/仓库人员添加`;
      p.some((c) => c.error === a) || p.push({ rowIndex: y.indexOf(s) + 1, error: a });
    }
  }
  if (p.length > 0) ds(p);
  else return y;
} }, ee = X[L.STEEL_PLATE.V];
function us(u, M) {
  const b = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], x = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  q({ type: "error", title: "导入失败,请查看错误清单" }), Q({ headers: b, data: x, filename: "钢板盘盈清单-错误清单", sheetName: "错误清单" });
}
const Le = { title: "钢板盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: ee.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: ee.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: ee.length.precision, excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", precision: ee.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: ee.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_9" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_10" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_11" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_12" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], length: [{ required: true, message: "长度不能为空" }], quantity: [{ required: true, message: "数量不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }] }, format: async (u) => {
  var i;
  if (!j(u, Le.rules)) return;
  const b = await le();
  t.state.wms.loaded.steelDensityCfg || await t.dispatch("config/fetchSteelDensityCfg");
  const x = t.state.wms.steelDensityCfg;
  t.state.config.loaded.matClsTree || await t.dispatch("config/fetchMatClsTree");
  const y = t.state.config.rawMatClsList.filter((e) => e.basicClass === L.STEEL_PLATE.V), N = t.state.config.rawMatClsKV, g = v(u), _ = [];
  let P = [];
  const p = [], m = [], w = [];
  t.state.config.loaded.workshopNameV2 || await t.dispatch("config/fetchWorkshopNameV2"), t.state.config.loaded.warehouseV2 || await t.dispatch("config/fetchWarehouseV2"), t.state.project.loaded || await t.dispatch("project/fetchUserProjects"), t.state.config.loaded.suppliers || t.dispatch("config/fetchSuppliers");
  const C = t.state.config.workshopNameV2, Y = t.state.config.warehouseV2, S = t.state.project.userProjectsMap[O].map((e) => (e.fullName = R(e, null, false), e)), I = t.state.config.suppliers;
  g.forEach((e, r) => {
    let a = false;
    const c = B(e.classifyName.split("/"));
    if (c.length === 1) {
      const l = y.filter((h) => h.name === e.classifyName) || [];
      if (T(l)) if (l.length === 1) a = true, e.classifyId = l[0].id, _.push(l[0].id);
      else {
        const h = [];
        for (const o of l) if (o.isLeaf) for (let d = 0; d < o.fullPathId.length; d++) o.id !== o.fullPathId[d] && h.push(o.fullPathId[d]);
        const f = l.find((o) => D(o.parent) && !h.includes(o.id));
        if (T(f)) a = true, e.classifyId = f.id, _.push(f.id);
        else {
          const o = l.filter((d) => d.isLeaf) || [];
          if (o.length === 1) {
            let d = true;
            l.forEach((V) => {
              o[0].fullPathId.includes(V.id) || (d = false);
            }), d && (a = true, e.classifyId = o[0].id, _.push(o[0].id));
          } else for (const d of l) T(d.parent) && !h.includes(d.id) && p.push(d);
        }
      }
      p.length > 1 && w.push({ rowIndex: r + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const l of y) if (l.fullPathName.length >= c.length && K(l.fullPathName.slice(-c.length), c)) {
      a = true, e.classifyId = l.id, _.push(l.id);
      break;
    }
    a || (P.push(e.classifyName), m.some((l) => l.classifyName === e.classifyName) || m.push({ rowIndex: r + 1, classifyName: e.classifyName }));
    const n = L.STEEL_PLATE.V;
    H(e, r, { workshopNameV2List: C, warehouseV2List: Y, arr: S, errorList: w, supplierList: I, basicClass: n });
  }), P = Array.from(new Set(P)), P.length > 0 && (w.push({ rowIndex: m[0].rowIndex, error: `${m.map((e) => `"${e.classifyName}"`).join("、")}${m.length > 1 ? "等" : ""}物料种类不存在` }), m.shift());
  const E = t.state.config.classifySpec, s = [];
  for (let e = 0; e < _.length; e++) E[_[e]] === void 0 && !s.includes(_[e]) && s.push(_[e]);
  s.length > 0 && (s.forEach((e) => {
    E[e] = {};
  }), await t.dispatch("config/fetchMarClsSpec", s));
  for (const e of g) {
    if (((i = N == null ? void 0 : N[e.classifyId]) == null ? void 0 : i.isLeaf) === false) {
      w.push({ rowIndex: g.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const r = E[e.classifyId];
    if ((r == null ? void 0 : r.hasUnitConfig) === false) {
      w.push({ rowIndex: g.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let a;
    const c = e.material ?? "";
    if (r && Array.isArray(r.specList)) {
      for (const n of r.specList) if (c === n.spec) {
        a = n;
        break;
      }
    }
    if (a) {
      e.uid = z(), e.sn = a.sn, e.specificationLabels = a.specificationLabels, e.classifySerialNumber = a.classify.serialNumber, e.serialNumber = a.serialNumber, e.classifyId = a.classify.id, e.classifyFullName = a.classify.fullName, e.classifyName = a.classify.name, e.classifyParentFullName = a.classify.parentFullName, e.basicClass = a.classify.basicClass, e.specification = a.spec, e.specificationMap = a.specKV, e.measureUnit = a.classify.measureUnit, e.accountingUnit = a.classify.accountingUnit, e.accountingPrecision = a.classify.accountingPrecision, e.measurePrecision = a.classify.measurePrecision;
      let n = 0;
      for (const l in x) Number(l) === e.classifyId && (n = x[l]);
      e.steelDensity = n, e.theoryWeight = await Ne({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness }), T(e.theoryWeight) && e.quantity ? e.theoryTotalWeight = A(e.theoryWeight * e.quantity, b[L.STEEL_PLATE.V].weight.precision) : e.theoryTotalWeight = void 0, e.weighingTotalWeight = e.theoryTotalWeight || e.weighingTotalWeight, e.mete = e.weighingTotalWeight;
    } else {
      const n = `${e.classifyName}下不存在规格为"${c}"的材料，请联系管理员/仓库人员添加`;
      w.some((l) => l.error === n) || w.push({ rowIndex: g.indexOf(e) + 1, error: n });
      continue;
    }
  }
  if (w.length > 0) us(w);
  else return g;
} }, ue = X[L.SECTION_STEEL.V];
function hs(u, M) {
  const b = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], x = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  q({ type: "error", title: "导入失败,请查看错误清单" }), Q({ headers: b, data: x, filename: "型材盘盈清单-错误清单", sheetName: "错误清单" });
}
const Me = { title: "型材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "规格", field: "specification", excelField: "__EMPTY_2" }, { label: "型材库标准", field: "profileLibraryStandard", excelField: "__EMPTY_3" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: ue.length.precision, excelField: "__EMPTY_4" }, { label: "数量（根）", field: "quantity", type: "number", precision: ue.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: ue.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_9" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_10" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_11" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_12" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "规格不能为空" }], length: [{ required: true, message: "定尺长度不能为空" }], quantity: [{ required: true, message: "数量不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }] }, format: async (u) => {
  var s, i;
  if (!j(u, Me.rules)) return;
  const b = await le();
  t.state.config.loaded.matClsTree || await t.dispatch("config/fetchMatClsTree");
  const x = t.state.config.rawMatClsList.filter((e) => e.basicClass === L.SECTION_STEEL.V), y = t.state.config.rawMatClsKV, N = v(u), g = [];
  let _ = [];
  const P = [], p = [], m = [];
  t.state.config.loaded.workshopNameV2 || await t.dispatch("config/fetchWorkshopNameV2"), t.state.config.loaded.warehouseV2 || await t.dispatch("config/fetchWarehouseV2"), t.state.project.loaded || await t.dispatch("project/fetchUserProjects"), t.state.config.loaded.suppliers || t.dispatch("config/fetchSuppliers");
  const w = t.state.config.workshopNameV2, C = t.state.config.warehouseV2, k = t.state.project.userProjectsMap[O].map((e) => (e.fullName = R(e, null, false), e)), S = t.state.config.suppliers;
  N.forEach((e, r) => {
    let a = false;
    const c = B(e.classifyName.split("/"));
    if (c.length === 1) {
      const l = x.filter((h) => h.name === e.classifyName) || [];
      if (T(l)) if (l.length === 1) a = true, e.classifyId = l[0].id, g.push(l[0].id);
      else {
        const h = [];
        for (const o of l) if (o.isLeaf) for (let d = 0; d < o.fullPathId.length; d++) o.id !== o.fullPathId[d] && h.push(o.fullPathId[d]);
        const f = l.find((o) => D(o.parent) && !h.includes(o.id));
        if (T(f)) a = true, e.classifyId = f.id, g.push(f.id);
        else {
          const o = l.filter((d) => d.isLeaf) || [];
          if (o.length === 1) {
            let d = true;
            l.forEach((V) => {
              o[0].fullPathId.includes(V.id) || (d = false);
            }), d && (a = true, e.classifyId = o[0].id, g.push(o[0].id));
          } else for (const d of l) T(d.parent) && !h.includes(d.id) && P.push(d);
        }
      }
      P.length > 1 && m.push({ rowIndex: r + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const l of x) if (l.fullPathName.length >= c.length && K(l.fullPathName.slice(-c.length), c)) {
      a = true, e.classifyId = l.id, g.push(l.id);
      break;
    }
    a || (_.push(e.classifyName), p.some((l) => l.classifyName === e.classifyName) || p.push({ rowIndex: r + 1, classifyName: e.classifyName }));
    const n = L.SECTION_STEEL.V;
    H(e, r, { workshopNameV2List: w, warehouseV2List: C, arr: k, errorList: m, supplierList: S, basicClass: n });
  }), _ = Array.from(new Set(_)), _.length > 0 && (m.push({ rowIndex: p[0].rowIndex, error: `${p.map((e) => `"${e.classifyName}"`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在` }), p.shift());
  const I = t.state.config.classifySpec, E = [];
  for (let e = 0; e < g.length; e++) I[g[e]] === void 0 && !E.includes(g[e]) && E.push(g[e]);
  E.length > 0 && (E.forEach((e) => {
    I[e] = {};
  }), await t.dispatch("config/fetchMarClsSpec", E));
  for (const e of N) {
    if (((s = y == null ? void 0 : y[e.classifyId]) == null ? void 0 : s.isLeaf) === false) {
      m.push({ rowIndex: N.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const r = I[e.classifyId];
    if ((r == null ? void 0 : r.hasUnitConfig) === false) {
      m.push({ rowIndex: N.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let a;
    const c = `${e.specification} * ${e.material}`;
    if (r && Array.isArray(r.specList)) {
      for (const n of r.specList) if (c === n.spec) {
        a = n;
        break;
      }
    }
    if (a) {
      const n = (i = a.nationalStandardOptions.find((f) => f.boolDefault === true)) == null ? void 0 : i.standardId;
      e.uid = z(), e.sn = a.sn, e.specificationLabels = a.specificationLabels, e.serialNumber = a.serialNumber, e.classifySerialNumber = a.classify.serialNumber, e.classifyId = a.classify.id, e.classifyFullName = a.classify.fullName, e.classifyName = a.classify.name, e.classifyParentFullName = a.classify.parentFullName, e.basicClass = a.classify.basicClass, e.specification = a.spec.split("*").slice(0, -1).join("*"), e.specificationMap = a.specKV, e.measureUnit = a.classify.measureUnit, e.accountingUnit = a.classify.accountingUnit, e.accountingPrecision = a.classify.accountingPrecision, e.measurePrecision = a.classify.measurePrecision, e.unitWeight = a.unitWeight, e.nationalStandardOptions = a.nationalStandardOptions, e.standardId = n;
      let l;
      const h = [];
      for (const f in e.specificationMap) f.indexOf("standard") > -1 ? l = e.specificationMap[f] : h.push(e.specificationMap[f]);
      e.sectionSteelSpec = l, e.doNotSectionSteelSpec = h.join(" * "), e.theoryWeight = await be({ length: e.length, unitWeight: e.unitWeight }), T(e.theoryWeight) && e.quantity ? e.theoryTotalWeight = A(e.theoryWeight * e.quantity, b[L.SECTION_STEEL.V].weight.precision) : e.theoryTotalWeight = void 0, e.weighingTotalWeight = e.weighingTotalWeight || e.theoryTotalWeight, e.mete = e.weighingTotalWeight, ms(e);
    } else {
      const n = `${e.classifyName}下不存在规格为"${c}"的材料，请联系管理员/仓库人员添加`;
      m.some((l) => l.error === n) || m.push({ rowIndex: N.indexOf(e) + 1, error: n });
      continue;
    }
  }
  if (m.length > 0) hs(m);
  else return N;
} };
function ms(u) {
  T(u.length) && u.quantity ? u.totalLength = xe({ length: u.length, quantity: u.quantity }) : u.totalLength = void 0;
}
const te = X[L.STEEL_COIL.V];
function ps(u, M) {
  const b = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], x = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  q({ type: "error", title: "导入失败,请查看错误清单" }), Q({ headers: b, data: x, filename: "钢卷盘盈清单-错误清单", sheetName: "错误清单" });
}
const Se = { title: "钢卷盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: te.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: te.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: te.length.precision, excelField: "__EMPTY_4" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: te.weight.precision, excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "卷号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_9" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_10" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_11" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], weighingTotalWeight: [{ required: true, message: "总重不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var s;
  if (!j(u, Se.rules)) return;
  t.state.wms.loaded.steelDensityCfg || await t.dispatch("config/fetchSteelDensityCfg");
  const b = t.state.wms.steelDensityCfg;
  t.state.config.loaded.matClsTree || await t.dispatch("config/fetchMatClsTree"), t.state.config.loaded.suppliers || t.dispatch("config/fetchSuppliers");
  const x = t.state.config.rawMatClsList.filter((i) => i.basicClass === L.STEEL_COIL.V), y = t.state.config.rawMatClsKV, N = v(u), g = [];
  let _ = [];
  const P = [], p = [], m = [];
  t.state.config.loaded.workshopNameV2 || await t.dispatch("config/fetchWorkshopNameV2"), t.state.config.loaded.warehouseV2 || await t.dispatch("config/fetchWarehouseV2"), t.state.project.loaded || await t.dispatch("project/fetchUserProjects");
  const w = t.state.config.workshopNameV2, C = t.state.config.warehouseV2, k = t.state.project.userProjectsMap[O].map((i) => (i.fullName = R(i, null, false), i)), S = t.state.config.suppliers;
  N.forEach((i, e) => {
    let r = false;
    const a = B(i.classifyName.split("/"));
    if (a.length === 1) {
      const n = x.filter((l) => l.name === i.classifyName) || [];
      if (T(n)) if (n.length === 1) r = true, i.classifyId = n[0].id, g.push(n[0].id);
      else {
        const l = [];
        for (const f of n) if (f.isLeaf) for (let o = 0; o < f.fullPathId.length; o++) f.id !== f.fullPathId[o] && l.push(f.fullPathId[o]);
        const h = n.find((f) => D(f.parent) && !l.includes(f.id));
        if (T(h)) r = true, i.classifyId = h.id, g.push(h.id);
        else {
          const f = n.filter((o) => o.isLeaf) || [];
          if (f.length === 1) {
            let o = true;
            n.forEach((d) => {
              f[0].fullPathId.includes(d.id) || (o = false);
            }), o && (r = true, i.classifyId = f[0].id, g.push(f[0].id));
          } else for (const o of n) T(o.parent) && !l.includes(o.id) && P.push(o);
        }
      }
      P.length > 1 && m.push({ rowIndex: e + 1, error: `科目名称"${i.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const n of x) if (n.fullPathName.length >= a.length && K(n.fullPathName.slice(-a.length), a)) {
      r = true, i.classifyId = n.id, g.push(n.id);
      break;
    }
    r || (_.push(i.classifyName), p.some((n) => n.classifyName === i.classifyName) || p.push({ rowIndex: e + 1, classifyName: i.classifyName }));
    const c = L.STEEL_COIL.V;
    H(i, e, { workshopNameV2List: w, warehouseV2List: C, arr: k, errorList: m, supplierList: S, basicClass: c });
  }), _ = Array.from(new Set(_)), _.length > 0 && (m.push({ rowIndex: p[0].rowIndex, error: `${p.map((i) => `"${i.classifyName}"`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在` }), p.shift());
  const I = t.state.config.classifySpec, E = [];
  for (let i = 0; i < g.length; i++) I[g[i]] === void 0 && !E.includes(g[i]) && E.push(g[i]);
  E.length > 0 && (E.forEach((i) => {
    I[i] = {};
  }), await t.dispatch("config/fetchMarClsSpec", E));
  for (const i of N) {
    if (((s = y == null ? void 0 : y[i.classifyId]) == null ? void 0 : s.isLeaf) === false) {
      m.push({ rowIndex: N.indexOf(i) + 1, error: `${i.classifyName}不是末级科目` });
      continue;
    }
    const e = I[i.classifyId];
    if ((e == null ? void 0 : e.hasUnitConfig) === false) {
      m.push({ rowIndex: N.indexOf(i) + 1, error: `${i.classifyName}未配置核算单位` });
      continue;
    }
    let r;
    const a = i.material ?? "";
    if (e && Array.isArray(e.specList)) {
      for (const c of e.specList) if (a === c.spec) {
        r = c;
        break;
      }
    }
    if (r) {
      i.uid = z(), i.sn = r.sn, i.specificationLabels = r.specificationLabels, i.serialNumber = r.serialNumber, i.classifySerialNumber = r.classify.serialNumber, i.classifyId = r.classify.id, i.classifyFullName = r.classify.fullName, i.classifyName = r.classify.name, i.classifyParentFullName = r.classify.parentFullName, i.basicClass = r.classify.basicClass, i.specification = r.spec, i.specificationMap = r.specKV, i.measureUnit = r.classify.measureUnit, i.accountingUnit = r.classify.accountingUnit, i.accountingPrecision = r.classify.accountingPrecision, i.measurePrecision = r.classify.measurePrecision;
      let c = 0;
      for (const n in b) Number(n) === i.classifyId && (c = b[n]);
      i.steelDensity = c, await gs(i), i.length = i.length || i.theoryLength, i.mete = i.weighingTotalWeight;
    } else {
      const c = `${i.classifyName}下不存在规格为"${a}"的材料，请联系管理员/仓库人员添加`;
      m.some((n) => n.error === c) || m.push({ rowIndex: N.indexOf(i) + 1, error: c });
      continue;
    }
  }
  if (m.length > 0) ps(m);
  else return N;
} };
async function gs(u) {
  u.theoryLength = await Pe({ classifyId: u.classifyId, name: u.classifyFullName, weight: u.weighingTotalWeight, width: u.width, thickness: u.thickness });
}
function ys(u, M) {
  const b = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], x = u.map((y) => ({ rowIndex: y.rowIndex, error: y.error }));
  q({ type: "error", title: "导入失败,请查看错误清单" }), Q({ headers: b, data: x, filename: "其他钢材盘盈清单-错误清单", sheetName: "错误清单" });
}
const Ce = { title: "其它钢材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_8" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_9" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (u) => {
  var E;
  if (!j(u, Ce.rules)) return;
  t.state.config.loaded.matClsTree || await t.dispatch("config/fetchMatClsTree");
  const b = t.state.config.rawMatClsList.filter((s) => s.basicClass === $.OTHER_STEEL_MATERIALS.V), x = t.state.config.rawMatClsKV, y = v(u), N = [];
  let g = [];
  const _ = [], P = [], p = [];
  t.state.config.loaded.workshopNameV2 || await t.dispatch("config/fetchWorkshopNameV2"), t.state.config.loaded.warehouseV2 || await t.dispatch("config/fetchWarehouseV2"), t.state.project.loaded || await t.dispatch("project/fetchUserProjects"), t.state.config.loaded.suppliers || t.dispatch("config/fetchSuppliers");
  const m = t.state.project.userProjectsMap, w = t.state.config.workshopNameV2, C = t.state.config.warehouseV2, Y = m[O].map((s) => (s.fullName = R(s, null, false), s)), k = t.state.config.suppliers;
  y.forEach((s, i) => {
    let e = false;
    const r = B(s.classifyName.split("/"));
    if (r.length === 1) {
      const c = b.filter((n) => n.name === s.classifyName) || [];
      if (T(c)) if (c.length === 1) e = true, s.classifyId = c[0].id, N.push(c[0].id);
      else {
        const n = [];
        for (const h of c) if (h.isLeaf) for (let f = 0; f < h.fullPathId.length; f++) h.id !== h.fullPathId[f] && n.push(h.fullPathId[f]);
        const l = c.find((h) => D(h.parent) && !n.includes(h.id));
        if (T(l)) e = true, s.classifyId = l.id, N.push(l.id);
        else {
          const h = c.filter((f) => f.isLeaf) || [];
          if (h.length === 1) {
            let f = true;
            c.forEach((o) => {
              h[0].fullPathId.includes(o.id) || (f = false);
            }), f && (e = true, s.classifyId = h[0].id, N.push(h[0].id));
          } else for (const f of c) T(f.parent) && !n.includes(f.id) && _.push(f);
        }
      }
      _.length > 1 && p.push({ rowIndex: i + 1, error: `科目名称"${s.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const c of b) if (c.fullPathName.length >= r.length && K(c.fullPathName.slice(-r.length), r)) {
      e = true, s.classifyId = c.id, N.push(c.id);
      break;
    }
    e || (g.push(s.classifyName), P.some((c) => c.classifyName === s.classifyName) || P.push({ rowIndex: i + 1, classifyName: s.classifyName }));
    const a = $.OTHER_STEEL_MATERIALS.V;
    H(s, i, { workshopNameV2List: w, warehouseV2List: C, arr: Y, errorList: p, supplierList: k, basicClass: a });
  }), g = Array.from(new Set(g)), g.length > 0 && (p.push({ rowIndex: P[0].rowIndex, error: `${P.map((s) => `"${s.classifyName}"`).join("、")}${P.length > 1 ? "等" : ""}物料种类不存在` }), P.shift());
  const S = t.state.config.classifySpec, I = [];
  for (let s = 0; s < N.length; s++) S[N[s]] === void 0 && !I.includes(N[s]) && I.push(N[s]);
  I.length > 0 && (I.forEach((s) => {
    S[s] = {};
  }), await t.dispatch("config/fetchMarClsSpec", I));
  for (const s of y) {
    if (((E = x == null ? void 0 : x[s.classifyId]) == null ? void 0 : E.isLeaf) === false) {
      p.push({ rowIndex: y.indexOf(s) + 1, error: `${s.classifyName}不是末级科目` });
      continue;
    }
    const i = S[s.classifyId];
    if ((i == null ? void 0 : i.hasUnitConfig) === false) {
      p.push({ rowIndex: y.indexOf(s) + 1, error: `${s.classifyName}未配置核算单位` });
      continue;
    }
    let e;
    const r = s.specification ?? "";
    if (i && Array.isArray(i.specList)) {
      for (const a of i.specList) if (r === a.spec) {
        if (e = a, s.measureUnit && (e.classify.measureUnit || p.push({ rowIndex: y.indexOf(s) + 1, error: `${s.classifyName}不存在计量单位` }), !await ae(e.classify.measureUnit, s.measureUnit))) {
          p.push({ rowIndex: y.indexOf(s) + 1, error: `${s.classifyName}填写的计量单位错误，单位应为：“${e.classify.measureUnit}”` });
          continue;
        }
        s.accountingUnit && (await ae(e.classify.accountingUnit, s.accountingUnit) || p.push({ rowIndex: y.indexOf(s) + 1, error: `${s.classifyName}填写的核算单位错误，单位应为：“${e.classify.accountingUnit}”` }));
        break;
      }
    }
    if (e) s.uid = z(), s.sn = e.sn, s.specificationLabels = e.specificationLabels, s.serialNumber = e.serialNumber, s.classifySerialNumber = e.classify.serialNumber, s.classifyId = e.classify.id, s.classifyFullPathId = e.classify.fullPathId, s.classifyFullName = e.classify.fullName, s.classifyName = e.classify.name, s.classifyParentFullName = e.classify.parentFullName, s.basicClass = e.classify.basicClass, s.specification = e.spec, s.specificationMap = e.specKV, s.measureUnit = e.classify.measureUnit, s.accountingUnit = e.classify.accountingUnit, s.accountingPrecision = e.classify.accountingPrecision, s.measurePrecision = e.classify.measurePrecision, s.measureUnit || (s.quantity = void 0), s.quantity && (s.quantity = A(s.quantity, s.measurePrecision)), s.mete && (s.mete = A(s.mete, s.accountingPrecision)), s.measureUnit || (s.quantity = void 0);
    else {
      const a = `${s.classifyName}下不存在规格为"${r}"的材料，请联系管理员/仓库人员添加`;
      p.some((c) => c.error === a) || p.push({ rowIndex: y.indexOf(s) + 1, error: a });
    }
  }
  if (p.length > 0) ys(p);
  else return y;
} }, _s = { class: "filter-container" }, Ns = { class: "filter-left-box" }, bs = { class: "filter-right-box" }, Ss = { __name: "index", props: { repeatList: { type: Array, default: () => [] } }, setup(u, { expose: M }) {
  var c;
  const b = { steelPlateList: { K: "steelPlateList", L: "钢板", V: L.STEEL_PLATE.V, TABLE: ze }, sectionSteelList: { K: "sectionSteelList", L: "型材", V: L.SECTION_STEEL.V, TABLE: Qe }, steelCoilList: { K: "steelCoilList", L: "钢卷", V: L.STEEL_COIL.V, TABLE: Ge }, otherSteelMaterialList: { K: "otherSteelMaterialList", L: "其它钢材", V: $.OTHER_STEEL_MATERIALS.V, TABLE: Je } }, x = G(), y = G(), N = G(), g = G(), _ = G(), P = G(), p = Fe({ steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null });
  ke("matSpecRef", g);
  const m = (c = Ye("crud")) == null ? void 0 : c.form, { maxHeight: w, maxHeightStyle: C } = _e({ mainBox: ".profit-application-record-form", extraBox: [".el-drawer__header", ".filter-container"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 210 }), { maxHeight: Y } = _e({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => N.value.loaded), k = he(() => {
    var n;
    return ((n = b == null ? void 0 : b[_.value]) == null ? void 0 : n.TABLE) || b.steelPlateList.TABLE;
  }), S = he(() => {
    var n, l;
    if (m.boolPartyA) switch ((n = b[_.value]) == null ? void 0 : n.V) {
      case $.STEEL_PLATE.V:
        return Le;
      case $.SECTION_STEEL.V:
        return Me;
      case $.STEEL_COIL.V:
        return Se;
      case $.OTHER_STEEL_MATERIALS.V:
        return Ce;
      default:
        return null;
    }
    else switch ((l = b[_.value]) == null ? void 0 : l.V) {
      case $.STEEL_PLATE.V:
        return Ee;
      case $.SECTION_STEEL.V:
        return we;
      case $.STEEL_COIL.V:
        return Ie;
      case $.OTHER_STEEL_MATERIALS.V:
        return Te;
      default:
        return null;
    }
  });
  me(_, (n) => {
    n && (m.currentBasicClass = b[n].V, re(() => {
      p[n] || (p[n] = x.value), console.log(p);
    }));
  }, { immediate: true });
  function I() {
    re(() => {
      p.steelPlateList = null, p.sectionSteelList = null, p.steelCoilList = null, p.otherSteelMaterialList = null, _.value = b.steelPlateList.K, g.value && g.value.clear();
    });
  }
  function E(n) {
    return x.value.rowInit(n);
  }
  function s() {
    P.value = true;
  }
  function i(n) {
    g.value && g.value.clearByBasicClass(n);
  }
  function e() {
    return Object.keys(p).every((n) => p[n] ? p[n].validate() : true);
  }
  function r() {
    return e();
  }
  I();
  function a(n) {
    const l = _.value, h = m[l].length;
    n.map((d, V) => {
      d.rowIndex = (m[l].length || 0) + V, d.projectId = d.projectId || (V > 0 || h > 0 ? -1 : void 0), d.workshopId = d.workshopId || (V > 0 || h > 0 ? -1 : void 0), d.warehouseId = d.warehouseId || (V > 0 || h > 0 ? -1 : void 0), d.supplierId = d.supplierId || (V > 0 || h > 0 ? -1 : void 0);
    }), m[l].push.apply(m[l], n);
    const f = m[l].length;
    for (let d = h; d < f; d++) m[l][d].amount = A(m[l][d].amount, He.YUAN), p[l].rowWatch(m[l][d]);
    const o = me(g, () => {
      g.value && (g.value.initSelected(n.map((d) => ({ sn: d.sn, classifyId: d.classifyId }))), re(() => {
        o();
      }));
    }, { immediate: true });
  }
  return M({ form: m, validate: r, handleClearByBasicClass: i }), (n, l) => {
    var V;
    const h = ve, f = pe("common-button"), o = Oe, d = pe("common-drawer");
    return ce(), ge(ye, null, [se("div", null, [se("div", _s, [se("div", Ns, [$e(n.$slots, "filterLeft"), W(U(Ae), { modelValue: _.value, "onUpdate:modelValue": l[0] || (l[0] = (F) => _.value = F), class: "filter-item", size: "default", style: { "margin-left": "5px !important" } }, { default: J(() => [(ce(), ge(ye, null, Ue(b, (F) => W(h, { key: F.K, label: F.K }, { default: J(() => [oe(fe(F.L) + fe(U(m)[F.K] && U(m)[F.K].length ? `(${U(m)[F.K].length})` : ""), 1)]), _: 2 }, 1032, ["label"])), 64))]), _: 1 }, 8, ["modelValue"])]), se("div", bs, [W(f, { class: "filter-item", type: "success", onClick: s }, { default: J(() => l[3] || (l[3] = [oe(" 添加物料 ")])), _: 1, __: [3] }), W(Re, { disabled: !_.value, template: S.value, "btn-name": "批量导入", "btn-size": "default", "btn-type": "primary", icon: "el-icon-upload", class: "filter-item", "open-loading": "", onSuccess: a }, null, 8, ["disabled", "template"]), W(De, { disabled: !_.value, fn: U(Be), params: { basicClass: (V = b[_.value]) == null ? void 0 : V.V, boolPartyA: U(m).boolPartyA }, class: "filter-item", "response-header-result": "" }, { default: J(() => {
      var F;
      return [oe(fe(_.value ? (F = b[_.value]) == null ? void 0 : F.L : "") + "盘盈模板下载 ", 1)];
    }), _: 1 }, 8, ["disabled", "fn", "params"])])]), W(o, { ref_key: "formRef", ref: y, model: U(m) }, { default: J(() => [(ce(), We(qe(k.value), { ref_key: "steelRef", ref: x, "max-height": U(w), repeatList: u.repeatList, style: je(U(C)) }, null, 8, ["max-height", "repeatList", "style"]))]), _: 1 }, 8, ["model"])]), W(d, { ref_key: "drawerRef", ref: N, modelValue: P.value, "onUpdate:modelValue": l[2] || (l[2] = (F) => P.value = F), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: J(() => {
      var F;
      return [W(Ke, { ref_key: "matSpecRef", ref: g, modelValue: U(m)[_.value], "onUpdate:modelValue": l[1] || (l[1] = (Ve) => U(m)[_.value] = Ve), "basic-class": (F = b == null ? void 0 : b[_.value]) == null ? void 0 : F.V, "max-height": U(Y), "row-init-fn": E, "table-width": 350, visible: P.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])];
    }), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  Ss as default
};

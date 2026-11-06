import { useStore as Xe } from "vuex";
import { ref as A } from "vue";
import { watch as ae } from "vue";
import { provide as Te } from "vue";
import { computed as ie } from "vue";
import { watchEffect as _e } from "vue";
import { nextTick as ce } from "vue";
import { ElMessage as z } from "element-plus";
import { resolveComponent as te } from "vue";
import { openBlock as M } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as V } from "vue";
import { renderSlot as Je } from "vue";
import { createVNode as d } from "vue";
import { withCtx as b } from "vue";
import { createTextVNode as H } from "vue";
import { unref as s } from "vue";
import { createBlock as v } from "vue";
import { createCommentVNode as I } from "vue";
import { normalizeStyle as ue } from "vue";
import { toDisplayString as j } from "vue";
import { Fragment as Ee } from "vue";
import { renderList as Ze } from "vue";
import { resolveDynamicComponent as es } from "vue";
import { ElFormItem as ss } from "element-plus";
import { ElInput as as } from "element-plus";
import { ElCheckbox as is } from "element-plus";
import { ElTag as ts } from "element-plus";
import { ElTooltip as ls } from "element-plus";
import { ElForm as ns } from "element-plus";
import { vP as Q, vQ as Ie, j as m, am as _, V as D, vR as G, f3 as X, aI as J, sT as rs, i as W, iX as Z, vS as fe, sU as os, v9 as cs, va as us, vT as le, D as Pe, _ as ds, tB as fs, vU as ms, vV as ps, vW as ys, j_ as T, jJ as Ce, o as Me, a$ as gs, kf as hs, jl as bs, b4 as Ts, au as _s, ap as Ve, bb as we, bE as Es, iH as Cs, bG as Ms, jT as Vs, jU as ws, jV as xs, R as Us, S as Is, nd as Ps, vI as de, vv as Ns, L as vs, vw as Ss, vx as Ls, vX as Rs, cQ as As, b as xe, bD as Fs } from "../../../../../shared/runtime.js";
import ks from "../components/requisition-list/index.vue.js";
import qs from "../components/manuf-list.vue.js";
import Ue from "../components/application/steel/index.vue.js";
import Os from "../components/application/auxiliary-material/index.vue.js";
import $s from "../components/application/other/index.vue.js";
import Bs from "../components/application/manufactured/index.vue.js";
import "../components/requisition-list/module/requisition-order.vue.js";
import "../components/requisition-list/module/steel/index.vue.js";
import "../components/requisition-list/module/steel/module/steel-plate-table.vue.js";
import "../components/requisition-list/module/steel/module/section-steel-table.vue.js";
import "../components/requisition-list/module/steel/module/steel-coil-table.vue.js";
import "../components/requisition-list/module/auxiliary-material/index.vue.js";
import "../components/requisition-list/module/manufactured/index.vue.js";
import "../components/application/steel/module/steel-plate-table.vue.js";
import "../components/application/steel/module/section-steel-table.vue.js";
import "../components/application/steel/module/steel-coil-table.vue.js";
const { handleMeteChangeCalcPrice: Ys } = fe("mete"), Ne = { title: "钢板采购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", excelField: "__EMPTY_5" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: 0, excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (p) => {
  var i;
  if (!Q(p, Ne.rules)) return;
  const P = await Ie();
  m.state.wms.loaded.steelDensityCfg || await m.dispatch("config/fetchSteelDensityCfg");
  const w = m.state.wms.steelDensityCfg;
  m.state.config.loaded.matClsTree || await m.dispatch("config/fetchMatClsTree");
  const U = m.state.config.rawMatClsList.filter((a) => a.basicClass === _.STEEL_PLATE.V), g = m.state.config.rawMatClsKV, y = D(p), h = [];
  let f = [];
  if (y.forEach((a) => {
    let r = false;
    const u = G(a.classifyName.split("/"));
    for (const C of U) if (C.fullPathName.length >= u.length && X(C.fullPathName.slice(-u.length), u)) {
      r = true, a.classifyId = C.id, h.push(C.id);
      break;
    }
    r || f.push(a.classifyName);
  }), f = Array.from(new Set(f)), f.length > 0) throw new Error(`${f.map((a) => `“${a}”`).join("、")}${f.length > 1 ? "等" : ""}物料种类不存在`);
  const e = m.state.config.classifySpec, t = h.filter((a) => e[a] === void 0);
  t.length > 0 && (t.forEach((a) => {
    e[a] = {};
  }), await m.dispatch("config/fetchMarClsSpec", t));
  for (const a of y) {
    if (((i = g == null ? void 0 : g[a.classifyId]) == null ? void 0 : i.isLeaf) === false) throw new Error(`${a.classifyName}不是末级科目`);
    const r = e[a.classifyId];
    if (r.hasUnitConfig === false) throw new Error(`${a.classifyName}未配置核算单位`);
    let u;
    const C = a.material ?? "";
    if (r && Array.isArray(r.specList)) {
      for (const R of r.specList) if (C === R.spec) {
        u = R;
        break;
      }
    }
    if (u) {
      a.uid = J(), a.sn = u.sn, a.specificationLabels = u.specificationLabels, a.serialNumber = u.serialNumber, a.classifySerialNumber = u.classify.serialNumber, a.classifyId = u.classify.id, a.classifyFullName = u.classify.fullName, a.classifyName = u.classify.name, a.classifyParentFullName = u.classify.parentFullName, a.basicClass = u.classify.basicClass, a.specification = u.spec, a.specificationMap = u.specKV, a.measureUnit = u.classify.measureUnit, a.accountingUnit = u.classify.accountingUnit, a.accountingPrecision = u.classify.accountingPrecision, a.measurePrecision = u.classify.measurePrecision;
      let R = 0;
      for (const ne in w) Number(ne) === a.classifyId && (R = w[ne]);
      a.steelDensity = R, a.theoryWeight = await rs({ classifyId: a.classifyId, name: a.classifyFullName, length: a.length, width: a.width, thickness: a.thickness }), W(a.theoryWeight) && a.quantity ? a.theoryTotalWeight = Z(a.theoryWeight * a.quantity, P[_.STEEL_PLATE.V].weight.precision) : a.theoryTotalWeight = void 0, a.weighingTotalWeight = a.weighingTotalWeight || a.theoryTotalWeight, a.mete = a.weighingTotalWeight, (!a.unitPrice || !a.amount) && Ys(a);
    } else throw new Error(`${a.classifyName}下不存在规格为“${C}”的材料，请联系初鸣售后人员添加`);
  }
  return y;
} }, { handleMeteChangeCalcPrice: js } = fe("mete"), ve = { title: "型材采购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格/材质", field: "specification", excelField: "__EMPTY_1" }, { label: "定尺长度（mm）", field: "length", type: "number", excelField: "__EMPTY_2" }, { label: "数量（根）", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: 0, excelField: "__EMPTY_4" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_5" }, { label: "品牌", field: "brand", excelField: "__EMPTY_6" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "型材规格不能为空" }] }, format: async (p) => {
  var t;
  if (!Q(p, ve.rules)) return;
  const P = await Ie();
  m.state.config.loaded.matClsTree || await m.dispatch("config/fetchMatClsTree");
  const w = m.state.config.rawMatClsList.filter((i) => i.basicClass === _.SECTION_STEEL.V), U = m.state.config.rawMatClsKV, g = D(p), y = [];
  let h = [];
  if (g.forEach((i) => {
    let a = false;
    const r = G(i.classifyName.split("/"));
    console.log(w, "matList");
    for (const u of w) if (u.fullPathName.length >= r.length && X(u.fullPathName.slice(-r.length), r)) {
      a = true, i.classifyId = u.id, y.push(u.id);
      break;
    }
    a || h.push(i.classifyName);
  }), h = Array.from(new Set(h)), h.length > 0) throw new Error(`${h.map((i) => `“${i}”`).join("、")}${h.length > 1 ? "等" : ""}物料种类不存在`);
  const f = m.state.config.classifySpec, e = y.filter((i) => f[i] === void 0);
  e.length > 0 && (e.forEach((i) => {
    f[i] = {};
  }), await m.dispatch("config/fetchMarClsSpec", e));
  for (const i of g) {
    if (((t = U == null ? void 0 : U[i.classifyId]) == null ? void 0 : t.isLeaf) === false) throw new Error(`${i.classifyName}不是末级科目`);
    const a = f[i.classifyId];
    if (a.hasUnitConfig === false) throw new Error(`${i.classifyName}未配置核算单位`);
    let r;
    const u = Ws(i.specification);
    if (a && Array.isArray(a.specList)) {
      for (const C of a.specList) if (u === C.spec) {
        r = C;
        break;
      }
    }
    if (r) i.uid = J(), i.sn = r.sn, i.specificationLabels = r.specificationLabels, i.serialNumber = r.serialNumber, i.classifySerialNumber = r.classify.serialNumber, i.classifyId = r.classify.id, i.classifyFullName = r.classify.fullName, i.classifyName = r.classify.name, i.classifyParentFullName = r.classify.parentFullName, i.basicClass = r.classify.basicClass, i.specification = r.spec, i.specificationMap = r.specKV, i.measureUnit = r.classify.measureUnit, i.accountingUnit = r.classify.accountingUnit, i.accountingPrecision = r.classify.accountingPrecision, i.measurePrecision = r.classify.measurePrecision, i.unitWeight = r.unitWeight, i.theoryWeight = await os({ length: i.length, unitWeight: i.unitWeight }), W(i.theoryWeight) && i.quantity ? i.theoryTotalWeight = Z(i.theoryWeight * i.quantity, P[_.SECTION_STEEL.V].weight.precision) : i.theoryTotalWeight = void 0, i.weighingTotalWeight = i.weighingTotalWeight || i.theoryTotalWeight, Hs(i), i.mete = i.weighingTotalWeight, (!i.unitPrice || !i.amount) && js(i);
    else throw new Error(`${i.classifyName}下不存在规格为“${u}”的材料，请联系初鸣售后人员添加`);
  }
  return g;
} };
function Hs(p) {
  W(p.length) && p.quantity ? p.totalLength = cs({ length: p.length, quantity: p.quantity }) : p.totalLength = void 0;
}
function Ws(p) {
  const L = p.replace(/\s+/g, ""), P = L.lastIndexOf("*");
  return P > -1 ? L.substring(0, P) + " * " + L.substring(P + 1) : L.substring(P + 1);
}
const { handleMeteChangeCalcPrice: Ds } = fe("mete"), Se = { title: "钢卷采购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", excelField: "__EMPTY_4" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: 0, excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "颜色", field: "color", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (p) => {
  var t;
  if (!Q(p, Se.rules)) return;
  m.state.config.loaded.matClsTree || await m.dispatch("config/fetchMatClsTree"), m.state.wms.loaded.steelDensityCfg || await m.dispatch("config/fetchSteelDensityCfg");
  const P = m.state.wms.steelDensityCfg, w = m.state.config.rawMatClsList.filter((i) => i.basicClass === _.STEEL_COIL.V), U = m.state.config.rawMatClsKV, g = D(p), y = [];
  let h = [];
  if (g.forEach((i) => {
    let a = false;
    const r = G(i.classifyName.split("/"));
    for (const u of w) if (u.fullPathName.length >= r.length && X(u.fullPathName.slice(-r.length), r)) {
      a = true, i.classifyId = u.id, y.push(u.id);
      break;
    }
    a || h.push(i.classifyName);
  }), h = Array.from(new Set(h)), h.length > 0) throw new Error(`${h.map((i) => `“${i}”`).join("、")}${h.length > 1 ? "等" : ""}物料种类不存在`);
  const f = m.state.config.classifySpec, e = y.filter((i) => f[i] === void 0);
  e.length > 0 && (e.forEach((i) => {
    f[i] = {};
  }), await m.dispatch("config/fetchMarClsSpec", e));
  for (const i of g) {
    if (((t = U == null ? void 0 : U[i.classifyId]) == null ? void 0 : t.isLeaf) === false) throw new Error(`${i.classifyName}不是末级科目`);
    const a = f[i.classifyId];
    if (a.hasUnitConfig === false) throw new Error(`${i.classifyName}未配置核算单位`);
    let r;
    const u = i.material ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const C of a.specList) if (u === C.spec) {
        r = C;
        break;
      }
    }
    if (r) {
      i.uid = J(), i.sn = r.sn, i.specificationLabels = r.specificationLabels, i.serialNumber = r.serialNumber, i.classifySerialNumber = r.classify.serialNumber, i.classifyId = r.classify.id, i.classifyFullName = r.classify.fullName, i.classifyName = r.classify.name, i.classifyParentFullName = r.classify.parentFullName, i.basicClass = r.classify.basicClass, i.specification = r.spec, i.specificationMap = r.specKV, i.measureUnit = r.classify.measureUnit, i.accountingUnit = r.classify.accountingUnit, i.accountingPrecision = r.classify.accountingPrecision, i.measurePrecision = r.classify.measurePrecision;
      let C = 0;
      for (const R in P) Number(R) === i.classifyId && (C = P[R]);
      i.steelDensity = C, await Ks(i), i.length = i.length || i.theoryLength, i.quantity = i.length, i.mete = i.weighingTotalWeight, (!i.unitPrice || !i.amount) && Ds(i);
    } else throw new Error(`${i.classifyName}下不存在规格为“${u}”的材料，请联系初鸣售后人员添加`);
  }
  return g;
} };
async function Ks(p) {
  p.theoryLength = await us({ classifyId: p.classifyId, name: p.classifyFullName, weight: p.weighingTotalWeight, width: p.width, thickness: p.thickness });
}
const Le = { title: "辅材采购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "颜色", field: "color", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (p) => {
  var e;
  if (!Q(p, Le.rules)) return;
  m.state.config.loaded.matClsTree || await m.dispatch("config/fetchMatClsTree");
  const P = m.state.config.rawMatClsList.filter((t) => t.basicClass === _.MATERIAL.V), w = m.state.config.rawMatClsKV, U = D(p), g = [];
  let y = [];
  if (U.forEach((t) => {
    let i = false;
    const a = G(t.classifyName.split("/"));
    for (const r of P) if (r.fullPathName.length >= a.length && X(r.fullPathName.slice(-a.length), a)) {
      i = true, t.classifyId = r.id, g.push(r.id);
      break;
    }
    i || y.push(t.classifyName);
  }), y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((t) => `“${t}”`).join("、")}${y.length > 1 ? "等" : ""}物料种类不存在`);
  const h = m.state.config.classifySpec, f = g.filter((t) => h[t] === void 0);
  f.length > 0 && (f.forEach((t) => {
    h[t] = {};
  }), await m.dispatch("config/fetchMarClsSpec", f));
  for (const t of U) {
    if (((e = w == null ? void 0 : w[t.classifyId]) == null ? void 0 : e.isLeaf) === false) throw new Error(`${t.classifyName}不是末级科目`);
    const i = h[t.classifyId];
    if (i.hasUnitConfig === false) throw new Error(`${t.classifyName}未配置核算单位`);
    let a;
    const r = t.specification ?? "";
    if (i && Array.isArray(i.specList)) {
      for (const u of i.specList) if (r === u.spec) {
        if (a = u, t.measureUnit) {
          if (!a.classify.measureUnit) throw new Error(`${t.classifyName}不存在计量单位`);
          if (!await le(a.classify.measureUnit, t.measureUnit)) throw new Error(`${t.classifyName}填写的计量单位错误，单位应为：“${a.classify.measureUnit}”`);
        }
        if (t.accountingUnit && !await le(a.classify.accountingUnit, t.accountingUnit)) throw new Error(`${t.classifyName}填写的核算单位错误，单位应为：“${a.classify.accountingUnit}”`);
        break;
      }
    }
    if (a) t.uid = J(), t.sn = a.sn, t.specificationLabels = a.specificationLabels, t.serialNumber = a.serialNumber, t.classifySerialNumber = a.classify.serialNumber, t.classifyId = a.classify.id, t.classifyFullPathId = a.classify.fullPathId, t.classifyFullName = a.classify.fullName, t.classifyName = a.classify.name, t.classifyParentFullName = a.classify.parentFullName, t.basicClass = a.classify.basicClass, t.specification = a.spec, t.specificationMap = a.specKV, t.measureUnit = a.classify.measureUnit, t.accountingUnit = a.classify.accountingUnit, t.accountingPrecision = a.classify.accountingPrecision, t.measurePrecision = a.classify.measurePrecision, t.measureUnit || (t.quantity = void 0), t.mete && t.unitPrice && (t.amount = Z(t.mete * t.unitPrice, Pe.YUAN));
    else throw new Error(`${t.classifyName}下不存在规格为“${r}”的材料，请联系初鸣售后人员添加`);
  }
  return U;
} }, Re = { title: "其它采购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "颜色", field: "color", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (p) => {
  var e;
  if (!Q(p, Re.rules)) return;
  m.state.config.loaded.matClsTree || await m.dispatch("config/fetchMatClsTree");
  const P = m.state.config.rawMatClsList.filter((t) => t.basicClass === _.OTHER.V), w = m.state.config.rawMatClsKV, U = D(p), g = [];
  let y = [];
  if (U.forEach((t) => {
    let i = false;
    const a = G(t.classifyName.split("/"));
    for (const r of P) if (r.fullPathName.length >= a.length && X(r.fullPathName.slice(-a.length), a)) {
      i = true, t.classifyId = r.id, g.push(r.id);
      break;
    }
    i || y.push(t.classifyName);
  }), y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((t) => `“${t}”`).join("、")}${y.length > 1 ? "等" : ""}物料种类不存在`);
  const h = m.state.config.classifySpec, f = g.filter((t) => h[t] === void 0);
  f.length > 0 && (f.forEach((t) => {
    h[t] = {};
  }), await m.dispatch("config/fetchMarClsSpec", f));
  for (const t of U) {
    if (((e = w == null ? void 0 : w[t.classifyId]) == null ? void 0 : e.isLeaf) === false) throw new Error(`${t.classifyName}不是末级科目`);
    const i = h[t.classifyId];
    if (i.hasUnitConfig === false) throw new Error(`${t.classifyName}未配置核算单位`);
    let a;
    const r = t.specification ?? "";
    if (i && Array.isArray(i.specList)) {
      for (const u of i.specList) if (r === u.spec) {
        if (a = u, t.measureUnit) {
          if (!a.classify.measureUnit) throw new Error(`${t.classifyName}不存在计量单位`);
          if (!await le(a.classify.measureUnit, t.measureUnit)) throw new Error(`${t.classifyName}填写的计量单位错误，单位应为：“${a.classify.measureUnit}”`);
        }
        if (t.accountingUnit && !await le(a.classify.accountingUnit, t.accountingUnit)) throw new Error(`${t.classifyName}填写的核算单位错误，单位应为：“${a.classify.accountingUnit}”`);
        break;
      }
    }
    if (a) t.uid = J(), t.sn = a.sn, t.specificationLabels = a.specificationLabels, t.serialNumber = a.serialNumber, t.classifySerialNumber = a.classify.serialNumber, t.classifyId = a.classify.id, t.classifyFullPathId = a.classify.fullPathId, t.classifyFullName = a.classify.fullName, t.classifyName = a.classify.name, t.classifyParentFullName = a.classify.parentFullName, t.basicClass = a.classify.basicClass, t.specification = a.spec, t.specificationMap = a.specKV, t.measureUnit = a.classify.measureUnit, t.accountingUnit = a.classify.accountingUnit, t.accountingPrecision = a.classify.accountingPrecision, t.measurePrecision = a.classify.measurePrecision, t.measureUnit || (t.quantity = void 0), t.mete && t.unitPrice && (t.amount = Z(t.mete * t.unitPrice, Pe.YUAN));
    else throw new Error(`${t.classifyName}下不存在规格为“${r}”的材料，请联系初鸣售后人员添加`);
  }
  return U;
} };
const zs = { style: { display: "flex" } }, Qs = { style: { flex: "1", "text-align": "right" } }, Gs = { class: "main-content" }, Xs = { class: "order-details" }, Js = { class: "flex-rss child-mr-10" }, Zs = { class: "flex-rss child-mr-10" }, ea = { class: "form-right" }, sa = { key: 0, class: "right-head flex-rbs" }, aa = { class: "right-head-content" }, ia = { key: 0 }, ta = { key: 0, class: "opt-content" }, la = { key: 1, class: "right-head flex-rbs" }, na = { class: "right-head-content" }, ra = { key: 0 }, oa = { key: 0, class: "opt-content" }, ca = { class: "table-remark" }, ua = { class: "con" }, da = { class: "con" }, fa = { __name: "has-detail-form", props: { edit: { type: Boolean, default: false }, dialogVisible: { type: Boolean, default: false }, detail: { type: Object }, maxHeight: { type: Number, default: 100 } }, emits: "success", setup(p, { emit: L }) {
  const P = L, w = Xe(), U = { attachmentIds: void 0, list: [], sectionSteelList: [], steelPlateList: [], steelCoilList: [], requisitions: [], requisitionsKV: {}, actualRequisitionIds: [], manufListObj: {}, manufMergeObj: {} }, g = p, y = A(false), h = A(), { cu: f, form: e, FORM: t } = fs({ title: "采购合同", formStore: !g.edit, formStoreKey: "SUPPLY_CHAIN_PURCHASE_ORDER", defaultForm: U, useDraftCallback: i, clearDraftCallback: a, api: g.edit ? ms : ps }, h, g.detail);
  ae(() => g.detail, (n = {}) => {
    e.useRequisitions = n.useRequisitions, e.materialType = g.detail.materialType, e.purchaseType = g.detail.purchaseType, e.currentBasicClass = g.detail.currentBasicClass, e.supplyType = g.detail.supplyType, e.boolUsed = g.detail.boolUsed;
  }, { deep: true, immediate: true }), Te("cu", f);
  function i() {
  }
  function a() {
  }
  const r = (n, l, c) => {
    e.invoiceType || e.invoiceType === 0 ? e.invoiceType === Fs.SPECIAL.V && !e.taxRate ? c(new Error("请选择税率")) : c() : c(new Error("请选择发票及税率"));
  }, u = A({}), C = { serialNumber: [{ max: 30, message: "订单编号长度不可超过30位", trigger: "blur" }], materialType: [{ required: true, message: "请选择材料类型", trigger: "change" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], supplyType: [{ required: true, message: "请选择供货类型", trigger: "change" }], supplierId: [{ required: true, message: "请选择供应商", trigger: "change" }], branchCompanyId: [{ required: true, message: "请选择签订主体", trigger: "change" }] }, R = { logisticsTransportType: [{ required: true, message: "请选择物流运输方式", trigger: "change" }], logisticsPayerType: [{ required: true, message: "请选择物流费用承担方", trigger: "change" }], purchaseOrderPaymentMode: [{ required: true, message: "请选择订单类型", trigger: "change" }], invoiceType: [{ required: true, validator: r, trigger: "change" }], taxRate: [{ max: 2, message: "请输入税率", trigger: "blur" }], mete: [{ required: true, message: "请填写合同量", trigger: "blur" }], amount: [{ required: true, message: "请填写合同额", trigger: "blur" }] }, Ae = { auxMaterialIds: [{ required: true, validator: (n, l, c) => {
    e.isAllMaterial || l ? c() : c(new Error("请选择辅材"));
  }, trigger: "change" }] }, Fe = { otherMaterialIds: [{ required: true, validator: (n, l, c) => {
    e.isAllOtherMaterial || l ? c() : c(new Error("请选择其它科目"));
  }, trigger: "change" }] }, me = ie(() => {
    var n;
    return (n = e.list) == null ? void 0 : n.filter((l) => {
      var c, E;
      return (E = (c = f == null ? void 0 : f.submitResult) == null ? void 0 : c.data) == null ? void 0 : E.includes(l.classifyId);
    });
  });
  _e(() => {
    if (g.dialogVisible) {
      const n = u.value;
      ys(n), Object.assign(n, C), Object.assign(n, R), e.materialType & T.MATERIAL.V && !e.useRequisitions && Object.assign(n, Ae), e.materialType & T.OTHER.V && !e.useRequisitions && Object.assign(n, Fe), ce(() => {
        h.value && h.value.clearValidate();
      });
    }
  });
  const Y = ie(() => !!(e.materialType & T.MANUFACTURED.V));
  ae(() => e.materialType, (n) => {
    console.log(e.materialType), n & T.MATERIAL.V && (e.basicClass = e.currentBasicClass = _.MATERIAL.V), n & T.OTHER.V && (e.basicClass = e.currentBasicClass = _.OTHER.V), n & T.STEEL.V && (e.basicClass = _.STEEL_PLATE.V | _.STEEL_COIL.V | _.SECTION_STEEL.V, e.currentBasicClass = _.STEEL_PLATE.V), n & T.MANUFACTURED.V ? (e.basicClass = e.currentBasicClass = _.STRUC_MANUFACTURED.V, e.purchaseType = Ce.MANUFACTURED.V) : e.purchaseType = Ce.RAW_MATERIAL.V, pe(), F.value && F.value.clear();
  });
  const ke = ie(() => {
    switch (e.materialType) {
      case T.STEEL.V:
        return Ue;
      case T.MATERIAL.V:
        return Os;
      case T.OTHER.V:
        return $s;
      case T.MANUFACTURED.V:
        return Bs;
      default:
        return Ue;
    }
  }), pe = () => {
    e.list = [], e.sectionSteelList = [], e.steelPlateList = [], e.steelCoilList = [], e.requisitionsKV = {}, e.actualRequisitionIds = [], e.manufListObj = {};
  }, O = { [_.STEEL_PLATE.V]: "steelPlateList", [_.SECTION_STEEL.V]: "sectionSteelList", [_.STEEL_COIL.V]: "steelCoilList", [_.MATERIAL.V]: "list", [_.OTHER.V]: "list", [_.STRUC_MANUFACTURED.V]: "list", [_.ENCL_MANUFACTURED.V]: "list" }, qe = ie(() => {
    switch (e.currentBasicClass) {
      case _.STEEL_PLATE.V:
        return Ne;
      case _.SECTION_STEEL.V:
        return ve;
      case _.STEEL_COIL.V:
        return Se;
      case _.MATERIAL.V:
        return Le;
      default:
        return Re;
    }
  }), N = A(), ye = A(), ge = A(), F = A(), ee = A(false), K = A(false);
  Te("matSpecRef", F);
  const { maxHeight: Oe } = Me({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => {
    var n;
    return (n = ye.value) == null ? void 0 : n.loaded;
  }), { maxHeight: $e } = Me({ mainBox: ".manufactured-select-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: true, clientHRepMainH: true, extraHeight: 50, minHeight: 300 }, () => {
    var n;
    return (n = ge.value) == null ? void 0 : n.loaded;
  });
  function Be(n) {
    return N.value.rowInit(n);
  }
  function Ye() {
    var n, l, c, E;
    if (e.materialType & T.MATERIAL.V && !e.isAllMaterial && !((n = e.auxMaterialIds) != null && n.length)) {
      z.warning("请先选择辅材明细");
      return;
    }
    if (e.materialType & T.OTHER.V && !e.isAllOtherMaterial && !((l = e.otherMaterialIds) != null && l.length)) {
      z.warning("请先选择其它明细");
      return;
    }
    if (W(me.value) && W((c = f == null ? void 0 : f.submitResult) == null ? void 0 : c.data)) {
      z.error("请删除全部标红数据");
      return;
    }
    ee.value = true, ((E = f == null ? void 0 : f.submitResult) == null ? void 0 : E.code) === 40206 && F.value && (w.dispatch("config/fetchMatClsTree"), f.submitResult.code = null, w.state.config.classifySpec = { specKV: [] });
  }
  function he(n) {
    for (let l = 0; l < n.length; l++) {
      const c = D(n[l]), E = c.curPurchaseQuantity * c.netWeight || 0;
      xe(e.manufListObj[c.id]) ? e.manufListObj[c.id] = { ...c, rowKey: c.id, curPurchaseWeight: E } : (e.manufListObj[c.id].curPurchaseQuantity += c.curPurchaseQuantity, e.manufListObj[c.id].curPurchaseWeight = Z(e.manufListObj[c.id].curPurchaseWeight + E, 2));
    }
    K.value = false;
  }
  function je(n) {
    var l, c;
    try {
      const E = O[e.currentBasicClass], x = e[E].length;
      e[E].push.apply(e[E], n);
      const S = e[E].length;
      if ((l = N.value) != null && l.rowWatch) for (let k = x; k < S; k++) (c = N.value) == null || c.rowWatch(e[E][k]);
      const se = ae(F, () => {
        F.value && (F.value.initSelected(n.map((k) => ({ sn: k.sn, classifyId: k.classifyId }))), ce(() => {
          se();
        }));
      }, { immediate: true });
    } catch (E) {
      z.error({ message: E.message, duration: 5e3 });
    }
  }
  const be = A(), re = A(false);
  _e(() => {
    var l, c, E, x;
    e.requisitions = gs(e.requisitionsKV);
    const n = [];
    e.materialType & T.STEEL.V && ((l = e.steelPlateList) == null || l.forEach((S) => {
      n.push(S.applyPurchaseId);
    }), (c = e.steelCoilList) == null || c.forEach((S) => {
      n.push(S.applyPurchaseId);
    }), (E = e.sectionSteelList) == null || E.forEach((S) => {
      n.push(S.applyPurchaseId);
    })), e.materialType & (T.MATERIAL.V | T.OTHER.V) && ((x = e.list) == null || x.forEach((S) => {
      n.push(S.applyPurchaseId);
    })), e.actualRequisitionIds = hs(n);
  });
  function He() {
    re.value = true, xe(w.state.config.getTreeClickTime) && w.dispatch("fetchTreeClickTime"), ce(() => {
      var n;
      return (n = be.value) == null ? void 0 : n.openInit();
    });
  }
  function We(n) {
    var l;
    e.materialType & T.MANUFACTURED.V ? he(n) : (e[O[n.basicClass]].push(n), n.basicClass & e.currentBasicClass && ((l = N.value) == null || l.rowWatch(n)));
  }
  function De() {
    F.value && F.value.clear();
  }
  t.HOOK.beforeToEdit = async (n, l) => {
    var c;
    (c = N.value) == null || c.setFormCallback(l);
  }, t.HOOK.beforeToCU = () => {
    let n;
    e.materialType & T.MANUFACTURED.V || (n = ae(N, () => {
      var l;
      N.value && n && N.value.setFormCallback && ((l = N.value) == null || l.setFormCallback(e), n());
    }, { immediate: true }));
  }, t.HOOK.afterToCU = () => {
    e.clickAddTime = (/* @__PURE__ */ new Date()).getTime();
  }, t.HOOK.beforeValidateCU = () => {
    y.value = false;
  }, t.HOOK.beforeSubmit = () => {
    var n;
    if (e.weightMeasurementMode = void 0, e.clickTime = w.state.config.getTreeClickTime, !((n = N.value) != null && n.validate()) && !e.boolUsed) return false;
    if (W(me.value)) return z.error("请先删除标红数据并重新添加"), false;
  }, t.HOOK.afterSubmit = () => {
    P("success");
  }, f.submitFormFormat = async (n) => (n.attachmentIds = n.attachments ? n.attachments.map((l) => l.id) : void 0, n.auxMaterialIds = n.isAllMaterial ? [0] : n.auxMaterialIds, n.otherMaterialIds = n.isAllOtherMaterial ? [0] : n.otherMaterialIds, n.useRequisitions && (n.applyPurchaseIds = n.actualRequisitionIds), Y.value ? (n.projectIds = [n.projectId], n.list = [], N != null && N.value && (N == null ? void 0 : N.value.fetchResList()).forEach((c) => {
    const { curPurchaseQuantity: E, basicClass: x } = n.manufListObj[c.rowKey];
    n.list.push({ artifactEnclosureId: c.id, quantity: E, basicClass: x, pricingMethod: c.pricingMethod, unitPrice: c.unitPrice, amount: c.amount, destination: c.destination });
  })) : n.list = await bs(n.list, { toSmallest: true, toNum: true }), n.useRequisitions && n.list.forEach((l) => {
    l.applyPurchaseDetailId || (l.applyPurchaseDetailId = l.id);
  }), n);
  async function Ke() {
    try {
      await f.submit();
    } catch (n) {
      console.log("采购合同提交", n);
    }
  }
  return (n, l) => {
    const c = te("common-button"), E = te("common-radio"), x = ss, S = as, se = is, k = te("common-radio-button"), ze = ts, Qe = ls, Ge = ns, oe = te("common-drawer");
    return M(), q("div", null, [V("div", zs, [V("div", null, [Je(n.$slots, "chose", {}, void 0, true)]), V("div", Qs, [d(c, { loading: s(f).status.edit === s(t).STATUS.PROCESSING, size: "default", type: "primary", onClick: Ke }, { default: b(() => l[26] || (l[26] = [H(" 提 交 ")])), _: 1, __: [26] }, 8, ["loading"]), g.edit ? I("", true) : (M(), v(Ts, { key: 0, type: "cu", onClear: De }))])]), V("div", Gs, [d(Ge, { ref_key: "detailFormRef", ref: h, model: s(e), rules: u.value, "label-position": "right", "label-width": "110px", size: "default" }, { default: b(() => [V("div", { style: ue(`height: ${p.maxHeight.value}px`), class: "form-content" }, [V("div", { style: ue(y.value ? "width:0px;padding:0;" : ""), class: "form-left" }, [V("div", Xs, [d(x, { label: "是否绑定申购", prop: "useRequisitions", required: "" }, { default: b(() => [d(E, { modelValue: s(e).useRequisitions, "onUpdate:modelValue": l[0] || (l[0] = (o) => s(e).useRequisitions = o), disabled: !!s(e).boolUsed, options: s(_s).ENUM, type: "enum", onChange: pe }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), d(x, { class: "el-form-item-1", label: "采购合同编号", prop: "serialNumber" }, { default: b(() => [d(S, { modelValue: s(e).serialNumber, "onUpdate:modelValue": l[1] || (l[1] = (o) => s(e).serialNumber = o), modelModifiers: { trim: true }, disabled: !!s(e).boolUsed, class: "input-underline", maxlength: "30", placeholder: "可输入采购合同编号（不填写则自动生成）", size: "default" }, null, 8, ["modelValue", "disabled"])]), _: 1 }), d(x, { class: "el-form-item-3", label: "材料类型", prop: "materialType" }, { default: b(() => [d(E, { modelValue: s(e).materialType, "onUpdate:modelValue": l[2] || (l[2] = (o) => s(e).materialType = o), disabled: !!s(e).boolUsed, disabledVal: [s(T).MANUFACTURED.V], options: s(T).ENUM, type: "enum" }, null, 8, ["modelValue", "disabled", "disabledVal", "options"])]), _: 1 }), s(e).materialType & s(T).MATERIAL.V && !s(e).useRequisitions ? (M(), v(x, { key: 0, class: "el-form-item-5", label: "辅材明细", prop: "auxMaterialIds" }, { default: b(() => [V("div", Js, [d(se, { modelValue: s(e).isAllMaterial, "onUpdate:modelValue": l[3] || (l[3] = (o) => s(e).isAllMaterial = o), disabled: s(e).boolUsed, border: "", label: "所有辅材", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), d(Ve, { modelValue: s(e).auxMaterialIds, "onUpdate:modelValue": l[4] || (l[4] = (o) => s(e).auxMaterialIds = o), "basic-class": s(_).MATERIAL.V, "collapse-tags": false, deep: 2, disabled: s(e).boolUsed ? !!s(e).boolUsed : s(e).isAllMaterial, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择辅材", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : I("", true), s(e).materialType & s(T).OTHER.V && !s(e).useRequisitions ? (M(), v(x, { key: 1, class: "el-form-item-5", label: "其它明细", prop: "otherMaterialIds" }, { default: b(() => [V("div", Zs, [d(se, { modelValue: s(e).isAllOtherMaterial, "onUpdate:modelValue": l[5] || (l[5] = (o) => s(e).isAllOtherMaterial = o), disabled: s(e).boolUsed, border: "", label: "所有其它科目", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), d(Ve, { modelValue: s(e).otherMaterialIds, "onUpdate:modelValue": l[6] || (l[6] = (o) => s(e).otherMaterialIds = o), "basic-class": s(_).OTHER.V, "collapse-tags": false, deep: 2, disabled: s(e).boolUsed ? !!s(e).boolUsed : s(e).otherMaterialIds, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择其它科目", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : I("", true), !s(e).useRequisitions && Y.value ? (M(), v(x, { key: 2, class: "el-form-item-4", label: "选择项目", prop: "projectId" }, { default: b(() => [d(we, { modelValue: s(e).projectId, "onUpdate:modelValue": l[7] || (l[7] = (o) => s(e).projectId = o), disabled: !!s(e).boolUsed, class: "input-underline", clearable: "" }, null, 8, ["modelValue", "disabled"])]), _: 1 })) : I("", true), d(x, { class: "el-form-item-7", label: "供应商", prop: "supplierId" }, { default: b(() => [d(Es, { modelValue: s(e).supplierId, "onUpdate:modelValue": l[8] || (l[8] = (o) => s(e).supplierId = o), "basic-class": s(e).basicClass, disabled: !!s(e).boolUsed, type: s(e).purchaseType, class: "input-underline", clearable: "", filterable: "", mode: "cross" }, null, 8, ["modelValue", "basic-class", "disabled", "type"])]), _: 1 }), d(x, { class: "el-form-item-18", label: "签订主体", prop: "branchCompanyId" }, { default: b(() => [d(Cs, { modelValue: s(e).branchCompanyId, "onUpdate:modelValue": l[9] || (l[9] = (o) => s(e).branchCompanyId = o), disabled: !!s(e).boolUsed, class: "input-underline", default: "", placeholder: "合同签订主体", style: { width: "100%" } }, null, 8, ["modelValue", "disabled"])]), _: 1 }), d(x, { class: "el-form-item-10", label: "发票及税率", prop: "invoiceType" }, { default: b(() => [d(Ms, { invoiceType: s(e).invoiceType, "onUpdate:invoiceType": l[10] || (l[10] = (o) => s(e).invoiceType = o), taxRate: s(e).taxRate, "onUpdate:taxRate": l[11] || (l[11] = (o) => s(e).taxRate = o), classification: s(e).materialType, disabled: !!s(e).boolUsed, class: "input-underline" }, null, 8, ["invoiceType", "taxRate", "classification", "disabled"])]), _: 1 }), d(x, { class: "el-form-item-13", label: "订单类型", prop: "purchaseOrderPaymentMode" }, { default: b(() => [d(E, { modelValue: s(e).purchaseOrderPaymentMode, "onUpdate:modelValue": l[12] || (l[12] = (o) => s(e).purchaseOrderPaymentMode = o), disabled: !!s(e).boolUsed, options: s(Vs).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), d(x, { class: "el-form-item-16", label: "物流运输方式", prop: "logisticsTransportType" }, { default: b(() => [d(E, { modelValue: s(e).logisticsTransportType, "onUpdate:modelValue": l[13] || (l[13] = (o) => s(e).logisticsTransportType = o), disabled: !!s(e).boolUsed, options: s(ws).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), d(x, { class: "el-form-item-17", label: "物流费用承担", prop: "logisticsPayerType" }, { default: b(() => [d(E, { modelValue: s(e).logisticsPayerType, "onUpdate:modelValue": l[14] || (l[14] = (o) => s(e).logisticsPayerType = o), disabled: !!s(e).boolUsed, options: s(xs).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), !s(e).useRequisitions && !Y.value ? (M(), v(x, { key: 3, class: "el-form-item-4", label: "选择项目", "label-width": "80px", prop: "projectIds" }, { default: b(() => [d(we, { modelValue: s(e).projectIds, "onUpdate:modelValue": l[15] || (l[15] = (o) => s(e).projectIds = o), disabled: !!s(e).boolUsed, class: "input-underline", clearable: "", multiple: "" }, null, 8, ["modelValue", "disabled"])]), _: 1 })) : I("", true), d(x, { class: "el-form-item-14", "label-width": "0", prop: "remark" }, { default: b(() => [d(S, { modelValue: s(e).remark, "onUpdate:modelValue": l[16] || (l[16] = (o) => s(e).remark = o), rows: 3, maxlength: "1000", placeholder: "备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }), d(Us, { files: s(e).attachments, "onUpdate:files": l[17] || (l[17] = (o) => s(e).attachments = o), "file-classify": s(Is).PURCHASE_ORDER_ATT.V, class: "el-form-item-15", "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])])], 4), V("div", { style: ue(y.value ? "display:none;" : ""), class: "vertical-dashed-divider" }, null, 4), V("div", ea, [d(Ps, { "is-active": y.value, class: "hamburger-container", onToggleClick: l[18] || (l[18] = (o) => y.value = !y.value) }, null, 8, ["is-active"]), s(e).useRequisitions ? (M(), q("div", sa, [V("span", aa, [l[27] || (l[27] = V("span", { class: "label" }, "关联申购单号", -1)), s(e).materialType & s(T).STEEL.V && !s(e).boolUsed ? (M(), v(k, { key: 0, modelValue: s(e).currentBasicClass, "onUpdate:modelValue": l[19] || (l[19] = (o) => s(e).currentBasicClass = o), disabledVal: [s(de).STEEL_COIL.V], options: s(de).ENUM, clearable: "", style: { "vertical-align": "middle", "margin-right": "6px" }, type: "enum" }, { suffix: b(({ item: o }) => {
      var $, B;
      return [($ = s(e)[O[o.V]]) != null && $.length ? (M(), q("span", ia, "(" + j((B = s(e)[O[o.V]]) == null ? void 0 : B.length) + ")", 1)) : I("", true)];
    }), _: 1 }, 8, ["modelValue", "disabledVal", "options"])) : I("", true), (M(true), q(Ee, null, Ze(s(e).actualRequisitionIds, (o) => (M(), v(ze, { key: o, class: "preparation-sn-tag", effect: "plain" }, { default: b(() => {
      var $, B;
      return [H(j((B = ($ = s(e).requisitionsKV) == null ? void 0 : $[o]) == null ? void 0 : B.serialNumber), 1)];
    }), _: 2 }, 1024))), 128))]), s(e).boolUsed ? I("", true) : (M(), q("span", ta, [d(c, { size: "default", type: "success", onClick: He }, { default: b(() => l[28] || (l[28] = [H(" 选择申购物料 ")])), _: 1, __: [28] })]))])) : I("", true), s(e).useRequisitions ? I("", true) : (M(), q("div", la, [V("span", na, [l[29] || (l[29] = V("span", { class: "label" }, "采购清单", -1)), s(e).materialType & s(T).STEEL.V && !s(e).boolUsed ? (M(), v(k, { key: 0, modelValue: s(e).currentBasicClass, "onUpdate:modelValue": l[20] || (l[20] = (o) => s(e).currentBasicClass = o), disabledVal: [], options: s(de).ENUM, clearable: "", style: { "vertical-align": "middle" }, type: "enum" }, { suffix: b(({ item: o }) => {
      var $, B;
      return [($ = s(e)[O[o.V]]) != null && $.length ? (M(), q("span", ra, "(" + j((B = s(e)[O[o.V]]) == null ? void 0 : B.length) + ")", 1)) : I("", true)];
    }), _: 1 }, 8, ["modelValue", "options"])) : I("", true)]), s(e).boolUsed ? I("", true) : (M(), q("span", oa, [!Y.value && !s(e).boolUsed ? (M(), v(c, { key: 0, class: "filter-item", size: "default", type: "success", onClick: Ye }, { default: b(() => l[30] || (l[30] = [H(" 添加物料 ")])), _: 1, __: [30] })) : I("", true), Y.value ? I("", true) : (M(), v(Ns, { key: 1, template: qe.value, "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload", "open-loading": "", style: { "margin-left": "10px" }, onSuccess: je }, null, 8, ["template"])), Y.value ? I("", true) : (M(), v(vs, { key: 2, fn: s(Ss), params: { basicClass: s(e).currentBasicClass, receiptType: s(Ls).PURCHASE.V }, class: "filter-item", style: { "margin-left": "10px" }, type: "info" }, { default: b(() => [H(j(s(_).VL[s(e).currentBasicClass]) + "清单模板下载 ", 1)]), _: 1 }, 8, ["fn", "params"])), d(Qe, { disabled: !!s(e).projectId, content: "请先选择项目", effect: "light", placement: "left-start" }, { default: b(() => [V("span", null, [Y.value ? (M(), v(c, { key: 0, disabled: !s(e).projectId, class: "filter-item", icon: "el-icon-plus", size: "default", type: "success", onClick: l[21] || (l[21] = (o) => K.value = true) }, { default: b(() => l[31] || (l[31] = [H(" 添加制成品 ")])), _: 1, __: [31] }, 8, ["disabled"])) : I("", true)])]), _: 1 }, 8, ["disabled"])]))])), s(e).boolUsed ? (M(), v(Rs, { key: 3, "bool-use-requisitions": s(e).useRequisitions, list: s(e).details, "material-type": s(e).materialType, "max-height": p.maxHeight - 150 }, null, 8, ["bool-use-requisitions", "list", "material-type", "max-height"])) : (M(), v(es(ke.value), { key: 2, ref_key: "compRef", ref: N, maxHeight: p.maxHeight - 150 }, null, 8, ["maxHeight"])), V("div", ca, [s(e).materialType & (s(T).MATERIAL.V | s(T).OTHER.V) ? I("", true) : (M(), q(Ee, { key: 0 }, [l[32] || (l[32] = V("span", { class: "title" }, "合同量", -1)), V("span", ua, [V("span", null, j(s(e).mete), 1), V("span", null, j(s(e).meteUnit), 1)])], 64)), l[33] || (l[33] = V("span", { class: "title" }, "合同额", -1)), V("span", da, j(s(e).amount) + " 元", 1)])])], 4)]), _: 1 }, 8, ["model", "rules"])]), d(oe, { modelValue: re.value, "onUpdate:modelValue": l[22] || (l[22] = (o) => re.value = o), "custom-class": "material-requisition-select", direction: "btt", size: "70%", title: "申购选择" }, { titleRight: b(() => l[34] || (l[34] = [])), content: b(() => [d(ks, { ref_key: "requisitionListRef", ref: be, onAddPurchase: We }, null, 512)]), _: 1 }, 8, ["modelValue"]), d(oe, { ref_key: "materialSpecSelectDrawer", ref: ye, modelValue: ee.value, "onUpdate:modelValue": l[24] || (l[24] = (o) => ee.value = o), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: b(() => [d(As, { ref_key: "matSpecRef", ref: F, modelValue: s(e)[O[s(e).currentBasicClass]], "onUpdate:modelValue": l[23] || (l[23] = (o) => s(e)[O[s(e).currentBasicClass]] = o), "basic-class": s(e).currentBasicClass, "classify-ids": s(e).materialType & s(T).MATERIAL.V ? s(e).auxMaterialIds : s(e).materialType & s(T).OTHER.V ? s(e).otherMaterialIds : [], "max-height": s(Oe), "row-init-fn": Be, "table-width": 350, visible: ee.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "classify-ids", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), d(oe, { ref_key: "manufSelectDrawerRef", ref: ge, modelValue: K.value, "onUpdate:modelValue": l[25] || (l[25] = (o) => K.value = o), "custom-class": "manufactured-select-drawer", "show-close": "", size: "80%", title: "制成品选择" }, { content: b(() => [d(qs, { maxHeight: s($e), "project-id": s(e).projectId, visible: K.value, onAdd: he }, null, 8, ["maxHeight", "project-id", "visible"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Sa = ds(fa, [["__scopeId", "data-v-d86b0384"]]);
export {
  Sa as default
};

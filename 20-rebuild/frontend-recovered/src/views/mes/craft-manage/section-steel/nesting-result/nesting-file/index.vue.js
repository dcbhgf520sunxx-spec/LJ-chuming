import { ref as N } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as i } from "vue";
import { createBlock as g } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { withKeys as X } from "vue";
import { withModifiers as M } from "vue";
import { createTextVNode as I } from "vue";
import { withDirectives as C } from "vue";
import { vShow as Z } from "vue";
import { createCommentVNode as k } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as r } from "vue";
import { createElementBlock as w } from "vue";
import { Fragment as ee } from "vue";
import { renderList as te } from "vue";
import { normalizeStyle as ne } from "vue";
import { isRef as ae } from "vue";
import { ElInput as le } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElTooltip as se } from "element-plus";
import { ElTag as ie } from "element-plus";
import { vLoading as re } from "element-plus";
import { l as y, nn as d, u as ue, no as E, np as me, o as pe, L as de, nl as ce, ca as ge, nq as B } from "../../../../../../shared/runtime.js";
import { n as fe } from "../../../../../../modules/nesting-setting-83aca0bd.js";
function _e(s) {
  return y({ module: "mes", url: "section_steel/nesting/wait/batch/project", method: "get", params: s });
}
function Ie(s) {
  return y({ module: "mes", url: "section_steel/nesting/wait/batch/list", method: "get", params: s });
}
function Se(s) {
  return y({ module: "mes", url: "section_steel/nesting/wait/monomer_area/list", method: "get", params: s });
}
function Ve(s) {
  return y({ module: "mes", url: "section_steel/nesting/wait/batch", method: "post", data: s });
}
function Re(s) {
  return y({ module: "mes", url: "section_steel/nesting/wait/batch", method: "delete", data: s });
}
function he(s) {
  return y({ module: "mes", url: "section_steel/nesting/list/batch", method: "get", params: s });
}
function ye(s) {
  return y({ module: "mes", url: "section_steel/nesting/export/batch", method: "get", responseType: "blob", params: s });
}
const De = { get: _e };
const we = { key: 0, style: { width: "100%", display: "flex" } }, be = { key: 0 }, ve = { key: 1 }, Le = { key: 0 }, Ne = { key: 1 }, ke = { __name: "index", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, monomerId: { type: Number }, areaId: { type: Number } }, emits: ["success"], setup(s, { emit: F }) {
  const T = N([]), b = N(false), c = N(d.NESTING_FILE.V), f = N(), j = F, p = s, { visible: S, handleClose: U } = ue({ emit: j, props: p, field: "visible", showHook: z });
  function z() {
    c.value = d.NESTING_FILE.V, v();
  }
  const V = N({});
  async function v() {
    try {
      b.value = true;
      const { content: u } = await fe({ batchId: p.detailData.id, serialNumber: f.value, monomerId: p.monomerId, areaId: p.areaId });
      u[0].typesettingDTOS.forEach((t) => {
        var _;
        t.assembleLength = t.typesettingTypeEnum === E.UN_LOSSY.V ? 0 : t.length, t.linkDOList.map((h) => {
          V.value[h.serialNumber] || (V.value[h.serialNumber] = me()), h.lengthColor = V.value[h.serialNumber], t.typesettingTypeEnum === E.UN_LOSSY.V && (t.assembleLength += h.length);
        }), t.areaName = (_ = t.areaName) == null ? void 0 : _.join(",");
      }), T.value = u[0].typesettingDTOS;
    } catch {
      console.log("获取套料文件失败");
    } finally {
      b.value = false;
    }
  }
  async function R() {
    try {
      b.value = true;
      const { content: u } = await he({ id: p.detailData.id, serialNumber: f.value, monomerId: p.monomerId, areaId: p.areaId });
      console.log(u), u[0].typesettingDTOS.forEach((t) => {
        var _;
        t.areaName = (_ = t.areaName) == null ? void 0 : _.join(",");
      }), T.value = u[0].typesettingDTOS;
    } catch {
      console.log("获取材料清单失败");
    } finally {
      b.value = false;
    }
  }
  function G(u) {
    f.value = void 0, u === d.MATERIAL_LIST.V ? R() : v();
  }
  function H() {
    c.value === d.MATERIAL_LIST.V ? R() : v();
  }
  function q() {
    v();
  }
  function Y() {
    c.value = d.NESTING_FILE.V, f.value = void 0, v();
  }
  const { maxHeight: $ } = pe({ mainBox: ".common-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 });
  return (u, t) => {
    const _ = x("common-radio-button"), h = le, D = x("common-button"), l = oe, O = x("common-table"), A = se, P = ie, W = x("common-drawer"), K = J("permission"), Q = re;
    return i(), g(W, { "before-close": o(U), "show-close": true, size: "90%", modal: "", "append-to-body": "", visible: o(S), "onUpdate:visible": t[2] || (t[2] = (e) => ae(S) ? S.value = e : null) }, { titleAfter: n(() => [a(_, { style: { "margin-right": "8px" }, class: "filter-item", modelValue: c.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => c.value = e), options: o(d).ENUM, type: "enum", size: "default", onChange: G }, null, 8, ["modelValue", "options"]), a(h, { modelValue: f.value, "onUpdate:modelValue": t[1] || (t[1] = (e) => f.value = e), modelModifiers: { trim: true }, placeholder: "输入构件编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: X(H, ["enter"]) }, null, 8, ["modelValue"]), a(D, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: M(q, ["stop"]) }, { default: n(() => t[3] || (t[3] = [I("搜索")])), _: 1, __: [3] }), a(D, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: M(Y, ["stop"]) }, { default: n(() => t[4] || (t[4] = [I(" 重置 ")])), _: 1, __: [4] })]), titleRight: n(() => [C((i(), g(de, { class: "filter-item", fn: o(ye), params: { id: p.detailData.id, serialNumber: f.value, monomerId: p.monomerId, areaId: p.areaId }, disabled: T.value.length === 0 }, { default: n(() => t[5] || (t[5] = [I(" 材料清单 ")])), _: 1, __: [5] }, 8, ["fn", "params", "disabled"])), [[K, o(ce).downloadList], [Z, c.value === o(d).MATERIAL_LIST.V]])]), content: n(() => [C((i(), g(O, { ref: "tableRef", data: T.value, "max-height": o($), style: { width: "100%" }, "row-key": "id" }, { default: n(() => [c.value === o(d).MATERIAL_LIST.V ? (i(), g(l, { key: 0, type: "expand" }, { default: n((e) => [a(O, { data: e.row.linkDOList }, { default: n(() => [a(l, { label: "单体", prop: "monomerName", align: "center" }), a(l, { label: "区域", prop: "areaName", align: "center" }), a(l, { label: "包含部件", prop: "serialNumber", align: "center" }), a(l, { label: "构件编号", prop: "artifactSerialNumber", align: "center" }), a(l, { label: "长度（mm）", prop: "length", align: "center" }), a(l, { label: "重量（kg）", prop: "netWeight", align: "center" }), a(l, { label: "数量", prop: "quantity", align: "center" })]), _: 2 }, 1032, ["data"])]), _: 1 })) : k("", true), a(l, { label: "序号", type: "index", align: "center", width: "60" }), a(l, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "套料编号", align: "left", width: "240px" }, { default: n((e) => [m("span", null, r(e.row.serialNumber), 1)]), _: 1 }), c.value === o(d).NESTING_FILE.V ? (i(), g(l, { key: "nestingResult", prop: "nestingResult", label: "套料成果", "header-align": "center", width: "600px" }, { default: n((e) => [e.row.linkDOList.length > 0 ? (i(), w("div", we, [(i(true), w(ee, null, te(e.row.linkDOList, (L) => (i(), g(A, { key: L, effect: "dark", content: L.serialNumber, placement: "top-start" }, { default: n(() => [m("div", { class: "assemble-shadow", style: ne(`width:${(L.length / e.row.assembleLength * 100).toFixed(2)}%; background-color: ${L.lengthColor}; margin-left: ${e.row.kerfLength / e.row.assembleLength * 100}% ;margin-right: ${e.row.kerfLength / e.row.assembleLength * 100}%`) }, r(L.serialNumber), 5)]), _: 2 }, 1032, ["content"]))), 128)), e.row.typesettingTypeEnum === o(E).LOSSY.V ? (i(), g(A, { key: 0, effect: "dark", content: "余料", placement: "top-start" }, { default: n(() => t[6] || (t[6] = [m("div", { class: "shadow", style: { flex: "1" } }, null, -1)])), _: 1, __: [6] })) : k("", true)])) : k("", true)]), _: 1 })) : k("", true), a(l, { key: "typesettingAssembleTypeEnum", prop: "typesettingAssembleTypeEnum", "show-overflow-tooltip": true, label: "材料属性", align: "center", width: "110px" }, { default: n((e) => [m("span", null, r(e.row.typesettingAssembleTypeEnum ? o(ge).VL[e.row.typesettingAssembleTypeEnum] : "-"), 1)]), _: 1 }), a(l, { key: "areaName", prop: "areaName", "show-overflow-tooltip": true, label: "区域", align: "center", width: "120px" }, { default: n((e) => [m("span", null, r(e.row.areaName), 1)]), _: 1 }), a(l, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "母材长度（mm）", align: "center", width: "120px" }, { default: n((e) => [e.row.typesettingTypeEnum === o(E).UN_LOSSY.V ? (i(), w("span", be, "-")) : (i(), w("span", ve, r(e.row.length), 1))]), _: 1 }), a(l, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "母材规格", align: "center", width: "200px" }, { default: n((e) => [m("span", null, r(e.row.specification), 1)]), _: 1 }), a(l, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", align: "center" }, { default: n((e) => [m("span", null, r(e.row.material), 1)]), _: 1 }), a(l, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "母材总重", align: "center", width: "100px" }, { default: n((e) => [e.row.typesettingTypeEnum === o(E).UN_LOSSY.V ? (i(), w("span", Le, "-")) : (i(), w("span", Ne, r(e.row.netWeight), 1))]), _: 1 }), a(l, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", width: "60px" }, { default: n((e) => [m("span", null, r(e.row.quantity), 1)]), _: 1 }), a(l, { key: "typesettingLength", prop: "typesettingLength", "show-overflow-tooltip": true, label: "套料长度（mm）", align: "center", width: "120px" }, { default: n((e) => [m("span", null, r(e.row.typesettingLength), 1)]), _: 1 }), a(l, { key: "lossRate", prop: "lossRate", "show-overflow-tooltip": true, label: "套料损耗", align: "center", width: "70px" }, { default: n((e) => [m("span", null, r(e.row.lossRate) + "%", 1)]), _: 1 }), a(l, { key: "kerfLossRate", prop: "kerfLossRate", "show-overflow-tooltip": true, label: "原材料损耗（mm）", align: "center", width: "140px" }, { default: n((e) => [m("span", null, r(e.row.kerfLossRate), 1)]), _: 1 }), c.value === o(d).NESTING_FILE.V ? (i(), g(l, { key: "statusEnum", prop: "statusEnum", "show-overflow-tooltip": true, label: "状态", align: "center", fixed: "right", width: "100px" }, { default: n((e) => [a(P, { type: o(B).V[e.row.statusEnum].T }, { default: n(() => [I(r(o(B).VL[e.row.statusEnum]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : k("", true)]), _: 1 }, 8, ["data", "max-height"])), [[Q, b.value]])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, Oe = Object.freeze(Object.defineProperty({ __proto__: null, default: ke }, Symbol.toStringTag, { value: "Module" }));
export {
  ke as _,
  Se as a,
  Re as b,
  De as c,
  Ve as d,
  Oe as i,
  Ie as n
};

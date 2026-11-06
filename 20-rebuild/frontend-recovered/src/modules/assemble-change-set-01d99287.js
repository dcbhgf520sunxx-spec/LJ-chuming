import { computed as E } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as a } from "vue";
import { createBlock as y } from "vue";
import { withCtx as h } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as r } from "vue";
import { unref as s } from "vue";
import { createElementBlock as m } from "vue";
import { ElTableColumn as $ } from "element-plus";
import { Fragment as S } from "vue";
import { renderList as q } from "vue";
import { createCommentVNode as U } from "vue";
import { ref as Z } from "vue";
import { normalizeClass as ee } from "vue";
import { createTextVNode as te } from "vue";
import { ElInputNumber as le } from "element-plus";
import { ElTag as ae } from "element-plus";
import { iX as W, _ as ne, aR as se } from "../shared/runtime.js";
import { b as x } from "./machine-part-change-table-207fbedf.js";
import { b as v, a as w } from "./common-ac6e385c.js";
const oe = { style: { "font-weight": "bold" } }, ie = { key: 1 }, de = { key: 1 }, ue = { key: 1 }, ce = { key: 1 }, Se = { __name: "artifact-change-table", props: { newArtifact: { type: Object, default: () => {
} }, oldArtifact: { type: Object, default: () => {
} } }, setup(j) {
  const d = j, N = E(() => {
    const _ = { length: p("length"), quantity: p("quantity"), netWeight: p("netWeight", 2), totalNetWeight: p("totalNetWeight", 2) };
    return [{ title: "原构件", isDiff: false, ...d.oldArtifact }, { title: "现构件", isDiff: false, ...d.newArtifact }, { title: "差异", isDiff: true, ..._ }];
  });
  function p(_, V = 0) {
    var f, O;
    return W((((f = d.oldArtifact) == null ? void 0 : f[_]) || 0) - (((O = d.newArtifact) == null ? void 0 : O[_]) || 0), V);
  }
  return (_, V) => {
    const f = $, O = A("common-table");
    return a(), y(O, { "header-cell-style": { "font-weight": "bold", color: "#333333" }, data: N.value, style: { width: "100%" } }, { default: h(() => [i(f, { align: "center", width: "70" }, { default: h(({ row: n }) => [b("span", oe, r(n.title), 1)]), _: 1 }), i(f, { label: "编号", prop: "serialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "120" }), i(f, { label: "规格", prop: "specification", "show-overflow-tooltip": "", align: "left", "min-width": "150" }), i(f, { label: "长度(mm)", prop: "length", "show-overflow-tooltip": "", align: "center", width: "100" }, { default: h(({ row: n }) => [n.isDiff ? (a(), y(s(x), { key: 0, value: n.length }, null, 8, ["value"])) : (a(), m("span", ie, r(n.length), 1))]), _: 1 }), i(f, { label: "总数量", prop: "quantity", "show-overflow-tooltip": "", align: "center", width: "100" }, { default: h(({ row: n }) => [n.isDiff ? (a(), y(s(x), { key: 0, value: n.quantity }, null, 8, ["value"])) : (a(), m("span", de, r(n.quantity), 1))]), _: 1 }), i(f, { label: "单重(kg)", prop: "netWeight", "show-overflow-tooltip": "", align: "center", width: "100" }, { default: h(({ row: n }) => [n.isDiff ? (a(), y(s(x), { key: 0, value: n.netWeight }, null, 8, ["value"])) : (a(), m("span", ue, r(n.netWeight), 1))]), _: 1 }), i(f, { label: "总重(kg)", prop: "totalNetWeight", "show-overflow-tooltip": "", align: "center", width: "100" }, { default: h(({ row: n }) => [n.isDiff ? (a(), y(s(x), { key: 0, value: n.totalNetWeight }, null, 8, ["value"])) : (a(), m("span", ce, r(n.totalNetWeight), 1))]), _: 1 })]), _: 1 }, 8, ["data"]);
  };
} }, re = { style: { color: "#0078fc" } }, he = { style: { "font-weight": "bold" } }, pe = { key: 1 }, We = { __name: "artifact-area-change-table", props: { areaList: { type: Object, default: () => {
} } }, setup(j) {
  const d = j, N = E(() => {
    const _ = {};
    for (const V of d.areaList) _[V.id] = { ...V, diff: (V.oldQuantity || 0) - (V.newQuantity || 0) };
    return _;
  }), p = E(() => [{ title: "原数量", isDiff: false, field: "oldQuantity" }, { title: "现数量", isDiff: false, field: "newQuantity" }, { title: "差异", isDiff: true, field: "diff" }]);
  return (_, V) => {
    var n;
    const f = $, O = A("common-table");
    return (n = d.areaList) != null && n.length ? (a(), y(O, { key: 0, "header-cell-style": { "font-weight": "bold", color: "#333333" }, data: p.value, style: { width: "100%" } }, { default: h(() => [i(f, { align: "center", width: "80" }, { header: h(() => {
      var e;
      return [b("span", re, "共" + r((e = d.areaList) == null ? void 0 : e.length) + "个区域", 1)];
    }), default: h(({ row: e }) => [b("span", he, r(e.title), 1)]), _: 1 }), (a(true), m(S, null, q(d.areaList, (e) => (a(), y(f, { key: e.id, label: e.name, align: "center", "min-width": "120" }, { default: h(({ row: l }) => {
      var o, u, k, g;
      return [l.isDiff ? (a(), y(s(x), { key: 0, value: (u = (o = N.value) == null ? void 0 : o[e.id]) == null ? void 0 : u[l.field] }, null, 8, ["value"])) : (a(), m("span", pe, r(((g = (k = N.value) == null ? void 0 : k[e.id]) == null ? void 0 : g[l.field]) || "-"), 1))];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["data"])) : U("", true);
  };
} };
const fe = { key: 0, class: "set-con" }, me = { class: "diff-con" }, _e = { class: "diff-item" }, be = { style: { flex: "0.5", "text-align": "left" } }, ye = { style: { flex: "0.25" } }, ge = { style: { width: "90px" } }, Ne = { key: 0 }, Ve = { style: { flex: "0.25" } }, ke = { class: "diff-item" }, ve = { class: "method-opt" }, Te = ["onClick"], je = { style: { "font-weight": "bold" } }, Oe = { key: 0 }, De = { key: 2 }, xe = { __name: "assemble-change-set", props: { newAssembleList: { type: Array, default: () => [] }, oldAssembleList: { type: Array, default: () => [] }, assembleInfo: { type: Object, default: () => {
} }, onlyShow: { type: Boolean, default: false } }, setup(j) {
  const d = j, N = Z([]), p = E(() => {
    var e;
    return ((e = d.assembleInfo) == null ? void 0 : e.needHandleOldObj) || {};
  }), _ = E(() => {
    var e;
    return ((e = d.assembleInfo) == null ? void 0 : e.needHandleNewObj) || {};
  });
  function V(e) {
    let l = [];
    for (let o = 0; o < d.newAssembleList.length; o++) {
      if (e === o) continue;
      const u = d.newAssembleList[o];
      typeof u.oldSerialNumbers != "object" && (u.oldSerialNumbers = []);
      const k = [];
      for (const g of u.oldSerialNumbers) u.handleObj[g].quantity === p[g].quantity && k.push(g);
      l = [...l, ...k];
    }
    return l;
  }
  function f(e, l) {
    e === w.NEW.V && (l.oldSerialNumbers = []);
  }
  function O(e, l) {
    if (e != null && e.length && !N.value.includes(l.serialNumber) && N.value.push(l.serialNumber), e != null && e.length && !l.operateType && (l.operateType = w.EDIT.V), (!l.handleObj || !(e != null && e.length)) && (l.handleObj = {}), e != null && e.length) for (const o of e) l.handleObj[o] || (l.handleObj[o] = { quantity: p.value[o].quantity, netWeight: p.value[o].netWeight });
  }
  function n(e, l, o) {
    var u, k, g, C, L;
    o === v.ADD_LENGTH.V && !(((k = (u = e.handleObj) == null ? void 0 : u[l]) == null ? void 0 : k.handleType) & v.TRUNCATE.V) || o === v.TRUNCATE.V && !(((C = (g = e.handleObj) == null ? void 0 : g[l]) == null ? void 0 : C.handleType) & v.ADD_LENGTH.V) || d.onlyShow || (((L = e.handleObj[l]) == null ? void 0 : L.handleType) & o ? e.handleObj[l].handleType -= o : e.handleObj[l].handleType |= o);
  }
  return (e, l) => {
    const o = le, u = $, k = A("common-radio"), g = ae, C = A("common-select"), L = A("common-table");
    return a(), y(L, { "header-cell-style": { "font-weight": "bold", color: "#333333" }, data: j.newAssembleList, "return-source-data": "", style: { "max-width": "1100px" }, "row-key": "serialNumber", class: "assemble-change-set-table", "expand-row-keys": N.value }, { default: h(() => [i(se, { data: j.newAssembleList, "expand-row-keys": N.value, "onUpdate:expandRowKeys": l[0] || (l[0] = (t) => N.value = t), "row-key": "serialNumber" }, { default: h(({ row: t }) => {
      var D;
      return [(D = t == null ? void 0 : t.oldSerialNumbers) != null && D.length ? (a(), m("div", fe, [(a(true), m(S, null, q(t == null ? void 0 : t.oldSerialNumbers, (c) => {
        var H, B, I, R, G, M, Q, K;
        return a(), m("div", { key: c, class: "set-item" }, [b("div", me, [b("div", _e, [b("span", be, r(c) + " -> " + r(t.serialNumber), 1), b("span", ye, r((H = p.value[c]) == null ? void 0 : H.length), 1), b("span", ge, [((B = t == null ? void 0 : t.oldSerialNumbers) == null ? void 0 : B.length) === 1 || d.onlyShow ? (a(), m("span", Ne, r(t.handleObj[c].quantity), 1)) : (a(), y(o, { key: 1, modelValue: t.handleObj[c].quantity, "onUpdate:modelValue": (T) => t.handleObj[c].quantity = T, modelModifiers: { number: true }, min: 1, max: p.value.value[e.oldSN].quantity, step: 1, placeholder: "数量", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"]))]), b("span", Ve, r((I = p.value[c]) == null ? void 0 : I.netWeight), 1)]), b("div", ke, [l[1] || (l[1] = b("span", { style: { flex: "0.5", "text-align": "left" } }, "差异", -1)), i(s(x), { style: { flex: "0.25" }, value: s(W)((((R = p.value[c]) == null ? void 0 : R.length) || 0) - (((G = _.value[t.serialNumber]) == null ? void 0 : G.length) || 0)) }, null, 8, ["value"]), i(s(x), { style: { width: "90px" }, value: s(W)((t.handleObj[c].quantity || 0) - (((M = _.value[t.serialNumber]) == null ? void 0 : M.quantity) || 0)) }, null, 8, ["value"]), i(s(x), { style: { flex: "0.25" }, value: s(W)((((Q = p.value[c]) == null ? void 0 : Q.netWeight) || 0) - (((K = _.value[t.serialNumber]) == null ? void 0 : K.netWeight) || 0), 2) }, null, 8, ["value"])])]), b("div", ve, [(a(true), m(S, null, q(s(v).ENUM, (T) => {
          var P, z, F, X, J, Y;
          return a(), m(S, { key: T.V }, [T.V === s(v).KEEP.V ? (a(), m("div", { key: 0, class: ee(["method-item", { "is-active": !!(((z = (P = t.handleObj) == null ? void 0 : P[c]) == null ? void 0 : z.handleType) & T.V), "is-disabled": T.V === s(v).ADD_LENGTH.V && !(((X = (F = t.handleObj) == null ? void 0 : F[c]) == null ? void 0 : X.handleType) & s(v).TRUNCATE.V) || T.V === s(v).TRUNCATE.V && !(((Y = (J = t.handleObj) == null ? void 0 : J[c]) == null ? void 0 : Y.handleType) & s(v).ADD_LENGTH.V) }]), onClick: (we) => n(t, c, T.V) }, r(T.L), 11, Te)) : U("", true)], 64);
        }), 128))])]);
      }), 128))])) : U("", true)];
    }), _: 1 }, 8, ["data", "expand-row-keys"]), i(u, { label: "编号", prop: "serialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: h(({ row: t }) => [b("span", je, r(t.serialNumber), 1)]), _: 1 }), i(u, { label: "规格", prop: "specification", "show-overflow-tooltip": "", align: "left", "min-width": "120" }), i(u, { label: "长度(mm)", prop: "length", "show-overflow-tooltip": "", align: "center", "min-width": "110" }), i(u, { label: "数量", prop: "quantity", "show-overflow-tooltip": "", align: "center", width: "90" }), i(u, { label: "单重(kg)", prop: "netWeight", "show-overflow-tooltip": "", align: "center", "min-width": "110" }), i(u, { label: "操作", align: "center", width: "160" }, { default: h(({ row: t }) => [d.onlyShow ? (a(), y(g, { key: 1, type: s(w).V[t.operateType].T, effect: "plain" }, { default: h(() => [te(r(s(w).VL[t.operateType]), 1)]), _: 2 }, 1032, ["type"])) : (a(), y(k, { key: 0, modelValue: t.operateType, "onUpdate:modelValue": (D) => t.operateType = D, options: s(w).ENUM, unshowVal: [s(w).EDIT.V], type: "enum", onChange: (D) => f(D, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshowVal", "onChange"]))]), _: 1 }), i(u, { label: "旧部件编号", align: "center", width: "180" }, { default: h(({ row: t, $index: D }) => [t.operateType === s(w).NEW.V ? (a(), m("span", Oe, "/")) : d.onlyShow ? (a(), m("span", De, r(t.oldSerialNumbers.join("、")), 1)) : (a(), y(C, { key: 1, modelValue: t.oldSerialNumbers, "onUpdate:modelValue": (c) => t.oldSerialNumbers = c, options: j.oldAssembleList, type: "other", placeholder: "请选择", disabledVal: V(D), "data-structure": { key: "serialNumber", label: "serialNumber", value: "serialNumber" }, clearable: "", collapseTags: "", multiple: "", style: { width: "100%" }, onChange: (c) => O(c, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabledVal", "onChange"]))]), _: 1 })]), _: 1 }, 8, ["data", "expand-row-keys"]);
  };
} }, qe = ne(xe, [["__scopeId", "data-v-049b08a8"]]);
export {
  Se as _,
  We as a,
  qe as b
};

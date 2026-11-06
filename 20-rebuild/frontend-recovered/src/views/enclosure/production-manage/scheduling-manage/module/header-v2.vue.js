import { ref as c } from "vue";
import { inject as F } from "vue";
import { watch as q } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as m } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as s } from "vue";
import { withCtx as r } from "vue";
import { Fragment as A } from "vue";
import { renderList as D } from "vue";
import { createBlock as N } from "vue";
import { normalizeStyle as Q } from "vue";
import { unref as p } from "vue";
import { createTextVNode as v } from "vue";
import { ElCheckbox as j } from "element-plus";
import { ElCheckboxGroup as T } from "element-plus";
import { ElBadge as U } from "element-plus";
import { _ as H, B as G } from "../../../../../shared/runtime.js";
import { g as O } from "../../../../../modules/scheduling-manage-9a6dc016.js";
import R from "./collect.vue.js";
import "../../../../../modules/use-scheduling-groups-b1c4e979.js";
const $ = { class: "head-checkbox" }, J = { class: "left" }, K = { class: "right" }, M = { __name: "header-v2", props: { areaIds: { type: Array } }, setup(h) {
  const _ = h, k = { dictionaryId: [] }, { crud: a, query: d } = G(k), f = c([]), l = c([]);
  c([]);
  const u = c(false);
  F("enclosureDictList");
  function E(e) {
    const t = e.id !== 71 ? "#CDDEB8" : "#FFEEAE";
    return { "--bgc": e.id === 71 ? "#FFEEAE" : "#fff", "--checkBgc": t };
  }
  async function I() {
    try {
      const e = await O({ areaIds: _.areaIds }), t = Object.keys(e).map((n) => ({ id: Number(n), label: e[n] }));
      f.value = t || [];
    } catch (e) {
      console.log(e);
    }
  }
  function C() {
    l.value = a.props.selectList.map((e) => ({ ...e, totalLength: e.length * (e == null ? void 0 : e.newQuantity) }));
  }
  function x() {
    u.value = true;
  }
  function V(e) {
    a.props.selectList = e, l.value = e, a.ref.table.clearSelection(), e.forEach((t) => {
      a.ref.table.toggleRowSelection(row, true);
    });
  }
  function L(e) {
    a.query.dictionaryId = [e.id], a.toQuery(), l.value = [];
  }
  function P(e) {
  }
  function B() {
    a.props.selectList = [], l.value = [], a.ref.table.clearSelection(), a.toQuery();
  }
  return q(() => _.areaIds, (e) => {
    I(), a.query.dictionaryId = [], a.query.areaIds = e;
  }, { deep: true, immediate: true }), (e, t) => {
    var b;
    const n = j, S = T, y = z("common-button"), w = U;
    return i(), m("div", $, [g("div", J, [s(S, { modelValue: p(d).dictionaryId, "onUpdate:modelValue": t[0] || (t[0] = (o) => p(d).dictionaryId = o) }, { default: r(() => [(i(true), m(A, null, D(f.value, (o) => (i(), N(n, { key: o.id, disabled: (o.id, void 0), label: o.label, style: Q(E(o)), value: o.id, border: "", size: "default", onChange: (W) => L(o) }, null, 8, ["disabled", "label", "style", "value", "onChange"]))), 128))]), _: 1 }, 8, ["modelValue"])]), g("div", K, [s(y, { icon: "el-icon-plus", size: "default", type: "primary", onClick: C }, { default: r(() => t[2] || (t[2] = [v("添加")])), _: 1, __: [2] }), s(w, { value: (b = l.value) == null ? void 0 : b.length }, { default: r(() => {
      var o;
      return [s(y, { disabled: !((o = l.value) != null && o.length), size: "default", type: "success", onClick: x }, { default: r(() => t[3] || (t[3] = [v("汇总 ")])), _: 1, __: [3] }, 8, ["disabled"])];
    }), _: 1 }, 8, ["value"])]), s(R, { modelValue: u.value, "onUpdate:modelValue": t[1] || (t[1] = (o) => u.value = o), "collect-list": l.value, dictionaryId: p(d).dictionaryId, onSuccess: B, onUpdateList: V }, null, 8, ["modelValue", "collect-list", "dictionaryId"])]);
  };
} }, ae = H(M, [["__scopeId", "data-v-988bce20"]]);
export {
  ae as default
};

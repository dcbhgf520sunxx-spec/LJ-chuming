import { inject as T } from "vue";
import { provide as h } from "vue";
import { ref as c } from "vue";
import { reactive as j } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as P } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as r } from "vue";
import { withDirectives as B } from "vue";
import { unref as g } from "vue";
import { withCtx as _ } from "vue";
import { createTextVNode as y } from "vue";
import { ElInput as E } from "element-plus";
import { g as $, e as A } from "./config-preview.vue.js";
import { cT as q, i as F, L as J } from "../../../../../shared/runtime.js";
import D from "./config.vue.js";
import "../../../../../modules/index-61ce89a1.js";
import "../../../../../modules/use-table-change-32e98420.js";
const H = { class: "head-container" }, Q = { class: "filter-container" }, R = { class: "filter-left-box" }, G = { class: "filter-right-box" }, K = { __name: "header", setup(W, { expose: I }) {
  const N = T("permission"), O = { nameOrCode: void 0 }, C = /* @__PURE__ */ new Map([["measureUnit", "sourceMeasureUnit"], ["measurePrecision", "sourceMeasurePrecision"], ["accountingUnit", "sourceAccountingUnit"], ["accountingPrecision", "sourceAccountingPrecision"], ["outboundUnitType", "sourceOutboundUnitType"]]);
  h("sourceMap", C), h("refreshFunc", U);
  const f = c(O), u = c(/* @__PURE__ */ new Map()), m = c([]), p = c(false), a = j({ level: 3, isEdit: false, visible: false });
  U();
  async function U() {
    try {
      p.value = true;
      const { content: s } = await $();
      u.value = /* @__PURE__ */ new Map(), m.value = M(s);
    } catch (s) {
      console.log(s), m.value = [];
    } finally {
      p.value = false;
    }
  }
  function d(s) {
    a.level = s, a.visible = true;
  }
  function M(s, e = 1, o = { fullId: [], fullName: [], fullCode: [], fullSerialNumber: [] }) {
    const n = [], v = new Array(s.length);
    let i = u.value.get(e);
    return i || (i = [], u.value.set(e, i)), s.forEach((t, V) => {
      t.fullId = [...o.fullId, t.id], t.fullName = [...o.fullName, t.name], t.fullCode = [...o.fullCode, t.code], t.fullSerialNumber = [...o.fullSerialNumber, o.fullCode.join("") + t.code], v[V] = q(t, C);
      const l = {};
      Object.assign(l, JSON.parse(JSON.stringify(o)), t);
      const w = l.children;
      if (F(w)) {
        const k = { fullId: l.fullId, fullName: l.fullName, fullCode: l.fullCode, fullSerialNumber: l.fullSerialNumber, attribute: l.attribute, measureUnit: l.measureUnit, accountingUnit: l.accountingUnit, measurePrecision: l.measurePrecision, accountingPrecision: l.accountingPrecision }, L = M(w, e + 1, k);
        n.push.apply(n, L);
      } else n.push(l);
      delete t.children;
    }), i.push.apply(i, s), n;
  }
  return I({ tableData: m, tableLoading: p, query: f }), (s, e) => {
    const o = E, n = x("common-button"), v = z("permission");
    return P(), S("div", H, [b("div", Q, [b("div", R, [r(o, { modelValue: f.value.nameOrCode, "onUpdate:modelValue": e[0] || (e[0] = (i) => f.value.nameOrCode = i), modelModifiers: { trim: true }, placeholder: "输入科目名称、编号搜索", class: "filter-item", style: { width: "250px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), b("div", G, [B((P(), S("span", null, [r(J, { class: "filter-item", fn: g(A), "response-header-result": "" }, null, 8, ["fn"]), r(n, { class: "filter-item", type: "primary", size: "default", onClick: e[1] || (e[1] = (i) => d(1)) }, { default: _(() => e[5] || (e[5] = [y("一级科目设置")])), _: 1, __: [5] }), r(n, { class: "filter-item", type: "primary", size: "default", onClick: e[2] || (e[2] = (i) => d(2)) }, { default: _(() => e[6] || (e[6] = [y("二级科目设置")])), _: 1, __: [6] }), r(n, { class: "filter-item", type: "primary", size: "default", onClick: e[3] || (e[3] = (i) => d(3)) }, { default: _(() => e[7] || (e[7] = [y("三级科目设置")])), _: 1, __: [7] })])), [[v, g(N).get]])])]), r(D, { visible: a.visible, "onUpdate:visible": e[4] || (e[4] = (i) => a.visible = i), level: a.level, permission: g(N), classificationList: u.value.get(a.level) }, null, 8, ["visible", "level", "permission", "classificationList"])]);
  };
} }, oe = K;
export {
  oe as default
};

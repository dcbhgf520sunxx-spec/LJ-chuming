import { inject as I } from "vue";
import { provide as k } from "vue";
import { ref as V } from "vue";
import { reactive as E } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as n } from "vue";
import { withCtx as u } from "vue";
import { unref as f } from "vue";
import { withDirectives as z } from "vue";
import { createTextVNode as c } from "vue";
import { mergeProps as B } from "vue";
import { ElInput as $ } from "element-plus";
import { B as T, cT as U, i as h, E as q } from "../../../../../shared/runtime.js";
import H from "./config.vue.js";
import "../../../../../modules/use-table-change-32e98420.js";
import "./config-preview.vue.js";
import "../../../../../modules/index-61ce89a1.js";
const J = { class: "head-container" }, W = { __name: "header", setup(A) {
  const v = I("permission"), w = { nameOrCode: void 0 }, { CRUD: O, query: b } = T(w), C = /* @__PURE__ */ new Map([["rdRate", "sourceRdRate"]]);
  k("sourceMap", C);
  const m = V(/* @__PURE__ */ new Map()), r = E({ level: 3, isEdit: false, visible: false });
  O.HOOK.handleRefresh = (t, e) => {
    m.value = /* @__PURE__ */ new Map(), e.data.content = N(e.data.content);
  };
  function p(t) {
    r.level = t, r.visible = true;
  }
  function N(t, e = 1, s = { fullId: [], fullName: [], fullCode: [], fullSerialNumber: [] }) {
    const a = [], d = new Array(t.length);
    let l = m.value.get(e);
    return l || (l = [], m.value.set(e, l)), t.forEach((i, M) => {
      i.fullId = [...s.fullId, i.id], i.fullName = [...s.fullName, i.name], i.fullCode = [...s.fullCode, i.code], i.fullSerialNumber = [...s.fullSerialNumber, s.fullCode.join("") + i.code], d[M] = U(i, C);
      const o = {};
      Object.assign(o, JSON.parse(JSON.stringify(s)), i);
      const y = o.children;
      if (h(y)) {
        const R = { fullId: o.fullId, fullName: o.fullName, fullCode: o.fullCode, fullSerialNumber: o.fullSerialNumber, rdRate: o.rdRate }, S = N(y, e + 1, R);
        a.push.apply(a, S);
      } else a.push(o);
      delete i.children;
    }), l.push.apply(l, t), a;
  }
  return (t, e) => {
    const s = $, a = L("common-button"), d = j("permission");
    return g(), _("div", J, [n(f(q), null, { optLeft: u(() => [n(s, { modelValue: f(b).nameOrCode, "onUpdate:modelValue": e[0] || (e[0] = (l) => f(b).nameOrCode = l), modelModifiers: { trim: true }, placeholder: "输入科目名称、编号搜索", class: "filter-item", style: { width: "250px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), viewLeft: u(() => [z((g(), _("span", null, [n(a, { class: "filter-item", type: "primary", size: "default", onClick: e[1] || (e[1] = (l) => p(1)) }, { default: u(() => e[5] || (e[5] = [c("一级科目设置")])), _: 1, __: [5] }), n(a, { class: "filter-item", type: "primary", size: "default", onClick: e[2] || (e[2] = (l) => p(2)) }, { default: u(() => e[6] || (e[6] = [c("二级科目设置")])), _: 1, __: [6] }), n(a, { class: "filter-item", type: "primary", size: "default", onClick: e[3] || (e[3] = (l) => p(3)) }, { default: u(() => e[7] || (e[7] = [c("三级科目设置")])), _: 1, __: [7] })])), [[d, f(v).get]])]), _: 1 }), n(H, B(t.$attrs, { visible: r.visible, "onUpdate:visible": e[4] || (e[4] = (l) => r.visible = l), level: r.level, permission: f(v), classificationList: m.value.get(r.level) }), null, 16, ["visible", "level", "permission", "classificationList"])]);
  };
} };
export {
  W as default
};

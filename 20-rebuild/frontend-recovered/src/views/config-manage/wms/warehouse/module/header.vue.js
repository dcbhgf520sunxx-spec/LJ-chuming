import { ref as I } from "vue";
import { watch as E } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as k } from "vue";
import { unref as o } from "vue";
import { createBlock as f } from "vue";
import { withCtx as u } from "vue";
import { Fragment as N } from "vue";
import { renderList as T } from "vue";
import { createTextVNode as b } from "vue";
import { createVNode as i } from "vue";
import { ElTabPane as q } from "element-plus";
import { ElTabs as C } from "element-plus";
import { ElTag as O } from "element-plus";
import { B as x, hW as B, i as c, hV as p, aS as L, E as Q } from "../../../../../shared/runtime.js";
import R from "./workshop-list.vue.js";
import "./workshop-form.vue.js";
const S = { class: "head-container" }, z = { __name: "header", setup(U) {
  const y = { workshopId: void 0, enabled: void 0 }, { crud: a, query: l } = x(y), m = I(false), { workshopName: t } = B();
  E(() => t.value, (s) => {
    var e, d;
    s && s.length && (a.query.workshopId = a.query.workshopId || (e = t.value[0]) != null && e.id ? (a.query.workshopId || ((d = t.value[0]) == null ? void 0 : d.id)) + "" : void 0, a.query.warehouseType = c(t.value[0]) ? t.value[0].workshopId ? p.WORKSHOP.V : p.NORMAL.V : void 0, a.toQuery());
  }, { immediate: true, deep: true });
  function w() {
    const s = t.value.find((e) => e.id === Number(a.query.workshopId)) || {};
    a.query.warehouseType = c(s) ? s.workshopId ? p.WORKSHOP.V : p.NORMAL.V : void 0, a.toQuery();
  }
  return (s, e) => {
    const d = q, V = C, h = O, v = _("common-button"), g = _("common-radio-button");
    return r(), k("div", S, [o(c)(o(t)) ? (r(), f(V, { key: 0, modelValue: o(l).workshopId, "onUpdate:modelValue": e[0] || (e[0] = (n) => o(l).workshopId = n), "tab-position": "top", onTabClick: w }, { default: u(() => [(r(true), k(N, null, T(o(t), (n) => (r(), f(d, { key: n.id, label: n.name, name: `${n.id}` }, null, 8, ["label", "name"]))), 128))]), _: 1 }, 8, ["modelValue"])) : (r(), f(h, { key: 1, type: "danger", style: { margin: "15px 0" } }, { default: u(() => e[4] || (e[4] = [b("* 请先添加仓库名称")])), _: 1, __: [4] })), i(Q, { disabled: !o(l).workshopId }, { optLeft: u(() => [i(v, { icon: "el-icon-plus", type: "success", class: "filter-item", size: "default", onClick: e[1] || (e[1] = (n) => m.value = true) }, { default: u(() => e[5] || (e[5] = [b("仓库名称")])), _: 1, __: [5] })]), viewLeft: u(() => [i(g, { modelValue: o(l).enabled, "onUpdate:modelValue": e[2] || (e[2] = (n) => o(l).enabled = n), options: o(L).ENUM, "show-option-all": "", type: "enum", size: "default", onChange: o(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), _: 1 }, 8, ["disabled"]), i(o(R), { modelValue: m.value, "onUpdate:modelValue": e[3] || (e[3] = (n) => m.value = n) }, null, 8, ["modelValue"])]);
  };
} };
export {
  z as default
};

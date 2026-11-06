import { ref as _ } from "vue";
import { inject as k } from "vue";
import { watch as v } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as E } from "vue";
import { vShow as Q } from "vue";
import { unref as e } from "vue";
import { createElementVNode as N } from "vue";
import { renderSlot as i } from "vue";
import { createVNode as a } from "vue";
import { withKeys as c } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as f } from "vue";
import { withModifiers as y } from "vue";
import { Fragment as S } from "vue";
import { ElInput as T } from "element-plus";
import { m as K, B as L, E as B, rG as P } from "../../../../../shared/runtime.js";
const q = { __name: "header", setup(U, { expose: g }) {
  const h = { taskTypeEnum: void 0, serialNumber: void 0, specification: void 0 }, u = _([]);
  K(["user"]);
  const { crud: o, query: t } = L(h);
  k("process");
  function w() {
    t.serialNumber = void 0, t.steelPlateTypeEnum = void 0, t.specification = void 0, o.toQuery();
  }
  async function V() {
    const l = await P(o.getQueryParams());
    u.value = l;
  }
  return v(() => t.taskOrderIds, () => {
    V();
  }), g({}), (l, s) => {
    const b = d("common-select"), p = T, m = d("common-button");
    return C(), x(S, null, [E(N("div", null, [i(l.$slots, "searchRight"), a(b, { modelValue: e(t).taskTypeEnum, "onUpdate:modelValue": s[0] || (s[0] = (n) => e(t).taskTypeEnum = n), options: u.value, placeholder: "全部类型", class: "filter-item", style: { "margin-top": "10px" }, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, multiple: "", clearable: "", "collapse-tags": "", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(p, { modelValue: e(t).serialNumber, "onUpdate:modelValue": s[1] || (s[1] = (n) => e(t).serialNumber = n), placeholder: "输入编号搜索", style: { "margin-top": "10px", width: "220px" }, class: "filter-item", clearable: "", onKeyup: c(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(p, { modelValue: e(t).specification, "onUpdate:modelValue": s[2] || (s[2] = (n) => e(t).specification = n), placeholder: "输入规格搜索", style: { "margin-top": "10px", width: "220px" }, class: "filter-item", clearable: "", onKeyup: c(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(m, { class: "filter-item", style: { "margin-top": "10px" }, type: "success", icon: "el-icon-search", onClick: y(e(o).toQuery, ["stop"]) }, { default: r(() => s[3] || (s[3] = [f(" 搜索 ")])), _: 1, __: [3] }, 8, ["onClick"]), a(m, { class: "filter-item", style: { "margin-top": "10px" }, type: "warning", icon: "el-icon-refresh-left", onClick: y(w, ["stop"]) }, { default: r(() => s[4] || (s[4] = [f(" 重置 ")])), _: 1, __: [4] })], 512), [[Q, e(o).searchToggle]]), a(e(B), { "show-grid": false, "show-refresh": false, showSearch: false, style: { padding: "0" } }, { optLeft: r(() => [i(l.$slots, "optLeft")]), viewLeft: r(() => [i(l.$slots, "viewLeft")]), _: 3 })], 64);
  };
} };
export {
  q as default
};

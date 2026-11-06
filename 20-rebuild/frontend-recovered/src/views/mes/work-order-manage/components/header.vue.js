import { ref as C } from "vue";
import { resolveComponent as r } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as I } from "vue";
import { withDirectives as N } from "vue";
import { vShow as v } from "vue";
import { unref as e } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as l } from "vue";
import { withCtx as u } from "vue";
import { withKeys as p } from "vue";
import { withModifiers as f } from "vue";
import { createTextVNode as y } from "vue";
import { ElInput as Q } from "element-plus";
import { g as T } from "../../../../modules/machine-part-85f162b2.js";
import { B as k, g8 as x, cm as E, aV as M, E as K, qw as U, cf as z } from "../../../../shared/runtime.js";
const B = { class: "head-container" }, L = { style: { display: "flex" } }, S = { __name: "header", setup(q) {
  const g = { factoryId: void 0, workshopId: void 0, printType: void 0, cutNumber: void 0, cutConfigId: void 0, serialNumber: void 0, deviceTypeId: void 0 }, { crud: a, query: o } = k(g);
  x(["device_type"]);
  const s = C([]);
  (async () => {
    try {
      const d = await T({ partProdMode: null, productCategoryType: U.BOARD.V, type: z.MAKINGS.V });
      s.value = d.map((t) => ({ name: t.name, id: t.id }));
    } catch (d) {
      console.log(d);
    }
  })();
  function h() {
    a.toQuery();
  }
  function V() {
    o.factoryId = void 0, o.workshopId = void 0, o.printType = void 0, o.cutNumber = void 0, o.cutConfigId = void 0, o.serialNumber = void 0, a.toQuery();
  }
  return (d, t) => {
    const _ = r("common-radio-button"), b = r("common-select"), i = Q, m = r("common-button");
    return w(), I("div", B, [N(c("div", null, [c("div", L, [l(_, { modelValue: e(o).printType, "onUpdate:modelValue": t[0] || (t[0] = (n) => e(o).printType = n), options: e(E).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(b, { modelValue: e(o).cutConfigId, "onUpdate:modelValue": t[1] || (t[1] = (n) => e(o).cutConfigId = n), options: s.value, "data-structure": { key: "id", label: "name", value: "id" }, placeholder: "选择切割方式", clearable: "", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), l(e(K), null, { optLeft: u(() => [l(e(M), { modelValue: e(o).workshopId, "onUpdate:modelValue": t[2] || (t[2] = (n) => e(o).workshopId = n), placeholder: "请选择车间", "factory-id": e(o).factoryId, style: { width: "200px" }, class: "filter-item", defaultValue: "", onChange: e(a).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"]), l(i, { modelValue: e(o).cutNumber, "onUpdate:modelValue": t[3] || (t[3] = (n) => e(o).cutNumber = n), placeholder: "指令号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: p(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(i, { modelValue: e(o).serialNumber, "onUpdate:modelValue": t[4] || (t[4] = (n) => e(o).serialNumber = n), modelModifiers: { trim: true }, placeholder: "输入编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: p(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(m, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: f(h, ["stop"]) }, { default: u(() => t[5] || (t[5] = [y("搜索")])), _: 1, __: [5] }), l(m, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: f(V, ["stop"]) }, { default: u(() => t[6] || (t[6] = [y(" 重置 ")])), _: 1, __: [6] })]), _: 1 })], 512), [[v, e(a).searchToggle]])]);
  };
} };
export {
  S as default
};

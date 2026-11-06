import { ref as i } from "vue";
import { inject as u } from "vue";
import { watch as N } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as o } from "vue";
import { withCtx as m } from "vue";
import { Fragment as w } from "vue";
import { renderList as I } from "vue";
import { createBlock as C } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as D } from "vue";
import { unref as t } from "vue";
import { ElDescriptionsItem as E } from "element-plus";
import { ElDescriptions as j } from "element-plus";
import { ElInput as L } from "element-plus";
import { _ as S, B as q, C as F } from "../../../../../../../../shared/runtime.js";
const H = { class: "" }, O = { class: "info", style: { "margin-bottom": "10px" } }, Q = { class: "query-container" }, R = { style: { display: "flex", gap: "6px" } }, U = { __name: "header", setup(z) {
  var d;
  const c = i([{ key: "projectName", label: "项目", value: "" }, { key: "monomerName", label: "单体", value: "" }, { key: "areaName", label: "区域", value: "" }]), p = u("enclosureDictList"), l = u("currentRow"), v = i({ key: "id", label: "label", value: "id" }), y = { inventoryId: { value: (d = l.value) == null ? void 0 : d.id, resetAble: false }, serialNumber: void 0, dictionaryId: void 0 }, { query: s, crud: f } = q(y);
  return N(() => l.value, (b) => {
    c.value.map((e) => {
      Object.hasOwn(l.value, e.key) && (e.value = l.value[e.key]);
    });
  }, { deep: true, immediate: true }), (b, e) => {
    const h = E, k = j, x = V("common-select-v2"), g = L;
    return n(), _("div", H, [r("div", O, [o(k, { column: 3, border: "" }, { default: m(() => [(n(true), _(w, null, I(c.value, (a) => (n(), C(h, { key: a.key, label: a.label, "label-width": "140px" }, { default: m(() => [B(D(a.value), 1)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 })]), r("div", Q, [o(x, { modelValue: t(s).dictionaryId, "onUpdate:modelValue": e[0] || (e[0] = (a) => t(s).dictionaryId = a), "data-structure": v.value, options: t(p), class: "filter-item", clearable: "", filterable: "", placeholder: "请选择类型", size: "default", type: "other", onChange: t(f).toQuery }, null, 8, ["modelValue", "data-structure", "options", "onChange"]), r("div", R, [o(g, { modelValue: t(s).serialNumber, "onUpdate:modelValue": e[1] || (e[1] = (a) => t(s).serialNumber = a), class: "filter-item", clearable: "", placeholder: "编号搜索", style: { width: "160px" } }, null, 8, ["modelValue"]), o(F)])])]);
  };
} }, $ = S(U, [["__scopeId", "data-v-7a651186"]]);
export {
  $ as default
};

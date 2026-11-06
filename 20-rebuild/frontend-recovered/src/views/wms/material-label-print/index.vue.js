import { provide as b } from "vue";
import { ref as v } from "vue";
import { computed as M } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as l } from "vue";
import { withCtx as s } from "vue";
import { unref as e } from "vue";
import { ElTabPane as u } from "element-plus";
import { createBlock as c } from "vue";
import { mergeProps as _ } from "vue";
import { createCommentVNode as m } from "vue";
import { ElTabs as g } from "element-plus";
import { createElementVNode as y } from "vue";
import { toDisplayString as $ } from "vue";
import { ElTag as k } from "element-plus";
import { _ as V, z2 as N } from "../../../shared/runtime.js";
import { u as h } from "../../../modules/use-get-not-printed-material-4179d261.js";
import x from "./material-mode/index.vue.js";
import E from "./receipt-mode/index.vue.js";
import "./material-mode/module/header.vue.js";
import "../../../modules/use-print-d47bc68b.js";
import "../../../modules/wms-material-label-cf4447ff.js";
import "../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../modules/material-print-button-3ec7d08d.js";
import "../../../modules/popover-confirm-35927771.js";
import "../../../modules/receipt-mode-c54e9044.js";
import "./receipt-mode/module/detail.vue.js";
import "./receipt-mode/module/header.vue.js";
const S = { class: "material-label-print" }, B = { style: { "font-weight": "bold" } }, C = { __name: "index", setup(w) {
  b("permission", N);
  const t = v("receiptMode"), { notPrintedMaterialNumber: f, refresh: d } = h(), p = M(() => {
    const { inboundMaterial: a = 0, outboundMaterial: r = 0, transferMaterial: n = 0, returnMaterial: i = 0 } = f.value || {};
    return `未打印物料数量　　入库：${a}　　半出：${r}　　调拨：${n}　　退库：${i}`;
  });
  return (a, r) => {
    const n = k;
    return o(), P("div", S, [l(e(g), { modelValue: t.value, "onUpdate:modelValue": r[0] || (r[0] = (i) => t.value = i), class: "print-list-tab" }, { default: s(() => [l(e(u), { label: "单据模式", name: "receiptMode" }, { default: s(() => [t.value === "receiptMode" ? (o(), c(e(E), _({ key: 0 }, a.$attrs, { onPrintedSuccess: e(d) }), null, 16, ["onPrintedSuccess"])) : m("", true)]), _: 1 }), l(e(u), { label: "物料模式", name: "materialMode" }, { default: s(() => [t.value === "materialMode" ? (o(), c(e(x), _({ key: 0 }, a.$attrs, { onPrintedSuccess: e(d) }), null, 16, ["onPrintedSuccess"])) : m("", true)]), _: 1 })]), _: 1 }, 8, ["modelValue"]), p.value ? (o(), c(n, { key: 0, class: "not-printed-info", type: "danger", effect: "plain" }, { default: s(() => [y("span", B, $(p.value), 1)]), _: 1 })) : m("", true)]);
  };
} }, K = V(C, [["__scopeId", "data-v-29bacf16"]]);
export {
  K as default
};

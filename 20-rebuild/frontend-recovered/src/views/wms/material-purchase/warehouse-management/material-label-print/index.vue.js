import { useStore as M } from "vuex";
import { computed as d } from "vue";
import { watch as y } from "vue";
import { provide as v } from "vue";
import { ref as h } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as p } from "vue";
import { withCtx as l } from "vue";
import { unref as t } from "vue";
import { ElTabPane as P } from "element-plus";
import { createBlock as f } from "vue";
import { mergeProps as N } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElTabs as g } from "element-plus";
import { createElementVNode as w } from "vue";
import { toDisplayString as A } from "vue";
import { ElTag as $ } from "element-plus";
import { _ as S, Ay as V } from "../../../../../shared/runtime.js";
import k from "./material-mode/index.vue.js";
import x from "./receipt-mode/index.vue.js";
import "../../../../../modules/material-mode-V2-9ef0c850.js";
import "./material-mode/module/header.vue.js";
import "../../../../../modules/use-print-7c5ddea7.js";
import "../../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/material-print-button-3ec7d08d.js";
import "../../../../../modules/popover-confirm-35927771.js";
import "../../../../../modules/receipt-mode-V2-8c051f68.js";
import "./receipt-mode/module/detail.vue.js";
import "./receipt-mode/module/header.vue.js";
import "../../../../../modules/receipt-mode-c54e9044.js";
const E = (m, a = true) => {
  const e = M(), r = d(() => e.state.config.loaded.notPrintedMaterialNotBoolPartyANumber);
  if ((!r.value || a) && e.dispatch("wms/fetchNotPrintedMaterialNotBoolPartyANumber"), m) {
    const s = y(r, (o) => {
      o && setTimeout(() => {
        m(), s();
      }, 0);
    }, { immediate: true });
  }
  return { notPrintedMaterialNotBoolPartyANumber: d(() => e.state.wms.notPrintedMaterialNotBoolPartyANumber), loaded: d(() => e.state.wms.loaded.notPrintedMaterialNotBoolPartyANumber), refresh: () => {
    e.dispatch("wms/fetchNotPrintedMaterialNotBoolPartyANumber");
  } };
};
const T = { class: "material-label-print" }, C = { style: { "font-weight": "bold" } }, D = { __name: "index", setup(m) {
  v("permission", V);
  const a = h("receiptMode"), { notPrintedMaterialNotBoolPartyANumber: e, refresh: r } = E(), s = d(() => {
    const { inboundMaterial: o = 0, outboundMaterial: i = 0, transferMaterial: c = 0, returnMaterial: u = 0, surplusMaterial: b = 0 } = e.value || {};
    return `未打印物料数量　　入库：${o}　　半出：${i}　　调拨：${c}　　退库：${u}　　盘盈：${b}`;
  });
  return (o, i) => {
    const c = $;
    return n(), B("div", { ...T, style: { paddingTop: s.value ? "36px" : void 0 } }, [p(t(g), { modelValue: a.value, "onUpdate:modelValue": i[0] || (i[0] = (u) => a.value = u), class: "print-list-tab" }, { default: l(() => [p(t(P), { label: "单据模式", name: "receiptMode" }, { default: l(() => [a.value === "receiptMode" ? (n(), f(t(x), N({ key: 0 }, o.$attrs, { onPrintedSuccess: t(r) }), null, 16, ["onPrintedSuccess"])) : _("", true)]), _: 1 }), p(t(P), { label: "物料模式", name: "materialMode" }, { default: l(() => [a.value === "materialMode" ? (n(), f(t(k), N({ key: 0 }, o.$attrs, { onPrintedSuccess: t(r) }), null, 16, ["onPrintedSuccess"])) : _("", true)]), _: 1 })]), _: 1 }, 8, ["modelValue"]), s.value ? (n(), f(c, { key: 0, class: "not-printed-info", effect: "plain", type: "danger" }, { default: l(() => [w("span", C, A(s.value), 1)]), _: 1 })) : _("", true)], 4);
  };
} }, X = S(D, [["__scopeId", "data-v-ffc6edb9"]]);
export {
  X as default
};

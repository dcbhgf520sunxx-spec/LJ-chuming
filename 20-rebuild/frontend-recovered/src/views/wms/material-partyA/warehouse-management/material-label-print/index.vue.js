import { useStore as y } from "vuex";
import { computed as d } from "vue";
import { watch as v } from "vue";
import { provide as N } from "vue";
import { ref as h } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as p } from "vue";
import { withCtx as l } from "vue";
import { unref as t } from "vue";
import { ElTabPane as P } from "element-plus";
import { createBlock as _ } from "vue";
import { mergeProps as M } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTabs as g } from "element-plus";
import { createElementVNode as w } from "vue";
import { toDisplayString as A } from "vue";
import { ElTag as $ } from "element-plus";
import { _ as V, zX as k } from "../../../../../shared/runtime.js";
import S from "./material-mode/index.vue.js";
import x from "./receipt-mode/index.vue.js";
import "../../../../../modules/material-mode-V2-9ef0c850.js";
import "./material-mode/module/header.vue.js";
import "../../../../../modules/use-print-4d7e67fe.js";
import "../../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/material-print-button-3ec7d08d.js";
import "../../../../../modules/popover-confirm-35927771.js";
import "../../../../../modules/receipt-mode-V2-8c051f68.js";
import "./receipt-mode/module/detail.vue.js";
import "./receipt-mode/module/header.vue.js";
import "../../../../../modules/receipt-mode-c54e9044.js";
const E = (m, a = true) => {
  const e = y(), o = d(() => e.state.config.loaded.notPrintedMaterialBoolPartyANumber);
  if ((!o.value || a) && e.dispatch("wms/fetchNotPrintedMaterialBoolPartyANumber"), m) {
    const s = v(o, (r) => {
      r && setTimeout(() => {
        m(), s();
      }, 0);
    }, { immediate: true });
  }
  return { notPrintedMaterialBoolPartyANumber: d(() => e.state.wms.notPrintedMaterialBoolPartyANumber), loaded: d(() => e.state.wms.loaded.notPrintedMaterialBoolPartyANumber), refresh: () => {
    e.dispatch("wms/fetchNotPrintedMaterialBoolPartyANumber");
  } };
};
const T = { class: "material-label-print" }, C = { style: { "font-weight": "bold" } }, D = { __name: "index", setup(m) {
  N("permission", k);
  const a = h("receiptMode"), { notPrintedMaterialBoolPartyANumber: e, refresh: o } = E(), s = d(() => {
    const { inboundMaterial: r = 0, outboundMaterial: i = 0, transferMaterial: u = 0, returnMaterial: c = 0, surplusMaterial: b = 0 } = e.value || {};
    return `未打印物料数量　　入库：${r}　　半出：${i}　　调拨：${u}　　退库：${c}　　盘盈：${b}`;
  });
  return (r, i) => {
    const u = $;
    return n(), B("div", { ...T, style: { paddingTop: s.value ? "36px" : void 0 } }, [p(t(g), { modelValue: a.value, "onUpdate:modelValue": i[0] || (i[0] = (c) => a.value = c), class: "print-list-tab" }, { default: l(() => [p(t(P), { label: "单据模式", name: "receiptMode" }, { default: l(() => [a.value === "receiptMode" ? (n(), _(t(x), M({ key: 0 }, r.$attrs, { onPrintedSuccess: t(o) }), null, 16, ["onPrintedSuccess"])) : f("", true)]), _: 1 }), p(t(P), { label: "物料模式", name: "materialMode" }, { default: l(() => [a.value === "materialMode" ? (n(), _(t(S), M({ key: 0 }, r.$attrs, { onPrintedSuccess: t(o) }), null, 16, ["onPrintedSuccess"])) : f("", true)]), _: 1 })]), _: 1 }, 8, ["modelValue"]), s.value ? (n(), _(u, { key: 0, class: "not-printed-info", effect: "plain", type: "danger" }, { default: l(() => [w("span", C, A(s.value), 1)]), _: 1 })) : f("", true)], 4);
  };
} }, W = V(D, [["__scopeId", "data-v-517a7e00"]]);
export {
  W as default
};

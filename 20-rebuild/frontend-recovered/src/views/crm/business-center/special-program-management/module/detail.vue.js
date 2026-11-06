import { ref as m } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as r } from "vue";
import { createBlock as E } from "vue";
import { withCtx as e } from "vue";
import { createVNode as a } from "vue";
import { createElementBlock as c } from "vue";
import { Fragment as d } from "vue";
import { renderList as k } from "vue";
import { createElementVNode as o } from "vue";
import { toDisplayString as s } from "vue";
import { unref as n } from "vue";
import { ElFormItem as V } from "element-plus";
import { ElDivider as w } from "element-plus";
import { ElForm as C } from "element-plus";
import { u as D, dH as S, p as F } from "../../../../../shared/runtime.js";
const L = { __name: "detail", props: { modelValue: { type: Boolean, default: void 0 }, currentRow: { type: Object, default: () => {
} }, detailData: { type: Array, default: () => [] } }, emits: ["update:modelValue"], setup(i, { emit: u }) {
  const p = m(), f = m({ id: void 0 }), _ = i, b = u, { visible: h, handleClose: y } = D({ emit: b, props: _ });
  return (N, R) => {
    const t = V, v = w, g = C, x = B("common-dialog");
    return r(), E(x, { visible: n(h), "close-on-click-modal": false, "before-close": n(y), title: "提报记录", width: "600px", top: "15vh" }, { default: e(() => [a(g, { ref_key: "formRef", ref: p, model: f.value, "label-width": "130px", "label-position": "right", style: { "max-height": "600px", "overflow-y": "auto" } }, { default: e(() => [(r(true), c(d, null, k(i.detailData, (l) => (r(), c(d, { key: l }, [a(t, { label: "类型：" }, { default: e(() => [o("span", null, s(n(S).VL[l.crmSpecialBubmissionStatusEnum] || "-"), 1)]), _: 2 }, 1024), a(t, { label: "提报人：" }, { default: e(() => [o("span", null, s(l.reportUserName || "-"), 1)]), _: 2 }, 1024), a(t, { label: "提报时间：" }, { default: e(() => [o("span", null, s(n(F)(l.reportingTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 2 }, 1024), a(t, { label: "业务要点：" }, { default: e(() => [o("span", null, s(l.businessEssentials || "-"), 1)]), _: 2 }, 1024), a(v)], 64))), 128))]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} };
export {
  L as default
};

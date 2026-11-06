import { ref as v } from "vue";
import { inject as w } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as s } from "vue";
import { createBlock as f } from "vue";
import { withCtx as l } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { createTextVNode as U } from "vue";
import { createElementBlock as _ } from "vue";
import { Fragment as b } from "vue";
import { renderList as g } from "vue";
import { ElOption as L } from "element-plus";
import { ElSelect as q } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElInputNumber as F } from "element-plus";
import { ElForm as R } from "element-plus";
import { ao as S, qe as i } from "../../../../../shared/runtime.js";
const A = { __name: "form", setup(B) {
  const m = v(), y = { typeName: void 0, unit: void 0, price: void 0 }, { crud: r, form: n } = S(y, m), V = w("typeSelectList"), x = [i.PIECE.L, i.SET.L, i.GRAIN.L], E = { typeName: [{ required: true, message: "请选择类型名称", trigger: "change" }], unit: [{ required: true, message: "请选择单位", trigger: "change" }], price: [{ required: true, message: "请输入单价", trigger: "change" }] };
  return (I, a) => {
    const k = c("common-button"), d = L, p = q, u = z, N = F, h = R, C = c("common-dialog");
    return s(), f(C, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(r).cancelCU, visible: t(r).status.cu > 0, title: t(r).status.title, width: "550px" }, { titleRight: l(() => [o(k, { loading: t(r).status.cu === 2, type: "primary", size: "default", onClick: t(r).submitCU }, { default: l(() => a[3] || (a[3] = [U("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: l(() => [o(h, { ref_key: "formRef", ref: m, model: t(n), rules: E, size: "default", "label-width": "170px" }, { default: l(() => [o(u, { label: "类型：", prop: "typeName" }, { default: l(() => [o(p, { modelValue: t(n).typeName, "onUpdate:modelValue": a[0] || (a[0] = (e) => t(n).typeName = e), clearable: "", size: "default", placeholder: "请选择类型", style: { width: "270px" } }, { default: l(() => [(s(true), _(b, null, g(t(V), (e) => (s(), f(d, { key: e, label: e, value: e }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), o(u, { label: "单位：", prop: "unit" }, { default: l(() => [o(p, { modelValue: t(n).unit, "onUpdate:modelValue": a[1] || (a[1] = (e) => t(n).unit = e), clearable: "", size: "default", placeholder: "请选择单位", style: { width: "270px" } }, { default: l(() => [(s(), _(b, null, g(x, (e) => o(d, { key: e, label: e, value: e }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), o(u, { label: "定额单价（元）：", prop: "price" }, { default: l(() => [o(N, { modelValue: t(n).price, "onUpdate:modelValue": a[2] || (a[2] = (e) => t(n).price = e), placeholder: "定额单价", min: 0, max: 999999999999, step: 10, precision: 2, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  A as default
};

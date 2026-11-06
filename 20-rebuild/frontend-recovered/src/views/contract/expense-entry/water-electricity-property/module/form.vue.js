import { ref as q } from "vue";
import { computed as g } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as i } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as T } from "vue";
import { withDirectives as A } from "vue";
import { createCommentVNode as m } from "vue";
import { createElementBlock as k } from "vue";
import { ElFormItem as B } from "element-plus";
import { ElDatePicker as M } from "element-plus";
import { ElInputNumber as W } from "element-plus";
import { ElInput as j } from "element-plus";
import { ElForm as $ } from "element-plus";
import { m as G, t as Q, ao as Y, jf as r, b as H } from "../../../../../shared/runtime.js";
const J = { style: { float: "right" } }, K = { class: "form" }, X = { key: 0, class: "hint" }, Z = { key: 1 }, oe = { __name: "form", props: { query: { type: Object }, branchList: { type: Array, default: () => [] } }, setup(x) {
  const { user: v } = G("user"), { decimalPrecision: _ } = Q(), C = q(), R = g(() => d.status.edit >= 1), w = { id: void 0, month: void 0, usedMete: void 0, totalAmount: void 0 }, { crud: d, form: t, CRUD: S } = Y(w, C), h = g(() => t.consumption && t.totalFee ? (t.totalFee / t.consumption).toFixed(2) : ""), b = (O, o, p) => {
    o || p(new Error("填写数据必须大于0")), p();
  }, F = { type: [{ required: true, message: "请选择类型", trigger: "change" }], yearMonthDate: [{ required: true, message: "请选择月份", trigger: "change" }], branchCompanyId: [{ required: true, message: "请选择费用归属", trigger: "change" }], consumption: [{ required: true, validator: b, trigger: "blur" }], totalFee: [{ required: true, validator: b, trigger: "blur" }] };
  function I() {
    t.consumption = void 0, t.totalFee = void 0, t.remark = void 0;
  }
  return (O, o) => {
    const p = f("common-button"), V = f("common-select-v2"), s = B, U = M, c = W, D = j, L = $, N = f("common-dialog"), P = z("show-thousand");
    return i(), u(N, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(d).cancelCU, visible: e(d).status.cu > 0, title: "新增", "show-close": false, width: "500px", top: "10vh" }, { titleRight: a(() => [y("span", J, [n(p, { loading: e(d).status.cu === e(S).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(d).submitCU }, { default: a(() => o[7] || (o[7] = [E(" 提 交 ")])), _: 1, __: [7] }, 8, ["loading", "onClick"]), n(p, { size: "default", onClick: e(d).cancelCU }, { default: a(() => o[8] || (o[8] = [E("关 闭")])), _: 1, __: [8] }, 8, ["onClick"])])]), default: a(() => [y("div", K, [n(L, { ref_key: "formRef", ref: C, model: e(t), rules: F, size: "default", "label-width": "140px", class: "demo-form" }, { default: a(() => [n(s, { label: "类型：", prop: "type" }, { default: a(() => [n(V, { modelValue: e(t).type, "onUpdate:modelValue": o[0] || (o[0] = (l) => e(t).type = l), options: e(r).ENUM, type: "enum", placeholder: "请选择类型", class: "filter-item", clearable: "", style: { width: "270px" }, onChange: I }, null, 8, ["modelValue", "options"])]), _: 1 }), n(s, { label: "月份：", prop: "yearMonthDate" }, { default: a(() => [n(U, { modelValue: e(t).yearMonthDate, "onUpdate:modelValue": o[1] || (o[1] = (l) => e(t).yearMonthDate = l), type: "month", size: "default", class: "filter-item", placeholder: "选择月", clearable: "", "value-format": "x", style: { width: "270px" }, onChange: e(d).toQuery }, null, 8, ["modelValue", "onChange"])]), _: 1 }), n(s, { label: "费用归属：", prop: "branchCompanyId" }, { default: a(() => [n(V, { modelValue: e(t).branchCompanyId, "onUpdate:modelValue": o[2] || (o[2] = (l) => e(t).branchCompanyId = l), options: x.branchList, "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", placeholder: "选择主体", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), n(s, { label: "录入人：", prop: "name" }, { default: a(() => {
      var l;
      return [y("span", null, T(R.value ? (l = e(t)) == null ? void 0 : l.userName : e(v).name), 1)];
    }), _: 1 }), e(t).type === e(r).ELECTRIC_COST.V || e(t).type === e(r).WATER_COST.V ? (i(), u(s, { key: 0, label: `用${e(t).type === e(r).ELECTRIC_COST.V ? "电" : "水"}量：`, prop: "consumption" }, { default: a(() => [A(n(c, { modelValue: e(t).consumption, "onUpdate:modelValue": o[3] || (o[3] = (l) => e(t).consumption = l), style: { width: "270px" }, placeholder: `${e(t).type === e(r).ELECTRIC_COST.V ? "输入用电量，单位：kw/h" : "输入用电量，单位：吨"}`, "controls-position": "right", min: 0, max: 9999999999 }, null, 8, ["modelValue", "placeholder"]), [[P]])]), _: 1 }, 8, ["label"])) : m("", true), e(t).type === e(r).ELECTRIC_COST.V || e(t).type === e(r).WATER_COST.V ? (i(), u(s, { key: 1, label: `${e(t).type === e(r).ELECTRIC_COST.V ? "电" : "水"}费总额（元）：`, prop: "totalFee" }, { default: a(() => [n(c, { modelValue: e(t).totalFee, "onUpdate:modelValue": o[4] || (o[4] = (l) => e(t).totalFee = l), style: { width: "270px" }, placeholder: "输入金额，单位：元", "controls-position": "right", precision: e(_).contract, min: 0, max: 9999999999 }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"])) : m("", true), e(t).type === e(r).PROPERTY_COST.V ? (i(), u(s, { key: 2, label: "物业费（元）：", prop: "totalFee" }, { default: a(() => [n(c, { modelValue: e(t).totalFee, "onUpdate:modelValue": o[5] || (o[5] = (l) => e(t).totalFee = l), style: { width: "270px" }, placeholder: "输入物业费", "controls-position": "right", precision: e(_).contract, min: 0, max: 9999999999 }, null, 8, ["modelValue", "precision"])]), _: 1 })) : m("", true), e(t).type === e(r).ELECTRIC_COST.V || e(t).type === e(r).WATER_COST.V ? (i(), u(s, { key: 3, label: "平均单价：", prop: "averageUnitPrice" }, { default: a(() => [e(H)(h.value) ? (i(), k("span", X, "根据上方填写内容自动计算")) : (i(), k("span", Z, T(h.value) + " 元", 1))]), _: 1 })) : m("", true), e(t).type === e(r).ELECTRIC_COST.V || e(t).type === e(r).WATER_COST.V ? (i(), u(s, { key: 4, label: "备注：", prop: "remark" }, { default: a(() => [n(D, { modelValue: e(t).remark, "onUpdate:modelValue": o[6] || (o[6] = (l) => e(t).remark = l), type: "textarea", maxlength: "500", "show-word-limit": "", autosize: { minRows: 3, maxRows: 3 }, style: { width: "270px" }, placeholder: "输入备注：" }, null, 8, ["modelValue"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} };
export {
  oe as default
};
